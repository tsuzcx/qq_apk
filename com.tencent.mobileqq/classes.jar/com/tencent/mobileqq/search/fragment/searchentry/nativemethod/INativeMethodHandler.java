package com.tencent.mobileqq.search.fragment.searchentry.nativemethod;

public abstract interface INativeMethodHandler
{
  public abstract void fillKeyword(String paramString);
  
  public abstract void hideInputMethod();
  
  public abstract void onHotwordClick(int paramInt);
  
  public abstract void requestSearchHotWord(boolean paramBoolean);
  
  public abstract void setHotwordVisible(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.nativemethod.INativeMethodHandler
 * JD-Core Version:    0.7.0.1
 */