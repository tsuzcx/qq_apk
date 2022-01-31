package com.tencent.mobileqq.util;

import ajzu;
import ajzv;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.GroupIconHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.troop.utils.TroopUtils;

public class FaceDrawableImpl
  extends FaceDrawable
{
  public ajzv a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  FaceDrawableImpl.InternalDiscussionObserver jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl$InternalDiscussionObserver;
  FaceDrawableImpl.InternalFriendListObserver jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl$InternalFriendListObserver;
  IdleUpdater jdField_a_of_type_ComTencentMobileqqUtilIdleUpdater;
  
  public FaceDrawableImpl(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, int paramInt4, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, FaceDrawable.OnLoadingStateChangeListener paramOnLoadingStateChangeListener, boolean paramBoolean2)
  {
    super(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramInt4, paramBoolean1, paramDrawable1, paramDrawable2, paramOnLoadingStateChangeListener, paramBoolean2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppInterface);
  }
  
  private Bitmap b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo == null) {
      return null;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 1001) {
      localObject1 = GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int, (String)localObject1, (byte)this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.c, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int, 100, paramBoolean);
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject2);
    if ((localObject2 != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 1001))
    {
      localObject1 = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
      if ((localObject1 != null) && (((DiscussionHandler)localObject1).a() != null)) {
        ((DiscussionHandler)localObject1).a().f(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      return localObject2;
      if ((localObject2 != null) && (QQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int)))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject1, false);
        if (((localObject1 == null) || (((ExtensionInfo)localObject1).faceIdUpdateTime == 0L)) && (this.jdField_a_of_type_ComTencentMobileqqUtilIdleUpdater == null))
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilIdleUpdater = new ajzu(this);
          this.jdField_a_of_type_ComTencentMobileqqUtilIdleUpdater.b();
        }
      }
    }
  }
  
  protected Bitmap a(boolean paramBoolean)
  {
    return b(paramBoolean);
  }
  
  public void a()
  {
    if ((!this.b) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      FaceManager localFaceManager;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl$InternalFriendListObserver != null)
      {
        localFaceManager = (FaceManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(169);
        if (localFaceManager != null) {
          localFaceManager.b(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl$InternalFriendListObserver);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl$InternalDiscussionObserver != null)
      {
        localFaceManager = (FaceManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(169);
        if (localFaceManager != null) {
          localFaceManager.b(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl$InternalDiscussionObserver);
        }
      }
      if (this.jdField_a_of_type_Ajzv != null)
      {
        localFaceManager = (FaceManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(169);
        if (localFaceManager != null) {
          localFaceManager.b(this.jdField_a_of_type_Ajzv);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    super.a();
  }
  
  protected void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppInterface);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, Object paramObject)
  {
    if ((this.b) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo == null)) {}
    while ((paramInt != this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int) || (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString.equals(paramString))) {
      return;
    }
    if (paramObject != null)
    {
      paramString = (FaceManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(169);
      if (paramString != null) {
        paramString.b(paramObject);
      }
    }
    if (paramBoolean)
    {
      paramString = b();
      if (paramString != null) {
        a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo, paramString);
      }
    }
    for (;;)
    {
      System.currentTimeMillis();
      return;
      a();
      continue;
      a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo, null);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo == null) {
      return false;
    }
    FaceManager localFaceManager;
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 101) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 1001))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl$InternalDiscussionObserver = new FaceDrawableImpl.InternalDiscussionObserver(this, this);
      localFaceManager = (FaceManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(169);
      if (localFaceManager != null) {
        localFaceManager.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl$InternalDiscussionObserver);
      }
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 113)) && (!TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Ajzv = new ajzv(this, null);
      localFaceManager = (FaceManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(169);
      if (localFaceManager != null) {
        localFaceManager.a(this.jdField_a_of_type_Ajzv);
      }
    }
    FaceDecodeTask.a(FaceDecodeTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo, this));
    return true;
  }
  
  protected Bitmap b()
  {
    return b(false);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl$InternalFriendListObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl$InternalFriendListObserver = new FaceDrawableImpl.InternalFriendListObserver(this, this);
    }
    Object localObject = (FaceManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(169);
    if (localObject != null) {
      ((FaceManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl$InternalFriendListObserver);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 11) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 16) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 1001))
    {
      localObject = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int != 1) {
        break label170;
      }
      ((FriendListHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Byte, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Byte);
    }
    for (;;)
    {
      System.currentTimeMillis();
      return;
      label170:
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 11) {
        ((FriendListHandler)localObject).b(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Byte);
      } else if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 4) {
        ((FriendListHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Byte);
      } else if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 32) {
        ((FriendListHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Byte, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Byte);
      } else if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 16) {
        ((FriendListHandler)localObject).b(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Byte, this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_b_of_type_Byte);
      } else if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 101) {
        ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString, true);
      } else if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_Int == 1001) {
        ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).a(GroupIconHelper.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString), true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.util.FaceDrawableImpl
 * JD-Core Version:    0.7.0.1
 */