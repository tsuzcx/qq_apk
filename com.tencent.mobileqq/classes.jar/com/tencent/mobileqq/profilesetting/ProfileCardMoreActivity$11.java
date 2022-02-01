package com.tencent.mobileqq.profilesetting;

import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.util.Utils;
import java.util.List;

class ProfileCardMoreActivity$11
  extends ShieldListObserver
{
  ProfileCardMoreActivity$11(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  protected void a(boolean paramBoolean, List<Long> paramList)
  {
    if (this.a.b == null) {
      return;
    }
    String str = this.a.b.uin;
    if (ProfilePAUtils.isPaTypeStrangerInContact(this.a.b)) {
      str = this.a.d();
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
    if (k != 0) {
      this.a.a(paramBoolean, false);
    }
  }
  
  protected void b(boolean paramBoolean, List<Long> paramList)
  {
    if (this.a.b == null) {
      return;
    }
    String str = this.a.b.uin;
    if (ProfilePAUtils.isPaTypeStrangerInContact(this.a.b)) {
      str = this.a.d();
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
    if (k != 0) {
      this.a.a(paramBoolean, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.11
 * JD-Core Version:    0.7.0.1
 */