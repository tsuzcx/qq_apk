package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.filemanager.fileviewer.ImageGalleryAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.ImageFileInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.DragView;
import com.tencent.widget.DragView.OnGestureChangeListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class PictureFileViewer
  extends FileBrowserViewBase
{
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private DragGallery jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery;
  private ImageGalleryAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerImageGalleryAdapter;
  private DragView.OnGestureChangeListener jdField_a_of_type_ComTencentWidgetDragView$OnGestureChangeListener = new PictureFileViewer.1(this);
  private DragView jdField_a_of_type_ComTencentWidgetDragView;
  private boolean jdField_a_of_type_Boolean = false;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  
  public PictureFileViewer(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: PictureFileViewer initFileView");
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131560839, this.jdField_a_of_type_AndroidViewViewGroup, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366800));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery = ((DragGallery)this.jdField_a_of_type_AndroidViewView.findViewById(2131367431));
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131366044));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerImageGalleryAdapter = new ImageGalleryAdapter(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerImageGalleryAdapter);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnNoBlankListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerImageGalleryAdapter);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSpacing(this.jdField_a_of_type_AndroidViewView.getResources().getDimensionPixelSize(2131297150));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372126));
      this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365892));
      Rect localRect = a();
      if (localRect != null)
      {
        localRect.top -= ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
        localRect.bottom -= ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
      }
      this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(localRect);
      this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(true);
      this.jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener(this.jdField_a_of_type_ComTencentWidgetDragView$OnGestureChangeListener);
    }
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    if (paramOnItemClickListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnItemClickListener(paramOnItemClickListener);
    }
  }
  
  public void a(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    if (paramOnItemLongClickListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnItemLongClickListener(paramOnItemLongClickListener);
    }
  }
  
  public void a(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    if (paramOnItemSelectedListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setOnItemSelectedListener(paramOnItemSelectedListener);
    }
  }
  
  public void a(List<FileBrowserModelBase.ImageFileInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerImageGalleryAdapter.a(paramList);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerImageGalleryAdapter.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      int j = 0;
      int i;
      if ((paramBoolean) && (!this.c)) {
        i = 1;
      } else {
        i = 0;
      }
      LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (i != 0) {
        i = j;
      } else {
        i = 8;
      }
      localLinearLayout.setVisibility(i);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(paramOnClickListener);
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool;
    if ((paramBoolean) && (!this.c)) {
      bool = true;
    } else {
      bool = false;
    }
    super.b(bool);
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    ImageGalleryAdapter localImageGalleryAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerImageGalleryAdapter;
    if (localImageGalleryAdapter != null) {
      localImageGalleryAdapter.notifyDataSetChanged();
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSelection(paramInt);
  }
  
  public void c(boolean paramBoolean)
  {
    ImageButton localImageButton = this.jdField_a_of_type_AndroidWidgetImageButton;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageButton.setVisibility(i);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.reset();
  }
  
  public void d(boolean paramBoolean)
  {
    DragView localDragView;
    if (paramBoolean)
    {
      localDragView = this.jdField_a_of_type_ComTencentWidgetDragView;
      if (localDragView != null) {
        localDragView.setOriginRect(a());
      }
    }
    else
    {
      localDragView = this.jdField_a_of_type_ComTencentWidgetDragView;
      if (localDragView != null) {
        localDragView.setOriginRect(null);
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetDragView != null)
    {
      Rect localRect = a();
      if (localRect != null)
      {
        int i;
        if (!paramBoolean)
        {
          localRect.top -= ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
          localRect.bottom -= ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
          if ((LiuHaiUtils.c) && (LiuHaiUtils.jdField_a_of_type_Boolean))
          {
            i = LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity);
            localRect.top += i;
            localRect.bottom += i;
          }
        }
        else
        {
          localRect.top += ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
          localRect.bottom += ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
          if ((LiuHaiUtils.c) && (LiuHaiUtils.jdField_a_of_type_Boolean))
          {
            i = LiuHaiUtils.b(this.jdField_a_of_type_AndroidAppActivity);
            localRect.top -= i;
            localRect.bottom -= i;
          }
        }
        this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(localRect);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.PictureFileViewer
 * JD-Core Version:    0.7.0.1
 */