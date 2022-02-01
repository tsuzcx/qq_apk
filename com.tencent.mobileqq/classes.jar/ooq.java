import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xea0.oidb_cmd0xea0.DynamicBannerItem;
import tencent.im.oidb.cmd0xea0.oidb_cmd0xea0.ReqBody;
import tencent.im.oidb.cmd0xea0.oidb_cmd0xea0.RspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerModule;", "Lcom/tencent/biz/pubaccount/readinjoy/model/ReadInJoyEngineModule;", "app", "Lcom/tencent/common/app/AppInterface;", "entityManager", "Lcom/tencent/mobileqq/persistence/EntityManager;", "executor", "Ljava/util/concurrent/ExecutorService;", "msfService", "Lcom/tencent/biz/pubaccount/readinjoy/protocol/ReadInJoyMSFService;", "mainThreadHandler", "Landroid/os/Handler;", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/util/concurrent/ExecutorService;Lcom/tencent/biz/pubaccount/readinjoy/protocol/ReadInJoyMSFService;Landroid/os/Handler;)V", "bannerInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerModule$ChannelBannerInfo;", "requestTimeMap", "", "getChannelBannerInfoList", "channelId", "getPageName", "", "dynamicJson", "handleReceiveChannelBannerInfo", "", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "onReceive", "requestChannelBannerInfo", "serviceType", "unInitialize", "ChannelBannerInfo", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ooq
  extends pqj
{
  public static final oos a;
  private final ConcurrentHashMap<Integer, List<oor>> a;
  private final ConcurrentHashMap<Integer, Long> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_Oos = new oos(null);
  }
  
  public ooq(@Nullable AppInterface paramAppInterface, @Nullable EntityManager paramEntityManager, @Nullable ExecutorService paramExecutorService, @Nullable qfo paramqfo, @Nullable Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqfo, paramHandler);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private final String a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("pts_page_name");
      Intrinsics.checkExpressionValueIsNotNull(paramString, "jsonObject.optString(PTS_LITE_PAGE_NAME)");
      return paramString;
    }
    catch (JSONException paramString)
    {
      QLog.e("RIJChannelBannerModule", 1, "[getPageName] failed, e = " + paramString);
    }
    return "";
  }
  
  private final void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    paramToServiceMsg = new oidb_cmd0xea0.RspBody();
    int i = qfq.a(paramFromServiceMsg, paramObject, (MessageMicro)paramToServiceMsg);
    QLog.i("RIJChannelBannerModule", 1, "[handleReceiveChannelBannerInfo], result = " + i);
    if (i == 0)
    {
      paramFromServiceMsg = paramToServiceMsg.channel_id;
      label102:
      oor localoor;
      if (paramFromServiceMsg != null)
      {
        i = (int)paramFromServiceMsg.get();
        paramFromServiceMsg = new ArrayList();
        paramObject = paramToServiceMsg.dynamic_banner_list;
        if ((!paramObject.has()) || (paramObject.size() <= 0)) {
          break label327;
        }
        int k = paramObject.size();
        if (j >= k) {
          break label327;
        }
        paramToServiceMsg = paramObject.get(j);
        Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "dynamicBannerList[i]");
        oidb_cmd0xea0.DynamicBannerItem localDynamicBannerItem = (oidb_cmd0xea0.DynamicBannerItem)paramToServiceMsg;
        localoor = new oor(this);
        localoor.a(i);
        paramToServiceMsg = localDynamicBannerItem.unique_id;
        if (paramToServiceMsg == null) {
          break label309;
        }
        paramToServiceMsg = paramToServiceMsg.get();
        if (paramToServiceMsg == null) {
          break label309;
        }
        paramToServiceMsg = paramToServiceMsg.toString();
        if (paramToServiceMsg == null) {
          break label309;
        }
        label173:
        localoor.a(paramToServiceMsg);
        paramToServiceMsg = localDynamicBannerItem.dynamic_json;
        if (paramToServiceMsg == null) {
          break label315;
        }
        paramToServiceMsg = paramToServiceMsg.get();
        if (paramToServiceMsg == null) {
          break label315;
        }
        paramToServiceMsg = paramToServiceMsg.toString();
        if (paramToServiceMsg == null) {
          break label315;
        }
        label207:
        localoor.c(paramToServiceMsg);
        paramToServiceMsg = localDynamicBannerItem.card_report_json;
        if (paramToServiceMsg == null) {
          break label321;
        }
        paramToServiceMsg = paramToServiceMsg.get();
        if (paramToServiceMsg == null) {
          break label321;
        }
        paramToServiceMsg = paramToServiceMsg.toString();
        if (paramToServiceMsg == null) {
          break label321;
        }
      }
      for (;;)
      {
        localoor.d(paramToServiceMsg);
        localoor.b(a(localoor.c()));
        paramFromServiceMsg.add(localoor);
        QLog.i("RIJChannelBannerModule", 1, "[handleReceiveChannelBannerInfo], channelBannerInfo: " + localoor);
        j += 1;
        break label102;
        i = 0;
        break;
        label309:
        paramToServiceMsg = "";
        break label173;
        label315:
        paramToServiceMsg = "";
        break label207;
        label321:
        paramToServiceMsg = "";
      }
      label327:
      ((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Integer.valueOf(i), paramFromServiceMsg);
      pfd.a().d(i, (List)paramFromServiceMsg);
    }
  }
  
  @Nullable
  public final List<oor> a(int paramInt)
  {
    return (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if (!oow.a.a(paramInt1))
    {
      QLog.i("RIJChannelBannerModule", 1, "[requestChannelBannerInfo] do not request, channelId = " + paramInt1);
      return;
    }
    oow localoow = oow.a;
    Object localObject = (Long)this.b.get(Integer.valueOf(paramInt1));
    if (localObject != null) {}
    while (!localoow.a(((Long)localObject).longValue()))
    {
      QLog.i("RIJChannelBannerModule", 1, "[requestChannelBannerInfo] do not request, limit request frequency.");
      return;
      localObject = Long.valueOf(0L);
    }
    localObject = new oidb_cmd0xea0.ReqBody();
    ((oidb_cmd0xea0.ReqBody)localObject).req_client_type.set(1);
    ((oidb_cmd0xea0.ReqBody)localObject).version.set("8.4.5");
    ((oidb_cmd0xea0.ReqBody)localObject).channel_id.set(paramInt1);
    localObject = qfq.a("OidbSvc.0xea0", 3744, paramInt2, ((oidb_cmd0xea0.ReqBody)localObject).toByteArray());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyOidbHelper.make…e, reqBody.toByteArray())");
    a((ToServiceMsg)localObject);
    long l = System.currentTimeMillis();
    ((Map)this.b).put(Integer.valueOf(paramInt1), Long.valueOf(l));
    QLog.i("RIJChannelBannerModule", 1, "[requestChannelBannerInfo], channelId = " + paramInt1 + ", serviceType = " + paramInt2 + ", timeStamp = " + l);
  }
  
  public void a(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    if (paramFromServiceMsg != null) {}
    for (String str = paramFromServiceMsg.getServiceCmd();; str = null)
    {
      if (TextUtils.equals((CharSequence)str, (CharSequence)"OidbSvc.0xea0")) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ooq
 * JD-Core Version:    0.7.0.1
 */