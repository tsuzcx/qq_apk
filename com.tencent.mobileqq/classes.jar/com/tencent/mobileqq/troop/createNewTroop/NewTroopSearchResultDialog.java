package com.tencent.mobileqq.troop.createNewTroop;

import ajbs;
import ajbt;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateCallback;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class NewTroopSearchResultDialog
  extends ActionSheet
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  Activity jdField_a_of_type_AndroidAppActivity;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public QQAppInterface a;
  TroopCreateLogic.TroopCreateCallback jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback;
  TroopCreateLogic jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic = (TroopCreateLogic)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31);
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  public NewTroopSearchResultDialog(Activity paramActivity, TroopCreateLogic.TroopCreateCallback paramTroopCreateCallback)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = paramTroopCreateCallback;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() != null)
    {
      paramView = (ajbt)paramView.getTag();
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic.a(paramView.a);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "clk_fuyong", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic.a().d, "" + this.jdField_a_of_type_Int, "", "");
    }
    do
    {
      return;
      if (2131368355 == paramView.getId())
      {
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1500L)
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic.a((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "clk_fuyong_new", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic.a().d, "" + this.jdField_a_of_type_Int, "", "");
        return;
      }
    } while (2131363978 != paramView.getId());
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic.a();
    dismiss();
  }
  
  public void show()
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(2130969880, null);
    a(localLinearLayout);
    Object localObject = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localLinearLayout.findViewById(2131363924));
    localObject = (TroopCreateLogic)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31);
    if ((((TroopCreateLogic)localObject).a == null) || (((TroopCreateLogic)localObject).a.size() == 0))
    {
      dismiss();
      ((TroopCreateLogic)localObject).a();
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    localObject = new ajbs(this, ((TroopCreateLogic)localObject).a);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject);
    this.jdField_a_of_type_ComTencentWidgetXListView.setMaxHeight(AIOUtils.a(200.0F, getContext().getResources()));
    this.jdField_a_of_type_AndroidViewView = localLinearLayout.findViewById(2131368355);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    localObject = String.format("和他们已有%d个群聊，可直接进入聊天。", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic.a.size()) });
    ((TextView)localLinearLayout.findViewById(2131368354)).setText((CharSequence)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic.a();
    this.jdField_a_of_type_Int = (((TroopCreateLogic.TroopCreateInfo)localObject).a.size() - 1);
    String str = String.format("已选择%d人", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368357)).setText(str);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368356)).setText(((TroopCreateLogic.TroopCreateInfo)localObject).c);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localLinearLayout.findViewById(2131363978));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    super.show();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "exp_fuyong", 0, 0, "" + ((TroopCreateLogic.TroopCreateInfo)localObject).d, "" + this.jdField_a_of_type_Int, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.NewTroopSearchResultDialog
 * JD-Core Version:    0.7.0.1
 */