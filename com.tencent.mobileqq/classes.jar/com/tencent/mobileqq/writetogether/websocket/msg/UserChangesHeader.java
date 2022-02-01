package com.tencent.mobileqq.writetogether.websocket.msg;

import com.google.gson.annotations.SerializedName;

public class UserChangesHeader
  extends BaseHeader
{
  @SerializedName("base_rev")
  public int baseRev;
  @SerializedName("code_ver")
  public int codeVer = 0;
  public String cookie = "";
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
  
  public UserChangesHeader()
  {
    this.type = Type.USER_CHANGES;
  }
  
  public UserChangesHeader(String paramString1, String paramString2, int paramInt)
  {
    this();
    this.docid = paramString1;
    this.uid = paramString2;
    this.baseRev = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.UserChangesHeader
 * JD-Core Version:    0.7.0.1
 */