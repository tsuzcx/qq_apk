package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ForwardH5PTVOption
  extends ForwardBaseOption
{
  protected ResultReceiver a;
  
  public ForwardH5PTVOption(Intent paramIntent)
  {
    super(paramIntent);
    this.E = true;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    FriendsManager localFriendsManager = (FriendsManager)this.q.getManager(QQManagerFactory.FRIENDS_MANAGER);
    int i = this.r.getIntExtra("choose_friend_h5_type", 0);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && ((localRecentUser.getType() != 1006) || (a(ForwardAbility.ForwardAbilityType.i))) && (localRecentUser.getType() != 9501) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 7000)) {
        if ((localRecentUser.getType() == 0) && (!Utils.b(localRecentUser.uin)) && (!Utils.d(localRecentUser.uin)) && (!CrmUtils.a(this.q, localRecentUser.uin, localRecentUser.getType())))
        {
          if ((localFriendsManager != null) && (localFriendsManager.n(localRecentUser.uin)) && ((i == 1) || (i == 13))) {
            localArrayList.add(localRecentUser);
          }
        }
        else if (localRecentUser.getType() == 1)
        {
          if ((i == 4) || (i == 13) || (i == 12)) {
            localArrayList.add(localRecentUser);
          }
        }
        else if ((localRecentUser.getType() == 3000) && ((i == 8) || (i == 13) || (i == 12))) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.A != null) && (this.A.isShowing())) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    paramInt = paramBundle.getInt("uintype", -1);
    if ((paramInt != 0) && (paramInt != 1004))
    {
      if (paramInt == 1006)
      {
        localArrayList1.add("");
        localArrayList2.add(paramBundle.getString("uin"));
        localArrayList3.add(paramBundle.getString("uinname"));
        localArrayList4.add("2");
      }
      else if (paramInt == 1)
      {
        localArrayList1.add(paramBundle.getString("uin"));
        localArrayList2.add("");
        localArrayList3.add(paramBundle.getString("uinname"));
        localArrayList4.add("4");
      }
      else if (paramInt == 3000)
      {
        localArrayList1.add(paramBundle.getString("uin"));
        localArrayList2.add("");
        localArrayList3.add(paramBundle.getString("uinname"));
        localArrayList4.add("8");
      }
    }
    else
    {
      localArrayList1.add(paramBundle.getString("uin"));
      localArrayList2.add("");
      localArrayList3.add(paramBundle.getString("uinname"));
      localArrayList4.add("1");
    }
    if (this.a != null)
    {
      paramBundle = new Bundle();
      paramBundle.putStringArrayList("choose_friend_uins", localArrayList1);
      paramBundle.putStringArrayList("choose_friend_phones", localArrayList2);
      paramBundle.putStringArrayList("choose_friend_names", localArrayList3);
      paramBundle.putStringArrayList("choose_friend_types", localArrayList4);
      this.a.send(0, paramBundle);
    }
    if (this.s != null)
    {
      this.s.setResult(1);
      this.s.finish();
    }
  }
  
  protected void c()
  {
    this.r.getBooleanExtra("choose_friend_is_qqfriends", true);
    this.r.getBooleanExtra("choose_friend_is_contacts", false);
    int i = this.r.getIntExtra("choose_friend_h5_type", 0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bType=");
      localStringBuilder.append(i);
      QLog.d("h5ptv", 2, localStringBuilder.toString());
    }
    if ((i == 1) && (ai())) {
      this.C.add(c);
    }
    if (i == 4) {
      this.C.add(d);
    }
    if (i == 8) {
      this.C.add(e);
    }
    if (i == 13)
    {
      this.C.add(c);
      this.C.add(d);
      this.C.add(e);
    }
    if (i == 12)
    {
      this.C.add(d);
      this.C.add(e);
    }
  }
  
  public boolean e()
  {
    super.e();
    this.a = ((ResultReceiver)this.r.getParcelableExtra("choose_friend_callback"));
    return true;
  }
  
  public String u()
  {
    String str2 = this.r.getStringExtra("choose_friend_title");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = HardCodeUtil.a(2131902758);
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardH5PTVOption
 * JD-Core Version:    0.7.0.1
 */