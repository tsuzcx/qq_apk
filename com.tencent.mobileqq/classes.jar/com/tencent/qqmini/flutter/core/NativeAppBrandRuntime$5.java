package com.tencent.qqmini.flutter.core;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import io.flutter.plugin.common.BasicMessageChannel.MessageHandler;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

class NativeAppBrandRuntime$5
  implements BasicMessageChannel.MessageHandler<ByteBuffer>
{
  NativeAppBrandRuntime$5(NativeAppBrandRuntime paramNativeAppBrandRuntime) {}
  
  public void onMessage(ByteBuffer paramByteBuffer, BasicMessageChannel.Reply<ByteBuffer> paramReply)
  {
    QMLog.w("miniapp-TISSUE", new String(paramByteBuffer.array(), Charset.forName("utf8")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.NativeAppBrandRuntime.5
 * JD-Core Version:    0.7.0.1
 */