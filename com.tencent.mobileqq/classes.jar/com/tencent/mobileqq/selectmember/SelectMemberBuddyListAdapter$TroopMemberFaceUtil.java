package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;

class SelectMemberBuddyListAdapter$TroopMemberFaceUtil
  implements DecodeTaskCompletionListener
{
  protected IFaceDecoder a;
  boolean jdField_a_of_type_Boolean = true;
  
  public SelectMemberBuddyListAdapter$TroopMemberFaceUtil(SelectMemberBuddyListAdapter paramSelectMemberBuddyListAdapter, Context paramContext, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  private Bitmap a(String paramString, int paramInt1, byte paramByte, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject == null) {
      return null;
    }
    localObject = ((IFaceDecoder)localObject).getBitmapFromCacheFrom(paramInt1, paramString, paramInt2);
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestDecodeFace, uin[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    QLog.w("FriendTeamListInnerFrameBuddyListAdapter", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, paramInt1, true, paramByte);
    return BaseImageUtil.f();
  }
  
  public Bitmap a(TroopMemberInfo paramTroopMemberInfo)
  {
    return a(paramTroopMemberInfo.memberuin, 1, (byte)0, 0);
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder == null) {
        break label29;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    }
    catch (Exception localException)
    {
      label24:
      label29:
      break label24;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDecodeTaskCompleted, uin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    QLog.w("FriendTeamListInnerFrameBuddyListAdapter", 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    SelectMemberBuddyListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter, paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberBuddyListAdapter.TroopMemberFaceUtil
 * JD-Core Version:    0.7.0.1
 */