package com.tencent.mobileqq.winkpublish.request;

import FileUpload.MultiPicInfo;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.aelight.camera.api.IAEEditorGenerateResultListener;
import com.tencent.aelight.camera.api.IAEEditorManagerForQzone;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.AppConstants;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.db.util.NeedParcel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IWinkExport;
import com.tencent.mobileqq.winkpublish.account.LoginData;
import com.tencent.mobileqq.winkpublish.api.IUploadLocalConfig;
import com.tencent.mobileqq.winkpublish.common.AUploadCommonSetting;
import com.tencent.mobileqq.winkpublish.fs.task.QCircleImageUploadTask;
import com.tencent.mobileqq.winkpublish.fs.task.QCircleVideoUploadTask;
import com.tencent.mobileqq.winkpublish.model.DynamicArrayList;
import com.tencent.mobileqq.winkpublish.model.ImageInfo;
import com.tencent.mobileqq.winkpublish.model.MediaWrapper;
import com.tencent.mobileqq.winkpublish.model.QzoneMediaUploadParams;
import com.tencent.mobileqq.winkpublish.model.ShuoshuoVideoInfo;
import com.tencent.mobileqq.winkpublish.model.UploadVideoObject;
import com.tencent.mobileqq.winkpublish.part.PublishSavePart;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.mobileqq.winkpublish.queue.IUploadQueueListener;
import com.tencent.mobileqq.winkpublish.service.video.util.PublishVideoUtils;
import com.tencent.mobileqq.winkpublish.util.ImageQualityPreference;
import com.tencent.mobileqq.winkpublish.util.PublishUtils;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PublishUploadRequest
  extends AUploadMediaUploadRequest
  implements IAEEditorGenerateResultListener
{
  private static final int A = QCircleConfigHelper.a("QZoneSetting", "qqcircleGenerateOverTime", Integer.valueOf(10000)).intValue();
  private static final int t = QCircleConfigHelper.a("QZoneSetting", "qqcircleTimeOutMaxRetryCount", Integer.valueOf(1)).intValue();
  private AUploadMediaUploadRequest.IMediaUploadTaskInfoListener B;
  private Runnable C = new PublishUploadRequest.1(this);
  @NeedParcel
  private boolean u = true;
  @NeedParcel
  private String v;
  @NeedParcel
  private boolean w = false;
  @NeedParcel
  private int x = 0;
  private boolean y = false;
  private int z = 0;
  
  public PublishUploadRequest() {}
  
  public PublishUploadRequest(List<MediaWrapper> paramList, QzoneMediaUploadParams paramQzoneMediaUploadParams, IUploadQueueListener paramIUploadQueueListener, AUploadMediaUploadRequest.IMediaUploadListener paramIMediaUploadListener)
  {
    this(paramList, paramQzoneMediaUploadParams, paramIUploadQueueListener, paramIMediaUploadListener, null);
  }
  
  public PublishUploadRequest(List<MediaWrapper> paramList, QzoneMediaUploadParams paramQzoneMediaUploadParams, IUploadQueueListener paramIUploadQueueListener, AUploadMediaUploadRequest.IMediaUploadListener paramIMediaUploadListener, AUploadMediaUploadRequest.IMediaUploadTaskInfoListener paramIMediaUploadTaskInfoListener)
  {
    super(paramList, paramQzoneMediaUploadParams, paramIUploadQueueListener, paramIMediaUploadListener);
    this.u = paramQzoneMediaUploadParams.I;
    this.v = paramQzoneMediaUploadParams.J;
    this.w = paramQzoneMediaUploadParams.K;
    this.B = paramIMediaUploadTaskInfoListener;
    QLog.d("[upload2_QCircleUploadRequest]", 1, new Object[] { "QCircleUploadRequest... isVideoReady:", Boolean.valueOf(this.u), " missionID:", this.v });
  }
  
  private void b(int paramInt)
  {
    b(paramInt, FSUploadConst.a(paramInt));
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).removeListener(this);
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.C);
  }
  
  private void c(AbstractUploadTask paramAbstractUploadTask)
  {
    if (paramAbstractUploadTask.mExtend_info == null) {
      paramAbstractUploadTask.mExtend_info = new HashMap();
    }
    if (!TextUtils.isEmpty(this.c.M))
    {
      paramAbstractUploadTask.mExtend_info.put("trace_id", this.c.M);
      return;
    }
    QLog.w("[upload2_QCircleUploadRequest]", 1, "warn!!! clientTraceId is empty");
    paramAbstractUploadTask.mExtend_info.put("trace_id", "");
  }
  
  private void f()
  {
    QLog.d("[upload2_QCircleUploadRequest]", 1, new Object[] { "tryExportVideo... missionId:", this.v, " isVideoReady:", Boolean.valueOf(this.u) });
    if ((!this.u) && (!TextUtils.isEmpty(this.v)))
    {
      ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).init();
      if (QCircleConfigHelper.an())
      {
        this.y = true;
        ((IWinkExport)QRoute.api(IWinkExport.class)).requestGenerateVideo(this.v);
      }
      else
      {
        this.y = false;
        ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).retryQFSMission(this.v);
      }
      QLog.d("[upload2_QCircleUploadRequest]", 1, new Object[] { "tryExportVideo... mUseQQProcess:", Boolean.valueOf(this.y) });
    }
  }
  
  private boolean g()
  {
    return this.x < t;
  }
  
  private void h()
  {
    if ((QCircleConfigHelper.b()) && (this.w))
    {
      DynamicArrayList localDynamicArrayList = new DynamicArrayList();
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
      {
        MediaWrapper localMediaWrapper = (MediaWrapper)localIterator.next();
        if ((localMediaWrapper != null) && (localMediaWrapper.a()) && (localMediaWrapper.c() != null)) {
          localDynamicArrayList.add(localMediaWrapper.c().b);
        }
      }
      PublishSavePart.a(localDynamicArrayList, QCircleHostConstants.AppConstants.SDCARD_IMG_SAVE());
    }
  }
  
  protected AbstractUploadTask a(ShuoshuoVideoInfo paramShuoshuoVideoInfo, byte[] paramArrayOfByte, int paramInt)
  {
    if (this.f)
    {
      paramShuoshuoVideoInfo = new StringBuilder();
      paramShuoshuoVideoInfo.append(c());
      paramShuoshuoVideoInfo.append(", createVideoUploadTask after aborted, return null!");
      QLog.e("[upload2_QCircleUploadRequest]", 1, paramShuoshuoVideoInfo.toString());
      return null;
    }
    if (paramShuoshuoVideoInfo == null)
    {
      paramShuoshuoVideoInfo = new StringBuilder();
      paramShuoshuoVideoInfo.append(c());
      paramShuoshuoVideoInfo.append(", createVideoUploadTask with null videoInfo, return null!");
      QLog.e("[upload2_QCircleUploadRequest]", 1, paramShuoshuoVideoInfo.toString());
      return null;
    }
    UploadVideoObject localUploadVideoObject = UploadVideoObject.a(paramShuoshuoVideoInfo);
    Object localObject = paramShuoshuoVideoInfo.b;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!PublishUtils.a((String)localObject))) {
      localUploadVideoObject.a = ((String)localObject);
    }
    this.k.put(localUploadVideoObject.a(), localUploadVideoObject);
    localObject = new QCircleVideoUploadTask(localUploadVideoObject.a());
    int i;
    if (this.c.k > 0) {
      i = this.c.k;
    } else {
      i = localUploadVideoObject.i();
    }
    ((QCircleVideoUploadTask)localObject).iIsNew = i;
    ((QCircleVideoUploadTask)localObject).flowId = a(this.c.d, localUploadVideoObject.a());
    ((QCircleVideoUploadTask)localObject).iUin = LoginData.a().b();
    ((QCircleVideoUploadTask)localObject).sRefer = "mqq";
    ((QCircleVideoUploadTask)localObject).vLoginData = paramArrayOfByte;
    ((QCircleVideoUploadTask)localObject).md5 = localUploadVideoObject.b();
    ((QCircleVideoUploadTask)localObject).sTitle = localUploadVideoObject.d();
    ((QCircleVideoUploadTask)localObject).sDesc = localUploadVideoObject.e();
    ((QCircleVideoUploadTask)localObject).iFlag = localUploadVideoObject.c();
    ((QCircleVideoUploadTask)localObject).sCoverUrl = localUploadVideoObject.h();
    ((QCircleVideoUploadTask)localObject).iPlayTime = ((int)localUploadVideoObject.f());
    ((QCircleVideoUploadTask)localObject).iUploadTime = (this.c.f - paramInt);
    ((QCircleVideoUploadTask)localObject).iBusiNessType = this.c.l;
    if (this.c.o) {
      paramArrayOfByte = this.c.m;
    } else {
      paramArrayOfByte = a(this.e, paramInt, ((QCircleVideoUploadTask)localObject).iUploadTime, localUploadVideoObject);
    }
    ((QCircleVideoUploadTask)localObject).vBusiNessData = paramArrayOfByte;
    ((QCircleVideoUploadTask)localObject).iIsOriginalVideo = localUploadVideoObject.j();
    ((QCircleVideoUploadTask)localObject).iIsFormatF20 = localUploadVideoObject.k();
    ((QCircleVideoUploadTask)localObject).uploadEntrance = this.c.e;
    ((QCircleVideoUploadTask)localObject).uploadTaskCallback = this;
    a((AbstractUploadTask)localObject, paramShuoshuoVideoInfo);
    ((QCircleVideoUploadTask)localObject).extend_info = new HashMap();
    ((QCircleVideoUploadTask)localObject).extend_info.put("video_type", UploadVideoObject.b(paramShuoshuoVideoInfo));
    ((QCircleVideoUploadTask)localObject).keepTmpFile(true);
    c((AbstractUploadTask)localObject);
    a((AbstractUploadTask)localObject, this.c.e);
    paramShuoshuoVideoInfo = new StringBuilder();
    paramShuoshuoVideoInfo.append(c());
    paramShuoshuoVideoInfo.append(", createVideoUploadTask finish.  index: ");
    paramShuoshuoVideoInfo.append(paramInt);
    paramShuoshuoVideoInfo.append(", QCircleVideoUploadTask:");
    paramShuoshuoVideoInfo.append(((QCircleVideoUploadTask)localObject).toString());
    QLog.i("[upload2_QCircleUploadRequest]", 1, paramShuoshuoVideoInfo.toString());
    return localObject;
  }
  
  protected ImageUploadTask a(ImageInfo paramImageInfo, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.f)
    {
      paramImageInfo = new StringBuilder();
      paramImageInfo.append(c());
      paramImageInfo.append(", createImageUploadTask after aborted, return null!");
      QLog.e("[upload2_QCircleUploadRequest]", 1, paramImageInfo.toString());
      return null;
    }
    if (paramImageInfo == null)
    {
      paramImageInfo = new StringBuilder();
      paramImageInfo.append(c());
      paramImageInfo.append(", createImageUploadTask with null imageInfo, return null!");
      QLog.e("[upload2_QCircleUploadRequest]", 1, paramImageInfo.toString());
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c());
    ((StringBuilder)localObject).append(", createImageUploadTask photoPath:");
    ((StringBuilder)localObject).append(paramImageInfo.a);
    QLog.d("[upload2_QCircleUploadRequest]", 1, ((StringBuilder)localObject).toString());
    localObject = paramImageInfo.a;
    int j = 0;
    localObject = new QCircleImageUploadTask(false, (String)localObject);
    ((QCircleImageUploadTask)localObject).uploadTaskCallback = this;
    ((QCircleImageUploadTask)localObject).iUin = LoginData.a().b();
    ((QCircleImageUploadTask)localObject).sRefer = "mqq";
    ((QCircleImageUploadTask)localObject).vLoginData = paramArrayOfByte;
    ((QCircleImageUploadTask)localObject).md5 = a(paramImageInfo.a);
    ((QCircleImageUploadTask)localObject).sAlbumName = "";
    ((QCircleImageUploadTask)localObject).flowId = a((int)this.c.c, paramImageInfo.a);
    ((QCircleImageUploadTask)localObject).uploadEntrance = this.c.e;
    ((QCircleImageUploadTask)localObject).sPicTitle = "";
    ((QCircleImageUploadTask)localObject).sPicDesc = this.c.i;
    ((QCircleImageUploadTask)localObject).bWaterType = this.c.j;
    ((QCircleImageUploadTask)localObject).autoRotate = this.d;
    ((QCircleImageUploadTask)localObject).clientFakeKey = this.c.d;
    ((QCircleImageUploadTask)localObject).uploadPoi = this.c.w;
    ((QCircleImageUploadTask)localObject).iBusiNessType = this.c.l;
    if (((QCircleImageUploadTask)localObject).iBusiNessType == 1) {
      ((QCircleImageUploadTask)localObject).vBusiNessData = this.c.m;
    }
    paramArrayOfByte = new MultiPicInfo();
    if (this.c.u > 0) {
      i = this.c.u;
    } else {
      i = this.e;
    }
    paramArrayOfByte.iBatUploadNum = i;
    if (this.c.v >= 0) {
      i = this.c.v;
    } else {
      i = paramInt;
    }
    paramArrayOfByte.iCurUpload = i;
    ((QCircleImageUploadTask)localObject).mutliPicInfo = paramArrayOfByte;
    ((QCircleImageUploadTask)localObject).iUploadTime = (this.c.f - paramInt);
    ((QCircleImageUploadTask)localObject).iUploadType = this.c.h;
    ((QCircleImageUploadTask)localObject).iBatchID = this.c.c;
    int i = j;
    if (this.e > 0) {
      i = 1;
    }
    ((QCircleImageUploadTask)localObject).iUpPicType = i;
    ((QCircleImageUploadTask)localObject).keepTmpFile(true);
    c((AbstractUploadTask)localObject);
    a((ImageUploadTask)localObject, this.c.a);
    a((ImageUploadTask)localObject, this.c, paramImageInfo, paramBoolean1, paramBoolean2);
    a((AbstractUploadTask)localObject, this.c.e);
    paramImageInfo = new StringBuilder();
    paramImageInfo.append(c());
    paramImageInfo.append(", createImageUploadTask finish, picPath:");
    paramImageInfo.append(((QCircleImageUploadTask)localObject).uploadFilePath);
    paramImageInfo.append(", flowId:");
    paramImageInfo.append(((QCircleImageUploadTask)localObject).flowId);
    paramImageInfo.append(", index: ");
    paramImageInfo.append(paramInt);
    paramImageInfo.append(", iUploadTime:");
    paramImageInfo.append(((QCircleImageUploadTask)localObject).iUploadTime);
    QLog.i("[upload2_QCircleUploadRequest]", 1, paramImageInfo.toString());
    return localObject;
  }
  
  public void a(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    if ((paramLocalMediaInfo != null) && (!TextUtils.isEmpty(paramLocalMediaInfo.path)))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = PublishVideoUtils.a(RFApplication.getApplication(), paramLocalMediaInfo._id, paramLocalMediaInfo.path, paramLocalMediaInfo.fileSize, 1, paramLocalMediaInfo.thumbnailPath, paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mediaWidth, 0L, paramLocalMediaInfo.mDuration, paramLocalMediaInfo.mDuration, paramLocalMediaInfo.needProcess, null);
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = PublishVideoUtils.a(RFApplication.getApplication(), paramLocalMediaInfo._id, paramLocalMediaInfo.path, paramLocalMediaInfo.fileSize, 1, null, paramLocalMediaInfo.thumbHeight, paramLocalMediaInfo.thumbWidth, 0L, paramLocalMediaInfo.mDuration, paramLocalMediaInfo.mDuration, paramLocalMediaInfo.needProcess, null, false);
      }
      PublishVideoUtils.a(paramString, "video_is_use_qcircle_rate", true);
      int i;
      if (ImageQualityPreference.a().a(1, paramLocalMediaInfo) == 3) {
        i = 1;
      } else {
        i = 0;
      }
      paramLocalMediaInfo.needProcess = (i ^ 0x1);
      paramLocalMediaInfo.mIsUploadOrigin = (paramLocalMediaInfo.needProcess ^ true);
      MediaWrapper localMediaWrapper = new MediaWrapper(paramString);
      if (localMediaWrapper.c().n == true)
      {
        localMediaWrapper.c().n = paramLocalMediaInfo.needProcess;
        paramString = localMediaWrapper.c();
        if (paramLocalMediaInfo.needProcess == true) {
          i = 0;
        } else {
          i = 1;
        }
        paramString.l = i;
        localMediaWrapper.c().q = (paramLocalMediaInfo.needProcess ^ true);
      }
      else if (!paramLocalMediaInfo.needProcess)
      {
        localMediaWrapper.c().n = false;
        localMediaWrapper.c().l = 1;
        localMediaWrapper.c().q = true;
      }
      localMediaWrapper.f = paramLocalMediaInfo.mediaOriginWidth;
      localMediaWrapper.g = paramLocalMediaInfo.mediaOriginHeight;
      localMediaWrapper.h = paramLocalMediaInfo.mediaOriginSize;
      localMediaWrapper.i = paramLocalMediaInfo.mediaOriginBitrate;
      localMediaWrapper.j = paramLocalMediaInfo.mediaBitrate;
      localMediaWrapper.a = paramLocalMediaInfo.materialID;
      localMediaWrapper.b = paramLocalMediaInfo.filterID;
      localMediaWrapper.c = paramLocalMediaInfo.materialName;
      localMediaWrapper.d = paramLocalMediaInfo.scheme;
      localMediaWrapper.e = paramLocalMediaInfo.showCircleTakeSame;
      localMediaWrapper.k = paramLocalMediaInfo.mKuolieId;
      localMediaWrapper.l = paramLocalMediaInfo.mKuolieCenterX;
      localMediaWrapper.m = paramLocalMediaInfo.mKuolieCenterY;
      localMediaWrapper.o = paramLocalMediaInfo.mKuolieWidthScale;
      localMediaWrapper.p = paramLocalMediaInfo.mKuolieHeightScale;
      localMediaWrapper.n = paramLocalMediaInfo.mKuolieRotate;
      paramString = this.B;
      if (paramString != null)
      {
        List localList = paramString.a();
        if ((localList != null) && (localList.size() > 0))
        {
          localObject = ((MediaWrapper)localList.get(0)).q;
          paramString = (String)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramString = "none";
          }
          localMediaWrapper.q = paramString;
          localObject = ((MediaWrapper)localList.get(0)).r;
          paramString = (String)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramString = "none";
          }
          localMediaWrapper.r = paramString;
          localObject = ((MediaWrapper)localList.get(0)).s;
          paramString = (String)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramString = "none";
          }
          localMediaWrapper.s = paramString;
          localObject = ((MediaWrapper)localList.get(0)).t;
          paramString = (String)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramString = "none";
          }
          localMediaWrapper.t = paramString;
        }
      }
      QLog.d("[upload2_QCircleUploadRequest]", 1, new Object[] { "uploadVideo... mediaWrapper:", localMediaWrapper.toString() });
      localArrayList.add(localMediaWrapper);
      this.h = localArrayList;
      paramString = this.B;
      if (paramString != null) {
        paramString.a(this.h);
      }
      a(localArrayList);
      paramString = (AUploadMediaUploadRequest.UploadMediaInfo)this.j.get(paramLocalMediaInfo.path);
      if (paramString == null)
      {
        paramLocalMediaInfo = new StringBuilder();
        paramLocalMediaInfo.append(c());
        paramLocalMediaInfo.append(", uploadVideo but get UploadMediaInfo fail path = ");
        paramLocalMediaInfo.append(paramString);
        QLog.e("[upload2_QCircleUploadRequest]", 1, paramLocalMediaInfo.toString());
        b(10000);
        return;
      }
      b(LoginData.a().e());
      return;
    }
    QLog.e("[upload2_QCircleUploadRequest]", 1, "uploadVideo... localMediaInfo == null || TextUtils.isEmpty(localMediaInfo.path)");
    b(10001);
  }
  
  public boolean a()
  {
    QLog.d("[upload2_QCircleUploadRequest]", 1, new Object[] { "cancel... missionId:", this.v });
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).removeListener(this);
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.C);
    return super.a();
  }
  
  protected void b(byte[] paramArrayOfByte)
  {
    QLog.d("[upload2_QCircleUploadRequest]", 1, new Object[] { "doUploadVideo... isVideoReady:", Boolean.valueOf(this.u), " missionID:", this.v });
    if ((!this.u) && (!TextUtils.isEmpty(this.v)))
    {
      paramArrayOfByte = null;
      if (!TextUtils.isEmpty(this.v))
      {
        paramArrayOfByte = ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).getMissionInfo(this.v);
      }
      else
      {
        QLog.e("[upload2_QCircleUploadRequest]", 1, "missionID not null");
        b(10000);
      }
      if ((paramArrayOfByte != null) && (paramArrayOfByte.isVideoReady))
      {
        QLog.d("[upload2_QCircleUploadRequest]", 1, new Object[] { "doUploadVideo... localMediaInfo != null localMediaInfo:", paramArrayOfByte.toString() });
        this.u = true;
        a(this.v, paramArrayOfByte);
        return;
      }
      ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).addListener(this);
      ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).retryQFSMission(this.v);
      RFThreadManager.getSerialThreadHandler().postDelayed(this.C, A);
      QLog.d("[upload2_QCircleUploadRequest]", 1, "doUploadVideo... wait for export complete...");
      return;
    }
    h();
    super.b(paramArrayOfByte);
  }
  
  public void onAETavSessionExportCompleted(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    QLog.d("[upload2_QCircleUploadRequest]", 1, new Object[] { "onAETavSessionExportCompleted... missionId:", paramString });
    if (!paramString.equals(this.v))
    {
      paramLocalMediaInfo = new StringBuilder();
      paramLocalMediaInfo.append("onAETavSessionExportCompleted not the same mission this.missionID:");
      paramLocalMediaInfo.append(this.v);
      paramLocalMediaInfo.append(" missionID:");
      paramLocalMediaInfo.append(paramString);
      QLog.w("[upload2_QCircleUploadRequest]", 1, paramLocalMediaInfo.toString());
      return;
    }
    if (this.f)
    {
      RFThreadManager.getSerialThreadHandler().removeCallbacks(this.C);
      paramLocalMediaInfo = new StringBuilder();
      paramLocalMediaInfo.append(c());
      paramLocalMediaInfo.append(", onAETavSessionExportCompleted... aborted missionID:");
      paramLocalMediaInfo.append(paramString);
      QLog.e("[upload2_QCircleUploadRequest]", 1, paramLocalMediaInfo.toString());
      return;
    }
    this.u = true;
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.C);
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).removeListener(this);
    IUploadLocalConfig localIUploadLocalConfig = AUploadCommonSetting.a();
    String str2 = QCirclePublishQualityReporter.P_VIDEO_EXPORT_COST;
    FeedCloudCommon.Entry localEntry1 = QCircleReportHelper.newEntry("traceid", this.c.M);
    FeedCloudCommon.Entry localEntry2 = QCircleReportHelper.newEntry("ext6", String.valueOf(this.x));
    Object localObject2 = new StringBuilder();
    boolean bool = this.y;
    String str1 = "QQ";
    if (bool) {
      localObject1 = "QQ";
    } else {
      localObject1 = "Peak";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append(this.z);
    localIUploadLocalConfig.mapReport(str2, paramString, Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, QCircleReportHelper.newEntry("attach_info", ((StringBuilder)localObject2).toString()), QCircleReportHelper.newEntry("ret_code", "0") }));
    localIUploadLocalConfig = AUploadCommonSetting.a();
    str2 = QCirclePublishQualityReporter.E_VIDEO_EXPORT_RESULT;
    localEntry1 = QCircleReportHelper.newEntry("traceid", this.c.M);
    localEntry2 = QCircleReportHelper.newEntry("ret_code", "0");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramLocalMediaInfo.mediaWidth);
    ((StringBuilder)localObject1).append("x");
    ((StringBuilder)localObject1).append(paramLocalMediaInfo.mediaHeight);
    localObject2 = QCircleReportHelper.newEntry("ext1", ((StringBuilder)localObject1).toString());
    FeedCloudCommon.Entry localEntry3 = QCircleReportHelper.newEntry("ext2", String.valueOf(paramLocalMediaInfo.mediaBitrate));
    FeedCloudCommon.Entry localEntry4 = QCircleReportHelper.newEntry("ext3", String.valueOf(paramLocalMediaInfo.fileSize));
    FeedCloudCommon.Entry localEntry5 = QCircleReportHelper.newEntry("ext4", String.valueOf(paramLocalMediaInfo.mDuration / 1000L));
    FeedCloudCommon.Entry localEntry6 = QCircleReportHelper.newEntry("ext5", paramLocalMediaInfo.path);
    FeedCloudCommon.Entry localEntry7 = QCircleReportHelper.newEntry("ext6", String.valueOf(this.x));
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.y) {
      localObject1 = str1;
    } else {
      localObject1 = "Peak";
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(":");
    localStringBuilder.append(this.z);
    localIUploadLocalConfig.uploadQualityReport(str2, Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, localObject2, localEntry3, localEntry4, localEntry5, localEntry6, localEntry7, QCircleReportHelper.newEntry("attach_info", localStringBuilder.toString()) }));
    if ((this.h != null) && (this.h.size() > 0) && (((MediaWrapper)this.h.get(0)).c() != null) && (!TextUtils.isEmpty(((MediaWrapper)this.h.get(0)).c().h)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onAETavSessionExportCompleted... localMediaInfo.thumbnailPath:");
      ((StringBuilder)localObject1).append(paramLocalMediaInfo.thumbnailPath);
      ((StringBuilder)localObject1).append(" mCoverUrl:");
      ((StringBuilder)localObject1).append(((MediaWrapper)this.h.get(0)).c().h);
      QLog.d("[upload2_QCircleUploadRequest]", 1, ((StringBuilder)localObject1).toString());
      paramLocalMediaInfo.thumbnailPath = ((MediaWrapper)this.h.get(0)).c().h;
    }
    a(paramString, paramLocalMediaInfo);
  }
  
  public void onAETavSessionExportError(String paramString1, int paramInt, String paramString2)
  {
    QLog.d("[upload2_QCircleUploadRequest]", 1, new Object[] { "onAETavSessionExportError... missionId:", paramString1 });
    if (!paramString1.equals(this.v))
    {
      paramString2 = new StringBuilder();
      paramString2.append("onAETavSessionExportError not the same mission this.missionID:");
      paramString2.append(this.v);
      paramString2.append(" missionID:");
      paramString2.append(paramString1);
      QLog.w("[upload2_QCircleUploadRequest]", 1, paramString2.toString());
      return;
    }
    boolean bool = this.f;
    String str = "QQ";
    if (bool)
    {
      paramString2 = new StringBuilder();
      paramString2.append(c());
      paramString2.append(", onAETavSessionExportError... aborted missionID:");
      paramString2.append(paramString1);
      QLog.e("[upload2_QCircleUploadRequest]", 1, paramString2.toString());
      localObject1 = AUploadCommonSetting.a();
      localObject2 = QCirclePublishQualityReporter.P_VIDEO_EXPORT_COST;
      localObject3 = QCircleReportHelper.newEntry("traceid", this.c.M);
      localObject4 = QCircleReportHelper.newEntry("ext6", String.valueOf(this.x));
      localObject5 = new StringBuilder();
      if (this.y) {
        paramString2 = "QQ";
      } else {
        paramString2 = "Peak";
      }
      ((StringBuilder)localObject5).append(paramString2);
      ((StringBuilder)localObject5).append(":");
      ((StringBuilder)localObject5).append(this.z);
      ((IUploadLocalConfig)localObject1).mapReport((String)localObject2, paramString1, Arrays.asList(new FeedCloudCommon.Entry[] { localObject3, localObject4, QCircleReportHelper.newEntry("attach_info", ((StringBuilder)localObject5).toString()), QCircleReportHelper.newEntry("ret_code", "-80000000") }));
      paramString1 = AUploadCommonSetting.a();
      paramString2 = QCirclePublishQualityReporter.E_VIDEO_EXPORT_RESULT;
      localObject1 = QCircleReportHelper.newEntry("traceid", this.c.M);
      localObject2 = QCircleReportHelper.newEntry("ret_code", "-80000000");
      localObject3 = QCircleReportHelper.newEntry("ext6", String.valueOf(this.x));
      localObject4 = new StringBuilder();
      if (!this.y) {
        str = "Peak";
      }
      ((StringBuilder)localObject4).append(str);
      ((StringBuilder)localObject4).append(":");
      ((StringBuilder)localObject4).append(this.z);
      paramString1.uploadQualityReport(paramString2, Arrays.asList(new FeedCloudCommon.Entry[] { localObject1, localObject2, localObject3, QCircleReportHelper.newEntry("attach_info", ((StringBuilder)localObject4).toString()) }));
      return;
    }
    Object localObject2 = AUploadCommonSetting.a();
    Object localObject3 = QCirclePublishQualityReporter.P_VIDEO_EXPORT_COST;
    Object localObject4 = QCircleReportHelper.newEntry("traceid", this.c.M);
    Object localObject5 = QCircleReportHelper.newEntry("ext6", String.valueOf(this.x));
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.y) {
      localObject1 = "QQ";
    } else {
      localObject1 = "Peak";
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(":");
    localStringBuilder.append(this.z);
    ((IUploadLocalConfig)localObject2).mapReport((String)localObject3, paramString1, Arrays.asList(new FeedCloudCommon.Entry[] { localObject4, localObject5, QCircleReportHelper.newEntry("attach_info", localStringBuilder.toString()), QCircleReportHelper.newEntry("ret_code", String.valueOf(paramInt)) }));
    paramString1 = AUploadCommonSetting.a();
    Object localObject1 = QCirclePublishQualityReporter.E_VIDEO_EXPORT_RESULT;
    localObject2 = QCircleReportHelper.newEntry("traceid", this.c.M);
    localObject3 = QCircleReportHelper.newEntry("ret_code", String.valueOf(paramInt));
    paramString2 = QCircleReportHelper.newEntry("desc", paramString2);
    localObject4 = QCircleReportHelper.newEntry("ext6", String.valueOf(this.x));
    localObject5 = new StringBuilder();
    if (!this.y) {
      str = "Peak";
    }
    ((StringBuilder)localObject5).append(str);
    ((StringBuilder)localObject5).append(":");
    ((StringBuilder)localObject5).append(this.z);
    paramString1.uploadQualityReport((String)localObject1, Arrays.asList(new FeedCloudCommon.Entry[] { localObject2, localObject3, paramString2, localObject4, QCircleReportHelper.newEntry("attach_info", ((StringBuilder)localObject5).toString()) }));
    b(10000);
  }
  
  public void onAETavSessionExporting(String paramString, float paramFloat)
  {
    QLog.d("[upload2_QCircleUploadRequest]", 1, new Object[] { "onAETavSessionExporting... missionId:", paramString, " progress:", Float.valueOf(paramFloat) });
    StringBuilder localStringBuilder;
    if (!paramString.equals(this.v))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAETavSessionExporting not the same mission this.missionID:");
      localStringBuilder.append(this.v);
      localStringBuilder.append(" missionID:");
      localStringBuilder.append(paramString);
      QLog.w("[upload2_QCircleUploadRequest]", 1, localStringBuilder.toString());
      return;
    }
    if (this.f)
    {
      RFThreadManager.getSerialThreadHandler().removeCallbacks(this.C);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(c());
      localStringBuilder.append(", onAETavSessionExporting... aborted missionID:");
      localStringBuilder.append(paramString);
      QLog.e("[upload2_QCircleUploadRequest]", 1, localStringBuilder.toString());
      return;
    }
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.C);
    RFThreadManager.getSerialThreadHandler().postDelayed(this.C, A);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.request.PublishUploadRequest
 * JD-Core Version:    0.7.0.1
 */