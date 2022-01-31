package com.tencent.mobileqq.troopAddFrd;

import adpn;
import ahkp;
import ahkz;
import alto;
import amdu;
import ameq;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import azqs;
import bctx;
import bcty;
import bcub;
import bcuc;
import bcud;
import bcue;
import bcuf;
import bdbk;
import bdgc;
import bdin;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class TroopRecommendFriendFragment
  extends IphoneTitleBarFragment
{
  private int jdField_a_of_type_Int = 0;
  private ahkp<bcty> jdField_a_of_type_Ahkp;
  private amdu jdField_a_of_type_Amdu;
  private final ameq jdField_a_of_type_Ameq = new bcuf(this);
  private View jdField_a_of_type_AndroidViewView;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int b;
  private int c;
  
  private String a(String paramString)
  {
    alto localalto = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localalto.b(paramString)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692867);
    }
    if (localalto.a(paramString, false)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699983);
    }
    return null;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Ahkp = new bcuc(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131559783);
    this.jdField_a_of_type_Ahkp.a(2131561328);
    this.jdField_a_of_type_Ahkp.a(new bcud(this));
  }
  
  private void a(ahkz paramahkz, bcty parambcty, int paramInt)
  {
    if ((paramahkz == null) || (parambcty == null)) {}
    Object localObject;
    do
    {
      return;
      ((bctx)paramahkz).a = parambcty;
      localObject = (ImageView)paramahkz.a(2131361795);
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(bdbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, parambcty.jdField_a_of_type_JavaLangString));
      }
      localObject = (TextView)paramahkz.a(2131371161);
      if (localObject != null) {
        ((TextView)localObject).setText(parambcty.jdField_b_of_type_JavaLangString);
      }
      localObject = (TextView)paramahkz.a(2131370121);
      if (localObject != null) {
        ((TextView)localObject).setText(parambcty.c);
      }
      localObject = (TroopLabelLayout)paramahkz.a(2131378430);
      if (localObject != null) {
        ((TroopLabelLayout)localObject).a(parambcty.jdField_a_of_type_JavaUtilArrayList, parambcty.jdField_a_of_type_Int, parambcty.jdField_b_of_type_Int, 1);
      }
      localObject = (Button)paramahkz.a(2131375716);
      paramahkz = (TextView)paramahkz.a(2131375726);
    } while ((localObject == null) || (paramahkz == null));
    String str = a(parambcty.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty(str))
    {
      paramahkz.setVisibility(8);
      ((Button)localObject).setVisibility(0);
      ((Button)localObject).setText(2131689628);
      ((Button)localObject).setOnClickListener(new bcue(this, parambcty));
      return;
    }
    paramahkz.setVisibility(0);
    paramahkz.setText(str);
    ((Button)localObject).setVisibility(8);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    adpn.a(paramContext, paramIntent, PublicFragmentActivity.class, TroopRecommendFriendFragment.class);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131375451);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)paramView.findViewById(2131378490));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addOnScrollListener(new bcub(this));
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopRecommendFriendFragment", 2, "addFriend troopUin = " + paramString1 + ", memberUin =" + paramString2 + ", troopCode =" + paramString3);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    String str = bdgc.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
    int i = this.jdField_b_of_type_Int;
    paramString2 = AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramString2, paramString3, 3004, i, str, null, null, null, null);
    paramString2.putExtra("need_result_uin", true);
    paramString2.putExtra("troop_uin", paramString1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(paramString2, 11);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Ahkp);
    if (!bdin.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694768), 0).a();
      return;
    }
    c();
  }
  
  private void c()
  {
    amdu localamdu;
    String str;
    int i;
    byte[] arrayOfByte;
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      localamdu = this.jdField_a_of_type_Amdu;
      str = this.jdField_a_of_type_JavaLangString;
      i = this.c;
      arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        break label55;
      }
    }
    label55:
    for (ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;; localArrayList = null)
    {
      localamdu.a(str, 2, i, arrayOfByte, 50, localArrayList);
      return;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ArrayOfByte != null) {
      c();
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ameq);
    a(this.mContentView);
    a();
    b();
  }
  
  public int getContentLayoutId()
  {
    return 2131559756;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface());
    this.jdField_a_of_type_Amdu = ((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("troopUin");
    this.c = paramBundle.getIntExtra("grayType", 0);
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("grayTypeSubId", 0);
    paramBundle = paramBundle.getSerializableExtra("grayUinList");
    if ((paramBundle instanceof ArrayList)) {
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramBundle);
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopRecommendFriendFragment", 2, "onCreate mSubId " + this.jdField_b_of_type_Int + " mTroopUin =" + this.jdField_a_of_type_JavaLangString + " mGrayTipType =" + this.c);
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD50", "0X800AD50", 0, 0, "", "", "", "");
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131689648));
    return localView;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ameq);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    super.onDestroy();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Ahkp != null) {
      this.jdField_a_of_type_Ahkp.notifyDataSetChanged();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopAddFrd.TroopRecommendFriendFragment
 * JD-Core Version:    0.7.0.1
 */