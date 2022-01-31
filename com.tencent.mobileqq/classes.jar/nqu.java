import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.1;
import com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.4;
import com.tencent.biz.pubaccount.ecshopassit.view.CustomTabView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.AdInfo;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.PosAdInfo;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.RedPointInfo;
import tencent.im.oidb.qqshop.qq_ad.QQAdReport;
import tencent.im.oidb.qqshop.qq_ad.QQAdReportRsp;

public class nqu
  extends ajtb
{
  public static int a;
  public long a;
  String a;
  public Set<Long> a;
  public boolean a;
  public long b;
  
  static
  {
    jdField_a_of_type_Int = 300000;
  }
  
  public nqu(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    ThreadManagerV2.excute(new EcshopAdHandler.1(this), 16, null, false);
  }
  
  private List<ChatMessage> a(List<ChatMessage> paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.get(i);
      Object localObject;
      if ((localChatMessage instanceof MessageForArkApp))
      {
        localObject = ((MessageForArkApp)localChatMessage).ark_app_message;
        if (localObject != null)
        {
          localObject = ((ArkAppMessage)localObject).metaList;
          if (bbkk.a((String)localObject)) {}
        }
      }
      for (;;)
      {
        try
        {
          localObject = new JSONObject((String)localObject).optJSONObject("gdt");
          if (QLog.isColorLevel()) {
            QLog.i("EcshopAdHandler", 2, "---aid---" + ((JSONObject)localObject).optString("aid"));
          }
          if (paramLong == ((JSONObject)localObject).optLong("aid")) {
            localArrayList.add(localChatMessage);
          }
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          continue;
        }
        i += 1;
        break;
        long l1;
        if ((localException1 instanceof MessageForStructing))
        {
          localObject = ((MessageForStructing)localException1).structingMsg;
          if ((localObject instanceof StructMsgForGeneralShare))
          {
            localObject = (StructMsgForGeneralShare)localObject;
            if ((((StructMsgForGeneralShare)localObject).mStructMsgItemLists != null) && (((StructMsgForGeneralShare)localObject).mStructMsgItemLists.size() > 0))
            {
              localObject = (axup)((StructMsgForGeneralShare)localObject).mStructMsgItemLists.get(0);
              if (localObject != null) {
                l1 = 0L;
              }
            }
          }
        }
        try
        {
          long l2 = Long.parseLong(((axup)localObject).s);
          l1 = l2;
        }
        catch (Exception localException2)
        {
          label275:
          break label275;
        }
        if (QLog.isColorLevel()) {
          QLog.i("EcshopAdHandler", 2, "---aid---" + l1);
        }
        if (paramLong == l1) {
          localArrayList.add(localException1);
        }
      }
    }
    return localArrayList;
  }
  
  private Set<Long> a()
  {
    HashSet localHashSet = new HashSet();
    if (this.app == null) {}
    String str;
    do
    {
      return localHashSet;
      str = agxa.a(this.app.getCurrentAccountUin(), "risk_ids", "");
      if (QLog.isColorLevel()) {
        QLog.i("EcshopAdHandler", 2, "---getRiskAids---" + str);
      }
    } while (bbkk.a(str));
    return (Set)new Gson().fromJson(str, new nqv(this).getType());
  }
  
  /* Error */
  public static nqx a(nqx paramnqx, MessageRecord paramMessageRecord)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aload_0
    //   5: areturn
    //   6: aload_1
    //   7: ldc 197
    //   9: invokevirtual 202	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   12: astore 5
    //   14: aload_1
    //   15: ldc 204
    //   17: invokevirtual 202	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   20: astore 4
    //   22: ldc 206
    //   24: astore_3
    //   25: aload_1
    //   26: ldc 208
    //   28: invokevirtual 202	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   31: astore 6
    //   33: aload_3
    //   34: astore_2
    //   35: new 79	org/json/JSONObject
    //   38: dup
    //   39: aload 4
    //   41: invokespecial 82	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 4
    //   46: aload_3
    //   47: astore_2
    //   48: aload 4
    //   50: ldc 210
    //   52: invokevirtual 110	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   55: astore_3
    //   56: aload_3
    //   57: astore_2
    //   58: aload 4
    //   60: ldc 212
    //   62: invokevirtual 110	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   65: astore 4
    //   67: aload 4
    //   69: astore_2
    //   70: aload_0
    //   71: aload_1
    //   72: getfield 215	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   75: invokevirtual 220	java/lang/String:trim	()Ljava/lang/String;
    //   78: invokestatic 151	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   81: putfield 224	nqx:jdField_a_of_type_Long	J
    //   84: aload_0
    //   85: aload_3
    //   86: putfield 227	nqx:k	Ljava/lang/String;
    //   89: aload_0
    //   90: aload 6
    //   92: putfield 229	nqx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   95: aload_0
    //   96: aload 5
    //   98: putfield 232	nqx:l	Ljava/lang/String;
    //   101: aload_0
    //   102: aload_2
    //   103: putfield 234	nqx:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   106: aload_0
    //   107: iconst_0
    //   108: putfield 237	nqx:jdField_g_of_type_Int	I
    //   111: aload_0
    //   112: areturn
    //   113: astore_3
    //   114: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +12 -> 129
    //   120: ldc 95
    //   122: iconst_2
    //   123: ldc 239
    //   125: aload_3
    //   126: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   129: aload_2
    //   130: astore_3
    //   131: ldc 170
    //   133: astore_2
    //   134: goto -64 -> 70
    //   137: astore_1
    //   138: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq -57 -> 84
    //   144: ldc 95
    //   146: iconst_2
    //   147: ldc 245
    //   149: aload_1
    //   150: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: goto -69 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramnqx	nqx
    //   0	156	1	paramMessageRecord	MessageRecord
    //   34	100	2	localObject1	Object
    //   24	62	3	str1	String
    //   113	13	3	localException	Exception
    //   130	1	3	localObject2	Object
    //   20	48	4	localObject3	Object
    //   12	85	5	str2	String
    //   31	60	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   35	46	113	java/lang/Exception
    //   48	56	113	java/lang/Exception
    //   58	67	113	java/lang/Exception
    //   70	84	137	java/lang/Exception
  }
  
  private void a(long paramLong)
  {
    if (this.app == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("EcshopAdHandler", 2, "---saveRiskAids---");
    }
    Object localObject = new Gson();
    Set localSet = a();
    localSet.add(Long.valueOf(paramLong));
    localObject = ((Gson)localObject).toJson(localSet);
    agxa.a(this.app.getCurrentAccountUin(), "risk_ids", (String)localObject);
  }
  
  public static void a(AppInterface paramAppInterface, ChatMessage paramChatMessage, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EcshopAdHandler", 1, "--> bindViewForGdtReport");
    }
    try
    {
      paramChatMessage = nqn.a(paramChatMessage);
      if (paramChatMessage != null)
      {
        paramView.setTag(2131379211, new GdtAd(paramChatMessage));
        paramView.setTag(2131379210, new nqw(paramAppInterface));
      }
      return;
    }
    catch (Throwable paramAppInterface)
    {
      paramAppInterface.printStackTrace();
      QLog.d("EcshopAdHandler", 1, "bindViewForGdtReport:" + paramAppInterface.getStackTrace().toString());
    }
  }
  
  private void a(List<qq_ad.QQAdGetRsp.RedPointInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcshopAdHandler", 2, "[onResponseRedpoint]");
    }
    if (BaseActivity.sTopActivity != null)
    {
      Object localObject = ((FragmentActivity)BaseActivity.sTopActivity).getChatFragment();
      if ((localObject != null) && (((ChatFragment)localObject).a != null) && (((ChatFragment)localObject).a.c != null) && (((ChatFragment)localObject).a.c.findViewById(2131364075) != null))
      {
        localObject = (CustomTabView)((ChatFragment)localObject).a.c.findViewById(2131364075).findViewWithTag("echopCustomTabView");
        if (QLog.isColorLevel()) {
          QLog.i("EcshopAdHandler", 2, "[onResponseRedpoint]" + localObject);
        }
        if (localObject != null) {
          ((CustomTabView)localObject).a(paramList);
        }
      }
    }
  }
  
  private void a(qq_ad.QQAdGetRsp paramQQAdGetRsp)
  {
    if ((paramQQAdGetRsp.del_aid.has()) && (BaseActivity.sTopActivity != null))
    {
      ChatFragment localChatFragment = ((FragmentActivity)BaseActivity.sTopActivity).getChatFragment();
      Object localObject1 = paramQQAdGetRsp.del_aid.get();
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        paramQQAdGetRsp = a();
        if (QLog.isColorLevel()) {
          QLog.d("EcshopAdHandler", 2, "---cacheRiskAids---" + paramQQAdGetRsp);
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Long localLong = (Long)((Iterator)localObject1).next();
          if (paramQQAdGetRsp.contains(localLong))
          {
            if (QLog.isColorLevel()) {
              QLog.i("EcshopAdHandler", 2, "already deleted!!!");
            }
          }
          else if ((localChatFragment != null) && (localChatFragment.a != null))
          {
            Object localObject2 = a(localChatFragment.a.a.a(), localLong.longValue());
            if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject2).next();
                localChatFragment.a.a(localChatMessage);
              }
              if (this.app != null) {
                agxa.a(this.app.getCurrentAccountUin(), "risk_ad_del_time", acrp.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd"));
              }
              a(localLong.longValue());
            }
          }
        }
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcshopAdHandler", 2, "On Running Foreground,login?" + this.jdField_a_of_type_Boolean + ",current interval:" + jdField_a_of_type_Int);
    }
    if (!this.jdField_a_of_type_Boolean) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
    } while (l - this.jdField_b_of_type_Long <= jdField_a_of_type_Int);
    this.jdField_b_of_type_Long = l;
    a(null, null, false, null);
  }
  
  public void a(int paramInt, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    nqx localnqx = new nqx();
    localnqx.jdField_a_of_type_Int = paramInt;
    a(localnqx, paramMessageRecord);
    a(localnqx, null);
  }
  
  public void a(List<Long> paramList, List<Integer> paramList1, boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcshopAdHandler", 2, "pull ad pos:" + paramList + ",count:" + paramList1 + ",syn:" + paramBoolean);
    }
    try
    {
      String str1 = acrp.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd");
      if (QLog.isColorLevel()) {
        QLog.i("EcshopAdHandler", 2, "currentTs:" + str1);
      }
      String str2 = agxa.a(this.app.getCurrentAccountUin(), "risk_ad_del_time", str1);
      if (QLog.isColorLevel()) {
        QLog.i("EcshopAdHandler", 2, "cacheTs:" + str2);
      }
      if (!str1.equals(str2))
      {
        if (QLog.isColorLevel()) {
          QLog.i("EcshopAdHandler", 2, "---removeRiskAids---");
        }
        agxa.a(this.app.getCurrentAccountUin(), "risk_ids");
      }
      if (TextUtils.isEmpty(paramString)) {
        paramString = "SQQShopAdSdkSvr.getAd";
      }
      for (;;)
      {
        ThreadManagerV2.excute(new EcshopAdHandler.4(this, paramList, paramList1, paramBoolean, paramString), 16, null, false);
        return;
        this.jdField_a_of_type_JavaLangString = paramString;
      }
      return;
    }
    catch (Exception paramList)
    {
      QLog.e("EcshopAdHandler", 1, "pullAd failed err msg: " + paramList.getMessage());
    }
  }
  
  public void a(nqx paramnqx, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcshopAdHandler", 2, "do ad report info:" + paramnqx.toString());
    }
    qq_ad.QQAdReport localQQAdReport;
    Object localObject2;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "SQQShopAdSdkReportSvr.AdReport";
      localQQAdReport = new qq_ad.QQAdReport();
      localQQAdReport.type.set(paramnqx.jdField_a_of_type_Int);
      localObject2 = localQQAdReport.view_id;
      if (paramnqx.jdField_a_of_type_JavaLangString != null) {
        break label627;
      }
      localObject1 = "";
      label84:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.trace_id;
      if (paramnqx.jdField_b_of_type_JavaLangString != null) {
        break label635;
      }
      localObject1 = "";
      label107:
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.act_time.set((int)(System.currentTimeMillis() / 1000L));
      localObject2 = localQQAdReport.sns_uid;
      if (paramnqx.jdField_c_of_type_JavaLangString != null) {
        break label643;
      }
      localObject1 = "";
      label146:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.resolution;
      if (paramnqx.jdField_d_of_type_JavaLangString != null) {
        break label651;
      }
      localObject1 = "";
      label169:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.referer;
      if (paramnqx.jdField_e_of_type_JavaLangString != null) {
        break label659;
      }
      localObject1 = "";
      label192:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.user_agent;
      if (paramnqx.jdField_f_of_type_JavaLangString != null) {
        break label667;
      }
      localObject1 = "";
      label215:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.q_user_agent;
      if (paramnqx.jdField_g_of_type_JavaLangString != null) {
        break label675;
      }
      localObject1 = "";
      label238:
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.feeds_index.set(paramnqx.jdField_b_of_type_Int);
      localQQAdReport.is_impression.set(paramnqx.jdField_a_of_type_Boolean);
      localQQAdReport.is_installed.set(paramnqx.jdField_b_of_type_Boolean);
      localObject2 = localQQAdReport.feeds_video_attachment;
      if (paramnqx.h != null) {
        break label683;
      }
      localObject1 = "";
      label297:
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.platform_id.set(109);
      localObject2 = localQQAdReport.imei;
      if (bdjp.c() != null) {
        break label691;
      }
      localObject1 = "";
      label329:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.click_source;
      if (paramnqx.i != null) {
        break label698;
      }
      localObject1 = "";
      label352:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.antispam_info;
      if (paramnqx.j != null) {
        break label706;
      }
      localObject1 = "";
      label375:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = bbdh.c(BaseApplicationImpl.getApplication().getApplicationContext());
      PBStringField localPBStringField = localQQAdReport.hardware_addr;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localPBStringField.set((String)localObject1);
      localQQAdReport.stay_time.set(paramnqx.jdField_c_of_type_Int);
      localQQAdReport.net_type.set(naj.a());
      localQQAdReport.client_id.set(paramnqx.jdField_d_of_type_Int);
      localQQAdReport.action_id.set(paramnqx.jdField_e_of_type_Int);
      localQQAdReport.msg_floor.set(paramnqx.jdField_f_of_type_Int);
      localQQAdReport.puin.set(paramnqx.jdField_a_of_type_Long);
      localQQAdReport.ad_puin.set(paramnqx.jdField_b_of_type_Long);
      localQQAdReport.version.set("8.3.0");
      localObject2 = localQQAdReport.ad_id;
      if (paramnqx.k != null) {
        break label714;
      }
      localObject1 = "";
      label527:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.msgid;
      if (paramnqx.l != null) {
        break label722;
      }
    }
    label643:
    label651:
    label659:
    label667:
    label675:
    label683:
    label691:
    label698:
    label706:
    label714:
    label722:
    for (Object localObject1 = "";; localObject1 = paramnqx.l)
    {
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.get_back.set(false);
      localQQAdReport.source.set(paramnqx.jdField_g_of_type_Int);
      paramnqx = new ToServiceMsg("mobileqq.service", this.app.c(), paramString);
      paramnqx.putWupBuffer(localQQAdReport.toByteArray());
      super.sendPbReq(paramnqx);
      return;
      ajtu.a(paramString, new int[] { 139 });
      break;
      label627:
      localObject1 = paramnqx.jdField_a_of_type_JavaLangString;
      break label84;
      label635:
      localObject1 = paramnqx.jdField_b_of_type_JavaLangString;
      break label107;
      localObject1 = paramnqx.jdField_c_of_type_JavaLangString;
      break label146;
      localObject1 = paramnqx.jdField_d_of_type_JavaLangString;
      break label169;
      localObject1 = paramnqx.jdField_e_of_type_JavaLangString;
      break label192;
      localObject1 = paramnqx.jdField_f_of_type_JavaLangString;
      break label215;
      localObject1 = paramnqx.jdField_g_of_type_JavaLangString;
      break label238;
      localObject1 = paramnqx.h;
      break label297;
      localObject1 = bdjp.c();
      break label329;
      localObject1 = paramnqx.i;
      break label352;
      localObject1 = paramnqx.j;
      break label375;
      localObject1 = paramnqx.k;
      break label527;
    }
  }
  
  protected Class<? extends ajte> observerClass()
  {
    return nrc.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return;
      if (("SQQShopAdSdkSvr.getAd".equals(paramToServiceMsg.getServiceCmd())) || ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramToServiceMsg.getServiceCmd()))))
      {
        paramToServiceMsg = new qq_ad.QQAdGetRsp();
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          if (paramToServiceMsg.pos_ads_info.has())
          {
            paramFromServiceMsg = paramToServiceMsg.pos_ads_info.get().iterator();
            while (paramFromServiceMsg.hasNext())
            {
              paramObject = (qq_ad.QQAdGetRsp.PosAdInfo)paramFromServiceMsg.next();
              if (paramObject.ads_info.has())
              {
                paramObject = paramObject.ads_info.get().iterator();
                while (paramObject.hasNext())
                {
                  qq_ad.QQAdGetRsp.AdInfo localAdInfo = (qq_ad.QQAdGetRsp.AdInfo)paramObject.next();
                  this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(localAdInfo.aid.get()));
                }
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break label228;
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          notifyUI(2, false, paramToServiceMsg);
          QLog.e("EcshopAdHandler", 2, "Get ad error:", paramFromServiceMsg);
          return;
        }
        QLog.i("EcshopAdHandler", 2, "redpoint info: " + paramToServiceMsg.red_point.toString());
        label228:
        a(paramToServiceMsg.red_point.get());
        a(paramToServiceMsg);
        notifyUI(1, true, paramToServiceMsg);
        return;
      }
      paramToServiceMsg = new qq_ad.QQAdReportRsp();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (QLog.isColorLevel())
        {
          QLog.i("EcshopAdHandler", 2, "rsp:" + bazp.a(paramToServiceMsg));
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("EcshopAdHandler", 2, "Report error:", paramToServiceMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqu
 * JD-Core Version:    0.7.0.1
 */