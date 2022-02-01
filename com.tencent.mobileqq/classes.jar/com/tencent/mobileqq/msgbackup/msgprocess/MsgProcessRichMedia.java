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
  protected T b;
  protected MessageRecord c;
  
  public MsgProcessRichMedia(T paramT)
  {
    this.b = paramT;
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
    localHashMap.put("msgType", String.valueOf(c()));
    localHashMap.put("msgSubType", String.valueOf(paramInt));
    return localHashMap;
  }
  
  public abstract void a();
  
  protected void a(MessageRecord paramMessageRecord)
  {
    this.c = paramMessageRecord;
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
  
  public abstract List<MsgBackupResEntity> b();
  
  protected abstract int c();
  
  public void d() {}
  
  public boolean e()
  {
    return true;
  }
  
  protected MsgBackupResEntity f()
  {
    MsgBackupResEntity localMsgBackupResEntity = new MsgBackupResEntity();
    localMsgBackupResEntity.msgType = c();
    MessageRecord localMessageRecord = this.c;
    if (localMessageRecord != null)
    {
      MsgBackupUtil.a(localMessageRecord, localMsgBackupResEntity);
      return localMsgBackupResEntity;
    }
    MsgBackupUtil.a(this.b, localMsgBackupResEntity);
    return localMsgBackupResEntity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessRichMedia
 * JD-Core Version:    0.7.0.1
 */