package com.tencent.mobileqq.shortvideo.filter;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.model.BuckleFrameItem;
import com.tencent.ttpic.util.FaceOffUtil;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQGameBuckleFaceFilter
{
  public static final String FACE_CROP_FRAGMENT;
  public static final String FACE_CROP_VERTEX = FileUtils.loadAssetsString(AEModule.getContext(), "camera/camera_video/shader/FaceCropVertexShader.dat");
  public static final int FLOAT_SIZE_BYTES = 4;
  private static final String TAG = "QQGameBuckleFaceFilter";
  public static final float[] TEXUTURE_COORDS = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  public static float[] VERTEXT_COORDS;
  private float[] attrPositions = new float[8];
  private float[] attrTexCoords = new float[8];
  protected int height;
  private final String mFragmentShader;
  private boolean mIsInitialized;
  private int mProgram;
  protected double mScreenScale;
  public int mTextureType = 3553;
  private FloatBuffer mUserTextureCoord = GlUtil.createFloatBuffer(TEXUTURE_COORDS);
  private final String mVertexShader;
  private FloatBuffer mVertextPosition = GlUtil.createFloatBuffer(VERTEXT_COORDS);
  protected int width;
  
  static
  {
    FACE_CROP_FRAGMENT = FileUtils.loadAssetsString(AEModule.getContext(), "camera/camera_video/shader/FaceCropFragmentShader.dat");
    VERTEXT_COORDS = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  }
  
  public QQGameBuckleFaceFilter()
  {
    this(FACE_CROP_VERTEX, FACE_CROP_FRAGMENT);
  }
  
  public QQGameBuckleFaceFilter(String paramString1, String paramString2)
  {
    this.mVertexShader = paramString1;
    this.mFragmentShader = paramString2;
    this.mTextureType = 3553;
  }
  
  private static float DISTANCE_OF(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private static float RADIANS2DEGREES(float paramFloat)
  {
    return (float)(180.0F * paramFloat / 3.141592653589793D);
  }
  
  private void checkGlError(String paramString)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      SLog.e("QQGameBuckleFaceFilter", new RuntimeException(paramString + ": glError " + i));
    }
  }
  
  private void checkLocation(int paramInt, String paramString)
  {
    if (paramInt < 0) {
      SLog.e("QQGameBuckleFaceFilter", new RuntimeException("Unable to locate '" + paramString + "' in program"));
    }
  }
  
  private void setUserTextureCoords(float[] paramArrayOfFloat)
  {
    this.mUserTextureCoord.position(0);
    this.mUserTextureCoord.put(paramArrayOfFloat);
    this.mUserTextureCoord.position(0);
  }
  
  private void setVertextPosition(float[] paramArrayOfFloat)
  {
    this.mVertextPosition.position(0);
    this.mVertextPosition.put(paramArrayOfFloat);
    this.mVertextPosition.position(0);
  }
  
  public void computeFaceRectAndUpdateShader(List<PointF> paramList, float[] paramArrayOfFloat, BuckleFrameItem paramBuckleFrameItem)
  {
    double d1 = paramBuckleFrameItem.size[0];
    double d2 = paramBuckleFrameItem.size[1];
    double d3 = paramBuckleFrameItem.nosePoint[0];
    double d4 = paramBuckleFrameItem.nosePoint[1];
    float f1 = (float)Math.min(d1 / this.width, d2 / this.height);
    float f2 = (float)(d1 / f1);
    float f3 = (float)(d2 / f1);
    Object localObject = new PointF((f2 - this.width) / 2.0F, (f3 - this.height) / 2.0F);
    float f6 = (float)(paramBuckleFrameItem.faceWidth / f1);
    f2 = (float)(d3 / f1 - ((PointF)localObject).x);
    f3 = (float)(d4 / f1 - ((PointF)localObject).y);
    localObject = FaceOffUtil.getFullCoords(paramList, 3.0F);
    paramList = ((List)localObject).iterator();
    PointF localPointF;
    while (paramList.hasNext())
    {
      localPointF = (PointF)paramList.next();
      localPointF.x = ((float)(localPointF.x / this.mScreenScale));
      localPointF.y = ((float)(localPointF.y / this.mScreenScale));
    }
    f1 = DISTANCE_OF((PointF)((List)localObject).get(0), (PointF)((List)localObject).get(18));
    float f4 = ((PointF)((List)localObject).get(64)).x;
    float f5 = ((PointF)((List)localObject).get(64)).y;
    paramList = new ArrayList();
    paramList.add(((List)localObject).get(99));
    paramList.add(((List)localObject).get(105));
    paramList.add(((List)localObject).get(101));
    paramList.add(((List)localObject).get(103));
    float f7 = f6 / f1;
    float f8 = paramArrayOfFloat[1];
    f1 = 0.0F;
    if (Math.abs(f8) > 0.2D) {
      if (f8 <= 0.0F) {
        break label563;
      }
    }
    label563:
    for (f1 = (f8 - 0.2F) * f6;; f1 = (0.2F + f8) * f6)
    {
      localObject = new Matrix();
      ((Matrix)localObject).reset();
      ((Matrix)localObject).postRotate(RADIANS2DEGREES((float)(paramArrayOfFloat[2] - paramBuckleFrameItem.faceAngle)), f4, f5);
      ((Matrix)localObject).postScale(f7, f7, f4, f5);
      ((Matrix)localObject).postTranslate(f2 - f4, f3 - f5);
      ((Matrix)localObject).postTranslate(f1, 0.0F);
      paramArrayOfFloat = new ArrayList();
      paramBuckleFrameItem = paramList.iterator();
      while (paramBuckleFrameItem.hasNext())
      {
        localPointF = (PointF)paramBuckleFrameItem.next();
        float[] arrayOfFloat = new float[2];
        ((Matrix)localObject).mapPoints(arrayOfFloat, new float[] { localPointF.x, localPointF.y });
        paramArrayOfFloat.add(new PointF(arrayOfFloat[0], arrayOfFloat[1]));
      }
    }
    int j = 0;
    int i = 0;
    while (i < 4)
    {
      paramBuckleFrameItem = (PointF)paramArrayOfFloat.get(i);
      this.attrPositions[j] = (2.0F * paramBuckleFrameItem.x / this.width - 1.0F);
      this.attrPositions[(j + 1)] = (paramBuckleFrameItem.y * 2.0F / this.height - 1.0F);
      paramBuckleFrameItem = (PointF)paramList.get(i);
      this.attrTexCoords[j] = (paramBuckleFrameItem.x / this.width);
      this.attrTexCoords[(j + 1)] = (paramBuckleFrameItem.y / this.height);
      j += 2;
      i += 1;
    }
    setVertextPosition(this.attrPositions);
    setUserTextureCoords(this.attrTexCoords);
  }
  
  public void destroy()
  {
    SLog.d("QQGameBuckleFaceFilter", "destroy");
    this.mIsInitialized = false;
    GLES20.glDeleteProgram(this.mProgram);
    this.mProgram = 0;
  }
  
  public void drawTexture(int paramInt)
  {
    checkGlError("onDrawFrame start");
    int j = this.mProgram;
    GLES20.glUseProgram(j);
    checkGlError("glUseProgram");
    int i = GLES20.glGetAttribLocation(j, "position");
    checkLocation(i, "position");
    j = GLES20.glGetAttribLocation(j, "inputTextureCoordinate");
    checkLocation(j, "inputTextureCoordinate");
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, this.mVertextPosition);
    checkGlError("glVertexAttribPointer position");
    GLES20.glEnableVertexAttribArray(i);
    checkGlError("glEnableVertexAttribArray mPositionHandle");
    GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, this.mUserTextureCoord);
    checkGlError("glVertexAttribPointer mTextureHandle");
    GLES20.glEnableVertexAttribArray(j);
    checkGlError("glEnableVertexAttribArray mTextureHandle");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, paramInt);
    GLES20.glDrawArrays(5, 0, 4);
    checkGlError("glDrawArrays");
  }
  
  public void init()
  {
    if (this.mIsInitialized) {
      return;
    }
    this.mProgram = GlUtil.createProgram(this.mVertexShader, this.mFragmentShader);
    if (this.mProgram == 0) {
      SLog.e("QQGameBuckleFaceFilter", new RuntimeException("failed creating program " + getClass().getSimpleName()));
    }
    this.mIsInitialized = true;
  }
  
  public void updateFilterSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.mScreenScale = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQGameBuckleFaceFilter
 * JD-Core Version:    0.7.0.1
 */