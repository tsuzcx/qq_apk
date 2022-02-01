package com.tencent.mobileqq.filemanager.fileviewer.colornote;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.colornote.settings.IOnHeaderClickHandler;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class QFileColorNoteHistoryHeaderHandler
  implements IOnHeaderClickHandler
{
  public String a()
  {
    return HardCodeUtil.a(2131699139);
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    while (paramInt != 17039360) {
      return;
    }
    paramView = paramView.getContext();
    Intent localIntent = new Intent(paramView, FileAssistantActivity.class);
    localIntent.putExtra("from", "FileAssistant");
    paramView.startActivity(localIntent);
    ReportController.b(null, "dc00898", "", "", "0X800AA81", "0X800AA81", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.colornote.QFileColorNoteHistoryHeaderHandler
 * JD-Core Version:    0.7.0.1
 */