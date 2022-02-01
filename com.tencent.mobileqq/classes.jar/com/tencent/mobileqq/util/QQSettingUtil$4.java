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
    if ((paramNetResp != null) && (paramNetResp.mResult == 0) && (paramNetResp.mRespData.length > 0)) {
      try
      {
        Object localObject = new JSONArray(new String(paramNetResp.mRespData, "UTF-8"));
        if (((JSONArray)localObject).length() > 0)
        {
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            paramNetResp = ((JSONArray)localObject).getJSONObject(i);
            if ((paramNetResp != null) && (paramNetResp.getInt("id") == 1))
            {
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("requestMyVipInfo result= ");
                ((StringBuilder)localObject).append(paramNetResp.toString());
                QLog.d("QQSetting", 2, ((StringBuilder)localObject).toString());
              }
              localEditor.putString("vip_qqsetting_title_vip", paramNetResp.optString("vip", "我的QQ会员"));
              localEditor.putString("vip_qqsetting_title_svip", paramNetResp.optString("svip", HardCodeUtil.a(2131908369)));
              localEditor.putString("vip_qqsetting_title_notvip", paramNetResp.optString("notVip", HardCodeUtil.a(2131908381)));
              localEditor.putString("vip_qqsetting_title_expired_vip", paramNetResp.optString("outdatedVip", HardCodeUtil.a(2131908380)));
              break;
            }
            i += 1;
          }
        }
        localEditor.commit();
      }
      catch (Exception paramNetResp)
      {
        paramNetResp.printStackTrace();
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.QQSettingUtil.4
 * JD-Core Version:    0.7.0.1
 */