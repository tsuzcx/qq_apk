package com.tencent.mobileqq.friend.processor;

import android.util.Pair;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.data.ExtRspData;
import friendlist.FriendInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpateBuffer;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50.ExtSnsFrdData;

public abstract class BaseFriendProcessor
{
  protected AppRuntime mApp;
  
  public BaseFriendProcessor(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  public void destroy()
  {
    this.mApp = null;
  }
  
  public void onBatchUpdateExtensionInfo(List<Pair<ExtensionInfo, FriendInfo>> paramList, ExtRspData paramExtRspData, long paramLong, boolean paramBoolean) {}
  
  public void onBatchUpdateFriendInfo(List<Pair<Friends, FriendInfo>> paramList, long paramLong, boolean paramBoolean) {}
  
  public void onGetFriendInfoFinish(String paramString) {}
  
  public void onGetFriendListFinish(boolean paramBoolean, ArrayList<String> paramArrayList, ExtRspData paramExtRspData) {}
  
  public void onUpdateExtensionInfo(ExtensionInfo paramExtensionInfo, FriendInfo paramFriendInfo, ExtRspData paramExtRspData) {}
  
  public void onUpdateFriendInfo(Friends paramFriends, FriendInfo paramFriendInfo) {}
  
  public void onUpdateSelfInfo(Friends paramFriends, FriendInfo paramFriendInfo) {}
  
  protected Oidb_0xd50.ExtSnsFrdData parseExtSnsFrdData(byte[] paramArrayOfByte)
  {
    Oidb_0xd50.ExtSnsFrdData localExtSnsFrdData = new Oidb_0xd50.ExtSnsFrdData();
    try
    {
      localExtSnsFrdData.mergeFrom(paramArrayOfByte);
      return localExtSnsFrdData;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  protected Oidb_0x5d0.SnsUpateBuffer parseSnsUpdateBuffer(byte[] paramArrayOfByte)
  {
    Oidb_0x5d0.SnsUpateBuffer localSnsUpateBuffer = new Oidb_0x5d0.SnsUpateBuffer();
    try
    {
      localSnsUpateBuffer.mergeFrom(paramArrayOfByte);
      return localSnsUpateBuffer;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.friend.processor.BaseFriendProcessor
 * JD-Core Version:    0.7.0.1
 */