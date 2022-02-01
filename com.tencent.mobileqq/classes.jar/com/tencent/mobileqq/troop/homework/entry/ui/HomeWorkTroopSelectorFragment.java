package com.tencent.mobileqq.troop.homework.entry.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class HomeWorkTroopSelectorFragment
  extends QIphoneTitleBarFragment
  implements Runnable
{
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = null;
  private HomeWorkTroopSelectorFragment.HwTroopAdapter jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiHomeWorkTroopSelectorFragment$HwTroopAdapter = null;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString = "";
  private List<String> jdField_a_of_type_JavaUtilList = null;
  private boolean jdField_a_of_type_Boolean;
  
  public static void a(Activity paramActivity, String paramString, ArrayList<String> paramArrayList)
  {
    Intent localIntent = new Intent();
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("HomeWorkTroopSelectorFragment:my_troop_uin", paramString);
    }
    if (paramArrayList != null) {
      localIntent.putExtra("HomeWorkTroopSelectorFragment:select_troop_uin", paramArrayList);
    }
    QPublicFragmentActivity.startForResult(paramActivity, localIntent, HomeWorkTroopSelectorFragment.class, 263);
  }
  
  private void a(List<TroopInfo> paramList)
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiHomeWorkTroopSelectorFragment$HwTroopAdapter = new HomeWorkTroopSelectorFragment.HwTroopAdapter(getActivity(), paramList, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiHomeWorkTroopSelectorFragment$HwTroopAdapter);
    }
  }
  
  protected int a()
  {
    return 2131560670;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)this.b.findViewById(2131368235));
    this.jdField_a_of_type_ComTencentWidgetListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetListView.setDividerHeight(0);
    if (getActivity() == null) {
      paramLayoutInflater = null;
    } else {
      paramLayoutInflater = (AppInterface)getQBaseActivity().getAppRuntime();
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramLayoutInflater;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null)
    {
      getActivity().finish();
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    c(2131697455, new HomeWorkTroopSelectorFragment.1(this));
    a(HardCodeUtil.a(2131705603));
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater != null)
    {
      this.jdField_a_of_type_JavaLangString = paramLayoutInflater.getString("HomeWorkTroopSelectorFragment:my_troop_uin");
      if (this.jdField_a_of_type_JavaLangString == null) {
        this.jdField_a_of_type_JavaLangString = "";
      }
      this.jdField_a_of_type_JavaUtilList = paramLayoutInflater.getStringArrayList("HomeWorkTroopSelectorFragment:select_troop_uin");
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
    }
    ThreadManager.postImmediately(this, null, true);
  }
  
  public boolean onBackEvent()
  {
    this.jdField_a_of_type_Boolean = false;
    return super.onBackEvent();
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    Object localObject1 = ((ITroopHWApi)QRoute.api(ITroopHWApi.class)).getTroopListUin(this.jdField_a_of_type_ComTencentCommonAppAppInterface, -2);
    if (localObject1 != null)
    {
      localObject1 = (String[])((HashMap)localObject1).get(Integer.valueOf(-2));
      if (this.jdField_a_of_type_JavaLangString == null) {
        this.jdField_a_of_type_JavaLangString = "";
      }
      ITroopInfoService localITroopInfoService = (ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = localITroopInfoService.findTroopInfo(this.jdField_a_of_type_JavaLangString);
      }
      if (localObject1 != null)
      {
        LinkedList localLinkedList = new LinkedList();
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!this.jdField_a_of_type_JavaLangString.equals(localObject2)))
          {
            localObject2 = localITroopInfoService.findTroopInfo((String)localObject2);
            if ((localObject2 != null) && (((((TroopInfo)localObject2).dwAdditionalFlag & 1L) == 1L) || ((((TroopInfo)localObject2).dwCmdUinUinFlag & 1L) == 1L))) {
              localLinkedList.add(localObject2);
            }
          }
          i += 1;
        }
        ThreadManager.getUIHandler().post(new HomeWorkTroopSelectorFragment.2(this, localLinkedList));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.HomeWorkTroopSelectorFragment
 * JD-Core Version:    0.7.0.1
 */