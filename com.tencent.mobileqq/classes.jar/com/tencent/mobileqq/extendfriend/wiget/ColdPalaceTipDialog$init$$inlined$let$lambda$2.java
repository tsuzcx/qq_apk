package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/extendfriend/wiget/ColdPalaceTipDialog$init$1$3"}, k=3, mv={1, 1, 16})
final class ColdPalaceTipDialog$init$$inlined$let$lambda$2
  implements View.OnClickListener
{
  ColdPalaceTipDialog$init$$inlined$let$lambda$2(ColdPalaceTipDialog paramColdPalaceTipDialog, Context paramContext, String paramString1, String paramString2, QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetColdPalaceTipDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetColdPalaceTipDialog.dismiss();
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, (CharSequence)this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692257), 0).a();
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B2CF", "0X800B2CF", 1, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        Object localObject = new HashMap();
        ((Map)localObject).put("frompage", this.b);
        ((Map)localObject).put("to_uid", this.jdField_a_of_type_JavaLangString);
        ExpandReportUtils.a("click#doghouse_page#doghouse", true, -1L, -1L, (Map)localObject, true, true);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
        if (localObject == null) {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler");
        }
        ((ExtendFriendHandler)localObject).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetColdPalaceTipDialog.isShowing()) {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetColdPalaceTipDialog.dismiss();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ColdPalaceTipDialog.init..inlined.let.lambda.2
 * JD-Core Version:    0.7.0.1
 */