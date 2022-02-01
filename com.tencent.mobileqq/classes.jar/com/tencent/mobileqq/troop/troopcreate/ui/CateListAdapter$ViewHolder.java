package com.tencent.mobileqq.troop.troopcreate.ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateConfig;
import com.tencent.mobileqq.troop.troopcreate.TroopCreateUtils;
import com.tencent.mobileqq.vas.api.IVasH5PayUtil;
import com.tencent.mobileqq.vas.config.business.qvip.QVIPPrettyTroopProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPrettyTroopConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

public class CateListAdapter$ViewHolder
  implements View.OnClickListener
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new CateListAdapter.ViewHolder.1(this);
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  CateListAdapter jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiCateListAdapter;
  SubCateListView.OnToggleSubListListener jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiSubCateListView$OnToggleSubListListener = new CateListAdapter.ViewHolder.2(this);
  TroopCateListProvider.TroopCateInfo jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiTroopCateListProvider$TroopCateInfo;
  ArrayList<SubCateListView> jdField_a_of_type_JavaUtilArrayList;
  View jdField_b_of_type_AndroidViewView;
  ArrayList<SingleItemViewHolder> jdField_b_of_type_JavaUtilArrayList;
  
  public CateListAdapter$ViewHolder(CateListAdapter paramCateListAdapter, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiCateListAdapter = paramCateListAdapter;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370130));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365325);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    paramCateListAdapter = new SingleItemViewHolder(paramView.findViewById(2131370132), 0);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramCateListAdapter);
    paramCateListAdapter = new SingleItemViewHolder(paramView.findViewById(2131370133), 1);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramCateListAdapter);
    paramCateListAdapter = new SingleItemViewHolder(paramView.findViewById(2131370134), 2);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramCateListAdapter);
    paramCateListAdapter = new SingleItemViewHolder(paramView.findViewById(2131370135), 3);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramCateListAdapter);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
    paramCateListAdapter = new SubCateListView((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131370136), this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiCateListAdapter.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiSubCateListView$OnToggleSubListListener);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramCateListAdapter);
    paramCateListAdapter = new SubCateListView((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131370137), this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiCateListAdapter.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiSubCateListView$OnToggleSubListListener);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramCateListAdapter);
  }
  
  public void a(TroopCateListProvider.TroopCateInfo paramTroopCateInfo)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((SubCateListView)((Iterator)localObject).next()).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiTroopCateListProvider$TroopCateInfo = paramTroopCateInfo;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopCateInfo.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramTroopCateInfo.jdField_b_of_type_JavaLangString);
    boolean bool = paramTroopCateInfo.jdField_b_of_type_JavaLangString.equals(CateListAdapter.jdField_a_of_type_JavaLangString);
    int j = 0;
    int i = j;
    if (bool)
    {
      localObject = (ITroopCreateConfig)this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiCateListAdapter.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopCreateConfig.class, "");
      bool = TroopCreateUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiCateListAdapter.jdField_a_of_type_ComTencentCommonAppAppInterface);
      i = j;
      if (((ITroopCreateConfig)localObject).isShow3KTroopTips())
      {
        localObject = this.jdField_b_of_type_AndroidViewView;
        if (bool) {
          i = 8;
        } else {
          i = 0;
        }
        ((View)localObject).setVisibility(i);
        i = j;
      }
    }
    while (i < paramTroopCateInfo.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((SingleItemViewHolder)this.jdField_b_of_type_JavaUtilArrayList.get(i)).a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiCateListAdapter.jdField_a_of_type_AndroidContentContext, (TroopCateListProvider.TroopCateInfo)paramTroopCateInfo.jdField_a_of_type_JavaUtilArrayList.get(i), this);
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    SingleItemViewHolder localSingleItemViewHolder = (SingleItemViewHolder)paramView.getTag();
    if ((localSingleItemViewHolder != null) && (localSingleItemViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiTroopCateListProvider$TroopCateInfo != null))
    {
      TroopCateListProvider.TroopCateInfo localTroopCateInfo = localSingleItemViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiTroopCateListProvider$TroopCateInfo;
      String str;
      if (localTroopCateInfo.jdField_a_of_type_JavaLangString == null) {
        str = "";
      } else {
        str = localTroopCateInfo.jdField_a_of_type_JavaLangString;
      }
      ReportController.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, str, "", "", "");
      if (localTroopCateInfo.jdField_a_of_type_Boolean)
      {
        int i = localSingleItemViewHolder.jdField_a_of_type_Int / 2;
        ((SubCateListView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(localSingleItemViewHolder, localTroopCateInfo);
      }
      else if (localTroopCateInfo.jdField_b_of_type_Int == 1)
      {
        if (localTroopCateInfo.jdField_a_of_type_JavaLangString != null) {
          if ((!localTroopCateInfo.jdField_a_of_type_JavaLangString.equals("20001")) && (!localTroopCateInfo.jdField_a_of_type_JavaLangString.equals("20002")))
          {
            if (localTroopCateInfo.jdField_a_of_type_JavaLangString.equals("20003"))
            {
              QLog.e("createNewTroop.CateListAdapter", 1, "click the create pretty troop icon");
              ((IVasH5PayUtil)QRoute.api(IVasH5PayUtil.class)).openH5Page(QVIPPrettyTroopProcessor.c().a("category"), this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiCateListAdapter.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin(), (Activity)this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiCateListAdapter.jdField_a_of_type_AndroidContentContext);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiCateListAdapter.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "qq_vip", "0X800A582", 0, 0, "", "", "", "");
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiCateListAdapter.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopCateView.a(localTroopCateInfo.jdField_a_of_type_JavaLangString, null);
            }
          }
          else
          {
            if (((ITroopCreateConfig)this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiCateListAdapter.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopCreateConfig.class, "")).isShow3KTroopTips())
            {
              TroopCreateUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiCateListAdapter.jdField_a_of_type_ComTencentCommonAppAppInterface);
              this.jdField_b_of_type_AndroidViewView.setVisibility(8);
            }
            TroopCreateUtils.b((Activity)this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiCateListAdapter.jdField_a_of_type_AndroidContentContext, localTroopCateInfo.jdField_a_of_type_JavaLangString);
            if (localTroopCateInfo.jdField_a_of_type_JavaLangString.equals("20001")) {
              str = "Clk_type_2";
            } else {
              str = "Clk_type_3";
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiCateListAdapter.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_create_mobile", "", "chose_type", str, 0, 0, "", "", "", "");
          }
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiCateListAdapter.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopCateView.a(localTroopCateInfo.d, localTroopCateInfo.jdField_a_of_type_JavaLangString);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.CateListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */