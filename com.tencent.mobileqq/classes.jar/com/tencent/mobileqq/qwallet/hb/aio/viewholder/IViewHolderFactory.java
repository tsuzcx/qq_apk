package com.tencent.mobileqq.qwallet.hb.aio.viewholder;

import com.qwallet.temp.IQWalletMsgHolder;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;

@QAPI(process={"all"})
public abstract interface IViewHolderFactory
  extends QRouteApi
{
  public static final int REDPKG_TYPE_BIRTHDAY = 16;
  public static final int REDPKG_TYPE_DEFAULT = 0;
  public static final int REDPKG_TYPE_DRAW = 11;
  public static final int REDPKG_TYPE_EMOJI = 9;
  public static final int REDPKG_TYPE_ENTERPRISE = 7;
  public static final int REDPKG_TYPE_GOLD = 12;
  public static final int REDPKG_TYPE_KSONG = 8;
  public static final int REDPKG_TYPE_KUAKUA = 14;
  public static final int REDPKG_TYPE_LOCK = 1;
  public static final int REDPKG_TYPE_LOOK = 5;
  public static final int REDPKG_TYPE_SHENGPIZI = 15;
  public static final int REDPKG_TYPE_SOLITAIRE = 10;
  public static final int REDPKG_TYPE_SPECIFY = 6;
  public static final int REDPKG_TYPE_THEME = 3;
  public static final int REDPKG_TYPE_VIP = 4;
  public static final int REDPKG_TYPE_VOICE = 2;
  public static final String TAG = "ViewHolderFactoryImpl";
  
  public abstract IFBaseViewHolder createViewHolder(BaseQQAppInterface paramBaseQQAppInterface, BaseSessionInfo paramBaseSessionInfo, IQWalletMsgHolder paramIQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, ICustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener);
  
  public abstract int getRedPkgType(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.viewholder.IViewHolderFactory
 * JD-Core Version:    0.7.0.1
 */