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
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.bean.globalconfig.AddToTopicConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/AddToTopicLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "selectedTopic", "getSelectedTopic", "()Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "setSelectedTopic", "(Lcom/tencent/tkd/topicsdk/bean/TopicInfo;)V", "topicTextView", "Landroid/widget/TextView;", "initFromConfig", "", "addToTopicConfig", "Lcom/tencent/tkd/topicsdk/bean/globalconfig/AddToTopicConfig;", "updateTextView", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class AddToTopicLayout
  extends LinearLayout
{
  @Nullable
  private TopicInfo a;
  private TextView b;
  
  public AddToTopicLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(R.layout.r, (ViewGroup)this, true);
    paramContext = findViewById(R.id.ar);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tvTopic)");
    this.b = ((TextView)paramContext);
  }
  
  private final void a(TopicInfo paramTopicInfo)
  {
    if (paramTopicInfo == null)
    {
      paramTopicInfo = this.b;
      Context localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      paramTopicInfo.setText((CharSequence)localContext.getResources().getString(R.string.O));
      return;
    }
    this.b.setText((CharSequence)paramTopicInfo.getTitle());
  }
  
  public final void a(@NotNull AddToTopicConfig paramAddToTopicConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramAddToTopicConfig, "addToTopicConfig");
    TopicInfo localTopicInfo = new TopicInfo(0L, null, null, null, false, 0L, 0, 127, null);
    localTopicInfo.setTopicId(paramAddToTopicConfig.getSelectedTopicId());
    localTopicInfo.setTitle(paramAddToTopicConfig.getSelectedTopicName());
    setSelectedTopic(localTopicInfo);
  }
  
  @Nullable
  public final TopicInfo getSelectedTopic()
  {
    return this.a;
  }
  
  public final void setSelectedTopic(@Nullable TopicInfo paramTopicInfo)
  {
    this.a = paramTopicInfo;
    a(paramTopicInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.AddToTopicLayout
 * JD-Core Version:    0.7.0.1
 */