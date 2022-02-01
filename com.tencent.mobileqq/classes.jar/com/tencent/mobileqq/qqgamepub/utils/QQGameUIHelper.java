package com.tencent.mobileqq.qqgamepub.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.view.GameSessionView;
import com.tencent.mobileqq.qqgamepub.web.view.GameContentView;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.supportui.views.recyclerview.LinearLayoutManager;
import mqq.app.MobileQQ;

public class QQGameUIHelper
{
  public static View a;
  
  public static int a(HippyListView paramHippyListView)
  {
    paramHippyListView = (LinearLayoutManager)paramHippyListView.getLayoutManager();
    int i = paramHippyListView.findFirstVisibleItemPosition();
    paramHippyListView = paramHippyListView.findViewByPosition(i);
    if (paramHippyListView != null) {
      return i * paramHippyListView.getHeight() - paramHippyListView.getTop();
    }
    return 0;
  }
  
  public static Pair<TextView, RelativeLayout.LayoutParams> a(QQGameMsgInfo paramQQGameMsgInfo, Context paramContext)
  {
    TextView localTextView = new TextView(paramContext);
    localTextView.setTextColor(-1);
    localTextView.setTextSize(1, 10.0F);
    localTextView.setBackgroundColor(0);
    localTextView.setText(TimeFormatterUtils.a(paramContext, 3, paramQQGameMsgInfo.msgTime * 1000L));
    localTextView.setPadding(12, 0, 12, 0);
    localTextView.setId(2131447379);
    paramContext = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    paramQQGameMsgInfo = paramContext;
    if (paramContext == null) {
      paramQQGameMsgInfo = new RelativeLayout.LayoutParams(-2, UIUtils.a(15.0F, MobileQQ.sMobileQQ.getResources()));
    }
    localTextView.setGravity(17);
    paramQQGameMsgInfo.addRule(14);
    paramQQGameMsgInfo.addRule(10);
    localTextView.bringToFront();
    return new Pair(localTextView, paramQQGameMsgInfo);
  }
  
  public static void a()
  {
    a = null;
  }
  
  public static void a(long paramLong, GameSessionView paramGameSessionView, View paramView)
  {
    if (paramGameSessionView != null) {
      paramGameSessionView.postDelayed(new QQGameUIHelper.2(paramGameSessionView, paramView), paramLong);
    }
  }
  
  public static void a(long paramLong, GameContentView paramGameContentView, View paramView)
  {
    if (paramGameContentView != null) {
      paramGameContentView.postDelayed(new QQGameUIHelper.1(paramGameContentView, paramView), paramLong);
    }
  }
  
  public static void a(View paramView)
  {
    a = paramView;
  }
  
  public static void a(View paramView, LinearLayout paramLinearLayout, Context paramContext)
  {
    paramLinearLayout = new DisplayMetrics();
    ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(paramLinearLayout);
    int i = paramLinearLayout.heightPixels;
    paramView = (LinearLayout)paramView.findViewById(2131437612);
    int j = UIUtils.a(418.0F, MobileQQ.sMobileQQ.getResources());
    paramLinearLayout = paramView.getLayoutParams();
    paramLinearLayout.height = UIUtils.a(i - j, MobileQQ.sMobileQQ.getResources());
    paramView.setLayoutParams(paramLinearLayout);
    PreloadStaticApi.a();
    PreloadStaticApi.b("https://i.gtimg.cn/channel/imglib/202003/upload_0408e905d4fe21d5749b1902145804d9.png", false, 0);
    a(paramView, paramContext);
  }
  
  public static void a(LinearLayout paramLinearLayout, Context paramContext)
  {
    paramLinearLayout.removeAllViews();
    TextView localTextView = new TextView(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = UIUtils.a(7.0F, paramContext.getResources());
    localTextView.setText(HardCodeUtil.a(2131892943));
    localTextView.setTextColor(2130706432);
    paramContext = new ImageView(paramContext);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = MobileQQ.sMobileQQ.getResources().getDrawable(2130849062);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = MobileQQ.sMobileQQ.getResources().getDrawable(2130849062);
    paramContext.setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_refresh_small_gray@2x.png", (URLDrawable.URLDrawableOptions)localObject));
    paramContext.setVisibility(0);
    localObject = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setRepeatCount(-1);
    ((Animation)localObject).setDuration(1000L);
    paramContext.startAnimation((Animation)localObject);
    paramLinearLayout.addView(paramContext, new LinearLayout.LayoutParams(UIUtils.a(15.0F, MobileQQ.sMobileQQ.getResources()), UIUtils.a(15.0F, MobileQQ.sMobileQQ.getResources())));
    paramLinearLayout.addView(localTextView, localLayoutParams);
  }
  
  private static void b(View paramView, boolean paramBoolean)
  {
    for (paramView = paramView.getParent(); (paramView != null) && ((paramView instanceof ViewGroup)); paramView = paramView.getParent()) {
      ((ViewGroup)paramView).setClipChildren(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper
 * JD-Core Version:    0.7.0.1
 */