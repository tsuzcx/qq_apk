package com.tencent.mobileqq.emoticon.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emoticon.EPRecommendTask;
import com.tencent.mobileqq.emoticon.IEPRecommendTask;
import com.tencent.mobileqq.emoticon.api.IEPRecommendTaskService;

public class EPRecommendTaskServiceImpl
  implements IEPRecommendTaskService
{
  public IEPRecommendTask createEPRecommendTask(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return new EPRecommendTask(paramBaseQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.impl.EPRecommendTaskServiceImpl
 * JD-Core Version:    0.7.0.1
 */