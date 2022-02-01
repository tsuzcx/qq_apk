package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import com.tencent.videocut.utils.DensityUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/TopTagViewContainerView;", "Landroid/widget/LinearLayout;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "views", "", "Landroid/widget/TextView;", "createTagView", "context", "refreshView", "", "list", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/TagData;", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TopTagViewContainerView
  extends LinearLayout
{
  public static final TopTagViewContainerView.Companion a = new TopTagViewContainerView.Companion(null);
  private final List<TextView> b = (List)new ArrayList();
  
  @JvmOverloads
  public TopTagViewContainerView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public TopTagViewContainerView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public TopTagViewContainerView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
  }
  
  private final TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    paramContext.setBackgroundResource(2130853643);
    paramContext.setTextSize(9.0F);
    paramContext.setTextColor(-1);
    paramContext.setPadding(DensityUtils.a.a(3.0F), 0, DensityUtils.a.a(3.0F), 0);
    ConstraintLayout.LayoutParams localLayoutParams = new ConstraintLayout.LayoutParams(-2, DensityUtils.a.a(12.0F));
    localLayoutParams.leftMargin = DensityUtils.a.a(3.0F);
    localLayoutParams.topMargin = DensityUtils.a.a(36.0F);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
    return paramContext;
  }
  
  public final void a(@NotNull List<TagData> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    Object localObject;
    if (this.b.size() > paramList.size())
    {
      localIterator = ((Iterable)CollectionsKt.toList((Iterable)this.b.subList(paramList.size(), this.b.size()))).iterator();
      while (localIterator.hasNext())
      {
        localObject = (TextView)localIterator.next();
        this.b.remove(localObject);
        removeView((View)localObject);
      }
    }
    Iterator localIterator = ((Iterable)paramList).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject = (TagData)paramList;
      paramList = this.b;
      if ((i >= 0) && (i <= CollectionsKt.getLastIndex(paramList)))
      {
        paramList = paramList.get(i);
      }
      else
      {
        paramList = getContext();
        Intrinsics.checkExpressionValueIsNotNull(paramList, "context");
        paramList = a(paramList);
        this.b.add(paramList);
        addView((View)paramList);
      }
      paramList = (TextView)paramList;
      int j;
      if (((CharSequence)((TagData)localObject).a()).length() > 0) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        paramList.setText((CharSequence)((TagData)localObject).a());
      } else {
        paramList.setBackgroundResource(((TagData)localObject).b());
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.TopTagViewContainerView
 * JD-Core Version:    0.7.0.1
 */