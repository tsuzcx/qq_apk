package com.tencent.tkd.topicsdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.bean.AddToTopicConfig;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/AddToTopicLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "selectedTopic", "getSelectedTopic", "()Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "setSelectedTopic", "(Lcom/tencent/tkd/topicsdk/bean/TopicInfo;)V", "topicTextView", "Landroid/widget/TextView;", "initFromConfig", "", "addToTopicConfig", "Lcom/tencent/tkd/topicsdk/bean/AddToTopicConfig;", "updateTextView", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class AddToTopicLayout
  extends LinearLayout
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @Nullable
  private TopicInfo jdField_a_of_type_ComTencentTkdTopicsdkBeanTopicInfo;
  
  public AddToTopicLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(R.layout.x, (ViewGroup)this, true);
    paramContext = findViewById(R.id.bs);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tvTopic)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext);
  }
  
  private final void a(TopicInfo paramTopicInfo)
  {
    if (paramTopicInfo == null)
    {
      paramTopicInfo = this.jdField_a_of_type_AndroidWidgetTextView;
      Context localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      paramTopicInfo.setText((CharSequence)localContext.getResources().getString(R.string.ad));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)paramTopicInfo.getTitle());
  }
  
  @Nullable
  public final TopicInfo a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkBeanTopicInfo;
  }
  
  public final void a(@NotNull AddToTopicConfig paramAddToTopicConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramAddToTopicConfig, "addToTopicConfig");
    TopicInfo localTopicInfo = new TopicInfo(0L, null, null, null, false, 0L, 0, 127, null);
    localTopicInfo.setTopicId(paramAddToTopicConfig.getSelectedTopicId());
    localTopicInfo.setTitle(paramAddToTopicConfig.getSelectedTopicName());
    setSelectedTopic(localTopicInfo);
  }
  
  public final void setSelectedTopic(@Nullable TopicInfo paramTopicInfo)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanTopicInfo = paramTopicInfo;
    a(paramTopicInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.AddToTopicLayout
 * JD-Core Version:    0.7.0.1
 */