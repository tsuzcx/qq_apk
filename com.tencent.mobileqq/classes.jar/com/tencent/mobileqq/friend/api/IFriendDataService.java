package com.tencent.mobileqq.friend.api;

import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.friend.api.callback.GetGroupListCallback;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IFriendDataService
  extends IRuntimeService
{
  public abstract List<Groups> asyncGetGroupList(GetGroupListCallback paramGetGroupListCallback);
  
  public abstract Friends deleteFriend(String paramString);
  
  public abstract List<Friends> getAllFriends();
  
  public abstract List<Friends> getAllFriends(boolean paramBoolean);
  
  public abstract Friends getFriend(String paramString);
  
  public abstract Friends getFriend(String paramString, boolean paramBoolean);
  
  public abstract Friends getFriend(String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract Friends getFriend(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract int getFriendCount();
  
  public abstract List<Friends> getFriendList(int paramInt);
  
  public abstract Groups getGroup(int paramInt);
  
  public abstract Groups getGroup(int paramInt, boolean paramBoolean);
  
  public abstract List<Groups> getGroupList();
  
  public abstract void initFriendCache();
  
  public abstract void initGroupCache();
  
  public abstract boolean isFriend(String paramString);
  
  public abstract boolean isFriend(String paramString, boolean paramBoolean);
  
  public abstract void moveFriendToNewGroup(String paramString, int paramInt);
  
  public abstract void moveGroup(int paramInt1, int paramInt2);
  
  public abstract List<Friends> preloadPartFriendCache(List<String> paramList);
  
  public abstract boolean saveFriend(Friends paramFriends);
  
  public abstract void saveFriendCache(Friends paramFriends);
  
  public abstract boolean saveFriendList(List<Friends> paramList);
  
  public abstract boolean saveFriendList(List<Friends> paramList, boolean paramBoolean, long paramLong);
  
  public abstract boolean saveGroup(Groups paramGroups);
  
  public abstract boolean saveGroupList(List<Groups> paramList);
  
  public abstract void updateGroupSortIds(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.api.IFriendDataService
 * JD-Core Version:    0.7.0.1
 */