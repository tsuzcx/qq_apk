package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.troop.file.ZipFilesListAdapter;
import com.tencent.biz.widgets.TriangleView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class ZipFileViewer
  extends FileBrowserViewBase
{
  private ZipFilesListAdapter jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter;
  private TriangleView jdField_a_of_type_ComTencentBizWidgetsTriangleView;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
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
  private TextView h;
  
  public ZipFileViewer(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: ZipFileViewer initFileView");
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2130970037, this.jdField_a_of_type_AndroidViewViewGroup, false);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364105));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368812));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366632));
      this.h = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368813));
      this.jdField_g_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368810);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368809);
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368821);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368819);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368817));
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368814);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131368816));
      this.jdField_a_of_type_ComTencentBizWidgetsTriangleView = ((TriangleView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367241));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368820));
      this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368780));
      this.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter = new ZipFilesListAdapter(null, this.jdField_a_of_type_AndroidAppActivity);
    }
  }
  
  public void a(CharSequence paramCharSequence, MovementMethod paramMovementMethod)
  {
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    b(false);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(paramMovementMethod);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramCharSequence);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_g_of_type_AndroidWidgetTextView.setText(paramString1);
    this.h.setText(paramString2);
  }
  
  public void a(List paramList, String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.a(paramList);
    this.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.e = "/";
    this.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.jdField_b_of_type_Long = paramLong1;
    this.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.jdField_a_of_type_Long = paramLong2;
    this.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.c = paramString3;
    this.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.d = paramString4;
    this.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.jdField_a_of_type_JavaLangString = paramString5;
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368780);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      localView.setOnClickListener(paramOnClickListener);
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, View.OnClickListener paramOnClickListener)
  {
    TextView localTextView = this.jdField_e_of_type_AndroidWidgetTextView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
      return;
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter != null) {
      this.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter.notifyDataSetChanged();
    }
  }
  
  public void c()
  {
    this.jdField_c_of_type_AndroidViewView.setPadding(0, this.jdField_c_of_type_AndroidViewView.getPaddingTop(), 0, 0);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void c(String paramString)
  {
    this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.jdField_e_of_type_AndroidWidgetTextView != null)
    {
      localTextView = this.jdField_e_of_type_AndroidWidgetTextView;
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
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838210);
      this.jdField_a_of_type_ComTencentBizWidgetsTriangleView.setColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131492923));
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131494129));
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#ffffffff"));
    this.jdField_a_of_type_ComTencentBizWidgetsTriangleView.setColor(Color.parseColor("#ffffffff"));
    this.jdField_g_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#fff7f7f8"));
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131494128));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.ZipFileViewer
 * JD-Core Version:    0.7.0.1
 */