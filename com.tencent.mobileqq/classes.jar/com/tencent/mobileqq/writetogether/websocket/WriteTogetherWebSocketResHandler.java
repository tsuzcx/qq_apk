package com.tencent.mobileqq.writetogether.websocket;

import com.tencent.mobileqq.writetogether.api.IQQWriteTogetherService;
import com.tencent.mobileqq.writetogether.websocket.msg.BaseWriteTogetherMsg;
import com.tencent.mobileqq.writetogether.websocket.msg.WriteTogetherDecodeFactory;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import okio.ByteString;

public class WriteTogetherWebSocketResHandler
{
  private static final String a;
  private WriteTogetherDecodeFactory b = new WriteTogetherDecodeFactory();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WriteTogether.");
    localStringBuilder.append(WriteTogetherWebSocketResHandler.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  private void b(String paramString)
  {
    String[] arrayOfString = paramString.split("\n");
    int i = 0;
    while (i < arrayOfString.length)
    {
      WriteTogetherDecodeFactory localWriteTogetherDecodeFactory = this.b;
      String str = arrayOfString[i];
      int j = i + 1;
      if (j < arrayOfString.length) {
        paramString = arrayOfString[j];
      } else {
        paramString = null;
      }
      paramString = localWriteTogetherDecodeFactory.decode(str, paramString);
      if (paramString != null) {
        a(paramString);
      }
      i += 2;
    }
  }
  
  void a(BaseWriteTogetherMsg paramBaseWriteTogetherMsg)
  {
    ((IQQWriteTogetherService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQWriteTogetherService.class, "")).notify(paramBaseWriteTogetherMsg);
  }
  
  public void a(String paramString)
  {
    b(paramString);
  }
  
  public void a(ByteString paramByteString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.WriteTogetherWebSocketResHandler
 * JD-Core Version:    0.7.0.1
 */