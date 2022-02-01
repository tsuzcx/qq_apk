import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.1;
import com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.4;
import com.tencent.biz.pubaccount.ecshopassit.view.CustomTabView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.StringUtil;
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

public class onx
  extends BusinessHandler
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
  
  public onx(AppInterface paramAppInterface)
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
          if (StringUtil.isEmpty((String)localObject)) {}
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
              localObject = (bdnu)((StructMsgForGeneralShare)localObject).mStructMsgItemLists.get(0);
              if (localObject != null) {
                l1 = 0L;
              }
            }
          }
        }
        try
        {
          long l2 = Long.parseLong(((bdnu)localObject).s);
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
      str = akrn.a(this.app.getCurrentAccountUin(), "risk_ids", "");
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_EcshopAdHandler", 2, "---getRiskAids---" + str);
      }
    } while (StringUtil.isEmpty(str));
    return (Set)new Gson().fromJson(str, new ony(this).getType());
  }
  
  /* Error */
  public static ooa a(ooa paramooa, MessageRecord paramMessageRecord)
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
    //   81: putfield 226	ooa:jdField_a_of_type_Long	J
    //   84: aload_0
    //   85: aload_3
    //   86: putfield 229	ooa:k	Ljava/lang/String;
    //   89: aload_0
    //   90: aload 6
    //   92: putfield 231	ooa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   95: aload_0
    //   96: aload 5
    //   98: putfield 234	ooa:l	Ljava/lang/String;
    //   101: aload_0
    //   102: aload_2
    //   103: putfield 236	ooa:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   106: aload_0
    //   107: iconst_0
    //   108: putfield 239	ooa:jdField_g_of_type_Int	I
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
    //   0	156	0	paramooa	ooa
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
    akrn.a(this.app.getCurrentAccountUin(), "risk_ids", (String)localObject);
  }
  
  public static void a(AppInterface paramAppInterface, ChatMessage paramChatMessage, View paramView)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Ecshop_EcshopAdHandler", 1, "--> bindViewForGdtReport,uin:" + paramChatMessage.senderuin);
      }
      if (!((onq)paramAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).a(paramChatMessage.senderuin)) {
        return;
      }
      paramChatMessage = onq.a(paramChatMessage);
      if (paramChatMessage != null)
      {
        paramView.setTag(2131381181, new GdtAd(paramChatMessage));
        paramView.setTag(2131381180, new onz(paramAppInterface));
        return;
      }
    }
    catch (Throwable paramAppInterface)
    {
      paramAppInterface.printStackTrace();
      QLog.d("Ecshop_EcshopAdHandler", 1, "bindViewForGdtReport:" + paramAppInterface.getStackTrace().toString());
    }
  }
  
  private void a(ArrayList<oon> paramArrayList)
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
      } while ((localObject == null) || (((ChatFragment)localObject).a == null) || (((ChatFragment)localObject).a.mAIORootView == null) || (((ChatFragment)localObject).a.mAIORootView.findViewById(2131364488) == null));
      localObject = (CustomTabView)((ChatFragment)localObject).a.mAIORootView.findViewById(2131364488).findViewWithTag("echopCustomTabView");
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_EcshopAdHandler", 2, "[onResponseRedpoint]" + localObject);
      }
    } while (localObject == null);
    opi.a(paramArrayList);
    ((CustomTabView)localObject).a(paramArrayList);
  }
  
  private void a(List<qq_ad.QQAdGetRsp.RedPointInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_EcshopAdHandler", 2, "[onResponseRedpoint]");
    }
    a(opg.a(paramList));
  }
  
  public static boolean a(SessionInfo paramSessionInfo)
  {
    if ((paramSessionInfo != null) && (paramSessionInfo.curFriendUin != null)) {
      return a(paramSessionInfo.curFriendUin);
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return ("3046055438".equals(paramString)) || ("2711679534".equals(paramString));
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
    ooa localooa = new ooa();
    localooa.jdField_a_of_type_Int = paramInt;
    a(localooa, paramMessageRecord);
    a(localooa, null);
  }
  
  public void a(List<Long> paramList, List<Integer> paramList1, boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_EcshopAdHandler", 2, "pull ad pos:" + paramList + ",count:" + paramList1 + ",syn:" + paramBoolean);
    }
    try
    {
      String str1 = afmj.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd");
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_EcshopAdHandler", 2, "currentTs:" + str1);
      }
      String str2 = akrn.a(this.app.getCurrentAccountUin(), "risk_ad_del_time", str1);
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_EcshopAdHandler", 2, "cacheTs:" + str2);
      }
      if (!str1.equals(str2))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Ecshop_EcshopAdHandler", 2, "---removeRiskAids---");
        }
        akrn.a(this.app.getCurrentAccountUin(), "risk_ids");
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
  
  public void a(ooa paramooa, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_EcshopAdHandler", 2, "do ad report info:" + paramooa.toString());
    }
    qq_ad.QQAdReport localQQAdReport;
    Object localObject2;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "trpc.qqshop.adreport.ReportService.AdReport";
      localQQAdReport = new qq_ad.QQAdReport();
      localQQAdReport.type.set(paramooa.jdField_a_of_type_Int);
      localObject2 = localQQAdReport.view_id;
      if (paramooa.jdField_a_of_type_JavaLangString != null) {
        break label627;
      }
      localObject1 = "";
      label84:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.trace_id;
      if (paramooa.jdField_b_of_type_JavaLangString != null) {
        break label635;
      }
      localObject1 = "";
      label107:
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.act_time.set((int)(System.currentTimeMillis() / 1000L));
      localObject2 = localQQAdReport.sns_uid;
      if (paramooa.jdField_c_of_type_JavaLangString != null) {
        break label643;
      }
      localObject1 = "";
      label146:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.resolution;
      if (paramooa.jdField_d_of_type_JavaLangString != null) {
        break label651;
      }
      localObject1 = "";
      label169:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.referer;
      if (paramooa.jdField_e_of_type_JavaLangString != null) {
        break label659;
      }
      localObject1 = "";
      label192:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.user_agent;
      if (paramooa.jdField_f_of_type_JavaLangString != null) {
        break label667;
      }
      localObject1 = "";
      label215:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.q_user_agent;
      if (paramooa.jdField_g_of_type_JavaLangString != null) {
        break label675;
      }
      localObject1 = "";
      label238:
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.feeds_index.set(paramooa.jdField_b_of_type_Int);
      localQQAdReport.is_impression.set(paramooa.jdField_a_of_type_Boolean);
      localQQAdReport.is_installed.set(paramooa.jdField_b_of_type_Boolean);
      localObject2 = localQQAdReport.feeds_video_attachment;
      if (paramooa.h != null) {
        break label683;
      }
      localObject1 = "";
      label297:
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.platform_id.set(109);
      localObject2 = localQQAdReport.imei;
      if (bjls.c() != null) {
        break label691;
      }
      localObject1 = "";
      label329:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.click_source;
      if (paramooa.i != null) {
        break label698;
      }
      localObject1 = "";
      label352:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.antispam_info;
      if (paramooa.j != null) {
        break label706;
      }
      localObject1 = "";
      label375:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = DeviceInfoUtil.getLocalMacAddress(BaseApplicationImpl.getApplication().getApplicationContext());
      PBStringField localPBStringField = localQQAdReport.hardware_addr;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localPBStringField.set((String)localObject1);
      localQQAdReport.stay_time.set(paramooa.jdField_c_of_type_Int);
      localQQAdReport.net_type.set(HttpUtil.getNetWorkType());
      localQQAdReport.client_id.set(paramooa.jdField_d_of_type_Int);
      localQQAdReport.action_id.set(paramooa.jdField_e_of_type_Int);
      localQQAdReport.msg_floor.set(paramooa.jdField_f_of_type_Int);
      localQQAdReport.puin.set(paramooa.jdField_a_of_type_Long);
      localQQAdReport.ad_puin.set(paramooa.jdField_b_of_type_Long);
      localQQAdReport.version.set("8.4.10");
      localObject2 = localQQAdReport.ad_id;
      if (paramooa.k != null) {
        break label714;
      }
      localObject1 = "";
      label527:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.msgid;
      if (paramooa.l != null) {
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
    for (Object localObject1 = "";; localObject1 = paramooa.l)
    {
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.get_back.set(false);
      localQQAdReport.source.set(paramooa.jdField_g_of_type_Int);
      paramooa = new ToServiceMsg("mobileqq.service", this.app.getCurrentUin(), paramString);
      paramooa.putWupBuffer(localQQAdReport.toByteArray());
      super.sendPbReq(paramooa);
      return;
      anrx.a(paramString, new int[] { BusinessHandlerFactory.ESHOP_AD_HANDLER });
      break;
      label627:
      localObject1 = paramooa.jdField_a_of_type_JavaLangString;
      break label84;
      label635:
      localObject1 = paramooa.jdField_b_of_type_JavaLangString;
      break label107;
      localObject1 = paramooa.jdField_c_of_type_JavaLangString;
      break label146;
      localObject1 = paramooa.jdField_d_of_type_JavaLangString;
      break label169;
      localObject1 = paramooa.jdField_e_of_type_JavaLangString;
      break label192;
      localObject1 = paramooa.jdField_f_of_type_JavaLangString;
      break label215;
      localObject1 = paramooa.jdField_g_of_type_JavaLangString;
      break label238;
      localObject1 = paramooa.h;
      break label297;
      localObject1 = bjls.c();
      break label329;
      localObject1 = paramooa.i;
      break label352;
      localObject1 = paramooa.j;
      break label375;
      localObject1 = paramooa.k;
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
            Object localObject2 = a(localChatFragment.a.listAdapter.a(), localLong.longValue());
            if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject2).next();
                localChatFragment.a.startDelAnimAndDelMsg(localChatMessage);
              }
              if (this.app != null) {
                akrn.a(this.app.getCurrentAccountUin(), "risk_ad_del_time", afmj.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd"));
              }
              a(localLong.longValue());
            }
          }
        }
      }
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return oof.class;
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
          paramFromServiceMsg = opi.a();
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
          QLog.i("Ecshop_EcshopAdHandler", 2, "rsp:" + bgzr.a(paramToServiceMsg));
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
 * Qualified Name:     onx
 * JD-Core Version:    0.7.0.1
 */