package com.tencent.mobileqq.troop.redpoint.troopsettingredpoint;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class CenterProcessor
{
  private String a;
  private QQAppInterface b;
  private ConcurrentHashMap<Integer, AbsBaseProcessor> c = new ConcurrentHashMap();
  
  public CenterProcessor(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.b = paramQQAppInterface;
    this.a = paramString;
    d();
  }
  
  private void d()
  {
    ConcurrentHashMap localConcurrentHashMap = this.c;
    if (localConcurrentHashMap != null)
    {
      localConcurrentHashMap.put(Integer.valueOf(1), new RobotProcessor(this.b, this.a));
      this.c.put(Integer.valueOf(3), new GameCardProcessor(this.b, this.a));
      this.c.put(Integer.valueOf(5), new TroopMgrAppProcessor(this.b, this.a));
    }
  }
  
  public void a()
  {
    ConcurrentHashMap localConcurrentHashMap = this.c;
    if (localConcurrentHashMap != null)
    {
      if (localConcurrentHashMap.isEmpty()) {
        return;
      }
      ThreadManager.getFileThreadHandler().post(new CenterProcessor.1(this));
    }
  }
  
  public void b()
  {
    ConcurrentHashMap localConcurrentHashMap = this.c;
    if (localConcurrentHashMap != null)
    {
      if (localConcurrentHashMap.isEmpty()) {
        return;
      }
      ThreadManager.getFileThreadHandler().post(new CenterProcessor.2(this));
    }
  }
  
  public void c()
  {
    ConcurrentHashMap localConcurrentHashMap = this.c;
    if (localConcurrentHashMap != null)
    {
      if (localConcurrentHashMap.isEmpty()) {
        return;
      }
      ThreadManager.getFileThreadHandler().post(new CenterProcessor.3(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.CenterProcessor
 * JD-Core Version:    0.7.0.1
 */