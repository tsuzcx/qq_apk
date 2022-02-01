package com.tencent.mobileqq.highway.ipv6;

import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.conn.IConnection;
import com.tencent.mobileqq.highway.segment.RequestWorker;
import com.tencent.mobileqq.highway.segment.RequestWorker.RequestHandler;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HappyEyeballsRace
{
  public List<IConnection> mConnList = new LinkedList();
  public boolean mIsIpv6Fast;
  public boolean mIsRacing;
  public Runnable mRacingRunnable;
  
  private void breakOtherConns(IConnection paramIConnection)
  {
    try
    {
      BdhLogUtil.LogEvent("C", "HappyEyeballsRace.breakOtherConns, mConnList.size() = " + this.mConnList.size());
      Iterator localIterator = this.mConnList.iterator();
      while (localIterator.hasNext())
      {
        IConnection localIConnection = (IConnection)localIterator.next();
        if (localIConnection.getConnId() != paramIConnection.getConnId())
        {
          BdhLogUtil.LogEvent("C", "HappyEyeballsRace.breakOtherConns, connId = " + localIConnection.getConnId());
          localIConnection.disConnect();
        }
        localIterator.remove();
      }
    }
    finally {}
  }
  
  public void doOnConect(boolean paramBoolean, IConnection paramIConnection, HwEngine paramHwEngine)
  {
    BdhLogUtil.LogEvent("C", "HappyEyeballsRace.doOnConect , isSuccess = " + paramBoolean + " ,connId = " + paramIConnection.getConnId());
    if (paramBoolean)
    {
      doOnConnSuc(paramIConnection, paramHwEngine);
      return;
    }
    doOnConnFail(paramIConnection, paramHwEngine);
  }
  
  public void doOnConnFail(IConnection paramIConnection, HwEngine paramHwEngine)
  {
    try
    {
      BdhLogUtil.LogEvent("C", "HappyEyeballsRace.doOnConnFail. mIsRacing = " + this.mIsRacing);
      if (this.mIsRacing)
      {
        this.mConnList.remove(paramIConnection);
        if ((this.mRacingRunnable == null) && (this.mConnList.size() == 0)) {
          this.mIsRacing = false;
        }
      }
      return;
    }
    finally
    {
      paramIConnection = finally;
      throw paramIConnection;
    }
  }
  
  public void doOnConnSuc(IConnection paramIConnection, HwEngine paramHwEngine)
  {
    BdhLogUtil.LogEvent("C", "HappyEyeballsRace.doOnConnSuc.");
    if (this.mIsRacing)
    {
      this.mIsRacing = false;
      if ((this.mRacingRunnable != null) && (paramHwEngine.mRequestWorker.mRequestHandler != null)) {
        paramHwEngine.mRequestWorker.mRequestHandler.removeCallbacks(this.mRacingRunnable);
      }
      breakOtherConns(paramIConnection);
      this.mIsIpv6Fast = paramIConnection.isIpv6();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.ipv6.HappyEyeballsRace
 * JD-Core Version:    0.7.0.1
 */