package com.tencent.mobileqq.vas;

import baot;
import baox;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class VasQuickUpdateManager$1
  extends baox
{
  VasQuickUpdateManager$1(VasQuickUpdateManager paramVasQuickUpdateManager) {}
  
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
        while (i < paramObject.update_list.size())
        {
          VasQuickUpdateManager.UpdateInfo localUpdateInfo = (VasQuickUpdateManager.UpdateInfo)paramObject.update_list.get(i);
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("bid", localUpdateInfo.bid);
          localJSONObject2.put("scid", localUpdateInfo.scid);
          localJSONObject2.put("dst_version", localUpdateInfo.dst_version);
          localJSONObject2.put("src_version", localUpdateInfo.src_version);
          localJSONObject2.put("delta_mode", localUpdateInfo.delta_mode);
          localJSONObject2.put("storage_mode", localUpdateInfo.storage_mode);
          localJSONObject2.put("compress_mode", localUpdateInfo.compress_mode);
          localJSONObject2.put("url", localUpdateInfo.url);
          localJSONObject2.put("filesize", localUpdateInfo.filesize);
          localJSONObject2.put("filecontent", localUpdateInfo.filecontent);
          localJSONObject2.put("code", localUpdateInfo.code);
          localJSONArray.put(localJSONObject2);
          i += 1;
        }
        localJSONObject1.put("update_list", localJSONArray);
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "onQuickUpdateGetUrl data = " + localJSONObject1.toString());
        }
        if (this.this$0.mEngine != null) {
          this.this$0.mEngine.onPbMsgRecv(0, baot.g, localJSONObject1.toString());
        }
        return;
      }
      catch (Exception localException)
      {
        do
        {
          QLog.e("VasQuickUpdateManager", 1, "onQuickUpdateGetUrl error: ", localException);
        } while (this.this$0.mEngine == null);
        str = "{\"cookie\":" + paramObject.cookie + "}";
        this.this$0.mEngine.onPbMsgRecv((int)paramObject.ret, baot.g, str);
        return;
      }
      paramObject = (VasQuickUpdateManager.QuickUpdateRsp)paramObject;
      QLog.e("VasQuickUpdateManager", 1, "onQuickUpdateGetUrl result = " + paramObject.ret + " cookie = " + paramObject.cookie);
    } while (this.this$0.mEngine == null);
    String str = "{\"cookie\":" + paramObject.cookie + "}";
    this.this$0.mEngine.onPbMsgRecv((int)paramObject.ret, baot.g, str);
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
        localJSONObject1.put("syncSwitch", paramObject.sync_switch);
        Object localObject1 = new JSONArray();
        int i = 0;
        Object localObject3;
        while (i < paramObject.vcr_list.size())
        {
          localObject2 = (VasQuickUpdateManager.VCR)paramObject.vcr_list.get(i);
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("bid", ((VasQuickUpdateManager.VCR)localObject2).bid);
          ((JSONObject)localObject3).put("scid", ((VasQuickUpdateManager.VCR)localObject2).scid);
          ((JSONObject)localObject3).put("optype", ((VasQuickUpdateManager.VCR)localObject2).optype);
          ((JSONObject)localObject3).put("version", ((VasQuickUpdateManager.VCR)localObject2).version);
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
        if (this.this$0.mEngine != null) {
          this.this$0.mEngine.onPbMsgRecv(0, baot.e, localJSONObject1.toString());
        }
        return;
      }
      catch (Exception localException)
      {
        do
        {
          QLog.e("VasQuickUpdateManager", 1, "onQuickUpdateSync error: ", localException);
        } while (this.this$0.mEngine == null);
        paramObject = "{\"cookie\":" + paramObject.cookie + "}";
        this.this$0.mEngine.onPbMsgRecv(-1, baot.e, paramObject);
        return;
      }
      paramObject = (VasQuickUpdateManager.QuickUpdateRsp)paramObject;
      QLog.e("VasQuickUpdateManager", 1, "onQuickUpdateSync result = " + paramObject.ret + " cookie = " + paramObject.cookie);
    } while (this.this$0.mEngine == null);
    String str = "{\"cookie\":" + paramObject.cookie + "}";
    this.this$0.mEngine.onPbMsgRecv((int)paramObject.ret, baot.e, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.1
 * JD-Core Version:    0.7.0.1
 */