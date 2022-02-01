package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.search.model.NetSearchSubItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateNetSeaEntranceItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;
import java.util.List;

public class NetSearchTemplateNetSeaEntranceView
  extends NetSearchTemplateBaseView
{
  public View a;
  public LinearLayout a;
  public TextView a;
  public URLImageView a;
  public ArrayList<NetSearchTemplateNetSeaEntranceView.NetSearchSubView> a;
  public LinearLayout b;
  public TextView b;
  public URLImageView b;
  public TextView c;
  
  public NetSearchTemplateNetSeaEntranceView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  protected void a()
  {
    View localView = a(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131366394));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131368729));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379432));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378646));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365699));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131377091));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131369130);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131378637));
  }
  
  public void a(NetSearchTemplateNetSeaEntranceItem paramNetSearchTemplateNetSeaEntranceItem)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if ((paramNetSearchTemplateNetSeaEntranceItem.a == null) || (paramNetSearchTemplateNetSeaEntranceItem.a.size() == 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    Context localContext = this.jdField_b_of_type_AndroidWidgetLinearLayout.getContext();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    int i = 0;
    label92:
    NetSearchTemplateNetSeaEntranceView.NetSearchSubView localNetSearchSubView;
    if (i < paramNetSearchTemplateNetSeaEntranceItem.a.size())
    {
      NetSearchSubItem localNetSearchSubItem = (NetSearchSubItem)paramNetSearchTemplateNetSeaEntranceItem.a.get(i);
      localNetSearchSubView = new NetSearchTemplateNetSeaEntranceView.NetSearchSubView(this, localContext);
      if (TextUtils.isEmpty(localNetSearchSubItem.a)) {
        break label350;
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.a(localContext, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.a(localContext, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(localNetSearchSubItem.a, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.a);
      localNetSearchSubView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      localNetSearchSubView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label251:
      if (TextUtils.isEmpty(localNetSearchSubItem.b)) {
        break label363;
      }
      localNetSearchSubView.jdField_a_of_type_AndroidWidgetTextView.setText(localNetSearchSubItem.b);
      localNetSearchSubView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label284:
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break label376;
      }
      localNetSearchSubView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#112037"));
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localNetSearchSubView.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_JavaUtilArrayList.add(localNetSearchSubView);
      i += 1;
      break label92;
      break;
      label350:
      localNetSearchSubView.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label251;
      label363:
      localNetSearchSubView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label284;
      label376:
      localNetSearchSubView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#E6E6E6"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateNetSeaEntranceView
 * JD-Core Version:    0.7.0.1
 */