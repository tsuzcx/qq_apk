package com.tencent.mobileqq.qqlive.view;

class TPPlayerVideoView$1
  implements ITPViewBase.ViewCreateCallBack
{
  TPPlayerVideoView$1(TPPlayerVideoView paramTPPlayerVideoView) {}
  
  public void a(Object paramObject)
  {
    TPPlayerVideoView.a(this.a, false);
    TPPlayerVideoView.d(this.a, paramObject);
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2)
  {
    TPPlayerVideoView.a(this.a, true);
    TPPlayerVideoView.a(this.a, paramObject);
    TPPlayerVideoView.b(this.a, paramObject);
  }
  
  public void b(Object paramObject, int paramInt1, int paramInt2)
  {
    if ((TPPlayerVideoView.a(this.a) == paramInt1) && (TPPlayerVideoView.b(this.a) == paramInt2)) {
      return;
    }
    TPPlayerVideoView.a(this.a, paramInt1);
    TPPlayerVideoView.b(this.a, paramInt2);
    TPPlayerVideoView.a(this.a, paramObject);
    TPPlayerVideoView.c(this.a, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.view.TPPlayerVideoView.1
 * JD-Core Version:    0.7.0.1
 */