package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.troop.file.ZipFilesListAdapter;
import com.tencent.biz.widgets.TriangleView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.FileData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class ZipFileViewer
  extends FileBrowserViewBase
{
  private RelativeLayout A;
  private ProgressBar B;
  private TextView C;
  private View D;
  private ZipFilesListAdapter E;
  private int F;
  private XListView l;
  private TriangleView m;
  private View n;
  private View o;
  private View p;
  private View q;
  private TextView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private View v;
  private TextView w;
  private TextView x;
  private TextView y;
  private TextView z;
  
  public ZipFileViewer(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    QLog.i("ZipFileViewer<QFile>", 4, "FileBrowserViewBase: ZipFileViewer initFileView");
    if (this.b == null)
    {
      this.b = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131627101, this.a, false);
      this.l = ((XListView)this.b.findViewById(2131433143));
      this.s = ((TextView)this.b.findViewById(2131439503));
      this.t = ((TextView)this.b.findViewById(2131449168));
      this.u = ((TextView)this.b.findViewById(2131449182));
      this.q = this.b.findViewById(2131450401);
      this.n = this.b.findViewById(2131450406);
      this.o = this.b.findViewById(2131440620);
      this.p = this.b.findViewById(2131433257);
      this.r = ((TextView)this.b.findViewById(2131448400));
      this.y = ((TextView)this.b.findViewById(2131448886));
      this.y.setVisibility(8);
      this.m = ((TriangleView)this.b.findViewById(2131447858));
      this.E = new ZipFilesListAdapter(null, this.c);
      this.v = this.b.findViewById(2131440618);
      this.w = ((TextView)this.v.findViewById(2131450404));
      this.x = ((TextView)this.v.findViewById(2131450402));
      this.i = ((TextView)this.b.findViewById(2131439595));
      this.z = ((TextView)this.b.findViewById(2131427500));
    }
  }
  
  public void a(int paramInt)
  {
    ProgressBar localProgressBar = this.B;
    if (localProgressBar != null) {
      localProgressBar.setProgress(paramInt);
    }
    if (this.e != null) {
      this.e.setProgress(paramInt);
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    super.a(paramOnClickListener);
    this.A = ((RelativeLayout)this.b.findViewById(2131447842));
    this.B = ((ProgressBar)this.b.findViewById(2131447808));
    this.C = ((TextView)this.b.findViewById(2131447817));
    this.D = this.b.findViewById(2131447806);
    this.D.setOnClickListener(paramOnClickListener);
  }
  
  public void a(String paramString)
  {
    if (this.A != null) {
      this.C.setText(paramString);
    }
    if (this.f != null) {
      this.f.setText(paramString);
    }
  }
  
  public void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    super.a(paramString, paramOnClickListener);
    this.r.setText(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.t.setText(paramString1);
    this.u.setText(paramString2);
  }
  
  public void a(List<ZipFilePresenter.FileData> paramList, String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, short paramShort)
  {
    this.E.a(paramList);
    paramList = this.E;
    paramList.g = "/";
    paramList.i = paramLong1;
    paramList.h = paramLong2;
    paramList.d = paramString2;
    paramList.e = paramString3;
    paramList.f = paramString4;
    paramList.c = paramString5;
    paramList.a(paramBoolean, paramString6, paramShort);
    this.l.setAdapter(this.E);
    this.n.setVisibility(0);
    this.o.setVisibility(8);
    this.v.setVisibility(8);
    this.F = 2;
  }
  
  public void a(boolean paramBoolean, String paramString, View.OnClickListener paramOnClickListener)
  {
    View localView = this.p;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
    this.r.setText(paramString);
    this.r.setOnClickListener(paramOnClickListener);
    if (this.F != 2) {
      this.p.setVisibility(8);
    }
  }
  
  public View b()
  {
    return this.b;
  }
  
  public void b(String paramString, View.OnClickListener paramOnClickListener)
  {
    TextView localTextView = this.z;
    if (localTextView != null)
    {
      localTextView.setText(paramString);
      this.z.setOnClickListener(paramOnClickListener);
      e(true);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    paramString1 = this.E;
    if (paramString1 != null) {
      paramString1.notifyDataSetChanged();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.A;
    if (this.F == 2) {
      localRelativeLayout = this.d;
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
        e(false);
      }
    }
  }
  
  public void c(String paramString)
  {
    this.w.setText(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    View localView = this.p;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  public void d(String paramString)
  {
    this.x.setText(paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.v.setVisibility(8);
      return;
    }
    this.v.setVisibility(0);
    this.w.setVisibility(0);
    this.x.setVisibility(0);
    this.F = 0;
  }
  
  public void e()
  {
    View localView = this.n;
    localView.setPadding(0, localView.getPaddingTop(), 0, 0);
    this.p.setVisibility(8);
  }
  
  public void e(String paramString)
  {
    this.s.setText(paramString);
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.z != null)
    {
      Object localObject = this.d;
      int i = 0;
      if (localObject != null)
      {
        if ((paramBoolean) && (this.d.getVisibility() != 0))
        {
          this.z.setVisibility(0);
          return;
        }
        this.z.setVisibility(8);
        return;
      }
      localObject = this.z;
      if (!paramBoolean) {
        i = 8;
      }
      ((TextView)localObject).setVisibility(i);
    }
  }
  
  public void f(String paramString)
  {
    this.y.setText(paramString);
    g(true);
  }
  
  public void f(boolean paramBoolean)
  {
    View localView = this.o;
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
      this.F = 1;
    }
  }
  
  public void g(boolean paramBoolean)
  {
    TextView localTextView = this.y;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
  }
  
  public void h(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.setBackgroundResource(2130838958);
      this.m.setColor(this.c.getResources().getColor(2131168376));
      this.r.setTextColor(this.c.getResources().getColor(2131167226));
      this.w.setTextColor(this.c.getResources().getColor(2131168125));
      return;
    }
    this.b.setBackgroundColor(Color.parseColor("#ffffffff"));
    this.m.setColor(Color.parseColor("#ffffffff"));
    this.q.setBackgroundColor(Color.parseColor("#fff7f7f8"));
    this.r.setTextColor(this.c.getResources().getColor(2131167225));
    this.w.setTextColor(this.c.getResources().getColor(2131165564));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.ZipFileViewer
 * JD-Core Version:    0.7.0.1
 */