package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

final class GroupVideoChatAppInfo$4
  implements DialogInterface.OnClickListener
{
  GroupVideoChatAppInfo$4(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, boolean paramBoolean, Map paramMap) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    GroupVideoChatAppInfo.enterNewGroupVideo(this.a, this.b, this.c, this.d, false, this.e, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.GroupVideoChatAppInfo.4
 * JD-Core Version:    0.7.0.1
 */