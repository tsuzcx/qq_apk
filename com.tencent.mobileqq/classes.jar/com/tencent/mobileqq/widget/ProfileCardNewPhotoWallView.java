package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import anni;
import bhzx;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ProfilePhotoWall;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

public class ProfileCardNewPhotoWallView
  extends LinearLayout
{
  private float jdField_a_of_type_Float;
  protected int a;
  public Activity a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Drawable a;
  protected LayoutInflater a;
  public QQAppInterface a;
  public String a;
  public LinkedList<ProfilePhotoWall> a;
  private boolean jdField_a_of_type_Boolean;
  protected int b;
  protected int c;
  private int d;
  
  public ProfileCardNewPhotoWallView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProfileCardNewPhotoWallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    a();
  }
  
  private void a()
  {
    int i = getResources().getDimensionPixelSize(2131297467);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = localDisplayMetrics.density;
    this.jdField_a_of_type_Int = (localDisplayMetrics.widthPixels - i * 2);
    this.b = localDisplayMetrics.heightPixels;
    this.c = ((int)(2.0F * this.jdField_a_of_type_Float + 0.5F));
    i = Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    if (i <= 240) {
      this.d = 60;
    }
    for (;;)
    {
      setOrientation(1);
      return;
      if (i <= 320) {
        this.d = 100;
      } else {
        this.d = 160;
      }
    }
  }
  
  protected View a()
  {
    return this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561425, null);
  }
  
  public ViewGroup a(int paramInt1, int paramInt2, int paramInt3)
  {
    ProfilePhotoWall localProfilePhotoWall = (ProfilePhotoWall)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt3);
    try
    {
      i = this.jdField_a_of_type_JavaUtilLinkedList.size();
      if ((i == 1) || (i == 4)) {
        break label381;
      }
      if (i != 7) {
        break label385;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        Object localObject1;
        if (QLog.isColorLevel()) {
          QLog.i("Q.qzonecover.", 2, localMalformedURLException.toString());
        }
        Object localObject2 = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        URLImageView localURLImageView;
        if (QLog.isColorLevel()) {
          QLog.i("Q.qzonecover.", 2, localException.toString());
        }
        Object localObject3 = null;
        continue;
        localURLImageView.setColorFilter(0);
        continue;
        localObject3 = null;
        continue;
        if ((paramInt3 != 0) && (((i != 2) && (i != 5) && (i != 8)) || ((paramInt3 != 0) && (paramInt3 != 1)))) {
          if (((i != 3) && (i != 6) && (i != 9)) || (paramInt3 != 0)) {}
        }
      }
    }
    for (localObject1 = new URL("qzone_cover", "original", localProfilePhotoWall.getOriginUrl());; localObject1 = new URL("qzone_cover", "original", localProfilePhotoWall.getThumbUrl(this.d)))
    {
      if (localObject1 == null) {
        break label375;
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2131166346);
      }
      Object localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = paramInt1;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = paramInt2;
      localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject4);
      localObject4 = (ViewGroup)a();
      localURLImageView = (URLImageView)((ViewGroup)localObject4).findViewById(2131368471);
      View localView = ((ViewGroup)localObject4).findViewById(2131368478);
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break;
      }
      localURLImageView.setColorFilter(1996488704);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt1, paramInt2);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, new ColorDrawable(855638016));
      localStateListDrawable.addState(View.EMPTY_STATE_SET, new ColorDrawable(0));
      ((ViewGroup)localObject4).setLayoutParams(localLayoutParams);
      localURLImageView.setImageDrawable((Drawable)localObject1);
      localURLImageView.setContentDescription(String.format(anni.a(2131707229), new Object[] { Integer.valueOf(paramInt3 + 1) }));
      localView.setBackgroundDrawable(localStateListDrawable);
      ((ViewGroup)localObject4).setOnClickListener(new bhzx(this, localProfilePhotoWall, paramInt3));
      return localObject4;
    }
  }
  
  public void a(String paramString, Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(LinkedList<ProfilePhotoWall> paramLinkedList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilLinkedList = paramLinkedList;
    int j;
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    if (paramInt > 3)
    {
      a(paramLinkedList, paramInt - 3);
      j = (this.jdField_a_of_type_Int - this.c * 2) / 3;
      paramLinkedList = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramLinkedList.setOrientation(0);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).topMargin = this.c;
      i = 0;
      while (i < 3)
      {
        localObject2 = a(j, j, paramInt - 3 + i);
        localObject3 = new LinearLayout.LayoutParams(j, j);
        if (i != paramInt - 1) {
          ((LinearLayout.LayoutParams)localObject3).rightMargin = this.c;
        }
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        paramLinkedList.addView((View)localObject2);
        i += 1;
      }
      paramLinkedList.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      addView(paramLinkedList);
      return;
    }
    paramLinkedList = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    paramLinkedList.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramLinkedList.setOrientation(0);
    switch (paramInt)
    {
    }
    for (;;)
    {
      removeAllViews();
      addView(paramLinkedList);
      return;
      paramLinkedList.addView(a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int * 2 / 3, 0));
      continue;
      paramInt = (this.jdField_a_of_type_Int - this.c) / 2;
      localObject1 = a(paramInt, paramInt, 0);
      localObject2 = a(paramInt, paramInt, 1);
      localObject3 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject3).setMargins(this.c, 0, 0, 0);
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      paramLinkedList.addView((View)localObject1);
      paramLinkedList.addView((View)localObject2);
      continue;
      paramInt = (this.jdField_a_of_type_Int - this.c) * 2 / 3;
      i = paramInt / 2;
      j = (paramInt - this.c) / 2;
      localObject1 = a(paramInt, paramInt, 0);
      localObject2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject3 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject3).setMargins(this.c, 0, 0, 0);
      ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      ((LinearLayout)localObject2).setOrientation(1);
      localObject3 = a(i, j, 1);
      ViewGroup localViewGroup = a(i, j, 2);
      ((LinearLayout.LayoutParams)localViewGroup.getLayoutParams()).setMargins(0, this.c, 0, 0);
      ((LinearLayout)localObject2).addView((View)localObject3);
      ((LinearLayout)localObject2).addView(localViewGroup);
      paramLinkedList.addView((View)localObject1);
      paramLinkedList.addView((View)localObject2);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if (this.jdField_a_of_type_Boolean) {
      bool = false;
    }
    return bool;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648));
  }
  
  @TargetApi(9)
  public void setOverScrollMode(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      super.setOverScrollMode(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardNewPhotoWallView
 * JD-Core Version:    0.7.0.1
 */