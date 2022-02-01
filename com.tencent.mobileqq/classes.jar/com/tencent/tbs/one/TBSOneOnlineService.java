package com.tencent.tbs.one;

import android.os.Bundle;

public abstract interface TBSOneOnlineService
{
  public abstract void cancelUpdate();
  
  public abstract void update(Bundle paramBundle, TBSOneCallback<Void> paramTBSOneCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.TBSOneOnlineService
 * JD-Core Version:    0.7.0.1
 */