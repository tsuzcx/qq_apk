package com.tencent.mobileqq.vashealth.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.HashMap;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IQQHealthService
  extends IRuntimeService
{
  public abstract boolean redirectAIOToMainPage(Context paramContext, int paramInt);
  
  public abstract void redirectAIOToMainPageInPA(Context paramContext);
  
  public abstract void reportToBeaconIfNeed(String paramString, HashMap<String, String> paramHashMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.api.IQQHealthService
 * JD-Core Version:    0.7.0.1
 */