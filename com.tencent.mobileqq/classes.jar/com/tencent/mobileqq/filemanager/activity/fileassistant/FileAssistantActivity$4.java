package com.tencent.mobileqq.filemanager.activity.fileassistant;

import android.content.Intent;
import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;
import cooperation.weiyun.AlbumBackupProxyActivity;

class FileAssistantActivity$4
  implements PopupMenuDialog.OnClickActionListener
{
  FileAssistantActivity$4(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    switch (paramMenuItem.a)
    {
    default: 
      return;
    case 0: 
      paramMenuItem = new Intent(this.a.getApplicationContext(), LiteActivity.class);
      if (this.a.l) {
        FileManagerReporter.a("0X8005534");
      }
      while (QFileAssistantUtils.a())
      {
        QFileAssistantUtils.a(this.a);
        return;
        FileManagerReporter.a("0X800681A");
      }
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putLong("category", 12);
        paramMenuItem.putExtra("bundle", localBundle);
        paramMenuItem.putExtra("from", "FileAssistant");
        this.a.startActivityForResult(paramMenuItem, 101);
        return;
      }
      catch (Exception paramMenuItem)
      {
        paramMenuItem.printStackTrace();
        return;
      }
    case 1: 
      if (this.a.l) {
        FileManagerReporter.a("0X8005535");
      }
      for (;;)
      {
        FileAssistantActivity.b(this.a);
        return;
        FileManagerReporter.a("0X800681B");
      }
    case 2: 
      if (this.a.l) {
        FileManagerReporter.a("0X8005536");
      }
      for (;;)
      {
        AlbumBackupProxyActivity.a(this.a, this.a.app.getCurrentAccountUin(), "source_qfile_assistant", 10001);
        FileAssistantActivity.a(this.a, this.a.c, "100160.100162");
        return;
        FileManagerReporter.a("0X800681C");
      }
    case 3: 
      FileManagerReporter.a("0X800A15F");
      paramMenuItem = new Bundle();
      paramMenuItem.putString("url", "https://docs.qq.com/desktop/m/templates_list.html?padtype=0&_wv=2&_wwv=512");
      paramMenuItem.putString("tdsourcetag", "s_qq_myfile_menu_create");
      TeamWorkDocEditBrowserActivity.a(this.a, paramMenuItem, false);
      return;
    }
    FileManagerReporter.a("0X8005532");
    FileManagerUtil.a(this.a.app, this.a, "_is_from_qfile_shortcut", this.a.getString(2131692365), 2130844503);
    FMToastUtil.b(2131692410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity.4
 * JD-Core Version:    0.7.0.1
 */