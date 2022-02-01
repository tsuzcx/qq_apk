package com.tencent.mobileqq.relationx.friendclue;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.qphone.base.util.QLog;

class FriendClueCommonGroupHelper$2
  extends IntimateInfoObserver
{
  FriendClueCommonGroupHelper$2(FriendClueCommonGroupHelper paramFriendClueCommonGroupHelper) {}
  
  protected void a(boolean paramBoolean, String paramString, IntimateInfo paramIntimateInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onGetIntimateInfo");
    }
    FriendClueCommonGroupHelper.a(this.a).removeObserver(this.a.a);
    FriendClueCommonGroupHelper.a(this.a).removeMessages(1);
    if (paramBoolean)
    {
      FriendClueCommonGroupHelper.a(this.a, paramIntimateInfo);
      this.a.a();
      return;
    }
    FriendClueCommonGroupHelper.a(this.a).post(new FriendClueCommonGroupHelper.2.1(this));
    QLog.e("FriendClueCommonGroupHelper", 1, "get intimateInfo failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.friendclue.FriendClueCommonGroupHelper.2
 * JD-Core Version:    0.7.0.1
 */