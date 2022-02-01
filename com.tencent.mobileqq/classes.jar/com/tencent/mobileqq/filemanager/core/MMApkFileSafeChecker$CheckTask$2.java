package com.tencent.mobileqq.filemanager.core;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.turingfd.sdk.xq.IteApkInfoResp;
import com.tencent.turingfd.sdk.xq.IteApkInfoRespCallback;
import java.util.Map;

class MMApkFileSafeChecker$CheckTask$2
  implements IteApkInfoRespCallback
{
  MMApkFileSafeChecker$CheckTask$2(MMApkFileSafeChecker.CheckTask paramCheckTask) {}
  
  public void onResult(long paramLong, Map<Integer, IteApkInfoResp> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = (IteApkInfoResp)paramMap.get(Integer.valueOf(this.a.k));
      if (paramMap != null)
      {
        i = (int)paramMap.getErrorCode();
        j = paramMap.getSafeLevel();
        str = paramMap.getRiskTips();
        paramMap = paramMap.getHandleUrl();
        break label76;
      }
    }
    String str = "";
    paramMap = str;
    int i = 2;
    int j = 0;
    label76:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MMApkCheck] <");
    localStringBuilder.append(this.a.k);
    localStringBuilder.append("> on checkresult. errCode:");
    localStringBuilder.append(i);
    localStringBuilder.append(" safeLevel:");
    localStringBuilder.append(j);
    localStringBuilder.append(" tipString:");
    localStringBuilder.append(str);
    localStringBuilder.append(" jumpDetailUrl:");
    localStringBuilder.append(paramMap);
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, localStringBuilder.toString());
    new Handler(Looper.getMainLooper()).post(new MMApkFileSafeChecker.CheckTask.2.1(this, i, j, str, paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.CheckTask.2
 * JD-Core Version:    0.7.0.1
 */