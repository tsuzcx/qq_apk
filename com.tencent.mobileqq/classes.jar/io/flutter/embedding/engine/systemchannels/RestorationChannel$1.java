package io.flutter.embedding.engine.systemchannels;

import io.flutter.Log;
import io.flutter.plugin.common.MethodChannel.Result;

class RestorationChannel$1
  implements MethodChannel.Result
{
  RestorationChannel$1(RestorationChannel paramRestorationChannel, byte[] paramArrayOfByte) {}
  
  public void error(String paramString1, String paramString2, Object paramObject)
  {
    paramObject = new StringBuilder();
    paramObject.append("Error ");
    paramObject.append(paramString1);
    paramObject.append(" while sending restoration data to framework: ");
    paramObject.append(paramString2);
    Log.e("RestorationChannel", paramObject.toString());
  }
  
  public void notImplemented() {}
  
  public void success(Object paramObject)
  {
    RestorationChannel.access$002(this.this$0, this.val$data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.RestorationChannel.1
 * JD-Core Version:    0.7.0.1
 */