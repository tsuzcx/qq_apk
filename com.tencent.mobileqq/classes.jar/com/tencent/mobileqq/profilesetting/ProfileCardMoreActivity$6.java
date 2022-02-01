package com.tencent.mobileqq.profilesetting;

import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.util.Utils;
import java.util.List;

class ProfileCardMoreActivity$6
  extends ShieldListObserver
{
  ProfileCardMoreActivity$6(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void a(boolean paramBoolean, List<Long> paramList)
  {
    if (this.a.a == null) {
      return;
    }
    String str = this.a.a.a;
    if (ProfileActivity.AllInOne.i(this.a.a)) {
      str = this.a.a();
    }
    for (;;)
    {
      if (paramList == null) {}
      int k;
      for (int i = 0;; i = paramList.size())
      {
        int j = 0;
        k = 0;
        while ((k == 0) && (j < i))
        {
          if (Utils.a(String.valueOf(paramList.get(j)), str)) {
            k = 1;
          }
          j += 1;
        }
      }
      if (k == 0) {
        break;
      }
      this.a.a(paramBoolean, false);
      return;
    }
  }
  
  public void b(boolean paramBoolean, List<Long> paramList)
  {
    int k = 0;
    if (this.a.a == null) {
      return;
    }
    String str = this.a.a.a;
    if (ProfileActivity.AllInOne.i(this.a.a)) {
      str = this.a.a();
    }
    for (;;)
    {
      if (paramList == null) {}
      for (int i = 0;; i = paramList.size())
      {
        int j = 0;
        while ((k == 0) && (j < i))
        {
          if (Utils.a(String.valueOf(paramList.get(j)), str)) {
            k = 1;
          }
          j += 1;
        }
      }
      if (k == 0) {
        break;
      }
      this.a.a(paramBoolean, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.6
 * JD-Core Version:    0.7.0.1
 */