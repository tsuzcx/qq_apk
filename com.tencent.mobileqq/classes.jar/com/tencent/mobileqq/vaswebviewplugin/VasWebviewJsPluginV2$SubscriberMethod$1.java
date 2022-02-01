package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

class VasWebviewJsPluginV2$SubscriberMethod$1
  implements Runnable
{
  VasWebviewJsPluginV2$SubscriberMethod$1(VasWebviewJsPluginV2.SubscriberMethod paramSubscriberMethod, WeakReference paramWeakReference, VasWebviewJsPluginV2.JsData paramJsData, JSONObject paramJSONObject) {}
  
  public void run()
  {
    for (;;)
    {
      Object[] arrayOfObject;
      int i;
      try
      {
        Object localObject1 = this.this$0.method.getParameterTypes();
        if (TextUtils.isEmpty(this.this$0.args))
        {
          if ((localObject1.length == 1) && (VasWebviewJsPluginV2.JsData.class.isAssignableFrom(localObject1[0])))
          {
            this.this$0.method.invoke(this.val$weakReferenceInstance.get(), new Object[] { this.val$jsData });
            return;
          }
          this.this$0.method.invoke(this.val$weakReferenceInstance.get(), new Object[0]);
          return;
        }
        String[] arrayOfString = this.this$0.args.split("\\|");
        arrayOfObject = new Object[arrayOfString.length];
        i = 0;
        int j = arrayOfObject.length;
        if (i < j)
        {
          localObject1 = null;
          try
          {
            Object localObject2 = this.val$json.get(arrayOfString[i]);
            localObject1 = localObject2;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
        else
        {
          this.this$0.method.invoke(this.val$weakReferenceInstance.get(), arrayOfObject);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("VasWebviewJsPluginV2", 1, localException, new Object[0]);
        return;
      }
      arrayOfObject[i] = localException;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPluginV2.SubscriberMethod.1
 * JD-Core Version:    0.7.0.1
 */