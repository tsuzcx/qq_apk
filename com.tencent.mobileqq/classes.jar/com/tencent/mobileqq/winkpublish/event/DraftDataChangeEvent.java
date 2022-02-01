package com.tencent.mobileqq.winkpublish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.winkpublish.model.DraftBean;

public class DraftDataChangeEvent
  extends SimpleBaseEvent
{
  public static final int OPTION_TYPE_ADD = 1;
  public static final int OPTION_TYPE_DEL = 2;
  public static final int OPTION_TYPE_QUERY = 4;
  public static final int OPTION_TYPE_UPDATE = 3;
  private DraftBean draftBean;
  private String missionId;
  private int optionType;
  
  public DraftDataChangeEvent(int paramInt)
  {
    this.optionType = paramInt;
  }
  
  public DraftDataChangeEvent(int paramInt, String paramString)
  {
    this.optionType = paramInt;
    this.missionId = paramString;
  }
  
  public DraftDataChangeEvent(int paramInt, String paramString, DraftBean paramDraftBean)
  {
    this.optionType = paramInt;
    this.missionId = paramString;
    this.draftBean = paramDraftBean;
  }
  
  public DraftBean getDraftBean()
  {
    return this.draftBean;
  }
  
  public String getMissionId()
  {
    return this.missionId;
  }
  
  public int getOptionType()
  {
    return this.optionType;
  }
  
  public void setDraftBean(DraftBean paramDraftBean)
  {
    this.draftBean = paramDraftBean;
  }
  
  public void setMissionId(String paramString)
  {
    this.missionId = paramString;
  }
  
  public void setOptionType(int paramInt)
  {
    this.optionType = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DraftDataChangeEvent{optionType=");
    localStringBuilder.append(this.optionType);
    localStringBuilder.append(", missionId='");
    localStringBuilder.append(this.missionId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", draftBean=");
    localStringBuilder.append(this.draftBean);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.event.DraftDataChangeEvent
 * JD-Core Version:    0.7.0.1
 */