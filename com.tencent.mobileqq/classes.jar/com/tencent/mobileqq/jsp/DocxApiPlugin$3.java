package com.tencent.mobileqq.jsp;

import aotx;
import aoty;
import atcy;
import badd;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class DocxApiPlugin$3
  implements Runnable
{
  public DocxApiPlugin$3(atcy paramatcy, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject = aoty.a();
    if ((((aotx)localObject).a()) && (((aotx)localObject).b()) && (badd.a(this.a)))
    {
      localObject = badd.b(this.a);
      this.this$0.callJs(this.b, new String[] { localObject });
    }
    for (;;)
    {
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(this.c);
      atcy.a(this.this$0, (ArrayList)localObject);
      return;
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("retcode", 1);
        this.this$0.callJs(this.b, new String[] { ((JSONObject)localObject).toString() });
      }
      catch (JSONException localJSONException)
      {
        QLog.e("DocxApiPlugin", 1, "JSONException ", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DocxApiPlugin.3
 * JD-Core Version:    0.7.0.1
 */