package com.tencent.mobileqq.friend.api;

import android.os.Bundle;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IFriendHandlerService
  extends IRuntimeService
{
  public abstract void addFriendGroup(byte paramByte, String paramString);
  
  public abstract void cacheToken(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public abstract void deleteFriendGroup(byte paramByte);
  
  public abstract boolean isRequestingFriendList();
  
  public abstract void renameFriendGroup(byte paramByte, String paramString);
  
  public abstract void requestAddBatchPhoneFriend(ArrayList<PhoneContact> paramArrayList, String paramString, int paramInt1, int paramInt2, ArrayList<AddBatchPhoneFriendResult> paramArrayList1);
  
  public abstract void requestAddFriend(String paramString1, String paramString2, int paramInt1, byte paramByte, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5);
  
  public abstract void requestAddFriend(String paramString1, String paramString2, int paramInt1, byte paramByte, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5, Bundle paramBundle, boolean paramBoolean3);
  
  public abstract void requestAddFriendWithMyCard(String paramString1, String paramString2, int paramInt1, byte paramByte1, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5, byte paramByte2, String paramString6, Bundle paramBundle, boolean paramBoolean3);
  
  public abstract void requestAutoInfo(String paramString, int paramInt1, int paramInt2);
  
  public abstract void requestFriendInfo(String paramString);
  
  public abstract void requestFriendList(boolean paramBoolean);
  
  public abstract void requestInfoWithOpenId(String paramString1, String paramString2);
  
  public abstract void requestUinSafetyFlag(long paramLong);
  
  public abstract void requestUserAddFriendSetting(String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  public abstract void requestUserAddFriendSetting(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3);
  
  public abstract void resortFriendGroup(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friend.api.IFriendHandlerService
 * JD-Core Version:    0.7.0.1
 */