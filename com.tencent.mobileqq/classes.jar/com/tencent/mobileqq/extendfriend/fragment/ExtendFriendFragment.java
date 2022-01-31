package com.tencent.mobileqq.extendfriend.fragment;

import achx;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager.ExtendFriendConfig;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendResourceUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery.LayoutParams;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;

public class ExtendFriendFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new achx(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ExtendFriendManager jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager;
  private ExtendFriendGroupFragment jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment;
  private ExtendFriendSquareFragment jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "loadSquareFragment");
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130842492);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-10776065);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130842493);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment == null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment = new ExtendFriendSquareFragment();
      }
      if (this.jdField_a_of_type_AndroidSupportV4AppFragment == this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment) {
        break label175;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.isAdded()) {
        break label147;
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment).add(2131363551, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment, "squareFragment").commit();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragment = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment;
      return;
      label147:
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment).show(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment).commit();
    }
    label175:
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.b();
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "loadGroupFragment");
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130842491);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130842494);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-10776065);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment == null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment = new ExtendFriendGroupFragment();
      }
      if (this.jdField_a_of_type_AndroidSupportV4AppFragment == this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment) {
        break label189;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment.isAdded()) {
        break label161;
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment).add(2131363551, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment, "groupFragment").commit();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragment = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment;
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.d();
      }
      return;
      label161:
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment).show(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment).commit();
    }
    label189:
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment.a();
  }
  
  private void d()
  {
    Object localObject3 = null;
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getApp().getSharedPreferences(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getCurrentAccountUin(), 0);
    Object localObject1;
    Object localObject4;
    if ((!localSharedPreferences.getBoolean("pref_extend_friend_has_show_first_guide", false)) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2130970330, null));
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
      localObject1 = this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131370087);
      localObject4 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject4).topMargin += ImmersiveUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject4 = ExtendFriendResourceUtil.a("expand_guide_wording.png");
      localObject1 = localObject3;
      if (!new File((String)localObject4).exists()) {}
    }
    try
    {
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.RGB_565;
      localObject1 = ExtendFriendResourceUtil.a((String)localObject4, (BitmapFactory.Options)localObject1);
      ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131370088)).setImageBitmap((Bitmap)localObject1);
      this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131370089).setOnClickListener(this);
      localObject1 = new Gallery.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_b_of_type_AndroidViewViewGroup, (ViewGroup.LayoutParams)localObject1);
      localObject1 = localSharedPreferences.edit();
      if (localObject1 != null) {
        ((SharedPreferences.Editor)localObject1).putBoolean("pref_extend_friend_has_show_first_guide", true).apply();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ExtendFriendFragment", 1, "showFirstGuide decode bitmap fail.", localException);
        Object localObject2 = localObject3;
      }
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_b_of_type_AndroidViewViewGroup != null))
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_b_of_type_AndroidViewViewGroup);
      this.jdField_b_of_type_AndroidViewViewGroup = null;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, String.format("onActivityResult requestCode=%s resultCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (((paramInt1 == 1031) || (paramInt1 == 1) || (paramInt1 == 2)) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment != null)) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131370072: 
    case 2131370076: 
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null);
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.doOnBackPressed();
        return;
      } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null);
      paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getCurrentAccountUin(), 0);
      ProfileActivity.b(getActivity(), paramView, 1031);
      ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092D1", "0X80092D1", 0, 0, "", "", "", "");
      return;
    case 2131370089: 
      e();
      return;
    case 2131370073: 
      b();
      ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092D2", "0X80092D2", 0, 0, "", "", "", "");
      return;
    }
    c();
    ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092D3", "0X80092D3", 0, 0, "", "", "", "");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager = ((ExtendFriendManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(263));
    paramBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow();
    if (paramBundle != null)
    {
      paramBundle.setFormat(-3);
      paramBundle.setBackgroundDrawable(new ColorDrawable(-1));
      paramBundle.setFlags(1024, 1024);
      paramBundle.setFlags(2048, 2048);
    }
    ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092F0", "0X80092F0", 0, 0, "", "", "", "");
    ExtendFriendReport.a().a();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2130970326, null));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363380);
    paramViewGroup = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370072);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370073));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370074));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370075));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370076);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362371);
    if (paramLayoutInflater != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
      localLayoutParams.topMargin = ImmersiveUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      paramLayoutInflater.setLayoutParams(localLayoutParams);
    }
    if (paramViewGroup != null) {
      paramViewGroup.setOnClickListener(this);
    }
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    }
    int i;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      if (bool)
      {
        i = 0;
        paramLayoutInflater.setVisibility(i);
      }
    }
    else
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager != null)
      {
        paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a();
        if (paramLayoutInflater != null)
        {
          if (paramLayoutInflater.h != 1) {
            break label365;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.c.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      if (paramBundle != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment = ((ExtendFriendSquareFragment)this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("squareFragment"));
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment = ((ExtendFriendGroupFragment)this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("groupFragment"));
      }
      b();
      return this.jdField_a_of_type_AndroidViewViewGroup;
      i = 8;
      break;
      label365:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.c.setVisibility(0);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "onDestroy");
    }
    int i = (int)((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L);
    if ((this.jdField_a_of_type_Long > 0L) && (i > 0) && (i < 86400))
    {
      ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092EF", "0X80092EF", 0, i, "", "", "", "");
      ExtendFriendReport.a().a(i);
    }
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment
 * JD-Core Version:    0.7.0.1
 */