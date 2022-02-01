package com.tencent.mobileqq.emoticonview;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.List;

public abstract class EmoticonLinearLayout$EmoticonAdapter
{
  public static final String RED_TEXT_INIT = "init";
  EmoticonInfo addEmotion;
  int columnNum;
  boolean deleteIconExists;
  EmoticonInfo favEditEmotion;
  EmoticonInfo funnyPicEmotion;
  boolean hasDeleteBtn;
  boolean hasFavEditButton;
  boolean hasFunnyPicButton;
  boolean hasPlusButton;
  boolean hasPushButton;
  boolean hasSettingButton;
  boolean hasUpdatePage;
  List<EmoticonInfo> list;
  EmoticonLinearLayout.DataObserver mObserver;
  int page;
  int pageTotalNum;
  EmoticonInfo pushEmotion;
  public String redString = "init";
  int rowNum;
  EmoticonInfo settingEmotion;
  EmoticonInfo specEmoticon;
  
  public abstract void bindView(int paramInt, RelativeLayout paramRelativeLayout, ViewGroup paramViewGroup);
  
  public int getColumnNum()
  {
    return this.columnNum;
  }
  
  public EmoticonInfo getItem(int paramInt)
  {
    paramInt = getRealIndex(paramInt);
    if (paramInt == -1) {
      return this.specEmoticon;
    }
    if (paramInt == -2) {
      return this.addEmotion;
    }
    if (paramInt == -3) {
      return this.settingEmotion;
    }
    if (paramInt == -4) {
      return this.pushEmotion;
    }
    if (paramInt == -5) {
      return this.favEditEmotion;
    }
    if (paramInt == -6) {
      return this.funnyPicEmotion;
    }
    List localList = this.list;
    if ((localList != null) && (paramInt < localList.size())) {
      return (EmoticonInfo)this.list.get(paramInt);
    }
    return null;
  }
  
  public List<EmoticonInfo> getList()
  {
    return this.list;
  }
  
  public int getPage()
  {
    return this.page;
  }
  
  public int getRealIndex(int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public int getRowNum()
  {
    return this.rowNum;
  }
  
  public EmoticonInfo getSpecEmoticon()
  {
    return this.specEmoticon;
  }
  
  public boolean isHasDeleteBtn()
  {
    return this.hasDeleteBtn;
  }
  
  public boolean isHasPlusButton()
  {
    return this.hasPlusButton;
  }
  
  public boolean isSettingButton()
  {
    return this.hasSettingButton;
  }
  
  public void notifyDataChanged()
  {
    EmoticonLinearLayout.DataObserver localDataObserver = this.mObserver;
    if (localDataObserver != null) {
      localDataObserver.onDataChanged();
    }
  }
  
  public void setAddEmoticon(EmoticonInfo paramEmoticonInfo)
  {
    this.addEmotion = paramEmoticonInfo;
  }
  
  void setDataSetObserver(EmoticonLinearLayout.DataObserver paramDataObserver)
  {
    this.mObserver = paramDataObserver;
  }
  
  public void setFavEditEmoticon(EmoticonInfo paramEmoticonInfo)
  {
    this.favEditEmotion = paramEmoticonInfo;
  }
  
  public void setFunnyPicButton(boolean paramBoolean)
  {
    this.hasFunnyPicButton = paramBoolean;
  }
  
  public void setFunnyPicEmoticon(EmoticonInfo paramEmoticonInfo)
  {
    this.funnyPicEmotion = paramEmoticonInfo;
  }
  
  public void setHasDeleteBtn(boolean paramBoolean)
  {
    this.hasDeleteBtn = paramBoolean;
  }
  
  public void setHasFavEditButton(boolean paramBoolean)
  {
    this.hasFavEditButton = paramBoolean;
  }
  
  public void setHasPlusButton(boolean paramBoolean)
  {
    this.hasPlusButton = paramBoolean;
  }
  
  public void setHasPushButton(boolean paramBoolean)
  {
    this.hasPushButton = paramBoolean;
  }
  
  public void setHasSettingButton(boolean paramBoolean)
  {
    this.hasSettingButton = paramBoolean;
  }
  
  public void setHasUpdatePage(boolean paramBoolean)
  {
    this.hasUpdatePage = paramBoolean;
  }
  
  public void setList(List<EmoticonInfo> paramList)
  {
    this.list = paramList;
  }
  
  public void setPage(int paramInt)
  {
    this.page = paramInt;
  }
  
  public void setPushEmoticon(EmoticonInfo paramEmoticonInfo)
  {
    this.pushEmotion = paramEmoticonInfo;
  }
  
  public void setRowColumnNum(int paramInt1, int paramInt2)
  {
    this.rowNum = paramInt1;
    this.columnNum = paramInt2;
    this.pageTotalNum = (paramInt2 * paramInt1);
    this.mObserver.onStructChanged(paramInt1, paramInt2);
  }
  
  public void setSettingEmoticon(EmoticonInfo paramEmoticonInfo)
  {
    this.settingEmotion = paramEmoticonInfo;
  }
  
  public void setSpecEmoticon(EmoticonInfo paramEmoticonInfo)
  {
    this.specEmoticon = paramEmoticonInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.EmoticonAdapter
 * JD-Core Version:    0.7.0.1
 */