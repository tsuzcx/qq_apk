package com.tencent.mobileqq.multimsg;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashMap;

public abstract interface IMultiMsgRichProcessor
{
  public abstract void a(MultiMsgRequest paramMultiMsgRequest, HashMap<String, ArrayList<MessageRecord>> paramHashMap, IMultiMsgRichUploadCallback paramIMultiMsgRichUploadCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.IMultiMsgRichProcessor
 * JD-Core Version:    0.7.0.1
 */