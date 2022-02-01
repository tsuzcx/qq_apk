package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.qphone.base.util.QLog;

public class DummyConfigHandler
  extends SimpleConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onReceiveConfig] id=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", version=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", content=");
    localStringBuilder.append(paramString);
    QLog.d("DummyConfigHandler", 2, localStringBuilder.toString());
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onWipeConfig] id=");
    localStringBuilder.append(paramInt);
    QLog.d("DummyConfigHandler", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.DummyConfigHandler
 * JD-Core Version:    0.7.0.1
 */