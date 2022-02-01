package com.tencent.mobileqq.kandian.biz.pts.loaders;

import com.tencent.qphone.base.util.QLog;

class PTSAppLoader$2$1
  extends PTSOfflineUtil.PTSOfflineAsyncBack
{
  PTSAppLoader$2$1(PTSAppLoader.2 param2) {}
  
  public void loaded(String paramString, int paramInt)
  {
    super.loaded(paramString, paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[updatePTSApp], asyncBack code = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", param = ");
    localStringBuilder.append(paramString);
    QLog.i("PTSAppLoader", 1, localStringBuilder.toString());
    if ((paramInt == 0) && (paramString == null))
    {
      PTSAppLoader.b(this.a.this$0, this.a.a);
      paramString = new StringBuilder();
      paramString.append("[updatePTSApp], download succeed, bid = ");
      paramString.append(this.a.a);
      QLog.i("PTSAppLoader", 1, paramString.toString());
    }
  }
  
  public void progress(int paramInt)
  {
    super.progress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.PTSAppLoader.2.1
 * JD-Core Version:    0.7.0.1
 */