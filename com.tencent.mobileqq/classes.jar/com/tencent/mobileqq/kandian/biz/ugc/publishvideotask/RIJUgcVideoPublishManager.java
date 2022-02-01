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
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;

@Deprecated
public class RIJUgcVideoPublishManager
  implements Manager
{
  private final LinkedHashMap<String, PublishTaskAutomator> a = new LinkedHashMap();
  private final ArrayList<UgcVideo> b = new ArrayList();
  private final CopyOnWriteArrayList<IRIJUgcVideoPublishService.ILoadDBCallback> c = new CopyOnWriteArrayList();
  private boolean d;
  private boolean e;
  private QQAppInterface f;
  private EntityManager g;
  private CopyOnWriteArrayList<IRIJUgcVideoPublishService.IVideoPublishCallback> h = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList<IRIJUgcVideoPublishService.IReleaseCallback> i = new CopyOnWriteArrayList();
  private final HashMap<String, IRIJUgcVideoPublishService.IUploadVideoStatusCallback> j = new HashMap();
  private INetInfoHandler k = new RIJUgcVideoPublishManager.1(this);
  private RIJUgcVideoPublishManager.RIJUgcVideoPublishManagerActivityLifecycleCallbacks l = new RIJUgcVideoPublishManager.RIJUgcVideoPublishManagerActivityLifecycleCallbacks(this);
  
  public RIJUgcVideoPublishManager(QQAppInterface paramQQAppInterface)
  {
    this.f = paramQQAppInterface;
    this.g = ReadInJoyLogicEngine.a().b().createEntityManager();
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.k);
    paramQQAppInterface.getApp().registerActivityLifecycleCallbacks(this.l);
  }
  
  public static RIJUgcVideoPublishManager a(AppRuntime paramAppRuntime)
  {
    return (RIJUgcVideoPublishManager)paramAppRuntime.getManager(QQManagerFactory.RIJ_UGC_VIDEO_PUBLISH_MANAGER);
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
    IRIJUgcVideoPublishService.IUploadVideoStatusCallback localIUploadVideoStatusCallback = (IRIJUgcVideoPublishService.IUploadVideoStatusCallback)this.j.get(paramUgcVideo.seqId);
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
    if (this.e)
    {
      QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "handleChangeToMobileEvent is doing");
      return;
    }
    this.e = true;
    long l1 = RIJUgcUtils.b(paramList);
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((l1 > 0L) && (RIJPushNotification.d()) && (localBaseActivity != null))
    {
      if (this.l.a())
      {
        this.l.a(true);
        this.e = false;
        return;
      }
      this.l.a(false);
      RIJUgcUtils.a(localBaseActivity, l1, new RIJUgcVideoPublishManager.12(this, paramList), new RIJUgcVideoPublishManager.13(this));
      return;
    }
    this.e = false;
  }
  
  private List<UgcVideo> b()
  {
    Object localObject = this.a.values();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PublishTaskAutomator localPublishTaskAutomator = (PublishTaskAutomator)((Iterator)localObject).next();
      if (localPublishTaskAutomator.e().status == UgcVideo.STATUS_UPLOADING) {
        localArrayList.add(localPublishTaskAutomator.e());
      }
    }
    return localArrayList;
  }
  
  private List<UgcVideo> c()
  {
    Object localObject = this.a.values();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PublishTaskAutomator localPublishTaskAutomator = (PublishTaskAutomator)((Iterator)localObject).next();
      if (localPublishTaskAutomator.e().status == UgcVideo.STATUS_PAUSE) {
        localArrayList.add(localPublishTaskAutomator.e());
      }
    }
    return localArrayList;
  }
  
  private void d()
  {
    ThreadManagerV2.excute(new RIJUgcVideoPublishManager.8(this), 32, null, false);
  }
  
  private void e()
  {
    Iterator localIterator = b().iterator();
    while (localIterator.hasNext()) {
      ((UgcVideo)localIterator.next()).canUploadInMobileNet = true;
    }
  }
  
  private void f()
  {
    if (CUKingCardUtils.a() == 1) {
      return;
    }
    List localList = b();
    if (localList.isEmpty())
    {
      QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "handleChangeToMobileEvent, ugcVideoList isEmpty");
      return;
    }
    Iterator localIterator = localList.iterator();
    int m = 0;
    while (localIterator.hasNext())
    {
      UgcVideo localUgcVideo = (UgcVideo)localIterator.next();
      if (!localUgcVideo.canUploadInMobileNet)
      {
        localUgcVideo.pauseBySwitchNet = true;
        b(localUgcVideo);
        m = 1;
      }
      else
      {
        localUgcVideo.canUploadInMobileNet = false;
      }
    }
    if (m != 0) {
      a(localList);
    }
  }
  
  private void f(UgcVideo paramUgcVideo)
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext()) {
      ((IRIJUgcVideoPublishService.IVideoPublishCallback)localIterator.next()).a(paramUgcVideo);
    }
  }
  
  private void g()
  {
    Object localObject = c();
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
    this.l.a(false);
  }
  
  private void h()
  {
    List localList = c();
    if (localList.isEmpty())
    {
      QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "handleAppToFrontEventInMobileNet, ugcVideoList isEmpty");
      return;
    }
    a(localList);
  }
  
  public void a()
  {
    Iterator localIterator = this.b.iterator();
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
    if (this.d)
    {
      paramIGetAllUploadStatusVideosCallback.a(a(paramLong, this.b));
      return;
    }
    this.c.add(new RIJUgcVideoPublishManager.7(this, paramLong, paramIGetAllUploadStatusVideosCallback));
    d();
  }
  
  public void a(@NotNull IRIJUgcVideoPublishService.IReleaseCallback paramIReleaseCallback)
  {
    if (!this.i.contains(paramIReleaseCallback)) {
      this.i.add(paramIReleaseCallback);
    }
  }
  
  @UiThread
  public void a(@NotNull IRIJUgcVideoPublishService.IVideoPublishCallback paramIVideoPublishCallback)
  {
    if (!this.h.contains(paramIVideoPublishCallback)) {
      this.h.add(paramIVideoPublishCallback);
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
    this.a.remove(paramUgcVideo.seqId);
    this.b.remove(paramUgcVideo);
    this.j.remove(paramUgcVideo.seqId);
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
    localObject1 = (PublishTaskAutomator)this.a.get(paramUgcVideo.seqId);
    if (localObject1 == null)
    {
      localObject1 = new PublishTaskAutomator(paramUgcVideo);
      ((PublishTaskAutomator)localObject1).a(new RIJUgcVideoPublishManager.2(this));
      ((PublishTaskAutomator)localObject1).a(new RIJUgcVideoPublishManager.3(this));
      Object localObject2 = new RIJUgcVideoPublishManager.4(this, paramUgcVideo);
      Object localObject3 = new CompressVideoTaskStep(this.f, (PublishTaskAutomator)localObject1, (IPublishTaskCallback)localObject2);
      QQAppInterface localQQAppInterface = this.f;
      localObject3 = new SyncSteps((Automator)localObject1, new BaseStep[] { localObject3, new UploadVideoTaskStep(localQQAppInterface, (PublishTaskAutomator)localObject1, (IPublishTaskCallback)localObject2, new RIJUgcVideoUploader(localQQAppInterface)) });
      localObject3 = new AsyncSteps((Automator)localObject1, new BaseStep[] { new UploadCoverTaskStep(this.f, (PublishTaskAutomator)localObject1, (IPublishTaskCallback)localObject2), localObject3 });
      localObject2 = new PublishTaskStep((PublishTaskAutomator)localObject1, (IPublishTaskCallback)localObject2);
      ((PublishTaskAutomator)localObject1).a(new RIJUgcVideoPublishManager.5(this, paramUgcVideo));
      ((PublishTaskAutomator)localObject1).a(new BaseStep[] { localObject3, localObject2 }, paramBoolean);
      this.a.put(paramUgcVideo.seqId, localObject1);
    }
    else
    {
      ((PublishTaskAutomator)localObject1).c();
    }
    if (paramBoolean)
    {
      paramUgcVideo.status = UgcVideo.STATUS_UPLOADING;
      localObject1 = (IRIJUgcVideoPublishService.IUploadVideoStatusCallback)this.j.get(paramUgcVideo.seqId);
      if (localObject1 != null) {
        ((IRIJUgcVideoPublishService.IUploadVideoStatusCallback)localObject1).c();
      }
    }
    if ((paramUgcVideo.title != null) && (!paramUgcVideo.title.isEmpty()))
    {
      if (!this.b.contains(paramUgcVideo)) {
        this.b.add(paramUgcVideo);
      }
      c(paramUgcVideo);
    }
  }
  
  @UiThread
  public final void a(@NotNull UgcVideo paramUgcVideo, boolean paramBoolean, @NotNull IRIJUgcVideoPublishService.IUploadVideoStatusCallback paramIUploadVideoStatusCallback)
  {
    if (!this.j.containsKey(paramUgcVideo.seqId)) {
      this.j.put(paramUgcVideo.seqId, paramIUploadVideoStatusCallback);
    }
    a(paramUgcVideo, paramBoolean);
  }
  
  public void b(@NotNull IRIJUgcVideoPublishService.IReleaseCallback paramIReleaseCallback)
  {
    this.i.remove(paramIReleaseCallback);
  }
  
  @UiThread
  public void b(@NotNull IRIJUgcVideoPublishService.IVideoPublishCallback paramIVideoPublishCallback)
  {
    this.h.remove(paramIVideoPublishCallback);
  }
  
  public void b(UgcVideo paramUgcVideo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pauseVideoTask, ugcVideo.seqId =");
    ((StringBuilder)localObject).append(paramUgcVideo.seqId);
    QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, ((StringBuilder)localObject).toString());
    paramUgcVideo.status = UgcVideo.STATUS_PAUSE;
    localObject = (PublishTaskAutomator)this.a.get(paramUgcVideo.seqId);
    if (paramUgcVideo.startUploadingTime > 0L) {
      RIJUgcUtils.a("pause", paramUgcVideo);
    }
    if (localObject != null) {
      ((PublishTaskAutomator)localObject).d();
    }
    if (this.j.containsKey(paramUgcVideo.seqId)) {
      ((IRIJUgcVideoPublishService.IUploadVideoStatusCallback)this.j.get(paramUgcVideo.seqId)).d();
    }
  }
  
  public void c(UgcVideo paramUgcVideo)
  {
    int m;
    if ((paramUgcVideo.title != null) && (!paramUgcVideo.title.isEmpty()) && (this.b.contains(paramUgcVideo))) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0) {
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
    this.a.clear();
    this.b.clear();
    this.c.clear();
    this.d = false;
    AppNetConnInfo.unregisterNetInfoHandler(this.k);
    this.f.getApp().unregisterActivityLifecycleCallbacks(this.l);
    a();
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((IRIJUgcVideoPublishService.IReleaseCallback)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.RIJUgcVideoPublishManager
 * JD-Core Version:    0.7.0.1
 */