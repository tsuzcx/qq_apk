package com.tencent.mobileqq.qwallet.jump;

import com.tencent.mobileqq.app.parser.JumpParserBase;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQWalletJumpParserFactory
  extends QRouteApi
{
  public abstract Class<? extends JumpParserBase> getJumpParserClass(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.jump.IQWalletJumpParserFactory
 * JD-Core Version:    0.7.0.1
 */