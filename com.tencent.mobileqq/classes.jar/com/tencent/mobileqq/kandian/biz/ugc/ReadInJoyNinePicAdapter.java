package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyNinePicDeliverDynamicGridView.BaseDynamicGridAdapter;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import java.io.File;
import java.util.ArrayList;

public class ReadInJoyNinePicAdapter
  extends ReadInJoyNinePicDeliverDynamicGridView.BaseDynamicGridAdapter
  implements View.OnTouchListener
{
  private ReadInJoyNinePicAdapter.OnDeleteClickListener jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter$OnDeleteClickListener;
  private ReadInJoyNinePicAdapter.OnPicTouchListener jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter$OnPicTouchListener;
  
  ReadInJoyNinePicAdapter(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private Drawable a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(paramString);
      if (localFile.exists())
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mPlayGifImage = BaseImageUtil.b(paramString);
        localURLDrawableOptions.mLoadingDrawable = ReadInJoyDeliverUGCActivity.a;
        localURLDrawableOptions.mFailedDrawable = ReadInJoyDeliverUGCActivity.a;
        localURLDrawableOptions.mUseAutoScaleParams = false;
        localURLDrawableOptions.mRequestWidth = ViewUtils.b(114.0F);
        localURLDrawableOptions.mRequestHeight = ViewUtils.b(114.0F);
        return URLDrawable.getDrawable(localFile, localURLDrawableOptions);
      }
    }
    return null;
  }
  
  void a(ReadInJoyNinePicAdapter.OnDeleteClickListener paramOnDeleteClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter$OnDeleteClickListener = paramOnDeleteClickListener;
  }
  
  void a(ReadInJoyNinePicAdapter.OnPicTouchListener paramOnPicTouchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter$OnPicTouchListener = paramOnPicTouchListener;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560303, null);
      paramViewGroup = new ReadInJoyNinePicAdapter.NinePicViewHolder(this, null);
      paramViewGroup.a = ((ImageView)paramView.findViewById(2131380118));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131380115));
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (ReadInJoyNinePicAdapter.NinePicViewHolder)paramView.getTag();
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((localObject instanceof HotPicData))
    {
      localObject = ReadInJoyDeliverUGCActivity.a((HotPicData)localObject);
      if (localObject != null)
      {
        paramViewGroup.b.setImageDrawable((Drawable)localObject);
        paramViewGroup.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramViewGroup.a.setVisibility(0);
      }
    }
    else if ("".equals(localObject))
    {
      paramViewGroup.b.setImageResource(2130841790);
      paramViewGroup.b.setScaleType(ImageView.ScaleType.CENTER);
      paramViewGroup.a.setVisibility(8);
    }
    else
    {
      localObject = a((String)localObject);
      if (localObject != null)
      {
        paramViewGroup.b.setImageDrawable((Drawable)localObject);
        paramViewGroup.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramViewGroup.a.setVisibility(0);
      }
    }
    paramViewGroup.b.setTag(Integer.valueOf(paramInt));
    paramViewGroup.a.setTag(Integer.valueOf(paramInt));
    paramViewGroup.b.setOnTouchListener(this);
    paramViewGroup.a.setOnClickListener(new ReadInJoyNinePicAdapter.1(this));
    return paramView;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ReadInJoyNinePicAdapter.OnPicTouchListener localOnPicTouchListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyNinePicAdapter$OnPicTouchListener;
    if (localOnPicTouchListener != null) {
      return localOnPicTouchListener.a(paramView, paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyNinePicAdapter
 * JD-Core Version:    0.7.0.1
 */