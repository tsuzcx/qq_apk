package com.tencent.mobileqq.filebrowser.view;

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
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class MusicFileBrowserView
  extends FileBrowserViewBase
{
  private ImageView a;
  private SeekBar b;
  private TextView c;
  private TextView m;
  private TextView n;
  private TextView o;
  
  public MusicFileBrowserView(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    if (FontSettingManager.getFontLevel() > 17.0F)
    {
      int i = (int)(BaseApplication.getContext().getResources().getDisplayMetrics().density * 150.0F);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i);
      this.a.setLayoutParams(localLayoutParams);
    }
  }
  
  public void a(int paramInt)
  {
    this.b.setProgress(paramInt);
  }
  
  public void a(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    if (paramOnSeekBarChangeListener != null) {
      this.b.setOnSeekBarChangeListener(paramOnSeekBarChangeListener);
    }
  }
  
  public void a(String paramString)
  {
    this.m.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.setEnabled(paramBoolean);
  }
  
  public void b(int paramInt)
  {
    if (paramInt > 0) {
      this.b.setMax(paramInt);
    }
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null) {
      this.a.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void d(String paramString)
  {
    this.c.setText(paramString);
  }
  
  public void e(String paramString)
  {
    if (this.n.getMeasuredWidth() <= 0)
    {
      this.n.post(new MusicFileBrowserView.1(this, paramString));
      return;
    }
    TextView localTextView = this.n;
    localTextView.setText(QQFileManagerUtil.a(paramString, false, localTextView.getMeasuredWidth(), this.n.getPaint(), 2));
  }
  
  public void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.setImageResource(2130845699);
      this.a.setContentDescription(BaseApplication.getContext().getString(2131888084));
      return;
    }
    this.a.setImageResource(2130845700);
    this.a.setContentDescription(BaseApplication.getContext().getString(2131888086));
  }
  
  public void f(String paramString)
  {
    this.o.setText(paramString);
  }
  
  public void g()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: MusicFileViewer initFileView");
    if (this.d == null)
    {
      this.d = ((LayoutInflater)BaseApplication.getContext().getSystemService("layout_inflater")).inflate(2131627095, null, false);
      this.a = ((ImageView)this.d.findViewById(2131439077));
      this.n = ((TextView)this.d.findViewById(2131433114));
      this.b = ((SeekBar)this.d.findViewById(2131440424));
      this.m = ((TextView)this.d.findViewById(2131428284));
      this.c = ((TextView)this.d.findViewById(2131440573));
      this.o = ((TextView)this.d.findViewById(2131433111));
      if (Build.VERSION.SDK_INT >= 21) {
        this.b.setSplitTrack(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.view.MusicFileBrowserView
 * JD-Core Version:    0.7.0.1
 */