package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aroj;
import arti;
import azqs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class SimpleFileViewer$3
  implements Runnable
{
  SimpleFileViewer$3(SimpleFileViewer paramSimpleFileViewer, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if (SimpleFileViewer.a(this.this$0) != null) {
      SimpleFileViewer.a(this.this$0).setVisibility(0);
    }
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
      } while ((SimpleFileViewer.a(this.this$0) == null) || (SimpleFileViewer.b(this.this$0) == null) || (!(BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)));
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      localObject = (LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater");
    } while (localObject == null);
    SimpleFileViewer.a(this.this$0, ((LayoutInflater)localObject).inflate(2131560684, SimpleFileViewer.a(this.this$0), false));
    Object localObject = new RelativeLayout.LayoutParams(-1, arti.a(localQQAppInterface));
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    SimpleFileViewer.a(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
    SimpleFileViewer.a(this.this$0).addView(SimpleFileViewer.a(this.this$0));
    azqs.b(localQQAppInterface, "dc00898", "", "", "0X8009064", "0X8009064", 0, 0, "", "", "", "");
    arti.a(localQQAppInterface, this.this$0.a, SimpleFileViewer.a(this.this$0), this.a, new aroj(this, localQQAppInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.3
 * JD-Core Version:    0.7.0.1
 */