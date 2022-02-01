package com.tencent.mobileqq.qqlive.api.impl.pendant;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.impl.IQQLiveBaseModule;
import com.tencent.mobileqq.qqlive.api.pendant.IQQLiveModulePendant;
import com.tencent.mobileqq.qqlive.callback.pendant.PendantInfoCallBack;
import com.tencent.mobileqq.qqlive.data.pendant.PendantViewData;
import com.tencent.mobileqq.qqlive.data.pendant.PicPendantData;
import com.tencent.mobileqq.qqlive.data.pendant.PushWebPendantData;
import com.tencent.mobileqq.qqlive.data.pendant.WebPendantData;
import com.tencent.mobileqq.qqlive.listener.pendant.PendantPushListener;
import com.tencent.mobileqq.qqlive.listener.pendant.PendantWebDataPushListener;
import com.tencent.mobileqq.qqlive.push.api.IQQLivePushCallback;
import com.tencent.mobileqq.qqlive.push.api.IQQLiveRoomPushService;
import com.tencent.mobileqq.qqlive.push.api.PushReceiver;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.mobileqq.qqlive.sso.QQLiveCallbackObserver;
import com.tencent.mobileqq.qqlive.utils.ThreadCenter;
import com.tencent.mobileqq.qqlive.utils.ThreadCenter.HandlerKeyable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.pendant.ilivePendantSvr.ilivePendantSvr.nano.PendantInfo;
import com.tencent.trpcprotocol.pendant.ilivePendantSvr.ilivePendantSvr.nano.PendantInfoData;
import com.tencent.trpcprotocol.pendant.ilivePendantSvr.ilivePendantSvr.nano.PicUrlNumExtend;
import com.tencent.trpcprotocol.pendant.ilivePendantSvr.ilivePendantSvr.nano.PullViewInfoReq;
import com.tencent.trpcprotocol.pendant.ilivePendantSvr.ilivePendantSvr.nano.PullViewInfoRsp;
import com.tencent.trpcprotocol.pendant.ilivePendantSvr.ilivePendantSvr.nano.PushPendantData;
import com.tencent.trpcprotocol.pendant.ilivePendantSvr.ilivePendantSvr.nano.UpdateFrequency;
import com.tencent.trpcprotocol.pendant.ilivePendantSvr.ilivePendantSvr.nano.ViewInfo;
import com.tencent.trpcprotocol.pendant.ilivePendantSvr.ilivePendantSvr.nano.ViewItemInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class QQLiveModulePendant
  extends IQQLiveBaseModule
  implements IQQLiveModulePendant, ThreadCenter.HandlerKeyable
{
  public static final int MILL_SECOND = 1000;
  private static final int MIN_SECOND = 60;
  private static final String PULL_VIEW_INFO_METHOD = "PullViewInfo";
  private static final int PUSH_PENDANT_DATA = 209;
  private static final int PUSH_WEB_DATA_CMD = 210;
  private static final long ROOM_ID_WRAPPER = 4294967295L;
  private static final String SERVICE_NAME = "trpc.qlive.pendant_svr.Pendant";
  private static final String TAG = "QQLiveModulePendant";
  private long anchorUid = 0L;
  private Set<PendantInfoCallBack> fetchInfoListeners = new HashSet();
  private final Runnable fetchInfoRun = new QQLiveModulePendant.4(this);
  private final AtomicBoolean isStartQuery = new AtomicBoolean(false);
  private final IQQLivePushCallback pendantPushCallback = new QQLiveModulePendant.1(this);
  private final IQQLivePushCallback pendantWebPushDataCallback = new QQLiveModulePendant.2(this);
  private List<PendantPushListener> pushListenerList = new ArrayList();
  private PushReceiver pushReceiver;
  private List<PendantWebDataPushListener> pushWebDataListenerList = new ArrayList();
  private long roomId = 0L;
  private long updateDuration = 0L;
  private PushReceiver webPushReceiver;
  
  private void appendMetaData(String paramString, StringBuilder paramStringBuilder)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = paramString.getString(str1);
        paramStringBuilder.append("&");
        paramStringBuilder.append(str1);
        paramStringBuilder.append("=");
        paramStringBuilder.append(str2);
      }
      return;
    }
    catch (Exception paramString)
    {
      paramStringBuilder = new StringBuilder();
      paramStringBuilder.append("appendMetaData exception fail ");
      paramStringBuilder.append(paramString.getMessage());
      QLog.d("QQLiveModulePendant", 1, paramStringBuilder.toString());
    }
  }
  
  private String buildWebDataUrl(String paramString1, long paramLong, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString1);
    if (paramString1.contains("?")) {
      localStringBuilder.append("&");
    } else {
      localStringBuilder.append("?");
    }
    localStringBuilder.append("roomId=");
    localStringBuilder.append(this.roomId & 0xFFFFFFFF);
    localStringBuilder.append("&anchorId=");
    localStringBuilder.append(this.anchorUid);
    localStringBuilder.append("&view_id=");
    localStringBuilder.append(paramLong);
    appendMetaData(paramString2, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  private void doFetchPendantInfo()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doFetchPendantInfo roomId:");
    ((StringBuilder)localObject).append(this.roomId);
    QLog.d("QQLiveModulePendant", 4, ((StringBuilder)localObject).toString());
    localObject = new PullViewInfoReq();
    ((PullViewInfoReq)localObject).a = this.roomId;
    IQQLiveSsoModule localIQQLiveSsoModule = (IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module");
    if (localIQQLiveSsoModule != null) {
      localIQQLiveSsoModule.a("trpc.qlive.pendant_svr.Pendant", "PullViewInfo", MessageNano.toByteArray((MessageNano)localObject), new QQLiveCallbackObserver(new QQLiveModulePendant.3(this)));
    }
  }
  
  private void handlePushData(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = transferViewInfoToBean("0xd1", ViewInfo.a(paramArrayOfByte));
      if (this.pushListenerList != null)
      {
        Iterator localIterator = this.pushListenerList.iterator();
        while (localIterator.hasNext()) {
          ((PendantPushListener)localIterator.next()).a(paramArrayOfByte);
        }
      }
      return;
    }
    catch (InvalidProtocolBufferNanoException paramArrayOfByte)
    {
      QLog.e("QQLiveModulePendant", 1, "the protocol error in handlePushData ");
      paramArrayOfByte.printStackTrace();
    }
  }
  
  private void handlePushWebPendantData(byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject = PushPendantData.a(paramArrayOfByte);
      paramArrayOfByte = new PushWebPendantData();
      paramArrayOfByte.viewId = ((PushPendantData)localObject).b;
      paramArrayOfByte.webData = ((PushPendantData)localObject).a;
      if (this.pushWebDataListenerList != null)
      {
        localObject = this.pushWebDataListenerList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((PendantWebDataPushListener)((Iterator)localObject).next()).a(paramArrayOfByte);
        }
      }
      return;
    }
    catch (InvalidProtocolBufferNanoException paramArrayOfByte)
    {
      QLog.e("QQLiveModulePendant", 1, "the protocol error in handlePushWebPendantData ");
      localObject = this.pushWebDataListenerList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((PendantWebDataPushListener)((Iterator)localObject).next()).a(false, -1, "the protocol error in handlePushWebPendantData ");
      }
      paramArrayOfByte.printStackTrace();
    }
  }
  
  private PicPendantData transPendantInfoToPicBean(PendantInfo paramPendantInfo)
  {
    PicPendantData localPicPendantData = new PicPendantData();
    localPicPendantData.picPendantId = paramPendantInfo.a;
    localPicPendantData.redirectUrl = paramPendantInfo.c;
    localPicPendantData.coverUrl = paramPendantInfo.b;
    localPicPendantData.visible = paramPendantInfo.d;
    localPicPendantData.startTs = paramPendantInfo.e;
    localPicPendantData.endTs = paramPendantInfo.f;
    localPicPendantData.serverTs = paramPendantInfo.g;
    localPicPendantData.actionLimit = paramPendantInfo.l;
    if (paramPendantInfo.h != null) {
      localPicPendantData.number = paramPendantInfo.h.a;
    }
    return localPicPendantData;
  }
  
  private ArrayList<PendantViewData> transToPendantServiceBean(String paramString, PullViewInfoRsp paramPullViewInfoRsp)
  {
    ArrayList localArrayList = new ArrayList();
    paramPullViewInfoRsp = paramPullViewInfoRsp.a;
    int j = paramPullViewInfoRsp.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(transferViewInfoToBean(paramString, paramPullViewInfoRsp[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  private PendantViewData transferViewInfoToBean(String paramString, ViewInfo paramViewInfo)
  {
    PendantViewData localPendantViewData = new PendantViewData();
    localPendantViewData.viewId = paramViewInfo.a;
    localPendantViewData.viewType = paramViewInfo.b;
    localPendantViewData.version = paramViewInfo.c;
    localPendantViewData.visible = paramViewInfo.d;
    localPendantViewData.minUpdateDuration = paramViewInfo.e.a;
    localPendantViewData.maxUpdateDuration = paramViewInfo.e.b;
    int i = 0;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramViewInfo.f);
      localPendantViewData.viewWidth = ViewUtils.dip2px(localJSONObject.optInt("width", 0));
      localPendantViewData.viewHeight = ViewUtils.dip2px(localJSONObject.optInt("height", 0));
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    Object localObject;
    if (paramViewInfo.b == 1L)
    {
      localObject = new WebPendantData();
      ((WebPendantData)localObject).dataCmd = paramString;
      ((WebPendantData)localObject).pendantWebUrl = buildWebDataUrl(paramViewInfo.h.a, paramViewInfo.a, paramViewInfo.f);
      ((WebPendantData)localObject).pendantWebData = paramViewInfo.h.b;
      localPendantViewData.webPendantData = ((WebPendantData)localObject);
      return localPendantViewData;
    }
    if (paramViewInfo.h.c == null)
    {
      QLog.d("QQLiveModulePendant", 1, " the view info of pci is null");
      return null;
    }
    if (paramViewInfo.h.c.a == null)
    {
      QLog.e("QQLiveModulePendant", 1, "transferViewInfoToBean viewInfo.getInfo().getPendantData().getInfosList() == null return null");
      return null;
    }
    paramString = paramViewInfo.h.c.a;
    int j = paramString.length;
    while (i < j)
    {
      localObject = transPendantInfoToPicBean(paramString[i]);
      localPendantViewData.picInfos.add(localObject);
      i += 1;
    }
    localPendantViewData.businessData = paramViewInfo.h.c.b;
    return localPendantViewData;
  }
  
  public void addFetchPendantInfoListener(PendantInfoCallBack paramPendantInfoCallBack)
  {
    if ((paramPendantInfoCallBack != null) && (!this.fetchInfoListeners.contains(paramPendantInfoCallBack))) {
      this.fetchInfoListeners.add(paramPendantInfoCallBack);
    }
  }
  
  public void addPendantPushListener(PendantPushListener paramPendantPushListener)
  {
    if (!this.pushListenerList.contains(paramPendantPushListener)) {
      this.pushListenerList.add(paramPendantPushListener);
    }
  }
  
  public void addPendantWebPushListener(PendantWebDataPushListener paramPendantWebDataPushListener)
  {
    if (!this.pushWebDataListenerList.contains(paramPendantWebDataPushListener)) {
      this.pushWebDataListenerList.add(paramPendantWebDataPushListener);
    }
  }
  
  public void destroy()
  {
    this.isStartQuery.set(false);
    this.pushReceiver.a();
    this.webPushReceiver.a();
    ThreadCenter.b(this, this.fetchInfoRun);
    this.pushListenerList.clear();
    this.pushWebDataListenerList.clear();
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    super.init(paramIQQLiveSDK);
    paramIQQLiveSDK = (IQQLiveRoomPushService)paramIQQLiveSDK.getExtModule("roomPush");
    this.pushReceiver = paramIQQLiveSDK.a().a(209, this.pendantPushCallback);
    this.webPushReceiver = paramIQQLiveSDK.a().a(210, this.pendantWebPushDataCallback);
  }
  
  public void removeFetchPendantInfoListener(PendantInfoCallBack paramPendantInfoCallBack)
  {
    this.fetchInfoListeners.remove(paramPendantInfoCallBack);
  }
  
  public void removePendantPushListener(PendantPushListener paramPendantPushListener)
  {
    this.pushListenerList.remove(paramPendantPushListener);
  }
  
  public void removePendantWebPushListener(PendantWebDataPushListener paramPendantWebDataPushListener)
  {
    this.pushWebDataListenerList.remove(paramPendantWebDataPushListener);
  }
  
  public void reset()
  {
    this.isStartQuery.set(false);
    this.pushReceiver.a();
    this.webPushReceiver.a();
    ThreadCenter.b(this, this.fetchInfoRun);
    this.pushListenerList.clear();
    this.pushWebDataListenerList.clear();
  }
  
  public void startFetchPendantInfo(long paramLong1, long paramLong2)
  {
    if (this.isStartQuery.get())
    {
      QLog.d("QQLiveModulePendant", 1, "the pendant fetch looper is beginning ");
      return;
    }
    this.anchorUid = paramLong1;
    this.roomId = paramLong2;
    ThreadCenter.a(this, this.fetchInfoRun);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.pendant.QQLiveModulePendant
 * JD-Core Version:    0.7.0.1
 */