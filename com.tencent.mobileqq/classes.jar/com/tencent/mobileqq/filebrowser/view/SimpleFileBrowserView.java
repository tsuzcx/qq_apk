package com.tencent.mobileqq.filebrowser.view;

import android.app.Activity;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class SimpleFileBrowserView
  extends FileBrowserViewBase
{
  private TextView a;
  private View b;
  private RelativeLayout c;
  AsyncImageView m;
  private TextView n;
  private TextView o;
  private TextView p;
  private TextView q;
  private TextView r;
  private TextView s;
  
  public SimpleFileBrowserView(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new SimpleFileBrowserView.2(this));
  }
  
  public void a(SpannableString paramSpannableString)
  {
    this.a.setMovementMethod(LinkMovementMethod.getInstance());
    this.a.setText(paramSpannableString);
    this.a.setHighlightColor(17170445);
  }
  
  public void a(String paramString, int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (this.d == null) {
      return;
    }
    if (this.q == null) {
      this.q = ((TextView)this.d.findViewById(2131445222));
    }
    TextView localTextView = this.q;
    if (localTextView == null) {
      return;
    }
    localTextView.setText(paramString);
    if (paramInt != 0) {
      this.q.setTextColor(this.e.getResources().getColor(paramInt));
    }
    this.q.setOnClickListener(paramOnClickListener);
    this.q.setVisibility(0);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    if (this.p == null) {
      this.p = ((TextView)this.d.findViewById(2131430838));
    }
    TextView localTextView = this.p;
    if (localTextView == null) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
    this.p.setText(paramString);
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    if (this.d == null) {
      return;
    }
    if (this.s == null) {
      this.s = ((TextView)this.d.findViewById(2131434466));
    }
    this.s.setOnClickListener(paramOnClickListener);
  }
  
  public void b(String paramString, View.OnClickListener paramOnClickListener)
  {
    TextView localTextView = this.r;
    if (localTextView != null)
    {
      localTextView.setText(paramString);
      this.r.setOnClickListener(paramOnClickListener);
      f(true);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    if (paramBoolean) {
      f(false);
    }
  }
  
  public void d(int paramInt)
  {
    this.m.setImageResource(paramInt);
  }
  
  public void d(String paramString)
  {
    TextView localTextView = this.a;
    if (localTextView == null) {
      return;
    }
    localTextView.setText(paramString);
  }
  
  public void e(int paramInt)
  {
    this.m.setDefaultImage(paramInt);
  }
  
  public void e(String paramString)
  {
    if (this.n.getMeasuredWidth() <= 0)
    {
      this.n.post(new SimpleFileBrowserView.1(this, paramString));
      return;
    }
    TextView localTextView = this.n;
    localTextView.setText(QQFileManagerUtil.a(paramString, false, localTextView.getMeasuredWidth(), this.n.getPaint(), 2));
  }
  
  public void e(boolean paramBoolean)
  {
    TextView localTextView = this.a;
    if (localTextView == null) {
      return;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(localTextView.getText())))
    {
      this.a.setVisibility(0);
      return;
    }
    this.a.setVisibility(8);
  }
  
  public void f(String paramString)
  {
    this.m.setApkIconAsyncImage(paramString);
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.r != null)
    {
      Object localObject = this.f;
      int i = 0;
      if (localObject != null)
      {
        if ((paramBoolean) && (this.f.getVisibility() != 0))
        {
          this.r.setVisibility(0);
          return;
        }
        this.r.setVisibility(8);
        return;
      }
      localObject = this.r;
      if (!paramBoolean) {
        i = 8;
      }
      ((TextView)localObject).setVisibility(i);
    }
  }
  
  public void g()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: SimpleFileViewer initFileView");
    if (this.d == null)
    {
      this.d = ((LayoutInflater)BaseApplication.getContext().getSystemService("layout_inflater")).inflate(2131627093, null, false);
      this.b = this.d;
      this.a = ((TextView)this.d.findViewById(2131433120));
      this.m = ((AsyncImageView)this.d.findViewById(2131430297));
      this.n = ((TextView)this.d.findViewById(2131433114));
      this.o = ((TextView)this.d.findViewById(2131433111));
      this.k = ((TextView)this.d.findViewById(2131439595));
      this.r = ((TextView)this.d.findViewById(2131427500));
    }
  }
  
  public void g(String paramString)
  {
    this.m.setUrlIconAsyncImage(paramString);
  }
  
  public void g(boolean paramBoolean)
  {
    TextView localTextView = this.o;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
  }
  
  public View h()
  {
    if (this.c != null)
    {
      QLog.e("FileBrowserViewBase", 2, "getInnerFileView : tbs not null");
      return this.c;
    }
    return this.d;
  }
  
  public void h(String paramString)
  {
    this.o.setText(paramString);
  }
  
  public void h(boolean paramBoolean)
  {
    TextView localTextView = this.s;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.view.SimpleFileBrowserView
 * JD-Core Version:    0.7.0.1
 */