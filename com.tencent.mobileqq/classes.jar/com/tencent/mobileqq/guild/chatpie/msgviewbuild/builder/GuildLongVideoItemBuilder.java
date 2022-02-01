package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildMsgItemLayout;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPlayUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.multimsg.save.FileSaveReq;
import com.tencent.mobileqq.multimsg.save.FileSaveResult;
import com.tencent.mobileqq.multimsg.save.FileSaveToastUtils;
import com.tencent.mobileqq.multimsg.save.ISingleFileSaveCallBack;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import com.tencent.mobileqq.qqvideoplatform.VideoPlatformUtils;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.qqvideoplatform.api.SceneID;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor.CompressTask;
import com.tencent.mobileqq.shortvideo.api.IShortVideoForwardProcessor;
import com.tencent.mobileqq.shortvideo.api.IShortVideoUploadProcessor;
import com.tencent.mobileqq.structmsg.AIOVideoPlayController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import cooperation.peak.PeakUtils;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class GuildLongVideoItemBuilder
  extends BaseGuildMsgViewBuild
  implements View.OnClickListener, Callback
{
  private static Rect q;
  private static CopyOnWriteArraySet<CropBubbleVideoView> r = new CopyOnWriteArraySet();
  private static long t = 0L;
  public int a = 0;
  private MessageForShortVideo l;
  private ListView m;
  private Handler n;
  private MultiRichMediaSaveManager o;
  private GuildLongVideoItemBuilder.CompressUpdateListenerImpl p;
  private QQCustomDialog s;
  private Runnable w = new GuildLongVideoItemBuilder.11(this);
  
  public GuildLongVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (paramAIOAnimationConatiner != null) {
      this.m = paramAIOAnimationConatiner.getListView();
    }
    this.n = new Handler(Looper.getMainLooper());
    if (this.o == null) {
      this.o = ((MultiRichMediaSaveManager)paramQQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER));
    }
    this.p = new GuildLongVideoItemBuilder.CompressUpdateListenerImpl(this, null);
  }
  
  private Rect a(View paramView, MessageForShortVideo paramMessageForShortVideo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramView != null)
    {
      if (paramMessageForShortVideo == null) {
        return null;
      }
      paramView = paramView.findViewById(2131427939);
      localObject1 = localObject2;
      if ((paramView instanceof CropBubbleVideoView))
      {
        paramView = (CropBubbleVideoView)paramView;
        localObject1 = AnimationUtils.a(paramView);
        if (paramMessageForShortVideo.isSend())
        {
          ((Rect)localObject1).right = ((int)(((Rect)localObject1).right - paramView.triWidth));
          return localObject1;
        }
        ((Rect)localObject1).left = ((int)(((Rect)localObject1).left + paramView.triWidth));
      }
    }
    return localObject1;
  }
  
  public static Drawable a(int paramInt1, int paramInt2)
  {
    return new EmptyDrawable(Color.rgb(214, 214, 214), paramInt1, paramInt2);
  }
  
  private void a(long paramLong, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 4)
    {
      localObject = AIOSingleReporter.a().b(Long.valueOf(paramLong));
      if ((!AIOSingleReporter.a().a(Long.valueOf(paramLong))) && (localObject != null))
      {
        ShortVideoUtils.reportVideoPlay(this.g, "0X8008E51", this.c, (MessageRecord)localObject, this.b);
        if (!AIOSingleReporter.a().c(Long.valueOf(((MessageForShortVideo)localObject).uniseq)))
        {
          AIOSingleReporter.a().d(Long.valueOf(((MessageForShortVideo)localObject).uniseq));
          ShortVideoUtils.reportVideoPlay(this.g, "0X8008E50", this.c, (MessageRecord)localObject, this.b);
        }
        AIOSingleReporter.a().a(Long.valueOf(paramLong), true);
      }
    }
    Object localObject = b(paramLong);
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("holder == null, msgUniseq=");
        ((StringBuilder)localObject).append(paramLong);
        QLog.w("GuildShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (((MessageForShortVideo)((GuildLongVideoItemBuilder.Holder)localObject).q).videoFileTime > 8) {
      bool = false;
    }
    if (paramInt == 5)
    {
      this.n.postDelayed(new GuildLongVideoItemBuilder.5(this, bool, (GuildLongVideoItemBuilder.Holder)localObject), 1200L);
      return;
    }
    if ((paramInt != 7) && (paramInt != 8))
    {
      if (paramInt == 4)
      {
        this.n.removeCallbacksAndMessages(null);
        if (bool) {
          ((GuildLongVideoItemBuilder.Holder)localObject).i.setVisibility(8);
        } else {
          ((GuildLongVideoItemBuilder.Holder)localObject).i.setVisibility(0);
        }
        a((GuildLongVideoItemBuilder.Holder)localObject);
        ((GuildLongVideoItemBuilder.Holder)localObject).h.setVisibility(8);
        ((GuildLongVideoItemBuilder.Holder)localObject).d.setVisibility(8);
        AIOSingleReporter.a().b(Long.valueOf(paramLong));
      }
    }
    else
    {
      this.n.removeCallbacksAndMessages(null);
      ((GuildLongVideoItemBuilder.Holder)localObject).i.setVisibility(8);
      ((GuildLongVideoItemBuilder.Holder)localObject).c.setVisibility(0);
      b((GuildLongVideoItemBuilder.Holder)localObject);
      ((GuildLongVideoItemBuilder.Holder)localObject).h.setVisibility(8);
      ((GuildLongVideoItemBuilder.Holder)localObject).d.setVisibility(0);
      if (paramInt == 8) {
        AIOSingleReporter.a().b(Long.valueOf(paramLong));
      }
    }
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, VideoPlayParam paramVideoPlayParam)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPlayError , id = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" , module = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" , errorType = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" , errorCode = ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" , exInfo =");
      if (paramString == null) {
        paramString = "null";
      }
      localStringBuilder.append(paramString);
      QLog.e("GuildShortVideoItemBuilder", 2, localStringBuilder.toString());
    }
    if (paramInt3 == 14011001)
    {
      paramString = this.m;
      if (paramString == null) {
        return;
      }
      paramString = AIOUtils.b(paramLong, paramString.getAdapter());
      if ((paramString instanceof MessageForShortVideo))
      {
        paramString = (MessageForShortVideo)paramString;
        paramString.videoFileStatus = 5002;
        paramString.serial();
        this.g.getMessageFacade().a(paramString.frienduin, this.c.a, paramString.uniseq, paramString.msgData);
        this.n.post(new GuildLongVideoItemBuilder.4(this, paramString));
      }
    }
    VideoPlatformUtils.a(paramInt3, paramVideoPlayParam);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, Context paramContext, SessionInfo paramSessionInfo, Bundle paramBundle, MessageForReplyText paramMessageForReplyText)
  {
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.G))
    {
      ChatFragment localChatFragment = ((BaseActivity)paramContext).getChatFragment();
      if (localChatFragment != null) {
        paramBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", localChatFragment.k().aR());
      }
    }
    if (paramSessionInfo.a == 1)
    {
      paramBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      paramBundle.putString("extra.GROUP_UIN", paramSessionInfo.b);
      paramBundle.putString("extra.GROUP_CODE", paramSessionInfo.c);
    }
    if ((paramSessionInfo.a != 1) && (paramSessionInfo.a != 3000)) {
      paramBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
    } else {
      paramBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
    }
    if (paramMessageForReplyText != null) {
      paramBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
    } else {
      paramBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForShortVideo.isMultiMsg);
    }
    paramBundle.putLong("click_video_bubble_time", System.currentTimeMillis());
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      paramMessageForReplyText = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (paramMessageForReplyText.processName.endsWith("mobileqq")) {
        paramBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", paramMessageForReplyText.pid);
      }
    }
    paramQQAppInterface = (MultiRichMediaSaveManager)paramQQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
    boolean bool = paramQQAppInterface.b(paramMessageForShortVideo);
    paramBundle.putBoolean("extra.IS_SAVING_FILE", bool);
    if (bool)
    {
      paramQQAppInterface = paramQQAppInterface.a(paramQQAppInterface.a(paramMessageForShortVideo));
      if ((paramQQAppInterface != null) && (paramQQAppInterface.f == 1)) {
        paramBundle.putInt("extra.SAVE_FILE_PROGRESS", paramQQAppInterface.e);
      }
    }
    paramQQAppInterface = q;
    if (paramQQAppInterface != null) {
      paramBundle.putParcelable("KEY_THUMBNAL_BOUND", paramQQAppInterface);
    }
    paramBundle.putInt("forward_source_uin_type", paramSessionInfo.a);
    paramBundle.putString("uin", paramSessionInfo.b);
    paramBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Bundle paramBundle, MessageForReplyText paramMessageForReplyText)
  {
    int i;
    if ((!((IVideoVolumeControl)QRoute.api(IVideoVolumeControl.class)).isInPhoneCall(paramContext)) && (!paramQQAppInterface.isVideoChatting()))
    {
      if (!paramMessageForShortVideo.isSend()) {
        new DCShortVideo(BaseApplication.getContext()).a(paramQQAppInterface, 2002, paramSessionInfo.a, paramSessionInfo.b, 1001);
      }
      if (MediaPlayerManager.a(paramQQAppInterface).g()) {
        MediaPlayerManager.a(paramQQAppInterface).a(true);
      }
      a(paramQQAppInterface, paramMessageForShortVideo, paramContext, paramSessionInfo, paramBundle, paramMessageForReplyText);
      if ((paramContext instanceof SplashActivity))
      {
        i = 1;
      }
      else
      {
        if ((paramContext instanceof ChatHistoryActivity)) {}
        while (((paramContext instanceof PublicFragmentActivity)) && ((((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment)))
        {
          i = 2;
          break;
        }
        i = -1;
      }
      str = paramMessageForShortVideo.selfuin;
      paramMessageForReplyText = str;
      if (!paramMessageForShortVideo.isMultiMsg) {}
    }
    try
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramMessageForReplyText = str;
      if ((localAppRuntime instanceof QQAppInterface)) {
        paramMessageForReplyText = localAppRuntime.getAccount();
      }
    }
    catch (Exception paramMessageForReplyText)
    {
      for (;;)
      {
        paramMessageForReplyText = str;
      }
    }
    if ((paramMessageForShortVideo.istroop == 0) && (Utils.c(paramMessageForShortVideo.senderuin)) && (!TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"))))
    {
      paramBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
      PeakUtils.a(paramContext, paramBundle, new AIOImageProviderService(paramMessageForReplyText, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), AIOGalleryUtils.a(paramMessageForShortVideo), 13007, i);
    }
    else
    {
      PeakUtils.a(paramContext, paramBundle, new AIOImageProviderService(paramMessageForReplyText, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), AIOGalleryUtils.a(paramMessageForShortVideo), -1, i);
    }
    if (!paramMessageForShortVideo.isSend()) {
      new DCShortVideo(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.a, paramSessionInfo.b, 1001);
    }
    return;
    QQToast.makeText(paramContext, 0, 2131916633, 0).show(paramContext.getResources().getDimensionPixelSize(2131299920));
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, MessageForReplyText paramMessageForReplyText)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("muate_play", false);
    localBundle.putBoolean("is_one_item", true);
    localBundle.putBoolean("is_ReplyMsg_From_Same_Session", paramBoolean1);
    localBundle.putBoolean(PeakUtils.b, paramBoolean2);
    a(paramMessageForShortVideo, paramLong, paramContext, paramQQAppInterface, paramSessionInfo, localBundle, paramMessageForReplyText);
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, StringBuilder paramStringBuilder, int paramInt, String paramString, GuildLongVideoItemBuilder.Holder paramHolder, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" sendFromLocal:true ");
    if (paramMessageForShortVideo.isMultiMsg) {
      paramMessageForShortVideo.extraflag = 32772;
    }
    if (FileUtils.fileExistsAndNotEmpty(paramMessageForShortVideo.videoFileName))
    {
      a(paramStringBuilder, paramHolder, paramMessageForShortVideo, paramInt, paramLong, paramBoolean);
      return;
    }
    b(paramStringBuilder, paramHolder, paramMessageForShortVideo, paramInt, paramLong, paramBoolean);
  }
  
  private void a(GuildLongVideoItemBuilder.Holder paramHolder, int paramInt)
  {
    paramHolder.g.setVisibility(0);
    paramHolder.g.setText(paramInt);
    VideoProgressView localVideoProgressView = paramHolder.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramHolder.q.frienduin);
    localStringBuilder.append(paramHolder.q.uniseq);
    localVideoProgressView.b(localStringBuilder.toString());
    paramHolder.c.setVisibility(0);
    paramHolder.c.setImageResource(2130851866);
    paramHolder.c.setDrawStatus(3);
  }
  
  private void a(GuildLongVideoItemBuilder.Holder paramHolder, View paramView, ChatMessage paramChatMessage)
  {
    if (e(paramHolder))
    {
      if (paramHolder.n == null)
      {
        paramHolder.n = new ImageView(this.b);
        paramHolder.n.setImageResource(2130838287);
        paramHolder.n.setId(2131430598);
        paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
        paramChatMessage.bottomMargin = AIOUtils.b(16.0F, this.b.getResources());
        paramChatMessage.addRule(8, 2131430578);
        paramChatMessage.addRule(0, 2131430578);
        paramChatMessage.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramHolder.n, paramChatMessage);
        }
      }
      b(paramHolder, true, this);
      return;
    }
    b(paramHolder, false, null);
  }
  
  private void a(GuildLongVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showVideoThumb, msg.uniseq = ");
      ((StringBuilder)localObject).append(paramMessageForShortVideo.uniseq);
      QLog.d("GuildShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    paramString = ShortVideoUtils.getThumbUrl(paramString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showVideoThumb, url = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("GuildShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    if ((QLog.isColorLevel()) && (paramHolder.b != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showVideoThumb, holder.d.getURL()=");
      ((StringBuilder)localObject).append(paramHolder.b.getURL());
      QLog.d("GuildShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    paramHolder.a.setID(paramMessageForShortVideo.uniseq);
    if ((paramHolder.b != null) && (paramHolder.b.getURL().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildShortVideoItemBuilder", 2, "showVideoThumb, holder.d is reuse !!!");
      }
      if (paramBoolean)
      {
        paramHolder.a.setCoverDrawable(paramHolder.b);
        return;
      }
      paramHolder.a.setID(paramMessageForShortVideo.uniseq);
      paramHolder.a.showCover(paramHolder.b);
      return;
    }
    Object localObject = a(paramInt1, paramInt2);
    paramString = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, (Drawable)localObject, (Drawable)localObject);
    paramHolder.a.setID(paramMessageForShortVideo.uniseq);
    paramHolder.a.showCover(paramString);
    paramHolder.b = paramString;
  }
  
  private void a(GuildLongVideoItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramHolder.q;
    int i = localMessageForShortVideo.videoFileStatus;
    long l1;
    if (paramHolder.a != null) {
      l1 = paramHolder.a.getCurPlayingPos();
    } else {
      l1 = 0L;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("click ppv, msg.uniseq:");
      localStringBuilder.append(localMessageForShortVideo.uniseq);
      localStringBuilder.append(",fileType: ");
      localStringBuilder.append(SVUtils.a(localMessageForShortVideo.fileType));
      localStringBuilder.append(", fileStatus:");
      localStringBuilder.append(SVUtils.b(i));
      localStringBuilder.append(", playPosition:");
      localStringBuilder.append(l1);
      QLog.d("GuildShortVideoItemBuilder", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("......click ppv, msg.uniseq:");
    ((StringBuilder)localObject).append(localMessageForShortVideo.uniseq);
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localObject = SVUtils.a(localMessageForShortVideo, "mp4");
    if (!localMessageForShortVideo.isSendFromLocal()) {
      b(localMessageForShortVideo, localStringBuilder, i, (String)localObject, paramHolder, l1, paramBoolean);
    } else {
      a(localMessageForShortVideo, localStringBuilder, i, (String)localObject, paramHolder, l1, paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.i("GuildShortVideoItemBuilder", 2, localStringBuilder.toString());
    }
  }
  
  private void a(GuildLongVideoItemBuilder.Holder paramHolder, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((paramHolder != null) && (paramHolder.k != null))
    {
      if (paramBoolean) {
        b(paramHolder, false, null);
      }
      paramHolder.k.setFailedIconVisable(paramBoolean, paramOnClickListener);
    }
  }
  
  private void a(GuildLongVideoItemBuilder.Holder paramHolder, boolean paramBoolean, MessageForShortVideo paramMessageForShortVideo, String paramString1, String[] paramArrayOfString, String paramString2, int paramInt1, int paramInt2)
  {
    paramHolder.a.setID(paramMessageForShortVideo.uniseq);
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    localVideoPlayParam.mSceneId = 101;
    localVideoPlayParam.mSceneName = SceneID.getSceneStr(101);
    int i = 1;
    localVideoPlayParam.mIsMute = true;
    localVideoPlayParam.mCallback = new GuildLongVideoItemBuilder.3(this, localVideoPlayParam);
    localVideoPlayParam.mIsLocal = paramBoolean;
    localVideoPlayParam.mIsLoop = true;
    localVideoPlayParam.mVideoPath = paramString1;
    localVideoPlayParam.mSavePath = SVUtils.a(paramMessageForShortVideo, "mp4");
    paramString1 = new StringBuilder();
    paramString1.append(paramMessageForShortVideo.md5);
    paramString1.append(paramMessageForShortVideo.uniseq);
    localVideoPlayParam.mFileID = paramString1.toString();
    localVideoPlayParam.mUrls = paramArrayOfString;
    localVideoPlayParam.mFileSize = paramMessageForShortVideo.videoFileSize;
    if (paramMessageForShortVideo.videoFileTime > 8) {
      i = 0;
    }
    if (i == 0)
    {
      localVideoPlayParam.mVideoFileTimeMs = (paramMessageForShortVideo.videoFileTime * 1000);
      localVideoPlayParam.mMaxPlayTimeMs = 8000L;
    }
    paramHolder.a.setVideoParam(localVideoPlayParam);
    paramMessageForShortVideo = a(paramInt1, paramInt2);
    if (TextUtils.isEmpty(paramString2))
    {
      paramHolder.a.setCoverDrawable(paramMessageForShortVideo);
    }
    else
    {
      paramMessageForShortVideo = URLDrawable.getDrawable(ShortVideoUtils.getThumbUrl(paramString2), paramInt1, paramInt2, paramMessageForShortVideo, paramMessageForShortVideo);
      paramHolder.a.setCoverDrawable(paramMessageForShortVideo);
      paramHolder.b = paramMessageForShortVideo;
    }
    if (c()) {
      paramHolder.a.play();
    }
    r.add(paramHolder.a);
  }
  
  private void a(FileSaveResult paramFileSaveResult, String paramString, GuildLongVideoItemBuilder.Holder paramHolder, ISingleFileSaveCallBack paramISingleFileSaveCallBack)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildShortVideoItemBuilder", 2, "dealVideoSaveUI onSaveComplete");
    }
    if (paramFileSaveResult != null)
    {
      if (paramFileSaveResult.b == 0) {
        FileSaveToastUtils.a(this.b);
      } else {
        FileSaveToastUtils.b(this.b);
      }
      paramFileSaveResult.g.b(paramISingleFileSaveCallBack);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramFileSaveResult = new StringBuilder();
      paramFileSaveResult.append(paramHolder.q.frienduin);
      paramFileSaveResult.append(paramHolder.q.uniseq);
      if (paramString.equals(paramFileSaveResult.toString())) {
        paramHolder.c.setVisibility(8);
      }
    }
  }
  
  private void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, StringBuilder paramStringBuilder, GuildLongVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, int paramInt, long paramLong, boolean paramBoolean)
  {
    boolean bool = ((ShortVideoDownloadProcessor)paramIHttpCommunicatorListener).isPause();
    paramIHttpCommunicatorListener = new StringBuilder();
    paramIHttpCommunicatorListener.append(" processor:download, pause:");
    paramIHttpCommunicatorListener.append(bool);
    paramStringBuilder.append(paramIHttpCommunicatorListener.toString());
    if (bool)
    {
      b(paramHolder);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" pause:true, result:download ");
      return;
    }
    if (paramInt == 2005)
    {
      b(paramHolder);
      QQToast.makeText(this.b, 2131916641, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
      paramStringBuilder.append(" status:recv_error, result:toast recv_error ");
      return;
    }
    if ((paramInt != 2002) && (paramInt != 2000) && (paramInt != 2008) && (paramInt != 2001))
    {
      if (paramInt == 5001)
      {
        b(paramHolder);
        QQToast.makeText(this.b, 2131916639, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
        paramStringBuilder.append(" status:file_unsafe, result:toast unsafe ");
        return;
      }
      if (paramInt == 5002)
      {
        a(paramHolder, 2131915835);
        QQToast.makeText(this.b, 2131916640, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
        paramStringBuilder.append(" status:file_expired, result:toast expired ");
        return;
      }
      b(paramHolder);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" status:other, result:download ");
      return;
    }
    b(paramHolder);
  }
  
  private void a(StringBuilder paramStringBuilder, GuildLongVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, int paramInt, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" localUploadPath Exists:true ");
    if ((paramMessageForShortVideo.fileType != 6) && (paramMessageForShortVideo.fileType != 17) && (paramMessageForShortVideo.fileType != 9) && (paramMessageForShortVideo.fileType != 67))
    {
      b(paramHolder);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" fileType:not video, result: play ");
      return;
    }
    paramStringBuilder.append(" fileType:video ");
    IHttpCommunicatorListener localIHttpCommunicatorListener = ((ITransFileController)this.g.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
    if (localIHttpCommunicatorListener != null)
    {
      if ((!IShortVideoUploadProcessor.class.isInstance(localIHttpCommunicatorListener)) && (!IShortVideoForwardProcessor.class.isInstance(localIHttpCommunicatorListener)))
      {
        if (ShortVideoDownloadProcessor.class.isInstance(localIHttpCommunicatorListener)) {
          paramStringBuilder.append(" processor:not up of forward, result: none");
        }
      }
      else
      {
        if (paramInt == 1005)
        {
          b(paramHolder);
          paramHolder.k.setFailedIconVisable(true, this);
          paramStringBuilder.append(" status:send_error, result:show send error ");
          return;
        }
        if ((paramInt != 1002) && (paramInt != 1001))
        {
          b(paramHolder);
          a(paramMessageForShortVideo, paramLong, paramBoolean);
          paramStringBuilder.append(" status:other, result:play ");
          return;
        }
        a(paramMessageForShortVideo, paramLong, paramBoolean);
        paramStringBuilder.append(" status:process or start, result:pauseSending ");
      }
    }
    else
    {
      b(paramHolder);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" processor:null, result:play ");
    }
  }
  
  private boolean a(long paramLong)
  {
    return ((IOrderMediaMsgService)this.g.getRuntimeService(IOrderMediaMsgService.class)).isMediaMsgInQueue(this.c.b, paramLong);
  }
  
  private GuildLongVideoItemBuilder.Holder b(long paramLong)
  {
    Object localObject = this.m;
    if ((localObject != null) && (paramLong > 0L))
    {
      int i = AIOUtils.a(paramLong, ((ListView)localObject).getAdapter());
      int j = this.m.getHeaderViewsCount();
      int k = this.m.getFirstVisiblePosition();
      int i1 = this.m.getLastVisiblePosition();
      if (i > -1)
      {
        localObject = AIOUtils.a(this.m, i);
        if (localObject != null)
        {
          localObject = AIOUtils.b((View)localObject);
          if ((localObject != null) && ((localObject instanceof GuildLongVideoItemBuilder.Holder))) {
            return (GuildLongVideoItemBuilder.Holder)localObject;
          }
        }
        else if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getHolderByMsg() uniseq=");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(", posi =");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", view = null");
          QLog.w("GuildShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getHolderByMsg() uniseq=");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(", posi =");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", firstVisblePosi=");
          ((StringBuilder)localObject).append(k);
          ((StringBuilder)localObject).append(",lastVisblePosi=");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append(",headerCount=");
          ((StringBuilder)localObject).append(j);
          QLog.d("GuildShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getHolderByMsg() uniseq=");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(", posi<= -1");
        QLog.w("GuildShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  private void b(MessageForShortVideo paramMessageForShortVideo, StringBuilder paramStringBuilder, int paramInt, String paramString, GuildLongVideoItemBuilder.Holder paramHolder, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" sendFromLocal:false ");
    if (!FileUtils.fileExistsAndNotEmpty(paramString))
    {
      paramStringBuilder.append(" videoPathExists:false ");
      if ((paramMessageForShortVideo.fileType != 6) && (paramMessageForShortVideo.fileType != 17) && (paramMessageForShortVideo.fileType != 9) && (paramMessageForShortVideo.fileType != 67))
      {
        if (paramInt == 5002)
        {
          a(paramHolder, 2131915835);
          QQToast.makeText(this.b, 2131916640, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
          paramStringBuilder.append("fileType:not video,videoPathExits:false, result:toast file_expired ");
          return;
        }
        b(paramHolder);
        a(paramMessageForShortVideo, paramLong, paramBoolean);
        paramStringBuilder.append("fileType:not video,videoPathExits:false, result: download");
        return;
      }
      paramString = new StringBuilder();
      paramString.append(" fileType:video, =");
      paramString.append(SVUtils.a(paramMessageForShortVideo.fileType));
      paramStringBuilder.append(paramString.toString());
      if ((paramInt == 2005) && (paramMessageForShortVideo.isAllowAutoDown))
      {
        b(paramHolder);
        QQToast.makeText(this.b, 2131916641, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
        paramStringBuilder.append(" result:toast recv_error ");
        return;
      }
      if (paramInt == 5001)
      {
        b(paramHolder);
        QQToast.makeText(this.b, 2131916639, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
        paramStringBuilder.append(" result: toast file_unsafe ");
        return;
      }
      if (paramInt == 5002)
      {
        a(paramHolder, 2131915835);
        QQToast.makeText(this.b, 2131916640, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
        paramStringBuilder.append(" result: toast file_expired ");
        return;
      }
      b(paramHolder);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" status:other, result: download ");
      return;
    }
    b(paramHolder);
    a(paramMessageForShortVideo, paramLong, paramBoolean);
    paramStringBuilder.append("videoPathExists:true, result:play ");
  }
  
  private void b(GuildLongVideoItemBuilder.Holder paramHolder, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean)
    {
      if (paramHolder.n != null)
      {
        paramHolder.n.setVisibility(0);
        paramHolder.n.setOnClickListener(paramOnClickListener);
      }
    }
    else if (paramHolder.n != null)
    {
      paramHolder.n.setVisibility(8);
      paramHolder.n.setOnClickListener(null);
    }
  }
  
  private void b(StringBuilder paramStringBuilder, GuildLongVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, int paramInt, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" localUploadPath Exists:false ");
    if (!FileUtils.fileExistsAndNotEmpty(SVUtils.a(paramMessageForShortVideo, "mp4")))
    {
      paramStringBuilder.append(" downloadPath Exists:false ");
      if ((paramMessageForShortVideo.fileType != 6) && (paramMessageForShortVideo.fileType != 17) && (paramMessageForShortVideo.fileType != 9) && (paramMessageForShortVideo.fileType != 67))
      {
        b(paramHolder);
        a(paramMessageForShortVideo, paramLong, paramBoolean);
        paramStringBuilder.append(" fileType:not video, result:download ");
        return;
      }
      Object localObject = ((ITransFileController)this.g.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      if (localObject != null)
      {
        if (ShortVideoDownloadProcessor.class.isInstance(localObject))
        {
          a((IHttpCommunicatorListener)localObject, paramStringBuilder, paramHolder, paramMessageForShortVideo, paramInt, paramLong, paramBoolean);
          return;
        }
        if (IShortVideoUploadProcessor.class.isInstance(localObject))
        {
          b(paramHolder);
          paramHolder.k.setFailedIconVisable(true, this);
          QQToast.makeText(this.b, 2131916646, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
          paramStringBuilder.append(" processor:upload, result:show upload error and show toast");
          return;
        }
        if (IShortVideoForwardProcessor.class.isInstance(localObject))
        {
          boolean bool = ((BaseTransProcessor)localObject).isPause();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" processor:forward, pause:");
          ((StringBuilder)localObject).append(bool);
          paramStringBuilder.append(((StringBuilder)localObject).toString());
          if (bool)
          {
            a(paramHolder, 10, false);
            c(paramMessageForShortVideo, paramHolder);
            paramStringBuilder.append(" pause:true, result:reforward ");
            return;
          }
          if (paramInt == 5001)
          {
            b(paramHolder);
            paramHolder.k.setFailedIconVisable(true, this);
            QQToast.makeText(this.b, 2131916615, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
            paramStringBuilder.append(" status:unsafe, result:toast unsafe ");
            return;
          }
          if (paramInt == 5002)
          {
            a(paramHolder, 2131915835);
            paramHolder.k.setFailedIconVisable(true, this);
            QQToast.makeText(this.b, 2131916616, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
            paramStringBuilder.append(" status:expired, result:toast expired ");
            return;
          }
          if (paramInt == 1005)
          {
            b(paramHolder);
            paramHolder.k.setFailedIconVisable(true, this);
            paramStringBuilder.append(" status:send_error, result:show send_error ");
            return;
          }
          if ((paramInt != 1002) && (paramInt != 1001))
          {
            b(paramHolder);
            a(paramMessageForShortVideo, 0L, paramBoolean);
            paramStringBuilder.append(" status:other, result:plau ");
            return;
          }
          a(paramMessageForShortVideo, 0L, paramBoolean);
          return;
        }
        paramStringBuilder.append(" processor:not down or forward or up, result:none ");
        return;
      }
      b(paramHolder);
      paramStringBuilder.append(" processor:null, result:download ");
      a(paramMessageForShortVideo, 0L, paramBoolean);
      return;
    }
    b(paramHolder);
    a(paramMessageForShortVideo, paramLong, paramBoolean);
    paramStringBuilder.append(" downloadPath Exists:true，result:play ");
  }
  
  private boolean b(MessageForShortVideo paramMessageForShortVideo)
  {
    return false;
  }
  
  private boolean c()
  {
    if ((this.h != null) && ((this.h instanceof ChatXListView))) {
      return ((ChatXListView)this.h).a();
    }
    return true;
  }
  
  private boolean c(MessageForShortVideo paramMessageForShortVideo)
  {
    return AIOVideoPlayController.a().a(this.b, 1, paramMessageForShortVideo.istroop);
  }
  
  private boolean c(GuildLongVideoItemBuilder.Holder paramHolder)
  {
    MultiRichMediaSaveManager localMultiRichMediaSaveManager = this.o;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localMultiRichMediaSaveManager != null)
    {
      paramHolder = localMultiRichMediaSaveManager.a(localMultiRichMediaSaveManager.a(paramHolder.q));
      if ((paramHolder != null) && (QLog.isColorLevel())) {
        QLog.d("GuildShortVideoItemBuilder", 2, "isVideoInMultiSaving = true");
      }
      bool1 = bool2;
      if (paramHolder != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void d(MessageForShortVideo paramMessageForShortVideo, GuildLongVideoItemBuilder.Holder paramHolder)
  {
    Object localObject = this.o;
    if ((localObject != null) && (paramMessageForShortVideo != null) && (paramHolder != null))
    {
      paramMessageForShortVideo = ((MultiRichMediaSaveManager)localObject).a(paramMessageForShortVideo);
      localObject = this.o.a(paramMessageForShortVideo);
      if (localObject != null)
      {
        int i = ((FileSaveResult)localObject).f;
        int k = 1;
        if (i == 1)
        {
          if (((FileSaveResult)localObject).e < 0) {
            i = 0;
          } else if (((FileSaveResult)localObject).e > 100) {
            i = 100;
          } else {
            i = ((FileSaveResult)localObject).e;
          }
          int j = k;
          if (paramHolder.c.getVisibility() != 8) {
            if ((paramHolder.c.getVisibility() == 0) && (paramHolder.c.g == 2)) {
              j = k;
            } else {
              j = 0;
            }
          }
          if ((i < 100) && (j != 0) && (!((FileSaveResult)localObject).a) && (((FileSaveResult)localObject).g != null))
          {
            ((FileSaveResult)localObject).g.a(new GuildLongVideoItemBuilder.6(this, paramMessageForShortVideo, paramHolder));
            this.o.a(paramMessageForShortVideo, (FileSaveResult)localObject);
            if (QLog.isColorLevel()) {
              QLog.d("GuildShortVideoItemBuilder", 2, "dealVideoSaveUI showSaveProgress");
            }
            a(paramHolder, i, false);
            paramHolder.c.setVisibility(0);
          }
        }
      }
    }
  }
  
  private boolean d(MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramMessageForShortVideo.videoFileStatus == 998) && (VideoCompressProcessor.a().b(paramMessageForShortVideo.uniseq) == null))
    {
      paramMessageForShortVideo = ShortVideoUtils.getShortVideoCompressPath(paramMessageForShortVideo.videoFileName, "mp4");
      if (!TextUtils.isEmpty(paramMessageForShortVideo)) {
        FileUtils.deleteFile(paramMessageForShortVideo);
      }
      return true;
    }
    return false;
  }
  
  private boolean d(GuildLongVideoItemBuilder.Holder paramHolder)
  {
    MultiRichMediaSaveManager localMultiRichMediaSaveManager = this.o;
    if (localMultiRichMediaSaveManager != null)
    {
      paramHolder = localMultiRichMediaSaveManager.a(localMultiRichMediaSaveManager.a(paramHolder.q));
      return (paramHolder != null) && (paramHolder.f == 1) && (!paramHolder.a);
    }
    return false;
  }
  
  private GuildLongVideoItemBuilder.Holder e(MessageForShortVideo paramMessageForShortVideo)
  {
    GuildLongVideoItemBuilder.Holder localHolder = b(paramMessageForShortVideo.uniseq);
    if ((localHolder == null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("holder is null, seq = ");
      localStringBuilder.append(paramMessageForShortVideo.uniseq);
      QLog.d("GuildShortVideoItemBuilder", 2, localStringBuilder.toString());
    }
    return localHolder;
  }
  
  private boolean e(GuildLongVideoItemBuilder.Holder paramHolder)
  {
    MessageForShortVideo localMessageForShortVideo;
    if ((paramHolder.q instanceof MessageForShortVideo)) {
      localMessageForShortVideo = (MessageForShortVideo)paramHolder.q;
    } else {
      localMessageForShortVideo = null;
    }
    boolean bool2 = false;
    if (localMessageForShortVideo == null) {
      return false;
    }
    int i;
    if ((localMessageForShortVideo.videoFileStatus != 998) && (localMessageForShortVideo.videoFileStatus != 1002) && (localMessageForShortVideo.videoFileStatus != 1001)) {
      i = 0;
    } else {
      i = 1;
    }
    int j;
    if ((!localMessageForShortVideo.isMultiMsg) && (localMessageForShortVideo.uiOperatorFlag != 2) && (localMessageForShortVideo.busiType == 4601) && (localMessageForShortVideo.subBusiType == 4601) && (localMessageForShortVideo.isSendFromLocal()) && (!paramHolder.k.f())) {
      j = 1;
    } else {
      j = 0;
    }
    if (QLog.isColorLevel())
    {
      paramHolder = new StringBuilder();
      paramHolder.append("needShowPauseIcon seq:");
      paramHolder.append(localMessageForShortVideo.uniseq);
      paramHolder.append(", videostatus:");
      paramHolder.append(localMessageForShortVideo.videoFileStatus);
      paramHolder.append(", iconshow:");
      if ((i != 0) && (j != 0)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramHolder.append(bool1);
      QLog.i("GuildShortVideoItemBuilder", 2, paramHolder.toString());
    }
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (j != 0)
      {
        bool1 = bool2;
        if (Build.VERSION.SDK_INT >= 21) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void f(GuildLongVideoItemBuilder.Holder paramHolder)
  {
    if (e(paramHolder))
    {
      if (paramHolder.n == null)
      {
        h();
        return;
      }
      if (paramHolder.n.getVisibility() != 0) {
        b(paramHolder, true, this);
      }
    }
  }
  
  private void h()
  {
    try
    {
      if (this.b != null)
      {
        Object localObject = ((BaseActivity)this.b).getChatFragment();
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).k();
          if (localObject != null) {
            ((BaseChatPie)localObject).a(false, false);
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    if ((paramChatMessage instanceof MessageForShortVideo)) {
      this.l = ((MessageForShortVideo)paramChatMessage);
    }
    a(paramChatMessage, paramView, this);
    a((GuildLongVideoItemBuilder.Holder)paramView.getTag(), paramView, paramChatMessage);
    if (v) {}
    try
    {
      paramChatMessage = (GuildLongVideoItemBuilder.Holder)paramView.getTag();
      paramChatMessage.r.append(paramChatMessage.e.getText());
      paramChatMessage.r.append(this.l.videoFileTime);
      paramChatMessage.r.append("秒按钮");
      paramView.setContentDescription(paramChatMessage.r.toString());
      return paramView;
    }
    catch (Exception paramChatMessage) {}
    return paramView;
  }
  
  @NonNull
  protected View a(ChatMessage paramChatMessage, BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, GuildMsgItemLayout paramGuildMsgItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (QLog.isColorLevel())
    {
      paramGuildMsgItemLayout = new StringBuilder();
      paramGuildMsgItemLayout.append("getContentView, message.uniseq = ");
      paramGuildMsgItemLayout.append(paramChatMessage.uniseq);
      QLog.d("GuildShortVideoItemBuilder", 2, paramGuildMsgItemLayout.toString());
    }
    GuildLongVideoItemBuilder.Holder localHolder = (GuildLongVideoItemBuilder.Holder)paramViewHolder;
    Resources localResources = this.b.getResources();
    paramGuildMsgItemLayout = (MessageForShortVideo)paramChatMessage;
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout(this.b);
      paramView = (CropBubbleVideoView)QQVideoViewFactory.createCropBubbleView(this.b, paramGuildMsgItemLayout.uniseq, null, true);
      paramView.setId(2131427939);
      paramView.setVisibility(0);
      paramView.setContentDescription(HardCodeUtil.a(2131911437));
      paramView.setDrawTri(false);
      paramView.setRadius(6.0F);
      paramViewHolder.addView(paramView);
      r.add(paramView);
      VideoProgressView localVideoProgressView = new VideoProgressView(this.b);
      localVideoProgressView.setRadius(6.0F, true);
      localVideoProgressView.setShowCorner(false);
      localVideoProgressView.setId(2131430626);
      paramViewHolder.addView(localVideoProgressView);
      ProgressBar localProgressBar = new ProgressBar(this.b, null, 0);
      i = AIOUtils.b(50.0F, this.b.getResources());
      Object localObject1 = new RelativeLayout.LayoutParams(i, i);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      paramViewHolder.addView(localProgressBar, (ViewGroup.LayoutParams)localObject1);
      Object localObject2 = new LinearLayout(this.b);
      ((LinearLayout)localObject2).setOrientation(1);
      ((LinearLayout)localObject2).setGravity(17);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      paramViewHolder.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new TextView(this.b);
      Object localObject3 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(70.0F, localResources);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setId(2131430624);
      ((TextView)localObject1).setVisibility(4);
      ((LinearLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new RelativeLayout(this.b);
      ((RelativeLayout)localObject2).setBackgroundResource(2130840770);
      localObject3 = new RelativeLayout.LayoutParams(-1, AIOUtils.b(55.0F, localResources));
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131427939);
      ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131427939);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131427939);
      paramViewHolder.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this.b);
      ((TextView)localObject3).setTextSize(1, 12.0F);
      ((TextView)localObject3).setTextColor(-1);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = AIOUtils.b(7.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject4).bottomMargin = AIOUtils.b(7.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject4).addRule(9);
      ((RelativeLayout.LayoutParams)localObject4).addRule(12);
      ((RelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(this.b);
      ((TextView)localObject4).setTextSize(1, 12.0F);
      ((TextView)localObject4).setTextColor(-1);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).rightMargin = AIOUtils.b(7.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject5).bottomMargin = AIOUtils.b(7.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject5).addRule(11);
      ((RelativeLayout.LayoutParams)localObject5).addRule(12);
      ((RelativeLayout)localObject2).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new TextView(this.b);
      ((TextView)localObject5).setTextSize(1, 14.0F);
      ((TextView)localObject5).setTextColor(-1);
      ((TextView)localObject5).setGravity(17);
      ((TextView)localObject5).setText(2131916634);
      ((TextView)localObject5).setShadowLayer(3.0F, 1.0F, 1.0F, -16777216);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = AIOUtils.b(14.0F, localResources);
      localLayoutParams.addRule(14);
      paramViewHolder.addView((View)localObject5, localLayoutParams);
      paramViewHolder.setOnClickListener(this);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      localHolder.h = localProgressBar;
      localHolder.d = ((RelativeLayout)localObject2);
      localHolder.e = ((TextView)localObject3);
      localHolder.f = ((TextView)localObject4);
      localHolder.c = localVideoProgressView;
      localHolder.g = ((TextView)localObject1);
      localHolder.i = ((TextView)localObject5);
      localHolder.a = paramView;
    }
    else
    {
      paramViewHolder = paramView;
    }
    localHolder.a.setTag(Long.valueOf(paramGuildMsgItemLayout.uniseq));
    AIOSingleReporter.a().a(Long.valueOf(paramGuildMsgItemLayout.uniseq), paramGuildMsgItemLayout);
    if (!localHolder.a.mIsSend)
    {
      localHolder.a.mIsSend = true;
      localHolder.a.invalidate();
    }
    localHolder.c.setOnClickListener(this);
    localHolder.c.setShowCorner(false);
    paramView = localHolder.c;
    paramOnLongClickAndTouchListener = new StringBuilder();
    paramOnLongClickAndTouchListener.append(paramChatMessage.frienduin);
    paramOnLongClickAndTouchListener.append(paramChatMessage.uniseq);
    paramView.a(paramOnLongClickAndTouchListener.toString());
    ((RelativeLayout.LayoutParams)localHolder.i.getLayoutParams()).rightMargin = (AIOUtils.b(localHolder.a.getTriaWidth(), localResources) / 2);
    localHolder.f.setText(ShortVideoUtils.stringForTime(paramGuildMsgItemLayout.videoFileTime * 1000));
    paramChatMessage = SVUtils.a(paramGuildMsgItemLayout.thumbMD5, "jpg");
    paramView = ShortVideoUtils.adjustSizeforGuild(paramGuildMsgItemLayout.thumbWidth, paramGuildMsgItemLayout.thumbHeight);
    int i = paramView[0];
    int j = paramView[1];
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("getBubbleView, msg.uniseq = ");
      paramView.append(paramGuildMsgItemLayout.uniseq);
      paramView.append(" msg.thumbWidth = ");
      paramView.append(paramGuildMsgItemLayout.thumbWidth);
      paramView.append(", msg.thumbHeight = ");
      paramView.append(paramGuildMsgItemLayout.thumbHeight);
      paramView.append(", adjustWidth = ");
      paramView.append(i);
      paramView.append(", adjustHeight = ");
      paramView.append(j);
      QLog.d("GuildShortVideoItemBuilder", 2, paramView.toString());
    }
    paramView = localHolder.a.getLayoutParams();
    if (paramView == null)
    {
      paramView = new RelativeLayout.LayoutParams(i, j);
      localHolder.a.setLayoutParams(paramView);
    }
    else if ((paramView.width != i) || (paramView.height != j))
    {
      paramView.width = i;
      paramView.height = j;
      localHolder.a.setLayoutParams(paramView);
    }
    paramView = localHolder.c.getLayoutParams();
    if (paramView == null)
    {
      paramView = new LinearLayout.LayoutParams(i, j);
      localHolder.c.setLayoutParams(paramView);
    }
    else if ((paramView.width != i) || (paramView.height != j))
    {
      paramView.width = i;
      paramView.height = j;
      localHolder.c.setLayoutParams(paramView);
    }
    if (SVBusiUtil.b)
    {
      SVBusiUtil.a = System.currentTimeMillis();
      SVBusiUtil.b = false;
    }
    paramView = a(i, j);
    b(localHolder);
    d(paramGuildMsgItemLayout, localHolder);
    if ((paramGuildMsgItemLayout.md5 == null) && (!paramGuildMsgItemLayout.checkIsHotVideo()) && (!paramGuildMsgItemLayout.isCancelStatus()))
    {
      a(paramGuildMsgItemLayout, localHolder, paramChatMessage, i, j);
      return paramViewHolder;
    }
    localHolder.g.setVisibility(8);
    localHolder.e.setText(ShortVideoUtils.stringForFileSize(this.b, paramGuildMsgItemLayout.videoFileSize));
    localHolder.i.setVisibility(8);
    if (!a(paramChatMessage, paramGuildMsgItemLayout, localHolder, i, j, paramView)) {
      return paramViewHolder;
    }
    b(paramGuildMsgItemLayout, localHolder);
    return paramViewHolder;
  }
  
  protected BaseGuildMsgViewBuild.ViewHolder a()
  {
    return new GuildLongVideoItemBuilder.Holder(this);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 998) {
      return;
    }
    boolean bool1 = TextUtils.isEmpty(paramMessageForShortVideo.md5);
    boolean bool2 = false;
    if ((!bool1) && (paramMessageForShortVideo.videoFileStatus != 1004))
    {
      String str = SVUtils.a(paramMessageForShortVideo, "mp4");
      boolean bool3 = NetworkUtils.isMobileConnected(this.b);
      bool1 = bool2;
      if (SVBusiUtil.a != 0L)
      {
        bool1 = bool2;
        if (System.currentTimeMillis() - SVBusiUtil.a < 300000L) {
          bool1 = true;
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startPlayVideo isConfirmed=");
        localStringBuilder.append(bool1);
        localStringBuilder.append(" allowPlayInXGTime=");
        localStringBuilder.append(SVBusiUtil.a);
        localStringBuilder.append(" isXGConnected = ");
        localStringBuilder.append(bool3);
        QLog.d("GuildShortVideoItemBuilder", 2, localStringBuilder.toString());
      }
      if ((bool3) && (!bool1) && ((!FileUtils.fileExists(str)) || (paramMessageForShortVideo.videoFileStatus == 2002)) && (paramMessageForShortVideo.videoFileSize >= 1048576))
      {
        if (!FreeWifiHelper.a((Activity)this.b, 3, new GuildLongVideoItemBuilder.8(this, paramMessageForShortVideo, paramLong, paramBoolean))) {
          break label378;
        }
        str = this.b.getString(2131915395);
        this.s = DialogUtil.a(this.b, 230, this.b.getString(2131915398), str, this.b.getString(2131915396), this.b.getString(2131915397), new GuildLongVideoItemBuilder.9(this, paramMessageForShortVideo, paramLong, paramBoolean), new GuildLongVideoItemBuilder.10(this));
        paramMessageForShortVideo = CUOpenCardGuideMng.a(this.b, this.g, 1, str);
        if ((paramMessageForShortVideo instanceof SpannableString)) {
          this.s.setMessageWithoutAutoLink(paramMessageForShortVideo);
        }
      }
    }
    try
    {
      this.s.show();
      return;
    }
    catch (Throwable paramMessageForShortVideo) {}
    b(paramMessageForShortVideo, paramLong, paramBoolean);
    ShortVideoUtils.reportVideoPlay(this.g, "0X8008E53", this.c, paramMessageForShortVideo, this.b);
    label378:
    return;
    QQToast.makeText(this.b, 2131916607, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
    return;
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, GuildLongVideoItemBuilder.Holder paramHolder)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startUploadVideo：");
      ((StringBuilder)localObject).append(paramMessageForShortVideo.toString());
      QLog.d("GuildShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool = paramMessageForShortVideo.checkIsHotVideo();
    Object localObject = paramMessageForShortVideo.videoFileName;
    String str = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if ((!FileUtils.fileExistsAndNotEmpty((String)localObject)) && (!bool))
    {
      QQToast.makeText(this.b, 1, 2131916646, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
      b(paramHolder);
      paramHolder.k.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if ((!FileUtils.fileExistsAndNotEmpty(str)) && (!bool))
    {
      QQToast.makeText(this.b, 1, 2131916647, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
      b(paramHolder);
      paramHolder.k.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    ((IOrderMediaMsgService)this.g.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsgStatus(this.c.b, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
    paramHolder = SVBusiUtil.a(1, this.a);
    paramMessageForShortVideo = ShortVideoBusiManager.a(this.a, paramMessageForShortVideo, paramHolder);
    paramMessageForShortVideo.C = bool;
    paramHolder.a(paramMessageForShortVideo);
    ShortVideoBusiManager.a(paramHolder, this.g);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, GuildLongVideoItemBuilder.Holder paramHolder, String paramString, int paramInt1, int paramInt2)
  {
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      paramHolder.e.setText("");
      if (FileUtils.fileExistsAndNotEmpty(paramString))
      {
        a(paramHolder, paramMessageForShortVideo, paramString, paramInt1, paramInt2, false);
        if (paramMessageForShortVideo.videoFileStatus == 1005)
        {
          paramHolder.c.setDrawStatus(2);
          paramHolder.g.setVisibility(8);
          return;
        }
        paramHolder.c.setDrawStatus(1);
        paramHolder.h.setVisibility(8);
        paramHolder.i.setVisibility(8);
        paramHolder.g.setVisibility(8);
        paramHolder.c.setVisibility(0);
        if ((paramMessageForShortVideo.videoFileStatus != 998) || (d(paramMessageForShortVideo)))
        {
          paramHolder = new VideoCompressProcessor.CompressTask(this.g, this.b, paramMessageForShortVideo, this.p);
          VideoCompressProcessor.a().a(paramMessageForShortVideo.uniseq, paramHolder);
          if (QLog.isColorLevel())
          {
            paramHolder = new StringBuilder();
            paramHolder.append("getBubbleView(): msg.md5 == null, start compress task, id:");
            paramHolder.append(paramMessageForShortVideo.uniseq);
            QLog.d("GuildShortVideoItemBuilder", 2, paramHolder.toString());
          }
        }
        paramMessageForShortVideo = VideoCompressProcessor.a().b(paramMessageForShortVideo.uniseq);
        if (paramMessageForShortVideo != null) {
          paramMessageForShortVideo.a(this.p);
        }
      }
    }
  }
  
  protected void a(GuildLongVideoItemBuilder.Holder paramHolder)
  {
    if (d(paramHolder))
    {
      if (QLog.isColorLevel()) {
        QLog.i("GuildShortVideoItemBuilder", 2, "disProgress...file is saving, so return!");
      }
      return;
    }
    if (a(paramHolder.q.uniseq))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("disProgress fail...video order sending! ");
        ((StringBuilder)localObject).append(paramHolder.q.uniseq);
        QLog.i("GuildShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = paramHolder.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramHolder.q.frienduin);
    localStringBuilder.append(paramHolder.q.uniseq);
    if (!((VideoProgressView)localObject).c(localStringBuilder.toString()))
    {
      paramHolder.c.setVisibility(8);
      return;
    }
    paramHolder.c.setAnimRunnableListener(new GuildLongVideoItemBuilder.2(this, paramHolder));
  }
  
  protected void a(GuildLongVideoItemBuilder.Holder paramHolder, int paramInt, boolean paramBoolean)
  {
    VideoProgressView localVideoProgressView;
    StringBuilder localStringBuilder;
    if (paramInt < 100)
    {
      paramHolder.c.setDrawStatus(1);
      localVideoProgressView = paramHolder.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramHolder.q.frienduin);
      localStringBuilder.append(paramHolder.q.uniseq);
      localVideoProgressView.setAnimProgress(paramInt, localStringBuilder.toString());
    }
    else
    {
      paramHolder.c.setDrawStatus(1);
      localVideoProgressView = paramHolder.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramHolder.q.frienduin);
      localStringBuilder.append(paramHolder.q.uniseq);
      localVideoProgressView.setAnimProgress(paramInt, localStringBuilder.toString());
    }
    paramHolder.c.setVisibility(0);
    paramHolder.c.setVideoCompressStatus(false);
    paramHolder.g.setVisibility(8);
  }
  
  public void a(GuildLongVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    b(paramHolder);
    if (c(paramHolder)) {
      return;
    }
    paramHolder = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!FileUtils.fileExistsAndNotEmpty(paramHolder))
    {
      ShortVideoReq localShortVideoReq = SVBusiUtil.a(2, this.a);
      ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.b);
      localShortVideoDownloadInfo.p = paramHolder;
      if ((paramMessageForShortVideo.istroop != 0) && (paramMessageForShortVideo.istroop != 1008))
      {
        if (paramMessageForShortVideo.istroop == 3000) {
          localShortVideoDownloadInfo.q = 1006;
        } else if (paramMessageForShortVideo.istroop == 1) {
          localShortVideoDownloadInfo.q = 1004;
        } else if (paramMessageForShortVideo.istroop == 10014) {
          localShortVideoDownloadInfo.q = 1008;
        }
      }
      else {
        localShortVideoDownloadInfo.q = 1002;
      }
      localShortVideoReq.a(localShortVideoDownloadInfo);
      localShortVideoReq.a(paramMessageForShortVideo);
      ShortVideoBusiManager.a(localShortVideoReq, this.g);
    }
  }
  
  public void a(FileMsg paramFileMsg, GuildLongVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    int i = paramFileMsg.status;
    if (i != 1007)
    {
      if (i != 5001)
      {
        if (i != 5002)
        {
          switch (i)
          {
          default: 
            switch (i)
            {
            default: 
              return;
            case 2005: 
              b(paramHolder);
              if (paramFileMsg.errorCode == -5100528) {
                break;
              }
              QQToast.makeText(this.b, 2131916641, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
              return;
            case 2004: 
              b(paramHolder);
              return;
            case 2003: 
              a(paramHolder, paramMessageForShortVideo);
              return;
            case 2002: 
              b(paramFileMsg, paramHolder, paramMessageForShortVideo);
              return;
            case 2001: 
              b(paramHolder);
              paramHolder.k.setFailedIconVisable(false, this);
              return;
            }
            break;
          case 1005: 
            paramFileMsg = new StringBuilder();
            paramFileMsg.append("<MessageProgressView> handleVideoTrans ==> FileMsg.STATUS_SEND_ERROR,  holder.mMessage.uniseq = ");
            paramFileMsg.append(paramHolder.q.uniseq);
            QLog.d("GuildShortVideoItemBuilder<gld>.video", 1, paramFileMsg.toString());
            b(paramHolder);
            paramHolder.k.setFailedIconVisable(true, this);
            VideoCompressProcessor.a().a(paramHolder.q.uniseq);
            return;
          case 1004: 
            paramFileMsg = paramHolder.c;
            paramMessageForShortVideo = new StringBuilder();
            paramMessageForShortVideo.append(paramHolder.q.frienduin);
            paramMessageForShortVideo.append(paramHolder.q.uniseq);
            paramFileMsg.b(paramMessageForShortVideo.toString());
            b(paramHolder);
            a(paramHolder, true, this);
            VideoCompressProcessor.a().a(paramHolder.q.uniseq);
            return;
          case 1003: 
            paramFileMsg = new StringBuilder();
            paramFileMsg.append("<MessageProgressView> handleVideoTrans ==> FileMsg.STATUS_SEND_FINISHED,  holder.mMessage.uniseq = ");
            paramFileMsg.append(paramHolder.q.uniseq);
            QLog.d("GuildShortVideoItemBuilder<gld>.video", 1, paramFileMsg.toString());
            a(paramHolder, 100, true);
            b(paramHolder);
            b(paramHolder, false, null);
            VideoCompressProcessor.a().a(paramHolder.q.uniseq);
            return;
          case 1002: 
            c(paramFileMsg, paramHolder, paramMessageForShortVideo);
            return;
          case 1001: 
            if (paramFileMsg.fileSize != 0L) {
              i = (int)(paramFileMsg.transferedSize * 100L / paramFileMsg.fileSize);
            } else {
              i = 0;
            }
            a(paramHolder, ShortVideoUtils.getDisplayProgress(i, 10), true);
            paramHolder.k.setFailedIconVisable(false, this);
            f(paramHolder);
            return;
          }
        }
        else
        {
          a(paramHolder, 2131915835);
          if (paramMessageForShortVideo.uiOperatorFlag == 2)
          {
            paramHolder.k.setFailedIconVisable(true, this);
            QQToast.makeText(this.b, 2131916616, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
            return;
          }
          QQToast.makeText(this.b, 2131916640, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
        }
      }
      else
      {
        a(paramHolder, 2131915834);
        if (paramMessageForShortVideo.uiOperatorFlag == 2)
        {
          paramHolder.k.setFailedIconVisable(true, this);
          QQToast.makeText(this.b, 2131916615, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
          return;
        }
        QQToast.makeText(this.b, 2131916639, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
      }
    }
    else
    {
      paramFileMsg = new StringBuilder();
      paramFileMsg.append("<MessageProgressView> handleVideoTrans ==> FileMsg.STATUS_UPLOAD_FINISHED,  holder.mMessage.uniseq = ");
      paramFileMsg.append(paramHolder.q.uniseq);
      QLog.d("GuildShortVideoItemBuilder<gld>.video", 1, paramFileMsg.toString());
      b(paramHolder);
      b(paramHolder, false, null);
      VideoCompressProcessor.a().a(paramHolder.q.uniseq);
    }
  }
  
  void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, GuildLongVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramIHttpCommunicatorListener == null)
    {
      paramHolder.k.setFailedIconVisable(true, this);
      b(paramHolder);
      if (QLog.isColorLevel())
      {
        paramIHttpCommunicatorListener = new StringBuilder();
        paramIHttpCommunicatorListener.append("getBubbleView : --> STATUS_SEND_PROCESS, 上传过程中被杀进程然后恢复, uniseq:");
        paramIHttpCommunicatorListener.append(paramMessageForShortVideo.uniseq);
        QLog.d("GuildShortVideoItemBuilder", 2, paramIHttpCommunicatorListener.toString());
      }
    }
    else
    {
      if (((IOrderMediaMsgService)this.g.getRuntimeService(IOrderMediaMsgService.class)).isMediaMsgInQueueNotHead(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq))
      {
        paramIHttpCommunicatorListener = paramHolder.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMessageForShortVideo.frienduin);
        localStringBuilder.append(paramMessageForShortVideo.uniseq);
        paramIHttpCommunicatorListener.setAnimProgress(10, localStringBuilder.toString());
        paramHolder.c.setVisibility(0);
        return;
      }
      int j = paramMessageForShortVideo.videoFileProgress;
      int i = j;
      if ((paramIHttpCommunicatorListener instanceof IShortVideoUploadProcessor))
      {
        paramIHttpCommunicatorListener = (BaseTransProcessor)paramIHttpCommunicatorListener;
        i = j;
        if (paramIHttpCommunicatorListener.getFileSize() != 0L) {
          i = (int)(paramIHttpCommunicatorListener.getTransferedSize() * 100L / paramIHttpCommunicatorListener.getFileSize());
        }
      }
      a(paramHolder, ShortVideoUtils.getDisplayProgress(i, 10), false);
    }
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    boolean bool1 = paramChatMessage.isMultiMsg;
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    bool1 = bool2;
    if (paramChatMessage.isSendFromLocal())
    {
      paramChatMessage = (MessageForShortVideo)paramChatMessage;
      if (paramChatMessage.videoFileStatus == 1005) {
        return true;
      }
      if (paramChatMessage.md5 == null) {
        return false;
      }
      int k;
      if ((paramChatMessage.uiOperatorFlag == 2) && ((paramChatMessage.videoFileStatus == 5002) || (paramChatMessage.videoFileStatus == 5001))) {
        k = 1;
      } else {
        k = 0;
      }
      int i;
      if (paramChatMessage.extraflag == 32768) {
        i = 1;
      } else {
        i = 0;
      }
      int j = i;
      if (paramChatMessage.uiOperatorFlag == 1)
      {
        j = i;
        if (paramChatMessage.videoFileStatus == 1004) {
          j = 1;
        }
      }
      if (a(paramChatMessage)) {
        j = 1;
      }
      if (k == 0)
      {
        bool1 = bool2;
        if (j == 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected boolean a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (((ITransFileController)this.g.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq) == null) {
      if (paramMessageForShortVideo.checkIsHotVideo())
      {
        if ((paramMessageForShortVideo.videoFileProgress != 100) && (paramMessageForShortVideo.videoFileStatus != 1003) && (paramMessageForShortVideo.videoFileStatus != 1004) && (paramMessageForShortVideo.videoFileStatus != 2009) && (paramMessageForShortVideo.uiOperatorFlag != 2) && (paramMessageForShortVideo.videoFileStatus != 2003) && (paramMessageForShortVideo.videoFileStatus != 2002)) {
          return true;
        }
      }
      else if ((paramMessageForShortVideo.videoFileProgress != 100) && (paramMessageForShortVideo.videoFileStatus != 1003) && (paramMessageForShortVideo.videoFileStatus != 1004) && (paramMessageForShortVideo.videoFileStatus != 2009) && (paramMessageForShortVideo.uiOperatorFlag != 2) && (paramMessageForShortVideo.videoFileStatus != 2003) && (paramMessageForShortVideo.videoFileStatus != 998) && (paramMessageForShortVideo.isAllowAutoDown == true)) {
        return true;
      }
    }
    return false;
  }
  
  protected boolean a(String paramString, MessageForShortVideo paramMessageForShortVideo, GuildLongVideoItemBuilder.Holder paramHolder, int paramInt1, int paramInt2)
  {
    int i = paramMessageForShortVideo.videoFileStatus;
    int j = 1;
    if ((i != 998) && (paramMessageForShortVideo.videoFileStatus != 1001) && (paramMessageForShortVideo.videoFileStatus != 1002) && (paramMessageForShortVideo.videoFileStatus != 1004)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((c(paramMessageForShortVideo)) && ((!paramMessageForShortVideo.isSendFromLocal()) || (i == 0)) && (!c(paramHolder)) && (!b(paramMessageForShortVideo)) && (!a(paramMessageForShortVideo.uniseq)))
    {
      Object localObject1 = SVUtils.a(paramMessageForShortVideo, "mp4");
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getBubbleView(): videoPath = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("GuildShortVideoItemBuilder", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = new File((String)localObject1);
      boolean bool2;
      if (((File)localObject2).exists())
      {
        long l2 = ((File)localObject2).length();
        long l1;
        if (paramMessageForShortVideo.videoFileTime <= 8) {
          l1 = paramMessageForShortVideo.videoFileSize;
        } else {
          l1 = ((IVideoPlayUtils)QRoute.api(IVideoPlayUtils.class)).calculateVideoPartSize(8, paramMessageForShortVideo.videoFileTime, paramMessageForShortVideo.videoFileSize);
        }
        boolean bool1;
        if (l2 < l1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("===> 1 video file  exits, downloadedSize =");
          ((StringBuilder)localObject2).append(l2);
          ((StringBuilder)localObject2).append(", estimatedSize=");
          ((StringBuilder)localObject2).append(l1);
          ((StringBuilder)localObject2).append(", needDownload=");
          ((StringBuilder)localObject2).append(bool1);
          ((StringBuilder)localObject2).append(",videoFileTime=");
          ((StringBuilder)localObject2).append(paramMessageForShortVideo.videoFileTime);
          QLog.d("GuildShortVideoItemBuilder", 2, ((StringBuilder)localObject2).toString());
          bool2 = bool1;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuildShortVideoItemBuilder", 2, "===> 2 video file no exits, need download video.");
        }
        bool2 = true;
      }
      if (bool2)
      {
        if ((NetworkUtil.isWifiConnected(this.b)) && (paramMessageForShortVideo.videoFileStatus != 5002))
        {
          localObject1 = SVBusiUtil.a(this.g, paramMessageForShortVideo, 2);
          if (localObject1 != null) {
            ShortVideoBusiManager.a((ShortVideoReq)localObject1, this.g);
          }
        }
        else
        {
          paramHolder.c.setVisibility(0);
        }
        a(paramHolder, paramMessageForShortVideo, paramString, paramInt1, paramInt2, true);
        return true;
      }
      a(paramHolder, true, paramMessageForShortVideo, (String)localObject1, null, paramString, paramInt1, paramInt2);
      if (paramMessageForShortVideo.videoFileTime <= 8) {
        paramInt1 = j;
      } else {
        paramInt1 = 0;
      }
      a(paramHolder);
      if (paramInt1 == 0) {
        paramHolder.i.setVisibility(0);
      }
      return false;
    }
    a(paramHolder, paramMessageForShortVideo, paramString, paramInt1, paramInt2, false);
    paramHolder.c.setVisibility(0);
    return true;
  }
  
  protected boolean a(String paramString, MessageForShortVideo paramMessageForShortVideo, GuildLongVideoItemBuilder.Holder paramHolder, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    if (FileUtils.fileExistsAndNotEmpty(paramString)) {
      return a(paramString, paramMessageForShortVideo, paramHolder, paramInt1, paramInt2);
    }
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      paramHolder.i.setVisibility(8);
      paramHolder.a.setID(paramMessageForShortVideo.uniseq);
      paramHolder.a.showCover(paramDrawable);
      a(paramHolder, 2131915835);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("getBubbleView not download pic : 缩略图不存在，而且文件已经过期，不下载, , uniseq:");
        paramString.append(paramMessageForShortVideo.uniseq);
        QLog.d("GuildShortVideoItemBuilder", 2, paramString.toString());
      }
    }
    else if ((paramMessageForShortVideo.extraflag != 32768) && (!c(paramHolder)))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("getBubbleView not SendFromLocal : 缩略图不存在，开始下载缩略图, , uniseq:");
        paramString.append(paramMessageForShortVideo.uniseq);
        QLog.d("GuildShortVideoItemBuilder", 2, paramString.toString());
      }
      paramHolder.a.setID(paramMessageForShortVideo.uniseq);
      paramHolder.a.showCover(paramDrawable);
      paramString = SVBusiUtil.a(2, this.a);
      paramHolder = paramMessageForShortVideo.getDownloadInfo(paramString.b);
      paramHolder.p = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      if (paramMessageForShortVideo.istroop == 10014) {
        paramHolder.q = 1008;
      }
      paramHolder.r = 2;
      paramString.a(paramHolder);
      paramString.a(paramMessageForShortVideo);
      ShortVideoBusiManager.a(paramString, this.g);
    }
    return true;
  }
  
  public void b()
  {
    super.b();
    Object localObject = this.s;
    if ((localObject != null) && (((QQCustomDialog)localObject).isShowing()))
    {
      this.s.dismiss();
      this.s = null;
    }
    localObject = r;
    if (localObject != null)
    {
      localObject = ((CopyOnWriteArraySet)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)((Iterator)localObject).next();
        if (localCropBubbleVideoView != null)
        {
          if (localCropBubbleVideoView.getCurPlayingPos() > 0L) {
            AIOSingleReporter.a().b(Integer.valueOf(localCropBubbleVideoView.getId()));
          }
          localCropBubbleVideoView.releasePlayer(false);
          r.remove(localCropBubbleVideoView);
        }
      }
    }
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, long paramLong, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("muate_play", paramBoolean);
    a(paramMessageForShortVideo, paramLong, this.b, this.g, this.c, localBundle, null);
    ThreadManager.getFileThreadHandler().post(this.w);
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo, GuildLongVideoItemBuilder.Holder paramHolder)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getBubbleView ，video no exits: sendFromLocal=");
      ((StringBuilder)localObject).append(paramMessageForShortVideo.isSendFromLocal());
      ((StringBuilder)localObject).append("===>  fileType:");
      ((StringBuilder)localObject).append(SVUtils.a(paramMessageForShortVideo.fileType));
      ((StringBuilder)localObject).append(" ===> videoFileStatus:");
      ((StringBuilder)localObject).append(SVUtils.b(paramMessageForShortVideo.videoFileStatus));
      ((StringBuilder)localObject).append("===> videoFileProgress:");
      ((StringBuilder)localObject).append(paramMessageForShortVideo.videoFileProgress);
      ((StringBuilder)localObject).append(", uniseq:");
      ((StringBuilder)localObject).append(paramMessageForShortVideo.uniseq);
      QLog.d("GuildShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = ((ITransFileController)this.g.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
    if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9) || (paramMessageForShortVideo.fileType == 19) || (paramMessageForShortVideo.fileType == 20) || (paramMessageForShortVideo.fileType == 67))
    {
      int i = paramMessageForShortVideo.videoFileStatus;
      if ((i != 2001) && (i != 2002) && (i != 2004))
      {
        if (i != 5002)
        {
          switch (i)
          {
          default: 
            return;
          case 1004: 
            paramHolder.c.setVisibility(0);
            paramMessageForShortVideo = paramHolder.c;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramHolder.q.frienduin);
            ((StringBuilder)localObject).append(paramHolder.q.uniseq);
            paramMessageForShortVideo.b(((StringBuilder)localObject).toString());
            b(paramHolder);
            a(paramHolder, true, this);
            return;
          case 1003: 
            b(paramHolder);
            return;
          case 1002: 
            a((IHttpCommunicatorListener)localObject, paramHolder, paramMessageForShortVideo);
            return;
          }
          if (localObject == null)
          {
            paramHolder.k.setFailedIconVisable(true, this);
            b(paramHolder);
            if (QLog.isColorLevel())
            {
              paramHolder = new StringBuilder();
              paramHolder.append("getBubbleView : --> STATUS_SEND_START, 上传开始被杀进程然后恢复, uniseq:");
              paramHolder.append(paramMessageForShortVideo.uniseq);
              QLog.d("GuildShortVideoItemBuilder", 2, paramHolder.toString());
            }
          }
          else
          {
            a(paramHolder, ShortVideoUtils.getDisplayProgress(paramMessageForShortVideo.videoFileProgress, 10), false);
          }
        }
        else
        {
          a(paramHolder, 2131915835);
        }
      }
      else {
        b(paramHolder);
      }
    }
  }
  
  protected void b(GuildLongVideoItemBuilder.Holder paramHolder)
  {
    if (a(paramHolder.q.uniseq))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("hideProgress fail...video order sending! ");
        ((StringBuilder)localObject).append(paramHolder.q.uniseq);
        QLog.i("GuildShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    paramHolder.g.setVisibility(8);
    Object localObject = paramHolder.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramHolder.q.frienduin);
    localStringBuilder.append(paramHolder.q.uniseq);
    if (!((VideoProgressView)localObject).c(localStringBuilder.toString()))
    {
      paramHolder.c.setDrawStatus(2);
      return;
    }
    paramHolder.c.setAnimRunnableListener(new GuildLongVideoItemBuilder.7(this, paramHolder));
  }
  
  public void b(FileMsg paramFileMsg, GuildLongVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    b(paramHolder);
    a(paramHolder);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleReceiveProcess, getAIOState() = ");
      ((StringBuilder)localObject1).append(f());
      QLog.d("GuildShortVideoItemBuilder", 2, ((StringBuilder)localObject1).toString());
    }
    if (f() != 4) {
      return;
    }
    int i;
    if ((paramFileMsg.urls != null) && (c(paramMessageForShortVideo)) && (!c(paramHolder)) && (!b(paramMessageForShortVideo)))
    {
      localObject1 = paramFileMsg.urls;
      paramFileMsg = paramFileMsg.domain;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleMessage VIDEO ==> STATUS_RECV_PROCESS: domain=");
        ((StringBuilder)localObject2).append(paramFileMsg);
        ((StringBuilder)localObject2).append(", videoUrls=");
        ((StringBuilder)localObject2).append(Arrays.toString((Object[])localObject1));
        QLog.d("GuildShortVideoItemBuilder", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      Object localObject3 = ShortVideoUtils.adjustSizeforGuild(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
      i = 0;
      int j = localObject3[0];
      int k = localObject3[1];
      while (i < 1)
      {
        if (!TextUtils.isEmpty(paramFileMsg))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(localObject1[i]);
          ((StringBuilder)localObject3).append("&txhost=");
          ((StringBuilder)localObject3).append(paramFileMsg);
          localObject1[i] = ((StringBuilder)localObject3).toString();
        }
        i += 1;
      }
      a(paramHolder, false, paramMessageForShortVideo, null, (String[])localObject1, (String)localObject2, j, k);
      if (!AIOSingleReporter.a().a(paramMessageForShortVideo, "0X80077D9"))
      {
        i = ((IVideoReporter)QRoute.api(IVideoReporter.class)).getUinMemberNum(this.g, this.c.b, this.c.a);
        paramFileMsg = new JSONObject();
      }
    }
    try
    {
      paramFileMsg.put("uin", this.c.b);
      paramFileMsg.put("memNum", i);
      paramFileMsg.put("msg_uniseq", paramMessageForShortVideo.uniseq);
      label384:
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80077D9", "0X80077D9", 0, 0, "0", "", "0", ((IVideoReporter)QRoute.api(IVideoReporter.class)).videoReportBaseR5(paramMessageForShortVideo.getMd5(), null, null, null, paramFileMsg), false);
      AIOSingleReporter.a().b(paramMessageForShortVideo, "0X80077D9");
      return;
    }
    catch (Exception paramHolder)
    {
      break label384;
    }
  }
  
  protected boolean b(View paramView)
  {
    paramView = (GuildLongVideoItemBuilder.Holder)AIOUtils.b(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.q;
    if (localMessageForShortVideo.isSendFromLocal())
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.b, null);
      localActionSheet.addButton(2131886574, 5);
      localActionSheet.addCancelButton(2131887648);
      localActionSheet.setOnButtonClickListener(new GuildLongVideoItemBuilder.1(this, localMessageForShortVideo, paramView, localActionSheet));
      localActionSheet.show();
      if (localMessageForShortVideo.videoFileStatus == 1004) {
        ShortVideoUtils.reportCancelSendVideo("0X800A374", this.c.a);
      }
    }
    return true;
  }
  
  protected String b_(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  protected void c(MessageForShortVideo paramMessageForShortVideo, GuildLongVideoItemBuilder.Holder paramHolder)
  {
    if (paramMessageForShortVideo == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reForwardVideo：");
      localStringBuilder.append(paramMessageForShortVideo.toString());
      QLog.d("GuildShortVideoItemBuilder", 2, localStringBuilder.toString());
    }
    if (!FileUtils.fileExistsAndNotEmpty(SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
    {
      QQToast.makeText(this.b, 1, 2131916647, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
      b(paramHolder);
      paramHolder.k.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
    {
      ((IOrderMediaMsgService)this.g.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsgStatus(this.c.b, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
      paramHolder = SVBusiUtil.a(4, this.a);
      paramHolder.a(ShortVideoBusiManager.b(this.a, paramMessageForShortVideo, paramHolder));
      ShortVideoBusiManager.a(paramHolder, this.g);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("GuildShortVideoItemBuilder", 2, "ShortVideoItemBuilder:reForwardVideo() path is empty");
    }
  }
  
  public void c(FileMsg paramFileMsg, GuildLongVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      int i;
      if (paramFileMsg.fileSize != 0L)
      {
        i = (int)(paramFileMsg.transferedSize * 100L / paramFileMsg.fileSize);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.e("GuildShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_SEND_PROCESS: fileSize == 0 ");
        }
        i = 0;
      }
      a(paramHolder, ShortVideoUtils.getDisplayProgress(i, 10), true);
    }
  }
  
  public void d(FileMsg paramFileMsg, GuildLongVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    int i = paramFileMsg.status;
    if (i != 2001)
    {
      int j;
      if (i != 2003)
      {
        if (i != 2005)
        {
          if (i != 5002) {
            return;
          }
          paramFileMsg = ShortVideoUtils.adjustSizeforGuild(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
          i = paramFileMsg[0];
          j = paramFileMsg[1];
          paramHolder.a.setID(paramMessageForShortVideo.uniseq);
          paramHolder.a.showCover(a(i, j));
          a(paramHolder, 2131915835);
          paramHolder.i.setVisibility(8);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("GuildShortVideoItemBuilder", 2, "handleMessage THUMB ==> STATUS_RECV_ERROR:");
        }
      }
      else
      {
        paramFileMsg = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
        Object localObject = ShortVideoUtils.adjustSizeforGuild(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
        j = localObject[0];
        int k = localObject[1];
        if ((c(paramMessageForShortVideo)) && (!c(paramHolder)) && (!b(paramMessageForShortVideo)))
        {
          localObject = SVUtils.a(paramMessageForShortVideo, "mp4");
          File localFile = new File((String)localObject);
          if (localFile.exists())
          {
            long l2 = localFile.length();
            long l1;
            if (paramMessageForShortVideo.videoFileTime <= 8) {
              l1 = paramMessageForShortVideo.videoFileSize;
            } else {
              l1 = ((IVideoPlayUtils)QRoute.api(IVideoPlayUtils.class)).calculateVideoPartSize(8, paramMessageForShortVideo.videoFileTime, paramMessageForShortVideo.videoFileSize);
            }
            if (l2 >= l1)
            {
              i = 0;
              break label277;
            }
          }
          i = 1;
          label277:
          if (i != 0)
          {
            if (NetworkUtil.isWifiConnected(this.b))
            {
              localObject = SVBusiUtil.a(this.g, paramMessageForShortVideo, 2);
              if (localObject != null) {
                ShortVideoBusiManager.a((ShortVideoReq)localObject, this.g);
              }
            }
            a(paramHolder, paramMessageForShortVideo, paramFileMsg, j, k, true);
            return;
          }
          if (paramMessageForShortVideo.videoFileTime <= 8) {
            i = 1;
          } else {
            i = 0;
          }
          a(paramHolder, true, paramMessageForShortVideo, (String)localObject, null, paramFileMsg, j, k);
          a(paramHolder);
          if (i != 0)
          {
            paramHolder.i.setVisibility(8);
            return;
          }
          paramHolder.i.setVisibility(0);
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("GuildShortVideoItemBuilder", 2, "handleMessage THUMB ==> STATUS_RECV_START:");
    }
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    try
    {
      paramView = (GuildLongVideoItemBuilder.Holder)AIOUtils.b(paramView);
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.q;
      Object localObject = paramView.c;
      if (localMessageForShortVideo.uniseq != paramFileMsg.uniseq) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleMessage msg.uniseq:");
        ((StringBuilder)localObject).append(localMessageForShortVideo.uniseq);
        ((StringBuilder)localObject).append(",fileType:");
        ((StringBuilder)localObject).append(SVUtils.a(paramFileMsg.fileType));
        ((StringBuilder)localObject).append(" ===> fileStatus:");
        ((StringBuilder)localObject).append(SVUtils.b(paramFileMsg.status));
        QLog.d("GuildShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      if (paramFileMsg.fileType == 67)
      {
        a(paramFileMsg, paramView, localMessageForShortVideo);
        return;
      }
      if (paramFileMsg.fileType == 68) {
        d(paramFileMsg, paramView, localMessageForShortVideo);
      }
      return;
    }
    catch (Exception paramView)
    {
      QLog.e("GuildShortVideoItemBuilder", 2, "handleMessage getHolder error ! ", paramView);
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    Object localObject1 = (GuildLongVideoItemBuilder.Holder)AIOUtils.b(paramView);
    q = a(paramView, (MessageForShortVideo)((GuildLongVideoItemBuilder.Holder)localObject1).q);
    AIOUtils.q = true;
    long l1 = System.currentTimeMillis();
    long l2 = t;
    if ((l1 - l2 < 1000L) && (l1 > l2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("GuildShortVideoItemBuilder", 2, "click too offen,please try again later ");
      }
      return;
    }
    t = l1;
    if ((paramView.getId() != 2131430578) && (paramView.getId() != 2131430626))
    {
      if (paramView.getId() == 2131430598)
      {
        paramView = new StringBuilder();
        if (((GuildLongVideoItemBuilder.Holder)localObject1).q.isMultiMsg) {
          return;
        }
        Object localObject2 = ((ITransFileController)this.g.getRuntimeService(ITransFileController.class)).findProcessor(((GuildLongVideoItemBuilder.Holder)localObject1).q.frienduin, ((GuildLongVideoItemBuilder.Holder)localObject1).q.uniseq);
        if (((localObject2 instanceof IShortVideoUploadProcessor)) && (((IShortVideoUploadProcessor)localObject2).isBDHSuccess()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GuildShortVideoItemBuilder", 2, "CompressTask pauseOperator!");
          }
          return;
        }
        localObject2 = VideoCompressProcessor.a().b(((GuildLongVideoItemBuilder.Holder)localObject1).q.uniseq);
        if (localObject2 != null)
        {
          ((VideoCompressProcessor.CompressTask)localObject2).a.isPause = true;
          boolean bool = ((VideoCompressProcessor.CompressTask)localObject2).cancel(true);
          paramView.append("\n ShortVideoItemBuilder task cancel:");
          paramView.append(bool);
          paramView.append("\n md5 info:");
          paramView.append(((MessageForShortVideo)((GuildLongVideoItemBuilder.Holder)localObject1).q).md5);
          if ((bool) && (((MessageForShortVideo)((GuildLongVideoItemBuilder.Holder)localObject1).q).md5 == null))
          {
            bool = ((VideoCompressProcessor.CompressTask)localObject2).a();
            paramView.append("\n media codec cancel:");
            paramView.append(bool);
            if (bool) {
              paramView.append("\n ffmpeg process cancel!");
            } else {
              paramView.append("\n ffmpeg process cancel exception!");
            }
          }
        }
        localObject1 = ((ITransFileController)this.g.getRuntimeService(ITransFileController.class)).findProcessor(((GuildLongVideoItemBuilder.Holder)localObject1).q.frienduin, ((GuildLongVideoItemBuilder.Holder)localObject1).q.uniseq);
        if ((localObject1 instanceof IShortVideoUploadProcessor))
        {
          ((BaseTransProcessor)localObject1).pause();
          paramView.append("\n upload process pause!");
        }
        ShortVideoUtils.reportCancelSendVideo("0X800A373", this.c.a);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("CompressTask pauseOperator info:");
          ((StringBuilder)localObject1).append(paramView.toString());
          QLog.d("GuildShortVideoItemBuilder", 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
    else {
      a((GuildLongVideoItemBuilder.Holder)localObject1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildLongVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */