package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqyw;
import aqzc;
import aqzm;
import aqzu;
import arbp;
import arcl;
import ardb;
import ardf;
import beog;
import bjeh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;
import mjg;

public class HeadSetView
  extends LinearLayout
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  aqzu jdField_a_of_type_Aqzu;
  private ardb jdField_a_of_type_Ardb;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private ImageView b;
  
  public HeadSetView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aqzu = new aqzu(paramContext);
    d();
    c();
    b();
  }
  
  public static Drawable a(Context paramContext, Drawable paramDrawable)
  {
    Object localObject;
    Bitmap localBitmap1;
    Bitmap localBitmap2;
    Resources localResources;
    if (!(paramDrawable instanceof SkinnableBitmapDrawable))
    {
      localObject = paramDrawable;
      if (!(paramDrawable instanceof BitmapDrawable)) {}
    }
    else
    {
      localBitmap1 = null;
      if (!(paramDrawable instanceof SkinnableBitmapDrawable)) {
        break label140;
      }
      localBitmap1 = ((SkinnableBitmapDrawable)paramDrawable).getBitmap();
      localBitmap2 = Bitmap.createBitmap(localBitmap1);
      localResources = paramContext.getResources();
      localObject = paramDrawable;
      if (localResources != null)
      {
        if ((localBitmap1 == null) || (localBitmap2 != null)) {
          break label158;
        }
        paramContext = localBitmap1;
      }
    }
    label140:
    label158:
    do
    {
      do
      {
        paramDrawable = new BitmapDrawable(localResources, localBitmap1);
        paramContext = new BitmapDrawable(localResources, paramContext);
        paramContext.setAlpha(127);
        localObject = new StateListDrawable();
        ((StateListDrawable)localObject).addState(new int[] { 16842919, 16842910 }, paramContext);
        ((StateListDrawable)localObject).addState(new int[] { 16842908 }, paramDrawable);
        ((StateListDrawable)localObject).addState(new int[0], paramDrawable);
        return localObject;
        if (!(paramDrawable instanceof BitmapDrawable)) {
          break;
        }
        localBitmap1 = ((BitmapDrawable)paramDrawable).getBitmap();
        break;
        paramContext = localBitmap2;
      } while (localBitmap1 != null);
      paramContext = localBitmap2;
    } while (localBitmap2 != null);
    return paramDrawable;
  }
  
  private void b()
  {
    View localView = a(2131309736);
    if (beog.a())
    {
      localView.setBackgroundColor(Color.parseColor("#CC000000"));
      return;
    }
    localView.setBackgroundColor(Color.parseColor("#7F000000"));
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      bjeh.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      if (bjeh.jdField_a_of_type_Boolean)
      {
        View localView = a(2131305240);
        ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
        localLayoutParams.height = bjeh.jdField_a_of_type_Int;
        localView.setLayoutParams(localLayoutParams);
        localView.setVisibility(0);
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView = inflate(getContext(), 2131493604, this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)a(2131303637));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131298311));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Aqzu);
    try
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844443)));
      arcl.a(this.jdField_a_of_type_AndroidWidgetImageView, "退出位置共享");
      this.b = ((ImageView)a(2131304473));
      this.b.setOnClickListener(this.jdField_a_of_type_Aqzu);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        this.b.setImageDrawable(a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844444)));
        arcl.a(this.b, "最小化位置共享");
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131311350));
        e();
        return;
        localThrowable1 = localThrowable1;
        QLog.e("HeadSetView", 1, "initViews: failed. ", localThrowable1);
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          QLog.e("HeadSetView", 1, "initViews: failed. ", localThrowable2);
        }
      }
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Ardb = new ardb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Ardb);
    this.jdField_a_of_type_Aqzu.a(this.jdField_a_of_type_Ardb);
    this.jdField_a_of_type_Aqzu.a(this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  public int a()
  {
    double d1 = 4.0D;
    View localView = a(2131303650);
    float f1 = mjg.a(this.jdField_a_of_type_AndroidContentContext, 40.0F);
    f1 = localView.getWidth() - f1;
    float f2 = mjg.a(this.jdField_a_of_type_AndroidContentContext, 48.0F);
    double d2 = Math.floor(f1 / f2);
    if (QLog.isColorLevel()) {
      QLog.d("HeadSetView", 2, new Object[] { "maxShownAvatarCount: invoked. ", " floor: ", Double.valueOf(d2), " avatarWidth: ", Float.valueOf(f2), " listviewContainerWidth: ", Float.valueOf(f1) });
    }
    if (d2 > 4.0D) {}
    for (;;)
    {
      return (int)d1;
      d1 = d2;
    }
  }
  
  protected final <T extends View> T a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
  }
  
  public aqzu a()
  {
    return this.jdField_a_of_type_Aqzu;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ardb.notifyDataSetChanged();
  }
  
  public void setLocationController(arbp paramarbp, aqyw paramaqyw, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ardb.a(paramarbp);
    this.jdField_a_of_type_Aqzu.a(paramaqyw);
    int i;
    if (!aqzc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a.a(paramaqyw))
    {
      paramarbp = new ArrayList();
      paramarbp.add(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      this.jdField_a_of_type_Ardb.a(paramarbp);
      if ((!paramBoolean) || (ardf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaqyw.a(), paramaqyw.a()))) {
        break label108;
      }
      i = 1;
      paramaqyw = this.jdField_a_of_type_AndroidWidgetTextView;
      if (i == 0) {
        break label114;
      }
    }
    label108:
    label114:
    for (paramarbp = "正在发起...";; paramarbp = "正在加入...")
    {
      paramaqyw.setText(paramarbp);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.HeadSetView
 * JD-Core Version:    0.7.0.1
 */