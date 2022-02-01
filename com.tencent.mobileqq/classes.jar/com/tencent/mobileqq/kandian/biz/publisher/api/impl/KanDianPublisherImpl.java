package com.tencent.mobileqq.kandian.biz.publisher.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoFragment;
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
import com.tencent.mobileqq.kandian.biz.publisher.impls.EntryViewBridgeImpl;
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
import com.tencent.mobileqq.kandian.biz.publisher.observer.PublisherObserverController;
import com.tencent.mobileqq.kandian.biz.publisher.report.RichEditTextReportListener;
import com.tencent.mobileqq.kandian.biz.publisher.report.UserActionReportListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.entry.IEntryViewBridge;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEventObserver;
import com.tencent.tkd.topicsdk.framework.events.RichEditTextEvent;
import com.tencent.tkd.topicsdk.framework.events.UserActionEvent;
import com.tencent.tkd.topicsdk.interfaces.BaseUploader;
import com.tencent.tkd.topicsdk.interfaces.IAccount;
import com.tencent.tkd.topicsdk.interfaces.IBizConfig;
import com.tencent.tkd.topicsdk.interfaces.IDataReporter;
import com.tencent.tkd.topicsdk.interfaces.IDataTransfer;
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
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/api/impl/KanDianPublisherImpl;", "Lcom/tencent/mobileqq/kandian/biz/publisher/api/IKanDianPublisher;", "()V", "hasInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "publisherRemoteConfig", "Lcom/tencent/mobileqq/kandian/biz/publisher/api/IPublisherRemoteConfig;", "getPublisherRemoteConfig", "()Lcom/tencent/mobileqq/kandian/biz/publisher/api/IPublisherRemoteConfig;", "publisherRemoteConfig$delegate", "Lkotlin/Lazy;", "assetInit", "", "buildOriginTopicInfo", "config", "Lorg/json/JSONObject;", "topicId", "", "coverUrl", "", "title", "brief", "allowSubmit", "", "buildPublisherScene", "from", "callback", "buildSelectVideoInfo", "duration", "", "fileSize", "coverPath", "width", "height", "filePath", "buildVideoOriginTopicInfo", "topicName", "getRemoteConfig", "init", "context", "Landroid/content/Context;", "initTopicSDK", "openCreateTopicPage", "extra", "openCreateTopicPageForResult", "activity", "Landroid/app/Activity;", "requestCode", "openEditTopicPage", "openEditTopicPageForResult", "openPublishArticlePage", "openPublishArticlePageForResult", "openSelectVideoPage", "openSelectVideoPageForResult", "registerPublishObserver", "observer", "Lcom/tencent/mobileqq/kandian/biz/publisher/api/IKanDianPublisher$IPublisherObserver;", "unRegisterPublishObserver", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KanDianPublisherImpl
  implements IKanDianPublisher
{
  public static final KanDianPublisherImpl.Companion Companion = new KanDianPublisherImpl.Companion(null);
  public static final int FROM_MAIN_TAB = 1;
  public static final int FROM_MY_TOPIC_DETAIL = 3;
  public static final int FROM_MY_VIDEO = 2;
  public static final int FROM_OTHER_TOPIC_DETAIL = 4;
  @NotNull
  public static final String K_CALLBACK = "key_callback";
  @NotNull
  public static final String K_FROM = "key_from";
  @NotNull
  public static final String TAG = "KanDianPublisherImpl";
  private AtomicBoolean hasInited = new AtomicBoolean(false);
  private final Lazy publisherRemoteConfig$delegate = LazyKt.lazy((Function0)KanDianPublisherImpl.publisherRemoteConfig.2.INSTANCE);
  
  private final void assetInit()
  {
    if (!this.hasInited.get())
    {
      BaseApplication localBaseApplication = BaseApplication.context;
      Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplication.context");
      initTopicSDK((Context)localBaseApplication);
    }
  }
  
  private final IPublisherRemoteConfig getPublisherRemoteConfig()
  {
    return (IPublisherRemoteConfig)this.publisherRemoteConfig$delegate.getValue();
  }
  
  private final void initTopicSDK(Context paramContext)
  {
    if (this.hasInited.get()) {
      return;
    }
    IBizConfig localIBizConfig = (IBizConfig)new BizConfigImpl();
    IPageOpener localIPageOpener = (IPageOpener)new PageOpenerImpl();
    ILogger localILogger = (ILogger)new LoggerImpl();
    IAccount localIAccount = (IAccount)new AccountImpl();
    IDataReporter localIDataReporter = (IDataReporter)new DataReporterImpl();
    IDataTransfer localIDataTransfer = (IDataTransfer)new DataTransferImpl();
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
    IEntryViewBridge localIEntryViewBridge = (IEntryViewBridge)new EntryViewBridgeImpl();
    IStorageConfig localIStorageConfig = (IStorageConfig)new StorageConfigImpl();
    IEmoJiEmotion localIEmoJiEmotion = (IEmoJiEmotion)new EmoJiEmotionImpl();
    IPkgManager localIPkgManager = (IPkgManager)new PkgManager();
    paramContext = new TopicSDKConfig(paramContext, localIBizConfig, localIPageOpener, localILogger, localIAccount, localIDataReporter, localIDataTransfer, localIUserActionHandler, localIThreadManager, localITheme, localIToast, localIPermission, localIWebViewOpener, localIImageLoader, localBaseUploader, localIViewPager, localIFloatViewManager, localIEntryViewBridge, localIStorageConfig, localIEmoJiEmotion, false, (IVideoCompressor)new VideoCompressor(paramContext), localIPkgManager, DialogBuilderImpl.class, (IPublishManager)new PublishManagerImpl());
    TopicSDK.a.a().a(paramContext);
    TopicSDK.a.a().a(UserActionEvent.class, (IEventObserver)new UserActionReportListener());
    TopicSDK.a.a().a(RichEditTextEvent.class, (IEventObserver)new RichEditTextReportListener());
    this.hasInited.set(true);
  }
  
  public void buildOriginTopicInfo(@NotNull JSONObject paramJSONObject, int paramInt, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "config");
    assetInit();
    paramJSONObject.put("topicID", paramInt);
    paramJSONObject.put("title", paramString2);
    paramJSONObject.put("intro", paramString3);
    paramJSONObject.put("iconUrl", paramString1);
    paramString1 = new JSONObject();
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramString1.put("allowSubmit", paramInt);
      paramJSONObject.put("topicSubmitConfig", paramString1);
      return;
    }
  }
  
  public void buildPublisherScene(@NotNull JSONObject paramJSONObject, int paramInt, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "config");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("key_from", paramInt);
    if (paramString != null) {}
    for (;;)
    {
      localJSONObject.put("key_callback", paramString);
      paramJSONObject.put("scene", localJSONObject.toString());
      return;
      paramString = "";
    }
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
  
  public void buildVideoOriginTopicInfo(@NotNull JSONObject paramJSONObject, long paramLong, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "config");
    Intrinsics.checkParameterIsNotNull(paramString, "topicName");
    assetInit();
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("showAddToTopic", 1);
    localJSONObject.put("selectedTopicID", paramLong);
    localJSONObject.put("selectedTopicName", paramString);
    localJSONObject.put("disableSelectTopic", 1);
    localJSONObject.put("default_column", 0);
    paramJSONObject.put("addToTopicConfig", localJSONObject);
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
  
  public void openCreateTopicPage(@NotNull Context paramContext, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    assetInit();
    Bundle localBundle = PublisherUtils.a.a(paramContext, paramJSONObject);
    TopicSDK.a.a().a(paramContext, localBundle, null);
    TopicSDK.a.a().a((Function2)new KanDianPublisherImpl.openCreateTopicPage.1(paramJSONObject, paramContext));
  }
  
  public void openCreateTopicPageForResult(@NotNull Activity paramActivity, int paramInt, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    assetInit();
    Bundle localBundle = PublisherUtils.a.a((Context)paramActivity, paramJSONObject);
    TopicSDK.a.a().a(paramActivity, paramInt, localBundle, null);
    TopicSDK.a.a().a((Function2)new KanDianPublisherImpl.openCreateTopicPageForResult.1(paramJSONObject, paramActivity));
  }
  
  public void openEditTopicPage(@NotNull Context paramContext, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    assetInit();
    paramJSONObject = PublisherUtils.a.b(paramContext, paramJSONObject);
    TopicSDK.a.a().b(paramContext, paramJSONObject, null);
  }
  
  public void openEditTopicPageForResult(@NotNull Activity paramActivity, int paramInt, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    assetInit();
    paramJSONObject = PublisherUtils.a.b((Context)paramActivity, paramJSONObject);
    TopicSDK.a.a().b((Context)paramActivity, paramJSONObject, null);
  }
  
  public void openPublishArticlePage(@NotNull Context paramContext, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    assetInit();
    paramJSONObject = PublisherUtils.a.c(paramContext, paramJSONObject);
    TopicSDK.a.a().c(paramContext, paramJSONObject, null);
  }
  
  public void openPublishArticlePageForResult(@NotNull Activity paramActivity, int paramInt, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    assetInit();
    paramJSONObject = PublisherUtils.a.c((Context)paramActivity, paramJSONObject);
    TopicSDK.a.a().b(paramActivity, paramInt, paramJSONObject, null);
  }
  
  public void openSelectVideoPage(@NotNull Context paramContext, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    assetInit();
    Intent localIntent = new Intent();
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.toString();; paramJSONObject = null)
    {
      localIntent.putExtra("extra", paramJSONObject);
      localIntent.putExtra("key_from", paramInt);
      PublicFragmentActivity.a(paramContext, localIntent, SelectVideoFragment.class);
      return;
    }
  }
  
  public void openSelectVideoPageForResult(@NotNull Activity paramActivity, int paramInt1, @Nullable JSONObject paramJSONObject, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    assetInit();
    Intent localIntent = new Intent();
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.toString();; paramJSONObject = null)
    {
      localIntent.putExtra("extra", paramJSONObject);
      localIntent.putExtra("key_from", paramInt2);
      PublicFragmentActivity.a(paramActivity, localIntent, SelectVideoFragment.class, paramInt1);
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.api.impl.KanDianPublisherImpl
 * JD-Core Version:    0.7.0.1
 */