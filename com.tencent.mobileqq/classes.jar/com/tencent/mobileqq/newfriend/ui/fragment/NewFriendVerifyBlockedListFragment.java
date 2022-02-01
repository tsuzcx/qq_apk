package com.tencent.mobileqq.newfriend.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendVerificationServiceImpl;
import com.tencent.mobileqq.newfriend.data.AddFriendBlockedInfo;
import com.tencent.mobileqq.newfriend.observer.NewFriendVerificationObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class NewFriendVerifyBlockedListFragment
  extends QIphoneTitleBarFragment
  implements DecodeTaskCompletionListener
{
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private NewFriendVerificationObserver jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendVerificationObserver = new NewFriendVerifyBlockedListFragment.2(this);
  private NewFriendVerifyBlockedListFragment.CommonAdapter jdField_a_of_type_ComTencentMobileqqNewfriendUiFragmentNewFriendVerifyBlockedListFragment$CommonAdapter;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new NewFriendVerifyBlockedListFragment.3(this);
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private List<AddFriendBlockedInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new NewFriendVerifyBlockedListFragment.1(this);
  private View c;
  private TextView g;
  
  private void a()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(getString(2131699058));
    localSpannableStringBuilder.setSpan(new NewFriendVerifyBlockedListFragment.5(this), 27, 31, 33);
    this.g.setText(localSpannableStringBuilder);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#4D94FF")), 27, 31, 33);
    this.g.setMovementMethod(LinkMovementMethod.getInstance());
    this.g.setText(localSpannableStringBuilder);
  }
  
  public static void a(Activity paramActivity)
  {
    QPublicFragmentActivity.start(paramActivity, new Intent(), NewFriendVerifyBlockedListFragment.class);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNewfriendUiFragmentNewFriendVerifyBlockedListFragment$CommonAdapter != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(NewFriendVerificationServiceImpl.getService(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).addFriendBlockedInfoList);
      this.jdField_a_of_type_ComTencentMobileqqNewfriendUiFragmentNewFriendVerifyBlockedListFragment$CommonAdapter.notifyDataSetChanged();
      if (this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        this.g.setVisibility(8);
        this.c.setVisibility(0);
        return;
      }
      this.g.setVisibility(0);
      this.c.setVisibility(8);
    }
  }
  
  protected int a()
  {
    return 2131561616;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131699060));
    this.c = this.b.findViewById(2131366238);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)this.b.findViewById(2131365015));
    this.jdField_a_of_type_ComTencentWidgetListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetListView.setOverscrollHeader(null);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.g = ((TextView)this.b.findViewById(2131370121));
    this.jdField_a_of_type_ComTencentMobileqqNewfriendUiFragmentNewFriendVerifyBlockedListFragment$CommonAdapter = new NewFriendVerifyBlockedListFragment.CommonAdapter(this, null);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNewfriendUiFragmentNewFriendVerifyBlockedListFragment$CommonAdapter);
    a();
    c(2131690863, new NewFriendVerifyBlockedListFragment.4(this));
    ((INewFriendVerificationService)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getRuntimeService(INewFriendVerificationService.class, "")).getAddFriendBlockedList(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getCurrentAccountUin());
    c();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 100)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = getQBaseActivity();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime() instanceof AppInterface))
    {
      ((AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).addObserver(this.jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendVerificationObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime());
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)))
        {
          localObject = (NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject;
          if ((((NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject).jdField_a_of_type_ComTencentMobileqqNewfriendDataAddFriendBlockedInfo != null) && (paramString.equals(((NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject).jdField_a_of_type_ComTencentMobileqqNewfriendDataAddFriendBlockedInfo.a))) {
            ((NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime() instanceof AppInterface))
    {
      ((AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).removeObserver(this.jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendVerificationObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(null);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = null;
  }
  
  public void onResume()
  {
    super.onResume();
    NewFriendVerifyBlockedListFragment.CommonAdapter localCommonAdapter = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiFragmentNewFriendVerifyBlockedListFragment$CommonAdapter;
    if (localCommonAdapter != null) {
      localCommonAdapter.b();
    }
    ReportController.b(null, "dc00898", "", "", "0X800A3A6", "0X800A3A6", 0, 0, "", "", "", "");
  }
  
  public void onStop()
  {
    super.onStop();
    NewFriendVerifyBlockedListFragment.CommonAdapter localCommonAdapter = this.jdField_a_of_type_ComTencentMobileqqNewfriendUiFragmentNewFriendVerifyBlockedListFragment$CommonAdapter;
    if (localCommonAdapter != null) {
      localCommonAdapter.a();
    }
    NewFriendVerificationServiceImpl.getService(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).setBlockInfoHasRead();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.fragment.NewFriendVerifyBlockedListFragment
 * JD-Core Version:    0.7.0.1
 */