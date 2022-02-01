package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StBaseLibInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetNewBaseLibReq;
import NS_MINI_INTERFACE.INTERFACE.StGetNewBaseLibRsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class GetNewBaseLibRequest
  extends ProtoBufRequest
{
  private static final String TAG = "GetNewBaseLibRequest";
  private INTERFACE.StGetNewBaseLibReq req = new INTERFACE.StGetNewBaseLibReq();
  
  public GetNewBaseLibRequest(String paramString, int paramInt)
  {
    this.req.curVersion.set(paramString);
    this.req.type.set(paramInt);
  }
  
  public String getBaseLibUrl64(String paramString1, String paramString2)
  {
    try
    {
      if (TextUtils.isEmpty(paramString1)) {
        return paramString2;
      }
      paramString1 = new JSONObject(paramString1).optString("downloadUrl_64", paramString2);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      QMLog.e("GetNewBaseLibRequest", "Failed to parse downloadUrl_64", paramString1);
    }
    return paramString2;
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "GetNewBaseLib";
  }
  
  protected String getModule()
  {
    return "mini_app_info";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    INTERFACE.StGetNewBaseLibRsp localStGetNewBaseLibRsp = new INTERFACE.StGetNewBaseLibRsp();
    try
    {
      localStGetNewBaseLibRsp.mergeFrom(paramArrayOfByte);
      int i = localStGetNewBaseLibRsp.interval.get();
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("[MiniEng] GetNewBaseLib interval:");
      paramArrayOfByte.append(i);
      QMLog.i("GetNewBaseLibRequest", paramArrayOfByte.toString());
      long l1 = i * 1000;
      long l2 = System.currentTimeMillis();
      StorageUtil.getPreference().edit().putLong("baselib_min_update_time", l1 + l2).apply();
      paramArrayOfByte = localStGetNewBaseLibRsp.jsOrsoLibs.get().iterator();
      while (paramArrayOfByte.hasNext())
      {
        Object localObject = (INTERFACE.StBaseLibInfo)paramArrayOfByte.next();
        BaseLibInfo localBaseLibInfo = new BaseLibInfo();
        localBaseLibInfo.baseLibUrl = ((INTERFACE.StBaseLibInfo)localObject).downloadUrl.get();
        localBaseLibInfo.baseLibVersion = ((INTERFACE.StBaseLibInfo)localObject).version.get();
        localBaseLibInfo.baseLibKey = null;
        localBaseLibInfo.baseLibDesc = ((INTERFACE.StBaseLibInfo)localObject).extInfo.get();
        if (TextUtils.isEmpty(localBaseLibInfo.baseLibDesc)) {
          localBaseLibInfo.baseLibDesc = "{'file_length':-1}";
        }
        localBaseLibInfo.baseLibType = ((INTERFACE.StBaseLibInfo)localObject).libType.get();
        if (QUAUtil.isAbi64()) {
          localBaseLibInfo.baseLibUrl = getBaseLibUrl64(localBaseLibInfo.baseLibDesc, localBaseLibInfo.baseLibUrl);
        }
        paramJSONObject.put(localBaseLibInfo.getKey(), localBaseLibInfo.toJSONObject());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[MiniEng] GetNewBaseLib ");
        ((StringBuilder)localObject).append(localBaseLibInfo);
        QMLog.i("GetNewBaseLibRequest", ((StringBuilder)localObject).toString());
      }
      paramJSONObject.put("version", localStGetNewBaseLibRsp.libInfo.version.get());
      paramJSONObject.put("downloadUrl", localStGetNewBaseLibRsp.libInfo.downloadUrl.get());
      return paramJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("GetNewBaseLibRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetNewBaseLibRequest
 * JD-Core Version:    0.7.0.1
 */