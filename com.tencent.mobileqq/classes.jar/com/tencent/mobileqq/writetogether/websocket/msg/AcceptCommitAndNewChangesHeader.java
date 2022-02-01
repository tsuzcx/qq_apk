package com.tencent.mobileqq.writetogether.websocket.msg;

import com.google.gson.annotations.SerializedName;

public class AcceptCommitAndNewChangesHeader
  extends BaseHeader
{
  @SerializedName("base_rev")
  public int baseRev;
  public String docid;
  @SerializedName("new_rev")
  public int newRev;
  @SerializedName("session_type")
  public int sessionType;
  @SerializedName("task_id")
  public int taskId;
  public String uid;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.AcceptCommitAndNewChangesHeader
 * JD-Core Version:    0.7.0.1
 */