package com.tencent.mobileqq.filebrowser.view;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import mqq.app.MobileQQ;

class DocFileBrowserView$5
  implements Runnable
{
  DocFileBrowserView$5(DocFileBrowserView paramDocFileBrowserView, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if (DocFileBrowserView.a(this.this$0) != null)
    {
      DocFileBrowserView.a(this.this$0).setVisibility(0);
      return;
    }
    if (DocFileBrowserView.a(this.this$0) == null) {
      return;
    }
    Object localObject = this.this$0;
    DocFileBrowserView.a((DocFileBrowserView)localObject, DocFileBrowserView.a((DocFileBrowserView)localObject, DocFileBrowserView.a((DocFileBrowserView)localObject)));
    localObject = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    ReportController.b(null, "dc00898", "", "", "0X8009064", "0X8009064", 0, 0, "", "", "", "");
    ((ITencentDocConvertABTestUtil)QRoute.api(ITencentDocConvertABTestUtil.class)).configureABTest((AppInterface)localObject, this.this$0.a, DocFileBrowserView.a(this.this$0), this.a, new DocFileBrowserView.5.1(this, (AppInterface)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.view.DocFileBrowserView.5
 * JD-Core Version:    0.7.0.1
 */