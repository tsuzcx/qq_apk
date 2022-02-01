package com.tencent.mobileqq.nearby.profilecard.moment;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class NearbyProfileCardMomentAdapter
  extends BaseAdapter
  implements DecodeTaskCompletionListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private NearbyCardMomentItemFactory jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyCardMomentItemFactory;
  private List<MomentFeedInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public NearbyProfileCardMomentAdapter(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyCardMomentItemFactory = new NearbyCardMomentItemFactory(paramQQAppInterface, paramContext);
    }
  }
  
  public List<MomentFeedInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
  }
  
  public void a(List<MomentFeedInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void b(List<MomentFeedInfo> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyCardMomentItemFactory == null) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyCardMomentItemFactory.a((MomentFeedInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyCardMomentItemFactory == null) {
      localView = null;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      MomentFeedInfo localMomentFeedInfo = (MomentFeedInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      int i = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyCardMomentItemFactory.a(localMomentFeedInfo);
      BaseMomentItemBuilder localBaseMomentItemBuilder = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyCardMomentItemFactory.a(i);
      localView = paramView;
      if (localBaseMomentItemBuilder != null)
      {
        localBaseMomentItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
        localBaseMomentItemBuilder.a(paramInt);
        localView = localBaseMomentItemBuilder.a(localMomentFeedInfo, this.jdField_a_of_type_AndroidContentContext, paramView);
      }
      paramView = localView;
    }
  }
  
  public int getViewTypeCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyCardMomentItemFactory == null) {
      return 1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyCardMomentItemFactory.a();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)) {
      return;
    }
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyProfileCardMomentAdapter
 * JD-Core Version:    0.7.0.1
 */