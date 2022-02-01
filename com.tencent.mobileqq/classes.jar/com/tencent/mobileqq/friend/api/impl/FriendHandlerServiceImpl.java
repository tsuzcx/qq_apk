package com.tencent.mobileqq.friend.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.friend.data.FriendListRequestData;
import com.tencent.mobileqq.friend.data.GroupRequestData;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.friend.helper.AddFrdTokenHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class FriendHandlerServiceImpl
  implements IFriendHandlerService
{
  private static final String TAG = "IMCore.friend.FriendHandlerServiceImp";
  private FriendHandler mHandler;
  
  private void requestAddFriendReal(String paramString1, String paramString2, int paramInt1, byte paramByte1, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5, byte paramByte2, String paramString6, Bundle paramBundle, boolean paramBoolean3)
  {
    this.mHandler.a(paramString1, paramString2, paramInt1, paramByte1, paramString3, paramInt2, paramInt3, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString4, paramString5, paramByte2, paramString6, paramBundle, paramBoolean3);
  }
  
  public void addFriendGroup(byte paramByte, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("IMCore.friend.FriendHandlerServiceImp", 1, "addFriendGroup| name is empty");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addFriendGroup| sortId: ");
      ((StringBuilder)localObject).append(paramByte);
      ((StringBuilder)localObject).append(", name: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("IMCore.friend.FriendHandlerServiceImp", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new GroupRequestData();
    ((GroupRequestData)localObject).setReqType(0);
    ((GroupRequestData)localObject).setSortId(paramByte);
    ((GroupRequestData)localObject).setName(paramString);
    this.mHandler.a((GroupRequestData)localObject);
  }
  
  public void cacheToken(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cacheToken uin: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" token: ");
      ((StringBuilder)localObject).append(paramArrayOfByte.toString());
      QLog.d("IMCore.friend.FriendHandlerServiceImp", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mHandler;
    if ((localObject != null) && (((FriendHandler)localObject).a() != null)) {
      this.mHandler.a().a(paramString, paramInt1, paramInt2, paramArrayOfByte);
    }
  }
  
  public void deleteFriendGroup(byte paramByte)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteFriendGroup| groupId: ");
      ((StringBuilder)localObject).append(paramByte);
      QLog.d("IMCore.friend.FriendHandlerServiceImp", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new GroupRequestData();
    ((GroupRequestData)localObject).setReqType(2);
    ((GroupRequestData)localObject).setGroupId(paramByte);
    this.mHandler.a((GroupRequestData)localObject);
  }
  
  public boolean isRequestingFriendList()
  {
    return this.mHandler.a();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mHandler = ((FriendHandler)((AppInterface)paramAppRuntime).getBusinessHandler(FriendHandler.class.getName()));
  }
  
  public void onDestroy() {}
  
  public void renameFriendGroup(byte paramByte, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("IMCore.friend.FriendHandlerServiceImp", 1, "renameFriendGroup| name is empty");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("renameFriendGroup| groupId: ");
      ((StringBuilder)localObject).append(paramByte);
      ((StringBuilder)localObject).append(", name: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("IMCore.friend.FriendHandlerServiceImp", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new GroupRequestData();
    ((GroupRequestData)localObject).setReqType(1);
    ((GroupRequestData)localObject).setGroupId(paramByte);
    ((GroupRequestData)localObject).setName(paramString);
    this.mHandler.a((GroupRequestData)localObject);
  }
  
  public void requestAddBatchPhoneFriend(ArrayList<PhoneContact> paramArrayList, String paramString, int paramInt1, int paramInt2, ArrayList<AddBatchPhoneFriendResult> paramArrayList1)
  {
    this.mHandler.a(paramArrayList, paramString, paramInt1, paramInt2, paramArrayList1);
  }
  
  public void requestAddFriend(String paramString1, String paramString2, int paramInt1, byte paramByte, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5)
  {
    requestAddFriendReal(paramString1, paramString2, paramInt1, paramByte, paramString3, paramInt2, paramInt3, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString4, paramString5, (byte)0, "", null, false);
  }
  
  public void requestAddFriend(String paramString1, String paramString2, int paramInt1, byte paramByte, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5, Bundle paramBundle, boolean paramBoolean3)
  {
    requestAddFriendReal(paramString1, paramString2, paramInt1, paramByte, paramString3, paramInt2, paramInt3, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString4, paramString5, (byte)0, "", paramBundle, paramBoolean3);
  }
  
  public void requestAddFriendWithMyCard(String paramString1, String paramString2, int paramInt1, byte paramByte1, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5, byte paramByte2, String paramString6, Bundle paramBundle, boolean paramBoolean3)
  {
    requestAddFriendReal(paramString1, paramString2, paramInt1, paramByte1, paramString3, paramInt2, paramInt3, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString4, paramString5, paramByte2, paramString6, paramBundle, paramBoolean3);
  }
  
  public void requestAutoInfo(String paramString, int paramInt1, int paramInt2)
  {
    this.mHandler.a(paramString, paramInt1, paramInt2);
  }
  
  public void requestFriendInfo(String paramString)
  {
    if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("requestFriendInfo, friendUin: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("IMCore.friend.FriendHandlerServiceImp", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new FriendListRequestData();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      ((FriendListRequestData)localObject).setRequestSingle(true);
      ((FriendListRequestData)localObject).setUinList(localArrayList);
      this.mHandler.a((FriendListRequestData)localObject, false);
      return;
    }
    QLog.e("IMCore.friend.FriendHandlerServiceImp", 1, "requestFriendInfo, friendUin is empty");
  }
  
  public void requestFriendList(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestFriendList| isPullRefresh: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("IMCore.friend.FriendHandlerServiceImp", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new FriendListRequestData();
    ((FriendListRequestData)localObject).setFriendStartIndex(0);
    ((FriendListRequestData)localObject).setFriendCount(20);
    ((FriendListRequestData)localObject).setGroupStartIndex(0);
    ((FriendListRequestData)localObject).setGroupCount(100);
    ((FriendListRequestData)localObject).setShowTermType(1);
    ((FriendListRequestData)localObject).setPullRefresh(paramBoolean);
    this.mHandler.a((FriendListRequestData)localObject, true);
  }
  
  public void requestInfoWithOpenId(String paramString1, String paramString2)
  {
    this.mHandler.a(paramString1, paramString2);
  }
  
  public void requestUinSafetyFlag(long paramLong)
  {
    this.mHandler.b(paramLong);
  }
  
  public void requestUserAddFriendSetting(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.mHandler.a(paramString1, paramInt1, paramInt2, paramString2);
  }
  
  public void requestUserAddFriendSetting(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    this.mHandler.a(paramString1, paramInt1, paramInt2, paramString2, paramInt3);
  }
  
  public void resortFriendGroup(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte1.length == paramArrayOfByte2.length))
    {
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.friend.FriendHandlerServiceImp", 2, "resortFriendGroup");
      }
      GroupRequestData localGroupRequestData = new GroupRequestData();
      localGroupRequestData.setReqType(3);
      localGroupRequestData.setGroupIdList(paramArrayOfByte1);
      localGroupRequestData.setSortIdList(paramArrayOfByte2);
      this.mHandler.a(localGroupRequestData);
      return;
    }
    QLog.e("IMCore.friend.FriendHandlerServiceImp", 1, "resortFriendGroup| params error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.api.impl.FriendHandlerServiceImpl
 * JD-Core Version:    0.7.0.1
 */