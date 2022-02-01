package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import anka;
import anma;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

class ApolloJsPlugin$5$1
  implements Runnable
{
  ApolloJsPlugin$5$1(ApolloJsPlugin.5 param5, String paramString) {}
  
  public void run()
  {
    Object localObject = anma.a(this.val$dressPath);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowLoad3DFaceDress] fileJsonFilePath is null!");
      this.this$1.this$0.callbackError(this.this$1.val$callbackId, "file face.json is not exists!");
      return;
    }
    localObject = new File((String)localObject);
    if (!((File)localObject).exists())
    {
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowLoad3DFaceDress] file face.json is not exists!");
      this.this$1.this$0.callbackError(this.this$1.val$callbackId, "file face.json is not exists!");
      return;
    }
    try
    {
      localObject = FileUtils.readFileToString((File)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put(anka.b, new JSONObject((String)localObject));
        this.this$1.this$0.callbackOk(this.this$1.val$callbackId, localJSONObject);
        return;
      }
    }
    catch (Exception localException)
    {
      this.this$1.this$0.callbackError(this.this$1.val$callbackId, localException.getMessage());
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowLoad3DFaceDress] read file face.json error!", localException);
      return;
    }
    this.this$1.this$0.callbackError(this.this$1.val$callbackId, "file face.json is empty!");
    QLog.e("ApolloJsPlugin", 1, "[handleCmShowLoad3DFaceDress] file face.json is empty!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.5.1
 * JD-Core Version:    0.7.0.1
 */