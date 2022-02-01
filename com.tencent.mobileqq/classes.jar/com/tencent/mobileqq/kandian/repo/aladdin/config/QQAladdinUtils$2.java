package com.tencent.mobileqq.kandian.repo.aladdin.config;

import com.tencent.aladdin.config.utils.SpUtils.IAladdinSpOperator;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;

final class QQAladdinUtils$2
  implements SpUtils.IAladdinSpOperator
{
  public <T> T getSpValue(String paramString, T paramT, boolean paramBoolean)
  {
    return RIJSPUtils.d(paramString, paramT, paramBoolean);
  }
  
  public <T> void updateSpValue(String paramString, T paramT, boolean paramBoolean)
  {
    RIJSPUtils.c(paramString, paramT, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.config.QQAladdinUtils.2
 * JD-Core Version:    0.7.0.1
 */