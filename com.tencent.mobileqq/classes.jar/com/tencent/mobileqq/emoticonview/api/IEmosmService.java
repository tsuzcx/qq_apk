package com.tencent.mobileqq.emoticonview.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.emogroupstore.ISDKEmotionSettingManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.favroaming.IEmoticonFromGroupManager;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.view.OnMagicPlayEnd;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

@QAPI(process={"all"})
public abstract interface IEmosmService
  extends QRouteApi
{
  public static final String GAMECENTER_MANAGER = "GAMECENTER_MANAGER";
  public static final String MGR_MSG_FACADE = "MGR_MSG_FACADE";
  
  public abstract EmoticonFromGroupEntity addBaseInfoToEmoticonFromGroupEntity(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord);
  
  public abstract int addEmotionToFavorite(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, Emoticon paramEmoticon, Handler paramHandler);
  
  public abstract void addToCustomEmotionForPic(Context paramContext, String paramString, boolean paramBoolean);
  
  public abstract int checkNewFlagByPath(BaseQQAppInterface paramBaseQQAppInterface, String paramString);
  
  public abstract void clearFrameFilesGifCreator(Object paramObject);
  
  public abstract void clickSmallEmoticon(EmoticonSpan[] paramArrayOfEmoticonSpan, float paramFloat1, float paramFloat2, boolean paramBoolean1, int paramInt1, int paramInt2, AppInterface paramAppInterface, Parcelable paramParcelable, Activity paramActivity, boolean paramBoolean2);
  
  public abstract void copyBaseInfoFromMixedToPic(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2);
  
  public abstract ISDKEmotionSettingManager createSDKEmotionSettingManager(Activity paramActivity);
  
  public abstract Runnable createSendPhotoTask(Activity paramActivity, Intent paramIntent, Handler paramHandler);
  
  public abstract void downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler);
  
  public abstract void enterBigPicPreview(Context paramContext, MessageRecord paramMessageRecord, View paramView);
  
  public abstract void enterEmotionPreview(Context paramContext, EmoticonInfo paramEmoticonInfo, Rect paramRect);
  
  public abstract void enterNewPhotoList(Activity paramActivity);
  
  public abstract Card findFriendCardByUin(BaseQQAppInterface paramBaseQQAppInterface, String paramString);
  
  public abstract Object gestureDetectorDestory(Object paramObject, IPanelInteractionListener paramIPanelInteractionListener);
  
  public abstract Class getChatActivityClass();
  
  public abstract MqqHandler getChatActivityHander(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract int getCurrChatType(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract String getCurrChatUin(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract URLDrawable getDrawable(URL paramURL, ColorDrawable paramColorDrawable, Drawable paramDrawable);
  
  public abstract boolean getEmojiStickerSwitch();
  
  public abstract IEmoticonFromGroupManager getEmoticonFromGroupManager(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract String getErrorMsg(int paramInt);
  
  public abstract int getExternalPanelheight();
  
  public abstract Object getGIFCreator(String paramString);
  
  public abstract Class<?> getH5MagicPlayerActivityClass();
  
  public abstract Manager getIndividualRedPacketManager(AppInterface paramAppInterface);
  
  public abstract int getManagerID(String paramString);
  
  public abstract <T> ImageView getMarketFaceItemBuilderHolderImage(T paramT);
  
  public abstract Class<?> getMessengerServiceClass();
  
  public abstract List<MessageRecord> getMsgElemListForMessageForMixedMsg(MessageRecord paramMessageRecord);
  
  public abstract int getRandomMaxValue(Emoticon paramEmoticon, int paramInt);
  
  public abstract int getRichTextChatManagerEmoSearchConfig();
  
  public abstract String getSendCombineImg(Manager paramManager);
  
  public abstract String getTimeoutReason(FromServiceMsg paramFromServiceMsg);
  
  public abstract Object getVasEmojiManager(AppInterface paramAppInterface);
  
  public abstract Rect getViewRect(URLImageView paramURLImageView);
  
  public abstract void gotoEmoMallPage(EmoticonCallback paramEmoticonCallback);
  
  public abstract void handleComicStructMsg(BaseQQAppInterface paramBaseQQAppInterface, Object paramObject1, Object paramObject2);
  
  public abstract void handleResonpse(BaseQQAppInterface paramBaseQQAppInterface, Intent paramIntent, FromServiceMsg paramFromServiceMsg);
  
  public abstract ActionGlobalData hasAction(Emoticon paramEmoticon, int paramInt);
  
  public abstract boolean hasReported(MessageRecord paramMessageRecord, String paramString);
  
  public abstract Object initGestureDetector(Object paramObject, Context paramContext, IPanelInteractionListener paramIPanelInteractionListener);
  
  public abstract boolean isComeFromComic(String paramString);
  
  public abstract boolean isFlashPicMsg(MessageRecord paramMessageRecord);
  
  public abstract boolean isMessageForMixedMsg(MessageRecord paramMessageRecord);
  
  public abstract boolean isSplashChatContext(Context paramContext);
  
  public abstract boolean isSupportMagicface();
  
  public abstract void launchAECameraUnit(Context paramContext, Object paramObject);
  
  public abstract void launchFriendPicker(Activity paramActivity, List<EmoticonInfo> paramList);
  
  public abstract boolean magicfaceAutoPlay(Context paramContext, Emoticon paramEmoticon, OnMagicPlayEnd paramOnMagicPlayEnd);
  
  public abstract StringBuilder obtainStringBuilder();
  
  public abstract void openEmojiDetailPage(Activity paramActivity, String paramString1, int paramInt, String paramString2, boolean paramBoolean1, Intent paramIntent, boolean paramBoolean2);
  
  public abstract void openEmojiDetailPage(Context paramContext, String paramString1, int paramInt, String paramString2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void openEmojiHomePage(Activity paramActivity, String paramString, int paramInt);
  
  public abstract void openEmojiHomePage(Context paramContext, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString1, int paramInt, boolean paramBoolean1, String paramString2, boolean paramBoolean2);
  
  public abstract void openEmosmActivity(Context paramContext, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString1, int paramInt, boolean paramBoolean, String paramString2);
  
  public abstract void parseJson(AppInterface paramAppInterface);
  
  public abstract MessageRecord queryMsgItemByShmsgseq(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt, long paramLong);
  
  public abstract Object reparse(BaseQQAppInterface paramBaseQQAppInterface, String paramString);
  
  public abstract void reportActionMobileReportManager(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, long paramLong);
  
  public abstract void reportSendPicSource(String[] paramArrayOfString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract void saveAioMedia2Weiyun(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord, Object paramObject);
  
  public abstract void sendEmoPic(Context paramContext, Intent paramIntent);
  
  public abstract void sendEmosmMsg(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, Emoticon paramEmoticon);
  
  public abstract void sendEmosmMsg(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, Emoticon paramEmoticon, int paramInt);
  
  public abstract void sendEmoticon(AppInterface paramAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, Emoticon paramEmoticon, boolean paramBoolean);
  
  public abstract void sendInfoFromPanelHelper(BaseAIOContext paramBaseAIOContext, EmoticonInfo paramEmoticonInfo);
  
  public abstract void sendRecEmoPic(AppInterface paramAppInterface, QBaseActivity paramQBaseActivity, BaseAIOContext paramBaseAIOContext, Editable paramEditable, Intent paramIntent, ArrayList<String> paramArrayList);
  
  public abstract void sendStickerMsg(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, Emoticon paramEmoticon, StickerInfo paramStickerInfo);
  
  public abstract void sendStructMsgForImage(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, BaseSessionInfo paramBaseSessionInfo);
  
  public abstract void setEmojiStickerMode(boolean paramBoolean);
  
  public abstract void setEmotionSearchPanelVisible(BaseAIOContext paramBaseAIOContext, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, String paramString, int paramInt2);
  
  public abstract void setPicEmoticonTag(Context paramContext, Emoticon paramEmoticon);
  
  public abstract void showEmoticonPanel(BaseAIOContext paramBaseAIOContext, int paramInt);
  
  public abstract void startEmoticonGroupStoreFragment(Context paramContext);
  
  public abstract void startGIFCreator(Object paramObject, IEmosmService.GIFCreatorCallback paramGIFCreatorCallback);
  
  public abstract void toastFMDefault(int paramInt);
  
  public abstract <T extends IEmoticonMainPanel> T tryGetEmoticonMainPanel(IPanelInteractionListener paramIPanelInteractionListener);
  
  public abstract void updateMarketFaceItemBuilderEmoticonInfo(EmoticonInfo paramEmoticonInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IEmosmService
 * JD-Core Version:    0.7.0.1
 */