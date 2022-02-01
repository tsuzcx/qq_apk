package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import android.support.annotation.UiThread;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.automator.AsyncSteps;
import com.tencent.mobileqq.kandian.base.automator.Automator;
import com.tencent.mobileqq.kandian.base.automator.BaseStep;
import com.tencent.mobileqq.kandian.base.automator.SyncSteps;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotification;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IGetAllUploadStatusVideosCallback;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.ILoadDBCallback;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IReleaseCallback;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IUploadVideoStatusCallback;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IVideoPublishCallback;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.kandian.biz.ugc.upload.RIJUgcVideoUploader;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;

@Deprecated
public class RIJUgcVideoPublishManager
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private RIJUgcVideoPublishManager.RIJUgcVideoPublishManagerActivityLifecycleCallbacks jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskRIJUgcVideoPublishManager$RIJUgcVideoPublishManagerActivityLifecycleCallbacks = new RIJUgcVideoPublishManager.RIJUgcVideoPublishManagerActivityLifecycleCallbacks(this);
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new RIJUgcVideoPublishManager.1(this);
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private final ArrayList<UgcVideo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final HashMap<String, IRIJUgcVideoPublishService.IUploadVideoStatusCallback> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final LinkedHashMap<String, PublishTaskAutomator> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private List<IRIJUgcVideoPublishService.IVideoPublishCallback> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private final ArrayList<IRIJUgcVideoPublishService.ILoadDBCallback> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private List<IRIJUgcVideoPublishService.IReleaseCallback> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  
  public RIJUgcVideoPublishManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = ReadInJoyLogicEngine.a().a().createEntityManager();
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    paramQQAppInterface.getApp().registerActivityLifecycleCallbacks(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskRIJUgcVideoPublishManager$RIJUgcVideoPublishManagerActivityLifecycleCallbacks);
  }
  
  public static RIJUgcVideoPublishManager a(AppRuntime paramAppRuntime)
  {
    return (RIJUgcVideoPublishManager)paramAppRuntime.getManager(QQManagerFactory.RIJ_UGC_VIDEO_PUBLISH_MANAGER);
  }
  
  private List<UgcVideo> a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap.values();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PublishTaskAutomator localPublishTaskAutomator = (PublishTaskAutomator)((Iterator)localObject).next();
      if (localPublishTaskAutomator.a().status == UgcVideo.STATUS_UPLOADING) {
        localArrayList.add(localPublishTaskAutomator.a());
      }
    }
    return localArrayList;
  }
  
  private List<UgcVideo> a(long paramLong, List<UgcVideo> paramList)
  {
    if (paramLong == 0L) {
      return new ArrayList(paramList);
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      UgcVideo localUgcVideo = (UgcVideo)paramList.next();
      if (localUgcVideo.columnId == paramLong) {
        localArrayList.add(localUgcVideo);
      }
    }
    return localArrayList;
  }
  
  private void a(@NotNull UgcVideo paramUgcVideo, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    IRIJUgcVideoPublishService.IUploadVideoStatusCallback localIUploadVideoStatusCallback = (IRIJUgcVideoPublishService.IUploadVideoStatusCallback)this.jdField_a_of_type_JavaUtilHashMap.get(paramUgcVideo.seqId);
    if (paramUgcVideo.status == UgcVideo.STATUS_FAILED)
    {
      localIUploadVideoStatusCallback.b();
      paramUgcVideo = new StringBuilder();
      paramUgcVideo.append("Publish taskType =");
      paramUgcVideo.append(paramInt);
      paramUgcVideo.append(" exc");
      QLog.e("RIJUGC.RIJUgcVideoPublishManager", 1, paramUgcVideo.toString());
      return;
    }
    localIUploadVideoStatusCallback.a(paramUgcVideo.getProgress(), paramUgcVideo.uploadSpeed, paramUgcVideo.fileSize * paramUgcVideo.videoProgress / 100L, paramUgcVideo.fileSize);
    if ((paramBoolean2) && (paramInt != 1))
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt == 4) {
            return;
          }
          paramUgcVideo = new StringBuilder();
          paramUgcVideo.append("Publish taskType =");
          paramUgcVideo.append(paramInt);
          QLog.e("RIJUGC.RIJUgcVideoPublishManager", 1, paramUgcVideo.toString());
          return;
        }
        if (paramUgcVideo.coverProgress == 100) {
          localIUploadVideoStatusCallback.a(paramUgcVideo.coverUrl);
        }
      }
      if (paramUgcVideo.getProgress() == 100) {
        localIUploadVideoStatusCallback.a();
      }
    }
  }
  
  private void a(List<UgcVideo> paramList)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "handleChangeToMobileEvent is doing");
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    long l = RIJUgcUtils.a(paramList);
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((l > 0L) && (RIJPushNotification.c()) && (localBaseActivity != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskRIJUgcVideoPublishManager$RIJUgcVideoPublishManagerActivityLifecycleCallbacks.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskRIJUgcVideoPublishManager$RIJUgcVideoPublishManagerActivityLifecycleCallbacks.a(true);
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskRIJUgcVideoPublishManager$RIJUgcVideoPublishManagerActivityLifecycleCallbacks.a(false);
      RIJUgcUtils.a(localBaseActivity, l, new RIJUgcVideoPublishManager.12(this, paramList), new RIJUgcVideoPublishManager.13(this));
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private List<UgcVideo> b()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap.values();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PublishTaskAutomator localPublishTaskAutomator = (PublishTaskAutomator)((Iterator)localObject).next();
      if (localPublishTaskAutomator.a().status == UgcVideo.STATUS_PAUSE) {
        localArrayList.add(localPublishTaskAutomator.a());
      }
    }
    return localArrayList;
  }
  
  private void b()
  {
    ThreadManagerV2.excute(new RIJUgcVideoPublishManager.8(this), 32, null, false);
  }
  
  private void c()
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext()) {
      ((UgcVideo)localIterator.next()).canUploadInMobileNet = true;
    }
  }
  
  private void d()
  {
    if (CUKingCardUtils.a() == 1) {
      return;
    }
    List localList = a();
    if (localList.isEmpty())
    {
      QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "handleChangeToMobileEvent, ugcVideoList isEmpty");
      return;
    }
    Iterator localIterator = localList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      UgcVideo localUgcVideo = (UgcVideo)localIterator.next();
      if (!localUgcVideo.canUploadInMobileNet)
      {
        localUgcVideo.pauseBySwitchNet = true;
        b(localUgcVideo);
        i = 1;
      }
      else
      {
        localUgcVideo.canUploadInMobileNet = false;
      }
    }
    if (i != 0) {
      a(localList);
    }
  }
  
  private void e()
  {
    Object localObject = b();
    if (((List)localObject).isEmpty())
    {
      QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "handleChangeToWifiEvent, ugcVideoList isEmpty");
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      UgcVideo localUgcVideo = (UgcVideo)((Iterator)localObject).next();
      if (localUgcVideo.pauseBySwitchNet)
      {
        localUgcVideo.pauseBySwitchNet = false;
        a(localUgcVideo, true);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskRIJUgcVideoPublishManager$RIJUgcVideoPublishManagerActivityLifecycleCallbacks.a(false);
  }
  
  private void f()
  {
    List localList = b();
    if (localList.isEmpty())
    {
      QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "handleAppToFrontEventInMobileNet, ugcVideoList isEmpty");
      return;
    }
    a(localList);
  }
  
  private void f(UgcVideo paramUgcVideo)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IRIJUgcVideoPublishService.IVideoPublishCallback)localIterator.next()).a(paramUgcVideo);
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      UgcVideo localUgcVideo = (UgcVideo)localIterator.next();
      if (localUgcVideo.status == UgcVideo.STATUS_UPLOADING) {
        b(localUgcVideo);
      }
    }
  }
  
  @UiThread
  public void a(long paramLong, @NotNull IRIJUgcVideoPublishService.IGetAllUploadStatusVideosCallback paramIGetAllUploadStatusVideosCallback)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramIGetAllUploadStatusVideosCallback.a(a(paramLong, this.jdField_a_of_type_JavaUtilArrayList));
      return;
    }
    this.jdField_b_of_type_JavaUtilArrayList.add(new RIJUgcVideoPublishManager.7(this, paramLong, paramIGetAllUploadStatusVideosCallback));
    b();
  }
  
  public void a(@NotNull IRIJUgcVideoPublishService.IReleaseCallback paramIReleaseCallback)
  {
    if (!this.jdField_b_of_type_JavaUtilList.contains(paramIReleaseCallback)) {
      this.jdField_b_of_type_JavaUtilList.add(paramIReleaseCallback);
    }
  }
  
  @UiThread
  public void a(@NotNull IRIJUgcVideoPublishService.IVideoPublishCallback paramIVideoPublishCallback)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramIVideoPublishCallback)) {
      this.jdField_a_of_type_JavaUtilList.add(paramIVideoPublishCallback);
    }
  }
  
  @UiThread
  public void a(UgcVideo paramUgcVideo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeVideoTask, ugcVideo.seqId =");
    localStringBuilder.append(paramUgcVideo.seqId);
    QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, localStringBuilder.toString());
    if (paramUgcVideo.status == UgcVideo.STATUS_UPLOADING) {
      b(paramUgcVideo);
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramUgcVideo.seqId);
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramUgcVideo);
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramUgcVideo.seqId);
    e(paramUgcVideo);
    ThreadManagerV2.excute(new RIJUgcVideoPublishManager.6(this, paramUgcVideo), 64, null, false);
  }
  
  @UiThread
  public final void a(@NotNull UgcVideo paramUgcVideo, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("addVideoTask: ugcVideo.seqId = ");
    ((StringBuilder)localObject1).append(paramUgcVideo.seqId);
    QLog.d("RIJUGC.RIJUgcVideoPublishManager", 1, ((StringBuilder)localObject1).toString());
    localObject1 = (PublishTaskAutomator)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramUgcVideo.seqId);
    if (localObject1 == null)
    {
      localObject1 = new PublishTaskAutomator(paramUgcVideo);
      ((PublishTaskAutomator)localObject1).a(new RIJUgcVideoPublishManager.2(this));
      ((PublishTaskAutomator)localObject1).a(new RIJUgcVideoPublishManager.3(this));
      Object localObject2 = new RIJUgcVideoPublishManager.4(this, paramUgcVideo);
      Object localObject3 = new CompressVideoTaskStep(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (PublishTaskAutomator)localObject1, (IPublishTaskCallback)localObject2);
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject3 = new SyncSteps((Automator)localObject1, new BaseStep[] { localObject3, new UploadVideoTaskStep(localQQAppInterface, (PublishTaskAutomator)localObject1, (IPublishTaskCallback)localObject2, new RIJUgcVideoUploader(localQQAppInterface)) });
      localObject3 = new AsyncSteps((Automator)localObject1, new BaseStep[] { new UploadCoverTaskStep(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (PublishTaskAutomator)localObject1, (IPublishTaskCallback)localObject2), localObject3 });
      localObject2 = new PublishTaskStep((PublishTaskAutomator)localObject1, (IPublishTaskCallback)localObject2);
      ((PublishTaskAutomator)localObject1).a(new RIJUgcVideoPublishManager.5(this, paramUgcVideo));
      ((PublishTaskAutomator)localObject1).a(new BaseStep[] { localObject3, localObject2 }, paramBoolean);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramUgcVideo.seqId, localObject1);
    }
    else
    {
      ((PublishTaskAutomator)localObject1).a();
    }
    if (paramBoolean)
    {
      paramUgcVideo.status = UgcVideo.STATUS_UPLOADING;
      localObject1 = (IRIJUgcVideoPublishService.IUploadVideoStatusCallback)this.jdField_a_of_type_JavaUtilHashMap.get(paramUgcVideo.seqId);
      if (localObject1 != null) {
        ((IRIJUgcVideoPublishService.IUploadVideoStatusCallback)localObject1).c();
      }
    }
    if ((paramUgcVideo.title != null) && (!paramUgcVideo.title.isEmpty()))
    {
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramUgcVideo)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramUgcVideo);
      }
      c(paramUgcVideo);
    }
  }
  
  @UiThread
  public final void a(@NotNull UgcVideo paramUgcVideo, boolean paramBoolean, @NotNull IRIJUgcVideoPublishService.IUploadVideoStatusCallback paramIUploadVideoStatusCallback)
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramUgcVideo.seqId)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramUgcVideo.seqId, paramIUploadVideoStatusCallback);
    }
    a(paramUgcVideo, paramBoolean);
  }
  
  public void b(@NotNull IRIJUgcVideoPublishService.IReleaseCallback paramIReleaseCallback)
  {
    this.jdField_b_of_type_JavaUtilList.remove(paramIReleaseCallback);
  }
  
  @UiThread
  public void b(@NotNull IRIJUgcVideoPublishService.IVideoPublishCallback paramIVideoPublishCallback)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramIVideoPublishCallback);
  }
  
  public void b(UgcVideo paramUgcVideo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pauseVideoTask, ugcVideo.seqId =");
    ((StringBuilder)localObject).append(paramUgcVideo.seqId);
    QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, ((StringBuilder)localObject).toString());
    paramUgcVideo.status = UgcVideo.STATUS_PAUSE;
    localObject = (PublishTaskAutomator)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramUgcVideo.seqId);
    if (paramUgcVideo.startUploadingTime > 0L) {
      RIJUgcUtils.a("pause", paramUgcVideo);
    }
    if (localObject != null) {
      ((PublishTaskAutomator)localObject).b();
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramUgcVideo.seqId)) {
      ((IRIJUgcVideoPublishService.IUploadVideoStatusCallback)this.jdField_a_of_type_JavaUtilHashMap.get(paramUgcVideo.seqId)).d();
    }
  }
  
  public void c(UgcVideo paramUgcVideo)
  {
    int i;
    if ((paramUgcVideo.title != null) && (!paramUgcVideo.title.isEmpty()) && (this.jdField_a_of_type_JavaUtilArrayList.contains(paramUgcVideo))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      ThreadManagerV2.excute(new RIJUgcVideoPublishManager.9(this, paramUgcVideo), 32, null, false);
    }
  }
  
  public void d(UgcVideo paramUgcVideo)
  {
    ThreadManagerV2.excute(new RIJUgcVideoPublishManager.10(this, paramUgcVideo), 32, null, false);
  }
  
  public void e(UgcVideo paramUgcVideo)
  {
    ThreadManagerV2.excute(new RIJUgcVideoPublishManager.11(this, paramUgcVideo), 32, null, false);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Boolean = false;
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterActivityLifecycleCallbacks(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskRIJUgcVideoPublishManager$RIJUgcVideoPublishManagerActivityLifecycleCallbacks);
    a();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IRIJUgcVideoPublishService.IReleaseCallback)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.RIJUgcVideoPublishManager
 * JD-Core Version:    0.7.0.1
 */