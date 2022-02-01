package com.tencent.mobileqq.fragment;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
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
    super.setTitle(getResources().getString(2131699272));
    this.mContentView.setBackgroundResource(2130838739);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131370153));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131366895));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699273);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 17.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167142));
    paramLayoutInflater = new RelativeLayout.LayoutParams(-2, -2);
    paramLayoutInflater.addRule(13);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramLayoutInflater);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)getBaseActivity().app.getRuntimeService(IQQAvatarService.class, "")).getInstance(getBaseActivity().app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFragmentShieldFriendsListFragment$ShieldFriendsAdapter = new ShieldFriendsListFragment.ShieldFriendsAdapter(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, getBaseActivity().app);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFragmentShieldFriendsListFragment$ShieldFriendsAdapter);
    paramLayoutInflater = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXListView.getLayoutParams();
    paramLayoutInflater.topMargin = ((int)DisplayUtils.a(getBaseActivity(), 12.0F));
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(paramLayoutInflater);
    a();
    getBaseActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (AppSetting.d) {
      this.leftView.setContentDescription(HardCodeUtil.a(2131713874));
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131561494;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", type=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",avatar= ");
      ((StringBuilder)localObject).append(paramBitmap);
      QLog.d("ShieldFriendsListActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBitmap == null) {
      return;
    }
    paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
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
  
  public void onDestroy()
  {
    super.onDestroy();
    IFaceDecoder localIFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
    getBaseActivity().app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.ShieldFriendsListFragment
 * JD-Core Version:    0.7.0.1
 */