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
  public static final int[] f = { 1, 5 };
  protected Context a;
  protected QQAppInterface b;
  protected QFileSendBottomView c;
  protected Bundle d;
  protected boolean e;
  
  public QFileCustomBottomBarManager(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    this.b = paramQQAppInterface;
    this.a = paramContext;
    this.c = paramQFileSendBottomView;
  }
  
  public static QFileCustomBottomBarManager a(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView, Bundle paramBundle)
  {
    int i = paramBundle.getInt("qfile_search_param_exparams_busi_type");
    paramBundle.getInt("qfile_search_param_exparams_peer_type");
    if (i == 1) {
      paramQQAppInterface = new QlinkSendBarManager(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    } else if (i == 5) {
      paramQQAppInterface = new PrinterSendBarManager(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    } else {
      paramQQAppInterface = new QFileSendBarManager(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    }
    paramQQAppInterface.a(paramBundle);
    return paramQQAppInterface;
  }
  
  public void a() {}
  
  protected void a(int paramInt, Intent paramIntent)
  {
    if (paramIntent != null) {
      paramIntent = new Intent(paramIntent);
    } else {
      paramIntent = new Intent();
    }
    paramIntent.putExtra("qfile_send_bottom_bar_finish_result_code", -1);
    Activity localActivity = (Activity)this.a;
    localActivity.setResult(paramInt, paramIntent);
    localActivity.finish();
  }
  
  protected void a(Intent paramIntent)
  {
    a(-1, paramIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.d = paramBundle;
      this.e = true;
      return;
    }
    this.e = false;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QFileCustomBottomBarManager
 * JD-Core Version:    0.7.0.1
 */