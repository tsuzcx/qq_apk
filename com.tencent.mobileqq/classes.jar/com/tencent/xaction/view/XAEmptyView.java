package com.tencent.xaction.view;

import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/view/XAEmptyView;", "Lcom/tencent/xaction/api/IView;", "()V", "decor", "Lcom/tencent/xaction/api/base/DecorView;", "getDecor", "()Lcom/tencent/xaction/api/base/DecorView;", "setDecor", "(Lcom/tencent/xaction/api/base/DecorView;)V", "Companion", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class XAEmptyView
  implements IView
{
  public static final XAEmptyView.Companion a;
  @NotNull
  private DecorView a;
  
  static
  {
    jdField_a_of_type_ComTencentXactionViewXAEmptyView$Companion = new XAEmptyView.Companion(null);
  }
  
  public XAEmptyView()
  {
    this.jdField_a_of_type_ComTencentXactionApiBaseDecorView = new DecorView((IView)this);
  }
  
  @NotNull
  public DecorView a()
  {
    return this.jdField_a_of_type_ComTencentXactionApiBaseDecorView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.view.XAEmptyView
 * JD-Core Version:    0.7.0.1
 */