package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.selectmember.ResultRecord;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ForwardArkFlashChatMsgOption
  extends ForwardBaseOption
{
  public ForwardArkFlashChatMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected boolean a(String paramString1, int paramInt, String paramString2)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.a = paramInt;
    localSessionInfo.b = paramString1;
    localSessionInfo.c = paramString2;
    paramString1 = this.t.getString("forward_flashchat_rawcontent");
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    paramString2 = new ArkFlashChatMessage();
    paramString2.fromAppXml(paramString1);
    paramInt = this.t.getInt("KEY_MSG_FORWARD_ID");
    ChatActivityFacade.a(this.q, localSessionInfo, paramString2, paramInt);
    return true;
  }
  
  protected void c()
  {
    if (ag()) {
      this.C.add(e);
    }
    if (ah()) {
      this.C.add(d);
    }
    if (ai()) {
      this.C.add(c);
    }
  }
  
  protected boolean f()
  {
    if (K())
    {
      Iterator localIterator = M().iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        a(localResultRecord.uin, localResultRecord.getUinType(), localResultRecord.groupUin);
      }
      return super.f();
    }
    o();
    return super.f();
  }
  
  public String n()
  {
    if (TextUtils.isEmpty(this.u))
    {
      this.u = this.t.getString("forward_ark_app_prompt");
      if (TextUtils.isEmpty(this.u)) {
        this.u = this.t.getString("forward_ark_app_desc");
      }
    }
    return this.u;
  }
  
  protected boolean o()
  {
    int i = this.t.getInt("uintype");
    return a(this.t.getString("uin"), i, this.t.getString("troop_uin"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardArkFlashChatMsgOption
 * JD-Core Version:    0.7.0.1
 */