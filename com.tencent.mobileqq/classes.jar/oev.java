import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
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
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class oev
{
  private static volatile oev jdField_a_of_type_Oev;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public ConcurrentHashMap<Long, ChatMessage> a;
  
  static
  {
    UserAction.registerTunnel(new TunnelInfo("000004B5DU3Q3LD1"));
  }
  
  private oev()
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
    } while ((!paramView.getGlobalVisibleRect(localRect)) || (localRect.left >= zlx.b(paramView.getContext())) || (localRect.top >= zlx.c(paramView.getContext())) || (localRect.right <= 0) || (localRect.bottom <= 0));
    return 1.0D * localRect.width() * localRect.height() / (paramView.getWidth() * paramView.getHeight());
  }
  
  public static String a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    String str1 = "";
    String str2 = oeq.a(paramQQAppInterface, oer.b(paramMessageRecord));
    paramQQAppInterface = str1;
    if (!bgsp.a(str2)) {
      paramQQAppInterface = oer.a(str2, oer.a(oer.c(paramMessageRecord)), false);
    }
    QLog.i("ReportUtil", 2, "wrapPushReport: " + paramQQAppInterface);
    return paramQQAppInterface;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (bgsp.a(paramString1)) {
      return paramString1;
    }
    String str = paramString2;
    if (bgsp.a(paramString2)) {
      str = "tab";
    }
    paramString2 = new HashMap(1);
    paramString2.put("_source", str);
    return oer.a(paramString1, paramString2, false);
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
  
  public static oev a()
  {
    if (jdField_a_of_type_Oev == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Oev == null) {
        jdField_a_of_type_Oev = new oev();
      }
      return jdField_a_of_type_Oev;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      Object localObject = paramQQAppInterface.a().a("3046055438", 1008);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = (MessageRecord)((List)localObject).get(((List)localObject).size() - 1);
        bcvs localbcvs = oer.a((MessageRecord)localObject);
        if (localbcvs != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ReportUtil", 2, "mGdtActionType " + localbcvs.c);
          }
          if ((localbcvs.c == 100) && ((localbcvs.a instanceof StructMsgForGeneralShare)))
          {
            oer.a(localbcvs.g, false);
            a(paramQQAppInterface, paramString, ((StructMsgForGeneralShare)localbcvs.a).mContentTitle, NetConnInfoCenter.getServerTimeMillis() + "", "");
            paramString = a(paramQQAppInterface, (MessageRecord)localObject);
            b(paramQQAppInterface, "qgg_push_click", ((StructMsgForGeneralShare)localbcvs.a).mContentTitle, NetConnInfoCenter.getServerTimeMillis() + "", paramString);
          }
        }
        else
        {
          paramString = oer.a((MessageRecord)localObject);
          if ((paramString != null) && (String.valueOf(100).equals(paramString.optString("action_type"))))
          {
            oer.a(oer.b((MessageRecord)localObject), false);
            localObject = a(paramQQAppInterface, (MessageRecord)localObject);
            b(paramQQAppInterface, "qgg_push_click", paramString.optString("aio_desc_name"), NetConnInfoCenter.getServerTimeMillis() + "", (String)localObject);
            return;
          }
        }
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("ReportUtil", 1, QLog.getStackTraceString(paramQQAppInterface));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReportUtil", 2, String.format("opName: %s__opType: %s__d2: %s__d1: %s", new Object[] { paramString1, paramString2, paramString3, paramString4 }));
    }
    try
    {
      bcst.b(paramQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", paramString2, paramString1, 0, 0, paramString4, paramString3, "android", "8.4.1");
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("ReportUtil", 1, QLog.getStackTraceString(paramQQAppInterface));
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("department", paramString1);
    localHashMap.put("op_type", paramString3);
    localHashMap.put("ext1", paramString5);
    localHashMap.put("pvid", paramString4);
    localHashMap.put("plat", "android");
    localHashMap.put("version", "8.4.1");
    localHashMap.put("A8", oer.a(BaseApplicationImpl.getApplication().getRuntime()));
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
          if (QLog.isColorLevel()) {
            QLog.i("ReportUtil", 2, "params: " + localMap);
          }
          akxd.a("000004B5DU3Q3LD1", "qgg_floor_show", localMap);
          i += 1;
        }
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReportUtil", 2, String.format("opName: %s__opType: %s__d2: %s__d1: %s", new Object[] { paramString1, paramString2, paramString3, paramString4 }));
    }
    try
    {
      a("Vip_pay_mywallet", paramString1, paramString2, paramString3, paramString4);
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("ReportUtil", 1, QLog.getStackTraceString(paramQQAppInterface));
    }
  }
  
  public void a(ChatXListView paramChatXListView, afwy paramafwy)
  {
    if ((paramafwy != null) && (!paramafwy.a().isEmpty()))
    {
      int i = 0;
      if (i < paramafwy.a().size())
      {
        ChatMessage localChatMessage = (ChatMessage)paramafwy.a().get(i);
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
          if (!bgsp.a((String)localObject1)) {
            try
            {
              Object localObject2 = akxe.a(localChatMessage, paramChatXListView);
              if (localObject2 != null)
              {
                localObject2 = (ArkAppView)((View)localObject2).findViewById(2131362910);
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
 * Qualified Name:     oev
 * JD-Core Version:    0.7.0.1
 */