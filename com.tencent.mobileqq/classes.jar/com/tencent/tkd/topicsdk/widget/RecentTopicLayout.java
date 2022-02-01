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
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/RecentTopicLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onItemClickListener", "Lkotlin/Function1;", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "recentJoinedTopicContainer", "Lcom/tencent/tkd/topicsdk/widget/FlowLayout;", "style", "", "getStyle", "()I", "setStyle", "(I)V", "value", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleView", "Landroid/widget/TextView;", "viewDisappearTime", "", "getViewDisappearTime", "()J", "setViewDisappearTime", "(J)V", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "initItemLayoutStyle", "itemLayout", "Landroid/view/View;", "isNightMode", "initTopicTextView", "topicName", "startTimingToDisappear", "updateTweetItems", "tweetItems", "", "Companion", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public final class RecentTopicLayout
  extends RelativeLayout
{
  public static final RecentTopicLayout.Companion a = new RecentTopicLayout.Companion(null);
  private TextView b;
  private FlowLayout c;
  @NotNull
  private String d;
  private int e;
  @Nullable
  private Function1<? super TweetTopicItem, Unit> f;
  private long g;
  
  public RecentTopicLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(R.layout.c, (ViewGroup)this, true);
    paramContext = findViewById(R.id.k);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_title)");
    this.b = ((TextView)paramContext);
    this.b.setTypeface(Typeface.DEFAULT_BOLD);
    paramContext = findViewById(R.id.d);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.ll_recent_joined_topic)");
    this.c = ((FlowLayout)paramContext);
    this.d = "";
    this.e = 1;
    this.g = -1L;
  }
  
  private final void a(View paramView, String paramString, boolean paramBoolean)
  {
    TextView localTextView = (TextView)paramView.findViewById(R.id.j);
    CharSequence localCharSequence = (CharSequence)paramString;
    int i;
    if (localCharSequence.length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    paramView = localCharSequence;
    if (i != 0)
    {
      paramView = localCharSequence;
      if (paramString.charAt(0) == '#') {
        if (paramString != null)
        {
          paramView = paramString.substring(1);
          Intrinsics.checkExpressionValueIsNotNull(paramView, "(this as java.lang.String).substring(startIndex)");
          paramView = (CharSequence)paramView;
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
    }
    localTextView.setText(paramView);
    localTextView.setTypeface(Typeface.defaultFromStyle(1));
    float f1;
    if (this.e == 2) {
      f1 = 16.0F;
    } else {
      f1 = 12.0F;
    }
    localTextView.setTextSize(f1);
    if (!paramBoolean)
    {
      localTextView.setTextColor(localTextView.getResources().getColor(R.color.c));
      return;
    }
    localTextView.setTextColor(localTextView.getResources().getColor(R.color.b));
  }
  
  private final void a(View paramView, boolean paramBoolean)
  {
    if (this.e == 2)
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
      paramView.setBackgroundResource(R.drawable.a);
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
  
  public final void a()
  {
    Handler localHandler = new Handler(Looper.getMainLooper());
    Runnable localRunnable = (Runnable)new RecentTopicLayout.startTimingToDisappear.viewDisappearRunnable.1(this);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecentJoinedTopicLayout startTimingToDisappear. viewDisappearTime = ");
    localStringBuilder.append(this.g);
    Log.d("RecentJoinedTopicLayout", localStringBuilder.toString());
    setVisibility(0);
    localHandler.removeCallbacks(localRunnable);
    long l = this.g;
    if (l >= 0L) {
      localHandler.postDelayed(localRunnable, l);
    }
  }
  
  public final void a(@NotNull List<TweetTopicItem> paramList, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "tweetItems");
    if (paramList.isEmpty()) {
      return;
    }
    this.c.removeAllViews();
    paramList = paramList.iterator();
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
      this.c.addView(localView);
    }
  }
  
  public boolean dispatchTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "ev");
    if ((this.g >= 0L) && (paramMotionEvent.getAction() == 1)) {
      a();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  @Nullable
  public final Function1<TweetTopicItem, Unit> getOnItemClickListener()
  {
    return this.f;
  }
  
  public final int getStyle()
  {
    return this.e;
  }
  
  @NotNull
  public final String getTitle()
  {
    return this.d;
  }
  
  public final long getViewDisappearTime()
  {
    return this.g;
  }
  
  public final void setOnItemClickListener(@Nullable Function1<? super TweetTopicItem, Unit> paramFunction1)
  {
    this.f = paramFunction1;
  }
  
  public final void setStyle(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void setTitle(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.d = paramString;
    this.b.setText((CharSequence)paramString);
  }
  
  public final void setViewDisappearTime(long paramLong)
  {
    this.g = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.RecentTopicLayout
 * JD-Core Version:    0.7.0.1
 */