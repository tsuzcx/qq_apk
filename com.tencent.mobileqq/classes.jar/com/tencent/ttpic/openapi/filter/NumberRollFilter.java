package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.tencent.aekit.openrender.UniformParam.Float4fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.model.NumberRollEffectParams;
import com.tencent.ttpic.openapi.model.NumberRollItem;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class NumberRollFilter
  extends VideoFilterBase
{
  private static final String fragmentShaderString = "#define ABC 1\nprecision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D numberTexture;\nuniform int boxCount;\nuniform vec4 box1;\nuniform float currentY1;\nuniform vec4 box2;\nuniform float currentY2;\nuniform vec4 box3;\nuniform float currentY3;\nvoid main()\n{\n    if (boxCount > 0 && textureCoordinate.x > box1.x && textureCoordinate.x < box1.z && textureCoordinate.y > box1.y && textureCoordinate.y < box1.w) {\n        float width = box1.z - box1.x;\n        float height = box1.w - box1.y;\n        float numberTextureCoordinateX = (textureCoordinate.x - box1.x) / width;\n        float numberTextureCoordinateY = 0.1 * (textureCoordinate.y - box1.y) / height + currentY1;\n        if (numberTextureCoordinateY > 1.0) {\n            numberTextureCoordinateY -= 1.0;\n        }\n        vec2 numberTextureCoordinate = vec2(numberTextureCoordinateX, numberTextureCoordinateY);\n        gl_FragColor = texture2D(numberTexture, numberTextureCoordinate);\n    } else if (boxCount > 1 && textureCoordinate.x > box2.x && textureCoordinate.x < box2.z && textureCoordinate.y > box2.y && textureCoordinate.y < box2.w) {\n        float width = box2.z - box2.x;\n        float height = box2.w - box2.y;\n        float numberTextureCoordinateX = (textureCoordinate.x - box2.x) / width;\n        float numberTextureCoordinateY = 0.1 * (textureCoordinate.y - box2.y) / height + currentY2;\n        if (numberTextureCoordinateY > 1.0) {\n            numberTextureCoordinateY -= 1.0;\n        }\n        vec2 numberTextureCoordinate = vec2(numberTextureCoordinateX, numberTextureCoordinateY);\n        gl_FragColor = texture2D(numberTexture, numberTextureCoordinate);\n    } else if (boxCount > 2 && textureCoordinate.x > box3.x && textureCoordinate.x < box3.z && textureCoordinate.y > box3.y && textureCoordinate.y < box3.w) {\n        float width = box3.z - box3.x;\n        float height = box3.w - box3.y;\n        float numberTextureCoordinateX = (textureCoordinate.x - box3.x) / width;\n        float numberTextureCoordinateY = 0.1 * (textureCoordinate.y - box3.y) / height + currentY3;\n        if (numberTextureCoordinateY > 1.0) {\n            numberTextureCoordinateY -= 1.0;\n        }\n        vec2 numberTextureCoordinate = vec2(numberTextureCoordinateX, numberTextureCoordinateY);\n        gl_FragColor = texture2D(numberTexture, numberTextureCoordinate);\n    } else {\n        gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n    }\n}\n";
  private static final String vertexShaderString = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}\n";
  private AIAttr aiAttr;
  private VideoFilterBase copyFilter = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private long currentTime = 0L;
  private PTFaceAttr faceAttr;
  private float firstNumberStopTime = 0.0F;
  private boolean hasSetNumber = false;
  private boolean isNeedReset = true;
  private float materialImageWidthHeightRatio = 0.0F;
  private int numberImageTextureID = 0;
  private NumberRollEffectParams numberRollEffectParams;
  private int scoreCount = 0;
  private float scoreSum = 0.0F;
  private long startTime = 0L;
  
  public NumberRollFilter(NumberRollEffectParams paramNumberRollEffectParams)
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}\n", "#define ABC 1\nprecision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D numberTexture;\nuniform int boxCount;\nuniform vec4 box1;\nuniform float currentY1;\nuniform vec4 box2;\nuniform float currentY2;\nuniform vec4 box3;\nuniform float currentY3;\nvoid main()\n{\n    if (boxCount > 0 && textureCoordinate.x > box1.x && textureCoordinate.x < box1.z && textureCoordinate.y > box1.y && textureCoordinate.y < box1.w) {\n        float width = box1.z - box1.x;\n        float height = box1.w - box1.y;\n        float numberTextureCoordinateX = (textureCoordinate.x - box1.x) / width;\n        float numberTextureCoordinateY = 0.1 * (textureCoordinate.y - box1.y) / height + currentY1;\n        if (numberTextureCoordinateY > 1.0) {\n            numberTextureCoordinateY -= 1.0;\n        }\n        vec2 numberTextureCoordinate = vec2(numberTextureCoordinateX, numberTextureCoordinateY);\n        gl_FragColor = texture2D(numberTexture, numberTextureCoordinate);\n    } else if (boxCount > 1 && textureCoordinate.x > box2.x && textureCoordinate.x < box2.z && textureCoordinate.y > box2.y && textureCoordinate.y < box2.w) {\n        float width = box2.z - box2.x;\n        float height = box2.w - box2.y;\n        float numberTextureCoordinateX = (textureCoordinate.x - box2.x) / width;\n        float numberTextureCoordinateY = 0.1 * (textureCoordinate.y - box2.y) / height + currentY2;\n        if (numberTextureCoordinateY > 1.0) {\n            numberTextureCoordinateY -= 1.0;\n        }\n        vec2 numberTextureCoordinate = vec2(numberTextureCoordinateX, numberTextureCoordinateY);\n        gl_FragColor = texture2D(numberTexture, numberTextureCoordinate);\n    } else if (boxCount > 2 && textureCoordinate.x > box3.x && textureCoordinate.x < box3.z && textureCoordinate.y > box3.y && textureCoordinate.y < box3.w) {\n        float width = box3.z - box3.x;\n        float height = box3.w - box3.y;\n        float numberTextureCoordinateX = (textureCoordinate.x - box3.x) / width;\n        float numberTextureCoordinateY = 0.1 * (textureCoordinate.y - box3.y) / height + currentY3;\n        if (numberTextureCoordinateY > 1.0) {\n            numberTextureCoordinateY -= 1.0;\n        }\n        vec2 numberTextureCoordinate = vec2(numberTextureCoordinateX, numberTextureCoordinateY);\n        gl_FragColor = texture2D(numberTexture, numberTextureCoordinate);\n    } else {\n        gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n    }\n}\n");
    this.numberRollEffectParams = paramNumberRollEffectParams;
    this.firstNumberStopTime = getFirstNumberStopTime(paramNumberRollEffectParams);
    initParams();
  }
  
  private static int createProgram(String paramString1, String paramString2)
  {
    int i = 0;
    int k = loadShader(35633, paramString1);
    if (k == 0) {
      return 0;
    }
    int m = loadShader(35632, paramString2);
    if (m == 0)
    {
      GLES20.glDeleteShader(k);
      return 0;
    }
    int j = GLES20.glCreateProgram();
    if (j == 0)
    {
      GLES20.glDeleteShader(k);
      GLES20.glDeleteShader(m);
      return 0;
    }
    GLES20.glAttachShader(j, k);
    GLES20.glAttachShader(j, m);
    GLES20.glLinkProgram(j);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(j, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      Log.e("createProgram", "Error: Could not link program: ");
      Log.e("createProgram", GLES20.glGetProgramInfoLog(j));
      GLES20.glDeleteProgram(j);
    }
    for (;;)
    {
      GLES20.glDeleteShader(k);
      GLES20.glDeleteShader(m);
      return i;
      i = j;
    }
  }
  
  private static int createTextures(int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    GLES20.glBindTexture(paramInt1, arrayOfInt[0]);
    GLES20.glTexParameteri(paramInt1, 10242, paramInt2);
    GLES20.glTexParameteri(paramInt1, 10243, paramInt2);
    GLES20.glTexParameteri(paramInt1, 10241, paramInt3);
    GLES20.glTexParameteri(paramInt1, 10240, paramInt3);
    return arrayOfInt[0];
  }
  
  private static int createTextures2D()
  {
    return createTextures(3553, 33071, 9729);
  }
  
  private static int createTextures2DWithBitmap(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap.isRecycled()) {
      return 0;
    }
    int i = createTextures2D();
    if (paramInt == 6409) {}
    try
    {
      GLES20.glPixelStorei(3317, 1);
      GLUtils.texImage2D(3553, 0, paramInt, paramBitmap, 5121, 0);
      GLES20.glPixelStorei(3317, 4);
    }
    catch (Exception paramBitmap)
    {
      return 0;
    }
    GLUtils.texImage2D(3553, 0, paramInt, paramBitmap, 5121, 0);
    return i;
  }
  
  private static FloatBuffer floatArrayToFloatBuffer(float[] paramArrayOfFloat)
  {
    Object localObject = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(paramArrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    return localObject;
  }
  
  private static int getFinalNumber(float paramFloat)
  {
    if (paramFloat >= 9.0F) {
      return 999;
    }
    if (paramFloat >= 5.0F) {
      return (int)((paramFloat - 5.0F) / 4.0F * 100.0F) + 900;
    }
    if (paramFloat >= 2.0F) {
      return (int)((paramFloat - 2.0F) / 3.0F * 200.0F) + 700;
    }
    if (paramFloat >= 1.0F) {
      return (int)((paramFloat - 1.0F) * 200.0F) + 500;
    }
    if (paramFloat >= 0.0F) {
      return (int)(100.0F * paramFloat) + 400;
    }
    return 1;
  }
  
  private static float getFirstNumberStopTime(NumberRollEffectParams paramNumberRollEffectParams)
  {
    float f2 = 3.4028235E+38F;
    float f1 = f2;
    if (paramNumberRollEffectParams != null)
    {
      f1 = f2;
      if (paramNumberRollEffectParams.numberRollItems != null)
      {
        paramNumberRollEffectParams = paramNumberRollEffectParams.numberRollItems.iterator();
        f1 = 3.4028235E+38F;
        if (paramNumberRollEffectParams.hasNext())
        {
          NumberRollItem localNumberRollItem = (NumberRollItem)paramNumberRollEffectParams.next();
          if (localNumberRollItem.speedUpTime + localNumberRollItem.continueTime >= f1) {
            break label79;
          }
          f1 = localNumberRollItem.speedUpTime;
          f1 = localNumberRollItem.continueTime + f1;
        }
      }
    }
    label79:
    for (;;)
    {
      break;
      return f1;
    }
  }
  
  private float getNarrowX(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = paramFloat1;
    if (paramFloat3 < paramFloat2) {
      f = (paramFloat1 * paramFloat2 - (paramFloat2 - paramFloat3) * 0.5F) / paramFloat3;
    }
    return f;
  }
  
  private static int loadShader(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    paramString = new int[1];
    GLES20.glGetShaderiv(paramInt, 35713, paramString, 0);
    if (paramString[0] == 0)
    {
      GLES20.glDeleteShader(paramInt);
      return 0;
    }
    return paramInt;
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    this.copyFilter.apply();
    if (this.numberRollEffectParams != null)
    {
      this.materialImageWidthHeightRatio = (this.numberRollEffectParams.materialImageWidth / this.numberRollEffectParams.materialImageHeight);
      if ((this.numberRollEffectParams.numberImageFile != null) && (!this.numberRollEffectParams.numberImageFile.isEmpty()))
      {
        Bitmap localBitmap = BitmapFactory.decodeFile(this.numberRollEffectParams.numberImageFile);
        if (localBitmap != null)
        {
          this.numberImageTextureID = createTextures2DWithBitmap(localBitmap, 6408);
          localBitmap.recycle();
        }
      }
    }
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    return render(paramFrame);
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    this.copyFilter.clearGLSLSelf();
    if (this.numberImageTextureID != 0) {
      GLES20.glDeleteTextures(1, new int[] { this.numberImageTextureID }, 0);
    }
  }
  
  public void initParams()
  {
    addParam(new UniformParam.TextureParam("inputImageTexture", 0, 33984));
    addParam(new UniformParam.IntParam("boxCount", 0));
    addParam(new UniformParam.TextureParam("numberTexture", 0, 33985));
    addParam(new UniformParam.Float4fParam("box1", 0.0F, 0.0F, 0.0F, 0.0F));
    addParam(new UniformParam.FloatParam("currentY1", 0.0F));
    addParam(new UniformParam.Float4fParam("box2", 0.0F, 0.0F, 0.0F, 0.0F));
    addParam(new UniformParam.FloatParam("currentY2", 0.0F));
    addParam(new UniformParam.Float4fParam("box3", 0.0F, 0.0F, 0.0F, 0.0F));
    addParam(new UniformParam.FloatParam("currentY3", 0.0F));
  }
  
  public Frame render(Frame paramFrame)
  {
    Object localObject;
    if (this.faceAttr != null)
    {
      if (this.isNeedReset)
      {
        this.startTime = this.faceAttr.getTimeStamp();
        this.isNeedReset = false;
      }
    }
    else if (this.aiAttr != null)
    {
      if ((float)this.currentTime >= this.firstNumberStopTime * 1000.0F) {
        break label781;
      }
      localObject = this.aiAttr.getAvailableData("FaceMarkingDetector");
      if ((localObject instanceof Float))
      {
        this.scoreSum = (((Float)localObject).floatValue() + this.scoreSum);
        this.scoreCount += 1;
      }
    }
    for (;;)
    {
      float f = paramFrame.width / paramFrame.height;
      localObject = this.copyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
      ((Frame)localObject).bindFrame(-1, ((Frame)localObject).width, ((Frame)localObject).height, 0.0D);
      addParam(new UniformParam.TextureParam("inputImageTexture", paramFrame.getTextureId(), 33984));
      addParam(new UniformParam.TextureParam("numberTexture", this.numberImageTextureID, 33985));
      if ((this.numberRollEffectParams != null) && (this.numberRollEffectParams.numberRollItems != null))
      {
        addParam(new UniformParam.IntParam("boxCount", this.numberRollEffectParams.numberRollItems.size()));
        if (this.numberRollEffectParams.numberRollItems.size() > 0)
        {
          addParam(new UniformParam.Float4fParam("box1", getNarrowX(((NumberRollItem)this.numberRollEffectParams.numberRollItems.get(0)).left, this.materialImageWidthHeightRatio, f), ((NumberRollItem)this.numberRollEffectParams.numberRollItems.get(0)).top, getNarrowX(((NumberRollItem)this.numberRollEffectParams.numberRollItems.get(0)).right, this.materialImageWidthHeightRatio, f), ((NumberRollItem)this.numberRollEffectParams.numberRollItems.get(0)).bottom));
          ((NumberRollItem)this.numberRollEffectParams.numberRollItems.get(0)).calculateCurrentPosition((float)this.currentTime / 1000.0F);
          addParam(new UniformParam.FloatParam("currentY1", ((NumberRollItem)this.numberRollEffectParams.numberRollItems.get(0)).currentPosition));
          if (this.numberRollEffectParams.numberRollItems.size() > 1)
          {
            addParam(new UniformParam.Float4fParam("box2", getNarrowX(((NumberRollItem)this.numberRollEffectParams.numberRollItems.get(1)).left, this.materialImageWidthHeightRatio, f), ((NumberRollItem)this.numberRollEffectParams.numberRollItems.get(1)).top, getNarrowX(((NumberRollItem)this.numberRollEffectParams.numberRollItems.get(1)).right, this.materialImageWidthHeightRatio, f), ((NumberRollItem)this.numberRollEffectParams.numberRollItems.get(1)).bottom));
            ((NumberRollItem)this.numberRollEffectParams.numberRollItems.get(1)).calculateCurrentPosition((float)this.currentTime / 1000.0F);
            addParam(new UniformParam.FloatParam("currentY2", ((NumberRollItem)this.numberRollEffectParams.numberRollItems.get(1)).currentPosition));
            if (this.numberRollEffectParams.numberRollItems.size() > 2)
            {
              addParam(new UniformParam.Float4fParam("box3", getNarrowX(((NumberRollItem)this.numberRollEffectParams.numberRollItems.get(2)).left, this.materialImageWidthHeightRatio, f), ((NumberRollItem)this.numberRollEffectParams.numberRollItems.get(2)).top, getNarrowX(((NumberRollItem)this.numberRollEffectParams.numberRollItems.get(2)).right, this.materialImageWidthHeightRatio, f), ((NumberRollItem)this.numberRollEffectParams.numberRollItems.get(2)).bottom));
              ((NumberRollItem)this.numberRollEffectParams.numberRollItems.get(2)).calculateCurrentPosition((float)this.currentTime / 1000.0F);
              addParam(new UniformParam.FloatParam("currentY3", ((NumberRollItem)this.numberRollEffectParams.numberRollItems.get(2)).currentPosition));
            }
          }
        }
      }
      OnDrawFrameGLSL();
      renderTexture(paramFrame.getTextureId(), this.width, this.height);
      return localObject;
      this.currentTime = (this.faceAttr.getTimeStamp() - this.startTime);
      break;
      label781:
      if (!this.hasSetNumber)
      {
        setTargetNumber(getFinalNumber(this.scoreSum / this.scoreCount));
        this.hasSetNumber = true;
      }
    }
  }
  
  public void reset()
  {
    this.isNeedReset = true;
    this.currentTime = 0L;
    this.scoreSum = 0.0F;
    this.scoreCount = 0;
    this.hasSetNumber = false;
  }
  
  public void setTargetNumber(int paramInt)
  {
    if ((this.numberRollEffectParams != null) && (this.numberRollEffectParams.numberRollItems != null))
    {
      int j = this.numberRollEffectParams.numberRollItems.size() - 1;
      int i = paramInt;
      paramInt = j;
      while (paramInt >= 0)
      {
        ((NumberRollItem)this.numberRollEffectParams.numberRollItems.get(paramInt)).targetNumber = (i % 10);
        i /= 10;
        paramInt -= 1;
      }
    }
  }
  
  public void updateData(PTFaceAttr paramPTFaceAttr, AIAttr paramAIAttr)
  {
    this.faceAttr = paramPTFaceAttr;
    this.aiAttr = paramAIAttr;
  }
  
  public void updatePreview(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.NumberRollFilter
 * JD-Core Version:    0.7.0.1
 */