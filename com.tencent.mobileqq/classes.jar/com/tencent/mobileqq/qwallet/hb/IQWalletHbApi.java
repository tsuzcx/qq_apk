package com.tencent.mobileqq.qwallet.hb;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.qwallet.temp.IBaseChatPieProxy;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory;
import com.tencent.mobileqq.qwallet.hb.send.PanelData;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IQWalletHbApi
  extends QRouteApi
{
  public static final int HONGBAO_REPORT_TYPE_AIOPANELICON = 1;
  public static final int HONGBAO_REPORT_TYPE_PANNEL = 3;
  public static final int HONGBAO_REPORT_TYPE_PLUSPANEL = 0;
  public static final int HONGBAO_REPORT_TYPE_SENDBACK = 2;
  
  public abstract void dealHongBaoPanelMultiPlex(int paramInt, View paramView);
  
  public abstract boolean doJumpAction(Context paramContext, String paramString);
  
  public abstract boolean doStartBrowser(Context paramContext, String paramString);
  
  public abstract ICustomizeStrategyFactory getCustomizeStrategyFactory();
  
  public abstract int getPanelFrom();
  
  public abstract int getSpecifyHbAniMaxSize(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract IQWalletHbApi.ITroopUnclaimedHbList getTroopUnclaimedHbList(BaseQQAppInterface paramBaseQQAppInterface, IBaseChatPieProxy paramIBaseChatPieProxy);
  
  public abstract boolean isCanShowNewCloseBtn(Context paramContext);
  
  public abstract boolean isRedPacketMsg(MessageRecord paramMessageRecord);
  
  public abstract boolean isValideToDoAction(long paramLong1, long paramLong2);
  
  public abstract void sendRedPkg(BaseQQAppInterface paramBaseQQAppInterface, Activity paramActivity, BaseSessionInfo paramBaseSessionInfo, PanelData paramPanelData, List<PanelData> paramList, int paramInt);
  
  public abstract void setPanelFrom(int paramInt);
  
  public abstract boolean specifyRedPacketIsValidAnim(Object paramObject, BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract void tryPreDownEmojiRes(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord);
  
  public abstract void tryPreDownLoadModel(MessageRecord paramMessageRecord);
  
  public abstract boolean tryScheduleSpecifyAnim(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord);
  
  public abstract void voiceRecognizerDestroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.IQWalletHbApi
 * JD-Core Version:    0.7.0.1
 */