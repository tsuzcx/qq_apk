package com.tencent.mobileqq.jubao;

import android.support.annotation.NonNull;
import axas;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mini.sdk.JsonORM;
import com.tencent.mobileqq.mini.sdk.JsonORM.Column;
import java.io.Serializable;
import org.json.JSONObject;

public class JubaoMsgData
  implements Serializable
{
  @JsonORM.Column(key="msgRandom")
  public int msgRandom;
  @JsonORM.Column(key="msgSeq")
  public int msgSeq;
  @JsonORM.Column(key="msgTime")
  public int msgTime;
  @JsonORM.Column(key="result")
  public int result;
  
  public static JubaoMsgData transfer(@NonNull MessageRecord paramMessageRecord)
  {
    JubaoMsgData localJubaoMsgData = new JubaoMsgData();
    if ((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 3000))
    {
      localJubaoMsgData.msgSeq = ((int)paramMessageRecord.shmsgseq);
      return localJubaoMsgData;
    }
    int i = axas.b(paramMessageRecord.msgUid);
    localJubaoMsgData.msgSeq = (0xFFFF & (short)(int)paramMessageRecord.shmsgseq);
    localJubaoMsgData.msgTime = ((int)paramMessageRecord.time);
    localJubaoMsgData.msgRandom = i;
    return localJubaoMsgData;
  }
  
  public JSONObject toJson()
  {
    return JsonORM.toJSON(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.jubao.JubaoMsgData
 * JD-Core Version:    0.7.0.1
 */