package com.tencent.mobileqq.qwallet.hb.aio.elem;

import com.tencent.common.app.business.BaseQQAppInterface;

public abstract interface ICustomizeStrategyFactory
{
  public abstract RedPacketInfo a(BaseQQAppInterface paramBaseQQAppInterface, RedPacketInfo paramRedPacketInfo, ICustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener);
  
  public abstract void a(RedPacketInfo paramRedPacketInfo);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a();
  
  public abstract void b();
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory
 * JD-Core Version:    0.7.0.1
 */