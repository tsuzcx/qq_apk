package com.tencent.tbs.reader.external;

public abstract interface ITbsReaderEditAtom
  extends ITbsReaderAtom
{
  public abstract void enterEditMode();
  
  public abstract void enterFindMode();
  
  public abstract void enterFitScreen();
  
  public abstract void enterPlayMode();
  
  public abstract void exitEditMode();
  
  public abstract void exitFindMode();
  
  public abstract void exitFitScreen();
  
  public abstract void exitPlayMode();
  
  public abstract void findNext();
  
  public abstract void findPrev();
  
  public abstract void getOutLineData();
  
  public abstract boolean isDocModified();
  
  public abstract boolean qryFitScreenMode();
  
  public abstract void revertEdit();
  
  public abstract void saveDoc(String paramString);
  
  public abstract void setDecryptPassWord(String paramString);
  
  public abstract void setExcelEditBarBottomMargin(int paramInt);
  
  public abstract void setFindText(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.reader.external.ITbsReaderEditAtom
 * JD-Core Version:    0.7.0.1
 */