package com.tencent.qcircle.shadow.core.runtime.remoteview;

import android.view.View;

public abstract interface ShadowRemoteViewCreator
{
  public abstract View createView(String paramString1, String paramString2);
  
  public abstract void createView(String paramString1, String paramString2, ShadowRemoteViewCreateCallback paramShadowRemoteViewCreateCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.remoteview.ShadowRemoteViewCreator
 * JD-Core Version:    0.7.0.1
 */