package com.tencent.mobileqq.fragment;

import alox;
import alpo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import asda;
import asdb;
import asdc;
import bcws;
import bcwt;
import bdcq;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;

public class ShieldFriendsListFragment
  extends IphoneTitleBarFragment
  implements bcwt
{
  alox jdField_a_of_type_Alox = new asda(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private asdc jdField_a_of_type_Asdc;
  private bcws jdField_a_of_type_Bcws;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  private void a()
  {
    ThreadManager.excute(new ShieldFriendsListFragment.1(this), 16, null, true);
  }
  
  private boolean a(long paramLong, boolean paramBoolean)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      if (localObject != null)
      {
        localObject = (asdb)((View)localObject).getTag();
        if ((localObject != null) && (paramLong == Long.valueOf(((asdb)localObject).jdField_a_of_type_JavaLangString).longValue()))
        {
          if (((asdb)localObject).jdField_a_of_type_ComTencentWidgetSwitch.isChecked() != paramBoolean)
          {
            ((asdb)localObject).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
            ((asdb)localObject).jdField_a_of_type_ComTencentWidgetSwitch.setChecked(paramBoolean);
            ((asdb)localObject).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(((asdb)localObject).jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
          }
          return true;
        }
      }
      i += 1;
    }
    return false;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Asdc.getCount() <= 0)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    super.setTitle(getResources().getString(2131699801));
    this.mContentView.setBackgroundResource(2130838591);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131369541));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131366404));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699802);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 17.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166979));
    paramLayoutInflater = new RelativeLayout.LayoutParams(-2, -2);
    paramLayoutInflater.addRule(13);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramLayoutInflater);
    this.jdField_a_of_type_Bcws = new bcws(getActivity(), getActivity().app);
    this.jdField_a_of_type_Bcws.a(this);
    this.jdField_a_of_type_Asdc = new asdc(getActivity(), this.jdField_a_of_type_Bcws, getActivity().app);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Asdc);
    paramLayoutInflater = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXListView.getLayoutParams();
    paramLayoutInflater.topMargin = ((int)bdcq.a(getActivity(), 12.0F));
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(paramLayoutInflater);
    a();
    getActivity().addObserver(this.jdField_a_of_type_Alox);
    if (AppSetting.c) {
      this.leftView.setContentDescription(alpo.a(2131714377));
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131561300;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShieldFriendsListActivity", 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if (paramBitmap == null) {}
    for (;;)
    {
      return;
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
        if (localObject != null)
        {
          localObject = (asdb)((View)localObject).getTag();
          if ((localObject != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(((asdb)localObject).jdField_a_of_type_JavaLangString)))
          {
            ((asdb)localObject).jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Bcws != null) {
      this.jdField_a_of_type_Bcws.d();
    }
    getActivity().app.removeObserver(this.jdField_a_of_type_Alox);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.ShieldFriendsListFragment
 * JD-Core Version:    0.7.0.1
 */