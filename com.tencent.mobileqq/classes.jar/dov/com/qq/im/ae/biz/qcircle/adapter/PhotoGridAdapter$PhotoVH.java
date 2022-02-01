package dov.com.qq.im.ae.biz.qcircle.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.NumberCheckBox;

public class PhotoGridAdapter$PhotoVH
  extends RecyclerView.ViewHolder
{
  public View a;
  public ImageView a;
  public TextView a;
  public URLDrawable a;
  public NumberCheckBox a;
  public PhotoGridAdapter.PhotoItemClickListener a;
  public ImageView b;
  public TextView b;
  public ImageView c;
  
  public PhotoGridAdapter$PhotoVH(PhotoGridAdapter paramPhotoGridAdapter, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373068));
    this.b = ((ImageView)paramView.findViewById(2131369374));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373070);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131373071));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373075));
    this.c = ((ImageView)paramView.findViewById(2131372993));
    if (this.c != null) {
      this.c.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox != null) {
      ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.adapter.PhotoGridAdapter.PhotoVH
 * JD-Core Version:    0.7.0.1
 */