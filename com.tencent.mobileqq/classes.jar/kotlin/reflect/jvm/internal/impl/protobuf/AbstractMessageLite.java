package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.OutputStream;

public abstract class AbstractMessageLite
  implements MessageLite
{
  protected int memoizedHashCode = 0;
  
  UninitializedMessageException newUninitializedMessageException()
  {
    return new UninitializedMessageException(this);
  }
  
  public void writeDelimitedTo(OutputStream paramOutputStream)
  {
    int i = getSerializedSize();
    paramOutputStream = CodedOutputStream.newInstance(paramOutputStream, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(i) + i));
    paramOutputStream.writeRawVarint32(i);
    writeTo(paramOutputStream);
    paramOutputStream.flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite
 * JD-Core Version:    0.7.0.1
 */