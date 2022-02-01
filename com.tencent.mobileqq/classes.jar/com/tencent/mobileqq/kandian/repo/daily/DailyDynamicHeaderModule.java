package com.tencent.mobileqq.kandian.repo.daily;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyRefreshOptimizeUtil;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModuleUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;

public class DailyDynamicHeaderModule
  extends ReadInJoyEngineModule
{
  private final Object a = new Object();
  private JSONObject b = null;
  
  public DailyDynamicHeaderModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    e();
  }
  
  public static JSONObject a(boolean paramBoolean)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = b();
    localJSONObject2.put("req_type", paramBoolean ^ true);
    localJSONObject1.put("dynamic_header_req_param", localJSONObject2);
    return localJSONObject1;
  }
  
  public static JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("ad_code", ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCityCode());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getProvince());
    localStringBuilder.append(" ");
    localStringBuilder.append(((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCity());
    localJSONObject.put("city_name", localStringBuilder.toString());
    return localJSONObject;
  }
  
  private void d()
  {
    oidb_cmd0x68b.ReqBody localReqBody = new oidb_cmd0x68b.ReqBody();
    long l = Long.valueOf(RIJQQAppInterfaceUtil.d()).longValue();
    localReqBody.uint64_uin.set(l);
    localReqBody.uint32_network_type.set(ArticleInfoModuleUtils.a());
    try
    {
      Object localObject = new JSONArray();
      ((JSONArray)localObject).put(a(false));
      localObject = ((JSONArray)localObject).toString();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[requestForUpdate] req: ");
        localStringBuilder.append((String)localObject);
        QLog.d("DynamicHeaderModule", 2, localStringBuilder.toString());
      }
      localReqBody.bytes_nearby_cookie.set(ByteStringMicro.copyFromUtf8((String)localObject));
    }
    catch (Exception localException)
    {
      QLog.e("DynamicHeaderModule", 1, "[requestForUpdate] ", localException);
    }
    sendPbReq(ReadInJoyOidbHelper.a("OidbSvc.0xcba", 3258, 0, localReqBody.toByteArray()));
  }
  
  private void e()
  {
    String str = (String)RIJSPUtils.b("sp_key_daily_dynamic_header_data", "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[startLoadFromDisk] json=");
    localStringBuilder.append(str);
    QLog.i("DynamicHeaderModule", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(str)) {
      a(str);
    }
  }
  
  public void a()
  {
    d();
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: new 59	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc 207
    //   11: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: ldc 140
    //   23: iconst_1
    //   24: aload_3
    //   25: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 194	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: aload_0
    //   32: getfield 19	com/tencent/mobileqq/kandian/repo/daily/DailyDynamicHeaderModule:a	Ljava/lang/Object;
    //   35: astore_3
    //   36: aload_3
    //   37: monitorenter
    //   38: iconst_0
    //   39: istore_2
    //   40: aload_0
    //   41: new 28	org/json/JSONObject
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 209	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   49: ldc 211
    //   51: invokevirtual 215	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   54: putfield 21	com/tencent/mobileqq/kandian/repo/daily/DailyDynamicHeaderModule:b	Lorg/json/JSONObject;
    //   57: aload_0
    //   58: getfield 21	com/tencent/mobileqq/kandian/repo/daily/DailyDynamicHeaderModule:b	Lorg/json/JSONObject;
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +27 -> 90
    //   66: iconst_1
    //   67: istore_2
    //   68: goto +22 -> 90
    //   71: astore_1
    //   72: goto +37 -> 109
    //   75: astore_1
    //   76: ldc 140
    //   78: iconst_1
    //   79: ldc 217
    //   81: aload_1
    //   82: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   85: aload_0
    //   86: aconst_null
    //   87: putfield 21	com/tencent/mobileqq/kandian/repo/daily/DailyDynamicHeaderModule:b	Lorg/json/JSONObject;
    //   90: aload_3
    //   91: monitorexit
    //   92: invokestatic 223	com/tencent/mobileqq/app/ThreadManagerV2:getUIHandlerV2	()Landroid/os/Handler;
    //   95: new 225	com/tencent/mobileqq/kandian/repo/daily/DailyDynamicHeaderModule$1
    //   98: dup
    //   99: aload_0
    //   100: iload_2
    //   101: invokespecial 228	com/tencent/mobileqq/kandian/repo/daily/DailyDynamicHeaderModule$1:<init>	(Lcom/tencent/mobileqq/kandian/repo/daily/DailyDynamicHeaderModule;Z)V
    //   104: invokevirtual 234	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   107: pop
    //   108: return
    //   109: aload_3
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	DailyDynamicHeaderModule
    //   0	113	1	paramString	String
    //   39	62	2	bool	boolean
    //   7	103	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   40	62	71	finally
    //   76	90	71	finally
    //   90	92	71	finally
    //   109	111	71	finally
    //   40	62	75	java/lang/Exception
  }
  
  public JSONObject c()
  {
    synchronized (this.a)
    {
      JSONObject localJSONObject = this.b;
      return localJSONObject;
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0x68b.RspBody localRspBody = new oidb_cmd0x68b.RspBody();
    int i = ReadInJoyRefreshOptimizeUtil.a(paramToServiceMsg, paramFromServiceMsg, paramObject, localRspBody, false);
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("[onReceive] result=");
    paramToServiceMsg.append(i);
    QLog.i("DynamicHeaderModule", 1, paramToServiceMsg.toString());
    if (i == 0)
    {
      if ((localRspBody.rspChannelArticle.has()) && (localRspBody.rspChannelArticle.get() != null))
      {
        paramToServiceMsg = (oidb_cmd0x68b.RspChannelArticle)localRspBody.rspChannelArticle.get();
        if ((paramToServiceMsg.bytes_nearby_cookie.has()) && (paramToServiceMsg.bytes_nearby_cookie.get() != null))
        {
          paramToServiceMsg = paramToServiceMsg.bytes_nearby_cookie.get().toStringUtf8();
          RIJSPUtils.a("sp_key_daily_dynamic_header_data", paramToServiceMsg);
          a(paramToServiceMsg);
        }
      }
    }
    else
    {
      RIJSPUtils.a("sp_key_daily_dynamic_header_data", "");
      ThreadManagerV2.getUIHandlerV2().post(new DailyDynamicHeaderModule.2(this));
    }
  }
  
  public void unInitialize() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.daily.DailyDynamicHeaderModule
 * JD-Core Version:    0.7.0.1
 */