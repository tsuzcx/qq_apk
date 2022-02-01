package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import asig;
import asiu;
import asix;
import asiy;
import bhyq;
import bhyt;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.EmoticonPackage;

public abstract class EmotionNeedDownloadAdapter
  extends BaseEmotionAdapter
{
  public static final int DOWN_BTN_DOWNING = 1;
  public static final int DOWN_BTN_IDLE = 2;
  protected int downBtnStatus = 2;
  asiu mEPDownloadListener = new EmotionNeedDownloadAdapter.2(this);
  asix mPayBackListener = new EmotionNeedDownloadAdapter.1(this);
  
  public EmotionNeedDownloadAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    asig.a().a(this.mEPDownloadListener);
    asiy.a().a(this.mPayBackListener);
  }
  
  public void destory()
  {
    super.destory();
    asig.a().b(this.mEPDownloadListener);
    asiy.a().b(this.mPayBackListener);
  }
  
  public bhyt getDownloader()
  {
    return ((bhyq)((QQAppInterface)((BaseActivity)this.mContext).getAppRuntime()).getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
  }
  
  public void packageDownloadEnd(EmoticonPackage paramEmoticonPackage, int paramInt) {}
  
  public void packageDownloadStart(EmoticonPackage paramEmoticonPackage) {}
  
  public void payBack(int paramInt) {}
  
  public void refreashProgress(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2) {}
  
  public void refreshCover(EmoticonPackage paramEmoticonPackage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionNeedDownloadAdapter
 * JD-Core Version:    0.7.0.1
 */