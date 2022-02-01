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
  public static Uri a;
  protected static int d = 7;
  int jdField_a_of_type_Int = 0;
  Activity jdField_a_of_type_AndroidAppActivity;
  Context jdField_a_of_type_AndroidContentContext;
  protected Handler a;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  TroopAvatarObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopAvatarObserver = new TroopPhotoController.9(this);
  TroopAvatarManger jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger;
  TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
  String jdField_a_of_type_JavaLangString;
  WeakReference<TroopPhotoController.OnUploadListener> jdField_a_of_type_JavaLangRefWeakReference;
  public ArrayList<TroopClipPic> a;
  List<AvatarInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  protected int[] a;
  protected String[] a;
  int jdField_b_of_type_Int = -1;
  WeakReference<TroopPhotoController.OnGotoBigPicListener> jdField_b_of_type_JavaLangRefWeakReference;
  List<TroopPhotoController.OnDataChangeListener> jdField_b_of_type_JavaUtilList = new ArrayList();
  AccountObserver jdField_b_of_type_MqqObserverAccountObserver = new TroopPhotoController.8(this);
  int c;
  
  public TroopPhotoController(Context paramContext, Activity paramActivity, AppInterface paramAppInterface, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    e();
    this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger = new TroopAvatarManger(this.jdField_a_of_type_JavaLangString, TroopUploadingTask.class, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger.a(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopAvatarObserver, true);
  }
  
  private AvatarInfo a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      AvatarInfo localAvatarInfo = (AvatarInfo)localIterator.next();
      if (localAvatarInfo.jdField_a_of_type_Long == paramLong) {
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
    int i = MobileQQ.getContext().getResources().getDimensionPixelSize(2131299168);
    QQToast.a(MobileQQ.getContext(), paramInt, paramString, 1).b(i);
  }
  
  private void g()
  {
    jdField_a_of_type_AndroidNetUri = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).profileCardUtils_enterSnapshot(this.jdField_a_of_type_AndroidAppActivity, 257);
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size()) {
      this.jdField_b_of_type_Int = (this.jdField_a_of_type_JavaUtilList.size() - 1);
    }
    if (this.jdField_b_of_type_Int < 0) {
      return;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (this.jdField_b_of_type_Int == i) {
        ((AvatarInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_d_of_type_Boolean = true;
      } else {
        ((AvatarInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_d_of_type_Boolean = false;
      }
      i += 1;
    }
  }
  
  public AvatarInfo a()
  {
    return null;
  }
  
  @NonNull
  public List<AvatarInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, "startUpload");
    }
    AccountManager localAccountManager = (AccountManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(0);
    String str = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getLocalSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (str == null)
    {
      localAccountManager.updateSKey(this.jdField_b_of_type_MqqObserverAccountObserver);
      return;
    }
    a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode, str, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
  }
  
  protected void a(int paramInt)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(TroopClipPic paramTroopClipPic, String paramString1, String paramString2, String paramString3)
  {
    if ((paramTroopClipPic != null) && (paramString1 != null))
    {
      if (paramString3 == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramTroopClipPic);
      this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger.a(TroopUploadingThread.class, this.jdField_a_of_type_ComTencentCommonAppAppInterface, localArrayList, paramString1, paramString2, paramString3, null);
    }
  }
  
  protected void a(AvatarInfo paramAvatarInfo)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).a(paramAvatarInfo);
    }
  }
  
  protected void a(AvatarInfo paramAvatarInfo, TroopUploadingThread.UploadState paramUploadState)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).a(paramAvatarInfo, paramUploadState);
    }
  }
  
  public void a(TroopPhotoController.OnDataChangeListener paramOnDataChangeListener)
  {
    if (!this.jdField_b_of_type_JavaUtilList.contains(paramOnDataChangeListener)) {
      this.jdField_b_of_type_JavaUtilList.add(paramOnDataChangeListener);
    }
  }
  
  public void a(TroopPhotoController.OnGotoBigPicListener paramOnGotoBigPicListener)
  {
    if (paramOnGotoBigPicListener != null) {
      this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramOnGotoBigPicListener);
    }
  }
  
  public void a(TroopPhotoController.OnUploadListener paramOnUploadListener)
  {
    if (paramOnUploadListener != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnUploadListener);
    }
  }
  
  public void a(ArrayList<TroopClipPic> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    if ((paramArrayList != null) && (paramString1 != null))
    {
      if (paramString3 == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        TroopClipPic localTroopClipPic = (TroopClipPic)paramArrayList.next();
        AvatarInfo localAvatarInfo = a(localTroopClipPic.ts);
        if ((localAvatarInfo != null) && (!localAvatarInfo.jdField_b_of_type_Boolean))
        {
          localAvatarInfo.jdField_b_of_type_Boolean = true;
          localArrayList.add(localTroopClipPic);
        }
      }
      if (localArrayList.size() == 0) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger.a(TroopUploadingThread.class, this.jdField_a_of_type_ComTencentCommonAppAppInterface, localArrayList, paramString1, paramString2, paramString3, null);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("onUpdateTroopAvatarWallList bServer=%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      if (paramBoolean) {
        e();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        Object localObject1 = new ArrayList();
        ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getCoverFromDb((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger.a();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            UploadItem localUploadItem = (UploadItem)((Iterator)localObject2).next();
            if ((localUploadItem != null) && (localUploadItem.jdField_b_of_type_Int != 1)) {
              if (((List)localObject1).size() == 7)
              {
                ((Iterator)localObject2).remove();
              }
              else
              {
                AvatarInfo localAvatarInfo = new AvatarInfo();
                localAvatarInfo.jdField_b_of_type_JavaLangString = localUploadItem.jdField_a_of_type_JavaLangString;
                localAvatarInfo.jdField_c_of_type_Int = localUploadItem.jdField_a_of_type_Int;
                localAvatarInfo.jdField_d_of_type_Int = localUploadItem.jdField_b_of_type_Int;
                localAvatarInfo.jdField_b_of_type_Int = 2;
                localAvatarInfo.jdField_a_of_type_Boolean = true;
                localAvatarInfo.jdField_a_of_type_Long = localUploadItem.jdField_a_of_type_Long;
                localAvatarInfo.jdField_d_of_type_JavaLangString = localUploadItem.jdField_b_of_type_JavaLangString;
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
        this.jdField_a_of_type_AndroidOsHandler.post((Runnable)localObject1);
      }
    }
  }
  
  protected boolean a(int paramInt, AvatarInfo paramAvatarInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("update2DB picId=%d info=%s", new Object[] { Integer.valueOf(paramInt), paramAvatarInfo }));
    }
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      AvatarInfo localAvatarInfo = (AvatarInfo)((Iterator)localObject).next();
      String str;
      if (localAvatarInfo != null) {
        str = localAvatarInfo.jdField_c_of_type_JavaLangString;
      }
      try
      {
        j = Integer.parseInt(str);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int j;
        label111:
        TroopClipPic localTroopClipPic;
        break label111;
      }
      j = -1;
      if ((str != null) && (j >= 0))
      {
        if (localAvatarInfo.jdField_b_of_type_Int == 1)
        {
          localTroopClipPic = new TroopClipPic();
          localTroopClipPic.id = str;
          localTroopClipPic.clipInfo = localAvatarInfo.jdField_d_of_type_JavaLangString;
          localTroopClipPic.type = localAvatarInfo.jdField_d_of_type_Int;
          localArrayList.add(localTroopClipPic);
          if (localAvatarInfo.jdField_c_of_type_Boolean) {
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
      this.jdField_a_of_type_JavaUtilList.remove(paramAvatarInfo);
      b(paramAvatarInfo);
      return false;
    }
    paramAvatarInfo.jdField_c_of_type_JavaLangString = String.valueOf(paramInt);
    paramAvatarInfo.jdField_b_of_type_Int = 1;
    paramAvatarInfo.jdField_a_of_type_Boolean = false;
    localObject = new TroopClipPic();
    ((TroopClipPic)localObject).id = paramAvatarInfo.jdField_c_of_type_JavaLangString;
    ((TroopClipPic)localObject).type = paramAvatarInfo.jdField_d_of_type_Int;
    ((TroopClipPic)localObject).clipInfo = paramAvatarInfo.jdField_d_of_type_JavaLangString;
    localArrayList.add(localObject);
    if (paramAvatarInfo.jdField_c_of_type_Boolean) {
      localHashSet.add(paramAvatarInfo.jdField_c_of_type_JavaLangString);
    }
    paramAvatarInfo = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (paramAvatarInfo != null)
    {
      paramAvatarInfo = (ITroopInfoService)paramAvatarInfo.getRuntimeService(ITroopInfoService.class, "");
      if (paramAvatarInfo != null)
      {
        localObject = paramAvatarInfo.findTroopInfo(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin));
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
  
  protected boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size() == 0;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool = QLog.isColorLevel();
    int j = 0;
    if (bool) {
      QLog.i("TroopPhotoController", 2, String.format("onPicPicked clip=%s path=%s", new Object[] { paramString2, paramString1 }));
    }
    if (b(paramString1)) {
      return false;
    }
    if (b(paramString1, paramString2)) {
      return false;
    }
    TroopClipPic localTroopClipPic = new TroopClipPic();
    localTroopClipPic.id = paramString1;
    localTroopClipPic.clipInfo = paramString2;
    localTroopClipPic.type = this.jdField_c_of_type_Int;
    localTroopClipPic.ts = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_JavaUtilList.size() >= 7) {
      return false;
    }
    paramString2 = new AvatarInfo();
    paramString2.jdField_b_of_type_JavaLangString = localTroopClipPic.id;
    paramString2.jdField_d_of_type_JavaLangString = localTroopClipPic.clipInfo;
    paramString2.jdField_b_of_type_Int = 2;
    paramString2.jdField_a_of_type_Boolean = true;
    paramString1 = null;
    paramString2.jdField_c_of_type_JavaLangString = null;
    paramString2.jdField_d_of_type_Int = localTroopClipPic.type;
    paramString2.jdField_a_of_type_Long = localTroopClipPic.ts;
    this.jdField_a_of_type_JavaUtilList.add(paramString2);
    this.jdField_a_of_type_JavaUtilArrayList.add(localTroopClipPic);
    a(paramString2);
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("onPicPicked uploadPaths=[size=%d, %s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), Arrays.toString(this.jdField_a_of_type_JavaUtilList.toArray()) }));
    }
    paramString2 = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (paramString2 != null) {
      paramString1 = (TroopPhotoController.OnUploadListener)paramString2.get();
    }
    int i = j;
    if (paramString1 != null)
    {
      i = j;
      if (paramString1.a(this.jdField_c_of_type_Int)) {
        i = 1;
      }
    }
    if (i == 0) {
      a();
    }
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_set", "", "Grp_moredata", "upload_head", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, "", "", "");
    return true;
  }
  
  protected void b()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).a();
    }
    if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size())
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
      a(this.jdField_b_of_type_Int);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    h();
    a(paramInt);
  }
  
  protected void b(AvatarInfo paramAvatarInfo)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).b(paramAvatarInfo);
    }
    if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size())
    {
      h();
      a(this.jdField_b_of_type_Int);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    QQCustomDialog localQQCustomDialog = DialogUtil.a(localActivity, 230);
    localQQCustomDialog.setTitle(null);
    if (paramBoolean) {
      localQQCustomDialog.setMessage(localActivity.getResources().getString(2131693291));
    } else {
      localQQCustomDialog.setMessage(localActivity.getResources().getString(2131693290));
    }
    localQQCustomDialog.setPositiveButton(localActivity.getResources().getString(2131693339), new DialogUtil.DialogOnClickAdapter());
    localQQCustomDialog.setPositiveButtonContentDescription(localActivity.getResources().getString(2131693339));
    localQQCustomDialog.show();
  }
  
  protected boolean b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopTypeExt == 2) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopTypeExt == 3) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopTypeExt == 4))
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
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131697251, 1).a();
    return true;
  }
  
  protected boolean b(String paramString1, String paramString2)
  {
    boolean bool2 = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).isInstanceOfTroopAvatarWallEditActivity(this.jdField_a_of_type_AndroidAppActivity);
    boolean bool1 = false;
    if (!bool2)
    {
      Object localObject = this.jdField_b_of_type_JavaLangRefWeakReference;
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
        if (this.jdField_c_of_type_Int == 0) {
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
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    long l = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupFlagExt;
    boolean bool = false;
    int j = 0;
    if (((l & 0x800) == 0L) && (this.jdField_a_of_type_Int <= 0))
    {
      if (this.jdField_a_of_type_ArrayOfInt == null) {
        this.jdField_a_of_type_ArrayOfInt = new int[jdField_d_of_type_Int];
      }
      Object localObject = this.jdField_a_of_type_ArrayOfInt;
      localObject[0] = 13;
      localObject[1] = 14;
      localObject[2] = 16;
      int i = 3;
      while (i < jdField_d_of_type_Int)
      {
        this.jdField_a_of_type_ArrayOfInt[i] = -1;
        i += 1;
      }
      if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
        this.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getStringArray(2130968636);
      }
      localObject = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null);
      i = j;
      for (;;)
      {
        int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
        if (i >= arrayOfInt.length) {
          break;
        }
        if (arrayOfInt[i] == 16)
        {
          ((ActionSheet)localObject).addCancelButton(this.jdField_a_of_type_ArrayOfJavaLangString[arrayOfInt[i]]);
        }
        else if (arrayOfInt[i] >= 0)
        {
          j = arrayOfInt[i];
          String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
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
    if (this.jdField_a_of_type_Int > 0) {
      bool = true;
    }
    b(bool);
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_certified", "", "data", "exp_edit_head", 3, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, "", "", "");
  }
  
  public void c(int paramInt)
  {
    Object localObject1 = (AvatarInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (((ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class)).isNumeric(((AvatarInfo)localObject1).jdField_c_of_type_JavaLangString))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "del_head", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, "", "", "");
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(Integer.valueOf(((AvatarInfo)localObject1).jdField_c_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, 2, (ArrayList)localObject2);
    }
    this.jdField_a_of_type_JavaUtilList.remove(localObject1);
    b((AvatarInfo)localObject1);
    Object localObject2 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
    int i = ((AvatarInfo)localObject1).jdField_b_of_type_Int;
    paramInt = 1;
    if ((i == 1) && (!TextUtils.isEmpty(((AvatarInfo)localObject1).jdField_c_of_type_JavaLangString)) && (((ITroopAvatarUtilApi)localObject2).isNumeric(((AvatarInfo)localObject1).jdField_c_of_type_JavaLangString)))
    {
      localObject2 = new ArrayList();
      ((List)localObject2).addAll(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mTroopPicList);
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        TroopClipPic localTroopClipPic = (TroopClipPic)localIterator.next();
        if (((AvatarInfo)localObject1).jdField_c_of_type_JavaLangString.equals(localTroopClipPic.id))
        {
          ((List)localObject2).remove(localTroopClipPic);
          break label262;
        }
      }
      paramInt = 0;
      label262:
      i = paramInt;
      if (paramInt != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mTroopPicList.clear();
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mTroopPicList.addAll((Collection)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mTroopVerifyingPics.remove(((AvatarInfo)localObject1).jdField_c_of_type_JavaLangString);
        i = paramInt;
      }
    }
    else
    {
      i = 0;
    }
    localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
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
    TroopInfo localTroopInfo = ((ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
    if ((localTroopInfo != null) && ((localTroopInfo.troopTypeExt == 2) || (localTroopInfo.troopTypeExt == 4)) && (localTroopInfo.isAdmin()))
    {
      paramAvatarInfo.jdField_c_of_type_Boolean = true;
      if (!this.jdField_a_of_type_ComTencentCommonAppAppInterface.getPreferences().getBoolean("has_shown_same_city_picture_uploaded_dialog", false))
      {
        paramAvatarInfo = this.jdField_a_of_type_AndroidAppActivity;
        if ((paramAvatarInfo != null) && (!paramAvatarInfo.isFinishing()))
        {
          paramAvatarInfo = this.jdField_a_of_type_AndroidAppActivity;
          DialogUtil.a(paramAvatarInfo, 230, null, paramAvatarInfo.getString(2131696081), null, this.jdField_a_of_type_AndroidAppActivity.getString(2131696071), new DialogUtil.DialogOnClickAdapter(), null).show();
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.getPreferences().edit().putBoolean("has_shown_same_city_picture_uploaded_dialog", true).commit();
        }
      }
    }
  }
  
  public void d()
  {
    Object localObject = jdField_a_of_type_AndroidNetUri;
    if (localObject != null)
    {
      localObject = BaseImageUtil.b(this.jdField_a_of_type_AndroidAppActivity, (Uri)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).startPhotoEdit(this.jdField_a_of_type_AndroidAppActivity, (String)localObject, ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getBusiByType(this.jdField_c_of_type_Int));
      }
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
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      AvatarInfo localAvatarInfo = (AvatarInfo)((Iterator)localObject).next();
      if ((localAvatarInfo.jdField_b_of_type_Int == 2) || (localAvatarInfo.jdField_a_of_type_Boolean))
      {
        ((Iterator)localObject).remove();
        b(localAvatarInfo);
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(String.valueOf(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData = new TroopInfoData();
    TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    localTroopInfoData.troopUin = this.jdField_a_of_type_JavaLangString;
    localTroopInfoData.updateForTroopChatSetting(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger.b(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopAvatarObserver);
    this.jdField_b_of_type_JavaUtilList.clear();
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
    if (paramObservable.jdField_d_of_type_Int != this.jdField_c_of_type_Int) {
      return;
    }
    paramObject = a(paramObservable.jdField_a_of_type_Long);
    if (paramObject == null) {
      return;
    }
    int i = paramObservable.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "upload_head_cancel", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, String.valueOf(paramObservable.jdField_b_of_type_Int), "", "");
        if (TextUtils.isEmpty(paramObservable.jdField_a_of_type_JavaLangString)) {
          paramObservable = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getErrText(this.jdField_a_of_type_AndroidAppActivity, paramObservable.jdField_b_of_type_Int);
        } else {
          paramObservable = paramObservable.jdField_a_of_type_JavaLangString;
        }
        if (QLog.isColorLevel()) {
          QLog.i("TroopPhotoController", 2, String.format("update() failed info=%s", new Object[] { paramObject }));
        }
        paramObservable = new TroopPhotoController.3(this, paramObject, paramObservable);
        this.jdField_a_of_type_AndroidOsHandler.post(paramObservable);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopPhotoController", 2, String.format("update() suc state.result=%d newSeq=%d info=%s", new Object[] { Integer.valueOf(paramObservable.jdField_b_of_type_Int), Integer.valueOf(paramObservable.jdField_c_of_type_Int), paramObject }));
      }
      i = paramObservable.jdField_b_of_type_Int;
      paramObservable = new TroopPhotoController.2(this, paramObservable, paramObject, i);
      this.jdField_a_of_type_AndroidOsHandler.post(paramObservable);
      ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).cacheFileFromLocal(i, paramObject.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
      return;
    }
    paramObject.jdField_c_of_type_Int = paramObservable.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidOsHandler.post(new TroopPhotoController.1(this, paramObject, paramObservable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopPhotoController
 * JD-Core Version:    0.7.0.1
 */