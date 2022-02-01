package com.tencent.mobileqq.multimsg;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashMap;

public class PttMultiMsgProcessor
  extends BaseMultiMsgProcessor
{
  public PttMultiMsgProcessor(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a(MultiMsgRequest paramMultiMsgRequest, HashMap<String, ArrayList<MessageRecord>> paramHashMap, IMultiMsgRichUploadCallback paramIMultiMsgRichUploadCallback)
  {
    super.a(paramMultiMsgRequest, paramHashMap, paramIMultiMsgRichUploadCallback);
    paramIMultiMsgRichUploadCallback.a(0, 4, paramMultiMsgRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.PttMultiMsgProcessor
 * JD-Core Version:    0.7.0.1
 */