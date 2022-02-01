package com.tencent.tkd.comment.publisher.qq.bridge;

import android.content.Intent;

public abstract interface QQLifecycleBridge
{
  public static final QQLifecycleBridge EMPTY = new QQLifecycleBridge.1();
  
  public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onDestroy(boolean paramBoolean);
  
  public abstract void onPause();
  
  public abstract void onResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.bridge.QQLifecycleBridge
 * JD-Core Version:    0.7.0.1
 */