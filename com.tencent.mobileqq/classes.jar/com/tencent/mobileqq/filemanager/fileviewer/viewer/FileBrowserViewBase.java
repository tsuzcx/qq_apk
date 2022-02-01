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
  protected ViewGroup a;
  protected View b;
  protected Activity c;
  protected RelativeLayout d;
  protected ProgressBar e;
  protected TextView f;
  protected View g;
  protected TextView h;
  protected TextView i;
  protected FileBrowserViewBase.CloseFileBrowserCallback j;
  protected Bundle k;
  
  public FileBrowserViewBase(Activity paramActivity)
  {
    this.c = paramActivity;
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    if (this.d != null) {
      this.e.setProgress(paramInt);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    this.k = paramBundle;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    View localView = this.b;
    if ((localView != null) && (this.d == null))
    {
      this.d = ((RelativeLayout)localView.findViewById(2131447841));
      this.e = ((ProgressBar)this.b.findViewById(2131447807));
      this.f = ((TextView)this.b.findViewById(2131447816));
      this.h = ((TextView)this.b.findViewById(2131432648));
      this.g = this.b.findViewById(2131447805);
    }
    this.g.setOnClickListener(paramOnClickListener);
  }
  
  public void a(FileBrowserViewBase.CloseFileBrowserCallback paramCloseFileBrowserCallback)
  {
    this.j = paramCloseFileBrowserCallback;
  }
  
  public void a(String paramString)
  {
    if (this.d != null) {
      this.f.setText(paramString);
    }
  }
  
  public void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    if (this.i == null) {
      this.i = ((TextView)this.b.findViewById(2131439595));
    }
    TextView localTextView = this.i;
    if (localTextView != null)
    {
      localTextView.setText(paramString);
      this.i.setOnClickListener(paramOnClickListener);
      this.i.setVisibility(0);
      a(true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    TextView localTextView = this.i;
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
  
  public View b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    TextView localTextView = this.h;
    if (localTextView != null) {
      localTextView.setVisibility(paramInt);
    }
  }
  
  public void b(String paramString)
  {
    if (this.d != null) {
      this.h.setText(paramString);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.d;
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
  
  public void c()
  {
    View localView = this.g;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public Rect d()
  {
    Bundle localBundle = this.k;
    if (localBundle != null) {
      return (Rect)localBundle.getParcelable("file_browser_params_thumb_bound");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.FileBrowserViewBase
 * JD-Core Version:    0.7.0.1
 */