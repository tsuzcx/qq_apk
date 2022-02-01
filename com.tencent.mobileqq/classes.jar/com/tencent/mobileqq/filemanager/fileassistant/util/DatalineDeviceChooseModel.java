package com.tencent.mobileqq.filemanager.fileassistant.util;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DatalineDeviceChooseModel
{
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
  private ForwardFileOption jdField_a_of_type_ComTencentMobileqqForwardForwardFileOption = null;
  private ArrayList<ForwardFileInfo> jdField_a_of_type_JavaUtilArrayList = null;
  private List<FileManagerEntity> jdField_a_of_type_JavaUtilList = null;
  private Set<FileInfo> jdField_a_of_type_JavaUtilSet = null;
  private List<ChatMessage> b = null;
  private List<String> c = null;
  
  public static DatalineDeviceChooseModel a(FileManagerEntity paramFileManagerEntity)
  {
    DatalineDeviceChooseModel localDatalineDeviceChooseModel = new DatalineDeviceChooseModel();
    localDatalineDeviceChooseModel.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    return localDatalineDeviceChooseModel;
  }
  
  public static DatalineDeviceChooseModel a(ForwardFileOption paramForwardFileOption)
  {
    DatalineDeviceChooseModel localDatalineDeviceChooseModel = new DatalineDeviceChooseModel();
    localDatalineDeviceChooseModel.jdField_a_of_type_ComTencentMobileqqForwardForwardFileOption = paramForwardFileOption;
    return localDatalineDeviceChooseModel;
  }
  
  public static DatalineDeviceChooseModel a(ArrayList<ForwardFileInfo> paramArrayList)
  {
    DatalineDeviceChooseModel localDatalineDeviceChooseModel = new DatalineDeviceChooseModel();
    localDatalineDeviceChooseModel.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    return localDatalineDeviceChooseModel;
  }
  
  public static DatalineDeviceChooseModel a(List<String> paramList)
  {
    DatalineDeviceChooseModel localDatalineDeviceChooseModel = new DatalineDeviceChooseModel();
    localDatalineDeviceChooseModel.c = paramList;
    return localDatalineDeviceChooseModel;
  }
  
  public static DatalineDeviceChooseModel a(List<FileManagerEntity> paramList, Set<FileInfo> paramSet)
  {
    DatalineDeviceChooseModel localDatalineDeviceChooseModel = new DatalineDeviceChooseModel();
    localDatalineDeviceChooseModel.jdField_a_of_type_JavaUtilList = paramList;
    localDatalineDeviceChooseModel.jdField_a_of_type_JavaUtilSet = paramSet;
    return localDatalineDeviceChooseModel;
  }
  
  private void a(Context paramContext, DatalineDeviceChooseModel.DeviceChooseInterface paramDeviceChooseInterface)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(paramContext, null);
    String str = FileUtil.a(QFileAssistantUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime())).replace(".00", "");
    localActionSheet.setMainTitle(str + paramContext.getResources().getString(2131698219));
    localActionSheet.addButton(2131698218, 5);
    localActionSheet.addButton(2131698217, 5);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnDismissListener(new DatalineDeviceChooseModel.1(this, paramDeviceChooseInterface));
    localActionSheet.setOnButtonClickListener(new DatalineDeviceChooseModel.2(this, paramDeviceChooseInterface, localActionSheet));
    localActionSheet.show();
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (!FileUtil.b(paramFileManagerEntity.getFilePath()))
    {
      QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkEntity:" + paramFileManagerEntity.nSessionId + ", not LocalFile!");
      return false;
    }
    long l = QFileAssistantUtils.a(paramQQAppInterface);
    if (paramFileManagerEntity.fileSize < l)
    {
      QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkEntity:" + paramFileManagerEntity.nSessionId + ", fileSize[" + paramFileManagerEntity.fileSize + "] < limitSize[" + l + "]");
      return false;
    }
    QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkEntity:" + paramFileManagerEntity.nSessionId + ", is LocalFile,and size is Over:" + paramFileManagerEntity.fileSize);
    return true;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) || (paramBoolean))
    {
      QLog.w("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkForwardFileInfo forwardFileInfos is null or isNeedCheckIpadStatus : " + paramBoolean);
      return paramBoolean;
    }
    QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkForwardFileInfo forwardFileInfos size : " + this.jdField_a_of_type_JavaUtilArrayList.size());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)localIterator.next();
      int i = localForwardFileInfo.b();
      long l1 = QFileAssistantUtils.a(paramQQAppInterface);
      switch (i)
      {
      default: 
        QLog.w("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkForwardFileInfo unknow type:" + i);
        break;
      case 10000: 
      case 10001: 
      case 10006: 
        boolean bool = FileUtil.b(localForwardFileInfo.a());
        long l2 = localForwardFileInfo.d();
        if ((bool) && (localForwardFileInfo.d() > l1))
        {
          QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkForwardFileInfo size[" + l2 + " > onlyOfflineLimitSize[" + l1 + "] ");
          paramBoolean = true;
        }
        break;
      }
    }
    QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkForwardFileInfo return : " + paramBoolean);
    return paramBoolean;
  }
  
  public static DatalineDeviceChooseModel b(List<ChatMessage> paramList)
  {
    DatalineDeviceChooseModel localDatalineDeviceChooseModel = new DatalineDeviceChooseModel();
    localDatalineDeviceChooseModel.b = paramList;
    return localDatalineDeviceChooseModel;
  }
  
  private void b(Context paramContext, QQAppInterface paramQQAppInterface, DatalineDeviceChooseModel.DeviceChooseInterface paramDeviceChooseInterface)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!a(paramQQAppInterface, (FileManagerEntity)localIterator.next()));
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (!bool1) && (a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity))) {
        bool1 = true;
      }
      for (;;)
      {
        if (((IQFileConfigManager)paramQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).isWlanOnly()) {
          bool1 = true;
        }
        boolean bool2 = a(paramQQAppInterface, b(paramQQAppInterface, c(paramQQAppInterface, d(paramQQAppInterface, bool1))));
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileOption != null)
        {
          bool1 = bool2;
          if (!bool2)
          {
            long l = QFileAssistantUtils.a(paramQQAppInterface);
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileOption.a() > l) {
              bool1 = true;
            }
          }
        }
        if (!bool1)
        {
          QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkFiles isNeedCheckIpadStatus is false ");
          paramDeviceChooseInterface.a();
          return;
        }
        if (!QFileAssistantUtils.b(paramQQAppInterface))
        {
          QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkFiles isNeedShowPadOpts is false ");
          paramDeviceChooseInterface.a();
          return;
        }
        a(paramContext, paramDeviceChooseInterface);
        return;
      }
    }
  }
  
  private boolean b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaUtilSet == null) || (paramBoolean))
    {
      QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkLocalFileInfos lstLocals is null or isNeedCheckIpadStatus : " + paramBoolean);
      return paramBoolean;
    }
    long l1 = QFileAssistantUtils.a(paramQQAppInterface);
    paramQQAppInterface = this.jdField_a_of_type_JavaUtilSet.iterator();
    FileInfo localFileInfo;
    long l2;
    do
    {
      bool = paramBoolean;
      if (!paramQQAppInterface.hasNext()) {
        break;
      }
      localFileInfo = (FileInfo)paramQQAppInterface.next();
      l2 = localFileInfo.a();
    } while (localFileInfo.a() <= l1);
    QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkLocalFileInfos troopFileStatusInfo size[" + l2 + " > onlyOfflineLimitSize[" + l1 + "] ");
    boolean bool = true;
    QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkLocalFileInfos return : " + bool);
    return bool;
  }
  
  private boolean c(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((this.c == null) || (paramBoolean))
    {
      QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkLocalPaths lstPaths null ro isNeedCheckIpadStatus:" + paramBoolean);
      return paramBoolean;
    }
    long l1 = QFileAssistantUtils.a(paramQQAppInterface);
    paramQQAppInterface = this.c.iterator();
    long l2;
    do
    {
      String str;
      for (;;)
      {
        bool = paramBoolean;
        if (!paramQQAppInterface.hasNext()) {
          break label174;
        }
        str = (String)paramQQAppInterface.next();
        if (FileUtil.b(str)) {
          break;
        }
        QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkLocalPaths file NotExisited:" + str);
      }
      l2 = FileManagerUtil.a(str);
    } while (l2 <= l1);
    QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkLocalPaths troopFileStatusInfo size[" + l2 + " > onlyOfflineLimitSize[" + l1 + "] ");
    boolean bool = true;
    label174:
    QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkLocalPaths return:" + bool);
    return bool;
  }
  
  private boolean d(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((this.b == null) || (paramBoolean))
    {
      QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkMsgList: lstMsg is null or isNeedCheckIpadStatus : " + paramBoolean);
      return paramBoolean;
    }
    QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkMsgList: lstMsg size : " + this.b.size());
    long l = QFileAssistantUtils.a(paramQQAppInterface);
    Iterator localIterator = this.b.iterator();
    Object localObject;
    do
    {
      bool = paramBoolean;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (ChatMessage)localIterator.next();
      if (!(localObject instanceof MessageForFile)) {
        break label169;
      }
    } while (!a(paramQQAppInterface, FileManagerUtil.a(paramQQAppInterface, (MessageForFile)localObject)));
    for (boolean bool = true;; bool = true)
    {
      QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkMsgList return:" + bool);
      return bool;
      label169:
      if (!(localObject instanceof MessageForTroopFile)) {
        break;
      }
      localObject = TroopFileUtils.a(paramQQAppInterface, (MessageForTroopFile)localObject);
      if (localObject == null)
      {
        QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkMsgList: troopFileStatusInfo null ");
        break;
      }
      if (!FileUtil.b(((TroopFileStatusInfo)localObject).a))
      {
        QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkMsgList troopFileStatusInfo not localFile ");
        break;
      }
      if (((TroopFileStatusInfo)localObject).c <= l) {
        break;
      }
      QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkMsgList troopFileStatusInfo size[" + ((TroopFileStatusInfo)localObject).c + " > onlyOfflineLimitSize[" + l + "] ");
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
    this.b = null;
    this.c = null;
    this.jdField_a_of_type_JavaUtilSet = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileOption = null;
    QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "setHideActionSheet clear all parames");
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, DatalineDeviceChooseModel.DeviceChooseInterface paramDeviceChooseInterface)
  {
    if (!QFileAssistantUtils.a(paramQQAppInterface))
    {
      paramDeviceChooseInterface.b();
      return;
    }
    b(paramContext, paramQQAppInterface, paramDeviceChooseInterface);
  }
  
  public void a(Context paramContext, String paramString, DatalineDeviceChooseModel.DeviceChooseInterface paramDeviceChooseInterface)
  {
    if (!QFileAssistantUtils.a(paramString))
    {
      QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkFileAssistantAndChooseDevice switch is not open!");
      paramDeviceChooseInterface.b();
      return;
    }
    b(paramContext, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramDeviceChooseInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.util.DatalineDeviceChooseModel
 * JD-Core Version:    0.7.0.1
 */