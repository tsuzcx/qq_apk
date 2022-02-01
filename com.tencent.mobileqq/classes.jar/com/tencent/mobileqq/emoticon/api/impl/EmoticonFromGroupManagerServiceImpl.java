package com.tencent.mobileqq.emoticon.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import com.tencent.mobileqq.emosm.favroaming.IEmoticonFromGroupManager;
import com.tencent.mobileqq.emoticon.api.IEmoticonFromGroupManagerService;

public class EmoticonFromGroupManagerServiceImpl
  implements IEmoticonFromGroupManagerService
{
  public IEmoticonFromGroupManager createEmoticonFromGroupManager(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return new EmoticonFromGroupManager(paramBaseQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.impl.EmoticonFromGroupManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */