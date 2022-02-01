package com.tencent.mobileqq.dinifly;

class DiniFlyAnimationView$3
  implements LottieListener<Throwable>
{
  DiniFlyAnimationView$3(DiniFlyAnimationView paramDiniFlyAnimationView) {}
  
  public void onResult(Throwable paramThrowable)
  {
    Object localObject;
    if (DiniFlyAnimationView.access$000(this.this$0) != 0)
    {
      localObject = this.this$0;
      ((DiniFlyAnimationView)localObject).setImageResource(DiniFlyAnimationView.access$000((DiniFlyAnimationView)localObject));
    }
    if (DiniFlyAnimationView.access$100(this.this$0) == null) {
      localObject = DiniFlyAnimationView.access$200();
    } else {
      localObject = DiniFlyAnimationView.access$100(this.this$0);
    }
    ((LottieListener)localObject).onResult(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.DiniFlyAnimationView.3
 * JD-Core Version:    0.7.0.1
 */