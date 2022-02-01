package com.tencent.mobileqq.profilecard.vas;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profile.VipWZRYTemplateHelper;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ITemplateManager;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplateCheckUtils;
import com.tencent.mobileqq.util.ProfileCardTemplateUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.profilecard.IProfileTemplateController;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import mqq.app.MobileQQ;

public class VasProfileTemplateController
  implements IProfileTemplateController
{
  private static final int MAX_TRY_DOWNLOAD_TIMES = 3;
  private static final String TAG = "ProfileTemplateCheckController";
  private final QQAppInterface mApp;
  private final Context mContext;
  private int mDownloadProfileResTimes = 0;
  private boolean mFirstCheckTemplate = true;
  private boolean mHasDownloadWZRYTemplate;
  private AtomicBoolean mIsDownloadTemplateRunning = new AtomicBoolean(false);
  private final Function0<Unit> mUpdateCallback;
  public boolean updateBG;
  public boolean updateDiyText;
  public boolean updateStyle;
  
  public VasProfileTemplateController(Activity paramActivity, Function0<Unit> paramFunction0)
  {
    this.mUpdateCallback = paramFunction0;
    this.mContext = paramActivity;
    this.mApp = ((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
  }
  
  private void checkDynamicRes(Card paramCard, ProfileCardTemplate paramProfileCardTemplate)
  {
    String str = paramCard.backgroundUrl;
    int i = paramCard.dynamicCardFlag;
    long l = paramCard.lCurrentBgId;
    if (i == 1)
    {
      boolean bool = ProfileCardManager.a(this.mContext, l, ".dynamic");
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
    if (paramCard.lCurrentStyleId != ProfileCardTemplate.PROFILE_CARD_STYLE_SIMPLE) {
      return;
    }
    int i = paramCard.diyTextFontId;
    if (!VipProfileCardDiyActivity.a(i))
    {
      paramCard = (IVasQuickUpdateService)this.mApp.getRuntimeService(IVasQuickUpdateService.class, "");
      paramCard.addCallBacker(new VasProfileTemplateController.1(this, i, paramCard));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("font.diycard.android.");
      localStringBuilder.append(i);
      paramCard.downloadItem(5L, localStringBuilder.toString(), "ProfileTemplateCheckController");
    }
  }
  
  private void checkWzryRes(Card paramCard, ProfileCardTemplate paramProfileCardTemplate)
  {
    String str = paramCard.backgroundUrl;
    long l = paramCard.lCurrentBgId;
    boolean bool;
    if (paramCard.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC)
    {
      bool = ProfileCardManager.a(this.mContext, paramCard.lCurrentBgId, "wzMainImage.png");
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckController", 2, String.format("onCardUpdate heroFileExist=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      if ((!bool) && (tryDownload())) {
        downloadProfileCardRes(str, l, paramProfileCardTemplate);
      }
    }
    if ((paramCard.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC) || (paramCard.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC))
    {
      bool = VipWZRYTemplateHelper.a("cardWZ.zip");
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckController", 2, String.format("onCardUpdate heroTemplateExist=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      if ((!this.mHasDownloadWZRYTemplate) && (!bool))
      {
        VipWZRYTemplateHelper.a(new VasProfileTemplateController.2(this));
        this.mHasDownloadWZRYTemplate = true;
      }
    }
  }
  
  private void downloadProfileCardRes(String paramString, long paramLong, ProfileCardTemplate paramProfileCardTemplate)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckController", 2, String.format("downloadProfileCardRes bgUrl=%s bgId=%s mIsDownloadTemplateRunning=%s", new Object[] { paramString, Long.valueOf(paramLong), this.mIsDownloadTemplateRunning }));
    }
    if ((paramLong != 160L) && (paramLong != 1600L))
    {
      ProfileCardManager localProfileCardManager = ((VasExtensionManager)this.mApp.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a;
      QQAppInterface localQQAppInterface = this.mApp;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("card.");
      localStringBuilder.append(paramLong);
      localProfileCardManager.a(localQQAppInterface, localStringBuilder.toString());
    }
    if (!this.mIsDownloadTemplateRunning.get())
    {
      this.mIsDownloadTemplateRunning.set(true);
      ThreadManagerV2.excute(new VasProfileTemplateController.DownloadTemplateRunnable(paramProfileCardTemplate, this.mIsDownloadTemplateRunning, paramString, paramLong, new VasProfileTemplateController.3(this)), 128, null, true);
    }
  }
  
  private boolean isBackgroundResExist(Card paramCard)
  {
    long l1 = paramCard.lCurrentStyleId;
    String str = paramCard.backgroundUrl;
    int i = paramCard.dynamicCardFlag;
    long l2 = paramCard.lCurrentBgId;
    boolean bool4 = ProfileCardTemplateUtil.a();
    boolean bool1;
    if ((l2 != 160L) && (l2 != 1600L))
    {
      if (i == 1)
      {
        bool2 = ProfileCardManager.a(this.mContext, l2, "dynamicBottom.jpg");
        bool1 = bool2;
        if (!bool2) {
          bool1 = new File(ProfileCardManager.a(this.mContext, l1, l2)).exists();
        }
      }
      else
      {
        bool1 = new File(ProfileCardManager.a(this.mContext, l1, l2)).exists();
      }
    }
    else {
      bool1 = ProfileCardUtil.a(str);
    }
    boolean bool2 = QLog.isColorLevel();
    boolean bool3 = false;
    if (bool2) {
      QLog.d("ProfileTemplateCheckController", 2, String.format("onCardUpdate commonDirExist=%s backgroundImageExist=%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool1) }));
    }
    bool2 = bool3;
    if (bool4)
    {
      bool2 = bool3;
      if (bool1) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  private void onUpdateCard()
  {
    this.mUpdateCallback.invoke();
  }
  
  private void setUpdateParams(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo, Card paramCard)
  {
    if (paramProfileCardInfo.card != null)
    {
      if (TextUtils.isEmpty(paramProfileCardInfo.card.backgroundUrl))
      {
        if (!TextUtils.isEmpty(paramCard.backgroundUrl)) {
          this.updateBG = true;
        }
      }
      else if (!paramProfileCardInfo.card.backgroundUrl.equals(paramCard.backgroundUrl)) {
        this.updateBG = true;
      }
      if ((paramProfileCardInfo.curUseStyleId != paramCard.lCurrentStyleId) || (paramProfileCardInfo.curUseTemplateVersion != ProfileTemplateApi.getTemplateManager(paramIComponentCenter).getDiyTemplateVersion(paramCard))) {
        this.updateStyle = true;
      }
      if ((paramProfileCardInfo.card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_SIMPLE) && (!TextUtils.isEmpty(paramCard.diyText))) {
        this.updateDiyText = true;
      }
    }
  }
  
  private boolean tryDownload()
  {
    int i = this.mDownloadProfileResTimes;
    if (i > 3) {
      return false;
    }
    this.mDownloadProfileResTimes = (i + 1);
    return true;
  }
  
  private void updateTemplateInfo(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo, Card paramCard)
  {
    long l1 = paramCard.lCurrentStyleId;
    int i = paramCard.templateRet;
    String str = paramCard.backgroundUrl;
    long l2 = paramCard.backgroundColor;
    long l3 = paramCard.lCurrentBgId;
    ProfileCardTemplate localProfileCardTemplate = ProfileCardTemplateUtil.a(l1, true);
    if ((l1 > 0L) && (localProfileCardTemplate != null) && (!TextUtils.isEmpty(str)) && (i == 0))
    {
      if (isBackgroundResExist(paramCard))
      {
        if (ProfileTemplateApi.getTemplateUtils(paramIComponentCenter).initTemplateConfig(localProfileCardTemplate, l2, l1))
        {
          paramProfileCardInfo.currentTemplate = localProfileCardTemplate;
          checkDynamicRes(paramCard, localProfileCardTemplate);
          checkWzryRes(paramCard, localProfileCardTemplate);
          return;
        }
        paramProfileCardInfo.currentTemplate = null;
        return;
      }
      if (tryDownload())
      {
        downloadProfileCardRes(str, l3, localProfileCardTemplate);
        return;
      }
      paramProfileCardInfo.currentTemplate = null;
      return;
    }
    paramProfileCardInfo.currentTemplate = null;
  }
  
  public boolean onCardUpdate(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    Card localCard = paramProfileCardInfo.card;
    boolean bool = false;
    this.updateBG = false;
    this.updateStyle = false;
    this.updateDiyText = false;
    setUpdateParams(paramIComponentCenter, paramProfileCardInfo, localCard);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckController", 2, String.format("onCardUpdate updateBG=%s updateStyle=%s updateDiyText=%s", new Object[] { Boolean.valueOf(this.updateBG), Boolean.valueOf(this.updateStyle), Boolean.valueOf(this.updateDiyText) }));
    }
    paramProfileCardInfo.card = localCard;
    if ((this.mFirstCheckTemplate) || (this.updateBG) || (this.updateStyle))
    {
      this.mFirstCheckTemplate = false;
      try
      {
        updateTemplateInfo(paramIComponentCenter, paramProfileCardInfo, localCard);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ProfileTemplateCheckController", 1, "onCardUpdate fail.", localThrowable);
        paramProfileCardInfo.currentTemplate = null;
      }
    }
    if (this.updateDiyText) {
      checkSimpleRes(localCard);
    }
    VasProfileTemplateCheckUtils.checkCurrentUseTemplate(paramIComponentCenter, paramProfileCardInfo);
    if ((this.updateBG) || (this.updateStyle) || (this.updateDiyText)) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.VasProfileTemplateController
 * JD-Core Version:    0.7.0.1
 */