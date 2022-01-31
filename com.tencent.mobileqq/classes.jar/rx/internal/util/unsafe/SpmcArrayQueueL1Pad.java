package rx.internal.util.unsafe;

abstract class SpmcArrayQueueL1Pad<E>
  extends ConcurrentCircularArrayQueue<E>
{
  long p10;
  long p11;
  long p12;
  long p13;
  long p14;
  long p15;
  long p16;
  long p30;
  long p31;
  long p32;
  long p33;
  long p34;
  long p35;
  long p36;
  long p37;
  
  public SpmcArrayQueueL1Pad(int paramInt)
  {
    super(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.util.unsafe.SpmcArrayQueueL1Pad
 * JD-Core Version:    0.7.0.1
 */