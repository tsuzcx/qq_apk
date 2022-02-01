package com.tencent.mobileqq.troop.troopcreate;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService.TroopCreateCallback;
import com.tencent.mobileqq.troop.data.TroopCreateInfo;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService.SearchResult;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class NewTroopSearchResultDialog
  extends ActionSheet
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  Activity jdField_a_of_type_AndroidAppActivity;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
  ITroopCreateInfoService.TroopCreateCallback jdField_a_of_type_ComTencentMobileqqTroopApiITroopCreateInfoService$TroopCreateCallback;
  ITroopCreateService jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiITroopCreateService = (ITroopCreateService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopCreateService.class, "");
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  private ArrayList<ITroopSearchService.SearchResult> jdField_a_of_type_JavaUtilArrayList;
  
  public NewTroopSearchResultDialog(Activity paramActivity, ITroopCreateInfoService.TroopCreateCallback paramTroopCreateCallback)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqTroopApiITroopCreateInfoService$TroopCreateCallback = paramTroopCreateCallback;
  }
  
  public void a(ArrayList<ITroopSearchService.SearchResult> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void onClick(View paramView)
  {
    int i = ((ITroopCreateInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopCreateInfoService.class, "")).getTroopCreateInfo().createFrom;
    Object localObject1;
    Object localObject2;
    StringBuilder localStringBuilder;
    if (paramView.getTag() != null)
    {
      localObject1 = (NewTroopSearchResultDialog.ViewHolder)paramView.getTag();
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiITroopCreateService.onReuseTroop(((NewTroopSearchResultDialog.ViewHolder)localObject1).a);
      localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(i);
      localObject2 = ((StringBuilder)localObject2).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_create_new", "", "create_page", "clk_fuyong", 0, 0, (String)localObject2, localStringBuilder.toString(), "", "");
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiITroopCreateService.terminateLogic();
    }
    else if (2131365321 == paramView.getId())
    {
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1500L)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiITroopCreateService.createTroop(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqTroopApiITroopCreateInfoService$TroopCreateCallback);
      }
      localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(i);
      localObject2 = ((StringBuilder)localObject2).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_create_new", "", "create_page", "clk_fuyong_new", 0, 0, (String)localObject2, localStringBuilder.toString(), "", "");
    }
    else if (2131364711 == paramView.getId())
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiITroopCreateService.terminateLogic();
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void show()
  {
    Object localObject1 = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131560637, null);
    if ("1103".equals(ThemeUtil.curThemeId)) {
      ((LinearLayout)localObject1).setBackgroundColor(-15921907);
    }
    addView((View)localObject1);
    Object localObject2 = (LinearLayout.LayoutParams)((LinearLayout)localObject1).getLayoutParams();
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)((LinearLayout)localObject1).findViewById(2131377082));
    localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
    {
      localObject2 = new NewTroopSearchResultDialog.ListAdapter(this, this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject2);
      this.jdField_a_of_type_ComTencentWidgetXListView.setMaxHeight(Utils.a(200.0F, getContext().getResources()));
      this.jdField_a_of_type_AndroidViewView = ((LinearLayout)localObject1).findViewById(2131365321);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      int i = this.jdField_a_of_type_JavaUtilArrayList.size();
      localObject2 = String.format(HardCodeUtil.a(2131707576), new Object[] { Integer.valueOf(i) });
      ((TextView)((LinearLayout)localObject1).findViewById(2131376504)).setText((CharSequence)localObject2);
      localObject2 = ((ITroopCreateInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopCreateInfoService.class, "")).getTroopCreateInfo();
      this.jdField_a_of_type_Int = (((TroopCreateInfo)localObject2).inviteMembers.size() - 1);
      Object localObject3 = String.format(HardCodeUtil.a(2131707582), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377158)).setText((CharSequence)localObject3);
      ((SingleLineTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379317)).setText(((TroopCreateInfo)localObject2).disPlayTroopName);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((LinearLayout)localObject1).findViewById(2131364711));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      super.show();
      localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(((TroopCreateInfo)localObject2).createFrom);
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_Int);
      ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_create_new", "", "create_page", "exp_fuyong", 0, 0, (String)localObject2, ((StringBuilder)localObject3).toString(), "", "");
      return;
    }
    dismiss();
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiITroopCreateService.terminateLogic();
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.NewTroopSearchResultDialog
 * JD-Core Version:    0.7.0.1
 */