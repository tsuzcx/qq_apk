import android.os.Bundle;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class kqd
  implements HttpWebCgiAsyncTask.Callback
{
  public kqd(NowLiveManager paramNowLiveManager) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    NowLiveManager.a(this.a);
    String str = "";
    long l = 0L;
    Object localObject1 = "";
    if (paramBundle != null)
    {
      l = paramBundle.getLong("time", 0L);
      str = paramBundle.getString("room_id");
      localObject1 = paramBundle.getString("friendUin");
    }
    localObject1 = this.a.a((String)localObject1, l);
    if (paramJSONObject == null)
    {
      NowLiveManager.b(this.a);
      this.a.notifyObservers(new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(false), localObject1, paramBundle });
      return;
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        for (;;)
        {
          this.a.notifyObservers(new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(false), null, paramBundle });
          return;
          Object localObject2 = paramJSONObject.optJSONObject("result");
          if ((localObject2 != null) && (((JSONObject)localObject2).optInt("retcode") == 0))
          {
            paramJSONObject = new ArrayList();
            localObject2 = ((JSONObject)localObject2).optJSONArray("videoURLList");
            if (localObject2 != null)
            {
              int i = 0;
              for (;;)
              {
                if (i < ((JSONArray)localObject2).length()) {
                  try
                  {
                    paramJSONObject.add(((JSONArray)localObject2).getString(i));
                    i += 1;
                  }
                  catch (JSONException localJSONException)
                  {
                    for (;;)
                    {
                      localJSONException.printStackTrace();
                    }
                  }
                }
              }
              ((kqe)localObject1).jdField_a_of_type_JavaUtilList = paramJSONObject;
              ((kqe)localObject1).b = str;
            }
            this.a.notifyObservers(new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(true), localObject1, paramBundle });
          }
        }
      } while (paramJSONObject.optInt("retcode") != 0);
      paramJSONObject = paramJSONObject.optJSONObject("result");
    } while (paramJSONObject == null);
    ((kqe)localObject1).jdField_a_of_type_Int = paramJSONObject.optInt("state");
    this.a.notifyObservers(new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(true), localObject1, paramBundle });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kqd
 * JD-Core Version:    0.7.0.1
 */