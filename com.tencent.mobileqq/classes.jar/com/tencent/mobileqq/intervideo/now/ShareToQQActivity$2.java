package com.tencent.mobileqq.intervideo.now;

import android.content.Intent;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.util.Utils;
import java.util.List;

class ShareToQQActivity$2
  extends ShieldListObserver
{
  ShareToQQActivity$2(ShareToQQActivity paramShareToQQActivity) {}
  
  protected void a(boolean paramBoolean, List<Long> paramList)
  {
    if (this.a.allinone == null)
    {
      this.a.finish();
      return;
    }
    String str = this.a.allinone.uin;
    if (ProfilePAUtils.isPaTypeStrangerInContact(this.a.allinone)) {
      str = this.a.getContactStrangerUin();
    }
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    int k = 0;
    int j = 0;
    while ((k == 0) && (j < i))
    {
      if (Utils.a(String.valueOf(paramList.get(j)), str)) {
        k = 1;
      }
      j += 1;
    }
    if (k != 0)
    {
      paramList = new Intent();
      paramList.putExtra("isSuccess", paramBoolean);
      paramList.putExtra("isCancelShield", false);
      this.a.setResult(-1, paramList);
    }
    this.a.finish();
  }
  
  protected void b(boolean paramBoolean, List<Long> paramList)
  {
    if (this.a.allinone == null)
    {
      this.a.finish();
      return;
    }
    String str = this.a.allinone.uin;
    if (ProfilePAUtils.isPaTypeStrangerInContact(this.a.allinone)) {
      str = this.a.getContactStrangerUin();
    }
    int k = 0;
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    int j = 0;
    while ((k == 0) && (j < i))
    {
      if (Utils.a(String.valueOf(paramList.get(j)), str)) {
        k = 1;
      }
      j += 1;
    }
    if (k != 0)
    {
      paramList = new Intent();
      paramList.putExtra("isSuccess", paramBoolean);
      paramList.putExtra("isCancelShield", true);
      this.a.setResult(-1, paramList);
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.ShareToQQActivity.2
 * JD-Core Version:    0.7.0.1
 */