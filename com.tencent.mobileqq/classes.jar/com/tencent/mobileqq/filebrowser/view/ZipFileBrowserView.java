package com.tencent.mobileqq.filebrowser.view;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanageraux.widget.TriangleView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

public class ZipFileBrowserView
  extends FileBrowserViewBase
{
  private TextView A;
  private BaseAdapter B;
  private int C;
  private XListView a;
  private TriangleView b;
  private View c;
  private View m;
  private View n;
  private View o;
  private TextView p;
  private TextView q;
  private TextView r;
  private TextView s;
  private View t;
  private TextView u;
  private TextView v;
  private TextView w;
  private TextView x;
  private RelativeLayout y;
  private ProgressBar z;
  
  public ZipFileBrowserView(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    super.a(paramOnClickListener);
    this.y = ((RelativeLayout)this.d.findViewById(2131447842));
    this.z = ((ProgressBar)this.d.findViewById(2131447808));
    this.A = ((TextView)this.d.findViewById(2131447817));
    this.d.findViewById(2131447806).setOnClickListener(paramOnClickListener);
  }
  
  public void a(BaseAdapter paramBaseAdapter)
  {
    this.B = paramBaseAdapter;
    this.a.setAdapter(paramBaseAdapter);
    this.c.setVisibility(0);
    this.m.setVisibility(8);
    this.t.setVisibility(8);
    this.C = 2;
  }
  
  public void a(String paramString)
  {
    this.u.setText(paramString);
  }
  
  public void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    super.a(paramString, paramOnClickListener);
    this.p.setText(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.r.setText(paramString1);
    this.s.setText(paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.C == 2))
    {
      this.n.setVisibility(0);
      return;
    }
    View localView = this.c;
    localView.setPadding(0, localView.getPaddingTop(), 0, 0);
    this.n.setVisibility(8);
  }
  
  public void a(boolean paramBoolean, String paramString, View.OnClickListener paramOnClickListener)
  {
    this.p.setText(paramString);
    this.p.setOnClickListener(paramOnClickListener);
    a(paramBoolean);
  }
  
  public void b(String paramString)
  {
    if (this.y != null) {
      this.A.setText(paramString);
    }
    if (this.h != null) {
      this.h.setText(paramString);
    }
  }
  
  public void b(String paramString, View.OnClickListener paramOnClickListener)
  {
    TextView localTextView = this.x;
    if (localTextView != null)
    {
      localTextView.setText(paramString);
      this.x.setOnClickListener(paramOnClickListener);
      f(true);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    paramString1 = this.B;
    if (paramString1 != null) {
      paramString1.notifyDataSetChanged();
    }
  }
  
  public void c(int paramInt)
  {
    ProgressBar localProgressBar = this.z;
    if (localProgressBar != null) {
      localProgressBar.setProgress(paramInt);
    }
    if (this.g != null) {
      this.g.setProgress(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.y;
    if (this.C == 2) {
      localRelativeLayout = this.f;
    }
    if (localRelativeLayout != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localRelativeLayout.setVisibility(i);
      if (paramBoolean) {
        f(false);
      }
    }
  }
  
  public void d(String paramString)
  {
    this.v.setText(paramString);
  }
  
  public void e(String paramString)
  {
    this.q.setText(paramString);
  }
  
  public void e(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.t.setVisibility(8);
      return;
    }
    this.t.setVisibility(0);
    this.C = 0;
  }
  
  public void f(String paramString)
  {
    this.w.setText(paramString);
    h(true);
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.x != null)
    {
      Object localObject = this.f;
      int i = 0;
      if (localObject != null)
      {
        if ((paramBoolean) && (this.f.getVisibility() != 0))
        {
          this.x.setVisibility(0);
          return;
        }
        this.x.setVisibility(8);
        return;
      }
      localObject = this.x;
      if (!paramBoolean) {
        i = 8;
      }
      ((TextView)localObject).setVisibility(i);
    }
  }
  
  public void g()
  {
    QLog.i("ZipFileViewer<QFile>", 4, "FileBrowserViewBase: ZipFileViewer initFileView");
    if (this.d == null)
    {
      this.d = ((LayoutInflater)BaseApplication.getContext().getSystemService("layout_inflater")).inflate(2131627064, null, false);
      this.a = ((XListView)this.d.findViewById(2131433143));
      this.q = ((TextView)this.d.findViewById(2131439503));
      this.r = ((TextView)this.d.findViewById(2131449168));
      this.s = ((TextView)this.d.findViewById(2131449182));
      this.o = this.d.findViewById(2131450401);
      this.c = this.d.findViewById(2131450406);
      this.m = this.d.findViewById(2131440620);
      this.n = this.d.findViewById(2131433257);
      this.p = ((TextView)this.d.findViewById(2131448400));
      this.w = ((TextView)this.d.findViewById(2131448886));
      this.w.setVisibility(8);
      this.b = ((TriangleView)this.d.findViewById(2131447858));
      this.t = this.d.findViewById(2131440618);
      this.u = ((TextView)this.t.findViewById(2131450404));
      this.v = ((TextView)this.t.findViewById(2131450402));
      this.k = ((TextView)this.d.findViewById(2131439595));
      this.x = ((TextView)this.d.findViewById(2131427500));
    }
  }
  
  public void g(boolean paramBoolean)
  {
    View localView = this.m;
    if (localView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
    }
    if (paramBoolean) {
      this.C = 1;
    }
  }
  
  public void h(boolean paramBoolean)
  {
    TextView localTextView = this.w;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
  }
  
  public void i(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.d.setBackgroundResource(2130838958);
      this.b.setColor(BaseApplication.getContext().getResources().getColor(2131168376));
      this.p.setTextColor(BaseApplication.getContext().getResources().getColor(2131167226));
      this.u.setTextColor(BaseApplication.getContext().getResources().getColor(2131168125));
      return;
    }
    this.d.setBackgroundColor(Color.parseColor("#ffffffff"));
    this.b.setColor(Color.parseColor("#ffffffff"));
    this.o.setBackgroundColor(Color.parseColor("#fff7f7f8"));
    this.p.setTextColor(BaseApplication.getContext().getResources().getColor(2131167225));
    this.u.setTextColor(BaseApplication.getContext().getResources().getColor(2131165564));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.view.ZipFileBrowserView
 * JD-Core Version:    0.7.0.1
 */