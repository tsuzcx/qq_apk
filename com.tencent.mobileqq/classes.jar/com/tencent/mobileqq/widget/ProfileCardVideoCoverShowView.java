package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProfileCardVideoCoverShowView
  extends FrameLayout
  implements AdapterView.OnItemClickListener, OverScrollCallbackHorizontalListView.Listener
{
  private OverScrollCallbackHorizontalListView a;
  private ArrayList<ProfileCardVideoCoverShowView.DataItem> b = new ArrayList(10);
  private ProfileCardVideoCoverShowView.Callback c;
  private BaseAdapter d = new ProfileCardVideoCoverShowView.1(this);
  
  public ProfileCardVideoCoverShowView(@NonNull Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public ProfileCardVideoCoverShowView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public ProfileCardVideoCoverShowView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void c()
  {
    LayoutInflater.from(getContext()).inflate(2131627668, this, true);
    this.a = ((OverScrollCallbackHorizontalListView)findViewById(2131437317));
    this.a.setListener(this);
    this.a.setDividerWidth(AIOUtils.b(2.0F, getResources()));
    this.a.setAdapter(this.d);
    this.a.setOnItemClickListener(this);
    this.a.setOverScrollMode(1);
  }
  
  public void a(OverScrollCallbackHorizontalListView paramOverScrollCallbackHorizontalListView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCardMicroVideoContentView", 2, "onOverScrollRight");
    }
    paramOverScrollCallbackHorizontalListView = this.c;
    if (paramOverScrollCallbackHorizontalListView != null) {
      paramOverScrollCallbackHorizontalListView.a(this);
    }
  }
  
  public Pair<ArrayList<String>, ArrayList<String>> getIdList()
  {
    ArrayList localArrayList1 = new ArrayList(this.b.size());
    ArrayList localArrayList2 = new ArrayList(this.b.size());
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      ProfileCardVideoCoverShowView.DataItem localDataItem = (ProfileCardVideoCoverShowView.DataItem)localIterator.next();
      localArrayList1.add(localDataItem.d);
      localArrayList2.add(localDataItem.e);
    }
    return new Pair(localArrayList1, localArrayList2);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onItemClick ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("ProfileCardMicroVideoContentView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c;
    if (localObject != null) {
      ((ProfileCardVideoCoverShowView.Callback)localObject).a(this, paramView, (ProfileCardVideoCoverShowView.DataItem)this.b.get(paramInt));
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void setCallback(ProfileCardVideoCoverShowView.Callback paramCallback)
  {
    this.c = paramCallback;
  }
  
  public void setData(List<ProfileCardVideoCoverShowView.DataItem> paramList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setData list=");
      Object localObject;
      if (paramList == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(paramList.size());
      }
      localStringBuilder.append(localObject);
      QLog.i("ProfileCardMicroVideoContentView", 2, localStringBuilder.toString());
    }
    this.b.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.b.addAll(paramList);
    }
    if ((paramList != null) && (paramList.size() != 0))
    {
      int i = getResources().getDisplayMetrics().widthPixels;
      int j = AIOUtils.b(114.0F, getResources());
      if (paramList.size() > i * 1.0F / j) {
        this.a.setOverScrollMode(0);
      } else {
        this.a.setOverScrollMode(1);
      }
    }
    else
    {
      this.a.setOverScrollMode(1);
    }
    this.d.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardVideoCoverShowView
 * JD-Core Version:    0.7.0.1
 */