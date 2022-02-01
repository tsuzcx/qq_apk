package com.tencent.tkd.topicsdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/RecentTopicLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "maxItemCount", "", "getMaxItemCount", "()I", "setMaxItemCount", "(I)V", "onItemClickListener", "Lkotlin/Function1;", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "recentJoinedTopicContainer", "Landroid/widget/LinearLayout;", "style", "getStyle", "setStyle", "value", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleView", "Landroid/widget/TextView;", "topicItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "uiHandler", "Landroid/os/Handler;", "viewDisappearRunnable", "Ljava/lang/Runnable;", "viewDisappearTime", "", "getViewDisappearTime", "()J", "setViewDisappearTime", "(J)V", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "initItemLayoutStyle", "itemLayout", "Landroid/view/View;", "isNightMode", "initTopicTextView", "topicName", "startTimingToDisappear", "updateTweetItems", "tweetItems", "", "Companion", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public final class RecentTopicLayout
  extends RelativeLayout
{
  public static final RecentTopicLayout.Companion a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final Runnable jdField_a_of_type_JavaLangRunnable;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  private final ArrayList<TweetTopicItem> jdField_a_of_type_JavaUtilArrayList;
  @Nullable
  private Function1<? super TweetTopicItem, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  private int b;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkWidgetRecentTopicLayout$Companion = new RecentTopicLayout.Companion(null);
  }
  
  public RecentTopicLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(R.layout.c, (ViewGroup)this, true);
    paramContext = findViewById(R.id.i);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_title)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.DEFAULT_BOLD);
    paramContext = findViewById(R.id.c);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.ll_recent_joined_topic)");
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRunnable = ((Runnable)new RecentTopicLayout.viewDisappearRunnable.1(this));
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.b = 5;
    this.jdField_a_of_type_Long = -1L;
  }
  
  private final void a(View paramView, String paramString, boolean paramBoolean)
  {
    paramView = (TextView)paramView.findViewById(R.id.h);
    paramView.setText((CharSequence)paramString);
    paramView.setTypeface(Typeface.defaultFromStyle(1));
    float f;
    if (this.jdField_a_of_type_Int == 2) {
      f = 16.0F;
    } else {
      f = 12.0F;
    }
    paramView.setTextSize(f);
    if (!paramBoolean)
    {
      paramView.setTextColor(paramView.getResources().getColor(R.color.c));
      return;
    }
    paramView.setTextColor(paramView.getResources().getColor(R.color.b));
  }
  
  private final void a(View paramView, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      if (!paramBoolean) {
        paramView.setBackgroundResource(R.drawable.d);
      } else {
        paramView.setBackgroundResource(R.drawable.b);
      }
      localDisplayUtils = DisplayUtils.a;
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      i = localDisplayUtils.a(localContext, 7.0F);
      localDisplayUtils = DisplayUtils.a;
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      paramView.setPadding(0, i, 0, localDisplayUtils.a(localContext, 7.0F));
      return;
    }
    if (!paramBoolean) {
      paramView.setBackgroundResource(R.drawable.c);
    } else {
      paramView.setBackgroundResource(R.drawable.jdField_a_of_type_Int);
    }
    DisplayUtils localDisplayUtils = DisplayUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i = localDisplayUtils.a(localContext, 4.0F);
    localDisplayUtils = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    paramView.setPadding(0, i, 0, localDisplayUtils.a(localContext, 4.0F));
  }
  
  @Nullable
  public final Function1<TweetTopicItem, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
  }
  
  public final void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecentJoinedTopicLayout startTimingToDisappear. viewDisappearTime = ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    Log.d("RecentJoinedTopicLayout", localStringBuilder.toString());
    setVisibility(0);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    long l = this.jdField_a_of_type_Long;
    if (l >= 0L) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, l);
    }
  }
  
  public final void a(@NotNull List<TweetTopicItem> paramList, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "tweetItems");
    if (paramList.isEmpty()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int j = paramList.size();
    int i = this.b;
    if (j <= i) {
      i = paramList.size();
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)paramList.subList(0, i));
    paramList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (TweetTopicItem)paramList.next();
      View localView = LayoutInflater.from(getContext()).inflate(R.layout.b, (ViewGroup)this, false);
      Intrinsics.checkExpressionValueIsNotNull(localView, "itemLayout");
      a(localView, paramBoolean);
      a(localView, ((TweetTopicItem)localObject).c(), paramBoolean);
      localView.setOnClickListener((View.OnClickListener)new RecentTopicLayout.updateTweetItems.1(this, (TweetTopicItem)localObject));
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(8, 0, 8, 0);
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
    }
  }
  
  public boolean dispatchTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "ev");
    if ((this.jdField_a_of_type_Long >= 0L) && (paramMotionEvent.getAction() == 1)) {
      a();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public final void setMaxItemCount(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void setOnItemClickListener(@Nullable Function1<? super TweetTopicItem, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void setStyle(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void setTitle(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)paramString);
  }
  
  public final void setViewDisappearTime(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.RecentTopicLayout
 * JD-Core Version:    0.7.0.1
 */