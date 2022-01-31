import NS_KING_INTERFACE.stDelCommentReplyRsp;
import NS_KING_INTERFACE.stDeleteFeedCommentRsp;
import NS_KING_INTERFACE.stGetCommentReplyListRsp;
import NS_KING_INTERFACE.stPostCommentDingRsp;
import NS_KING_INTERFACE.stPostFeedCommentRsp;
import NS_KING_INTERFACE.stPostFeedDingRsp;
import NS_KING_PUBLIC.stAuth;
import NS_KING_PUBLIC.stReqHeader;
import NS_KING_PUBLIC.stRspHeader;
import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfClientIpInfo;
import QMF_PROTOCAL.QmfDownstream;
import QMF_PROTOCAL.QmfServerInfo;
import QMF_PROTOCAL.RetryInfo;
import UserGrowth.stNotificationRsp;
import UserGrowth.stQQGetFeedCommentListRsp;
import UserGrowth.stReportItem;
import UserGrowth.stSimpleGetFeedListReq;
import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stWeishiReportReq;
import UserGrowth.stWeishiReportRsp;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.qq.jce.wup.UniAttribute;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import cooperation.qzone.QzoneExternalRequest;
import cooperation.qzone.WNSStream;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.WnsError;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class ryw<T1>
  extends QzoneExternalRequest
  implements ryl
{
  public static volatile int a;
  public static String a;
  public static Map<Integer, Map<String, String>> a;
  public long a;
  public JceStruct a;
  protected HashMap<Object, Object> a;
  protected transient ryn a;
  public ryr a;
  protected boolean a;
  public int b;
  public long b;
  public String b;
  protected volatile boolean b;
  private int jdField_c_of_type_Int;
  public long c;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  public long d;
  private String jdField_d_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  
  static
  {
    jdField_a_of_type_JavaLangString = "QzoneNewService.";
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_Int = 2;
  }
  
  public ryw(String paramString)
  {
    this("WeishiGZH.", paramString, false);
    this.f = paramString;
  }
  
  public ryw(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_Int = 100000;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_e_of_type_JavaLangString = (paramString1 + paramString2);
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_e_of_type_Long = System.currentTimeMillis();
  }
  
  private long a(Bundle paramBundle, String paramString)
  {
    if ((paramBundle == null) || (paramString == null)) {}
    while (!paramBundle.containsKey(paramString)) {
      return 0L;
    }
    return paramBundle.getLong(paramString);
  }
  
  private stReqHeader a()
  {
    stReqHeader localstReqHeader = new stReqHeader();
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    String str = ((AppRuntime)localObject).getAccount();
    TicketManager localTicketManager = (TicketManager)((AppRuntime)localObject).getManager(2);
    if ((localTicketManager != null) && (!TextUtils.isEmpty(((AppRuntime)localObject).getAccount())))
    {
      localObject = localTicketManager.getSkey(((AppRuntime)localObject).getAccount());
      Log.e("weishi", "session key:" + (String)localObject);
    }
    for (;;)
    {
      localstReqHeader.authInfo = new stAuth(2, str, (String)localObject);
      localstReqHeader.iChid = 0;
      localstReqHeader.person_id = ryu.jdField_a_of_type_JavaLangString;
      localstReqHeader.platform = "Android";
      localstReqHeader.appversion = DeviceUtils.getVersionCode(BaseApplicationImpl.getContext());
      localstReqHeader.user_ip = DeviceUtils.getLocalIpAddress();
      localstReqHeader.strQua = bfpk.a();
      localstReqHeader.device_info = DeviceUtils.getMachineInfo();
      sai.b("weishi-810", "device_info:" + localstReqHeader.device_info);
      localstReqHeader.h265key = a();
      localstReqHeader.appid = 1000027;
      if ("stWeishiReportReq".equals(uniKey()))
      {
        localstReqHeader.mapExt = a();
        if (localstReqHeader.mapExt == null) {
          break label472;
        }
        localstReqHeader.mapExt.put("iAuthType", "2");
        localstReqHeader.mapExt.put("sUid", str);
        localstReqHeader.mapExt.put("sSessionKey", localObject);
        str = rzu.a(BaseApplicationImpl.getContext());
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = "000000000000000";
        }
        localstReqHeader.mapExt.put("imei", localObject);
        sai.b("weishi-810", "imei:" + (String)localObject);
        localObject = rzu.b(BaseApplicationImpl.getContext());
        localstReqHeader.mapExt.put("qimei", localObject);
        sai.b("weishi-810", "qimei:" + (String)localObject);
        localObject = rzu.c(BaseApplicationImpl.getContext());
        sai.b("weishi-810", "ssid: " + (String)localObject);
        localstReqHeader.mapExt.put("ssid", localObject);
        localObject = a(rzu.a(BaseApplicationImpl.getContext()));
        localstReqHeader.mapExt.put("ssid_ip", localObject);
        sai.b("weishi-810", "ssid_ip: " + (String)localObject);
      }
      for (;;)
      {
        localstReqHeader.iAppVersion = c();
        return localstReqHeader;
        localstReqHeader.mapExt = new HashMap();
        break;
        label472:
        sai.a("weishi-Request", "header mapExt is null.");
      }
      localObject = "test-key";
    }
  }
  
  public static String a()
  {
    String str = "" + Build.MODEL;
    str = str + "&";
    str = str + Build.VERSION.RELEASE;
    str = str + "&";
    str = str + Build.VERSION.SDK_INT;
    str = str + "&";
    return str + b();
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt & 0xFF).append(".");
    localStringBuilder.append(paramInt >> 8 & 0xFF).append(".");
    localStringBuilder.append(paramInt >> 16 & 0xFF).append(".");
    localStringBuilder.append(paramInt >> 24 & 0xFF);
    return localStringBuilder.toString();
  }
  
  private Map<String, String> a()
  {
    if ((this.jdField_a_of_type_ComQqTafJceJceStruct instanceof stWeishiReportReq))
    {
      Object localObject = ((stWeishiReportReq)this.jdField_a_of_type_ComQqTafJceJceStruct).report_list;
      if (((ArrayList)localObject).size() > 0)
      {
        stReportItem localstReportItem = (stReportItem)((ArrayList)localObject).get(0);
        Log.i("weishi-Request", "上报取 pageType: " + localstReportItem.pagetype);
        Map localMap = (Map)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(localstReportItem.pagetype));
        if ((localMap != null) && (localMap.size() > 0))
        {
          Iterator localIterator = localMap.entrySet().iterator();
          for (;;)
          {
            localObject = localMap;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject = (Map.Entry)localIterator.next();
            Log.i("weishi-Request", "取出来" + uniKey() + " --- key: " + (String)((Map.Entry)localObject).getKey() + ", value: " + (String)((Map.Entry)localObject).getValue());
            if (("qq_abtest".equals(((Map.Entry)localObject).getKey())) && (localstReportItem.optype == 121))
            {
              ((Map.Entry)localObject).setValue("");
              Log.w("weishi-Request", "初始化上报，qq_abtest");
              Log.w("weishi-Request", "清空后qq_abtest的值是" + (String)((Map.Entry)localObject).getValue());
            }
          }
        }
        Log.i("weishi-Request", "没有pageType为" + localstReportItem.pagetype + "的extMap");
        localObject = new HashMap();
        return localObject;
      }
    }
    return new HashMap();
  }
  
  private static int b()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return Runtime.getRuntime().availableProcessors();
    }
    return DeviceUtils.getNumCores();
  }
  
  private int c()
  {
    String str = DeviceUtils.getVersionName(BaseApplicationImpl.getContext());
    if ((str == null) || (TextUtils.isEmpty(str))) {
      return 0;
    }
    String[] arrayOfString = str.split("\\.");
    str = "";
    int i = 0;
    if (i < arrayOfString.length)
    {
      int j = Integer.parseInt(arrayOfString[i]);
      if (j < 10) {}
      for (str = str + "0" + j;; str = str + j)
      {
        i += 1;
        break;
      }
    }
    return Integer.parseInt(str);
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_e_of_type_Long;
  }
  
  public final <T1> T1 a(byte[] paramArrayOfByte, String paramString, T1 paramT1)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramT1);
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("weishi-Request", paramArrayOfByte.getLocalizedMessage());
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  protected void a(UniAttribute paramUniAttribute, int paramInt1, int paramInt2, String paramString)
  {
    a(paramUniAttribute, paramInt1, paramInt2, paramString, true);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = true;
    Object localObject1 = null;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if (paramFromServiceMsg != null)
    {
      Object localObject2 = paramFromServiceMsg.getAttribute("_tag_socket");
      if (localObject2 != null)
      {
        localObject2 = localObject2.toString().split(":");
        if ((localObject2 != null) && (localObject2.length > 1))
        {
          this.jdField_a_of_type_JavaUtilHashMap.put("key_request_server_ip", localObject2[0]);
          this.jdField_a_of_type_JavaUtilHashMap.put("key_request_server_port", localObject2[1]);
        }
      }
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localObject2 = paramFromServiceMsg.getWupBuffer();
        if (localObject2 != null) {
          this.jdField_c_of_type_Long = localObject2.length;
        }
        Log.w("weishi-Server", "old cost=" + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long));
        Log.e("weishi-Server", "cmd=" + c() + ",response size=" + this.jdField_c_of_type_Long + ",request size=" + this.jdField_d_of_type_Long);
        if (localObject2 != null) {
          localObject1 = bakc.b((byte[])localObject2);
        }
        a((byte[])localObject1, paramFromServiceMsg);
        return;
      }
      localObject1 = paramFromServiceMsg.extraData;
      localObject2 = paramFromServiceMsg.getBusinessFailMsg();
      Log.e("weishi-Request", "errMsg:" + (String)localObject2);
      a("key_report_detail_msg", "errMsg:" + (String)localObject2);
      if ((!this.jdField_b_of_type_Boolean) && (b()) && (localObject1 != null))
      {
        if (a((Bundle)localObject1, "timestamp_msf2net_atMsfSite") <= 0L) {
          break label440;
        }
        bool1 = bool2;
        if (paramFromServiceMsg.getResultCode() != 1002) {
          if (paramFromServiceMsg.getResultCode() != 1013) {
            break label440;
          }
        }
      }
      label440:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.jdField_b_of_type_Boolean = bool1;
        Log.i("weishi-Request", "cmd=" + uniKey() + ", appSeq:" + paramFromServiceMsg.getAppSeq() + ", resultcode:" + paramFromServiceMsg.getResultCode() + " need retry send request");
        a(null, paramFromServiceMsg.getResultCode() + 300000, paramFromServiceMsg.getResultCode() + 300000, null);
        return;
      }
    }
    Log.e("weishi-Request", uniKey() + " MSF response is null");
    a(null, 1000000, 1000000, "");
  }
  
  protected void a(Object paramObject, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    Log.i("weishi-request", "doSuccessCallback!!");
    if (this.jdField_a_of_type_Ryn != null) {
      this.jdField_a_of_type_Ryn.a(paramObject, paramInt1, paramInt2, paramString, paramBoolean, null);
    }
  }
  
  protected void a(Object paramObject, int paramInt1, int paramInt2, String paramString, boolean paramBoolean, ryp paramryp)
  {
    Log.i("weishi-request", "doSuccessCallback!!");
    if (this.jdField_a_of_type_Ryn != null) {
      this.jdField_a_of_type_Ryn.a(paramObject, paramInt1, paramInt2, paramString, paramBoolean, paramryp);
    }
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramObject1, paramObject2);
  }
  
  public void a(ryn paramryn)
  {
    this.jdField_a_of_type_Ryn = paramryn;
  }
  
  public void a(byte[] paramArrayOfByte, FromServiceMsg paramFromServiceMsg)
  {
    if (paramArrayOfByte == null)
    {
      QZLog.e("QZLog", "cmd=" + uniKey() + " QZoneRequest decodeAndCallback() data is null");
      a(null, 1000003, 1000003, "");
      return;
    }
    Object localObject1 = new WNSStream();
    Object localObject2;
    int i;
    for (;;)
    {
      try
      {
        localObject1 = ((WNSStream)localObject1).unpack(paramArrayOfByte);
        paramArrayOfByte = new ryq();
        if ((localObject1 == null) || (((QmfDownstream)localObject1).WnsCode != 0)) {
          break label1120;
        }
        paramArrayOfByte.setEncodeName("utf-8");
        paramArrayOfByte.decode(((QmfDownstream)localObject1).Extra);
        localObject2 = (QmfServerInfo)paramArrayOfByte.get("server_info");
        if (bgek.a((QmfServerInfo)localObject2))
        {
          bgek.a().a((QmfServerInfo)localObject2);
          this.jdField_a_of_type_JavaUtilHashMap.put("key_report_busi_serverip", NetworkState.IntAddr2Ip(((QmfServerInfo)localObject2).ipWebapp.ClientIpv4));
        }
        localObject2 = (QmfBusiControl)paramArrayOfByte.get("busiCompCtl");
        if ((localObject2 != null) && (1 == ((QmfBusiControl)localObject2).compFlag))
        {
          localObject2 = WNSStream.decompress(((QmfDownstream)localObject1).BusiBuff);
          if (localObject2 != null) {
            ((QmfDownstream)localObject1).BusiBuff = ((byte[])localObject2);
          }
        }
        else
        {
          localObject2 = (ParameterizedType)getClass().getGenericSuperclass();
          if (localObject2 == null) {
            break label1086;
          }
          paramArrayOfByte = (Class)localObject2.getActualTypeArguments()[0];
          if (paramArrayOfByte != stSimpleGetFeedListRsp.class) {
            break label611;
          }
          paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stSimpleGetFeedListRsp());
          i = ((stSimpleGetFeedListReq)this.jdField_a_of_type_ComQqTafJceJceStruct).scene;
          if (paramArrayOfByte == null) {
            Log.w("weishi-Request", "微视公众号 解包失败!!");
          }
          Log.i("weishi-Request", "pageType scene：" + i);
          localObject1 = (stRspHeader)a(((QmfDownstream)localObject1).BusiBuff, "stRspHeader", new stRspHeader());
          localObject2 = new ryp();
          if ((localObject1 == null) || (((stRspHeader)localObject1).mapExt == null)) {
            break label1062;
          }
          localObject3 = ((stRspHeader)localObject1).mapExt;
          jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), localObject3);
          localObject3 = ((Map)localObject3).entrySet().iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
          Log.i("weishi-Request", b() + " 存进去 》》》 key: " + (String)localEntry.getKey() + ", value: " + (String)localEntry.getValue());
          continue;
        }
        QZLog.e("QZLog", "cmd=" + uniKey() + " WeishiRequest decompress error");
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = QZLog.getStackTraceString(paramArrayOfByte);
        if (paramArrayOfByte != null) {
          a("key_report_detail_msg", paramArrayOfByte);
        }
        QZLog.e("QZLog", "cmd=" + uniKey() + " WeishiRequest decodeAndCallback occur exception. stack info:" + paramArrayOfByte);
        a(null, 1000001, 1000001, "");
        return;
      }
      a(paramArrayOfByte, 1000002, 1000002, "");
      return;
      label611:
      if (paramArrayOfByte == stNotificationRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stNotificationRsp());
        i = 4;
      }
      else if (paramArrayOfByte == stQQGetFeedCommentListRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stQQGetFeedCommentListRsp());
        i = 0;
      }
      else if (paramArrayOfByte == stPostFeedCommentRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stPostFeedCommentRsp());
        i = 0;
      }
      else if (paramArrayOfByte == stGetCommentReplyListRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stGetCommentReplyListRsp());
        i = 0;
      }
      else if (paramArrayOfByte == stDelCommentReplyRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stDelCommentReplyRsp());
        i = 0;
      }
      else if (paramArrayOfByte == stPostCommentDingRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stPostCommentDingRsp());
        i = 0;
      }
      else if (paramArrayOfByte == stDeleteFeedCommentRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stDeleteFeedCommentRsp());
        i = 0;
      }
      else if (paramArrayOfByte == stPostFeedDingRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stPostFeedDingRsp());
        i = 0;
      }
      else if (paramArrayOfByte == stWeishiReportRsp.class)
      {
        paramArrayOfByte = a(((QmfDownstream)localObject1).BusiBuff, b(), new stWeishiReportRsp());
        i = 0;
      }
      else
      {
        Log.e("weishi-Request", "respone无法匹配");
        paramArrayOfByte = null;
        i = 0;
      }
    }
    Object localObject3 = (String)((stRspHeader)localObject1).mapExt.get("qq_abtest");
    Log.i("weishi-Request", "stRspHeader: {iRet=" + ((stRspHeader)localObject1).iRet + ", sErrMsg=" + ((stRspHeader)localObject1).sErrmsg + ", abTestId=" + (String)localObject3 + "}");
    ((ryp)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject3);
    Log.d("weishi-Request", "stRspHeader: {scene=" + i + ", abTestId=" + (String)localObject3 + "}");
    sam.a(i, (String)localObject3);
    label1062:
    a(paramArrayOfByte, paramFromServiceMsg.getResultCode(), paramFromServiceMsg.getResultCode(), paramFromServiceMsg.getBusinessFailMsg(), this.jdField_d_of_type_Boolean, (ryp)localObject2);
    return;
    label1086:
    Log.w("weishi-Request", "泛型匹配错误");
    a(paramArrayOfByte, ((QmfDownstream)localObject1).WnsCode, ((QmfDownstream)localObject1).WnsCode, WnsError.getErrorMessage(((QmfDownstream)localObject1).WnsCode));
    return;
    label1120:
    if (localObject1 != null)
    {
      QZLog.e("QZLog", "cmd=" + uniKey() + " WeishiRequest decodeAndCallback wnscode=" + ((QmfDownstream)localObject1).WnsCode + ",msg=" + WnsError.getErrorMessage(((QmfDownstream)localObject1).WnsCode));
      a(paramArrayOfByte, ((QmfDownstream)localObject1).WnsCode, ((QmfDownstream)localObject1).WnsCode, WnsError.getErrorMessage(((QmfDownstream)localObject1).WnsCode));
      return;
    }
    QZLog.e("QZLog", "cmd=" + uniKey() + " WeishiRequest unpack error,result is null");
    a(paramArrayOfByte, 1000003, 1000003, "");
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public String b()
  {
    return "st" + this.f + "Rsp";
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public String c()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public String d()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public byte[] encode()
  {
    Object localObject1 = getDeviceInfo();
    Object localObject2 = bfpk.a();
    long l = getLoginUserId();
    RetryInfo localRetryInfo = (RetryInfo)getRetryInfo();
    localObject1 = new WNSStream(1000027, (String)localObject2, l, new byte[0], (String)localObject1, localRetryInfo);
    localObject2 = getEncodedUniParameter();
    if (localObject2 != null) {
      return bakc.a(((WNSStream)localObject1).pack(MsfSdkUtils.getNextAppSeq(), getCmdString(), (byte[])localObject2, this.jdField_a_of_type_Boolean));
    }
    return null;
  }
  
  public String getCmdString()
  {
    return this.jdField_d_of_type_JavaLangString + this.jdField_e_of_type_JavaLangString;
  }
  
  public byte[] getEncodedUniParameter()
  {
    stReqHeader localstReqHeader = a();
    if (localstReqHeader != null) {}
    try
    {
      Log.d("weishi-Request", "encode, reqHeader = " + localstReqHeader.toString());
      for (;;)
      {
        this.jdField_a_of_type_Ryr = new ryr();
        this.jdField_a_of_type_Ryr.b(this.jdField_b_of_type_Int);
        this.jdField_b_of_type_Int += 1;
        this.jdField_a_of_type_Ryr.a("king");
        this.jdField_a_of_type_Ryr.b(d());
        this.jdField_a_of_type_Ryr.setEncodeName("UTF-8");
        this.jdField_a_of_type_Ryr.put("stReqHeader", localstReqHeader);
        this.jdField_a_of_type_Ryr.a(9999);
        if ((this.jdField_a_of_type_ComQqTafJceJceStruct != null) && (!TextUtils.isEmpty(c())))
        {
          this.jdField_a_of_type_Ryr.put("st" + d() + "Req", this.jdField_a_of_type_ComQqTafJceJceStruct);
          Log.i("weishi-Request", "req名 :st" + d() + "Req");
        }
        return this.jdField_a_of_type_Ryr.encode();
        Log.d("weishi-Request", "encode, reqHeader = null");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("weishi-Request", "encode get header error, e = " + localException.toString());
      }
    }
  }
  
  public JceStruct getReq()
  {
    return this.jdField_a_of_type_ComQqTafJceJceStruct;
  }
  
  public Object getRetryInfo()
  {
    if (a()) {}
    for (int i = 1;; i = 0) {
      return new RetryInfo((short)i, (short)a(), a());
    }
  }
  
  public String uniKey()
  {
    return "st" + this.f + "Req";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ryw
 * JD-Core Version:    0.7.0.1
 */