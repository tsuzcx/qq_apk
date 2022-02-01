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
  protected int a;
  protected Context a;
  protected Drawable a;
  protected View.OnClickListener a;
  protected NearbyPublishMenu.OnItemClickListener a;
  protected int b;
  
  public NearbyPublishMenu(Context paramContext, ArrayList<MenuItem> paramArrayList)
  {
    super(paramContext, 2131756189);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new NearbyPublishMenu.1(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = DisplayUtil.a(paramContext, 34.0F);
    this.jdField_a_of_type_Int = DisplayUtil.a(paramContext, 34.0F);
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
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#f2f2f2"));
    }
    Object localObject2 = null;
    Object localObject1;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.jdField_b_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
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
      paramString = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    paramImageView.setImageDrawable(paramString);
  }
  
  public void a(NearbyPublishMenu.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetNearbyPublishMenu$OnItemClickListener = paramOnItemClickListener;
  }
  
  protected void a(ArrayList<MenuItem> paramArrayList)
  {
    RoundCornerLinearLayout localRoundCornerLinearLayout = new RoundCornerLinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localRoundCornerLinearLayout.setOrientation(1);
    localRoundCornerLinearLayout.setBackgroundResource(2130845709);
    int i = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 6.0F);
    localRoundCornerLinearLayout.setPadding(0, i, 0, i);
    localRoundCornerLinearLayout.setRadius(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F));
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)paramArrayList.next();
      ViewGroup localViewGroup = (ViewGroup)localLayoutInflater.inflate(2131559494, localRoundCornerLinearLayout, false);
      ImageView localImageView = (ImageView)localViewGroup.findViewById(2131368343);
      TextView localTextView1 = (TextView)localViewGroup.findViewById(2131378784);
      TextView localTextView2 = (TextView)localViewGroup.findViewById(2131378039);
      localTextView1.setText(localMenuItem.jdField_b_of_type_JavaLangString);
      if (TextUtils.isEmpty(localMenuItem.c)) {
        localTextView2.setVisibility(8);
      } else {
        localTextView2.setText(localMenuItem.c);
      }
      if (!TextUtils.isEmpty(localMenuItem.a)) {
        a(localImageView, localMenuItem.a);
      } else if (localMenuItem.jdField_b_of_type_Int > 0) {
        localImageView.setImageResource(localMenuItem.jdField_b_of_type_Int);
      }
      localViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localViewGroup.setTag(localMenuItem);
      localRoundCornerLinearLayout.addView(localViewGroup);
    }
    setContentView(localRoundCornerLinearLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyPublishMenu
 * JD-Core Version:    0.7.0.1
 */