package com.tencent.mobileqq.editor.composite.step;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.opengl.EGL14;
import android.support.annotation.RequiresApi;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQImage2FrameFilter;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWVideoRecorder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class MuiltiImageToVideo
{
  private final int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  private HWVideoRecorder jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder;
  private final String jdField_a_of_type_JavaLangString;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private final int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private final int c;
  private int d = 42;
  private int e;
  
  public MuiltiImageToVideo(String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong, boolean paramBoolean, int paramInt4)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.e = paramInt4;
  }
  
  private int a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap != null) && (paramInt2 != 0) && (paramInt1 != 0))
    {
      int i = GlUtil.createTexture(3553, paramBitmap);
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = new QQFilterRenderManager();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceCreate(paramInt1, paramInt2, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceChange(paramInt1, paramInt2, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.pushChain(new int[] { 170 }, null);
      List localList = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getQQFilters(170);
      if ((localList != null) && (localList.size() > 0) && ((localList.get(0) instanceof QQImage2FrameFilter))) {
        ((QQImage2FrameFilter)localList.get(0)).setImageSize(paramBitmap.getWidth(), paramBitmap.getHeight());
      }
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.drawFrame(i);
      if (i > 0) {
        GlUtil.deleteTexture(i);
      }
      return paramInt1;
    }
    if (paramBitmap == null) {
      return 0;
    }
    return GlUtil.createTexture(3553, paramBitmap);
  }
  
  private int b(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap != null) && (paramInt2 != 0) && (paramInt1 != 0))
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      float f1 = paramInt1;
      float f2 = paramInt2;
      paramBitmap.getWidth();
      paramBitmap.getHeight();
      paramInt1 = paramBitmap.getWidth();
      paramInt2 = paramBitmap.getHeight();
      Matrix localMatrix = new Matrix();
      localMatrix.postTranslate(paramInt1 * -0.5F, paramInt2 * -0.5F);
      paramInt1 = this.e;
      if ((paramInt1 != 180) && (paramInt1 != 270)) {
        localMatrix.postRotate(-180.0F, 0.0F, 1.0F);
      }
      localMatrix.postScale(-1.0F, 1.0F);
      float f3 = f1 * 1.0F / paramBitmap.getWidth();
      localMatrix.postScale(f3, f3);
      localMatrix.postTranslate(f1 * 0.5F, f2 * 0.5F);
      localCanvas.drawBitmap(paramBitmap, localMatrix, null);
      return GlUtil.createTexture(3553, localBitmap);
    }
    if (paramBitmap == null) {
      return 0;
    }
    return GlUtil.createTexture(3553, paramBitmap);
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  @TargetApi(17)
  @RequiresApi(api=17)
  public void a(List<Bitmap> paramList, VideoStoryPicToVideo.ConvertListener paramConvertListener)
  {
    VideoStoryPicToVideo.RetCode localRetCode = new VideoStoryPicToVideo.RetCode(0, "success");
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder = new HWVideoRecorder();
    EncodeConfig localEncodeConfig = new EncodeConfig(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.c, 1, false, 0);
    localEncodeConfig.a(EGL14.eglGetCurrentContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.c);
    QLog.d("MuiltiImageToVideo", 2, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder.a(localEncodeConfig, new MuiltiImageToVideo.1(this, paramList, paramConvertListener, localRetCode));
    try
    {
      try
      {
        wait();
        return;
      }
      finally {}
      return;
    }
    catch (InterruptedException paramList)
    {
      paramList.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.step.MuiltiImageToVideo
 * JD-Core Version:    0.7.0.1
 */