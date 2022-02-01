package com.tencent.mobileqq.winkpublish.task;

import FileUpload.UploadVideoInfoRsp;
import NS_MOBILE_OPERATION.LbsInfo;
import NS_MOBILE_OPERATION.MediaInfo;
import NS_MOBILE_OPERATION.PicInfo;
import NS_MOBILE_PHOTO.shuoshuo_privacy;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.QzoneLbsConstant;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLbsHelper;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.qcircle.api.db.util.NeedParcel;
import com.tencent.mobileqq.winkpublish.IQueueTask;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.model.ImageInfo;
import com.tencent.mobileqq.winkpublish.model.MediaWrapper;
import com.tencent.mobileqq.winkpublish.model.PublishQueueTaskInfo;
import com.tencent.mobileqq.winkpublish.model.PublishUploadParams;
import com.tencent.mobileqq.winkpublish.model.ShuoshuoVideoInfo;
import com.tencent.mobileqq.winkpublish.request.AUploadMediaUploadRequest;
import com.tencent.mobileqq.winkpublish.request.AUploadMediaUploadRequest.IMediaUploadListener;
import com.tencent.mobileqq.winkpublish.request.result.UploadFileResponse;
import com.tencent.mobileqq.winkpublish.task.compress.VideoCompressTask;
import com.tencent.mobileqq.winkpublish.task.report.TaskReportInfo.MediaReportInfo;
import com.tencent.mobileqq.winkpublish.util.BatchIDGenerator;
import com.tencent.mobileqq.winkpublish.util.ImageUtil;
import com.tencent.mobileqq.winkpublish.util.PublishUtils;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.AbstractUploadTask;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.LbsDataV2.PoiInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AUploadBaseUploadShuoShuoTask
  extends AUploadQueueTask
  implements AUploadMediaUploadRequest.IMediaUploadListener
{
  private static final String ao;
  @NeedParcel
  public Map<String, String> A;
  public boolean B = false;
  String C = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoUploadDynamicPic", "上传动图：");
  String D = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoPublishMood", "发表说说：");
  String E = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoPublishCertifiedAccount", "发表作品：");
  String F = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoPublishVideo", "上传视频：");
  String G = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoPublishing", "发表中...");
  String H = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoUploadVideo", "上传视频");
  String I = QCircleConfigHelper.a("QZoneTextSetting", "BoxTaskInfoPublishSignMood", "发表签到：");
  @NeedParcel
  public String a;
  @NeedParcel
  private Map<String, String> aA;
  @NeedParcel
  private Map<String, String> aB;
  @NeedParcel
  private HashMap<String, PicInfo> aC;
  private boolean aD;
  private VideoCompressTask aE;
  private ArrayList<Integer> aF = new ArrayList();
  private Runnable aG = new AUploadBaseUploadShuoShuoTask.1(this);
  @NeedParcel
  private int ap = 0;
  @NeedParcel
  private HashMap<String, String> aq;
  @NeedParcel
  private shuoshuo_privacy ar;
  @NeedParcel
  private HashMap<String, Integer> as;
  @NeedParcel
  private boolean at;
  @NeedParcel
  private boolean au;
  @NeedParcel
  private String av = null;
  @NeedParcel
  private int aw = 1;
  @NeedParcel
  private ArrayList<String> ax = null;
  @NeedParcel
  private String ay;
  @NeedParcel
  private String az;
  @NeedParcel
  protected String b;
  @NeedParcel
  protected List<String> c;
  @NeedParcel
  protected List<String> d;
  @NeedParcel
  protected int e;
  @NeedParcel
  public MediaInfo f = new MediaInfo();
  protected LbsInfo g;
  @NeedParcel
  protected LbsDataV2.PoiInfo h;
  @NeedParcel
  public long i;
  @NeedParcel
  public long j;
  @NeedParcel
  protected ShuoshuoVideoInfo k;
  @NeedParcel
  protected List<ShuoshuoVideoInfo> l = new ArrayList();
  @NeedParcel
  protected List<ShuoshuoVideoInfo> m = new ArrayList();
  @NeedParcel
  protected List<ShuoshuoVideoInfo> n = new ArrayList();
  @NeedParcel
  protected Map<Integer, String> o = new HashMap();
  @NeedParcel
  protected List<MediaWrapper> p = new ArrayList();
  @NeedParcel
  public boolean q = false;
  @NeedParcel
  protected int r = 0;
  @NeedParcel
  public Map<String, String> s;
  @NeedParcel
  public volatile int t = 0;
  @NeedParcel
  protected int u = 0;
  @NeedParcel
  protected ArrayList<Pair<Integer, PicInfo>> v;
  @NeedParcel
  public LbsInfo w;
  @NeedParcel
  public int x;
  @NeedParcel
  public String y;
  @NeedParcel
  public Map<String, byte[]> z;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("[upload2_FSUploadBaseUploadShuoShuoTask]");
    ao = localStringBuilder.toString();
  }
  
  public AUploadBaseUploadShuoShuoTask() {}
  
  public AUploadBaseUploadShuoShuoTask(int paramInt1, int paramInt2, PublishUploadParams paramPublishUploadParams)
  {
    super(paramInt1);
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1) {
        return;
      }
      b(paramPublishUploadParams);
      return;
    }
    a(paramPublishUploadParams);
  }
  
  private void a(PublishUploadParams paramPublishUploadParams)
  {
    this.b = paramPublishUploadParams.b;
    this.aq = paramPublishUploadParams.e;
    this.ar = paramPublishUploadParams.f;
    this.k = paramPublishUploadParams.g;
    this.au = paramPublishUploadParams.l;
    this.at = paramPublishUploadParams.k;
    this.N = BatchIDGenerator.a();
    this.u = paramPublishUploadParams.o;
    this.i = paramPublishUploadParams.p;
    this.j = paramPublishUploadParams.q;
    this.aw = paramPublishUploadParams.r;
    this.ax = paramPublishUploadParams.s;
    this.ay = paramPublishUploadParams.t;
    this.az = paramPublishUploadParams.v;
    this.h = paramPublishUploadParams.i;
    this.aA = paramPublishUploadParams.n;
    this.aC = paramPublishUploadParams.h;
    this.z = paramPublishUploadParams.x;
    this.av = null;
    this.A = paramPublishUploadParams.A;
    a(paramPublishUploadParams.c);
    p();
    a(paramPublishUploadParams.i, paramPublishUploadParams.u);
    a(this.at);
    if (this.aB == null) {
      this.aB = new HashMap();
    }
    if (paramPublishUploadParams.y != null) {
      this.aB.putAll(paramPublishUploadParams.y);
    }
    if (paramPublishUploadParams.G != null) {
      this.aB.putAll(paramPublishUploadParams.G);
    }
    if (paramPublishUploadParams.E != null)
    {
      if (this.f.picinfolist == null) {
        this.f.picinfolist = new ArrayList();
      }
      this.f.picinfolist.add(paramPublishUploadParams.E);
    }
    b();
    paramPublishUploadParams = ao;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initNormal, ");
    localStringBuilder.append(k());
    QLog.i(paramPublishUploadParams, 1, localStringBuilder.toString());
  }
  
  private void a(LbsDataV2.PoiInfo paramPoiInfo, LbsDataV2.GpsInfo paramGpsInfo)
  {
    double d1;
    if (paramPoiInfo != null)
    {
      this.g = new LbsInfo();
      if (paramPoiInfo.gpsInfo != null)
      {
        LbsInfo localLbsInfo = this.g;
        d1 = paramPoiInfo.gpsInfo.lon;
        Double.isNaN(d1);
        localLbsInfo.lbs_x = String.valueOf(d1 / 1000000.0D);
        localLbsInfo = this.g;
        d1 = paramPoiInfo.gpsInfo.lat;
        Double.isNaN(d1);
        localLbsInfo.lbs_y = String.valueOf(d1 / 1000000.0D);
      }
      if (!TextUtils.isEmpty(paramPoiInfo.poiDefaultName))
      {
        this.g.lbs_idnm = paramPoiInfo.poiDefaultName;
        this.g.lbs_nm = paramPoiInfo.poiDefaultName;
      }
      else if (!TextUtils.isEmpty(paramPoiInfo.poiName))
      {
        this.g.lbs_idnm = paramPoiInfo.poiName;
        this.g.lbs_nm = paramPoiInfo.poiName;
      }
      else
      {
        this.g.lbs_idnm = paramPoiInfo.address;
        this.g.lbs_nm = paramPoiInfo.address;
      }
      this.g.i_poi_order_type = paramPoiInfo.poiOrderType;
      this.g.i_poi_num = paramPoiInfo.poiNum;
      this.g.i_poi_type = paramPoiInfo.poiType;
    }
    try
    {
      this.g.lbs_id = Integer.parseInt(paramPoiInfo.poiId);
    }
    catch (Exception paramPoiInfo)
    {
      label230:
      break label230;
    }
    if (paramGpsInfo != null)
    {
      this.w = new LbsInfo();
      paramPoiInfo = this.w;
      d1 = paramGpsInfo.lon;
      Double.isNaN(d1);
      paramPoiInfo.lbs_x = String.valueOf(d1 / 1000000.0D);
      paramPoiInfo = this.w;
      d1 = paramGpsInfo.lat;
      Double.isNaN(d1);
      paramPoiInfo.lbs_y = String.valueOf(d1 / 1000000.0D);
      return;
    }
    paramPoiInfo = QCircleHostLbsHelper.getCurrGps(QCircleHostConstants.QzoneLbsConstant.BUSINESS_ID_QZONE_SAY());
    if ((paramPoiInfo != null) && (paramPoiInfo.isValid()))
    {
      this.w = new LbsInfo();
      paramGpsInfo = this.w;
      d1 = paramPoiInfo.lon;
      Double.isNaN(d1);
      paramGpsInfo.lbs_x = String.valueOf(d1 / 1000000.0D);
      paramGpsInfo = this.w;
      d1 = paramPoiInfo.lat;
      Double.isNaN(d1);
      paramGpsInfo.lbs_y = String.valueOf(d1 / 1000000.0D);
    }
  }
  
  private void a(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.c = new ArrayList();
    this.v = new ArrayList();
    this.p = new ArrayList();
    int i2 = paramList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = (String)paramList.get(i1);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if ((!((String)localObject).startsWith("http://")) && (!((String)localObject).startsWith("https://")))
        {
          this.c.add(paramList.get(i1));
        }
        else
        {
          HashMap localHashMap = this.aC;
          if (localHashMap != null) {
            localObject = (PicInfo)localHashMap.get(localObject);
          } else {
            localObject = null;
          }
          this.v.add(new Pair(Integer.valueOf(i1), localObject));
        }
        localObject = new MediaWrapper(ImageInfo.a((String)paramList.get(i1)));
        this.p.add(localObject);
      }
      i1 += 1;
    }
    this.r = this.p.size();
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    if (isVideoTask())
    {
      ShuoshuoVideoInfo localShuoshuoVideoInfo = this.k;
      localShuoshuoVideoInfo.e |= 0x1;
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = TextUtils.isEmpty(paramString2);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (TextUtils.isEmpty(paramString1)) {
      return true;
    }
    paramString1 = new File(paramString1);
    if ((!paramString1.exists()) || (paramString1.isDirectory())) {
      bool1 = true;
    }
    return bool1;
  }
  
  private void b(PublishUploadParams paramPublishUploadParams)
  {
    this.b = paramPublishUploadParams.b;
    this.aq = paramPublishUploadParams.e;
    this.ar = paramPublishUploadParams.f;
    this.au = paramPublishUploadParams.l;
    this.at = paramPublishUploadParams.k;
    this.N = BatchIDGenerator.a();
    this.u = paramPublishUploadParams.o;
    this.i = paramPublishUploadParams.p;
    this.j = paramPublishUploadParams.q;
    this.aw = paramPublishUploadParams.r;
    this.ax = paramPublishUploadParams.s;
    this.ay = paramPublishUploadParams.t;
    this.az = paramPublishUploadParams.v;
    this.h = paramPublishUploadParams.i;
    this.aA = paramPublishUploadParams.n;
    this.aC = paramPublishUploadParams.h;
    this.z = paramPublishUploadParams.x;
    this.A = paramPublishUploadParams.A;
    b(paramPublishUploadParams.D);
    p();
    a(paramPublishUploadParams.i, paramPublishUploadParams.u);
    a(this.at);
    this.q = c();
    if (this.aB == null) {
      this.aB = new HashMap();
    }
    if (paramPublishUploadParams.y != null) {
      this.aB.putAll(paramPublishUploadParams.y);
    }
    if (paramPublishUploadParams.G != null) {
      this.aB.putAll(paramPublishUploadParams.G);
    }
    b();
    paramPublishUploadParams = ao;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initMixUpload, ");
    localStringBuilder.append(k());
    QLog.i(paramPublishUploadParams, 1, localStringBuilder.toString());
  }
  
  private void b(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      if (this.s == null) {
        this.s = new HashMap();
      }
      this.s.put(paramString1, paramString2);
    }
  }
  
  private void p()
  {
    if (this.c == null) {
      return;
    }
    if (this.as == null) {
      this.as = new HashMap();
    }
    int i1 = 0;
    while (i1 < this.c.size())
    {
      this.as.put(this.c.get(i1), Integer.valueOf(a((int)this.N, (String)this.c.get(i1))));
      i1 += 1;
    }
  }
  
  private int q()
  {
    return this.aF.size();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    String str = ao;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMediaUploadFailed mediaIndex:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", errCode:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString);
    QLog.w(str, 1, localStringBuilder.toString());
    a(this);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt < 0) {
      return;
    }
    b(paramInt);
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
  }
  
  public void a(JceStruct paramJceStruct, AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (paramJceStruct != null)
    {
      if (paramInt < 0) {
        return;
      }
      String str = ao;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMediaUploadSuccess mediaIndex:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", id:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", srcPath:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", uploadPath:");
      localStringBuilder.append(paramString3);
      QLog.i(str, 1, localStringBuilder.toString());
      if (!this.aF.contains(Integer.valueOf(paramInt))) {
        this.aF.add(Integer.valueOf(paramInt));
      }
      if ((paramJceStruct instanceof UploadVideoInfoRsp))
      {
        QLog.i(ao, 1, "response is UploadVideoInfoRsp");
        a((UploadVideoInfoRsp)paramJceStruct, paramAbstractUploadTask, paramInt);
        paramJceStruct = paramString2;
        if (a(paramString2, paramString3)) {
          paramJceStruct = paramString3;
        }
        if ((!TextUtils.isEmpty(paramJceStruct)) && (new File(paramJceStruct).exists()))
        {
          b(paramString1, paramJceStruct);
          paramAbstractUploadTask = ao;
          paramString2 = new StringBuilder();
          paramString2.append("addUploadVideoToUrlMap, id:");
          paramString2.append(paramString1);
          paramString2.append(", path:");
          paramString2.append(paramJceStruct);
          QLog.i(paramAbstractUploadTask, 1, paramString2.toString());
        }
      }
      else if ((paramJceStruct instanceof UploadFileResponse))
      {
        QLog.i(ao, 1, "response is UploadFileResponse");
        a((UploadFileResponse)paramJceStruct, paramAbstractUploadTask, paramInt);
      }
    }
  }
  
  protected void a(IQueueTask paramIQueueTask) {}
  
  protected void a(IQueueTask paramIQueueTask, boolean paramBoolean) {}
  
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
        int i1 = 0;
        while (i1 < this.p.size())
        {
          this.f.picinfolist.add(null);
          i1 += 1;
        }
      }
      paramAbstractUploadTask = new PicInfo();
      paramAbstractUploadTask.picheight = paramUploadFileResponse.height;
      paramAbstractUploadTask.picwidth = paramUploadFileResponse.width;
      paramAbstractUploadTask.hdheight = paramUploadFileResponse.oheight;
      paramAbstractUploadTask.hdwidth = paramUploadFileResponse.owidth;
      paramAbstractUploadTask.pictype = paramUploadFileResponse.picType;
      paramAbstractUploadTask.albumid = paramUploadFileResponse.albumId;
      paramAbstractUploadTask.pictureid = paramUploadFileResponse.photoId;
      paramAbstractUploadTask.sloc = paramUploadFileResponse.slocId;
      paramAbstractUploadTask.hdid = paramUploadFileResponse.originId;
      if (paramInt < this.f.picinfolist.size())
      {
        this.f.picinfolist.set(paramInt, paramAbstractUploadTask);
        return;
      }
      this.f.picinfolist.add(paramAbstractUploadTask);
    }
  }
  
  public void a(AUploadTask paramAUploadTask) {}
  
  public void a(TaskReportInfo.MediaReportInfo paramMediaReportInfo)
  {
    b(paramMediaReportInfo);
  }
  
  public void a(String paramString, int paramInt, double paramDouble)
  {
    a(this);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    a(this);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.t == 2)
    {
      if (this.c == null) {
        this.c = new ArrayList();
      }
      this.c.add(paramString2);
      this.t = 1;
    }
    a(this);
  }
  
  protected void b() {}
  
  public void b(int paramInt)
  {
    this.ap = paramInt;
  }
  
  protected void b(List<MediaWrapper> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      this.p = paramList;
      this.c = new ArrayList();
      this.d = new ArrayList();
      this.v = new ArrayList();
      this.l = new ArrayList();
      int i1 = 0;
      while (i1 < paramList.size())
      {
        Object localObject = (MediaWrapper)paramList.get(i1);
        if (((MediaWrapper)localObject).b())
        {
          this.r += 1;
          String str = ((MediaWrapper)localObject).d().a;
          if ((!str.startsWith("http://")) && (!str.startsWith("https://")))
          {
            this.c.add(str);
          }
          else
          {
            localObject = this.aC;
            if (localObject != null) {
              localObject = (PicInfo)((HashMap)localObject).get(str);
            } else {
              localObject = null;
            }
            if (localObject == null) {
              break label378;
            }
            this.v.add(new Pair(Integer.valueOf(i1), localObject));
          }
          this.d.add(str);
        }
        else if (((MediaWrapper)localObject).a())
        {
          this.r += 1;
          this.c.add(((MediaWrapper)localObject).c().b);
          this.d.add(((MediaWrapper)localObject).c().b);
          this.l.add(((MediaWrapper)localObject).c());
          this.o.put(Integer.valueOf(i1), new String(((MediaWrapper)localObject).c().b));
          if ((((MediaWrapper)localObject).c() != null) && (((MediaWrapper)localObject).c().n)) {
            this.m.add(((MediaWrapper)localObject).c());
          } else if (((MediaWrapper)localObject).c() != null) {
            this.n.add(((MediaWrapper)localObject).c());
          }
          if (this.k == null) {
            this.k = ((MediaWrapper)localObject).c();
          }
        }
        label378:
        i1 += 1;
      }
    }
  }
  
  public boolean c()
  {
    List localList = this.l;
    return (localList != null) && (localList.size() >= 1);
  }
  
  public boolean cancel()
  {
    String str = ao;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(k());
    localStringBuilder.append(" cancel task");
    QLog.i(str, 1, localStringBuilder.toString());
    if ((this.ai != null) && ((this.ai instanceof AUploadMediaUploadRequest))) {
      return ((AUploadMediaUploadRequest)this.ai).a();
    }
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.aG);
    return true;
  }
  
  public void clear()
  {
    super.clear();
    if ((this.ai != null) && ((this.ai instanceof AUploadMediaUploadRequest))) {
      ((AUploadMediaUploadRequest)this.ai).b();
    }
  }
  
  public boolean d()
  {
    List localList = this.c;
    return (localList != null) && (localList.size() > 0);
  }
  
  public void e()
  {
    String str = ao;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(k());
    localStringBuilder.append(", onRun batchId:");
    localStringBuilder.append(this.N);
    QLog.i(str, 1, localStringBuilder.toString());
  }
  
  public int f()
  {
    List localList = this.c;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public List<String> g()
  {
    return this.c;
  }
  
  public String getCacheKey()
  {
    return this.al;
  }
  
  public int getExactType()
  {
    return 1;
  }
  
  public PublishQueueTaskInfo getInfo()
  {
    PublishQueueTaskInfo localPublishQueueTaskInfo = super.getInfo();
    Object localObject1 = this.b;
    if ((localObject1 != null) && (((String)localObject1).length() > 320)) {
      localObject1 = this.b.substring(0, 320);
    } else {
      localObject1 = this.b;
    }
    Object localObject2 = localObject1;
    if (this.au)
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (((String)localObject1).startsWith("qm")) {
          localObject2 = ((String)localObject1).substring(2);
        }
      }
    }
    if (this.q)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.D);
      ((StringBuilder)localObject1).append((String)localObject2);
      localPublishQueueTaskInfo.title = ((StringBuilder)localObject1).toString();
    }
    else if (isVideoTask())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.F);
      ((StringBuilder)localObject1).append((String)localObject2);
      localPublishQueueTaskInfo.title = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.D);
      ((StringBuilder)localObject1).append((String)localObject2);
      localPublishQueueTaskInfo.title = ((StringBuilder)localObject1).toString();
    }
    localObject1 = localPublishQueueTaskInfo;
    if (getState() == 1)
    {
      if ((this.L > 0L) && (this.M > 0L))
      {
        localPublishQueueTaskInfo.progress = Math.max((int)(this.L * 100L / this.M), 1);
        if ((this.ap >= 0) && (f() > 0))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.L);
          ((StringBuilder)localObject1).append("k/");
          ((StringBuilder)localObject1).append(this.M);
          ((StringBuilder)localObject1).append("k");
          localPublishQueueTaskInfo.detail = ((StringBuilder)localObject1).toString();
        }
        else if (isVideoTask())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.H);
          ((StringBuilder)localObject1).append(this.L);
          ((StringBuilder)localObject1).append("/");
          ((StringBuilder)localObject1).append(this.M);
          ((StringBuilder)localObject1).append("k");
          localPublishQueueTaskInfo.detail = ((StringBuilder)localObject1).toString();
        }
      }
      if ((!this.q) && (!isVideoTask()))
      {
        if (f() != 0)
        {
          localObject1 = localPublishQueueTaskInfo;
          if (this.ap != f()) {}
        }
        else
        {
          localPublishQueueTaskInfo.detail = this.G;
          localObject1 = localPublishQueueTaskInfo;
        }
      }
      else
      {
        localObject1 = localPublishQueueTaskInfo;
        if ((this.ai instanceof AUploadMediaUploadRequest)) {
          localObject1 = ((AUploadMediaUploadRequest)this.ai).a(localPublishQueueTaskInfo);
        }
      }
    }
    int i3 = f();
    int i2 = q();
    if ((i2 >= 0) && (i3 > i2))
    {
      ((PublishQueueTaskInfo)localObject1).leftCount = (i3 - i2);
      if (TextUtils.isEmpty(((PublishQueueTaskInfo)localObject1).url))
      {
        int i1 = i2;
        if (i2 == i3) {
          i1 = i2 - 1;
        }
        if ((i1 >= 0) && (i1 < i3)) {
          ((PublishQueueTaskInfo)localObject1).url = ((String)g().get(i1));
        }
        if (!TextUtils.isEmpty(((PublishQueueTaskInfo)localObject1).url))
        {
          if (PublishUtils.b(((PublishQueueTaskInfo)localObject1).url) == 1) {
            ((PublishQueueTaskInfo)localObject1).showPreviewIcon = true;
          }
          localObject2 = new File(((PublishQueueTaskInfo)localObject1).url);
          if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()) && (isVideoTask()))
          {
            ((PublishQueueTaskInfo)localObject1).url = h();
            return localObject1;
          }
        }
      }
    }
    else if (isVideoTask())
    {
      ((PublishQueueTaskInfo)localObject1).url = h();
      ((PublishQueueTaskInfo)localObject1).showPreviewIcon = true;
      ((PublishQueueTaskInfo)localObject1).leftCount = 1;
    }
    return localObject1;
  }
  
  public long getLeaveSize()
  {
    if (this.q) {
      return QCircleConfigHelper.a("QZoneSetting", "LeaveWifiCheckSize", Integer.valueOf(10)).intValue() * 1024 * 1024;
    }
    long l1;
    if (!isVideoTask()) {
      l1 = this.M * 1024L - this.L * 1024L + i();
    } else {
      l1 = super.getLeaveSize();
    }
    return 0L + l1;
  }
  
  public String h()
  {
    if (!isVideoTask()) {
      return null;
    }
    return this.k.h;
  }
  
  public long i()
  {
    return j();
  }
  
  public boolean isVideoTask()
  {
    return this.k != null;
  }
  
  public long j()
  {
    boolean bool = isVideoTask();
    long l1 = 0L;
    if (bool)
    {
      if (this.k.s > 0.0D) {
        return this.k.s;
      }
      return this.k.g;
    }
    Object localObject = this.c;
    long l2 = l1;
    if (localObject != null)
    {
      l2 = l1;
      if (((List)localObject).size() > 0)
      {
        int i1 = 0;
        localObject = this.c.iterator();
        for (;;)
        {
          l2 = l1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          String str = (String)((Iterator)localObject).next();
          l2 = l1;
          if (i1 > this.ap - 1) {
            l2 = ((float)l1 + ImageUtil.a(str, this.u));
          }
          i1 += 1;
          l1 = l2;
        }
      }
    }
    return l2;
  }
  
  protected String k()
  {
    return "";
  }
  
  protected void l()
  {
    if ((this.ai != null) && ((this.ai instanceof AUploadMediaUploadRequest)))
    {
      ((AUploadMediaUploadRequest)this.ai).a();
      this.N = BatchIDGenerator.a();
      if (q() > 0) {
        this.aF.clear();
      }
      String str = ao;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(k());
      localStringBuilder.append(", checkRequestReentrant, cancel old request, reGenerateBatchId:");
      localStringBuilder.append(this.N);
      QLog.w(str, 1, localStringBuilder.toString());
    }
  }
  
  public void onRemove()
  {
    super.onRemove();
    VideoCompressTask localVideoCompressTask = this.aE;
    if (localVideoCompressTask != null) {
      localVideoCompressTask.d();
    }
    cancel();
  }
  
  public void onRestore()
  {
    super.onRestore();
    this.B = true;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.B)
    {
      this.N = BatchIDGenerator.a();
      this.B = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.task.AUploadBaseUploadShuoShuoTask
 * JD-Core Version:    0.7.0.1
 */