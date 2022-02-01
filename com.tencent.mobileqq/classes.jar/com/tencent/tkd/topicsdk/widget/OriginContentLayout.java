package com.tencent.tkd.topicsdk.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.bean.OriginContentInfo;
import com.tencent.tkd.topicsdk.common.StringKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/OriginContentLayout;", "Lcom/tencent/tkd/topicsdk/widget/RoundRelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "durationTv", "Landroid/widget/TextView;", "imageView", "Landroid/widget/ImageView;", "summaryTv", "titleTv", "setOriginContentInfo", "", "info", "Lcom/tencent/tkd/topicsdk/bean/OriginContentInfo;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class OriginContentLayout
  extends RoundRelativeLayout
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  private TextView c;
  
  public OriginContentLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(R.layout.D, (ViewGroup)this, true);
    paramContext = findViewById(R.id.Q);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.image)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext);
    paramContext = findViewById(R.id.aX);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_duration)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    paramContext = findViewById(R.id.bi);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_title)");
    this.b = ((TextView)paramContext);
    paramContext = findViewById(R.id.bg);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_summary)");
    this.c = ((TextView)paramContext);
    setBackgroundColor(Color.parseColor("#F5F6FA"));
    setRoundLayoutRadius(16.0F);
  }
  
  public final void setOriginContentInfo(@NotNull OriginContentInfo paramOriginContentInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramOriginContentInfo, "info");
    ((View)this).setVisibility(0);
    Object localObject1 = (View)this.jdField_a_of_type_AndroidWidgetTextView;
    int i = paramOriginContentInfo.getType();
    int j = 1;
    if (i == 2) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      i = 0;
    } else {
      i = 8;
    }
    ((View)localObject1).setVisibility(i);
    if (((CharSequence)paramOriginContentInfo.getDurationString()).length() > 0) {
      i = j;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)paramOriginContentInfo.getDurationString());
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    localObject1 = (String)CollectionsKt.firstOrNull(paramOriginContentInfo.getImageUrlArray());
    if (localObject1 != null)
    {
      localObject1 = StringKt.a((String)localObject1, paramOriginContentInfo.getDefaultImageUrl());
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = paramOriginContentInfo.getDefaultImageUrl();
    }
    String str = StringKt.a(paramOriginContentInfo.getTitle(), paramOriginContentInfo.getDefaultTitle());
    paramOriginContentInfo = StringKt.a(paramOriginContentInfo.getSummary(), paramOriginContentInfo.getDefaultSummary());
    Object localObject2 = com.tencent.tkd.topicsdk.framework.bridge.ImageLoader.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    ((com.tencent.tkd.topicsdk.framework.bridge.ImageLoader)localObject2).a(localContext).a(this.jdField_a_of_type_AndroidWidgetImageView).a((String)localObject1);
    localObject1 = this.b;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("@ ");
    ((StringBuilder)localObject2).append(str);
    ((TextView)localObject1).setText((CharSequence)((StringBuilder)localObject2).toString());
    this.c.setText((CharSequence)paramOriginContentInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.OriginContentLayout
 * JD-Core Version:    0.7.0.1
 */