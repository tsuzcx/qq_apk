package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class SquareCornerTextImageView
  extends FrameLayout
{
  KandianUrlImageView a;
  TextView b;
  View c;
  TextView d;
  public boolean e = true;
  
  public SquareCornerTextImageView(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = new KandianUrlImageView(paramContext);
    this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.b = new TextView(paramContext);
    this.b.setGravity(17);
    this.b.setBackgroundColor(Color.parseColor("#80000000"));
    this.b.setTextColor(-1);
    paramContext = new FrameLayout.LayoutParams(Utils.dp2px(30.0D), Utils.dp2px(18.0D));
    paramContext.gravity = 85;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.a, localLayoutParams);
    addView(this.b, paramContext);
    this.c = LayoutInflater.from(getContext()).inflate(2131626187, null);
    this.d = ((TextView)this.c.findViewById(2131448641));
    this.c.setVisibility(8);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.c, paramContext);
  }
  
  private void b(@NonNull SquareCornerTextImageView.PicInfo paramPicInfo)
  {
    float f = SquareCornerTextImageView.PicInfo.b(paramPicInfo) * 1.0F / SquareCornerTextImageView.PicInfo.c(paramPicInfo);
    if (SquareCornerTextImageView.PicInfo.d(paramPicInfo))
    {
      double d1 = f;
      if ((d1 < 0.455D) || (d1 > 2.2D))
      {
        this.b.setVisibility(0);
        this.b.setText(getResources().getString(2131915548));
        break label77;
      }
    }
    this.b.setVisibility(4);
    label77:
    if (SquareCornerTextImageView.PicInfo.e(paramPicInfo))
    {
      this.b.setVisibility(0);
      this.b.setText(getResources().getString(2131915547));
    }
    if ((SquareCornerTextImageView.PicInfo.f(paramPicInfo)) && (!TextUtils.isEmpty(SquareCornerTextImageView.PicInfo.g(paramPicInfo))))
    {
      this.d.setText(SquareCornerTextImageView.PicInfo.g(paramPicInfo));
      this.c.setVisibility(0);
      return;
    }
    this.c.setVisibility(8);
  }
  
  public void a(@NonNull SquareCornerTextImageView.PicInfo paramPicInfo)
  {
    ReadInJoyDisplayUtils.a(this.a, SquareCornerTextImageView.PicInfo.a(paramPicInfo), getContext());
    b(paramPicInfo);
  }
  
  public void a(@NonNull SquareCornerTextImageView.PicInfo paramPicInfo, String paramString)
  {
    try
    {
      paramString = new URL(paramString);
      ReadInJoyDisplayUtils.a(this.a, paramString, getContext());
    }
    catch (MalformedURLException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[configSmartSizeImage], e = ");
      localStringBuilder.append(paramString);
      QLog.e("SquareCornerTextImageView", 1, localStringBuilder.toString());
      ReadInJoyDisplayUtils.a(this.a, SquareCornerTextImageView.PicInfo.a(paramPicInfo), getContext());
    }
    b(paramPicInfo);
  }
  
  public KandianUrlImageView getImageView()
  {
    return this.a;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.e)
    {
      super.onMeasure(paramInt1, paramInt1);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.SquareCornerTextImageView
 * JD-Core Version:    0.7.0.1
 */