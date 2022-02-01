package com.tencent.mobileqq.kandian.biz.publisher.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.kandian.biz.publisher.api.IKanDianPublisher;
import com.tencent.mobileqq.kandian.biz.publisher.api.IKanDianPublisher.IPublisherObserver;
import com.tencent.mobileqq.kandian.biz.publisher.api.IPublisherRemoteConfig;
import com.tencent.mobileqq.kandian.biz.publisher.common.PublisherUtils;
import com.tencent.mobileqq.kandian.biz.publisher.impls.AccountImpl;
import com.tencent.mobileqq.kandian.biz.publisher.impls.BizConfigImpl;
import com.tencent.mobileqq.kandian.biz.publisher.impls.DataReporterImpl;
import com.tencent.mobileqq.kandian.biz.publisher.impls.DataTransferImpl;
import com.tencent.mobileqq.kandian.biz.publisher.impls.DialogBuilderImpl;
import com.tencent.mobileqq.kandian.biz.publisher.impls.EmoJiEmotionImpl;
import com.tencent.mobileqq.kandian.biz.publisher.impls.FloatViewManagerImpl;
import com.tencent.mobileqq.kandian.biz.publisher.impls.ImageLoaderImpl;
import com.tencent.mobileqq.kandian.biz.publisher.impls.LoggerImpl;
import com.tencent.mobileqq.kandian.biz.publisher.impls.PageOpenerImpl;
import com.tencent.mobileqq.kandian.biz.publisher.impls.PermissionImpl;
import com.tencent.mobileqq.kandian.biz.publisher.impls.PkgManager;
import com.tencent.mobileqq.kandian.biz.publisher.impls.PublishManagerImpl;
import com.tencent.mobileqq.kandian.biz.publisher.impls.StorageConfigImpl;
import com.tencent.mobileqq.kandian.biz.publisher.impls.ThemeImpl;
import com.tencent.mobileqq.kandian.biz.publisher.impls.ThreadManagerImpl;
import com.tencent.mobileqq.kandian.biz.publisher.impls.ToastImpl;
import com.tencent.mobileqq.kandian.biz.publisher.impls.UploaderFactory;
import com.tencent.mobileqq.kandian.biz.publisher.impls.UserActionHandlerImpl;
import com.tencent.mobileqq.kandian.biz.publisher.impls.VideoCompressor;
import com.tencent.mobileqq.kandian.biz.publisher.impls.ViewPagerImpl;
import com.tencent.mobileqq.kandian.biz.publisher.impls.WebViewOpenerImpl;
import com.tencent.mobileqq.kandian.biz.publisher.impls.component.UIDataTransferImpl;
import com.tencent.mobileqq.kandian.biz.publisher.impls.component.UIEmoJiBridgeImpl;
import com.tencent.mobileqq.kandian.biz.publisher.observer.PublisherObserverController;
import com.tencent.mobileqq.kandian.biz.publisher.report.RichEditTextReportListener;
import com.tencent.mobileqq.kandian.biz.publisher.report.UserActionReportListener;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcEntryExtraInfo;
import com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SelectVideoFragment;
import com.tencent.mobileqq.kandian.glue.video.compress.VideoCompressModule;
import com.tencent.mobileqq.kandian.glue.video.compress.VideoCompressModule.Companion;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEventObserver;
import com.tencent.tkd.topicsdk.framework.events.RichEditTextEvent;
import com.tencent.tkd.topicsdk.framework.events.UserActionEvent;
import com.tencent.tkd.topicsdk.interfaces.BaseUploader;
import com.tencent.tkd.topicsdk.interfaces.IAccount;
import com.tencent.tkd.topicsdk.interfaces.IBizConfig;
import com.tencent.tkd.topicsdk.interfaces.IDataReporter;
import com.tencent.tkd.topicsdk.interfaces.IEmoJiEmotion;
import com.tencent.tkd.topicsdk.interfaces.IFloatViewManager;
import com.tencent.tkd.topicsdk.interfaces.IImageLoader;
import com.tencent.tkd.topicsdk.interfaces.ILogger;
import com.tencent.tkd.topicsdk.interfaces.IPageOpener;
import com.tencent.tkd.topicsdk.interfaces.IPermission;
import com.tencent.tkd.topicsdk.interfaces.IPkgManager;
import com.tencent.tkd.topicsdk.interfaces.IPublishManager;
import com.tencent.tkd.topicsdk.interfaces.IStorageConfig;
import com.tencent.tkd.topicsdk.interfaces.ITheme;
import com.tencent.tkd.topicsdk.interfaces.IThreadManager;
import com.tencent.tkd.topicsdk.interfaces.IToast;
import com.tencent.tkd.topicsdk.interfaces.IUserActionHandler;
import com.tencent.tkd.topicsdk.interfaces.IVideoCompressor;
import com.tencent.tkd.topicsdk.interfaces.IViewPager;
import com.tencent.tkd.topicsdk.interfaces.IWebViewOpener;
import com.tencent.tkd.weibo.UiComponentSdk;
import com.tencent.tkd.weibo.UiComponentSdk.Companion;
import com.tencent.tkd.weibo.UiComponentSdkConfig;
import com.tencent.tkd.weibo.framework.IEmoJiBridge;
import com.tencent.widget.ThemeImageWrapper;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/api/impl/KanDianPublisher;", "Lcom/tencent/mobileqq/kandian/biz/publisher/api/IKanDianPublisher;", "()V", "FROM_MAIN_TAB", "", "FROM_MY_TOPIC_DETAIL", "FROM_MY_VIDEO", "FROM_OTHER_TOPIC_DETAIL", "K_CALLBACK", "", "K_FROM", "TAG", "hasInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "publisherRemoteConfig", "Lcom/tencent/mobileqq/kandian/biz/publisher/api/IPublisherRemoteConfig;", "getPublisherRemoteConfig", "()Lcom/tencent/mobileqq/kandian/biz/publisher/api/IPublisherRemoteConfig;", "publisherRemoteConfig$delegate", "Lkotlin/Lazy;", "assetInit", "", "buildKDCommunityInfo", "config", "Lorg/json/JSONObject;", "kdCommunityId", "kdCommunityName", "buildOriginTopicInfo", "topicId", "coverUrl", "title", "brief", "allowSubmit", "", "buildPublisherScene", "from", "callback", "buildSelectVideoInfo", "duration", "", "fileSize", "coverPath", "width", "height", "filePath", "buildUgcEntryExtraInfo", "ugcEntryExtraInfo", "Lcom/tencent/mobileqq/kandian/biz/ugc/entity/UgcEntryExtraInfo;", "getRemoteConfig", "init", "context", "Landroid/content/Context;", "initBaseSDK", "initTopicSDK", "initUIComponentSDK", "openPublishArticlePage", "extra", "openPublishArticlePageForResult", "activity", "Landroid/app/Activity;", "requestCode", "openSelectVideoPage", "openSelectVideoPageForResult", "registerPublishObserver", "observer", "Lcom/tencent/mobileqq/kandian/biz/publisher/api/IKanDianPublisher$IPublisherObserver;", "unRegisterPublishObserver", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KanDianPublisher
  implements IKanDianPublisher
{
  public static final int FROM_MAIN_TAB = 1;
  public static final int FROM_MY_TOPIC_DETAIL = 3;
  public static final int FROM_MY_VIDEO = 2;
  public static final int FROM_OTHER_TOPIC_DETAIL = 4;
  public static final KanDianPublisher INSTANCE = new KanDianPublisher();
  @NotNull
  public static final String K_CALLBACK = "key_callback";
  @NotNull
  public static final String K_FROM = "key_from";
  @NotNull
  public static final String TAG = "KanDianPublisherImpl";
  private static AtomicBoolean hasInited = new AtomicBoolean(false);
  private static final Lazy publisherRemoteConfig$delegate = LazyKt.lazy((Function0)KanDianPublisher.publisherRemoteConfig.2.INSTANCE);
  
  private final void assetInit()
  {
    if (!hasInited.get())
    {
      BaseApplication localBaseApplication = BaseApplication.context;
      Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplication.context");
      initTopicSDK((Context)localBaseApplication);
    }
  }
  
  private final IPublisherRemoteConfig getPublisherRemoteConfig()
  {
    return (IPublisherRemoteConfig)publisherRemoteConfig$delegate.getValue();
  }
  
  private final void initBaseSDK(Context paramContext)
  {
    IBizConfig localIBizConfig = (IBizConfig)new BizConfigImpl();
    IPageOpener localIPageOpener = (IPageOpener)new PageOpenerImpl();
    ILogger localILogger = (ILogger)new LoggerImpl();
    IAccount localIAccount = (IAccount)new AccountImpl();
    IDataReporter localIDataReporter = (IDataReporter)new DataReporterImpl();
    com.tencent.tkd.topicsdk.interfaces.IDataTransfer localIDataTransfer = (com.tencent.tkd.topicsdk.interfaces.IDataTransfer)new DataTransferImpl();
    IUserActionHandler localIUserActionHandler = (IUserActionHandler)new UserActionHandlerImpl();
    IThreadManager localIThreadManager = (IThreadManager)new ThreadManagerImpl();
    ITheme localITheme = (ITheme)new ThemeImpl();
    IToast localIToast = (IToast)new ToastImpl();
    IPermission localIPermission = (IPermission)new PermissionImpl();
    IImageLoader localIImageLoader = (IImageLoader)new ImageLoaderImpl();
    IWebViewOpener localIWebViewOpener = (IWebViewOpener)new WebViewOpenerImpl();
    BaseUploader localBaseUploader = (BaseUploader)new UploaderFactory();
    IViewPager localIViewPager = (IViewPager)new ViewPagerImpl();
    IFloatViewManager localIFloatViewManager = (IFloatViewManager)new FloatViewManagerImpl();
    IStorageConfig localIStorageConfig = (IStorageConfig)new StorageConfigImpl();
    IEmoJiEmotion localIEmoJiEmotion = (IEmoJiEmotion)new EmoJiEmotionImpl();
    IPkgManager localIPkgManager = (IPkgManager)new PkgManager();
    paramContext = new TopicSDKConfig(paramContext, localIBizConfig, localIPageOpener, localILogger, localIAccount, localIDataReporter, localIDataTransfer, localIUserActionHandler, localIThreadManager, localITheme, localIToast, localIPermission, localIWebViewOpener, localIImageLoader, localBaseUploader, localIViewPager, localIFloatViewManager, localIStorageConfig, localIEmoJiEmotion, false, (IVideoCompressor)new VideoCompressor(paramContext), localIPkgManager, DialogBuilderImpl.class, (IPublishManager)new PublishManagerImpl());
    TopicSDK.a.a().a(paramContext);
  }
  
  private final void initTopicSDK(Context paramContext)
  {
    if (hasInited.get()) {
      return;
    }
    initBaseSDK(paramContext);
    initUIComponentSDK();
    TopicSDK.a.a().a(UserActionEvent.class, (IEventObserver)new UserActionReportListener());
    TopicSDK.a.a().a(RichEditTextEvent.class, (IEventObserver)new RichEditTextReportListener());
    VideoCompressModule.a.a().a();
    hasInited.set(true);
  }
  
  private final void initUIComponentSDK()
  {
    UiComponentSdkConfig localUiComponentSdkConfig = new UiComponentSdkConfig((IImageLoader)new ImageLoaderImpl(), (com.tencent.tkd.weibo.data.IDataTransfer)new UIDataTransferImpl(), (ILogger)new LoggerImpl(), (IEmoJiBridge)new UIEmoJiBridgeImpl());
    UiComponentSdk.a.a().a(localUiComponentSdkConfig);
    UiComponentSdk.a.a().a(ThemeImageWrapper.isNightMode());
  }
  
  public void buildKDCommunityInfo(@NotNull JSONObject paramJSONObject, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "config");
    Intrinsics.checkParameterIsNotNull(paramString1, "kdCommunityId");
    Intrinsics.checkParameterIsNotNull(paramString2, "kdCommunityName");
    assetInit();
    paramJSONObject.put("ownerType", 5);
    paramJSONObject.put("ownerID", paramString1);
    paramJSONObject.put("ownerName", paramString2);
  }
  
  public void buildOriginTopicInfo(@NotNull JSONObject paramJSONObject, int paramInt, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "config");
    assetInit();
    paramJSONObject.put("topicID", paramInt);
    paramJSONObject.put("title", paramString2);
    paramJSONObject.put("intro", paramString3);
    paramJSONObject.put("iconUrl", paramString1);
  }
  
  public void buildPublisherScene(@NotNull JSONObject paramJSONObject, int paramInt, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "config");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("key_from", paramInt);
    if (paramString == null) {
      paramString = "";
    }
    localJSONObject.put("key_callback", paramString);
    paramJSONObject.put("scene", localJSONObject.toString());
  }
  
  public void buildSelectVideoInfo(@NotNull JSONObject paramJSONObject, long paramLong1, long paramLong2, @NotNull String paramString1, int paramInt1, int paramInt2, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "config");
    Intrinsics.checkParameterIsNotNull(paramString1, "coverPath");
    Intrinsics.checkParameterIsNotNull(paramString2, "filePath");
    assetInit();
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("videoPath", paramString2);
    localJSONObject.put("videoDuration", paramLong1);
    localJSONObject.put("fileSize", paramLong2);
    localJSONObject.put("coverPath", paramString1);
    localJSONObject.put("width", paramInt1);
    localJSONObject.put("height", paramInt2);
    paramJSONObject.put("originVideoInfo", localJSONObject);
  }
  
  public void buildUgcEntryExtraInfo(@NotNull JSONObject paramJSONObject, @NotNull UgcEntryExtraInfo paramUgcEntryExtraInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "config");
    Intrinsics.checkParameterIsNotNull(paramUgcEntryExtraInfo, "ugcEntryExtraInfo");
    assetInit();
    if (paramUgcEntryExtraInfo.a()) {
      paramJSONObject.put("ownerType", 5);
    }
    paramJSONObject.put("needShowPublishSuccesToast", paramUgcEntryExtraInfo.b());
  }
  
  @NotNull
  public IPublisherRemoteConfig getRemoteConfig()
  {
    return getPublisherRemoteConfig();
  }
  
  public void init(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    initTopicSDK(paramContext);
  }
  
  public void openPublishArticlePage(@NotNull Context paramContext, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    assetInit();
    TopicSDKHelperKt.a(paramContext, PublishArticlePage.class, PublisherUtils.a.a(paramContext, paramJSONObject), null, null, 16, null);
  }
  
  public void openPublishArticlePageForResult(@NotNull Activity paramActivity, int paramInt, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    assetInit();
    TopicSDKHelperKt.a(paramActivity, PublishArticlePage.class, paramInt, PublisherUtils.a.a((Context)paramActivity, paramJSONObject), null, null, 32, null);
  }
  
  public void openSelectVideoPage(@NotNull Context paramContext, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    assetInit();
    Intent localIntent = new Intent();
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.toString();
    } else {
      paramJSONObject = null;
    }
    localIntent.putExtra("extra", paramJSONObject);
    localIntent.putExtra("key_from", paramInt);
    PublicFragmentActivity.a(paramContext, localIntent, SelectVideoFragment.class);
  }
  
  public void openSelectVideoPageForResult(@NotNull Activity paramActivity, int paramInt1, @Nullable JSONObject paramJSONObject, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    assetInit();
    Intent localIntent = new Intent();
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.toString();
    } else {
      paramJSONObject = null;
    }
    localIntent.putExtra("extra", paramJSONObject);
    localIntent.putExtra("key_from", paramInt2);
    PublicFragmentActivity.a(paramActivity, localIntent, SelectVideoFragment.class, paramInt1);
  }
  
  public void registerPublishObserver(@NotNull IKanDianPublisher.IPublisherObserver paramIPublisherObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramIPublisherObserver, "observer");
    assetInit();
    PublisherObserverController.a.a(paramIPublisherObserver);
  }
  
  public void unRegisterPublishObserver(@NotNull IKanDianPublisher.IPublisherObserver paramIPublisherObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramIPublisherObserver, "observer");
    assetInit();
    PublisherObserverController.a.b(paramIPublisherObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.api.impl.KanDianPublisher
 * JD-Core Version:    0.7.0.1
 */