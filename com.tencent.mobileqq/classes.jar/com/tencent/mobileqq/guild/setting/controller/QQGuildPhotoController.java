package com.tencent.mobileqq.guild.setting.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.guild.util.GuildCoverUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.avatar.AvatarInfo;
import com.tencent.mobileqq.troop.avatar.BaseUrlAction;
import com.tencent.mobileqq.troop.avatar.TroopAvatarManger;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController.OnDataChangeListener;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController.OnUploadListener;
import com.tencent.mobileqq.troop.avatar.TroopUploadingTask;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import mqq.manager.AccountManager;

public class QQGuildPhotoController
  extends TroopPhotoController
{
  Activity a;
  AppInterface b;
  TroopInfoData c;
  String d;
  TroopInfo e;
  Context f;
  int g = 0;
  TroopAvatarManger h;
  List<AvatarInfo> i = new ArrayList();
  List<TroopPhotoController.OnDataChangeListener> j = new ArrayList();
  WeakReference<TroopPhotoController.OnUploadListener> k;
  
  public QQGuildPhotoController(Context paramContext, Activity paramActivity, AppInterface paramAppInterface, Bundle paramBundle)
  {
    super(paramContext, paramActivity, paramAppInterface, paramBundle);
    this.a = paramActivity;
    this.b = paramAppInterface;
    this.f = paramContext;
    if (paramBundle != null)
    {
      this.s = paramBundle;
      this.d = paramBundle.getString("troopUin", "");
      this.t = paramBundle.getInt("type", 1);
    }
    a();
    this.h = new TroopAvatarManger(this.d, TroopUploadingTask.class, this.b);
    this.h.a(this);
  }
  
  private AvatarInfo a(long paramLong)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      AvatarInfo localAvatarInfo = (AvatarInfo)localIterator.next();
      if (localAvatarInfo.n == paramLong) {
        return localAvatarInfo;
      }
    }
    return null;
  }
  
  private int d(String paramString)
  {
    boolean bool = StringUtil.isEmpty(paramString);
    int m = 0;
    if (bool) {
      return 0;
    }
    int n = 5381;
    while (m < paramString.length())
    {
      n += (n << 5) + paramString.charAt(m);
      m += 1;
    }
    return 0x7FFFFFFF & n;
  }
  
  protected void a()
  {
    if (this.t == 1)
    {
      this.e = ((ITroopInfoService)this.b.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(String.valueOf(this.d));
    }
    else
    {
      this.e = new TroopInfo();
      this.e.troopuin = this.d;
    }
    this.c = new TroopInfoData();
    this.c.troopUin = this.d;
  }
  
  protected void a(AvatarInfo paramAvatarInfo)
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).b(paramAvatarInfo);
    }
  }
  
  protected void a(AvatarInfo paramAvatarInfo, TroopUploadingThread.UploadState paramUploadState)
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).a(paramAvatarInfo, paramUploadState);
    }
  }
  
  public void a(BaseUrlAction paramBaseUrlAction)
  {
    this.h.a(paramBaseUrlAction);
  }
  
  public void a(TroopPhotoController.OnDataChangeListener paramOnDataChangeListener)
  {
    if (!this.j.contains(paramOnDataChangeListener)) {
      this.j.add(paramOnDataChangeListener);
    }
  }
  
  public void a(ArrayList<TroopClipPic> paramArrayList, Bundle paramBundle)
  {
    if (paramArrayList == null) {
      return;
    }
    f();
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      TroopClipPic localTroopClipPic = (TroopClipPic)paramArrayList.next();
      AvatarInfo localAvatarInfo = a(localTroopClipPic.ts);
      if ((localAvatarInfo != null) && (!localAvatarInfo.h))
      {
        localAvatarInfo.h = true;
        localArrayList.add(localTroopClipPic);
      }
    }
    if (localArrayList.size() == 0) {
      return;
    }
    this.h.a(TroopUploadingThread.class, this.b, localArrayList, paramBundle, null);
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    return false;
  }
  
  public void b()
  {
    if (this.a == null) {
      return;
    }
    if (((this.c.dwGroupFlagExt & 0x800) == 0L) && (this.g <= 0))
    {
      GuildCoverUtils.a(this.a, 102);
      return;
    }
    boolean bool;
    if (this.g > 0) {
      bool = true;
    } else {
      bool = false;
    }
    b(bool);
  }
  
  public void b(TroopPhotoController.OnDataChangeListener paramOnDataChangeListener)
  {
    this.j.remove(paramOnDataChangeListener);
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    boolean bool = QLog.isColorLevel();
    int n = 0;
    if (bool) {
      QLog.i("TroopPhotoController.TroopCoverController", 2, String.format("onPicPicked clip=%s path=%s", new Object[] { paramString2, paramString1 }));
    }
    if (a(paramString1, paramString2)) {
      return false;
    }
    TroopClipPic localTroopClipPic = new TroopClipPic();
    localTroopClipPic.id = paramString1;
    localTroopClipPic.clipInfo = paramString2;
    localTroopClipPic.type = 102;
    localTroopClipPic.ts = SystemClock.uptimeMillis();
    if (this.i.size() >= 7) {
      return false;
    }
    paramString2 = new AvatarInfo();
    paramString2.c = localTroopClipPic.id;
    paramString2.l = localTroopClipPic.clipInfo;
    paramString2.e = 2;
    paramString2.g = true;
    paramString1 = null;
    paramString2.d = null;
    paramString2.m = localTroopClipPic.type;
    paramString2.n = localTroopClipPic.ts;
    this.i.add(paramString2);
    this.z.add(localTroopClipPic);
    b(paramString2);
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController.TroopCoverController", 2, String.format("onPicPicked uploadPaths=[size=%d, %s]", new Object[] { Integer.valueOf(this.z.size()), Arrays.toString(this.i.toArray()) }));
    }
    paramString2 = this.k;
    if (paramString2 != null) {
      paramString1 = (TroopPhotoController.OnUploadListener)paramString2.get();
    }
    int m = n;
    if (paramString1 != null)
    {
      m = n;
      if (paramString1.b(102)) {
        m = 1;
      }
    }
    if (m == 0) {
      c();
    }
    ReportController.b(this.b, "P_CliOper", "Grp_set", "", "Grp_moredata", "upload_head", 0, 0, this.e.troopuin, "", "", "");
    return true;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController.TroopCoverController", 2, "startUpload");
    }
    AccountManager localAccountManager = (AccountManager)this.b.getManager(0);
    this.u = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getLocalSkey(this.b);
    if (this.u == null) {
      return;
    }
    a(this.z, this.s);
  }
  
  protected void d()
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).b();
    }
  }
  
  public void e()
  {
    this.h.b(this);
    this.j.clear();
  }
  
  public void f()
  {
    if ((this.e != null) && (this.b != null))
    {
      this.s.putString("troopCode", this.e.troopcode);
      this.s.putString("ukey", this.u);
      this.s.putString("uin", this.b.getCurrentAccountUin());
      int m = d(this.u);
      this.s.putInt("bkn", m);
      this.s.putString("pUin", this.b.getCurrentAccountUin());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("troopCode:");
      localStringBuilder.append(this.e.troopcode);
      localStringBuilder.append(" skey:");
      localStringBuilder.append(this.u);
      localStringBuilder.append(" uin and pUin:");
      localStringBuilder.append(this.b.getCurrentAccountUin());
      localStringBuilder.append(" mBkn:");
      localStringBuilder.append(m);
      QLog.d("TroopPhotoController.TroopCoverController", 4, localStringBuilder.toString());
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    if (!(paramObject instanceof TroopUploadingThread.UploadState)) {
      return;
    }
    paramObservable = (TroopUploadingThread.UploadState)paramObject;
    paramObject = a(paramObservable.d);
    if (paramObject == null) {
      return;
    }
    int m = paramObservable.a;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2) {
          return;
        }
        ReportController.b(this.b, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "upload_head_cancel", 0, 0, this.e.troopuin, String.valueOf(paramObservable.b), "", "");
        if (TextUtils.isEmpty(paramObservable.g)) {
          paramObservable = GuildCoverUtils.b(paramObservable.b);
        } else {
          paramObservable = paramObservable.g;
        }
        if (QLog.isColorLevel()) {
          QLog.i("TroopPhotoController.TroopCoverController", 2, String.format("update() failed info=%s", new Object[] { paramObject }));
        }
        paramObservable = new QQGuildPhotoController.3(this, paramObject, paramObservable);
        this.v.post(paramObservable);
        return;
      }
      paramObservable = new QQGuildPhotoController.2(this, paramObservable);
      this.v.post(paramObservable);
      return;
    }
    paramObject.f = paramObservable.b;
    this.v.post(new QQGuildPhotoController.1(this, paramObject, paramObservable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.controller.QQGuildPhotoController
 * JD-Core Version:    0.7.0.1
 */