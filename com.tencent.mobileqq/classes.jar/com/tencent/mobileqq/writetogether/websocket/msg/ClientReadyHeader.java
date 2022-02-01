package com.tencent.mobileqq.writetogether.websocket.msg;

import com.google.gson.annotations.SerializedName;

public class ClientReadyHeader
  extends BaseHeader
{
  @SerializedName("base_rev")
  public int baseRev;
  @SerializedName("code_ver")
  public int codeVer = 0;
  public String docid;
  @SerializedName("docs_type")
  public String docsType = "doc";
  public String dver = "2.1.0";
  public int gray;
  @SerializedName("session_type")
  public int sessionType;
  @SerializedName("task_id")
  public int taskId = (int)(Math.random() * 2147483647.0D);
  public String uid;
  public String wl = "0";
  
  public ClientReadyHeader()
  {
    this.type = Type.CLIENT_READY;
  }
  
  public ClientReadyHeader(String paramString1, String paramString2, long paramLong, int paramInt, String paramString3)
  {
    this();
    this.uid = paramString1;
    this.docid = paramString2;
    this.groupCode = paramLong;
    this.baseRev = paramInt;
    this.sig = paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.ClientReadyHeader
 * JD-Core Version:    0.7.0.1
 */