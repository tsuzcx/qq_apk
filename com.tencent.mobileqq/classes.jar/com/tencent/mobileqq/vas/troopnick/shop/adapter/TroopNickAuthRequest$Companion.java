package com.tencent.mobileqq.vas.troopnick.shop.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/troopnick/shop/adapter/TroopNickAuthRequest$Companion;", "", "()V", "AUTH_CMD", "", "AUTH_SERVANT_NAME", "buy", "", "context", "Landroid/content/Context;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TroopNickAuthRequest$Companion
{
  @JvmStatic
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("mode", "common");
    ((JSONObject)localObject1).put("businessType", "100");
    ((JSONObject)localObject1).put("itemId", "403_b53acf98");
    ((JSONObject)localObject1).put("buyNum", 1);
    ((JSONObject)localObject1).put("sandbox", 0);
    ((JSONObject)localObject1).put("aid", "mvip.g.a.qnc_20rx");
    ((JSONObject)localObject1).put("baseUrl", "https://zb.vip.qq.com/v2");
    localObject1 = ((JSONObject)localObject1).toString();
    if ((localObject1 != null) && (localObject1 != null)) {}
    for (;;)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "JSONObject().let {\n     …ULT);\n            } ?: \"\"");
      Object localObject2 = "https://h5.vip.qq.com/p/pay/vippaylogic.html?vipPayLogicParams=" + (String)localObject1;
      localObject1 = new Intent(paramContext, QQTranslucentBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", (String)localObject2);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putBoolean("hide_left_button", true);
      ((Bundle)localObject2).putBoolean("hide_more_button", true);
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      ((Intent)localObject1).setFlags(268435456);
      paramContext.startActivity((Intent)localObject1);
      return;
      localObject1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.adapter.TroopNickAuthRequest.Companion
 * JD-Core Version:    0.7.0.1
 */