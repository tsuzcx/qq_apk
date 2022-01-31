package cooperation.qzone.webviewplugin;

import bjmn;
import bjmp;
import org.json.JSONException;
import org.json.JSONObject;

public final class QzoneDeviceTagJsPlugin$1
  implements Runnable
{
  public QzoneDeviceTagJsPlugin$1(String[] paramArrayOfString) {}
  
  public void run()
  {
    Object localObject1;
    Object localObject3;
    Object localObject6;
    if ((this.a != null) && (this.a.length > 0) && (this.a[0] != null))
    {
      localObject1 = "";
      localObject3 = "";
      localObject6 = "";
      localObject2 = localObject3;
      localObject5 = localObject1;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.a[0]);
        localObject2 = localObject3;
        localObject5 = localObject1;
        localObject1 = localJSONObject.getString("strDiyMemo");
        localObject2 = localObject3;
        localObject5 = localObject1;
        localObject3 = localJSONObject.getString("strDeviceTail");
        localObject2 = localObject3;
        localObject5 = localObject1;
        localObject7 = localJSONObject.getString("strDeviceIcon");
        localObject2 = localObject7;
        localJSONException1.printStackTrace();
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          localObject5 = localJSONObject.getString("strIdentifySqua");
          localObject7 = localObject3;
          localObject6 = localObject2;
          localObject3 = localObject5;
          bjmn.a().a().c((String)localObject1, (String)localObject7, (String)localObject6, (String)localObject3);
          return;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            Object localObject7;
            localObject5 = localObject2;
            localObject2 = localObject4;
            Object localObject4 = localJSONException2;
          }
        }
        localJSONException1 = localJSONException1;
        localObject7 = "";
        localObject1 = localObject5;
        localObject5 = localObject7;
      }
      localObject4 = localObject6;
      localObject6 = localObject5;
      localObject7 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneDeviceTagJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */