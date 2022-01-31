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
import atlh;
import atln;
import atlx;
import atmg;
import atof;
import atpb;
import atpr;
import atpv;
import bhxo;
import bngs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;

public class JavaHeadSetView
  extends LinearLayout
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  atmg jdField_a_of_type_Atmg;
  private atpr jdField_a_of_type_Atpr;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private ImageView b;
  
  public JavaHeadSetView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Atmg = new atmg(paramContext);
    c();
    b();
    a();
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
  
  private void a()
  {
    View localView = a(2131375981);
    if (bhxo.a())
    {
      localView.setBackgroundColor(Color.parseColor("#CC000000"));
      return;
    }
    localView.setBackgroundColor(Color.parseColor("#7F000000"));
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      bngs.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      if (bngs.jdField_a_of_type_Boolean)
      {
        View localView = a(2131371225);
        ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
        localLayoutParams.height = bngs.jdField_a_of_type_Int;
        localView.setLayoutParams(localLayoutParams);
        localView.setVisibility(0);
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewView = inflate(getContext(), 2131559216, this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)a(2131369542));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131363922));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Atmg);
    try
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844891)));
      atpb.a(this.jdField_a_of_type_AndroidWidgetImageView, "退出位置共享");
      this.b = ((ImageView)a(2131370418));
      this.b.setOnClickListener(this.jdField_a_of_type_Atmg);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        this.b.setImageDrawable(a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844892)));
        atpb.a(this.b, "最小化位置共享");
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131377684));
        d();
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
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Atpr);
    this.jdField_a_of_type_Atmg.a(this.jdField_a_of_type_Atpr);
    this.jdField_a_of_type_Atmg.a(this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  protected final <T extends View> T a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
  }
  
  public void setLocationController(atof paramatof, atlh paramatlh, boolean paramBoolean)
  {
    this.jdField_a_of_type_Atpr.a(paramatof);
    this.jdField_a_of_type_Atmg.a(paramatlh);
    int i;
    if (!atln.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a.a(paramatlh))
    {
      paramatof = new ArrayList();
      paramatof.add(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      this.jdField_a_of_type_Atpr.a(paramatof);
      if ((!paramBoolean) || (atpv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramatlh.a(), paramatlh.a()))) {
        break label108;
      }
      i = 1;
      paramatlh = this.jdField_a_of_type_AndroidWidgetTextView;
      if (i == 0) {
        break label114;
      }
    }
    label108:
    label114:
    for (paramatof = "正在发起...";; paramatof = "正在加入...")
    {
      paramatlh.setText(paramatof);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.JavaHeadSetView
 * JD-Core Version:    0.7.0.1
 */