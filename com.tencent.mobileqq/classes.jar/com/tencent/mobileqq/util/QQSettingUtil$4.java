package com.tencent.mobileqq.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

final class QQSettingUtil$4
  implements INetEngineListener
{
  public void onResp(NetResp paramNetResp)
  {
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.putString("vip_qqsetting_last_update_time", new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date()));
    if ((paramNetResp != null) && (paramNetResp.mResult == 0) && (paramNetResp.mRespData.length > 0)) {}
    for (;;)
    {
      try
      {
        paramNetResp = new JSONArray(new String(paramNetResp.mRespData, "UTF-8"));
        if ((paramNetResp != null) && (paramNetResp.length() > 0))
        {
          i = 0;
          if (i < paramNetResp.length())
          {
            JSONObject localJSONObject = paramNetResp.getJSONObject(i);
            if ((localJSONObject == null) || (localJSONObject.getInt("id") != 1)) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QQSetting", 2, "requestMyVipInfo result= " + localJSONObject.toString());
            }
            localEditor.putString("vip_qqsetting_title_vip", localJSONObject.optString("vip", "我的QQ会员"));
            localEditor.putString("vip_qqsetting_title_svip", localJSONObject.optString("svip", HardCodeUtil.a(2131710711)));
            localEditor.putString("vip_qqsetting_title_notvip", localJSONObject.optString("notVip", HardCodeUtil.a(2131710723)));
            localEditor.putString("vip_qqsetting_title_expired_vip", localJSONObject.optString("outdatedVip", HardCodeUtil.a(2131710722)));
          }
        }
      }
      catch (Exception paramNetResp)
      {
        int i;
        paramNetResp.printStackTrace();
        continue;
      }
      localEditor.commit();
      return;
      i += 1;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.QQSettingUtil.4
 * JD-Core Version:    0.7.0.1
 */