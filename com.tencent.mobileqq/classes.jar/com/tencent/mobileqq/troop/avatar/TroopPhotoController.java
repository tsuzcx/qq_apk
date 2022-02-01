package com.tencent.mobileqq.troop.avatar;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.observer.TroopAvatarObserver;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class TroopPhotoController
  implements iPicCtrl, Observer
{
  protected static int D = 7;
  public static Uri E;
  int A = 0;
  protected String[] B;
  protected int[] C;
  List<TroopPhotoController.OnDataChangeListener> F = new ArrayList();
  WeakReference<TroopPhotoController.OnUploadListener> G;
  WeakReference<TroopPhotoController.OnGotoBigPicListener> H;
  AccountObserver I = new TroopPhotoController.8(this);
  TroopAvatarObserver J = new TroopPhotoController.9(this);
  Context l;
  Activity m;
  String n;
  TroopInfo o;
  TroopInfoData p;
  AppInterface q;
  TroopAvatarManger r;
  protected Bundle s;
  protected int t;
  protected String u;
  protected Handler v = new Handler(Looper.getMainLooper());
  int w = 0;
  int x = -1;
  List<AvatarInfo> y = new ArrayList();
  public ArrayList<TroopClipPic> z = new ArrayList();
  
  public TroopPhotoController(Context paramContext, Activity paramActivity, AppInterface paramAppInterface, Bundle paramBundle)
  {
    this.l = paramContext;
    this.m = paramActivity;
    this.q = paramAppInterface;
    if (paramBundle != null)
    {
      this.s = paramBundle;
      this.n = paramBundle.getString("troopUin", "");
      this.t = paramBundle.getInt("type", 1);
    }
    a();
    this.r = new TroopAvatarManger(this.n, TroopUploadingTask.class, this.q);
    this.r.a(this);
    this.q.addObserver(this.J, true);
  }
  
  private AvatarInfo a(long paramLong)
  {
    Iterator localIterator = this.y.iterator();
    while (localIterator.hasNext())
    {
      AvatarInfo localAvatarInfo = (AvatarInfo)localIterator.next();
      if (localAvatarInfo.n == paramLong) {
        return localAvatarInfo;
      }
    }
    return null;
  }
  
  public static void a(String paramString)
  {
    a(paramString, 0);
  }
  
  public static void a(String paramString, int paramInt)
  {
    int i = MobileQQ.getContext().getResources().getDimensionPixelSize(2131299920);
    QQToast.makeText(MobileQQ.getContext(), paramInt, paramString, 1).show(i);
  }
  
  private int d(String paramString)
  {
    boolean bool = StringUtil.isEmpty(paramString);
    int i = 0;
    if (bool) {
      return 0;
    }
    int j = 5381;
    while (i < paramString.length())
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return 0x7FFFFFFF & j;
  }
  
  private void j()
  {
    E = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).profileCardUtils_enterSnapshot(this.m, 257);
  }
  
  private void k()
  {
    if (this.x >= this.y.size()) {
      this.x = (this.y.size() - 1);
    }
    if (this.x < 0) {
      return;
    }
    int i = 0;
    while (i < this.y.size())
    {
      if (this.x == i) {
        ((AvatarInfo)this.y.get(i)).k = true;
      } else {
        ((AvatarInfo)this.y.get(i)).k = false;
      }
      i += 1;
    }
  }
  
  protected void a()
  {
    if (this.t == 1)
    {
      this.o = ((ITroopInfoService)this.q.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(String.valueOf(this.n));
    }
    else
    {
      this.o = new TroopInfo();
      this.o.troopuin = this.n;
    }
    this.p = new TroopInfoData();
    TroopInfoData localTroopInfoData = this.p;
    localTroopInfoData.troopUin = this.n;
    localTroopInfoData.updateForTroopChatSetting(this.o, this.l.getResources(), this.q.getCurrentAccountUin());
  }
  
  protected void a(int paramInt)
  {
    Iterator localIterator = this.F.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(TroopClipPic paramTroopClipPic, Bundle paramBundle)
  {
    if (paramTroopClipPic == null) {
      return;
    }
    f();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramTroopClipPic);
    this.r.a(TroopUploadingThread.class, this.q, localArrayList, paramBundle, null);
  }
  
  protected void a(AvatarInfo paramAvatarInfo)
  {
    Iterator localIterator = this.F.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).b(paramAvatarInfo);
    }
    if (this.x >= this.y.size())
    {
      k();
      a(this.x);
    }
  }
  
  protected void a(AvatarInfo paramAvatarInfo, TroopUploadingThread.UploadState paramUploadState)
  {
    Iterator localIterator = this.F.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).a(paramAvatarInfo, paramUploadState);
    }
  }
  
  public void a(BaseUrlAction paramBaseUrlAction)
  {
    this.r.a(paramBaseUrlAction);
  }
  
  public void a(TroopPhotoController.OnDataChangeListener paramOnDataChangeListener)
  {
    if (!this.F.contains(paramOnDataChangeListener)) {
      this.F.add(paramOnDataChangeListener);
    }
  }
  
  public void a(TroopPhotoController.OnGotoBigPicListener paramOnGotoBigPicListener)
  {
    if (paramOnGotoBigPicListener != null) {
      this.H = new WeakReference(paramOnGotoBigPicListener);
    }
  }
  
  public void a(TroopPhotoController.OnUploadListener paramOnUploadListener)
  {
    if (paramOnUploadListener != null) {
      this.G = new WeakReference(paramOnUploadListener);
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
    this.r.a(TroopUploadingThread.class, this.q, localArrayList, paramBundle, null);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("onUpdateTroopAvatarWallList bServer=%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (this.q != null)
    {
      if (paramBoolean) {
        a();
      }
      if (this.o != null)
      {
        Object localObject1 = new ArrayList();
        ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getCoverFromDb((List)localObject1, this.o);
        Object localObject2 = this.r.a();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            UploadItem localUploadItem = (UploadItem)((Iterator)localObject2).next();
            if ((localUploadItem != null) && (localUploadItem.e != 1)) {
              if (((List)localObject1).size() == 7)
              {
                ((Iterator)localObject2).remove();
              }
              else
              {
                AvatarInfo localAvatarInfo = new AvatarInfo();
                localAvatarInfo.c = localUploadItem.a;
                localAvatarInfo.f = localUploadItem.d;
                localAvatarInfo.m = localUploadItem.e;
                localAvatarInfo.e = 2;
                localAvatarInfo.g = true;
                localAvatarInfo.n = localUploadItem.f;
                localAvatarInfo.l = localUploadItem.g;
                ((List)localObject1).add(localAvatarInfo);
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("TroopPhotoController", 2, String.format("onUpdateTroopAvatarWallList bserver=%b size=%d info=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(((List)localObject1).size()), localObject1.toString() }));
        }
        localObject1 = new TroopPhotoController.7(this, (List)localObject1);
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
      QLog.i("TroopPhotoController", 2, String.format("update2DB picId=%d info=%s", new Object[] { Integer.valueOf(paramInt), paramAvatarInfo }));
    }
    if (this.t == 2) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Object localObject = this.y.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      AvatarInfo localAvatarInfo = (AvatarInfo)((Iterator)localObject).next();
      String str;
      if (localAvatarInfo != null) {
        str = localAvatarInfo.d;
      }
      try
      {
        j = Integer.parseInt(str);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int j;
        label122:
        TroopClipPic localTroopClipPic;
        break label122;
      }
      j = -1;
      if ((str != null) && (j >= 0))
      {
        if (localAvatarInfo.e == 1)
        {
          localTroopClipPic = new TroopClipPic();
          localTroopClipPic.id = str;
          localTroopClipPic.clipInfo = localAvatarInfo.l;
          localTroopClipPic.type = localAvatarInfo.m;
          localArrayList.add(localTroopClipPic);
          if (localAvatarInfo.j) {
            localHashSet.add(str);
          }
        }
        if (str.equals(String.valueOf(paramInt))) {
          i = 1;
        }
      }
    }
    if (i != 0)
    {
      this.y.remove(paramAvatarInfo);
      a(paramAvatarInfo);
      return false;
    }
    paramAvatarInfo.d = String.valueOf(paramInt);
    paramAvatarInfo.e = 1;
    paramAvatarInfo.g = false;
    localObject = new TroopClipPic();
    ((TroopClipPic)localObject).id = paramAvatarInfo.d;
    ((TroopClipPic)localObject).type = paramAvatarInfo.m;
    ((TroopClipPic)localObject).clipInfo = paramAvatarInfo.l;
    localArrayList.add(localObject);
    if (paramAvatarInfo.j) {
      localHashSet.add(paramAvatarInfo.d);
    }
    paramAvatarInfo = this.q;
    if (paramAvatarInfo != null)
    {
      paramAvatarInfo = (ITroopInfoService)paramAvatarInfo.getRuntimeService(ITroopInfoService.class, "");
      if (paramAvatarInfo != null)
      {
        localObject = paramAvatarInfo.findTroopInfo(String.valueOf(this.o.troopuin));
        if ((localObject != null) && (localArrayList.size() > 0))
        {
          ((TroopInfo)localObject).mTroopPicList.clear();
          ((TroopInfo)localObject).mTroopPicList.addAll(localArrayList);
          ((TroopInfo)localObject).mTroopVerifyingPics.clear();
          ((TroopInfo)localObject).mTroopVerifyingPics.addAll(localHashSet);
          ThreadManager.post(new TroopPhotoController.4(this, paramAvatarInfo, (TroopInfo)localObject), 8, null, false);
        }
      }
    }
    return true;
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).isInstanceOfTroopAvatarWallEditActivity(this.m);
    boolean bool1 = false;
    if (!bool2)
    {
      Object localObject = this.H;
      if (localObject != null) {
        localObject = (TroopPhotoController.OnGotoBigPicListener)((WeakReference)localObject).get();
      } else {
        localObject = null;
      }
      if (localObject != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
        localBundle.putString("key_clip_info", paramString2);
        if (this.A == 0) {
          bool1 = true;
        }
        localBundle.putBoolean("IS_COVER", bool1);
        localBundle.putBoolean("IS_EDIT", true);
        ((TroopPhotoController.OnGotoBigPicListener)localObject).b(localBundle);
      }
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (this.m == null) {
      return;
    }
    long l1 = this.p.dwGroupFlagExt;
    boolean bool = false;
    int j = 0;
    if (((l1 & 0x800) == 0L) && (this.w <= 0))
    {
      if (this.C == null) {
        this.C = new int[D];
      }
      Object localObject = this.C;
      localObject[0] = 13;
      localObject[1] = 14;
      localObject[2] = 16;
      int i = 3;
      while (i < D)
      {
        this.C[i] = -1;
        i += 1;
      }
      if (this.B == null) {
        this.B = this.m.getResources().getStringArray(2130968636);
      }
      localObject = (ActionSheet)ActionSheetHelper.b(this.m, null);
      i = j;
      for (;;)
      {
        int[] arrayOfInt = this.C;
        if (i >= arrayOfInt.length) {
          break;
        }
        if (arrayOfInt[i] == 16)
        {
          ((ActionSheet)localObject).addCancelButton(this.B[arrayOfInt[i]]);
        }
        else if (arrayOfInt[i] >= 0)
        {
          j = arrayOfInt[i];
          String[] arrayOfString = this.B;
          if (j < arrayOfString.length) {
            ((ActionSheet)localObject).addButton(arrayOfString[arrayOfInt[i]], 1);
          }
        }
        i += 1;
      }
      ((ActionSheet)localObject).setOnButtonClickListener(new TroopPhotoController.5(this, (ActionSheet)localObject));
      ((ActionSheet)localObject).show();
      return;
    }
    if (this.w > 0) {
      bool = true;
    }
    b(bool);
    ReportController.b(this.q, "dc00899", "Grp_certified", "", "data", "exp_edit_head", 3, 0, this.o.troopuin, "", "", "");
  }
  
  public void b(int paramInt)
  {
    this.x = paramInt;
    k();
    a(paramInt);
  }
  
  protected void b(AvatarInfo paramAvatarInfo)
  {
    Iterator localIterator = this.F.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).a(paramAvatarInfo);
    }
  }
  
  public void b(TroopPhotoController.OnDataChangeListener paramOnDataChangeListener)
  {
    this.F.remove(paramOnDataChangeListener);
  }
  
  public void b(boolean paramBoolean)
  {
    Activity localActivity = this.m;
    QQCustomDialog localQQCustomDialog = DialogUtil.a(localActivity, 230);
    localQQCustomDialog.setTitle(null);
    if (paramBoolean) {
      localQQCustomDialog.setMessage(localActivity.getResources().getString(2131890839));
    } else {
      localQQCustomDialog.setMessage(localActivity.getResources().getString(2131890838));
    }
    localQQCustomDialog.setPositiveButton(localActivity.getResources().getString(2131890888), new DialogUtil.DialogOnClickAdapter());
    localQQCustomDialog.setPositiveButtonContentDescription(localActivity.getResources().getString(2131890888));
    localQQCustomDialog.show();
  }
  
  protected boolean b(String paramString)
  {
    return this.z.size() == 0;
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    boolean bool = QLog.isColorLevel();
    int j = 0;
    if (bool) {
      QLog.i("TroopPhotoController", 2, String.format("onPicPicked clip=%s path=%s", new Object[] { paramString2, paramString1 }));
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
    if (this.y.size() >= 7) {
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
    this.y.add(paramString2);
    this.z.add(localTroopClipPic);
    b(paramString2);
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("onPicPicked uploadPaths=[size=%d, %s]", new Object[] { Integer.valueOf(this.z.size()), Arrays.toString(this.y.toArray()) }));
    }
    paramString2 = this.G;
    if (paramString2 != null) {
      paramString1 = (TroopPhotoController.OnUploadListener)paramString2.get();
    }
    int i = j;
    if (paramString1 != null)
    {
      i = j;
      if (paramString1.b(this.A)) {
        i = 1;
      }
    }
    if (i == 0) {
      c();
    }
    ReportController.b(this.q, "P_CliOper", "Grp_set", "", "Grp_moredata", "upload_head", 0, 0, this.o.troopuin, "", "", "");
    return true;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, "startUpload");
    }
    AccountManager localAccountManager = (AccountManager)this.q.getManager(0);
    this.u = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getLocalSkey(this.q);
    if (this.u == null)
    {
      localAccountManager.updateSKey(this.I);
      return;
    }
    a(this.z, this.s);
  }
  
  public void c(int paramInt)
  {
    Object localObject1 = (AvatarInfo)this.y.get(paramInt);
    if (((ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class)).isNumeric(((AvatarInfo)localObject1).d))
    {
      ReportController.b(this.q, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "del_head", 0, 0, this.o.troopuin, "", "", "");
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(Integer.valueOf(((AvatarInfo)localObject1).d));
      this.r.a(this.o.troopuin, 2, (ArrayList)localObject2);
    }
    this.y.remove(localObject1);
    a((AvatarInfo)localObject1);
    Object localObject2 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
    int i = ((AvatarInfo)localObject1).e;
    paramInt = 1;
    if ((i == 1) && (!TextUtils.isEmpty(((AvatarInfo)localObject1).d)) && (((ITroopAvatarUtilApi)localObject2).isNumeric(((AvatarInfo)localObject1).d)))
    {
      localObject2 = new ArrayList();
      ((List)localObject2).addAll(this.o.mTroopPicList);
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        TroopClipPic localTroopClipPic = (TroopClipPic)localIterator.next();
        if (((AvatarInfo)localObject1).d.equals(localTroopClipPic.id))
        {
          ((List)localObject2).remove(localTroopClipPic);
          break label258;
        }
      }
      paramInt = 0;
      label258:
      i = paramInt;
      if (paramInt != 0)
      {
        this.o.mTroopPicList.clear();
        this.o.mTroopPicList.addAll((Collection)localObject2);
        this.o.mTroopVerifyingPics.remove(((AvatarInfo)localObject1).d);
        i = paramInt;
      }
    }
    else
    {
      i = 0;
    }
    localObject1 = this.q;
    if ((localObject1 != null) && (i != 0))
    {
      localObject1 = (ITroopInfoService)((AppInterface)localObject1).getRuntimeService(ITroopInfoService.class, "");
      if (localObject1 != null) {
        ThreadManager.post(new TroopPhotoController.6(this, (ITroopInfoService)localObject1), 8, null, false);
      }
    }
  }
  
  protected void c(AvatarInfo paramAvatarInfo)
  {
    TroopInfo localTroopInfo = ((ITroopInfoService)this.q.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.o.troopuin);
    if ((localTroopInfo != null) && ((localTroopInfo.troopTypeExt == 2) || (localTroopInfo.troopTypeExt == 4)) && (localTroopInfo.isAdmin()))
    {
      paramAvatarInfo.j = true;
      if (!this.q.getPreferences().getBoolean("has_shown_same_city_picture_uploaded_dialog", false))
      {
        paramAvatarInfo = this.m;
        if ((paramAvatarInfo != null) && (!paramAvatarInfo.isFinishing()))
        {
          paramAvatarInfo = this.m;
          DialogUtil.a(paramAvatarInfo, 230, null, paramAvatarInfo.getString(2131893846), null, this.m.getString(2131893836), new DialogUtil.DialogOnClickAdapter(), null).show();
          this.q.getPreferences().edit().putBoolean("has_shown_same_city_picture_uploaded_dialog", true).commit();
        }
      }
    }
  }
  
  protected boolean c(String paramString)
  {
    if ((this.o.troopTypeExt == 2) || (this.o.troopTypeExt == 3) || (this.o.troopTypeExt == 4))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      if ((localOptions.outWidth < 100) || (localOptions.outHeight < 100)) {}
    }
    else
    {
      return false;
    }
    QQToast.makeText(this.m, 2131895024, 1).show();
    return true;
  }
  
  protected void d()
  {
    Iterator localIterator = this.F.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).b();
    }
    if (this.x >= this.y.size())
    {
      this.x = this.y.size();
      a(this.x);
    }
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onInsertAvatarFailed ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("TroopPhotoController", 2, ((StringBuilder)localObject).toString());
    }
    a(((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getErrText(MobileQQ.getContext(), -1));
    Object localObject = this.y.iterator();
    while (((Iterator)localObject).hasNext())
    {
      AvatarInfo localAvatarInfo = (AvatarInfo)((Iterator)localObject).next();
      if ((localAvatarInfo.e == 2) || (localAvatarInfo.g))
      {
        ((Iterator)localObject).remove();
        a(localAvatarInfo);
      }
    }
    this.z.clear();
    this.r.a(this.o.troopuin);
  }
  
  public void e()
  {
    this.r.b(this);
    this.q.removeObserver(this.J);
    this.F.clear();
  }
  
  public void e(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void f()
  {
    Object localObject = this.o;
    if ((localObject != null) && (this.q != null))
    {
      this.s.putString("troopCode", ((TroopInfo)localObject).troopcode);
      this.s.putString("ukey", this.u);
      this.s.putString("uin", this.q.getCurrentAccountUin());
      int i = d(this.u);
      this.s.putInt("bkn", i);
      this.s.putString("pUin", this.q.getCurrentAccountUin());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("troopCode:");
      ((StringBuilder)localObject).append(this.o.troopcode);
      ((StringBuilder)localObject).append(" skey:");
      ((StringBuilder)localObject).append(this.u);
      ((StringBuilder)localObject).append(" uin and pUin:");
      ((StringBuilder)localObject).append(this.q.getCurrentAccountUin());
      ((StringBuilder)localObject).append(" mBkn:");
      ((StringBuilder)localObject).append(i);
      QLog.d("TroopPhotoController", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  @NonNull
  public List<AvatarInfo> g()
  {
    return this.y;
  }
  
  public AvatarInfo h()
  {
    return null;
  }
  
  public void i()
  {
    Object localObject = E;
    if (localObject != null)
    {
      localObject = BaseImageUtil.b(this.m, (Uri)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).startPhotoEdit(this.m, (String)localObject, ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getBusiByType(this.A));
      }
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
    if (paramObservable.e != this.A) {
      return;
    }
    paramObject = a(paramObservable.d);
    if (paramObject == null) {
      return;
    }
    int i = paramObservable.a;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        ReportController.b(this.q, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "upload_head_cancel", 0, 0, this.o.troopuin, String.valueOf(paramObservable.b), "", "");
        if (TextUtils.isEmpty(paramObservable.g)) {
          paramObservable = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getErrText(this.m, paramObservable.b);
        } else {
          paramObservable = paramObservable.g;
        }
        if (QLog.isColorLevel()) {
          QLog.i("TroopPhotoController", 2, String.format("update() failed info=%s", new Object[] { paramObject }));
        }
        paramObservable = new TroopPhotoController.3(this, paramObject, paramObservable);
        this.v.post(paramObservable);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopPhotoController", 2, String.format("update() suc state.result=%d newSeq=%d info=%s", new Object[] { Integer.valueOf(paramObservable.b), Integer.valueOf(paramObservable.c), paramObject }));
      }
      i = paramObservable.b;
      paramObservable = new TroopPhotoController.2(this, paramObservable, paramObject, i);
      this.v.post(paramObservable);
      ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).cacheFileFromLocal(i, paramObject.c, this.o.troopuin);
      return;
    }
    paramObject.f = paramObservable.b;
    this.v.post(new TroopPhotoController.1(this, paramObject, paramObservable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopPhotoController
 * JD-Core Version:    0.7.0.1
 */