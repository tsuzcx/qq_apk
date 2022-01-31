package com.tencent.mobileqq.nearby.profilecard.moment;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ChangMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.LiveMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.PicMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ShortVideoMomentFeedInfo;

public class NearbyCardMomentItemFactory
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BaseMomentItemBuilder jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder;
  private BaseMomentItemBuilder b;
  private BaseMomentItemBuilder c;
  private BaseMomentItemBuilder d;
  
  public NearbyCardMomentItemFactory(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return 4;
  }
  
  public int a(MomentFeedInfo paramMomentFeedInfo)
  {
    if ((paramMomentFeedInfo instanceof LiveMomentFeedInfo)) {
      return 0;
    }
    if ((paramMomentFeedInfo instanceof ShortVideoMomentFeedInfo)) {
      return 1;
    }
    if ((paramMomentFeedInfo instanceof PicMomentFeedInfo)) {
      return 2;
    }
    if ((paramMomentFeedInfo instanceof ChangMomentFeedInfo)) {
      return 3;
    }
    return -1;
  }
  
  public BaseMomentItemBuilder a(int paramInt)
  {
    Object localObject = null;
    if (paramInt == 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder != null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder;
      }
    }
    do
    {
      return localObject;
      localObject = new LiveMomentItemBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder = ((BaseMomentItemBuilder)localObject);
      return localObject;
      if (paramInt == 1)
      {
        if (this.b != null) {
          return this.b;
        }
        localObject = new ShortVideoMomentItemBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.b = ((BaseMomentItemBuilder)localObject);
        return localObject;
      }
      if (paramInt == 2)
      {
        if (this.c != null) {
          return this.c;
        }
        localObject = new PicMomentItemBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.c = ((BaseMomentItemBuilder)localObject);
        return localObject;
      }
    } while (paramInt != 3);
    if (this.d != null) {
      return this.d;
    }
    localObject = new ChangMomentItemBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.d = ((BaseMomentItemBuilder)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyCardMomentItemFactory
 * JD-Core Version:    0.7.0.1
 */