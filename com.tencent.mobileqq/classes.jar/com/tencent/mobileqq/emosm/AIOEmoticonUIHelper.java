package com.tencent.mobileqq.emosm;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerHelper;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottie;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottieView;
import com.tencent.mobileqq.emoticonview.api.IAIOEmoticonPanelService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder;
import com.tencent.mobileqq.emoticonview.api.impl.AIOPanelInteractionListener;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
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
  protected IEmoticonMainPanel a;
  protected IEmotionSearchPanel b;
  public String c;
  public int d = -1;
  private WeakReference<BaseChatPie> e;
  private boolean f = false;
  private MagicfaceViewController g;
  private EmoticonObserver h = new AIOEmoticonUIHelper.1(this);
  
  public AIOEmoticonUIHelper() {}
  
  public AIOEmoticonUIHelper(BaseChatPie paramBaseChatPie)
  {
    this.e = new WeakReference(paramBaseChatPie);
    paramBaseChatPie.bv().d().a(this);
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
    return paramBaseAIOContext.j();
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    int i = 0;
    while (i < paramViewGroup.getChildCount())
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup))
      {
        localView.setBackgroundColor(Color.parseColor("#18191C"));
        a((ViewGroup)localView);
      }
      i += 1;
    }
  }
  
  public ActionGlobalData a(Emoticon paramEmoticon, int paramInt)
  {
    return MagicfaceActionManager.a(paramEmoticon, paramInt);
  }
  
  public MagicfaceViewController a()
  {
    if (this.g == null) {
      this.g = new MagicfaceViewController((BaseChatPie)this.e.get());
    }
    return this.g;
  }
  
  public void a(int paramInt)
  {
    IEmoticonMainPanel localIEmoticonMainPanel = this.a;
    if (localIEmoticonMainPanel != null) {
      localIEmoticonMainPanel.doAutoDownload(paramInt);
    }
  }
  
  protected void a(View paramView)
  {
    VideoReport.setElementId(paramView, "em_aio_stickers_panel");
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_NONE);
  }
  
  public void a(Emoticon paramEmoticon, int paramInt, String paramString, boolean paramBoolean)
  {
    Object localObject = b();
    if (localObject == null) {
      return;
    }
    AudioPanel localAudioPanel = (AudioPanel)((BaseChatPie)localObject).bq().d(2);
    if ((localAudioPanel != null) && (localAudioPanel.getStatus() != 1)) {
      return;
    }
    if ((!paramBoolean) && (paramInt == 1) && (((BaseChatPie)localObject).bm() != null) && (((BaseChatPie)localObject).bm().getCurrentPanel() != 0)) {
      return;
    }
    localObject = a(paramEmoticon, 1);
    if ((!paramBoolean) && (localObject != null) && (paramInt == 1) && (!((ActionGlobalData)localObject).e)) {
      return;
    }
    a().a(paramEmoticon, paramInt, paramString);
  }
  
  public void a(IEmoticonMainPanel paramIEmoticonMainPanel)
  {
    this.a = paramIEmoticonMainPanel;
  }
  
  public void a(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, String paramString, int paramInt2)
  {
    BaseChatPie localBaseChatPie = b();
    if (localBaseChatPie == null) {
      return;
    }
    if (paramBoolean1)
    {
      if (this.b == null) {
        this.b = ((IEmotionSearchPanel)View.inflate(localBaseChatPie.e, 2131624094, null));
      }
      IEmoticonPanelHotPicSearchHelper localIEmoticonPanelHotPicSearchHelper = (IEmoticonPanelHotPicSearchHelper)this.a.getEmoController().getHelper(7);
      this.b.showEmotionSearchWindow();
      int i = ScreenUtil.getRealHeight(localBaseChatPie.e) - paramInt1 - ImmersiveUtils.getStatusBarHeight(localBaseChatPie.e);
      if (ThemeUtil.isNowThemeIsSimple(localBaseChatPie.i(), false, null))
      {
        Rect localRect = new Rect();
        localBaseChatPie.Y.getGlobalVisibleRect(localRect);
        this.b.init(localBaseChatPie.i(), this.a.getPanelInteractionListener(), i, paramBoolean2, paramString, paramInt1 - localRect.bottom, paramInt2, localIEmoticonPanelHotPicSearchHelper);
      }
      else
      {
        paramInt1 = localBaseChatPie.W.getHeight();
        int j = localBaseChatPie.Y.getHeight();
        this.b.init(localBaseChatPie.i(), this.a.getPanelInteractionListener(), i, paramBoolean2, paramString, paramInt1 + j, paramInt2, localIEmoticonPanelHotPicSearchHelper);
      }
      if (((IGuildTempApi)QRoute.api(IGuildTempApi.class)).checkChatPie(this.e.get())) {
        a((ViewGroup)this.b);
      }
    }
    else
    {
      this.b.onDestory();
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public BaseChatPie b()
  {
    WeakReference localWeakReference = this.e;
    if ((localWeakReference != null) && (!localWeakReference.isEnqueued())) {
      return (BaseChatPie)this.e.get();
    }
    return null;
  }
  
  public void b(boolean paramBoolean)
  {
    IEmoticonMainPanel localIEmoticonMainPanel = this.a;
    if (localIEmoticonMainPanel != null) {
      localIEmoticonMainPanel.onHide(paramBoolean);
    }
  }
  
  public int bM_()
  {
    return 0;
  }
  
  public void c(boolean paramBoolean)
  {
    IEmoticonMainPanel localIEmoticonMainPanel = this.a;
    if (localIEmoticonMainPanel != null) {
      localIEmoticonMainPanel.switchToAnonymous(paramBoolean);
    }
  }
  
  public View createPanel(Context paramContext)
  {
    paramContext = d();
    if (paramContext != null)
    {
      paramContext = paramContext.getView();
      a(paramContext);
      return paramContext;
    }
    return null;
  }
  
  public IEmoticonMainPanel d()
  {
    BaseChatPie localBaseChatPie = b();
    if (localBaseChatPie == null) {
      return null;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = ((IEmoticonMainPanelService)localBaseChatPie.d.getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(localBaseChatPie.e, localBaseChatPie.aE().a);
    Object localObject2 = (AIOEmoticonPanelHelper)localBaseChatPie.q(104);
    if (localObject2 != null) {
      ((IEmoticonMainPanelService.PanelBuilder)localObject1).setCallBack((EmoticonCallback)localObject2);
    }
    boolean bool2 = ((FullScreenInputHelper)localBaseChatPie.q(24)).e();
    boolean bool1;
    if ((!bool2) && (!((ReceiptHelper)localBaseChatPie.q(118)).a)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    ((IEmoticonMainPanelService.PanelBuilder)localObject1).setOnlySysAndEmoji(bool1);
    if (bool2) {
      ((IEmoticonMainPanelService.PanelBuilder)localObject1).setHideAllSettingTabs(true);
    }
    ICmShowEmotionPanelBuilder localICmShowEmotionPanelBuilder = (ICmShowEmotionPanelBuilder)QRoute.api(ICmShowEmotionPanelBuilder.class);
    localICmShowEmotionPanelBuilder.init(((IEmoticonMainPanelService.PanelBuilder)localObject1).getEmoticonMainPanelApp(), localBaseChatPie.e, 4, 15, 15, (EmoticonCallback)localObject2, localBaseChatPie);
    localObject2 = new EmotionInjectionInfo(15, 4, 2130837985, localICmShowEmotionPanelBuilder);
    ((EmotionInjectionInfo)localObject2).setEmotionPanelLifecycleObserver(((IEmoticonPanelCmShowHelperBuilder)QRoute.api(IEmoticonPanelCmShowHelperBuilder.class)).build(9));
    ((EmotionInjectionInfo)localObject2).setEmotionTabCreateListener(((IEmotionPanelTabCreateCmShowListener)QRoute.api(IEmotionPanelTabCreateCmShowListener.class)).build(((IEmoticonMainPanelService.PanelBuilder)localObject1).getEmoticonMainPanelApp(), localBaseChatPie.e));
    ((IEmoticonMainPanelService.PanelBuilder)localObject1).setDisableMoreEmotionButton(((ReceiptHelper)localBaseChatPie.q(118)).a).setDisableGuide(((ReceiptHelper)localBaseChatPie.q(118)).a).setPanelInteractionListener(new AIOPanelInteractionListener(localBaseChatPie)).setDefaultEpId(this.c).setDefaultPanelType(this.d).setIsGuildLiveChannel(((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeIsGuildLiveChannelChatPie(localBaseChatPie)).setToastOffset(localBaseChatPie.A());
    if (localBaseChatPie.aE().a != 10014) {
      ((IEmoticonMainPanelService.PanelBuilder)localObject1).addEmotionInjectionInfo("cmshow", (EmotionInjectionInfo)localObject2);
    }
    this.a = ((IEmoticonMainPanelService.PanelBuilder)localObject1).create();
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
      bool1 = ((BaseTroopChatPie)localBaseChatPie).bG();
      if (bool1) {
        this.a.switchToAnonymous(bool1);
      }
    }
    return this.a;
  }
  
  public boolean d(int paramInt)
  {
    MagicfaceViewController localMagicfaceViewController = this.g;
    return (localMagicfaceViewController != null) && (localMagicfaceViewController.i());
  }
  
  public void e()
  {
    IEmoticonMainPanel localIEmoticonMainPanel = this.a;
    if (localIEmoticonMainPanel != null)
    {
      localIEmoticonMainPanel.onDestory();
      this.a = null;
    }
  }
  
  public void e(int paramInt) {}
  
  public void f()
  {
    BaseChatPie localBaseChatPie = b();
    if (localBaseChatPie == null) {
      return;
    }
    this.b = ((IEmotionSearchPanel)localBaseChatPie.aZ.findViewById(2131432486));
  }
  
  public void g()
  {
    q();
    e();
    IEmotionSearchPanel localIEmotionSearchPanel = this.b;
    if (localIEmotionSearchPanel != null) {
      localIEmotionSearchPanel.onDestory();
    }
    AniStickerHelper.clearAniStickerCache();
  }
  
  public View getPanel()
  {
    IEmoticonMainPanel localIEmoticonMainPanel = this.a;
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
    Object localObject = this.a;
    if (localObject != null) {
      ((IEmoticonMainPanel)localObject).onPause();
    }
    localObject = this.g;
    if (localObject != null) {
      ((MagicfaceViewController)localObject).j();
    }
  }
  
  public void i()
  {
    IEmoticonMainPanel localIEmoticonMainPanel = this.a;
    if (localIEmoticonMainPanel != null) {
      localIEmoticonMainPanel.onResume();
    }
  }
  
  public int[] interestedIn()
  {
    return new int[] { 0, 15, 7, 11, 6, 10, 1, 18, 17, 16 };
  }
  
  public boolean isNeedRecreatePanel()
  {
    return l();
  }
  
  public IEmoticonMainPanel j()
  {
    return this.a;
  }
  
  public void k()
  {
    IEmoticonMainPanel localIEmoticonMainPanel = this.a;
    if (localIEmoticonMainPanel != null) {
      localIEmoticonMainPanel.onShow();
    }
  }
  
  public boolean l()
  {
    if (this.f)
    {
      if (QLog.isColorLevel()) {
        QLog.d(getTag(), 2, "recreate emotion panel due to full screen");
      }
      this.f = false;
      return true;
    }
    return false;
  }
  
  public void m()
  {
    BaseChatPie localBaseChatPie = b();
    if (localBaseChatPie == null) {
      return;
    }
    if (this.a != null) {
      this.f = (((FullScreenInputHelper)localBaseChatPie.q(24)).e() ^ this.a.isOnlySysAndEmoji());
    }
    localBaseChatPie.bm().a(3);
    IEmoticonMainPanel localIEmoticonMainPanel = this.a;
    if (localIEmoticonMainPanel != null) {
      localIEmoticonMainPanel.preloadWebProcess();
    }
    ((AIOEmoticonGuideHelper)localBaseChatPie.q(54)).a();
    AIOPanelUtiles.a(localBaseChatPie.i(), "0X8005CAD", localBaseChatPie.aE().a);
    VasWebviewUtil.a(localBaseChatPie.i().getCurrentUin(), "ep_mall", "0X8005795", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
  
  public void n()
  {
    IEmoticonMainPanel localIEmoticonMainPanel = this.a;
    if (localIEmoticonMainPanel != null) {
      localIEmoticonMainPanel.setIsHiden(true);
    }
  }
  
  public void o()
  {
    BaseChatPie localBaseChatPie = b();
    if (localBaseChatPie == null) {
      return;
    }
    IEmoticonMainPanel localIEmoticonMainPanel = this.a;
    if (localIEmoticonMainPanel != null)
    {
      localIEmoticonMainPanel.setOnlySysAndEmoji(((ReceiptHelper)localBaseChatPie.q(118)).a);
      this.a.setDisableMoreEmotionButton(((ReceiptHelper)localBaseChatPie.q(118)).a);
      this.a.setDisableGuide(((ReceiptHelper)localBaseChatPie.q(118)).a);
      if (!((ReceiptHelper)localBaseChatPie.q(118)).a) {
        this.a.setDisableGuideOneTime(true);
      }
      this.a.init(localBaseChatPie.i(), localBaseChatPie.aE().a, localBaseChatPie.e, localBaseChatPie.A(), this.c, this.d);
    }
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
    ((IAIOEmoticonPanelService)QRoute.api(IAIOEmoticonPanelService.class)).removeStickerMask(((BaseChatPie)this.e.get()).bq().c());
    n();
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
              switch (paramInt)
              {
              default: 
                return;
              case 18: 
                AniStickerLottieView.resumeAll();
                return;
              case 16: 
              case 17: 
                AniStickerLottieView.pauseAll();
                return;
              }
              g();
              AniStickerLottie.refreshCache();
              return;
            }
            h();
            return;
          }
          i();
          return;
        }
        e();
        return;
      }
      p();
      return;
    }
    f();
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3)
    {
      boolean bool = true;
      if (paramInt2 != 1) {
        bool = false;
      }
      b(bool);
    }
    if (paramInt2 == 3)
    {
      ((IAIOEmoticonPanelService)QRoute.api(IAIOEmoticonPanelService.class)).setOpenStartTime(System.currentTimeMillis());
      StartupTracker.a(null, "AIO_EmoticonPanel_OpenDuration");
      k();
    }
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    paramXPanelContainer = b();
    if (paramXPanelContainer == null) {
      return;
    }
    if ((paramXPanelContainer instanceof LimitChatPie)) {
      ReportController.b(paramXPanelContainer.d, "dc00898", "", "", "0X80096AD", "0X80096AD", ((LimitChatPie)paramXPanelContainer).bI(), 0, "", "", "", "");
    }
    m();
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void p()
  {
    BaseChatPie localBaseChatPie = b();
    if (localBaseChatPie == null) {
      return;
    }
    localBaseChatPie.i().addObserver(this.h);
  }
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
  
  public void q()
  {
    BaseChatPie localBaseChatPie = b();
    if (localBaseChatPie == null) {
      return;
    }
    localBaseChatPie.i().removeObserver(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.AIOEmoticonUIHelper
 * JD-Core Version:    0.7.0.1
 */