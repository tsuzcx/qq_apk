package com.tencent.mobileqq.vaswebviewplugin;

import amod;
import amtl;
import android.app.Activity;
import ankl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.filament.CmShowAssetsData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

class ApolloJsPlugin$7
  implements amod
{
  ApolloJsPlugin$7(ApolloJsPlugin paramApolloJsPlugin, long paramLong, ArrayList paramArrayList, String paramString, Activity paramActivity, int paramInt, Map paramMap) {}
  
  public void onGetApolloDressInfo(HashMap<Integer, String> paramHashMap, String paramString, int paramInt)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("duration", String.valueOf(System.currentTimeMillis() - this.val$time));
    ((Map)localObject).put("itemids", this.val$dressIdList.toString());
    ankl.a("dressup_3d_page", "model", "change_dress", (Map)localObject);
    QLog.d("ApolloJsPlugin", 1, "[handleCmShowChange3DAvatarComponent] onGetApolloDressInfo: " + paramHashMap + ", errMsg: " + paramString);
    if (paramHashMap == null)
    {
      this.this$0.callbackError(this.val$callbackId, paramString);
      ApolloJsPlugin.access$300(this.this$0, false, paramString);
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowChange3DAvatarComponent] dress info is null " + paramString);
      this.val$activity.runOnUiThread(new ApolloJsPlugin.7.1(this));
      return;
    }
    if (this.val$type == 0)
    {
      paramString = new CmShowAssetsData();
      localObject = this.val$dressMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        paramString.dressResMap.put(localEntry.getValue(), paramHashMap.get(localEntry.getKey()));
      }
      paramHashMap = ApolloJsPlugin.access$400(this.this$0);
      if ((paramHashMap instanceof amtl))
      {
        ((amtl)paramHashMap).a(paramString, 2);
        ApolloJsPlugin.access$300(this.this$0, true, "");
        this.this$0.callbackOk(this.val$callbackId);
        return;
      }
      QLog.e("ApolloJsPlugin", 1, "[handleCmShowChange3DAvatarComponent] no apolloJsCallBack to handle this event!");
      this.this$0.callbackError(this.val$callbackId, "no apolloJsCallBack to handle this event!");
      ApolloJsPlugin.access$300(this.this$0, false, "no apolloJsCallBack to handle this event!");
      return;
    }
    if (this.val$type == 1)
    {
      ThreadManager.getFileThreadHandler().post(new ApolloJsPlugin.7.2(this, paramHashMap));
      return;
    }
    this.this$0.callbackError(this.val$callbackId, "invalid param: type");
    ApolloJsPlugin.access$300(this.this$0, false, "invalid param: type");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */