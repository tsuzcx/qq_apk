package com.tencent.mobileqq.vip.diy.common;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.util.URLUtil;
import cooperation.vip.jsoninflate.model.ViewModel;

public class DIYImageViewModule
  extends ViewModel
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private String jdField_a_of_type_JavaLangString;
  
  public DIYImageViewModule(String paramString1, View paramView, @NonNull String paramString2)
  {
    super(paramString1, paramView);
    if ((paramView != null) && ((paramView instanceof DIYImageView))) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((DIYImageView)paramView).a();
    }
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  private ImageView.ScaleType a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return ImageView.ScaleType.CENTER_CROP;
    }
    if ("center_crop".equals(paramString)) {
      return ImageView.ScaleType.CENTER_CROP;
    }
    if ("fit_center".equals(paramString)) {
      return ImageView.ScaleType.FIT_CENTER;
    }
    return ImageView.ScaleType.CENTER_CROP;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
        return;
      }
      if ((this.jdField_a_of_type_AndroidViewView.getParent() != null) && ((this.jdField_a_of_type_AndroidViewView.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).setClipChildren(false);
      }
      ViewGroup.LayoutParams localLayoutParams1 = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      ViewGroup.LayoutParams localLayoutParams2 = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if ((localLayoutParams1 != null) && (localLayoutParams2 != null))
      {
        localLayoutParams2.width = localLayoutParams1.width;
        localLayoutParams2.height = localLayoutParams1.height;
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams2);
      }
    }
  }
  
  protected void a(String paramString)
  {
    Object localObject = paramString;
    if (!paramString.startsWith("http"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    if (!URLUtil.a((String)localObject)) {
      return;
    }
    paramString = URLDrawable.URLDrawableOptions.obtain();
    if ((this.jdField_a_of_type_Int > 0) && (this.b > 0))
    {
      paramString.mRequestWidth = this.jdField_a_of_type_Int;
      paramString.mRequestHeight = this.b;
    }
    paramString.mLoadingDrawable = URLDrawableHelperConstants.a;
    paramString.mFailedDrawable = URLDrawableHelperConstants.a;
    paramString.mPlayGifImage = false;
    paramString = URLDrawable.getDrawable((String)localObject, paramString);
    if (paramString != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (!(this.jdField_a_of_type_AndroidViewView instanceof DIYImageView))
    {
      AssertUtils.fail("JsonInflateViewModel current view type illegal!", new Object[0]);
      return;
    }
    if ("content".equals(paramString1))
    {
      a(paramString2);
      return;
    }
    if ("scale_type".equals(paramString1)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(a(paramString2));
    }
  }
  
  protected void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.common.DIYImageViewModule
 * JD-Core Version:    0.7.0.1
 */