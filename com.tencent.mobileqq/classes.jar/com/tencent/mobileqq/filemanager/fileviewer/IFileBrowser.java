package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;

public abstract interface IFileBrowser
{
  public abstract int a();
  
  public abstract RelativeLayout a();
  
  public abstract QQAppInterface a();
  
  public abstract ForwardFileInfo a();
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean b();
  
  public abstract void d();
  
  public abstract Activity getActivity();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser
 * JD-Core Version:    0.7.0.1
 */