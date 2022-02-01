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
    LayoutInflater.from(paramContext).inflate(R.layout.F, (ViewGroup)this, true);
    paramContext = findViewById(R.id.ag);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.image)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext);
    paramContext = findViewById(R.id.bB);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_duration)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    paramContext = findViewById(R.id.bO);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_title)");
    this.b = ((TextView)paramContext);
    paramContext = findViewById(R.id.bM);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_summary)");
    this.c = ((TextView)paramContext);
    setBackgroundColor(Color.parseColor("#F5F6FA"));
    setRoundLayoutRadius(16.0F);
  }
  
  public final void setOriginContentInfo(@NotNull OriginContentInfo paramOriginContentInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramOriginContentInfo, "info");
    ((View)this).setVisibility(0);
    Object localObject = (View)this.jdField_a_of_type_AndroidWidgetTextView;
    int i;
    if (paramOriginContentInfo.getType() == 2)
    {
      i = 1;
      if (i == 0) {
        break label222;
      }
      i = 0;
      label38:
      ((View)localObject).setVisibility(i);
      if (((CharSequence)paramOriginContentInfo.getDurationString()).length() <= 0) {
        break label228;
      }
      i = 1;
      label60:
      if (i == 0) {
        break label233;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)paramOriginContentInfo.getDurationString());
      label86:
      localObject = (String)CollectionsKt.firstOrNull(paramOriginContentInfo.getImageUrlArray());
      if (localObject == null) {
        break label245;
      }
      localObject = StringKt.a((String)localObject, paramOriginContentInfo.getDefaultImageUrl());
      if (localObject == null) {
        break label245;
      }
    }
    for (;;)
    {
      String str = StringKt.a(paramOriginContentInfo.getTitle(), paramOriginContentInfo.getDefaultTitle());
      paramOriginContentInfo = StringKt.a(paramOriginContentInfo.getSummary(), paramOriginContentInfo.getDefaultSummary());
      com.tencent.tkd.topicsdk.framework.bridge.ImageLoader localImageLoader = com.tencent.tkd.topicsdk.framework.bridge.ImageLoader.a;
      Context localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      localImageLoader.a(localContext).a(this.jdField_a_of_type_AndroidWidgetImageView).a((String)localObject);
      this.b.setText((CharSequence)("@ " + str));
      this.c.setText((CharSequence)paramOriginContentInfo);
      return;
      i = 0;
      break;
      label222:
      i = 8;
      break label38;
      label228:
      i = 0;
      break label60;
      label233:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label86;
      label245:
      localObject = paramOriginContentInfo.getDefaultImageUrl();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.OriginContentLayout
 * JD-Core Version:    0.7.0.1
 */