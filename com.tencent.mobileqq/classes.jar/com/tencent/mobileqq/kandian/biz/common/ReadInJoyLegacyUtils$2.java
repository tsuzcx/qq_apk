package com.tencent.mobileqq.kandian.biz.common;

import android.app.Activity;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;

final class ReadInJoyLegacyUtils$2
  implements BusinessObserver
{
  ReadInJoyLegacyUtils$2(Activity paramActivity, AppInterface paramAppInterface, ProfileParams paramProfileParams) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      this.a.runOnUiThread(new ReadInJoyLegacyUtils.2.1(this, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyLegacyUtils.2
 * JD-Core Version:    0.7.0.1
 */