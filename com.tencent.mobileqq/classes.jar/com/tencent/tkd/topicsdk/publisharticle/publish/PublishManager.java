package com.tencent.tkd.topicsdk.publisharticle.publish;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.ImageInfo;
import com.tencent.tkd.topicsdk.bean.PreUploadVideoInfo;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.VideoInfo;
import com.tencent.tkd.topicsdk.bean.globalconfig.BusinessToastConfig;
import com.tencent.tkd.topicsdk.common.NetWorkStatus;
import com.tencent.tkd.topicsdk.common.NetworkUtils;
import com.tencent.tkd.topicsdk.framework.Account;
import com.tencent.tkd.topicsdk.framework.AppContext;
import com.tencent.tkd.topicsdk.framework.DataTransferManager;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.framework.Uploader;
import com.tencent.tkd.topicsdk.imagecompress.Luban;
import com.tencent.tkd.topicsdk.imagecompress.Luban.Builder;
import com.tencent.tkd.topicsdk.imagecompress.OnCompressListener;
import com.tencent.tkd.topicsdk.interfaces.BaseUploader;
import com.tencent.tkd.topicsdk.interfaces.BaseUploader.UploaderType;
import com.tencent.tkd.topicsdk.interfaces.IPublishManager;
import com.tencent.tkd.topicsdk.interfaces.IPublishManager.ICheckResultCallBack;
import com.tencent.tkd.topicsdk.interfaces.IPublishManager.IPublishListener;
import com.tencent.tkd.topicsdk.interfaces.IPublishManager.IPublishStatusListener;
import com.tencent.tkd.topicsdk.interfaces.IUploadListener;
import com.tencent.tkd.topicsdk.interfaces.IVideoCompressor;
import com.tencent.tkd.topicsdk.interfaces.IVideoCompressor.Callback;
import com.tencent.tkd.topicsdk.interfaces.IVideoCompressor.VideoCompressListener;
import com.tencent.tkd.topicsdk.network.NetWorkManager;
import com.tencent.tkd.topicsdk.network.NetWorkManager.INetWorkChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/publish/PublishManager;", "Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager;", "()V", "TAG", "", "value", "", "compressImageSizeThreshold", "getCompressImageSizeThreshold", "()I", "setCompressImageSizeThreshold", "(I)V", "hasLoadFromLocal", "", "publishListenerList", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/topicsdk/publisharticle/publish/PublishManager$IPublishArticleListener;", "Lkotlin/collections/ArrayList;", "publishManagerListenerList", "Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager$IPublishListener;", "publishTaskList", "Lcom/tencent/tkd/topicsdk/publisharticle/publish/PublishManager$PublishTask;", "publish_data_key", "getPublish_data_key", "()Ljava/lang/String;", "sdkUploader", "Lcom/tencent/tkd/topicsdk/interfaces/BaseUploader;", "getSdkUploader", "()Lcom/tencent/tkd/topicsdk/interfaces/BaseUploader;", "addPublishArticleListener", "", "listener", "addPublishListener", "addPublishTask", "articleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "compressAndUploadImage", "config", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "info", "imageInfo", "Lcom/tencent/tkd/topicsdk/bean/ImageInfo;", "compressImageWithLuban", "onSuccess", "Lkotlin/Function0;", "compressVideo", "videoInfo", "Lcom/tencent/tkd/topicsdk/bean/VideoInfo;", "compressVideoWithCompressor", "compressor", "Lcom/tencent/tkd/topicsdk/interfaces/IVideoCompressor;", "createAndStartUploadCoverTask", "createAndStartUploadImageTask", "createAndStartUploadVideoTask", "deletePublishTempFile", "dispatchOnFailed", "stage", "Lcom/tencent/tkd/topicsdk/publisharticle/publish/PublishStage;", "dispatchOnPauseByNet", "dispatchOnPauseFailed", "dispatchOnPauseSuccess", "dispatchOnStart", "publishId", "coverPath", "dispatchOnSuccess", "serverPublishData", "dispatchProgress", "progress", "getFirstPublishArticleInfo", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "getNextImageInfoForUpload", "getNextVideoInfoForUpload", "getPublishTask", "initDataFromLocal", "finishCallback", "isFinishUpload", "publishArticleInfo", "isTextOnly", "pauseUploadVideo", "preUploadVideo", "globalPublisherConfig", "preUploadVideoInfo", "Lcom/tencent/tkd/topicsdk/bean/PreUploadVideoInfo;", "isStart", "publishStatusListener", "Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager$IPublishStatusListener;", "publishArticle", "removePublishArticleListener", "removePublishListener", "removePublishStatusListener", "removePublishTask", "restartPublishTask", "bundle", "Landroid/os/Bundle;", "resumeUploadVideo", "saveDataToLocal", "showMobileNetworkDialog", "context", "Landroid/content/Context;", "fileSize", "", "Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager$ICheckResultCallBack;", "showPublishFailToast", "code", "msg", "showPublishSuccessToast", "startPublish", "uploadMedia", "uploadVideo", "uploadVideoCover", "IPublishArticleListener", "PublishTask", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishManager
  implements IPublishManager
{
  public static final PublishManager a = new PublishManager();
  private static int b = 15728640;
  private static final ArrayList<PublishManager.IPublishArticleListener> c = new ArrayList();
  private static final ArrayList<IPublishManager.IPublishListener> d = new ArrayList();
  private static final ArrayList<PublishManager.PublishTask> e = new ArrayList();
  private static boolean f;
  
  static
  {
    NetWorkManager.a.a((NetWorkManager.INetWorkChangeListener)new PublishManager.1());
  }
  
  private final void a(int paramInt, String paramString, GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("发表微博内容成功. [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]:");
    localStringBuilder.append(paramString);
    TopicSDKHelperKt.a(localStringBuilder.toString());
    if (Intrinsics.areEqual(paramGlobalPublisherConfig.getPublishScene(), "rijugc"))
    {
      paramString = AppContext.a.a().getString(R.string.af);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "AppContext.instance.getS…ing.video_upload_success)");
      TopicSDKHelperKt.a(paramString, false, null, 6, null);
      return;
    }
    paramString = paramGlobalPublisherConfig.getBusinessToastConfig().getPublishSuccessToast();
    if (!TextUtils.isEmpty((CharSequence)paramString)) {
      TopicSDKHelperKt.a(paramString, false, null, 6, null);
    }
  }
  
  private final void a(GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo, ImageInfo paramImageInfo)
  {
    boolean bool;
    if ((paramImageInfo.getSize() >= b) && (!paramImageInfo.getHasCompressed())) {
      bool = false;
    } else {
      bool = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("compressAndUploadImage，size:");
    localStringBuilder.append(paramImageInfo.getSize() / 1024);
    localStringBuilder.append("kb. ");
    localStringBuilder.append("hasCompressed: ");
    localStringBuilder.append(paramImageInfo.getHasCompressed());
    localStringBuilder.append(", needCompress: ");
    localStringBuilder.append(bool);
    TLog.a("PublishManager", localStringBuilder.toString());
    if (bool)
    {
      b(paramGlobalPublisherConfig, paramPublishArticleInfo, paramImageInfo);
      return;
    }
    a(paramImageInfo, paramGlobalPublisherConfig, paramPublishArticleInfo, (Function0)new PublishManager.compressAndUploadImage.1(paramGlobalPublisherConfig, paramPublishArticleInfo, paramImageInfo));
  }
  
  private final void a(GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo, VideoInfo paramVideoInfo)
  {
    int i = ((CharSequence)paramVideoInfo.getCompressPath()).length();
    int j = 1;
    if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (new File(paramVideoInfo.getCompressPath()).exists())) {
      i = j;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      TLog.a("PublishManager", "视频已经压缩");
      b(paramGlobalPublisherConfig, paramPublishArticleInfo, paramVideoInfo);
    }
    IVideoCompressor localIVideoCompressor = TopicSDK.a.a().b().t();
    localIVideoCompressor.a(paramVideoInfo.getFilePath(), (IVideoCompressor.Callback)new PublishManager.compressVideo.1(paramVideoInfo, localIVideoCompressor, paramPublishArticleInfo, paramGlobalPublisherConfig));
  }
  
  private final void a(ImageInfo paramImageInfo, GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo, Function0<Unit> paramFunction0)
  {
    PublishStage localPublishStage = PublishStage.PUBLISH_STAGE_COMPRESS_COVER;
    Luban.a(AppContext.a.a()).a(paramImageInfo.getFilePath()).b(TopicSDKHelperKt.e()).a((OnCompressListener)new PublishManager.compressImageWithLuban.1(paramImageInfo, paramFunction0, localPublishStage, paramGlobalPublisherConfig, paramPublishArticleInfo)).a();
  }
  
  private final void a(VideoInfo paramVideoInfo, PublishArticleInfo paramPublishArticleInfo, GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("准备上传封面, coverPath = ");
    ((StringBuilder)localObject1).append(paramVideoInfo.getCoverPath());
    TLog.d("PublishManager", ((StringBuilder)localObject1).toString());
    localObject1 = PublishStage.PUBLISH_STAGE_UPLOAD_COVER;
    PublishManager.PublishTask localPublishTask = c(paramPublishArticleInfo.getPublishId());
    Object localObject2 = paramVideoInfo.getCoverPath();
    BaseUploader localBaseUploader = c().a(BaseUploader.UploaderType.IMAGE);
    Intrinsics.checkExpressionValueIsNotNull(localBaseUploader, "sdkUploader.getUploaderB…oader.UploaderType.IMAGE)");
    localObject2 = new Uploader((String)localObject2, localBaseUploader);
    ((Uploader)localObject2).a((IUploadListener)new PublishManager.createAndStartUploadCoverTask.1(paramVideoInfo, (PublishStage)localObject1, paramPublishArticleInfo, localPublishTask, paramGlobalPublisherConfig));
    if (localPublishTask != null) {
      localPublishTask.a((Uploader)localObject2);
    }
    if (localPublishTask != null) {
      localPublishTask.b();
    }
  }
  
  private final void a(IVideoCompressor paramIVideoCompressor, VideoInfo paramVideoInfo, PublishArticleInfo paramPublishArticleInfo, GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    paramIVideoCompressor.a(paramVideoInfo.getFilePath(), (IVideoCompressor.VideoCompressListener)new PublishManager.compressVideoWithCompressor.1(paramPublishArticleInfo, paramVideoInfo, paramGlobalPublisherConfig));
  }
  
  private final void a(PublishStage paramPublishStage)
  {
    ThreadManagerKt.a((Function0)new PublishManager.dispatchOnPauseSuccess.1(paramPublishStage));
  }
  
  private final void a(PublishStage paramPublishStage, GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo)
  {
    a();
    ThreadManagerKt.a((Function0)new PublishManager.dispatchOnFailed.1(paramPublishArticleInfo, paramPublishStage, paramGlobalPublisherConfig));
  }
  
  private final void a(PublishStage paramPublishStage, GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo, String paramString)
  {
    ThreadManagerKt.a((Function0)new PublishManager.dispatchOnSuccess.1(paramPublishArticleInfo, paramPublishStage, paramGlobalPublisherConfig, paramString));
  }
  
  private final void a(PublishStage paramPublishStage, String paramString, int paramInt)
  {
    ThreadManagerKt.a((Function0)new PublishManager.dispatchProgress.1(paramPublishStage, paramInt, paramString));
  }
  
  private final void a(PublishStage paramPublishStage, String paramString1, String paramString2)
  {
    ThreadManagerKt.a((Function0)new PublishManager.dispatchOnStart.1(paramPublishStage, paramString1, paramString2));
  }
  
  private final void b(int paramInt, String paramString, GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("发表微博内容失败. [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]:");
    localStringBuilder.append(paramString);
    TopicSDKHelperKt.a(localStringBuilder.toString());
    if (Intrinsics.areEqual(paramGlobalPublisherConfig.getPublishScene(), "rijugc"))
    {
      paramString = AppContext.a.a().getString(R.string.ae);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "AppContext.instance.getS…ring.video_upload_failed)");
      TopicSDKHelperKt.a(paramString, false, null, 6, null);
      return;
    }
    paramString = paramGlobalPublisherConfig.getBusinessToastConfig().getPublishFailToast();
    if (!TextUtils.isEmpty((CharSequence)paramString)) {
      TopicSDKHelperKt.a(paramString, false, null, 6, null);
    }
  }
  
  private final void b(GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo)
  {
    ImageInfo localImageInfo = b(paramPublishArticleInfo);
    paramPublishArticleInfo.setPublishing(true);
    if (localImageInfo == null)
    {
      c(paramGlobalPublisherConfig, paramPublishArticleInfo);
      return;
    }
    a(paramGlobalPublisherConfig, paramPublishArticleInfo, localImageInfo);
  }
  
  private final void b(GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo, ImageInfo paramImageInfo)
  {
    PublishStage localPublishStage = PublishStage.PUBLISH_STAGE_UPLOAD_IMAGE;
    Object localObject1 = paramImageInfo.getFilePath();
    Object localObject2 = c().a(BaseUploader.UploaderType.IMAGE);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "sdkUploader.getUploaderB…oader.UploaderType.IMAGE)");
    localObject1 = new Uploader((String)localObject1, (BaseUploader)localObject2);
    localObject2 = c(paramPublishArticleInfo.getPublishId());
    if (localObject2 != null) {
      ((PublishManager.PublishTask)localObject2).a((Uploader)localObject1);
    }
    ((Uploader)localObject1).a((IUploadListener)new PublishManager.createAndStartUploadImageTask.1(paramPublishArticleInfo, localPublishStage, (PublishManager.PublishTask)localObject2, paramImageInfo, paramGlobalPublisherConfig));
    if (localObject2 != null) {
      ((PublishManager.PublishTask)localObject2).a();
    }
  }
  
  private final void b(GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo, VideoInfo paramVideoInfo)
  {
    int i;
    if (((CharSequence)paramVideoInfo.getUrl()).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      d(paramGlobalPublisherConfig, paramPublishArticleInfo);
      return;
    }
    b(paramVideoInfo, paramPublishArticleInfo, paramGlobalPublisherConfig);
  }
  
  private final void b(VideoInfo paramVideoInfo, PublishArticleInfo paramPublishArticleInfo, GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    int i = ((CharSequence)paramVideoInfo.getCompressPath()).length();
    int j = 1;
    if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localObject1 = paramVideoInfo.getCompressPath();
    } else {
      localObject1 = paramVideoInfo.getFilePath();
    }
    Object localObject2 = c().a(BaseUploader.UploaderType.VIDEO);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "sdkUploader.getUploaderB…oader.UploaderType.VIDEO)");
    Object localObject1 = new Uploader((String)localObject1, (BaseUploader)localObject2);
    localObject2 = c(paramPublishArticleInfo.getPublishId());
    ((Uploader)localObject1).a((IUploadListener)new PublishManager.createAndStartUploadVideoTask.1(paramPublishArticleInfo, paramVideoInfo, (PublishManager.PublishTask)localObject2, paramGlobalPublisherConfig));
    if (localObject2 != null) {
      ((PublishManager.PublishTask)localObject2).a((Uploader)localObject1);
    }
    if (((CharSequence)paramPublishArticleInfo.getVideoUploadKey()).length() > 0) {
      i = j;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (localObject2 != null) {
        ((PublishManager.PublishTask)localObject2).a(paramPublishArticleInfo.getVideoUploadKey());
      }
    }
    else if (localObject2 != null) {
      ((PublishManager.PublishTask)localObject2).c();
    }
  }
  
  private final void b(PublishStage paramPublishStage)
  {
    ThreadManagerKt.a((Function0)new PublishManager.dispatchOnPauseByNet.1(paramPublishStage));
  }
  
  private final BaseUploader c()
  {
    return TopicSDK.a.a().b().o();
  }
  
  private final void c(GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo)
  {
    VideoInfo localVideoInfo = c(paramPublishArticleInfo);
    if (localVideoInfo != null)
    {
      int i;
      if (((CharSequence)localVideoInfo.getCoverUrl()).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        a(paramGlobalPublisherConfig, paramPublishArticleInfo, localVideoInfo);
        return;
      }
      a(localVideoInfo, paramPublishArticleInfo, paramGlobalPublisherConfig);
    }
  }
  
  private final String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("publishTaskList_");
    localStringBuilder.append(Account.a.a());
    return localStringBuilder.toString();
  }
  
  private final void d(GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo)
  {
    DataTransferManager.a.a(paramPublishArticleInfo, (Function4)new PublishManager.publishArticle.1(paramPublishArticleInfo, paramGlobalPublisherConfig));
  }
  
  private final boolean d(PublishArticleInfo paramPublishArticleInfo)
  {
    ArrayList localArrayList = paramPublishArticleInfo.getImageList();
    paramPublishArticleInfo = paramPublishArticleInfo.getVideoInfo();
    return ((localArrayList == null) || (localArrayList.isEmpty())) && (paramPublishArticleInfo == null);
  }
  
  private final PublishManager.PublishTask e(PublishArticleInfo paramPublishArticleInfo)
  {
    paramPublishArticleInfo = new PublishManager.PublishTask(paramPublishArticleInfo);
    e.add(paramPublishArticleInfo);
    a();
    return paramPublishArticleInfo;
  }
  
  public final void a()
  {
    TLog.b("PublishManager", "saveDataToLocal");
    ThreadManagerKt.c((Function0)PublishManager.saveDataToLocal.1.INSTANCE);
  }
  
  public final void a(int paramInt)
  {
    b = paramInt * 1024;
  }
  
  @Deprecated(message="目前手Q用到，因此此处空实现")
  public void a(@NotNull Context paramContext, long paramLong, @NotNull IPublishManager.ICheckResultCallBack paramICheckResultCallBack)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramICheckResultCallBack, "callback");
  }
  
  @Deprecated(message="目前手Q用到，因此此处空实现")
  public void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PreUploadVideoInfo paramPreUploadVideoInfo, boolean paramBoolean, @NotNull IPublishManager.IPublishStatusListener paramIPublishStatusListener)
  {
    Intrinsics.checkParameterIsNotNull(paramGlobalPublisherConfig, "globalPublisherConfig");
    Intrinsics.checkParameterIsNotNull(paramPreUploadVideoInfo, "preUploadVideoInfo");
    Intrinsics.checkParameterIsNotNull(paramIPublishStatusListener, "publishStatusListener");
  }
  
  @UiThread
  public void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramGlobalPublisherConfig, "globalPublisherConfig");
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "publishArticleInfo");
    boolean bool = d(paramPublishArticleInfo);
    int i = 1;
    if (bool)
    {
      if (((CharSequence)paramPublishArticleInfo.getContent()).length() != 0) {
        i = 0;
      }
      if (i != 0) {
        return;
      }
      d(paramGlobalPublisherConfig, paramPublishArticleInfo);
      return;
    }
    bool = Intrinsics.areEqual(paramGlobalPublisherConfig.getPublishScene(), "rijugc");
    Object localObject1 = null;
    if ((bool) && (!NetworkUtils.a.b(AppContext.a.a())) && (!TopicSDKHelperKt.b()))
    {
      localObject2 = AppContext.a.a().getResources().getString(R.string.N);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "AppContext.instance.reso…commend_wifi_upload_tips)");
      TopicSDKHelperKt.a((String)localObject2, false, null, 6, null);
    }
    Object localObject2 = e(paramPublishArticleInfo);
    if (NetworkUtils.a.c(TopicSDK.a.a().b().b()) == NetWorkStatus.Mobile) {
      ((PublishManager.PublishTask)localObject2).a(true);
    }
    localObject2 = paramPublishArticleInfo.getImageList();
    if (localObject2 != null) {
      localObject1 = (ImageInfo)CollectionsKt.firstOrNull((List)localObject2);
    }
    if (localObject1 == null)
    {
      localObject2 = PublishStage.PUBLISH_STAGE_PUBLISH_VIDEO;
      String str = paramPublishArticleInfo.getPublishId();
      localObject1 = paramPublishArticleInfo.getVideoInfo();
      if (localObject1 != null)
      {
        localObject1 = ((VideoInfo)localObject1).getCoverPath();
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      a((PublishStage)localObject2, str, (String)localObject1);
    }
    else
    {
      a(PublishStage.PUBLISH_STAGE_PUBLISH_VIDEO, paramPublishArticleInfo.getPublishId(), ((ImageInfo)localObject1).getFilePath());
    }
    b(paramGlobalPublisherConfig, paramPublishArticleInfo);
  }
  
  @Deprecated(message="目前手Q用到，因此此处空实现")
  public void a(@NotNull IPublishManager.IPublishStatusListener paramIPublishStatusListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIPublishStatusListener, "publishStatusListener");
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "publishId");
    paramString = c(paramString);
    if (paramString != null) {
      paramString.d();
    }
  }
  
  public final boolean a(@NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "publishArticleInfo");
    Object localObject = paramPublishArticleInfo.getImageList();
    int j = 1;
    int i;
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      boolean bool1 = true;
      for (;;)
      {
        bool2 = bool1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        if (((CharSequence)((ImageInfo)((Iterator)localObject).next()).getUrl()).length() == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          bool1 = false;
        }
      }
    }
    boolean bool2 = true;
    paramPublishArticleInfo = paramPublishArticleInfo.getVideoInfo();
    if (paramPublishArticleInfo != null)
    {
      if (((CharSequence)paramPublishArticleInfo.getUrl()).length() == 0) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0) {
        return false;
      }
    }
    return bool2;
  }
  
  @VisibleForTesting
  @Nullable
  public final ImageInfo b(@NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "articleInfo");
    paramPublishArticleInfo = paramPublishArticleInfo.getImageList();
    Object localObject2 = null;
    if (paramPublishArticleInfo != null)
    {
      localObject1 = (Iterable)paramPublishArticleInfo;
      paramPublishArticleInfo = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = ((Iterator)localObject1).next();
        int i;
        if (((CharSequence)((ImageInfo)localObject3).getUrl()).length() == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          paramPublishArticleInfo.add(localObject3);
        }
      }
      paramPublishArticleInfo = (List)paramPublishArticleInfo;
    }
    else
    {
      paramPublishArticleInfo = null;
    }
    Object localObject1 = localObject2;
    if (paramPublishArticleInfo != null)
    {
      localObject1 = localObject2;
      if ((true ^ ((Collection)paramPublishArticleInfo).isEmpty())) {
        localObject1 = (ImageInfo)paramPublishArticleInfo.get(0);
      }
    }
    return localObject1;
  }
  
  public final void b()
  {
    ThreadManagerKt.c((Function0)PublishManager.deletePublishTempFile.1.INSTANCE);
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "publishId");
    Iterator localIterator = ((Iterable)e).iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (Intrinsics.areEqual(((PublishManager.PublishTask)localObject).i().getPublishId(), paramString))
      {
        paramString = (String)localObject;
        break label59;
      }
    }
    paramString = null;
    label59:
    paramString = (PublishManager.PublishTask)paramString;
    if (paramString != null) {
      e.remove(paramString);
    }
    if (paramString != null)
    {
      localObject = paramString.i();
      if (localObject != null) {
        ((PublishArticleInfo)localObject).setPublishing(false);
      }
    }
    if (paramString != null) {
      paramString.h();
    }
    a();
    b();
  }
  
  @VisibleForTesting
  @Nullable
  public final VideoInfo c(@NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "articleInfo");
    paramPublishArticleInfo = paramPublishArticleInfo.getVideoInfo();
    if (paramPublishArticleInfo != null)
    {
      int i;
      if (((CharSequence)paramPublishArticleInfo.getUrl()).length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return paramPublishArticleInfo;
      }
    }
    return null;
  }
  
  @Nullable
  public final PublishManager.PublishTask c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "publishId");
    Iterator localIterator = ((Iterable)e).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (Intrinsics.areEqual(((PublishManager.PublishTask)localObject).i().getPublishId(), paramString))
      {
        paramString = localObject;
        break label59;
      }
    }
    paramString = null;
    label59:
    return (PublishManager.PublishTask)paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publish.PublishManager
 * JD-Core Version:    0.7.0.1
 */