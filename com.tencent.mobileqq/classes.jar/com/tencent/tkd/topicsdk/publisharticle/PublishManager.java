package com.tencent.tkd.topicsdk.publisharticle;

import android.os.Bundle;
import androidx.annotation.UiThread;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.ImageInfo;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.VideoInfo;
import com.tencent.tkd.topicsdk.common.NetworkUtil;
import com.tencent.tkd.topicsdk.common.report.ReportKeys;
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
import com.tencent.tkd.topicsdk.interfaces.IDataReporter.ACTION;
import com.tencent.tkd.topicsdk.interfaces.IPublishManager;
import com.tencent.tkd.topicsdk.interfaces.IPublishManager.IPublishListener;
import com.tencent.tkd.topicsdk.interfaces.IUploadListener;
import com.tencent.tkd.topicsdk.interfaces.IVideoCompressor;
import com.tencent.tkd.topicsdk.interfaces.IVideoCompressor.Callback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/PublishManager;", "Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager;", "()V", "TAG", "", "value", "", "compressImageSizeThreshold", "getCompressImageSizeThreshold", "()I", "setCompressImageSizeThreshold", "(I)V", "hasLoadLocal", "", "publishListenerList", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/topicsdk/publisharticle/PublishManager$IPublishArticleListener;", "Lkotlin/collections/ArrayList;", "publishManagerListenerList", "Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager$IPublishListener;", "publishTaskList", "Lcom/tencent/tkd/topicsdk/publisharticle/PublishManager$PublishTask;", "addPublishArticleListener", "", "listener", "addPublishListener", "addPublishTask", "articleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "compressAndUploadImage", "globalPublisherConfig", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "publishArticleInfo", "imageInfo", "Lcom/tencent/tkd/topicsdk/bean/ImageInfo;", "compressVideo", "videoInfo", "Lcom/tencent/tkd/topicsdk/bean/VideoInfo;", "deletePublishTempFile", "dispatchOnFailed", "dispatchOnStart", "publishId", "coverPath", "dispatchOnSuccess", "serverPublishData", "dispatchProgress", "progress", "getBaseValueMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getBusinessType", "getDataType", "getFirstPublishTask", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "getNextImageInfoForUpload", "getNextVideoInfoForUpload", "getPublishTask", "getRelatedID", "init", "initData", "finishCallback", "Lkotlin/Function0;", "isFinishUpload", "isTextOnly", "publishArticle", "config", "removePublishArticleListener", "removePublishListener", "removePublishTask", "reportPublishFailed", "reportPublishSuccess", "restartPublishTask", "bundle", "Landroid/os/Bundle;", "saveData", "startPublish", "uploadImage", "uploadMedia", "uploadVideo", "uploadVideoCover", "IPublishArticleListener", "PublishTask", "topicsdk_release"}, k=1, mv={1, 1, 16})
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
    label91:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((CharSequence)((ImageInfo)localObject2).getUrl()).length() == 0) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label91;
        }
        paramPublishArticleInfo.add(localObject2);
        break;
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
  
  private final PublishManager.PublishTask a(String paramString)
  {
    Iterator localIterator = ((Iterable)c).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!Intrinsics.areEqual(((PublishManager.PublishTask)localObject).a().getPublishId(), paramString));
    for (paramString = localObject;; paramString = null) {
      return (PublishManager.PublishTask)paramString;
    }
  }
  
  private final String a(PublishArticleInfo paramPublishArticleInfo)
  {
    if (paramPublishArticleInfo.getTopicId() != 0L) {
      return "column";
    }
    if (((CharSequence)paramPublishArticleInfo.getCommunityId()).length() > 0) {}
    for (int i = 1; i != 0; i = 0) {
      return "community";
    }
    return "nothing";
  }
  
  private final HashMap<String, String> a(PublishArticleInfo paramPublishArticleInfo)
  {
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(ReportKeys.a.a(), paramPublishArticleInfo.getScene());
    ((Map)localHashMap).put(ReportKeys.a.b(), jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishManager.a(paramPublishArticleInfo));
    ((Map)localHashMap).put(ReportKeys.a.c(), jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishManager.b(paramPublishArticleInfo));
    ((Map)localHashMap).put(ReportKeys.a.e(), jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishManager.c(paramPublishArticleInfo));
    return localHashMap;
  }
  
  private final void a(GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo, ImageInfo paramImageInfo)
  {
    if ((paramImageInfo.getSize() < jdField_a_of_type_Int) || (paramImageInfo.getHasCompressed()))
    {
      TLog.a("PublishManager", "图片无需压缩，size:" + paramImageInfo.getSize() / 1024 + "kb" + " hasCompressed: " + paramImageInfo.getHasCompressed());
      b(paramGlobalPublisherConfig, paramPublishArticleInfo, paramImageInfo);
      return;
    }
    Luban.a(AppContext.a.a()).a(paramImageInfo.getFilePath()).b(TopicSDKHelperKt.b()).a((OnCompressListener)new PublishManager.compressAndUploadImage.1(paramImageInfo, paramGlobalPublisherConfig, paramPublishArticleInfo)).a();
  }
  
  private final void a(GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo, VideoInfo paramVideoInfo)
  {
    IVideoCompressor localIVideoCompressor = TopicSDK.a.a().a().a();
    localIVideoCompressor.a(paramVideoInfo.getFilePath(), (IVideoCompressor.Callback)new PublishManager.compressVideo.1(paramVideoInfo, localIVideoCompressor, paramPublishArticleInfo, paramGlobalPublisherConfig));
  }
  
  private final void a(GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo, String paramString)
  {
    ThreadManagerKt.a((Function0)new PublishManager.dispatchOnSuccess.1(paramPublishArticleInfo, paramGlobalPublisherConfig, paramString));
    b(paramPublishArticleInfo);
  }
  
  private final void a(PublishArticleInfo paramPublishArticleInfo)
  {
    paramPublishArticleInfo = a(paramPublishArticleInfo);
    TopicSDKHelperKt.a(IDataReporter.ACTION.ACTION_FAIL_PUBLISH, (Map)paramPublishArticleInfo, null, 4, null);
  }
  
  private final void a(Function0<Unit> paramFunction0)
  {
    ThreadManagerKt.c((Function0)new PublishManager.initData.1(paramFunction0));
  }
  
  private final String b(PublishArticleInfo paramPublishArticleInfo)
  {
    if (paramPublishArticleInfo.getVideoInfo() != null) {
      return "video";
    }
    return "shortContent";
  }
  
  private final void b(GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo, ImageInfo paramImageInfo)
  {
    Object localObject1 = paramImageInfo.getFilePath();
    Object localObject2 = TopicSDK.a.a().a().a().a(BaseUploader.UploaderType.IMAGE);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "TopicSDK.instance().topi…oader.UploaderType.IMAGE)");
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
    if (((CharSequence)paramVideoInfo.getUrl()).length() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      e(paramGlobalPublisherConfig, paramPublishArticleInfo);
      return;
    }
    Object localObject;
    if (((CharSequence)paramVideoInfo.getCompressPath()).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label182;
      }
      localObject = paramVideoInfo.getCompressPath();
      label65:
      BaseUploader localBaseUploader = TopicSDK.a.a().a().a().a(BaseUploader.UploaderType.VIDEO);
      Intrinsics.checkExpressionValueIsNotNull(localBaseUploader, "TopicSDK.instance().topi…oader.UploaderType.VIDEO)");
      localObject = new Uploader((String)localObject, localBaseUploader);
      ((Uploader)localObject).a((IUploadListener)new PublishManager.uploadVideo.1(paramPublishArticleInfo, paramVideoInfo, paramGlobalPublisherConfig));
      paramGlobalPublisherConfig = a(paramPublishArticleInfo.getPublishId());
      if (paramGlobalPublisherConfig != null) {
        paramGlobalPublisherConfig.a((Uploader)localObject);
      }
      if (((CharSequence)paramPublishArticleInfo.getVideoUploadKey()).length() <= 0) {
        break label191;
      }
    }
    label182:
    label191:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label197;
      }
      ((Uploader)localObject).a(paramPublishArticleInfo.getVideoUploadKey());
      return;
      i = 0;
      break;
      localObject = paramVideoInfo.getFilePath();
      break label65;
    }
    label197:
    ((Uploader)localObject).a();
  }
  
  private final void b(PublishArticleInfo paramPublishArticleInfo)
  {
    HashMap localHashMap = a(paramPublishArticleInfo);
    ((Map)localHashMap).put(ReportKeys.a.d(), paramPublishArticleInfo.getContentId());
    TopicSDKHelperKt.a(IDataReporter.ACTION.ACTION_SUCCESS_PUBLISH, (Map)localHashMap, null, 4, null);
  }
  
  private final boolean b(PublishArticleInfo paramPublishArticleInfo)
  {
    ArrayList localArrayList = paramPublishArticleInfo.getImageList();
    paramPublishArticleInfo = paramPublishArticleInfo.getVideoInfo();
    return ((localArrayList == null) || (localArrayList.isEmpty())) && (paramPublishArticleInfo == null);
  }
  
  private final String c(PublishArticleInfo paramPublishArticleInfo)
  {
    if (paramPublishArticleInfo.getTopicId() != 0L) {
      return String.valueOf(paramPublishArticleInfo.getTopicId());
    }
    return paramPublishArticleInfo.getCommunityId();
  }
  
  private final void c(PublishArticleInfo paramPublishArticleInfo)
  {
    paramPublishArticleInfo = new PublishManager.PublishTask(paramPublishArticleInfo);
    c.add(paramPublishArticleInfo);
    a();
  }
  
  private final void d(GlobalPublisherConfig paramGlobalPublisherConfig, PublishArticleInfo paramPublishArticleInfo)
  {
    VideoInfo localVideoInfo = a(paramPublishArticleInfo);
    if (localVideoInfo != null) {
      if (((CharSequence)localVideoInfo.getCoverUrl()).length() <= 0) {
        break label43;
      }
    }
    label43:
    for (int i = 1; i != 0; i = 0)
    {
      a(paramGlobalPublisherConfig, paramPublishArticleInfo, localVideoInfo);
      return;
    }
    TLog.d("PublishManager", "准备上传封面, coverPath = " + localVideoInfo.getCoverPath());
    Object localObject1 = localVideoInfo.getCoverPath();
    Object localObject2 = TopicSDK.a.a().a().a().a(BaseUploader.UploaderType.IMAGE);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "TopicSDK.instance().topi…oader.UploaderType.IMAGE)");
    localObject1 = new Uploader((String)localObject1, (BaseUploader)localObject2);
    localObject2 = a(paramPublishArticleInfo.getPublishId());
    if (localObject2 != null) {
      ((PublishManager.PublishTask)localObject2).a((Uploader)localObject1);
    }
    ((Uploader)localObject1).a((IUploadListener)new PublishManager.uploadVideoCover.1(localVideoInfo, paramPublishArticleInfo, paramGlobalPublisherConfig));
    ((Uploader)localObject1).a();
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
  
  public final void a(@Nullable Bundle paramBundle, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "publishId");
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getSerializable("global_publisher_config");
      paramBundle = (GlobalPublisherConfig)paramBundle;
      if (paramBundle == null) {
        break label54;
      }
    }
    PublishManager.PublishTask localPublishTask;
    for (;;)
    {
      localPublishTask = a(paramString);
      if ((localPublishTask != null) && (!localPublishTask.a().isPublishing())) {
        break label65;
      }
      return;
      paramBundle = null;
      break;
      label54:
      paramBundle = new GlobalPublisherConfig();
    }
    label65:
    localPublishTask.a().setPublishing(true);
    if ((jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishManager.a(localPublishTask.a()) == null) && (jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishManager.a(localPublishTask.a()) == null))
    {
      jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishManager.e(paramBundle, localPublishTask.a());
      return;
    }
    paramString = localPublishTask.a();
    if (paramString != null)
    {
      paramString.b();
      return;
    }
    paramString = localPublishTask.a().getImageList();
    if (paramString != null)
    {
      paramString = (ImageInfo)CollectionsKt.firstOrNull((List)paramString);
      if (paramString != null) {
        break label219;
      }
      PublishManager localPublishManager = jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishManager;
      String str = localPublishTask.a().getPublishId();
      paramString = localPublishTask.a().getVideoInfo();
      if (paramString == null) {
        break label212;
      }
      paramString = paramString.getCoverPath();
      if (paramString == null) {
        break label212;
      }
      label187:
      localPublishManager.a(str, paramString);
    }
    for (;;)
    {
      jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishManager.b(paramBundle, localPublishTask.a());
      return;
      paramString = null;
      break;
      label212:
      paramString = "";
      break label187;
      label219:
      jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishManager.a(localPublishTask.a().getPublishId(), paramString.getFilePath());
    }
  }
  
  @UiThread
  public void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramGlobalPublisherConfig, "globalPublisherConfig");
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "publishArticleInfo");
    if (b(paramPublishArticleInfo))
    {
      if (((CharSequence)paramPublishArticleInfo.getContent()).length() == 0) {}
      for (int i = 1; i != 0; i = 0) {
        return;
      }
      e(paramGlobalPublisherConfig, paramPublishArticleInfo);
      return;
    }
    if ((NetworkUtil.a(AppContext.a.a())) && (TopicSDKHelperKt.b())) {
      ThreadManagerKt.a((Function0)PublishManager.startPublish.1.INSTANCE);
    }
    Object localObject = UUID.randomUUID().toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "UUID.randomUUID().toString()");
    paramPublishArticleInfo.setPublishId((String)localObject);
    c(paramPublishArticleInfo);
    localObject = paramPublishArticleInfo.getImageList();
    if (localObject != null)
    {
      localObject = (ImageInfo)CollectionsKt.firstOrNull((List)localObject);
      if (localObject != null) {
        break label197;
      }
      String str = paramPublishArticleInfo.getPublishId();
      localObject = paramPublishArticleInfo.getVideoInfo();
      if (localObject == null) {
        break label189;
      }
      localObject = ((VideoInfo)localObject).getCoverPath();
      if (localObject == null) {
        break label189;
      }
      label168:
      a(str, (String)localObject);
    }
    for (;;)
    {
      b(paramGlobalPublisherConfig, paramPublishArticleInfo);
      return;
      localObject = null;
      break;
      label189:
      localObject = "";
      break label168;
      label197:
      a(paramPublishArticleInfo.getPublishId(), ((ImageInfo)localObject).getFilePath());
    }
  }
  
  public final void a(@NotNull PublishManager.IPublishArticleListener paramIPublishArticleListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIPublishArticleListener, "listener");
    jdField_a_of_type_JavaUtilArrayList.add(paramIPublishArticleListener);
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "publishId");
    Iterator localIterator = ((Iterable)c).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!Intrinsics.areEqual(((PublishManager.PublishTask)localObject).a().getPublishId(), paramString));
    for (paramString = (String)localObject;; paramString = null)
    {
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
          paramString.c();
        }
      }
      a();
      b();
      return;
    }
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
  
  @UiThread
  public final void a(@NotNull Function1<? super PublishArticleInfo, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    if (jdField_a_of_type_Boolean)
    {
      Object localObject = (PublishManager.PublishTask)CollectionsKt.firstOrNull((List)c);
      if (localObject != null) {}
      for (localObject = ((PublishManager.PublishTask)localObject).a();; localObject = null)
      {
        paramFunction1.invoke(localObject);
        return;
      }
    }
    a((Function0)new PublishManager.getFirstPublishTask.1(paramFunction1));
  }
  
  public final boolean a(@NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "publishArticleInfo");
    Object localObject = paramPublishArticleInfo.getImageList();
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      bool2 = true;
      label90:
      for (;;)
      {
        bool1 = bool2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        if (((CharSequence)((ImageInfo)((Iterator)localObject).next()).getUrl()).length() == 0) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label90;
          }
          bool2 = false;
          break;
        }
      }
    }
    boolean bool1 = true;
    paramPublishArticleInfo = paramPublishArticleInfo.getVideoInfo();
    boolean bool2 = bool1;
    if (paramPublishArticleInfo != null) {
      if (((CharSequence)paramPublishArticleInfo.getUrl()).length() != 0) {
        break label140;
      }
    }
    label140:
    for (int i = j;; i = 0)
    {
      bool2 = bool1;
      if (i != 0) {
        bool2 = false;
      }
      return bool2;
    }
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
  
  public final void b(@NotNull PublishManager.IPublishArticleListener paramIPublishArticleListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIPublishArticleListener, "listener");
    jdField_a_of_type_JavaUtilArrayList.remove(paramIPublishArticleListener);
  }
  
  public final void c(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramGlobalPublisherConfig, "globalPublisherConfig");
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "articleInfo");
    a();
    ThreadManagerKt.a((Function0)new PublishManager.dispatchOnFailed.1(paramPublishArticleInfo, paramGlobalPublisherConfig));
    a(paramPublishArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager
 * JD-Core Version:    0.7.0.1
 */