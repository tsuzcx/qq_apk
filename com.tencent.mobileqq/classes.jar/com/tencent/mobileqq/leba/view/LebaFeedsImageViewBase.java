package com.tencent.mobileqq.leba.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.LebaFeedInfo;
import com.tencent.mobileqq.leba.LebaFeedsAdapter.ListItem;
import com.tencent.mobileqq.leba.UITemplate.PicUITemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public abstract class LebaFeedsImageViewBase
  extends LebaFeedsNativeViewBase
{
  protected int a;
  protected LebaFeedsGridLayout a;
  protected List a;
  protected int b;
  
  public LebaFeedsImageViewBase(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsGridLayout = new LebaFeedsGridLayout(getContext());
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsGridLayout.setItemMargin(AIOUtils.a(2.0F, getResources()), AIOUtils.a(2.0F, getResources()));
    this.a.addView(this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsGridLayout, new ViewGroup.LayoutParams(-1, -2));
    b();
    a();
  }
  
  public abstract int a();
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(a());
    int i = 0;
    while (i < a())
    {
      URLImageView localURLImageView = new URLImageView(getContext());
      localURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_JavaUtilList.add(localURLImageView);
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsGridLayout.addView(localURLImageView, new LebaFeedsGridLayout.LayoutParams(this.jdField_a_of_type_Int, this.b));
      i += 1;
    }
  }
  
  public void a(LebaFeedsAdapter.ListItem paramListItem)
  {
    super.a(paramListItem);
    if (paramListItem == null) {}
    do
    {
      return;
      paramListItem = paramListItem.a;
    } while (paramListItem == null);
    int i;
    label47:
    URLImageView localURLImageView;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if ((paramListItem.templateInfo != null) && ((paramListItem.templateInfo instanceof PicUITemplateInfo)))
    {
      PicUITemplateInfo localPicUITemplateInfo = (PicUITemplateInfo)paramListItem.templateInfo;
      i = 0;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localURLImageView = (URLImageView)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localURLImageView != null)
        {
          localURLDrawableOptions = null;
          paramListItem = localURLDrawableOptions;
          if (localPicUITemplateInfo.jdField_a_of_type_JavaUtilList != null)
          {
            paramListItem = localURLDrawableOptions;
            if (i < localPicUITemplateInfo.jdField_a_of_type_JavaUtilList.size()) {
              paramListItem = (String)localPicUITemplateInfo.jdField_a_of_type_JavaUtilList.get(i);
            }
          }
          if (!TextUtils.isEmpty(paramListItem)) {
            break label154;
          }
          localURLImageView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      QLog.e("LebaFeedsNativeViewBase", 1, "fillData PicUITemplateInfo is null or not instance PicUITemplateInfo");
      return;
      label154:
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Int;
      localURLDrawableOptions.mRequestHeight = this.b;
      localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLImageView.setImageDrawable(URLDrawable.getDrawable(paramListItem, localURLDrawableOptions));
    }
  }
  
  protected abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.view.LebaFeedsImageViewBase
 * JD-Core Version:    0.7.0.1
 */