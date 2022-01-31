package com.tencent.mobileqq.troop.utils;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopTopicMgr$GroupPostElemInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public long bid;
  public String cid;
  public String pid;
  public int trans_type;
  
  public TroopTopicMgr$GroupPostElemInfo(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    this.trans_type = paramInt;
    this.bid = paramLong;
    this.pid = paramString1;
    this.cid = paramString2;
  }
  
  public TroopTopicMgr$GroupPostElemInfo(int paramInt, String paramString)
  {
    this.trans_type = paramInt;
    try
    {
      paramString = new JSONObject(paramString);
      this.bid = paramString.optLong("bid");
      this.pid = paramString.optString("pid");
      this.cid = paramString.optString("cid");
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(".troop.troop_topic.TroopTopicMgr", 2, QLog.getStackTraceString(paramString));
    }
  }
  
  public TroopTopicMgr$GroupPostElemInfo(GroupPostElemInfo paramGroupPostElemInfo)
  {
    this.trans_type = paramGroupPostElemInfo.trans_type;
    this.bid = paramGroupPostElemInfo.bid;
    this.pid = paramGroupPostElemInfo.pid;
    this.cid = paramGroupPostElemInfo.cid;
  }
  
  public String toString()
  {
    return new StringBuilder().append("GroupPostElemInfo: type = ").append(this.trans_type).append(", bid = ").append(this.bid).append(", pid = ").append(this.pid).append(", cid = ").append(this.cid).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopTopicMgr.GroupPostElemInfo
 * JD-Core Version:    0.7.0.1
 */