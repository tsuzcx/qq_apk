package com.tencent.timi.game.scheme.tools;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.utils.Logger;

final class SchemeUtil$1
  implements SchemeUtil.LaunchSchemeCallback
{
  SchemeUtil$1(boolean paramBoolean, String paramString1, String paramString2, Context paramContext) {}
  
  public void a(Exception paramException)
  {
    Object localObject = SchemeUtil.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchGame ERROR ");
    localStringBuilder.append(this.a);
    Logger.a((String)localObject, localStringBuilder.toString(), paramException);
    if ((!this.a) && (paramException != null) && ((paramException instanceof SecurityException)) && (Env.a() != null))
    {
      paramException = Env.a();
      localObject = new Intent();
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).putExtra("schemestring", this.b);
      ((Intent)localObject).putExtra("src_biz", this.c);
      QPublicFragmentActivity.Launcher.a(paramException, (Intent)localObject, QPublicTransFragmentActivity.class, SchemeRouteTranslucentFragment.class);
      return;
    }
    Toast.makeText(this.d, "启动应用程序失败", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.scheme.tools.SchemeUtil.1
 * JD-Core Version:    0.7.0.1
 */