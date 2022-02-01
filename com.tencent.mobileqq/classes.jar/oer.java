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
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.RedPointInfo;
import tencent.im.oidb.qqshop.qq_ad.QQAdReport;
import tencent.im.oidb.qqshop.qq_ad.QQAdReportRsp;

public class oer
  extends anud
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
  
  public oer(AppInterface paramAppInterface)
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
          if (bhsr.a((String)localObject)) {}
        }
      }
      for (;;)
      {
        try
        {
          localObject = new JSONObject((String)localObject).optJSONObject("gdt");
          if ((QLog.isColorLevel()) && (localObject != null)) {
            QLog.i("Ecshop_EcshopAdHandler", 2, "---aid---" + paramLong + "gdtJson: " + ((JSONObject)localObject).optString("aid"));
          }
          if ((localObject != null) && (paramLong == ((JSONObject)localObject).optLong("aid"))) {
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
              localObject = (bdol)((StructMsgForGeneralShare)localObject).mStructMsgItemLists.get(0);
              if (localObject != null) {
                l1 = 0L;
              }
            }
          }
        }
        try
        {
          long l2 = Long.parseLong(((bdol)localObject).s);
          l1 = l2;
        }
        catch (Exception localException2)
        {
          label294:
          break label294;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Ecshop_EcshopAdHandler", 2, "---aid---" + l1);
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
      str = akyd.a(this.app.getCurrentAccountUin(), "risk_ids", "");
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_EcshopAdHandler", 2, "---getRiskAids---" + str);
      }
    } while (bhsr.a(str));
    return (Set)new Gson().fromJson(str, new oes(this).getType());
  }
  
  /* Error */
  public static oeu a(oeu paramoeu, MessageRecord paramMessageRecord)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aload_0
    //   5: areturn
    //   6: aload_1
    //   7: ldc 199
    //   9: invokevirtual 204	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   12: astore 5
    //   14: aload_1
    //   15: ldc 206
    //   17: invokevirtual 204	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   20: astore 4
    //   22: ldc 208
    //   24: astore_3
    //   25: aload_1
    //   26: ldc 210
    //   28: invokevirtual 204	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
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
    //   50: ldc 212
    //   52: invokevirtual 115	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   55: astore_3
    //   56: aload_3
    //   57: astore_2
    //   58: aload 4
    //   60: ldc 214
    //   62: invokevirtual 115	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   65: astore 4
    //   67: aload 4
    //   69: astore_2
    //   70: aload_0
    //   71: aload_1
    //   72: getfield 217	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   75: invokevirtual 222	java/lang/String:trim	()Ljava/lang/String;
    //   78: invokestatic 156	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   81: putfield 226	oeu:jdField_a_of_type_Long	J
    //   84: aload_0
    //   85: aload_3
    //   86: putfield 229	oeu:k	Ljava/lang/String;
    //   89: aload_0
    //   90: aload 6
    //   92: putfield 231	oeu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   95: aload_0
    //   96: aload 5
    //   98: putfield 234	oeu:l	Ljava/lang/String;
    //   101: aload_0
    //   102: aload_2
    //   103: putfield 236	oeu:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   106: aload_0
    //   107: iconst_0
    //   108: putfield 239	oeu:jdField_g_of_type_Int	I
    //   111: aload_0
    //   112: areturn
    //   113: astore_3
    //   114: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +12 -> 129
    //   120: ldc 95
    //   122: iconst_2
    //   123: ldc 241
    //   125: aload_3
    //   126: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   129: aload_2
    //   130: astore_3
    //   131: ldc 172
    //   133: astore_2
    //   134: goto -64 -> 70
    //   137: astore_1
    //   138: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq -57 -> 84
    //   144: ldc 95
    //   146: iconst_2
    //   147: ldc 247
    //   149: aload_1
    //   150: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: goto -69 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramoeu	oeu
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
      QLog.i("Ecshop_EcshopAdHandler", 2, "---saveRiskAids---");
    }
    Object localObject = new Gson();
    Set localSet = a();
    localSet.add(Long.valueOf(paramLong));
    localObject = ((Gson)localObject).toJson(localSet);
    akyd.a(this.app.getCurrentAccountUin(), "risk_ids", (String)localObject);
  }
  
  public static void a(AppInterface paramAppInterface, ChatMessage paramChatMessage, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Ecshop_EcshopAdHandler", 1, "--> bindViewForGdtReport");
    }
    try
    {
      paramChatMessage = oek.a(paramChatMessage);
      if (paramChatMessage != null)
      {
        paramView.setTag(2131381107, new GdtAd(paramChatMessage));
        paramView.setTag(2131381106, new oet(paramAppInterface));
      }
      return;
    }
    catch (Throwable paramAppInterface)
    {
      paramAppInterface.printStackTrace();
      QLog.d("Ecshop_EcshopAdHandler", 1, "bindViewForGdtReport:" + paramAppInterface.getStackTrace().toString());
    }
  }
  
  private void a(ArrayList<ofh> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(BaseActivity.sTopActivity instanceof FragmentActivity));
        localObject = ((FragmentActivity)BaseActivity.sTopActivity).getChatFragment();
      } while ((localObject == null) || (((ChatFragment)localObject).a == null) || (((ChatFragment)localObject).a.c == null) || (((ChatFragment)localObject).a.c.findViewById(2131364389) == null));
      localObject = (CustomTabView)((ChatFragment)localObject).a.c.findViewById(2131364389).findViewWithTag("echopCustomTabView");
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_EcshopAdHandler", 2, "[onResponseRedpoint]" + localObject);
      }
    } while (localObject == null);
    ogb.a(paramArrayList);
    ((CustomTabView)localObject).a(paramArrayList);
  }
  
  private void a(List<qq_ad.QQAdGetRsp.RedPointInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_EcshopAdHandler", 2, "[onResponseRedpoint]");
    }
    a(ofz.a(paramList));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_EcshopAdHandler", 2, "On Running Foreground,login?" + this.jdField_a_of_type_Boolean + ",current interval:" + jdField_a_of_type_Int);
    }
    if (!this.jdField_a_of_type_Boolean) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
    } while (l - this.jdField_b_of_type_Long <= jdField_a_of_type_Int);
    this.jdField_b_of_type_Long = l;
    a(null, null, false, null, 3);
  }
  
  public void a(int paramInt, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    oeu localoeu = new oeu();
    localoeu.jdField_a_of_type_Int = paramInt;
    a(localoeu, paramMessageRecord);
    a(localoeu, null);
  }
  
  public void a(List<Long> paramList, List<Integer> paramList1, boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_EcshopAdHandler", 2, "pull ad pos:" + paramList + ",count:" + paramList1 + ",syn:" + paramBoolean);
    }
    try
    {
      String str1 = agce.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd");
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_EcshopAdHandler", 2, "currentTs:" + str1);
      }
      String str2 = akyd.a(this.app.getCurrentAccountUin(), "risk_ad_del_time", str1);
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_EcshopAdHandler", 2, "cacheTs:" + str2);
      }
      if (!str1.equals(str2))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Ecshop_EcshopAdHandler", 2, "---removeRiskAids---");
        }
        akyd.a(this.app.getCurrentAccountUin(), "risk_ids");
      }
      if (TextUtils.isEmpty(paramString)) {
        paramString = "trpc.qqshop.adpush.PushService.GetAd";
      }
      for (;;)
      {
        ThreadManagerV2.excute(new EcshopAdHandler.4(this, paramInt, paramList, paramList1, paramBoolean, paramString), 16, null, false);
        return;
        this.jdField_a_of_type_JavaLangString = paramString;
      }
      return;
    }
    catch (Exception paramList)
    {
      QLog.e("Ecshop_EcshopAdHandler", 1, "pullAd failed err msg: " + paramList.getMessage());
    }
  }
  
  public void a(oeu paramoeu, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_EcshopAdHandler", 2, "do ad report info:" + paramoeu.toString());
    }
    qq_ad.QQAdReport localQQAdReport;
    Object localObject2;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "trpc.qqshop.adreport.ReportService.AdReport";
      localQQAdReport = new qq_ad.QQAdReport();
      localQQAdReport.type.set(paramoeu.jdField_a_of_type_Int);
      localObject2 = localQQAdReport.view_id;
      if (paramoeu.jdField_a_of_type_JavaLangString != null) {
        break label627;
      }
      localObject1 = "";
      label84:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.trace_id;
      if (paramoeu.jdField_b_of_type_JavaLangString != null) {
        break label635;
      }
      localObject1 = "";
      label107:
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.act_time.set((int)(System.currentTimeMillis() / 1000L));
      localObject2 = localQQAdReport.sns_uid;
      if (paramoeu.jdField_c_of_type_JavaLangString != null) {
        break label643;
      }
      localObject1 = "";
      label146:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.resolution;
      if (paramoeu.jdField_d_of_type_JavaLangString != null) {
        break label651;
      }
      localObject1 = "";
      label169:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.referer;
      if (paramoeu.jdField_e_of_type_JavaLangString != null) {
        break label659;
      }
      localObject1 = "";
      label192:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.user_agent;
      if (paramoeu.jdField_f_of_type_JavaLangString != null) {
        break label667;
      }
      localObject1 = "";
      label215:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.q_user_agent;
      if (paramoeu.jdField_g_of_type_JavaLangString != null) {
        break label675;
      }
      localObject1 = "";
      label238:
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.feeds_index.set(paramoeu.jdField_b_of_type_Int);
      localQQAdReport.is_impression.set(paramoeu.jdField_a_of_type_Boolean);
      localQQAdReport.is_installed.set(paramoeu.jdField_b_of_type_Boolean);
      localObject2 = localQQAdReport.feeds_video_attachment;
      if (paramoeu.h != null) {
        break label683;
      }
      localObject1 = "";
      label297:
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.platform_id.set(109);
      localObject2 = localQQAdReport.imei;
      if (bjve.c() != null) {
        break label691;
      }
      localObject1 = "";
      label329:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.click_source;
      if (paramoeu.i != null) {
        break label698;
      }
      localObject1 = "";
      label352:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.antispam_info;
      if (paramoeu.j != null) {
        break label706;
      }
      localObject1 = "";
      label375:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = bhlo.c(BaseApplicationImpl.getApplication().getApplicationContext());
      PBStringField localPBStringField = localQQAdReport.hardware_addr;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localPBStringField.set((String)localObject1);
      localQQAdReport.stay_time.set(paramoeu.jdField_c_of_type_Int);
      localQQAdReport.net_type.set(nnr.a());
      localQQAdReport.client_id.set(paramoeu.jdField_d_of_type_Int);
      localQQAdReport.action_id.set(paramoeu.jdField_e_of_type_Int);
      localQQAdReport.msg_floor.set(paramoeu.jdField_f_of_type_Int);
      localQQAdReport.puin.set(paramoeu.jdField_a_of_type_Long);
      localQQAdReport.ad_puin.set(paramoeu.jdField_b_of_type_Long);
      localQQAdReport.version.set("8.4.5");
      localObject2 = localQQAdReport.ad_id;
      if (paramoeu.k != null) {
        break label714;
      }
      localObject1 = "";
      label527:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.msgid;
      if (paramoeu.l != null) {
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
    for (Object localObject1 = "";; localObject1 = paramoeu.l)
    {
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.get_back.set(false);
      localQQAdReport.source.set(paramoeu.jdField_g_of_type_Int);
      paramoeu = new ToServiceMsg("mobileqq.service", this.app.c(), paramString);
      paramoeu.putWupBuffer(localQQAdReport.toByteArray());
      super.sendPbReq(paramoeu);
      return;
      anvc.a(paramString, new int[] { 139 });
      break;
      label627:
      localObject1 = paramoeu.jdField_a_of_type_JavaLangString;
      break label84;
      label635:
      localObject1 = paramoeu.jdField_b_of_type_JavaLangString;
      break label107;
      localObject1 = paramoeu.jdField_c_of_type_JavaLangString;
      break label146;
      localObject1 = paramoeu.jdField_d_of_type_JavaLangString;
      break label169;
      localObject1 = paramoeu.jdField_e_of_type_JavaLangString;
      break label192;
      localObject1 = paramoeu.jdField_f_of_type_JavaLangString;
      break label215;
      localObject1 = paramoeu.jdField_g_of_type_JavaLangString;
      break label238;
      localObject1 = paramoeu.h;
      break label297;
      localObject1 = bjve.c();
      break label329;
      localObject1 = paramoeu.i;
      break label352;
      localObject1 = paramoeu.j;
      break label375;
      localObject1 = paramoeu.k;
      break label527;
    }
  }
  
  public void a(qq_ad.QQAdGetRsp paramQQAdGetRsp)
  {
    if ((paramQQAdGetRsp.del_aid.has()) && ((BaseActivity.sTopActivity instanceof FragmentActivity)))
    {
      ChatFragment localChatFragment = ((FragmentActivity)BaseActivity.sTopActivity).getChatFragment();
      Object localObject1 = paramQQAdGetRsp.del_aid.get();
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        paramQQAdGetRsp = a();
        if (QLog.isColorLevel()) {
          QLog.d("Ecshop_EcshopAdHandler", 2, "---cacheRiskAids---" + paramQQAdGetRsp);
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Long localLong = (Long)((Iterator)localObject1).next();
          if (paramQQAdGetRsp.contains(localLong))
          {
            if (QLog.isColorLevel()) {
              QLog.i("Ecshop_EcshopAdHandler", 2, "already deleted!!!");
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
                akyd.a(this.app.getCurrentAccountUin(), "risk_ad_del_time", agce.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd"));
              }
              a(localLong.longValue());
            }
          }
        }
      }
    }
  }
  
  protected Class<? extends anui> observerClass()
  {
    return oez.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return;
      if (("trpc.qqshop.adpush.PushService.GetAd".equals(paramToServiceMsg.getServiceCmd())) || ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramToServiceMsg.getServiceCmd()))))
      {
        paramToServiceMsg = new qq_ad.QQAdGetRsp();
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          if (QLog.isColorLevel()) {
            QLog.i("Ecshop_EcshopAdHandler", 2, "redpoint info: " + paramToServiceMsg.red_point.toString());
          }
          paramFromServiceMsg = ogb.a();
          if ((paramFromServiceMsg == null) || (paramFromServiceMsg.isEmpty())) {
            a(paramToServiceMsg.red_point.get());
          }
          a(paramToServiceMsg);
          notifyUI(1, true, paramToServiceMsg);
          return;
        }
        catch (Exception paramFromServiceMsg)
        {
          notifyUI(2, false, paramToServiceMsg);
          QLog.e("Ecshop_EcshopAdHandler", 2, "Get ad error:", paramFromServiceMsg);
          return;
        }
      }
      paramToServiceMsg = new qq_ad.QQAdReportRsp();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (QLog.isColorLevel())
        {
          QLog.i("Ecshop_EcshopAdHandler", 2, "rsp:" + bhhq.a(paramToServiceMsg));
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("Ecshop_EcshopAdHandler", 2, "Report error:", paramToServiceMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oer
 * JD-Core Version:    0.7.0.1
 */