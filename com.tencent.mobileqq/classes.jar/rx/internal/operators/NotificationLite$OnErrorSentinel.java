package rx.internal.operators;

import java.io.Serializable;

class NotificationLite$OnErrorSentinel
  implements Serializable
{
  private static final long serialVersionUID = 3L;
  final Throwable e;
  
  public NotificationLite$OnErrorSentinel(Throwable paramThrowable)
  {
    this.e = paramThrowable;
  }
  
  public String toString()
  {
    return "Notification=>Error:" + this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.NotificationLite.OnErrorSentinel
 * JD-Core Version:    0.7.0.1
 */