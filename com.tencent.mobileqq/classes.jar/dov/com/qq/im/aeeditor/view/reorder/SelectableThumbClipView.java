package dov.com.qq.im.aeeditor.view.reorder;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zau;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Ldov/com/qq/im/aeeditor/view/reorder/SelectableThumbClipView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "durationView", "Landroid/widget/TextView;", "getDurationView", "()Landroid/widget/TextView;", "setDurationView", "(Landroid/widget/TextView;)V", "foregroundView", "Landroid/view/View;", "thumbView", "Ldov/com/qq/im/aeeditor/view/reorder/ThumbClipView;", "getThumbView", "()Ldov/com/qq/im/aeeditor/view/reorder/ThumbClipView;", "setSelected", "", "selected", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
@RequiresApi(16)
public final class SelectableThumbClipView
  extends FrameLayout
{
  private final View jdField_a_of_type_AndroidViewView;
  @NotNull
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @NotNull
  private final ThumbClipView jdField_a_of_type_DovComQqImAeeditorViewReorderThumbClipView;
  
  @JvmOverloads
  public SelectableThumbClipView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public SelectableThumbClipView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public SelectableThumbClipView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidViewView = new View(paramContext);
    this.jdField_a_of_type_DovComQqImAeeditorViewReorderThumbClipView = new ThumbClipView(paramContext, null, 0, 6, null);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(getResources().getDimensionPixelSize(2131296330), getResources().getDimensionPixelSize(2131296328)));
    this.jdField_a_of_type_AndroidViewView.setBackground(getResources().getDrawable(2130837708));
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    paramAttributeSet = new FrameLayout.LayoutParams(-2, (int)getResources().getDimension(2131296313));
    paramAttributeSet.leftMargin = ((int)getResources().getDimension(2131296289));
    paramAttributeSet.bottomMargin = ((int)getResources().getDimension(2131296291));
    paramAttributeSet.gravity = 83;
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, getResources().getDimension(2131296309));
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    localTextView.setTextColor(localTextView.getResources().getColor(2131167337));
    this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(2.0F, 1.0F, 1.0F, 2131165362);
    this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(80);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding((int)getResources().getDimension(2131296290), 0, (int)getResources().getDimension(2131296290), 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(zau.a(paramContext, "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)paramAttributeSet);
    addView((View)this.jdField_a_of_type_DovComQqImAeeditorViewReorderThumbClipView);
    addView(this.jdField_a_of_type_AndroidViewView);
    addView((View)this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  @NotNull
  public final TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  @NotNull
  public final ThumbClipView a()
  {
    return this.jdField_a_of_type_DovComQqImAeeditorViewReorderThumbClipView;
  }
  
  public final void setDurationView(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "<set-?>");
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.reorder.SelectableThumbClipView
 * JD-Core Version:    0.7.0.1
 */