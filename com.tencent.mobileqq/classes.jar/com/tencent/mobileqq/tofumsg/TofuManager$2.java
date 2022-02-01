package com.tencent.mobileqq.tofumsg;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.lyric.util.Singleton;

class TofuManager$2
  extends Singleton<TofuDataHandlerFactory, QQAppInterface>
{
  TofuManager$2(TofuManager paramTofuManager) {}
  
  protected TofuDataHandlerFactory a(QQAppInterface paramQQAppInterface)
  {
    return new TofuDataHandlerFactory(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.TofuManager.2
 * JD-Core Version:    0.7.0.1
 */