package com.tencent.qidian;

import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;

class QidianProfileCardActivity$2
  implements Runnable
{
  QidianProfileCardActivity$2(QidianProfileCardActivity paramQidianProfileCardActivity, String paramString) {}
  
  public void run()
  {
    Object localObject2 = this.this$0.t.m(this.a);
    Object localObject1;
    if ((localObject2 != null) && (((Friends)localObject2).remark != null))
    {
      String str1 = ((Friends)localObject2).remark;
      localObject1 = str1;
      if (((Friends)localObject2).remark.equals(((Friends)localObject2).name))
      {
        localObject1 = this.this$0.u;
        localObject2 = this.this$0.app.getCurrentAccountUin();
        String str2 = this.this$0.e.allInOne.uin;
        long l = ProfileUtils.getControl(this.this$0.e.allInOne, false);
        ((CardHandler)localObject1).a((String)localObject2, str2, 1, 0L, (byte)1, 0L, 0L, new byte[] { 0 }, "", l, 10004, new byte[] { 0 }, (byte)0);
        localObject1 = str1;
      }
    }
    else
    {
      localObject1 = "";
    }
    this.this$0.e.allInOne.remark = ((String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.2
 * JD-Core Version:    0.7.0.1
 */