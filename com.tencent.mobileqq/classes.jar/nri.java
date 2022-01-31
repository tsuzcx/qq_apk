import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import tencent.im.oidb.qqshop.qqshop_report.SQQSHPCliLogInfo;
import tencent.im.oidb.qqshop.qqshop_report.SQQSHPCliLogReq;
import tencent.im.oidb.qqshop.qqshop_richmsg.SQQSHPFolderAdMsg;
import tencent.im.oidb.qqshop.qqshop_richmsg.SQQSHPRichMsg;
import tencent.im.oidb.qqshop.qqshop_richmsg.SQQSHPRichMsgReq;
import tencent.im.oidb.qqshop.qqshop_richmsg.SQQSHPRichMsgRsp;

public class nri
  extends ajtd
{
  static String a;
  static final String b = BaseApplication.getContext().getFilesDir() + File.separator + "qqshp_client_log_wl_conf.json";
  public akav a;
  
  public nri(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_Akav = new nrj(this);
  }
  
  public static List<String> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localArrayList.add(paramJSONArray.optString(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    boolean bool = true;
    Object localObject = new File(b);
    if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
      localObject = bbdj.a((File)localObject);
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        JSONArray localJSONArray1 = ((JSONObject)localObject).optJSONArray("report_list");
        JSONArray localJSONArray2 = ((JSONObject)localObject).optJSONArray("gtk_list");
        ArrayList localArrayList = new ArrayList();
        nqq.c = new ArrayList();
        if (((JSONObject)localObject).optInt("aio_auto_play", 1) != 1) {
          break label242;
        }
        nqq.a = bool;
        int i;
        if ((localJSONArray1 != null) && (localJSONArray1.length() > 0))
        {
          i = 0;
          if (i < localJSONArray1.length())
          {
            localArrayList.add(String.valueOf(localJSONArray1.getLong(i)));
            i += 1;
            continue;
          }
        }
        nqq.b = localArrayList;
        if ((localJSONArray2 != null) && (localJSONArray2.length() > 0))
        {
          i = 0;
          if (i < localJSONArray2.length())
          {
            nqq.c.add(String.valueOf(localJSONArray2.getLong(i)));
            i += 1;
            continue;
          }
        }
        if (nqq.b != null) {
          break label225;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EcshopReportHandler", 2, localException, new Object[0]);
        }
      }
      nqq.b = new ArrayList();
      label225:
      if (nqq.c == null) {
        nqq.c = new ArrayList();
      }
      return;
      label242:
      bool = false;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean)
  {
    a(paramInt, paramString1, paramString2, paramString3, paramString4, null, paramLong1, paramLong2, paramLong3, paramLong4, paramBoolean);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, boolean paramBoolean)
  {
    a(paramInt, paramString1, paramString2, paramString3, paramString4, paramLong, 0L, 0L, 0L, paramBoolean);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcshopReportHandler", 2, "real time report:[" + Integer.toHexString(paramInt) + "," + paramString1 + "," + paramString2 + "," + paramString3 + "," + paramString4 + "," + paramString5 + "," + paramLong1 + "," + paramBoolean + "]");
    }
    long l1 = 0L;
    try
    {
      i = bbev.a(this.app.getApp().getApplicationContext());
      long l2 = Long.parseLong(paramString1);
      l1 = l2;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        qqshop_report.SQQSHPCliLogReq localSQQSHPCliLogReq;
        qqshop_report.SQQSHPCliLogInfo localSQQSHPCliLogInfo;
        PBStringField localPBStringField;
        Object localObject;
        int i = 0;
        QLog.e("EcshopReportHandler", 2, "doReport error:", paramString1);
        continue;
        paramString1 = this.app.getCurrentAccountUin();
      }
    }
    if (this.app == null)
    {
      paramString1 = "";
      localSQQSHPCliLogReq = new qqshop_report.SQQSHPCliLogReq();
      localSQQSHPCliLogInfo = new qqshop_report.SQQSHPCliLogInfo();
      localSQQSHPCliLogInfo.puin.set(l1);
      localSQQSHPCliLogInfo.network.set(i);
      localSQQSHPCliLogInfo.cnt.set(1);
      localPBStringField = localSQQSHPCliLogInfo.strp1;
      localObject = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        localObject = "";
      }
      localPBStringField.set((String)localObject);
      localObject = localSQQSHPCliLogInfo.strp2;
      paramString2 = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        paramString2 = "";
      }
      ((PBStringField)localObject).set(paramString2);
      paramString3 = localSQQSHPCliLogInfo.strp3;
      paramString2 = paramString4;
      if (TextUtils.isEmpty(paramString4)) {
        paramString2 = "";
      }
      paramString3.set(paramString2);
      paramString3 = localSQQSHPCliLogInfo.strp4;
      paramString2 = paramString5;
      if (TextUtils.isEmpty(paramString5)) {
        paramString2 = "";
      }
      paramString3.set(paramString2);
      localSQQSHPCliLogInfo.tvalue.set(paramInt);
      localSQQSHPCliLogInfo.uintp1.set(paramLong1);
      localSQQSHPCliLogInfo.uintp2.set(paramLong2);
      localSQQSHPCliLogInfo.uintp3.set(paramLong3);
      localSQQSHPCliLogInfo.uintp4.set(paramLong4);
      if (paramBoolean)
      {
        if ((jdField_a_of_type_JavaLangString == null) && (this.app != null) && (this.app.getApp() != null))
        {
          paramString2 = (WifiManager)this.app.getApp().getSystemService("wifi");
          if ((paramString2 != null) && (paramString2.getConnectionInfo() != null)) {
            jdField_a_of_type_JavaLangString = paramString2.getConnectionInfo().getMacAddress();
          }
        }
        if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
          localSQQSHPCliLogInfo.wifimac.set(jdField_a_of_type_JavaLangString);
        }
      }
      localSQQSHPCliLogReq.logs.add(localSQQSHPCliLogInfo);
      paramString1 = new ToServiceMsg("mobileqq.service", paramString1, "SQQShopCliLog.RtReport");
      paramString1.putWupBuffer(localSQQSHPCliLogReq.toByteArray());
      super.sendPbReq(paramString1);
      return;
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (this.app == null)) {}
    qqshop_richmsg.SQQSHPRichMsgReq localSQQSHPRichMsgReq;
    ArrayList localArrayList;
    do
    {
      return;
      nqq localnqq = (nqq)this.app.getManager(88);
      localSQQSHPRichMsgReq = new qqshop_richmsg.SQQSHPRichMsgReq();
      localArrayList = new ArrayList();
      String str = paramMessageRecord.getExtInfoFromExtStr("public_account_msg_id");
      Object localObject = new qqshop_richmsg.SQQSHPRichMsg();
      ((qqshop_richmsg.SQQSHPRichMsg)localObject).msg_id.set(Long.parseLong(str));
      ((qqshop_richmsg.SQQSHPRichMsg)localObject).puin.set(Long.parseLong(paramMessageRecord.senderuin));
      ((qqshop_richmsg.SQQSHPRichMsg)localObject).sendtime.set(paramMessageRecord.time);
      localArrayList.add(localObject);
      if (QLog.isColorLevel()) {
        QLog.i("EcshopReportHandler", 2, "get rich msg:" + str + "," + paramMessageRecord.senderuin + "," + paramMessageRecord.time);
      }
      localObject = localnqq.a(paramMessageRecord.senderuin);
      ((EcShopData)localObject).mLastMsgTime = paramMessageRecord.time;
      paramMessageRecord = this.app.a().a(((EcShopData)localObject).mUin, 1008);
      if (paramMessageRecord != null)
      {
        long l = paramMessageRecord.time;
        if (l > ((EcShopData)localObject).mLastMsgTime) {
          ((EcShopData)localObject).mLastMsgTime = l;
        }
      }
      ((EcShopData)localObject).msgId = str;
      ((EcShopData)localObject).mImgInfo = "";
      localnqq.a((EcShopData)localObject);
    } while (localArrayList.isEmpty());
    localSQQSHPRichMsgReq.rich_msgs.addAll(localArrayList);
    paramMessageRecord = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "SQQShopMsgSvc.GetRichMsgInfo");
    paramMessageRecord.putWupBuffer(localSQQSHPRichMsgReq.toByteArray());
    super.sendPbReq(paramMessageRecord);
  }
  
  public void a(boolean paramBoolean, MessageRecord paramMessageRecord, int paramInt, String paramString)
  {
    try
    {
      String str = paramMessageRecord.getExtInfoFromExtStr("public_account_msg_id");
      if ("1".equals(paramMessageRecord.getExtInfoFromExtStr("is_AdArrive_Msg")))
      {
        paramString = new nra();
        paramString.a = 3;
        paramMessageRecord = nqx.a(paramString, paramMessageRecord);
        paramMessageRecord.f = paramInt;
        ((nqx)this.app.a(139)).a(paramMessageRecord, null);
        return;
      }
      if (paramBoolean)
      {
        a(134243864, paramMessageRecord.senderuin, str, paramString, null, paramInt, false);
        return;
      }
      a(134243858, paramMessageRecord.senderuin, str, paramString, null, paramInt, false);
      return;
    }
    catch (Throwable paramMessageRecord) {}
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EcshopReportHandler", 1, "doArrivalReport " + paramMessageRecord);
    }
    Object localObject1;
    try
    {
      localObject1 = paramMessageRecord.getExtInfoFromExtStr("public_account_msg_id");
      if ("1".equals(paramMessageRecord.getExtInfoFromExtStr("is_AdArrive_Msg")))
      {
        localObject1 = new nra();
        ((nra)localObject1).a = 1;
        localObject1 = nqx.a((nra)localObject1, paramMessageRecord);
        ((nqx)this.app.a(139)).a((nra)localObject1, null);
        if ((paramMessageRecord instanceof MessageForStructing))
        {
          paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
          if (!(paramMessageRecord instanceof StructMsgForGeneralShare)) {
            return;
          }
          paramMessageRecord = (StructMsgForGeneralShare)paramMessageRecord;
          if ((paramMessageRecord.mStructMsgItemLists == null) || (paramMessageRecord.mStructMsgItemLists.size() <= 0)) {
            return;
          }
          yxy.a(0, 2, nqq.a((axun)paramMessageRecord.mStructMsgItemLists.get(0)));
          return;
        }
        if (!(paramMessageRecord instanceof MessageForArkApp)) {
          return;
        }
        paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
        if (paramMessageRecord == null) {
          return;
        }
        paramMessageRecord = new JSONObject(paramMessageRecord.metaList).optJSONObject("gdt");
        if (paramMessageRecord == null) {
          return;
        }
        long l = paramMessageRecord.optLong("aid");
        Object localObject2 = paramMessageRecord.optJSONObject("thirdparty_monitor_urls");
        if (localObject2 == null) {
          return;
        }
        paramMessageRecord = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
        paramMessageRecord.trace_info.aid.set(l);
        localObject1 = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls();
        JSONArray localJSONArray = ((JSONObject)localObject2).optJSONArray("api_click_monitor_url");
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls)localObject1).api_click_monitor_url.set(a(localJSONArray));
        localObject2 = ((JSONObject)localObject2).optJSONArray("api_exposure_monitor_url");
        ((qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls)localObject1).api_exposure_monitor_url.set(a((JSONArray)localObject2));
        paramMessageRecord.thirdparty_monitor_urls.set((MessageMicro)localObject1);
        localObject1 = new qq_ad_get.QQAdGetRsp.AdInfo();
        ((qq_ad_get.QQAdGetRsp.AdInfo)localObject1).report_info.set(paramMessageRecord);
        yxy.a(0, 2, (qq_ad_get.QQAdGetRsp.AdInfo)localObject1);
        return;
      }
    }
    catch (Throwable paramMessageRecord)
    {
      QLog.e("EcshopReportHandler", 1, "doArrivalReport occur an error: " + paramMessageRecord);
      return;
    }
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      a(134243862, paramMessageRecord.senderuin, (String)localObject1, null, null, 0L, false);
      return;
    }
    a(134243856, paramMessageRecord.senderuin, (String)localObject1, null, null, 0L, false);
  }
  
  protected Class<? extends ajtg> observerClass()
  {
    return nqv.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcshopReportHandler", 2, "on receive:" + paramToServiceMsg.getServiceCmd());
    }
    if ((!"SQQShopMsgSvc.GetRichMsgInfo".equals(paramToServiceMsg.getServiceCmd())) || (this.app == null) || (paramObject == null)) {}
    label450:
    do
    {
      do
      {
        do
        {
          return;
          paramFromServiceMsg = new qqshop_richmsg.SQQSHPRichMsgRsp();
          paramToServiceMsg = (nqq)this.app.getManager(88);
          localObject1 = paramToServiceMsg.a();
          try
          {
            paramFromServiceMsg.mergeFrom((byte[])paramObject);
            paramObject = paramFromServiceMsg.rich_msgs.get();
            j = paramObject.size();
            int i = 0;
            for (;;)
            {
              if (i >= j) {
                break label450;
              }
              localObject2 = (qqshop_richmsg.SQQSHPRichMsg)paramObject.get(i);
              if ((((qqshop_richmsg.SQQSHPRichMsg)localObject2).img_url.has()) && (((qqshop_richmsg.SQQSHPRichMsg)localObject2).msg_id.has()) && (((qqshop_richmsg.SQQSHPRichMsg)localObject2).puin.has())) {
                break;
              }
              i += 1;
            }
          }
          catch (Exception paramObject)
          {
            int j;
            for (;;)
            {
              Object localObject2;
              if (QLog.isColorLevel())
              {
                QLog.e("EcshopReportHandler", 2, "merge exception:" + paramObject);
                continue;
                String str1 = String.valueOf(((qqshop_richmsg.SQQSHPRichMsg)localObject2).msg_id.get());
                String str2 = String.valueOf(((qqshop_richmsg.SQQSHPRichMsg)localObject2).puin.get());
                Object localObject3 = ((qqshop_richmsg.SQQSHPRichMsg)localObject2).img_url.get();
                localObject2 = new StringBuilder();
                Object localObject4 = ((List)localObject3).iterator();
                while (((Iterator)localObject4).hasNext())
                {
                  ((StringBuilder)localObject2).append((String)((Iterator)localObject4).next());
                  ((StringBuilder)localObject2).append(",");
                }
                if (QLog.isColorLevel()) {
                  QLog.i("EcshopReportHandler", 2, "recv rich msg:" + str1 + "," + str2 + "," + localObject3.toString());
                }
                localObject3 = ((List)localObject1).iterator();
                do
                {
                  if (!((Iterator)localObject3).hasNext()) {
                    break;
                  }
                  localObject4 = (EcShopData)((Iterator)localObject3).next();
                } while ((!str1.equals(((EcShopData)localObject4).msgId)) || (!str2.equals(((EcShopData)localObject4).mUin)));
                ((EcShopData)localObject4).mImgInfo = ((StringBuilder)localObject2).substring(0, ((StringBuilder)localObject2).length() - 1).toString();
                paramToServiceMsg.a((EcShopData)localObject4);
              }
            }
            if (j > 0) {
              super.notifyUI(6, true, null);
            }
          }
        } while (!paramFromServiceMsg.ad_msgs.has());
        paramFromServiceMsg = (qqshop_richmsg.SQQSHPFolderAdMsg)paramFromServiceMsg.ad_msgs.get(0);
        localObject1 = this.app.getCurrentAccountUin();
      } while (paramFromServiceMsg == null);
      paramObject = paramFromServiceMsg.pic_url.get();
    } while ((TextUtils.isEmpty((CharSequence)localObject1)) || (paramObject == null) || (paramObject.isEmpty()));
    Object localObject1 = this.app.getApp().getSharedPreferences("ecshop_sp" + (String)localObject1, 0);
    long l = ((SharedPreferences)localObject1).getLong("ad_puin", 0L);
    nqq.g = String.valueOf(l);
    localObject1 = ((SharedPreferences)localObject1).edit();
    if (l != 0L) {
      paramToServiceMsg.b(String.valueOf(l));
    }
    ((SharedPreferences.Editor)localObject1).putBoolean("is_ad_added", false);
    ((SharedPreferences.Editor)localObject1).putInt("ad_start", paramFromServiceMsg.begin_time.get());
    ((SharedPreferences.Editor)localObject1).putInt("ad_end", paramFromServiceMsg.end_time.get());
    ((SharedPreferences.Editor)localObject1).putLong("ad_id", paramFromServiceMsg.ad_id.get());
    ((SharedPreferences.Editor)localObject1).putLong("ad_puin", paramFromServiceMsg.puin.get());
    ((SharedPreferences.Editor)localObject1).putString("ad_icon_url", paramFromServiceMsg.ad_url.get());
    ((SharedPreferences.Editor)localObject1).putString("ad_title", paramFromServiceMsg.title.get());
    ((SharedPreferences.Editor)localObject1).putString("ad_nick", paramFromServiceMsg.name.get());
    ((SharedPreferences.Editor)localObject1).putString("ad_url", paramFromServiceMsg.ad_content_url.get());
    if (paramFromServiceMsg.verify_flag.get() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((SharedPreferences.Editor)localObject1).putBoolean("ad_cert", bool);
      paramToServiceMsg = new StringBuilder();
      paramObject = paramObject.iterator();
      while (paramObject.hasNext())
      {
        paramToServiceMsg.append((String)paramObject.next());
        paramToServiceMsg.append(",");
      }
    }
    paramToServiceMsg = paramToServiceMsg.substring(0, paramToServiceMsg.length() - 1).toString();
    if (QLog.isColorLevel()) {
      QLog.i("EcshopReportHandler", 2, "v_flag" + paramFromServiceMsg.verify_flag.get() + ",puin:" + paramFromServiceMsg.puin.get() + ",ad pics:" + paramToServiceMsg);
    }
    ((SharedPreferences.Editor)localObject1).putString("ad_pics", paramToServiceMsg);
    ((SharedPreferences.Editor)localObject1).commit();
    a(134246435, null, null, null, null, paramFromServiceMsg.ad_id.get(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nri
 * JD-Core Version:    0.7.0.1
 */