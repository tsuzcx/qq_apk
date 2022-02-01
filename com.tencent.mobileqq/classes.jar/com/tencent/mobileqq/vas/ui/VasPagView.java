package com.tencent.mobileqq.vas.ui;

import android.content.Context;
import android.util.AttributeSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/VasPagView;", "Lcom/tencent/mobileqq/vas/ui/PagViewProxy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "apiImpl", "Lcom/tencent/mobileqq/vas/ui/VasPagView$MyVasPagViewApiImpl;", "api", "Lcom/tencent/mobileqq/vas/ui/IVasPagViewApi;", "MyVasPagViewApiImpl", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public class VasPagView
  extends PagViewProxy
{
  private final VasPagView.MyVasPagViewApiImpl a = new VasPagView.MyVasPagViewApiImpl(this);
  
  public VasPagView(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VasPagView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VasPagView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @NotNull
  public final IVasPagViewApi g()
  {
    return (IVasPagViewApi)this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.VasPagView
 * JD-Core Version:    0.7.0.1
 */