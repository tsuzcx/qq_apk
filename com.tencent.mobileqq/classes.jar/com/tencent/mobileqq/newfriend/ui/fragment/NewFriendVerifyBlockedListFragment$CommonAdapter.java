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
      paramView.setBackgroundResource(2130839579);
      return;
    }
    if (QQTheme.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839577);
      return;
    }
    paramView.setBackgroundResource(2130839574);
  }
  
  private void a(NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder paramNewFriendBlockedHolder, View.OnClickListener paramOnClickListener)
  {
    if (paramNewFriendBlockedHolder.a == null) {
      return;
    }
    if (TextUtils.isEmpty(paramNewFriendBlockedHolder.a.b)) {
      paramNewFriendBlockedHolder.d.setText(paramNewFriendBlockedHolder.a.a);
    } else {
      paramNewFriendBlockedHolder.d.setText(paramNewFriendBlockedHolder.a.b);
    }
    a(paramNewFriendBlockedHolder, paramNewFriendBlockedHolder.a.a);
    paramNewFriendBlockedHolder.c.setTag(paramNewFriendBlockedHolder);
    ((INewFriendApi)QRoute.api(INewFriendApi.class)).showGenderAge(paramNewFriendBlockedHolder.h, paramNewFriendBlockedHolder.a.d, paramNewFriendBlockedHolder.a.c, null);
    paramOnClickListener = paramNewFriendBlockedHolder.a.e;
    if (!TextUtils.isEmpty(paramOnClickListener))
    {
      paramOnClickListener = String.format(Locale.getDefault(), HardCodeUtil.a(2131905340), new Object[] { paramOnClickListener });
      paramNewFriendBlockedHolder.f.setText(paramOnClickListener);
      paramNewFriendBlockedHolder.f.setVisibility(0);
    }
    else
    {
      paramNewFriendBlockedHolder.f.setVisibility(8);
    }
    int i = paramNewFriendBlockedHolder.a.h;
    if (i > 0)
    {
      paramOnClickListener = String.format(Locale.getDefault(), "%d位共同好友", new Object[] { Integer.valueOf(i) });
      paramNewFriendBlockedHolder.e.setVisibility(0);
      paramNewFriendBlockedHolder.e.setText(paramOnClickListener);
    }
    else
    {
      paramNewFriendBlockedHolder.e.setVisibility(8);
    }
    paramNewFriendBlockedHolder.g.setTag(paramNewFriendBlockedHolder);
    paramNewFriendBlockedHolder.g.setOnClickListener(this);
  }
  
  public AddFriendBlockedInfo a(int paramInt)
  {
    return (AddFriendBlockedInfo)NewFriendVerifyBlockedListFragment.e(this.a).get(paramInt);
  }
  
  public void a()
  {
    NewFriendVerifyBlockedListFragment.f(this.a).cancelPendingRequests();
    NewFriendVerifyBlockedListFragment.f(this.a).pause();
  }
  
  public void a(NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder paramNewFriendBlockedHolder, String paramString)
  {
    if ((paramNewFriendBlockedHolder != null) && (paramNewFriendBlockedHolder.c != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      Bitmap localBitmap = NewFriendVerifyBlockedListFragment.f(this.a).getBitmapFromCache(1, paramString);
      if ((localBitmap == null) && (!NewFriendVerifyBlockedListFragment.f(this.a).isPausing())) {
        NewFriendVerifyBlockedListFragment.f(this.a).requestDecodeFace(paramString, 1, true);
      }
      paramString = localBitmap;
      if (localBitmap == null) {
        paramString = BaseImageUtil.k();
      }
      paramNewFriendBlockedHolder.c.setImageBitmap(paramString);
    }
  }
  
  public void b()
  {
    if (NewFriendVerifyBlockedListFragment.f(this.a).isPausing()) {
      NewFriendVerifyBlockedListFragment.f(this.a).resume();
    }
  }
  
  public void c()
  {
    int j = NewFriendVerifyBlockedListFragment.c(this.a).getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = NewFriendVerifyBlockedListFragment.c(this.a).getChildAt(i).getTag();
      if ((localObject instanceof NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder))
      {
        localObject = (NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject;
        a((NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject, ((NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject).a.a);
      }
      i += 1;
    }
  }
  
  public int getCount()
  {
    if (NewFriendVerifyBlockedListFragment.e(this.a) == null) {
      return 0;
    }
    return NewFriendVerifyBlockedListFragment.e(this.a).size();
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
      paramView = LayoutInflater.from(NewFriendVerifyBlockedListFragment.b(this.a)).inflate(2131627994, null);
      localNewFriendBlockedHolder.c = ((ImageView)paramView.findViewById(2131427337));
      localNewFriendBlockedHolder.d = ((TextView)paramView.findViewById(2131439320));
      localNewFriendBlockedHolder.e = ((TextView)paramView.findViewById(2131444728));
      localNewFriendBlockedHolder.h = ((TextView)paramView.findViewById(2131427898));
      localNewFriendBlockedHolder.f = ((TextView)paramView.findViewById(2131446184));
      localNewFriendBlockedHolder.g = ((Button)paramView.findViewById(2131444718));
      localNewFriendBlockedHolder.b = paramView;
      paramView.setOnClickListener(this);
      a(localNewFriendBlockedHolder.c);
      paramView.setTag(localNewFriendBlockedHolder);
    }
    else
    {
      localNewFriendBlockedHolder = (NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)paramView.getTag();
    }
    AddFriendBlockedInfo localAddFriendBlockedInfo = a(paramInt);
    localNewFriendBlockedHolder.a = localAddFriendBlockedInfo;
    if (!localAddFriendBlockedInfo.g) {
      a(localNewFriendBlockedHolder.b, true);
    } else {
      a(localNewFriendBlockedHolder.b, false);
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
    if (i == 2131444905)
    {
      localObject1 = paramView.getTag();
      if ((localObject1 instanceof NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder))
      {
        localObject1 = ((NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject1).a;
        if (localObject1 != null)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onClick rlSystemMsg， friendtype=");
            ((StringBuilder)localObject2).append(109);
            QLog.d("BlockedListFragment", 2, ((StringBuilder)localObject2).toString());
          }
          localObject2 = new AllInOne(((AddFriendBlockedInfo)localObject1).a, 109);
          if (!TextUtils.isEmpty(((AddFriendBlockedInfo)localObject1).b)) {
            ((AllInOne)localObject2).nickname = ((AddFriendBlockedInfo)localObject1).b;
          } else {
            ((AllInOne)localObject2).nickname = ((AddFriendBlockedInfo)localObject1).a;
          }
          ((AllInOne)localObject2).profileEntryType = 120;
          ProfileUtils.openProfileCardForResult(NewFriendVerifyBlockedListFragment.b(this.a), (AllInOne)localObject2, 100);
          ReportController.b(null, "dc00898", "", "", "0X800A3A8", "0X800A3A8", 0, 0, "", "", "", "");
        }
      }
    }
    else if (i == 2131444718)
    {
      localObject1 = paramView.getTag();
      if ((localObject1 instanceof NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)) {
        if (!NetworkUtil.isNetworkAvailable(NewFriendVerifyBlockedListFragment.b(this.a)))
        {
          QQToast.makeText(NewFriendVerifyBlockedListFragment.b(this.a), NewFriendVerifyBlockedListFragment.b(this.a).getResources().getString(2131889169), 0).show(NewFriendVerifyBlockedListFragment.b(this.a).getTitleBarHeight());
        }
        else
        {
          localObject2 = ((NewFriendVerifyBlockedListFragment.CommonAdapter.NewFriendBlockedHolder)localObject1).a;
          if (!TextUtils.isEmpty(((AddFriendBlockedInfo)localObject2).b)) {
            localObject1 = ((AddFriendBlockedInfo)localObject2).b;
          } else {
            localObject1 = ((AddFriendBlockedInfo)localObject2).a;
          }
          localObject1 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(NewFriendVerifyBlockedListFragment.b(this.a), 1, ((AddFriendBlockedInfo)localObject2).a, null, 3041, 15, (String)localObject1, null, null, NewFriendVerifyBlockedListFragment.b(this.a).getString(2131886199), null);
          ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(NewFriendVerifyBlockedListFragment.b(this.a), (Intent)localObject1, 100);
          ReportController.b(null, "dc00898", "", "", "0X800A3A7", "0X800A3A7", 0, 0, "", "", "", "");
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.fragment.NewFriendVerifyBlockedListFragment.CommonAdapter
 * JD-Core Version:    0.7.0.1
 */