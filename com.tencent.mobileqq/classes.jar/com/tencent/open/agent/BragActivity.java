package com.tencent.open.agent;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.open.base.LengthInputFilter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.widget.IKeyboardChanged;
import com.tencent.open.widget.KeyboardDetectorRelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class BragActivity
  extends ChallengeBragBase
  implements IKeyboardChanged
{
  protected ScrollView a;
  protected ImageView b;
  protected InputFilter[] c;
  protected KeyboardDetectorRelativeLayout d;
  
  protected void a()
  {
    this.a = ((ScrollView)super.findViewById(2131429727));
    this.d = ((KeyboardDetectorRelativeLayout)super.findViewById(2131444923));
    this.d.a(this);
    this.b = ((ImageView)super.findViewById(2131429726));
    this.A = ((EditText)super.findViewById(2131432616));
    this.y = ((TextView)super.findViewById(2131431870));
    this.z = ((TextView)super.findViewById(2131431864));
    this.x = ((TextView)super.findViewById(2131448305));
    this.c = new InputFilter[] { new LengthInputFilter(this.A, 100) };
    this.A.setFilters(this.c);
    this.A.setText(this.o);
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
    try
    {
      a(this.n);
      Bitmap localBitmap = ImageLoader.a().a(this.p);
      if (localBitmap != null)
      {
        this.b.setImageBitmap(localBitmap);
        return;
      }
      this.b.setImageResource(2130841060);
      ImageLoader.a().a(this.p, new BragActivity.1(this));
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNickName error. ");
      localStringBuilder.append(localException.getMessage());
      LogUtility.c("BragActivity", localStringBuilder.toString(), localException);
      d();
    }
  }
  
  public void a(int paramInt)
  {
    paramInt = DisplayUtil.b(this, paramInt) - 10 - 10;
    ScrollView localScrollView = this.a;
    if ((localScrollView != null) && (paramInt < 255))
    {
      paramInt = paramInt - 20 - 145;
      if ((paramInt > 0) && (paramInt < 90))
      {
        localScrollView.setVisibility(0);
        this.a.getLayoutParams().height = DisplayUtil.a(this, paramInt);
        this.a.setVerticalFadingEdgeEnabled(true);
        return;
      }
      if (paramInt <= 0)
      {
        this.a.getLayoutParams().height = 0;
        this.a.setVisibility(8);
      }
    }
  }
  
  public void b()
  {
    ImageView localImageView = this.b;
    if (localImageView != null)
    {
      localImageView.getLayoutParams().height = DisplayUtil.a(this, 90.0F);
      this.b.setVerticalFadingEdgeEnabled(false);
      this.b.setVisibility(0);
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
    super.setContentView(2131625698);
    super.c();
    a();
    StaticAnalyz.a("100", "ANDROIDQQ.BRAG.FS", this.i, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BragActivity
 * JD-Core Version:    0.7.0.1
 */