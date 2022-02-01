package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import com.tencent.commonsdk.cache.QQLruCache;

class CustomizeStrategyFactory$1
  extends QQLruCache<String, InterfaceRedPkgElem>
{
  CustomizeStrategyFactory$1(CustomizeStrategyFactory paramCustomizeStrategyFactory, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  protected void a(boolean paramBoolean, String paramString, InterfaceRedPkgElem paramInterfaceRedPkgElem1, InterfaceRedPkgElem paramInterfaceRedPkgElem2)
  {
    super.entryRemoved(paramBoolean, paramString, paramInterfaceRedPkgElem1, paramInterfaceRedPkgElem2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory.1
 * JD-Core Version:    0.7.0.1
 */