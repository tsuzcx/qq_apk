package com.tencent.mobileqq.filemanager.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;
import cooperation.weiyun.AlbumBackupProxyActivity;

class FileAssistantExt$2
  implements PopupMenuDialog.OnClickActionListener
{
  FileAssistantExt$2(FileAssistantExt paramFileAssistantExt, boolean paramBoolean, Activity paramActivity, BaseQQAppInterface paramBaseQQAppInterface, BusinessInfoCheckUpdate.AppInfo paramAppInfo) {}
  
  public void onClickAction(PopupMenuDialog.MenuItem paramMenuItem)
  {
    int i = paramMenuItem.id;
    Object localObject;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return;
            }
            FileManagerReporter.a("0X8005532");
            paramMenuItem = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
            localObject = this.jdField_a_of_type_AndroidAppActivity;
            FileManagerUtil.a(paramMenuItem, (Context)localObject, "_is_from_qfile_shortcut", ((Activity)localObject).getString(2131692293), 2130844409);
            FMToastUtil.b(2131692338);
            return;
          }
          FileManagerReporter.a("0X800A15F");
          paramMenuItem = new Bundle();
          paramMenuItem.putString("url", "https://docs.qq.com/desktop/m/templates_list.html?padtype=0&_wv=2&_wwv=512");
          paramMenuItem.putString("tdsourcetag", "s_qq_myfile_menu_create");
          TeamWorkDocEditBrowserActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramMenuItem, false);
          return;
        }
        if (this.jdField_a_of_type_Boolean) {
          FileManagerReporter.a("0X8005536");
        } else {
          FileManagerReporter.a("0X800681C");
        }
        AlbumBackupProxyActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin(), "source_qfile_assistant", 10001);
        FileAssistantExt.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplFileAssistantExt, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo, "100160.100162");
        return;
      }
      if (this.jdField_a_of_type_Boolean) {
        FileManagerReporter.a("0X8005535");
      } else {
        FileManagerReporter.a("0X800681B");
      }
      FileAssistantExt.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplFileAssistantExt, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this.jdField_a_of_type_AndroidAppActivity);
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      FileManagerReporter.a("0X8005534");
    } else {
      FileManagerReporter.a("0X800681A");
    }
    if (QFileAssistantUtils.a())
    {
      QFileAssistantUtils.a(this.jdField_a_of_type_AndroidAppActivity);
      return;
    }
    try
    {
      paramMenuItem = new Intent(this.jdField_a_of_type_AndroidAppActivity, LiteActivity.class);
      localObject = new Bundle();
      ((Bundle)localObject).putLong("category", 12);
      paramMenuItem.putExtra("bundle", (Bundle)localObject);
      paramMenuItem.putExtra("from", "FileAssistant");
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramMenuItem, 101);
      return;
    }
    catch (Exception paramMenuItem)
    {
      paramMenuItem.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.FileAssistantExt.2
 * JD-Core Version:    0.7.0.1
 */