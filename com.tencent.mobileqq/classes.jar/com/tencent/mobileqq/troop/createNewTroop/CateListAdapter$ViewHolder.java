package com.tencent.mobileqq.troop.createNewTroop;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.troopconfig.TroopConfigForAllUser;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.qvip.QVIPPrettyTroopProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipPrettyTroopConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QVipUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

public class CateListAdapter$ViewHolder
  implements View.OnClickListener
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new CateListAdapter.ViewHolder.1(this);
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  CateListAdapter jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter;
  SubCateListView.OnToggleSubListListener jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopSubCateListView$OnToggleSubListListener = new CateListAdapter.ViewHolder.2(this);
  TroopCateListProvider.TroopCateInfo jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopTroopCateListProvider$TroopCateInfo;
  ArrayList<SubCateListView> jdField_a_of_type_JavaUtilArrayList;
  View jdField_b_of_type_AndroidViewView;
  ArrayList<CateListAdapter.SingleItemViewHolder> jdField_b_of_type_JavaUtilArrayList;
  
  public CateListAdapter$ViewHolder(CateListAdapter paramCateListAdapter, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter = paramCateListAdapter;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370471));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365462);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    CateListAdapter.SingleItemViewHolder localSingleItemViewHolder = new CateListAdapter.SingleItemViewHolder(paramView.findViewById(2131370472), 0);
    this.jdField_b_of_type_JavaUtilArrayList.add(localSingleItemViewHolder);
    localSingleItemViewHolder = new CateListAdapter.SingleItemViewHolder(paramView.findViewById(2131370473), 1);
    this.jdField_b_of_type_JavaUtilArrayList.add(localSingleItemViewHolder);
    localSingleItemViewHolder = new CateListAdapter.SingleItemViewHolder(paramView.findViewById(2131370474), 2);
    this.jdField_b_of_type_JavaUtilArrayList.add(localSingleItemViewHolder);
    paramView = new CateListAdapter.SingleItemViewHolder(paramView.findViewById(2131370475), 3);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramView);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
    paramView = new SubCateListView((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131370476), paramCateListAdapter.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopSubCateListView$OnToggleSubListListener);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
    paramCateListAdapter = new SubCateListView((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131370477), paramCateListAdapter.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopSubCateListView$OnToggleSubListListener);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramCateListAdapter);
  }
  
  public void a(TroopCateListProvider.TroopCateInfo paramTroopCateInfo)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((SubCateListView)((Iterator)localObject).next()).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopTroopCateListProvider$TroopCateInfo = paramTroopCateInfo;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopCateInfo.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramTroopCateInfo.jdField_b_of_type_JavaLangString);
    if (paramTroopCateInfo.jdField_b_of_type_JavaLangString.equals(CateListAdapter.jdField_a_of_type_JavaLangString))
    {
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      boolean bool = ((TroopManager)localObject).c();
      if (((TroopManager)localObject).a.jdField_a_of_type_Boolean)
      {
        localObject = this.jdField_b_of_type_AndroidViewView;
        if (!bool) {
          break label182;
        }
      }
    }
    label182:
    for (int i = 8;; i = 0)
    {
      ((View)localObject).setVisibility(i);
      i = 0;
      while (i < paramTroopCateInfo.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((CateListAdapter.SingleItemViewHolder)this.jdField_b_of_type_JavaUtilArrayList.get(i)).a(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter.jdField_a_of_type_AndroidContentContext, (TroopCateListProvider.TroopCateInfo)paramTroopCateInfo.jdField_a_of_type_JavaUtilArrayList.get(i), this);
        i += 1;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    CateListAdapter.SingleItemViewHolder localSingleItemViewHolder = (CateListAdapter.SingleItemViewHolder)paramView.getTag();
    if ((localSingleItemViewHolder == null) || (localSingleItemViewHolder.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopTroopCateListProvider$TroopCateInfo == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      TroopCateListProvider.TroopCateInfo localTroopCateInfo = localSingleItemViewHolder.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopTroopCateListProvider$TroopCateInfo;
      if (localTroopCateInfo.jdField_a_of_type_JavaLangString == null) {}
      for (Object localObject = "";; localObject = localTroopCateInfo.jdField_a_of_type_JavaLangString)
      {
        ReportController.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, (String)localObject, "", "", "");
        if (!localTroopCateInfo.jdField_a_of_type_Boolean) {
          break label118;
        }
        int i = localSingleItemViewHolder.jdField_a_of_type_Int / 2;
        ((SubCateListView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(localSingleItemViewHolder, localTroopCateInfo);
        break;
      }
      label118:
      if (localTroopCateInfo.jdField_b_of_type_Int == 1)
      {
        if (localTroopCateInfo.jdField_a_of_type_JavaLangString != null)
        {
          if ((localTroopCateInfo.jdField_a_of_type_JavaLangString.equals("20001")) || (localTroopCateInfo.jdField_a_of_type_JavaLangString.equals("20002")))
          {
            localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            if (((TroopManager)localObject).a.jdField_a_of_type_Boolean)
            {
              ((TroopManager)localObject).d();
              this.jdField_b_of_type_AndroidViewView.setVisibility(8);
            }
            this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localTroopCateInfo.jdField_a_of_type_JavaLangString);
            if (localTroopCateInfo.jdField_a_of_type_JavaLangString.equals("20001")) {}
            for (localObject = "Clk_type_2";; localObject = "Clk_type_3")
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_mobile", "", "chose_type", (String)localObject, 0, 0, "", "", "", "");
              break;
            }
          }
          if (localTroopCateInfo.jdField_a_of_type_JavaLangString.equals("20003"))
          {
            QLog.e("vip_pretty.createNewTroop.CateListAdapter", 1, "click the create pretty troop icon");
            QVipUtils.a(QVIPPrettyTroopProcessor.c().a("category"), this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), (Activity)this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter.jdField_a_of_type_AndroidContentContext);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A582", 0, 0, "", "", "", "");
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localTroopCateInfo.jdField_a_of_type_JavaLangString, null);
          }
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopCateListAdapter.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localTroopCateInfo.d, localTroopCateInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.CateListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */