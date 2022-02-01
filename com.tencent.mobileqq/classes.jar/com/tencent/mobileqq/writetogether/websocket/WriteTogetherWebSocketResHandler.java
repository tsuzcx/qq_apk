package com.tencent.mobileqq.writetogether.websocket;

import com.tencent.mobileqq.writetogether.api.IQQWriteTogetherService;
import com.tencent.mobileqq.writetogether.websocket.msg.BaseWriteTogetherMsg;
import com.tencent.mobileqq.writetogether.websocket.msg.WriteTogetherDecodeFactory;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import okio.ByteString;

public class WriteTogetherWebSocketResHandler
{
  private static final String jdField_a_of_type_JavaLangString = "WriteTogether." + WriteTogetherWebSocketResHandler.class.getSimpleName();
  private WriteTogetherDecodeFactory jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketMsgWriteTogetherDecodeFactory = new WriteTogetherDecodeFactory();
  
  private void b(String paramString)
  {
    String[] arrayOfString = paramString.split("\n");
    int i = 0;
    if (i < arrayOfString.length)
    {
      WriteTogetherDecodeFactory localWriteTogetherDecodeFactory = this.jdField_a_of_type_ComTencentMobileqqWritetogetherWebsocketMsgWriteTogetherDecodeFactory;
      String str = arrayOfString[i];
      if (i + 1 < arrayOfString.length)
      {
        paramString = arrayOfString[(i + 1)];
        label40:
        paramString = localWriteTogetherDecodeFactory.decode(str, paramString);
        if (paramString != null) {
          break label65;
        }
      }
      for (;;)
      {
        i += 2;
        break;
        paramString = null;
        break label40;
        label65:
        a(paramString);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.WriteTogetherWebSocketResHandler
 * JD-Core Version:    0.7.0.1
 */