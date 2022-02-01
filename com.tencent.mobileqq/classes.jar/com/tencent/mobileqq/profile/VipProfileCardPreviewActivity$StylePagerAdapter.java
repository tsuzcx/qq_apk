package com.tencent.mobileqq.profile;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.widget.ProfileCardScrollImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class VipProfileCardPreviewActivity$StylePagerAdapter
  extends PagerAdapter
{
  public Context a;
  public LayoutInflater a;
  
  public VipProfileCardPreviewActivity$StylePagerAdapter(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("destroyItem, pos = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, ((StringBuilder)localObject).toString());
    }
    paramObject = (View)paramObject;
    Object localObject = (VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)paramObject.getTag();
    paramViewGroup.removeView(paramObject);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.jdField_a_of_type_JavaUtilList.size();
  }
  
  @TargetApi(16)
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("instantiateItem, pos = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562032, paramViewGroup, false);
    VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder localViewHolder = new VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder(this);
    localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView = ((ProfileCardScrollImageView)((View)localObject1).findViewById(2131367435));
    localViewHolder.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView = ((HiBoomTextView)((View)localObject1).findViewById(2131368173));
    ((View)localObject1).setTag(localViewHolder);
    localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    Object localObject2 = (RelativeLayout.LayoutParams)localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).width = this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.z;
    ((RelativeLayout.LayoutParams)localObject2).height = this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.y;
    localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    if (Build.VERSION.SDK_INT >= 16) {
      localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView.setBackground(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    } else {
      localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847650);
    localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView.setImageDrawable((Drawable)localObject2);
    ((View)localObject1).setId(paramInt);
    localObject2 = (ProfileCardTemplateInfo)this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramViewGroup.addView((View)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a(localViewHolder, (ProfileCardTemplateInfo)localObject2, paramInt);
    return localObject1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.StylePagerAdapter
 * JD-Core Version:    0.7.0.1
 */