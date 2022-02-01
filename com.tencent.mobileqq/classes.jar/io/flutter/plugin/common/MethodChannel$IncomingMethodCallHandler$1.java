package io.flutter.plugin.common;

class MethodChannel$IncomingMethodCallHandler$1
  implements MethodChannel.Result
{
  MethodChannel$IncomingMethodCallHandler$1(MethodChannel.IncomingMethodCallHandler paramIncomingMethodCallHandler, BinaryMessenger.BinaryReply paramBinaryReply) {}
  
  public void error(String paramString1, String paramString2, Object paramObject)
  {
    this.val$reply.reply(MethodChannel.access$000(this.this$1.this$0).encodeErrorEnvelope(paramString1, paramString2, paramObject));
  }
  
  public void notImplemented()
  {
    this.val$reply.reply(null);
  }
  
  public void success(Object paramObject)
  {
    this.val$reply.reply(MethodChannel.access$000(this.this$1.this$0).encodeSuccessEnvelope(paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.common.MethodChannel.IncomingMethodCallHandler.1
 * JD-Core Version:    0.7.0.1
 */