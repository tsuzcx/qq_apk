package com.tencent.mobileqq.jsp;

import com.tencent.mobileqq.config.business.tendoc.TencentDocPreloadConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreloadConfigProcessor;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class DocxApiPlugin$3
  implements Runnable
{
  DocxApiPlugin$3(DocxApiPlugin paramDocxApiPlugin, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject = TencentDocPreloadConfigProcessor.a();
    if ((((TencentDocPreloadConfigBean)localObject).a()) && (((TencentDocPreloadConfigBean)localObject).b()) && (TeamWorkHandlerUtils.a(this.a)))
    {
      localObject = TeamWorkHandlerUtils.b(this.a);
      this.this$0.callJs(this.b, new String[] { localObject });
    }
    else
    {
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
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(this.c);
    DocxApiPlugin.a(this.this$0, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DocxApiPlugin.3
 * JD-Core Version:    0.7.0.1
 */