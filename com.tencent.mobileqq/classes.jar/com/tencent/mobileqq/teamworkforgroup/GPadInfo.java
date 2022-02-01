package com.tencent.mobileqq.teamworkforgroup;

import beex;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import java.util.ArrayList;
import java.util.List;

public class GPadInfo
  extends PadInfo
  implements beex
{
  public String creatorCard;
  public long creatorUid;
  public long groupCode;
  public String lastModifyCard;
  public long lastModifyUid;
  @notColumn
  public boolean mClickable = true;
  @notColumn
  public boolean mSelectable;
  @notColumn
  public List<TimDocSSOMsg.UinRightInfo> mUins;
  public String ownerCard;
  public long ownerUin;
  public long owneruid;
  @notColumn
  public List<String> searchKeyWordList = new ArrayList();
  
  public void copyFrom(PadInfo paramPadInfo)
  {
    paramPadInfo = (GPadInfo)paramPadInfo;
    super.copyFrom(paramPadInfo);
    this.groupCode = paramPadInfo.groupCode;
    this.creatorCard = paramPadInfo.creatorCard;
    this.ownerUin = paramPadInfo.ownerUin;
    this.ownerCard = paramPadInfo.ownerCard;
    this.lastModifyCard = paramPadInfo.lastModifyCard;
    this.owneruid = paramPadInfo.owneruid;
    this.lastModifyUid = paramPadInfo.lastModifyUid;
    this.creatorUid = paramPadInfo.creatorUid;
    this.searchKeyWordList.addAll(paramPadInfo.searchKeyWordList);
  }
  
  public int getCloudFileType()
  {
    return 2;
  }
  
  public boolean isClickable()
  {
    return this.mClickable;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(" == padInfo == \n");
    localStringBuilder.append("domainId: ").append(this.domainId).append(",padId: ").append(this.padId).append(",lastUnPinnedTime: ").append(this.lastUnPinnedTime).append(",itemDeleteFlag: ").append(this.itemDeleteFlag).append(",itemLateDeleteTime: ").append(this.itemLateDeleteTime).append(",thumbUrl: ").append(this.thumbUrl).append(",pad_url: ").append(this.pad_url).append(",type: ").append(this.type).append(",title: ").append(this.title).append(",createTime: ").append(this.createTime).append(",creatorUin: ").append(this.creatorUin).append(",creatorNick: ").append(this.creatorNick).append(",lastEditorUin: ").append(this.lastEditorUin).append(",lastEditorNick: ").append(this.lastEditorNick).append(",lastEditTime: ").append(this.lastEditTime).append(",pinedFlag: ").append(this.pinedFlag).append(",policy: ").append(this.policy).append(",group code: ").append(this.groupCode).append(",creator card: ").append(this.creatorCard).append(",owner uin: ").append(this.ownerUin).append(", owner card ").append(this.ownerCard).append(", lastModifyCard: ").append(this.lastModifyCard).append(", creator uid: ").append(this.creatorUid).append(" , last modify uid: ").append(this.lastModifyUid).append(", owner uid").append(this.owneruid);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GPadInfo
 * JD-Core Version:    0.7.0.1
 */