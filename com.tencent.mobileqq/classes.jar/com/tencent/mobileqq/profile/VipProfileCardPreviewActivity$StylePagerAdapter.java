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
  public LayoutInflater a;
  public Context b;
  
  public VipProfileCardPreviewActivity$StylePagerAdapter(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity, Context paramContext)
  {
    this.b = paramContext;
    this.a = LayoutInflater.from(this.b);
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
    return this.c.ah.size();
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
    Object localObject1 = this.a.inflate(2131628458, paramViewGroup, false);
    VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder localViewHolder = new VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder(this);
    localViewHolder.a = ((ProfileCardScrollImageView)((View)localObject1).findViewById(2131433938));
    localViewHolder.b = ((HiBoomTextView)((View)localObject1).findViewById(2131435034));
    ((View)localObject1).setTag(localViewHolder);
    localViewHolder.a.setScaleType(ImageView.ScaleType.FIT_XY);
    Object localObject2 = (RelativeLayout.LayoutParams)localViewHolder.a.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).width = this.c.ak;
    ((RelativeLayout.LayoutParams)localObject2).height = this.c.aj;
    localViewHolder.a.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    if (Build.VERSION.SDK_INT >= 16) {
      localViewHolder.a.setBackground(this.c.H);
    } else {
      localViewHolder.a.setBackgroundDrawable(this.c.H);
    }
    localObject2 = this.b.getResources().getDrawable(2130849310);
    localViewHolder.a.setImageDrawable((Drawable)localObject2);
    ((View)localObject1).setId(paramInt);
    localObject2 = (ProfileCardTemplateInfo)this.c.ah.get(paramInt);
    paramViewGroup.addView((View)localObject1);
    this.c.a(localViewHolder, (ProfileCardTemplateInfo)localObject2, paramInt);
    return localObject1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.StylePagerAdapter
 * JD-Core Version:    0.7.0.1
 */