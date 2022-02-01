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
  private static final String b = "BannerAdapter";
  private Context c;
  private int d;
  private int e;
  private BannerAdapter.OnBannerClickListener f;
  
  private void a(LinearLayout paramLinearLayout, int paramInt, DiscoveryBannerInfo paramDiscoveryBannerInfo)
  {
    if (paramDiscoveryBannerInfo != null)
    {
      if (paramLinearLayout == null) {
        return;
      }
      paramLinearLayout = (KandianUrlImageView)paramLinearLayout.findViewById(2131431969);
      Object localObject1 = paramLinearLayout.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = this.d;
      ((ViewGroup.LayoutParams)localObject1).height = this.e;
      paramLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramLinearLayout.setTag(paramDiscoveryBannerInfo);
      paramLinearLayout.setOnClickListener(this);
      try
      {
        localObject1 = new ColorDrawable(Color.parseColor("#E8E8E7"));
        if (!TextUtils.isEmpty(paramDiscoveryBannerInfo.b))
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.d;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.e;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
          paramLinearLayout.setImageDrawable(URLDrawable.getDrawable(paramDiscoveryBannerInfo.b, (URLDrawable.URLDrawableOptions)localObject2));
          return;
        }
        paramLinearLayout.setImageDrawable((Drawable)localObject1);
        if (QLog.isColorLevel())
        {
          paramLinearLayout = b;
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
          localObject1 = b;
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
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(this.c).inflate(2131626365, null);
    a(localLinearLayout, paramInt, paramDiscoveryBannerInfo);
    return localLinearLayout;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131431969) {
      return;
    }
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof DiscoveryBannerInfo)))
    {
      BannerAdapter.OnBannerClickListener localOnBannerClickListener = this.f;
      if (localOnBannerClickListener != null) {
        localOnBannerClickListener.a(paramView, (DiscoveryBannerInfo)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.discovery.BannerAdapter
 * JD-Core Version:    0.7.0.1
 */