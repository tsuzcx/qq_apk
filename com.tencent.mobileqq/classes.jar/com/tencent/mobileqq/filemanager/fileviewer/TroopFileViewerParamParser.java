package com.tencent.mobileqq.filemanager.fileviewer;

import adkn;
import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import java.util.ArrayList;
import java.util.List;

public class TroopFileViewerParamParser
{
  protected int a;
  protected QQAppInterface a;
  protected FileManagerEntity a;
  protected List a;
  private int b;
  
  TroopFileViewerParamParser(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public FileBrowserManager.IModelCreater a(BaseActivity paramBaseActivity)
  {
    return new adkn(this, paramBaseActivity);
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public boolean a(Intent paramIntent, Activity paramActivity)
  {
    ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
    if (localForwardFileInfo == null) {
      return false;
    }
    if (paramIntent.getBooleanExtra("from_webview", false))
    {
      TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localForwardFileInfo.a(), localForwardFileInfo.b(), localForwardFileInfo.e(), localForwardFileInfo.d(), localForwardFileInfo.d(), paramIntent.getIntExtra("bisId", 0));
      new TroopFileItemOperation(localForwardFileInfo.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramActivity).a(localTroopFileStatusInfo, paramIntent.getStringExtra("sender_uin"), paramIntent.getLongExtra("last_time", 0L), -1);
      paramActivity.finish();
      return false;
    }
    long l = localForwardFileInfo.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime = paramIntent.getLongExtra("last_time", 0L);
    this.jdField_a_of_type_JavaUtilList.add(FileViewerAdapterBase.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
    {
      this.jdField_a_of_type_Int = 1;
      return true;
    }
    this.jdField_a_of_type_Int = 3;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.TroopFileViewerParamParser
 * JD-Core Version:    0.7.0.1
 */