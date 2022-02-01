package com.tencent.tkd.weibo.tweetTopic.recentTopic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
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
import com.tencent.tkd.weibo.R.drawable;
import com.tencent.tkd.weibo.R.id;
import com.tencent.tkd.weibo.R.layout;
import com.tencent.tkd.weibo.UiComponentSdk;
import com.tencent.tkd.weibo.UiComponentSdk.Companion;
import com.tencent.tkd.weibo.UiComponentSdkKt;
import com.tencent.tkd.weibo.bean.TweetTopicItem;
import com.tencent.tkd.weibo.framework.TLog;
import com.tencent.tkd.weibo.framework.color.IComponentColorStrategy;
import com.tencent.tkd.weibo.utils.DisplayUtils;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/tweetTopic/recentTopic/RecentTopicLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "maxItemCount", "", "getMaxItemCount", "()I", "setMaxItemCount", "(I)V", "onItemClickListener", "Lkotlin/Function1;", "Lcom/tencent/tkd/weibo/bean/TweetTopicItem;", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "recentJoinedTopicContainer", "Landroid/widget/LinearLayout;", "recentJoinedTopicView", "Landroid/view/View;", "style", "getStyle", "setStyle", "topicItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTopicItems", "()Ljava/util/ArrayList;", "uiHandler", "Landroid/os/Handler;", "viewDisappearRunnable", "Ljava/lang/Runnable;", "viewDisappearTime", "", "getViewDisappearTime", "()J", "setViewDisappearTime", "(J)V", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "initItemLayoutStyle", "itemLayout", "startTimingToDisappear", "updateTweetItems", "tweetItems", "", "Companion", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class RecentTopicLayout
  extends RelativeLayout
{
  public static final RecentTopicLayout.Companion a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private final Runnable jdField_a_of_type_JavaLangRunnable;
  @NotNull
  private final ArrayList<TweetTopicItem> jdField_a_of_type_JavaUtilArrayList;
  @Nullable
  private Function1<? super TweetTopicItem, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  private int b;
  
  static
  {
    jdField_a_of_type_ComTencentTkdWeiboTweetTopicRecentTopicRecentTopicLayout$Companion = new RecentTopicLayout.Companion(null);
  }
  
  public RecentTopicLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.e, (ViewGroup)this, true);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(cont…joined_topic, this, true)");
    this.jdField_a_of_type_AndroidViewView = paramContext;
    paramContext = findViewById(R.id.i);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.ll_recent_joined_topic)");
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRunnable = ((Runnable)new RecentTopicLayout.viewDisappearRunnable.1(this));
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.b = 5;
    this.jdField_a_of_type_Long = -1L;
  }
  
  private final void a(View paramView)
  {
    DisplayUtils localDisplayUtils;
    Context localContext;
    int i;
    if (this.jdField_a_of_type_Int == 2)
    {
      if (!UiComponentSdk.a.a().a()) {
        paramView.setBackgroundResource(R.drawable.d);
      }
      for (;;)
      {
        localDisplayUtils = DisplayUtils.a;
        localContext = getContext();
        Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
        i = localDisplayUtils.a(localContext, 7.0F);
        localDisplayUtils = DisplayUtils.a;
        localContext = getContext();
        Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
        paramView.setPadding(0, i, 0, localDisplayUtils.a(localContext, 7.0F));
        return;
        paramView.setBackgroundResource(R.drawable.b);
      }
    }
    if (!UiComponentSdk.a.a().a()) {
      paramView.setBackgroundResource(R.drawable.c);
    }
    for (;;)
    {
      localDisplayUtils = DisplayUtils.a;
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      i = localDisplayUtils.a(localContext, 4.0F);
      localDisplayUtils = DisplayUtils.a;
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      paramView.setPadding(0, i, 0, localDisplayUtils.a(localContext, 4.0F));
      return;
      paramView.setBackgroundResource(R.drawable.jdField_a_of_type_Int);
    }
  }
  
  @Nullable
  public final Function1<TweetTopicItem, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
  }
  
  public final void a()
  {
    TLog.a.a("RecentJoinedTopicLayout", "RecentJoinedTopicLayout startTimingToDisappear. viewDisappearTime = " + this.jdField_a_of_type_Long);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_Long >= 0L) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Long);
    }
  }
  
  public final void a(@NotNull List<TweetTopicItem> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "tweetItems");
    if (paramList.isEmpty()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int i;
    label49:
    label76:
    Object localObject;
    View localView;
    TextView localTextView;
    if (paramList.size() > this.b)
    {
      i = this.b;
      this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)paramList.subList(0, i));
      paramList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (paramList.hasNext())
      {
        localObject = (TweetTopicItem)paramList.next();
        localView = LayoutInflater.from(getContext()).inflate(R.layout.c, (ViewGroup)this, false);
        Intrinsics.checkExpressionValueIsNotNull(localView, "itemLayout");
        a(localView);
        localTextView = (TextView)localView.findViewById(R.id.n);
        localTextView.setText((CharSequence)((TweetTopicItem)localObject).c());
        localTextView.setTypeface(Typeface.defaultFromStyle(1));
        if (this.jdField_a_of_type_Int != 2) {
          break label292;
        }
      }
    }
    label292:
    for (float f = 16.0F;; f = 12.0F)
    {
      localTextView.setTextSize(f);
      Context localContext = localTextView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      localTextView.setTextColor(localContext.getResources().getColor(UiComponentSdkKt.a().e()));
      localView.setOnClickListener((View.OnClickListener)new RecentTopicLayout.updateTweetItems.2(this, (TweetTopicItem)localObject));
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).setMargins(8, 0, 8, 0);
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      break label76;
      break;
      i = paramList.size();
      break label49;
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
  
  public final void setViewDisappearTime(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.recentTopic.RecentTopicLayout
 * JD-Core Version:    0.7.0.1
 */