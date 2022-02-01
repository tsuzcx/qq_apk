package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build.VERSION;
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
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  
  public MusicFileViewer(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: MusicFileViewer initFileView");
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131560837, this.jdField_a_of_type_AndroidViewViewGroup, false);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371656));
      this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372125));
      this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366792));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131372862));
      this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362661));
      this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373004));
      this.h = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366789));
      if (Build.VERSION.SDK_INT >= 21) {
        this.jdField_a_of_type_AndroidWidgetSeekBar.setSplitTrack(false);
      }
    }
  }
  
  public void a(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    if (paramOnSeekBarChangeListener != null) {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(paramOnSeekBarChangeListener);
    }
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void c()
  {
    if (FontSettingManager.getFontLevel() > 17.0F)
    {
      int i = (int)(this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density * 150.0F);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(paramInt);
  }
  
  public void c(String paramString)
  {
    this.f.setText(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(paramBoolean);
  }
  
  public void d(int paramInt)
  {
    if (paramInt > 0) {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(paramInt);
    }
  }
  
  public void d(String paramString)
  {
    this.e.setText(paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844382);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691138));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844383);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691140));
  }
  
  public void e(String paramString)
  {
    if (this.g.getMeasuredWidth() <= 0)
    {
      this.g.post(new MusicFileViewer.1(this, paramString));
      return;
    }
    TextView localTextView = this.g;
    localTextView.setText(FileManagerUtil.a(paramString, false, localTextView.getMeasuredWidth(), this.g.getPaint(), 2));
  }
  
  public void f(String paramString)
  {
    this.h.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.MusicFileViewer
 * JD-Core Version:    0.7.0.1
 */