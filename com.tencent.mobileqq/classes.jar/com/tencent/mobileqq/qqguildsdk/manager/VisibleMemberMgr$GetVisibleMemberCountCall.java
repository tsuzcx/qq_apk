package com.tencent.mobileqq.qqguildsdk.manager;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.callback.IGetVisibleMemberCountCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VisibleMemberMgr$GetVisibleMemberCountCall
  implements IGetVisibleMemberCountCallback
{
  private final List<IGetVisibleMemberCountCallback> a = new ArrayList();
  
  public void a(@NonNull IGetVisibleMemberCountCallback paramIGetVisibleMemberCountCallback)
  {
    this.a.add(paramIGetVisibleMemberCountCallback);
  }
  
  public void onGetVisibleMemberCount(int paramInt1, String paramString, int paramInt2)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((IGetVisibleMemberCountCallback)localIterator.next()).onGetVisibleMemberCount(paramInt1, paramString, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.manager.VisibleMemberMgr.GetVisibleMemberCountCall
 * JD-Core Version:    0.7.0.1
 */