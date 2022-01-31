package com.tencent.mobileqq.nearby.picbrowser;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;

public class NearbyProfilePicBrowserGalleryScene
  extends PicBrowserGalleryScene
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  
  public NearbyProfilePicBrowserGalleryScene(PicBrowserActivity paramPicBrowserActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    super(paramPicBrowserActivity, paramAbstractImageListModel);
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130969131, null);
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    super.b(paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365282));
    this.b = ((TextView)paramViewGroup.findViewById(2131365283));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b.setOnClickListener(this);
  }
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.b(paramAdapterView, paramView, paramInt, paramLong);
    c(paramInt);
  }
  
  protected void c(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a() <= 1)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.b.setVisibility(8);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void j()
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a();
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int < localArrayList.size())) {
      localArrayList.add(0, (PicInfo)localArrayList.remove(this.jdField_a_of_type_Int));
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("intent_param_pic_infos", localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.setResult(-1, localIntent);
    super.j();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131365282: 
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.b();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131437402), 0).a();
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.b();
    if (i < this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_Int -= 1;
    }
    for (;;)
    {
      g();
      c(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.b());
      return;
      if (i == this.jdField_a_of_type_Int) {
        if (i == this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a() - 1) {
          this.jdField_a_of_type_Int = (i - 1);
        } else {
          this.jdField_a_of_type_Int = i;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserGalleryScene
 * JD-Core Version:    0.7.0.1
 */