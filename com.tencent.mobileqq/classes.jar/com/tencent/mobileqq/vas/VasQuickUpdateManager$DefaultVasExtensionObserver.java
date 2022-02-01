package com.tencent.mobileqq.vas;

import bggc;
import bgkc;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class VasQuickUpdateManager$DefaultVasExtensionObserver
  extends bggc
{
  public VasQuickUpdateManager$DefaultVasExtensionObserver(VasQuickUpdateManager paramVasQuickUpdateManager) {}
  
  public void onQuickUpdateGetUrl(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      paramObject = (VasQuickUpdateManager.GetUrlRsp)paramObject;
    }
    do
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("cookie", paramObject.cookie);
        JSONArray localJSONArray = new JSONArray();
        int i = 0;
        while (i < paramObject.updateList.size())
        {
          VasQuickUpdateManager.UpdateInfo localUpdateInfo = (VasQuickUpdateManager.UpdateInfo)paramObject.updateList.get(i);
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("bid", localUpdateInfo.bid);
          localJSONObject2.put("scid", localUpdateInfo.scid);
          localJSONObject2.put("dst_version", localUpdateInfo.dstVersion);
          localJSONObject2.put("src_version", localUpdateInfo.srcVersion);
          localJSONObject2.put("delta_mode", localUpdateInfo.deltaMode);
          localJSONObject2.put("storage_mode", localUpdateInfo.storageMode);
          localJSONObject2.put("compress_mode", localUpdateInfo.compressMode);
          localJSONObject2.put("url", localUpdateInfo.url);
          localJSONObject2.put("filesize", localUpdateInfo.filesize);
          localJSONObject2.put("filecontent", localUpdateInfo.filecontent);
          localJSONObject2.put("code", localUpdateInfo.code);
          localJSONObject2.put("appVersion", localUpdateInfo.appVersion);
          localJSONArray.put(localJSONObject2);
          i += 1;
        }
        localJSONObject1.put("update_list", localJSONArray);
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "onQuickUpdateGetUrl data = " + localJSONObject1.toString());
        }
        if (this.this$0.mEngineProxy != null) {
          this.this$0.mEngineProxy.onPbMsgRecv(0, VasExtensionHandler.g, localJSONObject1.toString());
        }
        return;
      }
      catch (Exception localException)
      {
        do
        {
          QLog.e("VasQuickUpdateManager", 1, "onQuickUpdateGetUrl error: ", localException);
        } while (this.this$0.mEngineProxy == null);
        str = "{\"cookie\":" + paramObject.cookie + "}";
        this.this$0.mEngineProxy.onPbMsgRecv((int)paramObject.ret, VasExtensionHandler.g, str);
        return;
      }
      paramObject = (VasQuickUpdateManager.QuickUpdateRsp)paramObject;
      QLog.e("VasQuickUpdateManager", 1, "onQuickUpdateGetUrl result = " + paramObject.ret + " cookie = " + paramObject.cookie);
    } while (this.this$0.mEngineProxy == null);
    String str = "{\"cookie\":" + paramObject.cookie + "}";
    this.this$0.mEngineProxy.onPbMsgRecv((int)paramObject.ret, VasExtensionHandler.g, str);
  }
  
  public void onQuickUpdateSync(boolean paramBoolean, Object paramObject)
  {
    int j = 0;
    JSONObject localJSONObject1;
    if (paramBoolean)
    {
      paramObject = (VasQuickUpdateManager.SyncVCRRsp)paramObject;
      localJSONObject1 = new JSONObject();
    }
    do
    {
      try
      {
        localJSONObject1.put("cookie", paramObject.cookie);
        localJSONObject1.put("seq", paramObject.seq);
        localJSONObject1.put("polltime", paramObject.polltime);
        localJSONObject1.put("syncSwitch", paramObject.syncSwitch);
        localJSONObject1.put("environment", paramObject.environment);
        Object localObject1 = new JSONArray();
        int i = 0;
        Object localObject3;
        while (i < paramObject.vcrList.size())
        {
          localObject2 = (VasQuickUpdateManager.VCR)paramObject.vcrList.get(i);
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("bid", ((VasQuickUpdateManager.VCR)localObject2).bid);
          ((JSONObject)localObject3).put("scid", ((VasQuickUpdateManager.VCR)localObject2).scid);
          ((JSONObject)localObject3).put("optype", ((VasQuickUpdateManager.VCR)localObject2).optype);
          ((JSONObject)localObject3).put("version", ((VasQuickUpdateManager.VCR)localObject2).version);
          ((JSONObject)localObject3).put("appVersion", ((VasQuickUpdateManager.VCR)localObject2).appVersion);
          ((JSONArray)localObject1).put(localObject3);
          i += 1;
        }
        localJSONObject1.put("vcr_list", localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("plver", paramObject.preload.ver);
        Object localObject2 = new JSONArray();
        i = 0;
        JSONObject localJSONObject2;
        while (i < paramObject.preload.itemList.size())
        {
          localObject3 = (VasQuickUpdateManager.ItemVersion)paramObject.preload.itemList.get(i);
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("bid", ((VasQuickUpdateManager.ItemVersion)localObject3).bid);
          localJSONObject2.put("scid", ((VasQuickUpdateManager.ItemVersion)localObject3).scid);
          localJSONObject2.put("flag", ((VasQuickUpdateManager.ItemVersion)localObject3).flag);
          ((JSONArray)localObject2).put(localJSONObject2);
          i += 1;
        }
        ((JSONObject)localObject1).put("item_list", localObject2);
        localJSONObject1.put("preload", localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("rpver", paramObject.report.ver);
        localObject2 = new JSONArray();
        i = j;
        while (i < paramObject.report.itemList.size())
        {
          localObject3 = (VasQuickUpdateManager.ItemVersion)paramObject.report.itemList.get(i);
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("bid", ((VasQuickUpdateManager.ItemVersion)localObject3).bid);
          localJSONObject2.put("scid", ((VasQuickUpdateManager.ItemVersion)localObject3).scid);
          ((JSONArray)localObject2).put(localJSONObject2);
          i += 1;
        }
        ((JSONObject)localObject1).put("item_list", localObject2);
        localJSONObject1.put("report", localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "onQuickUpdateSync data = " + localJSONObject1.toString());
        }
        if (this.this$0.mEngineProxy != null) {
          this.this$0.mEngineProxy.onPbMsgRecv(0, VasExtensionHandler.e, localJSONObject1.toString());
        }
        return;
      }
      catch (Exception localException)
      {
        do
        {
          QLog.e("VasQuickUpdateManager", 1, "onQuickUpdateSync error: ", localException);
        } while (this.this$0.mEngineProxy == null);
        paramObject = "{\"cookie\":" + paramObject.cookie + "}";
        this.this$0.mEngineProxy.onPbMsgRecv(-1, VasExtensionHandler.e, paramObject);
        return;
      }
      paramObject = (VasQuickUpdateManager.QuickUpdateRsp)paramObject;
      QLog.e("VasQuickUpdateManager", 1, "onQuickUpdateSync result = " + paramObject.ret + " cookie = " + paramObject.cookie);
    } while (this.this$0.mEngineProxy == null);
    String str = "{\"cookie\":" + paramObject.cookie + "}";
    this.this$0.mEngineProxy.onPbMsgRecv((int)paramObject.ret, VasExtensionHandler.e, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.DefaultVasExtensionObserver
 * JD-Core Version:    0.7.0.1
 */