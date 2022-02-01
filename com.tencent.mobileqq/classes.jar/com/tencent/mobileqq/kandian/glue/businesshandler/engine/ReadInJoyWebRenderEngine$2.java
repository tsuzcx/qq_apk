package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyWebRenderEngine$2
  implements Runnable
{
  public void run()
  {
    try
    {
      JSONObject localJSONObject = ViolaAccessHelper.a();
      if (localJSONObject != null)
      {
        if (!TextUtils.isEmpty(this.a)) {
          localJSONObject.put("param", this.a);
        }
        localJSONObject.put("url", this.b);
        ReadInJoyWebRenderEngine.a(this.this$0, false);
        ReadInJoyWebRenderEngine.a(this.this$0).render(this.c, localJSONObject.toString());
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onRender JSONException e");
        localStringBuilder.append(localJSONException.getMessage());
        localStringBuilder.append("ms");
        QLog.e("viola.ReadInJoyWebRenderEngine", 1, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyWebRenderEngine.2
 * JD-Core Version:    0.7.0.1
 */