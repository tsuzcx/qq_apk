package com.tencent.secprotocol;

import a.a.a.b.a;
import a.a.a.b.f;
import a.a.a.b.g;
import org.json.JSONObject;

public class ByteData$a
  implements Runnable
{
  public ByteData$a(ByteData paramByteData, String paramString) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new f(ByteData.access$000(this.b)).a(10, 1, this.a, ByteData.access$100(this.b));
      JSONObject localJSONObject3 = ByteData.access$200(this.b).a();
      localJSONObject1.put(g.a(19), localJSONObject2);
      localJSONObject1.put(g.a(20), localJSONObject3);
      ByteData.access$300(this.b, 164, 10, 0, localJSONObject1.toString(), new ByteData.a.a(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.secprotocol.ByteData.a
 * JD-Core Version:    0.7.0.1
 */