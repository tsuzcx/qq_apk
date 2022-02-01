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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/adapter/widget/BigVideoCoverLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "backgroundCoverView", "Landroid/widget/ImageView;", "backgroundShadowView", "changeCoverView", "Landroid/widget/TextView;", "value", "Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "displayItem", "getDisplayItem", "()Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "setDisplayItem", "(Lcom/tencent/tkd/topicsdk/bean/DisplayItem;)V", "foregroundCoverView", "Lkotlin/Function1;", "", "onChangeCoverClickListener", "getOnChangeCoverClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnChangeCoverClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onItemClickListener", "getOnItemClickListener", "setOnItemClickListener", "displayHorizontalVideoCover", "displayPortraitVideoCover", "notifyUI", "updatePortraitVideoForegroundView", "backgroundViewHeight", "", "Companion", "qq-adapter_release"}, k=1, mv={1, 1, 16})
public final class BigVideoCoverLayout
  extends LinearLayout
{
  public static final BigVideoCoverLayout.Companion a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @Nullable
  private DisplayItem jdField_a_of_type_ComTencentTkdTopicsdkBeanDisplayItem;
  @Nullable
  private Function1<? super DisplayItem, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  @Nullable
  private Function1<? super DisplayItem, Unit> jdField_b_of_type_KotlinJvmFunctionsFunction1;
  private ImageView c;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetBigVideoCoverLayout$Companion = new BigVideoCoverLayout.Companion(null);
  }
  
  public BigVideoCoverLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(R.layout.b, (ViewGroup)this, true);
    paramContext = findViewById(R.id.i);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_video_cover_background)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext);
    paramContext = findViewById(R.id.h);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_shadow_background)");
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramContext);
    paramContext = findViewById(R.id.j);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_video_cover_foreground)");
    this.c = ((ImageView)paramContext);
    paramContext = findViewById(R.id.y);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_change_cover)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext);
  }
  
  private final void a()
  {
    DisplayItem localDisplayItem = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanDisplayItem;
    if (localDisplayItem != null)
    {
      if ((localDisplayItem.getMedia().getWidth() > 0) && (localDisplayItem.getMedia().getHeight() > 0))
      {
        if (!new File(localDisplayItem.getCoverPath()).exists())
        {
          TLog.d("BigVideoCoverLayout", "displayItem cover is not exist.");
          return;
        }
        this.c.setImageDrawable(null);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        if (localDisplayItem.getMedia().getWidth() > localDisplayItem.getMedia().getHeight())
        {
          a(localDisplayItem);
          return;
        }
        b(localDisplayItem);
        return;
      }
      TLog.d("BigVideoCoverLayout", "displayItem size error.");
    }
  }
  
  private final void a(DisplayItem paramDisplayItem)
  {
    TLog.b("BigVideoCoverLayout", "displaying horizontal video cover.");
    paramDisplayItem = paramDisplayItem.getCoverPath();
    this.c.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    ThreadManagerKt.c((Function0)new BigVideoCoverLayout.displayHorizontalVideoCover.1(this, paramDisplayItem));
  }
  
  private final void a(DisplayItem paramDisplayItem, int paramInt)
  {
    int i = paramDisplayItem.getMedia().getWidth();
    int j = paramDisplayItem.getMedia().getHeight();
    if ((j > 0) && (i > 0))
    {
      paramInt = paramInt * i / j;
      paramDisplayItem = this.c.getLayoutParams();
      paramDisplayItem.width = paramInt;
      this.c.setLayoutParams(paramDisplayItem);
      return;
    }
    TLog.d("BigVideoCoverLayout", "invalid params. mediaHeight or mediaWidth must not < 0");
  }
  
  private final void b(DisplayItem paramDisplayItem)
  {
    TLog.b("BigVideoCoverLayout", "displaying portrait video cover.");
    this.c.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    Object localObject = DisplayUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i = ((DisplayUtils)localObject).a(localContext, 197.0F);
    localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    float f = ((Context)localObject).getResources().getDimension(R.dimen.a);
    localObject = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int j = (int)(((DisplayUtils)localObject).a(localContext) - f * 2);
    a(paramDisplayItem, i);
    ThreadManagerKt.c((Function0)new BigVideoCoverLayout.displayPortraitVideoCover.1(this, paramDisplayItem, j, i));
  }
  
  @Nullable
  public final DisplayItem a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkBeanDisplayItem;
  }
  
  public final void setDisplayItem(@Nullable DisplayItem paramDisplayItem)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanDisplayItem = paramDisplayItem;
    a();
  }
  
  public final void setOnChangeCoverClickListener(@Nullable Function1<? super DisplayItem, Unit> paramFunction1)
  {
    this.jdField_b_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)new BigVideoCoverLayout.onChangeCoverClickListener.1(this, paramFunction1));
  }
  
  public final void setOnItemClickListener(@Nullable Function1<? super DisplayItem, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
    setOnClickListener((View.OnClickListener)new BigVideoCoverLayout.onItemClickListener.1(this, paramFunction1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.widget.BigVideoCoverLayout
 * JD-Core Version:    0.7.0.1
 */