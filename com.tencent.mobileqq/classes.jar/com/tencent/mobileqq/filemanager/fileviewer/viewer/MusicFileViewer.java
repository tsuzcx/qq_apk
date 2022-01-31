package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import adoa;
import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class MusicFileViewer
  extends FileBrowserViewBase
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  
  public MusicFileViewer(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: MusicFileViewer initFileView");
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130970056, this.jdField_a_of_type_AndroidViewViewGroup, false);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368866));
      this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368850));
      this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368732));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131368868));
      this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368869));
      this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368867));
      this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368733));
    }
  }
  
  public void a(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    if (paramOnSeekBarChangeListener != null) {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(paramOnSeekBarChangeListener);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(paramInt);
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void b(String paramString)
  {
    this.e.setText(paramString);
  }
  
  public void c()
  {
    if (FontSettingManager.a() > 17.0F)
    {
      float f1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)(150.0F * f1), (int)(f1 * 150.0F));
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void c(int paramInt)
  {
    if (paramInt > 0) {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(paramInt);
    }
  }
  
  public void c(String paramString)
  {
    this.d.setText(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(paramBoolean);
  }
  
  public void d(String paramString)
  {
    if (this.f.getMeasuredWidth() <= 0)
    {
      this.f.post(new adoa(this, paramString));
      return;
    }
    this.f.setText(FileManagerUtil.a(paramString, false, this.f.getMeasuredWidth(), this.f.getPaint(), 2));
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841671);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131437421));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841672);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131437420));
  }
  
  public void e(String paramString)
  {
    this.g.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.MusicFileViewer
 * JD-Core Version:    0.7.0.1
 */