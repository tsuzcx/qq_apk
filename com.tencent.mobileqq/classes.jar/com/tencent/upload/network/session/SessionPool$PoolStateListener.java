package com.tencent.upload.network.session;

import com.tencent.upload.utils.Const.FileType;

public abstract interface SessionPool$PoolStateListener
{
  public abstract void allIpFailed(SessionPool paramSessionPool);
  
  public abstract void onSessionPoolError(SessionPool paramSessionPool, int paramInt);
  
  public abstract void onSessionPoolRestore(Const.FileType paramFileType);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.session.SessionPool.PoolStateListener
 * JD-Core Version:    0.7.0.1
 */