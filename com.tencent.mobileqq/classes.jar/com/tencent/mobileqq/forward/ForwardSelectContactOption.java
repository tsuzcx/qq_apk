package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ForwardSelectContactOption
  extends ForwardBaseOption
{
  public ForwardSelectContactOption(Intent paramIntent)
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
      if ((localRecentUser != null) && (((!Utils.b(localRecentUser.uin)) && (localRecentUser.getType() != 10004) && ((localRecentUser.getType() != 0) || (!CrmUtils.a(this.q, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() == 0) && (a(c))) || ((localRecentUser.getType() == 1) && (!c(localRecentUser.uin)) && (a(d))) || ((localRecentUser.getType() == 1006) && (a(ForwardAbility.ForwardAbilityType.i))) || ((localRecentUser.getType() == 3000) && (a(e))))) || (((localRecentUser.getType() == 1004) || (localRecentUser.getType() == 1000)) && (this.E)))) {
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
    if (this.r.getIntExtra("openAIOForPtt", 0) != 1)
    {
      a(2131892360);
      long l = this.r.getLongExtra("appid", -1L);
      localObject = this.s;
      QQAppInterface localQQAppInterface = this.q;
      String str = paramBundle.getString("uin");
      paramInt = paramBundle.getInt("uintype");
      UiApiPlugin.a((Activity)localObject, localQQAppInterface, l, new String[] { str }, new int[] { paramInt });
      return;
    }
    Object localObject = AIOUtils.a(new Intent(this.s, SplashActivity.class), null);
    this.t.putString("uin", paramBundle.getString("uin"));
    this.t.putInt("uintype", paramBundle.getInt("uintype"));
    this.t.putString("uinname", paramBundle.getString("uinname"));
    ((Intent)localObject).putExtras(this.t);
    ((Intent)localObject).putExtra("open_chat_from_voice_changer_guide", true);
    this.s.startActivity((Intent)localObject);
    this.s.finish();
  }
  
  protected void c()
  {
    int i = this.r.getIntExtra("acceptType", 13);
    if (((i & 0x1) != 0) && (ai())) {
      this.C.add(c);
    }
    if (((i & 0x4) != 0) && (ah())) {
      this.C.add(d);
    }
    if (((i & 0x8) != 0) && (ag())) {
      this.C.add(e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSelectContactOption
 * JD-Core Version:    0.7.0.1
 */