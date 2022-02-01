package com.tencent.mobileqq.winkpublish.request;

import FileUpload.MultiPicInfo;
import FileUpload.PicExtendInfo;
import FileUpload.UploadPicInfoReq;
import FileUpload.UploadVideoInfoRsp;
import FileUpload.stPoi;
import NS_MOBILE_OPERATION.LbsInfo;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.qq.jce.wup.UniAttribute;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDeviceHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostFileUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.winkpublish.account.LoginData;
import com.tencent.mobileqq.winkpublish.api.IUploadLocalConfig;
import com.tencent.mobileqq.winkpublish.common.AUploadCommonSetting;
import com.tencent.mobileqq.winkpublish.common.IUploadProtocolListener;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.model.ImageInfo;
import com.tencent.mobileqq.winkpublish.model.MediaWrapper;
import com.tencent.mobileqq.winkpublish.model.PublishQueueTaskInfo;
import com.tencent.mobileqq.winkpublish.model.QzoneMediaUploadParams;
import com.tencent.mobileqq.winkpublish.model.ShuoshuoVideoInfo;
import com.tencent.mobileqq.winkpublish.model.UploadVideoObject;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.mobileqq.winkpublish.queue.IUploadQueueListener;
import com.tencent.mobileqq.winkpublish.request.result.UploadFileResponse;
import com.tencent.mobileqq.winkpublish.service.video.util.PublishVideoUtils;
import com.tencent.mobileqq.winkpublish.task.compress.VideoCompressEngine;
import com.tencent.mobileqq.winkpublish.task.compress.VideoCompressTask;
import com.tencent.mobileqq.winkpublish.task.compress.VideoCompressTask.VideoCompressListener;
import com.tencent.mobileqq.winkpublish.task.report.TaskReportInfo.MediaReportInfo;
import com.tencent.mobileqq.winkpublish.util.ExifUtil;
import com.tencent.mobileqq.winkpublish.util.ExtendExifInterface;
import com.tencent.mobileqq.winkpublish.util.PublishUtils;
import com.tencent.mobileqq.winkpublish.util.VideoCompressConfig;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import com.tencent.upload.uinterface.data.ImageUploadResult;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import com.tencent.upload.uinterface.data.VideoUploadResult;
import com.tencent.upload.uinterface.data.VideoUploadTask;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AUploadMediaUploadRequest
  extends AUploadBaseUploadRequest
  implements VideoCompressTask.VideoCompressListener, IUploadTaskCallback
{
  private static final String t;
  private HashMap<String, AUploadMediaUploadRequest.UploadMediaInfo> A = new HashMap();
  private ArrayList<VideoCompressTask> B = new ArrayList();
  private AbstractUploadTask C;
  private AUploadMediaUploadRequest.IMediaUploadListener D;
  public QzoneMediaUploadParams c;
  protected boolean d;
  protected int e;
  protected volatile boolean f;
  protected String g;
  protected List<MediaWrapper> h;
  protected LinkedHashMap<String, AUploadMediaUploadRequest.UploadMediaInfo> i = new LinkedHashMap();
  protected LinkedHashMap<String, AUploadMediaUploadRequest.UploadMediaInfo> j = new LinkedHashMap();
  protected HashMap<String, UploadVideoObject> k = new HashMap();
  protected ArrayList<AbstractUploadTask> l = new ArrayList();
  private int u;
  private int v;
  private volatile int w = 0;
  private int x = 0;
  private int y = 0;
  private long z;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("[upload2_AUploadMediaUploadRequest]");
    t = localStringBuilder.toString();
  }
  
  public AUploadMediaUploadRequest() {}
  
  public AUploadMediaUploadRequest(List<MediaWrapper> paramList, QzoneMediaUploadParams paramQzoneMediaUploadParams, IUploadQueueListener paramIUploadQueueListener, AUploadMediaUploadRequest.IMediaUploadListener paramIMediaUploadListener)
  {
    super((String)null);
    this.c = paramQzoneMediaUploadParams;
    if (this.c == null)
    {
      this.c = new QzoneMediaUploadParams();
      QLog.e(t, 1, "constructor error, uploadParams null, set to default");
    }
    if ((this.c.a == 0) || (this.c.a == 4) || (this.c.a == 5)) {
      this.d = true;
    }
    if (!TextUtils.isEmpty(this.c.b)) {
      c(this.c.b);
    }
    if (!TextUtils.isEmpty(this.c.p)) {
      this.a = this.c.p;
    }
    if (this.c.f == 0L)
    {
      this.c.f = (HostStaticInvokeHelper.getServerTimeMillis() / 1000L);
      paramQzoneMediaUploadParams = t;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(c());
      localStringBuilder.append(", get uploadTime 0, reset to serverTime:");
      localStringBuilder.append(this.c.f);
      QLog.w(paramQzoneMediaUploadParams, 1, localStringBuilder.toString());
    }
    this.z = this.c.c;
    this.g = this.c.d;
    if (paramIUploadQueueListener != null) {
      a(paramIUploadQueueListener);
    }
    if (paramIMediaUploadListener != null) {
      this.D = paramIMediaUploadListener;
    }
    this.h = paramList;
    a(this.h);
    if ((this.i.size() > 0) && (this.j.size() > 0) && (!this.c.t)) {
      this.c.b(true);
    }
  }
  
  private ImageUploadTask a(ImageInfo paramImageInfo, byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramImageInfo, paramArrayOfByte, paramInt, false, false);
  }
  
  private String a(ShuoshuoVideoInfo paramShuoshuoVideoInfo)
  {
    if (paramShuoshuoVideoInfo == null) {
      return null;
    }
    String str2 = paramShuoshuoVideoInfo.h;
    String str1;
    if ((!TextUtils.isEmpty(str2)) && (new File(str2).exists()))
    {
      str1 = str2;
      if (!new File(str2).isDirectory()) {}
    }
    else
    {
      str1 = PublishVideoUtils.a(paramShuoshuoVideoInfo.b);
    }
    return str1;
  }
  
  private void a(int paramInt, String paramString, JceStruct paramJceStruct)
  {
    UniAttribute localUniAttribute = new UniAttribute();
    localUniAttribute.setEncodeName("utf8");
    localUniAttribute.put("ReplyCode", Integer.valueOf(paramInt));
    String str;
    if (paramInt == 0) {
      str = "success";
    } else {
      str = "fail";
    }
    localUniAttribute.put("StrResult", str);
    if (paramJceStruct != null) {
      localUniAttribute.put("response", paramJceStruct);
    }
    this.o.a(localUniAttribute, paramInt, paramInt, paramString, false);
  }
  
  private void a(AbstractUploadTask paramAbstractUploadTask, ImageUploadTask paramImageUploadTask, String paramString)
  {
    if (paramAbstractUploadTask != null)
    {
      if (paramImageUploadTask == null) {
        return;
      }
      paramImageUploadTask.iUploadTime = paramAbstractUploadTask.iUploadTime;
      if (paramImageUploadTask.stExtendInfo == null) {
        paramImageUploadTask.stExtendInfo = new PicExtendInfo();
      }
      if (paramImageUploadTask.stExtendInfo.mapParams == null) {
        paramImageUploadTask.stExtendInfo.mapParams = new HashMap();
      }
      paramImageUploadTask.stExtendInfo.mapParams.put("vid", paramString);
      if (paramImageUploadTask.stExternalMapExt == null) {
        paramImageUploadTask.stExternalMapExt = new HashMap();
      }
      if (this.c.n != null) {
        paramImageUploadTask.stExternalMapExt.putAll(this.c.n);
      }
      paramImageUploadTask.stExternalMapExt.put("is_client_upload_cover", "1");
      paramImageUploadTask.stExternalMapExt.put("is_pic_video_mix_feeds", "1");
      paramAbstractUploadTask = (UploadVideoObject)this.k.get(paramAbstractUploadTask.uploadFilePath);
      if (paramAbstractUploadTask != null)
      {
        paramString = paramImageUploadTask.stExternalMapExt;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAbstractUploadTask.g());
        localStringBuilder.append("");
        paramString.put("mix_videoSize", localStringBuilder.toString());
        paramString = paramImageUploadTask.stExternalMapExt;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAbstractUploadTask.j());
        localStringBuilder.append("");
        paramString.put("mix_isOriginalVideo", localStringBuilder.toString());
        paramString = paramImageUploadTask.stExternalMapExt;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAbstractUploadTask.f());
        localStringBuilder.append("");
        paramString.put("mix_time", localStringBuilder.toString());
        paramImageUploadTask.sPicDesc = paramAbstractUploadTask.e();
      }
      if ((paramImageUploadTask.iDistinctUse == 14301) && (paramImageUploadTask.isCover))
      {
        paramImageUploadTask.iBusiNessType = 0;
        paramImageUploadTask.vBusiNessData = null;
      }
      if (this.c.a()) {
        paramImageUploadTask.vBusiNessData = null;
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AUploadCommonSetting.a().uploadQualityReport(paramString1, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", paramString2), QCircleReportHelper.newEntry("ret_code", paramString3), QCircleReportHelper.newEntry("ext1", paramString4), QCircleReportHelper.newEntry("ext2", String.valueOf(paramInt)) }));
  }
  
  public static final byte[] a(String paramString, Object paramObject)
  {
    if ((paramString != null) && (paramObject != null))
    {
      UniPacket localUniPacket = new UniPacket();
      localUniPacket.setEncodeName("UTF-8");
      localUniPacket.setRequestId(0);
      localUniPacket.setFuncName("FuncName");
      localUniPacket.setServantName("ServantName");
      localUniPacket.put(paramString, paramObject);
      paramString = localUniPacket.encode();
      localUniPacket.clearCacheData();
      return paramString;
    }
    return null;
  }
  
  private void c(byte[] paramArrayOfByte)
  {
    Object localObject1 = this.i.values();
    if ((localObject1 != null) && (!((Collection)localObject1).isEmpty()))
    {
      int m = 0;
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (AUploadMediaUploadRequest.UploadMediaInfo)((Iterator)localObject1).next();
        if (this.f)
        {
          paramArrayOfByte = t;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(c());
          ((StringBuilder)localObject1).append(", doUploadPhoto aborted");
          QLog.e(paramArrayOfByte, 1, ((StringBuilder)localObject1).toString());
          a(QCirclePublishQualityReporter.E_UPLOAD_START, this.c.M, "-80000000", QCircleConstants.y, m);
          return;
        }
        if (localObject2 == null)
        {
          m += 1;
          a(QCirclePublishQualityReporter.E_UPLOAD_START, this.c.M, "-80000001", QCircleConstants.y, m);
        }
        else
        {
          Object localObject3 = a(((AUploadMediaUploadRequest.UploadMediaInfo)localObject2).a.d(), paramArrayOfByte, ((AUploadMediaUploadRequest.UploadMediaInfo)localObject2).b);
          if (localObject3 != null)
          {
            a(QCirclePublishQualityReporter.E_UPLOAD_START, this.c.M, "0", QCircleConstants.y, m);
            a((AbstractUploadTask)localObject3, ((AUploadMediaUploadRequest.UploadMediaInfo)localObject2).b, ((AUploadMediaUploadRequest.UploadMediaInfo)localObject2).d);
          }
          else
          {
            localObject2 = t;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(c());
            ((StringBuilder)localObject3).append(", doUploadPhoto, createImageUploadTask error");
            QLog.e((String)localObject2, 1, ((StringBuilder)localObject3).toString());
            a(QCirclePublishQualityReporter.E_UPLOAD_START, this.c.M, "-80000002", QCircleConstants.y, m);
          }
          m += 1;
        }
      }
    }
  }
  
  private boolean f()
  {
    return false;
  }
  
  private void g()
  {
    try
    {
      Object localObject1 = t;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(c());
      ((StringBuilder)localObject3).append(", cancelAllTasks");
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject3).toString());
      this.f = true;
      if (this.l.size() > 0)
      {
        localObject1 = this.l.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (AbstractUploadTask)((Iterator)localObject1).next();
          UploadServiceBuilder.getInstance().cancel((AbstractUploadTask)localObject3);
          String str = t;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(c());
          localStringBuilder.append(", cancel flowId:");
          localStringBuilder.append(((AbstractUploadTask)localObject3).flowId);
          QLog.i(str, 1, localStringBuilder.toString());
        }
        this.l.clear();
      }
      if (this.B.size() > 0)
      {
        localObject1 = this.B.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((VideoCompressTask)((Iterator)localObject1).next()).cancel();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  protected int a(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    paramString2 = new StringBuilder();
    paramString2.append(str);
    paramString2.append(String.valueOf(paramString1));
    return paramString2.toString().hashCode();
  }
  
  public PublishQueueTaskInfo a(PublishQueueTaskInfo paramPublishQueueTaskInfo)
  {
    if (this.f) {
      return paramPublishQueueTaskInfo;
    }
    VideoCompressTask localVideoCompressTask = VideoCompressEngine.a().b();
    Object localObject1;
    int m;
    if (localVideoCompressTask != null)
    {
      localObject1 = HardCodeUtil.a(2131909566);
      AUploadMediaUploadRequest.UploadMediaInfo localUploadMediaInfo = (AUploadMediaUploadRequest.UploadMediaInfo)this.j.get(localVideoCompressTask.b);
      boolean bool;
      if (localUploadMediaInfo != null) {
        bool = localUploadMediaInfo.a.e();
      } else {
        bool = false;
      }
      if (bool) {
        localObject1 = HardCodeUtil.a(2131909561);
      }
      if (localVideoCompressTask.f())
      {
        double d1 = localVideoCompressTask.h();
        if (d1 == 0.0D)
        {
          localObject2 = "0.00";
        }
        else
        {
          double d2 = 200.0D * (1.0D / (Math.exp(-d1) + 1.0D) - 0.5D);
          d1 = d2;
          if (Double.isNaN(d2)) {
            d1 = 0.0D;
          }
          localObject2 = String.format("%.2f", new Object[] { Double.valueOf(d1) });
        }
        StringBuilder localStringBuilder;
        if (this.j.size() > 1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131909562));
          localStringBuilder.append(this.x + 1);
          localStringBuilder.append(HardCodeUtil.a(2131909557));
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(HardCodeUtil.a(2131909567));
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("%");
          paramPublishQueueTaskInfo.detail = localStringBuilder.toString();
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(HardCodeUtil.a(2131909559));
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("%");
          paramPublishQueueTaskInfo.detail = localStringBuilder.toString();
        }
        paramPublishQueueTaskInfo.showHandleProgress = false;
        paramPublishQueueTaskInfo.progress = 0;
      }
      else
      {
        m = this.y;
        if (m == 0)
        {
          paramPublishQueueTaskInfo.detail = QCircleConfigHelper.a("QZoneTextSetting", "UploadWait", "等待上传");
          paramPublishQueueTaskInfo.progress = 0;
        }
        else if (m == 1)
        {
          if (this.j.size() > 1)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131909558));
            ((StringBuilder)localObject2).append(this.x + 1);
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131909563));
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131909568));
            paramPublishQueueTaskInfo.detail = ((StringBuilder)localObject2).toString();
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131909565));
            paramPublishQueueTaskInfo.detail = ((StringBuilder)localObject2).toString();
          }
        }
      }
      Object localObject2 = localVideoCompressTask.b;
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (new File((String)localObject2).exists()))
      {
        localObject1 = localObject2;
        if (!new File((String)localObject2).isDirectory()) {}
      }
      else
      {
        localObject1 = localObject2;
        if (localUploadMediaInfo != null)
        {
          localObject1 = localObject2;
          if (localUploadMediaInfo.a != null)
          {
            localObject1 = localObject2;
            if (localUploadMediaInfo.a.c() != null) {
              localObject1 = localUploadMediaInfo.a.c().h;
            }
          }
        }
      }
      paramPublishQueueTaskInfo.url = ((String)localObject1);
      paramPublishQueueTaskInfo.showPreviewIcon = true;
    }
    if (TextUtils.isEmpty(paramPublishQueueTaskInfo.url))
    {
      int n = this.w;
      localObject1 = this.h;
      if ((localObject1 != null) && (((List)localObject1).size() > 0) && (n >= 0))
      {
        m = n;
        if (n == this.h.size()) {
          m = n - 1;
        }
        localObject1 = (MediaWrapper)this.h.get(m);
        if (localObject1 != null)
        {
          if (((MediaWrapper)localObject1).b())
          {
            paramPublishQueueTaskInfo.url = ((MediaWrapper)localObject1).d().a;
            return paramPublishQueueTaskInfo;
          }
          if (((MediaWrapper)localObject1).a())
          {
            paramPublishQueueTaskInfo.url = ((MediaWrapper)localObject1).c().h;
            paramPublishQueueTaskInfo.showPreviewIcon = true;
          }
        }
      }
    }
    return paramPublishQueueTaskInfo;
  }
  
  protected AbstractUploadTask a(ShuoshuoVideoInfo paramShuoshuoVideoInfo, byte[] paramArrayOfByte, int paramInt)
  {
    if (this.f)
    {
      paramShuoshuoVideoInfo = t;
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(c());
      paramArrayOfByte.append(", createVideoUploadTask after aborted, return null!");
      QLog.e(paramShuoshuoVideoInfo, 1, paramArrayOfByte.toString());
      return null;
    }
    if (paramShuoshuoVideoInfo == null)
    {
      paramShuoshuoVideoInfo = t;
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(c());
      paramArrayOfByte.append(", createVideoUploadTask with null videoInfo, return null!");
      QLog.e(paramShuoshuoVideoInfo, 1, paramArrayOfByte.toString());
      return null;
    }
    UploadVideoObject localUploadVideoObject = UploadVideoObject.a(paramShuoshuoVideoInfo);
    Object localObject = paramShuoshuoVideoInfo.b;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!PublishUtils.a((String)localObject))) {
      localUploadVideoObject.a = ((String)localObject);
    }
    this.k.put(localUploadVideoObject.a(), localUploadVideoObject);
    localObject = new VideoUploadTask(localUploadVideoObject.a());
    int m;
    if (this.c.k > 0) {
      m = this.c.k;
    } else {
      m = localUploadVideoObject.i();
    }
    ((VideoUploadTask)localObject).iIsNew = m;
    ((VideoUploadTask)localObject).flowId = a(this.c.d, localUploadVideoObject.a());
    ((VideoUploadTask)localObject).iUin = LoginData.a().b();
    ((VideoUploadTask)localObject).sRefer = "mqq";
    ((VideoUploadTask)localObject).vLoginData = paramArrayOfByte;
    ((VideoUploadTask)localObject).md5 = localUploadVideoObject.b();
    ((VideoUploadTask)localObject).sTitle = localUploadVideoObject.d();
    ((VideoUploadTask)localObject).sDesc = localUploadVideoObject.e();
    ((VideoUploadTask)localObject).iFlag = localUploadVideoObject.c();
    ((VideoUploadTask)localObject).sCoverUrl = localUploadVideoObject.h();
    ((VideoUploadTask)localObject).iPlayTime = ((int)localUploadVideoObject.f());
    ((VideoUploadTask)localObject).iUploadTime = (this.c.f - paramInt);
    ((VideoUploadTask)localObject).iBusiNessType = this.c.l;
    if (this.c.o) {
      paramArrayOfByte = this.c.m;
    } else {
      paramArrayOfByte = a(this.e, paramInt, ((VideoUploadTask)localObject).iUploadTime, localUploadVideoObject);
    }
    ((VideoUploadTask)localObject).vBusiNessData = paramArrayOfByte;
    ((VideoUploadTask)localObject).iIsOriginalVideo = localUploadVideoObject.j();
    ((VideoUploadTask)localObject).iIsFormatF20 = localUploadVideoObject.k();
    ((VideoUploadTask)localObject).uploadEntrance = this.c.e;
    ((VideoUploadTask)localObject).uploadTaskCallback = this;
    if (this.c.H)
    {
      ((VideoUploadTask)localObject).setInnerAppid("qq_story_video");
      ((VideoUploadTask)localObject).iSync = 0;
    }
    a((AbstractUploadTask)localObject, paramShuoshuoVideoInfo);
    ((VideoUploadTask)localObject).extend_info = new HashMap();
    ((VideoUploadTask)localObject).extend_info.put("video_type", UploadVideoObject.b(paramShuoshuoVideoInfo));
    a((AbstractUploadTask)localObject, this.c.e);
    paramShuoshuoVideoInfo = t;
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append(c());
    paramArrayOfByte.append(", createVideoUploadTask finish. videoPath:");
    paramArrayOfByte.append(((VideoUploadTask)localObject).uploadFilePath);
    paramArrayOfByte.append(", flowId:");
    paramArrayOfByte.append(((VideoUploadTask)localObject).flowId);
    paramArrayOfByte.append(", index: ");
    paramArrayOfByte.append(paramInt);
    paramArrayOfByte.append(", iUploadTime:");
    paramArrayOfByte.append(((VideoUploadTask)localObject).iUploadTime);
    QLog.i(paramShuoshuoVideoInfo, 1, paramArrayOfByte.toString());
    return localObject;
  }
  
  protected ImageUploadTask a(ImageInfo paramImageInfo, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.f)
    {
      paramImageInfo = t;
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(c());
      paramArrayOfByte.append(", createImageUploadTask after aborted, return null!");
      QLog.e(paramImageInfo, 1, paramArrayOfByte.toString());
      return null;
    }
    if (paramImageInfo == null)
    {
      paramImageInfo = t;
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(c());
      paramArrayOfByte.append(", createImageUploadTask with null imageInfo, return null!");
      QLog.e(paramImageInfo, 1, paramArrayOfByte.toString());
      return null;
    }
    Object localObject = paramImageInfo.a;
    int n = 0;
    localObject = new ImageUploadTask(false, (String)localObject);
    ((ImageUploadTask)localObject).uploadTaskCallback = this;
    ((ImageUploadTask)localObject).iUin = LoginData.a().b();
    ((ImageUploadTask)localObject).sRefer = "mqq";
    ((ImageUploadTask)localObject).vLoginData = paramArrayOfByte;
    ((ImageUploadTask)localObject).md5 = a(paramImageInfo.a);
    ((ImageUploadTask)localObject).sAlbumName = "";
    ((ImageUploadTask)localObject).flowId = a((int)this.c.c, paramImageInfo.a);
    ((ImageUploadTask)localObject).uploadEntrance = this.c.e;
    ((ImageUploadTask)localObject).sPicTitle = "";
    ((ImageUploadTask)localObject).sPicDesc = this.c.i;
    ((ImageUploadTask)localObject).bWaterType = this.c.j;
    ((ImageUploadTask)localObject).autoRotate = this.d;
    ((ImageUploadTask)localObject).clientFakeKey = this.c.d;
    ((ImageUploadTask)localObject).uploadPoi = this.c.w;
    ((ImageUploadTask)localObject).iBusiNessType = this.c.l;
    if (((ImageUploadTask)localObject).iBusiNessType == 1) {
      ((ImageUploadTask)localObject).vBusiNessData = this.c.m;
    }
    paramArrayOfByte = new MultiPicInfo();
    if (this.c.u > 0) {
      m = this.c.u;
    } else {
      m = this.e;
    }
    paramArrayOfByte.iBatUploadNum = m;
    if (this.c.v >= 0) {
      m = this.c.v;
    } else {
      m = paramInt;
    }
    paramArrayOfByte.iCurUpload = m;
    ((ImageUploadTask)localObject).mutliPicInfo = paramArrayOfByte;
    ((ImageUploadTask)localObject).iUploadTime = (this.c.f - paramInt);
    ((ImageUploadTask)localObject).iUploadType = this.c.h;
    ((ImageUploadTask)localObject).iBatchID = this.c.c;
    int m = n;
    if (this.e > 0) {
      m = 1;
    }
    ((ImageUploadTask)localObject).iUpPicType = m;
    a((ImageUploadTask)localObject, this.c.a);
    a((ImageUploadTask)localObject, this.c, paramImageInfo, paramBoolean1, false);
    a((AbstractUploadTask)localObject, this.c.e);
    paramImageInfo = t;
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append(c());
    paramArrayOfByte.append(", createImageUploadTask finish, picPath:");
    paramArrayOfByte.append(((ImageUploadTask)localObject).uploadFilePath);
    paramArrayOfByte.append(", flowId:");
    paramArrayOfByte.append(((ImageUploadTask)localObject).flowId);
    paramArrayOfByte.append(", index: ");
    paramArrayOfByte.append(paramInt);
    paramArrayOfByte.append(", iUploadTime:");
    paramArrayOfByte.append(((ImageUploadTask)localObject).iUploadTime);
    QLog.i(paramImageInfo, 1, paramArrayOfByte.toString());
    return localObject;
  }
  
  public void a(VideoCompressTask paramVideoCompressTask)
  {
    if ((paramVideoCompressTask != null) && (!TextUtils.isEmpty(paramVideoCompressTask.b)))
    {
      if (!this.j.containsKey(paramVideoCompressTask.b)) {
        return;
      }
      paramVideoCompressTask = (AUploadMediaUploadRequest.UploadMediaInfo)this.j.get(paramVideoCompressTask.b);
      if ((paramVideoCompressTask != null) && (paramVideoCompressTask.g != null)) {
        paramVideoCompressTask.g.e = System.currentTimeMillis();
      }
    }
  }
  
  public void a(VideoCompressTask paramVideoCompressTask, double paramDouble)
  {
    if ((paramVideoCompressTask != null) && (this.D != null))
    {
      paramVideoCompressTask = (AUploadMediaUploadRequest.UploadMediaInfo)this.j.get(paramVideoCompressTask.b);
      if (paramVideoCompressTask != null) {
        this.D.a(paramVideoCompressTask.d, paramVideoCompressTask.b, paramDouble);
      }
    }
  }
  
  public void a(VideoCompressTask paramVideoCompressTask, int paramInt)
  {
    this.B.remove(paramVideoCompressTask);
    Object localObject1 = paramVideoCompressTask.b;
    Object localObject2 = (AUploadMediaUploadRequest.UploadMediaInfo)this.j.get(localObject1);
    ShuoshuoVideoInfo localShuoshuoVideoInfo = paramVideoCompressTask.b();
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (new File((String)localObject1).exists()) && (!((String)localObject1).equals(localShuoshuoVideoInfo.b))) {
      localShuoshuoVideoInfo.b = ((String)localObject1);
    }
    if ((!this.f) && (PublishUtils.a(localShuoshuoVideoInfo)))
    {
      localObject1 = t;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(c());
      ((StringBuilder)localObject2).append(", onCompressFailed errorCode:");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(", videoPath:");
      ((StringBuilder)localObject2).append(localShuoshuoVideoInfo.b);
      ((StringBuilder)localObject2).append(", upload video without compress");
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("video_source_path", localShuoshuoVideoInfo.b);
      a(paramVideoCompressTask, (Intent)localObject1);
      VideoCompressEngine.a().b(paramVideoCompressTask);
      return;
    }
    String str = t;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append(", onCompressFailed errorCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", videoPath:");
    localStringBuilder.append(localShuoshuoVideoInfo.b);
    localStringBuilder.append(", do not upload");
    QLog.e(str, 1, localStringBuilder.toString());
    this.y = 1;
    g();
    if ((this.s.getState() != 2) || (!paramVideoCompressTask.m()))
    {
      paramVideoCompressTask = new StringBuilder();
      paramVideoCompressTask.append(HardCodeUtil.a(2131909560));
      paramVideoCompressTask.append(this.x + 1);
      paramVideoCompressTask.append(HardCodeUtil.a(2131909564));
      a(paramInt, paramVideoCompressTask.toString(), null);
    }
    paramVideoCompressTask = this.D;
    if (paramVideoCompressTask != null)
    {
      int m;
      if (localObject2 != null) {
        m = ((AUploadMediaUploadRequest.UploadMediaInfo)localObject2).b;
      } else {
        m = -1;
      }
      paramVideoCompressTask.a((String)localObject1, m, paramInt, "");
    }
  }
  
  public void a(VideoCompressTask paramVideoCompressTask, Intent paramIntent)
  {
    if (this.f) {
      return;
    }
    this.B.remove(paramVideoCompressTask);
    this.y = 0;
    this.x += 1;
    paramIntent = paramIntent.getStringExtra("video_source_path");
    Object localObject1 = (AUploadMediaUploadRequest.UploadMediaInfo)this.j.get(paramIntent);
    if (localObject1 == null)
    {
      paramVideoCompressTask = t;
      paramIntent = new StringBuilder();
      paramIntent.append(c());
      paramIntent.append(", onCompressSuccess but get UploadMediaInfo fail path = ");
      paramIntent.append(localObject1);
      QLog.i(paramVideoCompressTask, 1, paramIntent.toString());
      return;
    }
    boolean bool = ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).a.e();
    Object localObject2 = paramVideoCompressTask.b();
    this.A.put(((ShuoshuoVideoInfo)localObject2).b, localObject1);
    Object localObject3 = t;
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(c());
    ((StringBuilder)localObject4).append(", onCompressSuccess srcPath:");
    ((StringBuilder)localObject4).append(((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).d);
    ((StringBuilder)localObject4).append(", destPath:");
    ((StringBuilder)localObject4).append(((ShuoshuoVideoInfo)localObject2).b);
    QLog.i((String)localObject3, 1, ((StringBuilder)localObject4).toString());
    if ((!bool) && (((ShuoshuoVideoInfo)localObject2).o > 0L)) {
      ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).c = PublishVideoUtils.a(((ShuoshuoVideoInfo)localObject2).b);
    }
    ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).g.f = System.currentTimeMillis();
    localObject3 = new File(((ShuoshuoVideoInfo)localObject2).b);
    if (((File)localObject3).exists()) {
      ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).g.d = (((File)localObject3).length() / 1024L);
    }
    localObject3 = this.D;
    if (localObject3 != null) {
      ((AUploadMediaUploadRequest.IMediaUploadListener)localObject3).a(((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).d, ((ShuoshuoVideoInfo)localObject2).b, ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).e);
    }
    if ((this.s != null) && (this.s.getState() == 1))
    {
      if (bool)
      {
        localObject2 = new ImageInfo(((ShuoshuoVideoInfo)localObject2).b);
        if (!this.i.containsKey(((ImageInfo)localObject2).a))
        {
          localObject3 = new MediaWrapper((ImageInfo)localObject2);
          localObject4 = new AUploadMediaUploadRequest.UploadMediaInfo(this);
          ((AUploadMediaUploadRequest.UploadMediaInfo)localObject4).a = ((MediaWrapper)localObject3);
          ((AUploadMediaUploadRequest.UploadMediaInfo)localObject4).b = ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).b;
          ((AUploadMediaUploadRequest.UploadMediaInfo)localObject4).e = ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).e;
          ((AUploadMediaUploadRequest.UploadMediaInfo)localObject4).d = ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).d;
          this.i.put(((ImageInfo)localObject2).a, localObject4);
        }
        localObject2 = a((ImageInfo)localObject2, LoginData.a().e(), ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).b);
        if (localObject2 == null)
        {
          paramVideoCompressTask = t;
          paramIntent = new StringBuilder();
          paramIntent.append(c());
          paramIntent.append(", onCompressSuccess, createImageUploadTask[gif] error, return");
          QLog.e(paramVideoCompressTask, 1, paramIntent.toString());
          return;
        }
        localObject3 = t;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(c());
        ((StringBuilder)localObject4).append(", validAndUpload gif, path:");
        ((StringBuilder)localObject4).append(((AbstractUploadTask)localObject2).uploadFilePath);
        ((StringBuilder)localObject4).append(", flowId:");
        ((StringBuilder)localObject4).append(((AbstractUploadTask)localObject2).flowId);
        QLog.i((String)localObject3, 1, ((StringBuilder)localObject4).toString());
        a((AbstractUploadTask)localObject2, ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).b, ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).d);
      }
      else
      {
        localObject2 = a((ShuoshuoVideoInfo)localObject2, LoginData.a().e(), ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).b);
        if (localObject2 == null)
        {
          paramVideoCompressTask = t;
          paramIntent = new StringBuilder();
          paramIntent.append(c());
          paramIntent.append(", onCompressSuccess, createVideoUploadTask error, return");
          QLog.e(paramVideoCompressTask, 1, paramIntent.toString());
          return;
        }
        localObject3 = t;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(c());
        ((StringBuilder)localObject4).append(", validAndUpload, path:");
        ((StringBuilder)localObject4).append(((AbstractUploadTask)localObject2).uploadFilePath);
        ((StringBuilder)localObject4).append(", flowId:");
        ((StringBuilder)localObject4).append(((AbstractUploadTask)localObject2).flowId);
        QLog.i((String)localObject3, 1, ((StringBuilder)localObject4).toString());
        a((AbstractUploadTask)localObject2, ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).b, ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).d);
      }
    }
    else
    {
      localObject1 = t;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(c());
      ((StringBuilder)localObject2).append(" don't in running state, upload paused");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if ((paramVideoCompressTask.g) && (!TextUtils.isEmpty(paramIntent)) && (PublishUtils.a(paramIntent))) {
      try
      {
        paramVideoCompressTask = t;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(c());
        ((StringBuilder)localObject1).append(", delete directory file, path:");
        ((StringBuilder)localObject1).append(paramIntent);
        QLog.i(paramVideoCompressTask, 1, ((StringBuilder)localObject1).toString());
        HostFileUtils.deleteFile(new File(paramIntent));
        return;
      }
      catch (Exception paramVideoCompressTask)
      {
        QLog.w(t, 1, paramVideoCompressTask.getMessage());
      }
    }
  }
  
  protected void a(AbstractUploadTask paramAbstractUploadTask, int paramInt)
  {
    if (paramAbstractUploadTask == null) {
      return;
    }
    if (paramInt != 19)
    {
      if ((paramInt != 45) && (paramInt != 207)) {}
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          return;
        }
        paramAbstractUploadTask.entry = "shoushuo";
        return;
      }
    }
    paramAbstractUploadTask.entry = "album";
  }
  
  protected void a(AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString)
  {
    this.l.add(paramAbstractUploadTask);
    Object localObject;
    if (a(paramAbstractUploadTask))
    {
      localObject = this.D;
      if (localObject != null) {
        ((AUploadMediaUploadRequest.IMediaUploadListener)localObject).a(paramInt, paramString, paramAbstractUploadTask.uploadFilePath);
      }
    }
    else
    {
      localObject = t;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(c());
      localStringBuilder.append(", validAndUpload fail, srcPath:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", flowId:");
      localStringBuilder.append(paramAbstractUploadTask.flowId);
      QLog.e((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  protected void a(AbstractUploadTask paramAbstractUploadTask, ShuoshuoVideoInfo paramShuoshuoVideoInfo)
  {
    if (paramShuoshuoVideoInfo != null)
    {
      Object localObject = paramShuoshuoVideoInfo.u;
      boolean bool = false;
      if (localObject != null) {
        bool = paramShuoshuoVideoInfo.u.getBoolean("video_is_sync_to_weishi", false);
      }
      paramAbstractUploadTask.isSyncWeishi = bool;
      if (paramAbstractUploadTask.isSyncWeishi)
      {
        paramAbstractUploadTask.sDevIMEI = QCircleHostDeviceHelper.getIMEI();
        if ((paramAbstractUploadTask instanceof ImageUploadTask))
        {
          localObject = (ImageUploadTask)paramAbstractUploadTask;
          if ((this.c.E != null) && (((ImageUploadTask)localObject).stExtendInfo != null) && (((ImageUploadTask)localObject).stExtendInfo.mapParams != null))
          {
            ((ImageUploadTask)localObject).stExternalMapExt.put("geo_x_choose", String.valueOf(this.c.E.lbs_x));
            ((ImageUploadTask)localObject).stExternalMapExt.put("geo_y_choose", String.valueOf(this.c.E.lbs_y));
          }
          if (paramShuoshuoVideoInfo.v == null) {
            paramAbstractUploadTask = "";
          } else {
            paramAbstractUploadTask = paramShuoshuoVideoInfo.v;
          }
          ((ImageUploadTask)localObject).sPicDesc = paramAbstractUploadTask;
        }
      }
    }
  }
  
  protected void a(ImageUploadTask paramImageUploadTask, int paramInt)
  {
    if (paramImageUploadTask == null) {
      return;
    }
    int m = 7;
    int i1 = 0;
    int n = 0;
    if (paramInt == 4)
    {
      if ((paramImageUploadTask.iBusiNessType != 0) && (!this.c.s)) {
        paramImageUploadTask.iSync = 1;
      } else {
        paramImageUploadTask.iSync = 0;
      }
      if (!this.c.H) {
        n = paramImageUploadTask.iSync;
      }
      paramImageUploadTask.iSync = n;
      paramImageUploadTask.sAlbumID = "";
      if (this.c.y != -1) {
        m = this.c.y;
      }
      paramImageUploadTask.iAlbumTypeID = m;
    }
    else if ((paramInt != 1) && (paramInt != 3))
    {
      paramImageUploadTask.iSync = 1;
      if (TextUtils.isEmpty(this.c.g))
      {
        if (this.c.y != -1) {
          m = this.c.y;
        } else {
          m = 1;
        }
        paramImageUploadTask.iAlbumTypeID = m;
      }
      else
      {
        m = i1;
        if (this.c.y != -1) {
          m = this.c.y;
        }
        paramImageUploadTask.iAlbumTypeID = m;
        paramImageUploadTask.sAlbumID = this.c.g;
      }
    }
    else
    {
      paramImageUploadTask.iSync = 0;
      paramImageUploadTask.sAlbumID = "";
      if (this.c.y != -1) {
        m = this.c.y;
      }
      paramImageUploadTask.iAlbumTypeID = m;
    }
    if (paramInt == 0)
    {
      paramImageUploadTask.iDistinctUse = 14301;
      return;
    }
    if (paramInt == 1)
    {
      paramImageUploadTask.iDistinctUse = 14302;
      return;
    }
    if ((paramInt == 4) || (paramInt == 3)) {
      paramImageUploadTask.iDistinctUse = 14303;
    }
  }
  
  protected void a(ImageUploadTask paramImageUploadTask, QzoneMediaUploadParams paramQzoneMediaUploadParams, ImageInfo paramImageInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1;
    if (paramImageUploadTask != null)
    {
      if (paramQzoneMediaUploadParams == null) {
        return;
      }
      if (paramImageUploadTask.stExtendInfo == null) {
        paramImageUploadTask.stExtendInfo = new PicExtendInfo();
      }
      if (paramImageUploadTask.stExtendInfo.mapParams == null) {
        paramImageUploadTask.stExtendInfo.mapParams = new HashMap();
      }
      if (paramImageUploadTask.stExternalMapExt == null) {
        paramImageUploadTask.stExternalMapExt = new HashMap();
      }
      boolean bool = paramQzoneMediaUploadParams.t;
      str1 = "1";
      if (bool) {
        paramImageUploadTask.stExternalMapExt.put("is_pic_video_mix_feeds", "1");
      }
      if ((paramQzoneMediaUploadParams.B != null) && (paramQzoneMediaUploadParams.B.size() > 0)) {
        paramImageUploadTask.stExternalMapExt.putAll(paramQzoneMediaUploadParams.B);
      }
    }
    try
    {
      if (JpegExifReader.isCrashJpeg(paramImageUploadTask.uploadFilePath)) {
        break label191;
      }
      localObject = new ExtendExifInterface(paramImageUploadTask.uploadFilePath);
      paramImageUploadTask.stExtendInfo.mapExif = ExifUtil.a((ExtendExifInterface)localObject);
      paramImageUploadTask.exifTime = a((ExtendExifInterface)localObject, paramImageUploadTask.uploadFilePath);
    }
    catch (Exception localException)
    {
      Object localObject;
      label181:
      Iterator localIterator;
      break label181;
    }
    QLog.e(t, 1, "read pic exif error");
    label191:
    if ((!paramBoolean1) && (!f()))
    {
      if (paramImageInfo.f != null) {
        a(paramImageUploadTask, paramImageInfo.f);
      } else {
        a(paramImageUploadTask);
      }
    }
    else {
      a(paramImageUploadTask, paramQzoneMediaUploadParams.C);
    }
    localObject = new HashMap();
    if ((paramImageInfo != null) && (paramImageInfo.h != null) && (paramImageInfo.h.size() > 0))
    {
      localIterator = paramImageInfo.h.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        ((HashMap)localObject).put(str2, (byte[])paramImageInfo.h.get(str2));
      }
    }
    if ((paramQzoneMediaUploadParams.z != null) && (paramQzoneMediaUploadParams.z.containsKey(paramImageInfo.a))) {
      ((HashMap)localObject).put("mark_uin_upload", paramQzoneMediaUploadParams.z.get(paramImageInfo.a));
    } else {
      ((HashMap)localObject).put("mark_uin_upload", new byte[0]);
    }
    paramImageUploadTask.mExternalByteData = ((HashMap)localObject);
    if ((paramQzoneMediaUploadParams.D != null) && (paramQzoneMediaUploadParams.D.size() > 0)) {
      paramImageUploadTask.mExternalByteData.putAll(paramQzoneMediaUploadParams.D);
    }
    if ((paramQzoneMediaUploadParams.A != null) && (paramQzoneMediaUploadParams.A.containsKey(paramImageInfo.a)))
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("youtu_tag_array", paramQzoneMediaUploadParams.A.get(paramImageInfo.a));
      paramImageUploadTask.stExternalMapExt.putAll((Map)localObject);
    }
    if ((paramImageInfo != null) && (paramImageInfo.g != null) && (paramImageInfo.g.size() > 0)) {
      paramImageUploadTask.stExternalMapExt.putAll(paramImageInfo.g);
    }
    if (!TextUtils.isEmpty(paramQzoneMediaUploadParams.x)) {
      paramImageUploadTask.stExtendInfo.mapParams.put("open_appid", paramQzoneMediaUploadParams.x);
    }
    if (paramQzoneMediaUploadParams.w != null)
    {
      paramImageUploadTask.stExtendInfo.mapParams.put("show_geo", String.valueOf(paramQzoneMediaUploadParams.w.show_poi));
      if (QLog.isDevelopLevel())
      {
        paramImageInfo = t;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(", show_geo:");
        ((StringBuilder)localObject).append(paramQzoneMediaUploadParams.w.show_poi);
        QLog.d(paramImageInfo, 4, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      paramImageUploadTask.stExtendInfo.mapParams.put("show_geo", "0");
      if (QLog.isDevelopLevel()) {
        QLog.d(t, 4, ", show_geo:0");
      }
    }
    if (paramBoolean2)
    {
      QLog.d(t, 1, new Object[] { "setExtendInfoParams... hasSelectCover:", Boolean.valueOf(paramQzoneMediaUploadParams.L) });
      paramImageInfo = paramImageUploadTask.stExtendInfo.mapParams;
      if (paramQzoneMediaUploadParams.L) {
        paramImageUploadTask = str1;
      } else {
        paramImageUploadTask = "0";
      }
      paramImageInfo.put("user_select_cover", paramImageUploadTask);
    }
  }
  
  protected void a(ImageUploadTask paramImageUploadTask, Object paramObject)
  {
    this.w += 1;
    Object localObject2 = (AUploadMediaUploadRequest.UploadMediaInfo)this.i.get(paramImageUploadTask.uploadFilePath);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramImageUploadTask.mOriginFilePath)) {
        localObject1 = (AUploadMediaUploadRequest.UploadMediaInfo)this.i.get(paramImageUploadTask.mOriginFilePath);
      }
    }
    if ((localObject1 != null) && (((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).g != null))
    {
      ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).g.e = paramImageUploadTask.compressStartTime;
      ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).g.f = paramImageUploadTask.compressEndTime;
      localObject2 = this.D;
      if (localObject2 != null) {
        ((AUploadMediaUploadRequest.IMediaUploadListener)localObject2).a(((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).g);
      }
    }
    if (paramImageUploadTask.isCover) {
      localObject2 = (AUploadMediaUploadRequest.UploadMediaInfo)this.j.get(paramImageUploadTask.srcVideoPath);
    } else {
      localObject2 = null;
    }
    if ((paramObject instanceof ImageUploadResult))
    {
      Object localObject4 = (ImageUploadResult)paramObject;
      UploadFileResponse localUploadFileResponse = new UploadFileResponse();
      localUploadFileResponse.albumId = ((ImageUploadResult)localObject4).sAlbumID;
      localUploadFileResponse.height = ((ImageUploadResult)localObject4).iHeight;
      localUploadFileResponse.width = ((ImageUploadResult)localObject4).iWidth;
      localUploadFileResponse.photoId = ((ImageUploadResult)localObject4).sPhotoID;
      localUploadFileResponse.slocId = ((ImageUploadResult)localObject4).sSloc;
      localUploadFileResponse.originId = ((ImageUploadResult)localObject4).sOriPhotoID;
      localUploadFileResponse.oheight = ((ImageUploadResult)localObject4).iOriHeight;
      localUploadFileResponse.owidth = ((ImageUploadResult)localObject4).iOriWidth;
      localUploadFileResponse.url = ((ImageUploadResult)localObject4).sBURL;
      localUploadFileResponse.picType = ((ImageUploadResult)localObject4).iPicType;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(LoginData.a().b());
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append(paramImageUploadTask.iUploadTime);
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append(this.c.d);
      localUploadFileResponse.clientFakeKey = ((StringBuilder)localObject3).toString();
      if (localObject1 != null) {
        localObject3 = ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).d;
      } else {
        localObject3 = "";
      }
      localUploadFileResponse.originUploadUrl = ((String)localObject3);
      localUploadFileResponse.md5 = ((ImageUploadResult)localObject4).sPhotoMD5;
      if (localObject1 != null) {
        ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).f = localUploadFileResponse;
      }
      if (this.D != null)
      {
        int m;
        if (localObject1 != null) {
          m = ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).e;
        } else if (localObject2 != null) {
          m = ((AUploadMediaUploadRequest.UploadMediaInfo)localObject2).e;
        } else {
          m = 0;
        }
        localObject3 = this.D;
        localObject4 = ((ImageUploadResult)localObject4).sPhotoID;
        if (localObject1 != null) {
          localObject1 = ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).d;
        } else {
          localObject1 = null;
        }
        ((AUploadMediaUploadRequest.IMediaUploadListener)localObject3).a(localUploadFileResponse, paramImageUploadTask, m, (String)localObject4, (String)localObject1, paramImageUploadTask.uploadFilePath);
      }
      if (this.s != null) {
        this.s.a(paramObject);
      }
      if (this.w >= this.e)
      {
        paramObject = localUploadFileResponse;
        if (paramImageUploadTask.isCover)
        {
          paramObject = localUploadFileResponse;
          if (localObject2 != null) {
            paramObject = ((AUploadMediaUploadRequest.UploadMediaInfo)localObject2).f;
          }
        }
        a(0, "", paramObject);
      }
    }
  }
  
  protected void a(VideoUploadTask paramVideoUploadTask, Object paramObject)
  {
    Object localObject2 = (AUploadMediaUploadRequest.UploadMediaInfo)this.j.get(paramVideoUploadTask.uploadFilePath);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (AUploadMediaUploadRequest.UploadMediaInfo)this.A.get(paramVideoUploadTask.uploadFilePath);
    }
    if (localObject1 == null)
    {
      paramObject = t;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(c());
      ((StringBuilder)localObject1).append(", get MediaOrderInfo fail path = ");
      ((StringBuilder)localObject1).append(paramVideoUploadTask.uploadFilePath);
      ((StringBuilder)localObject1).append(", flowId:");
      ((StringBuilder)localObject1).append(paramVideoUploadTask.flowId);
      QLog.i(paramObject, 1, ((StringBuilder)localObject1).toString());
      return;
    }
    if (((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).g != null)
    {
      localObject2 = this.D;
      if (localObject2 != null) {
        ((AUploadMediaUploadRequest.IMediaUploadListener)localObject2).a(((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).g);
      }
    }
    Object localObject3 = (VideoUploadResult)paramObject;
    localObject2 = new UploadVideoInfoRsp();
    ((UploadVideoInfoRsp)localObject2).iBusiNessType = ((VideoUploadResult)localObject3).iBusiNessType;
    ((UploadVideoInfoRsp)localObject2).sVid = ((VideoUploadResult)localObject3).sVid;
    ((UploadVideoInfoRsp)localObject2).vBusiNessData = ((VideoUploadResult)localObject3).vBusiNessData;
    localObject3 = ((UploadVideoInfoRsp)localObject2).sVid;
    ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).f = ((JceStruct)localObject2);
    MediaWrapper localMediaWrapper = ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).a;
    Object localObject4 = (UploadVideoObject)this.k.get(paramVideoUploadTask.uploadFilePath);
    if ((localObject4 != null) && (TextUtils.isEmpty(((UploadVideoObject)localObject4).a)) && (localMediaWrapper != null) && (localMediaWrapper.a()) && (localMediaWrapper.c().m == 0) && (!PublishUtils.a(paramVideoUploadTask.uploadFilePath)))
    {
      ((UploadVideoObject)localObject4).a = paramVideoUploadTask.uploadFilePath;
      ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).d = paramVideoUploadTask.uploadFilePath;
    }
    localObject4 = this.D;
    if (localObject4 != null) {
      ((AUploadMediaUploadRequest.IMediaUploadListener)localObject4).a((JceStruct)localObject2, paramVideoUploadTask, ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).e, (String)localObject3, ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).d, paramVideoUploadTask.uploadFilePath);
    }
    if (this.s != null) {
      this.s.a(paramObject);
    }
    boolean bool1 = this.c.q;
    boolean bool2 = false;
    if (bool1)
    {
      localObject2 = ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).c;
      paramObject = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramObject = t;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(c());
        ((StringBuilder)localObject2).append(", coverPath == null, reget cover, videoPath:");
        ((StringBuilder)localObject2).append(paramVideoUploadTask.uploadFilePath);
        ((StringBuilder)localObject2).append(", flowId:");
        ((StringBuilder)localObject2).append(paramVideoUploadTask.flowId);
        QLog.i(paramObject, 1, ((StringBuilder)localObject2).toString());
        paramObject = PublishVideoUtils.a(paramVideoUploadTask.uploadFilePath);
      }
      localObject2 = t;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(c());
      ((StringBuilder)localObject4).append(", create VideoCover Upload Task, videoPath:");
      ((StringBuilder)localObject4).append(paramVideoUploadTask.uploadFilePath);
      ((StringBuilder)localObject4).append(", coverPath:");
      ((StringBuilder)localObject4).append(paramObject);
      QLog.i((String)localObject2, 1, ((StringBuilder)localObject4).toString());
      localObject2 = ImageInfo.a(paramObject);
      if (f())
      {
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if (localObject2 != null)
        {
          ((ImageInfo)localObject2).f = b(((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).d);
          bool1 = bool2;
        }
      }
      localObject2 = a((ImageInfo)localObject2, LoginData.a().e(), ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).b, bool1, true);
      if (localObject2 == null)
      {
        localObject1 = FSUploadConst.a(1707);
        b(1707, (String)localObject1);
        localObject2 = t;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(c());
        ((StringBuilder)localObject3).append(", create VideoCover Upload Task failed msg:");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(", videoPath:");
        ((StringBuilder)localObject3).append(paramVideoUploadTask.uploadFilePath);
        ((StringBuilder)localObject3).append(", coverPath:");
        ((StringBuilder)localObject3).append(paramObject);
        QLog.e((String)localObject2, 1, ((StringBuilder)localObject3).toString());
        a(QCirclePublishQualityReporter.E_UPLOAD_RESULT, this.c.M, "-80000005", QCircleConstants.x, 0);
        return;
      }
      ((ImageUploadTask)localObject2).isCover = true;
      ((ImageUploadTask)localObject2).srcVideoPath = ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).d;
      a(paramVideoUploadTask, (ImageUploadTask)localObject2, (String)localObject3);
      a((ImageUploadTask)localObject2, ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).d);
      if ((localMediaWrapper != null) && (localMediaWrapper.a())) {
        a((AbstractUploadTask)localObject2, localMediaWrapper.c());
      }
      a(QCirclePublishQualityReporter.E_UPLOAD_START, this.c.M, "0", QCircleConstants.y, 0);
      a((AbstractUploadTask)localObject2, ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).b, ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).d);
      paramObject = t;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(c());
      ((StringBuilder)localObject1).append(", upload video succeed, videoPath:");
      ((StringBuilder)localObject1).append(paramVideoUploadTask.uploadFilePath);
      ((StringBuilder)localObject1).append(", flowId:");
      ((StringBuilder)localObject1).append(paramVideoUploadTask.flowId);
      ((StringBuilder)localObject1).append(", vid:");
      ((StringBuilder)localObject1).append((String)localObject3);
      ((StringBuilder)localObject1).append(", validAndUpload, coverPath:");
      ((StringBuilder)localObject1).append(((ImageUploadTask)localObject2).uploadFilePath);
      ((StringBuilder)localObject1).append(", cover flowId:");
      ((StringBuilder)localObject1).append(((ImageUploadTask)localObject2).flowId);
      QLog.i(paramObject, 1, ((StringBuilder)localObject1).toString());
      return;
    }
    paramObject = t;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(c());
    ((StringBuilder)localObject1).append(", upload video succeed, videoPath:");
    ((StringBuilder)localObject1).append(paramVideoUploadTask.uploadFilePath);
    ((StringBuilder)localObject1).append(", flowId:");
    ((StringBuilder)localObject1).append(paramVideoUploadTask.flowId);
    ((StringBuilder)localObject1).append(", vid:");
    ((StringBuilder)localObject1).append((String)localObject3);
    ((StringBuilder)localObject1).append(", don't need upload cover");
    QLog.i(paramObject, 1, ((StringBuilder)localObject1).toString());
    this.w += 1;
    if (this.w >= this.e) {
      a(0, "", (JceStruct)localObject2);
    }
  }
  
  protected void a(List<MediaWrapper> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      this.e = 0;
      this.j.clear();
      this.i.clear();
      this.u = paramList.size();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (MediaWrapper)localIterator.next();
        if (localObject2 != null)
        {
          int m = paramList.indexOf(localObject2);
          localObject1 = new AUploadMediaUploadRequest.UploadMediaInfo(this);
          ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).a = ((MediaWrapper)localObject2);
          ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).b = m;
          ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).e = (this.v + m);
          String str;
          StringBuilder localStringBuilder;
          if (((MediaWrapper)localObject2).a())
          {
            this.e += 1;
            ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).d = ((MediaWrapper)localObject2).c().b;
            this.j.put(((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).d, localObject1);
            str = t;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(c());
            localStringBuilder.append(", load video ");
            localStringBuilder.append(((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).d);
            QLog.i(str, 1, localStringBuilder.toString());
            ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).g = new TaskReportInfo.MediaReportInfo(2, ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).d);
            ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).g.c = (((MediaWrapper)localObject2).c().g / 1024L);
          }
          else if (((MediaWrapper)localObject2).b())
          {
            localObject2 = ((MediaWrapper)localObject2).d();
            if ((localObject2 != null) && (!URLUtil.isNetworkUrl(((ImageInfo)localObject2).a)))
            {
              this.e += 1;
              ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).d = ((ImageInfo)localObject2).a;
              this.i.put(((ImageInfo)localObject2).a, localObject1);
              str = t;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(c());
              localStringBuilder.append(", load photo ");
              localStringBuilder.append(((ImageInfo)localObject2).a);
              QLog.i(str, 1, localStringBuilder.toString());
              ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).g = new TaskReportInfo.MediaReportInfo(1, ((ImageInfo)localObject2).a);
              ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).g.c = (((ImageInfo)localObject2).c / 1024L);
            }
            else
            {
              localIterator.remove();
              this.v += 1;
              str = t;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(c());
              localStringBuilder.append(", load photo ");
              if (localObject2 == null)
              {
                localObject1 = "null imageInfo";
              }
              else
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("rich image:");
                ((StringBuilder)localObject1).append(((ImageInfo)localObject2).a);
                localObject1 = ((StringBuilder)localObject1).toString();
              }
              localStringBuilder.append((String)localObject1);
              localStringBuilder.append(", pass this one, current index:");
              localStringBuilder.append(m);
              QLog.i(str, 1, localStringBuilder.toString());
            }
          }
        }
      }
      paramList = t;
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(c());
      ((StringBuilder)localObject1).append(", uploadMediaList total num:");
      ((StringBuilder)localObject1).append(this.u);
      ((StringBuilder)localObject1).append(", batch num:");
      ((StringBuilder)localObject1).append(this.e);
      ((StringBuilder)localObject1).append(", rich photo num:");
      ((StringBuilder)localObject1).append(this.v);
      QLog.i(paramList, 1, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    c(paramArrayOfByte);
    b(paramArrayOfByte);
  }
  
  public boolean a()
  {
    g();
    return true;
  }
  
  protected byte[] a(int paramInt1, int paramInt2, long paramLong, UploadVideoObject paramUploadVideoObject)
  {
    UploadPicInfoReq localUploadPicInfoReq = new UploadPicInfoReq();
    localUploadPicInfoReq.iBatchID = this.c.c;
    localUploadPicInfoReq.mutliPicInfo = new MultiPicInfo();
    localUploadPicInfoReq.mutliPicInfo.iBatUploadNum = paramInt1;
    localUploadPicInfoReq.mutliPicInfo.iCurUpload = paramInt2;
    if (localUploadPicInfoReq.stExtendInfo == null)
    {
      localUploadPicInfoReq.stExtendInfo = new PicExtendInfo();
      localUploadPicInfoReq.stExtendInfo.mapParams = new HashMap();
    }
    if (localUploadPicInfoReq.stExternalMapExt == null) {
      localUploadPicInfoReq.stExternalMapExt = new HashMap();
    }
    if (this.c.t)
    {
      localUploadPicInfoReq.stExternalMapExt.put("is_client_upload_cover", "1");
      localUploadPicInfoReq.stExternalMapExt.put("is_pic_video_mix_feeds", "1");
    }
    String str = "";
    Object localObject2;
    if (paramUploadVideoObject != null)
    {
      localObject1 = localUploadPicInfoReq.stExternalMapExt;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramUploadVideoObject.g());
      ((StringBuilder)localObject2).append("");
      ((Map)localObject1).put("mix_videoSize", ((StringBuilder)localObject2).toString());
      localObject1 = localUploadPicInfoReq.stExternalMapExt;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramUploadVideoObject.j());
      ((StringBuilder)localObject2).append("");
      ((Map)localObject1).put("mix_isOriginalVideo", ((StringBuilder)localObject2).toString());
      localObject1 = localUploadPicInfoReq.stExternalMapExt;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramUploadVideoObject.f());
      ((StringBuilder)localObject2).append("");
      ((Map)localObject1).put("mix_time", ((StringBuilder)localObject2).toString());
    }
    if (Build.VERSION.SDK_INT >= 5)
    {
      if (localUploadPicInfoReq.stExtendInfo == null) {
        paramUploadVideoObject = null;
      } else {
        paramUploadVideoObject = localUploadPicInfoReq.stExtendInfo.mapExif;
      }
      if (paramUploadVideoObject != null)
      {
        localObject2 = (String)paramUploadVideoObject.get(UploadConfiguration.getExifTagCode("Make"));
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localUploadPicInfoReq.sExif_CameraMaker = ((String)localObject1);
        localObject2 = (String)paramUploadVideoObject.get(UploadConfiguration.getExifTagCode("Model"));
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localUploadPicInfoReq.sExif_CameraModel = ((String)localObject1);
        localObject2 = (String)paramUploadVideoObject.get(UploadConfiguration.getExifTagCode("GPSLatitude"));
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localUploadPicInfoReq.sExif_Latitude = ((String)localObject1);
        localObject2 = (String)paramUploadVideoObject.get(UploadConfiguration.getExifTagCode("GPSLatitudeRef"));
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localUploadPicInfoReq.sExif_LatitudeRef = ((String)localObject1);
        localObject2 = (String)paramUploadVideoObject.get(UploadConfiguration.getExifTagCode("GPSLongitude"));
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localUploadPicInfoReq.sExif_Longitude = ((String)localObject1);
        localObject1 = (String)paramUploadVideoObject.get(UploadConfiguration.getExifTagCode("GPSLongitudeRef"));
        paramUploadVideoObject = (UploadVideoObject)localObject1;
        if (localObject1 == null) {
          paramUploadVideoObject = "";
        }
        localUploadPicInfoReq.sExif_LongitudeRef = paramUploadVideoObject;
      }
    }
    localUploadPicInfoReq.iUploadTime = paramLong;
    Object localObject1 = (HashMap)localUploadPicInfoReq.mapExt;
    paramUploadVideoObject = (UploadVideoObject)localObject1;
    if (localObject1 == null) {
      paramUploadVideoObject = new HashMap();
    }
    if (this.c.d == null) {
      localObject1 = str;
    } else {
      localObject1 = this.c.d;
    }
    paramUploadVideoObject.put("mobile_fakefeeds_clientkey", localObject1);
    if ((localUploadPicInfoReq.stExtendInfo != null) && (localUploadPicInfoReq.stExtendInfo.mapParams == null)) {
      localUploadPicInfoReq.stExtendInfo.mapParams = new HashMap();
    }
    if (!TextUtils.isEmpty(this.c.b)) {
      paramUploadVideoObject.put("refer", this.c.b);
    }
    localUploadPicInfoReq.mapExt = paramUploadVideoObject;
    localUploadPicInfoReq.iBusiNessType = this.c.l;
    if (localUploadPicInfoReq.iBusiNessType == 1)
    {
      if (this.c.m == null) {
        paramUploadVideoObject = new byte[0];
      } else {
        paramUploadVideoObject = this.c.m;
      }
      localUploadPicInfoReq.vBusiNessData = paramUploadVideoObject;
    }
    else
    {
      localUploadPicInfoReq.vBusiNessData = new byte[0];
    }
    try
    {
      paramUploadVideoObject = a("UploadPicInfoReq", localUploadPicInfoReq);
      return paramUploadVideoObject;
    }
    catch (Throwable paramUploadVideoObject)
    {
      QLog.e(t, 1, paramUploadVideoObject.getMessage());
    }
    return null;
  }
  
  public void b() {}
  
  protected void b(int paramInt, String paramString)
  {
    a(paramInt, paramString, null);
    if (this.s != null) {
      this.s.a(null, paramInt, paramString);
    }
  }
  
  protected void b(byte[] paramArrayOfByte)
  {
    Object localObject1 = this.j.values();
    QLog.d(t, 1, new Object[] { "doUploadVideo... upload video size:", Integer.valueOf(((Collection)localObject1).size()) });
    if ((localObject1 != null) && (!((Collection)localObject1).isEmpty()))
    {
      Object localObject2 = ((Collection)localObject1).iterator();
      int m = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (AUploadMediaUploadRequest.UploadMediaInfo)((Iterator)localObject2).next();
        if (this.f)
        {
          paramArrayOfByte = t;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(c());
          ((StringBuilder)localObject1).append(", doUploadVideo aborted");
          QLog.e(paramArrayOfByte, 1, ((StringBuilder)localObject1).toString());
          a(QCirclePublishQualityReporter.E_UPLOAD_START, this.c.M, "-80000000", QCircleConstants.x, m);
          return;
        }
        if ((localObject1 != null) && (((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).a != null))
        {
          Object localObject3 = ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).a.c();
          if (localObject3 != null)
          {
            ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).c = a((ShuoshuoVideoInfo)localObject3);
            if (((((ShuoshuoVideoInfo)localObject3).q) && (((ShuoshuoVideoInfo)localObject3).f == ((ShuoshuoVideoInfo)localObject3).t)) || (((ShuoshuoVideoInfo)localObject3).t >= QCircleHostQzoneHelper.getVideoCanCompressLimitMs())) {
              ((ShuoshuoVideoInfo)localObject3).n = false;
            }
            if (PublishUtils.a(((ShuoshuoVideoInfo)localObject3).b)) {
              ((ShuoshuoVideoInfo)localObject3).n = true;
            }
            if (!PublishUtils.c(((ShuoshuoVideoInfo)localObject3).b))
            {
              g();
              a(1700, FSUploadConst.a(1700), null);
              paramArrayOfByte = this.D;
              if (paramArrayOfByte != null)
              {
                localObject2 = ((ShuoshuoVideoInfo)localObject3).b;
                int n;
                if (localObject1 != null) {
                  n = ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).b;
                } else {
                  n = -1;
                }
                paramArrayOfByte.a((String)localObject2, n, 1700, "");
              }
              a(QCirclePublishQualityReporter.E_UPLOAD_RESULT, this.c.M, "-80000004", QCircleConstants.x, m);
              return;
            }
            Object localObject4;
            if (PublishUtils.b((ShuoshuoVideoInfo)localObject3))
            {
              boolean bool;
              if ((((ShuoshuoVideoInfo)localObject3).n) && (((ShuoshuoVideoInfo)localObject3).m == 0) && (PublishUtils.a(((ShuoshuoVideoInfo)localObject3).b))) {
                bool = true;
              } else {
                bool = false;
              }
              if (VideoCompressConfig.a()) {
                bool = true;
              }
              localObject4 = new VideoCompressTask((ShuoshuoVideoInfo)localObject3, this.c.d, this, bool);
              if (((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).a.e()) {
                ((VideoCompressTask)localObject4).a(((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).a.e());
              }
              ((VideoCompressTask)localObject4).b(this.c.G);
              ((VideoCompressTask)localObject4).c(((ShuoshuoVideoInfo)localObject3).q);
              this.B.add(localObject4);
              VideoCompressEngine.a().c((VideoCompressTask)localObject4);
              continue;
            }
            if ((!PublishUtils.a()) && ((PublishUtils.a(((ShuoshuoVideoInfo)localObject3).b)) || (!PublishUtils.a((ShuoshuoVideoInfo)localObject3))))
            {
              g();
              paramArrayOfByte = FSUploadConst.a(1706);
              b(1706, paramArrayOfByte);
              localObject2 = this.D;
              if (localObject2 != null) {
                ((AUploadMediaUploadRequest.IMediaUploadListener)localObject2).a(((ShuoshuoVideoInfo)localObject3).b, ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).b, 1706, paramArrayOfByte);
              }
              paramArrayOfByte = t;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(c());
              ((StringBuilder)localObject1).append(", upload video which must compress, but check video compress env failed.");
              QLog.e(paramArrayOfByte, 1, ((StringBuilder)localObject1).toString());
              a(QCirclePublishQualityReporter.E_UPLOAD_START, this.c.M, "-80000003", QCircleConstants.x, m);
              return;
            }
            if (((ShuoshuoVideoInfo)localObject3).n)
            {
              localObject4 = t;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(c());
              localStringBuilder.append(", video[");
              localStringBuilder.append(((ShuoshuoVideoInfo)localObject3).b);
              localStringBuilder.append("] need compress but env check failed, upload directly");
              QLog.i((String)localObject4, 1, localStringBuilder.toString());
              ((ShuoshuoVideoInfo)localObject3).n = false;
            }
            localObject3 = a((ShuoshuoVideoInfo)localObject3, paramArrayOfByte, ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).b);
            if (localObject3 != null)
            {
              a(QCirclePublishQualityReporter.E_UPLOAD_START, this.c.M, "0", QCircleConstants.x, m);
              a((AbstractUploadTask)localObject3, ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).b, ((AUploadMediaUploadRequest.UploadMediaInfo)localObject1).d);
              continue;
            }
            a(QCirclePublishQualityReporter.E_UPLOAD_START, this.c.M, "-80000002", QCircleConstants.x, m);
            localObject1 = t;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(c());
            ((StringBuilder)localObject3).append(", doUploadVideo, createVideoUploadTask error");
            QLog.e((String)localObject1, 1, ((StringBuilder)localObject3).toString());
            continue;
          }
        }
        m += 1;
      }
    }
  }
  
  protected String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("batchId:");
    localStringBuilder.append(this.z);
    localStringBuilder.append(", fakeKey:");
    localStringBuilder.append(this.g);
    return localStringBuilder.toString();
  }
  
  public void onUploadError(AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString)
  {
    this.C = paramAbstractUploadTask;
    this.l.remove(paramAbstractUploadTask);
    String str = paramString;
    if (paramString == null) {
      str = QCircleConfigHelper.a("QZoneTextSetting", "UploadFail", "上传失败");
    }
    paramString = t;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append(", onUploadError path:");
    localStringBuilder.append(paramAbstractUploadTask.uploadFilePath);
    localStringBuilder.append(", flowId:");
    localStringBuilder.append(paramAbstractUploadTask.flowId);
    localStringBuilder.append(" errorCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errorMsg:");
    localStringBuilder.append(str);
    QLog.e(paramString, 1, localStringBuilder.toString());
    a(paramInt, str, null);
    g();
    if (this.s != null) {
      this.s.a(paramAbstractUploadTask, paramInt, str);
    }
    if (this.D != null)
    {
      boolean bool = paramAbstractUploadTask instanceof ImageUploadTask;
      if (bool) {
        paramString = this.i;
      } else {
        paramString = this.j;
      }
      paramAbstractUploadTask = (AUploadMediaUploadRequest.UploadMediaInfo)paramString.get(paramAbstractUploadTask.uploadFilePath);
      paramString = this.D;
      int m;
      if (paramAbstractUploadTask != null) {
        m = paramAbstractUploadTask.b;
      } else {
        m = -1;
      }
      paramString.a(m, paramInt, str, bool);
    }
  }
  
  public void onUploadProgress(AbstractUploadTask paramAbstractUploadTask, long paramLong1, long paramLong2)
  {
    if (this.f) {
      return;
    }
    if (this.s != null)
    {
      this.s.a(paramAbstractUploadTask.mOriginFilePath, paramLong2 / 1024L, paramLong1 / 1024L);
      if (this.s.getState() != 1)
      {
        this.s.a(1);
        this.s.setTime(System.currentTimeMillis());
      }
      this.s.dC_();
    }
  }
  
  public void onUploadStateChange(AbstractUploadTask paramAbstractUploadTask, int paramInt)
  {
    if (!this.f)
    {
      if (paramInt == 3) {
        return;
      }
      if ((this.s != null) && (this.s.getState() != paramInt)) {
        this.s.a(paramInt);
      }
    }
  }
  
  public void onUploadSucceed(AbstractUploadTask paramAbstractUploadTask, Object paramObject)
  {
    if (this.f) {
      return;
    }
    String str = t;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append(", onUploadSucceed, path:");
    localStringBuilder.append(paramAbstractUploadTask.uploadFilePath);
    localStringBuilder.append(", flowId:");
    localStringBuilder.append(paramAbstractUploadTask.flowId);
    localStringBuilder.append(", mCurNumImage:");
    localStringBuilder.append(this.w);
    QLog.i(str, 1, localStringBuilder.toString());
    this.l.remove(paramAbstractUploadTask);
    if ((paramAbstractUploadTask instanceof ImageUploadTask))
    {
      a((ImageUploadTask)paramAbstractUploadTask, paramObject);
      return;
    }
    if ((paramAbstractUploadTask instanceof VideoUploadTask)) {
      a((VideoUploadTask)paramAbstractUploadTask, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.request.AUploadMediaUploadRequest
 * JD-Core Version:    0.7.0.1
 */