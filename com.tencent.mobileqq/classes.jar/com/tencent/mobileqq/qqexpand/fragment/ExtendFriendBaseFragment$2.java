package com.tencent.mobileqq.qqexpand.fragment;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.qphone.base.util.QLog;

class ExtendFriendBaseFragment$2
  extends ExpandObserver
{
  ExtendFriendBaseFragment$2(ExtendFriendBaseFragment paramExtendFriendBaseFragment) {}
  
  protected void a(boolean paramBoolean, StrangerInfo paramStrangerInfo, int paramInt)
  {
    if (paramInt != ExtendFriendBaseFragment.c(this.a)) {
      return;
    }
    if ((paramBoolean) && (paramStrangerInfo != null))
    {
      Object localObject = ((FriendsManager)this.a.i.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(this.a.i.getCurrentUin());
      if (localObject != null)
      {
        this.a.y = (TextUtils.isEmpty(paramStrangerInfo.mDeclaration) ^ true);
        this.a.z = ((Card)localObject).isShowCard;
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendBaseFragment", 2, String.format("addMyFeed mProfileComplete=%s mShowCard=%s", new Object[] { Boolean.valueOf(this.a.y), Boolean.valueOf(this.a.z) }));
        }
        if (this.a.m != null)
        {
          localObject = this.a.m.b(0);
          paramStrangerInfo.mIsMyFeed = true;
          if ((localObject != null) && (TextUtils.equals(((StrangerInfo)localObject).mUin, paramStrangerInfo.mUin))) {
            this.a.m.c(0);
          }
          this.a.m.a(0, paramStrangerInfo);
          if (!TextUtils.isEmpty(paramStrangerInfo.mDeclaration)) {
            paramStrangerInfo.mDeclaration = paramStrangerInfo.mDeclaration.replace('\n', ' ').trim();
          }
          if ((!this.a.z) || (!this.a.y)) {
            this.a.m.c(0);
          }
          this.a.m.notifyDataSetChanged();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment.2
 * JD-Core Version:    0.7.0.1
 */