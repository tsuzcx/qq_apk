package com.tencent.mobileqq.gamecenter.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.onlinestatus.view.OnlineStatusController;
import com.tencent.mobileqq.onlinestatus.view.OnlineStatusController.PanelTouchListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class GameAioOnlineStatusPopUpWindow
  extends PopupWindow
  implements View.OnClickListener, OnlineStatusController.PanelTouchListener
{
  private Activity a;
  private OnlineStatusController b;
  private View c;
  private TextView d;
  private Animation e;
  private GameDetailInfo f;
  private Bundle g;
  private View.OnClickListener h;
  private View i;
  
  private GameAioOnlineStatusPopUpWindow(AppInterface paramAppInterface, Activity paramActivity, GameDetailInfo paramGameDetailInfo, View paramView, Bundle paramBundle, View.OnClickListener paramOnClickListener)
  {
    super(paramView, -1, -1);
    this.a = paramActivity;
    this.f = paramGameDetailInfo;
    this.g = paramBundle;
    this.h = paramOnClickListener;
  }
  
  public static GameAioOnlineStatusPopUpWindow a(AppInterface paramAppInterface, Activity paramActivity, GameDetailInfo paramGameDetailInfo, Bundle paramBundle, View.OnClickListener paramOnClickListener)
  {
    paramAppInterface = new GameAioOnlineStatusPopUpWindow(paramAppInterface, paramActivity, paramGameDetailInfo, LayoutInflater.from(paramActivity).inflate(2131624883, null), paramBundle, paramOnClickListener);
    paramAppInterface.a();
    return paramAppInterface;
  }
  
  private void a(float paramFloat)
  {
    Window localWindow = this.a.getWindow();
    if (localWindow != null)
    {
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.alpha = paramFloat;
      localWindow.setAttributes(localLayoutParams);
    }
  }
  
  private void a(View paramView)
  {
    Object localObject = this.g.getString("onlineText");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    TextView localTextView = (TextView)paramView.findViewById(2131435764);
    localTextView.setVisibility(0);
    localTextView.setText((CharSequence)localObject);
    localObject = null;
    int j = this.f.j;
    if (j != 1)
    {
      if (j == 2) {
        localObject = paramView.getResources().getDrawable(2130840482);
      }
    }
    else {
      localObject = paramView.getResources().getDrawable(2130837650);
    }
    if (localObject == null) {
      return;
    }
    j = BaseAIOUtils.b(28.0F, paramView.getResources());
    ((Drawable)localObject).setBounds(0, 0, j, j);
    paramView = localTextView.getCompoundDrawables();
    localTextView.setCompoundDrawablePadding(Utils.a(4.0F, MobileQQ.sMobileQQ.getResources()));
    localTextView.setCompoundDrawables((Drawable)localObject, paramView[1], paramView[2], paramView[3]);
  }
  
  private void a(TextView paramTextView)
  {
    paramTextView = paramTextView.getPaint();
    paramTextView.setStyle(Paint.Style.FILL_AND_STROKE);
    paramTextView.setStrokeWidth(1.0F);
  }
  
  private void b(View paramView)
  {
    ArrayList localArrayList1 = this.g.getStringArrayList("priorityIconList");
    ArrayList localArrayList2 = this.g.getStringArrayList("priorityDetailList");
    if ((localArrayList1 != null) && (localArrayList2 != null) && (localArrayList1.size() > 0))
    {
      if (localArrayList1.size() != localArrayList2.size()) {
        return;
      }
      View localView = paramView.findViewById(2131435752);
      LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131435755);
      int j = 0;
      localView.setVisibility(0);
      paramView = paramView.getContext();
      while ((j < localArrayList1.size()) && (j < 4))
      {
        localView = View.inflate(paramView, 2131624884, null);
        ((TextView)localView.findViewById(2131435753)).setText((CharSequence)localArrayList2.get(j));
        ((ImageView)localView.findViewById(2131435754)).setImageDrawable(URLDrawable.getDrawable((String)localArrayList1.get(j)));
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.leftMargin = BaseAIOUtils.b(13.0F, paramView.getResources());
        localLayoutParams.rightMargin = BaseAIOUtils.b(13.0F, paramView.getResources());
        localLinearLayout.addView(localView, localLayoutParams);
        j += 1;
      }
    }
  }
  
  protected void a()
  {
    View localView = getContentView();
    this.b = ((OnlineStatusController)localView.findViewById(2131431322));
    this.i = localView.findViewById(2131435751);
    this.d = ((TextView)localView.findViewById(2131435764));
    this.c = localView.findViewById(2131439574);
    Object localObject2 = (ImageView)localView.findViewById(2131435757);
    Object localObject1 = (TextView)localView.findViewById(2131435784);
    TextView localTextView = (TextView)localView.findViewById(2131435756);
    ImageView localImageView = (ImageView)localView.findViewById(2131435750);
    RoundRelativeLayout localRoundRelativeLayout = (RoundRelativeLayout)localView.findViewById(2131435758);
    if (!TextUtils.isEmpty(this.f.d))
    {
      ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(this.f.d));
      int j = BaseAIOUtils.b(36.0F, localView.getResources());
      localObject2 = localRoundRelativeLayout.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = j;
      ((ViewGroup.LayoutParams)localObject2).height = j;
      localRoundRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localRoundRelativeLayout.b = (j / 2);
    }
    if (!TextUtils.isEmpty(this.f.e)) {
      ((TextView)localObject1).setText(this.f.e);
    }
    if (!TextUtils.isEmpty(this.f.l)) {
      localImageView.setImageDrawable(URLDrawable.getDrawable(this.f.l));
    }
    localObject1 = this.g.getString("startBtnText");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localTextView.setText((CharSequence)localObject1);
      this.i.setOnClickListener(this.h);
    }
    localView.findViewById(2131447803).setOnClickListener(this);
    localView.findViewById(2131437320).setOnClickListener(this);
    localView.setOnClickListener(this);
    this.b.setDisableMinScrollY(true);
    this.b.setAtPanelTouchListener(this);
    a(localView);
    b(localView);
    b();
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.f.c, "1", "145", "920", "92005", "208986", "", "", "8", String.valueOf(this.f.j));
  }
  
  public void a(int paramInt)
  {
    dismiss();
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    boolean bool = QQTheme.isNowThemeIsNight();
    Object localObject = this.c;
    int j;
    if (bool) {
      j = 2130840481;
    } else {
      j = 2130840479;
    }
    ((View)localObject).setBackgroundResource(j);
    TextView localTextView = this.d;
    if (bool) {
      localObject = "#FFFFFF";
    } else {
      localObject = "#03081A";
    }
    localTextView.setTextColor(Color.parseColor((String)localObject));
    a(this.d);
  }
  
  public void c()
  {
    this.b.scrollTo(0, 0);
    Animation localAnimation = this.e;
    if ((localAnimation != null) && (!localAnimation.hasEnded())) {
      return;
    }
    if (this.e == null) {
      this.e = AnimationUtils.loadAnimation(this.a, 2130772014);
    }
    this.b.startAnimation(this.e);
  }
  
  public void d() {}
  
  public void dismiss()
  {
    try
    {
      if (isShowing())
      {
        super.dismiss();
        a(1.0F);
      }
      this.i.setOnClickListener(null);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dismiss e:");
      localStringBuilder.append(localThrowable);
      QLog.e("GameAioOnlineStatusPopUpWindow", 1, localStringBuilder.toString());
    }
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if ((j == 2131447803) || (j == 2131431322))
    {
      dismiss();
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.f.c, "1", "145", "920", "92005", "208987", "2", "", "20", String.valueOf(this.f.j));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
    a(0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.ui.GameAioOnlineStatusPopUpWindow
 * JD-Core Version:    0.7.0.1
 */