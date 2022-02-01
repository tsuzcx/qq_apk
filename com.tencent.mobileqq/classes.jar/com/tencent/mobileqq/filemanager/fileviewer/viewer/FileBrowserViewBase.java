package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class FileBrowserViewBase
{
  protected Activity a;
  protected Bundle a;
  protected View a;
  protected ViewGroup a;
  protected ProgressBar a;
  protected RelativeLayout a;
  protected TextView a;
  protected FileBrowserViewBase.CloseFileBrowserCallback a;
  protected View b;
  protected TextView b;
  protected TextView c;
  
  public FileBrowserViewBase(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public Rect a()
  {
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      return (Rect)this.jdField_a_of_type_AndroidOsBundle.getParcelable("file_browser_params_thumb_bound");
    }
    return null;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379776));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131379742));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379752));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366468));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379740);
    }
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
  }
  
  public void a(FileBrowserViewBase.CloseFileBrowserCallback paramCloseFileBrowserCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerFileBrowserViewBase$CloseFileBrowserCallback = paramCloseFileBrowserCallback;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    if (this.c == null) {
      this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372540));
    }
    if (this.c != null)
    {
      this.c.setText(paramString);
      this.c.setOnClickListener(paramOnClickListener);
      this.c.setVisibility(0);
      a(true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.c != null)
    {
      localTextView = this.c;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.FileBrowserViewBase
 * JD-Core Version:    0.7.0.1
 */