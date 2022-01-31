package com.tencent.mobileqq.fragment;

import ajjh;
import ajjy;
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
import appv;
import appw;
import appx;
import azwg;
import azwh;
import bacc;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;

public class ShieldFriendsListFragment
  extends IphoneTitleBarFragment
  implements azwh
{
  ajjh jdField_a_of_type_Ajjh = new appv(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private appx jdField_a_of_type_Appx;
  private azwg jdField_a_of_type_Azwg;
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
        localObject = (appw)((View)localObject).getTag();
        if ((localObject != null) && (paramLong == Long.valueOf(((appw)localObject).jdField_a_of_type_JavaLangString).longValue()))
        {
          if (((appw)localObject).jdField_a_of_type_ComTencentWidgetSwitch.isChecked() != paramBoolean)
          {
            ((appw)localObject).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
            ((appw)localObject).jdField_a_of_type_ComTencentWidgetSwitch.setChecked(paramBoolean);
            ((appw)localObject).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(((appw)localObject).jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
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
    if (this.jdField_a_of_type_Appx.getCount() <= 0)
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
    super.setTitle(getResources().getString(2131633669));
    this.mContentView.setBackgroundResource(2130838503);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131303636));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131300703));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131633670);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 17.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131101336));
    paramLayoutInflater = new RelativeLayout.LayoutParams(-2, -2);
    paramLayoutInflater.addRule(13);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramLayoutInflater);
    this.jdField_a_of_type_Azwg = new azwg(getActivity(), getActivity().app);
    this.jdField_a_of_type_Azwg.a(this);
    this.jdField_a_of_type_Appx = new appx(getActivity(), this.jdField_a_of_type_Azwg, getActivity().app);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Appx);
    paramLayoutInflater = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXListView.getLayoutParams();
    paramLayoutInflater.topMargin = ((int)bacc.a(getActivity(), 12.0F));
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(paramLayoutInflater);
    a();
    getActivity().addObserver(this.jdField_a_of_type_Ajjh);
    if (AppSetting.c) {
      this.leftView.setContentDescription(ajjy.a(2131648206));
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131495526;
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
          localObject = (appw)((View)localObject).getTag();
          if ((localObject != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(((appw)localObject).jdField_a_of_type_JavaLangString)))
          {
            ((appw)localObject).jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
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
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.d();
    }
    getActivity().app.removeObserver(this.jdField_a_of_type_Ajjh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.ShieldFriendsListFragment
 * JD-Core Version:    0.7.0.1
 */