package com.tencent.mobileqq.stranger.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.stranger.data.Stranger;
import java.util.List;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;

public class StrangerObserver
  implements BusinessObserver
{
  public void a(List<String> paramList) {}
  
  public void a(boolean paramBoolean, PBRepeatMessageField<oidb_0x5d4.DelResult> paramPBRepeatMessageField) {}
  
  public void a(boolean paramBoolean, List<Stranger> paramList) {}
  
  public void b(boolean paramBoolean, List<Stranger> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1)
    {
      b(paramBoolean, (List)paramObject);
      return;
    }
    if (paramInt == 2)
    {
      a(paramBoolean, (List)paramObject);
      return;
    }
    if (paramInt == 3)
    {
      a(paramBoolean, (PBRepeatMessageField)paramObject);
      return;
    }
    if (paramInt == 4) {
      a((List)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.stranger.observer.StrangerObserver
 * JD-Core Version:    0.7.0.1
 */