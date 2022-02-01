package com.tencent.mobileqq.data;

import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class PublicAccountMenuEntity
  extends Entity
{
  public byte[] data = null;
  public long savedDateTime;
  public int seqno;
  @unique
  public String uin;
  
  public PublicAccountMenuEntity()
  {
    this.seqno = 0;
    this.savedDateTime = 0L;
  }
  
  public PublicAccountMenuEntity(String paramString, mobileqq_mp.GetPublicAccountMenuResponse paramGetPublicAccountMenuResponse)
  {
    this(paramString, paramGetPublicAccountMenuResponse, System.currentTimeMillis());
  }
  
  public PublicAccountMenuEntity(String paramString, mobileqq_mp.GetPublicAccountMenuResponse paramGetPublicAccountMenuResponse, long paramLong)
  {
    int i = 0;
    this.seqno = 0;
    this.savedDateTime = 0L;
    this.uin = paramString;
    this.data = paramGetPublicAccountMenuResponse.toByteArray();
    this.savedDateTime = paramLong;
    if (paramGetPublicAccountMenuResponse.seqno.has()) {
      i = paramGetPublicAccountMenuResponse.seqno.get();
    }
    this.seqno = i;
  }
  
  public void clone(PublicAccountMenuEntity paramPublicAccountMenuEntity)
  {
    this.uin = paramPublicAccountMenuEntity.uin;
    this.data = ((byte[])paramPublicAccountMenuEntity.data.clone());
    this.savedDateTime = paramPublicAccountMenuEntity.savedDateTime;
    this.seqno = paramPublicAccountMenuEntity.seqno;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.PublicAccountMenuEntity
 * JD-Core Version:    0.7.0.1
 */