package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ForwardApolloActionSendOption
  extends ForwardBaseOption
{
  public ForwardApolloActionSendOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.b(localRecentUser.uin)) && ((localRecentUser.getType() == 0) || (localRecentUser.getType() == 1))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.A != null) && (this.A.isShowing())) {
      return;
    }
    this.t.putString("uin", paramBundle.getString("uin"));
    this.t.putInt("uintype", paramBundle.getInt("uintype"));
    this.t.putBoolean("apollo_forward_key", true);
    this.t.putBoolean("isBack2Root", true);
    this.r = new Intent(this.s, SplashActivity.class);
    this.r = AIOUtils.a(this.r, new int[] { 2 });
    this.r.putExtras(this.t);
    this.s.startActivity(this.r);
  }
  
  protected void c()
  {
    if (ah()) {
      this.C.add(d);
    }
    if (ai()) {
      this.C.add(c);
    }
  }
  
  public boolean e()
  {
    super.e();
    return true;
  }
  
  public void m()
  {
    super.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardApolloActionSendOption
 * JD-Core Version:    0.7.0.1
 */