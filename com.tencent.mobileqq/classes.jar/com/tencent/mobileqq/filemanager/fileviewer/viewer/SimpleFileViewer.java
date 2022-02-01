package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.app.Activity;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aram;
import atlt;
import atsj;
import atso;
import atsp;
import atss;
import atvo;
import auaw;
import aucd;
import audf;
import audh;
import biau;
import bkho;
import bkif;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.kwstudio.office.preview.TdsReaderView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsDebugView;
import com.tencent.mobileqq.filemanageraux.widget.DocQBBottomView;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.reader.TbsReaderView;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class SimpleFileViewer
  extends atsj
{
  public audf a;
  public audh a;
  private biau jdField_a_of_type_Biau;
  private TdsReaderView jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView;
  AsyncImageView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
  private DocQBBottomView jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView;
  private TbsReaderView jdField_a_of_type_ComTencentTbsReaderTbsReaderView;
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
  private TextView i;
  private TextView j;
  
  public SimpleFileViewer(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a(QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    Object localObject2 = this.jdField_a_of_type_AndroidAppActivity.getString(2131691695);
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131691688);
    Object localObject3 = aucd.a();
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
        localObject3 = (aram)localIterator.next();
        if ((((aram)localObject3).a() != 0) || (TextUtils.isEmpty(((aram)localObject3).b())) || (TextUtils.isEmpty(((aram)localObject3).c()))) {
          break label329;
        }
        localObject2 = ((aram)localObject3).b();
        localObject1 = ((aram)localObject3).c();
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
        localObject3 = (aram)localIterator.next();
        if ((((aram)localObject3).a() != 1) || (TextUtils.isEmpty(((aram)localObject3).b())) || (TextUtils.isEmpty(((aram)localObject3).c()))) {
          break label316;
        }
        localObject2 = ((aram)localObject3).b();
        localObject1 = ((aram)localObject3).c();
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
        localObject1 = (bkho)bkif.a(this.jdField_a_of_type_AndroidAppActivity, null);
        ((bkho)localObject1).a((CharSequence)localObject3);
        ((bkho)localObject1).a(localObject4, 5);
        ((bkho)localObject1).c(2131690582);
        ((bkho)localObject1).a(new atso(this, paramQQAppInterface, paramTeamWorkFileImportInfo, (bkho)localObject1));
        ((bkho)localObject1).show();
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
      int k = this.b.indexOfChild(paramView1);
      if (k >= 0)
      {
        this.b.removeView(paramView1);
        paramView1 = new RelativeLayout.LayoutParams(-1, -1);
        this.b.addView(paramView2, k, paramView1);
        this.jdField_d_of_type_AndroidViewView = paramView2;
        return true;
      }
    }
    return false;
  }
  
  private void g()
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
  
  public View a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView = new DocQBBottomView(this.jdField_a_of_type_AndroidAppActivity, new atsp(this));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView.setTeamWorkFileImportInfo(paramTeamWorkFileImportInfo);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView;
  }
  
  public void a()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: SimpleFileViewer initFileView");
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131560898, this.jdField_a_of_type_AndroidViewViewGroup, false);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366572));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364134));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366566));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366563));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371966));
      this.i = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131361938));
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView != null) {
      this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.onSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, String paramString, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView.a(paramInt, paramString, paramObject);
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
    if (paramTeamWorkFileImportInfo == null) {
      return;
    }
    paramTeamWorkFileImportInfo.d = 3;
    ThreadManager.getUIHandler().post(new SimpleFileViewer.3(this, paramTeamWorkFileImportInfo));
  }
  
  public void a(String paramString, atlt paramatlt)
  {
    ThreadManager.getUIHandler().post(new SimpleFileViewer.5(this, paramString, paramatlt));
  }
  
  public void a(String paramString, auaw paramauaw)
  {
    ThreadManager.getUIHandler().post(new SimpleFileViewer.7(this, paramString, paramauaw));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_g_of_type_AndroidWidgetTextView == null) {
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364566));
    }
    TextView localTextView = this.jdField_g_of_type_AndroidWidgetTextView;
    if (paramBoolean) {}
    for (int k = 0;; k = 8)
    {
      localTextView.setVisibility(k);
      this.jdField_g_of_type_AndroidWidgetTextView.setText(paramString);
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (this.h == null) {
      this.h = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376863));
    }
    TextView localTextView = this.h;
    if (paramBoolean) {}
    for (int k = 0;; k = 8)
    {
      localTextView.setVisibility(k);
      this.h.setText(paramString);
      if (paramInt != 0) {
        this.h.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(paramInt));
      }
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
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    if (this.j == null) {
      this.j = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367684));
    }
    this.j.setVisibility(0);
    this.j.setOnClickListener(paramOnClickListener);
  }
  
  public void b(String paramString, View.OnClickListener paramOnClickListener)
  {
    if (this.i != null)
    {
      this.i.setText(paramString);
      this.i.setOnClickListener(paramOnClickListener);
      d(true);
    }
  }
  
  public void b(String paramString, atlt paramatlt)
  {
    ThreadManager.getUIHandler().post(new SimpleFileViewer.6(this, paramString, paramatlt));
  }
  
  public void b(String paramString, auaw paramauaw)
  {
    ThreadManager.getUIHandler().post(new SimpleFileViewer.8(this, paramString, paramauaw));
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (paramBoolean) {
      d(false);
    }
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
  
  public void c(String paramString)
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(this.jdField_d_of_type_AndroidWidgetTextView.getText())))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
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
    this.jdField_e_of_type_AndroidWidgetTextView.setText(atvo.a(paramString, false, this.jdField_e_of_type_AndroidWidgetTextView.getMeasuredWidth(), this.jdField_e_of_type_AndroidWidgetTextView.getPaint(), 2));
  }
  
  public void d(boolean paramBoolean)
  {
    int k = 0;
    if (this.i != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        break label49;
      }
      if ((paramBoolean) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) {
        this.i.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.i.setVisibility(8);
    return;
    label49:
    TextView localTextView = this.i;
    if (paramBoolean) {}
    for (;;)
    {
      localTextView.setVisibility(k);
      return;
      k = 8;
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Biau != null) && (this.jdField_a_of_type_Biau.isShowing())) {
      this.jdField_a_of_type_Biau.dismiss();
    }
  }
  
  public void e(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView.a(paramInt);
    }
  }
  
  public void e(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setApkIconAsyncImage(paramString);
  }
  
  public void e(boolean paramBoolean)
  {
    TextView localTextView = this.jdField_f_of_type_AndroidWidgetTextView;
    if (paramBoolean) {}
    for (int k = 0;; k = 8)
    {
      localTextView.setVisibility(k);
      return;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView != null) {
      this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView.onStop();
    }
    if (this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView != null) {
      this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView.onStop();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView.a();
    }
  }
  
  public void f(int paramInt)
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
  
  public void f(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setUrlIconAsyncImage(paramString);
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void g(String paramString)
  {
    this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void g(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.j != null)
    {
      localTextView = this.j;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int k = 0;; k = 8)
    {
      localTextView.setVisibility(k);
      return;
    }
  }
  
  public void h(String paramString)
  {
    RelativeLayout localRelativeLayout = this.b;
    if ((localRelativeLayout == null) || (this.jdField_d_of_type_AndroidViewView == null)) {}
    while (!TdsDebugView.a(paramString)) {
      return;
    }
    if (this.jdField_e_of_type_AndroidViewView == null) {
      this.jdField_e_of_type_AndroidViewView = new TdsDebugView(this.jdField_a_of_type_AndroidAppActivity, new atss(this));
    }
    if (localRelativeLayout.indexOfChild(this.jdField_e_of_type_AndroidViewView) < 0)
    {
      paramString = new RelativeLayout.LayoutParams(-1, -1);
      paramString.topMargin = ((int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298998));
      localRelativeLayout.addView(this.jdField_e_of_type_AndroidViewView, paramString);
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void i(String paramString)
  {
    if (this.jdField_a_of_type_Biau == null)
    {
      this.jdField_a_of_type_Biau = new biau(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_Biau.setCancelable(false);
    }
    if (!this.jdField_a_of_type_Biau.isShowing())
    {
      this.jdField_a_of_type_Biau.a(paramString);
      this.jdField_a_of_type_Biau.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer
 * JD-Core Version:    0.7.0.1
 */