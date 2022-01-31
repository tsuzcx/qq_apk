package com.tencent.mobileqq.data;

import awge;
import awhs;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class PublicAccountMenuEntity
  extends awge
{
  public byte[] data;
  public long savedDateTime;
  public int seqno;
  @awhs
  public String uin;
  
  public PublicAccountMenuEntity() {}
  
  public PublicAccountMenuEntity(String paramString, mobileqq_mp.GetPublicAccountMenuResponse paramGetPublicAccountMenuResponse)
  {
    this(paramString, paramGetPublicAccountMenuResponse, System.currentTimeMillis());
  }
  
  public PublicAccountMenuEntity(String paramString, mobileqq_mp.GetPublicAccountMenuResponse paramGetPublicAccountMenuResponse, long paramLong)
  {
    this.uin = paramString;
    this.data = paramGetPublicAccountMenuResponse.toByteArray();
    this.savedDateTime = paramLong;
    if (paramGetPublicAccountMenuResponse.seqno.has()) {}
    for (int i = paramGetPublicAccountMenuResponse.seqno.get();; i = 0)
    {
      this.seqno = i;
      return;
    }
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