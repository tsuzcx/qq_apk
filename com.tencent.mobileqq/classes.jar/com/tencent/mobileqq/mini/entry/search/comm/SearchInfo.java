package com.tencent.mobileqq.mini.entry.search.comm;

import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StUserInfo;
import NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StoreAppInfo;
import amtj;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.List;

public class SearchInfo
  implements ItemInfo
{
  public String categoryDesc;
  public MiniAppInfo miniAppInfo;
  public String playingFriendsDesc;
  private int position;
  public List<STORE_APP_CLIENT.StUserInfo> userInfoList;
  public int userNum;
  
  public SearchInfo(STORE_APP_CLIENT.StoreAppInfo paramStoreAppInfo)
  {
    this.miniAppInfo = MiniAppInfo.from((INTERFACE.StUserAppInfo)paramStoreAppInfo.userAppInfo.get());
    this.categoryDesc = paramStoreAppInfo.serviceCategoryText.get();
    this.userNum = paramStoreAppInfo.userNum.get();
    this.userInfoList = paramStoreAppInfo.users.get();
    this.playingFriendsDesc = paramStoreAppInfo.playingFriText.get();
  }
  
  public String getCategoryDesc()
  {
    return this.categoryDesc;
  }
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.miniAppInfo;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public int getType()
  {
    return 2;
  }
  
  public String getUseNumberDesc()
  {
    if (this.userNum < 10000) {
      return this.userNum + amtj.a(2131693814);
    }
    if (this.userNum >= 100000000) {
      return this.userNum / 100000000 + amtj.a(2131693813);
    }
    return this.userNum / 10000 + amtj.a(2131693815);
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.comm.SearchInfo
 * JD-Core Version:    0.7.0.1
 */