package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.BaseApplication;

class SimpleFileViewer$3
  implements Runnable
{
  SimpleFileViewer$3(SimpleFileViewer paramSimpleFileViewer, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if (SimpleFileViewer.b(this.this$0) != null)
    {
      SimpleFileViewer.b(this.this$0).setVisibility(0);
      return;
    }
    if ((SimpleFileViewer.c(this.this$0) != null) && (SimpleFileViewer.d(this.this$0) != null) && ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      Object localObject = (LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater");
      if (localObject != null)
      {
        SimpleFileViewer localSimpleFileViewer = this.this$0;
        SimpleFileViewer.a(localSimpleFileViewer, ((LayoutInflater)localObject).inflate(2131627084, SimpleFileViewer.c(localSimpleFileViewer), false));
        localObject = new RelativeLayout.LayoutParams(-1, ((ITencentDocConvertABTestUtil)QRoute.api(ITencentDocConvertABTestUtil.class)).calcHeightLayoutParam(localQQAppInterface));
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        SimpleFileViewer.b(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
        SimpleFileViewer.c(this.this$0).addView(SimpleFileViewer.b(this.this$0));
        ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009064", "0X8009064", 0, 0, "", "", "", "");
        ((ITencentDocConvertABTestUtil)QRoute.api(ITencentDocConvertABTestUtil.class)).configureABTest(localQQAppInterface, this.this$0.c, SimpleFileViewer.b(this.this$0), this.a, new SimpleFileViewer.3.1(this, localQQAppInterface));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.3
 * JD-Core Version:    0.7.0.1
 */