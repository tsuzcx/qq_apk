package com.tencent.mobileqq.kandian.biz.pts.loaders;

import com.tencent.qphone.base.util.QLog;

class PTSEngineLoader$3$1
  extends PTSOfflineUtil.PTSOfflineAsyncBack
{
  PTSEngineLoader$3$1(PTSEngineLoader.3 param3) {}
  
  public void loaded(String paramString, int paramInt)
  {
    super.loaded(paramString, paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[updatePTSEngine], asyncBack code = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", param = ");
    localStringBuilder.append(paramString);
    QLog.i("PTSEngineLoader", 1, localStringBuilder.toString());
    if ((paramInt == 0) && (paramString == null))
    {
      QLog.i("PTSEngineLoader", 1, "[updatePTSEngine], handleDownloadPTSEngine, download succeed.");
      PTSEngineLoader.c(this.a.this$0);
    }
  }
  
  public void progress(int paramInt)
  {
    super.progress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.PTSEngineLoader.3.1
 * JD-Core Version:    0.7.0.1
 */