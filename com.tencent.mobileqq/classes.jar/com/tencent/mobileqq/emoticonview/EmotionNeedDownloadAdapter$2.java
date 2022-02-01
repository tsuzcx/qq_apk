package com.tencent.mobileqq.emoticonview;

import areo;
import com.tencent.mobileqq.data.EmoticonPackage;

class EmotionNeedDownloadAdapter$2
  extends areo
{
  EmotionNeedDownloadAdapter$2(EmotionNeedDownloadAdapter paramEmotionNeedDownloadAdapter) {}
  
  public void onCoverComplete(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    this.this$0.refreshCover(paramEmoticonPackage);
  }
  
  public void onPackageEnd(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    this.this$0.packageDownloadEnd(paramEmoticonPackage, paramInt);
  }
  
  public void onPackageProgress(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    this.this$0.refreashProgress(paramEmoticonPackage, paramInt1, paramInt2);
  }
  
  public void onPackageStart(EmoticonPackage paramEmoticonPackage)
  {
    this.this$0.packageDownloadStart(paramEmoticonPackage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionNeedDownloadAdapter.2
 * JD-Core Version:    0.7.0.1
 */