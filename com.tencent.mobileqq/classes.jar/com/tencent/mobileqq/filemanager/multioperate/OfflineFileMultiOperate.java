package com.tencent.mobileqq.filemanager.multioperate;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OfflineFileMultiOperate
  implements IQFileMultiOperate<FileManagerEntity>
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public OfflineFileMultiOperate(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void e(List<FileManagerEntity> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    if (paramList == null)
    {
      QLog.w("OfflineFileMultiOperate", 1, "fileList == null");
      return;
    }
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      paramQFileMultiOperateCallback = (FileManagerEntity)paramList.next();
      if (QfavBuilder.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramQFileMultiOperateCallback, null, true)) {
        break label96;
      }
      i = 1;
    }
    label96:
    for (;;)
    {
      break;
      if (i != 0)
      {
        FileManagerUtil.c(this.jdField_a_of_type_AndroidAppActivity.getString(2131698158));
        return;
      }
      FMToastUtil.b(this.jdField_a_of_type_AndroidAppActivity.getString(2131719640));
      return;
    }
  }
  
  public void a(List<FileManagerEntity> paramList, int paramInt, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("OfflineFileMultiOperate", 1, "doFileMultiOperate no any file");
      return;
    }
    switch (paramInt)
    {
    default: 
      QLog.e("OfflineFileMultiOperate", 1, "doFileMultiOperate unkonw optype:" + paramInt);
      return;
    case 3: 
      a(paramList, paramQFileMultiOperateCallback);
      return;
    case 1: 
      b(paramList, paramQFileMultiOperateCallback);
      return;
    case 2: 
      c(paramList, paramQFileMultiOperateCallback);
      return;
    case 4: 
      d(paramList, paramQFileMultiOperateCallback);
      return;
    }
    e(paramList, paramQFileMultiOperateCallback);
  }
  
  protected void a(List<FileManagerEntity> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (FileManagerEntity)localIterator.next();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, ((FileManagerEntity)localObject).uniseq);
      if (localObject != null) {
        localArrayList.add((ChatMessage)localObject);
      }
    }
    if (localArrayList.size() > 0)
    {
      ThreadManager.post(new OfflineFileMultiOperate.1(this, localArrayList, paramList, paramQFileMultiOperateCallback), 8, null, true);
      return;
    }
    ThreadManagerV2.executeOnSubThread(new OfflineFileMultiOperate.2(this, paramList, paramQFileMultiOperateCallback));
  }
  
  protected void b(List<FileManagerEntity> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    if (!NetworkUtil.d(BaseApplication.getContext())) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694510, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299166));
    }
    long l;
    do
    {
      return;
      l = 0L;
      if ((paramList.size() != 1) || (!((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful())) {
        break;
      }
      FMToastUtil.a(2131692511);
    } while (paramQFileMultiOperateCallback == null);
    paramQFileMultiOperateCallback.a(1, 2);
    return;
    Object localObject = paramList.iterator();
    label90:
    FileManagerEntity localFileManagerEntity;
    if (((Iterator)localObject).hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if (!FileModel.a(localFileManagerEntity).a(true)) {
        break label247;
      }
      l = localFileManagerEntity.fileSize + l;
    }
    label247:
    for (;;)
    {
      break label90;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine();
      if ((FileManagerUtil.a()) && (l > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
      {
        FileManagerUtil.a(false, this.jdField_a_of_type_AndroidAppActivity, new OfflineFileMultiOperate.3(this, paramList, (FileManagerEngine)localObject, paramQFileMultiOperateCallback));
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localFileManagerEntity = (FileManagerEntity)paramList.next();
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          ((FileManagerEngine)localObject).c(localFileManagerEntity);
        }
      }
      if (paramQFileMultiOperateCallback == null) {
        break;
      }
      paramQFileMultiOperateCallback.a(1, 0);
      return;
    }
  }
  
  protected void c(List<FileManagerEntity> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    if (!NetworkUtil.d(BaseApplication.getContext())) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694510, 1).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299166));
    }
    do
    {
      return;
      if ((paramList.size() != 1) || (!((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful())) {
        break;
      }
      FMToastUtil.a(2131692512);
    } while (paramQFileMultiOperateCallback == null);
    paramQFileMultiOperateCallback.a(2, 3);
    return;
    Iterator localIterator = paramList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!FileModel.a((FileManagerEntity)localIterator.next()).a(false));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        FMDialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131692609, 2131692614, new OfflineFileMultiOperate.4(this, paramList, paramQFileMultiOperateCallback));
        return;
      }
      FileManagerUtil.a(paramList, this.jdField_a_of_type_AndroidAppActivity);
      if (paramQFileMultiOperateCallback == null) {
        break;
      }
      paramQFileMultiOperateCallback.a(2, 0);
      return;
    }
  }
  
  protected void d(List<FileManagerEntity> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    Object localObject1 = (FileManagerEntity)paramList.get(0);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine();
    if ((paramList.size() == 1) && (((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful()))
    {
      FMToastUtil.a(2131692513);
      return;
    }
    Object localObject2 = paramList.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (!FileModel.a((FileManagerEntity)((Iterator)localObject2).next()).a(false));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (!FreeWifiHelper.a(this.jdField_a_of_type_AndroidAppActivity, 5, new OfflineFileMultiOperate.5(this, paramList, (FileManagerEngine)localObject1, paramQFileMultiOperateCallback))) {
          break;
        }
        FMDialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131692609, 2131692612, new OfflineFileMultiOperate.6(this, paramList, (FileManagerEngine)localObject1, paramQFileMultiOperateCallback));
        return;
      }
      FMToastUtil.d(this.jdField_a_of_type_AndroidAppActivity.getString(2131692733));
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (FileManagerEntity)paramList.next();
        if (!((FileManagerEntity)localObject2).sendCloudUnsuccessful()) {
          if (FileUtils.b(((FileManagerEntity)localObject2).getFilePath())) {
            ((FileManagerEngine)localObject1).a(((FileManagerEntity)localObject2).getFilePath(), "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, false);
          } else {
            ((FileManagerEngine)localObject1).a((FileManagerEntity)localObject2, String.valueOf(((FileManagerEntity)localObject2).peerUin));
          }
        }
      }
      if (paramQFileMultiOperateCallback == null) {
        break;
      }
      paramQFileMultiOperateCallback.a(4, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multioperate.OfflineFileMultiOperate
 * JD-Core Version:    0.7.0.1
 */