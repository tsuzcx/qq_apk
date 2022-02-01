package com.tencent.mobileqq.emoticonview.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.Process;
import android.text.Editable;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ReplyHelper;
import com.tencent.mobileqq.activity.aio.helper.SpecWordEmotionThinkHelper;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.TroopPobingItemBuilder;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.mobileqq.activity.emogroupstore.ISDKEmotionSettingManager;
import com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationEmotion;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationEmotion;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.favroaming.IEmoticonFromGroupManager;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.emoticonview.AIOEmoticonPanelHelper;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.StickerGestureDetector;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.api.IEmosmService.GIFCreatorCallback;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter;
import com.tencent.mobileqq.forward.EmotionBatchForwardOption;
import com.tencent.mobileqq.hotpic.HotPicDownLoader;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.magicface.view.OnMagicPlayEnd;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.multimsg.save.FileSaveErrorInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.text.style.ISmallEmojiSpan;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vas.URLInterceptManager;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.weiyun.WeiyunCallback;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import cooperation.peak.PeakUtils;
import cooperation.qzone.mobilereport.MobileReportManager;
import dov.com.qq.im.ae.current.GIFCreator;
import dov.com.qq.im.ae.current.SessionWrap;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class EmosmServiceImpl
  implements IEmosmService
{
  private static final String TAG = "EmosmServiceImpl";
  
  public EmoticonFromGroupEntity addBaseInfoToEmoticonFromGroupEntity(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    return ((VasExtensionManager)paramBaseQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).d.a(paramMessageRecord);
  }
  
  public int addEmotionToFavorite(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, Emoticon paramEmoticon, Handler paramHandler)
  {
    return MarketFaceItemBuilder.a(paramContext, (QQAppInterface)paramBaseQQAppInterface, paramEmoticon, paramHandler);
  }
  
  public void addToCustomEmotionForPic(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject2 = HotPicDownLoader.a(paramString);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((File)localObject2).exists()) {}
      }
      else
      {
        QLog.e("EmosmServiceImpl", 4, " add custom fail file no exist");
      }
    }
    else
    {
      localObject2 = AbsDownloader.getFile(paramString);
      if (localObject2 == null) {
        break label183;
      }
      localObject1 = localObject2;
      if (!((File)localObject2).exists()) {
        break label183;
      }
    }
    Object localObject2 = (MessageForPic)MessageRecordFactory.a(-2000);
    ((MessageForPic)localObject2).path = ((File)localObject1).getAbsolutePath();
    ((MessageForPic)localObject2).md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(((MessageForPic)localObject2).path));
    ((MessageForPic)localObject2).thumbMsgUrl = paramString;
    ((MessageForPic)localObject2).bigMsgUrl = paramString;
    ((MessageForPic)localObject2).imageType = 2000;
    paramString = URLDrawableHelper.getDrawable(paramString);
    paramString.setTag(localObject2);
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject1 instanceof QQAppInterface))
    {
      QLog.e("EmosmServiceImpl", 2, "addToCustomEmotionForPic cannot get QQAppInterface");
      return;
    }
    AIOGalleryUtils.a(paramContext, (QQAppInterface)localObject1, paramString, "", paramContext.getResources().getDimensionPixelSize(2131299920), null, ((MessageForPic)localObject2).picExtraData);
    return;
    label183:
    QLog.e("EmosmServiceImpl", 4, " add custom fail file no exist");
  }
  
  public int checkNewFlagByPath(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    return ((GameCenterManagerImp)paramBaseQQAppInterface.getManager(QQManagerFactory.GAMECENTER_MANAGER)).a(paramString);
  }
  
  public void clearFrameFilesGifCreator(Object paramObject)
  {
    ((GIFCreator)paramObject).a();
  }
  
  public void clickSmallEmoticon(EmoticonSpan[] paramArrayOfEmoticonSpan, float paramFloat1, float paramFloat2, boolean paramBoolean1, int paramInt1, int paramInt2, AppInterface paramAppInterface, Parcelable paramParcelable, Activity paramActivity, boolean paramBoolean2)
  {
    if ((paramArrayOfEmoticonSpan != null) && (paramAppInterface != null) && (paramParcelable != null))
    {
      if (paramActivity == null) {
        return;
      }
      paramParcelable = (SessionInfo)paramParcelable;
      Object localObject1 = new TreeSet();
      int i = 0;
      int j = paramInt1;
      paramInt1 = i;
      Object localObject2;
      while (paramInt1 < paramArrayOfEmoticonSpan.length)
      {
        localObject2 = paramArrayOfEmoticonSpan[paramInt1];
        boolean bool = paramBoolean1;
        int k = j;
        i = paramInt2;
        if ((localObject2 instanceof ISmallEmojiSpan))
        {
          localObject2 = (ISmallEmojiSpan)localObject2;
          float f1 = ((ISmallEmojiSpan)localObject2).getLeft();
          float f2 = ((ISmallEmojiSpan)localObject2).getTop();
          float f3 = ((ISmallEmojiSpan)localObject2).getRight();
          float f4 = ((ISmallEmojiSpan)localObject2).getBottom();
          int m = ((ISmallEmojiSpan)localObject2).getEpId();
          int n = ((ISmallEmojiSpan)localObject2).getEId();
          ((TreeSet)localObject1).add(Integer.valueOf(m));
          bool = paramBoolean1;
          k = j;
          i = paramInt2;
          if (!paramBoolean2)
          {
            bool = paramBoolean1;
            k = j;
            i = paramInt2;
            if (paramFloat1 >= f1)
            {
              bool = paramBoolean1;
              k = j;
              i = paramInt2;
              if (paramFloat1 <= f3)
              {
                bool = paramBoolean1;
                k = j;
                i = paramInt2;
                if (paramFloat2 >= f2)
                {
                  bool = paramBoolean1;
                  k = j;
                  i = paramInt2;
                  if (paramFloat2 <= f4)
                  {
                    bool = paramBoolean1;
                    k = j;
                    i = paramInt2;
                    if (!paramBoolean1)
                    {
                      i = n;
                      k = m;
                      bool = true;
                    }
                  }
                }
              }
            }
          }
        }
        paramInt1 += 1;
        paramBoolean1 = bool;
        j = k;
        paramInt2 = i;
      }
      if (paramBoolean1)
      {
        if (((TreeSet)localObject1).size() == 1)
        {
          ((IEmoticonManagerService)paramAppInterface.getRuntimeService(IEmoticonManagerService.class, "")).asyncFindTabEmoticonPackageById(String.valueOf(j), 0, new EmosmServiceImpl.1(this, paramParcelable, paramAppInterface, j, paramActivity));
          return;
        }
        paramParcelable = ((TreeSet)localObject1).iterator();
        for (paramArrayOfEmoticonSpan = ""; paramParcelable.hasNext(); paramArrayOfEmoticonSpan = ((StringBuilder)localObject2).toString())
        {
          localObject1 = (Integer)paramParcelable.next();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramArrayOfEmoticonSpan);
          ((StringBuilder)localObject2).append(localObject1);
          ((StringBuilder)localObject2).append(",");
        }
        paramParcelable = paramArrayOfEmoticonSpan;
        if (!paramArrayOfEmoticonSpan.equals("")) {
          paramParcelable = paramArrayOfEmoticonSpan.substring(0, paramArrayOfEmoticonSpan.length() - 1);
        }
        EmojiHomeUiPlugin.openSmallEmojiListPage(paramActivity, paramAppInterface.getAccount(), 11, paramParcelable);
        ReportController.b(paramAppInterface, "CliOper", "", "", "ep_mall", "0X8007000", 0, 0, String.valueOf(j), String.valueOf(paramInt2), "", "");
      }
    }
  }
  
  public void copyBaseInfoFromMixedToPic(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)paramMessageRecord1, (MessageForMixedMsg)paramMessageRecord2);
  }
  
  public ISDKEmotionSettingManager createSDKEmotionSettingManager(Activity paramActivity)
  {
    return new SDKEmotionSettingManager(paramActivity);
  }
  
  public Runnable createSendPhotoTask(Activity paramActivity, Intent paramIntent, Handler paramHandler)
  {
    return new SendPhotoTask((BaseActivity)paramActivity, paramIntent, paramHandler);
  }
  
  public void downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    new HttpDownloader().downloadImage(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
  }
  
  public void enterBigPicPreview(Context paramContext, MessageRecord paramMessageRecord, View paramView)
  {
    if (!(paramMessageRecord instanceof MessageForPic)) {
      return;
    }
    paramMessageRecord = (MessageForPic)paramMessageRecord;
    paramView = AnimationUtils.a(paramView);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramView);
    localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
    localBundle.putBoolean("IS_APP_SHARE_PIC", true);
    localBundle.putBoolean("group.emo.big.preview", true);
    localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
    PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramMessageRecord.selfuin, null, -1, paramMessageRecord), AIOGalleryUtils.a(paramMessageRecord), -1, -1);
  }
  
  public void enterEmotionPreview(Context paramContext, EmoticonInfo paramEmoticonInfo, Rect paramRect)
  {
    AIOEmotionFragment.a(paramContext, paramEmoticonInfo, paramRect);
  }
  
  public void enterNewPhotoList(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 2);
    localIntent.putExtra("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationEmotion.a);
    localIntent.putExtra("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationEmotion.a);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localIntent.putExtra("filter_photolist_troopalbum_toolbar", false);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("PhotoConst.IS_FROM_EMOTION_FAVORITE", true);
    localIntent.putExtra("peakconstant.request_code", 10015);
    paramActivity.startActivityForResult(localIntent, 10015);
  }
  
  public Card findFriendCardByUin(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    paramBaseQQAppInterface = (FriendsManager)paramBaseQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramBaseQQAppInterface != null) {
      return paramBaseQQAppInterface.f(paramString);
    }
    return null;
  }
  
  public Object gestureDetectorDestory(Object paramObject, IPanelInteractionListener paramIPanelInteractionListener)
  {
    Object localObject = (StickerGestureDetector)paramObject;
    paramObject = localObject;
    if (localObject != null)
    {
      paramObject = localObject;
      if (paramIPanelInteractionListener != null)
      {
        paramObject = localObject;
        if (paramIPanelInteractionListener.getAIORootView() != null)
        {
          paramObject = (TopGestureLayout)paramIPanelInteractionListener.getAIORootView();
          localObject = paramObject.getGestureDetector();
          if ((localObject instanceof StickerGestureDetector))
          {
            ThreadManagerV2.getUIHandlerV2().post(new EmosmServiceImpl.2(this, paramObject, (GestureDetector)localObject));
            EmojiStickerManager.a = false;
            paramIPanelInteractionListener.stickerEditMode(false);
          }
          paramObject.restoreGestureDetector();
          paramObject = null;
        }
      }
    }
    return paramObject;
  }
  
  public Class getChatActivityClass()
  {
    return ChatActivity.class;
  }
  
  public MqqHandler getChatActivityHander(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return paramBaseQQAppInterface.getHandler(ChatActivity.class);
  }
  
  public int getCurrChatType(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return ((QQMessageFacade)paramBaseQQAppInterface.getManager(QQManagerFactory.MGR_MSG_FACADE)).m();
  }
  
  public String getCurrChatUin(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return ((QQMessageFacade)paramBaseQQAppInterface.getManager(QQManagerFactory.MGR_MSG_FACADE)).l();
  }
  
  public URLDrawable getDrawable(URL paramURL, ColorDrawable paramColorDrawable, Drawable paramDrawable)
  {
    return URLDrawableHelper.getDrawable(paramURL, paramColorDrawable, paramDrawable);
  }
  
  public boolean getEmojiStickerSwitch()
  {
    return EmojiStickerManager.n;
  }
  
  public IEmoticonFromGroupManager getEmoticonFromGroupManager(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return ((VasExtensionManager)paramBaseQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).d;
  }
  
  public String getErrorMsg(int paramInt)
  {
    return FileSaveErrorInfo.a(paramInt);
  }
  
  public int getExternalPanelheight()
  {
    return XPanelContainer.a;
  }
  
  public Object getGIFCreator(String paramString)
  {
    return new GIFCreator(paramString);
  }
  
  public Class<?> getH5MagicPlayerActivityClass()
  {
    return H5MagicPlayerActivity.class;
  }
  
  public Manager getIndividualRedPacketManager(AppInterface paramAppInterface)
  {
    return paramAppInterface.getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER);
  }
  
  public int getManagerID(String paramString)
  {
    if ("GAMECENTER_MANAGER".equals(paramString)) {
      return QQManagerFactory.GAMECENTER_MANAGER;
    }
    if ("MGR_MSG_FACADE".equals(paramString)) {
      return QQManagerFactory.MGR_MSG_FACADE;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("name: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" is ID -1.");
    QLog.e("EmosmServiceImpl", 4, localStringBuilder.toString());
    return -1;
  }
  
  public <T> ImageView getMarketFaceItemBuilderHolderImage(T paramT)
  {
    return ((MarketFaceItemBuilder.Holder)paramT).s;
  }
  
  public Class<?> getMessengerServiceClass()
  {
    return MessengerService.class;
  }
  
  public List<MessageRecord> getMsgElemListForMessageForMixedMsg(MessageRecord paramMessageRecord)
  {
    return ((MessageForMixedMsg)paramMessageRecord).msgElemList;
  }
  
  public int getRandomMaxValue(Emoticon paramEmoticon, int paramInt)
  {
    return MagicfaceActionManager.b(paramEmoticon, paramInt);
  }
  
  public int getRichTextChatManagerEmoSearchConfig()
  {
    return 5;
  }
  
  public String getSendCombineImg(Manager paramManager)
  {
    return ((IndividualRedPacketManager)paramManager).d();
  }
  
  public String getTimeoutReason(FromServiceMsg paramFromServiceMsg)
  {
    return MessageHandler.a(paramFromServiceMsg);
  }
  
  public Object getVasEmojiManager(AppInterface paramAppInterface)
  {
    return ((VasExtensionManager)paramAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).b;
  }
  
  public Rect getViewRect(URLImageView paramURLImageView)
  {
    if (paramURLImageView == null) {
      return null;
    }
    return AnimationUtils.a(paramURLImageView);
  }
  
  public void gotoEmoMallPage(EmoticonCallback paramEmoticonCallback)
  {
    if ((paramEmoticonCallback instanceof AIOEmoticonPanelHelper)) {
      ((AIOEmoticonPanelHelper)paramEmoticonCallback).gotoEmoMallPage(9);
    }
  }
  
  public void handleComicStructMsg(BaseQQAppInterface paramBaseQQAppInterface, Object paramObject1, Object paramObject2)
  {
    AIOGalleryUtils.b((QQAppInterface)paramBaseQQAppInterface, (StructMsgForImageShare)paramObject1, (CustomEmotionData)paramObject2);
  }
  
  public void handleResonpse(BaseQQAppInterface paramBaseQQAppInterface, Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    HotPicManager.a((QQAppInterface)paramBaseQQAppInterface).a(paramIntent, paramFromServiceMsg);
  }
  
  public ActionGlobalData hasAction(Emoticon paramEmoticon, int paramInt)
  {
    return MagicfaceActionManager.a(paramEmoticon, paramInt);
  }
  
  public boolean hasReported(MessageRecord paramMessageRecord, String paramString)
  {
    if (!AIOSingleReporter.a().a(paramMessageRecord, paramString))
    {
      AIOSingleReporter.a().b(paramMessageRecord, paramString);
      return false;
    }
    return true;
  }
  
  public Object initGestureDetector(Object paramObject, Context paramContext, IPanelInteractionListener paramIPanelInteractionListener)
  {
    if (paramIPanelInteractionListener == null) {
      return null;
    }
    StickerGestureDetector localStickerGestureDetector = (StickerGestureDetector)paramObject;
    int j = 0;
    if (localStickerGestureDetector == null)
    {
      paramObject = localStickerGestureDetector;
      if (paramIPanelInteractionListener != null)
      {
        int i = j;
        paramObject = localStickerGestureDetector;
        if (paramIPanelInteractionListener.getAIORootView() != null)
        {
          GestureDetector localGestureDetector = ((TopGestureLayout)paramIPanelInteractionListener.getAIORootView()).getGestureDetector();
          i = j;
          paramObject = localStickerGestureDetector;
          if ((localGestureDetector instanceof StickerGestureDetector))
          {
            i = 1;
            paramObject = (StickerGestureDetector)localGestureDetector;
          }
        }
        if (i == 0)
        {
          paramObject = new StickerGestureDetector(paramContext, ((TopGestureLayout)paramIPanelInteractionListener.getAIORootView()).getGestureListener(), (BaseChatPie)paramIPanelInteractionListener.getBaseChatPie());
          ((TopGestureLayout)paramIPanelInteractionListener.getAIORootView()).setGestureDetector(paramObject);
          return paramObject;
        }
      }
    }
    else
    {
      localStickerGestureDetector.enteredAIO = false;
      localStickerGestureDetector.isFirstUpInvoked = false;
      localStickerGestureDetector.mBottom = paramIPanelInteractionListener.getAIORootView().getBottom();
      paramObject = localStickerGestureDetector;
    }
    return paramObject;
  }
  
  public boolean isComeFromComic(String paramString)
  {
    return AIOGallerySceneWithBusiness.a(paramString);
  }
  
  public boolean isFlashPicMsg(MessageRecord paramMessageRecord)
  {
    return HotChatHelper.a(paramMessageRecord);
  }
  
  public boolean isMessageForMixedMsg(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord instanceof MessageForMixedMsg;
  }
  
  public boolean isSplashChatContext(Context paramContext)
  {
    return ((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity));
  }
  
  public boolean isSupportMagicface()
  {
    return MagicfaceViewController.b();
  }
  
  public void launchAECameraUnit(Context paramContext, Object paramObject)
  {
    if (paramObject != null)
    {
      if (paramContext == null) {
        return;
      }
      paramObject = (BaseChatPie)paramObject;
      Bundle localBundle = new Bundle();
      localBundle.putInt("AECAMERA_MODE", 202);
      localBundle.putInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.i.a());
      localBundle.putParcelable("ARG_SESSION_INFO", new SessionWrap(paramObject.ah.b, paramObject.ah.e, paramObject.ah.a, paramObject.ah.c));
      ((IAECameraLauncher)QRoute.api(IAECameraLauncher.class)).launchAECameraUnit((Activity)paramContext, 120, localBundle);
    }
  }
  
  public void launchFriendPicker(Activity paramActivity, List<EmoticonInfo> paramList)
  {
    EmotionBatchForwardOption.a(paramActivity, paramList);
  }
  
  public boolean magicfaceAutoPlay(Context paramContext, Emoticon paramEmoticon, OnMagicPlayEnd paramOnMagicPlayEnd)
  {
    paramContext = ((BaseActivity)paramContext).getChatFragment();
    if ((paramContext != null) && (paramContext.k() != null))
    {
      ((AIOEmoticonUIHelper)paramContext.k().q(105)).a().a(paramEmoticon, paramOnMagicPlayEnd);
      return true;
    }
    return false;
  }
  
  public StringBuilder obtainStringBuilder()
  {
    return AIOUtils.a();
  }
  
  public void openEmojiDetailPage(Activity paramActivity, String paramString1, int paramInt, String paramString2, boolean paramBoolean1, Intent paramIntent, boolean paramBoolean2)
  {
    EmojiHomeUiPlugin.openEmojiDetailPage(paramActivity, paramString1, paramInt, paramString2, paramBoolean1, paramIntent, paramBoolean2);
  }
  
  public void openEmojiDetailPage(Context paramContext, String paramString1, int paramInt, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    EmojiHomeUiPlugin.openEmojiDetailPage(((BaseActivity)paramContext).getActivity(), paramString1, paramInt, paramString2, paramBoolean1, paramBoolean2);
  }
  
  public void openEmojiHomePage(Activity paramActivity, String paramString, int paramInt)
  {
    EmojiHomeUiPlugin.openEmojiHomePage(paramActivity, paramString, paramInt);
  }
  
  public void openEmojiHomePage(Context paramContext, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString1, int paramInt, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    EmojiHomeUiPlugin.openEmojiHomePage(paramContext, paramIEmoticonMainPanelApp, paramString1, paramInt, paramBoolean1, paramString2, paramBoolean2);
  }
  
  public void openEmosmActivity(Context paramContext, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    EmojiHomeUiPlugin.openEmosmActivity(paramContext, paramIEmoticonMainPanelApp, paramIEmoticonMainPanelApp.getAccount(), 1, false, "");
  }
  
  public void parseJson(AppInterface paramAppInterface)
  {
    if (!(paramAppInterface instanceof QQAppInterface)) {
      return;
    }
    ((URLInterceptManager)paramAppInterface.getManager(QQManagerFactory.URL_INTECEPT_MANAGER)).a((QQAppInterface)paramAppInterface);
  }
  
  public MessageRecord queryMsgItemByShmsgseq(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getMessageFacade().c(paramString, paramInt, paramLong);
  }
  
  public Object reparse(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    return ((PngFrameManager)paramBaseQQAppInterface.getManager(QQManagerFactory.PNG_FRAME_DRAWABLE_MANAGER)).b(paramString);
  }
  
  public void reportActionMobileReportManager(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, long paramLong)
  {
    MobileReportManager.getInstance().reportAction(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramLong);
  }
  
  public void reportSendPicSource(String[] paramArrayOfString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, BaseQQAppInterface paramBaseQQAppInterface)
  {
    StatisticConstants.a(paramArrayOfString, paramInt1, paramBoolean1, paramBoolean2, paramInt2, (QQAppInterface)paramBaseQQAppInterface);
  }
  
  public void saveAioMedia2Weiyun(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord, Object paramObject)
  {
    ((QQAppInterface)paramBaseQQAppInterface).getFileManagerEngine().d().a((ChatMessage)paramMessageRecord, (WeiyunCallback)paramObject);
  }
  
  public void sendEmoPic(Context paramContext, Intent paramIntent)
  {
    if ((paramContext instanceof BaseActivity)) {
      ThreadManager.post(new SendPhotoTask((BaseActivity)paramContext, paramIntent, null), 8, null, false);
    }
  }
  
  public void sendEmosmMsg(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, Emoticon paramEmoticon)
  {
    ChatActivityFacade.a((QQAppInterface)paramBaseQQAppInterface, paramContext, (SessionInfo)paramBaseSessionInfo, paramEmoticon);
  }
  
  public void sendEmosmMsg(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, Emoticon paramEmoticon, int paramInt)
  {
    ChatActivityFacade.a((QQAppInterface)paramBaseQQAppInterface, paramContext, (SessionInfo)paramBaseSessionInfo, paramEmoticon, paramInt);
  }
  
  public void sendEmoticon(AppInterface paramAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, Emoticon paramEmoticon, boolean paramBoolean)
  {
    if (!(paramAppInterface instanceof QQAppInterface)) {
      return;
    }
    paramAppInterface = (QQAppInterface)paramAppInterface;
    ChatActivityFacade.a(paramAppInterface, paramContext, paramBaseSessionInfo, paramEmoticon);
    if ((paramEmoticon != null) && (paramEmoticon.isNewSoundEmoticon())) {
      EmoticonOperateReport.reportNewSoundEvent(paramAppInterface, "0X800A932", ((SessionInfo)paramBaseSessionInfo).a, paramEmoticon.epId);
    }
    if (paramBoolean) {
      ((IEmoticonManagerService)paramAppInterface.getRuntimeService(IEmoticonManagerService.class)).asyncIncreaseEmotionClickNum(paramEmoticon);
    }
  }
  
  public void sendInfoFromPanelHelper(BaseAIOContext paramBaseAIOContext, EmoticonInfo paramEmoticonInfo)
  {
    paramBaseAIOContext = (AIOEmoticonPanelHelper)paramBaseAIOContext.a(104);
    if (paramBaseAIOContext != null) {
      paramBaseAIOContext.send(paramEmoticonInfo);
    }
  }
  
  public void sendRecEmoPic(AppInterface paramAppInterface, QBaseActivity paramQBaseActivity, BaseAIOContext paramBaseAIOContext, Editable paramEditable, Intent paramIntent, ArrayList<String> paramArrayList)
  {
    SpecWordEmotionThinkHelper localSpecWordEmotionThinkHelper = (SpecWordEmotionThinkHelper)paramBaseAIOContext.a(41);
    MessageForReplyText.SourceMsgInfo localSourceMsgInfo = ((ReplyHelper)paramBaseAIOContext.a(119)).a();
    if (localSpecWordEmotionThinkHelper.e())
    {
      paramQBaseActivity = TroopUtils.a(paramEditable);
      paramIntent = (MixedMsgManager)paramAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER);
      paramAppInterface = (QQAppInterface)paramAppInterface;
      paramIntent.a(paramAppInterface, paramBaseAIOContext.O().b, paramBaseAIOContext.O().a, paramArrayList, false, (String)paramQBaseActivity.first, (ArrayList)paramQBaseActivity.second, localSourceMsgInfo);
      TroopPobingItemBuilder.b(paramAppInterface, paramEditable.toString(), (ArrayList)paramQBaseActivity.second, paramBaseAIOContext.O().b);
      return;
    }
    sendEmoPic(paramQBaseActivity, paramIntent);
  }
  
  public void sendStickerMsg(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, Emoticon paramEmoticon, StickerInfo paramStickerInfo)
  {
    ChatActivityFacade.a((QQAppInterface)paramBaseQQAppInterface, paramContext, (SessionInfo)paramBaseSessionInfo, paramEmoticon, paramStickerInfo);
    paramContext = ((BaseActivity)paramContext).getChatFragment();
    if (paramContext != null)
    {
      if (paramContext.k() != null) {
        paramContext = paramContext.k().bv();
      } else {
        paramContext = null;
      }
      paramContext = AIOEmoticonUIHelper.a(paramContext);
      if (paramContext != null)
      {
        i = paramContext.getEmoticonTab(paramEmoticon.epId);
        break label76;
      }
    }
    int i = -1;
    label76:
    if (i >= 0) {
      paramContext = Integer.toString(i);
    } else {
      paramContext = "";
    }
    ReportController.b(paramBaseQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057A9", 0, 0, paramEmoticon.epId, "", paramContext, paramEmoticon.eId);
  }
  
  public void sendStructMsgForImage(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, BaseSessionInfo paramBaseSessionInfo)
  {
    paramBundle = (StructMsgForImageShare)StructMsgFactory.a(paramBundle);
    StructMsgForImageShare.sendAndUploadImageShare((QQAppInterface)paramBaseQQAppInterface, paramBundle, paramBaseSessionInfo.b, paramBaseSessionInfo.a, paramBaseSessionInfo.c, 0);
    paramBundle = AIOGallerySceneWithBusiness.e(paramString);
    if ((paramBundle != null) && (paramBundle.length >= 8)) {
      ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145(paramBaseQQAppInterface, "100007", "2", "40051", paramBundle[0], new String[] { paramBundle[2], paramBundle[4], AIOGallerySceneWithBusiness.c(paramString) });
    }
  }
  
  public void setEmojiStickerMode(boolean paramBoolean)
  {
    EmojiStickerManager.b = paramBoolean;
  }
  
  public void setEmotionSearchPanelVisible(BaseAIOContext paramBaseAIOContext, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, String paramString, int paramInt2)
  {
    paramBaseAIOContext = (AIOEmoticonUIHelper)paramBaseAIOContext.a(105);
    if (paramBaseAIOContext != null) {
      paramBaseAIOContext.a(paramBoolean1, paramInt1, paramBoolean2, paramString, paramInt2);
    }
  }
  
  public void setPicEmoticonTag(Context paramContext, Emoticon paramEmoticon)
  {
    paramContext = ((BaseActivity)paramContext).getChatFragment();
    if (paramContext != null)
    {
      paramContext = paramContext.k();
      if (paramContext != null)
      {
        paramContext = (AIOEmoticonUIHelper)paramContext.q(105);
        if (paramContext != null)
        {
          paramContext.a(paramEmoticon, 0, null, false);
          paramContext.a().a(paramEmoticon);
        }
      }
    }
  }
  
  public void showEmoticonPanel(BaseAIOContext paramBaseAIOContext, int paramInt)
  {
    paramBaseAIOContext = (AIOEmoticonPanelHelper)paramBaseAIOContext.a(104);
    if (paramBaseAIOContext != null) {
      paramBaseAIOContext.showEmoticonPanel(paramInt);
    }
  }
  
  public void startEmoticonGroupStoreFragment(Context paramContext)
  {
    PublicFragmentActivity.a(paramContext, EmoticonGroupStoreFragment.class);
  }
  
  public void startGIFCreator(Object paramObject, IEmosmService.GIFCreatorCallback paramGIFCreatorCallback)
  {
    ((GIFCreator)paramObject).a(new EmosmServiceImpl.3(this, paramGIFCreatorCallback));
  }
  
  public void toastFMDefault(int paramInt)
  {
    FMToastUtil.c(paramInt);
  }
  
  public <T extends IEmoticonMainPanel> T tryGetEmoticonMainPanel(IPanelInteractionListener paramIPanelInteractionListener)
  {
    if (paramIPanelInteractionListener == null) {
      return null;
    }
    return AIOEmoticonUIHelper.a(paramIPanelInteractionListener.getAIOContext());
  }
  
  public void updateMarketFaceItemBuilderEmoticonInfo(EmoticonInfo paramEmoticonInfo)
  {
    MarketFaceItemBuilder.w = (IPicEmoticonInfo)paramEmoticonInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.EmosmServiceImpl
 * JD-Core Version:    0.7.0.1
 */