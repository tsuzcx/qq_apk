package com.tencent.vas.update.entity;

import androidx.annotation.NonNull;
import com.tencent.vas.update.util.CommonUtil;

public class BusinessUpdateParams
{
  public long mBid;
  public String mFrom;
  public String mItemId;
  public String mScid;
  
  public BusinessUpdateParams(long paramLong, String paramString1, String paramString2)
  {
    this.mBid = paramLong;
    this.mScid = paramString1;
    this.mFrom = paramString2;
    this.mItemId = CommonUtil.sComposeItemId(this.mBid, this.mScid);
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BusinessUpdateParams mItemId = ");
    localStringBuilder.append(this.mItemId);
    localStringBuilder.append("，mBid = ");
    localStringBuilder.append(this.mBid);
    localStringBuilder.append("，mScid = ");
    localStringBuilder.append(this.mScid);
    localStringBuilder.append("，mFrom = ");
    localStringBuilder.append(this.mFrom);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.entity.BusinessUpdateParams
 * JD-Core Version:    0.7.0.1
 */