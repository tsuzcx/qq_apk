package com.tencent.mobileqq.qwallet;

import android.content.Context;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import tencent.im.msg.im_msg_body.GeneralFlags;

@QAPI(process={""})
public abstract interface IQWalletGdtAdApi
  extends QRouteApi
{
  public static final String TAG = "QWalletGdtAdApi";
  public static final String WALLET_PUB_AD_TAG = "isShowQWalletPubAd";
  
  public abstract void checkReportTailAdShow();
  
  public abstract void doReqAdsStatistics(int paramInt);
  
  public abstract GdtAppReceiver getAppReceiver(Context paramContext);
  
  public abstract GdtAd getGdtAd();
  
  public abstract void handlePubRefreshList(List<ChatMessage> paramList);
  
  public abstract void handlePubTailMsg(im_msg_body.GeneralFlags paramGeneralFlags, MessageRecord paramMessageRecord);
  
  public abstract void handleWhenPubEnter(QBaseActivity paramQBaseActivity, Object paramObject);
  
  public abstract void handleWhenPubPause();
  
  public abstract void handleWhenPubQuit(Context paramContext);
  
  public abstract void handleWhenPubResume();
  
  public abstract void reportEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void reportUrlByHttpGet(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.IQWalletGdtAdApi
 * JD-Core Version:    0.7.0.1
 */