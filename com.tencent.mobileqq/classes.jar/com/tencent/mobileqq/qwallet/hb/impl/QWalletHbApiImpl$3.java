package com.tencent.mobileqq.qwallet.hb.impl;

import android.app.Activity;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import cooperation.qwallet.QwUtils.AnsyListener;
import java.util.HashMap;
import java.util.Map;

class QWalletHbApiImpl$3
  implements QwUtils.AnsyListener
{
  QWalletHbApiImpl$3(QWalletHbApiImpl paramQWalletHbApiImpl, int paramInt1, BaseSessionInfo paramBaseSessionInfo, BaseQQAppInterface paramBaseQQAppInterface, int paramInt2, String paramString, Activity paramActivity) {}
  
  public void a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs.length > 0) && (paramVarArgs[0] != null))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("pskey_type", "27");
      localHashMap.put("pskey", paramVarArgs[0]);
      paramVarArgs = new StringBuilder();
      paramVarArgs.append(this.a);
      paramVarArgs.append("");
      localHashMap.put("recv_group_type", paramVarArgs.toString());
      localHashMap.put("recv_group_id", this.b.b);
      localHashMap.put("send_nickname", ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getGrayBarShowName(this.b.b, this.c.getCurrentUin()));
      localHashMap.put("send_uin", this.c.getCurrentUin());
      paramVarArgs = new StringBuilder();
      paramVarArgs.append(this.d);
      paramVarArgs.append("");
      localHashMap.put("group_count", paramVarArgs.toString());
      paramVarArgs = QwUtils.a(this.e, localHashMap, true);
      ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).doJumpAction(this.f, paramVarArgs);
      return;
    }
    QLog.i("QWalletHbApi", 2, "error get pskey...");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.QWalletHbApiImpl.3
 * JD-Core Version:    0.7.0.1
 */