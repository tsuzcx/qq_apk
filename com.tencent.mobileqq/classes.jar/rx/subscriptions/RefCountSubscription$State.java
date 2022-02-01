package rx.subscriptions;

final class RefCountSubscription$State
{
  final int children;
  final boolean isUnsubscribed;
  
  RefCountSubscription$State(boolean paramBoolean, int paramInt)
  {
    this.isUnsubscribed = paramBoolean;
    this.children = paramInt;
  }
  
  State addChild()
  {
    return new State(this.isUnsubscribed, this.children + 1);
  }
  
  State removeChild()
  {
    return new State(this.isUnsubscribed, this.children - 1);
  }
  
  State unsubscribe()
  {
    return new State(true, this.children);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.subscriptions.RefCountSubscription.State
 * JD-Core Version:    0.7.0.1
 */