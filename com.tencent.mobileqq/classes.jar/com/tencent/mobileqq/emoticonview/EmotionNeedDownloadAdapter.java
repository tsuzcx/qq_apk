package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import area;
import areo;
import arer;
import ares;
import bgog;
import bgoj;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;

public abstract class EmotionNeedDownloadAdapter
  extends BaseEmotionAdapter
{
  public static final int DOWN_BTN_DOWNING = 1;
  public static final int DOWN_BTN_IDLE = 2;
  protected int downBtnStatus = 2;
  areo mEPDownloadListener = new EmotionNeedDownloadAdapter.2(this);
  arer mPayBackListener = new EmotionNeedDownloadAdapter.1(this);
  
  public EmotionNeedDownloadAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    area.a().a(this.mEPDownloadListener);
    ares.a().a(this.mPayBackListener);
  }
  
  public void destory()
  {
    super.destory();
    area.a().b(this.mEPDownloadListener);
    ares.a().b(this.mPayBackListener);
  }
  
  public bgoj getDownloader()
  {
    return ((bgog)((QQAppInterface)((BaseActivity)this.mContext).getAppRuntime()).getManager(47)).a(1);
  }
  
  public void packageDownloadEnd(EmoticonPackage paramEmoticonPackage, int paramInt) {}
  
  public void packageDownloadStart(EmoticonPackage paramEmoticonPackage) {}
  
  public void payBack(int paramInt) {}
  
  public void refreashProgress(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2) {}
  
  public void refreshCover(EmoticonPackage paramEmoticonPackage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionNeedDownloadAdapter
 * JD-Core Version:    0.7.0.1
 */