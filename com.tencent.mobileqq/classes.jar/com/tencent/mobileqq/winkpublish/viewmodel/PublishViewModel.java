package com.tencent.mobileqq.winkpublish.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.api.IAEEditorGenerateResultListener;
import com.tencent.aelight.camera.api.IAEEditorManagerForQzone;
import com.tencent.aelight.camera.api.IAEEditorUICallbackListener;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.QZoneAppConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AEEditorConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._PhotoConst;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._QAlbumConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.qcircle.api.event.QCircleClosePageEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleSelectTabEvent;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.account.LoginData;
import com.tencent.mobileqq.winkpublish.api.IPublishLauncher;
import com.tencent.mobileqq.winkpublish.api.IUploadLocalConfig;
import com.tencent.mobileqq.winkpublish.api.impl.DataManagerImpl;
import com.tencent.mobileqq.winkpublish.common.AUploadCommonSetting;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.common.config.LocalConfig;
import com.tencent.mobileqq.winkpublish.event.DraftDataChangeEvent;
import com.tencent.mobileqq.winkpublish.event.WinkDraftStatusEvent;
import com.tencent.mobileqq.winkpublish.model.DynamicArrayList;
import com.tencent.mobileqq.winkpublish.model.ImageInfo;
import com.tencent.mobileqq.winkpublish.model.MediaWrapper;
import com.tencent.mobileqq.winkpublish.model.PublishUploadParams;
import com.tencent.mobileqq.winkpublish.model.ShuoshuoContent;
import com.tencent.mobileqq.winkpublish.model.ShuoshuoVideoInfo;
import com.tencent.mobileqq.winkpublish.part.PublishContentPart;
import com.tencent.mobileqq.winkpublish.part.PublishContentPart.ContentSet;
import com.tencent.mobileqq.winkpublish.part.PublishSavePart;
import com.tencent.mobileqq.winkpublish.queue.AUploadTaskQueue;
import com.tencent.mobileqq.winkpublish.service.video.util.PublishVideoUtils;
import com.tencent.mobileqq.winkpublish.task.FSUploadShuoShuoTask;
import com.tencent.mobileqq.winkpublish.util.AlbumUtil;
import com.tencent.mobileqq.winkpublish.util.FSToastUtil;
import com.tencent.mobileqq.winkpublish.util.ImageQualityPreference;
import com.tencent.mobileqq.winkpublish.util.ImageUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleMapReporter;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qzone.LbsDataV2.PoiInfo;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.widget.QzoneEmotionUtils;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PublishViewModel
  extends BasePublishModel
  implements IAEEditorGenerateResultListener, IAEEditorUICallbackListener
{
  public static final String a;
  public static final int w = QCircleConfigHelper.aG() / 1000;
  public static boolean z = true;
  public String A;
  public long B;
  public String C;
  public long E;
  public String F;
  public LbsDataV2.PoiInfo G = null;
  public boolean H = false;
  PublishJumpModel I = new PublishJumpModel();
  public boolean J = true;
  protected PublishViewModel.EditVideoTimeOutRunnable K = new PublishViewModel.EditVideoTimeOutRunnable(this);
  private HashMap<String, ArrayList<String>> L = new HashMap();
  private HashMap<String, String> M;
  private boolean N = false;
  private ArrayList<String> O;
  private boolean P = false;
  private int Q;
  private boolean R = false;
  private boolean S = false;
  private Intent T;
  private PublishViewModel.AEEditorUIBroadcastReceiver U = new PublishViewModel.AEEditorUIBroadcastReceiver(this);
  public MutableLiveData<DynamicArrayList<String>> b = new MutableLiveData();
  public MutableLiveData<HashMap<String, LocalMediaInfo>> c = new MutableLiveData();
  public MutableLiveData<HashMap<String, ShuoshuoVideoInfo>> d = new MutableLiveData();
  public MutableLiveData<PublishContentPart.ContentSet> e = new MutableLiveData();
  public MutableLiveData<Boolean> f = new MutableLiveData();
  public DynamicArrayList<String> g = new DynamicArrayList();
  public HashMap<String, LocalMediaInfo> h = new HashMap();
  public String i;
  public HashMap<String, String> j = new HashMap();
  public boolean k;
  public String l = QCircleHostConstants._AEEditorConstants.AE_PHOTO_PICKER_TAB_ALBUM();
  public int m;
  public int n;
  public boolean o = false;
  protected long p;
  public boolean q = false;
  public int r;
  public boolean s = false;
  public boolean t = false;
  protected boolean u = false;
  boolean v = true;
  public long x;
  public String y = "";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("PublishViewModel");
    a = localStringBuilder.toString();
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i1 = QCircleConfigHelper.a("qqcircle", "QcircleEditVideoTimeout", Integer.valueOf(60000)).intValue();
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.K);
    RFThreadManager.getSerialThreadHandler().postDelayed(this.K, i1);
    this.K.a = paramLocalMediaInfo.missionID;
    Object localObject2 = QCircleMapReporter.getInstance();
    if (TextUtils.isEmpty(paramLocalMediaInfo.missionID)) {
      localObject1 = "NoId";
    } else {
      localObject1 = paramLocalMediaInfo.missionID;
    }
    ((QCircleMapReporter)localObject2).startKey((String)localObject1);
    IUploadLocalConfig localIUploadLocalConfig = AUploadCommonSetting.a();
    String str = QCirclePublishQualityReporter.E_VIDEO_EXPORT_START;
    FeedCloudCommon.Entry localEntry1 = QCircleReportHelper.newEntry("traceid", this.y);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramLocalMediaInfo.mediaOriginWidth);
    ((StringBuilder)localObject1).append("x");
    ((StringBuilder)localObject1).append(paramLocalMediaInfo.mediaOriginHeight);
    FeedCloudCommon.Entry localEntry2 = QCircleReportHelper.newEntry("ext1", ((StringBuilder)localObject1).toString());
    FeedCloudCommon.Entry localEntry3 = QCircleReportHelper.newEntry("ext2", String.valueOf(paramLocalMediaInfo.mediaOriginBitrate));
    FeedCloudCommon.Entry localEntry4 = QCircleReportHelper.newEntry("ext3", String.valueOf(paramLocalMediaInfo.mediaOriginSize));
    FeedCloudCommon.Entry localEntry5 = QCircleReportHelper.newEntry("ext4", String.valueOf(paramLocalMediaInfo.mDuration / 1000L));
    ArrayList localArrayList = paramLocalMediaInfo.mOriginPath;
    localObject2 = "";
    localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (paramLocalMediaInfo.mOriginPath.size() > 0) {
        localObject1 = (String)paramLocalMediaInfo.mOriginPath.get(0);
      }
    }
    localIUploadLocalConfig.uploadQualityReport(str, Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, localEntry3, localEntry4, localEntry5, QCircleReportHelper.newEntry("ext5", (String)localObject1), QCircleReportHelper.newEntry("ret_code", "0") }));
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, ImageInfo paramImageInfo)
  {
    if ((paramLocalMediaInfo.mediaWidth != 0) && (paramLocalMediaInfo.mediaHeight != 0))
    {
      paramImageInfo.m = paramLocalMediaInfo.mediaWidth;
      paramImageInfo.n = paramLocalMediaInfo.mediaHeight;
      return;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramLocalMediaInfo.path, localOptions);
    int i1 = ImageUtil.b(paramLocalMediaInfo.path);
    if ((i1 != 90) && (i1 != 270))
    {
      paramImageInfo.m = localOptions.outWidth;
      paramImageInfo.n = localOptions.outHeight;
      return;
    }
    paramImageInfo.m = localOptions.outHeight;
    paramImageInfo.n = localOptions.outWidth;
  }
  
  private void a(PublishUploadParams paramPublishUploadParams, BasePartFragment paramBasePartFragment, ArrayList<MediaWrapper> paramArrayList, LocalMediaInfo paramLocalMediaInfo)
  {
    if (ImageQualityPreference.a().a(1, paramLocalMediaInfo) == 3) {
      bool = true;
    } else {
      bool = false;
    }
    this.u = bool;
    boolean bool = this.u;
    paramLocalMediaInfo.needProcess = (bool ^ true);
    paramLocalMediaInfo.mIsUploadOrigin = bool;
    paramPublishUploadParams.H = paramLocalMediaInfo.isVideoReady;
    paramPublishUploadParams.I = paramLocalMediaInfo.missionID;
    ShuoshuoVideoInfo localShuoshuoVideoInfo = PublishVideoUtils.a(paramBasePartFragment.getActivity(), paramLocalMediaInfo._id, paramLocalMediaInfo.path, paramLocalMediaInfo.fileSize, 1, paramLocalMediaInfo.thumbnailPath, paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mediaWidth, 0L, paramLocalMediaInfo.mDuration, paramLocalMediaInfo.mDuration, paramLocalMediaInfo.needProcess, null);
    Object localObject = localShuoshuoVideoInfo;
    if (localShuoshuoVideoInfo == null)
    {
      QLog.w(a, 1, "videoInfo == null and renew");
      localObject = PublishVideoUtils.a(paramBasePartFragment.getActivity(), paramLocalMediaInfo._id, paramLocalMediaInfo.path, paramLocalMediaInfo.fileSize, 1, null, paramLocalMediaInfo.thumbHeight, paramLocalMediaInfo.thumbWidth, 0L, paramLocalMediaInfo.mDuration, paramLocalMediaInfo.mDuration, paramLocalMediaInfo.needProcess, null, false);
    }
    ((ShuoshuoVideoInfo)localObject).v = paramPublishUploadParams.b;
    PublishVideoUtils.a((ShuoshuoVideoInfo)localObject, "video_is_use_qcircle_rate", true);
    if ((paramLocalMediaInfo.mOriginPath != null) && (paramLocalMediaInfo.mOriginPath.size() > 0))
    {
      ((ShuoshuoVideoInfo)localObject).y = paramLocalMediaInfo.mOriginPath;
    }
    else
    {
      ((ShuoshuoVideoInfo)localObject).y = new ArrayList();
      ((ShuoshuoVideoInfo)localObject).y.add(paramLocalMediaInfo.path);
    }
    localObject = new MediaWrapper((ShuoshuoVideoInfo)localObject);
    if (((MediaWrapper)localObject).c().n == true)
    {
      ((MediaWrapper)localObject).c().n = paramLocalMediaInfo.needProcess;
      paramPublishUploadParams = ((MediaWrapper)localObject).c();
      int i1;
      if (paramLocalMediaInfo.needProcess == true) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      paramPublishUploadParams.l = i1;
      ((MediaWrapper)localObject).c().q = (true ^ paramLocalMediaInfo.needProcess);
    }
    else if (!paramLocalMediaInfo.needProcess)
    {
      ((MediaWrapper)localObject).c().n = false;
      ((MediaWrapper)localObject).c().l = 1;
      ((MediaWrapper)localObject).c().q = true;
    }
    ((MediaWrapper)localObject).f = paramLocalMediaInfo.mediaOriginWidth;
    ((MediaWrapper)localObject).g = paramLocalMediaInfo.mediaOriginHeight;
    ((MediaWrapper)localObject).h = paramLocalMediaInfo.mediaOriginSize;
    ((MediaWrapper)localObject).i = paramLocalMediaInfo.mediaOriginBitrate;
    ((MediaWrapper)localObject).j = paramLocalMediaInfo.mediaBitrate;
    ((MediaWrapper)localObject).a = paramLocalMediaInfo.materialID;
    ((MediaWrapper)localObject).b = paramLocalMediaInfo.filterID;
    ((MediaWrapper)localObject).c = paramLocalMediaInfo.materialName;
    ((MediaWrapper)localObject).d = paramLocalMediaInfo.scheme;
    ((MediaWrapper)localObject).e = paramLocalMediaInfo.showCircleTakeSame;
    ((MediaWrapper)localObject).k = paramLocalMediaInfo.mKuolieId;
    ((MediaWrapper)localObject).l = paramLocalMediaInfo.mKuolieCenterX;
    ((MediaWrapper)localObject).m = paramLocalMediaInfo.mKuolieCenterY;
    ((MediaWrapper)localObject).o = paramLocalMediaInfo.mKuolieWidthScale;
    ((MediaWrapper)localObject).p = paramLocalMediaInfo.mKuolieHeightScale;
    ((MediaWrapper)localObject).n = paramLocalMediaInfo.mKuolieRotate;
    bool = TextUtils.isEmpty((CharSequence)this.j.get("templateId"));
    paramBasePartFragment = "none";
    if (bool) {
      paramPublishUploadParams = "none";
    } else {
      paramPublishUploadParams = (String)this.j.get("templateId");
    }
    ((MediaWrapper)localObject).q = paramPublishUploadParams;
    if (TextUtils.isEmpty((CharSequence)this.j.get("filterId"))) {
      paramPublishUploadParams = "none";
    } else {
      paramPublishUploadParams = (String)this.j.get("filterId");
    }
    ((MediaWrapper)localObject).r = paramPublishUploadParams;
    if (TextUtils.isEmpty((CharSequence)this.j.get("stickerId"))) {
      paramPublishUploadParams = "none";
    } else {
      paramPublishUploadParams = (String)this.j.get("stickerId");
    }
    ((MediaWrapper)localObject).s = paramPublishUploadParams;
    if (TextUtils.isEmpty((CharSequence)this.j.get("textId"))) {
      paramPublishUploadParams = paramBasePartFragment;
    } else {
      paramPublishUploadParams = (String)this.j.get("textId");
    }
    ((MediaWrapper)localObject).t = paramPublishUploadParams;
    paramArrayList.add(localObject);
  }
  
  private void a(PublishUploadParams paramPublishUploadParams, ArrayList<MediaWrapper> paramArrayList, ArrayList<String> paramArrayList1, LocalMediaInfo paramLocalMediaInfo)
  {
    if (URLUtil.isNetworkUrl(paramLocalMediaInfo.path))
    {
      localObject = new ImageInfo();
      ((ImageInfo)localObject).a = paramLocalMediaInfo.path;
    }
    else
    {
      localObject = new ImageInfo(paramLocalMediaInfo.path);
      ((ImageInfo)localObject).k = paramLocalMediaInfo.panoramaPhotoType;
    }
    ((ImageInfo)localObject).r = paramLocalMediaInfo.mMimeType;
    if ((paramPublishUploadParams.z != null) && (paramPublishUploadParams.z.containsKey(paramLocalMediaInfo.path))) {
      ((ImageInfo)localObject).h.put("mark_uin_upload", paramPublishUploadParams.z.get(paramLocalMediaInfo.path));
    }
    ((ImageInfo)localObject).e = paramPublishUploadParams.b;
    a(paramLocalMediaInfo, (ImageInfo)localObject);
    ((ImageInfo)localObject).o = paramLocalMediaInfo.mediaOriginWidth;
    ((ImageInfo)localObject).p = paramLocalMediaInfo.mediaOriginHeight;
    ((ImageInfo)localObject).q = paramLocalMediaInfo.mediaOriginSize;
    MediaWrapper localMediaWrapper = new MediaWrapper((ImageInfo)localObject);
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
    boolean bool = TextUtils.isEmpty((CharSequence)this.j.get("ImageTemplateId"));
    Object localObject = "none";
    if (bool) {
      paramPublishUploadParams = "none";
    } else {
      paramPublishUploadParams = (String)this.j.get("ImageTemplateId");
    }
    localMediaWrapper.q = paramPublishUploadParams;
    if (TextUtils.isEmpty((CharSequence)this.j.get("filterId"))) {
      paramPublishUploadParams = "none";
    } else {
      paramPublishUploadParams = (String)this.j.get("filterId");
    }
    localMediaWrapper.r = paramPublishUploadParams;
    if (TextUtils.isEmpty((CharSequence)this.j.get("stickerId"))) {
      paramPublishUploadParams = "none";
    } else {
      paramPublishUploadParams = (String)this.j.get("stickerId");
    }
    localMediaWrapper.s = paramPublishUploadParams;
    if (TextUtils.isEmpty((CharSequence)this.j.get("textId"))) {
      paramPublishUploadParams = "none";
    } else {
      paramPublishUploadParams = (String)this.j.get("textId");
    }
    localMediaWrapper.t = paramPublishUploadParams;
    if (TextUtils.isEmpty((CharSequence)this.j.get("frameId"))) {
      paramPublishUploadParams = "none";
    } else {
      paramPublishUploadParams = (String)this.j.get("frameId");
    }
    localMediaWrapper.u = paramPublishUploadParams;
    if (TextUtils.isEmpty((CharSequence)this.j.get("cropId"))) {
      paramPublishUploadParams = (PublishUploadParams)localObject;
    } else {
      paramPublishUploadParams = (String)this.j.get("cropId");
    }
    localMediaWrapper.v = paramPublishUploadParams;
    paramArrayList.add(localMediaWrapper);
    paramArrayList1.add(paramLocalMediaInfo.path);
  }
  
  public static boolean a(String paramString, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if (!((IAEResUtil)QRoute.api(IAEResUtil.class)).checkAEResVersionOK(AEResInfo.AE_RES_BASE_PACKAGE))
    {
      QLog.d(a, 1, "isPtuReady... checkAEResVersionOK not OK");
      return false;
    }
    if (paramHashMap.containsKey(paramString))
    {
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramHashMap.get(paramString);
      if (localLocalMediaInfo != null)
      {
        if ((TextUtils.isEmpty(localLocalMediaInfo.missionID)) && (AlbumUtil.b((LocalMediaInfo)paramHashMap.get(paramString))))
        {
          QLog.w(a, 1, "isPtuReady... missionId empty");
          return false;
        }
        return true;
      }
      QLog.w(a, 1, "isPtuReady... mediaInfo == null");
      return false;
    }
    QLog.w(a, 1, "isPtuReady... mSelectedVideoInfoMap.containsKey(videoPath) is false");
    return false;
  }
  
  private String b(String paramString, HashMap<String, String> paramHashMap)
  {
    Object localObject = paramString;
    if (paramHashMap != null)
    {
      localObject = paramString;
      if (paramHashMap.containsKey("atuin"))
      {
        String[] arrayOfString = ((String)paramHashMap.get("atuin")).split(",");
        ArrayList localArrayList = new ArrayList();
        localObject = new StringBuilder();
        int i1 = 0;
        while (i1 < arrayOfString.length)
        {
          paramHashMap = HostDataTransUtils.getFriendNickName(arrayOfString[i1]);
          if (!TextUtils.isEmpty(paramHashMap))
          {
            localArrayList.add(paramHashMap);
            paramHashMap = PublishContentPart.b(paramHashMap.replace("%", "%25").replace(",", "%2C").replace("}", "%7D").replace("{", "%7B").replace(":", "%3A").replace(">", "%3E"));
          }
          else
          {
            paramHashMap = arrayOfString[i1];
            localArrayList.add(arrayOfString[i1]);
          }
          ((StringBuilder)localObject).append("@{uin:");
          ((StringBuilder)localObject).append(arrayOfString[i1]);
          ((StringBuilder)localObject).append(",nick:");
          ((StringBuilder)localObject).append(paramHashMap);
          ((StringBuilder)localObject).append("} ");
          i1 += 1;
        }
        if (TextUtils.isEmpty(paramString))
        {
          paramString = new StringBuilder();
          paramString.append("\n");
          paramString.append(localObject);
          return paramString.toString();
        }
        paramHashMap = new StringBuilder();
        paramHashMap.append(paramString);
        paramHashMap.append("\n");
        paramHashMap.append(localObject);
        localObject = paramHashMap.toString();
      }
    }
    return localObject;
  }
  
  private ArrayList<String> d(Intent paramIntent)
  {
    ArrayList localArrayList = paramIntent.getStringArrayListExtra(QCircleHostConstants._PhotoConst.PHOTO_PATHS());
    HashMap localHashMap = (HashMap)paramIntent.getSerializableExtra(QCircleHostConstants._QAlbumConstants.SELECTED_MEDIA_INFO_HASH_MAP());
    paramIntent = (HashMap)paramIntent.getSerializableExtra("key_image_sucai_info");
    if (paramIntent != null) {
      this.j = paramIntent;
    }
    paramIntent = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getData4Intent... imagePaths:");
    localStringBuilder.append(localArrayList);
    QLog.d(paramIntent, 1, localStringBuilder.toString());
    if (localHashMap != null) {
      if (this.h != null)
      {
        QLog.d(a, 1, "getData4Intent... has old mSelectedMediaInfoMap");
        this.h.putAll(localHashMap);
      }
      else
      {
        this.h = localHashMap;
      }
    }
    if (this.h == null) {
      this.h = new HashMap();
    }
    return localArrayList;
  }
  
  public static boolean l()
  {
    return QCircleConfigHelper.a("qqcircle", "qqcircle_show_associate_tag_panel", Integer.valueOf(1)).intValue() == 1;
  }
  
  private void m()
  {
    Object localObject1 = new HashMap();
    Object localObject2 = this.g.iterator();
    String str;
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      ((HashMap)localObject1).put(str, (LocalMediaInfo)this.h.get(str));
    }
    this.h.clear();
    this.h.putAll((Map)localObject1);
    if (this.h != null)
    {
      localObject1 = this.L;
      if ((localObject1 != null) && (((HashMap)localObject1).size() > 0))
      {
        localObject2 = this.h.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (Map.Entry)((Iterator)localObject2).next();
          ArrayList localArrayList = (ArrayList)this.L.get(((Map.Entry)localObject1).getKey());
          if (localArrayList != null) {
            ((LocalMediaInfo)((Map.Entry)localObject1).getValue()).aiTextLabel = localArrayList;
          }
          str = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("path:");
          localStringBuilder.append((String)((Map.Entry)localObject1).getKey());
          localStringBuilder.append(" aiTextCache:");
          if (localArrayList != null) {
            localObject1 = localArrayList.toString();
          } else {
            localObject1 = "null";
          }
          localStringBuilder.append((String)localObject1);
          QLog.d(str, 1, localStringBuilder.toString());
        }
      }
    }
    localObject1 = a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("checkSelectMediaInfoMap... mSelectedMediaInfoMap size:");
    ((StringBuilder)localObject2).append(this.h.size());
    QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
  }
  
  private void n()
  {
    Object localObject = this.h;
    if ((localObject != null) && (((HashMap)localObject).size() > 0))
    {
      localObject = this.h.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((Map.Entry)((Iterator)localObject).next()).getValue();
        if ((AlbumUtil.b(localLocalMediaInfo)) && (!localLocalMediaInfo.isVideoReady)) {
          a(localLocalMediaInfo);
        }
        if ((AlbumUtil.b(localLocalMediaInfo)) && (TextUtils.isEmpty(localLocalMediaInfo.thumbnailPath))) {
          PublishVideoUtils.a(RFApplication.getApplication(), localLocalMediaInfo);
        }
      }
    }
  }
  
  private void o()
  {
    Object localObject1 = this.h;
    String str = "1";
    Object localObject5 = "0";
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = ((HashMap)localObject1).entrySet().iterator();
      localObject1 = "0";
      for (;;)
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (LocalMediaInfo)((Map.Entry)((Iterator)localObject3).next()).getValue();
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(((LocalMediaInfo)localObject4).mKuolieId)) {
          localObject2 = "1";
        }
        localObject1 = localObject2;
        if (((LocalMediaInfo)localObject4).mTextId > 0)
        {
          i1 = ((LocalMediaInfo)localObject4).mTextId;
          localObject1 = localObject2;
        }
      }
    }
    Object localObject2 = "0";
    long l1 = LoginData.a().b();
    int i1 = 1;
    if (QCircleHostQzoneHelper.getInt4Uin("qcircle_publish_selected_grid_save", 1, l1) != 1) {
      i1 = 0;
    }
    localObject1 = this.M;
    if (localObject1 != null)
    {
      localObject1 = (String)((HashMap)localObject1).get("traceid");
      localObject4 = localObject1;
      if (localObject1 != null) {}
    }
    else
    {
      localObject4 = "0";
    }
    localObject1 = p();
    if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
      localObject3 = TextUtils.join(";", (Iterable)localObject1);
    } else {
      localObject3 = "0";
    }
    if (this.G == null)
    {
      localObject1 = "2";
    }
    else
    {
      localObject1 = localObject5;
      if (this.H) {
        localObject1 = "1";
      }
    }
    localObject5 = new QCircleLpReportDc05504.DataBuilder();
    Object localObject4 = ((QCircleLpReportDc05504.DataBuilder)localObject5).setExt1(String.valueOf(this.m)).setExt2((String)localObject4).setExt5((String)localObject1);
    if (this.P) {
      localObject1 = "1";
    } else {
      localObject1 = "2";
    }
    localObject4 = ((QCircleLpReportDc05504.DataBuilder)localObject4).setExt6((String)localObject1);
    if (i1 != 0) {
      localObject1 = str;
    } else {
      localObject1 = "2";
    }
    ((QCircleLpReportDc05504.DataBuilder)localObject4).setExt7((String)localObject1).setExt8((String)localObject2).setExt12((String)localObject3);
    if (this.j.size() > 0)
    {
      boolean bool = TextUtils.isEmpty((CharSequence)this.j.get("shuiyinId"));
      localObject2 = "none";
      if (bool) {
        localObject1 = "none";
      } else {
        localObject1 = (String)this.j.get("shuiyinId");
      }
      localObject3 = ((QCircleLpReportDc05504.DataBuilder)localObject5).setExt9((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)this.j.get("filterId"))) {
        localObject1 = "none";
      } else {
        localObject1 = (String)this.j.get("filterId");
      }
      localObject3 = ((QCircleLpReportDc05504.DataBuilder)localObject3).setExt10((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)this.j.get("frameId"))) {
        localObject1 = "none";
      } else {
        localObject1 = (String)this.j.get("frameId");
      }
      localObject3 = ((QCircleLpReportDc05504.DataBuilder)localObject3).setExt11((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)this.j.get("stickerId"))) {
        localObject1 = "none";
      } else {
        localObject1 = (String)this.j.get("stickerId");
      }
      localObject3 = ((QCircleLpReportDc05504.DataBuilder)localObject3).setExt13((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)this.j.get("guajianId"))) {
        localObject1 = "none";
      } else {
        localObject1 = (String)this.j.get("guajianId");
      }
      localObject3 = ((QCircleLpReportDc05504.DataBuilder)localObject3).setExt14((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)this.j.get("templateId"))) {
        localObject1 = "none";
      } else {
        localObject1 = (String)this.j.get("templateId");
      }
      localObject3 = ((QCircleLpReportDc05504.DataBuilder)localObject3).setExt15((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)this.j.get("ImageTemplateId"))) {
        localObject1 = "none";
      } else {
        localObject1 = (String)this.j.get("ImageTemplateId");
      }
      localObject3 = ((QCircleLpReportDc05504.DataBuilder)localObject3).setExt16((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)this.j.get("textId"))) {
        localObject1 = "none";
      } else {
        localObject1 = (String)this.j.get("textId");
      }
      localObject3 = ((QCircleLpReportDc05504.DataBuilder)localObject3).setExt17((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)this.j.get("musicId"))) {
        localObject1 = localObject2;
      } else {
        localObject1 = (String)this.j.get("musicId");
      }
      ((QCircleLpReportDc05504.DataBuilder)localObject3).setExt18((String)localObject1);
    }
  }
  
  private List<String> p()
  {
    if (TextUtils.isEmpty(this.i)) {
      return null;
    }
    localArrayList = new ArrayList();
    Object localObject = new StringBuilder(this.i);
    localObject = PublishContentPart.r.matcher((CharSequence)localObject);
    try
    {
      while (((Matcher)localObject).find())
      {
        int i1 = ((Matcher)localObject).start();
        if (((Matcher)localObject).end() - i1 != 1) {
          localArrayList.add(((Matcher)localObject).group().substring(1));
        }
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      QLog.e(a, 1, localException, new Object[0]);
    }
  }
  
  public String a()
  {
    return a;
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.g;
    if ((localObject != null) && (paramInt < ((DynamicArrayList)localObject).size())) {
      localObject = (String)this.g.get(paramInt);
    } else {
      localObject = null;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      HashMap localHashMap = this.h;
      if ((localHashMap != null) && (localHashMap.containsKey(localObject)))
      {
        localObject = (LocalMediaInfo)this.h.remove(localObject);
        this.c.postValue(this.h);
      }
      this.g.remove(paramInt);
      this.b.postValue(this.g);
      j();
    }
  }
  
  public void a(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_wink_video_mission_id", h());
    ArrayList localArrayList = new ArrayList();
    if (this.g.get(0) != null)
    {
      localArrayList.add(this.h.get(this.g.get(0)));
      localIntent.putExtra("localMediaInfos", localArrayList);
    }
    ((IPublishLauncher)QRoute.api(IPublishLauncher.class)).startWithPublicFragmentActivityForPeak(paramActivity, localIntent);
  }
  
  public void a(Context paramContext)
  {
    this.I.a(paramContext, this.T, this.g, this.o, this.l, h());
    this.L.clear();
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent = d(paramIntent);
    if (paramIntent != null) {
      QLog.d(a, 1, new Object[] { "loadFromAlbumList pic size: ", Integer.valueOf(paramIntent.size()) });
    } else {
      QLog.d(a, 1, "loadFromAlbumList pic is null");
    }
    if ((paramIntent != null) && (this.g != null))
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadFromAlbumList... has selected size :");
      localStringBuilder.append(this.g.size());
      QLog.d(str, 1, localStringBuilder.toString());
      if (this.o) {
        this.g.clear();
      }
      this.g.addAll(paramIntent);
    }
    m();
    this.b.postValue(this.g);
    this.c.postValue(this.h);
    n();
    j();
  }
  
  public void a(BasePartFragment paramBasePartFragment)
  {
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).removeListener(this);
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).removeUICallbackListener(this);
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.K);
    o();
    Object localObject1 = paramBasePartFragment.getActivity().getIntent();
    if (localObject1 != null) {
      localObject1 = ((Intent)localObject1).getStringExtra("key_ext_param");
    } else {
      localObject1 = null;
    }
    PublishUploadParams localPublishUploadParams = new PublishUploadParams();
    String str = this.i;
    Object localObject2 = str;
    if (str != null) {
      localObject2 = str.trim();
    }
    localPublishUploadParams.b = ((String)localObject2);
    localPublishUploadParams.c = this.g;
    int i2 = 0;
    localPublishUploadParams.k = false;
    localPublishUploadParams.o = ImageQualityPreference.a().a(1, this.g, this.h);
    localPublishUploadParams.t = ((String)localObject1);
    localPublishUploadParams.w = this.r;
    localPublishUploadParams.N = this.P;
    localPublishUploadParams.O = this.y;
    localObject2 = ((PublishPoiViewModel)paramBasePartFragment.a(PublishPoiViewModel.class)).d();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new HashMap();
    }
    localPublishUploadParams.n = ((Map)localObject1);
    localPublishUploadParams.i = ((PublishPoiViewModel)paramBasePartFragment.a(PublishPoiViewModel.class)).h;
    localPublishUploadParams.j = ((PublishPoiViewModel)paramBasePartFragment.a(PublishPoiViewModel.class)).b();
    localPublishUploadParams.u = ((PublishPoiViewModel)paramBasePartFragment.a(PublishPoiViewModel.class)).c();
    localPublishUploadParams.I = h();
    localPublishUploadParams.m = ((PublishShareViewModel)paramBasePartFragment.a(PublishShareViewModel.class)).c;
    localPublishUploadParams.R = ((PublishJurisdictionViewModel)paramBasePartFragment.a(PublishJurisdictionViewModel.class)).c();
    localPublishUploadParams.S = ((PublishJurisdictionViewModel)paramBasePartFragment.a(PublishJurisdictionViewModel.class)).b();
    localObject1 = new ArrayList();
    localObject2 = ((PublishJurisdictionViewModel)paramBasePartFragment.a(PublishJurisdictionViewModel.class)).e.split(",");
    int i1 = 0;
    while (i1 < localObject2.length)
    {
      if (!localObject2[i1].equals("")) {
        ((ArrayList)localObject1).add(localObject2[i1]);
      }
      i1 += 1;
    }
    localPublishUploadParams.P = ((ArrayList)localObject1);
    localObject1 = new ArrayList();
    localObject2 = ((PublishJurisdictionViewModel)paramBasePartFragment.a(PublishJurisdictionViewModel.class)).d.split(",");
    i1 = i2;
    while (i1 < localObject2.length)
    {
      if (!localObject2[i1].equals("")) {
        ((ArrayList)localObject1).add(localObject2[i1]);
      }
      i1 += 1;
    }
    localPublishUploadParams.Q = ((ArrayList)localObject1);
    localPublishUploadParams.U = this.B;
    localPublishUploadParams.T = this.A;
    localPublishUploadParams.V = this.C;
    localPublishUploadParams.W = this.E;
    localPublishUploadParams.X = UUID.randomUUID().toString();
    a(localPublishUploadParams, paramBasePartFragment);
    a(localPublishUploadParams);
    a(paramBasePartFragment, 3, localPublishUploadParams.X);
    paramBasePartFragment.getActivity().finish();
    paramBasePartFragment.getActivity().overridePendingTransition(2130772349, 2130772350);
    SimpleEventBus.getInstance().dispatchEvent(new QCircleClosePageEvent());
    SimpleEventBus.getInstance().dispatchEvent(new QCircleSelectTabEvent(1));
  }
  
  public void a(BasePartFragment paramBasePartFragment, int paramInt)
  {
    a(paramBasePartFragment, paramInt, "");
  }
  
  public void a(BasePartFragment paramBasePartFragment, int paramInt, String paramString)
  {
    if (paramInt == 2) {
      return;
    }
    QLog.d(a, 1, "saveShuoshuo...");
    Object localObject1 = new ShuoshuoContent();
    DataManagerImpl localDataManagerImpl = new DataManagerImpl();
    Object localObject2 = this.i;
    if (localObject2 != null) {
      ((ShuoshuoContent)localObject1).e(QzoneEmotionUtils.emCodesToQQcodes((String)localObject2));
    }
    localObject2 = this.g;
    if ((localObject2 != null) && (((DynamicArrayList)localObject2).size() > 0)) {
      ((ShuoshuoContent)localObject1).a(new ArrayList(this.g));
    }
    ((ShuoshuoContent)localObject1).a(this.h);
    ((ShuoshuoContent)localObject1).a(((PublishShareViewModel)paramBasePartFragment.a(PublishShareViewModel.class)).c);
    long l1 = LoginData.a().b();
    ((ShuoshuoContent)localObject1).a(System.currentTimeMillis());
    if (!TextUtils.isEmpty(paramString)) {
      ((ShuoshuoContent)localObject1).a(paramString);
    }
    paramBasePartFragment = h();
    paramString = new StringBuilder();
    paramString.append("_flash_show_publish_");
    paramString.append(paramBasePartFragment);
    LocalConfig.a((ShuoshuoContent)localObject1, l1, paramString.toString());
    localDataManagerImpl.putMissionId(l1, paramBasePartFragment);
    if (QLog.isColorLevel()) {
      QLog.d(a, 1, new Object[] { "[saveShuoshuo] save missionId: ", paramBasePartFragment });
    }
    paramString = DataManagerImpl.trans2DraftBean(paramBasePartFragment, (ShuoshuoContent)localObject1);
    QCircleHostQzoneHelper.putInt4Uin("_flash_show_publish_", 1, l1);
    QCircleHostQzoneHelper.putInt4Uin("_flash_show_publish_draft_from", paramInt, l1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("_flash_show_has_select_cover");
    ((StringBuilder)localObject1).append(paramBasePartFragment);
    LocalConfig.a(((StringBuilder)localObject1).toString(), this.P, l1);
    QLog.d(a, 1, "[saveShuoshuo] saveShuoshuo finish.");
    SimpleEventBus.getInstance().dispatchEvent(new DraftDataChangeEvent(1, paramBasePartFragment, paramString));
  }
  
  public void a(BasePartFragment paramBasePartFragment, Intent paramIntent, boolean paramBoolean)
  {
    if (paramIntent == null)
    {
      QLog.e(a, 1, new Object[] { Integer.valueOf(1), "initData... intent == null" });
      return;
    }
    this.T = paramIntent;
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).init();
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).addListener(this);
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).addUICallbackListener(this);
    Object localObject1 = new IntentFilter();
    ((IntentFilter)localObject1).addAction("AEEDITOR_UPDATE_AI_TEXT");
    RFApplication.getApplication().registerReceiver(this.U, (IntentFilter)localObject1);
    this.y = paramIntent.getStringExtra(QCircleConstants.w);
    this.p = LoginData.a().b();
    this.M = ((HashMap)paramIntent.getSerializableExtra("key_attrs"));
    this.i = paramIntent.getStringExtra(QCircleHostQzoneHelper.QZONE_SHARE_SUMMERY());
    this.A = paramIntent.getStringExtra("PUBLISH_MUSIC_MID");
    this.B = paramIntent.getLongExtra("PUBLISH_MUSIC_ID", 0L);
    this.C = paramIntent.getStringExtra("PUBLISH_MUSIC_NAME");
    this.E = paramIntent.getLongExtra("PUBLISH_MUSIC_START_TIME", 0L);
    this.F = paramIntent.getStringExtra("PUBLISH_MUSIC_LOCAL_PATH");
    localObject1 = (HashMap)paramIntent.getSerializableExtra("PUBLISH_EDIT_DATONG_DATA");
    WinkDatongCurrentParams.params.clear();
    if (localObject1 != null) {
      WinkDatongCurrentParams.params.putAll((Map)localObject1);
    }
    localObject1 = (HashMap)paramIntent.getSerializableExtra("PUBLISH_EDIT_PUBLISH_DATA");
    WinkDatongCurrentParams.paramsForPublish.clear();
    if (localObject1 != null) {
      WinkDatongCurrentParams.paramsForPublish.putAll((Map)localObject1);
    }
    int i1;
    if (TextUtils.isEmpty(this.i)) {
      i1 = 0;
    } else {
      i1 = this.i.length();
    }
    this.i = b(this.i, this.M);
    if (!TextUtils.isEmpty(this.i)) {
      this.e.postValue(new PublishContentPart.ContentSet(this.i, i1));
    }
    this.O = paramIntent.getStringArrayListExtra(QCircleHostQzoneHelper.QZONE_SHARE_IMAGES());
    if ((this.O == null) && (!paramBoolean)) {
      a(paramIntent);
    }
    localObject1 = this.O;
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!this.g.contains(localObject2)) {
          a((String)localObject2);
        }
      }
      this.b.postValue(this.g);
      j();
    }
    this.r = paramIntent.getIntExtra(QCircleHostConstants.QZoneAppConstants.KEY_UPLOAD_ENTRANCE(), 23);
    this.s = true;
    this.t = true;
    this.m = paramIntent.getIntExtra("fromType", 1);
    this.n = paramIntent.getIntExtra(QCircleHostConstants._AEEditorConstants.VIDEO_PHOTO_FROM(), 2);
    this.N = paramIntent.getBooleanExtra("key_qcircle_publish_finish_jump_to_mainpage", false);
    this.v = paramIntent.getBooleanExtra("key_need_use_draft", false);
    if (!this.v) {
      this.v = paramIntent.getBooleanExtra("key_qcircle_pulish_use_draft", false);
    }
    if (QCircleHostQzoneHelper.getInt4Uin("_flash_show_publish_", 0, this.p) == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    this.R = paramIntent.getBooleanExtra("bundle_key_allow_long_video", false);
    this.x = paramIntent.getIntExtra("bundle_key_max_limit_video", w);
    QLog.d(a, 1, new Object[] { "initData... mQcircleFromType:", Integer.valueOf(this.m), " mQcircleUpType:", Integer.valueOf(this.n) });
    Object localObject2 = AUploadCommonSetting.a();
    String str = QCirclePublishQualityReporter.E_PUBLIC_ENTER;
    FeedCloudCommon.Entry localEntry1 = QCircleReportHelper.newEntry("traceid", this.y);
    FeedCloudCommon.Entry localEntry2 = QCircleReportHelper.newEntry("ext1", String.valueOf(this.m));
    if (i1 != 0) {
      localObject1 = "hasdraft";
    } else {
      localObject1 = "nodraft";
    }
    ((IUploadLocalConfig)localObject2).uploadQualityReport(str, Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, QCircleReportHelper.newEntry("ext2", (String)localObject1), QCircleReportHelper.newEntry("ret_code", "0") }));
    a(paramBasePartFragment, h());
    this.l = paramIntent.getStringExtra(QCircleHostConstants._AEEditorConstants.KEY_AE_EDITOR_FROM_PHOTO_PICKER_TAB());
  }
  
  public void a(BasePartFragment paramBasePartFragment, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("_flash_show_publish_");
    ((StringBuilder)localObject1).append(paramString);
    paramString = ((StringBuilder)localObject1).toString();
    localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("recoverDraft... key:");
    ((StringBuilder)localObject2).append(paramString);
    localObject2 = ((StringBuilder)localObject2).toString();
    boolean bool = true;
    QLog.d((String)localObject1, 1, (String)localObject2);
    localObject1 = LocalConfig.h(paramString, this.p);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.i = ((String)localObject1);
      localObject1 = this.e;
      localObject2 = this.i;
      ((MutableLiveData)localObject1).postValue(new PublishContentPart.ContentSet((String)localObject2, ((String)localObject2).length()));
    }
    int i1 = LocalConfig.f(paramString, this.p);
    localObject1 = (PublishShareViewModel)paramBasePartFragment.a(PublishShareViewModel.class);
    if ((i1 & 0x1) == 0) {
      bool = false;
    }
    ((PublishShareViewModel)localObject1).c = bool;
    ((PublishShareViewModel)paramBasePartFragment.a(PublishShareViewModel.class)).a.postValue(Boolean.valueOf(((PublishShareViewModel)paramBasePartFragment.a(PublishShareViewModel.class)).c));
    this.R = LocalConfig.a(paramString, this.p, false);
    this.x = LocalConfig.b(paramString, this.p, w);
    paramBasePartFragment = new StringBuilder();
    paramBasePartFragment.append("_flash_show_has_select_cover");
    paramBasePartFragment.append(h());
    this.P = LocalConfig.b(paramBasePartFragment.toString(), false, this.p);
  }
  
  protected void a(PublishUploadParams paramPublishUploadParams)
  {
    FSUploadShuoShuoTask localFSUploadShuoShuoTask = new FSUploadShuoShuoTask(67, 1, paramPublishUploadParams);
    localFSUploadShuoShuoTask.al = paramPublishUploadParams.X;
    localFSUploadShuoShuoTask.x = paramPublishUploadParams.w;
    localFSUploadShuoShuoTask.y = paramPublishUploadParams.C;
    AUploadTaskQueue.a().a(localFSUploadShuoShuoTask);
    paramPublishUploadParams = new WinkDraftStatusEvent(localFSUploadShuoShuoTask.getMissionId());
    paramPublishUploadParams.setUploadStatus(1);
    SimpleEventBus.getInstance().dispatchEvent(paramPublishUploadParams);
  }
  
  public void a(PublishUploadParams paramPublishUploadParams, BasePartFragment paramBasePartFragment)
  {
    Object localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    Object localObject4 = new ArrayList();
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < paramPublishUploadParams.c.size(); i2 = i3)
    {
      localObject1 = (String)paramPublishUploadParams.c.get(i1);
      localObject1 = (LocalMediaInfo)this.h.get(localObject1);
      if (localObject1 != null)
      {
        ((ArrayList)localObject2).add(localObject1);
      }
      else
      {
        localObject1 = new LocalMediaInfo();
        ((LocalMediaInfo)localObject1).path = ((String)this.g.get(i1));
        ((ArrayList)localObject2).add(localObject1);
      }
      if (AlbumUtil.c((LocalMediaInfo)localObject1))
      {
        a(paramPublishUploadParams, (ArrayList)localObject3, (ArrayList)localObject4, (LocalMediaInfo)localObject1);
        i3 = i2;
      }
      else
      {
        i3 = i2;
        if (AlbumUtil.b((LocalMediaInfo)localObject1))
        {
          a(paramPublishUploadParams, paramBasePartFragment, (ArrayList)localObject3, (LocalMediaInfo)localObject1);
          i3 = i2 + 1;
        }
      }
      i1 += 1;
    }
    if (i2 == 0) {
      PublishSavePart.a(paramPublishUploadParams.c);
    }
    paramPublishUploadParams.d = ((List)localObject2);
    paramPublishUploadParams.D = ((ArrayList)localObject3);
    paramPublishUploadParams.F = ((ArrayList)localObject4);
    paramPublishUploadParams.J = this.m;
    paramPublishUploadParams.K = this.n;
    boolean bool;
    if (QCircleHostQzoneHelper.getInt4Uin("qcircle_publish_selected_grid_save", QCircleConfigHelper.a("qqcircle", "qqcircle_save_media_in_device_when_publish", Integer.valueOf(0)).intValue(), LoginData.a().b()) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    paramPublishUploadParams.L = bool;
    Object localObject1 = AUploadCommonSetting.a();
    localObject2 = QCirclePublishQualityReporter.E_PUBLIC_EXIT_NORMAL;
    localObject3 = QCircleReportHelper.newEntry("traceid", this.y);
    localObject4 = QCircleReportHelper.newEntry("ret_code", "0");
    if (i2 == 0) {
      paramBasePartFragment = "pic";
    } else {
      paramBasePartFragment = "video";
    }
    ((IUploadLocalConfig)localObject1).uploadQualityReport((String)localObject2, Arrays.asList(new FeedCloudCommon.Entry[] { localObject3, localObject4, QCircleReportHelper.newEntry("ext1", paramBasePartFragment), QCircleReportHelper.newEntry("ext2", String.valueOf(paramPublishUploadParams.c.size())) }));
  }
  
  public void a(LbsDataV2.PoiInfo paramPoiInfo)
  {
    this.G = paramPoiInfo;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.i = paramString;
    this.k = paramBoolean;
    j();
  }
  
  public void a(boolean paramBoolean)
  {
    this.H = paramBoolean;
  }
  
  public boolean a(String paramString)
  {
    DynamicArrayList localDynamicArrayList = this.g;
    if (localDynamicArrayList != null)
    {
      if (localDynamicArrayList.contains(paramString)) {
        return false;
      }
      if (this.g.size() >= b())
      {
        paramString = String.format(HardCodeUtil.a(2131891843), new Object[] { Integer.valueOf(b()) });
        FSToastUtil.a(FSToastUtil.b, paramString, 0);
        return false;
      }
      if (!TextUtils.isEmpty(paramString))
      {
        this.g.add(paramString);
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    return 9;
  }
  
  public void b(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      if (paramActivity.getIntent() == null) {
        return;
      }
      HashMap localHashMap = (HashMap)paramActivity.getIntent().getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
      Object localObject = paramActivity.getIntent().getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if (localHashMap != null)
      {
        if (localObject == null) {
          return;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("key_wink_video_mission_id", h());
        ArrayList localArrayList = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList.add(localHashMap.get((String)((Iterator)localObject).next()));
        }
        localIntent.putExtra("localMediaInfos", localArrayList);
        localIntent.putExtra("PUBLISH_MUSIC_LOCAL_PATH", this.F);
        localIntent.putExtra("PUBLISH_MUSIC_START_TIME", this.E);
        ((IPublishLauncher)QRoute.api(IPublishLauncher.class)).startWithPublicFragmentActivityForPicPreview(paramActivity, localIntent);
      }
    }
  }
  
  public void b(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent = paramIntent.getParcelableArrayListExtra("publish_pic_preview_result_data_key");
    if (paramIntent == null) {
      return;
    }
    this.g.clear();
    this.h.clear();
    this.j.clear();
    paramIntent = paramIntent.iterator();
    while (paramIntent.hasNext())
    {
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramIntent.next();
      if ((localLocalMediaInfo != null) && (!TextUtils.isEmpty(localLocalMediaInfo.path)))
      {
        this.g.add(localLocalMediaInfo.path);
        this.h.put(localLocalMediaInfo.path, localLocalMediaInfo);
      }
    }
    m();
    this.b.postValue(this.g);
    this.c.postValue(this.h);
    j();
  }
  
  public void b(boolean paramBoolean)
  {
    this.S = paramBoolean;
  }
  
  public boolean b(String paramString)
  {
    HashMap localHashMap = this.h;
    if (localHashMap == null) {
      return false;
    }
    return a(paramString, localHashMap);
  }
  
  public void c()
  {
    Object localObject = this.h;
    if (localObject == null) {
      return;
    }
    localObject = ((HashMap)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((LocalMediaInfo)((Map.Entry)((Iterator)localObject).next()).getValue()).aiTextLabel = null;
    }
  }
  
  public void c(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    String str = (String)this.g.get(0);
    localIntent.putExtra(QCircleHostConstants._AEEditorConstants.KEY_VIDEO_MEDIA_PATH(), str);
    localIntent.putExtra("key_wink_video_mission_id", ((LocalMediaInfo)this.h.get(str)).missionID);
    localIntent.putExtra(QCircleHostConstants._AEEditorConstants.KEY_VIDEO_COVER_POSITION(), ((LocalMediaInfo)this.h.get(str)).thumbnailProgress);
    localIntent.putExtra(QCircleHostConstants._AEEditorConstants.KEY_VIDEO_COVER_PATH(), ((LocalMediaInfo)this.h.get(str)).thumbnailPath);
    localIntent.putExtra("key_is_video_progress_cover", ((LocalMediaInfo)this.h.get(str)).isProgressThumbnail);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.h.get(str));
    localIntent.putParcelableArrayListExtra("localMediaInfos", localArrayList);
    ((IPublishLauncher)QRoute.api(IPublishLauncher.class)).startWithPublicFragmentActivityForPeakForResult(paramActivity, localIntent, 8);
  }
  
  public void c(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra(QCircleHostConstants._AEEditorConstants.KEY_VIDEO_MEDIA_PATH());
    String str = paramIntent.getStringExtra(QCircleHostConstants._AEEditorConstants.KEY_VIDEO_COVER_PATH());
    boolean bool = paramIntent.getBooleanExtra("key_is_video_progress_cover", true);
    float f1 = paramIntent.getFloatExtra(QCircleHostConstants._AEEditorConstants.KEY_VIDEO_COVER_POSITION(), 0.5F);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)) && (this.h.get(localObject) != null))
    {
      paramIntent = (LocalMediaInfo)this.h.get(localObject);
      paramIntent.thumbnailPath = str;
      paramIntent.thumbnailProgress = f1;
      paramIntent.isProgressThumbnail = bool;
      this.P = true;
      paramIntent = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResult... 封面选择成功: progress = ");
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append(" | path = ");
      ((StringBuilder)localObject).append(str);
      QLog.d(paramIntent, 1, ((StringBuilder)localObject).toString());
      this.q = true;
      this.c.postValue(this.h);
    }
  }
  
  protected void d()
  {
    QLog.e(a, 1, new Object[] { Integer.valueOf(1), "handleEditVideoTimeOut: 圈子视频合成超时 missionId:", this.K.a });
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).cancelQFSMission(this.K.a);
    AUploadCommonSetting.a().mapReport(QCirclePublishQualityReporter.P_VIDEO_EXPORT_COST, this.K.a, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.y), QCircleReportHelper.newEntry("ext6", String.valueOf(this.Q)), QCircleReportHelper.newEntry("attach_info", "Peak"), QCircleReportHelper.newEntry("ret_code", "-80000007") }));
    AUploadCommonSetting.a().uploadQualityReport(QCirclePublishQualityReporter.E_VIDEO_EXPORT_RESULT, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.y), QCircleReportHelper.newEntry("ret_code", "0"), QCircleReportHelper.newEntry("ext6", String.valueOf(this.Q)), QCircleReportHelper.newEntry("attach_info", "Peak") }));
    RFThreadManager.getUIHandler().post(new PublishViewModel.1(this));
  }
  
  public void deleteMedia(int paramInt)
  {
    QLog.d(a, 1, new Object[] { "deleteMedia... position:", Integer.valueOf(paramInt) });
    HostUIHelper.closeHostEnvironment();
    a(paramInt);
  }
  
  public boolean e()
  {
    Object localObject = this.i;
    if ((localObject != null) && (!TextUtils.isEmpty(((String)localObject).trim()))) {
      return true;
    }
    localObject = this.g;
    return (localObject != null) && (!((ArrayList)localObject).isEmpty());
  }
  
  public boolean f()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      if (((ArrayList)localObject).isEmpty()) {
        return false;
      }
      localObject = (String)((ArrayList)localObject).get(0);
      if (localObject != null)
      {
        HashMap localHashMap = this.h;
        if (localHashMap == null) {
          return false;
        }
        localObject = (LocalMediaInfo)localHashMap.get(localObject);
        if (localObject != null)
        {
          if (!HostStaticInvokeHelper.validateVideoType(((LocalMediaInfo)localObject).mMimeType)) {
            return false;
          }
          return ((LocalMediaInfo)localObject).isVideoReady ^ true;
        }
      }
    }
    return false;
  }
  
  public String g()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      if (((ArrayList)localObject).isEmpty()) {
        return null;
      }
      localObject = (String)((ArrayList)localObject).get(0);
      if (localObject != null)
      {
        HashMap localHashMap = this.h;
        if (localHashMap == null) {
          return null;
        }
        localObject = (LocalMediaInfo)localHashMap.get(localObject);
        if (localObject != null)
        {
          if (!HostStaticInvokeHelper.validateVideoType(((LocalMediaInfo)localObject).mMimeType)) {
            return null;
          }
          return ((LocalMediaInfo)localObject).missionID;
        }
      }
    }
    return null;
  }
  
  public String h()
  {
    return this.T.getStringExtra("key_wink_video_mission_id");
  }
  
  public void i()
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clearDraft... mIsNeedUseDraft:");
    localStringBuilder.append(this.v);
    QLog.d(str, 1, localStringBuilder.toString());
    LocalConfig.b(this.p, "_flash_show_publish_");
    LocalMultiProcConfig.putInt4Uin("_flash_show_publish_", 0, this.p);
    QCircleHostQzoneHelper.putInt4Uin("_flash_show_publish_", 0, this.p);
  }
  
  public void j()
  {
    boolean bool = this.k;
    Boolean localBoolean = Boolean.valueOf(false);
    if (bool)
    {
      this.f.postValue(localBoolean);
      return;
    }
    DynamicArrayList localDynamicArrayList = this.g;
    if ((localDynamicArrayList != null) && (!localDynamicArrayList.isEmpty()))
    {
      this.f.postValue(Boolean.valueOf(true));
      return;
    }
    this.f.postValue(localBoolean);
  }
  
  public boolean k()
  {
    return this.S;
  }
  
  public void onAETavSessionExportCompleted(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    QLog.d(a, 1, new Object[] { "onAETavSessionExportCompleted... missionID:", paramString });
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.K);
    this.Q = 0;
    if ((paramLocalMediaInfo != null) && (!TextUtils.isEmpty(paramLocalMediaInfo.path)))
    {
      Object localObject = this.h;
      if (localObject != null)
      {
        localObject = (LocalMediaInfo)((HashMap)localObject).get(paramLocalMediaInfo.path);
        if (localObject != null)
        {
          QLog.d(a, 1, new Object[] { "onAETavSessionExportCompleted... oldMedia thumbnailPath:", ((LocalMediaInfo)localObject).thumbnailPath, " oldMedia.thumbnailProgress:", Float.valueOf(((LocalMediaInfo)localObject).thumbnailProgress) });
          paramLocalMediaInfo.thumbnailPath = ((LocalMediaInfo)localObject).thumbnailPath;
          paramLocalMediaInfo.thumbnailProgress = ((LocalMediaInfo)localObject).thumbnailProgress;
          this.h.put(paramLocalMediaInfo.path, paramLocalMediaInfo);
          this.c.postValue(this.h);
        }
        AUploadCommonSetting.a().mapReport(QCirclePublishQualityReporter.P_VIDEO_EXPORT_COST, paramString, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.y), QCircleReportHelper.newEntry("ret_code", "0"), QCircleReportHelper.newEntry("ext6", String.valueOf(this.Q)), QCircleReportHelper.newEntry("attach_info", "Peak") }));
        paramString = AUploadCommonSetting.a();
        localObject = QCirclePublishQualityReporter.E_VIDEO_EXPORT_RESULT;
        FeedCloudCommon.Entry localEntry1 = QCircleReportHelper.newEntry("traceid", this.y);
        FeedCloudCommon.Entry localEntry2 = QCircleReportHelper.newEntry("ret_code", "0");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramLocalMediaInfo.mediaWidth);
        localStringBuilder.append("x");
        localStringBuilder.append(paramLocalMediaInfo.mediaHeight);
        paramString.uploadQualityReport((String)localObject, Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, QCircleReportHelper.newEntry("ext1", localStringBuilder.toString()), QCircleReportHelper.newEntry("ext2", String.valueOf(paramLocalMediaInfo.mediaBitrate)), QCircleReportHelper.newEntry("ext3", String.valueOf(paramLocalMediaInfo.fileSize)), QCircleReportHelper.newEntry("ext4", String.valueOf(paramLocalMediaInfo.mDuration / 1000L)), QCircleReportHelper.newEntry("ext5", paramLocalMediaInfo.path), QCircleReportHelper.newEntry("ext6", String.valueOf(this.Q)), QCircleReportHelper.newEntry("attach_info", "Peak") }));
      }
    }
  }
  
  public void onAETavSessionExportError(String paramString1, int paramInt, String paramString2)
  {
    QLog.d(a, 1, new Object[] { "onAETavSessionExportError... missionID:", paramString1, " errorCode=", Integer.valueOf(paramInt) });
    if (paramInt != QCircleHostConstants._AEEditorConstants.GENERATE_ERROR_NODATA())
    {
      int i1 = this.Q;
      if (i1 < 2)
      {
        this.Q = (i1 + 1);
        ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).retryQFSMission(paramString1);
        RFThreadManager.getSerialThreadHandler().removeCallbacks(this.K);
        paramInt = QCircleConfigHelper.a("qqcircle", "QcircleEditVideoTimeout", Integer.valueOf(60000)).intValue();
        RFThreadManager.getSerialThreadHandler().postDelayed(this.K, paramInt);
        return;
      }
    }
    AUploadCommonSetting.a().mapReport(QCirclePublishQualityReporter.P_VIDEO_EXPORT_COST, paramString1, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.y), QCircleReportHelper.newEntry("ret_code", String.valueOf(paramInt)), QCircleReportHelper.newEntry("ext6", String.valueOf(this.Q)), QCircleReportHelper.newEntry("attach_info", "Peak") }));
    AUploadCommonSetting.a().uploadQualityReport(QCirclePublishQualityReporter.E_VIDEO_EXPORT_RESULT, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", this.y), QCircleReportHelper.newEntry("ret_code", String.valueOf(paramInt)), QCircleReportHelper.newEntry("desc", paramString2), QCircleReportHelper.newEntry("ext6", String.valueOf(this.Q)), QCircleReportHelper.newEntry("attach_info", "Peak") }));
  }
  
  public void onAETavSessionExporting(String paramString, float paramFloat)
  {
    QLog.d(a, 1, new Object[] { "onAETavSessionExporting... missionID:", paramString, " progress:", Float.valueOf(paramFloat) });
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.K);
    int i1 = QCircleConfigHelper.a("qqcircle", "QcircleEditVideoTimeout", Integer.valueOf(60000)).intValue();
    RFThreadManager.getSerialThreadHandler().postDelayed(this.K, i1);
  }
  
  public void onCleared()
  {
    super.onCleared();
    QLog.d(a, 1, "onCleared...");
    if (this.U != null) {
      try
      {
        RFApplication.getApplication().unregisterReceiver(this.U);
        this.U = null;
      }
      catch (Throwable localThrowable)
      {
        QLog.e(a, 1, "onCleared...", localThrowable);
      }
    }
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).removeListener(this);
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).removeUICallbackListener(this);
    RFThreadManager.getSerialThreadHandler().removeCallbacks(this.K);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.viewmodel.PublishViewModel
 * JD-Core Version:    0.7.0.1
 */