package com.tencent.mobileqq.businessCard.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.utils.ContactUtils;

class BusinessCardEditActivity$17
  extends FriendListObserver
{
  BusinessCardEditActivity$17(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramString != null))
    {
      String str = ContactUtils.d(this.a.app, paramString, false);
      int i = 0;
      while (i < this.a.c.getChildCount())
      {
        Object localObject = this.a.c.getChildAt(i);
        if (((localObject instanceof ViewGroup)) && ((((View)localObject).getTag() instanceof BusinessCardEditActivity.ItemHolder)) && (paramString.equals(((BusinessCardEditActivity.ItemHolder)((View)localObject).getTag()).a)))
        {
          localObject = (TextView)((View)localObject).findViewById(2131372273);
          if (localObject != null) {
            ((TextView)localObject).setText(str);
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