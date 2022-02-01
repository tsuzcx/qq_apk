package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

public class InvalidProtocolBufferException
  extends IOException
{
  private MessageLite unfinishedMessage = null;
  
  public InvalidProtocolBufferException(String paramString)
  {
    super(paramString);
  }
  
  static InvalidProtocolBufferException invalidEndTag()
  {
    return new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
  }
  
  static InvalidProtocolBufferException invalidTag()
  {
    return new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
  }
  
  static InvalidProtocolBufferException invalidUtf8()
  {
    return new InvalidProtocolBufferException("Protocol message had invalid UTF-8.");
  }
  
  static InvalidProtocolBufferException invalidWireType()
  {
    return new InvalidProtocolBufferException("Protocol message tag had invalid wire type.");
  }
  
  static InvalidProtocolBufferException malformedVarint()
  {
    return new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
  }
  
  static InvalidProtocolBufferException negativeSize()
  {
    return new InvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static InvalidProtocolBufferException recursionLimitExceeded()
  {
    return new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
  
  static InvalidProtocolBufferException sizeLimitExceeded()
  {
    return new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
  }
  
  static InvalidProtocolBufferException truncatedMessage()
  {
    return new InvalidProtocolBufferException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }
  
  public MessageLite getUnfinishedMessage()
  {
    return this.unfinishedMessage;
  }
  
  public InvalidProtocolBufferException setUnfinishedMessage(MessageLite paramMessageLite)
  {
    this.unfinishedMessage = paramMessageLite;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException
 * JD-Core Version:    0.7.0.1
 */