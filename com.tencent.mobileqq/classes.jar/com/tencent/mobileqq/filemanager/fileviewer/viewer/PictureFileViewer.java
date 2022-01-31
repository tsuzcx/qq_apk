package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.ImageGalleryAdapter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.Gallery;
import java.util.List;

public class PictureFileViewer
  extends FileBrowserViewBase
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ImageGalleryAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerImageGalleryAdapter;
  private Gallery jdField_a_of_type_ComTencentWidgetGallery;
  
  public PictureFileViewer(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: PictureFileViewer initFileView");
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130970033, this.jdField_a_of_type_AndroidViewViewGroup, false);
      this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)this.jdField_a_of_type_AndroidViewView.findViewById(2131364774));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerImageGalleryAdapter = new ImageGalleryAdapter(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerImageGalleryAdapter);
      this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(this.jdField_a_of_type_AndroidViewView.getResources().getDimensionPixelSize(2131558524));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368801));
    }
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    if (paramOnItemClickListener != null) {
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(paramOnItemClickListener);
    }
  }
  
  public void a(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    if (paramOnItemSelectedListener != null) {
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(paramOnItemSelectedListener);
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerImageGalleryAdapter.a(paramList);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerImageGalleryAdapter.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    LinearLayout localLinearLayout;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      return;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(paramInt);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerImageGalleryAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerImageGalleryAdapter.notifyDataSetChanged();
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentWidgetGallery.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.PictureFileViewer
 * JD-Core Version:    0.7.0.1
 */