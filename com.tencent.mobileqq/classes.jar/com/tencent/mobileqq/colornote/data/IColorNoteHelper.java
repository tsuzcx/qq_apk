package com.tencent.mobileqq.colornote.data;

import android.os.Bundle;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IColorNoteHelper
  extends IRuntimeService
{
  public abstract boolean addColorNote(Bundle paramBundle);
  
  public abstract boolean canAddColorNote();
  
  public abstract boolean clearHistoryNote(int paramInt);
  
  public abstract void deleteAllColorNote(AppRuntime paramAppRuntime, ProxyListener paramProxyListener);
  
  public abstract boolean deleteColorNote(int paramInt, String paramString);
  
  public abstract boolean deleteColorNote(int paramInt1, String paramString, int paramInt2);
  
  public abstract boolean deleteColorNote(String paramString, int paramInt);
  
  public abstract boolean isColorNoteExit(int paramInt, String paramString);
  
  public abstract boolean isColorNoteExit(String paramString);
  
  public abstract boolean updateColorNote(String paramString1, String paramString2, Object paramObject);
  
  public abstract boolean updateColorNote(String paramString1, String paramString2, Object paramObject, int paramInt);
  
  public abstract Bundle updateColorNoteState(int paramInt, String paramString, boolean paramBoolean);
  
  public abstract Bundle updateColorNoteState(String paramString, boolean paramBoolean);
  
  public abstract boolean updateRecentNote(ColorNote paramColorNote);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.IColorNoteHelper
 * JD-Core Version:    0.7.0.1
 */