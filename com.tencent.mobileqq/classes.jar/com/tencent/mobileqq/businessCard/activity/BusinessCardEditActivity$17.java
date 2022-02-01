package com.tencent.mobileqq.businessCard.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.utils.ContactUtils;
import mqq.app.AppRuntime;

class BusinessCardEditActivity$17
  extends FriendListObserver
{
  BusinessCardEditActivity$17(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramString != null))
    {
      Object localObject1 = this.a.app;
      int i = 0;
      localObject1 = ContactUtils.b((AppRuntime)localObject1, paramString, false);
      while (i < this.a.m.getChildCount())
      {
        Object localObject2 = this.a.m.getChildAt(i);
        if (((localObject2 instanceof ViewGroup)) && ((((View)localObject2).getTag() instanceof BusinessCardEditActivity.ItemHolder)) && (paramString.equals(((BusinessCardEditActivity.ItemHolder)((View)localObject2).getTag()).a)))
        {
          localObject2 = (TextView)((View)localObject2).findViewById(2131439303);
          if (localObject2 != null) {
            ((TextView)localObject2).setText((CharSequence)localObject1);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.17
 * JD-Core Version:    0.7.0.1
 */