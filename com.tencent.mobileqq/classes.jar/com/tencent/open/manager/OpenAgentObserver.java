package com.tencent.open.manager;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.open.model.AppInfo;
import java.util.List;

public class OpenAgentObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, OpenAgentHandler.AuthItemResult paramAuthItemResult) {}
  
  protected void a(boolean paramBoolean, List<AppInfo> paramList) {}
  
  protected void a(boolean paramBoolean, List<AppInfo> paramList, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        a(paramBoolean, (OpenAgentHandler.AuthItemResult)paramObject);
        return;
      }
      if (paramBoolean)
      {
        a(paramBoolean, (List)paramObject);
        return;
      }
      a(paramBoolean, null);
      return;
    }
    if (paramBoolean)
    {
      a(paramBoolean, (List)paramObject, null);
      return;
    }
    a(paramBoolean, null, (String)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.manager.OpenAgentObserver
 * JD-Core Version:    0.7.0.1
 */