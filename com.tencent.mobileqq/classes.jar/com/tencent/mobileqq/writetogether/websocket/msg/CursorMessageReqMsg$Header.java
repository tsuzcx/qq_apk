package com.tencent.mobileqq.writetogether.websocket.msg;

import com.google.gson.annotations.SerializedName;

public class CursorMessageReqMsg$Header
  extends BaseHeader
{
  public String docid;
  @SerializedName("docs_type")
  public String docsType = "doc";
  public String uid;
  public String uuId;
  
  public CursorMessageReqMsg$Header(CursorMessageReqMsg paramCursorMessageReqMsg, String paramString1, String paramString2, String paramString3)
  {
    this.type = Type.CURSOR_MESSAGE;
    this.docid = paramString1;
    this.uid = paramString2;
    this.uuId = paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.CursorMessageReqMsg.Header
 * JD-Core Version:    0.7.0.1
 */