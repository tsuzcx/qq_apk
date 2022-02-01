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
  private final String a;
  private final int b;
  private final int c;
  private final int d;
  private HWVideoRecorder e;
  private QQFilterRenderManager f;
  private int g = 42;
  private ArrayList<Integer> h = new ArrayList();
  private long i;
  private long j;
  private boolean k = true;
  private int l;
  
  public MuiltiImageToVideo(String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong, boolean paramBoolean, int paramInt4)
  {
    this.a = paramString;
    this.i = paramLong;
    this.c = paramInt1;
    this.b = paramInt2;
    this.d = paramInt3;
    this.k = paramBoolean;
    this.l = paramInt4;
  }
  
  private int a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap != null) && (paramInt2 != 0) && (paramInt1 != 0))
    {
      int m = GlUtil.createTexture(3553, paramBitmap);
      if (this.f == null) {
        this.f = new QQFilterRenderManager();
      }
      this.f.surfaceCreate(paramInt1, paramInt2, paramInt1, paramInt2);
      this.f.surfaceChange(paramInt1, paramInt2, paramInt1, paramInt2);
      this.f.pushChain(new int[] { 170 }, null);
      List localList = this.f.getQQFilters(170);
      if ((localList != null) && (localList.size() > 0) && ((localList.get(0) instanceof QQImage2FrameFilter))) {
        ((QQImage2FrameFilter)localList.get(0)).setImageSize(paramBitmap.getWidth(), paramBitmap.getHeight());
      }
      paramInt1 = this.f.drawFrame(m);
      if (m > 0) {
        GlUtil.deleteTexture(m);
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
      paramInt1 = this.l;
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
    this.g = paramInt;
  }
  
  @TargetApi(17)
  @RequiresApi(api=17)
  public void a(List<Bitmap> paramList, VideoStoryPicToVideo.ConvertListener paramConvertListener)
  {
    VideoStoryPicToVideo.RetCode localRetCode = new VideoStoryPicToVideo.RetCode(0, "success");
    this.e = new HWVideoRecorder();
    EncodeConfig localEncodeConfig = new EncodeConfig(this.a, this.c, this.b, this.d, 1, false, 0);
    localEncodeConfig.a(EGL14.eglGetCurrentContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.d);
    QLog.d("MuiltiImageToVideo", 2, localStringBuilder.toString());
    this.e.a(localEncodeConfig, new MuiltiImageToVideo.1(this, paramList, paramConvertListener, localRetCode));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.step.MuiltiImageToVideo
 * JD-Core Version:    0.7.0.1
 */