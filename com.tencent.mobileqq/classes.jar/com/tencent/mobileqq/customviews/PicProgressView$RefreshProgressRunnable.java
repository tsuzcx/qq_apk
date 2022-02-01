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
    this.this$0.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable = null;
    if (!this.this$0.jdField_a_of_type_Boolean)
    {
      this.a += this.b;
      PicProgressView.a(this.this$0, this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.PicProgressView.RefreshProgressRunnable
 * JD-Core Version:    0.7.0.1
 */