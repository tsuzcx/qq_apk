package com.tencent.mobileqq.profilecard.bussiness.miniapp;

import NS_MINI_APP_MISC.MISC.StAppPlayingInfo;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import java.util.ArrayList;
import java.util.List;

public class ProfileMiniAppInfo
  implements IProfileBusinessInfo
{
  public List<MISC.StAppPlayingInfo> appPlayingInfos;
  public int guestAppTotal;
  public String guestJumpUrl;
  public boolean isShowMiniPlaying;
  public ArrayList<INTERFACE.StApiAppInfo> miniAppInfoArrayList;
  public String tabJumpUrl;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.miniapp.ProfileMiniAppInfo
 * JD-Core Version:    0.7.0.1
 */