package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.widget.MultiImageTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/widget/QIDStatusFormSimpleItem;", "Lcom/tencent/mobileqq/widget/FormSimpleItem;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "updateRightViews", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QIDStatusFormSimpleItem
  extends FormSimpleItem
{
  public QIDStatusFormSimpleItem(@Nullable Context paramContext)
  {
    super(paramContext);
  }
  
  public QIDStatusFormSimpleItem(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    super.a();
    MultiImageTextView localMultiImageTextView = this.a;
    Intrinsics.checkExpressionValueIsNotNull(localMultiImageTextView, "mRightTextView");
    localMultiImageTextView.setCompoundDrawablePadding(AIOUtils.dp2px(12.0F, getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QIDStatusFormSimpleItem
 * JD-Core Version:    0.7.0.1
 */