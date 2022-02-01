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
  private ImageView l;
  private SeekBar m;
  private TextView n;
  private TextView o;
  private TextView p;
  private TextView q;
  private TextView r;
  
  public MusicFileViewer(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: MusicFileViewer initFileView");
    if (this.b == null)
    {
      this.b = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131627095, this.a, false);
      this.l = ((ImageView)this.b.findViewById(2131439077));
      this.n = ((TextView)this.b.findViewById(2131439595));
      this.q = ((TextView)this.b.findViewById(2131433114));
      this.m = ((SeekBar)this.b.findViewById(2131440424));
      this.p = ((TextView)this.b.findViewById(2131428284));
      this.o = ((TextView)this.b.findViewById(2131440573));
      this.r = ((TextView)this.b.findViewById(2131433111));
      if (Build.VERSION.SDK_INT >= 21) {
        this.m.setSplitTrack(false);
      }
    }
  }
  
  public void a(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    if (paramOnSeekBarChangeListener != null) {
      this.m.setOnSeekBarChangeListener(paramOnSeekBarChangeListener);
    }
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null) {
      this.l.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void c(int paramInt)
  {
    this.m.setProgress(paramInt);
  }
  
  public void c(String paramString)
  {
    this.p.setText(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    this.m.setEnabled(paramBoolean);
  }
  
  public void d(int paramInt)
  {
    if (paramInt > 0) {
      this.m.setMax(paramInt);
    }
  }
  
  public void d(String paramString)
  {
    this.o.setText(paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.l.setImageResource(2130845699);
      this.l.setContentDescription(this.c.getString(2131888084));
      return;
    }
    this.l.setImageResource(2130845700);
    this.l.setContentDescription(this.c.getString(2131888086));
  }
  
  public void e()
  {
    if (FontSettingManager.getFontLevel() > 17.0F)
    {
      int i = (int)(this.c.getResources().getDisplayMetrics().density * 150.0F);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i);
      this.l.setLayoutParams(localLayoutParams);
    }
  }
  
  public void e(String paramString)
  {
    if (this.q.getMeasuredWidth() <= 0)
    {
      this.q.post(new MusicFileViewer.1(this, paramString));
      return;
    }
    TextView localTextView = this.q;
    localTextView.setText(FileManagerUtil.a(paramString, false, localTextView.getMeasuredWidth(), this.q.getPaint(), 2));
  }
  
  public void f(String paramString)
  {
    this.r.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.MusicFileViewer
 * JD-Core Version:    0.7.0.1
 */