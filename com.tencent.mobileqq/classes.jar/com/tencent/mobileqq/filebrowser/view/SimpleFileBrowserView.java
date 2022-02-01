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
  AsyncImageView a;
  private RelativeLayout b;
  private View c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  
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
    this.d.setMovementMethod(LinkMovementMethod.getInstance());
    this.d.setText(paramSpannableString);
    this.d.setHighlightColor(17170445);
  }
  
  public void a(String paramString, int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if (this.h == null) {
      this.h = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376880));
    }
    TextView localTextView = this.h;
    if (localTextView == null) {
      return;
    }
    localTextView.setText(paramString);
    if (paramInt != 0) {
      this.h.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(paramInt));
    }
    this.h.setOnClickListener(paramOnClickListener);
    this.h.setVisibility(0);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if (this.g == null) {
      this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364730));
    }
    TextView localTextView = this.g;
    if (localTextView == null) {
      return;
    }
    int k;
    if (paramBoolean) {
      k = 0;
    } else {
      k = 8;
    }
    localTextView.setVisibility(k);
    this.g.setText(paramString);
  }
  
  public View b()
  {
    if (this.b != null)
    {
      QLog.e("FileBrowserViewBase", 2, "getInnerFileView : tbs not null");
      return this.b;
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if (this.j == null) {
      this.j = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367884));
    }
    this.j.setOnClickListener(paramOnClickListener);
  }
  
  public void b(String paramString, View.OnClickListener paramOnClickListener)
  {
    TextView localTextView = this.i;
    if (localTextView != null)
    {
      localTextView.setText(paramString);
      this.i.setOnClickListener(paramOnClickListener);
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(paramInt);
  }
  
  public void d(String paramString)
  {
    TextView localTextView = this.d;
    if (localTextView == null) {
      return;
    }
    localTextView.setText(paramString);
  }
  
  public void e()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: SimpleFileViewer initFileView");
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplication.getContext().getSystemService("layout_inflater")).inflate(2131560835, null, false);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
      this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366798));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364278));
      this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366792));
      this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366789));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372125));
      this.i = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131361946));
    }
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(paramInt);
  }
  
  public void e(String paramString)
  {
    if (this.e.getMeasuredWidth() <= 0)
    {
      this.e.post(new SimpleFileBrowserView.1(this, paramString));
      return;
    }
    TextView localTextView = this.e;
    localTextView.setText(QQFileManagerUtil.a(paramString, false, localTextView.getMeasuredWidth(), this.e.getPaint(), 2));
  }
  
  public void e(boolean paramBoolean)
  {
    TextView localTextView = this.d;
    if (localTextView == null) {
      return;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(localTextView.getText())))
    {
      this.d.setVisibility(0);
      return;
    }
    this.d.setVisibility(8);
  }
  
  public void f(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setApkIconAsyncImage(paramString);
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.i != null)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      int k = 0;
      if (localObject != null)
      {
        if ((paramBoolean) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0))
        {
          this.i.setVisibility(0);
          return;
        }
        this.i.setVisibility(8);
        return;
      }
      localObject = this.i;
      if (!paramBoolean) {
        k = 8;
      }
      ((TextView)localObject).setVisibility(k);
    }
  }
  
  public void g(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setUrlIconAsyncImage(paramString);
  }
  
  public void g(boolean paramBoolean)
  {
    TextView localTextView = this.f;
    int k;
    if (paramBoolean) {
      k = 0;
    } else {
      k = 8;
    }
    localTextView.setVisibility(k);
  }
  
  public void h(String paramString)
  {
    this.f.setText(paramString);
  }
  
  public void h(boolean paramBoolean)
  {
    TextView localTextView = this.j;
    if (localTextView != null)
    {
      int k;
      if (paramBoolean) {
        k = 0;
      } else {
        k = 8;
      }
      localTextView.setVisibility(k);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.view.SimpleFileBrowserView
 * JD-Core Version:    0.7.0.1
 */