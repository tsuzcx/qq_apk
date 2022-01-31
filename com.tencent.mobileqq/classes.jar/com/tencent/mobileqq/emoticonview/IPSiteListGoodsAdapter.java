package com.tencent.mobileqq.emoticonview;

import acgf;
import acgg;
import acgh;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.IPSiteModel.Goods;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class IPSiteListGoodsAdapter
  extends BaseAdapter
{
  private static int jdField_a_of_type_Int = 6;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener;
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  private String b;
  private String c;
  
  public IPSiteListGoodsAdapter(Context paramContext, List paramList, URLDrawable.URLDrawableListener paramURLDrawableListener, Drawable paramDrawable, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = paramURLDrawableListener;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      if (i > jdField_a_of_type_Int) {
        return jdField_a_of_type_Int + 1;
      }
      return i + 1;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt < getCount() - 1)
    {
      localObject2 = (IPSiteModel.Goods)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968967, null, false);
        paramViewGroup = new acgh(this, null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364519));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364521));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131364522));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        if (localObject2 != null)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(VasUtils.a(((IPSiteModel.Goods)localObject2).cover, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((IPSiteModel.Goods)localObject2).name);
          localObject1 = "0";
          if (!TextUtils.isEmpty(((IPSiteModel.Goods)localObject2).saleNum)) {
            localObject1 = ((IPSiteModel.Goods)localObject2).saleNum;
          }
          paramViewGroup.b.setText((String)localObject1 + "人已拥有");
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new acgf(this, (IPSiteModel.Goods)localObject2));
        }
        return paramView;
        paramViewGroup = (acgh)paramView.getTag();
      }
    }
    paramView = (IPSiteModel.Goods)this.jdField_a_of_type_JavaUtilList.get(0);
    paramViewGroup = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    paramViewGroup.setBackgroundColor(Color.parseColor("#fafafa"));
    Object localObject1 = new AbsListView.LayoutParams(AIOUtils.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramViewGroup.setMinimumWidth(AIOUtils.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramViewGroup.setMinimumHeight(AIOUtils.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131362323);
    ((TextView)localObject2).setTextSize(12.0F);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setText("发现更多");
    ((TextView)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localImageView.setImageResource(2130843961);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(1, 2131362323);
    localLayoutParams.addRule(15);
    localLayoutParams.leftMargin = AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localImageView.setLayoutParams(localLayoutParams);
    ((RelativeLayout)localObject1).addView((View)localObject2);
    ((RelativeLayout)localObject1).addView(localImageView);
    paramViewGroup.addView((View)localObject1);
    paramViewGroup.setOnClickListener(new acgg(this, paramView));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.IPSiteListGoodsAdapter
 * JD-Core Version:    0.7.0.1
 */