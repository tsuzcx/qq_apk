package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import bgfm;
import bgod;
import bgoe;
import bgog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

class LocalDataJsPlugin$1
  extends bgod
{
  LocalDataJsPlugin$1(LocalDataJsPlugin paramLocalDataJsPlugin) {}
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    if (QLog.isColorLevel()) {
      QLog.d("LocalDataJsPlugin", 2, "sigTplResDownloadListener.onDone| task:" + parambgoe);
    }
    Object localObject1 = parambgoe.a();
    if (localObject1 == null) {
      QLog.e("LocalDataJsPlugin", 1, "sigTplResDownloadListener.onDone error no params: " + parambgoe);
    }
    String str1;
    String str2;
    File localFile;
    do
    {
      return;
      str1 = ((Bundle)localObject1).getString("callbackId");
      str2 = ((Bundle)localObject1).getString("itemId");
      localObject1 = ((Bundle)localObject1).getString("localRules");
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (!TextUtils.isDigitsOnly(str2)))
      {
        QLog.e("LocalDataJsPlugin", 1, "sigTplResDownloadListener.onDone error : callbackId = " + str1 + " itemId = " + str2);
        return;
      }
      if ((3 != parambgoe.a()) && (parambgoe.a() != 0)) {
        break;
      }
      localFile = new File(bgfm.a(str2, "dynamic_aio"));
    } while (!bgog.a(new File(bgfm.a(str2, "temp.zip")), localFile, true));
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = new JSONObject((String)localObject1);
        LocalDataJsPlugin.access$000(this.this$0, str1, Integer.parseInt(str2), parambgoe.c, (JSONObject)localObject1);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("LocalDataJsPlugin", 1, "sigTplResDownloadListener error: " + localException.getMessage());
        Object localObject2 = null;
      }
    }
    QLog.e("LocalDataJsPlugin", 1, "sigTpl download fail status = " + parambgoe.a() + " itemId = " + str2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.LocalDataJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */