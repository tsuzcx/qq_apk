package com.tencent.mobileqq.profilecard.vas;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.VipWZRYTemplateHelper;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplateCheckUtils;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class VasProfileTemplateController
{
  private static final int MAX_TRY_DOWNLOAD_TIMES = 3;
  private static final String TAG = "ProfileTemplateCheckController";
  private FriendProfileCardActivity mActivity;
  private QQAppInterface mApp;
  private ProfileCardInfo mCardInfo;
  private int mDownloadProfileResTimes = 0;
  private boolean mFirstCheckTemplate = true;
  private boolean mHasDownloadWZRYTemplate;
  private AtomicBoolean mIsDownloadTemplateRunning = new AtomicBoolean(false);
  public boolean updateBG;
  public boolean updateDiyText;
  public boolean updateStyle;
  
  public VasProfileTemplateController(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    this.mActivity = paramFriendProfileCardActivity;
    this.mApp = paramFriendProfileCardActivity.app;
    this.mCardInfo = paramFriendProfileCardActivity.a;
  }
  
  private void checkDynamicRes(Card paramCard, ProfileCardTemplate paramProfileCardTemplate)
  {
    String str = paramCard.backgroundUrl;
    int i = paramCard.dynamicCardFlag;
    long l = paramCard.lCurrentBgId;
    if (i == 1)
    {
      boolean bool = ProfileCardManager.a(this.mApp.getApp(), l, ".dynamic");
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckController", 2, String.format("onCardUpdate dynamicBackgroundExist=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      if ((!bool) && (tryDownload())) {
        downloadProfileCardRes(str, l, paramProfileCardTemplate);
      }
    }
  }
  
  private void checkSimpleRes(Card paramCard)
  {
    if (paramCard.lCurrentStyleId != ProfileCardTemplate.g) {}
    while (VipProfileCardDiyActivity.a(this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextFontId)) {
      return;
    }
    paramCard = (IVasQuickUpdateService)this.mApp.getRuntimeService(IVasQuickUpdateService.class, "");
    paramCard.addCallBacker(new VasProfileTemplateController.1(this, paramCard));
    paramCard.downloadItem(5L, "font.diycard.android." + this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextFontId, "ProfileTemplateCheckController");
  }
  
  private void checkWzryRes(Card paramCard, ProfileCardTemplate paramProfileCardTemplate)
  {
    String str = paramCard.backgroundUrl;
    long l = paramCard.lCurrentBgId;
    boolean bool;
    if (paramCard.lCurrentStyleId == ProfileCardTemplate.j)
    {
      bool = ProfileCardManager.a(this.mApp.getApp(), paramCard.lCurrentBgId, "wzMainImage.png");
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckController", 2, String.format("onCardUpdate heroFileExist=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      if ((!bool) && (tryDownload())) {
        downloadProfileCardRes(str, l, paramProfileCardTemplate);
      }
    }
    if ((paramCard.lCurrentStyleId == ProfileCardTemplate.j) || (paramCard.lCurrentStyleId == ProfileCardTemplate.i))
    {
      bool = VipWZRYTemplateHelper.a(this.mActivity, "cardWZ.zip");
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckController", 2, String.format("onCardUpdate heroTemplateExist=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      if ((!this.mHasDownloadWZRYTemplate) && (!bool))
      {
        VipWZRYTemplateHelper.a(this.mApp, new VasProfileTemplateController.2(this, paramProfileCardTemplate, paramCard));
        this.mHasDownloadWZRYTemplate = true;
      }
    }
  }
  
  private void downloadProfileCardRes(String paramString, long paramLong, ProfileCardTemplate paramProfileCardTemplate)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckController", 2, String.format("downloadProfileCardRes bgUrl=%s bgId=%s mIsDownloadTemplateRunning=%s", new Object[] { paramString, Long.valueOf(paramLong), this.mIsDownloadTemplateRunning }));
    }
    if ((paramLong != 160L) && (paramLong != 1600L)) {
      ((VasExtensionManager)this.mApp.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.a(this.mApp, "card." + paramLong);
    }
    if (!this.mIsDownloadTemplateRunning.get())
    {
      this.mIsDownloadTemplateRunning.set(true);
      ThreadManagerV2.excute(new VasProfileTemplateController.DownloadTemplateRunnable(this.mActivity, paramProfileCardTemplate, this.mIsDownloadTemplateRunning, paramString, paramLong), 128, null, true);
    }
  }
  
  private boolean isBackgroundResExist(Card paramCard)
  {
    long l1 = paramCard.lCurrentStyleId;
    String str = paramCard.backgroundUrl;
    int i = paramCard.dynamicCardFlag;
    long l2 = paramCard.lCurrentBgId;
    boolean bool3 = ProfileCardUtil.a(this.mApp);
    boolean bool1;
    if ((l2 == 160L) || (l2 == 1600L)) {
      bool1 = ProfileCardUtil.a(this.mApp.getApp(), str);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckController", 2, String.format("onCardUpdate commonDirExist=%s backgroundImageExist=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) }));
      }
      if ((!bool3) || (!bool1)) {
        break;
      }
      return true;
      if (i == 1)
      {
        boolean bool2 = ProfileCardManager.a(this.mApp.getApp(), l2, "dynamicBottom.jpg");
        bool1 = bool2;
        if (!bool2) {
          bool1 = new File(ProfileCardManager.a(this.mApp.getApp(), l1, l2)).exists();
        }
      }
      else
      {
        bool1 = new File(ProfileCardManager.a(this.mApp.getApp(), l1, l2)).exists();
      }
    }
    return false;
  }
  
  private boolean tryDownload()
  {
    if (this.mDownloadProfileResTimes > 3) {
      return false;
    }
    this.mDownloadProfileResTimes += 1;
    return true;
  }
  
  public void onCardUpdate(Card paramCard, int paramInt)
  {
    this.updateBG = false;
    this.updateStyle = false;
    this.updateDiyText = false;
    if (paramInt == 8)
    {
      if (this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        if (!TextUtils.isEmpty(this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl)) {
          break label305;
        }
        if (!TextUtils.isEmpty(paramCard.backgroundUrl)) {
          this.updateBG = true;
        }
        if ((this.mCardInfo.jdField_a_of_type_Long != paramCard.lCurrentStyleId) || (this.mCardInfo.b != ProfileCardTemplate.a(paramCard))) {
          this.updateStyle = true;
        }
        if ((this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == ProfileCardTemplate.g) && (!TextUtils.isEmpty(paramCard.diyText))) {
          this.updateDiyText = true;
        }
      }
      label129:
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckController", 2, String.format("onCardUpdate updateBG=%s updateStyle=%s updateDiyText=%s", new Object[] { Boolean.valueOf(this.updateBG), Boolean.valueOf(this.updateStyle), Boolean.valueOf(this.updateDiyText) }));
      }
      this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
      if ((this.mFirstCheckTemplate) || (this.updateBG) || (this.updateStyle)) {
        this.mFirstCheckTemplate = false;
      }
    }
    for (;;)
    {
      try
      {
        l1 = paramCard.lCurrentStyleId;
        paramInt = paramCard.templateRet;
        String str = paramCard.backgroundUrl;
        l2 = paramCard.backgroundColor;
        l3 = paramCard.lCurrentBgId;
        localProfileCardTemplate = ProfileCardUtil.a(this.mApp, l1, true);
        if ((l1 > 0L) && (localProfileCardTemplate != null) && (!TextUtils.isEmpty(str)) && (paramInt == 0)) {
          continue;
        }
        this.mCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
      }
      catch (Throwable localThrowable)
      {
        long l1;
        long l2;
        long l3;
        ProfileCardTemplate localProfileCardTemplate;
        label305:
        QLog.e("ProfileTemplateCheckController", 1, "onCardUpdate fail.", localThrowable);
        this.mCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
        continue;
        this.mCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
        continue;
        if (!tryDownload()) {
          continue;
        }
        downloadProfileCardRes(localThrowable, l3, localProfileCardTemplate);
        continue;
        this.mCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
        continue;
      }
      if (this.updateDiyText) {
        checkSimpleRes(paramCard);
      }
      VasProfileTemplateCheckUtils.checkCurrentUseTemplate(this.mCardInfo);
      return;
      if (this.mCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl.equals(paramCard.backgroundUrl)) {
        break;
      }
      this.updateBG = true;
      break;
      if (paramInt != 13) {
        break label129;
      }
      this.updateBG = true;
      break label129;
      if (!isBackgroundResExist(paramCard)) {
        continue;
      }
      if (!localProfileCardTemplate.a(this.mApp, l2, l1)) {
        continue;
      }
      this.mCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = localProfileCardTemplate;
      checkDynamicRes(paramCard, localProfileCardTemplate);
      checkWzryRes(paramCard, localProfileCardTemplate);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.VasProfileTemplateController
 * JD-Core Version:    0.7.0.1
 */