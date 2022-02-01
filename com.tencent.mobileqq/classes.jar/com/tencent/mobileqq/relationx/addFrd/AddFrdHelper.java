package com.tencent.mobileqq.relationx.addFrd;

import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import com.tencent.mobileqq.activity.TroopMemberListActivity.TmViewHolder;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddFrdHelper
  implements View.OnClickListener
{
  public int a;
  public TroopMemberListActivity.ATroopMember a;
  public TroopMemberListActivity a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new AddFrdHelper.2(this);
  private AddFrdHelper.TroopMemberListConfig jdField_a_of_type_ComTencentMobileqqRelationxAddFrdAddFrdHelper$TroopMemberListConfig = null;
  public AddFrdStateMng a;
  public final ArrayList<String> a;
  public boolean a;
  
  public AddFrdHelper(TroopMemberListActivity paramTroopMemberListActivity)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ATroopMember = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity = paramTroopMemberListActivity;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_ComTencentMobileqqRelationxAddFrdAddFrdStateMng = ((FriendsManager)paramTroopMemberListActivity.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a();
    paramTroopMemberListActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ATroopMember != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ATroopMember);
      a(1, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ATroopMember.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ATroopMember = null;
      return;
      b();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt > this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_Int = paramInt;
    }
    if ((this.jdField_a_of_type_Int < 2) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        b();
        return;
      }
    }
    catch (Throwable paramString)
    {
      do
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
      } while ((paramString == null) || (!paramString.isResume()));
      paramString.runOnUiThread(new AddFrdHelper.1(this));
    }
  }
  
  public void a(TroopMemberListActivity.ATroopMember paramATroopMember)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    AddFrdStateMng localAddFrdStateMng = this.jdField_a_of_type_ComTencentMobileqqRelationxAddFrdAddFrdStateMng;
    if ((paramATroopMember == null) || (localTroopMemberListActivity == null)) {
      return;
    }
    if (!a(localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo))
    {
      paramATroopMember.n = 0;
      return;
    }
    if (localAddFrdStateMng != null)
    {
      if (((TroopRobotManager)localTroopMemberListActivity.app.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).b(paramATroopMember.jdField_a_of_type_JavaLangString))
      {
        paramATroopMember.n = 0;
        return;
      }
      paramATroopMember.n = localAddFrdStateMng.a(paramATroopMember.jdField_a_of_type_JavaLangString, localTroopMemberListActivity.app);
      return;
    }
    paramATroopMember.n = 0;
  }
  
  public void a(TroopMemberListActivity.TmViewHolder paramTmViewHolder, TroopMemberListActivity.ATroopMember paramATroopMember)
  {
    if (paramTmViewHolder == null) {}
    Object localObject;
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
      } while ((paramTmViewHolder.f == null) || (localObject == null));
      localTroopInfo = ((TroopMemberListActivity)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      localObject = ((TroopMemberListActivity)localObject).app;
      int i;
      if (paramATroopMember == null) {
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label266;
        }
        paramTmViewHolder.f.setVisibility(0);
        localButton = (Button)paramTmViewHolder.f.findViewById(2131362186);
        paramTmViewHolder = (TextView)paramTmViewHolder.f.findViewById(2131362188);
        if (paramATroopMember.n != 2) {
          break;
        }
        localButton.setVisibility(8);
        paramTmViewHolder.setVisibility(0);
        return;
        if ((paramATroopMember.n == 3) || (paramATroopMember.n == 2)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      if (paramATroopMember.n != 3) {
        break;
      }
      localButton.setTag(paramATroopMember);
      localButton.setOnClickListener(this);
      localButton.setText(HardCodeUtil.a(2131699914));
      localButton.setVisibility(0);
      paramTmViewHolder.setVisibility(8);
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = true;
    paramATroopMember = "";
    paramTmViewHolder = "";
    if (localTroopInfo != null)
    {
      paramTmViewHolder = localTroopInfo.troopuin;
      paramATroopMember = String.valueOf(localTroopInfo.dwGroupClassExt);
    }
    new ReportTask((QQAppInterface)localObject).b("Grp_mber").c("mber_list").d("add_exp").a(new String[] { paramTmViewHolder, paramATroopMember }).a();
    return;
    localButton.setVisibility(8);
    paramTmViewHolder.setVisibility(8);
    return;
    label266:
    paramTmViewHolder.f.setVisibility(8);
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (paramTroopInfo.isQidianPrivateTroop())) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_ComTencentMobileqqRelationxAddFrdAddFrdHelper$TroopMemberListConfig == null) {
        d();
      }
    } while ((!this.jdField_a_of_type_ComTencentMobileqqRelationxAddFrdAddFrdHelper$TroopMemberListConfig.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt))) || (paramTroopInfo.wMemberNum > this.jdField_a_of_type_ComTencentMobileqqRelationxAddFrdAddFrdHelper$TroopMemberListConfig.jdField_a_of_type_Int));
    return true;
  }
  
  public void b()
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    if ((localTroopMemberListActivity == null) || (localTroopMemberListActivity.isFinishing()) || (!localTroopMemberListActivity.isResume())) {
      if (QLog.isColorLevel()) {
        QLog.i("AddFrdHelper", 2, "checkNeedUpdate activity is not resume or is finishing!");
      }
    }
    do
    {
      return;
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("AddFrdHelper", 2, "checkNeedUpdate cur thread is not main thread!");
    return;
    TroopMemberListActivity.ATroopMember localATroopMember;
    if (this.jdField_a_of_type_Int == 1) {
      try
      {
        Iterator localIterator1 = localTroopMemberListActivity.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          localATroopMember = (TroopMemberListActivity.ATroopMember)localIterator1.next();
          if ((localATroopMember != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localATroopMember.jdField_a_of_type_JavaLangString))) {
            a(localATroopMember);
          }
        }
        this.jdField_a_of_type_Int = 0;
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
        localTroopMemberListActivity.p();
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        return;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        return;
      }
      if (this.jdField_a_of_type_Int != 2) {
        continue;
      }
      try
      {
        Iterator localIterator2 = localThrowable1.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          localATroopMember = (TroopMemberListActivity.ATroopMember)localIterator2.next();
          if (localATroopMember != null) {
            a(localATroopMember);
          }
        }
      }
      catch (Throwable localThrowable3)
      {
        localThrowable3.printStackTrace();
        localThrowable1.p();
      }
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    if (localObject != null)
    {
      localObject = ((TroopMemberListActivity)localObject).app;
      if (localObject != null) {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqRelationxAddFrdAddFrdStateMng = null;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRelationxAddFrdAddFrdHelper$TroopMemberListConfig == null)
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
      this.jdField_a_of_type_ComTencentMobileqqRelationxAddFrdAddFrdHelper$TroopMemberListConfig = new AddFrdHelper.TroopMemberListConfig((String)localObject1);
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
      String str = localTroopMemberListActivity.jdField_a_of_type_JavaLangString;
      localObject = str;
      if (str == null)
      {
        localObject = str;
        if (localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
          localObject = localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode;
        }
      }
      localTroopMemberListActivity.startActivity(AddFriendLogicActivity.a(localTroopMemberListActivity, 1, localATroopMember.jdField_a_of_type_JavaLangString, (String)localObject, 3004, 13, localATroopMember.m, null, null, null, null));
      localObject = "";
      if (localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
        localObject = String.valueOf(localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupClassExt);
      }
      new ReportTask(localTroopMemberListActivity.app).b("Grp_mber").c("mber_list").d("add_clk").a(new String[] { "", localObject }).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.addFrd.AddFrdHelper
 * JD-Core Version:    0.7.0.1
 */