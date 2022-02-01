package com.tencent.mobileqq.forward;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.MaxHeightRelativelayout;

public abstract class ForwardPreviewBaseController
{
  protected Context a;
  protected View a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected QQCustomDialog a;
  protected MaxHeightRelativelayout a;
  
  public ForwardPreviewBaseController(QQCustomDialog paramQQCustomDialog)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = paramQQCustomDialog;
    this.jdField_a_of_type_AndroidContentContext = paramQQCustomDialog.getContext();
    a();
    this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout.setMaxHeight(Math.max(paramQQCustomDialog.getRootViewHeight() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297133), AIOUtils.a(a(), this.jdField_a_of_type_AndroidContentContext.getResources())));
  }
  
  protected int a()
  {
    return 380;
  }
  
  protected abstract View a();
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559065, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380831));
    this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout = ((MaxHeightRelativelayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377207));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368997));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377241));
    View localView = a();
    if (localView != null) {
      this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout.addView(localView);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ForwardPreviewBaseController.1(this));
    int i = ViewUtils.a(15.0F);
    AIOUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, i, i, i, i);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131704796));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public View b()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void b()
  {
    c();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.removePreviewView();
  }
  
  protected void c() {}
  
  protected void d()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPreviewBaseController
 * JD-Core Version:    0.7.0.1
 */