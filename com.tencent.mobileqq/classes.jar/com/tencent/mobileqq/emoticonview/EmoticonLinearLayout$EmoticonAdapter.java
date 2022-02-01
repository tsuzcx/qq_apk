package com.tencent.mobileqq.emoticonview;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;
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
    if ((this.list != null) && (paramInt < this.list.size())) {
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
    int j = 1;
    int i = 0;
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonLinearLayout", 2, "getRealIndex, position:" + paramInt + ",pageTotalNum:" + this.pageTotalNum + ",page:" + this.page);
    }
    if (this.hasDeleteBtn) {
      if ((paramInt + 1) % this.pageTotalNum == 0) {
        paramInt = -1;
      }
    }
    int m;
    label237:
    label242:
    do
    {
      do
      {
        return paramInt;
        return paramInt + this.page * (this.pageTotalNum - 1);
        if (this.hasFavEditButton)
        {
          if ((paramInt == 0) && (this.page == 0)) {
            return -5;
          }
          if (this.hasFunnyPicButton) {
            i = 1;
          }
          if ((paramInt == 1) && (this.page == 0) && (this.hasFunnyPicButton)) {
            return -6;
          }
          if (this.page == 0) {
            return paramInt - 1 - i;
          }
          return this.pageTotalNum - 1 + (this.page - 1) * this.pageTotalNum + paramInt - i;
        }
        m = this.list.size();
        if (this.hasPushButton)
        {
          i = 1;
          if (!this.hasPlusButton) {
            break label237;
          }
        }
        for (;;)
        {
          if (this.page + paramInt != 0) {
            break label270;
          }
          if (!this.hasPushButton) {
            break label242;
          }
          return -4;
          i = 0;
          break;
          j = 0;
        }
        paramInt = k;
      } while (this.list.size() != 0);
      paramInt = k;
    } while (!this.hasPlusButton);
    return -2;
    label270:
    if (this.page * this.pageTotalNum + paramInt == i + (m - 1) + j)
    {
      if (this.hasPlusButton) {
        return -2;
      }
      return this.list.size() - 1;
    }
    if (this.hasPushButton) {
      return this.page * this.pageTotalNum + paramInt - 1;
    }
    return paramInt + this.page * this.pageTotalNum;
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
    if (this.mObserver != null) {
      this.mObserver.onDataChanged();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.EmoticonAdapter
 * JD-Core Version:    0.7.0.1
 */