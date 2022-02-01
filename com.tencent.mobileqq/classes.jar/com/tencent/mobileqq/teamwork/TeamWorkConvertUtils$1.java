package com.tencent.mobileqq.teamwork;

import android.content.Context;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class TeamWorkConvertUtils$1
  implements ActionSheet.OnButtonClickListener
{
  TeamWorkConvertUtils$1(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, ActionSheet paramActionSheet, AppInterface paramAppInterface, Context paramContext, String paramString, TeamWorkConvertUtils.TencentDocGetProgressDialogCallback paramTencentDocGetProgressDialogCallback) {}
  
  public void onClick(View paramView, int paramInt)
  {
    Object localObject;
    Context localContext;
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      this.a.B = 0;
      ((ITeamWorkFileImportHandler)this.c.getBusinessHandler(((ITeamWorkFacadeCreator)QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName())).removeFromConvertedMap(this.a);
      this.b.dismiss();
      paramView = this.c;
      localObject = this.a;
      localContext = this.d;
      paramView = TeamWorkConvertUtils.a(paramView, (TeamWorkFileImportInfo)localObject, localContext, this.e, localContext.getString(2131917105), true);
      localObject = this.f;
      if (localObject != null) {
        ((TeamWorkConvertUtils.TencentDocGetProgressDialogCallback)localObject).a(paramView);
      }
      if (this.a.d()) {
        TenDocLogReportHelper.a(this.c, "0X8009ED2");
      }
    }
    else
    {
      this.a.B = 2;
      this.b.dismiss();
      paramView = this.c;
      localObject = this.a;
      localContext = this.d;
      paramView = TeamWorkConvertUtils.a(paramView, (TeamWorkFileImportInfo)localObject, localContext, this.e, localContext.getString(2131917105), true);
      localObject = this.f;
      if (localObject != null) {
        ((TeamWorkConvertUtils.TencentDocGetProgressDialogCallback)localObject).a(paramView);
      }
      if (this.a.d()) {
        TenDocLogReportHelper.a(this.c, "0X8009ED1");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkConvertUtils.1
 * JD-Core Version:    0.7.0.1
 */