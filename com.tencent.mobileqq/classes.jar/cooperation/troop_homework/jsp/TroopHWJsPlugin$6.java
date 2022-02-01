package cooperation.troop_homework.jsp;

import android.text.TextUtils;
import bifw;
import bmjd;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

class TroopHWJsPlugin$6
  implements Runnable
{
  TroopHWJsPlugin$6(TroopHWJsPlugin paramTroopHWJsPlugin, String paramString) {}
  
  public void run()
  {
    Object localObject2 = this.this$0.mRuntime.a();
    Object localObject1 = (TicketManager)((AppRuntime)localObject2).getManager(2);
    localObject2 = ((AppRuntime)localObject2).getAccount();
    localObject1 = ((TicketManager)localObject1).getSkey((String)localObject2);
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.this$0.h)))
    {
      localObject1 = bmjd.a(this.this$0.h, this.a, (String)localObject2, (String)localObject1, 1234567L);
      if (localObject1 == null) {}
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      if (((JSONObject)localObject1).optInt("retcode", -1) == 0)
      {
        localObject1 = ((JSONObject)localObject1).optJSONObject("data");
        if (localObject1 != null)
        {
          localObject1 = ((JSONObject)localObject1).optString("url");
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("id", this.this$0.d - 1);
          ((JSONObject)localObject2).put("state", "uploaded");
          ((JSONObject)localObject2).put("url", localObject1);
          this.this$0.callJs(this.this$0.b, new String[] { ((JSONObject)localObject2).toString() });
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */