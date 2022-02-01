package com.tencent.mobileqq.filemanager.multioperate;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class TroopFileMultiOperate
  implements IQFileMultiOperate<TroopFileInfo>
{
  private QQAppInterface a;
  private Activity b;
  private long c;
  
  public TroopFileMultiOperate(QQAppInterface paramQQAppInterface, Activity paramActivity, long paramLong)
  {
    this.a = paramQQAppInterface;
    this.b = paramActivity;
    this.c = paramLong;
  }
  
  private void a(List<TroopFileInfo> paramList)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.a, this.c);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopFileInfo localTroopFileInfo = (TroopFileInfo)paramList.next();
      TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.a, this.c, localTroopFileInfo.b.toString(), localTroopFileInfo.c, localTroopFileInfo.d, localTroopFileInfo.e, localTroopFileInfo.f);
      if ((localTroopFileStatusInfo != null) && (localTroopFileStatusInfo.a != null) && ((localTroopFileStatusInfo.e == 10) || (localTroopFileStatusInfo.e == 9))) {
        localTroopFileTransferManager.d(localTroopFileStatusInfo.a);
      } else {
        localTroopFileTransferManager.a(localTroopFileInfo.c, localTroopFileInfo.d, localTroopFileInfo.e, localTroopFileInfo.f);
      }
    }
  }
  
  private void a(List<TroopFileInfo> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    if (paramList == null)
    {
      QLog.w("TroopFileMultiOperate", 1, "fileList == null");
      return;
    }
    int i = 0;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramQFileMultiOperateCallback = (TroopFileInfo)paramList.next();
      Object localObject = new TroopFileStatusInfo();
      ((TroopFileStatusInfo)localObject).t = paramQFileMultiOperateCallback.d;
      ((TroopFileStatusInfo)localObject).k = paramQFileMultiOperateCallback.t;
      ((TroopFileStatusInfo)localObject).i = paramQFileMultiOperateCallback.e;
      ((TroopFileStatusInfo)localObject).j = paramQFileMultiOperateCallback.r;
      ((TroopFileStatusInfo)localObject).a = paramQFileMultiOperateCallback.b;
      ((TroopFileStatusInfo)localObject).d = this.c;
      ((TroopFileStatusInfo)localObject).u = paramQFileMultiOperateCallback.f;
      ((TroopFileStatusInfo)localObject).r = paramQFileMultiOperateCallback.c;
      ((TroopFileStatusInfo)localObject).s = paramQFileMultiOperateCallback.l;
      ((TroopFileStatusInfo)localObject).l = paramQFileMultiOperateCallback.w;
      ((TroopFileStatusInfo)localObject).m = paramQFileMultiOperateCallback.x;
      ((TroopFileStatusInfo)localObject).n = paramQFileMultiOperateCallback.y;
      ((TroopFileStatusInfo)localObject).e = paramQFileMultiOperateCallback.p;
      TroopFileManager.a(this.a, this.c).b(((TroopFileStatusInfo)localObject).a);
      localObject = FileManagerUtil.a((TroopFileStatusInfo)localObject);
      if (paramQFileMultiOperateCallback.g != 0L)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramQFileMultiOperateCallback.g);
        ((FileManagerEntity)localObject).selfUin = localStringBuilder.toString();
      }
      if (paramQFileMultiOperateCallback.j != 0) {
        ((FileManagerEntity)localObject).lastTime = paramQFileMultiOperateCallback.j;
      }
      ((FileManagerEntity)localObject).bSend = this.a.getAccount().equals(((FileManagerEntity)localObject).selfUin);
      if (!new QfavBuilder(3).a(this.a, this.b, (FileManagerEntity)localObject, null, false)) {
        i = 1;
      }
    }
    if (i != 0) {
      FileManagerUtil.l(this.b.getString(2131896096));
    }
  }
  
  private void b(List<TroopFileInfo> paramList)
  {
    if (!NetworkUtil.isNetSupport(this.b))
    {
      QQToast.makeText(this.b, 2131892157, 1).show(this.b.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      Object localObject = (TroopFileInfo)localIterator.next();
      localObject = QFileUtils.a(this.a, this.c, (TroopFileInfo)localObject);
      if (localObject != null) {
        bool = QFileUtils.a(false, ((TroopFileStatusInfo)localObject).i, ((TroopFileStatusInfo)localObject).r);
      }
    }
    if (bool)
    {
      FMDialogUtil.a(this.b, 2131889584, 2131889589, new TroopFileMultiOperate.3(this, paramList));
      return;
    }
    QFileUtils.a(this.a, paramList, this.b, this.c);
  }
  
  private void b(List<TroopFileInfo> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    if (TroopFileUtils.a(this.a, this.b, this.c) == 0) {
      return;
    }
    paramQFileMultiOperateCallback = TroopFileManager.a(this.a, this.c);
    if (paramQFileMultiOperateCallback == null) {
      return;
    }
    int i = 0;
    boolean bool1 = TroopFileUtils.a(this.a, this.c);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopFileInfo localTroopFileInfo = (TroopFileInfo)paramList.next();
      boolean bool2 = this.a.getCurrentAccountUin().equals(localTroopFileInfo.b());
      if ((localTroopFileInfo.a(this.a, this.c, true)) && ((bool2) || (bool1)))
      {
        paramQFileMultiOperateCallback.b(localTroopFileInfo);
        i = 1;
      }
    }
    if (bool1)
    {
      FMToastUtil.b(2131889392);
      return;
    }
    if (i != 0)
    {
      FMToastUtil.b(2131889394);
      return;
    }
    FMToastUtil.c(2131889393);
  }
  
  private void c(List<TroopFileInfo> paramList)
  {
    if (!NetworkUtil.isNetSupport(this.b))
    {
      QQToast.makeText(this.b, 2131892157, 1).show(this.b.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      Object localObject = (TroopFileInfo)localIterator.next();
      localObject = QFileUtils.a(this.a, this.c, (TroopFileInfo)localObject);
      if (localObject != null) {
        bool = QFileUtils.a(false, ((TroopFileStatusInfo)localObject).i, ((TroopFileStatusInfo)localObject).r);
      }
    }
    if (bool)
    {
      if (FreeWifiHelper.a(this.b, 5, new TroopFileMultiOperate.4(this, paramList))) {
        FMDialogUtil.a(this.b, 2131889584, 2131889587, new TroopFileMultiOperate.5(this, paramList));
      }
    }
    else
    {
      FMToastUtil.d(this.b.getString(2131889761));
      TroopFileUtils.a(this.a, this.c, paramList);
    }
  }
  
  private void c(List<TroopFileInfo> paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    if (!NetworkUtil.isNetSupport(this.b))
    {
      QQToast.makeText(this.b, 2131892157, 1).show(this.b.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    long l = 0L;
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext()) {
      l += ((TroopFileInfo)((Iterator)localObject).next()).e;
    }
    TroopFileTransferManager.a(this.a, this.c);
    if ((FileManagerUtil.b()) && (l > 3145728L))
    {
      if (FreeWifiHelper.a(this.b, 1, new TroopFileMultiOperate.1(this, paramList, paramQFileMultiOperateCallback)))
      {
        paramList = new TroopFileMultiOperate.2(this, paramList, paramQFileMultiOperateCallback);
        paramQFileMultiOperateCallback = this.b.getString(2131895170);
        localObject = this.b;
        DialogUtil.a((Context)localObject, 230, ((Activity)localObject).getString(2131895386), paramQFileMultiOperateCallback, 2131887648, 2131895106, paramList, paramList).show();
      }
    }
    else
    {
      a(paramList);
      if (paramQFileMultiOperateCallback != null) {
        paramQFileMultiOperateCallback.a(1, 0);
      }
    }
  }
  
  public void a(List<TroopFileInfo> paramList, int paramInt, QFileMultiOperateCallback paramQFileMultiOperateCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doFileMultiOperate. operateType[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.i("TroopFileMultiOperate", 1, localStringBuilder.toString());
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return;
              }
              a(paramList, paramQFileMultiOperateCallback);
              return;
            }
            c(paramList);
            return;
          }
          b(paramList, paramQFileMultiOperateCallback);
          return;
        }
        b(paramList);
        return;
      }
      c(paramList, paramQFileMultiOperateCallback);
      return;
    }
    QLog.i("TroopFileMultiOperate", 1, "doFileMultiOperate. file list is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multioperate.TroopFileMultiOperate
 * JD-Core Version:    0.7.0.1
 */