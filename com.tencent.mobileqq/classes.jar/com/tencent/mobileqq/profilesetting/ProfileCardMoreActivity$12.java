package com.tencent.mobileqq.profilesetting;

import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.util.List;

class ProfileCardMoreActivity$12
  extends FriendListObserver
{
  ProfileCardMoreActivity$12(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  protected void onSetAsNormalContacts(boolean paramBoolean, List<String> paramList)
  {
    if (!paramBoolean)
    {
      this.a.notifyUser(2131916300, 1);
      this.a.p.setOnCheckedChangeListener(null);
      this.a.p.setChecked(true);
      this.a.p.setOnCheckedChangeListener(this.a);
    }
  }
  
  protected void onSetAsUncommonlyUsedContacts(boolean paramBoolean, List<String> paramList)
  {
    if (!paramBoolean)
    {
      this.a.notifyUser(2131916300, 1);
      this.a.p.setOnCheckedChangeListener(null);
      this.a.p.setChecked(false);
      this.a.p.setOnCheckedChangeListener(this.a);
    }
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (this.a.b.uin.equals(paramString1))
    {
      if (!ProfilePAUtils.isPaTypeFriend(this.a.b)) {
        return;
      }
      if (paramBoolean)
      {
        paramString1 = this.a;
        paramString1.A = paramString2;
        paramString1.b(paramString2);
      }
      else
      {
        paramString1 = (FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (paramString1 == null) {
          paramString1 = null;
        } else {
          paramString1 = paramString1.m(this.a.b.uin);
        }
        if (paramString1 != null)
        {
          if (paramString1.remark != null) {
            this.a.A = paramString1.remark;
          }
          paramString1 = this.a;
          paramString1.b(paramString1.A);
        }
      }
      paramByte = this.a.y;
      int i = 1;
      if ((paramByte & 0x1) == 1)
      {
        paramString1 = this.a;
        if (paramBoolean) {
          paramByte = 2131890912;
        } else {
          paramByte = 2131890911;
        }
        if (paramBoolean) {
          i = 2;
        }
        paramString1.notifyUser(paramByte, i);
      }
      paramString1 = this.a;
      paramString1.y &= 0xFFFFFFFE;
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.b.uin.equals(String.valueOf(paramObject))))
    {
      this.a.notifyUser(2131888423, 2);
      if (this.a.E == null) {
        this.a.E = new Intent();
      }
      this.a.E.putExtra("finchat", true);
      paramObject = this.a;
      paramObject.setResult(-1, paramObject.E);
      this.a.finish();
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2) && (this.a.b.uin != null) && (ProfilePAUtils.isPaTypeFriend(this.a.b)))
    {
      Object localObject2 = (FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      Object localObject1;
      if (localObject2 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((FriendsManager)localObject2).m(this.a.b.uin);
      }
      if (localObject1 != null)
      {
        if (((Friends)localObject1).remark != null) {
          this.a.A = ((Friends)localObject1).remark;
        }
        ProfileCardMoreActivity localProfileCardMoreActivity = this.a;
        localProfileCardMoreActivity.b(localProfileCardMoreActivity.A);
        localObject1 = ((FriendsManager)localObject2).u(String.valueOf(((Friends)localObject1).groupid));
        if ((localObject1 != null) && (!Utils.a(this.a.w, ((Groups)localObject1).group_name)))
        {
          this.a.w = ((Groups)localObject1).group_name;
          localObject2 = this.a.f;
          if (TextUtils.isEmpty(this.a.w)) {
            localObject1 = "";
          } else {
            localObject1 = this.a.w;
          }
          ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
        }
      }
    }
  }
  
  protected void onUpdateFriendShieldFlag(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (!String.valueOf(paramLong).equals(this.a.b.uin)) {
      return;
    }
    paramBoolean1 ^= true;
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      this.a.a(paramBoolean2, paramBoolean1);
      return;
    }
    if (this.a.o != null) {
      this.a.o.post(new ProfileCardMoreActivity.12.2(this, paramBoolean2, paramBoolean1));
    }
  }
  
  protected void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2)
  {
    if ((this.a.b != null) && (!TextUtils.isEmpty(this.a.b.uin)))
    {
      if (!Utils.a(this.a.b.uin, paramString)) {
        return;
      }
      paramString = (FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.u(String.valueOf(paramByte1));
      }
      if ((paramString != null) && (!Utils.a(this.a.w, paramString.group_name)))
      {
        this.a.w = paramString.group_name;
        this.a.runOnUiThread(new ProfileCardMoreActivity.12.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.12
 * JD-Core Version:    0.7.0.1
 */