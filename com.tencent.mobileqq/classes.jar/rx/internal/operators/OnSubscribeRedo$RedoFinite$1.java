package rx.internal.operators;

import rx.Notification;
import rx.functions.Func1;

class OnSubscribeRedo$RedoFinite$1
  implements Func1<Notification<?>, Notification<?>>
{
  int num = 0;
  
  OnSubscribeRedo$RedoFinite$1(OnSubscribeRedo.RedoFinite paramRedoFinite) {}
  
  public Notification<?> call(Notification<?> paramNotification)
  {
    if (this.this$0.count == 0L) {
      return paramNotification;
    }
    this.num += 1;
    if (this.num <= this.this$0.count) {
      paramNotification = Notification.createOnNext(Integer.valueOf(this.num));
    }
    return paramNotification;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.RedoFinite.1
 * JD-Core Version:    0.7.0.1
 */