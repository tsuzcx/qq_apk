package com.tencent.mobileqq.extendfriend.bean;

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
import com.tencent.mobileqq.extendfriend.fragment.SquareItemClickListener;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendResourceUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import java.io.File;

public class EmptyViewHoder
  extends RecyclerView.ViewHolder
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private SquareItemClickListener jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener;
  private int b;
  
  public EmptyViewHoder(View paramView, RecyclerView paramRecyclerView, int paramInt1, SquareItemClickListener paramSquareItemClickListener, int paramInt2)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.b = paramInt2;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368603));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379091));
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener = paramSquareItemClickListener;
    paramView.setOnTouchListener(this);
  }
  
  public void a(EmptyViewHoder paramEmptyViewHoder, StrangerInfo paramStrangerInfo, int paramInt)
  {
    paramStrangerInfo = paramEmptyViewHoder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    paramStrangerInfo.height = (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getHeight() - this.jdField_a_of_type_Int);
    if ((paramStrangerInfo instanceof RecyclerView.LayoutParams)) {
      ((RecyclerView.LayoutParams)paramStrangerInfo).topMargin = this.jdField_a_of_type_Int;
    }
    paramStrangerInfo = URLDrawable.URLDrawableOptions.obtain();
    paramStrangerInfo.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    paramStrangerInfo.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    paramStrangerInfo = ExtendFriendResourceUtil.a("expand_square_blank.png");
    if (new File(paramStrangerInfo).exists())
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      paramStrangerInfo = ExtendFriendResourceUtil.a(paramStrangerInfo, localOptions);
      paramEmptyViewHoder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new BitmapDrawable(paramStrangerInfo));
    }
    if (paramInt == 1) {
      if (this.b == 0) {
        paramInt = 2131698741;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
      return;
      paramInt = 2131698737;
      continue;
      if (this.b == 0) {
        paramInt = 2131698740;
      } else {
        paramInt = 2131698736;
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener != null) && (paramMotionEvent.getAction() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener.e();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.bean.EmptyViewHoder
 * JD-Core Version:    0.7.0.1
 */