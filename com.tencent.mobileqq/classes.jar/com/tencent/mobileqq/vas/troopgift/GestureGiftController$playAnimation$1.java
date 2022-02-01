package com.tencent.mobileqq.vas.troopgift;

import android.content.Context;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqva.post.post.GestureGiftCoordinateBean.GetPostRsp;
import com.tencent.xaction.openapi.api.IPublicRuleManager;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "type", "", "isSuccess", "", "data", "", "kotlin.jvm.PlatformType", "onUpdate"}, k=3, mv={1, 1, 16})
final class GestureGiftController$playAnimation$1
  implements BusinessObserver
{
  GestureGiftController$playAnimation$1(GestureGiftController paramGestureGiftController, File[] paramArrayOfFile) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof GestureGiftCoordinateBean.GetPostRsp)))
    {
      Object localObject1 = this.a.f().getRuleManager();
      Object localObject2 = this.a;
      paramObject = ((GestureGiftCoordinateBean.GetPostRsp)paramObject).points;
      Intrinsics.checkExpressionValueIsNotNull(paramObject, "data.points");
      ((IPublicRuleManager)localObject1).registerRuleLine("$COORD_ARRAY", ((GestureGiftController)localObject2).a(paramObject));
      this.a.f().getRuleManager().registerRuleLine("$SUBSCRIBE", new GestureGiftController.playAnimation.1.1(this));
      paramObject = new StringBuilder();
      paramObject.append(this.b[0].getPath());
      paramObject.append("/xa.json");
      paramObject = paramObject.toString();
      localObject1 = this.a.b();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("xa.json exists is ");
      ((StringBuilder)localObject2).append(new File(paramObject).exists());
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      paramObject = this.a.f().setTag("gesture_gift");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.b[0].getPath());
      ((StringBuilder)localObject1).append('/');
      paramObject.initRootAsync(((StringBuilder)localObject1).toString(), (Function0)new GestureGiftController.playAnimation.1.2(this));
      return;
    }
    QQToast.makeText((Context)this.a.m(), (CharSequence)"网络开小差，请重试", 0).show();
    this.a.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.GestureGiftController.playAnimation.1
 * JD-Core Version:    0.7.0.1
 */