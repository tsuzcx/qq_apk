package com.tencent.mobileqq.vas.troopnick;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.FormSimpleItem;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/troopnick/TroopNickFormItem;", "Lcom/tencent/mobileqq/widget/FormSimpleItem;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isShowArrow", "", "showArrow", "", "show", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TroopNickFormItem
  extends FormSimpleItem
{
  private boolean d;
  
  public TroopNickFormItem(@Nullable Context paramContext)
  {
    super(paramContext);
  }
  
  public TroopNickFormItem(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.TroopNickFormItem
 * JD-Core Version:    0.7.0.1
 */