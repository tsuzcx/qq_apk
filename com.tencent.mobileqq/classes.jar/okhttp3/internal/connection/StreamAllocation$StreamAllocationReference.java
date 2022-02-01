package okhttp3.internal.connection;

import java.lang.ref.WeakReference;

public final class StreamAllocation$StreamAllocationReference
  extends WeakReference<StreamAllocation>
{
  public final Object callStackTrace;
  
  StreamAllocation$StreamAllocationReference(StreamAllocation paramStreamAllocation, Object paramObject)
  {
    super(paramStreamAllocation);
    this.callStackTrace = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.connection.StreamAllocation.StreamAllocationReference
 * JD-Core Version:    0.7.0.1
 */