import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class ohq
{
  private static volatile ohq jdField_a_of_type_Ohq;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public ConcurrentHashMap<Long, ChatMessage> a;
  
  static
  {
    UserAction.registerTunnel(new TunnelInfo("000004B5DU3Q3LD1"));
  }
  
  private ohq()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private double a(View paramView)
  {
    if (paramView == null) {}
    Rect localRect;
    do
    {
      return 0.0D;
      localRect = new Rect();
    } while ((!paramView.getGlobalVisibleRect(localRect)) || (localRect.left >= UIUtils.getScreenWidth(paramView.getContext())) || (localRect.top >= UIUtils.getScreenHeight(paramView.getContext())) || (localRect.right <= 0) || (localRect.bottom <= 0));
    return 1.0D * localRect.width() * localRect.height() / (paramView.getWidth() * paramView.getHeight());
  }
  
  public static String a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    String str1 = "";
    String str2 = ohl.a(paramQQAppInterface, ohm.b(paramMessageRecord));
    paramQQAppInterface = str1;
    if (!StringUtil.isEmpty(str2)) {
      paramQQAppInterface = ohm.a(str2, ohm.a(ohm.c(paramMessageRecord)), false);
    }
    QLog.i("ReportUtil", 2, "wrapPushReport: " + paramQQAppInterface);
    return paramQQAppInterface;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (StringUtil.isEmpty(paramString1)) {
      return paramString1;
    }
    String str = paramString2;
    if (StringUtil.isEmpty(paramString2)) {
      str = "tab";
    }
    paramString2 = new HashMap(1);
    paramString2.put("_source", str);
    return ohm.a(paramString1, paramString2, false);
  }
  
  private Map<String, String> a(JSONObject paramJSONObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    HashMap localHashMap = new HashMap();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramJSONObject.optString(str));
    }
    return localHashMap;
  }
  
  public static ohq a()
  {
    if (jdField_a_of_type_Ohq == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Ohq == null) {
        jdField_a_of_type_Ohq = new ohq();
      }
      return jdField_a_of_type_Ohq;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      localObject1 = paramQQAppInterface.getMessageFacade().getAIOList("3046055438", 1008);
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        return;
      }
      localObject1 = (MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1);
      i = 0;
    }
    catch (Throwable paramQQAppInterface)
    {
      Object localObject1;
      int i;
      int j;
      label63:
      Object localObject2;
      QLog.e("ReportUtil", 1, QLog.getStackTraceString(paramQQAppInterface));
      return;
    }
    try
    {
      j = Integer.parseInt(ohm.a((MessageRecord)localObject1));
      i = j;
    }
    catch (Exception localException)
    {
      break label63;
    }
    localObject2 = ohm.a((MessageRecord)localObject1);
    if (localObject2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ReportUtil", 2, "mGdtActionType " + ((bcgw)localObject2).c);
      }
      if ((((bcgw)localObject2).a instanceof StructMsgForGeneralShare))
      {
        a(paramQQAppInterface, paramString, ((StructMsgForGeneralShare)((bcgw)localObject2).a).mContentTitle, NetConnInfoCenter.getServerTimeMillis() + "", "", i);
        paramString = a(paramQQAppInterface, (MessageRecord)localObject1);
        b(paramQQAppInterface, "qgg_push_click", ((StructMsgForGeneralShare)((bcgw)localObject2).a).mContentTitle, NetConnInfoCenter.getServerTimeMillis() + "", paramString, i);
      }
    }
    else
    {
      localObject2 = ohm.a((MessageRecord)localObject1);
      if (localObject2 != null)
      {
        a(paramQQAppInterface, paramString, ((JSONObject)localObject2).optString("aio_desc_name"), NetConnInfoCenter.getServerTimeMillis() + "", "", i);
        paramString = a(paramQQAppInterface, (MessageRecord)localObject1);
        b(paramQQAppInterface, "qgg_push_click", ((JSONObject)localObject2).optString("aio_desc_name"), NetConnInfoCenter.getServerTimeMillis() + "", paramString, i);
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReportUtil", 2, String.format("opName: %s__opType: %s__d2: %s__d1: %s__fromType: %s", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramInt) }));
    }
    try
    {
      bcef.b(paramQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", paramString2, paramString1, paramInt, 0, paramString4, paramString3, "android", "8.4.8");
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("ReportUtil", 1, QLog.getStackTraceString(paramQQAppInterface));
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("department", paramString1);
    localHashMap.put("op_type", paramString3);
    localHashMap.put("op_in", paramInt + "");
    localHashMap.put("ext1", paramString5);
    localHashMap.put("pvid", paramString4);
    localHashMap.put("plat", "android");
    localHashMap.put("version", "8.4.8");
    localHashMap.put("A8", ohm.a(BaseApplicationImpl.getApplication().getRuntime()));
    a(paramString2, localHashMap);
  }
  
  public static void a(String paramString, HashMap<String, String> paramHashMap)
  {
    try
    {
      if ((BaseApplicationImpl.getApplication().peekAppRuntime() instanceof QQAppInterface))
      {
        UserAction.onUserActionToTunnel("000004B5DU3Q3LD1", paramString, true, -1L, -1L, paramHashMap, true, true);
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("key_report_event", paramString);
      localBundle.putSerializable("key_report_params", paramHashMap);
      QIPCClientHelper.getInstance().callServer("EcshopIPCModule", "reportToBeacon", localBundle, null);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ReportUtil", 1, paramString, new Object[0]);
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      paramJSONObject = paramJSONObject.optJSONArray("item_list");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        int i = 0;
        while (i < paramJSONObject.length())
        {
          Map localMap = a(paramJSONObject.optJSONObject(i).optJSONObject("report_data"));
          if ((localMap != null) && (!localMap.isEmpty())) {
            localMap.put("ext3", NetConnInfoCenter.getServerTimeMillis() + "");
          }
          if (QLog.isColorLevel()) {
            QLog.i("ReportUtil", 2, "params: " + localMap);
          }
          akgk.a("000004B5DU3Q3LD1", "qgg_floor_show", localMap);
          i += 1;
        }
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    b(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, 0);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReportUtil", 2, String.format("opName: %s__opType: %s__d2: %s__d1: %s__fromType: %s", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramInt) }));
    }
    try
    {
      a("Vip_pay_mywallet", paramString1, paramString2, paramString3, paramString4, paramInt);
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("ReportUtil", 1, QLog.getStackTraceString(paramQQAppInterface));
    }
  }
  
  public void a(ChatXListView paramChatXListView, aezn paramaezn)
  {
    if ((paramaezn != null) && (!paramaezn.a().isEmpty()))
    {
      int i = 0;
      if (i < paramaezn.a().size())
      {
        ChatMessage localChatMessage = (ChatMessage)paramaezn.a().get(i);
        Object localObject1;
        if ((localChatMessage instanceof MessageForArkApp))
        {
          localObject1 = (MessageForArkApp)localChatMessage;
          if (((MessageForArkApp)localObject1).ark_app_message != null) {
            break label76;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label76:
          localObject1 = ((MessageForArkApp)localObject1).ark_app_message.metaList;
          if (!StringUtil.isEmpty((String)localObject1)) {
            try
            {
              Object localObject2 = akgl.a(localChatMessage, paramChatXListView);
              if (localObject2 != null)
              {
                localObject2 = (ArkAppView)((View)localObject2).findViewById(2131362940);
                if ((localObject2 != null) && (a((View)localObject2) >= 0.8D) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(localChatMessage.uniseq))))
                {
                  a(new JSONObject((String)localObject1).optJSONObject("floorData"));
                  this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localChatMessage.uniseq));
                }
              }
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ohq
 * JD-Core Version:    0.7.0.1
 */