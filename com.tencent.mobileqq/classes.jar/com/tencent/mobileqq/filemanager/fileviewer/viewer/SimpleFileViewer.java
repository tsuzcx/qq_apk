package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import adfu;
import adfv;
import adfw;
import android.app.Activity;
import android.content.SharedPreferences;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager.LocalTbsViewManagerCallback;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsReaderView;

public class SimpleFileViewer
  extends FileBrowserViewBase
{
  AsyncImageView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private TbsReaderView jdField_a_of_type_ComTencentSmttSdkTbsReaderView;
  private RelativeLayout b;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private View jdField_g_of_type_AndroidViewView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  
  public SimpleFileViewer(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public View a()
  {
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView != null))
    {
      QLog.e("FileBrowserViewBase", 2, "getInnerFileView : tbs not null");
      this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: SimpleFileViewer initFileView");
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130970042, this.jdField_a_of_type_AndroidViewViewGroup, false);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368731));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368728));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368729));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368730));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368847));
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
    this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramSpannableString);
    this.jdField_c_of_type_AndroidWidgetTextView.setHighlightColor(17170445);
  }
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      break label4;
    }
    label4:
    while ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView == null) || (!(BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface))) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(11, 1);
    ((RelativeLayout.LayoutParams)localObject).addRule(12, 1);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = 70;
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = 140;
    this.jdField_e_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130968830, this.jdField_a_of_type_AndroidViewViewGroup, false);
    this.jdField_e_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_e_of_type_AndroidViewView);
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    this.jdField_f_of_type_AndroidViewView = this.jdField_e_of_type_AndroidViewView.findViewById(2131363987);
    this.jdField_g_of_type_AndroidViewView = this.jdField_e_of_type_AndroidViewView.findViewById(2131363988);
    localObject = localQQAppInterface.getApp().getSharedPreferences("tim_convert_teamwork_pre_" + localQQAppInterface.c(), 4);
    boolean bool1 = ((SharedPreferences)localObject).getBoolean("tim_convert_teamwork_open_with_share_doc", false);
    boolean bool2 = ((SharedPreferences)localObject).getBoolean("tim_convert_teamwork_open_file_in_tim", false);
    if (!bool1)
    {
      if (this.jdField_f_of_type_AndroidViewView != null) {
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      }
      label241:
      if (bool2) {
        break label348;
      }
      if (this.jdField_g_of_type_AndroidViewView != null) {
        this.jdField_g_of_type_AndroidViewView.setVisibility(8);
      }
    }
    for (;;)
    {
      if ((this.jdField_f_of_type_AndroidViewView != null) && (bool1)) {
        this.jdField_f_of_type_AndroidViewView.setOnClickListener(new adfv(this, localQQAppInterface, paramTeamWorkFileImportInfo));
      }
      if ((this.jdField_g_of_type_AndroidViewView == null) || (!bool2)) {
        break;
      }
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(new adfw(this, localQQAppInterface, paramTeamWorkFileImportInfo));
      return;
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009064", "0X8009064", 0, 0, "", "", "", "");
      break label241;
      label348:
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8008A30", "0X8008A30", 0, 0, "", "", "", "");
    }
  }
  
  public void a(String paramString, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView = LocalTbsViewManager.a().a(this.jdField_a_of_type_AndroidAppActivity, paramString, paramLocalTbsViewManagerCallback);
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) && (this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView != null))
    {
      if (this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView.getParent()).removeAllViews();
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
      paramString = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView, 0, paramString);
      if (paramBoolean)
      {
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(12);
        if (this.jdField_c_of_type_AndroidViewView == null)
        {
          this.jdField_c_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130970033, this.jdField_a_of_type_AndroidViewViewGroup, false);
          paramLocalTbsViewManagerCallback = this.jdField_c_of_type_AndroidViewView.findViewById(2131368828);
          View localView = this.jdField_c_of_type_AndroidViewView.findViewById(2131368827);
          this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131368826);
          localView.setOnClickListener(paramOnClickListener);
          paramLocalTbsViewManagerCallback.setOnClickListener(paramOnClickListener);
          this.jdField_c_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView, 1, paramString);
      }
    }
    e();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_f_of_type_AndroidWidgetTextView == null) {
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368848));
    }
    TextView localTextView = this.jdField_f_of_type_AndroidWidgetTextView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString);
      return;
    }
  }
  
  public void a(String paramString, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_g_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368851));
      this.jdField_g_of_type_AndroidWidgetTextView.setHighlightColor(17170445);
    }
    paramString = this.jdField_g_of_type_AndroidWidgetTextView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      paramString.setVisibility(i);
      this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
      return;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_ComTencentSmttSdkTbsReaderView != null) && (this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) && (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  public View b()
  {
    return this.jdField_e_of_type_AndroidViewView;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(paramInt);
  }
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void c()
  {
    if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(paramInt);
  }
  
  public void c(String paramString)
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView.getMeasuredWidth() <= 0)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.post(new adfu(this, paramString));
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(FileManagerUtil.a(paramString, false, this.jdField_d_of_type_AndroidWidgetTextView.getMeasuredWidth(), this.jdField_d_of_type_AndroidWidgetTextView.getPaint(), 2));
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void d(int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams;
    if (this.jdField_d_of_type_AndroidViewView != null) {
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
    }
    switch (paramInt)
    {
    default: 
      localLayoutParams.weight = 72.0F;
      return;
    case 1: 
      localLayoutParams.weight = 72.0F;
      return;
    }
    localLayoutParams.weight = 584.0F;
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setApkIconAsyncImage(paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    TextView localTextView = this.jdField_e_of_type_AndroidWidgetTextView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void e()
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent();
    if ((localViewGroup != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null))
    {
      localViewGroup.removeAllViews();
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localViewGroup.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 0, localLayoutParams);
    }
  }
  
  public void e(String paramString)
  {
    this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void e(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.jdField_g_of_type_AndroidWidgetTextView != null)
    {
      localTextView = this.jdField_g_of_type_AndroidWidgetTextView;
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
  
  public void f()
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer
 * JD-Core Version:    0.7.0.1
 */