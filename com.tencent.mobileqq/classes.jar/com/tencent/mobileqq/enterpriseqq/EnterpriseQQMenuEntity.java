package com.tencent.mobileqq.enterpriseqq;

import aukm;
import auma;
import com.tencent.crmqq.structmsg.StructMsg.GetCRMMenuResponse;

public class EnterpriseQQMenuEntity
  extends aukm
{
  public byte[] data;
  public long savedDateTime;
  public int seqno;
  @auma
  public String uin;
  
  public EnterpriseQQMenuEntity() {}
  
  public EnterpriseQQMenuEntity(String paramString, StructMsg.GetCRMMenuResponse paramGetCRMMenuResponse, int paramInt, long paramLong)
  {
    this.uin = paramString;
    this.data = paramGetCRMMenuResponse.toByteArray();
    this.seqno = paramInt;
    this.savedDateTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.enterpriseqq.EnterpriseQQMenuEntity
 * JD-Core Version:    0.7.0.1
 */