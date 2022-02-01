package com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import java.lang.ref.SoftReference;

public class CaptureTask
  extends AsyncTask<Void, Void, Bitmap>
{
  int jdField_a_of_type_Int = -2147483648;
  private CaptureTask.OnCaptureCallback jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask$OnCaptureCallback;
  private CaptureTask.OnTaskListener jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask$OnTaskListener;
  private ICaptureProxy jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureICaptureProxy;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private SoftReference<Bitmap> jdField_a_of_type_JavaLangRefSoftReference;
  public int b;
  public int c;
  public int d;
  public int e;
  private int f = 0;
  
  public CaptureTask(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, CaptureTask.OnCaptureCallback paramOnCaptureCallback)
  {
    this.b = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask$OnCaptureCallback = paramOnCaptureCallback;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask$OnCaptureCallback = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask$OnTaskListener = null;
  }
  
  private void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public Bitmap a()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefSoftReference;
    if ((localObject != null) && (((SoftReference)localObject).get() != null))
    {
      localObject = (Bitmap)this.jdField_a_of_type_JavaLangRefSoftReference.get();
      if (!((Bitmap)localObject).isRecycled()) {
        return localObject;
      }
    }
    this.jdField_a_of_type_JavaLangRefSoftReference = null;
    return null;
  }
  
  protected Bitmap a(Void... arg1)
  {
    ??? = a();
    if (??? != null) {
      return ???;
    }
    this.f += 1;
    Bitmap[] arrayOfBitmap = new Bitmap[1];
    arrayOfBitmap[0] = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureICaptureProxy.a(this, new CaptureTask.1(this, arrayOfBitmap));
    try
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.wait();
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
      return localObject[0];
    }
  }
  
  protected void a(Bitmap paramBitmap)
  {
    super.onPostExecute(paramBitmap);
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramBitmap);
    CaptureTask.OnTaskListener localOnTaskListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask$OnTaskListener;
    if (localOnTaskListener != null) {
      localOnTaskListener.b(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask$OnCaptureCallback != null) {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask$OnCaptureCallback.a(paramBitmap, this);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask$OnCaptureCallback.a();
      }
    }
    a();
  }
  
  public void a(CaptureTask.OnTaskListener paramOnTaskListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask$OnTaskListener = paramOnTaskListener;
  }
  
  public void a(ICaptureProxy paramICaptureProxy)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureICaptureProxy = paramICaptureProxy;
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    a();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    CaptureTask.OnTaskListener localOnTaskListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask$OnTaskListener;
    if (localOnTaskListener != null) {
      localOnTaskListener.a(this);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CaptureTask{id=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", path='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", position=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.CaptureTask
 * JD-Core Version:    0.7.0.1
 */