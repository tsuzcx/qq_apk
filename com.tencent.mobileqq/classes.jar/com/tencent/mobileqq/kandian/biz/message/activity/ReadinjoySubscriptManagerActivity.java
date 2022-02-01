package com.tencent.mobileqq.kandian.biz.message.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.biz.pubaccount.AccountDetail.view.ReadInJoyNewFeedsTopGestureLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.kandian.biz.follow.PublicAccountUnfollowTask;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Comparator;
import java.util.List;
import mqq.os.MqqHandler;

public class ReadinjoySubscriptManagerActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, DecodeTaskCompletionListener, SwipListView.RightIconMenuListener
{
  private boolean a = false;
  private TextView b = null;
  private SwipListView c = null;
  private View d = null;
  private View e = null;
  private ReadinjoySubscriptManagerActivity.SubscribeAdapter f = null;
  private RecentFaceDecoder g = null;
  private TopGestureLayout h = null;
  private Comparator<ReadinjoySubscriptManagerActivity.SubscribeFeedData> i = new ReadinjoySubscriptManagerActivity.1(this);
  
  private void a(String paramString)
  {
    Context localContext = getApplicationContext();
    new PublicAccountUnfollowTask(this.app, paramString, localContext, new ReadinjoySubscriptManagerActivity.3(this, localContext)).a();
  }
  
  private void a(List<ReadinjoySubscriptManagerActivity.SubscribeFeedData> paramList)
  {
    if (paramList != null)
    {
      this.f.a(paramList);
      this.c.hideCurShowingRightView();
    }
    if (this.f.getCount() == 0)
    {
      this.b.setVisibility(8);
      this.d.setVisibility(0);
      return;
    }
    this.b.setVisibility(0);
    this.d.setVisibility(8);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.h == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.h = ((TopGestureLayout)localObject);
      }
    }
    Object localObject = this.h;
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
    }
  }
  
  private void b()
  {
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      localObject = new ReadInJoyNewFeedsTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(((ReadInJoyNewFeedsTopGestureLayout)localObject).a());
    }
    setTitle(HardCodeUtil.a(2131910268));
    setLeftViewName(2131887440);
    this.b = ((TextView)getRightTextView());
    this.b.setVisibility(8);
    this.b.setOnClickListener(this);
    this.b.setText(2131915371);
    this.d = findViewById(2131432530);
    ((TextView)findViewById(2131447914)).setText(HardCodeUtil.a(2131910336));
    this.f = new ReadinjoySubscriptManagerActivity.SubscribeAdapter(this, null);
    this.c = ((SwipListView)findViewById(2131446576));
    Object localObject = new TextView(this);
    ((TextView)localObject).setHeight(AIOUtils.b(20.0F, getResources()));
    ((TextView)localObject).setBackgroundResource(2131168376);
    ((TextView)localObject).setClickable(false);
    ((TextView)localObject).setHintTextColor(getResources().getColor(2131168376));
    this.c.addHeaderView((View)localObject, null, false);
    this.c.setDragEnable(this.a);
    this.c.setAdapter(this.f);
    this.c.setRightIconMenuListener(this);
    this.c.setOnItemClickListener(this.f);
    this.g = new RecentFaceDecoder(this.app, this, false);
    this.e = findViewById(2131439328);
    if (ThemeUtil.isInNightMode(this.app)) {
      this.e.setVisibility(0);
    }
  }
  
  private void c()
  {
    ThreadManager.getSubThreadHandler().post(new ReadinjoySubscriptManagerActivity.2(this));
  }
  
  public void a()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (ThemeUtil.isInNightMode(this.app))
      {
        if ((!SystemUtil.d()) && (!SystemUtil.g()))
        {
          this.mSystemBarComp.setStatusBarColor(-7829368);
        }
        else
        {
          this.mSystemBarComp.setStatusBarColor(-7829368);
          this.mSystemBarComp.setStatusBarDarkMode(true);
        }
      }
      else if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.d()) && (!SystemUtil.g()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!SystemUtil.g())
      {
        this.mSystemBarComp.setStatusBarColor(-2368549);
      }
      else
      {
        this.mSystemBarComp.setStatusBarColor(-1);
        this.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
    this.leftView.setTextColor(-14408926);
    this.leftView.setTextColor(-14408926);
    this.leftView.setBackgroundResource(2130851519);
    if (this.centerView != null) {
      this.centerView.setTextColor(-16777216);
    }
    TextView localTextView = this.b;
    if (localTextView != null) {
      localTextView.setTextColor(-16777216);
    }
    this.vg.setBackgroundColor(-1);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    setContentView(2131626338);
    b();
    a();
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    RecentFaceDecoder localRecentFaceDecoder = this.g;
    if (localRecentFaceDecoder != null)
    {
      localRecentFaceDecoder.b();
      this.g = null;
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    c();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131436211) {
      return;
    }
    this.a ^= true;
    this.c.setDragEnable(this.a);
    paramView = this.b;
    int j;
    if (this.a) {
      j = 2131915301;
    } else {
      j = 2131915371;
    }
    paramView.setText(j);
    this.f.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
    paramInt2 = ((SwipListView)localObject).getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      localObject = this.c.getChildAt(paramInt1);
      if ((((View)localObject).getTag() instanceof ReadinjoySubscriptManagerActivity.SubscribeHolder))
      {
        localObject = (ReadinjoySubscriptManagerActivity.SubscribeHolder)((View)localObject).getTag();
        if (TextUtils.equals(ReadinjoySubscriptManagerActivity.SubscribeHolder.a((ReadinjoySubscriptManagerActivity.SubscribeHolder)localObject), paramString))
        {
          new Handler(Looper.getMainLooper()).post(new ReadinjoySubscriptManagerActivity.4(this, (ReadinjoySubscriptManagerActivity.SubscribeHolder)localObject, paramBitmap));
          return;
        }
      }
      paramInt1 += 1;
    }
  }
  
  public void onRightIconMenuHide(View paramView)
  {
    a(true);
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.activity.ReadinjoySubscriptManagerActivity
 * JD-Core Version:    0.7.0.1
 */