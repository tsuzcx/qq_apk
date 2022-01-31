package com.tencent.mobileqq.mini.entry.search.comm;

import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StUserInfo;
import NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StoreAppInfo;
import alpo;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.List;

public class SearchInfo
{
  public String categoryDesc;
  public MiniAppInfo miniAppInfo;
  public String playingFriendsDesc;
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
  
  public String getUseNumberDesc()
  {
    if (this.userNum < 10000) {
      return this.userNum + alpo.a(2131694429);
    }
    if (this.userNum >= 100000000) {
      return this.userNum / 100000000 + alpo.a(2131694428);
    }
    return this.userNum / 10000 + alpo.a(2131694430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.comm.SearchInfo
 * JD-Core Version:    0.7.0.1
 */