package com.tencent.mobileqq.teamwork;

import awge;
import awhp;
import awhs;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import java.util.ArrayList;
import java.util.List;

public class PadInfo
  extends awge
{
  public static final int TYPE_DOC = 1;
  public static final int TYPE_FORM = 3;
  public static final int TYPE_LIST_ALL = 4;
  public static final int TYPE_LIST_BROWSE = 2;
  public static final int TYPE_LIST_CREATE = 1;
  public static final int TYPE_LIST_SHARED = 3;
  public static final int TYPE_PDF = 5;
  public static final int TYPE_PIN_LIST_IN_LIST_ALL = 5;
  public static final int TYPE_PPT = 4;
  public static final int TYPE_SHEET = 2;
  public long createTime;
  public String creatorNick;
  public long creatorUin;
  public long currentUserBrowseTime;
  public long domainId;
  public boolean itemDeleteFlag;
  public long itemLateDeleteTime;
  public long lastEditTime;
  public String lastEditorNick;
  public long lastEditorUin;
  public long lastPinnedTime;
  public long lastPinnedTimeInAllList;
  public long lastUnPinnedTime;
  public long lastViewTime;
  public String lastViewerNick;
  public long lastViewerUin;
  public long lastshardTime;
  @awhp
  private List<TimDocSSOMsg.UinRightInfo> mUins = new ArrayList();
  public String padId;
  @awhs
  public String pad_url;
  public boolean pinInAllList;
  public boolean pinedFlag;
  public int policy = 2;
  public String shardNick;
  public long shardUin;
  public String thumbUrl;
  public String title;
  public int type;
  public int type_list;
  
  public void copyFrom(PadInfo paramPadInfo)
  {
    this.domainId = paramPadInfo.domainId;
    this.padId = paramPadInfo.padId;
    this.lastUnPinnedTime = paramPadInfo.lastUnPinnedTime;
    this.itemDeleteFlag = paramPadInfo.itemDeleteFlag;
    this.itemLateDeleteTime = paramPadInfo.itemLateDeleteTime;
    this.thumbUrl = paramPadInfo.thumbUrl;
    this.pad_url = paramPadInfo.pad_url;
    this.type_list = paramPadInfo.type_list;
    this.type = paramPadInfo.type;
    this.title = paramPadInfo.title;
    this.createTime = paramPadInfo.createTime;
    this.creatorUin = paramPadInfo.creatorUin;
    this.creatorNick = paramPadInfo.creatorNick;
    this.lastEditorUin = paramPadInfo.lastEditorUin;
    this.lastEditorNick = paramPadInfo.lastEditorNick;
    this.lastEditTime = paramPadInfo.lastEditTime;
    this.pinedFlag = paramPadInfo.pinedFlag;
    this.lastViewerUin = paramPadInfo.lastViewerUin;
    this.lastViewerNick = paramPadInfo.lastViewerNick;
    this.lastViewTime = paramPadInfo.lastViewTime;
    this.lastPinnedTime = paramPadInfo.lastPinnedTime;
    this.currentUserBrowseTime = paramPadInfo.currentUserBrowseTime;
    this.shardUin = paramPadInfo.shardUin;
    this.shardNick = paramPadInfo.shardNick;
    this.lastshardTime = paramPadInfo.lastshardTime;
    this.policy = paramPadInfo.policy;
    this.mUins.addAll(paramPadInfo.mUins);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof PadInfo)) {
      return (this.pad_url != null) && (this.pad_url.equalsIgnoreCase(((PadInfo)paramObject).pad_url));
    }
    return super.equals(paramObject);
  }
  
  public List<TimDocSSOMsg.UinRightInfo> getRightList()
  {
    return this.mUins;
  }
  
  public void setRightsList(List<TimDocSSOMsg.UinRightInfo> paramList)
  {
    this.mUins = paramList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(" == padInfo == \n");
    localStringBuilder.append("domainId: ").append(this.domainId).append(",padId: ").append(this.padId).append(",lastUnPinnedTime: ").append(this.lastUnPinnedTime).append(",itemDeleteFlag: ").append(this.itemDeleteFlag).append(",itemLateDeleteTime: ").append(this.itemLateDeleteTime).append(",thumbUrl: ").append(this.thumbUrl).append(",pad_url: ").append(this.pad_url).append(",type: ").append(this.type).append(",title: ").append(this.title).append(",createTime: ").append(this.createTime).append(",creatorUin: ").append(this.creatorUin).append(",creatorNick: ").append(this.creatorNick).append(",lastEditorUin: ").append(this.lastEditorUin).append(",lastEditorNick: ").append(this.lastEditorNick).append(",lastEditTime: ").append(this.lastEditTime).append(",pinedFlag: ").append(this.pinedFlag).append(",policy: ").append(this.policy);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.PadInfo
 * JD-Core Version:    0.7.0.1
 */