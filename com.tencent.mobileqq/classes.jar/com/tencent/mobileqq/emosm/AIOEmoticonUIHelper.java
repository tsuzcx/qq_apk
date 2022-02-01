package com.tencent.mobileqq.emosm;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.helper.AIOEmoticonGuideHelper;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.helper.OnActivityResultCallback;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
import com.tencent.mobileqq.apollo.emotionview.api.ICmShowEmotionPanelBuilder;
import com.tencent.mobileqq.apollo.emotionview.api.IEmoticonPanelCmShowHelperBuilder;
import com.tencent.mobileqq.apollo.emotionview.api.IEmotionPanelTabCreateCmShowListener;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticonview.AIOEmoticonPanelHelper;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelController;
import com.tencent.mobileqq.emoticonview.api.IAIOEmoticonPanelService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder;
import com.tencent.mobileqq.emoticonview.api.impl.AIOPanelInteractionListener;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.receipt.ReceiptHelper;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.util.WeakReference;

public class AIOEmoticonUIHelper
  implements OnFinishListener, ILifeCycleHelper, OnActivityResultCallback, PanelProvider<View>, IAIOEmoticonUIHelper
{
  public int a;
  private EmoticonObserver jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver = new AIOEmoticonUIHelper.1(this);
  protected IEmotionSearchPanel a;
  protected IEmoticonMainPanel a;
  private MagicfaceViewController jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController;
  public String a;
  private WeakReference<BaseChatPie> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  
  public AIOEmoticonUIHelper()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public AIOEmoticonUIHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseChatPie);
    paramBaseChatPie.b().a().a(this);
  }
  
  public static IEmoticonMainPanel a(BaseAIOContext paramBaseAIOContext)
  {
    if (paramBaseAIOContext == null) {
      return null;
    }
    paramBaseAIOContext = (AIOEmoticonUIHelper)paramBaseAIOContext.a(105);
    if (paramBaseAIOContext == null) {
      return null;
    }
    return paramBaseAIOContext.c();
  }
  
  private void a(View paramView)
  {
    VideoReport.setElementId(paramView, "em_aio_stickers_panel");
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_NONE);
  }
  
  public int a()
  {
    return 0;
  }
  
  public BaseChatPie a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_MqqUtilWeakReference;
    if ((localWeakReference != null) && (!localWeakReference.isEnqueued())) {
      return (BaseChatPie)this.jdField_a_of_type_MqqUtilWeakReference.get();
    }
    return null;
  }
  
  public IEmoticonMainPanel a()
  {
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie == null) {
      return null;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = ((IEmoticonMainPanelService)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(localBaseChatPie.jdField_a_of_type_AndroidContentContext, localBaseChatPie.a().jdField_a_of_type_Int);
    Object localObject2 = (AIOEmoticonPanelHelper)localBaseChatPie.a(104);
    if (localObject2 != null) {
      ((IEmoticonMainPanelService.PanelBuilder)localObject1).setCallBack((EmoticonCallback)localObject2);
    }
    boolean bool2 = ((FullScreenInputHelper)localBaseChatPie.a(24)).c();
    boolean bool1;
    if ((!bool2) && (!((ReceiptHelper)localBaseChatPie.a(118)).jdField_a_of_type_Boolean)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    ((IEmoticonMainPanelService.PanelBuilder)localObject1).setOnlySysAndEmoji(bool1);
    if (bool2) {
      ((IEmoticonMainPanelService.PanelBuilder)localObject1).setHideAllSettingTabs(true);
    }
    ICmShowEmotionPanelBuilder localICmShowEmotionPanelBuilder = (ICmShowEmotionPanelBuilder)QRoute.api(ICmShowEmotionPanelBuilder.class);
    localICmShowEmotionPanelBuilder.init(((IEmoticonMainPanelService.PanelBuilder)localObject1).getEmoticonMainPanelApp(), localBaseChatPie.jdField_a_of_type_AndroidContentContext, 4, 15, 15, (EmoticonCallback)localObject2, localBaseChatPie);
    localObject2 = new EmotionInjectionInfo(15, 4, 2130837961, localICmShowEmotionPanelBuilder);
    ((EmotionInjectionInfo)localObject2).setEmotionPanelLifecycleObserver(((IEmoticonPanelCmShowHelperBuilder)QRoute.api(IEmoticonPanelCmShowHelperBuilder.class)).build(9));
    ((EmotionInjectionInfo)localObject2).setEmotionTabCreateListener(((IEmotionPanelTabCreateCmShowListener)QRoute.api(IEmotionPanelTabCreateCmShowListener.class)).build(((IEmoticonMainPanelService.PanelBuilder)localObject1).getEmoticonMainPanelApp(), localBaseChatPie.jdField_a_of_type_AndroidContentContext));
    ((IEmoticonMainPanelService.PanelBuilder)localObject1).setDisableMoreEmotionButton(((ReceiptHelper)localBaseChatPie.a(118)).jdField_a_of_type_Boolean).setDisableGuide(((ReceiptHelper)localBaseChatPie.a(118)).jdField_a_of_type_Boolean).setPanelInteractionListener(new AIOPanelInteractionListener(localBaseChatPie)).addEmotionInjectionInfo("cmshow", (EmotionInjectionInfo)localObject2).setDefaultEpId(this.jdField_a_of_type_JavaLangString).setDefaultPanelType(this.jdField_a_of_type_Int).setToastOffset(localBaseChatPie.a());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel = ((IEmoticonMainPanelService.PanelBuilder)localObject1).create();
    if (QLog.isColorLevel())
    {
      localObject1 = getTag();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("OpenEmoticonMainPanel:");
      ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if ((localBaseChatPie instanceof BaseTroopChatPie))
    {
      bool1 = ((BaseTroopChatPie)localBaseChatPie).v();
      if (bool1) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.switchToAnonymous(bool1);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
  }
  
  public MagicfaceViewController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController == null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController = new MagicfaceViewController((BaseChatPie)this.jdField_a_of_type_MqqUtilWeakReference.get());
    }
    return this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController;
  }
  
  public void a()
  {
    IEmoticonMainPanel localIEmoticonMainPanel = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
    if (localIEmoticonMainPanel != null)
    {
      localIEmoticonMainPanel.onDestory();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel = null;
    }
  }
  
  public void a(int paramInt)
  {
    IEmoticonMainPanel localIEmoticonMainPanel = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
    if (localIEmoticonMainPanel != null) {
      localIEmoticonMainPanel.doAutoDownload(paramInt);
    }
  }
  
  public void a(Emoticon paramEmoticon, int paramInt, String paramString, boolean paramBoolean)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    AudioPanel localAudioPanel = (AudioPanel)((BaseChatPie)localObject).a().b(2);
    if ((localAudioPanel != null) && (localAudioPanel.b() != 1)) {
      return;
    }
    if ((!paramBoolean) && (paramInt == 1) && (((BaseChatPie)localObject).a() != null) && (((BaseChatPie)localObject).a().a() != 0)) {
      return;
    }
    localObject = MagicfaceActionManager.a(paramEmoticon, 1);
    if ((!paramBoolean) && (localObject != null) && (paramInt == 1) && (!((ActionGlobalData)localObject).c)) {
      return;
    }
    a().a(paramEmoticon, paramInt, paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    IEmoticonMainPanel localIEmoticonMainPanel = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
    if (localIEmoticonMainPanel != null) {
      localIEmoticonMainPanel.onHide(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, String paramString, int paramInt2)
  {
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie == null) {
      return;
    }
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmIEmotionSearchPanel == null) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmIEmotionSearchPanel = ((IEmotionSearchPanel)View.inflate(localBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131558541, null));
      }
      IEmoticonPanelHotPicSearchHelper localIEmoticonPanelHotPicSearchHelper = (IEmoticonPanelHotPicSearchHelper)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getEmoController().getHelper(7);
      this.jdField_a_of_type_ComTencentMobileqqEmosmIEmotionSearchPanel.showEmotionSearchWindow();
      int i = ScreenUtil.getRealHeight(localBaseChatPie.jdField_a_of_type_AndroidContentContext) - paramInt1 - ImmersiveUtils.getStatusBarHeight(localBaseChatPie.jdField_a_of_type_AndroidContentContext);
      if (ThemeUtil.isNowThemeIsSimple(localBaseChatPie.a(), false, null))
      {
        Rect localRect = new Rect();
        localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getGlobalVisibleRect(localRect);
        this.jdField_a_of_type_ComTencentMobileqqEmosmIEmotionSearchPanel.init(localBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getPanelInteractionListener(), i, paramBoolean2, paramString, paramInt1 - localRect.bottom, paramInt2, localIEmoticonPanelHotPicSearchHelper);
        return;
      }
      paramInt1 = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight();
      int j = localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getHeight();
      this.jdField_a_of_type_ComTencentMobileqqEmosmIEmotionSearchPanel.init(localBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getPanelInteractionListener(), i, paramBoolean2, paramString, paramInt1 + j, paramInt2, localIEmoticonPanelHotPicSearchHelper);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmIEmotionSearchPanel.onDestory();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(getTag(), 2, "recreate emotion panel due to full screen");
      }
      this.jdField_a_of_type_Boolean = false;
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    MagicfaceViewController localMagicfaceViewController = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController;
    return (localMagicfaceViewController != null) && (localMagicfaceViewController.b());
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public IEmoticonMainPanel b()
  {
    Object localObject = a();
    if (localObject == null) {
      return null;
    }
    long l = System.currentTimeMillis();
    IEmoticonMainPanelService.PanelBuilder localPanelBuilder = ((IEmoticonMainPanelService)((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(((BaseChatPie)localObject).jdField_a_of_type_AndroidContentContext, ((BaseChatPie)localObject).a().jdField_a_of_type_Int);
    AIOEmoticonPanelHelper localAIOEmoticonPanelHelper = (AIOEmoticonPanelHelper)((BaseChatPie)localObject).a(104);
    if (localAIOEmoticonPanelHelper != null) {
      localPanelBuilder.setCallBack(localAIOEmoticonPanelHelper);
    }
    localPanelBuilder.setOnlySysAndEmoji(true);
    localPanelBuilder.setHideAllSettingTabs(true);
    localPanelBuilder.setDisableMoreEmotionButton(true).setDisableGuide(true).setIsOnlySysEmotion(true).setSysEmotionOrder(IGameMsgHelperApi.SYS_EMOTION_ORDER).setPanelInteractionListener(new AIOPanelInteractionListener((BaseChatPie)localObject)).setDefaultEpId(this.jdField_a_of_type_JavaLangString).setDefaultPanelType(this.jdField_a_of_type_Int).setToastOffset(((BaseChatPie)localObject).a());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel = localPanelBuilder.create();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.setEmoSettingVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.hideAllTabs();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OpenEmoticonMainPanel:");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      QLog.d("OpenPanel", 2, ((StringBuilder)localObject).toString());
    }
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
  }
  
  public void b()
  {
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmIEmotionSearchPanel = ((IEmotionSearchPanel)localBaseChatPie.c.findViewById(2131366198));
  }
  
  public void b(boolean paramBoolean)
  {
    IEmoticonMainPanel localIEmoticonMainPanel = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
    if (localIEmoticonMainPanel != null) {
      localIEmoticonMainPanel.switchToAnonymous(paramBoolean);
    }
  }
  
  public IEmoticonMainPanel c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
  }
  
  public void c()
  {
    k();
    a();
    IEmotionSearchPanel localIEmotionSearchPanel = this.jdField_a_of_type_ComTencentMobileqqEmosmIEmotionSearchPanel;
    if (localIEmotionSearchPanel != null) {
      localIEmotionSearchPanel.onDestory();
    }
  }
  
  public View createPanel(Context paramContext)
  {
    paramContext = a();
    if (paramContext != null)
    {
      paramContext = paramContext.getView();
      a(paramContext);
      return paramContext;
    }
    return null;
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
    if (localObject != null) {
      ((IEmoticonMainPanel)localObject).onPause();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController;
    if (localObject != null) {
      ((MagicfaceViewController)localObject).h();
    }
  }
  
  public void d(int paramInt) {}
  
  public void e()
  {
    IEmoticonMainPanel localIEmoticonMainPanel = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
    if (localIEmoticonMainPanel != null) {
      localIEmoticonMainPanel.onResume();
    }
  }
  
  public void f()
  {
    IEmoticonMainPanel localIEmoticonMainPanel = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
    if (localIEmoticonMainPanel != null) {
      localIEmoticonMainPanel.onShow();
    }
  }
  
  public void g()
  {
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel != null) {
      this.jdField_a_of_type_Boolean = (((FullScreenInputHelper)localBaseChatPie.a(24)).c() ^ this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.isOnlySysAndEmoji());
    }
    localBaseChatPie.a().a(3);
    IEmoticonMainPanel localIEmoticonMainPanel = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
    if (localIEmoticonMainPanel != null) {
      localIEmoticonMainPanel.preloadWebProcess();
    }
    ((AIOEmoticonGuideHelper)localBaseChatPie.a(54)).a();
    AIOPanelUtiles.a(localBaseChatPie.a(), "0X8005CAD", localBaseChatPie.a().jdField_a_of_type_Int);
    VasWebviewUtil.a(localBaseChatPie.a().getCurrentUin(), "ep_mall", "0X8005795", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
  
  public View getPanel()
  {
    IEmoticonMainPanel localIEmoticonMainPanel = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
    if (localIEmoticonMainPanel == null) {
      return null;
    }
    return localIEmoticonMainPanel.getView();
  }
  
  public int getPanelId()
  {
    return 3;
  }
  
  @NonNull
  public String getTag()
  {
    return getClass().getName();
  }
  
  public void h()
  {
    IEmoticonMainPanel localIEmoticonMainPanel = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
    if (localIEmoticonMainPanel != null) {
      localIEmoticonMainPanel.setIsHiden(true);
    }
  }
  
  public void i()
  {
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie == null) {
      return;
    }
    IEmoticonMainPanel localIEmoticonMainPanel = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
    if (localIEmoticonMainPanel != null)
    {
      localIEmoticonMainPanel.setOnlySysAndEmoji(((ReceiptHelper)localBaseChatPie.a(118)).jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.setDisableMoreEmotionButton(((ReceiptHelper)localBaseChatPie.a(118)).jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.setDisableGuide(((ReceiptHelper)localBaseChatPie.a(118)).jdField_a_of_type_Boolean);
      if (!((ReceiptHelper)localBaseChatPie.a(118)).jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.setDisableGuideOneTime(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.init(localBaseChatPie.a(), localBaseChatPie.a().jdField_a_of_type_Int, localBaseChatPie.jdField_a_of_type_AndroidContentContext, localBaseChatPie.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
  }
  
  public int[] interestedIn()
  {
    return new int[] { 0, 15, 7, 11, 6, 10, 1 };
  }
  
  public boolean isNeedRecreatePanel()
  {
    return a();
  }
  
  public void j()
  {
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie == null) {
      return;
    }
    localBaseChatPie.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
  }
  
  public void k()
  {
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie == null) {
      return;
    }
    localBaseChatPie.a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 4779) && (paramInt2 == 8213))
    {
      a(17);
      return;
    }
    if ((paramInt1 == 4813) && (paramInt2 == 8213)) {
      a(18);
    }
  }
  
  public void onHideAllPanel()
  {
    ((IAIOEmoticonPanelService)QRoute.api(IAIOEmoticonPanelService.class)).removeStickerMask(((BaseChatPie)this.jdField_a_of_type_MqqUtilWeakReference.get()).a().a());
    h();
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 6)
        {
          if (paramInt != 7)
          {
            if (paramInt != 11)
            {
              if (paramInt != 15) {
                return;
              }
              c();
              return;
            }
            d();
            return;
          }
          e();
          return;
        }
        a();
        return;
      }
      j();
      return;
    }
    b();
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3)
    {
      boolean bool = true;
      if (paramInt2 != 1) {
        bool = false;
      }
      a(bool);
    }
    if (paramInt2 == 3)
    {
      ((IAIOEmoticonPanelService)QRoute.api(IAIOEmoticonPanelService.class)).setOpenStartTime(System.currentTimeMillis());
      StartupTracker.a(null, "AIO_EmoticonPanel_OpenDuration");
      f();
    }
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    paramXPanelContainer = a();
    if (paramXPanelContainer == null) {
      return;
    }
    if ((paramXPanelContainer instanceof LimitChatPie)) {
      ReportController.b(paramXPanelContainer.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096AD", "0X80096AD", ((LimitChatPie)paramXPanelContainer).j(), 0, "", "", "", "");
    }
    g();
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.AIOEmoticonUIHelper
 * JD-Core Version:    0.7.0.1
 */