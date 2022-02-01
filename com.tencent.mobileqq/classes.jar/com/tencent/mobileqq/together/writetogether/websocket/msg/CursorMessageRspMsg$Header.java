package com.tencent.mobileqq.together.writetogether.websocket.msg;

import com.google.gson.annotations.SerializedName;

public class CursorMessageRspMsg$Header
  extends BaseHeader
{
  public String docid;
  @SerializedName("docs_type")
  public String docsType = "doc";
  public String uid;
  public String uuId;
  
  public CursorMessageRspMsg$Header(CursorMessageRspMsg paramCursorMessageRspMsg, String paramString1, String paramString2, String paramString3)
  {
    this.type = BaseWriteTogetherMsg.Type.CURSOR_MESSAGE;
    this.docid = paramString1;
    this.uid = paramString2;
    this.uuId = paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.msg.CursorMessageRspMsg.Header
 * JD-Core Version:    0.7.0.1
 */