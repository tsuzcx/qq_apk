package com.tencent.mobileqq.kandian.biz.ugc.coverselect;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mobileqq.kandian.base.view.widget.CaptureOperateTouchLayout;
import com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.CandidateCaptureManager;
import com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.CapturePreparedListener;
import com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.CaptureTask;
import com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.ICaptureProxy;
import com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.PreviewCaptureManager;
import com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.SystemCaptureProxy;
import com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SavePicTask;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VideoCapturePresenter
  implements CapturePreparedListener
{
  private static float a = 0.8F;
  private Activity b;
  private IVideoCaptureView c;
  private PreviewCaptureManager d;
  private CandidateCaptureManager e;
  private ICaptureProxy f;
  private List<CaptureTask> g = new ArrayList();
  private List<CaptureTask> h = new ArrayList();
  private String i;
  private float j;
  private String k;
  private int l;
  private int m;
  
  public VideoCapturePresenter(Activity paramActivity, Bundle paramBundle, IVideoCaptureView paramIVideoCaptureView)
  {
    this.b = paramActivity;
    this.c = paramIVideoCaptureView;
    a(paramBundle);
    this.f = new SystemCaptureProxy();
    this.f.a(this);
    this.e = new CandidateCaptureManager();
    this.d = new PreviewCaptureManager(this.f);
    this.e.a(new VideoCapturePresenter.1(this, paramIVideoCaptureView));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, List<CaptureTask> paramList)
  {
    CaptureTask localCaptureTask = new CaptureTask(1, this.i, paramInt1, paramInt2, paramInt3, new VideoCapturePresenter.PreviewCaptureCallback(this, paramList.size()));
    this.d.c(localCaptureTask);
    paramList.add(localCaptureTask);
  }
  
  private void a(Bitmap paramBitmap, int paramInt)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(URLDrawableHelper.diskCachePath);
    localStringBuilder1.append(File.separator);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(this.i);
    localStringBuilder2.append("-");
    localStringBuilder2.append(paramInt);
    localStringBuilder1.append(AbsDownloader.getFileName(localStringBuilder2.toString()));
    this.k = localStringBuilder1.toString();
    new SavePicTask(paramBitmap, this.k).a();
  }
  
  private void a(Bundle paramBundle)
  {
    this.i = paramBundle.getString("ARG_VIDEO_URL");
    this.j = paramBundle.getFloat("ARG_INITIAL_PROGRESS");
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
    {
      this.l = ((int)(this.c.b() * a));
      this.m = (paramInt2 * this.l / paramInt1);
    }
    else
    {
      this.m = ((int)(this.c.b() * a));
      this.l = (paramInt1 * this.m / paramInt2);
    }
    paramInt1 = (int)(this.c.b() * a);
    this.m = paramInt1;
    this.l = paramInt1;
  }
  
  private void f()
  {
    int i1 = this.c.a();
    float f1;
    if (i1 > 0) {
      f1 = (float)this.f.b() / i1;
    } else {
      f1 = 0.0F;
    }
    int n = 0;
    while (n < i1)
    {
      a((int)(n * f1), this.l, this.m, this.g);
      n += 1;
    }
    this.c.a(this.g);
  }
  
  public void a()
  {
    this.e.a(this.i, this.c.c(), new VideoCapturePresenter.2(this));
    this.f.a(this.i, null);
  }
  
  public void a(int paramInt)
  {
    this.e.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.h.clear();
    ArrayList localArrayList = new ArrayList();
    int n = 0;
    while (n < this.c.a())
    {
      int i1 = (n - paramInt2) * CaptureOperateTouchLayout.a + paramInt1;
      a(i1, this.l, this.m, this.h);
      localArrayList.add(Integer.valueOf(i1));
      n += 1;
    }
    this.c.b(this.h);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("expandCandidateImageList positionList:");
      localStringBuilder.append(localArrayList);
      localStringBuilder.append(" position：");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" seedPosition：");
      localStringBuilder.append(paramInt2);
      QLog.d("VideoCapturePresenter", 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    b(paramInt1, paramInt2);
    f();
    this.c.a(this.f.b());
  }
  
  public void a(OutputPicListener paramOutputPicListener)
  {
    paramOutputPicListener.a(this.k);
  }
  
  public void b()
  {
    this.c.b(this.g);
  }
  
  public void c()
  {
    this.d.a();
    this.e.c();
  }
  
  public void d()
  {
    this.e.a();
  }
  
  public void e()
  {
    this.e.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.VideoCapturePresenter
 * JD-Core Version:    0.7.0.1
 */