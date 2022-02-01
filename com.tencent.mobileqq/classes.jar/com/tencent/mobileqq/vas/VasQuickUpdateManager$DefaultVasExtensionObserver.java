package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.apollo.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.vas.updatesystem.api.IVasEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class VasQuickUpdateManager$DefaultVasExtensionObserver
  implements IApolloExtensionObserver
{
  public VasQuickUpdateManager$DefaultVasExtensionObserver(VasQuickUpdateManager paramVasQuickUpdateManager) {}
  
  protected void onQuickUpdateGetUrl(boolean paramBoolean, Object paramObject)
  {
    Object localObject1;
    if (paramBoolean)
    {
      paramObject = (VasQuickUpdateManager.GetUrlRsp)paramObject;
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("cookie", paramObject.cookie);
        Object localObject2 = new JSONArray();
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
          ((JSONArray)localObject2).put(localJSONObject2);
          i += 1;
        }
        localJSONObject1.put("update_list", localObject2);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onQuickUpdateGetUrl data = ");
          ((StringBuilder)localObject2).append(localJSONObject1.toString());
          QLog.d("VasQuickUpdateManager", 2, ((StringBuilder)localObject2).toString());
        }
        if (VasQuickUpdateManager.access$000(this.this$0) == null) {
          return;
        }
        VasQuickUpdateManager.access$000(this.this$0).onPbMsgRecv(0, "GetUrlRsp", localJSONObject1.toString());
        return;
      }
      catch (Exception localException)
      {
        QLog.e("VasQuickUpdateManager", 1, "onQuickUpdateGetUrl error: ", localException);
        if (VasQuickUpdateManager.access$000(this.this$0) == null) {
          return;
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("{\"cookie\":");
      ((StringBuilder)localObject1).append(paramObject.cookie);
      ((StringBuilder)localObject1).append("}");
      localObject1 = ((StringBuilder)localObject1).toString();
      VasQuickUpdateManager.access$000(this.this$0).onPbMsgRecv((int)paramObject.ret, "GetUrlRsp", (String)localObject1);
    }
    else
    {
      paramObject = (VasQuickUpdateManager.QuickUpdateRsp)paramObject;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onQuickUpdateGetUrl result = ");
      ((StringBuilder)localObject1).append(paramObject.ret);
      ((StringBuilder)localObject1).append(" cookie = ");
      ((StringBuilder)localObject1).append(paramObject.cookie);
      QLog.e("VasQuickUpdateManager", 1, ((StringBuilder)localObject1).toString());
      if (VasQuickUpdateManager.access$000(this.this$0) != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("{\"cookie\":");
        ((StringBuilder)localObject1).append(paramObject.cookie);
        ((StringBuilder)localObject1).append("}");
        localObject1 = ((StringBuilder)localObject1).toString();
        VasQuickUpdateManager.access$000(this.this$0).onPbMsgRecv((int)paramObject.ret, "GetUrlRsp", (String)localObject1);
      }
    }
  }
  
  protected void onQuickUpdateSync(boolean paramBoolean, Object paramObject)
  {
    Object localObject3 = "}";
    Object localObject1 = "{\"cookie\":";
    if (paramBoolean)
    {
      paramObject = (VasQuickUpdateManager.SyncVCRRsp)paramObject;
      JSONObject localJSONObject1 = new JSONObject();
      Object localObject2 = paramObject;
      try
      {
        localJSONObject1.put("cookie", paramObject.cookie);
        localObject2 = paramObject;
        localJSONObject1.put("seq", paramObject.seq);
        localObject2 = paramObject;
        localJSONObject1.put("polltime", paramObject.polltime);
        localObject2 = paramObject;
        localJSONObject1.put("syncSwitch", paramObject.syncSwitch);
        localObject2 = paramObject;
        localJSONObject1.put("environment", paramObject.environment);
        localObject2 = paramObject;
        Object localObject4 = new JSONArray();
        int i = 0;
        for (;;)
        {
          localObject2 = paramObject;
          int j = paramObject.vcrList.size();
          Object localObject6;
          JSONObject localJSONObject2;
          if (i < j)
          {
            localObject2 = paramObject;
            localObject6 = (VasQuickUpdateManager.VCR)paramObject.vcrList.get(i);
            localObject2 = paramObject;
            localJSONObject2 = new JSONObject();
          }
          try
          {
            localJSONObject2.put("bid", ((VasQuickUpdateManager.VCR)localObject6).bid);
            localJSONObject2.put("scid", ((VasQuickUpdateManager.VCR)localObject6).scid);
            localJSONObject2.put("optype", ((VasQuickUpdateManager.VCR)localObject6).optype);
            localJSONObject2.put("version", ((VasQuickUpdateManager.VCR)localObject6).version);
            localJSONObject2.put("appVersion", ((VasQuickUpdateManager.VCR)localObject6).appVersion);
            ((JSONArray)localObject4).put(localJSONObject2);
            i += 1;
          }
          catch (Exception localException)
          {
            Object localObject7;
            JSONObject localJSONObject3;
            localObject2 = paramObject;
            paramObject = localException;
          }
        }
        localJSONObject1.put("vcr_list", localObject4);
        localJSONObject2 = new JSONObject();
        localObject2 = paramObject;
        localObject6 = localObject3;
        localObject4 = localObject1;
        try
        {
          localJSONObject2.put("plver", localObject2.preload.ver);
          localObject6 = localObject3;
          localObject4 = localObject1;
          paramObject = new JSONArray();
          i = 0;
          for (;;)
          {
            localObject6 = localObject3;
            localObject4 = localObject1;
            if (i >= localObject2.preload.itemList.size()) {
              break;
            }
            localObject6 = localObject3;
            localObject4 = localObject1;
            localObject7 = (VasQuickUpdateManager.ItemVersion)localObject2.preload.itemList.get(i);
            localObject6 = localObject3;
            localObject4 = localObject1;
            localJSONObject3 = new JSONObject();
            localObject6 = localObject3;
            localObject4 = localObject1;
            localJSONObject3.put("bid", ((VasQuickUpdateManager.ItemVersion)localObject7).bid);
            localObject6 = localObject3;
            localObject4 = localObject1;
            localJSONObject3.put("scid", ((VasQuickUpdateManager.ItemVersion)localObject7).scid);
            localObject6 = localObject3;
            localObject4 = localObject1;
            localJSONObject3.put("flag", ((VasQuickUpdateManager.ItemVersion)localObject7).flag);
            localObject6 = localObject3;
            localObject4 = localObject1;
            paramObject.put(localJSONObject3);
            i += 1;
          }
          localObject6 = localObject3;
          localObject4 = localObject1;
          localJSONObject2.put("item_list", paramObject);
          localObject6 = localObject3;
          localObject4 = localObject1;
          localJSONObject1.put("preload", localJSONObject2);
          localObject6 = localObject3;
          localObject4 = localObject1;
          localJSONObject2 = new JSONObject();
          localObject6 = localObject3;
          localObject4 = localObject1;
          localJSONObject2.put("rpver", localObject2.report.ver);
          localObject6 = localObject3;
          localObject4 = localObject1;
          localObject7 = new JSONArray();
          i = 0;
          paramObject = localObject3;
          for (;;)
          {
            localObject6 = paramObject;
            localObject4 = localObject1;
            if (i < localObject2.report.itemList.size())
            {
              localObject6 = paramObject;
              localObject4 = localObject1;
              localObject3 = (VasQuickUpdateManager.ItemVersion)localObject2.report.itemList.get(i);
              localObject6 = paramObject;
              localObject4 = localObject1;
              localJSONObject3 = new JSONObject();
            }
            try
            {
              localJSONObject3.put("bid", ((VasQuickUpdateManager.ItemVersion)localObject3).bid);
              localJSONObject3.put("scid", ((VasQuickUpdateManager.ItemVersion)localObject3).scid);
              ((JSONArray)localObject7).put(localJSONObject3);
              i += 1;
            }
            catch (Exception paramObject)
            {
              localObject3 = localObject1;
              localObject1 = paramObject;
              paramObject = paramObject;
              break label821;
            }
          }
          localJSONObject2.put("item_list", localObject7);
          localJSONObject1.put("report", localJSONObject2);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("onQuickUpdateSync data = ");
            ((StringBuilder)localObject3).append(localJSONObject1.toString());
            QLog.d("VasQuickUpdateManager", 2, ((StringBuilder)localObject3).toString());
          }
          if (VasQuickUpdateManager.access$000(this.this$0) == null) {
            return;
          }
          VasQuickUpdateManager.access$000(this.this$0).onPbMsgRecv(0, "SyncVCRRsp", localJSONObject1.toString());
          return;
        }
        catch (Exception paramObject)
        {
          localObject3 = localObject6;
          localObject1 = localObject4;
        }
        Object localObject5 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject5;
      }
      catch (Exception paramObject)
      {
        localObject1 = "}";
        localObject3 = "{\"cookie\":";
      }
      label821:
      QLog.e("VasQuickUpdateManager", 1, "onQuickUpdateSync error: ", paramObject);
      if (VasQuickUpdateManager.access$000(this.this$0) != null)
      {
        paramObject = new StringBuilder();
        paramObject.append((String)localObject3);
        paramObject.append(localObject2.cookie);
        paramObject.append((String)localObject1);
        paramObject = paramObject.toString();
        VasQuickUpdateManager.access$000(this.this$0).onPbMsgRecv(-1, "SyncVCRRsp", paramObject);
      }
    }
    else
    {
      paramObject = (VasQuickUpdateManager.QuickUpdateRsp)paramObject;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onQuickUpdateSync result = ");
      ((StringBuilder)localObject1).append(paramObject.ret);
      ((StringBuilder)localObject1).append(" cookie = ");
      ((StringBuilder)localObject1).append(paramObject.cookie);
      QLog.e("VasQuickUpdateManager", 1, ((StringBuilder)localObject1).toString());
      if (VasQuickUpdateManager.access$000(this.this$0) != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("{\"cookie\":");
        ((StringBuilder)localObject1).append(paramObject.cookie);
        ((StringBuilder)localObject1).append("}");
        localObject1 = ((StringBuilder)localObject1).toString();
        VasQuickUpdateManager.access$000(this.this$0).onPbMsgRecv((int)paramObject.ret, "SyncVCRRsp", (String)localObject1);
      }
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 16)
    {
      onQuickUpdateSync(paramBoolean, paramObject);
      return;
    }
    if (paramInt == 17) {
      onQuickUpdateGetUrl(paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.DefaultVasExtensionObserver
 * JD-Core Version:    0.7.0.1
 */