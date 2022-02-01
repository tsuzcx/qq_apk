package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.view.widget.CircleCountdownView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.InterruptedWeishiAd;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class VideoFeedsInterruptedAdManager
{
  public static final String a = "VideoFeedsInterruptedAdManager";
  private Activity b;
  private VideoInfo.InterruptedWeishiAd c;
  private SparseBooleanArray d;
  private ShortVideoItemHolder e;
  private VideoFeedsPlayManager.VideoStatusListener f;
  private VideoFeedsPlayManager g;
  private QQAppInterface h;
  private VideoFeedsAdapter i;
  private boolean j = false;
  private boolean k;
  private String l;
  private int m = 0;
  private int n = 0;
  private int o = 0;
  private boolean p;
  private boolean q;
  private boolean r;
  private int s = -1;
  private boolean t = false;
  private boolean u = false;
  
  public VideoFeedsInterruptedAdManager(Activity paramActivity, QQAppInterface paramQQAppInterface, VideoFeedsPlayManager.VideoStatusListener paramVideoStatusListener, VideoFeedsPlayManager paramVideoFeedsPlayManager, VideoFeedsAdapter paramVideoFeedsAdapter, boolean paramBoolean)
  {
    this.b = paramActivity;
    this.h = paramQQAppInterface;
    this.f = paramVideoStatusListener;
    this.g = paramVideoFeedsPlayManager;
    this.i = paramVideoFeedsAdapter;
    this.k = false;
    this.p = false;
    this.q = false;
    this.r = false;
    this.j = paramBoolean;
  }
  
  private boolean f()
  {
    Object localObject = this.c;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (localObject != null)
    {
      localObject = this.e;
      if (localObject == null) {
        return false;
      }
      int i1 = ((ShortVideoItemHolder)localObject).Z;
      int i2 = this.c.f;
      if (i2 != 0)
      {
        if (i2 != 1) {
          return false;
        }
        bool1 = bool2;
        if (!TextUtils.isEmpty(this.c.h))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.c.g))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.c.i))
            {
              bool1 = bool2;
              if (!TextUtils.isEmpty(this.c.j))
              {
                bool1 = bool2;
                if (this.c.k != null)
                {
                  bool1 = bool2;
                  if (this.d.get(i1)) {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
        return bool1;
      }
      bool1 = bool3;
      if (!TextUtils.isEmpty(this.c.e))
      {
        localObject = this.d;
        bool1 = bool3;
        if (localObject != null)
        {
          bool1 = bool3;
          if (((SparseBooleanArray)localObject).get(i1))
          {
            bool1 = bool3;
            if (!this.u) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void g()
  {
    this.u = true;
    int i1 = this.c.f;
    if (i1 != 0)
    {
      if (i1 != 1) {
        return;
      }
      h();
      i();
      this.e.c.setVisibility(0);
      return;
    }
    Object localObject = this.g;
    if (localObject != null) {
      ((VideoFeedsPlayManager)localObject).m();
    }
    localObject = Boolean.valueOf(ReadInJoyHelper.Y(ReadInJoyUtils.b()));
    WebViewTitleStyle localWebViewTitleStyle = new WebViewTitleStyle();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("titleStyle", localWebViewTitleStyle);
    localBundle.putBoolean("public_account_finish_animation_out_to_bottom", true);
    localBundle.putBoolean("KEY_SLIDE_RIGHT_BACK_ENABLE", false);
    localWebViewTitleStyle.b = -16777216;
    localWebViewTitleStyle.c = -1;
    localWebViewTitleStyle.d = -16777216;
    localWebViewTitleStyle.e = -16777216;
    localBundle.putParcelable("titleStyle", localWebViewTitleStyle);
    if (((Boolean)localObject).booleanValue()) {
      ViolaAccessHelper.a(this.b, HardCodeUtil.a(2131913453), "https://kandian.qq.com/viola/bundle_weishiLeadTo.js?v_bid=3256", null, new VideoFeedsInterruptedAdManager.1(this, localBundle));
    } else {
      RIJJumpUtils.a(this.b, this.c.e, localBundle);
    }
    if (!((Boolean)localObject).booleanValue()) {
      this.b.overridePendingTransition(2130772014, 0);
    }
    if (this.j) {
      try
      {
        i1 = this.b.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        localObject = this.e.az.c;
        PublicAccountReportUtils.a(null, null, "0X800933E", "0X800933E", 0, 0, String.valueOf(i1), "", "", VideoReporter.a(null, null, ((VideoInfo)localObject).b, ((VideoInfo)localObject).l, null), false);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void h()
  {
    if ((this.e.c == null) && ((this.e.itemView instanceof ViewGroup)))
    {
      View localView = View.inflate(this.b, 2131626388, (ViewGroup)this.e.itemView);
      this.e.c = localView.findViewById(2131434506);
      this.e.d = localView.findViewById(2131434489);
      this.e.e = ((ImageView)localView.findViewById(2131434498));
      this.e.f = ((TextView)localView.findViewById(2131434507));
      this.e.g = ((TextView)localView.findViewById(2131434510));
      this.e.h = ((TextView)localView.findViewById(2131434496));
      this.e.i = ((CircleCountdownView)localView.findViewById(2131434508));
    }
  }
  
  private void i()
  {
    Object localObject = this.e;
    if ((localObject != null) && (((ShortVideoItemHolder)localObject).h != null))
    {
      Resources localResources = this.b.getResources();
      if (this.e.az != null)
      {
        if (!PackageUtil.a(this.b, this.c.k.c))
        {
          this.e.h.setText(this.c.i);
          localObject = localResources.getDrawable(2130844162);
        }
        else
        {
          this.e.h.setText(this.c.j);
          localObject = localResources.getDrawable(2130844165);
        }
        int i1 = AIOUtils.b(12.0F, localResources);
        ((Drawable)localObject).setBounds(0, 0, i1, i1);
        this.e.h.setCompoundDrawables((Drawable)localObject, null, null, null);
        this.e.h.setOnClickListener(new VideoFeedsInterruptedAdManager.2(this));
        this.e.g.setOnClickListener(new VideoFeedsInterruptedAdManager.3(this));
        this.e.f.setText(this.c.g);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
        localObject = URLDrawable.getDrawable(this.c.h, (URLDrawable.URLDrawableOptions)localObject);
        this.e.e.setImageDrawable((Drawable)localObject);
        this.e.c.setOnClickListener(null);
        localObject = new JSONObject();
      }
    }
    try
    {
      ((JSONObject)localObject).put("uin", this.h.getCurrentAccountUin());
      label271:
      PublicAccountReportUtils.a(null, null, "0X8009BF0", "0X8009BF0", 0, 0, "", "", "", VideoReporter.a(null, null, this.e.az.c.b, this.e.az.c.l, (JSONObject)localObject), false);
      return;
    }
    catch (Exception localException)
    {
      break label271;
    }
  }
  
  private boolean j()
  {
    Object localObject2;
    if (!this.k)
    {
      this.k = true;
      this.l = ReadInJoyHelper.ad(this.h);
      localObject1 = ReadInJoyHelper.af(this.h);
      boolean bool = ReadInJoyHelper.ae(this.h);
      if (QLog.isColorLevel())
      {
        localObject2 = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkIsNeedShowInterruptedAd() 后台下发原始配置：");
        localStringBuilder.append(this.l);
        localStringBuilder.append("\n本地副本配置：");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("\n本地副本配置是否为当天：");
        localStringBuilder.append(bool);
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      if ((bool) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
        this.l = ((String)localObject1);
      }
      if (TextUtils.isEmpty(this.l)) {}
    }
    try
    {
      localObject2 = new JSONObject(this.l);
      if (!this.j) {
        break label420;
      }
      localObject1 = "weishi";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i1;
        int i2;
        continue;
        String str = "default";
      }
    }
    Object localObject1 = ((JSONObject)localObject2).getJSONObject((String)localObject1);
    if (localObject1 == null)
    {
      this.l = null;
      return false;
    }
    i1 = ((JSONObject)localObject1).getInt("display_count_each_entrance");
    this.m = i1;
    this.o = i1;
    this.n = ((JSONObject)localObject1).getInt("display_count_each_day");
    break label241;
    this.l = null;
    return false;
    label241:
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkIsNeedShowInterruptedAd() 初始剩余次数 mDisplayCountEachEntrance = ");
      ((StringBuilder)localObject2).append(this.m);
      ((StringBuilder)localObject2).append(", mDisplayCountEachDay = ");
      ((StringBuilder)localObject2).append(this.n);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    i1 = this.n;
    if (i1 > 0)
    {
      i2 = this.m;
      if (i2 > 0)
      {
        this.n = (i1 - 1);
        this.m = (i2 - 1);
        if (QLog.isColorLevel())
        {
          localObject1 = a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("checkIsNeedShowInterruptedAd() 满足条件，更新后的剩余次数 mDisplayCountEachEntrance = ");
          ((StringBuilder)localObject2).append(this.m);
          ((StringBuilder)localObject2).append(", mDisplayCountEachDay = ");
          ((StringBuilder)localObject2).append(this.n);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        return true;
      }
    }
    return false;
  }
  
  public void a(VideoInfo.InterruptedWeishiAd paramInterruptedWeishiAd)
  {
    if (this.c == null) {
      this.c = paramInterruptedWeishiAd;
    }
    if (this.d == null)
    {
      this.d = new SparseBooleanArray();
      paramInterruptedWeishiAd = this.c;
      if ((paramInterruptedWeishiAd != null) && (paramInterruptedWeishiAd.a != null))
      {
        paramInterruptedWeishiAd = this.c.a;
        int i2 = paramInterruptedWeishiAd.length;
        int i1 = 0;
        while (i1 < i2)
        {
          int i3 = paramInterruptedWeishiAd[i1];
          this.d.put(i3 - 1, true);
          i1 += 1;
        }
      }
    }
    if ((this.c != null) && (QLog.isColorLevel()))
    {
      paramInterruptedWeishiAd = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setInterruptedAdInfo() interruptedAdInfo = ");
      localStringBuilder.append(this.c.toString());
      QLog.d(paramInterruptedWeishiAd, 2, localStringBuilder.toString());
    }
  }
  
  public boolean a()
  {
    return this.u;
  }
  
  public boolean a(int paramInt)
  {
    if (!f()) {
      return false;
    }
    if ((!this.p) && (this.c.f == 0) && (this.c.d >= 0) && (paramInt >= this.c.d) && (j()))
    {
      g();
      this.p = true;
      return true;
    }
    return false;
  }
  
  public boolean a(ShortVideoItemHolder paramShortVideoItemHolder, boolean paramBoolean)
  {
    Object localObject = this.e;
    if (localObject != null) {
      i1 = ((ShortVideoItemHolder)localObject).Z;
    } else {
      i1 = 0;
    }
    if ((paramShortVideoItemHolder.Z > i1) && (paramBoolean)) {
      c();
    }
    localObject = this.e;
    if ((localObject != null) && (((ShortVideoItemHolder)localObject).c != null)) {
      this.e.c.setVisibility(8);
    }
    this.e = paramShortVideoItemHolder;
    int i1 = this.s;
    if (i1 >= 0)
    {
      localObject = this.d;
      if ((localObject != null) && (((SparseBooleanArray)localObject).indexOfKey(i1) >= 0) && ((this.r) || (this.q) || (this.p))) {
        this.d.delete(this.s);
      }
    }
    this.s = paramShortVideoItemHolder.Z;
    this.p = false;
    this.q = false;
    this.r = false;
    if ((this.c != null) && (QLog.isColorLevel()))
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPlayingVideoInfo() itemHolder.position=");
      localStringBuilder.append(paramShortVideoItemHolder.Z);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return a(0) | false;
  }
  
  public void b()
  {
    if ((this.c.f == 0) && (this.t))
    {
      VideoFeedsPlayManager.VideoStatusListener localVideoStatusListener = this.f;
      Object localObject = this.e;
      if (localObject != null) {
        localObject = ((ShortVideoItemHolder)localObject).az;
      } else {
        localObject = null;
      }
      localVideoStatusListener.d((VideoPlayParam)localObject);
    }
    this.u = false;
    this.t = false;
  }
  
  public boolean c()
  {
    if (!f()) {
      return false;
    }
    if ((!this.q) && (this.c.f == 0) && (this.c.b) && (j()))
    {
      g();
      this.q = true;
      return true;
    }
    return false;
  }
  
  public boolean d()
  {
    if (!f()) {
      return false;
    }
    if ((!this.r) && ((this.c.f == 1) || (this.c.c)) && (j()))
    {
      g();
      this.r = true;
      this.t = this.u;
      return true;
    }
    return false;
  }
  
  public void e()
  {
    String str1;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      str1 = a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doOnDestory() mIsConfigInited = ");
      ((StringBuilder)localObject1).append(this.k);
      QLog.d(str1, 2, ((StringBuilder)localObject1).toString());
    }
    if ((this.k) && (!TextUtils.isEmpty(this.l))) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(this.l);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("display_count_each_entrance", this.o);
        ((JSONObject)localObject2).put("display_count_each_day", this.n);
        if (!this.j) {
          break label228;
        }
        str1 = "weishi";
        ((JSONObject)localObject1).put(str1, localObject2);
        ReadInJoyHelper.F(this.h, ((JSONObject)localObject1).toString());
        if (QLog.isColorLevel())
        {
          str1 = a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("doOnDestory() 本地配置更新成功，mConfigStr = ");
          ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
          QLog.d(str1, 2, ((StringBuilder)localObject2).toString());
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("doOnDestory() 本地配置更新失败，error = ");
          ((StringBuilder)localObject2).append(localException.getMessage());
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
      }
      return;
      label228:
      String str2 = "default";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsInterruptedAdManager
 * JD-Core Version:    0.7.0.1
 */