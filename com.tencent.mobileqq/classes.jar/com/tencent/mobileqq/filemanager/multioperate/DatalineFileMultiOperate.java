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
  private QQAppInterface a;
  private Context b;
  private OfflineFileMultiOperate c;
  
  public DatalineFileMultiOperate(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.a = paramQQAppInterface;
    this.b = paramActivity;
    this.c = new OfflineFileMultiOperate(paramQQAppInterface, paramActivity);
  }
  
  private void a(QFileMultiOperateCallback paramQFileMultiOperateCallback, int paramInt1, int paramInt2)
  {
    ThreadManagerV2.getUIHandlerV2().post(new DatalineFileMultiOperate.4(this, paramQFileMultiOperateCallback, paramInt1, paramInt2));
  }
  
  private void a(List<ChatMessage> paramList)
  {
    if (paramList.size() == 1)
    {
      this.a.getMessageFacade().a((MessageRecord)paramList.get(0), false);
      return;
    }
    if (paramList.size() > 1) {
      this.a.getMessageFacade().a(paramList, false);
    }
  }
  
  private void a(List<FileManagerEntity> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    paramList = b(paramList);
    paramQFileMultiOperateCallback = (List)paramList.get(1);
    int i = 0;
    paramList = (List)paramList.get(0);
    paramQFileMultiOperateCallback = paramQFileMultiOperateCallback.iterator();
    while (paramQFileMultiOperateCallback.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramQFileMultiOperateCallback.next();
      if (!QfavBuilder.a().a(this.a, this.b, localFileManagerEntity, null, true)) {
        i = 1;
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      long l = ((FileManagerEntity)paramList.next()).datalineEntitySessionId;
      int j = DataLineMsgRecord.getDevTypeBySeId(l);
      paramQFileMultiOperateCallback = this.a.getMessageFacade().d(j).a(l);
      if ((paramQFileMultiOperateCallback != null) && (FileUtils.fileExistsAndNotEmpty(paramQFileMultiOperateCallback.path)) && (!QfavBuilder.a().a(this.a, this.b, paramQFileMultiOperateCallback.path))) {
        i = 1;
      }
    }
    if (i != 0)
    {
      FileManagerUtil.l(this.b.getString(2131896096));
      return;
    }
    FMToastUtil.b(this.b.getString(2131916911));
  }
  
  private void a(List<FileManagerEntity> paramList1, List<FileManagerEntity> paramList2)
  {
    FileManagerEngine localFileManagerEngine = this.a.getFileManagerEngine();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramList1.next();
      if (FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) {
        localFileManagerEngine.a(localFileManagerEntity.getFilePath(), "", this.a.getCurrentAccountUin(), 0, false);
      } else {
        localFileManagerEngine.a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
      }
    }
    paramList1 = paramList2.iterator();
    while (paramList1.hasNext())
    {
      long l = ((FileManagerEntity)paramList1.next()).datalineEntitySessionId;
      int i = DataLineMsgRecord.getDevTypeBySeId(l);
      paramList2 = this.a.getMessageFacade().d(i).a(l);
      if ((paramList2 != null) && (FileUtils.fileExistsAndNotEmpty(paramList2.path)))
      {
        paramList2.nWeiyunSessionId = this.a.getFileManagerEngine().a(paramList2.path, null, this.a.getAccount(), 0, false).nSessionId;
        this.a.getMessageFacade().d(i).f(paramList2.msgId);
      }
    }
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return paramFileManagerEntity.peerType == 6000;
  }
  
  private List<List<FileManagerEntity>> b(List<FileManagerEntity> paramList)
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
  
  private void b(List<FileManagerEntity> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.makeText(this.b, 2131892157, 1).show(this.b.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    paramQFileMultiOperateCallback = b(paramList);
    paramList = (List)paramQFileMultiOperateCallback.get(1);
    paramQFileMultiOperateCallback = (List)paramQFileMultiOperateCallback.get(0);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    long l1 = 0L;
    Iterator localIterator = paramList.iterator();
    FileManagerEntity localFileManagerEntity;
    while (localIterator.hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((localFileManagerEntity.cloudType != 0) && (localFileManagerEntity.status != 16))
      {
        localArrayList1.add(localFileManagerEntity);
        l1 += localFileManagerEntity.fileSize;
      }
    }
    localIterator = paramQFileMultiOperateCallback.iterator();
    while (localIterator.hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)localIterator.next();
      long l2 = localFileManagerEntity.datalineEntitySessionId;
      int i = DataLineMsgRecord.getDevTypeBySeId(l2);
      DataLineMsgRecord localDataLineMsgRecord = this.a.getMessageFacade().d(i).a(l2);
      if ((localDataLineMsgRecord != null) && (FileUtils.fileExistsAndNotEmpty(localDataLineMsgRecord.path)))
      {
        localArrayList2.add(localFileManagerEntity);
        l1 += localDataLineMsgRecord.filesize;
      }
    }
    if ((paramList.size() + paramQFileMultiOperateCallback.size() > 0) && (localArrayList1.size() + localArrayList2.size() == 0))
    {
      FMToastUtil.a(2131889580);
      return;
    }
    if ((FileManagerUtil.b()) && (l1 > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      FMDialogUtil.a(this.b, 2131889584, 2131889589, new DatalineFileMultiOperate.1(this, localArrayList1, localArrayList2));
      return;
    }
    a(localArrayList1, localArrayList2);
    QQToast.makeText(this.b, 2131889761, 0).show();
  }
  
  private void b(List<FileManagerEntity> paramList1, List<FileManagerEntity> paramList2)
  {
    Object localObject = this.a.getFileManagerEngine();
    paramList1 = paramList1.iterator();
    FileManagerEntity localFileManagerEntity;
    while (paramList1.hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)paramList1.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        ((FileManagerEngine)localObject).h(localFileManagerEntity);
      }
    }
    paramList1 = (DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    localObject = new ArrayList();
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)paramList2.next();
      int i = DataLineMsgRecord.getDevTypeBySeId(localFileManagerEntity.datalineEntitySessionId);
      this.a.getMessageFacade().d(i);
      ((List)localObject).add(Long.valueOf(localFileManagerEntity.datalineEntitySessionId));
    }
    if (!((List)localObject).isEmpty()) {
      paramList1.b((List)localObject);
    }
  }
  
  private long c(List<FileManagerEntity> paramList1, List<FileManagerEntity> paramList2)
  {
    paramList1 = paramList1.iterator();
    long l = 0L;
    while (paramList1.hasNext())
    {
      paramList2 = (FileManagerEntity)paramList1.next();
      if (!FileUtils.fileExistsAndNotEmpty(paramList2.strFilePath)) {
        l += paramList2.fileSize;
      }
    }
    return l;
  }
  
  private void c(List<FileManagerEntity> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    this.c.c(paramList, paramQFileMultiOperateCallback);
  }
  
  private void d(List<FileManagerEntity> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    List localList = b(paramList);
    paramList = (List)localList.get(1);
    localList = (List)localList.get(0);
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.makeText(this.b, 2131892157, 1).show(this.b.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    long l = c(paramList, localList);
    if ((FileManagerUtil.b()) && (l > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      FileManagerUtil.a(false, this.b, new DatalineFileMultiOperate.2(this, paramList, localList, paramQFileMultiOperateCallback));
      return;
    }
    b(paramList, localList);
    a(paramQFileMultiOperateCallback, 1, 0);
  }
  
  private void d(List<FileManagerEntity> paramList1, List<FileManagerEntity> paramList2)
  {
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramList2.next();
      int i = DataLineMsgRecord.getDevTypeBySeId(localFileManagerEntity.datalineEntitySessionId);
      this.a.getMessageFacade().d(i).h(localFileManagerEntity.datalineEntitySessionId);
    }
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (FileManagerEntity)paramList1.next();
      paramList2.bDelInAio = true;
      this.a.getFileManagerEngine().c(paramList2.nSessionId);
    }
  }
  
  private List<ChatMessage> e(List<FileManagerEntity> paramList1, List<FileManagerEntity> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      Object localObject = (FileManagerEntity)paramList2.next();
      String str = ((IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin();
      localObject = this.a.getMessageFacade().b(str, 0, ((FileManagerEntity)localObject).uniseq);
      if (localObject != null) {
        localArrayList.add((ChatMessage)localObject);
      }
    }
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (FileManagerEntity)paramList1.next();
      paramList2 = this.a.getMessageFacade().b(paramList2.peerUin, paramList2.peerType, paramList2.uniseq);
      if (paramList2 != null) {
        localArrayList.add((ChatMessage)paramList2);
      }
    }
    return localArrayList;
  }
  
  private void e(List<FileManagerEntity> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    List localList = b(paramList);
    paramList = (List)localList.get(1);
    localList = (List)localList.get(0);
    ThreadManagerV2.executeOnSubThread(new DatalineFileMultiOperate.3(this, e(paramList, localList), paramList, localList, paramQFileMultiOperateCallback));
  }
  
  public void a(List<FileManagerEntity> paramList, int paramInt, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5)
              {
                paramList = new StringBuilder();
                paramList.append("doFileMultiOperate unkonw optype:");
                paramList.append(paramInt);
                QLog.e("DatalineFileMultiOperate", 1, paramList.toString());
                return;
              }
              a(paramList, paramQFileMultiOperateCallback);
              return;
            }
            b(paramList, paramQFileMultiOperateCallback);
            return;
          }
          e(paramList, paramQFileMultiOperateCallback);
          return;
        }
        c(paramList, paramQFileMultiOperateCallback);
        return;
      }
      d(paramList, paramQFileMultiOperateCallback);
      return;
    }
    QLog.e("DatalineFileMultiOperate", 1, "doFileMultiOperate no any file");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multioperate.DatalineFileMultiOperate
 * JD-Core Version:    0.7.0.1
 */