package com.tencent.tbs.reader.external;

public class TbsReaderAdvAtom
  implements ITbsReaderEditAtom
{
  protected ITbsReaderEditAtom mReaderAtom;
  
  public TbsReaderAdvAtom(ITbsReaderEditAtom paramITbsReaderEditAtom)
  {
    this.mReaderAtom = paramITbsReaderEditAtom;
  }
  
  public void destory()
  {
    this.mReaderAtom = null;
  }
  
  public void enterEditMode()
  {
    ITbsReaderEditAtom localITbsReaderEditAtom = this.mReaderAtom;
    if (localITbsReaderEditAtom != null) {
      localITbsReaderEditAtom.enterEditMode();
    }
  }
  
  public void enterFindMode()
  {
    ITbsReaderEditAtom localITbsReaderEditAtom = this.mReaderAtom;
    if (localITbsReaderEditAtom != null) {
      localITbsReaderEditAtom.enterFindMode();
    }
  }
  
  public void enterFitScreen()
  {
    ITbsReaderEditAtom localITbsReaderEditAtom = this.mReaderAtom;
    if (localITbsReaderEditAtom != null) {
      localITbsReaderEditAtom.enterFitScreen();
    }
  }
  
  public void enterPlayMode()
  {
    ITbsReaderEditAtom localITbsReaderEditAtom = this.mReaderAtom;
    if (localITbsReaderEditAtom != null) {
      localITbsReaderEditAtom.enterPlayMode();
    }
  }
  
  public void exitEditMode()
  {
    ITbsReaderEditAtom localITbsReaderEditAtom = this.mReaderAtom;
    if (localITbsReaderEditAtom != null) {
      localITbsReaderEditAtom.exitEditMode();
    }
  }
  
  public void exitFindMode()
  {
    ITbsReaderEditAtom localITbsReaderEditAtom = this.mReaderAtom;
    if (localITbsReaderEditAtom != null) {
      localITbsReaderEditAtom.exitFindMode();
    }
  }
  
  public void exitFitScreen()
  {
    ITbsReaderEditAtom localITbsReaderEditAtom = this.mReaderAtom;
    if (localITbsReaderEditAtom != null) {
      localITbsReaderEditAtom.exitFitScreen();
    }
  }
  
  public void exitPlayMode()
  {
    ITbsReaderEditAtom localITbsReaderEditAtom = this.mReaderAtom;
    if (localITbsReaderEditAtom != null) {
      localITbsReaderEditAtom.exitPlayMode();
    }
  }
  
  public void findNext()
  {
    ITbsReaderEditAtom localITbsReaderEditAtom = this.mReaderAtom;
    if (localITbsReaderEditAtom != null) {
      localITbsReaderEditAtom.findNext();
    }
  }
  
  public void findPrev()
  {
    ITbsReaderEditAtom localITbsReaderEditAtom = this.mReaderAtom;
    if (localITbsReaderEditAtom != null) {
      localITbsReaderEditAtom.findPrev();
    }
  }
  
  public int getAtomType()
  {
    return 2;
  }
  
  public void getOutLineData()
  {
    ITbsReaderEditAtom localITbsReaderEditAtom = this.mReaderAtom;
    if (localITbsReaderEditAtom != null) {
      localITbsReaderEditAtom.getOutLineData();
    }
  }
  
  public int init(Object paramObject)
  {
    ITbsReaderEditAtom localITbsReaderEditAtom = this.mReaderAtom;
    if (localITbsReaderEditAtom != null) {
      return localITbsReaderEditAtom.init(paramObject);
    }
    return -1;
  }
  
  public boolean isDocModified()
  {
    ITbsReaderEditAtom localITbsReaderEditAtom = this.mReaderAtom;
    if (localITbsReaderEditAtom != null) {
      return localITbsReaderEditAtom.isDocModified();
    }
    return false;
  }
  
  public boolean qryFitScreenMode()
  {
    ITbsReaderEditAtom localITbsReaderEditAtom = this.mReaderAtom;
    if (localITbsReaderEditAtom != null) {
      return localITbsReaderEditAtom.qryFitScreenMode();
    }
    return false;
  }
  
  public void revertEdit()
  {
    ITbsReaderEditAtom localITbsReaderEditAtom = this.mReaderAtom;
    if (localITbsReaderEditAtom != null) {
      localITbsReaderEditAtom.revertEdit();
    }
  }
  
  public void saveDoc(String paramString)
  {
    ITbsReaderEditAtom localITbsReaderEditAtom = this.mReaderAtom;
    if (localITbsReaderEditAtom != null) {
      localITbsReaderEditAtom.saveDoc(paramString);
    }
  }
  
  public void setDecryptPassWord(String paramString)
  {
    ITbsReaderEditAtom localITbsReaderEditAtom = this.mReaderAtom;
    if (localITbsReaderEditAtom != null) {
      localITbsReaderEditAtom.setDecryptPassWord(paramString);
    }
  }
  
  public void setExcelEditBarBottomMargin(int paramInt)
  {
    ITbsReaderEditAtom localITbsReaderEditAtom = this.mReaderAtom;
    if (localITbsReaderEditAtom != null) {
      localITbsReaderEditAtom.setExcelEditBarBottomMargin(paramInt);
    }
  }
  
  public void setFindText(String paramString)
  {
    ITbsReaderEditAtom localITbsReaderEditAtom = this.mReaderAtom;
    if (localITbsReaderEditAtom != null) {
      localITbsReaderEditAtom.setFindText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.reader.external.TbsReaderAdvAtom
 * JD-Core Version:    0.7.0.1
 */