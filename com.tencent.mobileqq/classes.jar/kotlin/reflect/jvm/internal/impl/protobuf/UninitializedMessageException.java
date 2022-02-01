package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.List;

public class UninitializedMessageException
  extends RuntimeException
{
  private final List<String> missingFields = null;
  
  public UninitializedMessageException(MessageLite paramMessageLite)
  {
    super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
  }
  
  public InvalidProtocolBufferException asInvalidProtocolBufferException()
  {
    return new InvalidProtocolBufferException(getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException
 * JD-Core Version:    0.7.0.1
 */