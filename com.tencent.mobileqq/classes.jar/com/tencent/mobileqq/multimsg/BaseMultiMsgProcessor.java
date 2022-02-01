package com.tencent.mobileqq.multimsg;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseMultiMsgProcessor
  implements IMultiMsgRichProcessor
{
  QQAppInterface a;
  
  public BaseMultiMsgProcessor(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(MultiMsgRequest paramMultiMsgRequest, HashMap<String, ArrayList<MessageRecord>> paramHashMap, IMultiMsgRichUploadCallback paramIMultiMsgRichUploadCallback) {}
  
  public boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.BaseMultiMsgProcessor
 * JD-Core Version:    0.7.0.1
 */