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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("HappyEyeballsRace.breakOtherConns, mConnList.size() = ");
      ((StringBuilder)localObject).append(this.mConnList.size());
      BdhLogUtil.LogEvent("C", ((StringBuilder)localObject).toString());
      localObject = this.mConnList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        IConnection localIConnection = (IConnection)((Iterator)localObject).next();
        if (localIConnection.getConnId() != paramIConnection.getConnId())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("HappyEyeballsRace.breakOtherConns, connId = ");
          localStringBuilder.append(localIConnection.getConnId());
          BdhLogUtil.LogEvent("C", localStringBuilder.toString());
          localIConnection.disConnect();
        }
        ((Iterator)localObject).remove();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramIConnection;
    }
  }
  
  public void doOnConect(boolean paramBoolean, IConnection paramIConnection, HwEngine paramHwEngine)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HappyEyeballsRace.doOnConect , isSuccess = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" ,connId = ");
    localStringBuilder.append(paramIConnection.getConnId());
    BdhLogUtil.LogEvent("C", localStringBuilder.toString());
    if (paramBoolean)
    {
      doOnConnSuc(paramIConnection, paramHwEngine);
      return;
    }
    doOnConnFail(paramIConnection);
  }
  
  public void doOnConnFail(IConnection paramIConnection)
  {
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("HappyEyeballsRace.doOnConnFail. mIsRacing = ");
        localStringBuilder.append(this.mIsRacing);
        BdhLogUtil.LogEvent("C", localStringBuilder.toString());
        if (this.mIsRacing)
        {
          this.mConnList.remove(paramIConnection);
          paramIConnection = new StringBuilder();
          paramIConnection.append("HappyEyeballsRace.doOnConnFail, mRacingRunnable == null : ");
          if (this.mRacingRunnable != null) {
            break label148;
          }
          bool = true;
          paramIConnection.append(bool);
          paramIConnection.append(" , mConnList.size() = ");
          paramIConnection.append(this.mConnList.size());
          BdhLogUtil.LogEvent("C", paramIConnection.toString());
          if ((this.mRacingRunnable == null) && (this.mConnList.size() == 0)) {
            this.mIsRacing = false;
          }
        }
        return;
      }
      finally {}
      label148:
      boolean bool = false;
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
      paramIConnection = new StringBuilder();
      paramIConnection.append("HappyEyeballsRace.doOnConnSuc, mIsIpv6Fast = ");
      paramIConnection.append(this.mIsIpv6Fast);
      BdhLogUtil.LogEvent("C", paramIConnection.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.ipv6.HappyEyeballsRace
 * JD-Core Version:    0.7.0.1
 */