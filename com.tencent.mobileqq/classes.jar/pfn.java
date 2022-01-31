import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.DailyDynamicHeaderModule.1;
import com.tencent.biz.pubaccount.readinjoy.model.DailyDynamicHeaderModule.2;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;

public class pfn
  extends pgp
{
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  
  public pfn(AppInterface paramAppInterface, awgf paramawgf, ExecutorService paramExecutorService, puz parampuz, Handler paramHandler)
  {
    super(paramAppInterface, paramawgf, paramExecutorService, parampuz, paramHandler);
    d();
  }
  
  static JSONObject a(boolean paramBoolean)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localJSONObject2.put("req_type", i);
      localJSONObject2.put("ad_code", ampk.b());
      localJSONObject2.put("city_name", ampk.a());
      localJSONObject1.put("dynamic_header_req_param", localJSONObject2);
      return localJSONObject1;
    }
  }
  
  private void c()
  {
    oidb_cmd0x68b.ReqBody localReqBody = new oidb_cmd0x68b.ReqBody();
    long l = Long.valueOf(ors.a()).longValue();
    localReqBody.uint64_uin.set(l);
    localReqBody.uint32_network_type.set(pew.b());
    try
    {
      Object localObject = new JSONArray();
      ((JSONArray)localObject).put(a(false));
      localObject = ((JSONArray)localObject).toString();
      if (QLog.isColorLevel()) {
        QLog.d("DynamicHeaderModule", 2, "[requestForUpdate] req: " + (String)localObject);
      }
      localReqBody.bytes_nearby_cookie.set(ByteStringMicro.copyFromUtf8((String)localObject));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("DynamicHeaderModule", 1, "[requestForUpdate] ", localException);
      }
    }
    a(pvb.a("OidbSvc.0xcba", 3258, 0, localReqBody.toByteArray()));
  }
  
  private void d()
  {
    String str = (String)bkbq.a("sp_key_daily_dynamic_header_data", "");
    QLog.i("DynamicHeaderModule", 1, "[startLoadFromDisk] json=" + str);
    if (!TextUtils.isEmpty(str)) {
      a(str);
    }
  }
  
  public JSONObject a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
      return localJSONObject;
    }
  }
  
  public void a()
  {
    c();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0x68b.RspBody localRspBody = new oidb_cmd0x68b.RspBody();
    int i = ork.a(paramToServiceMsg, paramFromServiceMsg, paramObject, localRspBody, false);
    QLog.i("DynamicHeaderModule", 1, "[onReceive] result=" + i);
    if (i == 0)
    {
      if ((localRspBody.rspChannelArticle.has()) && (localRspBody.rspChannelArticle.get() != null))
      {
        paramToServiceMsg = (oidb_cmd0x68b.RspChannelArticle)localRspBody.rspChannelArticle.get();
        if ((paramToServiceMsg.bytes_nearby_cookie.has()) && (paramToServiceMsg.bytes_nearby_cookie.get() != null))
        {
          paramToServiceMsg = paramToServiceMsg.bytes_nearby_cookie.get().toStringUtf8();
          bkbq.a("sp_key_daily_dynamic_header_data", paramToServiceMsg);
          a(paramToServiceMsg);
        }
      }
      return;
    }
    bkbq.a("sp_key_daily_dynamic_header_data", "");
    ThreadManagerV2.getUIHandlerV2().post(new DailyDynamicHeaderModule.2(this));
  }
  
  public void a(String paramString)
  {
    boolean bool = true;
    QLog.i("DynamicHeaderModule", 1, "[updateDynamicHeaderData] jsonString=" + paramString);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(paramString).optJSONObject("dynamic_header_data");
        paramString = this.jdField_a_of_type_OrgJsonJSONObject;
        if (paramString == null) {
          break label79;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          label79:
          QLog.e("DynamicHeaderModule", 1, "[updateDynamicHeaderData] ", paramString);
          this.jdField_a_of_type_OrgJsonJSONObject = null;
          bool = false;
        }
      }
      ThreadManagerV2.getUIHandlerV2().post(new DailyDynamicHeaderModule.1(this, bool));
      return;
      bool = false;
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pfn
 * JD-Core Version:    0.7.0.1
 */