package com.tencent.mobileqq.qwallet.jump.impl;

import com.tencent.mobileqq.app.parser.JumpParserBase;
import com.tencent.mobileqq.qwallet.jump.IQWalletJumpParserFactory;

public class QWalletJumpParserFactoryImpl
  implements IQWalletJumpParserFactory
{
  public Class<? extends JumpParserBase> getJumpParserClass(String paramString)
  {
    if ("mqqapi://wxminiapp/launch".equals(paramString)) {
      return QwalletToLaunchWXMiniAppParser.class;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.jump.impl.QWalletJumpParserFactoryImpl
 * JD-Core Version:    0.7.0.1
 */