package com.tencent.mobileqq.qqexpand.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qqexpand.manager.ExtendFriendSearchHistoryManager;
import com.tencent.mobileqq.qqexpand.manager.ExtendFriendSearchHistoryManager.HistoryTagChangeListener;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.FeedListView;
import cooperation.qzone.api.FeedListView.LoadFeedCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExtendFriendCampusSearchFragment
  extends ExtendFriendSearchBaseFragment
  implements ExtendFriendSearchHistoryManager.HistoryTagChangeListener, FeedListView.LoadFeedCallback
{
  private IExpandManager c;
  private ExtendFriendSearchHistoryManager d;
  private FeedListView e;
  private ExtendEmptyViewDirector f;
  private boolean g;
  
  private void c()
  {
    List localList1 = this.c.c(1);
    List localList2 = this.d.a();
    b("");
    b((ArrayList)localList1);
    a((ArrayList)localList2);
  }
  
  void a()
  {
    this.d.b();
  }
  
  void a(ViewGroup paramViewGroup)
  {
    if (this.e == null)
    {
      if (getBaseActivity() == null) {
        return;
      }
      View localView = LayoutInflater.from(getBaseActivity()).inflate(2131627442, paramViewGroup, false);
      this.f = new ExtendEmptyViewDirector(localView);
      this.e = ((FeedListView)localView.findViewById(2131445309));
      this.e.setExtArgs(Collections.singletonMap("search_mode", "1"));
      this.e.setOverScrollMode(0);
      this.e.setEdgeEffectEnabled(false);
      this.e.setVerticalScrollBarEnabled(false);
      this.e.attach(this.b, getBaseActivity(), this.b.getLongAccountUin());
      paramViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCampusSearchFragment", 2, String.format("onSearch searchKey=%s", new Object[] { paramString }));
    }
    this.d.a(paramString);
    if (this.e == null) {
      return;
    }
    this.f.b();
    this.e.setOverScrollMode(0);
    if (this.g)
    {
      this.e.postDelayed(new ExtendFriendCampusSearchFragment.1(this, paramString), 800L);
      this.g = false;
      return;
    }
    this.e.switchTag(paramString, this);
  }
  
  public void dh_()
  {
    a((ArrayList)this.d.a());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      paramInt1 = -1;
      break;
    case 1208: 
      paramInt1 = 1208;
      break;
    case 1207: 
      paramInt1 = 1207;
      break;
    case 1206: 
      paramInt1 = 1206;
      break;
    case 1205: 
      paramInt1 = 1205;
    }
    if (paramInt1 != -1)
    {
      FeedListView localFeedListView = this.e;
      if (localFeedListView != null) {
        localFeedListView.doActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = ((IExpandManager)this.b.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER));
    this.d = this.c.l();
    this.d.a(this);
    this.g = true;
  }
  
  public void onLoadOver(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.e.getFeedCnt() == 0)
      {
        this.f.d();
        return;
      }
      this.f.a();
      return;
    }
    if (NetworkUtil.isNetworkAvailable())
    {
      this.f.c();
      return;
    }
    this.f.e();
  }
  
  public void onPause()
  {
    super.onPause();
    FeedListView localFeedListView = this.e;
    if (localFeedListView != null) {
      localFeedListView.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    c();
    FeedListView localFeedListView = this.e;
    if (localFeedListView != null) {
      localFeedListView.onResume();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    FeedListView localFeedListView = this.e;
    if (localFeedListView != null) {
      localFeedListView.onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    FeedListView localFeedListView = this.e;
    if (localFeedListView != null) {
      localFeedListView.onStop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendCampusSearchFragment
 * JD-Core Version:    0.7.0.1
 */