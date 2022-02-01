package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.Shader;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import com.tencent.ttpic.util.SensorUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SkyboxFilter
  extends VideoFilterBase
{
  private static final String fragment = "precision highp float;\n\nuniform samplerCube inputCubeTexture;\n\nvarying vec3 cubeTextureCoordinate;\n\nvoid main()\n{\n    gl_FragColor = textureCube(inputCubeTexture, cubeTextureCoordinate);\n//    gl_FragColor = vec4(1.0, 1.0, 0.0, 1.0);\n}\n";
  private static final float[] vVertices = { -1.0F, 1.0F, -1.0F, -1.0F, -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, -1.0F, 1.0F, -1.0F, -1.0F, -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F, -1.0F, -1.0F, -1.0F, -1.0F, -1.0F, -1.0F, 1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, -1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F };
  private static final String vertex = "attribute vec3 vposition;\n\nuniform mat4 uMVPMatrix;\n\nvarying vec3 cubeTextureCoordinate;\n\nvoid main()\n{\n    gl_Position = uMVPMatrix * vec4(vposition, 1.0);\n    gl_Position = gl_Position.xyww;\n\n    cubeTextureCoordinate = vposition;\n//    cubeTextureCoordinate.z = -vposition.z;\n    cubeTextureCoordinate.y = -vposition.y;\n    cubeTextureCoordinate.x = -vposition.x;\n}\n";
  private String back;
  private boolean backLoad;
  private boolean backUpdate;
  private Bitmap bitmap;
  private String bottom;
  private boolean bottomLoad;
  private boolean bottomUpdate;
  private String dataPath;
  private String front;
  private boolean frontLoad;
  private boolean frontUpdate;
  private boolean isCurTrigged;
  private String left;
  private boolean leftLoad;
  private boolean leftUpdate;
  private float[] mCenterUp = new float[6];
  private int mCubeTextureHandle;
  private float[] mIdentityMatrix = new float[16];
  private float[] mMVPMatrix = new float[16];
  private int mMVPMatrixHandle;
  private float[] mModelMatrix = new float[16];
  private float[] mProjectMatrix = new float[16];
  private float[] mViewMatrix = new float[16];
  private String right;
  private boolean rightLoad;
  private boolean rightUpdate;
  private SensorUtil sensorUtil;
  private SkyBitmapUtil skyBitmapUtil;
  private StickerItem stickerItem;
  private int[] tex = new int[1];
  private String top;
  private boolean topLoad;
  private boolean topUpdate;
  private TriggerCtrlItem triggerCtrlItem;
  
  public SkyboxFilter(String paramString, StickerItem paramStickerItem)
  {
    super("attribute vec3 vposition;\n\nuniform mat4 uMVPMatrix;\n\nvarying vec3 cubeTextureCoordinate;\n\nvoid main()\n{\n    gl_Position = uMVPMatrix * vec4(vposition, 1.0);\n    gl_Position = gl_Position.xyww;\n\n    cubeTextureCoordinate = vposition;\n//    cubeTextureCoordinate.z = -vposition.z;\n    cubeTextureCoordinate.y = -vposition.y;\n    cubeTextureCoordinate.x = -vposition.x;\n}\n", "precision highp float;\n\nuniform samplerCube inputCubeTexture;\n\nvarying vec3 cubeTextureCoordinate;\n\nvoid main()\n{\n    gl_FragColor = textureCube(inputCubeTexture, cubeTextureCoordinate);\n//    gl_FragColor = vec4(1.0, 1.0, 0.0, 1.0);\n}\n");
    this.dataPath = paramString;
    this.stickerItem = paramStickerItem;
    addAttribParam(new AttributeParam("vposition", vVertices, 3, true));
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(36);
    this.sensorUtil = new SensorUtil();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramStickerItem.id);
    localStringBuilder.append(File.separator);
    this.skyBitmapUtil = new SkyBitmapUtil(localStringBuilder.toString());
    this.skyBitmapUtil.decode(0, new ArrayList(Arrays.asList(new String[] { "left", "right", "front", "back", "top", "bottom" })));
    Matrix.setIdentityM(this.mMVPMatrix, 0);
    Matrix.setIdentityM(this.mModelMatrix, 0);
    Matrix.setIdentityM(this.mViewMatrix, 0);
    Matrix.setIdentityM(this.mProjectMatrix, 0);
    Matrix.setIdentityM(this.mIdentityMatrix, 0);
  }
  
  private void initCubemap()
  {
    int[] arrayOfInt = this.tex;
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    GLES20.glActiveTexture(33987);
    GLES20.glBindTexture(34067, this.tex[0]);
  }
  
  private void initMVP(int paramInt1, int paramInt2)
  {
    Matrix.setIdentityM(this.mModelMatrix, 0);
    Matrix.setIdentityM(this.mViewMatrix, 0);
    Matrix.setIdentityM(this.mProjectMatrix, 0);
    Matrix.setIdentityM(this.mMVPMatrix, 0);
    Matrix.setIdentityM(this.mIdentityMatrix, 0);
    float[] arrayOfFloat1 = this.mViewMatrix;
    float[] arrayOfFloat2 = this.mCenterUp;
    Matrix.setLookAtM(arrayOfFloat1, 0, 0.0F, 0.0F, 0.0F, arrayOfFloat2[0], arrayOfFloat2[1], arrayOfFloat2[2], arrayOfFloat2[3], arrayOfFloat2[4], arrayOfFloat2[5]);
    Matrix.perspectiveM(this.mProjectMatrix, 0, 72.0F, paramInt1 / paramInt2, 1.0F, 300.0F);
    Matrix.multiplyMM(this.mMVPMatrix, 0, this.mViewMatrix, 0, this.mIdentityMatrix, 0);
    arrayOfFloat1 = this.mMVPMatrix;
    Matrix.multiplyMM(arrayOfFloat1, 0, this.mProjectMatrix, 0, arrayOfFloat1, 0);
  }
  
  private List<String> lookSides(long paramLong)
  {
    float[] arrayOfFloat = this.sensorUtil.centerUp(paramLong);
    ArrayList localArrayList = new ArrayList();
    if (seeFront(arrayOfFloat)) {
      localArrayList.add("front");
    }
    if (seeLeft(arrayOfFloat)) {
      localArrayList.add("left");
    }
    if (seeBack(arrayOfFloat)) {
      localArrayList.add("back");
    }
    if (seeRight(arrayOfFloat)) {
      localArrayList.add("right");
    }
    if (seeTop(arrayOfFloat)) {
      localArrayList.add("top");
    }
    if (seeBottom(arrayOfFloat)) {
      localArrayList.add("bottom");
    }
    return localArrayList;
  }
  
  private int nextCount(long paramLong1, long paramLong2)
  {
    return this.triggerCtrlItem.getFrameIndexElapse();
  }
  
  private int nextFrame(PTDetectInfo paramPTDetectInfo, int paramInt)
  {
    this.isCurTrigged = this.triggerCtrlItem.isTriggered();
    paramInt = this.triggerCtrlItem.getFrameIndex();
    paramPTDetectInfo = new StringBuilder();
    paramPTDetectInfo.append(this.dataPath);
    paramPTDetectInfo.append(File.separator);
    paramPTDetectInfo.append(this.stickerItem.id);
    paramPTDetectInfo.append(File.separator);
    paramPTDetectInfo = paramPTDetectInfo.toString();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramPTDetectInfo);
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("_left");
    ((StringBuilder)localObject1).append(".png");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramPTDetectInfo);
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("_right");
    ((StringBuilder)localObject2).append(".png");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramPTDetectInfo);
    ((StringBuilder)localObject3).append(paramInt);
    ((StringBuilder)localObject3).append("_top");
    ((StringBuilder)localObject3).append(".png");
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(paramPTDetectInfo);
    ((StringBuilder)localObject4).append(paramInt);
    ((StringBuilder)localObject4).append("_bottom");
    ((StringBuilder)localObject4).append(".png");
    localObject4 = ((StringBuilder)localObject4).toString();
    Object localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append(paramPTDetectInfo);
    ((StringBuilder)localObject5).append(paramInt);
    ((StringBuilder)localObject5).append("_back");
    ((StringBuilder)localObject5).append(".png");
    localObject5 = ((StringBuilder)localObject5).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramPTDetectInfo);
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_front");
    localStringBuilder.append(".png");
    paramPTDetectInfo = localStringBuilder.toString();
    if (FileUtils.assetAndPathExist(AEModule.getContext(), (String)localObject1))
    {
      this.left = ((String)localObject1);
      this.leftUpdate = true;
    }
    if (FileUtils.assetAndPathExist(AEModule.getContext(), (String)localObject2))
    {
      this.right = ((String)localObject2);
      this.rightUpdate = true;
    }
    if (FileUtils.assetAndPathExist(AEModule.getContext(), (String)localObject3))
    {
      this.top = ((String)localObject3);
      this.topUpdate = true;
    }
    if (FileUtils.assetAndPathExist(AEModule.getContext(), (String)localObject4))
    {
      this.bottom = ((String)localObject4);
      this.bottomUpdate = true;
    }
    if (FileUtils.assetAndPathExist(AEModule.getContext(), (String)localObject5))
    {
      this.back = ((String)localObject5);
      this.backUpdate = true;
    }
    if (FileUtils.assetAndPathExist(AEModule.getContext(), paramPTDetectInfo))
    {
      this.front = paramPTDetectInfo;
      this.frontUpdate = true;
    }
    return paramInt;
  }
  
  private boolean seeBack(float[] paramArrayOfFloat)
  {
    return paramArrayOfFloat[2] > 0.0F;
  }
  
  private boolean seeBottom(float[] paramArrayOfFloat)
  {
    return paramArrayOfFloat[1] > 0.0F;
  }
  
  private boolean seeFront(float[] paramArrayOfFloat)
  {
    return paramArrayOfFloat[2] < 0.0F;
  }
  
  private boolean seeLeft(float[] paramArrayOfFloat)
  {
    boolean bool = false;
    if (paramArrayOfFloat[0] < 0.0F) {
      bool = true;
    }
    return bool;
  }
  
  private boolean seeRight(float[] paramArrayOfFloat)
  {
    boolean bool = false;
    if (paramArrayOfFloat[0] > 0.0F) {
      bool = true;
    }
    return bool;
  }
  
  private boolean seeTop(float[] paramArrayOfFloat)
  {
    return paramArrayOfFloat[1] < 0.0F;
  }
  
  private void updateCubemap(HashMap<String, Bitmap> paramHashMap)
  {
    if (((this.leftUpdate) && (seeLeft(this.mCenterUp))) || (!this.leftLoad))
    {
      if ((paramHashMap != null) && (BitmapUtils.isLegal((Bitmap)paramHashMap.get("left"))))
      {
        this.bitmap = ((Bitmap)paramHashMap.get("left"));
        if (BitmapUtils.isLegal(this.bitmap)) {
          GLUtils.texImage2D(34069, 0, this.bitmap, 0);
        }
      }
      else
      {
        this.bitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.left, 1);
        if (BitmapUtils.isLegal(this.bitmap))
        {
          GLUtils.texImage2D(34069, 0, this.bitmap, 0);
          this.bitmap.recycle();
        }
      }
      this.leftUpdate = false;
      this.leftLoad = true;
    }
    if (((this.rightUpdate) && (seeRight(this.mCenterUp))) || (!this.rightLoad))
    {
      if ((paramHashMap != null) && (BitmapUtils.isLegal((Bitmap)paramHashMap.get("right"))))
      {
        this.bitmap = ((Bitmap)paramHashMap.get("right"));
        if (BitmapUtils.isLegal(this.bitmap)) {
          GLUtils.texImage2D(34070, 0, this.bitmap, 0);
        }
      }
      else
      {
        this.bitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.right, 1);
        if (BitmapUtils.isLegal(this.bitmap))
        {
          GLUtils.texImage2D(34070, 0, this.bitmap, 0);
          this.bitmap.recycle();
        }
      }
      this.rightUpdate = false;
      this.rightLoad = true;
    }
    Bitmap localBitmap;
    if (((this.topUpdate) && (seeTop(this.mCenterUp))) || (!this.topLoad))
    {
      if ((paramHashMap != null) && (BitmapUtils.isLegal((Bitmap)paramHashMap.get("top"))))
      {
        this.bitmap = ((Bitmap)paramHashMap.get("top"));
        if (BitmapUtils.isLegal(this.bitmap)) {
          GLUtils.texImage2D(34071, 0, this.bitmap, 0);
        }
      }
      else
      {
        this.bitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.top, 1);
        if (BitmapUtils.isLegal(this.bitmap))
        {
          localBitmap = BitmapUtils.rotateBitmap(this.bitmap, 180, false);
          GLUtils.texImage2D(34071, 0, localBitmap, 0);
          this.bitmap.recycle();
          localBitmap.recycle();
        }
      }
      this.topUpdate = false;
      this.topLoad = true;
    }
    if (((this.bottomUpdate) && (seeBottom(this.mCenterUp))) || (!this.bottomLoad))
    {
      if ((paramHashMap != null) && (BitmapUtils.isLegal((Bitmap)paramHashMap.get("bottom"))))
      {
        this.bitmap = ((Bitmap)paramHashMap.get("bottom"));
        if (BitmapUtils.isLegal(this.bitmap)) {
          GLUtils.texImage2D(34072, 0, this.bitmap, 0);
        }
      }
      else
      {
        this.bitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.bottom, 1);
        if (BitmapUtils.isLegal(this.bitmap))
        {
          localBitmap = BitmapUtils.rotateBitmap(this.bitmap, 180, false);
          GLUtils.texImage2D(34072, 0, localBitmap, 0);
          this.bitmap.recycle();
          localBitmap.recycle();
        }
      }
      this.bottomUpdate = false;
      this.bottomLoad = true;
    }
    if (((this.backUpdate) && (seeBack(this.mCenterUp))) || (!this.backLoad))
    {
      if ((paramHashMap != null) && (BitmapUtils.isLegal((Bitmap)paramHashMap.get("back"))))
      {
        this.bitmap = ((Bitmap)paramHashMap.get("back"));
        if (BitmapUtils.isLegal(this.bitmap)) {
          GLUtils.texImage2D(34073, 0, this.bitmap, 0);
        }
      }
      else
      {
        this.bitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.back, 1);
        if (BitmapUtils.isLegal(this.bitmap))
        {
          GLUtils.texImage2D(34073, 0, this.bitmap, 0);
          this.bitmap.recycle();
        }
      }
      this.backUpdate = false;
      this.backLoad = true;
    }
    if (((this.frontUpdate) && (seeFront(this.mCenterUp))) || (!this.frontLoad))
    {
      if ((paramHashMap != null) && (BitmapUtils.isLegal((Bitmap)paramHashMap.get("front"))))
      {
        this.bitmap = ((Bitmap)paramHashMap.get("front"));
        if (BitmapUtils.isLegal(this.bitmap)) {
          GLUtils.texImage2D(34074, 0, this.bitmap, 0);
        }
      }
      else
      {
        this.bitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.front, 1);
        if (BitmapUtils.isLegal(this.bitmap))
        {
          GLUtils.texImage2D(34074, 0, this.bitmap, 0);
          this.bitmap.recycle();
        }
      }
      this.frontUpdate = false;
      this.frontLoad = true;
    }
    GLES20.glTexParameterf(34067, 10240, 9729.0F);
    GLES20.glTexParameterf(34067, 10241, 9729.0F);
    GLES20.glTexParameterf(34067, 10242, 33071.0F);
    GLES20.glTexParameterf(34067, 10243, 33071.0F);
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    this.mCubeTextureHandle = GLES20.glGetUniformLocation(getProgramIds(), "inputCubeTexture");
    this.mMVPMatrixHandle = GLES20.glGetUniformLocation(getProgramIds(), "uMVPMatrix");
    initCubemap();
    this.sensorUtil.start();
  }
  
  public void clearGLSLSelf()
  {
    int[] arrayOfInt = this.tex;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    super.clearGLSLSelf();
    this.sensorUtil.stop();
  }
  
  public String getItemId()
  {
    return this.stickerItem.id;
  }
  
  public Frame render(Frame paramFrame, PTDetectInfo paramPTDetectInfo, int paramInt)
  {
    paramInt = nextFrame(paramPTDetectInfo, paramInt);
    if (!this.isCurTrigged) {
      return paramFrame;
    }
    AIAttr localAIAttr = paramPTDetectInfo.aiAttr;
    paramPTDetectInfo = paramFrame;
    if (localAIAttr != null)
    {
      paramPTDetectInfo = paramFrame;
      if (localAIAttr.getSurfaceTime() > 0L)
      {
        if (localAIAttr.getNextSurfaceTime() <= 0L) {
          return paramFrame;
        }
        System.arraycopy(this.sensorUtil.centerUp(localAIAttr.getSurfaceTime()), 0, this.mCenterUp, 0, 6);
        this.skyBitmapUtil.decode(this.triggerCtrlItem.getFrameIndexElapse(), lookSides(localAIAttr.getNextSurfaceTime()));
        this.shader.bind();
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(34067, this.tex[0]);
        updateCubemap(this.skyBitmapUtil.getBitmap(paramInt));
        GLES20.glUniform1i(this.mCubeTextureHandle, 3);
        initMVP(paramFrame.width, paramFrame.height);
        GLES20.glUniformMatrix4fv(this.mMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
        paramPTDetectInfo = super.render(paramFrame);
      }
    }
    return paramPTDetectInfo;
  }
  
  public void setTriggerCtrlItem(TriggerCtrlItem paramTriggerCtrlItem)
  {
    this.triggerCtrlItem = paramTriggerCtrlItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.SkyboxFilter
 * JD-Core Version:    0.7.0.1
 */