package com.tencent.mobileqq.qwallet.hb.aio;

import android.content.Context;
import android.widget.RelativeLayout;
import com.qwallet.temp.IBaseChatPieProxy;
import com.qwallet.temp.IQWalletMsgHolder;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IQQWalletHbItemApi
  extends QRouteApi
{
  public static final String AIO_TYPE_DEFAULT = "1";
  public static final String AIO_TYPE_GUILD = "2";
  public static final String TAG = "QQWalletHbItemApi";
  
  public abstract RelativeLayout createRedPacketBubbleView(IQWalletMsgHolder paramIQWalletMsgHolder, Context paramContext, int paramInt);
  
  public abstract boolean setHbOnClickListener(BaseQQAppInterface paramBaseQQAppInterface, IBaseChatPieProxy paramIBaseChatPieProxy, RelativeLayout paramRelativeLayout, BaseSessionInfo paramBaseSessionInfo, int paramInt1, int paramInt2, String paramString);
  
  public abstract void setOldHbOnClickListener(RelativeLayout paramRelativeLayout, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.IQQWalletHbItemApi
 * JD-Core Version:    0.7.0.1
 */