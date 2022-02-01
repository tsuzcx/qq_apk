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
  public int a;
  public TroopMemberListActivity.ATroopMember a;
  public TroopMemberListActivity a;
  private final FriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new AddFrdHelper.2(this);
  private final IFriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverIFriendObserver = (IFriendObserver)((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).getFriendListObserverForAddFrd(this);
  public IAddFrdStateMngProxy a;
  private AddFrdHelper.TroopMemberListConfig jdField_a_of_type_ComTencentMobileqqTroopMemberlistAddFrdHelper$TroopMemberListConfig = null;
  public final ArrayList<String> a;
  public boolean a;
  
  public AddFrdHelper(TroopMemberListActivity paramTroopMemberListActivity)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ATroopMember = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity = paramTroopMemberListActivity;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_ComTencentMobileqqTroopApiTroopmemberlistIAddFrdStateMngProxy = ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).getAddFrdStateMngProxy(paramTroopMemberListActivity.app);
    paramTroopMemberListActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverIFriendObserver);
    paramTroopMemberListActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
  }
  
  public void a()
  {
    TroopMemberListActivity.ATroopMember localATroopMember = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ATroopMember;
    if (localATroopMember != null)
    {
      a(localATroopMember);
      a(1, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ATroopMember.a);
    }
    else
    {
      b();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ATroopMember = null;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt > this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_Int = paramInt;
    }
    if ((this.jdField_a_of_type_Int < 2) && (!TextUtils.isEmpty(paramString))) {
      try
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
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
    paramString = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    if ((paramString != null) && (paramString.isResume())) {
      paramString.runOnUiThread(new AddFrdHelper.1(this));
    }
  }
  
  public void a(TroopMemberListActivity.ATroopMember paramATroopMember)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    if (paramATroopMember != null)
    {
      if (localTroopMemberListActivity == null) {
        return;
      }
      if (!a(localTroopMemberListActivity.mTroopInfo))
      {
        paramATroopMember.n = 0;
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopApiTroopmemberlistIAddFrdStateMngProxy != null)
      {
        if (((ITroopRobotService)localTroopMemberListActivity.app.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(paramATroopMember.a))
        {
          paramATroopMember.n = 0;
          return;
        }
        paramATroopMember.n = this.jdField_a_of_type_ComTencentMobileqqTroopApiTroopmemberlistIAddFrdStateMngProxy.a(paramATroopMember.a, localTroopMemberListActivity.app);
        return;
      }
      paramATroopMember.n = 0;
    }
  }
  
  public void a(TroopMemberListActivity.TmViewHolder paramTmViewHolder, TroopMemberListActivity.ATroopMember paramATroopMember)
  {
    if (paramTmViewHolder == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    if ((paramTmViewHolder.f != null) && (localObject != null))
    {
      TroopInfo localTroopInfo = ((TroopMemberListActivity)localObject).mTroopInfo;
      localObject = ((TroopMemberListActivity)localObject).app;
      if (paramATroopMember == null) {}
      while ((paramATroopMember.n != 3) && (paramATroopMember.n != 2))
      {
        i = 0;
        break;
      }
      int i = 1;
      if (i != 0)
      {
        paramTmViewHolder.f.setVisibility(0);
        Button localButton = (Button)paramTmViewHolder.f.findViewById(2131362212);
        paramTmViewHolder = (TextView)paramTmViewHolder.f.findViewById(2131362214);
        if (paramATroopMember.n == 2)
        {
          localButton.setVisibility(8);
          paramTmViewHolder.setVisibility(0);
          return;
        }
        if (paramATroopMember.n == 3)
        {
          localButton.setTag(paramATroopMember);
          localButton.setOnClickListener(this);
          localButton.setText(HardCodeUtil.a(2131700055));
          localButton.setVisibility(0);
          paramTmViewHolder.setVisibility(8);
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = true;
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
        paramTmViewHolder.f.setVisibility(8);
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
      if (this.jdField_a_of_type_ComTencentMobileqqTroopMemberlistAddFrdHelper$TroopMemberListConfig == null) {
        d();
      }
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopMemberlistAddFrdHelper$TroopMemberListConfig.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt)))
      {
        bool1 = bool2;
        if (paramTroopInfo.wMemberNum <= this.jdField_a_of_type_ComTencentMobileqqTroopMemberlistAddFrdHelper$TroopMemberListConfig.jdField_a_of_type_Int) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    if ((localTroopMemberListActivity != null) && (!localTroopMemberListActivity.isFinishing()) && (localTroopMemberListActivity.isResume()))
    {
      if (Thread.currentThread() != Looper.getMainLooper().getThread())
      {
        if (QLog.isColorLevel()) {
          QLog.i("AddFrdHelper", 2, "checkNeedUpdate cur thread is not main thread!");
        }
        return;
      }
      int i = this.jdField_a_of_type_Int;
      TroopMemberListActivity.ATroopMember localATroopMember;
      if (i == 1) {
        try
        {
          Iterator localIterator1 = localTroopMemberListActivity.mListData.iterator();
          while (localIterator1.hasNext())
          {
            localATroopMember = (TroopMemberListActivity.ATroopMember)localIterator1.next();
            if ((localATroopMember != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localATroopMember.a))) {
              a(localATroopMember);
            }
          }
          if (i != 2) {
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
          this.jdField_a_of_type_Int = 0;
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
        this.jdField_a_of_type_JavaUtilArrayList.clear();
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    if (localObject != null)
    {
      localObject = ((TroopMemberListActivity)localObject).app;
      if (localObject != null)
      {
        ((AppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverIFriendObserver);
        ((AppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopApiTroopmemberlistIAddFrdStateMngProxy = null;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopMemberlistAddFrdHelper$TroopMemberListConfig == null)
    {
      TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (localTroopMemberListActivity != null)
      {
        localObject1 = localObject2;
        if (localTroopMemberListActivity.app != null) {
          localObject1 = localTroopMemberListActivity.app.getCurrentAccountUin();
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopMemberlistAddFrdHelper$TroopMemberListConfig = new AddFrdHelper.TroopMemberListConfig((String)localObject1);
    }
  }
  
  public void onClick(View paramView)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    Object localObject = paramView.getTag();
    if ((localTroopMemberListActivity != null) && ((localObject instanceof TroopMemberListActivity.ATroopMember)))
    {
      TroopMemberListActivity.ATroopMember localATroopMember = (TroopMemberListActivity.ATroopMember)localObject;
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ATroopMember = localATroopMember;
      String str = localTroopMemberListActivity.mTroopCode;
      localObject = str;
      if (str == null)
      {
        localObject = str;
        if (localTroopMemberListActivity.mTroopInfo != null) {
          localObject = localTroopMemberListActivity.mTroopInfo.troopcode;
        }
      }
      localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(localTroopMemberListActivity, 1, localATroopMember.a, (String)localObject, 3004, 13, localATroopMember.m, null, null, null, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.memberlist.AddFrdHelper
 * JD-Core Version:    0.7.0.1
 */