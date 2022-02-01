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
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (localBundle != null) {
      return (Rect)localBundle.getParcelable("file_browser_params_thumb_bound");
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
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((localView != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131379107));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131379080));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379089));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366347));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379078);
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
      this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372125));
    }
    TextView localTextView = this.c;
    if (localTextView != null)
    {
      localTextView.setText(paramString);
      this.c.setOnClickListener(paramOnClickListener);
      this.c.setVisibility(0);
      a(true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    TextView localTextView = this.c;
    if (localTextView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localTextView.setVisibility(i);
    }
  }
  
  public void b()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void b(int paramInt)
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setVisibility(paramInt);
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
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localRelativeLayout.setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.FileBrowserViewBase
 * JD-Core Version:    0.7.0.1
 */