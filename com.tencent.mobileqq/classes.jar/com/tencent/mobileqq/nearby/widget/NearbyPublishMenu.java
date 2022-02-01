package com.tencent.mobileqq.nearby.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.RoundCornerLinearLayout;
import java.util.ArrayList;
import java.util.Iterator;

public class NearbyPublishMenu
  extends Dialog
{
  protected NearbyPublishMenu.OnItemClickListener a;
  protected Context b;
  protected Drawable c;
  protected int d;
  protected int e;
  protected View.OnClickListener f = new NearbyPublishMenu.1(this);
  
  public NearbyPublishMenu(Context paramContext, ArrayList<MenuItem> paramArrayList)
  {
    super(paramContext, 2131953338);
    this.b = paramContext;
    this.d = DisplayUtil.a(paramContext, 34.0F);
    this.d = DisplayUtil.a(paramContext, 34.0F);
    a(paramArrayList);
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.x = paramInt1;
    localLayoutParams.y = paramInt2;
    localLayoutParams.gravity = 85;
    localLayoutParams.dimAmount = paramFloat;
    localWindow.setAttributes(localLayoutParams);
    super.show();
  }
  
  protected void a(ImageView paramImageView, String paramString)
  {
    if (this.c == null) {
      this.c = new ColorDrawable(Color.parseColor("#f2f2f2"));
    }
    Object localObject2 = null;
    Object localObject1;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.d;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.e;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.c;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.c;
        localObject1 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
      }
      else
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.w("NearbyPublishMenu", 2, "loadImage empty url");
          localObject1 = localObject2;
        }
      }
    }
    catch (Exception localException)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("loadImage exp: url=");
        ((StringBuilder)localObject1).append(paramString);
        QLog.w("NearbyPublishMenu", 2, ((StringBuilder)localObject1).toString(), localException);
        localObject1 = localObject2;
      }
    }
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = this.c;
    }
    paramImageView.setImageDrawable(paramString);
  }
  
  public void a(NearbyPublishMenu.OnItemClickListener paramOnItemClickListener)
  {
    this.a = paramOnItemClickListener;
  }
  
  protected void a(ArrayList<MenuItem> paramArrayList)
  {
    RoundCornerLinearLayout localRoundCornerLinearLayout = new RoundCornerLinearLayout(this.b);
    localRoundCornerLinearLayout.setOrientation(1);
    localRoundCornerLinearLayout.setBackgroundResource(2130847178);
    int i = DisplayUtil.a(this.b, 6.0F);
    localRoundCornerLinearLayout.setPadding(0, i, 0, i);
    localRoundCornerLinearLayout.setRadius(DisplayUtil.a(this.b, 8.0F));
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.b);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)paramArrayList.next();
      ViewGroup localViewGroup = (ViewGroup)localLayoutInflater.inflate(2131625515, localRoundCornerLinearLayout, false);
      ImageView localImageView = (ImageView)localViewGroup.findViewById(2131435219);
      TextView localTextView1 = (TextView)localViewGroup.findViewById(2131447463);
      TextView localTextView2 = (TextView)localViewGroup.findViewById(2131446539);
      localTextView1.setText(localMenuItem.d);
      if (TextUtils.isEmpty(localMenuItem.e)) {
        localTextView2.setVisibility(8);
      } else {
        localTextView2.setText(localMenuItem.e);
      }
      if (!TextUtils.isEmpty(localMenuItem.c)) {
        a(localImageView, localMenuItem.c);
      } else if (localMenuItem.b > 0) {
        localImageView.setImageResource(localMenuItem.b);
      }
      localViewGroup.setOnClickListener(this.f);
      localViewGroup.setTag(localMenuItem);
      localRoundCornerLinearLayout.addView(localViewGroup);
    }
    setContentView(localRoundCornerLinearLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyPublishMenu
 * JD-Core Version:    0.7.0.1
 */