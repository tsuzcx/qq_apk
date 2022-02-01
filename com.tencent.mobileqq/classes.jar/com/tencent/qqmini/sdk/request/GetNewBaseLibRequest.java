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
      if (localStGetNewBaseLibRsp == null) {
        break label325;
      }
      int i = localStGetNewBaseLibRsp.interval.get();
      QMLog.i("GetNewBaseLibRequest", "[MiniEng] GetNewBaseLib interval:" + i);
      long l1 = i * 1000;
      long l2 = System.currentTimeMillis();
      StorageUtil.getPreference().edit().putLong("baselib_min_update_time", l1 + l2).apply();
      paramArrayOfByte = localStGetNewBaseLibRsp.jsOrsoLibs.get().iterator();
      while (paramArrayOfByte.hasNext())
      {
        INTERFACE.StBaseLibInfo localStBaseLibInfo = (INTERFACE.StBaseLibInfo)paramArrayOfByte.next();
        BaseLibInfo localBaseLibInfo = new BaseLibInfo();
        localBaseLibInfo.baseLibUrl = localStBaseLibInfo.downloadUrl.get();
        localBaseLibInfo.baseLibVersion = localStBaseLibInfo.version.get();
        localBaseLibInfo.baseLibKey = null;
        localBaseLibInfo.baseLibDesc = localStBaseLibInfo.extInfo.get();
        if (TextUtils.isEmpty(localBaseLibInfo.baseLibDesc)) {
          localBaseLibInfo.baseLibDesc = "{'file_length':-1}";
        }
        localBaseLibInfo.baseLibType = localStBaseLibInfo.libType.get();
        paramJSONObject.put(localBaseLibInfo.getKey(), localBaseLibInfo.toJSONObject());
        QMLog.i("GetNewBaseLibRequest", "[MiniEng] GetNewBaseLib " + localBaseLibInfo);
      }
      paramJSONObject.put("version", localStGetNewBaseLibRsp.libInfo.version.get());
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("GetNewBaseLibRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    paramJSONObject.put("downloadUrl", localStGetNewBaseLibRsp.libInfo.downloadUrl.get());
    return paramJSONObject;
    label325:
    QMLog.d("GetNewBaseLibRequest", "onResponse fail.rsp = null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetNewBaseLibRequest
 * JD-Core Version:    0.7.0.1
 */