package dov.com.qq.im.ae.camera.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.view.AEDownLoadingView;

public class AEMaterialWaterMarkViewHolder
  extends RecyclerView.ViewHolder
{
  private Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  AEDownLoadingView jdField_a_of_type_DovComQqImAeViewAEDownLoadingView;
  public View b;
  ImageView b;
  ImageView c;
  ImageView d;
  ImageView e;
  
  public AEMaterialWaterMarkViewHolder(View paramView, Context paramContext)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131379308));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365998));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365994));
    this.c = ((ImageView)paramView.findViewById(2131370733));
    this.d = ((ImageView)paramView.findViewById(2131370736));
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView = ((AEDownLoadingView)paramView.findViewById(2131373580));
    this.e = ((ImageView)paramView.findViewById(2131377737));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131381806);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131381807);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    int i = AIOUtils.a(6.0F, this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.getResources());
    int j = AIOUtils.a(2.0F, this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.getResources());
    int k = AIOUtils.a(16.0F, this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.getResources());
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setBgCorner(k / 2);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setMinimumHeight(k);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setMinimumWidth(k);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgressSizeAndMode(i, j, false);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setBgColor(0);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgressColor(-1);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.a(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (TextUtils.isEmpty(paramAEMaterialMetaData.c)) {
      return;
    }
    UIUtils.a(this.jdField_a_of_type_ComTencentImageURLImageView, paramAEMaterialMetaData.c, UIUtils.a(this.jdField_a_of_type_ComTencentImageURLImageView.getContext(), 67.0F), UIUtils.a(this.jdField_a_of_type_ComTencentImageURLImageView.getContext(), 67.0F), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837652), null);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(paramInt);
    this.c.setVisibility(paramInt);
    this.d.setVisibility(paramInt);
  }
  
  public void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData.a())
    {
      a(8);
      b(8);
      return;
    }
    if (paramAEMaterialMetaData.jdField_e_of_type_Boolean)
    {
      a(8);
      b(8);
      return;
    }
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
    {
      AEQLog.d("AEMaterialWaterMarkViewHolder", "net work not available");
      a(0);
      b(8);
      return;
    }
    if (paramAEMaterialMetaData.f)
    {
      a(8);
      b(0);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgress(paramAEMaterialMetaData.jdField_e_of_type_Int);
      return;
    }
    a(0);
    b(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialWaterMarkViewHolder
 * JD-Core Version:    0.7.0.1
 */