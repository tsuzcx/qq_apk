package com.tencent.mobileqq.filemanager.multioperate;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DatalineFileMultiOperate
  implements IQFileMultiOperate<FileManagerEntity>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private OfflineFileMultiOperate jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateOfflineFileMultiOperate;
  
  public DatalineFileMultiOperate(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateOfflineFileMultiOperate = new OfflineFileMultiOperate(paramQQAppInterface, paramActivity);
  }
  
  private long a(List<FileManagerEntity> paramList1, List<FileManagerEntity> paramList2)
  {
    paramList1 = paramList1.iterator();
    long l = 0L;
    if (paramList1.hasNext())
    {
      paramList2 = (FileManagerEntity)paramList1.next();
      if (FileUtils.b(paramList2.strFilePath)) {
        break label50;
      }
      l = paramList2.fileSize + l;
    }
    label50:
    for (;;)
    {
      break;
      return l;
    }
  }
  
  private List<List<FileManagerEntity>> a(List<FileManagerEntity> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    localArrayList3.add(localArrayList2);
    localArrayList3.add(localArrayList1);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramList.next();
      if (a(localFileManagerEntity)) {
        localArrayList2.add(localFileManagerEntity);
      } else {
        localArrayList1.add(localFileManagerEntity);
      }
    }
    return localArrayList3;
  }
  
  private List<ChatMessage> a(List<FileManagerEntity> paramList1, List<FileManagerEntity> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      Object localObject = (FileManagerEntity)paramList2.next();
      String str = ((IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(str, 0, ((FileManagerEntity)localObject).uniseq);
      if (localObject != null) {
        localArrayList.add((ChatMessage)localObject);
      }
    }
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (FileManagerEntity)paramList1.next();
      paramList2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramList2.peerUin, paramList2.peerType, paramList2.uniseq);
      if (paramList2 != null) {
        localArrayList.add((ChatMessage)paramList2);
      }
    }
    return localArrayList;
  }
  
  private void a(QFileMultiOperateCallback paramQFileMultiOperateCallback, int paramInt1, int paramInt2)
  {
    ThreadManagerV2.getUIHandlerV2().post(new DatalineFileMultiOperate.4(this, paramQFileMultiOperateCallback, paramInt1, paramInt2));
  }
  
  private void a(List<ChatMessage> paramList)
  {
    if (paramList.size() == 1) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((MessageRecord)paramList.get(0), false);
    }
    while (paramList.size() <= 1) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramList, false);
  }
  
  private void a(List<FileManagerEntity> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    paramList = a(paramList);
    paramQFileMultiOperateCallback = (List)paramList.get(1);
    paramList = (List)paramList.get(0);
    paramQFileMultiOperateCallback = paramQFileMultiOperateCallback.iterator();
    int i = 0;
    if (paramQFileMultiOperateCallback.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramQFileMultiOperateCallback.next();
      if (QfavBuilder.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, null, true)) {
        break label208;
      }
      i = 1;
    }
    label208:
    for (;;)
    {
      break;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        long l = ((FileManagerEntity)paramList.next()).datalineEntitySessionId;
        int j = DataLineMsgRecord.getDevTypeBySeId(l);
        paramQFileMultiOperateCallback = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(j).a(l);
        if ((paramQFileMultiOperateCallback != null) && (FileUtils.b(paramQFileMultiOperateCallback.path)) && (!QfavBuilder.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramQFileMultiOperateCallback.path))) {
          i = 1;
        }
      }
      if (i != 0)
      {
        FileManagerUtil.c(this.jdField_a_of_type_AndroidContentContext.getString(2131698158));
        return;
      }
      FMToastUtil.b(this.jdField_a_of_type_AndroidContentContext.getString(2131719640));
      return;
    }
  }
  
  private void a(List<FileManagerEntity> paramList1, List<FileManagerEntity> paramList2)
  {
    FileManagerEngine localFileManagerEngine = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramList1.next();
      if (FileUtils.b(localFileManagerEntity.getFilePath())) {
        localFileManagerEngine.a(localFileManagerEntity.getFilePath(), "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, false);
      } else {
        localFileManagerEngine.a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
      }
    }
    paramList1 = paramList2.iterator();
    while (paramList1.hasNext())
    {
      long l = ((FileManagerEntity)paramList1.next()).datalineEntitySessionId;
      int i = DataLineMsgRecord.getDevTypeBySeId(l);
      paramList2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(l);
      if ((paramList2 != null) && (FileUtils.b(paramList2.path)))
      {
        paramList2.nWeiyunSessionId = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(paramList2.path, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, false).nSessionId;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).d(paramList2.msgId);
      }
    }
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return paramFileManagerEntity.peerType == 6000;
  }
  
  private void b(List<FileManagerEntity> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694510, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
      return;
    }
    paramQFileMultiOperateCallback = a(paramList);
    paramList = (List)paramQFileMultiOperateCallback.get(1);
    paramQFileMultiOperateCallback = (List)paramQFileMultiOperateCallback.get(0);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    label95:
    FileManagerEntity localFileManagerEntity;
    for (long l1 = 0L; localIterator.hasNext(); l1 = localFileManagerEntity.fileSize + l1)
    {
      localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((localFileManagerEntity.cloudType == 0) || (localFileManagerEntity.status == 16)) {
        break label95;
      }
      localArrayList1.add(localFileManagerEntity);
    }
    localIterator = paramQFileMultiOperateCallback.iterator();
    while (localIterator.hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)localIterator.next();
      long l2 = localFileManagerEntity.datalineEntitySessionId;
      int i = DataLineMsgRecord.getDevTypeBySeId(l2);
      DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(l2);
      if ((localDataLineMsgRecord != null) && (FileUtils.b(localDataLineMsgRecord.path)))
      {
        localArrayList2.add(localFileManagerEntity);
        l1 += localDataLineMsgRecord.filesize;
      }
    }
    if ((paramList.size() + paramQFileMultiOperateCallback.size() > 0) && (localArrayList1.size() + localArrayList2.size() == 0))
    {
      FMToastUtil.a(2131692605);
      return;
    }
    if ((FileManagerUtil.a()) && (l1 > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      FMDialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131692609, 2131692614, new DatalineFileMultiOperate.1(this, localArrayList1, localArrayList2));
      return;
    }
    a(localArrayList1, localArrayList2);
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131692733, 0).a();
  }
  
  private void b(List<FileManagerEntity> paramList1, List<FileManagerEntity> paramList2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine();
    paramList1 = paramList1.iterator();
    FileManagerEntity localFileManagerEntity;
    while (paramList1.hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)paramList1.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        ((FileManagerEngine)localObject).c(localFileManagerEntity);
      }
    }
    paramList1 = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    localObject = new ArrayList();
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)paramList2.next();
      int i = DataLineMsgRecord.getDevTypeBySeId(localFileManagerEntity.datalineEntitySessionId);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i);
      ((List)localObject).add(Long.valueOf(localFileManagerEntity.datalineEntitySessionId));
    }
    if (!((List)localObject).isEmpty()) {
      paramList1.a((List)localObject);
    }
  }
  
  private void c(List<FileManagerEntity> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateOfflineFileMultiOperate.c(paramList, paramQFileMultiOperateCallback);
  }
  
  private void c(List<FileManagerEntity> paramList1, List<FileManagerEntity> paramList2)
  {
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramList2.next();
      int i = DataLineMsgRecord.getDevTypeBySeId(localFileManagerEntity.datalineEntitySessionId);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(localFileManagerEntity.datalineEntitySessionId);
    }
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (FileManagerEntity)paramList1.next();
      paramList2.bDelInAio = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().b(paramList2.nSessionId);
    }
  }
  
  private void d(List<FileManagerEntity> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    List localList = a(paramList);
    paramList = (List)localList.get(1);
    localList = (List)localList.get(0);
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694510, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
      return;
    }
    long l = a(paramList, localList);
    if ((FileManagerUtil.a()) && (l > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      FileManagerUtil.a(false, this.jdField_a_of_type_AndroidContentContext, new DatalineFileMultiOperate.2(this, paramList, localList, paramQFileMultiOperateCallback));
      return;
    }
    b(paramList, localList);
    a(paramQFileMultiOperateCallback, 1, 0);
  }
  
  private void e(List<FileManagerEntity> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    List localList = a(paramList);
    paramList = (List)localList.get(1);
    localList = (List)localList.get(0);
    ThreadManagerV2.executeOnSubThread(new DatalineFileMultiOperate.3(this, a(paramList, localList), paramList, localList, paramQFileMultiOperateCallback));
  }
  
  public void a(List<FileManagerEntity> paramList, int paramInt, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("DatalineFileMultiOperate", 1, "doFileMultiOperate no any file");
      return;
    }
    switch (paramInt)
    {
    default: 
      QLog.e("DatalineFileMultiOperate", 1, "doFileMultiOperate unkonw optype:" + paramInt);
      return;
    case 3: 
      e(paramList, paramQFileMultiOperateCallback);
      return;
    case 1: 
      d(paramList, paramQFileMultiOperateCallback);
      return;
    case 2: 
      c(paramList, paramQFileMultiOperateCallback);
      return;
    case 4: 
      b(paramList, paramQFileMultiOperateCallback);
      return;
    }
    a(paramList, paramQFileMultiOperateCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multioperate.DatalineFileMultiOperate
 * JD-Core Version:    0.7.0.1
 */