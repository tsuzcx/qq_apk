package com.tencent.mobileqq.together.writetogether.websocket.msg;

import com.google.gson.annotations.SerializedName;

public class HeartBeatMsg$Header
  extends BaseHeader
{
  @SerializedName("code_ver")
  public int codeVer = 0;
  public String docid;
  @SerializedName("docs_type")
  public String docsType = "doc";
  public String dver = "2.1.0";
  @SerializedName("task_id")
  public int taskId = (int)(Math.random() * 2147483647.0D);
  public String uid;
  public String wl = "0";
  
  public HeartBeatMsg$Header()
  {
    this.type = BaseWriteTogetherMsg.Type.HEART_BEAT;
  }
  
  public HeartBeatMsg$Header(String paramString1, String paramString2)
  {
    this();
    this.docid = paramString1;
    this.uid = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.msg.HeartBeatMsg.Header
 * JD-Core Version:    0.7.0.1
 */