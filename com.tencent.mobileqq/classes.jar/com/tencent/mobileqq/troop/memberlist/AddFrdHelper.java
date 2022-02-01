package com.tencent.mobileqq.troop.memberlist;

import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import com.tencent.mobileqq.activity.TroopMemberListActivity.TmViewHolder;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.friend.observer.IFriendObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.api.troopmemberlist.IAddFrdStateMngProxy;
import com.tencent.mobileqq.troop.api.troopmemberlist.IFriendListObserverForAddFrdProxy;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class AddFrdHelper
  implements View.OnClickListener, IFriendListObserverForAddFrdProxy
{
  public TroopMemberListActivity a;
  public final ArrayList<String> b;
  public boolean c = false;
  public int d = 0;
  public TroopMemberListActivity.ATroopMember e = null;
  public IAddFrdStateMngProxy f;
  private AddFrdHelper.TroopMemberListConfig g = null;
  private final FriendObserver h = new AddFrdHelper.2(this);
  private final IFriendObserver i = (IFriendObserver)((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).getFriendListObserverForAddFrd(this);
  
  public AddFrdHelper(TroopMemberListActivity paramTroopMemberListActivity)
  {
    this.a = paramTroopMemberListActivity;
    this.b = new ArrayList(5);
    this.f = ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).getAddFrdStateMngProxy(paramTroopMemberListActivity.app);
    paramTroopMemberListActivity.app.addObserver(this.i);
    paramTroopMemberListActivity.app.addObserver(this.h);
  }
  
  public void a()
  {
    TroopMemberListActivity.ATroopMember localATroopMember = this.e;
    if (localATroopMember != null)
    {
      a(localATroopMember);
      a(1, this.e.a);
    }
    else
    {
      b();
    }
    this.e = null;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt > this.d) {
      this.d = paramInt;
    }
    if ((this.d < 2) && (!TextUtils.isEmpty(paramString))) {
      try
      {
        this.b.add(paramString);
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      b();
      return;
    }
    paramString = this.a;
    if ((paramString != null) && (paramString.isResume())) {
      paramString.runOnUiThread(new AddFrdHelper.1(this));
    }
  }
  
  public void a(TroopMemberListActivity.ATroopMember paramATroopMember)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.a;
    if (paramATroopMember != null)
    {
      if (localTroopMemberListActivity == null) {
        return;
      }
      if (!a(localTroopMemberListActivity.mTroopInfo))
      {
        paramATroopMember.U = 0;
        return;
      }
      if (this.f != null)
      {
        if (((ITroopRobotService)localTroopMemberListActivity.app.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(paramATroopMember.a))
        {
          paramATroopMember.U = 0;
          return;
        }
        paramATroopMember.U = this.f.a(paramATroopMember.a, localTroopMemberListActivity.app);
        return;
      }
      paramATroopMember.U = 0;
    }
  }
  
  public void a(TroopMemberListActivity.TmViewHolder paramTmViewHolder, TroopMemberListActivity.ATroopMember paramATroopMember)
  {
    if (paramTmViewHolder == null) {
      return;
    }
    Object localObject = this.a;
    if ((paramTmViewHolder.w != null) && (localObject != null))
    {
      TroopInfo localTroopInfo = ((TroopMemberListActivity)localObject).mTroopInfo;
      localObject = ((TroopMemberListActivity)localObject).app;
      if (paramATroopMember == null) {}
      while ((paramATroopMember.U != 3) && (paramATroopMember.U != 2))
      {
        j = 0;
        break;
      }
      int j = 1;
      if (j != 0)
      {
        paramTmViewHolder.w.setVisibility(0);
        Button localButton = (Button)paramTmViewHolder.w.findViewById(2131427793);
        paramTmViewHolder = (TextView)paramTmViewHolder.w.findViewById(2131427795);
        if (paramATroopMember.U == 2)
        {
          localButton.setVisibility(8);
          paramTmViewHolder.setVisibility(0);
          return;
        }
        if (paramATroopMember.U == 3)
        {
          localButton.setTag(paramATroopMember);
          localButton.setOnClickListener(this);
          localButton.setText(HardCodeUtil.a(2131898101));
          localButton.setVisibility(0);
          paramTmViewHolder.setVisibility(8);
          if (!this.c)
          {
            this.c = true;
            paramTmViewHolder = "";
            if (localTroopInfo != null)
            {
              paramTmViewHolder = localTroopInfo.troopuin;
              paramATroopMember = String.valueOf(localTroopInfo.dwGroupClassExt);
            }
            else
            {
              paramATroopMember = "";
            }
            new ReportTask((AppRuntime)localObject).b("Grp_mber").c("mber_list").d("add_exp").a(new String[] { paramTmViewHolder, paramATroopMember }).a();
          }
        }
        else
        {
          localButton.setVisibility(8);
          paramTmViewHolder.setVisibility(8);
        }
      }
      else
      {
        paramTmViewHolder.w.setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    a(1, paramString);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(2, null);
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      if (paramTroopInfo.isQidianPrivateTroop()) {
        return false;
      }
      if (this.g == null) {
        d();
      }
      bool1 = bool2;
      if (this.g.a.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt)))
      {
        bool1 = bool2;
        if (paramTroopInfo.wMemberNum <= this.g.b) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    TroopMemberListActivity localTroopMemberListActivity = this.a;
    if ((localTroopMemberListActivity != null) && (!localTroopMemberListActivity.isFinishing()) && (localTroopMemberListActivity.isResume()))
    {
      if (Thread.currentThread() != Looper.getMainLooper().getThread())
      {
        if (QLog.isColorLevel()) {
          QLog.i("AddFrdHelper", 2, "checkNeedUpdate cur thread is not main thread!");
        }
        return;
      }
      int j = this.d;
      TroopMemberListActivity.ATroopMember localATroopMember;
      if (j == 1) {
        try
        {
          Iterator localIterator1 = localTroopMemberListActivity.mListData.iterator();
          while (localIterator1.hasNext())
          {
            localATroopMember = (TroopMemberListActivity.ATroopMember)localIterator1.next();
            if ((localATroopMember != null) && (this.b.contains(localATroopMember.a))) {
              a(localATroopMember);
            }
          }
          if (j != 2) {
            break label200;
          }
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
          localTroopMemberListActivity.refreshAddFrdState();
        }
      } else {
        try
        {
          Iterator localIterator2 = localTroopMemberListActivity.mListData.iterator();
          while (localIterator2.hasNext())
          {
            localATroopMember = (TroopMemberListActivity.ATroopMember)localIterator2.next();
            if (localATroopMember != null) {
              a(localATroopMember);
            }
          }
          this.d = 0;
        }
        catch (Throwable localThrowable3)
        {
          localThrowable3.printStackTrace();
          localTroopMemberListActivity.refreshAddFrdState();
        }
      }
      try
      {
        label200:
        this.b.clear();
        return;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("AddFrdHelper", 2, "checkNeedUpdate activity is not resume or is finishing!");
    }
  }
  
  public void c()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((TroopMemberListActivity)localObject).app;
      if (localObject != null)
      {
        ((AppInterface)localObject).removeObserver(this.i);
        ((AppInterface)localObject).removeObserver(this.h);
      }
    }
    this.a = null;
    this.f = null;
  }
  
  protected void d()
  {
    if (this.g == null)
    {
      TroopMemberListActivity localTroopMemberListActivity = this.a;
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (localTroopMemberListActivity != null)
      {
        localObject1 = localObject2;
        if (localTroopMemberListActivity.app != null) {
          localObject1 = localTroopMemberListActivity.app.getCurrentAccountUin();
        }
      }
      this.g = new AddFrdHelper.TroopMemberListConfig((String)localObject1);
    }
  }
  
  public void onClick(View paramView)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.a;
    Object localObject = paramView.getTag();
    if ((localTroopMemberListActivity != null) && ((localObject instanceof TroopMemberListActivity.ATroopMember)))
    {
      TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)localObject;
      this.e = localATroopMember;
      String str = localTroopMemberListActivity.mTroopCode;
      localObject = str;
      if (str == null)
      {
        localObject = str;
        if (localTroopMemberListActivity.mTroopInfo != null) {
          localObject = localTroopMemberListActivity.mTroopInfo.troopcode;
        }
      }
      localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(localTroopMemberListActivity, 1, localATroopMember.a, (String)localObject, 3004, 13, localATroopMember.n, null, null, null, null);
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(localTroopMemberListActivity, (Intent)localObject);
      if (localTroopMemberListActivity.mTroopInfo != null) {
        localObject = String.valueOf(localTroopMemberListActivity.mTroopInfo.dwGroupClassExt);
      } else {
        localObject = "";
      }
      new ReportTask(localTroopMemberListActivity.app).b("Grp_mber").c("mber_list").d("add_clk").a(new String[] { "", localObject }).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.memberlist.AddFrdHelper
 * JD-Core Version:    0.7.0.1
 */