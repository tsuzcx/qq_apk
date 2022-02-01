package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import java.util.ArrayList;
import java.util.List;

public class TroopFileViewerParamParser
{
  protected int a;
  protected QQAppInterface a;
  protected FileManagerEntity a;
  protected List<IFileViewerAdapter> a;
  private int b = 0;
  
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
    return new TroopFileViewerParamParser.1(this, paramBaseActivity);
  }
  
  public List<IFileViewerAdapter> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public boolean a(Intent paramIntent, Activity paramActivity)
  {
    Object localObject = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
    if (localObject == null) {
      return false;
    }
    if (paramIntent.getBooleanExtra("from_webview", false))
    {
      TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ForwardFileInfo)localObject).a(), ((ForwardFileInfo)localObject).b(), ((ForwardFileInfo)localObject).e(), ((ForwardFileInfo)localObject).d(), ((ForwardFileInfo)localObject).d(), paramIntent.getIntExtra("bisId", 0));
      l1 = ((ForwardFileInfo)localObject).a();
      localObject = paramIntent.getStringExtra("sender_uin");
      long l2 = paramIntent.getLongExtra("last_time", 0L);
      QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramActivity, null, null, l1, localTroopFileStatusInfo, (String)localObject, l2, -1, 0, null, false, false);
      paramActivity.finish();
      return false;
    }
    long l1 = ((ForwardFileInfo)localObject).b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(l1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.TroopFileViewerParamParser
 * JD-Core Version:    0.7.0.1
 */