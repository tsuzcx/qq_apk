package com.tencent.mobileqq.fragment;

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
import anvi;
import anvx;
import auyc;
import auyd;
import auye;
import bhdz;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;

public class ShieldFriendsListFragment
  extends IphoneTitleBarFragment
  implements FaceDecoder.DecodeTaskCompletionListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  anvi jdField_a_of_type_Anvi = new auyc(this);
  private auye jdField_a_of_type_Auye;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
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
        localObject = (auyd)((View)localObject).getTag();
        if ((localObject != null) && (paramLong == Long.valueOf(((auyd)localObject).jdField_a_of_type_JavaLangString).longValue()))
        {
          if (((auyd)localObject).jdField_a_of_type_ComTencentWidgetSwitch.isChecked() != paramBoolean)
          {
            ((auyd)localObject).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
            ((auyd)localObject).jdField_a_of_type_ComTencentWidgetSwitch.setChecked(paramBoolean);
            ((auyd)localObject).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(((auyd)localObject).jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
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
    if (this.jdField_a_of_type_Auye.getCount() <= 0)
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
    super.setTitle(getResources().getString(2131698850));
    this.mContentView.setBackgroundResource(2130838911);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131370221));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131366855));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698851);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 17.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167110));
    paramLayoutInflater = new RelativeLayout.LayoutParams(-2, -2);
    paramLayoutInflater.addRule(13);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramLayoutInflater);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(getActivity(), getActivity().app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_Auye = new auye(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, getActivity().app);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Auye);
    paramLayoutInflater = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXListView.getLayoutParams();
    paramLayoutInflater.topMargin = ((int)bhdz.a(getActivity(), 12.0F));
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(paramLayoutInflater);
    a();
    getActivity().addObserver(this.jdField_a_of_type_Anvi);
    if (AppSetting.c) {
      this.leftView.setContentDescription(anvx.a(2131713447));
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131561529;
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
          localObject = (auyd)((View)localObject).getTag();
          if ((localObject != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(((auyd)localObject).jdField_a_of_type_JavaLangString)))
          {
            ((auyd)localObject).jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
    getActivity().app.removeObserver(this.jdField_a_of_type_Anvi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.ShieldFriendsListFragment
 * JD-Core Version:    0.7.0.1
 */