package com.tencent.mobileqq.troopgift;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.util.DisplayUtil;
import org.json.JSONObject;

public class TroopGiftActionButton
  extends RelativeLayout
{
  protected Handler a;
  protected View.OnClickListener b;
  protected ImageView c;
  protected AnimationDrawable d;
  private TroopGiftActionButton.ProgressView e;
  private JSONObject f;
  
  public TroopGiftActionButton(Context paramContext, JSONObject paramJSONObject, View.OnClickListener paramOnClickListener)
  {
    super(paramContext);
    this.f = paramJSONObject;
    this.b = paramOnClickListener;
    this.a = new Handler(Looper.getMainLooper());
    a();
  }
  
  protected void a()
  {
    this.e = new TroopGiftActionButton.ProgressView(this, getContext());
    Object localObject1 = new RelativeLayout.LayoutParams(DisplayUtil.a(getContext(), 68.0F), DisplayUtil.a(getContext(), 68.0F));
    ((RelativeLayout.LayoutParams)localObject1).addRule(10);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(getContext(), 53.5F);
    addView(this.e, (ViewGroup.LayoutParams)localObject1);
    Object localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setShape(1);
    ((GradientDrawable)localObject2).setCornerRadius(DisplayUtil.a(getContext(), 56.0F));
    ((GradientDrawable)localObject2).setColor(Color.parseColor(this.f.optString("buttonColor")));
    localObject1 = new TextView(getContext());
    ((TextView)localObject1).setText(this.f.optString("buttonText"));
    ((TextView)localObject1).setTextColor(Color.parseColor(this.f.optString("buttonTextColor")));
    ((TextView)localObject1).setGravity(17);
    ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
    localObject2 = new RelativeLayout.LayoutParams(DisplayUtil.a(getContext(), 56.0F), DisplayUtil.a(getContext(), 56.0F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = DisplayUtil.a(getContext(), 59.5F);
    addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.c = new ImageView(getContext());
    this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
    ((TextView)localObject1).setOnTouchListener(new TroopGiftActionButton.1(this, (TextView)localObject1));
  }
  
  public void a(String paramString)
  {
    this.a.post(new TroopGiftActionButton.2(this, paramString));
  }
  
  public void setProgress(int paramInt)
  {
    this.e.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftActionButton
 * JD-Core Version:    0.7.0.1
 */