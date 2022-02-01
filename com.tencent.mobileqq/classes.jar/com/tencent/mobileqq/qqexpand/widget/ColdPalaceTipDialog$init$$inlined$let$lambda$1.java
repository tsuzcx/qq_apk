package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/qqexpand/widget/ColdPalaceTipDialog$init$1$1"}, k=3, mv={1, 1, 16})
final class ColdPalaceTipDialog$init$$inlined$let$lambda$1
  implements View.OnClickListener
{
  ColdPalaceTipDialog$init$$inlined$let$lambda$1(ColdPalaceTipDialog paramColdPalaceTipDialog, Context paramContext, String paramString1, String paramString2, BaseQQAppInterface paramBaseQQAppInterface, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetColdPalaceTipDialog.isShowing())
    {
      ReportController.b(null, "dc00898", "", "", "0X800B2CF", "0X800B2CF", 2, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetColdPalaceTipDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ColdPalaceTipDialog.init..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */