package com.tencent.mobileqq.troop.logic;

import aixx;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.observer.AccountObserver;
import mqq.util.WeakReference;

public class TroopAvatarWallEditCtrl
  implements AdapterView.OnItemClickListener
{
  public int a;
  public long a;
  public BaseActivity a;
  public QQAppInterface a;
  public TroopInfo a;
  public TroopAvatarWallEditCtrl.IGridItemStatusCallBack a;
  public AvatarWallAdapter a;
  public GridView a;
  public String a;
  public ArrayList a;
  AccountObserver a;
  public int b;
  public int c;
  
  public TroopAvatarWallEditCtrl()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_MqqObserverAccountObserver = new aixx(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b();
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AvatarWallAdapter.AvatarInfo)((Iterator)localObject).next()).jdField_c_of_type_Boolean = false;
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(paramInt);
    if (localObject != null)
    {
      ((AvatarWallAdapter.AvatarInfo)localObject).jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.notifyDataSetChanged();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl$IGridItemStatusCallBack != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl$IGridItemStatusCallBack.a(paramInt);
      }
    }
  }
  
  public void a(BaseActivity paramBaseActivity, String paramString, long paramLong, int paramInt1, QQAppInterface paramQQAppInterface, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.b = paramInt2;
    if (this.b < 0) {
      this.b = 0;
    }
    this.jdField_a_of_type_Long = paramLong;
    this.c = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramString);
    this.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramBaseActivity.findViewById(2131368247));
    this.jdField_a_of_type_ComTencentWidgetGridView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetGridView.setEdgeEffectEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter = new AvatarWallAdapter(new WeakReference(paramBaseActivity), this.jdField_a_of_type_ComTencentWidgetGridView, paramQQAppInterface, paramString, true, new Handler(), true, "Grp_Admin_data");
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.f = 0;
    paramString = new DisplayMetrics();
    paramBaseActivity.getWindowManager().getDefaultDisplay().getMetrics(paramString);
    paramInt1 = (paramString.widthPixels - DisplayUtil.a(paramBaseActivity, 12.0F) * 2 - DisplayUtil.a(paramBaseActivity, 10.0F) * 3) / 4;
    ((RelativeLayout)paramBaseActivity.findViewById(2131364035)).setMinimumHeight(paramInt1 * 2 + UIUtils.a(paramBaseActivity, 10.0F));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(paramInt1);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.e(1);
    this.jdField_a_of_type_Int = paramBaseActivity.getTitleBarHeight();
  }
  
  public void a(TroopAvatarWallEditCtrl.IGridItemStatusCallBack paramIGridItemStatusCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl$IGridItemStatusCallBack = paramIGridItemStatusCallBack;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(paramInt);
    if (paramAdapterView != null) {
      if (!TextUtils.equals("PLUS", paramAdapterView.d)) {
        a(paramInt);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if (((this.jdField_a_of_type_Long & 0x800) != 0L) || (this.c > 0))
      {
        paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter;
        if (this.c > 0) {}
        for (boolean bool = true;; bool = false)
        {
          paramAdapterView.d(bool);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_certified", "", "data", "exp_edit_head", 3, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
          return;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.e();
      return;
    }
    QLog.i("Q.troop_avatar_wall", 2, "avatarInfo = null, position=" + paramInt);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null))
    {
      paramArrayList = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(paramArrayList, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopTypeExt, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqObserverAccountObserver);
      if (paramArrayList != null)
      {
        this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl$IGridItemStatusCallBack != null)
        {
          paramArrayList = paramArrayList.iterator();
          while (paramArrayList.hasNext())
          {
            String str = (String)paramArrayList.next();
            this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl$IGridItemStatusCallBack.a(str);
          }
        }
      }
    }
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
        if (str != null)
        {
          localAvatarInfo.jdField_c_of_type_JavaLangString = str;
          if (AvatarTroopUtil.b(localAvatarInfo.jdField_c_of_type_JavaLangString)) {
            if (localAvatarInfo.jdField_c_of_type_JavaLangString.equals(AvatarWallAdapter.AvatarInfo.jdField_a_of_type_JavaLangString)) {
              localAvatarInfo.d = "SYSTEM_PHOTO";
            }
          }
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
            {
              Set localSet = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mTroopVerifyingPics;
              if (localSet != null) {
                localAvatarInfo.jdField_b_of_type_Boolean = localSet.contains(str);
              }
            }
            localArrayList.add(localAvatarInfo);
            break;
            localAvatarInfo.d = "AVATAR_URL_STR";
            continue;
            localAvatarInfo.d = "AVATAR_LOCAL_STR";
            localAvatarInfo.jdField_b_of_type_JavaLangString = str;
          }
        }
      }
    }
    if ((localArrayList.size() == 0) && (!paramBoolean))
    {
      paramList = new AvatarWallAdapter.AvatarInfo();
      paramList.jdField_c_of_type_JavaLangString = AvatarWallAdapter.AvatarInfo.jdField_a_of_type_JavaLangString;
      paramList.d = "SYSTEM_PHOTO";
      localArrayList.add(paramList);
    }
    if (this.b < localArrayList.size()) {
      ((AvatarWallAdapter.AvatarInfo)localArrayList.get(this.b)).jdField_c_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(localArrayList, false);
  }
  
  public void b(int paramInt)
  {
    AvatarWallAdapter.AvatarInfo localAvatarInfo = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(paramInt);
    if (localAvatarInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troop_avatar_wall", 2, "avatarInfo == null");
      }
      return;
    }
    if (AvatarTroopUtil.b(localAvatarInfo.jdField_c_of_type_JavaLangString))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "del_head", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Integer.valueOf(localAvatarInfo.jdField_c_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a.a(this.jdField_a_of_type_JavaLangString, 2, localArrayList);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b(paramInt);
    if (paramInt < this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a().size()) {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(paramInt) == null) || (!"PLUS".equals(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(paramInt).d))) {
        break label195;
      }
    }
    label195:
    for (int i = paramInt - 1;; i = paramInt)
    {
      if (i >= 0) {
        a(i);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl$IGridItemStatusCallBack == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopAvatarWallEditCtrl$IGridItemStatusCallBack.b(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.TroopAvatarWallEditCtrl
 * JD-Core Version:    0.7.0.1
 */