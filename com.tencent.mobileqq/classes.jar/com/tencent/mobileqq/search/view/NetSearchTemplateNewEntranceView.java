package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateNewEntranceItem;
import com.tencent.mobileqq.search.business.net.model.RelativeWord;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateBaseView;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.widget.ThemeURLImageView;
import java.util.ArrayList;
import java.util.List;

public class NetSearchTemplateNewEntranceView
  extends NetSearchTemplateBaseView
{
  public View a;
  public LinearLayout a;
  public TextView a;
  public URLImageView a;
  public ArrayList<NetSearchTemplateNewEntranceView.NetSearchSubView> a;
  public LinearLayout b;
  public TextView b;
  public ImageView c;
  public TextView c;
  public TextView h;
  
  public NetSearchTemplateNewEntranceView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  protected void a()
  {
    View localView = a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131366276));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131368461));
    URLImageView localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
    if ((localURLImageView instanceof ThemeURLImageView)) {
      ((ThemeURLImageView)localURLImageView).setSupportMaskView(false);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378784));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378039));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378039));
    this.h = ((TextView)localView.findViewById(2131365536));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131376568));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131368863);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131378029));
  }
  
  public void a(NetSearchTemplateNewEntranceItem paramNetSearchTemplateNewEntranceItem)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#004080"));
    }
    if ((paramNetSearchTemplateNewEntranceItem.a != null) && (paramNetSearchTemplateNewEntranceItem.a.size() != 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      Context localContext = this.jdField_b_of_type_AndroidWidgetLinearLayout.getContext();
      ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      int i = 0;
      while ((i < paramNetSearchTemplateNewEntranceItem.a.size()) && (i < 6))
      {
        RelativeWord localRelativeWord = (RelativeWord)paramNetSearchTemplateNewEntranceItem.a.get(i);
        NetSearchTemplateNewEntranceView.NetSearchSubView localNetSearchSubView = new NetSearchTemplateNewEntranceView.NetSearchSubView(this, localContext);
        if (!TextUtils.isEmpty(paramNetSearchTemplateNewEntranceItem.m))
        {
          Object localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.a(localContext, 16.0F);
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.a(localContext, 16.0F);
          ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "subItemLeftIconUrl";
          localObject = URLDrawable.getDrawable(paramNetSearchTemplateNewEntranceItem.m, (URLDrawable.URLDrawableOptions)localObject);
          ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.a);
          localNetSearchSubView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
          if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
            ((URLDrawable)localObject).restartDownload();
          }
          localNetSearchSubView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
        else
        {
          localNetSearchSubView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        }
        localNetSearchSubView.jdField_a_of_type_AndroidViewView.setTag(2131380884, paramNetSearchTemplateNewEntranceItem);
        if (!TextUtils.isEmpty(localRelativeWord.a))
        {
          localNetSearchSubView.jdField_a_of_type_AndroidWidgetTextView.setText(localRelativeWord.a);
          localNetSearchSubView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          localNetSearchSubView.jdField_a_of_type_AndroidViewView.setTag(2131378315, localRelativeWord.a);
        }
        else
        {
          localNetSearchSubView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(localRelativeWord.b))
        {
          localNetSearchSubView.jdField_a_of_type_AndroidViewView.setTag(2131378314, localRelativeWord.b);
          localNetSearchSubView.jdField_a_of_type_AndroidViewView.setTag(2131378285, Integer.valueOf(paramNetSearchTemplateNewEntranceItem.c));
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localNetSearchSubView.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_JavaUtilArrayList.add(localNetSearchSubView);
        i += 1;
      }
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateNewEntranceView
 * JD-Core Version:    0.7.0.1
 */