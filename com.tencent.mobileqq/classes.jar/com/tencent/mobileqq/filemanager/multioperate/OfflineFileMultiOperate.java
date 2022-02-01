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
import com.tencent.mobileqq.filemanager.recreate.IFModel;
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
  private QQAppInterface a;
  private Activity b;
  
  public OfflineFileMultiOperate(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.a = paramQQAppInterface;
    this.b = paramActivity;
  }
  
  private void e(List<FileManagerEntity> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    if (paramList == null)
    {
      QLog.w("OfflineFileMultiOperate", 1, "fileList == null");
      return;
    }
    int i = 0;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramQFileMultiOperateCallback = (FileManagerEntity)paramList.next();
      if (!QfavBuilder.a().a(this.a, this.b, paramQFileMultiOperateCallback, null, true)) {
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
                QLog.e("OfflineFileMultiOperate", 1, paramList.toString());
                return;
              }
              e(paramList, paramQFileMultiOperateCallback);
              return;
            }
            d(paramList, paramQFileMultiOperateCallback);
            return;
          }
          a(paramList, paramQFileMultiOperateCallback);
          return;
        }
        c(paramList, paramQFileMultiOperateCallback);
        return;
      }
      b(paramList, paramQFileMultiOperateCallback);
      return;
    }
    QLog.e("OfflineFileMultiOperate", 1, "doFileMultiOperate no any file");
  }
  
  protected void a(List<FileManagerEntity> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (FileManagerEntity)localIterator.next();
      localObject = this.a.getMessageFacade().b(((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, ((FileManagerEntity)localObject).uniseq);
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
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.makeText(this.b, 2131892157, 1).show(this.b.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    long l = 0L;
    if ((paramList.size() == 1) && (((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful()))
    {
      FMToastUtil.a(2131889437);
      if (paramQFileMultiOperateCallback != null) {
        paramQFileMultiOperateCallback.a(1, 2);
      }
      return;
    }
    Object localObject = paramList.iterator();
    FileManagerEntity localFileManagerEntity;
    while (((Iterator)localObject).hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if (FileModel.a(localFileManagerEntity).a(true)) {
        l += localFileManagerEntity.fileSize;
      }
    }
    localObject = this.a.getFileManagerEngine();
    if ((FileManagerUtil.b()) && (l > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      FileManagerUtil.a(false, this.b, new OfflineFileMultiOperate.3(this, paramList, (FileManagerEngine)localObject, paramQFileMultiOperateCallback));
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)paramList.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        ((FileManagerEngine)localObject).h(localFileManagerEntity);
      }
    }
    if (paramQFileMultiOperateCallback != null) {
      paramQFileMultiOperateCallback.a(1, 0);
    }
  }
  
  protected void c(List<FileManagerEntity> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    boolean bool = NetworkUtil.isNetSupport(BaseApplication.getContext());
    int i = 1;
    if (!bool)
    {
      QQToast.makeText(this.b, 2131892157, 1).show(this.b.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    if ((paramList.size() == 1) && (((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful()))
    {
      FMToastUtil.a(2131889438);
      if (paramQFileMultiOperateCallback != null) {
        paramQFileMultiOperateCallback.a(2, 3);
      }
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      if (FileModel.a((FileManagerEntity)localIterator.next()).a(false)) {
        break label132;
      }
    }
    i = 0;
    label132:
    if (i != 0)
    {
      FMDialogUtil.a(this.b, 2131889584, 2131889589, new OfflineFileMultiOperate.4(this, paramList, paramQFileMultiOperateCallback));
      return;
    }
    FileManagerUtil.a(paramList, this.b);
    if (paramQFileMultiOperateCallback != null) {
      paramQFileMultiOperateCallback.a(2, 0);
    }
  }
  
  protected void d(List<FileManagerEntity> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    Object localObject1 = (FileManagerEntity)paramList.get(0);
    localObject1 = this.a.getFileManagerEngine();
    int j = paramList.size();
    int i = 1;
    if ((j == 1) && (((FileManagerEntity)paramList.get(0)).sendCloudUnsuccessful()))
    {
      FMToastUtil.a(2131889439);
      return;
    }
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (FileModel.a((FileManagerEntity)((Iterator)localObject2).next()).a(false)) {
        break label105;
      }
    }
    i = 0;
    label105:
    if (i != 0)
    {
      if (FreeWifiHelper.a(this.b, 5, new OfflineFileMultiOperate.5(this, paramList, (FileManagerEngine)localObject1, paramQFileMultiOperateCallback))) {
        FMDialogUtil.a(this.b, 2131889584, 2131889587, new OfflineFileMultiOperate.6(this, paramList, (FileManagerEngine)localObject1, paramQFileMultiOperateCallback));
      }
    }
    else
    {
      FMToastUtil.d(this.b.getString(2131889761));
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (FileManagerEntity)paramList.next();
        if (!((FileManagerEntity)localObject2).sendCloudUnsuccessful()) {
          if (FileUtils.fileExistsAndNotEmpty(((FileManagerEntity)localObject2).getFilePath())) {
            ((FileManagerEngine)localObject1).a(((FileManagerEntity)localObject2).getFilePath(), "", this.a.getCurrentAccountUin(), 0, false);
          } else {
            ((FileManagerEngine)localObject1).a((FileManagerEntity)localObject2, String.valueOf(((FileManagerEntity)localObject2).peerUin));
          }
        }
      }
      if (paramQFileMultiOperateCallback != null) {
        paramQFileMultiOperateCallback.a(4, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multioperate.OfflineFileMultiOperate
 * JD-Core Version:    0.7.0.1
 */