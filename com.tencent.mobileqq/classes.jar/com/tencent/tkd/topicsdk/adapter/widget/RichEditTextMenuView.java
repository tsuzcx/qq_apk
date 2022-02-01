package com.tencent.tkd.topicsdk.adapter.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.qq_adapter.R.id;
import com.tencent.tkd.topicsdk.qq_adapter.R.layout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/adapter/widget/RichEditTextMenuView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addMentionBtn", "Landroid/view/View;", "addTopicBtn", "onAddMentionBtnClickListener", "Landroid/view/View$OnClickListener;", "onAddTopicBtnClickListener", "titleCountView", "Landroid/widget/TextView;", "setAddMentionBtnClickListener", "", "listener", "setAddTopicBtnClickListener", "updateAddMentionBtnVisibility", "mentionBtnVisible", "", "updateAddTopicBtnVisibility", "topicBtnVisible", "updateTitleCount", "curCount", "limit", "qq-adapter_release"}, k=1, mv={1, 1, 16})
public final class RichEditTextMenuView
  extends LinearLayout
{
  private final View a;
  private final View b;
  private final TextView c;
  private View.OnClickListener d;
  private View.OnClickListener e;
  
  @JvmOverloads
  public RichEditTextMenuView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public RichEditTextMenuView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public RichEditTextMenuView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(R.layout.d, (ViewGroup)this, true);
    paramContext = findViewById(R.id.G);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_add_topic)");
    this.a = paramContext;
    paramContext = findViewById(R.id.F);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_add_mention)");
    this.b = paramContext;
    paramContext = findViewById(R.id.M);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_title_count)");
    this.c = ((TextView)paramContext);
    this.a.setOnClickListener((View.OnClickListener)new RichEditTextMenuView.1(this));
    this.b.setOnClickListener((View.OnClickListener)new RichEditTextMenuView.2(this));
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append('/');
    localStringBuilder.append(paramInt2);
    ((TextView)localObject).setText((CharSequence)localStringBuilder.toString());
    if (paramInt1 > paramInt2) {
      localObject = "#F44837";
    } else {
      localObject = "#AAAAAA";
    }
    paramInt1 = Color.parseColor((String)localObject);
    this.c.setTextColor(paramInt1);
  }
  
  public final void a(boolean paramBoolean)
  {
    View localView = this.a;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  public final void b(boolean paramBoolean)
  {
    View localView = this.b;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  public final void setAddMentionBtnClickListener(@NotNull View.OnClickListener paramOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnClickListener, "listener");
    this.e = paramOnClickListener;
  }
  
  public final void setAddTopicBtnClickListener(@NotNull View.OnClickListener paramOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnClickListener, "listener");
    this.d = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.widget.RichEditTextMenuView
 * JD-Core Version:    0.7.0.1
 */