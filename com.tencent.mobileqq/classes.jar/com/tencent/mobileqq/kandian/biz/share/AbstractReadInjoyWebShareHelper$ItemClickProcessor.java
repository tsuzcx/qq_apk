package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.jetbrains.annotations.NotNull;

class AbstractReadInjoyWebShareHelper$ItemClickProcessor
  extends ReadInJoyShareHelperV2.BaseSheetItemClickProcessor
{
  AbstractReadInjoyWebShareHelper$ItemClickProcessor(AbstractReadInjoyWebShareHelper paramAbstractReadInjoyWebShareHelper) {}
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    ActionItem localActionItem = AbstractReadInjoyWebShareHelper.c(this.a).a(AbstractReadInjoyWebShareHelper.a(this.a), AbstractReadInjoyWebShareHelper.b(this.a), paramInt);
    if (localActionItem == null) {
      return false;
    }
    Object localObject = this.a;
    ((AbstractReadInjoyWebShareHelper)localObject).a(paramInt, true, AbstractReadInjoyWebShareHelper.d((AbstractReadInjoyWebShareHelper)localObject));
    if (localActionItem.c)
    {
      AbstractReadInjoyWebShareHelper.a(this.a, localActionItem.a);
      return true;
    }
    if (paramInt != 21)
    {
      if (paramInt != 26)
      {
        if (paramInt != 35)
        {
          if (paramInt != 68)
          {
            if (paramInt != 31)
            {
              if (paramInt != 32)
              {
                if (paramInt != 37)
                {
                  if (paramInt != 38)
                  {
                    if ((paramInt != 72) && (paramInt != 73)) {
                      switch (paramInt)
                      {
                      default: 
                        switch (paramInt)
                        {
                        default: 
                          AbstractReadInjoyWebShareHelper.a(this.a, localActionItem.a);
                        }
                      case 7: 
                      case 6: 
                      case 5: 
                      case 4: 
                      case 1: 
                        for (;;)
                        {
                          break;
                          AbstractReadInjoyWebShareHelper.a(this.a, localActionItem.a);
                          continue;
                          AbstractReadInjoyWebShareHelper.g(this.a);
                          this.a.a(localActionItem.a, true);
                          continue;
                          AbstractReadInjoyWebShareHelper.c(this.a).a(this.a);
                          this.a.a(localActionItem.a, true);
                          continue;
                          AbstractReadInjoyWebShareHelper.f(this.a);
                          this.a.a(localActionItem.a, true);
                          continue;
                          AbstractReadInjoyWebShareHelper.c(this.a).a(AbstractReadInjoyWebShareHelper.e(this.a).c);
                          this.a.a(localActionItem.a, true);
                          continue;
                          AbstractReadInjoyWebShareHelper.c(this.a).b(AbstractReadInjoyWebShareHelper.e(this.a).c);
                          this.a.a(localActionItem.a, true);
                          continue;
                          AbstractReadInjoyWebShareHelper.c(this.a).c(AbstractReadInjoyWebShareHelper.e(this.a).c);
                          this.a.a(localActionItem.a, true);
                        }
                      }
                    }
                    AbstractReadInjoyWebShareHelper.a(this.a, paramActionSheetItem);
                  }
                  else
                  {
                    AbstractReadInjoyWebShareHelper.a(this.a, "not_care");
                  }
                }
                else if (!TextUtils.isEmpty(AbstractReadInjoyWebShareHelper.e(this.a).e))
                {
                  localObject = AIOUtils.a(new Intent(this.a.b(), SplashActivity.class), null);
                  ((Intent)localObject).putExtra("uin", AbstractReadInjoyWebShareHelper.e(this.a).e);
                  ((Intent)localObject).putExtra("uintype", 0);
                  this.a.b().startActivity((Intent)localObject);
                  this.a.a(localActionItem.a, true);
                }
              }
              else {
                AbstractReadInjoyWebShareHelper.a(this.a, "unfollow");
              }
            }
            else if (!TextUtils.isEmpty(AbstractReadInjoyWebShareHelper.e(this.a).e))
            {
              localObject = new ActivityURIRequest(this.a.b(), "/pubaccount/detail");
              ((ActivityURIRequest)localObject).extra().putString("uin", AbstractReadInjoyWebShareHelper.e(this.a).e);
              ((ActivityURIRequest)localObject).extra().putBoolean("from_js", true);
              QRoute.startUri((URIRequest)localObject, null);
              this.a.a(localActionItem.a, true);
            }
          }
          else if (!TextUtils.isEmpty(AbstractReadInjoyWebShareHelper.e(this.a).c))
          {
            TeamWorkConvertUtils.a(1, 3);
            TeamWorkConvertUtils.a(AbstractReadInjoyWebShareHelper.e(this.a).c, AbstractReadInjoyWebShareHelper.e(this.a).a);
            this.a.a(localActionItem.a, true);
          }
        }
        else
        {
          if (!TextUtils.isEmpty(AbstractReadInjoyWebShareHelper.e(this.a).e))
          {
            localObject = (IAddFriendApi)QRoute.api(IAddFriendApi.class);
            Activity localActivity = this.a.b();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(AbstractReadInjoyWebShareHelper.e(this.a).e);
            localStringBuilder.append("");
            localObject = ((IAddFriendApi)localObject).startAddFriend(localActivity, 1, localStringBuilder.toString(), null, 3096, 1, AbstractReadInjoyWebShareHelper.e(this.a).f, null, null, null, null);
            ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.a.b(), (Intent)localObject);
          }
          this.a.a(localActionItem.a, true);
        }
      }
      else if (!TextUtils.isEmpty(AbstractReadInjoyWebShareHelper.e(this.a).c))
      {
        localObject = this.a;
        ((AbstractReadInjoyWebShareHelper)localObject).a(AbstractReadInjoyWebShareHelper.e((AbstractReadInjoyWebShareHelper)localObject).c, new AbstractReadInjoyWebShareHelper.ItemClickProcessor.1(this, localActionItem));
      }
    }
    else
    {
      AbstractReadInjoyWebShareHelper.c(this.a).e();
      this.a.a(localActionItem.a, true);
    }
    return super.a(paramInt, paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper.ItemClickProcessor
 * JD-Core Version:    0.7.0.1
 */