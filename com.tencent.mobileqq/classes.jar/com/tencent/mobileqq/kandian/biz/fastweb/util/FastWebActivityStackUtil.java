package com.tencent.mobileqq.kandian.biz.fastweb.util;

import com.tencent.mobileqq.app.BaseActivity;
import java.util.LinkedList;

public class FastWebActivityStackUtil
{
  private LinkedList<FastWebActivityStackUtil.SaveState> a = new LinkedList();
  private BaseActivity b;
  
  public FastWebActivityStackUtil(BaseActivity paramBaseActivity)
  {
    this.b = paramBaseActivity;
  }
  
  public FastWebActivityStackUtil.SaveState a()
  {
    if (this.a.isEmpty()) {
      return null;
    }
    return (FastWebActivityStackUtil.SaveState)this.a.pop();
  }
  
  public void a(FastWebActivityStackUtil.PopPageListener paramPopPageListener)
  {
    if (paramPopPageListener == null) {
      return;
    }
    while (!b())
    {
      FastWebActivityStackUtil.SaveState localSaveState = a();
      if (localSaveState != null) {
        paramPopPageListener.a(localSaveState);
      }
    }
  }
  
  public void a(FastWebActivityStackUtil.SaveState paramSaveState)
  {
    this.a.push(paramSaveState);
  }
  
  public boolean b()
  {
    return this.a.isEmpty();
  }
  
  public int c()
  {
    LinkedList localLinkedList = this.a;
    if (localLinkedList == null) {
      return 0;
    }
    return localLinkedList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebActivityStackUtil
 * JD-Core Version:    0.7.0.1
 */