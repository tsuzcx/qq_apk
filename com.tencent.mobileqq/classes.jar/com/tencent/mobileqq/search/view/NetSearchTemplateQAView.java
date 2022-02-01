package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.search.model.AnswerItem;
import com.tencent.mobileqq.search.model.ImageItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateQAItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import java.util.ArrayList;
import java.util.List;

public class NetSearchTemplateQAView
  extends NetSearchTemplateBaseView
{
  public LinearLayout a;
  public TextView a;
  public URLImageView a;
  public ArrayList<NetSearchTemplateQAView.AnswerView> a;
  public TextView b;
  
  public NetSearchTemplateQAView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  protected void a()
  {
    View localView = a(this.c);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131363068));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368317));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131362757));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362760));
  }
  
  public void a(NetSearchTemplateQAItem paramNetSearchTemplateQAItem)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if ((paramNetSearchTemplateQAItem.jdField_a_of_type_JavaUtilList == null) || (paramNetSearchTemplateQAItem.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    Context localContext = this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    int j = 0;
    label60:
    Object localObject2;
    Object localObject1;
    Object localObject3;
    label224:
    label353:
    Object localObject4;
    label257:
    label290:
    label340:
    int i;
    label416:
    int k;
    int m;
    Object localObject5;
    if (j < paramNetSearchTemplateQAItem.jdField_a_of_type_JavaUtilList.size())
    {
      localObject2 = (AnswerItem)paramNetSearchTemplateQAItem.jdField_a_of_type_JavaUtilList.get(j);
      localObject1 = new NetSearchTemplateQAView.AnswerView(this, localContext);
      if (TextUtils.isEmpty(((AnswerItem)localObject2).jdField_a_of_type_JavaLangString)) {
        break label780;
      }
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = DisplayUtil.a(localContext, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = DisplayUtil.a(localContext, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject3).mMemoryCacheKeySuffix = "leftIcon";
      localObject3 = URLDrawable.getDrawable(((AnswerItem)localObject2).jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
      ((URLDrawable)localObject3).setDecodeHandler(URLDrawableDecodeHandler.a);
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable((Drawable)localObject3);
      if ((((URLDrawable)localObject3).getStatus() != 1) && (((URLDrawable)localObject3).getStatus() != 0)) {
        ((URLDrawable)localObject3).restartDownload();
      }
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
      if (TextUtils.isEmpty(((AnswerItem)localObject2).b)) {
        break label793;
      }
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((AnswerItem)localObject2).b);
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (TextUtils.isEmpty(((AnswerItem)localObject2).c)) {
        break label806;
      }
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((AnswerItem)localObject2).c);
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (TextUtils.isEmpty(((AnswerItem)localObject2).d)) {
        break label831;
      }
      ((NetSearchTemplateQAView.AnswerView)localObject1).c.setVisibility(0);
      if ((((AnswerItem)localObject2).jdField_a_of_type_JavaUtilList == null) || (((AnswerItem)localObject2).jdField_a_of_type_JavaUtilList.size() == 0)) {
        break label819;
      }
      ((NetSearchTemplateQAView.AnswerView)localObject1).c.setMaxLines(2);
      ((NetSearchTemplateQAView.AnswerView)localObject1).c.setText(((AnswerItem)localObject2).d);
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label844;
      }
      ((NetSearchTemplateQAView.AnswerView)localObject1).c.setTextColor(Color.parseColor("#737373"));
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130842544);
      if ((((AnswerItem)localObject2).jdField_a_of_type_JavaUtilList == null) || (((AnswerItem)localObject2).jdField_a_of_type_JavaUtilList.size() == 0)) {
        break label1311;
      }
      if (((AnswerItem)localObject2).jdField_a_of_type_JavaUtilList.size() != 1) {
        break label911;
      }
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject3 = ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView;
      localObject4 = localContext.getResources();
      i = ((Resources)localObject4).getDisplayMetrics().widthPixels;
      float f1 = ((Resources)localObject4).getDimension(2131298471);
      float f2 = ((Resources)localObject4).getDimension(2131298471);
      k = DisplayUtil.a(localContext, 2.0F);
      m = ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = (int)(i - f1 - f2 - (m - 1) * k) / m;
      ((SquareImageView)localObject3).setLayoutParams(new FrameLayout.LayoutParams(i, i));
      localObject2 = (ImageItem)((AnswerItem)localObject2).jdField_a_of_type_JavaUtilList.get(0);
      localObject4 = ((ImageItem)localObject2).jdField_a_of_type_JavaLangString;
      localObject5 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject5).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestHeight = i;
      ((URLDrawable.URLDrawableOptions)localObject5).mPlayGifImage = true;
      localObject4 = URLDrawable.getDrawable((String)localObject4, (URLDrawable.URLDrawableOptions)localObject5);
      ((SquareImageView)localObject3).setImageDrawable((Drawable)localObject4);
      if ((((URLDrawable)localObject4).getStatus() != 1) && (((URLDrawable)localObject4).getStatus() != 0)) {
        ((URLDrawable)localObject4).restartDownload();
      }
      if (((ImageItem)localObject2).jdField_a_of_type_Int != 2) {
        break label898;
      }
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
      if (j != paramNetSearchTemplateQAItem.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        localObject1 = new View(localContext);
        ((View)localObject1).setBackgroundResource(2130839537);
        ((View)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, DisplayUtil.a(localContext, 6.0F)));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      j += 1;
      break label60;
      break;
      label780:
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
      break label224;
      label793:
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label257;
      label806:
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label290;
      label819:
      ((NetSearchTemplateQAView.AnswerView)localObject1).c.setMaxLines(3);
      break label340;
      label831:
      ((NetSearchTemplateQAView.AnswerView)localObject1).c.setVisibility(8);
      break label353;
      label844:
      ((NetSearchTemplateQAView.AnswerView)localObject1).c.setTextColor(Color.parseColor("#262626"));
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130842541);
      break label416;
      label898:
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      label911:
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int n = ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      k = i;
      if (i < ((AnswerItem)localObject2).jdField_a_of_type_JavaUtilList.size())
      {
        k = i;
        if (i < n)
        {
          localObject4 = ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject4).setVisibility(0);
          localObject3 = (SquareImageView)((View)localObject4).findViewById(2131368829);
          localObject4 = (ImageView)((View)localObject4).findViewById(2131370047);
          localObject5 = (ImageItem)((AnswerItem)localObject2).jdField_a_of_type_JavaUtilList.get(i);
          Object localObject6 = ((ImageItem)localObject5).jdField_a_of_type_JavaLangString;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestHeight = 200;
          localURLDrawableOptions.mRequestWidth = 200;
          localURLDrawableOptions.mFailedDrawable = localColorDrawable;
          localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
          localURLDrawableOptions.mPlayGifImage = true;
          localObject6 = URLDrawable.getDrawable((String)localObject6, localURLDrawableOptions);
          ((SquareImageView)localObject3).setImageDrawable((Drawable)localObject6);
          if ((((URLDrawable)localObject6).getStatus() != 1) && (((URLDrawable)localObject6).getStatus() != 0)) {
            ((URLDrawable)localObject6).restartDownload();
          }
          ((SquareImageView)localObject3).setVisibility(0);
          if (((ImageItem)localObject5).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject4).setVisibility(0);
            label1141:
            if ((i != n - 1) || (((AnswerItem)localObject2).jdField_a_of_type_Int <= n)) {
              break label1264;
            }
            ((ImageView)localObject4).setVisibility(8);
            ((SquareImageView)localObject3).setFilterColor(Color.parseColor("#66000000"));
            m = ((AnswerItem)localObject2).jdField_a_of_type_Int - n;
            k = m;
            if (m > 99) {
              k = 99;
            }
            ((SquareImageView)localObject3).setFilterText("+" + k);
            ((SquareImageView)localObject3).setFilterTextSize(DisplayUtil.a(((SquareImageView)localObject3).getContext(), 20.0F));
          }
          for (;;)
          {
            i += 1;
            break;
            ((ImageView)localObject4).setVisibility(8);
            break label1141;
            label1264:
            ((SquareImageView)localObject3).setFilterColor(-1);
            ((SquareImageView)localObject3).setFilterText("");
          }
        }
      }
      while (k < n)
      {
        ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(k).setVisibility(4);
        k += 1;
      }
      continue;
      label1311:
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      ((NetSearchTemplateQAView.AnswerView)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateQAView
 * JD-Core Version:    0.7.0.1
 */