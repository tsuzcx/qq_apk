package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.FormResHelper;

public class TroopAppFormItem
  extends RelativeLayout
{
  int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  String jdField_a_of_type_JavaLangString = "";
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString = "";
  
  public TroopAppFormItem(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  protected Drawable a(Resources paramResources, int paramInt)
  {
    return FormResHelper.a(paramResources, paramInt, false);
  }
  
  public void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131560731, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372115));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378645));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370307));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131377113);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)localView.findViewById(2131368729));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(DisplayUtil.a(getContext(), 4.0F));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368834));
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    setBackgroundDrawable(a(getResources(), paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAppFormItem
 * JD-Core Version:    0.7.0.1
 */