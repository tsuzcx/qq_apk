package com.tencent.mobileqq.winkpublish.task;

import FileUpload.UploadVideoInfoRsp;
import NS_MOBILE_OPERATION.LbsInfo;
import NS_MOBILE_OPERATION.MediaInfo;
import NS_MOBILE_OPERATION.PicInfo;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.aelight.camera.api.IAEEditorManagerForQzone;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.qcircle.api.db.util.NeedParcel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.IQueueTask;
import com.tencent.mobileqq.winkpublish.account.LoginData;
import com.tencent.mobileqq.winkpublish.api.IDataManager;
import com.tencent.mobileqq.winkpublish.api.IUploadLocalConfig;
import com.tencent.mobileqq.winkpublish.common.AUploadCommonSetting;
import com.tencent.mobileqq.winkpublish.event.DraftDataChangeEvent;
import com.tencent.mobileqq.winkpublish.event.WinkDraftStatusEvent;
import com.tencent.mobileqq.winkpublish.fs.request.FSFeedDetailRequest;
import com.tencent.mobileqq.winkpublish.model.ImageInfo;
import com.tencent.mobileqq.winkpublish.model.MediaWrapper;
import com.tencent.mobileqq.winkpublish.model.PublishQueueTaskInfo;
import com.tencent.mobileqq.winkpublish.model.PublishUploadParams;
import com.tencent.mobileqq.winkpublish.model.QzoneMediaUploadParams;
import com.tencent.mobileqq.winkpublish.model.ShuoshuoVideoInfo;
import com.tencent.mobileqq.winkpublish.qcircle.request.QCirclePublishFeedRequest;
import com.tencent.mobileqq.winkpublish.queue.AUploadTaskQueue;
import com.tencent.mobileqq.winkpublish.report.PublishReport;
import com.tencent.mobileqq.winkpublish.request.AUploadMediaUploadRequest.IMediaUploadTaskInfoListener;
import com.tencent.mobileqq.winkpublish.request.PublishUploadRequest;
import com.tencent.mobileqq.winkpublish.request.result.UploadFileResponse;
import com.tencent.mobileqq.winkpublish.util.DateUtil;
import com.tencent.mobileqq.winkpublish.util.FSTransUtils;
import com.tencent.mobileqq.winkpublish.util.PublishUtils;
import com.tencent.mobileqq.winkpublish.util.UploadTaskBatchUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.beans.QCircleFakeFeed;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleTaskReportInfo;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.LbsDataV2.PoiInfo;
import cooperation.qzone.model.LabelInfo;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StClientInfo;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StFeedMusic;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StRight;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import qqcircle.QQCircleFeedBase.StImageBusiData;
import qqcircle.QQCircleFeedBase.StKuoliePasterData;
import qqcircle.QQCircleFeedBase.StMaterialData;
import qqcircle.QQCircleFeedBase.StSimulateData;
import qqcircle.QQCircleFeedBase.StVideoBusiData;
import ufo.UgcRight.RightInfo;
import ufo.UgcRight.TagInfo;

