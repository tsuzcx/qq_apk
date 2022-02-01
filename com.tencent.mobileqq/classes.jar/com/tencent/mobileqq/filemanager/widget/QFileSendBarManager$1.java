package com.tencent.mobileqq.filemanager.widget;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class QFileSendBarManager$1
  implements View.OnClickListener
{
  QFileSendBarManager$1(QFileSendBarManager paramQFileSendBarManager) {}
  
  public void onClick(View paramView)
  {
    if (this.a.e)
    {
      int i = 4;
      if (QFileSendBarManager.a(this.a) == 1) {
        i = 2;
      } else if (QFileSendBarManager.a(this.a) == 0) {
        i = 1;
      }
      if ((QFileSendBarManager.b(this.a) != null) && (QFileSendBarManager.b(this.a).equals(AppConstants.DATALINE_PC_UIN))) {
        i = 3;
      }
      long l = ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedCount();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(l);
      ReportController.b(null, "dc00898", "", "", "0X800AA92", "0X800AA92", i, 0, ((StringBuilder)localObject1).toString(), "0", "", "");
      if (QFileSendBarManager.a(this.a) == 1101)
      {
        Object localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll(((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getLocalFiles());
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("file_choose_search_result_code", "file_choose_search_result_code");
        ((Intent)localObject1).putParcelableArrayListExtra("reslut_select_file_info_list", (ArrayList)localObject2);
        localObject2 = (Activity)this.a.a;
        ((Activity)localObject2).setResult(-1, (Intent)localObject1);
        ((Activity)localObject2).finish();
      }
      else if (QFileSendBarManager.a(this.a) == 1)
      {
        QFileSendBarManager.c(this.a);
      }
      else
      {
        QFileSendBarManager.d(this.a);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QFileSendBarManager.1
 * JD-Core Version:    0.7.0.1
 */