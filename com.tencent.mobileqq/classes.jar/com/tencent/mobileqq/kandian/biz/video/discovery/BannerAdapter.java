package com.tencent.mobileqq.kandian.biz.video.discovery;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.qphone.base.util.QLog;

public class BannerAdapter
  extends BannerView.BannerViewAdapter<DiscoveryBannerInfo, LinearLayout>
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "BannerAdapter";
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private BannerAdapter.OnBannerClickListener jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerAdapter$OnBannerClickListener;
  private int b;
  
  private void a(LinearLayout paramLinearLayout, int paramInt, DiscoveryBannerInfo paramDiscoveryBannerInfo)
  {
    if (paramDiscoveryBannerInfo != null)
    {
      if (paramLinearLayout == null) {
        return;
      }
      paramLinearLayout = (KandianUrlImageView)paramLinearLayout.findViewById(2131365727);
      Object localObject1 = paramLinearLayout.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = this.jdField_a_of_type_Int;
      ((ViewGroup.LayoutParams)localObject1).height = this.b;
      paramLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramLinearLayout.setTag(paramDiscoveryBannerInfo);
      paramLinearLayout.setOnClickListener(this);
      try
      {
        localObject1 = new ColorDrawable(Color.parseColor("#E8E8E7"));
        if (!TextUtils.isEmpty(paramDiscoveryBannerInfo.jdField_a_of_type_JavaLangString))
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_Int;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.b;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
          paramLinearLayout.setImageDrawable(URLDrawable.getDrawable(paramDiscoveryBannerInfo.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2));
          return;
        }
        paramLinearLayout.setImageDrawable((Drawable)localObject1);
        if (QLog.isColorLevel())
        {
          paramLinearLayout = jdField_a_of_type_JavaLangString;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("banner cover url is null, banner info: ");
          ((StringBuilder)localObject1).append(paramDiscoveryBannerInfo.toString());
          QLog.d(paramLinearLayout, 2, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      catch (Exception paramLinearLayout)
      {
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("轮播图的url格式有问题, ");
          ((StringBuilder)localObject2).append(paramDiscoveryBannerInfo.toString());
          ((StringBuilder)localObject2).append(", ");
          ((StringBuilder)localObject2).append(paramLinearLayout.getMessage());
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
  }
  
  public LinearLayout a(int paramInt, DiscoveryBannerInfo paramDiscoveryBannerInfo)
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560319, null);
    a(localLinearLayout, paramInt, paramDiscoveryBannerInfo);
    return localLinearLayout;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131365727) {
      return;
    }
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof DiscoveryBannerInfo)))
    {
      BannerAdapter.OnBannerClickListener localOnBannerClickListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBannerAdapter$OnBannerClickListener;
      if (localOnBannerClickListener != null) {
        localOnBannerClickListener.a(paramView, (DiscoveryBannerInfo)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.discovery.BannerAdapter
 * JD-Core Version:    0.7.0.1
 */