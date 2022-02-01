package com.tencent.qcircle.application.initprocess;

import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QCircleInitChain
{
  private List<IAppInitProcess> a = new ArrayList();
  
  public QCircleInitChain a()
  {
    this.a.add(new QCircleInitStartProcess());
    this.a.add(new QCircleInitUploadProcess());
    this.a.add(new QCircleInitClassProcess());
    return this;
  }
  
  public void b()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      IAppInitProcess localIAppInitProcess = (IAppInitProcess)localIterator.next();
      if (localIAppInitProcess.a()) {
        RFThreadManager.execute(new QCircleInitChain.1(this, localIAppInitProcess), RFThreadManager.Normal);
      } else {
        localIAppInitProcess.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.application.initprocess.QCircleInitChain
 * JD-Core Version:    0.7.0.1
 */