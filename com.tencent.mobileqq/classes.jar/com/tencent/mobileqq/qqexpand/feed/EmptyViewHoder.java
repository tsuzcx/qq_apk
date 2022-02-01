package com.tencent.mobileqq.qqexpand.feed;

import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qqexpand.fragment.SquareItemClickListener;
import com.tencent.mobileqq.qqexpand.utils.ExpandResourceUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import java.io.File;

public class EmptyViewHoder
  extends RecyclerView.ViewHolder
  implements View.OnTouchListener
{
  private final int jdField_a_of_type_Int;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private final SquareItemClickListener jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener;
  private final int b;
  
  public EmptyViewHoder(View paramView, RecyclerView paramRecyclerView, int paramInt1, SquareItemClickListener paramSquareItemClickListener, int paramInt2)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.b = paramInt2;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368343));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378460));
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener = paramSquareItemClickListener;
    paramView.setOnTouchListener(this);
  }
  
  public void a(EmptyViewHoder paramEmptyViewHoder, StrangerInfo paramStrangerInfo, int paramInt)
  {
    paramStrangerInfo = paramEmptyViewHoder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    int i = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getHeight();
    int j = this.jdField_a_of_type_Int;
    paramStrangerInfo.height = (i - j);
    if ((paramStrangerInfo instanceof RecyclerView.LayoutParams)) {
      ((RecyclerView.LayoutParams)paramStrangerInfo).topMargin = j;
    }
    paramStrangerInfo = URLDrawable.URLDrawableOptions.obtain();
    paramStrangerInfo.mLoadingDrawable = URLDrawableHelperConstants.a;
    paramStrangerInfo.mFailedDrawable = URLDrawableHelperConstants.a;
    paramStrangerInfo = ExpandResourceUtil.a("expand_square_blank.png");
    if (new File(paramStrangerInfo).exists())
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      paramStrangerInfo = ExpandResourceUtil.a(paramStrangerInfo, localOptions);
      paramEmptyViewHoder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new BitmapDrawable(paramStrangerInfo));
    }
    if (paramInt == 1)
    {
      if (this.b == 0) {
        paramInt = 2131698816;
      } else {
        paramInt = 2131698812;
      }
    }
    else if (this.b == 0) {
      paramInt = 2131698815;
    } else {
      paramInt = 2131698811;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener != null) && (paramMotionEvent.getAction() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener.e();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.feed.EmptyViewHoder
 * JD-Core Version:    0.7.0.1
 */