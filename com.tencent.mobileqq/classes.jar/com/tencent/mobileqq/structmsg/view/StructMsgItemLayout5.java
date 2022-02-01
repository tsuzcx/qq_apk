package com.tencent.mobileqq.structmsg.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.widget.TextViewWrapLayout;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class StructMsgItemLayout5
  extends AbsStructMsgItem
{
  public boolean a;
  
  public StructMsgItemLayout5()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private RelativeLayout a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Resources localResources = paramContext.getResources();
    TextViewWrapLayout localTextViewWrapLayout = new TextViewWrapLayout(paramContext);
    Object localObject = new RelativeLayout.LayoutParams(-1, -2);
    int i = AIOUtils.b(15.0F, localResources);
    localTextViewWrapLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localTextViewWrapLayout.setPadding(0, i, 0, i);
    AnyScaleTypeImageView localAnyScaleTypeImageView = new AnyScaleTypeImageView(paramContext);
    localAnyScaleTypeImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    try
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.b(70.0F, localResources);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.b(70.0F, localResources);
      localObject = URLDrawable.getDrawable(paramString1, (URLDrawable.URLDrawableOptions)localObject);
      paramString1 = (String)localObject;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getPAVideoPreDialogView():  getDrawable Exception, imgUrl=");
        localStringBuilder.append(paramString1);
        QLog.e("StructMsgItemLayout5", 2, localStringBuilder.toString(), localException);
      }
      paramString1 = null;
    }
    localAnyScaleTypeImageView.setId(2131368461);
    localAnyScaleTypeImageView.setImageDrawable(paramString1);
    paramString1 = new RelativeLayout.LayoutParams(AIOUtils.b(70.0F, localResources), AIOUtils.b(70.0F, localResources));
    paramString1.addRule(9);
    paramString1.addRule(10);
    localTextViewWrapLayout.addView(localAnyScaleTypeImageView, paramString1);
    i = AIOUtils.b(10.0F, localResources);
    paramString1 = new TextView(paramContext);
    paramString1.setId(2131379930);
    paramString1.setText(paramString2);
    paramString1.setTextSize(14.0F);
    paramString1.setTextColor(-8355712);
    paramString1.setTypeface(Typeface.DEFAULT);
    paramString1.setMaxLines(2);
    paramString1.setEllipsize(TextUtils.TruncateAt.END);
    paramString2 = new RelativeLayout.LayoutParams(-1, -2);
    paramString2.topMargin = 0;
    paramString2.leftMargin = i;
    paramString2.addRule(10);
    paramString2.addRule(1, localAnyScaleTypeImageView.getId());
    paramString2.addRule(11);
    paramContext = new TextView(paramContext);
    paramContext.setId(2131379906);
    paramContext.setText(paramString3);
    paramContext.setTextSize(14.0F);
    paramContext.setTextColor(-8355712);
    paramContext.setTypeface(Typeface.DEFAULT);
    paramContext.setMaxLines(2);
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramString3 = new RelativeLayout.LayoutParams(-1, -2);
    paramString3.topMargin = 0;
    paramString3.leftMargin = i;
    paramString3.addRule(3, paramString1.getId());
    paramString3.addRule(1, localAnyScaleTypeImageView.getId());
    localTextViewWrapLayout.addView(paramString1, paramString2);
    localTextViewWrapLayout.addView(paramContext, paramString3);
    localTextViewWrapLayout.a(true);
    return localTextViewWrapLayout;
  }
  
  @TargetApi(16)
  private RelativeLayout a(Context paramContext, boolean paramBoolean)
  {
    Resources localResources = paramContext.getResources();
    paramContext = new RelativeLayout(paramContext);
    a(paramContext);
    d(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    if (paramBoolean) {
      i = 2131296441;
    } else {
      i = 2131299074;
    }
    int k = localResources.getDimensionPixelSize(i);
    if (paramBoolean) {
      i = 2131296442;
    } else {
      i = 2131299075;
    }
    int m = localResources.getDimensionPixelSize(i);
    int j;
    if (a(1)) {
      j = AIOUtils.b(15.0F, localResources);
    } else {
      j = AIOUtils.b(6.0F, localResources);
    }
    int i = AIOUtils.b(6.0F, localResources);
    if (a(2)) {
      i = AIOUtils.b(15.0F, localResources);
    } else if (a(1)) {
      i = AIOUtils.b(15.0F, localResources);
    }
    paramContext.setPadding(k, j, m, i);
    paramContext.setLayoutParams(localLayoutParams);
    return paramContext;
  }
  
  protected int b()
  {
    return 5;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject2;
    if (paramBundle == null) {
      localObject2 = new Bundle();
    } else {
      localObject2 = paramBundle;
    }
    Object localObject3;
    if (((Bundle)localObject2).getBoolean("pre_dialog") == true)
    {
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      localObject1 = null;
      localObject3 = null;
      paramBundle = null;
      i = 0;
      while (localIterator.hasNext())
      {
        localObject4 = (AbsStructMsgElement)localIterator.next();
        if ((localObject4 instanceof StructMsgItemVideo))
        {
          localObject4 = (StructMsgItemVideo)localObject4;
          if (!((StructMsgItemVideo)localObject4).a()) {
            break;
          }
          localObject1 = ((StructMsgItemVideo)localObject4).ac;
          localObject3 = ((StructMsgItemVideo)localObject4).ag;
          i = 1;
        }
        else if ((localObject4 instanceof StructMsgItemTitle))
        {
          paramBundle = ((StructMsgItemTitle)localObject4).b();
        }
      }
      if (i != 0) {
        return a(paramContext, (String)localObject1, paramBundle, (String)localObject3);
      }
    }
    Resources localResources = paramContext.getResources();
    Object localObject4 = "accostType";
    boolean bool;
    if (((Bundle)localObject2).getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {
      bool = true;
    } else {
      bool = false;
    }
    if ((paramView != null) && ((paramView instanceof RelativeLayout))) {
      localObject3 = (RelativeLayout)paramView;
    } else {
      localObject3 = a(paramContext, bool);
    }
    ((RelativeLayout)localObject3).removeAllViews();
    int m = (int)(TypedValue.applyDimension(1, 175.0F, localResources.getDisplayMetrics()) + 0.5F);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    paramView = "";
    paramBundle = null;
    int j = 0;
    int i = -1;
    Object localObject1 = null;
    int k;
    while (localIterator.hasNext())
    {
      Object localObject5 = (AbsStructMsgElement)localIterator.next();
      ((AbsStructMsgElement)localObject5).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      String str = ((AbsStructMsgElement)localObject5).jdField_a_of_type_JavaLangString;
      if ("title".equals(str))
      {
        localObject5 = (StructMsgItemTitle)localObject5;
        if (!TextUtils.isEmpty(((StructMsgItemTitle)localObject5).b()))
        {
          localObject1 = new TextView(paramContext);
          ((TextView)localObject1).setText(((StructMsgItemTitle)localObject5).b());
          paramView = ((StructMsgItemTitle)localObject5).b();
          ((TextView)localObject1).setId(2131379930);
          ((TextView)localObject1).setTag(localObject5);
          ((TextView)localObject1).setGravity(3);
          ((TextView)localObject1).setGravity(16);
          if (((Bundle)localObject2).getInt((String)localObject4) == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {
            ((TextView)localObject1).setMaxLines(2);
          } else {
            ((TextView)localObject1).setMaxLines(1);
          }
          ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
          ((TextView)localObject1).setTextColor(-1);
          ((TextView)localObject1).setTextSize(2, 18.0F);
          ((TextView)localObject1).setBackgroundColor(paramContext.getResources().getColor(2131165257));
          int n = AIOUtils.b(10.0F, localResources);
          int i1 = AIOUtils.b(4.0F, localResources);
          int i2 = AIOUtils.b(5.0F, localResources);
          if (((Bundle)localObject2).getBoolean("pre_dialog", false)) {
            k = n * 2;
          } else {
            k = n;
          }
          ((TextView)localObject1).setPadding(k, i1, n, i2);
        }
      }
      for (;;)
      {
        break;
        if ("picture".equals(str))
        {
          paramBundle = ((AbsStructMsgElement)localObject5).a(paramContext, null, (Bundle)localObject2);
          localObject5 = paramBundle.findViewById(2131368633);
          if ((localObject5 != null) && ((localObject5 instanceof AnyScaleTypeImageView))) {
            ((AnyScaleTypeImageView)localObject5).setTag(2131373227, Integer.valueOf(1));
          }
        }
        else if ("video".equals(str))
        {
          if ((localObject5 instanceof StructMsgItemVideo))
          {
            paramBundle = (StructMsgItemVideo)localObject5;
            if (this.jdField_a_of_type_Boolean) {
              paramBundle.c = false;
            }
            if (paramBundle.a())
            {
              if (!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.hasFlag(4)) {
                i = -2;
              } else {
                i = -1;
              }
              j = 0;
              while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
              {
                paramBundle = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(j);
                if ("title".equals(paramBundle.jdField_a_of_type_JavaLangString))
                {
                  ((Bundle)localObject2).putString("public_account_video_title", ((StructMsgItemTitle)paramBundle).b());
                  break;
                }
                j += 1;
              }
            }
            else
            {
              ((Bundle)localObject2).putBoolean("v_crap_ctn", true);
              ((Bundle)localObject2).putBoolean("has_cnr", true);
              ((Bundle)localObject2).putInt("v_height", m);
              i = -2;
            }
          }
          else
          {
            i = -1;
          }
          ((RelativeLayout)localObject3).setPadding(0, 0, 0, 0);
          ((RelativeLayout)localObject3).getLayoutParams().width = i;
          if (((Bundle)localObject2).getBoolean("pre_dialog", false)) {
            ((LinearLayout.LayoutParams)((RelativeLayout)localObject3).getLayoutParams()).gravity = 1;
          }
          paramBundle = ((AbsStructMsgElement)localObject5).a(paramContext, null, (Bundle)localObject2);
          j = 1;
        }
      }
    }
    if (paramBundle != null)
    {
      if (j == 0)
      {
        if (bool) {
          i = localResources.getDimensionPixelSize(2131296441);
        } else {
          i = localResources.getDimensionPixelSize(2131299074);
        }
        k = BaseChatItemLayout.B;
        i *= 2;
        if (!((Bundle)localObject2).getBoolean("hasHeadIcon", true)) {
          i = BaseChatItemLayout.B - i;
        } else {
          i = k - i;
        }
        k = (int)(i / 1.8F);
      }
      else
      {
        k = m;
      }
      localObject2 = new RelativeLayout.LayoutParams(i, k);
      if (j != 0) {
        localObject2 = new RelativeLayout.LayoutParams(i, -2);
      }
      ((RelativeLayout)localObject3).addView(paramBundle, (ViewGroup.LayoutParams)localObject2);
    }
    if ((j != 0) && (!TextUtils.isEmpty(paramView)) && ((paramBundle instanceof TitledImageView)))
    {
      localObject2 = (TitledImageView)paramBundle;
      ((TitledImageView)localObject2).setTitle(paramView);
      ((TitledImageView)localObject2).setTextColor(-1);
      ((TitledImageView)localObject2).setTextSize(AIOUtils.a(2, 18, localResources));
      ((TitledImageView)localObject2).setTextBackground(paramContext.getResources().getColor(2131165257));
      ((TitledImageView)localObject2).setTextPadding(AIOUtils.b(10.0F, localResources));
      ((TitledImageView)localObject2).settextBgRadius(AIOUtils.b(12.0F, localResources));
    }
    if ((j != 0) && (!TextUtils.isEmpty(paramView)) && (paramBundle != null))
    {
      paramContext = paramBundle.getTag(2131377982);
      if ((paramContext != null) && ((paramContext instanceof StructMsgItemVideo.Holder))) {
        ((StructMsgItemVideo.Holder)paramContext).a.setText(paramView);
      }
    }
    if ((j == 0) && (localObject1 != null))
    {
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      if (paramBundle != null) {
        paramContext.addRule(8, paramBundle.getId());
      }
      ((RelativeLayout)localObject3).addView((View)localObject1, paramContext);
    }
    ((RelativeLayout)localObject3).setId(2131377979);
    return localObject3;
  }
  
  public String b()
  {
    return "Layout5";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5
 * JD-Core Version:    0.7.0.1
 */