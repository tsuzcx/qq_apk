package com.tencent.mobileqq.colornote.api;

import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.IColorNoteListener;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IColorNoteDataService
  extends IRuntimeService
{
  public abstract boolean addColorNote(String paramString, ColorNote paramColorNote, ProxyListener paramProxyListener, boolean paramBoolean);
  
  public abstract boolean canAddColorNote();
  
  public abstract void clearAllUpcomingMindFlag();
  
  public abstract ArrayList<ColorNote> deleteAllColorNote(String paramString, ProxyListener paramProxyListener);
  
  public abstract void deleteColorNote(String paramString, ColorNote paramColorNote, ProxyListener paramProxyListener);
  
  public abstract List<ColorNote> extraTypeFilter(List<ColorNote> paramList, int paramInt);
  
  public abstract ColorNote findColorNoteByKey(String paramString);
  
  public abstract ColorNote findColorNoteByKey(String paramString, int paramInt);
  
  public abstract List<ColorNote> getColorNotes(boolean paramBoolean);
  
  public abstract List<ColorNote> getColorNotes(boolean paramBoolean, int paramInt);
  
  public abstract int getCurrentColorNoteCount();
  
  public abstract List<ColorNote> getVisiableColorNotes();
  
  public abstract List<ColorNote> getVisiableColorNotes(List<ColorNote> paramList);
  
  public abstract void registerColorNoteListener(IColorNoteListener paramIColorNoteListener);
  
  public abstract void setCache(List<ColorNote> paramList);
  
  public abstract void setEntityManager(EntityManager paramEntityManager);
  
  public abstract void setUpcomingColorNoteExtLong(ColorNote paramColorNote);
  
  public abstract void unregisterColorNoteListener(IColorNoteListener paramIColorNoteListener);
  
  public abstract ColorNote updateColorNoteFieldByKey(String paramString1, String paramString2, String paramString3, Object paramObject);
  
  public abstract boolean updateRecentNote(String paramString, ColorNote paramColorNote);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.api.IColorNoteDataService
 * JD-Core Version:    0.7.0.1
 */