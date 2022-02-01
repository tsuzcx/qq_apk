package com.tencent.mobileqq.msgbackup.msgprocess;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract class MsgProcessRichMedia<T extends MessageRecord>
  extends MsgProcessConstant
{
  protected T a;
  protected MessageRecord b;
  
  public MsgProcessRichMedia(T paramT)
  {
    this.a = paramT;
  }
  
  protected abstract int a();
  
  protected MsgBackupResEntity a()
  {
    MsgBackupResEntity localMsgBackupResEntity = new MsgBackupResEntity();
    localMsgBackupResEntity.msgType = a();
    MessageRecord localMessageRecord = this.b;
    if (localMessageRecord != null)
    {
      MsgBackupUtil.a(localMessageRecord, localMsgBackupResEntity);
      return localMsgBackupResEntity;
    }
    MsgBackupUtil.a(this.a, localMsgBackupResEntity);
    return localMsgBackupResEntity;
  }
  
  protected String a(Map paramMap)
  {
    try
    {
      paramMap = new JSONObject(paramMap).toString();
      return paramMap;
    }
    catch (Exception paramMap)
    {
      label14:
      break label14;
    }
    return null;
  }
  
  protected HashMap<String, String> a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", String.valueOf(a()));
    localHashMap.put("msgSubType", String.valueOf(paramInt));
    return localHashMap;
  }
  
  public abstract List<MsgBackupResEntity> a();
  
  public abstract void a();
  
  protected void a(MessageRecord paramMessageRecord)
  {
    this.b = paramMessageRecord;
  }
  
  protected void a(String paramString, MsgBackupResEntity paramMsgBackupResEntity)
  {
    try
    {
      new File(paramString);
      paramMsgBackupResEntity.fileSize = new File(paramString).length();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessRichMedia
 * JD-Core Version:    0.7.0.1
 */