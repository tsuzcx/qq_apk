package com.tencent.tkd.topicsdk.adapter.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.bean.DisplayItem;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.topicsdk.qq_adapter.R.dimen;
import com.tencent.tkd.topicsdk.qq_adapter.R.id;
import com.tencent.tkd.topicsdk.qq_adapter.R.layout;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/adapter/widget/BigVideoCoverLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "backgroundCoverView", "Landroid/widget/ImageView;", "backgroundShadowView", "changeCoverView", "Landroid/widget/TextView;", "value", "Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "displayItem", "getDisplayItem", "()Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "setDisplayItem", "(Lcom/tencent/tkd/topicsdk/bean/DisplayItem;)V", "foregroundCoverView", "Lkotlin/Function1;", "", "onChangeCoverClickListener", "getOnChangeCoverClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnChangeCoverClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onItemClickListener", "getOnItemClickListener", "setOnItemClickListener", "displayVideoCover", "notifyUI", "Companion", "qq-adapter_release"}, k=1, mv={1, 1, 16})
public final class BigVideoCoverLayout
  extends LinearLayout
{
  public static final BigVideoCoverLayout.Companion a = new BigVideoCoverLayout.Companion(null);
  private ImageView b;
  private ImageView c;
  private ImageView d;
  private TextView e;
  @Nullable
  private DisplayItem f;
  @Nullable
  private Function1<? super DisplayItem, Unit> g;
  @Nullable
  private Function1<? super DisplayItem, Unit> h;
  
  public BigVideoCoverLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(R.layout.b, (ViewGroup)this, true);
    paramContext = findViewById(R.id.q);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_video_cover_background)");
    this.b = ((ImageView)paramContext);
    paramContext = findViewById(R.id.p);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_shadow_background)");
    this.c = ((ImageView)paramContext);
    paramContext = findViewById(R.id.r);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_video_cover_foreground)");
    this.d = ((ImageView)paramContext);
    paramContext = findViewById(R.id.I);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_change_cover)");
    this.e = ((TextView)paramContext);
  }
  
  private final void a()
  {
    DisplayItem localDisplayItem = this.f;
    if (localDisplayItem != null)
    {
      if ((localDisplayItem.getMedia().getWidth() > 0) && (localDisplayItem.getMedia().getHeight() > 0))
      {
        if (!new File(localDisplayItem.getCoverPath()).exists())
        {
          TLog.d("BigVideoCoverLayout", "displayItem cover is not exist.");
          return;
        }
        this.d.setImageDrawable(null);
        this.b.setImageDrawable(null);
        a(localDisplayItem);
        return;
      }
      TLog.d("BigVideoCoverLayout", "displayItem size error.");
    }
  }
  
  private final void a(DisplayItem paramDisplayItem)
  {
    TLog.b("BigVideoCoverLayout", "displaying portrait video cover.");
    this.d.setVisibility(0);
    this.c.setVisibility(0);
    Object localObject = DisplayUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i = ((DisplayUtils)localObject).a(localContext, 197.0F);
    localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    float f1 = ((Context)localObject).getResources().getDimension(R.dimen.a);
    localObject = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    ThreadManagerKt.c((Function0)new BigVideoCoverLayout.displayVideoCover.1(this, paramDisplayItem, i, (int)(((DisplayUtils)localObject).a(localContext) - f1 * 2)));
  }
  
  @Nullable
  public final DisplayItem getDisplayItem()
  {
    return this.f;
  }
  
  @Nullable
  public final Function1<DisplayItem, Unit> getOnChangeCoverClickListener()
  {
    return this.h;
  }
  
  @Nullable
  public final Function1<DisplayItem, Unit> getOnItemClickListener()
  {
    return this.g;
  }
  
  public final void setDisplayItem(@Nullable DisplayItem paramDisplayItem)
  {
    this.f = paramDisplayItem;
    a();
  }
  
  public final void setOnChangeCoverClickListener(@Nullable Function1<? super DisplayItem, Unit> paramFunction1)
  {
    this.h = paramFunction1;
    this.e.setOnClickListener((View.OnClickListener)new BigVideoCoverLayout.onChangeCoverClickListener.1(this, paramFunction1));
  }
  
  public final void setOnItemClickListener(@Nullable Function1<? super DisplayItem, Unit> paramFunction1)
  {
    this.g = paramFunction1;
    setOnClickListener((View.OnClickListener)new BigVideoCoverLayout.onItemClickListener.1(this, paramFunction1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.widget.BigVideoCoverLayout
 * JD-Core Version:    0.7.0.1
 */