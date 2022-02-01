package com.tencent.qidian.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.api.IQidianApi;
import mqq.app.MobileQQ;

public class QidianApiImpl
  implements IQidianApi
{
  public static final String TAG = "QidianServiceImpl";
  
  public Intent getProfileCardIntent(Context paramContext, AllInOne paramAllInOne)
  {
    Intent localIntent1 = null;
    if (paramAllInOne == null) {
      return null;
    }
    if (BmqqSegmentUtil.c(paramAllInOne.uin))
    {
      localIntent1 = new Intent(paramContext, QidianProfileCardActivity.class);
      localIntent1.putExtra("AllInOne", paramAllInOne);
    }
    Intent localIntent2 = localIntent1;
    if (localIntent1 == null)
    {
      Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
      localIntent2 = localIntent1;
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        if ((!CrmUtils.a((BaseQQAppInterface)localObject, paramAllInOne.uin)) && (!QidianManager.a((BaseQQAppInterface)localObject, paramAllInOne.uin)))
        {
          localIntent2 = localIntent1;
          if (!QidianManager.a((QQAppInterface)localObject, paramAllInOne.uin)) {}
        }
        else
        {
          boolean bool;
          if ((!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof ChatActivity))) {
            bool = false;
          } else {
            bool = true;
          }
          localIntent2 = CrmUtils.a(paramContext, null, paramAllInOne.uin, bool, -1, false, -1);
        }
      }
    }
    return localIntent2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.api.impl.QidianApiImpl
 * JD-Core Version:    0.7.0.1
 */