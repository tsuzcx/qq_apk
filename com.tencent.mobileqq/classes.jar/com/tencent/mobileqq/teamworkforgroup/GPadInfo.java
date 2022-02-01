package com.tencent.mobileqq.teamworkforgroup;

import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import java.util.ArrayList;
import java.util.List;

public class GPadInfo
  extends PadInfo
  implements ICloudFile
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
    localStringBuilder.append("domainId: ");
    localStringBuilder.append(this.domainId);
    localStringBuilder.append(",padId: ");
    localStringBuilder.append(this.padId);
    localStringBuilder.append(",lastUnPinnedTime: ");
    localStringBuilder.append(this.lastUnPinnedTime);
    localStringBuilder.append(",itemDeleteFlag: ");
    localStringBuilder.append(this.itemDeleteFlag);
    localStringBuilder.append(",itemLateDeleteTime: ");
    localStringBuilder.append(this.itemLateDeleteTime);
    localStringBuilder.append(",thumbUrl: ");
    localStringBuilder.append(this.thumbUrl);
    localStringBuilder.append(",pad_url: ");
    localStringBuilder.append(this.pad_url);
    localStringBuilder.append(",type: ");
    localStringBuilder.append(this.type);
    localStringBuilder.append(",title: ");
    localStringBuilder.append(this.title);
    localStringBuilder.append(",createTime: ");
    localStringBuilder.append(this.createTime);
    localStringBuilder.append(",creatorUin: ");
    localStringBuilder.append(this.creatorUin);
    localStringBuilder.append(",creatorNick: ");
    localStringBuilder.append(this.creatorNick);
    localStringBuilder.append(",lastEditorUin: ");
    localStringBuilder.append(this.lastEditorUin);
    localStringBuilder.append(",lastEditorNick: ");
    localStringBuilder.append(this.lastEditorNick);
    localStringBuilder.append(",lastEditTime: ");
    localStringBuilder.append(this.lastEditTime);
    localStringBuilder.append(",pinedFlag: ");
    localStringBuilder.append(this.pinedFlag);
    localStringBuilder.append(",policy: ");
    localStringBuilder.append(this.policy);
    localStringBuilder.append(",group code: ");
    localStringBuilder.append(this.groupCode);
    localStringBuilder.append(",creator card: ");
    localStringBuilder.append(this.creatorCard);
    localStringBuilder.append(",owner uin: ");
    localStringBuilder.append(this.ownerUin);
    localStringBuilder.append(", owner card ");
    localStringBuilder.append(this.ownerCard);
    localStringBuilder.append(", lastModifyCard: ");
    localStringBuilder.append(this.lastModifyCard);
    localStringBuilder.append(", creator uid: ");
    localStringBuilder.append(this.creatorUid);
    localStringBuilder.append(" , last modify uid: ");
    localStringBuilder.append(this.lastModifyUid);
    localStringBuilder.append(", owner uid");
    localStringBuilder.append(this.owneruid);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GPadInfo
 * JD-Core Version:    0.7.0.1
 */