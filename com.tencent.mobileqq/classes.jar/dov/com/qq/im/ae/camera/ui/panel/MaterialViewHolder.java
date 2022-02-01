package dov.com.qq.im.ae.camera.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.view.AEDownLoadingView;

public class MaterialViewHolder
  extends RecyclerView.ViewHolder
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  public ImageView a;
  public RelativeLayout a;
  public URLImageView a;
  public AEDownLoadingView a;
  public ImageView b;
  public ImageView c;
  
  public MaterialViewHolder(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131379308));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377719));
    this.b = ((ImageView)paramView.findViewById(2131366026));
    this.c = ((ImageView)paramView.findViewById(2131379719));
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView = ((AEDownLoadingView)paramView.findViewById(2131373580));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131381806));
  }
  
  private static int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 0;
    }
    return 8;
  }
  
  private void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    c(paramAEMaterialMetaData);
    e(paramAEMaterialMetaData);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(a(paramAEMaterialMetaData.a));
  }
  
  private void c(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData.a())
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      return;
    }
    if (paramAEMaterialMetaData.jdField_e_of_type_Boolean)
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      return;
    }
    if (paramAEMaterialMetaData.f)
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgress(paramAEMaterialMetaData.jdField_e_of_type_Int);
      return;
    }
    this.b.setVisibility(0);
    this.b.setImageResource(2130844722);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
  }
  
  private void d(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844766);
    c(paramAEMaterialMetaData);
    e(paramAEMaterialMetaData);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(a(paramAEMaterialMetaData.a));
  }
  
  private void e(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData.a())
    {
      this.c.setVisibility(0);
      this.c.setImageResource(2130846263);
      return;
    }
    if (paramAEMaterialMetaData.b())
    {
      this.c.setVisibility(0);
      this.c.setImageResource(paramAEMaterialMetaData.a());
      return;
    }
    this.c.setVisibility(8);
  }
  
  private void f(AEMaterialMetaData paramAEMaterialMetaData)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      a(paramAEMaterialMetaData);
      return;
    case 0: 
      a(paramAEMaterialMetaData);
      return;
    case 1: 
      b(paramAEMaterialMetaData);
      g(paramAEMaterialMetaData);
      return;
    }
    d(paramAEMaterialMetaData);
    g(paramAEMaterialMetaData);
  }
  
  private void g(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (TextUtils.isEmpty(paramAEMaterialMetaData.c)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int i = AIOUtils.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844721);
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mRetryCount = 3;
    paramAEMaterialMetaData = URLDrawable.getDrawable(paramAEMaterialMetaData.c, localURLDrawableOptions);
    if (paramAEMaterialMetaData.getStatus() == 2) {
      paramAEMaterialMetaData.restartDownload();
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramAEMaterialMetaData);
  }
  
  public void a(int paramInt, AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.jdField_a_of_type_Int = paramInt;
    f(paramAEMaterialMetaData);
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    int i = AIOUtils.a(6.0F, paramContext.getResources());
    int j = AIOUtils.a(2.0F, paramContext.getResources());
    int k = AIOUtils.a(16.0F, paramContext.getResources());
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setBgCorner(k / 2);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setMinimumHeight(k);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setMinimumWidth(k);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgressSizeAndMode(i, j, false);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setBgColor(-1);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgressColor(-16725252);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.MaterialViewHolder
 * JD-Core Version:    0.7.0.1
 */