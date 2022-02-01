package com.tencent.open.agent;

import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;
import com.tencent.open.agent.datamodel.QZonePortraitData;
import com.tencent.open.base.LengthInputFilter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.widget.IKeyboardChanged;
import com.tencent.open.widget.KeyboardDetectorRelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ChallengeActivity
  extends ChallengeBragBase
  implements View.OnClickListener, ImageLoader.ImageLoadListener, IKeyboardChanged
{
  protected KeyboardDetectorRelativeLayout a;
  protected ScrollView b;
  protected ScrollView c;
  protected ImageView d;
  protected ImageView e;
  protected InputFilter[] f;
  protected String g;
  protected String h;
  
  @TargetApi(14)
  protected void a()
  {
    this.a = ((KeyboardDetectorRelativeLayout)super.findViewById(2131445000));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.a.setFitsSystemWindows(true);
      this.a.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.c = ((ScrollView)super.findViewById(2131446652));
    this.x = ((TextView)super.findViewById(2131448645));
    this.A = ((EditText)super.findViewById(2131432616));
    this.b = ((ScrollView)super.findViewById(2131446651));
    this.y = ((TextView)super.findViewById(2131429752));
    this.z = ((TextView)super.findViewById(2131429747));
    this.d = ((ImageView)super.findViewById(2131429037));
    this.e = ((ImageView)super.findViewById(2131429038));
    this.a.a(this);
    this.c.setVerticalFadingEdgeEnabled(false);
    this.f = new InputFilter[] { new LengthInputFilter(this.A, 100) };
    this.A.setFilters(this.f);
    this.A.setText(this.o);
    Object localObject1 = this.b;
    if (localObject1 != null) {
      ((ScrollView)localObject1).setVerticalFadingEdgeEnabled(false);
    }
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
    try
    {
      a(this.n);
      this.g = QZonePortraitData.a(this.i, this.j);
      this.h = QZonePortraitData.a(this.i, this.n);
      localObject1 = ImageLoader.a().a(this.g);
      localObject2 = ImageLoader.a().a(this.h);
      if (localObject1 != null)
      {
        this.d.setImageBitmap((Bitmap)localObject1);
      }
      else
      {
        this.d.setImageResource(2130841060);
        ImageLoader.a().a(this.g, this);
      }
      if (localObject2 != null)
      {
        this.e.setImageBitmap((Bitmap)localObject2);
        return;
      }
      this.e.setImageResource(2130841060);
      ImageLoader.a().a(this.h, this);
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getNickName error. ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      LogUtility.c("ChallengeActivity", ((StringBuilder)localObject2).toString(), localException);
      d();
    }
  }
  
  public void a(int paramInt)
  {
    paramInt = DisplayUtil.b(this, paramInt) - 10 - 10;
    ScrollView localScrollView = this.b;
    if ((localScrollView != null) && (paramInt < 255))
    {
      int i = paramInt - 20;
      paramInt = i - 30 - 5 - 145;
      i = i - 5 - 145;
      if ((paramInt > 0) && (paramInt < 55))
      {
        localScrollView.setVisibility(0);
        this.b.getLayoutParams().height = DisplayUtil.a(this, paramInt);
        this.b.setVerticalFadingEdgeEnabled(true);
        this.c.getLayoutParams().height = DisplayUtil.a(this, 30.0F);
        this.c.setVerticalFadingEdgeEnabled(false);
        this.c.setVisibility(0);
        return;
      }
      if ((paramInt <= 0) && (i > 0) && (i < 30))
      {
        this.b.getLayoutParams().height = 0;
        this.b.setVisibility(8);
        this.x.getLayoutParams().height = DisplayUtil.a(this, i);
        this.c.setVerticalFadingEdgeEnabled(true);
        return;
      }
      this.b.getLayoutParams().height = 0;
      this.b.setVisibility(8);
      this.c.getLayoutParams().height = 0;
      this.c.setVisibility(8);
    }
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if (this.g.equals(paramString1))
    {
      this.d.setImageBitmap(paramBitmap);
      return;
    }
    if (this.h.equals(paramString1)) {
      this.e.setImageBitmap(paramBitmap);
    }
  }
  
  public void b()
  {
    ScrollView localScrollView = this.b;
    if (localScrollView != null)
    {
      localScrollView.getLayoutParams().height = DisplayUtil.a(this, 55.0F);
      this.b.setVerticalFadingEdgeEnabled(false);
      this.b.setVisibility(0);
      this.c.getLayoutParams().height = DisplayUtil.a(this, 30.0F);
      this.c.setVerticalFadingEdgeEnabled(false);
      this.c.setVisibility(0);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.getWindow().requestFeature(1);
    super.onCreate(paramBundle);
    super.setContentView(2131625699);
    super.c();
    a();
    StaticAnalyz.a("100", "ANDROIDQQ.PK.FS", this.i, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.ChallengeActivity
 * JD-Core Version:    0.7.0.1
 */