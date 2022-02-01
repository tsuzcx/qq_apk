package com.tencent.mobileqq.together.writetogether.websocket.msg;

import com.google.gson.annotations.SerializedName;

public class CommitErrorMsg$Header
  extends BaseHeader
{
  @SerializedName("base_rev")
  public int baseRev;
  public String docid;
  @SerializedName("session_type")
  public int sessionType;
  @SerializedName("task_id")
  public int taskId;
  public long uid;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.msg.CommitErrorMsg.Header
 * JD-Core Version:    0.7.0.1
 */