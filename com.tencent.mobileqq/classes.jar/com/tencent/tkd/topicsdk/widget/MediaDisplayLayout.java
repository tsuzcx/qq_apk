package com.tencent.tkd.topicsdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.bean.DisplayItem;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/MediaDisplayLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "Lkotlin/collections/ArrayList;", "displayItems", "getDisplayItems", "()Ljava/util/ArrayList;", "setDisplayItems", "(Ljava/util/ArrayList;)V", "displayItemsHeight", "", "getDisplayItemsHeight", "()I", "gridViewAdapter", "Lcom/tencent/tkd/topicsdk/widget/MediaDisplayLayout$MediaDisplayGridAdapter;", "getGridViewAdapter", "()Lcom/tencent/tkd/topicsdk/widget/MediaDisplayLayout$MediaDisplayGridAdapter;", "horizontalPadding", "lastClickPosition", "getLastClickPosition", "setLastClickPosition", "(I)V", "mGridViewAdapter", "onCoverSelectListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "", "getOnCoverSelectListener", "()Lkotlin/jvm/functions/Function1;", "setOnCoverSelectListener", "(Lkotlin/jvm/functions/Function1;)V", "onItemClickListener", "getOnItemClickListener", "setOnItemClickListener", "onItemDelListener", "getOnItemDelListener", "setOnItemDelListener", "onScrollListener", "Lkotlin/Function0;", "getOnScrollListener", "()Lkotlin/jvm/functions/Function0;", "setOnScrollListener", "(Lkotlin/jvm/functions/Function0;)V", "showDelImage", "", "getShowDelImage", "()Z", "setShowDelImage", "(Z)V", "initGridView", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "Companion", "DisplayViewHolder", "MediaDisplayGridAdapter", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class MediaDisplayLayout
  extends RelativeLayout
{
  public static final MediaDisplayLayout.Companion a;
  private int jdField_a_of_type_Int = -1;
  private MediaDisplayLayout.MediaDisplayGridAdapter jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout$MediaDisplayGridAdapter;
  @NotNull
  private ArrayList<DisplayItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  @Nullable
  private Function0<Unit> jdField_a_of_type_KotlinJvmFunctionsFunction0;
  @Nullable
  private Function1<? super Integer, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  private boolean jdField_a_of_type_Boolean = true;
  private final int jdField_b_of_type_Int;
  @Nullable
  private Function1<? super Integer, Unit> jdField_b_of_type_KotlinJvmFunctionsFunction1;
  private final int jdField_c_of_type_Int;
  @Nullable
  private Function1<? super Integer, Unit> jdField_c_of_type_KotlinJvmFunctionsFunction1;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout$Companion = new MediaDisplayLayout.Companion(null);
  }
  
  public MediaDisplayLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = DisplayUtils.a.a(paramContext, 26.0F);
    this.jdField_c_of_type_Int = ((DisplayUtils.a.a(paramContext) - this.jdField_b_of_type_Int) / 3);
    LayoutInflater.from(paramContext).inflate(R.layout.C, (ViewGroup)this, true);
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout$MediaDisplayGridAdapter = new MediaDisplayLayout.MediaDisplayGridAdapter(this);
    a();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private final void a()
  {
    GridView localGridView = (GridView)findViewById(R.id.O);
    Intrinsics.checkExpressionValueIsNotNull(localGridView, "it");
    localGridView.setAdapter((ListAdapter)this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout$MediaDisplayGridAdapter);
    localGridView.setOnTouchListener((View.OnTouchListener)new MediaDisplayLayout.initGridView..inlined.also.lambda.1(this));
  }
  
  public final int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  @NotNull
  public final ArrayList<DisplayItem> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  @Nullable
  public final Function0<Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction0;
  }
  
  @Nullable
  public final Function1<Integer, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  @Nullable
  public final Function1<Integer, Unit> b()
  {
    return this.jdField_b_of_type_KotlinJvmFunctionsFunction1;
  }
  
  @Nullable
  public final Function1<Integer, Unit> c()
  {
    return this.jdField_c_of_type_KotlinJvmFunctionsFunction1;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    double d1 = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout$MediaDisplayGridAdapter.getCount();
    double d2 = 3;
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 = Math.ceil(d1 / d2);
    d2 = this.jdField_c_of_type_Int + 2;
    Double.isNaN(d2);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec((int)(d1 * d2), 1073741824));
  }
  
  public final void setDisplayItems(@NotNull ArrayList<DisplayItem> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "value");
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetMediaDisplayLayout$MediaDisplayGridAdapter.notifyDataSetChanged();
  }
  
  public final void setLastClickPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void setOnCoverSelectListener(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.jdField_b_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void setOnItemClickListener(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void setOnItemDelListener(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.jdField_c_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void setOnScrollListener(@Nullable Function0<Unit> paramFunction0)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction0 = paramFunction0;
  }
  
  public final void setShowDelImage(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.MediaDisplayLayout
 * JD-Core Version:    0.7.0.1
 */