package com.tencent.mobileqq.troop.selecttroopmember;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

class SelectTroopMemberAdapter$TroopMemberFaceUtil
  implements DecodeTaskCompletionListener
{
  protected IFaceDecoder a;
  boolean jdField_a_of_type_Boolean = true;
  
  public SelectTroopMemberAdapter$TroopMemberFaceUtil(SelectTroopMemberAdapter paramSelectTroopMemberAdapter, Context paramContext, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  private Bitmap a(String paramString, int paramInt1, byte paramByte, int paramInt2)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder == null) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCacheFrom(paramInt1, paramString, paramInt2);
      localObject = localBitmap;
    } while (localBitmap != null);
    QLog.w("SelectTroopMemberAdapter", 1, "requestDecodeFace, uin[" + paramString + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, paramInt1, true, paramByte);
    return ImageUtil.c();
  }
  
  public Bitmap a(SelectTroopMemberAdapter.TroopMemInfoData paramTroopMemInfoData)
  {
    return a(paramTroopMemInfoData.b, 1, (byte)0, 0);
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
      }
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    QLog.w("SelectTroopMemberAdapter", 1, "onDecodeTaskCompleted, uin[" + paramString + "]");
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    SelectTroopMemberAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter, paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.SelectTroopMemberAdapter.TroopMemberFaceUtil
 * JD-Core Version:    0.7.0.1
 */