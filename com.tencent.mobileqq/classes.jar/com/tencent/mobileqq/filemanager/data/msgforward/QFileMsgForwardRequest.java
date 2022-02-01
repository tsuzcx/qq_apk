package com.tencent.mobileqq.filemanager.data.msgforward;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class QFileMsgForwardRequest
{
  public abstract String a();
  
  public abstract void a(int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2);
  
  public abstract void a(String paramString, List<MessageRecord> paramList, MessageRecord paramMessageRecord, int paramInt);
  
  protected void a(HashMap<String, ArrayList<MessageRecord>> paramHashMap1, HashMap<String, ArrayList<MessageRecord>> paramHashMap2) {}
  
  public abstract String b();
  
  public abstract int c();
  
  public abstract HashMap<String, ArrayList<MessageRecord>> d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.msgforward.QFileMsgForwardRequest
 * JD-Core Version:    0.7.0.1
 */