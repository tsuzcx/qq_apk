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
import com.tencent.mobileqq.pb.PBUInt64Field;
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
import tencent.im.oidb.cmd0xf4d.oidb_0xf4d.DanmuSummaryInfo;
import tencent.im.oidb.cmd0xf4d.oidb_0xf4d.ExtraInfo;
import tencent.im.oidb.cmd0xf4d.oidb_0xf4d.PostAccountInfo;
import tencent.im.oidb.cmd0xf4d.oidb_0xf4d.ReportInfo;
import tencent.im.oidb.cmd0xf4d.oidb_0xf4d.ReqBody;
import tencent.im.oidb.cmd0xf4d.oidb_0xf4d.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/model/RIJDanmakuHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "app", "Lcom/tencent/common/app/AppInterface;", "(Lcom/tencent/common/app/AppInterface;)V", "getCommandList", "", "", "observerClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "onReceive", "", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "requestDanmakuData", "observer", "rowkey", "beginDeltaTime", "", "endDeltaTime", "cookie", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDanmakuHandler
  extends BusinessHandler
{
  public static final RIJDanmakuHandler.Companion a = new RIJDanmakuHandler.Companion(null);
  
  public RIJDanmakuHandler(@Nullable AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public final void a(@NotNull Object paramObject, @NotNull String paramString1, int paramInt1, int paramInt2, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "observer");
    Intrinsics.checkParameterIsNotNull(paramString1, "rowkey");
    Intrinsics.checkParameterIsNotNull(paramString2, "cookie");
    String str = RIJQQAppInterfaceUtil.d();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestDanmakuData: rowkey=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", beginDeltaTime=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", endDeltaTime=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("RIJDanmakuModel", 2, ((StringBuilder)localObject).toString());
    }
    if (str != null)
    {
      localObject = new oidb_0xf4d.ReqBody();
      ((oidb_0xf4d.ReqBody)localObject).uin.set(str);
      ((oidb_0xf4d.ReqBody)localObject).uin_source.set(1);
      ((oidb_0xf4d.ReqBody)localObject).rowkey.set(paramString1);
      ((oidb_0xf4d.ReqBody)localObject).begin_delta_time.set(paramInt1);
      ((oidb_0xf4d.ReqBody)localObject).end_delta_time.set(paramInt2);
      ((oidb_0xf4d.ReqBody)localObject).danmu_cookie.set(ByteStringMicro.copyFromUtf8(paramString2));
      paramString2 = super.makeOIDBPkg("OidbSvc.0xf4d", 3917, 0, ((oidb_0xf4d.ReqBody)localObject).toByteArray());
      paramString2.addAttribute("VALUE_OBSERVER_TAG", Integer.valueOf(paramObject.hashCode()));
      paramString2.addAttribute("VALUE_REQUEST_ROWKEY", paramString1);
      paramString2.addAttribute("VALUE_REQUEST_BEGIN_TIME", Integer.valueOf(paramInt1));
      super.sendPbReq(paramString2);
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
    boolean bool2;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess() == true) && (paramObject != null)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    Object localObject4 = null;
    if (paramToServiceMsg != null) {
      localObject1 = paramToServiceMsg.getAttribute("VALUE_REQUEST_ROWKEY");
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof String)) {
      localObject2 = null;
    }
    localObject2 = (String)localObject2;
    if (paramToServiceMsg != null) {
      localObject1 = paramToServiceMsg.getAttribute("VALUE_OBSERVER_TAG");
    } else {
      localObject1 = null;
    }
    Object localObject3 = localObject1;
    if (!(localObject1 instanceof Integer)) {
      localObject3 = null;
    }
    localObject3 = (Integer)localObject3;
    if (paramToServiceMsg != null) {
      paramToServiceMsg = paramToServiceMsg.getAttribute("VALUE_REQUEST_BEGIN_TIME");
    } else {
      paramToServiceMsg = null;
    }
    Object localObject1 = paramToServiceMsg;
    if (!(paramToServiceMsg instanceof Integer)) {
      localObject1 = null;
    }
    paramToServiceMsg = (Integer)localObject1;
    Bundle localBundle = new Bundle();
    Object localObject5;
    boolean bool1;
    if (QLog.isColorLevel())
    {
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("onReceive: rowkey=");
      ((StringBuilder)localObject5).append((String)localObject2);
      ((StringBuilder)localObject5).append(", isSuccess=");
      ((StringBuilder)localObject5).append(bool2);
      ((StringBuilder)localObject5).append(',');
      ((StringBuilder)localObject5).append(" resultCode=");
      localObject1 = localObject4;
      if (paramFromServiceMsg != null) {
        localObject1 = Integer.valueOf(paramFromServiceMsg.getResultCode());
      }
      ((StringBuilder)localObject5).append(localObject1);
      ((StringBuilder)localObject5).append(", dataIsNull=");
      if (paramObject == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((StringBuilder)localObject5).append(bool1);
      QLog.d("RIJDanmakuModel", 2, ((StringBuilder)localObject5).toString());
    }
    int i;
    if (bool2)
    {
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      if (paramObject != null)
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        i = paramFromServiceMsg.uint32_result.get();
        paramObject = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
        paramFromServiceMsg = new oidb_0xf4d.RspBody();
        paramFromServiceMsg.mergeFrom(paramObject);
        int j = paramFromServiceMsg.pull_interval.get();
        if (paramFromServiceMsg.is_forbid.get() == 1) {
          bool1 = bool3;
        } else {
          bool1 = false;
        }
        Object localObject6 = paramFromServiceMsg.danmu_detail_list.get();
        paramObject = (oidb_0xf4d.ExtraInfo)paramFromServiceMsg.extra_info.get();
        localObject5 = paramObject.report_info.get();
        localObject4 = (oidb_0xf4d.DanmuSummaryInfo)paramObject.danmu_summary_info.get();
        paramObject = new ArrayList();
        localObject1 = ((oidb_0xf4d.DanmuSummaryInfo)localObject4).danmu_cookie.get();
        long l1 = ((oidb_0xf4d.DanmuSummaryInfo)localObject4).danmu_total_nums.get();
        localObject4 = ((oidb_0xf4d.DanmuSummaryInfo)localObject4).open_text.get();
        Object localObject7;
        if (QLog.isColorLevel())
        {
          localObject7 = new StringBuilder();
          ((StringBuilder)localObject7).append("onReceive: innerResultCode=");
          ((StringBuilder)localObject7).append(i);
          ((StringBuilder)localObject7).append(',');
          ((StringBuilder)localObject7).append(" ret=");
          ((StringBuilder)localObject7).append(paramFromServiceMsg.ret.get());
          ((StringBuilder)localObject7).append(", errMsg=");
          ((StringBuilder)localObject7).append(paramFromServiceMsg.err_message.get());
          ((StringBuilder)localObject7).append(',');
          ((StringBuilder)localObject7).append(" interval=");
          ((StringBuilder)localObject7).append(j);
          ((StringBuilder)localObject7).append(", isForbid=");
          ((StringBuilder)localObject7).append(bool1);
          ((StringBuilder)localObject7).append(',');
          ((StringBuilder)localObject7).append(" danmkuListSize=");
          ((StringBuilder)localObject7).append(((List)localObject6).size());
          ((StringBuilder)localObject7).append(", reportInfoListSize=");
          ((StringBuilder)localObject7).append(((List)localObject5).size());
          ((StringBuilder)localObject7).append(" cookie=");
          ((StringBuilder)localObject7).append(localObject1);
          ((StringBuilder)localObject7).append(", danmakuCount=");
          ((StringBuilder)localObject7).append(l1);
          ((StringBuilder)localObject7).append(", openText=");
          ((StringBuilder)localObject7).append((String)localObject4);
          QLog.d("RIJDanmakuModel", 2, ((StringBuilder)localObject7).toString());
        }
        paramFromServiceMsg = ((List)localObject6).iterator();
        while (paramFromServiceMsg.hasNext())
        {
          localObject6 = (oidb_0xf4d.DanmuDetail)paramFromServiceMsg.next();
          localObject7 = (oidb_0xf4d.DanmuBaseInfo)((oidb_0xf4d.DanmuDetail)localObject6).danmu_base_info.get();
          localObject6 = (oidb_0xf4d.PostAccountInfo)((oidb_0xf4d.DanmuDetail)localObject6).post_account_info.get();
          String str1 = ((oidb_0xf4d.DanmuBaseInfo)localObject7).danmu_id.get();
          Intrinsics.checkExpressionValueIsNotNull(str1, "danmakuBaseInfo.danmu_id.get()");
          i = ((oidb_0xf4d.DanmuBaseInfo)localObject7).danmu_type.get();
          int k = ((oidb_0xf4d.DanmuBaseInfo)localObject7).danmu_source.get();
          String str2 = ((oidb_0xf4d.DanmuBaseInfo)localObject7).danmu_content.get();
          Intrinsics.checkExpressionValueIsNotNull(str2, "danmakuBaseInfo.danmu_content.get()");
          localObject7 = new DanmakuInfo(str1, i, k, str2, ((oidb_0xf4d.DanmuBaseInfo)localObject7).post_delta_time.get(), ((oidb_0xf4d.DanmuBaseInfo)localObject7).rowkey.get());
          str1 = ((oidb_0xf4d.PostAccountInfo)localObject6).uin.get();
          Intrinsics.checkExpressionValueIsNotNull(str1, "postAccountInfo.uin.get()");
          localObject6 = new DanmakuDetail((DanmakuInfo)localObject7, new UserInfo(str1, ((oidb_0xf4d.PostAccountInfo)localObject6).uin_source.get(), ((oidb_0xf4d.PostAccountInfo)localObject6).nick_name.get(), ((oidb_0xf4d.PostAccountInfo)localObject6).avatar_url.get()));
          long l2 = ((DanmakuInfo)localObject7).e();
          if (paramToServiceMsg != null) {
            i = paramToServiceMsg.intValue();
          } else {
            i = 0;
          }
          if (l2 >= i)
          {
            paramObject.add(localObject6);
            if (QLog.isColorLevel())
            {
              localObject7 = new StringBuilder();
              ((StringBuilder)localObject7).append("onReceive: addDanmaku=");
              ((StringBuilder)localObject7).append(localObject6);
              QLog.d("RIJDanmakuModel", 2, ((StringBuilder)localObject7).toString());
            }
          }
          else if (QLog.isColorLevel())
          {
            localObject7 = new StringBuilder();
            ((StringBuilder)localObject7).append("onReceive: error time, danmuku=");
            ((StringBuilder)localObject7).append(localObject6);
            QLog.d("RIJDanmakuModel", 2, ((StringBuilder)localObject7).toString());
          }
        }
        paramFromServiceMsg = new ArrayList();
        localObject5 = ((List)localObject5).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (oidb_0xf4d.ReportInfo)((Iterator)localObject5).next();
          i = ((oidb_0xf4d.ReportInfo)localObject6).show_type.get();
          localObject6 = ((oidb_0xf4d.ReportInfo)localObject6).show_text.get();
          Intrinsics.checkExpressionValueIsNotNull(localObject6, "info.show_text.get()");
          localObject6 = new ReportInfo(i, (String)localObject6);
          paramFromServiceMsg.add(localObject6);
          if (QLog.isColorLevel())
          {
            localObject7 = new StringBuilder();
            ((StringBuilder)localObject7).append("onReceive: reportInfo=");
            ((StringBuilder)localObject7).append(localObject6);
            QLog.d("RIJDanmakuModel", 2, ((StringBuilder)localObject7).toString());
          }
        }
        localBundle.putString("VALUE_COOKIE", ((ByteStringMicro)localObject1).toStringUtf8());
        localBundle.putLong("VALUE_DANMAKU_COUNT", l1);
        localBundle.putString("VALUE_OPEN_TEXT", (String)localObject4);
        localBundle.putInt("VALUE_PULL_INTERVAL", j);
        localBundle.putBoolean("VALUE_IS_FORBID", bool1);
        localBundle.putParcelableArrayList("VALUE_DANMAKU_LIST", paramObject);
        localBundle.putParcelableArrayList("VALUE_REPORT_INFO_LIST", paramFromServiceMsg);
        paramFromServiceMsg = "VALUE_REQUEST_ROWKEY";
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.ByteArray");
      }
    }
    else
    {
      paramFromServiceMsg = "VALUE_REQUEST_ROWKEY";
    }
    localBundle.putString(paramFromServiceMsg, (String)localObject2);
    if (localObject3 != null) {
      i = ((Integer)localObject3).intValue();
    } else {
      i = 0;
    }
    localBundle.putInt("VALUE_OBSERVER_TAG", i);
    if (paramToServiceMsg != null) {
      i = paramToServiceMsg.intValue();
    } else {
      i = 0;
    }
    localBundle.putInt("VALUE_REQUEST_BEGIN_TIME", i);
    super.notifyUI(0, bool2, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.model.RIJDanmakuHandler
 * JD-Core Version:    0.7.0.1
 */