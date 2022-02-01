package rx.internal.operators;

import java.util.Deque;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;

final class TakeLastQueueProducer<T>
  extends AtomicLong
  implements Producer
{
  private final Deque<Object> deque;
  private volatile boolean emittingStarted = false;
  private final NotificationLite<T> notification;
  private final Subscriber<? super T> subscriber;
  
  public TakeLastQueueProducer(NotificationLite<T> paramNotificationLite, Deque<Object> paramDeque, Subscriber<? super T> paramSubscriber)
  {
    this.notification = paramNotificationLite;
    this.deque = paramDeque;
    this.subscriber = paramSubscriber;
  }
  
  /* Error */
  void emit(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 42	rx/internal/operators/TakeLastQueueProducer:get	()J
    //   4: ldc2_w 43
    //   7: lcmp
    //   8: ifne +118 -> 126
    //   11: lload_1
    //   12: lconst_0
    //   13: lcmp
    //   14: ifne +225 -> 239
    //   17: aload_0
    //   18: getfield 29	rx/internal/operators/TakeLastQueueProducer:deque	Ljava/util/Deque;
    //   21: invokeinterface 50 1 0
    //   26: astore 7
    //   28: aload 7
    //   30: invokeinterface 56 1 0
    //   35: ifeq +69 -> 104
    //   38: aload 7
    //   40: invokeinterface 60 1 0
    //   45: astore 8
    //   47: aload_0
    //   48: getfield 31	rx/internal/operators/TakeLastQueueProducer:subscriber	Lrx/Subscriber;
    //   51: invokevirtual 65	rx/Subscriber:isUnsubscribed	()Z
    //   54: istore 6
    //   56: iload 6
    //   58: ifeq +13 -> 71
    //   61: aload_0
    //   62: getfield 29	rx/internal/operators/TakeLastQueueProducer:deque	Ljava/util/Deque;
    //   65: invokeinterface 68 1 0
    //   70: return
    //   71: aload_0
    //   72: getfield 27	rx/internal/operators/TakeLastQueueProducer:notification	Lrx/internal/operators/NotificationLite;
    //   75: aload_0
    //   76: getfield 31	rx/internal/operators/TakeLastQueueProducer:subscriber	Lrx/Subscriber;
    //   79: aload 8
    //   81: invokevirtual 74	rx/internal/operators/NotificationLite:accept	(Lrx/Observer;Ljava/lang/Object;)Z
    //   84: pop
    //   85: goto -57 -> 28
    //   88: astore 7
    //   90: goto +24 -> 114
    //   93: astore 7
    //   95: aload 7
    //   97: aload_0
    //   98: getfield 31	rx/internal/operators/TakeLastQueueProducer:subscriber	Lrx/Subscriber;
    //   101: invokestatic 80	rx/exceptions/Exceptions:throwOrReport	(Ljava/lang/Throwable;Lrx/Observer;)V
    //   104: aload_0
    //   105: getfield 29	rx/internal/operators/TakeLastQueueProducer:deque	Ljava/util/Deque;
    //   108: invokeinterface 68 1 0
    //   113: return
    //   114: aload_0
    //   115: getfield 29	rx/internal/operators/TakeLastQueueProducer:deque	Ljava/util/Deque;
    //   118: invokeinterface 68 1 0
    //   123: aload 7
    //   125: athrow
    //   126: lload_1
    //   127: lconst_0
    //   128: lcmp
    //   129: ifne +110 -> 239
    //   132: aload_0
    //   133: invokevirtual 42	rx/internal/operators/TakeLastQueueProducer:get	()J
    //   136: lstore_1
    //   137: iconst_0
    //   138: istore_3
    //   139: lload_1
    //   140: lconst_1
    //   141: lsub
    //   142: lstore_1
    //   143: lload_1
    //   144: lconst_0
    //   145: lcmp
    //   146: iflt +54 -> 200
    //   149: aload_0
    //   150: getfield 29	rx/internal/operators/TakeLastQueueProducer:deque	Ljava/util/Deque;
    //   153: invokeinterface 83 1 0
    //   158: astore 7
    //   160: aload 7
    //   162: ifnull +38 -> 200
    //   165: aload_0
    //   166: getfield 31	rx/internal/operators/TakeLastQueueProducer:subscriber	Lrx/Subscriber;
    //   169: invokevirtual 65	rx/Subscriber:isUnsubscribed	()Z
    //   172: ifeq +4 -> 176
    //   175: return
    //   176: aload_0
    //   177: getfield 27	rx/internal/operators/TakeLastQueueProducer:notification	Lrx/internal/operators/NotificationLite;
    //   180: aload_0
    //   181: getfield 31	rx/internal/operators/TakeLastQueueProducer:subscriber	Lrx/Subscriber;
    //   184: aload 7
    //   186: invokevirtual 74	rx/internal/operators/NotificationLite:accept	(Lrx/Observer;Ljava/lang/Object;)Z
    //   189: ifeq +4 -> 193
    //   192: return
    //   193: iload_3
    //   194: iconst_1
    //   195: iadd
    //   196: istore_3
    //   197: goto -58 -> 139
    //   200: aload_0
    //   201: invokevirtual 42	rx/internal/operators/TakeLastQueueProducer:get	()J
    //   204: lstore_1
    //   205: lload_1
    //   206: iload_3
    //   207: i2l
    //   208: lsub
    //   209: lstore 4
    //   211: lload_1
    //   212: ldc2_w 43
    //   215: lcmp
    //   216: ifne +6 -> 222
    //   219: goto -87 -> 132
    //   222: aload_0
    //   223: lload_1
    //   224: lload 4
    //   226: invokevirtual 87	rx/internal/operators/TakeLastQueueProducer:compareAndSet	(JJ)Z
    //   229: ifeq -29 -> 200
    //   232: lload 4
    //   234: lconst_0
    //   235: lcmp
    //   236: ifne -104 -> 132
    //   239: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	TakeLastQueueProducer
    //   0	240	1	paramLong	long
    //   138	69	3	i	int
    //   209	24	4	l	long
    //   54	3	6	bool	boolean
    //   26	13	7	localIterator	java.util.Iterator
    //   88	1	7	localObject1	Object
    //   93	31	7	localThrowable	java.lang.Throwable
    //   158	27	7	localObject2	Object
    //   45	35	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   17	28	88	finally
    //   28	56	88	finally
    //   71	85	88	finally
    //   95	104	88	finally
    //   17	28	93	java/lang/Throwable
    //   28	56	93	java/lang/Throwable
    //   71	85	93	java/lang/Throwable
  }
  
  public void request(long paramLong)
  {
    if (get() == 9223372036854775807L) {
      return;
    }
    if (paramLong == 9223372036854775807L) {
      paramLong = getAndSet(9223372036854775807L);
    } else {
      paramLong = BackpressureUtils.getAndAddRequest(this, paramLong);
    }
    if (!this.emittingStarted) {
      return;
    }
    emit(paramLong);
  }
  
  void startEmitting()
  {
    if (!this.emittingStarted)
    {
      this.emittingStarted = true;
      emit(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.TakeLastQueueProducer
 * JD-Core Version:    0.7.0.1
 */