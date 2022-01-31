package com.tencent.mobileqq.nearby.profilecard.moment;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import java.util.ArrayList;
import java.util.List;

public class NearbyProfileCardMomentAdapter
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private NearbyCardMomentItemFactory jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyCardMomentItemFactory;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public NearbyProfileCardMomentAdapter(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyCardMomentItemFactory = new NearbyCardMomentItemFactory(paramQQAppInterface, paramContext);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramContext, paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    }
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(null);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void b(List paramList)
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
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyCardMomentItemFactory == null) {
      paramViewGroup = null;
    }
    MomentFeedInfo localMomentFeedInfo;
    BaseMomentItemBuilder localBaseMomentItemBuilder;
    do
    {
      return paramViewGroup;
      localMomentFeedInfo = (MomentFeedInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramInt = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyCardMomentItemFactory.a(localMomentFeedInfo);
      localBaseMomentItemBuilder = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyCardMomentItemFactory.a(paramInt);
      paramViewGroup = paramView;
    } while (localBaseMomentItemBuilder == null);
    localBaseMomentItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
    localBaseMomentItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
    return localBaseMomentItemBuilder.a(localMomentFeedInfo, this.jdField_a_of_type_AndroidContentContext, paramView);
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
    if ((paramBitmap == null) && (paramInt1 > 0)) {
      return;
    }
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyProfileCardMomentAdapter
 * JD-Core Version:    0.7.0.1
 */