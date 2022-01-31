package com.tencent.mobileqq.filemanager.core;

import acyu;
import acyw;
import acyx;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavPluginProxyService;
import cooperation.qqfav.ipc.FavoritesRemoteCommand;
import cooperation.qqfav.ipc.FavoritesRemoteCommand.IRemoteCommandHandler;

public class QfavFilePreviewController
  extends FilePreViewControllerBase
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private FavoritesRemoteCommand.IRemoteCommandHandler jdField_a_of_type_CooperationQqfavIpcFavoritesRemoteCommand$IRemoteCommandHandler = new acyu(this);
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int = 80;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public QfavFilePreviewController(Bundle paramBundle)
  {
    QfavPluginProxyService.a().a(3, this.jdField_a_of_type_CooperationQqfavIpcFavoritesRemoteCommand$IRemoteCommandHandler);
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new acyw(this), 300000L);
  }
  
  public int a()
  {
    return 4;
  }
  
  public boolean a()
  {
    if (3 != this.jdField_a_of_type_Int)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("QfavFilePreviewController", 4, "sendCS: oldState = " + this.jdField_a_of_type_Int + ", newState = STATE_REQUESTING.");
      }
      this.jdField_a_of_type_Int = 1;
      return true;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new acyx(this), 2000L);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    QfavPluginProxyService.a().b(3, this.jdField_a_of_type_CooperationQqfavIpcFavoritesRemoteCommand$IRemoteCommandHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController
 * JD-Core Version:    0.7.0.1
 */