import com.tencent.biz.pubaccount.readinjoy.viola.redpacket.VKdRedPacketProgress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.ui.dom.DomObject;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class spv
  extends oxe
{
  public spv(VKdRedPacketProgress paramVKdRedPacketProgress) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {}
    try
    {
      if (this.a.mAppendEvents.contains("redPacketProcessFinish"))
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("isFinish", paramBoolean);
        localJSONObject.put("tips", paramString);
        paramString = new JSONArray();
        if (this.a.getDomObject() != null)
        {
          String str = this.a.getDomObject().getRef();
          if (str != null) {
            paramString.put(str);
          }
          paramString.put("redPacketProcessFinish");
          VKdRedPacketProgress.access$000(this.a, "redPacketProcessFinish", paramString, localJSONObject);
        }
      }
      else
      {
        QLog.i("VKdRedPacketProgress", QLog.getUIN_REPORTLOG_LEVEL(), " red packet task do not get Tips!");
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("VKdRedPacketProgress", QLog.getUIN_REPORTLOG_LEVEL(), " onRedPacketTaskFinish error :" + paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     spv
 * JD-Core Version:    0.7.0.1
 */