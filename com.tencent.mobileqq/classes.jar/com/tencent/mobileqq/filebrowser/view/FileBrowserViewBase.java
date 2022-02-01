package com.tencent.mobileqq.filebrowser.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class FileBrowserViewBase
{
  protected View d;
  protected Activity e;
  protected RelativeLayout f;
  protected ProgressBar g;
  protected TextView h;
  protected View i;
  protected TextView j;
  protected TextView k;
  protected Bundle l;
  
  public FileBrowserViewBase(Activity paramActivity)
  {
    this.e = paramActivity;
  }
  
  public void a(Bundle paramBundle)
  {
    this.l = paramBundle;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    View localView = this.d;
    if ((localView != null) && (this.f == null))
    {
      this.f = ((RelativeLayout)localView.findViewById(2131447841));
      this.g = ((ProgressBar)this.d.findViewById(2131447807));
      this.h = ((TextView)this.d.findViewById(2131447816));
      this.j = ((TextView)this.d.findViewById(2131432648));
      this.i = this.d.findViewById(2131447805);
    }
    this.i.setOnClickListener(paramOnClickListener);
  }
  
  public void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    if (this.k == null) {
      this.k = ((TextView)this.d.findViewById(2131439595));
    }
    TextView localTextView = this.k;
    if (localTextView != null)
    {
      localTextView.setText(paramString);
      this.k.setOnClickListener(paramOnClickListener);
      this.k.setVisibility(0);
      b(true);
    }
  }
  
  public void b(String paramString)
  {
    TextView localTextView = this.h;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    TextView localTextView = this.k;
    if (localTextView != null)
    {
      int m;
      if (paramBoolean) {
        m = 0;
      } else {
        m = 8;
      }
      localTextView.setVisibility(m);
    }
  }
  
  public void c(int paramInt)
  {
    if (this.f != null) {
      this.g.setProgress(paramInt);
    }
  }
  
  public void c(String paramString)
  {
    TextView localTextView = this.j;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.f;
    if (localRelativeLayout != null)
    {
      int m;
      if (paramBoolean) {
        m = 0;
      } else {
        m = 8;
      }
      localRelativeLayout.setVisibility(m);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    TextView localTextView = this.j;
    if (localTextView != null)
    {
      int m;
      if (paramBoolean) {
        m = 0;
      } else {
        m = 8;
      }
      localTextView.setVisibility(m);
    }
  }
  
  public abstract void g();
  
  public View h()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.view.FileBrowserViewBase
 * JD-Core Version:    0.7.0.1
 */