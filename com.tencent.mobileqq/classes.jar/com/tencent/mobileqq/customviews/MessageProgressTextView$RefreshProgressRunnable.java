package com.tencent.mobileqq.customviews;

class MessageProgressTextView$RefreshProgressRunnable
  implements Runnable
{
  int a = 0;
  int b = 0;
  
  public MessageProgressTextView$RefreshProgressRunnable(MessageProgressTextView paramMessageProgressTextView, int paramInt1, int paramInt2)
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
    MessageProgressTextView localMessageProgressTextView = this.this$0;
    localMessageProgressTextView.e = null;
    if (!localMessageProgressTextView.d)
    {
      int i = this.a;
      int j = this.b;
      this.a = (i + j);
      MessageProgressTextView.a(this.this$0, this.a, j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.MessageProgressTextView.RefreshProgressRunnable
 * JD-Core Version:    0.7.0.1
 */