package com.tencent.secprotocol;

import a.a.a.b.e;
import a.a.a.b.f;
import a.a.a.b.g;
import com.tencent.secprotocol.t.ReportLogHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class ByteData$b
  implements Runnable
{
  public ByteData$b(ByteData paramByteData, String paramString, long paramLong) {}
  
  public void run()
  {
    try
    {
      ReportLogHelper.report(3, 2);
      e locale = new e();
      JSONObject localJSONObject2 = new JSONObject();
      JSONObject localJSONObject3 = new f(ByteData.access$200(this.c)).a(11, 1, this.a, ByteData.access$300(this.c));
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put(g.a(24), 1);
        localJSONObject1.put(g.a(26), "");
        localJSONObject1.put(g.a(25), "");
        localJSONObject2.put(g.a(19), localJSONObject3);
        localJSONObject2.put(g.a(20), localJSONObject1);
        ByteData.access$500(this.c, 165, 11, 0, localJSONObject2.toString(), new ByteData.b.a(this, locale));
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          Object localObject = null;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.secprotocol.ByteData.b
 * JD-Core Version:    0.7.0.1
 */