package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/qqexpand/widget/ColdPalaceTipDialog$init$1$3"}, k=3, mv={1, 1, 16})
final class ColdPalaceTipDialog$init$$inlined$let$lambda$2
  implements View.OnClickListener
{
  ColdPalaceTipDialog$init$$inlined$let$lambda$2(ColdPalaceTipDialog paramColdPalaceTipDialog, Context paramContext, String paramString1, String paramString2, BaseQQAppInterface paramBaseQQAppInterface, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (!NetworkUtil.isNetSupport(this.b))
    {
      if (this.a.isShowing()) {
        this.a.dismiss();
      }
      paramView = this.b;
      QQToast.makeText(paramView, 1, (CharSequence)paramView.getResources().getString(2131889169), 0).show();
    }
    else if (this.c != null)
    {
      paramView = (Map)new HashMap();
      paramView.put("frompage", this.d);
      paramView.put("to_uid", this.c);
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#doghouse_page#doghouse", true, -1L, -1L, paramView, true, true);
      paramView = this.e.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
      if (paramView != null)
      {
        ((IExpandHandler)paramView).a(this.c, this.f);
        if (this.a.isShowing()) {
          this.a.dismiss();
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.network.IExpandHandler");
      }
    }
    ReportController.b(null, "dc00898", "", "", "0X800B2CF", "0X800B2CF", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ColdPalaceTipDialog.init..inlined.let.lambda.2
 * JD-Core Version:    0.7.0.1
 */