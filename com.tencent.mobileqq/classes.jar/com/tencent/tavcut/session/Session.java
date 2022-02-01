package com.tencent.tavcut.session;

import android.content.Context;

public abstract interface Session
{
  public abstract int init(Context paramContext);
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.Session
 * JD-Core Version:    0.7.0.1
 */