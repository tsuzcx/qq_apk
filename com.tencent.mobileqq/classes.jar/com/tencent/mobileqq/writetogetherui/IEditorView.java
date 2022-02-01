package com.tencent.mobileqq.writetogetherui;

import com.tencent.mobileqq.writetogether.data.InsertDeleteWatcher;

public abstract interface IEditorView
{
  public abstract void a();
  
  public abstract void a(InsertDeleteWatcher paramInsertDeleteWatcher);
  
  public abstract void a(String paramString);
  
  public abstract void b(InsertDeleteWatcher paramInsertDeleteWatcher);
  
  public abstract void b(String paramString);
  
  public abstract void setEditorEnabled(boolean paramBoolean);
  
  public abstract void setMySelection(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.IEditorView
 * JD-Core Version:    0.7.0.1
 */