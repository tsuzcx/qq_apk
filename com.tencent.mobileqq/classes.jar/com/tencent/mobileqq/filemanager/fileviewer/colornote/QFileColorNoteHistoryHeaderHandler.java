package com.tencent.mobileqq.filemanager.fileviewer.colornote;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.settings.IOnHeaderClickHandler;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;

public class QFileColorNoteHistoryHeaderHandler
  implements IOnHeaderClickHandler
{
  public String a()
  {
    return HardCodeUtil.a(2131897259);
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    if (paramInt != 17039360) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramView = paramView.getContext();
    ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).openFileSelectorByColorNoteHistory(paramView);
    ReportController.b(null, "dc00898", "", "", "0X800AA81", "0X800AA81", 1, 0, "", "", "", "");
  }
  
  public int b()
  {
    return 17039360;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.colornote.QFileColorNoteHistoryHeaderHandler
 * JD-Core Version:    0.7.0.1
 */