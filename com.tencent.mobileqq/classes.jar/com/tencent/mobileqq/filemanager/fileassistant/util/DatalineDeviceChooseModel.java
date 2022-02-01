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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramContext.getResources().getString(2131698283));
    localActionSheet.setMainTitle(localStringBuilder.toString());
    localActionSheet.addButton(2131698282, 5);
    localActionSheet.addButton(2131698281, 5);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnDismissListener(new DatalineDeviceChooseModel.1(this, paramDeviceChooseInterface));
    localActionSheet.setOnButtonClickListener(new DatalineDeviceChooseModel.2(this, paramDeviceChooseInterface, localActionSheet));
    localActionSheet.show();
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (!FileUtil.a(paramFileManagerEntity.getFilePath()))
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("checkEntity:");
      paramQQAppInterface.append(paramFileManagerEntity.nSessionId);
      paramQQAppInterface.append(", not LocalFile!");
      QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, paramQQAppInterface.toString());
      return false;
    }
    long l = QFileAssistantUtils.a(paramQQAppInterface);
    if (paramFileManagerEntity.fileSize < l)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("checkEntity:");
      paramQQAppInterface.append(paramFileManagerEntity.nSessionId);
      paramQQAppInterface.append(", fileSize[");
      paramQQAppInterface.append(paramFileManagerEntity.fileSize);
      paramQQAppInterface.append("] < limitSize[");
      paramQQAppInterface.append(l);
      paramQQAppInterface.append("]");
      QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, paramQQAppInterface.toString());
      return false;
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("checkEntity:");
    paramQQAppInterface.append(paramFileManagerEntity.nSessionId);
    paramQQAppInterface.append(", is LocalFile,and size is Over:");
    paramQQAppInterface.append(paramFileManagerEntity.fileSize);
    QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, paramQQAppInterface.toString());
    return true;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0) && (!paramBoolean))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkForwardFileInfo forwardFileInfos size : ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilArrayList.size());
      QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, ((StringBuilder)localObject1).toString());
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ForwardFileInfo)((Iterator)localObject1).next();
        int i = ((ForwardFileInfo)localObject2).b();
        long l1 = QFileAssistantUtils.a(paramQQAppInterface);
        if ((i != 10000) && (i != 10001) && (i != 10006))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("checkForwardFileInfo unknow type:");
          ((StringBuilder)localObject2).append(i);
          QLog.w("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, ((StringBuilder)localObject2).toString());
        }
        else
        {
          boolean bool = FileUtil.a(((ForwardFileInfo)localObject2).a());
          long l2 = ((ForwardFileInfo)localObject2).d();
          if ((bool) && (((ForwardFileInfo)localObject2).d() > l1))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("checkForwardFileInfo size[");
            ((StringBuilder)localObject2).append(l2);
            ((StringBuilder)localObject2).append(" > onlyOfflineLimitSize[");
            ((StringBuilder)localObject2).append(l1);
            ((StringBuilder)localObject2).append("] ");
            QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, ((StringBuilder)localObject2).toString());
            paramBoolean = true;
          }
        }
      }
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("checkForwardFileInfo return : ");
      paramQQAppInterface.append(paramBoolean);
      QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, paramQQAppInterface.toString());
      return paramBoolean;
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("checkForwardFileInfo forwardFileInfos is null or isNeedCheckIpadStatus : ");
    paramQQAppInterface.append(paramBoolean);
    QLog.w("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, paramQQAppInterface.toString());
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
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (a(paramQQAppInterface, (FileManagerEntity)((Iterator)localObject).next()))
        {
          bool1 = true;
          break label57;
        }
      }
    }
    boolean bool1 = false;
    label57:
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    boolean bool2 = bool1;
    if (localObject != null)
    {
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (a(paramQQAppInterface, (FileManagerEntity)localObject)) {
          bool2 = true;
        }
      }
    }
    if (((IQFileConfigManager)paramQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).isWlanOnly()) {
      bool2 = true;
    }
    bool2 = a(paramQQAppInterface, b(paramQQAppInterface, c(paramQQAppInterface, d(paramQQAppInterface, bool2))));
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
  }
  
  private boolean b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaUtilSet != null) && (!paramBoolean))
    {
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
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("checkLocalFileInfos troopFileStatusInfo size[");
      paramQQAppInterface.append(l2);
      paramQQAppInterface.append(" > onlyOfflineLimitSize[");
      paramQQAppInterface.append(l1);
      paramQQAppInterface.append("] ");
      QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, paramQQAppInterface.toString());
      boolean bool = true;
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("checkLocalFileInfos return : ");
      paramQQAppInterface.append(bool);
      QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, paramQQAppInterface.toString());
      return bool;
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("checkLocalFileInfos lstLocals is null or isNeedCheckIpadStatus : ");
    paramQQAppInterface.append(paramBoolean);
    QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, paramQQAppInterface.toString());
    return paramBoolean;
  }
  
  private boolean c(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((this.c != null) && (!paramBoolean))
    {
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
            break label171;
          }
          str = (String)paramQQAppInterface.next();
          if (FileUtil.a(str)) {
            break;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkLocalPaths file NotExisited:");
          localStringBuilder.append(str);
          QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, localStringBuilder.toString());
        }
        l2 = FileManagerUtil.a(str);
      } while (l2 <= l1);
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("checkLocalPaths troopFileStatusInfo size[");
      paramQQAppInterface.append(l2);
      paramQQAppInterface.append(" > onlyOfflineLimitSize[");
      paramQQAppInterface.append(l1);
      paramQQAppInterface.append("] ");
      QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, paramQQAppInterface.toString());
      boolean bool = true;
      label171:
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("checkLocalPaths return:");
      paramQQAppInterface.append(bool);
      QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, paramQQAppInterface.toString());
      return bool;
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("checkLocalPaths lstPaths null ro isNeedCheckIpadStatus:");
    paramQQAppInterface.append(paramBoolean);
    QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, paramQQAppInterface.toString());
    return paramBoolean;
  }
  
  private boolean d(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((this.b != null) && (!paramBoolean))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkMsgList: lstMsg size : ");
      ((StringBuilder)localObject1).append(this.b.size());
      QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, ((StringBuilder)localObject1).toString());
      long l = QFileAssistantUtils.a(paramQQAppInterface);
      localObject1 = this.b.iterator();
      boolean bool;
      Object localObject2;
      do
      {
        bool = paramBoolean;
        if (!((Iterator)localObject1).hasNext()) {
          break label259;
        }
        localObject2 = (ChatMessage)((Iterator)localObject1).next();
        if (!(localObject2 instanceof MessageForFile)) {
          break;
        }
      } while (!a(paramQQAppInterface, FileManagerUtil.a(paramQQAppInterface, (MessageForFile)localObject2)));
      for (;;)
      {
        bool = true;
        break label259;
        if (!(localObject2 instanceof MessageForTroopFile)) {
          break;
        }
        localObject2 = TroopFileUtils.a(paramQQAppInterface, (MessageForTroopFile)localObject2);
        if (localObject2 == null)
        {
          QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkMsgList: troopFileStatusInfo null ");
          break;
        }
        if (!FileUtil.a(((TroopFileStatusInfo)localObject2).a))
        {
          QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkMsgList troopFileStatusInfo not localFile ");
          break;
        }
        if (((TroopFileStatusInfo)localObject2).c <= l) {
          break;
        }
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("checkMsgList troopFileStatusInfo size[");
        paramQQAppInterface.append(((TroopFileStatusInfo)localObject2).c);
        paramQQAppInterface.append(" > onlyOfflineLimitSize[");
        paramQQAppInterface.append(l);
        paramQQAppInterface.append("] ");
        QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, paramQQAppInterface.toString());
      }
      label259:
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("checkMsgList return:");
      paramQQAppInterface.append(bool);
      QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, paramQQAppInterface.toString());
      return bool;
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("checkMsgList: lstMsg is null or isNeedCheckIpadStatus : ");
    paramQQAppInterface.append(paramBoolean);
    QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, paramQQAppInterface.toString());
    return paramBoolean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.util.DatalineDeviceChooseModel
 * JD-Core Version:    0.7.0.1
 */