public class FSUploadShuoShuoTask
  extends AUploadBaseUploadShuoShuoTask
  implements AUploadMediaUploadRequest.IMediaUploadTaskInfoListener
{
  @NeedParcel
  private boolean aA;
  @NeedParcel
  private boolean aB;
  @NeedParcel
  private HashMap<String, String> aC;
  @NeedParcel
  private String aD;
  @NeedParcel
  private ArrayList<String> aE;
  @NeedParcel
  private ArrayList<String> aF;
  @NeedParcel
  private boolean aG;
  @NeedParcel
  private boolean aH;
  @NeedParcel
  private FSUploadShuoShuoTask.ResultParmas aI;
  private boolean aJ;
  private ArrayList<QCircleTaskReportInfo> aK;
  @NeedParcel
  public int ao;
  @NeedParcel
  public String ap;
  @NeedParcel
  public long aq;
  @NeedParcel
  public String ar;
  @NeedParcel
  public long as;
  String at;
  String au;
  Runnable av;
  Runnable aw;
  @NeedParcel
  private ArrayList<LabelInfo> ax;
  @NeedParcel
  private boolean ay;
  @NeedParcel
  private String az;
  
  public FSUploadShuoShuoTask()
  {
    this.ao = 0;
    this.ax = new ArrayList();
    this.ay = false;
    this.aB = false;
    this.aC = new HashMap();
    this.aG = true;
    this.aH = true;
    this.aJ = false;
    this.aK = new ArrayList();
    this.at = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoPublishQCircle", "发表：");
    this.au = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskQcircleVideoQueueing", "合成中...");
    this.av = new FSUploadShuoShuoTask.4(this);
    this.aw = new FSUploadShuoShuoTask.5(this);
  }
  
  public FSUploadShuoShuoTask(int paramInt1, int paramInt2, PublishUploadParams paramPublishUploadParams)
  {
    super(paramInt1, paramInt2, paramPublishUploadParams);
    paramInt1 = 0;
    this.ao = 0;
    this.ax = new ArrayList();
    this.ay = false;
    this.aB = false;
    this.aC = new HashMap();
    this.aG = true;
    this.aH = true;
    this.aJ = false;
    this.aK = new ArrayList();
    this.at = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoPublishQCircle", "发表：");
    this.au = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskQcircleVideoQueueing", "合成中...");
    this.av = new FSUploadShuoShuoTask.4(this);
    this.aw = new FSUploadShuoShuoTask.5(this);
    QLog.d("[upload2_FSUploadShuoShuoTask]", 1, new Object[] { "FSUploadShuoShuoTask... syncToQzone:", Boolean.valueOf(paramPublishUploadParams.m), " missionID:", paramPublishUploadParams.I });
    this.ay = paramPublishUploadParams.H;
    if (paramPublishUploadParams.m) {
      paramInt1 = 3;
    }
    this.ao = paramInt1;
    this.ax = paramPublishUploadParams.M;
    this.az = paramPublishUploadParams.I;
    this.aA = paramPublishUploadParams.L;
    this.aB = paramPublishUploadParams.N;
    this.aD = paramPublishUploadParams.O;
    this.aE = paramPublishUploadParams.P;
    this.aF = paramPublishUploadParams.Q;
    this.aG = paramPublishUploadParams.R;
    this.aH = paramPublishUploadParams.S;
    this.ap = paramPublishUploadParams.T;
    this.aq = paramPublishUploadParams.U;
    this.ar = paramPublishUploadParams.V;
    this.as = paramPublishUploadParams.W;
    try
    {
      a(paramPublishUploadParams);
    }
    catch (Exception localException)
    {
      QLog.e("[upload2_FSUploadShuoShuoTask]", 1, "FSUploadShuoShuoTask... exception:", localException);
    }
    this.aC.put("up_type", String.valueOf(paramPublishUploadParams.K));
    this.aC.put("up_source", String.valueOf(paramPublishUploadParams.J));
  }
  
  private void a(PublishUploadParams paramPublishUploadParams)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.ax != null)
    {
      i = 0;
      while (i < this.ax.size())
      {
        if (i != this.ax.size() - 1)
        {
          localStringBuilder.append(((LabelInfo)this.ax.get(i)).name);
          localStringBuilder.append("|");
        }
        else
        {
          localStringBuilder.append(((LabelInfo)this.ax.get(i)).name);
        }
        i += 1;
      }
    }
    int i = 0;
    while (i < this.p.size())
    {
      QCircleTaskReportInfo localQCircleTaskReportInfo = new QCircleTaskReportInfo();
      localQCircleTaskReportInfo.author_uin = LoginData.a().b();
      localQCircleTaskReportInfo.feed_tag = localStringBuilder.toString();
      localQCircleTaskReportInfo.txtinfo = paramPublishUploadParams.b;
      localQCircleTaskReportInfo.total_upload_num = this.p.size();
      localQCircleTaskReportInfo.up_source = paramPublishUploadParams.J;
      localQCircleTaskReportInfo.up_type = paramPublishUploadParams.K;
      if (this.w != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.w.lbs_x);
        ((StringBuilder)localObject).append("|");
        ((StringBuilder)localObject).append(this.w.lbs_y);
        localQCircleTaskReportInfo.up_place = ((StringBuilder)localObject).toString();
        if (paramPublishUploadParams.K == 1)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.w.lbs_x);
          ((StringBuilder)localObject).append("|");
          ((StringBuilder)localObject).append(this.w.lbs_y);
          localQCircleTaskReportInfo.shoot_place = ((StringBuilder)localObject).toString();
        }
      }
      Object localObject = (MediaWrapper)this.p.get(i);
      if (((MediaWrapper)localObject).b())
      {
        localQCircleTaskReportInfo.origPicWidth = ((MediaWrapper)localObject).d().o;
        localQCircleTaskReportInfo.origPicHeight = ((MediaWrapper)localObject).d().p;
        localQCircleTaskReportInfo.origPicSize = (((MediaWrapper)localObject).d().q / 1024L);
        localQCircleTaskReportInfo.editedPicHeight = ((MediaWrapper)localObject).d().n;
        localQCircleTaskReportInfo.editedPicWidth = ((MediaWrapper)localObject).d().m;
        localQCircleTaskReportInfo.editedPicSize = (((MediaWrapper)localObject).d().c / 1024L);
        if (((MediaWrapper)localObject).d().r == null) {
          localQCircleTaskReportInfo.picture_format = "jpeg";
        } else {
          localQCircleTaskReportInfo.picture_format = localObject.d().r.split("/")[1];
        }
        localQCircleTaskReportInfo.is_video = 0;
        a(localQCircleTaskReportInfo, ((MediaWrapper)localObject).d().a);
      }
      else if (((MediaWrapper)localObject).a())
      {
        localQCircleTaskReportInfo.origPicWidth = ((MediaWrapper)localObject).f;
        localQCircleTaskReportInfo.origPicHeight = ((MediaWrapper)localObject).g;
        localQCircleTaskReportInfo.origPicSize = (((MediaWrapper)localObject).h / 1024L);
        localQCircleTaskReportInfo.mediaOriginBitrate = ((MediaWrapper)localObject).i;
        localQCircleTaskReportInfo.editedPicHeight = ((MediaWrapper)localObject).c().k;
        localQCircleTaskReportInfo.editedPicWidth = ((MediaWrapper)localObject).c().j;
        localQCircleTaskReportInfo.editedPicSize = (((MediaWrapper)localObject).c().g / 1024L);
        localQCircleTaskReportInfo.editedVideoMediaBitrate = ((MediaWrapper)localObject).j;
        localQCircleTaskReportInfo.picture_format = "mp4";
        localQCircleTaskReportInfo.is_video = 1;
        if ((((MediaWrapper)localObject).c().y != null) && (((MediaWrapper)localObject).c().y.size() > 0)) {
          try
          {
            if (((String)((MediaWrapper)localObject).c().y.get(0)).endsWith("mp4"))
            {
              MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
              localMediaMetadataRetriever.setDataSource((String)((MediaWrapper)localObject).c().y.get(0));
              QLog.d("[upload2_FSUploadShuoShuoTask]", 1, new Object[] { "initReportInfo... lbs:", localMediaMetadataRetriever.extractMetadata(23), " path:", ((MediaWrapper)localObject).c().y.get(0) });
            }
            else
            {
              a(localQCircleTaskReportInfo, (String)((MediaWrapper)localObject).c().y.get(0));
            }
          }
          catch (Exception localException)
          {
            QLog.e("[upload2_FSUploadShuoShuoTask]", 1, "FSUploadShuoShuoTask... exception:", localException);
          }
        }
      }
      this.aK.add(localQCircleTaskReportInfo);
      i += 1;
    }
  }
  
  private void a(FSUploadShuoShuoTask.ResultParmas paramResultParmas)
  {
    int j = 1;
    QLog.d("[upload2_FSUploadShuoShuoTask]", 1, "processPublishData...");
    this.aI = paramResultParmas;
    long l = paramResultParmas.a;
    String str1 = paramResultParmas.b;
    String str2 = paramResultParmas.c;
    String str3 = paramResultParmas.e;
    setResultCode((int)l);
    setResultMsg(str1);
    int i = 0;
    while (i < this.aK.size())
    {
      ((QCircleTaskReportInfo)this.aK.get(i)).feedid = str2;
      ((QCircleTaskReportInfo)this.aK.get(i)).traceId = str3;
      ((QCircleTaskReportInfo)this.aK.get(i)).retCode = l;
      QLog.d("[upload2_FSUploadShuoShuoTask]", 1, new Object[] { "PublishFeedResultCallback onCallback... i:", Integer.valueOf(i), " report:", ((QCircleTaskReportInfo)this.aK.get(i)).toString() });
      i += 1;
    }
    PublishReport.a(this.aK);
    if (l == 0L)
    {
      AUploadTaskQueue.a().a(this, true);
      i = j;
    }
    else if (l == 10027L)
    {
      AUploadTaskQueue.a().a(this, true);
      i = j;
    }
    else
    {
      AUploadTaskQueue.a().a(this, false);
      i = 0;
    }
    if (i != 0)
    {
      ((IDataManager)QRoute.api(IDataManager.class)).removeMissionIdAndData(HostDataTransUtils.getLongAccountUin(), this.az);
      SimpleEventBus.getInstance().dispatchEvent(new DraftDataChangeEvent(2, paramResultParmas.i));
    }
  }
  
  private void a(QCircleTaskReportInfo paramQCircleTaskReportInfo, String paramString)
  {
    try
    {
      if (JpegExifReader.isCrashJpeg(paramString)) {
        break label164;
      }
      Object localObject = new ExifInterface(paramString);
      String str1 = ((ExifInterface)localObject).getAttribute("Model");
      String str2 = ((ExifInterface)localObject).getAttribute("Make");
      String str3 = ((ExifInterface)localObject).getAttribute("DateTime");
      paramString = new float[2];
      boolean bool = ((ExifInterface)localObject).getLatLong(paramString);
      if (!TextUtils.isEmpty(str3)) {
        paramQCircleTaskReportInfo.shooting_time = String.valueOf(DateUtil.a(str3));
      }
      if (!TextUtils.isEmpty(str2)) {
        paramQCircleTaskReportInfo.shoot_product = str2;
      }
      if (!TextUtils.isEmpty(str1)) {
        paramQCircleTaskReportInfo.shoot_model = str1;
      }
      if (!bool) {
        break label164;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString[1]);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramString[0]);
      paramQCircleTaskReportInfo.place = ((StringBuilder)localObject).toString();
      return;
    }
    catch (Exception paramQCircleTaskReportInfo)
    {
      label155:
      label164:
      break label155;
    }
    QLog.e("[upload2_FSUploadShuoShuoTask]", 1, "read pic exif error");
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if ((this.f != null) && (this.f.picinfolist != null))
    {
      Iterator localIterator = this.f.picinfolist.iterator();
      int i = 0;
      int j = 0;
      if (localIterator.hasNext())
      {
        PicInfo localPicInfo = (PicInfo)localIterator.next();
        int k;
        if (localPicInfo == null) {
          k = j;
        }
        for (;;)
        {
          i += 1;
          j = k;
          break;
          QLog.d("[upload2_FSUploadShuoShuoTask]", 1, new Object[] { "onStepPublishQCircleFeed... picInfo pic_url:", localPicInfo.pic_url });
          FeedCloudMeta.StImage localStImage = new FeedCloudMeta.StImage();
          if (localPicInfo.pic_url != null) {
            localStImage.picUrl.set(localPicInfo.pic_url);
          }
          localStImage.width.set(localPicInfo.picwidth);
          localStImage.height.set(localPicInfo.picheight);
          if (!TextUtils.isEmpty(localPicInfo.picmd5)) {
            localStImage.imageMD5.set(localPicInfo.picmd5);
          }
          QQCircleFeedBase.StImageBusiData localStImageBusiData = c(i);
          localStImage.busiData.set(ByteStringMicro.copyFrom(localStImageBusiData.toByteArray()));
          paramStFeed.images.add(localStImage);
          k = j;
          if (j == 0)
          {
            localStImage = new FeedCloudMeta.StImage();
            if (localPicInfo.pic_url != null) {
              localStImage.picUrl.set(localPicInfo.pic_url);
            }
            localStImage.width.set(localPicInfo.picwidth);
            localStImage.height.set(localPicInfo.picheight);
            paramStFeed.cover.set(localStImage);
            k = 1;
          }
        }
      }
    }
  }
  
  private void b(QCircleFakeFeed paramQCircleFakeFeed, int paramInt, FSUploadShuoShuoTask.ResultParmas paramResultParmas)
  {
    VSNetworkHelper.getInstance().sendRequest(new FSFeedDetailRequest(paramQCircleFakeFeed.getFeedId(), FSTransUtils.a(), paramQCircleFakeFeed.getCreateTime(), true), new FSUploadShuoShuoTask.2(this, paramResultParmas, paramInt, paramQCircleFakeFeed));
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed)
  {
    Object localObject1 = new FeedCloudMeta.StVideo();
    if (this.k.x != null)
    {
      QLog.d("[upload2_FSUploadShuoShuoTask]", 1, new Object[] { "onStepPublishQCircleFeed... videoInfo svid:", this.k.x });
      ((FeedCloudMeta.StVideo)localObject1).fileId.set(this.k.x);
    }
    ((FeedCloudMeta.StVideo)localObject1).width.set(this.k.j);
    ((FeedCloudMeta.StVideo)localObject1).height.set(this.k.k);
    ((FeedCloudMeta.StVideo)localObject1).fileSize.set((int)this.k.g);
    ((FeedCloudMeta.StVideo)localObject1).duration.set((int)this.k.f);
    ((FeedCloudMeta.StVideo)localObject1).transStatus.set(2);
    if (!TextUtils.isEmpty(this.k.z)) {
      ((FeedCloudMeta.StVideo)localObject1).videoMD5.set(this.k.z);
    }
    Object localObject2 = r();
    ((FeedCloudMeta.StVideo)localObject1).busiData.set(ByteStringMicro.copyFrom(((QQCircleFeedBase.StVideoBusiData)localObject2).toByteArray()));
    paramStFeed.video.set((MessageMicro)localObject1);
    if ((this.f != null) && (this.f.picinfolist != null) && (this.f.picinfolist.size() > 0))
    {
      localObject1 = (PicInfo)this.f.picinfolist.get(0);
      localObject2 = new FeedCloudMeta.StImage();
      if (((PicInfo)localObject1).pic_url != null) {
        ((FeedCloudMeta.StImage)localObject2).picUrl.set(((PicInfo)localObject1).pic_url);
      }
      ((FeedCloudMeta.StImage)localObject2).width.set(((PicInfo)localObject1).picwidth);
      ((FeedCloudMeta.StImage)localObject2).height.set(((PicInfo)localObject1).picheight);
      paramStFeed.cover.set((MessageMicro)localObject2);
    }
  }
  
  private QQCircleFeedBase.StImageBusiData c(int paramInt)
  {
    QQCircleFeedBase.StImageBusiData localStImageBusiData = new QQCircleFeedBase.StImageBusiData();
    ArrayList localArrayList = new ArrayList();
    if (paramInt < this.p.size())
    {
      Object localObject = new QQCircleFeedBase.StSimulateData();
      if (!TextUtils.isEmpty(((MediaWrapper)this.p.get(paramInt)).a)) {
        ((QQCircleFeedBase.StSimulateData)localObject).material_id.set(((MediaWrapper)this.p.get(paramInt)).a);
      }
      if (!TextUtils.isEmpty(((MediaWrapper)this.p.get(paramInt)).b)) {
        ((QQCircleFeedBase.StSimulateData)localObject).filter_id.set(((MediaWrapper)this.p.get(paramInt)).b);
      }
      if (!TextUtils.isEmpty(((MediaWrapper)this.p.get(paramInt)).c)) {
        ((QQCircleFeedBase.StSimulateData)localObject).simulate_name.set(((MediaWrapper)this.p.get(paramInt)).c);
      } else {
        ((QQCircleFeedBase.StSimulateData)localObject).simulate_name.set("拍同款");
      }
      if (!TextUtils.isEmpty(((MediaWrapper)this.p.get(paramInt)).d))
      {
        ((QQCircleFeedBase.StSimulateData)localObject).simulate_schema.set(((MediaWrapper)this.p.get(paramInt)).d);
        ((QQCircleFeedBase.StSimulateData)localObject).is_show_button.set(1);
      }
      QQCircleFeedBase.StMaterialData localStMaterialData = new QQCircleFeedBase.StMaterialData();
      if (!TextUtils.isEmpty(((MediaWrapper)this.p.get(paramInt)).a))
      {
        localStMaterialData.material_id.set(((MediaWrapper)this.p.get(paramInt)).a);
        localStMaterialData.interactive_type.set(1);
      }
      localStMaterialData.simulate_date.set((MessageMicro)localObject);
      localArrayList.add(localStMaterialData);
      QLog.d("[upload2_FSUploadShuoShuoTask]", 1, new Object[] { "onStepPublishQCircleFeed... getImageBusiData index:", Integer.valueOf(paramInt), " localmedia:", ((MediaWrapper)this.p.get(paramInt)).toString() });
      localObject = new QQCircleFeedBase.StKuoliePasterData();
      ((QQCircleFeedBase.StKuoliePasterData)localObject).kuolie_id.set(((MediaWrapper)this.p.get(paramInt)).k);
      ((QQCircleFeedBase.StKuoliePasterData)localObject).center_x.set(((MediaWrapper)this.p.get(paramInt)).l);
      ((QQCircleFeedBase.StKuoliePasterData)localObject).center_y.set(((MediaWrapper)this.p.get(paramInt)).m);
      ((QQCircleFeedBase.StKuoliePasterData)localObject).width.set(((MediaWrapper)this.p.get(paramInt)).o);
      ((QQCircleFeedBase.StKuoliePasterData)localObject).height.set(((MediaWrapper)this.p.get(paramInt)).p);
      ((QQCircleFeedBase.StKuoliePasterData)localObject).rotation.set(((MediaWrapper)this.p.get(paramInt)).n);
      localStMaterialData = new QQCircleFeedBase.StMaterialData();
      localStMaterialData.kuolie_data.set((MessageMicro)localObject);
      localStMaterialData.material_id.set(((QQCircleFeedBase.StKuoliePasterData)localObject).kuolie_id.get());
      if (!TextUtils.isEmpty(localStMaterialData.material_id.get())) {
        localStMaterialData.interactive_type.set(2);
      }
      localArrayList.add(localStMaterialData);
      if (paramInt == 0) {
        c(localArrayList);
      }
    }
    localStImageBusiData.material_datas.addAll(localArrayList);
    return localStImageBusiData;
  }
  
  private void c(FeedCloudMeta.StFeed paramStFeed)
  {
    FeedCloudMeta.StRight localStRight = new FeedCloudMeta.StRight();
    UgcRight.RightInfo localRightInfo;
    if ((this.aH) && (this.aE.size() == 0) && (this.aF.size() == 0))
    {
      localRightInfo = new UgcRight.RightInfo();
      localRightInfo.rightFlag.set(1L);
      localStRight.ugcRight.set(localRightInfo);
    }
    else if (!this.aH)
    {
      localRightInfo = new UgcRight.RightInfo();
      localRightInfo.rightFlag.set(2L);
      localStRight.ugcRight.set(localRightInfo);
    }
    else
    {
      localRightInfo = new UgcRight.RightInfo();
      localRightInfo.rightFlag.set(4L);
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < this.aE.size())
      {
        UgcRight.TagInfo localTagInfo = new UgcRight.TagInfo();
        localTagInfo.tagID.set((String)this.aE.get(i));
        localArrayList.add(localTagInfo);
        i += 1;
      }
      localRightInfo.tagList.set(localArrayList);
      localRightInfo.uinList.set(this.aF);
      localStRight.ugcRight.set(localRightInfo);
    }
    paramStFeed.right.set(localStRight);
  }
  
  private void c(List<QQCircleFeedBase.StMaterialData> paramList)
  {
    Object localObject4 = (String)WinkDatongCurrentParams.paramsForPublish.get("publish_template_id");
    Object localObject3 = (String)WinkDatongCurrentParams.paramsForPublish.get("publish_filter_id");
    Object localObject2 = (String)WinkDatongCurrentParams.paramsForPublish.get("publish_sticker_id");
    String str1 = (String)WinkDatongCurrentParams.paramsForPublish.get("publish_text_id");
    Object localObject5 = new QQCircleFeedBase.StMaterialData();
    PBStringField localPBStringField = ((QQCircleFeedBase.StMaterialData)localObject5).material_id;
    boolean bool = TextUtils.isEmpty((CharSequence)localObject4);
    String str2 = "none";
    if (bool) {
      localObject1 = "none";
    } else {
      localObject1 = localObject4;
    }
    localPBStringField.set((String)localObject1);
    ((QQCircleFeedBase.StMaterialData)localObject5).material_type.set("template");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setMaterialData... templateId:");
    ((StringBuilder)localObject1).append((String)localObject4);
    QLog.d("[upload2_FSUploadShuoShuoTask]", 1, ((StringBuilder)localObject1).toString());
    paramList.add(localObject5);
    localObject4 = new QQCircleFeedBase.StMaterialData();
    localObject5 = ((QQCircleFeedBase.StMaterialData)localObject4).material_id;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject1 = "none";
    } else {
      localObject1 = localObject3;
    }
    ((PBStringField)localObject5).set((String)localObject1);
    ((QQCircleFeedBase.StMaterialData)localObject4).material_type.set("filter");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setMaterialData... filter:");
    ((StringBuilder)localObject1).append((String)localObject3);
    QLog.d("[upload2_FSUploadShuoShuoTask]", 1, ((StringBuilder)localObject1).toString());
    paramList.add(localObject4);
    localObject3 = new QQCircleFeedBase.StMaterialData();
    localObject4 = ((QQCircleFeedBase.StMaterialData)localObject3).material_id;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "none";
    } else {
      localObject1 = localObject2;
    }
    ((PBStringField)localObject4).set((String)localObject1);
    ((QQCircleFeedBase.StMaterialData)localObject3).material_type.set("sticker");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setMaterialData... sticker:");
    ((StringBuilder)localObject1).append((String)localObject2);
    QLog.d("[upload2_FSUploadShuoShuoTask]", 1, ((StringBuilder)localObject1).toString());
    paramList.add(localObject3);
    localObject2 = new QQCircleFeedBase.StMaterialData();
    localObject3 = ((QQCircleFeedBase.StMaterialData)localObject2).material_id;
    if (TextUtils.isEmpty(str1)) {
      localObject1 = str2;
    } else {
      localObject1 = str1;
    }
    ((PBStringField)localObject3).set((String)localObject1);
    ((QQCircleFeedBase.StMaterialData)localObject2).material_type.set("text");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setMaterialData... text:");
    ((StringBuilder)localObject1).append(str1);
    QLog.d("[upload2_FSUploadShuoShuoTask]", 1, ((StringBuilder)localObject1).toString());
    paramList.add(localObject2);
  }
  
  private void d(FeedCloudMeta.StFeed paramStFeed)
  {
    LbsDataV2.PoiInfo localPoiInfo = this.h;
    if (localPoiInfo != null)
    {
      FeedCloudMeta.StPoiInfoV2 localStPoiInfoV2 = new FeedCloudMeta.StPoiInfoV2();
      if (localPoiInfo.poiId != null) {
        localStPoiInfoV2.poiId.set(localPoiInfo.poiId);
      }
      if (localPoiInfo.poiName != null) {
        localStPoiInfoV2.name.set(localPoiInfo.poiName);
      }
      if (localPoiInfo.poiTypeName != null) {
        localStPoiInfoV2.typeName.set(localPoiInfo.poiTypeName);
      }
      if (localPoiInfo.poiTypeName != null) {
        localStPoiInfoV2.address.set(localPoiInfo.address);
      }
      if (localPoiInfo.poiTypeName != null) {
        localStPoiInfoV2.districtCode.set(localPoiInfo.districtCode);
      }
      LbsDataV2.GpsInfo localGpsInfo = localPoiInfo.gpsInfo;
      if (localGpsInfo != null)
      {
        FeedCloudMeta.StGPSV2 localStGPSV2 = new FeedCloudMeta.StGPSV2();
        localStGPSV2.lat.set(localGpsInfo.lat);
        localStGPSV2.lon.set(localGpsInfo.lon);
        localStGPSV2.eType.set(localGpsInfo.gpsType);
        localStGPSV2.alt.set(localGpsInfo.alt);
        localStPoiInfoV2.gps.set(localStGPSV2);
      }
      localStPoiInfoV2.distance.set(localPoiInfo.distance);
      localStPoiInfoV2.hotValue.set(localPoiInfo.hotValue);
      if (localPoiInfo.phoneNumber != null) {
        localStPoiInfoV2.phone.set(localPoiInfo.phoneNumber);
      }
      if (localPoiInfo.country != null) {
        localStPoiInfoV2.country.set(localPoiInfo.country);
      }
      if (localPoiInfo.province != null) {
        localStPoiInfoV2.province.set(localPoiInfo.province);
      }
      if (localPoiInfo.city != null) {
        localStPoiInfoV2.city.set(localPoiInfo.city);
      }
      localStPoiInfoV2.poiNum.set(localPoiInfo.poiNum);
      localStPoiInfoV2.poiOrderType.set(localPoiInfo.poiOrderType);
      if (localPoiInfo.poiDefaultName != null) {
        localStPoiInfoV2.defaultName.set(localPoiInfo.poiDefaultName);
      }
      if (localPoiInfo.district != null) {
        localStPoiInfoV2.district.set(localPoiInfo.district);
      }
      if (localPoiInfo.dianPingId != null) {
        localStPoiInfoV2.dianPingId.set(localPoiInfo.dianPingId);
      }
      paramStFeed.poiInfo.set(localStPoiInfoV2);
    }
  }
  
  private void e(FeedCloudMeta.StFeed paramStFeed)
  {
    FeedCloudMeta.StFeedMusic localStFeedMusic = new FeedCloudMeta.StFeedMusic();
    localStFeedMusic.ID.set(this.aq);
    if (!TextUtils.isEmpty(this.ap)) {
      localStFeedMusic.MID.set(this.ap);
    }
    localStFeedMusic.startPos.set((int)this.as);
    if (!TextUtils.isEmpty(this.ar)) {
      localStFeedMusic.musicName.set(this.ar);
    }
    localStFeedMusic.scene.set(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setFeedMusicInfo... pubMusicId:");
    localStringBuilder.append(this.aq);
    localStringBuilder.append(" pubMusicMid:");
    localStringBuilder.append(this.ap);
    localStringBuilder.append(" pubStartTime:");
    localStringBuilder.append(this.as);
    localStringBuilder.append(" pubMusicName:");
    localStringBuilder.append(this.ar);
    QLog.d("[upload2_FSUploadShuoShuoTask]", 1, localStringBuilder.toString());
    paramStFeed.musicInfo.set(localStFeedMusic);
  }
  
  private void q()
  {
    QLog.i("[upload2_FSUploadShuoShuoTask]", 1, k());
    l();
    QzoneMediaUploadParams localQzoneMediaUploadParams = new QzoneMediaUploadParams();
    localQzoneMediaUploadParams.a(4).b(this.y).a(this.N).c(this.al).b(this.x).b(UploadTaskBatchUtil.a(this.N)).c(this.u).d(113).a(this.g).a(this.h).c(this.ay).d(this.az).d(this.aA).e(this.aB).a(this.aD);
    localQzoneMediaUploadParams.e(0);
    this.ai = new PublishUploadRequest(this.p, localQzoneMediaUploadParams, this, this, this);
  }
  
  private QQCircleFeedBase.StVideoBusiData r()
  {
    QQCircleFeedBase.StVideoBusiData localStVideoBusiData = new QQCircleFeedBase.StVideoBusiData();
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    QQCircleFeedBase.StMaterialData localStMaterialData;
    if (!TextUtils.isEmpty(((MediaWrapper)this.p.get(0)).d))
    {
      localObject = new QQCircleFeedBase.StSimulateData();
      if (!TextUtils.isEmpty(((MediaWrapper)this.p.get(0)).a)) {
        ((QQCircleFeedBase.StSimulateData)localObject).material_id.set(((MediaWrapper)this.p.get(0)).a);
      }
      if (!TextUtils.isEmpty(((MediaWrapper)this.p.get(0)).b)) {
        ((QQCircleFeedBase.StSimulateData)localObject).filter_id.set(((MediaWrapper)this.p.get(0)).b);
      }
      if (!TextUtils.isEmpty(((MediaWrapper)this.p.get(0)).c)) {
        ((QQCircleFeedBase.StSimulateData)localObject).simulate_name.set(((MediaWrapper)this.p.get(0)).c);
      } else {
        ((QQCircleFeedBase.StSimulateData)localObject).simulate_name.set("拍同款");
      }
      if (!TextUtils.isEmpty(((MediaWrapper)this.p.get(0)).d)) {
        ((QQCircleFeedBase.StSimulateData)localObject).simulate_schema.set(((MediaWrapper)this.p.get(0)).d);
      }
      ((QQCircleFeedBase.StSimulateData)localObject).is_show_button.set(1);
      localStMaterialData = new QQCircleFeedBase.StMaterialData();
      if (!TextUtils.isEmpty(((MediaWrapper)this.p.get(0)).a))
      {
        localStMaterialData.material_id.set(((MediaWrapper)this.p.get(0)).a);
        localStMaterialData.interactive_type.set(1);
      }
      localStMaterialData.simulate_date.set((MessageMicro)localObject);
      localArrayList.add(localStMaterialData);
      QLog.d("[upload2_FSUploadShuoShuoTask]", 1, new Object[] { "onStepPublishQCircleFeed... index:", Integer.valueOf(0), " localmedia:", ((MediaWrapper)this.p.get(0)).toString() });
    }
    if ((this.p != null) && (this.p.get(0) != null))
    {
      localObject = new QQCircleFeedBase.StKuoliePasterData();
      ((QQCircleFeedBase.StKuoliePasterData)localObject).kuolie_id.set(((MediaWrapper)this.p.get(0)).k);
      ((QQCircleFeedBase.StKuoliePasterData)localObject).center_x.set(((MediaWrapper)this.p.get(0)).l);
      ((QQCircleFeedBase.StKuoliePasterData)localObject).center_y.set(((MediaWrapper)this.p.get(0)).m);
      ((QQCircleFeedBase.StKuoliePasterData)localObject).width.set(((MediaWrapper)this.p.get(0)).o);
      ((QQCircleFeedBase.StKuoliePasterData)localObject).height.set(((MediaWrapper)this.p.get(0)).p);
      ((QQCircleFeedBase.StKuoliePasterData)localObject).rotation.set(((MediaWrapper)this.p.get(0)).n);
      localStMaterialData = new QQCircleFeedBase.StMaterialData();
      localStMaterialData.material_id.set(((QQCircleFeedBase.StKuoliePasterData)localObject).kuolie_id.get());
      localStMaterialData.kuolie_data.set((MessageMicro)localObject);
      if (!TextUtils.isEmpty(localStMaterialData.material_id.get())) {
        localStMaterialData.interactive_type.set(2);
      }
      localArrayList.add(localStMaterialData);
      c(localArrayList);
    }
    localStVideoBusiData.material_datas.addAll(localArrayList);
    return localStVideoBusiData;
  }
  
  private void s()
  {
    QLog.d("[upload2_FSUploadShuoShuoTask]", 1, "onStepPublishQCircleFeed... ");
    this.ai = null;
    FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
    Object localObject = new FeedCloudMeta.StUser();
    ((FeedCloudMeta.StUser)localObject).id.set(LoginData.a().c());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStepPublishPublicAccountFeed  syncToQzone: ");
      localStringBuilder.append(this.ao);
      QLog.d("[upload2_FSUploadShuoShuoTask]", 2, localStringBuilder.toString());
    }
    localStFeed.syncStatus.set(this.ao);
    localStFeed.poster.set((MessageMicro)localObject);
    localStFeed.disableNearbyRecomm.set(true ^ this.aG);
    c(localStFeed);
    if (this.k != null)
    {
      b(localStFeed);
      localStFeed.type.set(3);
    }
    else
    {
      a(localStFeed);
      localStFeed.type.set(2);
    }
    e(localStFeed);
    if (this.a != null) {
      localStFeed.title.set(this.a);
    }
    if (this.b != null) {
      localStFeed.content.set(this.b);
    }
    d(localStFeed);
    localObject = this.ax;
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      int i = 0;
      while (i < this.ax.size())
      {
        localObject = new FeedCloudMeta.StTagInfo();
        ((FeedCloudMeta.StTagInfo)localObject).tagName.set(((LabelInfo)this.ax.get(i)).name);
        localStFeed.tagInfos.add((MessageMicro)localObject);
        i += 1;
      }
    }
    this.aC.put("clientkey", this.al);
    localObject = new FeedCloudMeta.StClientInfo();
    ((FeedCloudMeta.StClientInfo)localObject).feedclientkey.set(this.al);
    localStFeed.clientInfo.set((MessageMicro)localObject);
    localStFeed.extInfo.add(QCircleReportHelper.newEntry("client_session", (String)WinkDatongCurrentParams.get("xsj_camera_session_id")));
    a(localStFeed, this.aC);
  }
  
  private void t()
  {
    QLog.d("[upload2_FSUploadShuoShuoTask]", 1, "removeRunnableToBoxProgress...");
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.av);
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.aw);
  }
  
  private void u()
  {
    a(this, false);
  }
  
  public List<MediaWrapper> a()
  {
    return this.p;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    IUploadLocalConfig localIUploadLocalConfig = AUploadCommonSetting.a();
    String str = QCirclePublishQualityReporter.E_UPLOAD_RESULT;
    FeedCloudCommon.Entry localEntry1 = QCircleReportHelper.newEntry("traceid", this.aD);
    FeedCloudCommon.Entry localEntry2 = QCircleReportHelper.newEntry("ret_code", String.valueOf(paramInt2));
    FeedCloudCommon.Entry localEntry3 = QCircleReportHelper.newEntry("desc", paramString);
    if (paramBoolean) {
      paramString = QCircleConstants.y;
    } else {
      paramString = QCircleConstants.x;
    }
    localIUploadLocalConfig.uploadQualityReport(str, Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, localEntry3, QCircleReportHelper.newEntry("ext1", paramString), QCircleReportHelper.newEntry("ext2", String.valueOf(paramInt1)) }));
    t();
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    super.a(paramInt, paramString1, paramString2);
    if (paramInt == 0)
    {
      t();
      paramInt = QzoneConfig.getWinkCancelUploadShowCloseButton();
      RFThreadManager.getSerialThreadHandler().postDelayed(this.av, paramInt * 60 * 1000);
      int i = QzoneConfig.getWinkCancelUploadDelay();
      RFThreadManager.getSerialThreadHandler().postDelayed(this.aw, i * 60 * 1000);
      paramString1 = new StringBuilder();
      paramString1.append("onMediaUploadStart... start showCloseButtonDelay:");
      paramString1.append(paramInt);
      paramString1.append(" cancelUploadDelay:");
      paramString1.append(i);
      QLog.d("[upload2_FSUploadShuoShuoTask]", 1, paramString1.toString());
    }
  }
  
  protected void a(UploadVideoInfoRsp paramUploadVideoInfoRsp, AbstractUploadTask paramAbstractUploadTask, int paramInt)
  {
    if (paramUploadVideoInfoRsp == null) {
      return;
    }
    if (this.ac == null) {
      this.ac = new UniAttribute();
    }
    this.ac.put("response", paramUploadVideoInfoRsp);
    if (this.k != null)
    {
      this.k.x = paramUploadVideoInfoRsp.sVid;
      this.k.z = paramAbstractUploadTask.md5;
    }
    if (paramInt < this.aK.size()) {
      ((QCircleTaskReportInfo)this.aK.get(paramInt)).vid = paramUploadVideoInfoRsp.sVid;
    }
    AUploadCommonSetting.a().uploadQualityReport(QCirclePublishQualityReporter.E_UPLOAD_RESULT, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.aD), QCircleReportHelper.newEntry("ret_code", "0"), QCircleReportHelper.newEntry("ext1", QCircleConstants.x), QCircleReportHelper.newEntry("ext2", String.valueOf(paramInt)), QCircleReportHelper.newEntry("ext3", paramUploadVideoInfoRsp.sVid) }));
  }
  
  public void a(JceStruct paramJceStruct, AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    super.a(paramJceStruct, paramAbstractUploadTask, paramInt, paramString1, paramString2, paramString3);
    t();
  }
  
  protected void a(IQueueTask paramIQueueTask)
  {
    AUploadTaskQueue.a().g(paramIQueueTask);
  }
  
  protected void a(IQueueTask paramIQueueTask, boolean paramBoolean)
  {
    AUploadTaskQueue.a().a(paramIQueueTask, paramBoolean);
  }
  
  protected void a(UploadFileResponse paramUploadFileResponse, AbstractUploadTask paramAbstractUploadTask, int paramInt)
  {
    if (paramUploadFileResponse != null)
    {
      if (paramInt < 0) {
        return;
      }
      if (this.f == null) {
        this.f = new MediaInfo();
      }
      if (this.f.picinfolist == null)
      {
        this.f.picinfolist = new ArrayList();
        int i = 0;
        while (i < this.p.size())
        {
          this.f.picinfolist.add(null);
          i += 1;
        }
      }
      PicInfo localPicInfo = new PicInfo();
      localPicInfo.picheight = paramUploadFileResponse.height;
      localPicInfo.picwidth = paramUploadFileResponse.width;
      localPicInfo.hdheight = paramUploadFileResponse.oheight;
      localPicInfo.hdwidth = paramUploadFileResponse.owidth;
      localPicInfo.pictype = paramUploadFileResponse.picType;
      localPicInfo.albumid = paramUploadFileResponse.albumId;
      localPicInfo.pictureid = paramUploadFileResponse.photoId;
      localPicInfo.sloc = paramUploadFileResponse.slocId;
      localPicInfo.hdid = paramUploadFileResponse.originId;
      localPicInfo.pic_url = paramUploadFileResponse.url;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMediaPhotoUploadSuccess... pic_url:");
      localStringBuilder.append(paramUploadFileResponse.url);
      QLog.d("[upload2_FSUploadShuoShuoTask]", 1, localStringBuilder.toString());
      localPicInfo.picmd5 = paramUploadFileResponse.md5;
      if (((this.ai instanceof PublishUploadRequest)) && (!((PublishUploadRequest)this.ai).c.q) && (paramInt < this.aK.size()))
      {
        ((QCircleTaskReportInfo)this.aK.get(paramInt)).albumId = paramUploadFileResponse.albumId;
        ((QCircleTaskReportInfo)this.aK.get(paramInt)).lloc = paramUploadFileResponse.photoId;
        ((QCircleTaskReportInfo)this.aK.get(paramInt)).backendPicWidth = paramUploadFileResponse.width;
        ((QCircleTaskReportInfo)this.aK.get(paramInt)).backendPicHeight = paramUploadFileResponse.height;
        if (paramAbstractUploadTask != null)
        {
          ((QCircleTaskReportInfo)this.aK.get(paramInt)).hasCompress = paramAbstractUploadTask.needCompress;
          if (paramAbstractUploadTask.mTargetSize != null)
          {
            ((QCircleTaskReportInfo)this.aK.get(paramInt)).clientCompressPicWidth = paramAbstractUploadTask.mTargetSize.width;
            ((QCircleTaskReportInfo)this.aK.get(paramInt)).clientCompressPicHeight = paramAbstractUploadTask.mTargetSize.height;
            ((QCircleTaskReportInfo)this.aK.get(paramInt)).clientCompressPicSize = (paramAbstractUploadTask.getFileLength() / 1024L);
          }
        }
      }
      AUploadCommonSetting.a().uploadQualityReport(QCirclePublishQualityReporter.E_UPLOAD_RESULT, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.aD), QCircleReportHelper.newEntry("ret_code", "0"), QCircleReportHelper.newEntry("ext1", QCircleConstants.y), QCircleReportHelper.newEntry("ext2", String.valueOf(paramInt)), QCircleReportHelper.newEntry("ext3", paramUploadFileResponse.url) }));
      if (paramInt < this.f.picinfolist.size())
      {
        this.f.picinfolist.set(paramInt, localPicInfo);
        return;
      }
      this.f.picinfolist.add(localPicInfo);
    }
  }
  
  public void a(AUploadTask paramAUploadTask)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(k());
    localStringBuilder.append(" onTaskResponse succeed:");
    localStringBuilder.append(paramAUploadTask.o());
    localStringBuilder.append(", batchId:");
    localStringBuilder.append(this.N);
    QLog.i("[upload2_FSUploadShuoShuoTask]", 1, localStringBuilder.toString());
    if (!paramAUploadTask.o())
    {
      a(this, false);
      return;
    }
    int i = this.t;
    if ((i != 0) && (i != 4))
    {
      paramAUploadTask = new StringBuilder();
      paramAUploadTask.append("onRun step:");
      paramAUploadTask.append(this.t);
      QLog.w("[upload2_FSUploadShuoShuoTask]", 1, paramAUploadTask.toString());
      return;
    }
    s();
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, HashMap<String, String> paramHashMap)
  {
    Object localObject = new WinkDraftStatusEvent(getMissionId());
    ((WinkDraftStatusEvent)localObject).setUploadStatus(2);
    SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)localObject);
    try
    {
      localObject = new FeedCloudCommon.StCommonExt();
      if (paramHashMap != null)
      {
        paramHashMap = paramHashMap.entrySet().iterator();
        while (paramHashMap.hasNext()) {
          ((FeedCloudCommon.StCommonExt)localObject).mapInfo.add(QCircleReportHelper.newEntry((Map.Entry)paramHashMap.next()));
        }
      }
      paramHashMap = new QCirclePublishFeedRequest((FeedCloudCommon.StCommonExt)localObject, paramStFeed);
      paramHashMap.overrideTraceId(this.aD);
      AUploadCommonSetting.a().uploadQualityReport(QCirclePublishQualityReporter.E_PUBLISH_FEEDS_START, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.aD), QCircleReportHelper.newEntry("ret_code", "0"), QCircleReportHelper.newEntry("ext1", paramHashMap.getTraceId()), QCircleReportHelper.newEntry("ext2", String.valueOf(paramHashMap.getSsoSeq())) }));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ACTION_QCIRCLE_PULISH_FEED publishFeed id:");
      ((StringBuilder)localObject).append(paramStFeed.id.get());
      QLog.d("[upload2_FSUploadShuoShuoTask]", 1, ((StringBuilder)localObject).toString());
      VSNetworkHelper.getInstance().sendRequest(paramHashMap, new FSUploadShuoShuoTask.1(this));
      return;
    }
    catch (Exception paramStFeed)
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("ACTION_QCIRCLE_PULISH_FEED error");
      paramHashMap.append(paramStFeed);
      QLog.e("[upload2_FSUploadShuoShuoTask]", 1, new Object[] { Integer.valueOf(1), paramHashMap.toString() });
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    this.R = paramString;
    this.L = paramLong1;
    this.M = paramLong2;
    AUploadTaskQueue.a().g(this);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    super.a(paramString1, paramString2, paramInt);
    paramString1 = new MediaMetadataRetriever();
    paramString1.setDataSource(paramString2);
    paramString2 = paramString1.extractMetadata(19);
    String str = paramString1.extractMetadata(18);
    if ((paramString2 != null) && (str != null))
    {
      if (paramInt < this.aK.size()) {
        try
        {
          ((QCircleTaskReportInfo)this.aK.get(paramInt)).clientCompressPicHeight = Integer.parseInt(paramString2);
          ((QCircleTaskReportInfo)this.aK.get(paramInt)).clientCompressPicWidth = Integer.parseInt(str);
          paramString2 = new File(this.k.b);
          if (paramString2.exists())
          {
            ((QCircleTaskReportInfo)this.aK.get(paramInt)).clientCompressPicSize = (paramString2.length() / 1024L);
            paramString1 = paramString1.extractMetadata(20);
            ((QCircleTaskReportInfo)this.aK.get(paramInt)).clientCompressMediaBitrate = Long.parseLong(paramString1);
            return;
          }
        }
        catch (Exception paramString1)
        {
          QLog.e("[upload2_FSUploadShuoShuoTask]", 1, "onMediaCompressSuccess... exception:", paramString1);
        }
      }
      return;
    }
    QLog.e("[upload2_FSUploadShuoShuoTask]", 1, new Object[] { Integer.valueOf(1), "onMediaCompressSuccess... height == null || width == null" });
  }
  
  public void a(List<MediaWrapper> paramList)
  {
    QLog.d("[upload2_FSUploadShuoShuoTask]", 1, "onGenerateComplete...");
    this.r = 0;
    this.k = null;
    this.ay = true;
    b(paramList);
    int i = 0;
    while (i < paramList.size())
    {
      if (i < this.aK.size())
      {
        ((QCircleTaskReportInfo)this.aK.get(i)).editedPicSize = (((MediaWrapper)paramList.get(i)).c().g / 1024L);
        ((QCircleTaskReportInfo)this.aK.get(i)).editedVideoMediaBitrate = ((MediaWrapper)paramList.get(i)).j;
        QLog.d("[upload2_FSUploadShuoShuoTask]", 1, new Object[] { "onGenerateComplete... mSize:", Long.valueOf(((MediaWrapper)paramList.get(i)).c().g), " edited_video_mediaBitrate:", Long.valueOf(((QCircleTaskReportInfo)this.aK.get(i)).editedVideoMediaBitrate) });
      }
      i += 1;
    }
    AUploadTaskQueue.a().b(this);
  }
  
  protected boolean a(QCircleFakeFeed paramQCircleFakeFeed, int paramInt, FSUploadShuoShuoTask.ResultParmas paramResultParmas)
  {
    if (paramInt >= 3)
    {
      QLog.e("[upload2_FSUploadShuoShuoTask]", 1, "retryCount >= QCircleFakeAdapter.MAX_RETYR_COUNT");
      return false;
    }
    paramQCircleFakeFeed = new FSUploadShuoShuoTask.RetryRequestFeed(this, paramQCircleFakeFeed, paramInt + 1, paramResultParmas);
    RFThreadManager.getSerialThreadHandler().postDelayed(paramQCircleFakeFeed, paramInt * 2000);
    return true;
  }
  
  protected void b()
  {
    if (isVideoTask())
    {
      this.t = 4;
      return;
    }
    if (d())
    {
      if (this.c.size() >= 1) {
        this.t = 0;
      }
      this.e = 1;
    }
  }
  
  public boolean cancel()
  {
    return super.cancel();
  }
  
  public void e()
  {
    int i = this.t;
    if (i != 0)
    {
      if (i != 4)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onRun step:");
        localStringBuilder.append(this.t);
        QLog.w("[upload2_FSUploadShuoShuoTask]", 1, localStringBuilder.toString());
        return;
      }
      q();
      return;
    }
    p();
  }
  
  public String getCacheKey()
  {
    return this.al;
  }
  
  public PublishQueueTaskInfo getInfo()
  {
    PublishQueueTaskInfo localPublishQueueTaskInfo = super.getInfo();
    String str;
    if ((this.b != null) && (this.b.length() > 320)) {
      str = this.b.substring(0, 320);
    } else if (this.b == null) {
      str = "";
    } else {
      str = this.b;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.at);
    localStringBuilder.append(str);
    localPublishQueueTaskInfo.title = localStringBuilder.toString();
    if ((isVideoTask()) && (!this.ay) && (getState() == 1)) {
      localPublishQueueTaskInfo.detail = this.au;
    }
    if (isVideoTask())
    {
      localPublishQueueTaskInfo.url = h();
      return localPublishQueueTaskInfo;
    }
    localPublishQueueTaskInfo.url = ((String)g().get(0));
    return localPublishQueueTaskInfo;
  }
  
  public String getMissionId()
  {
    return this.az;
  }
  
  public boolean isNeedRetryByQueue()
  {
    return false;
  }
  
  protected String k()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("id:");
    ((StringBuilder)localObject).append(getTaskId());
    ((StringBuilder)localObject).append(", fakeKey:");
    ((StringBuilder)localObject).append(getCacheKey());
    localObject = ((StringBuilder)localObject).toString();
    int i = this.t;
    if (i != 0)
    {
      if (i != 4)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(getCacheKey());
        ((StringBuilder)localObject).append(", step: unknown step");
        return ((StringBuilder)localObject).toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", STEP_UPLOAD_MIX_VIDEO_PIC_TASK");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", STEP_UPLOAD_TASK");
    return localStringBuilder.toString();
  }
  
  public boolean needShowCloseBt()
  {
    return this.aJ;
  }
  
  public void notifyComplete(boolean paramBoolean)
  {
    RFThreadManager.getUIHandler().post(new FSUploadShuoShuoTask.3(this, paramBoolean));
  }
  
  public void onRemove()
  {
    super.onRemove();
    QLog.d("[upload2_FSUploadShuoShuoTask]", 1, new Object[] { "onRemove... missionId:", this.az });
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).cancelQFSMission(this.az);
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.d("[upload2_FSUploadShuoShuoTask]", 1, new Object[] { "onResume... missionId:", this.az, " isVideoReady:", Boolean.valueOf(this.ay) });
    if ((!this.ay) && (!TextUtils.isEmpty(this.az)))
    {
      ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).init();
      ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).retryQFSMission(this.az);
    }
  }
  
  protected void p()
  {
    l();
    long l2 = UploadTaskBatchUtil.a(this.N);
    long l1 = l2;
    if (l2 == 0L)
    {
      l1 = HostStaticInvokeHelper.getServerTimeMillis() / 1000L;
      UploadTaskBatchUtil.a(this.N, l1);
    }
    QzoneMediaUploadParams localQzoneMediaUploadParams = new QzoneMediaUploadParams();
    localQzoneMediaUploadParams.a(4).b(this.y).a(this.N).c(this.al).b(this.x).b(l1).c(this.u).a(this.A).a(false).a(this.aD).f(32);
    localQzoneMediaUploadParams.e(0);
    this.ai = new PublishUploadRequest(PublishUtils.a(this.c), localQzoneMediaUploadParams, this, this);
    if (this.S != null) {
      this.S.e = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.task.FSUploadShuoShuoTask
 * JD-Core Version:    0.7.0.1
 */