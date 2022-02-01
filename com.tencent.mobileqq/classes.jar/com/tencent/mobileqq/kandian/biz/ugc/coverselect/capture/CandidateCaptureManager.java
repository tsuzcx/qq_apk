package com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture;

import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import java.util.concurrent.Executor;

public class CandidateCaptureManager
  implements CapturePreparedListener, ISuperPlayer.OnSeekCompleteListener
{
  private int jdField_a_of_type_Int = -1;
  private CaptureTask.OnCaptureCallback jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask$OnCaptureCallback;
  private CaptureTask jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask = null;
  private ICaptureProxy jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureICaptureProxy = new PlayerCaptureProxy();
  private String jdField_a_of_type_JavaLangString;
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManagerExecutor.getExecutorService(64);
  private int b;
  private int c;
  
  private void d()
  {
    e();
    CaptureTask localCaptureTask = new CaptureTask(2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask$OnCaptureCallback);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask = localCaptureTask;
    localCaptureTask.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureICaptureProxy);
    localCaptureTask.executeOnExecutor(this.jdField_a_of_type_JavaUtilConcurrentExecutor, null);
  }
  
  private void e()
  {
    CaptureTask localCaptureTask = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask;
    if (localCaptureTask != null) {
      localCaptureTask.cancel(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask = null;
  }
  
  public void a()
  {
    ICaptureProxy localICaptureProxy = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureICaptureProxy;
    if (localICaptureProxy != null) {
      localICaptureProxy.b();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureICaptureProxy.a(paramInt, this);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void a(CaptureTask.OnCaptureCallback paramOnCaptureCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask$OnCaptureCallback = paramOnCaptureCallback;
  }
  
  public void a(String paramString, ViewGroup paramViewGroup, CapturePreparedListener paramCapturePreparedListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureICaptureProxy.a(paramString, paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureICaptureProxy.a(paramCapturePreparedListener);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureICaptureProxy.a(this);
  }
  
  public void b()
  {
    ICaptureProxy localICaptureProxy = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureICaptureProxy;
    if (localICaptureProxy != null) {
      localICaptureProxy.c();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask$OnCaptureCallback = null;
    e();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureICaptureProxy.a();
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.CandidateCaptureManager
 * JD-Core Version:    0.7.0.1
 */