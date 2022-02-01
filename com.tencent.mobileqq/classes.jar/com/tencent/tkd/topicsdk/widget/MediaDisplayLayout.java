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
  public static final MediaDisplayLayout.Companion a = new MediaDisplayLayout.Companion(null);
  private boolean b = true;
  @NotNull
  private ArrayList<DisplayItem> c = new ArrayList();
  private MediaDisplayLayout.MediaDisplayGridAdapter d;
  private int e = -1;
  @Nullable
  private Function0<Unit> f;
  @Nullable
  private Function1<? super Integer, Unit> g;
  @Nullable
  private Function1<? super Integer, Unit> h;
  @Nullable
  private Function1<? super Integer, Unit> i;
  private final int j;
  private final int k;
  
  public MediaDisplayLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.j = DisplayUtils.a.a(paramContext, 26.0F);
    this.k = ((DisplayUtils.a.a(paramContext) - this.j) / 3);
    LayoutInflater.from(paramContext).inflate(R.layout.y, (ViewGroup)this, true);
    this.d = new MediaDisplayLayout.MediaDisplayGridAdapter(this);
    a();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private final void a()
  {
    GridView localGridView = (GridView)findViewById(R.id.v);
    Intrinsics.checkExpressionValueIsNotNull(localGridView, "it");
    localGridView.setAdapter((ListAdapter)this.d);
    localGridView.setOnTouchListener((View.OnTouchListener)new MediaDisplayLayout.initGridView..inlined.also.lambda.1(this));
  }
  
  @NotNull
  public final ArrayList<DisplayItem> getDisplayItems()
  {
    return this.c;
  }
  
  public final int getDisplayItemsHeight()
  {
    return this.k;
  }
  
  @NotNull
  public final MediaDisplayLayout.MediaDisplayGridAdapter getGridViewAdapter()
  {
    return this.d;
  }
  
  public final int getLastClickPosition()
  {
    return this.e;
  }
  
  @Nullable
  public final Function1<Integer, Unit> getOnCoverSelectListener()
  {
    return this.h;
  }
  
  @Nullable
  public final Function1<Integer, Unit> getOnItemClickListener()
  {
    return this.g;
  }
  
  @Nullable
  public final Function1<Integer, Unit> getOnItemDelListener()
  {
    return this.i;
  }
  
  @Nullable
  public final Function0<Unit> getOnScrollListener()
  {
    return this.f;
  }
  
  public final boolean getShowDelImage()
  {
    return this.b;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    double d1 = this.d.getCount();
    double d2 = 3;
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 = Math.ceil(d1 / d2);
    d2 = this.k + 2;
    Double.isNaN(d2);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec((int)(d1 * d2), 1073741824));
  }
  
  public final void setDisplayItems(@NotNull ArrayList<DisplayItem> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "value");
    this.c = paramArrayList;
    this.d.notifyDataSetChanged();
  }
  
  public final void setLastClickPosition(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void setOnCoverSelectListener(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.h = paramFunction1;
  }
  
  public final void setOnItemClickListener(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.g = paramFunction1;
  }
  
  public final void setOnItemDelListener(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.i = paramFunction1;
  }
  
  public final void setOnScrollListener(@Nullable Function0<Unit> paramFunction0)
  {
    this.f = paramFunction0;
  }
  
  public final void setShowDelImage(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.MediaDisplayLayout
 * JD-Core Version:    0.7.0.1
 */