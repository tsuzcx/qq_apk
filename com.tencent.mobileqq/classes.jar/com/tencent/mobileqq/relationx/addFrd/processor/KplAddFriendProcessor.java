package com.tencent.mobileqq.relationx.addFrd.processor;

import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.processor.BaseAddFriendProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.KplHelper;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

@KeepClassConstructor
public class KplAddFriendProcessor
  extends BaseAddFriendProcessor
{
  public KplAddFriendProcessor(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void a(Intent paramIntent, Activity paramActivity, String paramString, int paramInt)
  {
    if (paramActivity == null) {
      return;
    }
    if ((!paramIntent.hasExtra("param_wzry_data")) && (KplHelper.a((QQAppInterface)this.a, paramActivity, paramString, paramInt)))
    {
      paramActivity = KplRoleInfo.WZRYUIinfo.buildNickName(paramActivity.getIntent().getStringExtra("nick_name"), KplHelper.a((QQAppInterface)this.a, paramString));
      paramString = KplRoleInfo.WZRYUIinfo.createInfo(paramString, paramActivity, KplHelper.a((QQAppInterface)this.a), 0, 0);
      if (paramString != null)
      {
        paramIntent.putExtra("param_wzry_data", paramString);
        paramIntent.putExtra("nick_name", paramActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.addFrd.processor.KplAddFriendProcessor
 * JD-Core Version:    0.7.0.1
 */