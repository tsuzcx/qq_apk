package com.tencent.mobileqq.intervideo.now;

import android.content.Intent;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.util.Utils;
import java.util.List;

class ShareToQQActivity$2
  extends ShieldListObserver
{
  ShareToQQActivity$2(ShareToQQActivity paramShareToQQActivity) {}
  
  public void a(boolean paramBoolean, List<Long> paramList)
  {
    if (this.a.a == null)
    {
      this.a.finish();
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
      if (k != 0)
      {
        paramList = new Intent();
        paramList.putExtra("isSuccess", paramBoolean);
        paramList.putExtra("isCancelShield", false);
        this.a.setResult(-1, paramList);
      }
      this.a.finish();
      return;
    }
  }
  
  public void b(boolean paramBoolean, List<Long> paramList)
  {
    int k = 0;
    if (this.a.a == null)
    {
      this.a.finish();
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
      if (k != 0)
      {
        paramList = new Intent();
        paramList.putExtra("isSuccess", paramBoolean);
        paramList.putExtra("isCancelShield", true);
        this.a.setResult(-1, paramList);
      }
      this.a.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.ShareToQQActivity.2
 * JD-Core Version:    0.7.0.1
 */