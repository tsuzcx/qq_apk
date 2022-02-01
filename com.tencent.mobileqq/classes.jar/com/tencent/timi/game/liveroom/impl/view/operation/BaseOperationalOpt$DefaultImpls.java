package com.tencent.timi.game.liveroom.impl.view.operation;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.web.business.api.IWebBusinessService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class BaseOperationalOpt$DefaultImpls
{
  public static void a(BaseOperationalOpt paramBaseOperationalOpt, @NotNull OperationItem paramOperationItem)
  {
    Intrinsics.checkParameterIsNotNull(paramOperationItem, "data");
    paramBaseOperationalOpt = new StringBuilder();
    paramBaseOperationalOpt.append("doJumpTask ");
    paramBaseOperationalOpt.append(paramOperationItem);
    Logger.b("BaseOperationalOpt", paramBaseOperationalOpt.toString());
    paramBaseOperationalOpt = paramOperationItem.b();
    int i = paramBaseOperationalOpt.hashCode();
    if (i != 48)
    {
      if ((i == 49) && (paramBaseOperationalOpt.equals("1")))
      {
        paramBaseOperationalOpt = BaseApplication.context;
        if ("0".equals(paramOperationItem.d()))
        {
          localObject = (IWebBusinessService)ServiceCenter.a(IWebBusinessService.class);
          Intrinsics.checkExpressionValueIsNotNull(paramBaseOperationalOpt, "context");
          ((IWebBusinessService)localObject).a((Context)paramBaseOperationalOpt, paramOperationItem.c());
          return;
        }
        Object localObject = new Intent((Context)paramBaseOperationalOpt, QQBrowserActivity.class);
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("url", paramOperationItem.c());
        paramBaseOperationalOpt.startActivity((Intent)localObject);
      }
    }
    else if (paramBaseOperationalOpt.equals("0")) {
      return;
    }
    paramBaseOperationalOpt = JumpParser.a((BaseQQAppInterface)TimiGameActivityManager.c(), (Context)TimiGameActivityManager.a(), paramOperationItem.c());
    paramOperationItem = new StringBuilder();
    paramOperationItem.append("doJumpTask action:");
    paramOperationItem.append(paramBaseOperationalOpt);
    Logger.a("BaseOperationalOpt", 1, paramOperationItem.toString());
    if (paramBaseOperationalOpt != null) {
      paramBaseOperationalOpt.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.operation.BaseOperationalOpt.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */