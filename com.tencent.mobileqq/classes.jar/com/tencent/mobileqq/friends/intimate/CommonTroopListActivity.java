package com.tencent.mobileqq.friends.intimate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import auyz;
import auza;
import bdla;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo.CommonTroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.widget.ListView;
import java.util.ArrayList;

public class CommonTroopListActivity
  extends IphoneTitleBarFragment
{
  private int jdField_a_of_type_Int = -1;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new auyz(this);
  private auza jdField_a_of_type_Auza;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private ArrayList<IntimateInfo.CommonTroopInfo> jdField_a_of_type_JavaUtilArrayList;
  
  public static void a(Context paramContext, ArrayList<IntimateInfo.CommonTroopInfo> paramArrayList, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("common_troop_list", paramArrayList);
    localIntent.putExtra("report_friend_type", paramInt);
    PublicFragmentActivity.a(paramContext, localIntent, CommonTroopListActivity.class);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)this.mContentView.findViewById(2131365020));
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
    {
      setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131693306));
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("report_friend_type", -1);
      this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getParcelableArrayListExtra("common_troop_list");
      this.jdField_a_of_type_Auza = new auza(this, null);
      this.jdField_a_of_type_Auza.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Auza);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
    }
    bdla.b(null, "dc00898", "", "", "0X8009F53", "0X8009F53", this.jdField_a_of_type_Int, 0, "", "", "", "");
  }
  
  public int getContentLayoutId()
  {
    return 2131559327;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friends.intimate.CommonTroopListActivity
 * JD-Core Version:    0.7.0.1
 */