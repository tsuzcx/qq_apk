package com.tencent.mobileqq.gamecenter.data;

import java.io.Serializable;
import java.util.List;

public class FeedsItemData
  implements Serializable
{
  public String algorithmId;
  public String authorIcon;
  public String authorName;
  public int commentNum;
  public String coverImgUrl;
  public String feedId;
  public List<FeedsItemData.FriendInfo> friendList;
  public int friendNum;
  public int friendType;
  public FeedsItemData.GameInfo gameInfo;
  public List<FeedsItemData.Gift> giftList;
  public String groupId = "";
  public String jumpUrl;
  public String label = "";
  public int miniType;
  public String msgId;
  public String operateText = "";
  public String rcmdReason = "";
  public String subTitle = "";
  public String title;
  public int type;
  public int videoDuration;
  public String videoSrcImg;
  public String videoSrcName;
  public int videoSrcType;
  public int videoType;
  public String videoUrl;
  public String videoVid;
  public int videoViewers;
  public int viewersNum;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.FeedsItemData
 * JD-Core Version:    0.7.0.1
 */