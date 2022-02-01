package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

final class GroupVideoChatAppInfo$2
  implements DialogInterface.OnClickListener
{
  GroupVideoChatAppInfo$2(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean, Map paramMap) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.a(-1034L, this.a, this.b, this.c, this.d);
    GroupVideoChatAppInfo.enterNewGroupVideo(this.a, this.b, this.e, this.f, this.g, false, this.h);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.GroupVideoChatAppInfo.2
 * JD-Core Version:    0.7.0.1
 */