package com.tencent.mobileqq.vaswebviewplugin;

import amtl;
import android.text.TextUtils;
import anma;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ApolloJsPlugin$6$1$1
  implements Runnable
{
  ApolloJsPlugin$6$1$1(ApolloJsPlugin.6.1 param1) {}
  
  public void run()
  {
    Object localObject = anma.b(this.this$2.this$1.val$faceDataUrl);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowInit3DAvatar] fileJsonFilePath is null!");
      this.this$2.this$1.this$0.callbackError(this.this$2.this$1.val$callbackId, "file face.json is not exists!");
      return;
    }
    localObject = new File((String)localObject);
    if (!((File)localObject).exists())
    {
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowInit3DAvatar] file face.json is not exists!");
      this.this$2.this$1.this$0.callbackError(this.this$2.this$1.val$callbackId, "file face.json is not exists!");
      return;
    }
    try
    {
      localObject = FileUtils.readFileToString((File)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.this$2.this$1.this$0.callbackError(this.this$2.this$1.val$callbackId, "file face.json is empty!");
        return;
      }
    }
    catch (Exception localException)
    {
      this.this$2.this$1.this$0.callbackError(this.this$2.this$1.val$callbackId, localException.getMessage());
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowInit3DAvatar] read file face.json error!", localException);
      return;
    }
    amtl localamtl = ApolloJsPlugin.access$200(this.this$2.this$1.this$0);
    if (localamtl == null)
    {
      this.this$2.this$1.this$0.callbackError(this.this$2.this$1.val$callbackId, "no apolloJsCallBack to handle this event!");
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowInit3DAvatar] no apolloJsCallBack to handle this event!");
      return;
    }
    this.this$2.val$data.faceDataJsonStr = localException;
    localamtl.a(this.this$2.val$data, 3);
    this.this$2.this$1.this$0.callbackOk(this.this$2.this$1.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.6.1.1
 * JD-Core Version:    0.7.0.1
 */