package com.tencent.mobileqq.fragment;

import actn;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import aqjh;
import bfpc;
import bgkh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import onk;
import xpx;

public class SDKSetEmotionPreviewFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, bfpc
{
  private int jdField_a_of_type_Int;
  private aqjh jdField_a_of_type_Aqjh;
  private GridView jdField_a_of_type_ComTencentWidgetGridView;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private int b;
  
  private void a()
  {
    this.jdField_a_of_type_Aqjh = new aqjh(this);
    this.jdField_a_of_type_ComTencentWidgetGridView.setAdapter(this.jdField_a_of_type_Aqjh);
    this.jdField_a_of_type_Aqjh.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void a(View paramView)
  {
    Object localObject = getResources();
    int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
    int j = actn.a(0.0F, (Resources)localObject);
    int k = actn.a(4.0F, (Resources)localObject);
    int m = actn.a(4.0F, (Resources)localObject);
    this.jdField_a_of_type_Int = ((i - j * 2 - k * 3) / 4);
    this.b = this.jdField_a_of_type_Int;
    localObject = ((Resources)localObject).getString(2131691343);
    setTitle((CharSequence)localObject, (String)localObject);
    this.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131365592));
    this.jdField_a_of_type_ComTencentWidgetGridView.setScrollBarStyle(0);
    this.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(4);
    this.jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(k);
    this.jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(m);
    this.jdField_a_of_type_ComTencentWidgetGridView.setPadding(j, this.jdField_a_of_type_ComTencentWidgetGridView.getPaddingTop(), j, this.jdField_a_of_type_ComTencentWidgetGridView.getPaddingBottom());
    this.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetGridView.setMaximumVelocity((int)(2500.0F * getResources().getDisplayMetrics().density));
  }
  
  public static void a(String paramString, Context paramContext, View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (QLog.isColorLevel()) {
      QLog.d("SDKSetEmotionPreviewFragment", 2, "startToAioImagePreviewWithPath: path=" + paramString);
    }
    if ((localQQAppInterface == null) || (paramContext == null)) {}
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    AIOImageData localAIOImageData = new AIOImageData();
    localAIOImageData.a = paramString;
    localAIOImageData.b = paramString;
    localAIOImageData.c = paramString;
    localAIOImageData.e = false;
    paramString = new Bundle();
    if (paramView != null) {
      paramString.putParcelable("KEY_THUMBNAL_BOUND", xpx.a(paramView));
    }
    bgkh.a(paramContext, paramString, new AIOImageProviderService(localQQAppInterface.c(), null, 0, null), localAIOImageData, -1, 4);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    a(this.mContentView);
    a();
  }
  
  protected int getContentLayoutId()
  {
    return 2131559033;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    return super.onBackEvent();
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getActivity().getIntent();
    if (paramBundle != null) {
      this.jdField_a_of_type_JavaUtilArrayList = paramBundle.getStringArrayListExtra("path_list");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    onk.a(getActivity());
    if (this.leftView != null)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setContentDescription(getString(2131690331));
      this.leftView.setBackgroundResource(2130848492);
    }
    if (this.centerView != null) {
      this.centerView.setTextColor(-16777216);
    }
    if (this.vg != null) {
      this.vg.setBackgroundColor(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.SDKSetEmotionPreviewFragment
 * JD-Core Version:    0.7.0.1
 */