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
  private int jdField_a_of_type_Int;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter;
  private TriangleView jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetTriangleView;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private ProgressBar jdField_b_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private View c;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private View jdField_g_of_type_AndroidViewView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  
  public ZipFileBrowserView(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    super.a(paramOnClickListener);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379108));
    this.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131379081));
    this.l = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379090));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131379079).setOnClickListener(paramOnClickListener);
  }
  
  public void a(BaseAdapter paramBaseAdapter)
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(paramBaseAdapter);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_g_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Int = 2;
  }
  
  public void a(String paramString)
  {
    this.h.setText(paramString);
  }
  
  public void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    super.a(paramString, paramOnClickListener);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString1);
    this.jdField_g_of_type_AndroidWidgetTextView.setText(paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Int == 2))
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    View localView = this.jdField_c_of_type_AndroidViewView;
    localView.setPadding(0, localView.getPaddingTop(), 0, 0);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean, String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    a(paramBoolean);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
      this.l.setText(paramString);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void b(String paramString, View.OnClickListener paramOnClickListener)
  {
    TextView localTextView = this.k;
    if (localTextView != null)
    {
      localTextView.setText(paramString);
      this.k.setOnClickListener(paramOnClickListener);
      f(true);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_AndroidWidgetBaseAdapter;
    if (paramString1 != null) {
      paramString1.notifyDataSetChanged();
    }
  }
  
  public void c(int paramInt)
  {
    ProgressBar localProgressBar = this.jdField_b_of_type_AndroidWidgetProgressBar;
    if (localProgressBar != null) {
      localProgressBar.setProgress(paramInt);
    }
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if (this.jdField_a_of_type_Int == 2) {
      localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    }
    if (localRelativeLayout != null)
    {
      int m;
      if (paramBoolean) {
        m = 0;
      } else {
        m = 8;
      }
      localRelativeLayout.setVisibility(m);
      if (paramBoolean) {
        f(false);
      }
    }
  }
  
  public void d(String paramString)
  {
    this.i.setText(paramString);
  }
  
  public void e()
  {
    QLog.i("ZipFileViewer<QFile>", 4, "FileBrowserViewBase: ZipFileViewer initFileView");
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplication.getContext().getSystemService("layout_inflater")).inflate(2131560806, null, false);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366821));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372040));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380250));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380264));
      this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131381348);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131381353);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373038);
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366915);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379632));
      this.j = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379983));
      this.j.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetTriangleView = ((TriangleView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379123));
      this.jdField_g_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373037);
      this.h = ((TextView)this.jdField_g_of_type_AndroidViewView.findViewById(2131381351));
      this.i = ((TextView)this.jdField_g_of_type_AndroidViewView.findViewById(2131381349));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372125));
      this.k = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131361946));
    }
  }
  
  public void e(String paramString)
  {
    this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void e(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_g_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_Int = 0;
  }
  
  public void f(String paramString)
  {
    this.j.setText(paramString);
    h(true);
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.k != null)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      int m = 0;
      if (localObject != null)
      {
        if ((paramBoolean) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0))
        {
          this.k.setVisibility(0);
          return;
        }
        this.k.setVisibility(8);
        return;
      }
      localObject = this.k;
      if (!paramBoolean) {
        m = 8;
      }
      ((TextView)localObject).setVisibility(m);
    }
  }
  
  public void g(boolean paramBoolean)
  {
    View localView = this.jdField_d_of_type_AndroidViewView;
    if (localView != null)
    {
      int m;
      if (paramBoolean) {
        m = 0;
      } else {
        m = 8;
      }
      localView.setVisibility(m);
    }
    if (paramBoolean) {
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  public void h(boolean paramBoolean)
  {
    TextView localTextView = this.j;
    int m;
    if (paramBoolean) {
      m = 0;
    } else {
      m = 8;
    }
    localTextView.setVisibility(m);
  }
  
  public void i(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838739);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetTriangleView.setColor(BaseApplication.getContext().getResources().getColor(2131167333));
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(BaseApplication.getContext().getResources().getColor(2131166390));
      this.h.setTextColor(BaseApplication.getContext().getResources().getColor(2131167144));
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#ffffffff"));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetTriangleView.setColor(Color.parseColor("#ffffffff"));
    this.jdField_f_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#fff7f7f8"));
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(BaseApplication.getContext().getResources().getColor(2131166389));
    this.h.setTextColor(BaseApplication.getContext().getResources().getColor(2131165327));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.view.ZipFileBrowserView
 * JD-Core Version:    0.7.0.1
 */