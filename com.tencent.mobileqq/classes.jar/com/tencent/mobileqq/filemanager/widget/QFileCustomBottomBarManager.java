package com.tencent.mobileqq.filemanager.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.sendbar.PrinterSendBarManager;
import com.tencent.mobileqq.filemanager.fileviewer.sendbar.QlinkSendBarManager;

public class QFileCustomBottomBarManager
{
  public static final int[] a;
  public Context a;
  protected Bundle a;
  protected QQAppInterface a;
  protected QFileSendBottomView a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 1, 5 };
  }
  
  public QFileCustomBottomBarManager(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView = paramQFileSendBottomView;
  }
  
  public static QFileCustomBottomBarManager a(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView, Bundle paramBundle)
  {
    int i = paramBundle.getInt("qfile_search_param_exparams_busi_type");
    paramBundle.getInt("qfile_search_param_exparams_peer_type");
    if (i == 1) {
      paramQQAppInterface = new QlinkSendBarManager(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    }
    for (;;)
    {
      paramQQAppInterface.a(paramBundle);
      return paramQQAppInterface;
      if (i == 5) {
        paramQQAppInterface = new PrinterSendBarManager(paramQQAppInterface, paramContext, paramQFileSendBottomView);
      } else {
        paramQQAppInterface = new QFileSendBarManager(paramQQAppInterface, paramContext, paramQFileSendBottomView);
      }
    }
  }
  
  public void a() {}
  
  protected void a(int paramInt, Intent paramIntent)
  {
    if (paramIntent != null) {}
    for (paramIntent = new Intent(paramIntent);; paramIntent = new Intent())
    {
      paramIntent.putExtra("qfile_send_bottom_bar_finish_result_code", -1);
      Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
      localActivity.setResult(paramInt, paramIntent);
      localActivity.finish();
      return;
    }
  }
  
  public void a(Intent paramIntent)
  {
    a(-1, paramIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QFileCustomBottomBarManager
 * JD-Core Version:    0.7.0.1
 */