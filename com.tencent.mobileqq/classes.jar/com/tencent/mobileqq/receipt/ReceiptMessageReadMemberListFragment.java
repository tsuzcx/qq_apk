package com.tencent.mobileqq.receipt;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ReceiptMessageReadMemberListFragment
  extends BaseFragment
{
  private View a;
  private QQAppInterface b;
  private IFaceDecoder c;
  
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
    if ((getBaseActivity().getAppInterface() instanceof QQAppInterface))
    {
      this.b = ((QQAppInterface)getBaseActivity().getAppInterface());
      return;
    }
    throw new IllegalStateException("only allow used in main process");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = paramLayoutInflater.inflate(2131624158, paramViewGroup, false);
    paramLayoutInflater = this.a;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    this.c.destory();
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
      localObject = this.a.findViewById(2131432530);
      ((TextView)this.a.findViewById(2131432532)).setText(paramBundle);
      ((View)localObject).setVisibility(0);
    }
    paramBundle = (RecyclerView)this.a.findViewById(2131438051);
    this.c = ((IQQAvatarService)this.b.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.b);
    Object localObject = new ReceiptMessageReadMemberListFragment.MemberAdapter(BaseApplicationImpl.getContext(), this.c, paramBundle, null);
    ((ReceiptMessageReadMemberListFragment.MemberAdapter)localObject).a(paramView);
    paramBundle.setAdapter((RecyclerView.Adapter)localObject);
    paramBundle.setLayoutManager(new LinearLayoutManager(BaseApplicationImpl.getContext()));
    int i = (int)(getResources().getDisplayMetrics().density * 64.0F);
    paramBundle.addItemDecoration(new ReceiptMessageReadMemberListFragment.DividerItemDecoration(getResources().getDrawable(2130838252), i, 0, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment
 * JD-Core Version:    0.7.0.1
 */