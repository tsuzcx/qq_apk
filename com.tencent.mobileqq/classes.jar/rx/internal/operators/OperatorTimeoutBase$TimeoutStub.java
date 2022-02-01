package rx.internal.operators;

import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Func4;

abstract interface OperatorTimeoutBase$TimeoutStub<T>
  extends Func4<OperatorTimeoutBase.TimeoutSubscriber<T>, Long, T, Scheduler.Worker, Subscription>
{}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorTimeoutBase.TimeoutStub
 * JD-Core Version:    0.7.0.1
 */