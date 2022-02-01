package com.tencent.mobileqq.troop.avatar;

import android.app.Activity;
import android.content.Context;
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
  private TroopClipPic jdField_a_of_type_ComTencentMobileqqDataTroopTroopClipPic;
  private AvatarInfo jdField_a_of_type_ComTencentMobileqqTroopAvatarAvatarInfo;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new TroopAvatarController.2(this);
  private AvatarInfo b;
  
  public TroopAvatarController(Context paramContext, Activity paramActivity, AppInterface paramAppInterface, String paramString)
  {
    super(paramContext, paramActivity, paramAppInterface, paramString);
    this.jdField_c_of_type_Int = 1;
  }
  
  public AvatarInfo a()
  {
    AvatarInfo localAvatarInfo = this.jdField_b_of_type_ComTencentMobileqqTroopAvatarAvatarInfo;
    if (localAvatarInfo != null) {
      return localAvatarInfo;
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopAvatarAvatarInfo;
  }
  
  public List<AvatarInfo> a()
  {
    return null;
  }
  
  public void a()
  {
    AccountManager localAccountManager = (AccountManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(0);
    String str = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getLocalSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (str == null)
    {
      localAccountManager.updateSKey(this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopClipPic, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode, str, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopClipPic = null;
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
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      if (paramBoolean) {
        e();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        paramBoolean = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead;
        if (QLog.isColorLevel()) {
          QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onUpdateTroopAvatarWallList hasHead=%b id=%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mTroopAvatarId) }));
        }
        Object localObject2 = null;
        AvatarInfo localAvatarInfo = null;
        if (paramBoolean)
        {
          int i = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mTroopAvatarId;
          if (i > 0)
          {
            localObject1 = new AvatarInfo();
            ((AvatarInfo)localObject1).jdField_c_of_type_JavaLangString = String.valueOf(i);
            ((AvatarInfo)localObject1).jdField_d_of_type_Int = 1;
            ((AvatarInfo)localObject1).jdField_b_of_type_Int = 1;
            ((AvatarInfo)localObject1).jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mTroopVerifyingPics.contains(((AvatarInfo)localObject1).jdField_c_of_type_JavaLangString);
          }
          else
          {
            localObject1 = null;
          }
          if (localObject1 == null)
          {
            localObject1 = new AvatarInfo();
            ((AvatarInfo)localObject1).jdField_c_of_type_JavaLangString = AvatarInfo.jdField_a_of_type_JavaLangString;
            ((AvatarInfo)localObject1).jdField_d_of_type_Int = 1;
            ((AvatarInfo)localObject1).jdField_b_of_type_Int = 3;
          }
        }
        else
        {
          localObject1 = null;
        }
        ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger.a();
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
            if ((localObject2 != null) && (((UploadItem)localObject2).jdField_b_of_type_Int == 1)) {
              if (localAvatarInfo != null)
              {
                localIterator.remove();
              }
              else
              {
                localAvatarInfo = new AvatarInfo();
                localAvatarInfo.jdField_b_of_type_JavaLangString = ((UploadItem)localObject2).jdField_a_of_type_JavaLangString;
                localAvatarInfo.jdField_c_of_type_Int = ((UploadItem)localObject2).jdField_a_of_type_Int;
                localAvatarInfo.jdField_d_of_type_Int = ((UploadItem)localObject2).jdField_b_of_type_Int;
                localAvatarInfo.jdField_b_of_type_Int = 2;
                localAvatarInfo.jdField_a_of_type_Boolean = true;
                localAvatarInfo.jdField_a_of_type_Long = ((UploadItem)localObject2).jdField_a_of_type_Long;
                localAvatarInfo.jdField_d_of_type_JavaLangString = ((UploadItem)localObject2).jdField_b_of_type_JavaLangString;
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
        this.jdField_a_of_type_AndroidOsHandler.post((Runnable)localObject1);
      }
    }
  }
  
  protected boolean a(int paramInt, AvatarInfo paramAvatarInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update2DB picId=%d info=%s", new Object[] { Integer.valueOf(paramInt), paramAvatarInfo }));
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarAvatarInfo;
    if (localObject != null) {
      localObject = ((AvatarInfo)localObject).jdField_c_of_type_JavaLangString;
    }
    try
    {
      i = Integer.parseInt((String)localObject);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i;
      label59:
      TroopInfo localTroopInfo;
      break label59;
    }
    i = -1;
    if ((localObject != null) && (i >= 0) && (i == paramInt)) {
      return false;
    }
    localObject = new HashSet();
    if (paramAvatarInfo.jdField_c_of_type_Boolean) {
      ((Set)localObject).add(paramAvatarInfo.jdField_c_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      paramAvatarInfo = (ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "");
      if (paramAvatarInfo != null)
      {
        localTroopInfo = paramAvatarInfo.findTroopInfo(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin));
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
  
  public boolean a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onNewIntent clip=%s path=%s", new Object[] { paramString2, paramString1 }));
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
    paramString1 = new AvatarInfo();
    paramString1.jdField_b_of_type_JavaLangString = localTroopClipPic.id;
    paramString1.jdField_d_of_type_JavaLangString = localTroopClipPic.clipInfo;
    paramString1.jdField_b_of_type_Int = 2;
    paramString1.jdField_a_of_type_Boolean = true;
    paramString1.jdField_c_of_type_JavaLangString = "-1";
    paramString1.jdField_d_of_type_Int = localTroopClipPic.type;
    paramString1.jdField_a_of_type_Long = localTroopClipPic.ts;
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger.a();
    if (paramString2 != null)
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        UploadItem localUploadItem = (UploadItem)paramString2.next();
        if ((localUploadItem != null) && (localUploadItem.jdField_b_of_type_Int == 1)) {
          paramString2.remove();
        }
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqTroopAvatarAvatarInfo = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopClipPic = localTroopClipPic;
    b();
    a();
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_set", "", "Grp_moredata", "upload_head", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, "", "", "");
    return true;
  }
  
  protected void b()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((TroopPhotoController.OnDataChangeListener)localIterator.next()).a();
    }
  }
  
  public void b(int paramInt) {}
  
  protected void b(AvatarInfo paramAvatarInfo) {}
  
  public void c(int paramInt) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    if (!(paramObject instanceof TroopUploadingThread.UploadState)) {
      return;
    }
    TroopUploadingThread.UploadState localUploadState = (TroopUploadingThread.UploadState)paramObject;
    if (localUploadState.jdField_d_of_type_Int != this.jdField_c_of_type_Int) {
      return;
    }
    long l = localUploadState.jdField_a_of_type_Long;
    paramObject = this.jdField_b_of_type_ComTencentMobileqqTroopAvatarAvatarInfo;
    if ((paramObject != null) && (paramObject.jdField_a_of_type_Long == l))
    {
      int i = localUploadState.jdField_a_of_type_Int;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "upload_head_cancel", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, String.valueOf(localUploadState.jdField_b_of_type_Int), "", "");
          if (TextUtils.isEmpty(localUploadState.jdField_a_of_type_JavaLangString)) {
            paramObservable = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getErrText(this.jdField_a_of_type_AndroidAppActivity, localUploadState.jdField_b_of_type_Int);
          } else {
            paramObservable = localUploadState.jdField_a_of_type_JavaLangString;
          }
          if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update() failed result=%d info=%s", new Object[] { Integer.valueOf(localUploadState.jdField_b_of_type_Int), paramObject }));
          }
          paramObservable = new TroopAvatarController.5(this, paramObservable);
          this.jdField_a_of_type_AndroidOsHandler.post(paramObservable);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update() suc state.result=%d newSeq=%d info=%s", new Object[] { Integer.valueOf(localUploadState.jdField_b_of_type_Int), Integer.valueOf(localUploadState.jdField_c_of_type_Int), paramObject }));
        }
        i = localUploadState.jdField_b_of_type_Int;
        paramObservable = new TroopAvatarController.4(this, localUploadState, paramObject, i);
        this.jdField_a_of_type_AndroidOsHandler.post(paramObservable);
        ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).cacheFileFromLocal(i, paramObject.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
        return;
      }
      paramObject.jdField_c_of_type_Int = localUploadState.jdField_b_of_type_Int;
      this.jdField_a_of_type_AndroidOsHandler.post(new TroopAvatarController.3(this, paramObject, localUploadState));
      return;
    }
    if (localUploadState.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopAvatarManger.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopAvatarController
 * JD-Core Version:    0.7.0.1
 */