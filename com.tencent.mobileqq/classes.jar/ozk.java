import com.tencent.biz.webviewplugin.HotchatPlugin;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.hotchat.LBS.Attribute;
import tencent.im.oidb.hotchat.LBS.Cell;
import tencent.im.oidb.hotchat.LBS.LBSInfo;
import tencent.im.oidb.hotchat.LBS.Wifi;

public class ozk
  implements Runnable
{
  public ozk(HotchatPlugin paramHotchatPlugin, String[] paramArrayOfString) {}
  
  public void run()
  {
    Object localObject2 = HotChatHandler.a();
    Object localObject1 = HotChatHandler.a(false);
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject3;
    Object localObject4;
    JSONObject localJSONObject2;
    try
    {
      localObject3 = new JSONObject();
      if (localObject2 != null)
      {
        ((JSONObject)localObject3).put("mac", String.valueOf(((LBS.Wifi)((LBS.Wifi)localObject2).get()).mac.get()));
        ((JSONObject)localObject3).put("essid", ((LBS.Wifi)((LBS.Wifi)localObject2).get()).essid.get().toStringUtf8());
        ((JSONObject)localObject3).put("rssi", String.valueOf(((LBS.Wifi)((LBS.Wifi)localObject2).get()).rssi.get()));
      }
      localJSONObject1.put("joined_wifi", localObject3);
      if (localObject1 != null)
      {
        localObject2 = new JSONArray();
        localObject3 = ((LBS.LBSInfo)localObject1).rpt_wifi.get();
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (LBS.Wifi)((Iterator)localObject3).next();
            localJSONObject2 = new JSONObject();
            localJSONObject2.put("mac", String.valueOf(((LBS.Wifi)localObject4).mac.get()));
            localJSONObject2.put("rssi", String.valueOf(((LBS.Wifi)localObject4).rssi.get()));
            localJSONObject2.put("essid", String.valueOf(((LBS.Wifi)localObject4).essid.get().toStringUtf8()));
            ((JSONArray)localObject2).put(localJSONObject2);
            continue;
            return;
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    for (;;)
    {
      localJSONException.put("rpt_wifis", localObject2);
      localObject2 = new JSONArray();
      localObject3 = ((LBS.LBSInfo)localObject1).rpt_cell.get();
      if ((localObject3 != null) && (((List)localObject3).size() > 0))
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (LBS.Cell)((Iterator)localObject3).next();
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("mcc", String.valueOf(((LBS.Cell)localObject4).mcc.get()));
          localJSONObject2.put("mnc", String.valueOf(((LBS.Cell)localObject4).mnc.get()));
          localJSONObject2.put("lac", String.valueOf(((LBS.Cell)localObject4).lac.get()));
          localJSONObject2.put("cellid", String.valueOf(((LBS.Cell)localObject4).cellid.get()));
          localJSONObject2.put("rssi", String.valueOf(((LBS.Cell)localObject4).rssi.get()));
          ((JSONArray)localObject2).put(localJSONObject2);
        }
      }
      localJSONException.put("rpt_cells", localObject2);
      localObject2 = new JSONObject();
      if (((LBS.LBSInfo)localObject1).attribute != null)
      {
        localObject1 = (LBS.Attribute)((LBS.LBSInfo)localObject1).attribute.get();
        if (localObject1 != null)
        {
          ((JSONObject)localObject2).put("imei", ((LBS.Attribute)localObject1).imei.get().toStringUtf8());
          ((JSONObject)localObject2).put("imsi", ((LBS.Attribute)localObject1).imsi.get().toStringUtf8());
        }
      }
      localJSONException.put("attribute", localObject2);
      while ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
      {
        localObject1 = new JSONObject(this.jdField_a_of_type_ArrayOfJavaLangString[0]).getString("callback");
        if (QLog.isColorLevel())
        {
          QLog.d("HotchatPlugin", 2, "callbackName: " + (String)localObject1);
          QLog.d("HotchatPlugin", 2, "get 8a3Info: " + localJSONException.toString());
        }
        this.jdField_a_of_type_ComTencentBizWebviewpluginHotchatPlugin.callJs((String)localObject1, new String[] { localJSONException.toString() });
        return;
        localJSONException.put("rpt_wifis", new JSONArray());
        localJSONException.put("rpt_cells", new JSONArray());
        localJSONException.put("attribute", new JSONObject());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ozk
 * JD-Core Version:    0.7.0.1
 */