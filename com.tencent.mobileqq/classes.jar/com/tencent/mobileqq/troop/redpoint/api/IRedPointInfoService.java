package com.tencent.mobileqq.troop.redpoint.api;

import android.view.View;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.redpoint.RedPointInfo;
import com.tencent.mobileqq.troop.redpoint.RedPointListener;
import java.util.HashMap;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IRedPointInfoService
  extends IRuntimeService
{
  public abstract void addRedPointListener(RedPointListener paramRedPointListener);
  
  public abstract void cleanRedPointInfoById(String paramString1, String paramString2, int paramInt);
  
  public abstract void cleanRedPointInfoByIds(String paramString1, String paramString2, List<Integer> paramList);
  
  public abstract RedPointInfo getRedPointInfo(String paramString1, String paramString2);
  
  public abstract void notifyRedPointViewClick(String paramString1, String paramString2, View paramView);
  
  public abstract void removeRedPointListener(RedPointListener paramRedPointListener);
  
  public abstract void updateRedPointInfo(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract void updateRedPointInfos(String paramString1, String paramString2, HashMap<Integer, Integer> paramHashMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.api.IRedPointInfoService
 * JD-Core Version:    0.7.0.1
 */