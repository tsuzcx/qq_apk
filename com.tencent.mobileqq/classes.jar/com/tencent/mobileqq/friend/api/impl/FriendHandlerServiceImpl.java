package com.tencent.mobileqq.friend.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.friend.data.FriendListRequestData;
import com.tencent.mobileqq.friend.data.GroupRequestData;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class FriendHandlerServiceImpl
  implements IFriendHandlerService
{
  private static final String TAG = "IMCore.friend.FriendHandlerServiceImp";
  private FriendHandler mHandler;
  
  public void addFriendGroup(byte paramByte, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("IMCore.friend.FriendHandlerServiceImp", 1, "addFriendGroup| name is empty");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendHandlerServiceImp", 2, "addFriendGroup| sortId: " + paramByte + ", name: " + paramString);
    }
    GroupRequestData localGroupRequestData = new GroupRequestData();
    localGroupRequestData.setReqType(0);
    localGroupRequestData.setSortId(paramByte);
    localGroupRequestData.setName(paramString);
    this.mHandler.a(localGroupRequestData);
  }
  
  public void deleteFriendGroup(byte paramByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendHandlerServiceImp", 2, "deleteFriendGroup| groupId: " + paramByte);
    }
    GroupRequestData localGroupRequestData = new GroupRequestData();
    localGroupRequestData.setReqType(2);
    localGroupRequestData.setGroupId(paramByte);
    this.mHandler.a(localGroupRequestData);
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
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendHandlerServiceImp", 2, "renameFriendGroup| groupId: " + paramByte + ", name: " + paramString);
    }
    GroupRequestData localGroupRequestData = new GroupRequestData();
    localGroupRequestData.setReqType(1);
    localGroupRequestData.setGroupId(paramByte);
    localGroupRequestData.setName(paramString);
    this.mHandler.a(localGroupRequestData);
  }
  
  public void requestFriendInfo(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("IMCore.friend.FriendHandlerServiceImp", 1, "requestFriendInfo, friendUin is empty");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendHandlerServiceImp", 2, "requestFriendInfo, friendUin: " + paramString);
    }
    FriendListRequestData localFriendListRequestData = new FriendListRequestData();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localFriendListRequestData.setRequestSingle(true);
    localFriendListRequestData.setUinList(localArrayList);
    this.mHandler.a(localFriendListRequestData, false);
  }
  
  public void requestFriendList(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendHandlerServiceImp", 2, "requestFriendList| isPullRefresh: " + paramBoolean);
    }
    FriendListRequestData localFriendListRequestData = new FriendListRequestData();
    localFriendListRequestData.setFriendStartIndex(0);
    localFriendListRequestData.setFriendCount(20);
    localFriendListRequestData.setGroupStartIndex(0);
    localFriendListRequestData.setGroupCount(100);
    localFriendListRequestData.setShowTermType(1);
    localFriendListRequestData.setPullRefresh(paramBoolean);
    this.mHandler.a(localFriendListRequestData, true);
  }
  
  public void resortFriendGroup(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramArrayOfByte1.length != paramArrayOfByte2.length))
    {
      QLog.e("IMCore.friend.FriendHandlerServiceImp", 1, "resortFriendGroup| params error");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendHandlerServiceImp", 2, "resortFriendGroup");
    }
    GroupRequestData localGroupRequestData = new GroupRequestData();
    localGroupRequestData.setReqType(3);
    localGroupRequestData.setGroupIdList(paramArrayOfByte1);
    localGroupRequestData.setSortIdList(paramArrayOfByte2);
    this.mHandler.a(localGroupRequestData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.friend.api.impl.FriendHandlerServiceImpl
 * JD-Core Version:    0.7.0.1
 */