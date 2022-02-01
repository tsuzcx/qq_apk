package com.tencent.mobileqq.newfriend.ui.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.data.AddFriendBlockedInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.ThemeImageView;
import java.util.List;
import java.util.Locale;

class NewFriendVerifyBlockedListFragment$CommonAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private NewFriendVerifyBlockedListFragment$CommonAdapter(NewFriendVerifyBlockedListFragment paramNewFriendVerifyBlockedListFragment) {}
  
  private void a(View paramView)
  {
    if ((paramView instanceof ThemeImageView)) {
      ((ThemeImageView)paramView).setSupportMaskView(true);
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2130839395);
      return;
    }
    if (QQTheme.e())
    {
      paramView.setBackgroundResource(2130839393);
      return;
    }
    paramView.setBackgroundResource(2130839390);
  }
  
  private void a(NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder paramNewFriendBlockedHolder, View.OnClickListener paramOnClickListener)
  {
    if (paramNewFriendBlockedHolder.jdField_a_of_type_ComTencentMobileqqNewfriendDataAddFriendBlockedInfo == null) {
      return;
    }
    if (TextUtils.isEmpty(paramNewFriendBlockedHolder.jdField_a_of_type_ComTencentMobileqqNewfriendDataAddFriendBlockedInfo.jdField_b_of_type_JavaLangString)) {
      paramNewFriendBlockedHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramNewFriendBlockedHolder.jdField_a_of_type_ComTencentMobileqqNewfriendDataAddFriendBlockedInfo.jdField_a_of_type_JavaLangString);
    } else {
      paramNewFriendBlockedHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramNewFriendBlockedHolder.jdField_a_of_type_ComTencentMobileqqNewfriendDataAddFriendBlockedInfo.jdField_b_of_type_JavaLangString);
    }
    a(paramNewFriendBlockedHolder, paramNewFriendBlockedHolder.jdField_a_of_type_ComTencentMobileqqNewfriendDataAddFriendBlockedInfo.jdField_a_of_type_JavaLangString);
    paramNewFriendBlockedHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramNewFriendBlockedHolder);
    ((INewFriendApi)QRoute.api(INewFriendApi.class)).showGenderAge(paramNewFriendBlockedHolder.d, paramNewFriendBlockedHolder.jdField_a_of_type_ComTencentMobileqqNewfriendDataAddFriendBlockedInfo.jdField_b_of_type_Int, paramNewFriendBlockedHolder.jdField_a_of_type_ComTencentMobileqqNewfriendDataAddFriendBlockedInfo.jdField_a_of_type_Int, null);
    paramOnClickListener = paramNewFriendBlockedHolder.jdField_a_of_type_ComTencentMobileqqNewfriendDataAddFriendBlockedInfo.jdField_c_of_type_JavaLangString;
    if (!TextUtils.isEmpty(paramOnClickListener))
    {
      paramOnClickListener = String.format(Locale.getDefault(), HardCodeUtil.a(2131707525), new Object[] { paramOnClickListener });
      paramNewFriendBlockedHolder.c.setText(paramOnClickListener);
      paramNewFriendBlockedHolder.c.setVisibility(0);
    }
    else
    {
      paramNewFriendBlockedHolder.c.setVisibility(8);
    }
    int i = paramNewFriendBlockedHolder.jdField_a_of_type_ComTencentMobileqqNewfriendDataAddFriendBlockedInfo.jdField_c_of_type_Int;
    if (i > 0)
    {
      paramOnClickListener = String.format(Locale.getDefault(), "%d位共同好友", new Object[] { Integer.valueOf(i) });
      paramNewFriendBlockedHolder.b.setVisibility(0);
      paramNewFriendBlockedHolder.b.setText(paramOnClickListener);
    }
    else
    {
      paramNewFriendBlockedHolder.b.setVisibility(8);
    }
    paramNewFriendBlockedHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramNewFriendBlockedHolder);
    paramNewFriendBlockedHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public AddFriendBlockedInfo a(int paramInt)
  {
    return (AddFriendBlockedInfo)NewFriendVerifyBlockedListFragment.a(this.a).get(paramInt);
  }
  
  public void a()
  {
    NewFriendVerifyBlockedListFragment.a(this.a).cancelPendingRequests();
    NewFriendVerifyBlockedListFragment.a(this.a).pause();
  }
  
  public void a(NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder paramNewFriendBlockedHolder, String paramString)
  {
    if ((paramNewFriendBlockedHolder != null) && (paramNewFriendBlockedHolder.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      Bitmap localBitmap = NewFriendVerifyBlockedListFragment.a(this.a).getBitmapFromCache(1, paramString);
      if ((localBitmap == null) && (!NewFriendVerifyBlockedListFragment.a(this.a).isPausing())) {
        NewFriendVerifyBlockedListFragment.a(this.a).requestDecodeFace(paramString, 1, true);
      }
      paramString = localBitmap;
      if (localBitmap == null) {
        paramString = BaseImageUtil.f();
      }
      paramNewFriendBlockedHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString);
    }
  }
  
  public void b()
  {
    if (NewFriendVerifyBlockedListFragment.a(this.a).isPausing()) {
      NewFriendVerifyBlockedListFragment.a(this.a).resume();
    }
  }
  
  public void c()
  {
    int j = NewFriendVerifyBlockedListFragment.a(this.a).getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = NewFriendVerifyBlockedListFragment.a(this.a).getChildAt(i).getTag();
      if ((localObject instanceof NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder))
      {
        localObject = (NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject;
        a((NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject, ((NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject).jdField_a_of_type_ComTencentMobileqqNewfriendDataAddFriendBlockedInfo.jdField_a_of_type_JavaLangString);
      }
      i += 1;
    }
  }
  
  public int getCount()
  {
    if (NewFriendVerifyBlockedListFragment.a(this.a) == null) {
      return 0;
    }
    return NewFriendVerifyBlockedListFragment.a(this.a).size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder localNewFriendBlockedHolder;
    if (paramView == null)
    {
      localNewFriendBlockedHolder = new NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder(this);
      paramView = LayoutInflater.from(NewFriendVerifyBlockedListFragment.a(this.a)).inflate(2131561615, null);
      localNewFriendBlockedHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361799));
      localNewFriendBlockedHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371877));
      localNewFriendBlockedHolder.b = ((TextView)paramView.findViewById(2131376487));
      localNewFriendBlockedHolder.d = ((TextView)paramView.findViewById(2131362299));
      localNewFriendBlockedHolder.c = ((TextView)paramView.findViewById(2131377726));
      localNewFriendBlockedHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376477));
      localNewFriendBlockedHolder.jdField_a_of_type_AndroidViewView = paramView;
      paramView.setOnClickListener(this);
      a(localNewFriendBlockedHolder.jdField_a_of_type_AndroidWidgetImageView);
      paramView.setTag(localNewFriendBlockedHolder);
    }
    else
    {
      localNewFriendBlockedHolder = (NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)paramView.getTag();
    }
    AddFriendBlockedInfo localAddFriendBlockedInfo = a(paramInt);
    localNewFriendBlockedHolder.jdField_a_of_type_ComTencentMobileqqNewfriendDataAddFriendBlockedInfo = localAddFriendBlockedInfo;
    if (!localAddFriendBlockedInfo.jdField_a_of_type_Boolean) {
      a(localNewFriendBlockedHolder.jdField_a_of_type_AndroidViewView, true);
    } else {
      a(localNewFriendBlockedHolder.jdField_a_of_type_AndroidViewView, false);
    }
    a(localNewFriendBlockedHolder, this);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject1;
    Object localObject2;
    if (i == 2131376644)
    {
      localObject1 = paramView.getTag();
      if ((localObject1 instanceof NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder))
      {
        localObject1 = ((NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject1).jdField_a_of_type_ComTencentMobileqqNewfriendDataAddFriendBlockedInfo;
        if (localObject1 != null)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onClick rlSystemMsg， friendtype=");
            ((StringBuilder)localObject2).append(109);
            QLog.d("BlockedListFragment", 2, ((StringBuilder)localObject2).toString());
          }
          localObject2 = new AllInOne(((AddFriendBlockedInfo)localObject1).jdField_a_of_type_JavaLangString, 109);
          if (!TextUtils.isEmpty(((AddFriendBlockedInfo)localObject1).jdField_b_of_type_JavaLangString)) {
            ((AllInOne)localObject2).nickname = ((AddFriendBlockedInfo)localObject1).jdField_b_of_type_JavaLangString;
          } else {
            ((AllInOne)localObject2).nickname = ((AddFriendBlockedInfo)localObject1).jdField_a_of_type_JavaLangString;
          }
          ((AllInOne)localObject2).profileEntryType = 120;
          ProfileUtils.openProfileCardForResult(NewFriendVerifyBlockedListFragment.a(this.a), (AllInOne)localObject2, 100);
          ReportController.b(null, "dc00898", "", "", "0X800A3A8", "0X800A3A8", 0, 0, "", "", "", "");
        }
      }
    }
    else if (i == 2131376477)
    {
      localObject1 = paramView.getTag();
      if ((localObject1 instanceof NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)) {
        if (!NetworkUtil.isNetworkAvailable(NewFriendVerifyBlockedListFragment.a(this.a)))
        {
          QQToast.a(NewFriendVerifyBlockedListFragment.a(this.a), NewFriendVerifyBlockedListFragment.a(this.a).getResources().getString(2131692183), 0).b(NewFriendVerifyBlockedListFragment.a(this.a).getTitleBarHeight());
        }
        else
        {
          localObject2 = ((NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject1).jdField_a_of_type_ComTencentMobileqqNewfriendDataAddFriendBlockedInfo;
          if (!TextUtils.isEmpty(((AddFriendBlockedInfo)localObject2).jdField_b_of_type_JavaLangString)) {
            localObject1 = ((AddFriendBlockedInfo)localObject2).jdField_b_of_type_JavaLangString;
          } else {
            localObject1 = ((AddFriendBlockedInfo)localObject2).jdField_a_of_type_JavaLangString;
          }
          localObject1 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(NewFriendVerifyBlockedListFragment.a(this.a), 1, ((AddFriendBlockedInfo)localObject2).jdField_a_of_type_JavaLangString, null, 3041, 15, (String)localObject1, null, null, NewFriendVerifyBlockedListFragment.a(this.a).getString(2131689589), null);
          ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(NewFriendVerifyBlockedListFragment.a(this.a), (Intent)localObject1, 100);
          ReportController.b(null, "dc00898", "", "", "0X800A3A7", "0X800A3A7", 0, 0, "", "", "", "");
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.fragment.NewFriendVerifyBlockedListFragment.CommonAdapter
 * JD-Core Version:    0.7.0.1
 */