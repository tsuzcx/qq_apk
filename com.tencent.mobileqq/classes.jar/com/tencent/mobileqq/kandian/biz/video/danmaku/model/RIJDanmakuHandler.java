package com.tencent.mobileqq.kandian.biz.video.danmaku.model;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuDetail;
import com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuInfo;
import com.tencent.mobileqq.kandian.biz.video.danmaku.ReportInfo;
import com.tencent.mobileqq.kandian.biz.video.danmaku.UserInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xf4d.oidb_0xf4d.DanmuBaseInfo;
import tencent.im.oidb.cmd0xf4d.oidb_0xf4d.DanmuDetail;
import tencent.im.oidb.cmd0xf4d.oidb_0xf4d.ExtraInfo;
import tencent.im.oidb.cmd0xf4d.oidb_0xf4d.PostAccountInfo;
import tencent.im.oidb.cmd0xf4d.oidb_0xf4d.ReportInfo;
import tencent.im.oidb.cmd0xf4d.oidb_0xf4d.ReqBody;
import tencent.im.oidb.cmd0xf4d.oidb_0xf4d.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/model/RIJDanmakuHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "app", "Lcom/tencent/common/app/AppInterface;", "(Lcom/tencent/common/app/AppInterface;)V", "getCommandList", "", "", "observerClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "onReceive", "", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "requestDanmakuData", "observer", "rowkey", "beginDeltaTime", "", "endDeltaTime", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDanmakuHandler
  extends BusinessHandler
{
  public static final RIJDanmakuHandler.Companion a = new RIJDanmakuHandler.Companion(null);
  
  public RIJDanmakuHandler(@Nullable AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public final void a(@NotNull Object paramObject, @NotNull String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "observer");
    Intrinsics.checkParameterIsNotNull(paramString, "rowkey");
    Object localObject1 = RIJQQAppInterfaceUtil.a();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("requestDanmakuData: rowkey=");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(", beginDeltaTime=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(", endDeltaTime=");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.d("RIJDanmakuModel", 2, ((StringBuilder)localObject2).toString());
    }
    if (localObject1 != null)
    {
      localObject2 = new oidb_0xf4d.ReqBody();
      ((oidb_0xf4d.ReqBody)localObject2).uin.set((String)localObject1);
      ((oidb_0xf4d.ReqBody)localObject2).uin_source.set(1);
      ((oidb_0xf4d.ReqBody)localObject2).rowkey.set(paramString);
      ((oidb_0xf4d.ReqBody)localObject2).begin_delta_time.set(paramInt1);
      ((oidb_0xf4d.ReqBody)localObject2).end_delta_time.set(paramInt2);
      localObject1 = super.makeOIDBPkg("OidbSvc.0xf4d", 3917, 0, ((oidb_0xf4d.ReqBody)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).addAttribute("VALUE_OBSERVER_TAG", Integer.valueOf(paramObject.hashCode()));
      ((ToServiceMsg)localObject1).addAttribute("VALUE_REQUEST_ROWKEY", paramString);
      ((ToServiceMsg)localObject1).addAttribute("VALUE_REQUEST_BEGIN_TIME", Integer.valueOf(paramInt1));
      super.sendPbReq((ToServiceMsg)localObject1);
    }
  }
  
  @NotNull
  public Set<String> getCommandList()
  {
    return SetsKt.mutableSetOf(new String[] { "OidbSvc.0xf4d" });
  }
  
  @NotNull
  protected Class<? extends BusinessObserver> observerClass()
  {
    return RIJDanmakuModel.class;
  }
  
  public void onReceive(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    boolean bool3 = true;
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess() == true) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ArrayList localArrayList = null;
    if (paramToServiceMsg != null) {
      localObject1 = paramToServiceMsg.getAttribute("VALUE_REQUEST_ROWKEY");
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof String)) {
      localObject2 = null;
    }
    String str1 = (String)localObject2;
    Object localObject3 = "VALUE_OBSERVER_TAG";
    if (paramToServiceMsg != null) {
      localObject1 = paramToServiceMsg.getAttribute("VALUE_OBSERVER_TAG");
    } else {
      localObject1 = null;
    }
    localObject2 = localObject1;
    if (!(localObject1 instanceof Integer)) {
      localObject2 = null;
    }
    Object localObject1 = (Integer)localObject2;
    if (paramToServiceMsg != null) {
      paramToServiceMsg = paramToServiceMsg.getAttribute("VALUE_REQUEST_BEGIN_TIME");
    } else {
      paramToServiceMsg = null;
    }
    localObject2 = paramToServiceMsg;
    if (!(paramToServiceMsg instanceof Integer)) {
      localObject2 = null;
    }
    localObject2 = (Integer)localObject2;
    Bundle localBundle = new Bundle();
    Object localObject4;
    boolean bool2;
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("onReceive: rowkey=");
      ((StringBuilder)localObject4).append(str1);
      ((StringBuilder)localObject4).append(", isSuccess=");
      ((StringBuilder)localObject4).append(bool1);
      ((StringBuilder)localObject4).append(", resultCode=");
      paramToServiceMsg = localArrayList;
      if (paramFromServiceMsg != null) {
        paramToServiceMsg = Integer.valueOf(paramFromServiceMsg.getResultCode());
      }
      ((StringBuilder)localObject4).append(paramToServiceMsg);
      ((StringBuilder)localObject4).append(", dataIsNull=");
      if (paramObject == null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      ((StringBuilder)localObject4).append(bool2);
      QLog.d("RIJDanmakuModel", 2, ((StringBuilder)localObject4).toString());
    }
    int i;
    if (bool1)
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      if (paramObject != null)
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        i = paramToServiceMsg.uint32_result.get();
        paramFromServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        paramToServiceMsg = new oidb_0xf4d.RspBody();
        paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        int j = paramToServiceMsg.pull_interval.get();
        if (paramToServiceMsg.is_forbid.get() == 1) {
          bool2 = bool3;
        } else {
          bool2 = false;
        }
        paramFromServiceMsg = paramToServiceMsg.danmu_detail_list.get();
        localObject4 = ((oidb_0xf4d.ExtraInfo)paramToServiceMsg.extra_info.get()).report_info.get();
        localArrayList = new ArrayList();
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("onReceive: innerResultCode=");
          paramObject.append(i);
          paramObject.append(", ret=");
          paramObject.append(paramToServiceMsg.ret.get());
          paramObject.append(", errMsg=");
          paramObject.append(paramToServiceMsg.err_message.get());
          paramObject.append(", interval=");
          paramObject.append(j);
          paramObject.append(", isForbid=");
          paramObject.append(bool2);
          paramObject.append(", danmkuListSize=");
          paramObject.append(paramFromServiceMsg.size());
          paramObject.append(", reportInfoListSize=");
          paramObject.append(((List)localObject4).size());
          QLog.d("RIJDanmakuModel", 2, paramObject.toString());
        }
        paramObject = paramFromServiceMsg.iterator();
        paramToServiceMsg = (ToServiceMsg)localObject1;
        paramFromServiceMsg = (FromServiceMsg)localObject3;
        while (paramObject.hasNext())
        {
          localObject1 = (oidb_0xf4d.DanmuDetail)paramObject.next();
          localObject3 = (oidb_0xf4d.DanmuBaseInfo)((oidb_0xf4d.DanmuDetail)localObject1).danmu_base_info.get();
          localObject1 = (oidb_0xf4d.PostAccountInfo)((oidb_0xf4d.DanmuDetail)localObject1).post_account_info.get();
          String str2 = ((oidb_0xf4d.DanmuBaseInfo)localObject3).danmu_id.get();
          Intrinsics.checkExpressionValueIsNotNull(str2, "danmakuBaseInfo.danmu_id.get()");
          i = ((oidb_0xf4d.DanmuBaseInfo)localObject3).danmu_type.get();
          int k = ((oidb_0xf4d.DanmuBaseInfo)localObject3).danmu_source.get();
          String str3 = ((oidb_0xf4d.DanmuBaseInfo)localObject3).danmu_content.get();
          Intrinsics.checkExpressionValueIsNotNull(str3, "danmakuBaseInfo.danmu_content.get()");
          localObject3 = new DanmakuInfo(str2, i, k, str3, ((oidb_0xf4d.DanmuBaseInfo)localObject3).post_delta_time.get(), ((oidb_0xf4d.DanmuBaseInfo)localObject3).rowkey.get());
          str2 = ((oidb_0xf4d.PostAccountInfo)localObject1).uin.get();
          Intrinsics.checkExpressionValueIsNotNull(str2, "postAccountInfo.uin.get()");
          localObject1 = new DanmakuDetail((DanmakuInfo)localObject3, new UserInfo(str2, ((oidb_0xf4d.PostAccountInfo)localObject1).uin_source.get(), ((oidb_0xf4d.PostAccountInfo)localObject1).nick_name.get(), ((oidb_0xf4d.PostAccountInfo)localObject1).avatar_url.get()));
          long l = ((DanmakuInfo)localObject3).a();
          if (localObject2 != null) {
            i = ((Integer)localObject2).intValue();
          } else {
            i = 0;
          }
          if (l >= i)
          {
            localArrayList.add(localObject1);
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("onReceive: addDanmaku=");
              ((StringBuilder)localObject3).append(localObject1);
              QLog.d("RIJDanmakuModel", 2, ((StringBuilder)localObject3).toString());
            }
          }
          else if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("onReceive: error time, danmuku=");
            ((StringBuilder)localObject3).append(localObject1);
            QLog.d("RIJDanmakuModel", 2, ((StringBuilder)localObject3).toString());
          }
        }
        paramObject = new ArrayList();
        localObject1 = ((List)localObject4).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (oidb_0xf4d.ReportInfo)((Iterator)localObject1).next();
          i = ((oidb_0xf4d.ReportInfo)localObject3).show_type.get();
          localObject3 = ((oidb_0xf4d.ReportInfo)localObject3).show_text.get();
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "info.show_text.get()");
          localObject3 = new ReportInfo(i, (String)localObject3);
          paramObject.add(localObject3);
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("onReceive: reportInfo=");
            ((StringBuilder)localObject4).append(localObject3);
            QLog.d("RIJDanmakuModel", 2, ((StringBuilder)localObject4).toString());
          }
        }
        localBundle.putInt("VALUE_PULL_INTERVAL", j);
        localBundle.putBoolean("VALUE_IS_FORBID", bool2);
        localBundle.putParcelableArrayList("VALUE_DANMAKU_LIST", localArrayList);
        localBundle.putParcelableArrayList("VALUE_REPORT_INFO_LIST", paramObject);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.ByteArray");
      }
    }
    else
    {
      paramFromServiceMsg = "VALUE_OBSERVER_TAG";
      paramToServiceMsg = (ToServiceMsg)localObject1;
    }
    localBundle.putString("VALUE_REQUEST_ROWKEY", str1);
    if (paramToServiceMsg != null) {
      i = paramToServiceMsg.intValue();
    } else {
      i = 0;
    }
    localBundle.putInt(paramFromServiceMsg, i);
    if (localObject2 != null) {
      i = ((Integer)localObject2).intValue();
    } else {
      i = 0;
    }
    localBundle.putInt("VALUE_REQUEST_BEGIN_TIME", i);
    super.notifyUI(0, bool1, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.model.RIJDanmakuHandler
 * JD-Core Version:    0.7.0.1
 */