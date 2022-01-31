package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import anbr;
import ancg;
import android.app.Activity;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import apjf;
import apji;
import apqn;
import apqs;
import apqv;
import apue;
import apvv;
import apwy;
import apxa;
import bcpq;
import bfol;
import bfoy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.kwstudio.office.preview.TdsReaderView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TdsDebugView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsReaderView;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class SimpleFileViewer
  extends apqn
{
  public apwy a;
  public apxa a;
  private bcpq jdField_a_of_type_Bcpq;
  private TdsReaderView jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView;
  AsyncImageView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
  private TbsReaderView jdField_a_of_type_ComTencentSmttSdkTbsReaderView;
  private boolean jdField_a_of_type_Boolean = true;
  private RelativeLayout b;
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
  
  public SimpleFileViewer(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a(QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    Object localObject2 = this.jdField_a_of_type_AndroidAppActivity.getString(2131691981);
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131691974);
    Object localObject3 = apvv.a();
    Iterator localIterator;
    Object localObject4;
    if ((localObject3 != null) && (((List)localObject3).size() == 2)) {
      if (this.jdField_a_of_type_Boolean)
      {
        localIterator = ((List)localObject3).iterator();
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject4 = localObject2;
        localObject3 = localObject1;
        if (!localIterator.hasNext()) {
          break label265;
        }
        localObject3 = (anbr)localIterator.next();
        if ((((anbr)localObject3).a() != 0) || (TextUtils.isEmpty(((anbr)localObject3).b())) || (TextUtils.isEmpty(((anbr)localObject3).c()))) {
          break label329;
        }
        localObject2 = ((anbr)localObject3).b();
        localObject1 = ((anbr)localObject3).c();
      }
    }
    for (;;)
    {
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break;
      localIterator = ((List)localObject3).iterator();
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      localObject4 = localObject2;
      localObject3 = localObject1;
      if (localIterator.hasNext())
      {
        localObject3 = (anbr)localIterator.next();
        if ((((anbr)localObject3).a() != 1) || (TextUtils.isEmpty(((anbr)localObject3).b())) || (TextUtils.isEmpty(((anbr)localObject3).c()))) {
          break label316;
        }
        localObject2 = ((anbr)localObject3).b();
        localObject1 = ((anbr)localObject3).c();
      }
      for (;;)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        localObject3 = localObject2;
        localObject4 = localObject1;
        label265:
        localObject1 = (bfol)bfoy.a(this.jdField_a_of_type_AndroidAppActivity, null);
        ((bfol)localObject1).a((CharSequence)localObject3);
        ((bfol)localObject1).a(localObject4, 5);
        ((bfol)localObject1).c(2131690596);
        ((bfol)localObject1).a(new apqs(this, paramQQAppInterface, paramTeamWorkFileImportInfo, (bfol)localObject1));
        ((bfol)localObject1).show();
        return;
        label316:
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      label329:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  private boolean a(View paramView1, View paramView2, boolean paramBoolean)
  {
    if (paramView1 == null)
    {
      this.jdField_d_of_type_AndroidViewView = paramView2;
      if ((this.b == null) && (paramView2 != null))
      {
        if (paramView2.getParent() != null) {
          ((ViewGroup)paramView2.getParent()).removeAllViews();
        }
        if (paramBoolean) {}
        for (paramView1 = new SimpleFileViewer.GestureRelativeLayout(this, this.jdField_a_of_type_AndroidAppActivity);; paramView1 = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity))
        {
          this.b = paramView1;
          paramView1 = new RelativeLayout.LayoutParams(-1, -1);
          this.b.addView(paramView2, 0, paramView1);
          return true;
        }
      }
    }
    else if ((this.b != null) && (paramView1 != null) && (paramView2 != null) && (paramView1.hashCode() != paramView2.hashCode()))
    {
      int i = this.b.indexOfChild(paramView1);
      if (i >= 0)
      {
        this.b.removeView(paramView1);
        paramView1 = new RelativeLayout.LayoutParams(-1, -1);
        this.b.addView(paramView2, i, paramView1);
        this.jdField_d_of_type_AndroidViewView = paramView2;
        return true;
      }
    }
    return false;
  }
  
  private void f()
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent();
    if ((localViewGroup != null) && (this.b != null))
    {
      localViewGroup.removeAllViews();
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localViewGroup.addView(this.b, 0, localLayoutParams);
    }
  }
  
  public View a()
  {
    if ((this.b != null) && (this.jdField_d_of_type_AndroidViewView != null))
    {
      QLog.e("FileBrowserViewBase", 2, "getInnerFileView : tbs not null");
      this.jdField_a_of_type_AndroidViewView = this.b;
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: SimpleFileViewer initFileView");
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131560500, this.jdField_a_of_type_AndroidViewViewGroup, false);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366229));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363872));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366223));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366219));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371063));
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView != null) {
      this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView.onSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public void a(SpannableString paramSpannableString)
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramSpannableString);
    this.jdField_d_of_type_AndroidWidgetTextView.setHighlightColor(17170445);
  }
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (this.b != null)
    {
      this.jdField_a_of_type_Apxa = new apxa(this.jdField_a_of_type_AndroidAppActivity, this.b, paramTeamWorkFileImportInfo, ancg.a());
      this.jdField_a_of_type_Apxa.a();
    }
  }
  
  public void a(String paramString, apjf paramapjf)
  {
    ThreadManager.getUIHandler().post(new SimpleFileViewer.5(this, paramString, paramapjf));
  }
  
  public void a(String paramString, apji paramapji)
  {
    ThreadManager.getUIHandler().post(new SimpleFileViewer.7(this, paramString, paramapji));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_g_of_type_AndroidWidgetTextView == null) {
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364286));
    }
    TextView localTextView = this.jdField_g_of_type_AndroidWidgetTextView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      this.jdField_g_of_type_AndroidWidgetTextView.setText(paramString);
      return;
    }
  }
  
  public void a(String paramString, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (this.h == null)
    {
      this.h = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371060));
      this.h.setHighlightColor(17170445);
    }
    paramString = this.h;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      paramString.setVisibility(i);
      this.h.setOnClickListener(paramOnClickListener);
      return;
    }
  }
  
  public boolean a()
  {
    return (this.b != null) && (this.jdField_d_of_type_AndroidViewView != null) && (this.jdField_f_of_type_AndroidViewView != null) && (this.jdField_f_of_type_AndroidViewView.getVisibility() == 0) && (this.b.getVisibility() == 0) && (this.jdField_f_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  public View b()
  {
    return this.jdField_f_of_type_AndroidViewView;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView != null) {
      this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView.onSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public void b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (this.b != null)
    {
      this.jdField_a_of_type_Apwy = new apwy(this.jdField_a_of_type_AndroidAppActivity, this.b, paramTeamWorkFileImportInfo);
      this.jdField_a_of_type_Apwy.b();
    }
  }
  
  public void b(String paramString, apjf paramapjf)
  {
    ThreadManager.getUIHandler().post(new SimpleFileViewer.6(this, paramString, paramapjf));
  }
  
  public void b(String paramString, apji paramapji)
  {
    ThreadManager.getUIHandler().post(new SimpleFileViewer.8(this, paramString, paramapji));
  }
  
  public void c()
  {
    if ((this.jdField_f_of_type_AndroidViewView != null) && (this.jdField_f_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(paramInt);
  }
  
  public void c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return;
    }
    paramTeamWorkFileImportInfo.d = 3;
    ThreadManager.getUIHandler().post(new SimpleFileViewer.3(this, paramTeamWorkFileImportInfo));
  }
  
  public void c(String paramString)
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void d()
  {
    ThreadManager.getUIHandler().post(new SimpleFileViewer.4(this));
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(paramInt);
  }
  
  public void d(String paramString)
  {
    if (this.jdField_e_of_type_AndroidWidgetTextView.getMeasuredWidth() <= 0)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.post(new SimpleFileViewer.1(this, paramString));
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setText(apue.a(paramString, false, this.jdField_e_of_type_AndroidWidgetTextView.getMeasuredWidth(), this.jdField_e_of_type_AndroidWidgetTextView.getPaint(), 2));
  }
  
  public void d(boolean paramBoolean)
  {
    TextView localTextView = this.jdField_f_of_type_AndroidWidgetTextView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {
      this.jdField_a_of_type_Bcpq.dismiss();
    }
  }
  
  public void e(int paramInt)
  {
    View localView;
    if (this.jdField_g_of_type_AndroidViewView != null)
    {
      localView = this.jdField_g_of_type_AndroidViewView;
      if (paramInt <= 0) {
        break label24;
      }
    }
    label24:
    for (paramInt = 0;; paramInt = 4)
    {
      localView.setVisibility(paramInt);
      return;
    }
  }
  
  public void e(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setApkIconAsyncImage(paramString);
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void f(String paramString)
  {
    this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void f(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.h != null)
    {
      localTextView = this.h;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void g(String paramString)
  {
    RelativeLayout localRelativeLayout = this.b;
    if ((localRelativeLayout == null) || (this.jdField_d_of_type_AndroidViewView == null)) {}
    while (!TdsDebugView.a(paramString)) {
      return;
    }
    if (this.jdField_e_of_type_AndroidViewView == null) {
      this.jdField_e_of_type_AndroidViewView = new TdsDebugView(this.jdField_a_of_type_AndroidAppActivity, new apqv(this));
    }
    if (localRelativeLayout.indexOfChild(this.jdField_e_of_type_AndroidViewView) < 0)
    {
      paramString = new RelativeLayout.LayoutParams(-1, -1);
      paramString.topMargin = ((int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298865));
      localRelativeLayout.addView(this.jdField_e_of_type_AndroidViewView, paramString);
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void h(String paramString)
  {
    if (this.jdField_a_of_type_Bcpq == null)
    {
      this.jdField_a_of_type_Bcpq = new bcpq(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_Bcpq.setCancelable(false);
    }
    if (!this.jdField_a_of_type_Bcpq.isShowing())
    {
      this.jdField_a_of_type_Bcpq.a(paramString);
      this.jdField_a_of_type_Bcpq.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer
 * JD-Core Version:    0.7.0.1
 */