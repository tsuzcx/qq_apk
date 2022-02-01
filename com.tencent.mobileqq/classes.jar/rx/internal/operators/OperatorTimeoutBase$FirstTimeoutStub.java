package rx.internal.operators;

import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Func3;

abstract interface OperatorTimeoutBase$FirstTimeoutStub<T>
  extends Func3<OperatorTimeoutBase.TimeoutSubscriber<T>, Long, Scheduler.Worker, Subscription>
{}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorTimeoutBase.FirstTimeoutStub
 * JD-Core Version:    0.7.0.1
 */