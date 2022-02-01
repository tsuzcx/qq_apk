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
import com.tencent.mobileqq.picbrowser.PicBrowserActivity;
import com.tencent.mobileqq.picbrowser.PicBrowserGalleryScene;
import com.tencent.mobileqq.picbrowser.PicBrowserModel;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;

public class NearbyProfilePicBrowserGalleryScene
  extends PicBrowserGalleryScene
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  
  public NearbyProfilePicBrowserGalleryScene(PicBrowserActivity paramPicBrowserActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    super(paramPicBrowserActivity, paramAbstractImageListModel);
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131559493, null);
  }
  
  protected void a(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    } else {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.a() <= 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.b.setVisibility(8);
    }
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    super.b(paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131377300));
    this.b = ((TextView)paramViewGroup.findViewById(2131365483));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b.setOnClickListener(this);
  }
  
  public void l()
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.a();
    int i = this.jdField_a_of_type_Int;
    if ((i != 0) && (i < localArrayList.size())) {
      localArrayList.add(0, (PicInfo)localArrayList.remove(this.jdField_a_of_type_Int));
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("intent_param_pic_infos", localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserActivity.setResult(-1, localIntent);
    super.l();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131365483)
    {
      if (i != 2131377300) {
        return;
      }
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.b();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131694414), 0).a();
      return;
    }
    i = this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.b();
    int j = this.jdField_a_of_type_Int;
    if (i < j) {
      this.jdField_a_of_type_Int = (j - 1);
    } else if (i == j) {
      if (i == this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.a() - 1) {
        this.jdField_a_of_type_Int = (i - 1);
      } else {
        this.jdField_a_of_type_Int = i;
      }
    }
    d();
    a(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.b());
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserGalleryScene
 * JD-Core Version:    0.7.0.1
 */