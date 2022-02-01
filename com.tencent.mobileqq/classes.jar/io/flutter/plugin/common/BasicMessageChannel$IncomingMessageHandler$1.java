package io.flutter.plugin.common;

class BasicMessageChannel$IncomingMessageHandler$1
  implements BasicMessageChannel.Reply<T>
{
  public void reply(T paramT)
  {
    this.val$callback.reply(BasicMessageChannel.access$200(this.this$1.this$0).encodeMessage(paramT));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugin.common.BasicMessageChannel.IncomingMessageHandler.1
 * JD-Core Version:    0.7.0.1
 */