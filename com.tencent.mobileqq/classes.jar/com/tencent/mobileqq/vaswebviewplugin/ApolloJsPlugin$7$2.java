package com.tencent.mobileqq.vaswebviewplugin;

import amtl;
import android.text.TextUtils;
import anka;
import anma;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.filament.CmShowAssetsData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

class ApolloJsPlugin$7$2
  implements Runnable
{
  ApolloJsPlugin$7$2(ApolloJsPlugin.7 param7, HashMap paramHashMap) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject1 = this.this$1.val$dressIdList.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        int i = ((Integer)((Iterator)localObject1).next()).intValue();
        localObject2 = (String)this.val$apolloDressInfo.get(Integer.valueOf(i));
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        localObject2 = anma.a((String)localObject2);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          QLog.e("ApolloJsPlugin", 1, "[handleCmShowChange3DAvatarComponent] fileJsonFilePath is null!");
          this.this$1.this$0.callbackError(this.this$1.val$callbackId, "file face.json is not exists!");
          return;
        }
        localObject2 = new File((String)localObject2);
        if (!((File)localObject2).exists()) {
          break label246;
        }
        localObject2 = FileUtils.readFileToString((File)localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          ApolloUtil.a(localJSONObject, new JSONObject((String)localObject2));
          continue;
        }
        QLog.e("ApolloJsPlugin", 1, "[handleCmShowChange3DAvatarComponent] file face.json is empty!");
      }
      catch (Exception localException)
      {
        this.this$1.this$0.callbackError(this.this$1.val$callbackId, localException.getMessage());
        ApolloJsPlugin.access$300(this.this$1.this$0, false, localException.getMessage());
        QLog.e("ApolloJsPlugin", 1, "[handleCmShowChange3DAvatarComponent] read file face.json error!", localException);
        return;
      }
      this.this$1.this$0.callbackError(this.this$1.val$callbackId, "file face.json is empty!");
      ApolloJsPlugin.access$300(this.this$1.this$0, false, "file face.json is empty!");
      return;
      label246:
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowChange3DAvatarComponent] file face.json is not exists!");
      this.this$1.this$0.callbackError(this.this$1.val$callbackId, "file face.json is not exists!");
    }
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put(anka.b, localException);
    amtl localamtl = ApolloJsPlugin.access$200(this.this$1.this$0);
    if (localamtl != null)
    {
      localObject2 = new CmShowAssetsData();
      ((CmShowAssetsData)localObject2).faceDataJsonStr = ((JSONObject)localObject1).toString();
      localamtl.a((CmShowAssetsData)localObject2, 0);
    }
    this.this$1.this$0.callbackOk(this.this$1.val$callbackId);
    ApolloJsPlugin.access$300(this.this$1.this$0, true, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.7.2
 * JD-Core Version:    0.7.0.1
 */