package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Hashtable;

public class JumpActionLegacy$CustomHeadObserver
  extends AvatarObserver
{
  private final JumpAction b;
  
  public JumpActionLegacy$CustomHeadObserver(JumpActionLegacy paramJumpActionLegacy, JumpAction paramJumpAction)
  {
    this.b = paramJumpAction;
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.u != null))
    {
      if (!this.a.u.containsKey(paramString)) {
        return;
      }
      this.a.u.remove(paramString);
      if (this.a.u.size() == 0) {
        this.a.H.removeObserver(this.a.I);
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.E());
      ((StringBuilder)localObject).append("&uin=");
      ((StringBuilder)localObject).append(paramString);
      localObject = Uri.parse(((StringBuilder)localObject).toString());
      localObject = new Intent((String)this.a.f.get("callback_name"), (Uri)localObject);
      this.a.b.sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("download head ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" success. Send broadcast to ");
        ((StringBuilder)localObject).append((String)this.a.f.get("callback_name"));
        QLog.i("JumpAction", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpActionLegacy.CustomHeadObserver
 * JD-Core Version:    0.7.0.1
 */