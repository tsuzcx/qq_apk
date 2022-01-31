package com.tencent.mobileqq.troop.fragment;

import airs;
import airt;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.troop.widget.ExpandableTextView;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.text.SimpleDateFormat;

public class TroopMoreDetailFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new airt(this);
  ExpandableTextView jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView;
  public TroopMoreDetailView a;
  public TroopInfoData a;
  public String a;
  boolean jdField_a_of_type_Boolean;
  public boolean b = false;
  ImageView c;
  TextView g;
  TextView h;
  TextView i;
  TextView j;
  
  private View a(int paramInt)
  {
    return this.e.findViewById(paramInt);
  }
  
  private QQAppInterface a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && ((localFragmentActivity.getAppInterface() instanceof QQAppInterface))) {
      return (QQAppInterface)localFragmentActivity.getAppInterface();
    }
    return null;
  }
  
  private String a(long paramLong)
  {
    Object localObject = "";
    if (paramLong > 0L)
    {
      localObject = new SimpleDateFormat("yyyy年MM月dd日");
      localObject = getResources().getString(2131430410) + ((SimpleDateFormat)localObject).format(Long.valueOf(1000L * paramLong));
    }
    return localObject;
  }
  
  public static void a(Activity paramActivity, TroopInfoData paramTroopInfoData, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_troop_info_data", paramTroopInfoData);
    localIntent.putExtra("key_qidian_private_troop", paramBoolean);
    PublicFragmentActivity.a(paramActivity, localIntent, TroopMoreDetailFragment.class);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131363667));
    this.g = ((TextView)a(2131364607));
    this.c = ((ImageView)a(2131366563));
    this.h = ((TextView)a(2131368429));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView = ((ExpandableTextView)a(2131368455));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView = ((TroopMoreDetailView)a(2131368456));
    this.i = ((TextView)a(2131368430));
    this.j = ((TextView)a(2131368431));
  }
  
  private void c()
  {
    a("更多资料");
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName);
    this.g.setText(this.jdField_a_of_type_JavaLangString);
    String str2 = a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
    String str1 = str2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
      str1 = str2 + "\r\n" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setText(new QQText(str1, 11, 15));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.a().setEditableFactory(QQTextBuilder.a);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.a().setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setOnExpandStateChangeListener(new airs(this));
    int k;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L) {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwAuthGroupType == 2L) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwAuthGroupType == 1L))
      {
        this.c.setVisibility(0);
        this.c.setOnClickListener(this);
        k = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800000) != 8388608L) {
          k = 0;
        }
        if ((k <= 0) || (this.jdField_a_of_type_Boolean)) {
          break label385;
        }
        str1 = String.format(getResources().getString(2131433491), new Object[] { Integer.valueOf(k) });
        this.h.setText(str1);
        this.h.setContentDescription(str1);
        this.h.setVisibility(0);
        this.h.setOnClickListener(this);
        label309:
        if (!this.jdField_a_of_type_Boolean) {
          break label397;
        }
        this.i.setVisibility(8);
        this.j.setVisibility(8);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.setGuestVisitor(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.setTroopInfoData(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.a();
      return;
      this.c.setVisibility(8);
      break;
      this.c.setVisibility(8);
      break;
      label385:
      this.h.setVisibility(8);
      break label309;
      label397:
      this.i.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 1)
      {
        this.i.setVisibility(8);
        label425:
        if ((!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) || (!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {
          break label611;
        }
      }
      label611:
      for (k = 1;; k = 0)
      {
        if (k == 0) {
          break label616;
        }
        this.j.setVisibility(0);
        this.j.setText(getResources().getString(2131433492));
        this.j.setContentDescription(getResources().getString(2131433492));
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 0)
        {
          this.i.setVisibility(8);
          break label425;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 2)
        {
          this.i.setText(getString(2131429837));
          break label425;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 3) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 4))
        {
          this.i.setText(getString(2131429837));
          break label425;
        }
        this.i.setVisibility(8);
        break label425;
      }
      label616:
      this.j.setVisibility(8);
    }
  }
  
  private void d()
  {
    if (getActivity() == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = a();
      } while (localObject == null);
      localObject = (TroopHandler)((QQAppInterface)localObject).a(20);
    } while (localObject == null);
    ((TroopHandler)localObject).a(1, BizTroopHandler.a(this.jdField_a_of_type_JavaLangString), 0L, 2, 11, 0);
  }
  
  protected int a()
  {
    return 2130969929;
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("key_qidian_private_troop", false);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = ((TroopInfoData)paramBundle.getSerializable("key_troop_info_data"));
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = getActivity();
    if (paramLayoutInflater == null) {}
    while (!(paramLayoutInflater.getAppInterface() instanceof QQAppInterface)) {
      return;
    }
    paramLayoutInflater.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    b();
    c();
    d();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1) {
      return;
    }
    switch (paramInt1)
    {
    }
  }
  
  public void onClick(View paramView)
  {
    if (UIUtils.b()) {}
    do
    {
      return;
      localObject = getActivity();
    } while ((localObject == null) || ((QQAppInterface)((FragmentActivity)localObject).getAppInterface() == null));
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_a_of_type_JavaLangString });
    Object localObject = new Intent((Context)localObject, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
    ((Intent)localObject).putExtra("url", paramView);
    super.startActivity((Intent)localObject);
  }
  
  public void onDestroyView()
  {
    this.b = true;
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    localFragmentActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.fragment.TroopMoreDetailFragment
 * JD-Core Version:    0.7.0.1
 */