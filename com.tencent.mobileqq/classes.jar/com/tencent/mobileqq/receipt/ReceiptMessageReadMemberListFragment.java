package com.tencent.mobileqq.receipt;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import avpb;
import avpc;
import baxy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ReceiptMessageReadMemberListFragment
  extends Fragment
{
  private View jdField_a_of_type_AndroidViewView;
  private baxy jdField_a_of_type_Baxy;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  @Nonnull
  public static ReceiptMessageReadMemberListFragment a(@Nonnull ArrayList<ReceiptMessageReadMemberListFragment.MemberInfo> paramArrayList, @Nullable String paramString)
  {
    ReceiptMessageReadMemberListFragment localReceiptMessageReadMemberListFragment = new ReceiptMessageReadMemberListFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("ReceiptMessageReadMemberListFragment.EXTRA_KEY_MEMBER_LIST", paramArrayList);
    localBundle.putString("ReceiptMessageReadMemberListFragment.EXTRA_KEY_EMPTY_TEXT", paramString);
    localReceiptMessageReadMemberListFragment.setArguments(localBundle);
    return localReceiptMessageReadMemberListFragment;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((getActivity().getAppInterface() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
      return;
    }
    throw new IllegalStateException("only allow used in main process");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131558596, paramViewGroup, false);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Baxy.d();
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramBundle = getArguments();
    paramView = paramBundle.getParcelableArrayList("ReceiptMessageReadMemberListFragment.EXTRA_KEY_MEMBER_LIST");
    paramBundle = paramBundle.getString("ReceiptMessageReadMemberListFragment.EXTRA_KEY_EMPTY_TEXT");
    if (((paramView == null) || (paramView.isEmpty())) && (!TextUtils.isEmpty(paramBundle)))
    {
      localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131365675);
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365679)).setText(paramBundle);
      ((View)localObject).setVisibility(0);
    }
    paramBundle = (RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369865);
    this.jdField_a_of_type_Baxy = new baxy(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = new avpc(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Baxy, paramBundle, null);
    ((avpc)localObject).a(paramView);
    paramBundle.setAdapter((RecyclerView.Adapter)localObject);
    paramBundle.setLayoutManager(new LinearLayoutManager(BaseApplicationImpl.getContext()));
    int i = (int)(getResources().getDisplayMetrics().density * 64.0F);
    paramBundle.addItemDecoration(new avpb(getResources().getDrawable(2130838084), i, 0, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment
 * JD-Core Version:    0.7.0.1
 */