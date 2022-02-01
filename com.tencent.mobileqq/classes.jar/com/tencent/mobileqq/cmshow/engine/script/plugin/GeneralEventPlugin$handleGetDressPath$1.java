package com.tencent.mobileqq.cmshow.engine.script.plugin;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameBasicEventUtil.NotifyDressReady;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.model.Argument;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mobileqq/app/QQAppInterface;", "kotlin.jvm.PlatformType", "uin", "", "openId", "cmd", "roleId", "", "dressIds", "", "from", "onDressReady"}, k=3, mv={1, 1, 16})
final class GeneralEventPlugin$handleGetDressPath$1
  implements ApolloGameBasicEventUtil.NotifyDressReady
{
  GeneralEventPlugin$handleGetDressPath$1(Argument paramArgument) {}
  
  public final void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      GeneralEventPlugin.b();
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("[getRoleDressPath], uin:");
      paramQQAppInterface.append(paramString1);
      paramQQAppInterface.append(", roleId:");
      paramQQAppInterface.append(paramInt1);
      paramQQAppInterface.append(", from:");
      paramQQAppInterface.append(paramInt2);
      paramQQAppInterface.append(", cmd:");
      paramQQAppInterface.append(paramString3);
      QLog.d("[cmshow][GeneralEventPlugin]", 2, paramQQAppInterface.toString());
    }
    if (paramArrayOfInt != null)
    {
      if (paramArrayOfInt.length == 0) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      if (paramInt2 != 0) {
        return;
      }
      try
      {
        paramQQAppInterface = ApolloGameBasicEventUtil.a(paramInt1, paramArrayOfInt);
        if (paramQQAppInterface == null)
        {
          GeneralEventPlugin.b();
          QLog.e("[cmshow][GeneralEventPlugin]", 1, "getRoleDressPath errInfo-> jsonObject is NULL");
          return;
        }
        paramQQAppInterface.put("errCode", 0);
        if (!TextUtils.isEmpty((CharSequence)paramString2)) {
          paramQQAppInterface.put("openId", paramString2);
        } else {
          paramQQAppInterface.put("uin", paramString1);
        }
        paramString1 = this.a;
        Intrinsics.checkExpressionValueIsNotNull(paramString3, "cmd");
        paramString1.a(paramString3, paramQQAppInterface.toString());
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        GeneralEventPlugin.b();
        QLog.e("[cmshow][GeneralEventPlugin]", 1, "[notifyRoleDress], errInfo->", (Throwable)paramQQAppInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.plugin.GeneralEventPlugin.handleGetDressPath.1
 * JD-Core Version:    0.7.0.1
 */