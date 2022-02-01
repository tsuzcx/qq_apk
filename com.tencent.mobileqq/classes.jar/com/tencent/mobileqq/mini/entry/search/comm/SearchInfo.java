package com.tencent.mobileqq.mini.entry.search.comm;

import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StUserInfo;
import NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StoreAppInfo;
import NS_STORE_APP_SEARCH.MiniAppSearch.SearchExtInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
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
  private MiniAppSearch.SearchExtInfo searchExtInfo;
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
  
  public MiniAppSearch.SearchExtInfo getSearchExtInfo()
  {
    return this.searchExtInfo;
  }
  
  public int getType()
  {
    return 2;
  }
  
  public String getUseNumberDesc()
  {
    int i = this.userNum;
    if (i < 10000)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.userNum);
      localStringBuilder.append(HardCodeUtil.a(2131694171));
      return localStringBuilder.toString();
    }
    if (i >= 100000000)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.userNum / 100000000);
      localStringBuilder.append(HardCodeUtil.a(2131694170));
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.userNum / 10000);
    localStringBuilder.append(HardCodeUtil.a(2131694172));
    return localStringBuilder.toString();
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public void setSearchExtInfo(MiniAppSearch.SearchExtInfo paramSearchExtInfo)
  {
    this.searchExtInfo = paramSearchExtInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.comm.SearchInfo
 * JD-Core Version:    0.7.0.1
 */