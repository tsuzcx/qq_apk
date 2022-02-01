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
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;

public class ShieldFriendsListFragment
  extends IphoneTitleBarFragment
  implements DecodeTaskCompletionListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ShieldFriendsListFragment.2(this);
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private ShieldFriendsListFragment.ShieldFriendsAdapter jdField_a_of_type_ComTencentMobileqqFragmentShieldFriendsListFragment$ShieldFriendsAdapter;
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
        localObject = (ShieldFriendsListFragment.Holder)((View)localObject).getTag();
        if ((localObject != null) && (paramLong == Long.valueOf(((ShieldFriendsListFragment.Holder)localObject).jdField_a_of_type_JavaLangString).longValue()))
        {
          if (((ShieldFriendsListFragment.Holder)localObject).jdField_a_of_type_ComTencentWidgetSwitch.isChecked() != paramBoolean)
          {
            ((ShieldFriendsListFragment.Holder)localObject).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
            ((ShieldFriendsListFragment.Holder)localObject).jdField_a_of_type_ComTencentWidgetSwitch.setChecked(paramBoolean);
            ((ShieldFriendsListFragment.Holder)localObject).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(((ShieldFriendsListFragment.Holder)localObject).jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
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
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentShieldFriendsListFragment$ShieldFriendsAdapter.getCount() <= 0)
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
    super.setTitle(getResources().getString(2131699168));
    this.mContentView.setBackgroundResource(2130838979);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131370493));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131367045));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699169);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 17.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167117));
    paramLayoutInflater = new RelativeLayout.LayoutParams(-2, -2);
    paramLayoutInflater.addRule(13);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramLayoutInflater);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)getActivity().app.getRuntimeService(IQQAvatarService.class, "")).getInstance(getActivity().app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFragmentShieldFriendsListFragment$ShieldFriendsAdapter = new ShieldFriendsListFragment.ShieldFriendsAdapter(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, getActivity().app);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFragmentShieldFriendsListFragment$ShieldFriendsAdapter);
    paramLayoutInflater = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXListView.getLayoutParams();
    paramLayoutInflater.topMargin = ((int)DisplayUtils.a(getActivity(), 12.0F));
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(paramLayoutInflater);
    a();
    getActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (AppSetting.d) {
      this.leftView.setContentDescription(HardCodeUtil.a(2131713943));
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131561644;
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
          localObject = (ShieldFriendsListFragment.Holder)((View)localObject).getTag();
          if ((localObject != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(((ShieldFriendsListFragment.Holder)localObject).jdField_a_of_type_JavaLangString)))
          {
            ((ShieldFriendsListFragment.Holder)localObject).jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
    getActivity().app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.ShieldFriendsListFragment
 * JD-Core Version:    0.7.0.1
 */