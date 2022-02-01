package com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl;

import com.qwallet.temp.IQWalletMsgHolder;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.viewholder.IFBaseViewHolder;
import com.tencent.mobileqq.qwallet.hb.aio.viewholder.IViewHolderFactory;
import com.tencent.qphone.base.util.QLog;

public class ViewHolderFactoryImpl
  implements IViewHolderFactory
{
  public IFBaseViewHolder createViewHolder(BaseQQAppInterface paramBaseQQAppInterface, IQWalletMsgHolder paramIQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, ICustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    switch (paramInt)
    {
    case 13: 
    default: 
      return new BaseViewHolder(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 15: 
      return new ShengpiziRedPkgViewHolder(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 14: 
      return new KuaKuaRedPkgViewHolder(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 12: 
      return new GoldRedPkgViewHolder(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 11: 
      return new DrawRedPkgViewHolder(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 10: 
      return new SolitaireRedPkgViewHolder(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 9: 
      return new EmojiRedPkgViewHolder(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 8: 
      return new KSongRedPkgViewHolder(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 7: 
      return new EpRedPkgViewHolder(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 6: 
      return new SpecifyRedPkgViewHolder(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 5: 
      return new LookRedPkgViewHolder(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 4: 
      return new VipRedPkgViewHolder(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 3: 
      return new ThemeRedPkgViewHolder(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    case 2: 
      return new VoiceRedPkgViewHolder(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    }
    return new LockRedPkgViewHolder(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
  }
  
  public int getRedPkgType(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CFT-debug messageType = ");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    int i = 2;
    QLog.i("ViewHolderFactoryImpl", 2, (String)localObject);
    if (paramInt == 6) {
      return 1;
    }
    if (paramInt == 14) {
      return 5;
    }
    if (paramInt != 13)
    {
      if (paramInt == 15) {
        return 2;
      }
      if ((paramInt != 4) && (paramInt != 5))
      {
        if (paramInt == 2001) {
          return 4;
        }
        if ((paramInt != 7) && (paramInt != 8) && (paramInt != 11) && (paramInt != 12))
        {
          if (paramInt == 2002) {
            return 7;
          }
          if (paramInt == 18) {
            return 8;
          }
          if (paramInt == 19) {
            return 9;
          }
          if ((paramInt != 21) && (paramInt != 24) && (paramInt != 25) && (paramInt != 27))
          {
            if ((paramInt != 22) && (paramInt != 26))
            {
              if (paramInt == 23) {
                return 12;
              }
              if (paramInt == 28) {
                return 14;
              }
              if (paramInt == 29) {
                return 15;
              }
              return 0;
            }
            return 11;
          }
          return 10;
        }
        return 6;
      }
      i = 3;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.ViewHolderFactoryImpl
 * JD-Core Version:    0.7.0.1
 */