package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import com.tencent.mobileqq.core.QQEmotionPanelManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticon.EmotionPanelPayBackListener;
import com.tencent.mobileqq.emoticon.IEmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
import com.tencent.mobileqq.qroute.QRoute;

public abstract class EmotionNeedDownloadAdapter
  extends AbsBigEmotionUpdateAdapter
{
  public static final int DOWN_BTN_DOWNING = 1;
  public static final int DOWN_BTN_IDLE = 2;
  protected int downBtnStatus = 2;
  EmoticonPackageDownloadListener mEPDownloadListener = new EmotionNeedDownloadAdapter.2(this);
  EmotionPanelPayBackListener mPayBackListener = new EmotionNeedDownloadAdapter.1(this);
  
  public EmotionNeedDownloadAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    if (QQEmotionPanelManager.a().a() != null) {
      QQEmotionPanelManager.a().a().addEmoticonPackageDownloadListener(this.mEPDownloadListener);
    }
    ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).addEmotionPanelPayBackListener(this.mPayBackListener);
  }
  
  public void destory()
  {
    super.destory();
    if (QQEmotionPanelManager.a().a() != null) {
      QQEmotionPanelManager.a().a().removeEmoticonPackageDownloadListener(this.mEPDownloadListener);
    }
    ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).removeEmotionPanelPayBackListener(this.mPayBackListener);
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