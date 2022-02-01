package com.tencent.mobileqq.troop.avatar;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Set;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class TroopAvatarController
  extends TroopPhotoController
{
  private AvatarInfo a;
  AccountObserver b = new TroopAvatarController.2(this);
  private AvatarInfo c;
  private TroopClipPic d;
  
  public TroopAvatarController(Context paramContext, Activity paramActivity, AppInterface paramAppInterface, Bundle paramBundle)
  {
    super(paramContext, paramActivity, paramAppInterface, paramBundle);
    this.A = 1;
  }
  
  protected void a(int paramInt) {}
  
  protected void a(AvatarInfo paramAvatarInfo) {}
  
  protected void a(AvatarInfo paramAvatarInfo, TroopUploadingThread.UploadState paramUploadState)
  {
    super.a(paramAvatarInfo, paramUploadState);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onUpdateTroopAvatarWallList bServer=%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (this.q != null)
    {
      if (paramBoolean) {
        a();
      }
      if (this.o != null)
      {
        paramBoolean = this.p.hasSetNewTroopHead;
        if (QLog.isColorLevel()) {
          QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onUpdateTroopAvatarWallList hasHead=%b id=%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.o.mTroopAvatarId) }));
        }
        Object localObject2 = null;
        AvatarInfo localAvatarInfo = null;
        if (paramBoolean)
        {
          int i = this.o.mTroopAvatarId;
          if (i > 0)
          {
            localObject1 = new AvatarInfo();
            ((AvatarInfo)localObject1).d = String.valueOf(i);
            ((AvatarInfo)localObject1).m = 1;
            ((AvatarInfo)localObject1).e = 1;
            ((AvatarInfo)localObject1).j = this.o.mTroopVerifyingPics.contains(((AvatarInfo)localObject1).d);
          }
          else
          {
            localObject1 = null;
          }
          if (localObject1 == null)
          {
            localObject1 = new AvatarInfo();
            ((AvatarInfo)localObject1).d = AvatarInfo.a;
            ((AvatarInfo)localObject1).m = 1;
            ((AvatarInfo)localObject1).e = 3;
          }
        }
        else
        {
          localObject1 = null;
        }
        ArrayList localArrayList = this.r.a();
        if (localArrayList != null)
        {
          Iterator localIterator = localArrayList.iterator();
          for (;;)
          {
            localObject2 = localAvatarInfo;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject2 = (UploadItem)localIterator.next();
            if ((localObject2 != null) && (((UploadItem)localObject2).e == 1)) {
              if (localAvatarInfo != null)
              {
                localIterator.remove();
              }
              else
              {
                localAvatarInfo = new AvatarInfo();
                localAvatarInfo.c = ((UploadItem)localObject2).a;
                localAvatarInfo.f = ((UploadItem)localObject2).d;
                localAvatarInfo.m = ((UploadItem)localObject2).e;
                localAvatarInfo.e = 2;
                localAvatarInfo.g = true;
                localAvatarInfo.n = ((UploadItem)localObject2).f;
                localAvatarInfo.l = ((UploadItem)localObject2).g;
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onUpdateTroopAvatarWallList uploadItems=%s", new Object[] { localArrayList }));
        }
        Object localObject1 = new TroopAvatarController.1(this, (AvatarInfo)localObject1, (AvatarInfo)localObject2);
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          ((Runnable)localObject1).run();
          return;
        }
        this.v.post((Runnable)localObject1);
      }
    }
  }
  
  protected boolean a(int paramInt, AvatarInfo paramAvatarInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update2DB picId=%d info=%s", new Object[] { Integer.valueOf(paramInt), paramAvatarInfo }));
    }
    if (this.t == 2) {
      return false;
    }
    Object localObject = this.a;
    if (localObject != null) {
      localObject = ((AvatarInfo)localObject).d;
    }
    try
    {
      i = Integer.parseInt((String)localObject);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i;
      label69:
      TroopInfo localTroopInfo;
      break label69;
    }
    i = -1;
    if ((localObject != null) && (i >= 0) && (i == paramInt)) {
      return false;
    }
    localObject = new HashSet();
    if (paramAvatarInfo.j) {
      ((Set)localObject).add(paramAvatarInfo.d);
    }
    if (this.q != null)
    {
      paramAvatarInfo = (ITroopInfoService)this.q.getRuntimeService(ITroopInfoService.class, "");
      if (paramAvatarInfo != null)
      {
        localTroopInfo = paramAvatarInfo.findTroopInfo(String.valueOf(this.o.troopuin));
        if (localTroopInfo != null)
        {
          localTroopInfo.mTroopAvatarId = paramInt;
          localTroopInfo.mTroopVerifyingPics.addAll((Collection)localObject);
          ThreadManager.post(new TroopAvatarController.6(this, paramAvatarInfo, localTroopInfo), 8, null, false);
        }
      }
    }
    return true;
  }
  
  public void b(int paramInt) {}
  
  protected void b(AvatarInfo paramAvatarInfo) {}
  
  public boolean b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onNewIntent clip=%s path=%s", new Object[] { paramString2, paramString1 }));
    }
    if (c(paramString1)) {
      return false;
    }
    if (a(paramString1, paramString2)) {
      return false;
    }
    TroopClipPic localTroopClipPic = new TroopClipPic();
    localTroopClipPic.id = paramString1;
    localTroopClipPic.clipInfo = paramString2;
    localTroopClipPic.type = this.A;
    localTroopClipPic.ts = SystemClock.uptimeMillis();
    paramString1 = new AvatarInfo();
    paramString1.c = localTroopClipPic.id;
    paramString1.l = localTroopClipPic.clipInfo;
    paramString1.e = 2;
    paramString1.g = true;
    paramString1.d = "-1";
    paramString1.m = localTroopClipPic.type;
    paramString1.n = localTroopClipPic.ts;
    paramString2 = this.r.a();
    if (paramString2 != null)
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        UploadItem localUploadItem = (UploadItem)paramString2.next();
        if ((localUploadItem != null) && (localUploadItem.e == 1)) {
          paramString2.remove();
        }
      }
    }
    this.c = paramString1;
    this.d = localTroopClipPic;
    if (this.t != 2) {
      d();
    }
    c();
    ReportController.b(this.q, "P_CliOper", "Grp_set", "", "Grp_moredata", "upload_head", 0, 0, this.o.troopuin, "", "", "");
    return true;
  }
  
  public void c()
  {
    AccountManager localAccountManager = (AccountManager)this.q.getManager(0);
    this.u = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getLocalSkey(this.q);
    if (this.u == null)
    {
      localAccountManager.updateSKey(this.b);
      return;
    }
    a(this.d, this.s);
    this.d = null;
  }
  
  public void c(int paramInt) {}
  
  protected void d()
  {
    Iterator localIterator = this.F.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).b();
    }
  }
  
  public List<AvatarInfo> g()
  {
    return null;
  }
  
  public AvatarInfo h()
  {
    AvatarInfo localAvatarInfo = this.c;
    if (localAvatarInfo != null) {
      return localAvatarInfo;
    }
    return this.a;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    if (!(paramObject instanceof TroopUploadingThread.UploadState)) {
      return;
    }
    TroopUploadingThread.UploadState localUploadState = (TroopUploadingThread.UploadState)paramObject;
    if (localUploadState.e != this.A) {
      return;
    }
    long l = localUploadState.d;
    paramObject = this.c;
    if ((paramObject != null) && (paramObject.n == l))
    {
      int i = localUploadState.a;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return;
          }
          ReportController.b(this.q, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "upload_head_cancel", 0, 0, this.o.troopuin, String.valueOf(localUploadState.b), "", "");
          if (TextUtils.isEmpty(localUploadState.g)) {
            paramObservable = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getErrText(this.m, localUploadState.b);
          } else {
            paramObservable = localUploadState.g;
          }
          if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update() failed result=%d info=%s", new Object[] { Integer.valueOf(localUploadState.b), paramObject }));
          }
          paramObservable = new TroopAvatarController.5(this, paramObservable);
          this.v.post(paramObservable);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update() suc state.result=%d newSeq=%d info=%s", new Object[] { Integer.valueOf(localUploadState.b), Integer.valueOf(localUploadState.c), paramObject }));
        }
        i = localUploadState.b;
        paramObservable = new TroopAvatarController.4(this, localUploadState, paramObject, i);
        this.v.post(paramObservable);
        ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).cacheFileFromLocal(i, paramObject.c, this.o.troopuin);
        return;
      }
      paramObject.f = localUploadState.b;
      this.v.post(new TroopAvatarController.3(this, paramObject, localUploadState));
      return;
    }
    if (localUploadState.a == 1) {
      this.r.a(this.o.troopuin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopAvatarController
 * JD-Core Version:    0.7.0.1
 */