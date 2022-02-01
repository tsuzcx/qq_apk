package com.tencent.mobileqq.together.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.ThemeImageView;

public class WatchPanelView
  extends RelativeLayout
  implements View.OnClickListener
{
  Drawable a;
  ImageView b;
  ImageView c;
  TextView d;
  TextView e;
  PatchedButton f;
  int g;
  public View.OnClickListener h;
  URLDrawable i;
  
  public WatchPanelView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  private void b()
  {
    LayoutInflater.from(getContext()).inflate(2131627294, this, true);
    setBackgroundResource(2130837937);
    this.b = ((ImageView)findViewById(2131447680));
    this.c = ((ImageView)findViewById(2131447675));
    this.d = ((TextView)findViewById(2131447683));
    this.f = ((PatchedButton)findViewById(2131447681));
    this.e = ((TextView)findViewById(2131447682));
    this.f.setOnClickListener(this);
    this.g = AIOUtils.b(39.0F, getResources());
  }
  
  public void a()
  {
    URLDrawable localURLDrawable = this.i;
    if (localURLDrawable != null)
    {
      localURLDrawable.setDecodeHandler(null);
      this.i = null;
    }
  }
  
  public void a(int paramInt)
  {
    ImageView localImageView = this.b;
    if ((localImageView instanceof ThemeImageView)) {
      ((ThemeImageView)localImageView).setMaskShape(paramInt);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.e.setVisibility(paramInt);
    this.e.setText(paramString);
    this.e.setContentDescription(paramString);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.equals((String)this.b.getTag()))
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        int j = this.g;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = j;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = j;
        Drawable localDrawable = this.a;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
        localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
        j = this.g;
        ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.b(j, j, 6));
        ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.e);
        this.b.setImageDrawable((Drawable)localObject);
        this.b.setTag(paramString);
        paramString = this.i;
        if (paramString != null) {
          paramString.setDecodeHandler(null);
        }
        this.i = ((URLDrawable)localObject);
      }
    }
    else
    {
      this.b.setImageDrawable(this.a);
      this.b.setTag("");
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    this.d.setText(paramString);
    this.d.setContentDescription(paramString);
    this.d.setTextColor(getResources().getColor(paramInt));
    setContentDescription(paramString);
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.c.setTag("");
      this.c.setImageDrawable(ImageUtil.j());
      return;
    }
    if (!paramString.equals((String)this.c.getTag()))
    {
      paramQQAppInterface = paramQQAppInterface.getFaceBitmap(paramString, true);
      this.c.setImageBitmap(paramQQAppInterface);
      this.c.setTag(paramString);
    }
  }
  
  public void b(int paramInt)
  {
    this.a = getResources().getDrawable(paramInt);
  }
  
  public void b(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "加入";
    }
    this.f.setText(str);
    this.f.setContentDescription(str);
  }
  
  public void c(int paramInt)
  {
    this.f.setVisibility(paramInt);
  }
  
  public void onClick(View paramView)
  {
    View.OnClickListener localOnClickListener = this.h;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.WatchPanelView
 * JD-Core Version:    0.7.0.1
 */