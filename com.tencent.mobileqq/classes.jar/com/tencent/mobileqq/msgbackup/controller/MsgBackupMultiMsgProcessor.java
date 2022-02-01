package com.tencent.mobileqq.msgbackup.controller;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MsgBackupMultiMsgProcessor
  implements IMsgBackupRichProcessor
{
  public static String a = "MsgBackup_MsgBackupMultiMsgProcessor";
  
  public MsgBackupMultiMsgProcessor(BaseQQAppInterface paramBaseQQAppInterface) {}
  
  public static String a(String paramString, MessageRecord paramMessageRecord)
  {
    String str = ((IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class)).handleMultiMsg(paramMessageRecord);
    paramMessageRecord = new JSONObject();
    try
    {
      paramMessageRecord.put("selfuin", paramString);
      paramMessageRecord.put("uuid", str);
      paramMessageRecord.put("msgType", 4);
      paramMessageRecord.put("msgSubType", 10);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return paramMessageRecord.toString();
  }
  
  public static List<MessageRecord> a(HashMap<String, ArrayList<MessageRecord>> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll((Collection)paramHashMap.get((String)localIterator.next()));
    }
    return localArrayList;
  }
  
  public static String c(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    if ((paramMsgBackupResEntity != null) && (!TextUtils.isEmpty(paramMsgBackupResEntity.extraDataStr))) {
      try
      {
        paramMessageRecord = MsgBackupUtil.d(new JSONObject(paramMsgBackupResEntity.extraDataStr).optString("uuid"));
        return paramMessageRecord;
      }
      catch (JSONException paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
      }
    }
    return "";
  }
  
  public ResDownloadObject a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    ResDownloadObject localResDownloadObject = new ResDownloadObject();
    localResDownloadObject.b = b(paramMessageRecord, paramMsgBackupResEntity);
    localResDownloadObject.a = true;
    return localResDownloadObject;
  }
  
  public void a(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList) {}
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof ChatMessage)) {
      return ((IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class)).isMultiMsg((ChatMessage)paramMessageRecord);
    }
    return false;
  }
  
  public boolean a(MsgBackupResEntity paramMsgBackupResEntity)
  {
    return paramMsgBackupResEntity.msgType == 4;
  }
  
  public String b(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    if ((paramMsgBackupResEntity != null) && (!TextUtils.isEmpty(paramMsgBackupResEntity.extraDataStr))) {
      try
      {
        paramMessageRecord = MsgBackupUtil.d(new JSONObject(paramMsgBackupResEntity.extraDataStr).optString("uuid"));
        return paramMessageRecord;
      }
      catch (JSONException paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
      }
    }
    return "";
  }
  
  public void b(MessageRecord paramMessageRecord, List<MsgBackupResEntity> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupMultiMsgProcessor
 * JD-Core Version:    0.7.0.1
 */