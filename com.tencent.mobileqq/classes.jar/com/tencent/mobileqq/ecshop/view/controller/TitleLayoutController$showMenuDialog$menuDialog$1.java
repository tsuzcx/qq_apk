package com.tencent.mobileqq.ecshop.view.controller;

import com.tencent.mobileqq.ecshop.conf.EcshopConfBean.MenuConfBean;
import com.tencent.mobileqq.ecshop.report.ReportUtil;
import com.tencent.mobileqq.ecshop.view.EcshopMenuDialog.OnClickActionListener;
import com.tencent.mobileqq.ecshop.view.EcshopMenuDialog.ViewTag;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "viewTag", "Lcom/tencent/mobileqq/ecshop/view/EcshopMenuDialog$ViewTag;", "onClickAction"}, k=3, mv={1, 1, 16})
final class TitleLayoutController$showMenuDialog$menuDialog$1
  implements EcshopMenuDialog.OnClickActionListener
{
  TitleLayoutController$showMenuDialog$menuDialog$1(TitleLayoutController paramTitleLayoutController) {}
  
  public final void a(@NotNull EcshopMenuDialog.ViewTag paramViewTag)
  {
    Intrinsics.checkParameterIsNotNull(paramViewTag, "viewTag");
    Object localObject1 = this.a;
    Object localObject2 = paramViewTag.b;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "viewTag.menuConfBean");
    TitleLayoutController.a((TitleLayoutController)localObject1, (EcshopConfBean.MenuConfBean)localObject2);
    localObject1 = TitleLayoutController.b(this.a).get("pvsrc");
    localObject2 = "";
    if (localObject1 != null) {
      localObject1 = (String)TitleLayoutController.b(this.a).get("pvsrc");
    } else {
      localObject1 = "";
    }
    if (TitleLayoutController.b(this.a).get("ext10") != null) {
      localObject2 = (String)TitleLayoutController.b(this.a).get("ext10");
    }
    int j = paramViewTag.b.b;
    long l = NetConnInfoCenter.getServerTimeMillis();
    int i;
    if (paramViewTag.b.a != 0) {
      i = 1;
    } else {
      i = 0;
    }
    ReportUtil.a("qgg_menu_click", String.valueOf(j), String.valueOf(l), String.valueOf(i), (String)localObject1, (String)localObject2, "");
    paramViewTag.b.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.TitleLayoutController.showMenuDialog.menuDialog.1
 * JD-Core Version:    0.7.0.1
 */