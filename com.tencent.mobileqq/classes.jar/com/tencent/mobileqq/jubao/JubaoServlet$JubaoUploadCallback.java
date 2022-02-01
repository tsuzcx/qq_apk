package com.tencent.mobileqq.jubao;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import tencent.im.msg.im_msg_body.RichText;

class JubaoServlet$JubaoUploadCallback
  implements UpCallBack
{
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult.a == 0)
    {
      paramSendResult = paramSendResult.c;
      JubaoIPCServer.a().a(paramSendResult);
      return;
    }
    JubaoIPCServer.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jubao.JubaoServlet.JubaoUploadCallback
 * JD-Core Version:    0.7.0.1
 */