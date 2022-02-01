package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.jetbrains.annotations.NotNull;

class ReadInjoyWebShareHelper$ItemClickProcessor
  extends ReadInJoyShareHelperV2.BaseSheetItemClickProcessor
{
  ReadInjoyWebShareHelper$ItemClickProcessor(ReadInjoyWebShareHelper paramReadInjoyWebShareHelper) {}
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    ActionItem localActionItem = ReadInjoyWebShareHelper.a(this.a).a(ReadInjoyWebShareHelper.a(this.a), ReadInjoyWebShareHelper.b(this.a), paramInt);
    if (localActionItem == null) {
      return false;
    }
    if (localActionItem.jdField_a_of_type_Boolean)
    {
      this.a.b(localActionItem.jdField_a_of_type_JavaLangString);
      return true;
    }
    if (paramInt != 21)
    {
      if (paramInt != 26)
      {
        Object localObject;
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
                          this.a.b(localActionItem.jdField_a_of_type_JavaLangString);
                        }
                      case 7: 
                      case 6: 
                      case 5: 
                      case 4: 
                      case 1: 
                        for (;;)
                        {
                          break;
                          this.a.b(localActionItem.jdField_a_of_type_JavaLangString);
                          continue;
                          ReadInjoyWebShareHelper.b(this.a);
                          ReadInjoyWebShareHelper.a(this.a, localActionItem.jdField_a_of_type_JavaLangString, true);
                          continue;
                          ReadInjoyWebShareHelper.a(this.a).a(this.a);
                          ReadInjoyWebShareHelper.a(this.a, localActionItem.jdField_a_of_type_JavaLangString, true);
                          continue;
                          ReadInjoyWebShareHelper.a(this.a);
                          ReadInjoyWebShareHelper.a(this.a, localActionItem.jdField_a_of_type_JavaLangString, true);
                          continue;
                          ReadInjoyWebShareHelper.a(this.a).a(ReadInjoyWebShareHelper.a(this.a).c);
                          ReadInjoyWebShareHelper.a(this.a, localActionItem.jdField_a_of_type_JavaLangString, true);
                          continue;
                          ReadInjoyWebShareHelper.a(this.a).b(ReadInjoyWebShareHelper.a(this.a).c);
                          ReadInjoyWebShareHelper.a(this.a, localActionItem.jdField_a_of_type_JavaLangString, true);
                          continue;
                          ReadInjoyWebShareHelper.a(this.a).c(ReadInjoyWebShareHelper.a(this.a).c);
                          ReadInjoyWebShareHelper.a(this.a, localActionItem.jdField_a_of_type_JavaLangString, true);
                        }
                      }
                    }
                    ReadInjoyWebShareHelper.a(this.a, paramActionSheetItem);
                  }
                  else
                  {
                    this.a.b("not_care");
                  }
                }
                else if (!TextUtils.isEmpty(ReadInjoyWebShareHelper.a(this.a).e))
                {
                  localObject = AIOUtils.a(new Intent(this.a.a(), SplashActivity.class), null);
                  ((Intent)localObject).putExtra("uin", ReadInjoyWebShareHelper.a(this.a).e);
                  ((Intent)localObject).putExtra("uintype", 0);
                  this.a.a().startActivity((Intent)localObject);
                  ReadInjoyWebShareHelper.a(this.a, localActionItem.jdField_a_of_type_JavaLangString, true);
                }
              }
              else {
                this.a.b("unfollow");
              }
            }
            else if (!TextUtils.isEmpty(ReadInjoyWebShareHelper.a(this.a).e))
            {
              localObject = new ActivityURIRequest(this.a.a(), "/pubaccount/detail");
              ((ActivityURIRequest)localObject).extra().putString("uin", ReadInjoyWebShareHelper.a(this.a).e);
              ((ActivityURIRequest)localObject).extra().putBoolean("from_js", true);
              QRoute.startUri((URIRequest)localObject, null);
              ReadInjoyWebShareHelper.a(this.a, localActionItem.jdField_a_of_type_JavaLangString, true);
            }
          }
          else if (!TextUtils.isEmpty(ReadInjoyWebShareHelper.a(this.a).c))
          {
            TeamWorkConvertUtils.a(1, 3);
            TeamWorkConvertUtils.a(ReadInjoyWebShareHelper.a(this.a).c, ReadInjoyWebShareHelper.a(this.a).jdField_a_of_type_JavaLangString);
            ReadInjoyWebShareHelper.a(this.a, localActionItem.jdField_a_of_type_JavaLangString, true);
          }
        }
        else
        {
          if (!TextUtils.isEmpty(ReadInjoyWebShareHelper.a(this.a).e))
          {
            localObject = (IAddFriendApi)QRoute.api(IAddFriendApi.class);
            Activity localActivity = this.a.a();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(ReadInjoyWebShareHelper.a(this.a).e);
            localStringBuilder.append("");
            localObject = ((IAddFriendApi)localObject).startAddFriend(localActivity, 1, localStringBuilder.toString(), null, 3096, 1, ReadInjoyWebShareHelper.a(this.a).f, null, null, null, null);
            ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.a.a(), (Intent)localObject);
          }
          ReadInjoyWebShareHelper.a(this.a, localActionItem.jdField_a_of_type_JavaLangString, true);
        }
      }
      else if (!TextUtils.isEmpty(ReadInjoyWebShareHelper.a(this.a).c))
      {
        this.a.a.d(ReadInjoyWebShareHelper.a(this.a).c, new ReadInjoyWebShareHelper.ItemClickProcessor.1(this, localActionItem));
      }
    }
    else
    {
      ReadInjoyWebShareHelper.a(this.a).c();
      ReadInjoyWebShareHelper.a(this.a, localActionItem.jdField_a_of_type_JavaLangString, true);
    }
    return super.a(paramInt, paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ReadInjoyWebShareHelper.ItemClickProcessor
 * JD-Core Version:    0.7.0.1
 */