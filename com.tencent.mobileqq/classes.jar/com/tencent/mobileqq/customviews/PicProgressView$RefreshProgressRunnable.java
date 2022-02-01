package com.tencent.mobileqq.customviews;

class PicProgressView$RefreshProgressRunnable
  implements Runnable
{
  int a = 0;
  int b = 0;
  
  public PicProgressView$RefreshProgressRunnable(PicProgressView paramPicProgressView, int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void run()
  {
    PicProgressView localPicProgressView = this.this$0;
    localPicProgressView.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable = null;
    if (!localPicProgressView.jdField_a_of_type_Boolean)
    {
      int i = this.a;
      int j = this.b;
      this.a = (i + j);
      PicProgressView.a(this.this$0, this.a, j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.PicProgressView.RefreshProgressRunnable
 * JD-Core Version:    0.7.0.1
 */