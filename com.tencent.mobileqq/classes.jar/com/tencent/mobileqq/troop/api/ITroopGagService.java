package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.data.SelfGagInfo;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopGagService
  extends IRuntimeService
{
  public abstract SelfGagInfo getSelfGagInfo(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopGagService
 * JD-Core Version:    0.7.0.1
 */