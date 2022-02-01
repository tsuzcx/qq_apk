package com.tencent.tkd.topicsdk.publisharticle;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.UiThread;
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
import com.tencent.tkd.topicsdk.common.NetworkUtils;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/PublishManager;", "Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager;", "()V", "TAG", "", "value", "", "compressImageSizeThreshold", "getCompressImageSizeThreshold", "()I", "setCompressImageSizeThreshold", "(I)V", "hasLoadLocal", "", "publishListenerList", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/topicsdk/publisharticle/PublishManager$IPublishArticleListener;", "Lkotlin/collections/ArrayList;", "publishManagerListenerList", "Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager$IPublishListener;", "publishTaskList", "Lcom/tencent/tkd/topicsdk/publisharticle/PublishManager$PublishTask;", "sdkUploader", "Lcom/tencent/tkd/topicsdk/interfaces/BaseUploader;", "getSdkUploader", "()Lcom/tencent/tkd/topicsdk/interfaces/BaseUploader;", "addPublishArticleListener", "", "listener", "addPublishListener", "addPublishTask", "articleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "compressAndUploadImage", "globalPublisherConfig", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "publishArticleInfo", "imageInfo", "Lcom/tencent/tkd/topicsdk/bean/ImageInfo;", "compressVideo", "videoInfo", "Lcom/tencent/tkd/topicsdk/bean/VideoInfo;", "deletePublishTempFile", "dispatchOnFailed", "dispatchOnStart", "publishId", "coverPath", "dispatchOnSuccess", "serverPublishData", "dispatchProgress", "progress", "getBaseValueMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getBusinessType", "getDataType", "getFirstPublishTask", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "getNextImageInfoForUpload", "getNextVideoInfoForUpload", "getPublishTask", "getRelatedID", "init", "initData", "finishCallback", "Lkotlin/Function0;", "isFinishUpload", "isTextOnly", "pauseUploadVideo", "preUploadVideoInfo", "Lcom/tencent/tkd/topicsdk/bean/PreUploadVideoInfo;", "preUploadVideo", "isStart", "publishStatusListener", "Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager$IPublishStatusListener;", "publishArticle", "config", "removePublishArticleListener", "removePublishListener", "removePublishStatusListener", "removePublishTask", "restartPublishTask", "bundle", "Landroid/os/Bundle;", "saveData", "showMobileNetworkDialog", "context", "Landroid/content/Context;", "fileSize", "", "Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager$ICheckResultCallBack;", "showPublishFailToast", "code", "msg", "showPublishSuccessToast", "startPublish", "uploadImage", "uploadMedia", "uploadVideo", "uploadVideoCover", "IPublishArticleListener", "PublishTask", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishManager
  implements IPublishManager
{
  private static int jdField_a_of_type_Int = 15728640;
  public static final PublishManager a;
  private static final ArrayList<PublishManager.IPublishArticleListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static boolean jdField_a_of_type_Boolean;
  private static final ArrayList<IPublishManager.IPublishListener> b = new ArrayList();
  private static final ArrayList<PublishManager.PublishTask> c = new ArrayList();
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishManager = new PublishManager();
  }
  
  private final ImageInfo a(PublishArticleInfo paramPublishArticleInfo)
  {
    paramPublishArticleInfo = paramPublishArticleInfo.getImageList();
    if (paramPublishArticleInfo == null) {
      return null;
    }
    Object localObject1 = (Iterable)paramPublishArticleInfo;
    paramPublishArticleInfo = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    for (;;)
    {
      boolean bool = ((Iterator)localObject1).hasNext();
      int i = 0;
      if (!bool) {
        break;
      }
      Object localObject2 = ((Iterator)localObject1).next();
      if (((CharSequence)((ImageInfo)localObject2).getUrl()).length() == 0) {
        i = 1;
      }
      if (i != 0) {
        paramPublishArticleInfo.add(localObject2);
      }
    }
    paramPublishArticleInfo = (List)paramPublishArticleInfo;
    if (paramPublishArticleInfo.isEmpty()) {
      return null;
    }
    return (ImageInfo)paramPublishArticleInfo.get(0);
  }
  
  private final VideoInfo a(PublishArticleInfo paramPublishArticleInfo)
  {
    return paramPublishArticleInfo.getVideoInfo();
  }
  
  private final BaseUploader a()
  {
    return TopicSDK.a.a().a().a();
  }
  
  private final PublishManager.PublishTask a(String paramString)
  {
    Iterator localIterator = ((Iterable)c).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (Intrinsics.areEqual(((PublishManager.PublishTask)localObject).a().getPublishId(), paramString))
      {
        paramString = localObject;
        break label52;
      }
    }
    paramString = null;
    label52:
    return (PublishManager.PublishTask)paramString;
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
      paramString = AppContext.a.a().getString(R.string.as);
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
    if ((paramImageInfo.getSize() >= jdField_a_of_type_Int) && (!paramImageInfo.getHasCompressed()))
    {
      Luban.a(AppContext.a.a()).a(paramImageInfo.getFilePath()).b(TopicSDKHelperKt.c()).a((OnCompressListener)new PublishManager.compressAndUploadImage.1(paramImageInfo, paramGlobalPublisherConfig, paramPublishArticleInfo)).a();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("图片无需压缩，size:");
    localStringBuilder.append(paramImageInfo.getSize() / 1024);
    localStringBuilder.append("kb");
    localStringBuilder.append(" hasCompressed: ");
    localStringBuilder.append(paramImageInfo.getHasCompressed());
    TLog.a("PublishManager", localStringBuilder.toString());
    b(paramGlobalPublisherConfig, paramPublishArticleInfo, paramImageInfo);
  }
  
  private final void a(GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo, VideoInfo paramVideoInfo)
  {
    IVideoCompressor localIVideoCompressor = TopicSDK.a.a().a().a();
    localIVideoCompressor.a(paramVideoInfo.getFilePath(), (IVideoCompressor.Callback)new PublishManager.compressVideo.1(paramVideoInfo, localIVideoCompressor, paramPublishArticleInfo, paramGlobalPublisherConfig));
  }
  
  private final void a(GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo, String paramString)
  {
    ThreadManagerKt.a((Function0)new PublishManager.dispatchOnSuccess.1(paramPublishArticleInfo, paramGlobalPublisherConfig, paramString));
  }
  
  private final void a(PublishArticleInfo paramPublishArticleInfo)
  {
    paramPublishArticleInfo = new PublishManager.PublishTask(paramPublishArticleInfo);
    c.add(paramPublishArticleInfo);
    a();
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
      paramString = AppContext.a.a().getString(R.string.ar);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "AppContext.instance.getS…ring.video_upload_failed)");
      TopicSDKHelperKt.a(paramString, false, null, 6, null);
      return;
    }
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      paramString = AppContext.a.a().getString(R.string.Q);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "AppContext.instance.getS…ng(R.string.publish_fail)");
      TopicSDKHelperKt.a(paramString, false, null, 6, null);
      return;
    }
    TopicSDKHelperKt.a(paramString, false, null, 6, null);
  }
  
  private final void b(GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo, ImageInfo paramImageInfo)
  {
    Object localObject1 = paramImageInfo.getFilePath();
    Object localObject2 = a().a(BaseUploader.UploaderType.IMAGE);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "sdkUploader.getUploaderB…oader.UploaderType.IMAGE)");
    localObject1 = new Uploader((String)localObject1, (BaseUploader)localObject2);
    localObject2 = a(paramPublishArticleInfo.getPublishId());
    if (localObject2 != null) {
      ((PublishManager.PublishTask)localObject2).a((Uploader)localObject1);
    }
    ((Uploader)localObject1).a((IUploadListener)new PublishManager.uploadImage.1(paramPublishArticleInfo, paramImageInfo, paramGlobalPublisherConfig));
    ((Uploader)localObject1).a();
  }
  
  private final void b(GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo, VideoInfo paramVideoInfo)
  {
    int i = ((CharSequence)paramVideoInfo.getUrl()).length();
    int j = 1;
    if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      e(paramGlobalPublisherConfig, paramPublishArticleInfo);
      return;
    }
    if (((CharSequence)paramVideoInfo.getCompressPath()).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localObject = paramVideoInfo.getCompressPath();
    } else {
      localObject = paramVideoInfo.getFilePath();
    }
    BaseUploader localBaseUploader = a().a(BaseUploader.UploaderType.VIDEO);
    Intrinsics.checkExpressionValueIsNotNull(localBaseUploader, "sdkUploader.getUploaderB…oader.UploaderType.VIDEO)");
    Object localObject = new Uploader((String)localObject, localBaseUploader);
    ((Uploader)localObject).a((IUploadListener)new PublishManager.uploadVideo.1(paramPublishArticleInfo, paramVideoInfo, paramGlobalPublisherConfig));
    paramGlobalPublisherConfig = a(paramPublishArticleInfo.getPublishId());
    if (paramGlobalPublisherConfig != null) {
      paramGlobalPublisherConfig.a((Uploader)localObject);
    }
    if (((CharSequence)paramPublishArticleInfo.getVideoUploadKey()).length() > 0) {
      i = j;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      ((Uploader)localObject).a(paramPublishArticleInfo.getVideoUploadKey());
      return;
    }
    ((Uploader)localObject).a();
  }
  
  private final boolean b(PublishArticleInfo paramPublishArticleInfo)
  {
    ArrayList localArrayList = paramPublishArticleInfo.getImageList();
    paramPublishArticleInfo = paramPublishArticleInfo.getVideoInfo();
    return ((localArrayList == null) || (localArrayList.isEmpty())) && (paramPublishArticleInfo == null);
  }
  
  private final void d(GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo)
  {
    VideoInfo localVideoInfo = a(paramPublishArticleInfo);
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
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("准备上传封面, coverPath = ");
      ((StringBuilder)localObject1).append(localVideoInfo.getCoverPath());
      TLog.d("PublishManager", ((StringBuilder)localObject1).toString());
      localObject1 = localVideoInfo.getCoverPath();
      Object localObject2 = a().a(BaseUploader.UploaderType.IMAGE);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "sdkUploader.getUploaderB…oader.UploaderType.IMAGE)");
      localObject1 = new Uploader((String)localObject1, (BaseUploader)localObject2);
      localObject2 = a(paramPublishArticleInfo.getPublishId());
      if (localObject2 != null) {
        ((PublishManager.PublishTask)localObject2).a((Uploader)localObject1);
      }
      ((Uploader)localObject1).a((IUploadListener)new PublishManager.uploadVideoCover.1(localVideoInfo, paramPublishArticleInfo, paramGlobalPublisherConfig));
      ((Uploader)localObject1).a();
    }
  }
  
  private final void e(GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo)
  {
    DataTransferManager.a.a(paramPublishArticleInfo, (Function4)new PublishManager.publishArticle.1(paramPublishArticleInfo, paramGlobalPublisherConfig));
  }
  
  public final void a()
  {
    ThreadManagerKt.c((Function0)PublishManager.saveData.1.INSTANCE);
  }
  
  public final void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt * 1024;
  }
  
  @Deprecated(message="目前手Q用到，因此此处空实现")
  public void a(@NotNull Context paramContext, long paramLong, @NotNull IPublishManager.ICheckResultCallBack paramICheckResultCallBack)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramICheckResultCallBack, "callback");
  }
  
  @Deprecated(message="目前手Q用到，因此此处空实现")
  public void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PreUploadVideoInfo paramPreUploadVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramGlobalPublisherConfig, "globalPublisherConfig");
    Intrinsics.checkParameterIsNotNull(paramPreUploadVideoInfo, "preUploadVideoInfo");
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
    boolean bool = b(paramPublishArticleInfo);
    int i = 0;
    if (bool)
    {
      if (((CharSequence)paramPublishArticleInfo.getContent()).length() == 0) {
        i = 1;
      }
      if (i != 0) {
        return;
      }
      e(paramGlobalPublisherConfig, paramPublishArticleInfo);
      return;
    }
    bool = Intrinsics.areEqual(paramGlobalPublisherConfig.getPublishScene(), "rijugc");
    Object localObject1 = null;
    if ((bool) && (!NetworkUtils.a.b(AppContext.a.a())) && (!TopicSDKHelperKt.b()))
    {
      localObject2 = AppContext.a.a().getResources().getString(R.string.X);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "AppContext.instance.reso…commend_wifi_upload_tips)");
      TopicSDKHelperKt.a((String)localObject2, false, null, 6, null);
    }
    a(paramPublishArticleInfo);
    Object localObject2 = paramPublishArticleInfo.getImageList();
    if (localObject2 != null) {
      localObject1 = (ImageInfo)CollectionsKt.firstOrNull((List)localObject2);
    }
    if (localObject1 == null)
    {
      localObject2 = paramPublishArticleInfo.getPublishId();
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
      a((String)localObject2, (String)localObject1);
    }
    else
    {
      a(paramPublishArticleInfo.getPublishId(), ((ImageInfo)localObject1).getFilePath());
    }
    b(paramGlobalPublisherConfig, paramPublishArticleInfo);
  }
  
  @Deprecated(message="目前手Q用到，因此此处空实现")
  public void a(@NotNull IPublishManager.IPublishStatusListener paramIPublishStatusListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIPublishStatusListener, "publishStatusListener");
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "publishId");
    Iterator localIterator = ((Iterable)c).iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (Intrinsics.areEqual(((PublishManager.PublishTask)localObject).a().getPublishId(), paramString))
      {
        paramString = (String)localObject;
        break label59;
      }
    }
    paramString = null;
    label59:
    paramString = (PublishManager.PublishTask)paramString;
    if (paramString != null) {
      c.remove(paramString);
    }
    if (paramString != null)
    {
      localObject = paramString.a();
      if (localObject != null) {
        ((PublishArticleInfo)localObject).setPublishing(false);
      }
    }
    if (paramString != null)
    {
      paramString = paramString.a();
      if (paramString != null) {
        paramString.b();
      }
    }
    a();
    b();
  }
  
  public final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "publishId");
    ThreadManagerKt.a((Function0)new PublishManager.dispatchProgress.1(paramString, paramInt));
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "publishId");
    Intrinsics.checkParameterIsNotNull(paramString2, "coverPath");
    ThreadManagerKt.a((Function0)new PublishManager.dispatchOnStart.1(paramString1, paramString2));
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
  
  public final void b()
  {
    ThreadManagerKt.c((Function0)PublishManager.deletePublishTempFile.1.INSTANCE);
  }
  
  public final void b(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramGlobalPublisherConfig, "globalPublisherConfig");
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "publishArticleInfo");
    ImageInfo localImageInfo = a(paramPublishArticleInfo);
    paramPublishArticleInfo.setPublishing(true);
    if (localImageInfo == null)
    {
      d(paramGlobalPublisherConfig, paramPublishArticleInfo);
      return;
    }
    a(paramGlobalPublisherConfig, paramPublishArticleInfo, localImageInfo);
  }
  
  public final void c(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramGlobalPublisherConfig, "globalPublisherConfig");
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "articleInfo");
    a();
    ThreadManagerKt.a((Function0)new PublishManager.dispatchOnFailed.1(paramPublishArticleInfo, paramGlobalPublisherConfig));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager
 * JD-Core Version:    0.7.0.1
 */