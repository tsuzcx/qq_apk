package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
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
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ThumbInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildMsgItemLayout;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.qqvideoplatform.api.SceneID;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.shortvideo.ResultListener;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.ShortVideoPlayConfig;
import com.tencent.mobileqq.shortvideo.api.IShortVideoUploadProcessor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AIOVideoPlayController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import cooperation.peak.PeakUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class GuildShortVideoItemBuilder
  extends BaseGuildMsgViewBuild
  implements View.OnClickListener, Callback
{
  private static long D = 0L;
  public static boolean a;
  public static int l;
  public static int m;
  protected static CopyOnWriteArraySet<CropBubbleVideoView> n;
  protected static ColorDrawable o;
  protected static int p;
  protected static int q;
  protected static int r;
  protected static int s;
  protected static int t;
  private static boolean w;
  private static boolean x;
  private static Map<Long, MessageForShortVideo> y;
  private static HashMap<String, String> z;
  private Handler A = new Handler(Looper.getMainLooper());
  private ListView B;
  private MessageForShortVideo C;
  private ResultListener E = new GuildShortVideoItemBuilder.7(this);
  
  static
  {
    URLDrawableHelper.initVideoAIOSizeByDpc();
    a = true;
    l = 960;
    m = 720;
    w = false;
    x = false;
    y = new ConcurrentHashMap();
    z = new HashMap();
    n = new CopyOnWriteArraySet();
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    r = BaseChatItemLayout.f;
    r = Math.min(AIOUtils.b(320.0F, localResources), r);
    s = AIOUtils.b(100.0F, localResources);
    t = AIOUtils.b(100.0F, localResources);
    p = AIOUtils.b(CodecParam.FINAL_DST_VIDEO_WIDTH, localResources);
    q = AIOUtils.b(CodecParam.FINAL_DST_VIDEO_HEIGHT, localResources);
    o = new EmptyDrawable(-10065297, p, q);
  }
  
  public GuildShortVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (paramAIOAnimationConatiner != null) {
      this.B = paramAIOAnimationConatiner.getListView();
    }
    ShortVideoUtils.loadShortVideoSo(paramQQAppInterface);
    ShortVideoUtils.ShortVideoPlayConfig.initConfig();
    i();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo, View paramView, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, MessageForReplyText paramMessageForReplyText)
  {
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8007429", "0X8007429", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("GuildShortVideoRealItemBuilder", 2, "enterRichMediaPreview");
    }
    if (MediaPlayerManager.a(paramQQAppInterface).g()) {
      MediaPlayerManager.a(paramQQAppInterface).a(true);
    }
    paramView = AnimationUtils.a(paramView);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramView);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.G)) {
      localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", ((BaseActivity)paramContext).getChatFragment().k().aR());
    }
    if (paramSessionInfo.a == 1)
    {
      localBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      localBundle.putString("extra.GROUP_UIN", paramSessionInfo.b);
      localBundle.putString("extra.GROUP_CODE", paramSessionInfo.c);
    }
    if ((paramSessionInfo.a != 1) && (paramSessionInfo.a != 3000)) {
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
    } else {
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
    }
    if (paramMessageForReplyText != null) {
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
    } else {
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForShortVideo.isMultiMsg);
    }
    localBundle.putLong("click_video_bubble_time", System.currentTimeMillis());
    paramView = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramView.hasNext())
    {
      paramMessageForReplyText = (ActivityManager.RunningAppProcessInfo)paramView.next();
      if (paramMessageForReplyText.processName.endsWith("mobileqq")) {
        localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", paramMessageForReplyText.pid);
      }
    }
    paramMessageForReplyText = paramMessageForShortVideo.selfuin;
    paramView = paramMessageForReplyText;
    if (paramMessageForShortVideo.isMultiMsg) {}
    try
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramView = paramMessageForReplyText;
      if ((localAppRuntime instanceof QQAppInterface)) {
        paramView = localAppRuntime.getAccount();
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        int i;
        paramView = paramMessageForReplyText;
      }
    }
    localBundle.putInt("forward_source_uin_type", paramSessionInfo.a);
    localBundle.putString("uin", paramSessionInfo.b);
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
    localBundle.putBoolean("muate_play", paramBoolean1);
    localBundle.putBoolean("is_one_item", paramBoolean2);
    localBundle.putBoolean("is_ReplyMsg_From_Same_Session", paramBoolean3);
    localBundle.putBoolean(PeakUtils.b, paramBoolean4);
    if ((paramMessageForShortVideo.istroop == 0) && (com.tencent.mobileqq.util.Utils.c(paramMessageForShortVideo.senderuin)) && (!TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"))))
    {
      localBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
      localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
      PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), AIOGalleryUtils.a(paramMessageForShortVideo), 13007, i);
    }
    else
    {
      localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
      PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), AIOGalleryUtils.a(paramMessageForShortVideo), -1, i);
    }
    if (!paramMessageForShortVideo.isSend()) {
      new DCShortVideo(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.a, paramSessionInfo.b, 1001);
    }
    ShortVideoUtils.reportVideoPlay(paramQQAppInterface, "0X8008E53", paramSessionInfo, paramMessageForShortVideo, paramContext);
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, GuildShortVideoItemBuilder.Holder paramHolder, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!paramMessageForShortVideo.isSend()) {
      new DCShortVideo(BaseApplication.getContext()).a(this.g, 2001, this.c.a, this.c.b, 1002);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131911460));
    localStringBuilder.append(paramString2);
    a(paramMessageForShortVideo, localStringBuilder.toString());
    a(paramHolder.a, paramString2, paramString1, paramMessageForShortVideo, paramInt1, paramInt2);
    if ((TroopStoryUtil.a(paramHolder.q.istroop, paramHolder.q)) && (!AIOSingleReporter.a().a(paramHolder.q, "aio_msg|play_msg_video")))
    {
      AIOSingleReporter.a().b(paramHolder.q, "aio_msg|play_msg_video");
      StoryReportor.a("aio_msg", "play_msg_video", 0, 0, new String[] { "", "", "", TroopStoryUtil.a((MessageForShortVideo)paramHolder.q) });
    }
    if (!FileUtils.fileExistsAndNotEmpty(paramString1))
    {
      a(paramMessageForShortVideo);
      a(paramMessageForShortVideo, "getBubbleView: Video file exist and status finish. Thumb not exist.");
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, GuildShortVideoItemBuilder.Holder paramHolder, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = b(paramMessageForShortVideo);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      x = true;
      this.C = paramMessageForShortVideo;
      EncodeVideoTask.ThumbInfo localThumbInfo = new EncodeVideoTask.ThumbInfo(paramMessageForShortVideo.mThumbFilePath, paramMessageForShortVideo.thumbMD5, null, paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
      localObject = new EncodeVideoTask(this.g, this.b, (String)localObject, paramMessageForShortVideo.mediacodecEncode, localThumbInfo, paramMessageForShortVideo);
      EncodeVideoTask.a.put(Long.valueOf(paramMessageForShortVideo.uniseq), localObject);
      ((EncodeVideoTask)localObject).a(this.E);
      ((EncodeVideoTask)localObject).a(false);
      com.tencent.image.Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)localObject, new Void[] { (Void)null });
      ThreadManager.getUIHandler().post(new GuildShortVideoItemBuilder.9(this, paramBoolean1, paramHolder, paramMessageForShortVideo, paramBoolean2));
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GuildShortVideoRealItemBuilder");
      localStringBuilder.append("[");
      localStringBuilder.append(paramMessageRecord.uniseq);
      localStringBuilder.append("]");
      paramMessageRecord = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMessageRecord);
      localStringBuilder.append(":content ");
      localStringBuilder.append(paramString);
      QLog.i("GuildShortVideoRealItemBuilder", 2, localStringBuilder.toString());
    }
  }
  
  private void a(GuildShortVideoItemBuilder.Holder paramHolder, View paramView)
  {
    if (c(paramHolder))
    {
      if (paramHolder.e == null)
      {
        paramHolder.e = new ImageView(this.b);
        paramHolder.e.setImageResource(2130838287);
        paramHolder.e.setId(2131430598);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = AIOUtils.b(16.0F, this.b.getResources());
        localLayoutParams.addRule(8, 2131430578);
        localLayoutParams.addRule(0, 2131430578);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramHolder.e, localLayoutParams);
        }
      }
      a(paramHolder, true, this);
      return;
    }
    a(paramHolder, false, null);
  }
  
  private void a(GuildShortVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.md5 == null)
    {
      QQToast.makeText(this.b, 2131916607, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    FlowCameraMqqAction.a("", "0X8006A1C");
    StoryReportor.a("story_grp", "aio_msg", 0, 0, new String[] { "", "", "", "" });
    String str = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!FileUtils.fileExistsAndNotEmpty(SVUtils.a(paramMessageForShortVideo, "mp4")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildShortVideoRealItemBuilder", 2, "onClick, video file not exist");
      }
      if (paramMessageForShortVideo.videoFileStatus == 5002)
      {
        b(paramMessageForShortVideo, paramHolder, 2131915835);
        QQToast.makeText(this.b, 2131916640, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
      }
      else
      {
        a(paramMessageForShortVideo, false);
        a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, false);
      }
      if (!paramMessageForShortVideo.isSend()) {
        new DCShortVideo(BaseApplication.getContext()).a(this.g, 2001, this.c.a, this.c.b, 1003);
      }
    }
    else if (FileUtils.fileExistsAndNotEmpty(str))
    {
      ReportController.b(this.g, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
      if (TVK_SDKMgr.isInstalled(this.b))
      {
        a(this.g, this.b, paramMessageForShortVideo, paramHolder.a, this.c, paramBoolean, false, true, true, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GuildShortVideoRealItemBuilder", 2, "onClick, sdk is not installed");
      }
      QQToast.makeText(this.b, this.b.getResources().getString(2131895511), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299920));
    }
  }
  
  private void a(GuildShortVideoItemBuilder.Holder paramHolder, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean)
    {
      if (paramHolder.e != null)
      {
        paramHolder.e.setVisibility(0);
        paramHolder.e.setOnClickListener(paramOnClickListener);
      }
    }
    else if (paramHolder.e != null)
    {
      paramHolder.e.setVisibility(8);
      paramHolder.e.setOnClickListener(null);
    }
  }
  
  private void a(boolean paramBoolean, CropBubbleVideoView paramCropBubbleVideoView, MessageForShortVideo paramMessageForShortVideo, GuildShortVideoItemBuilder.Holder paramHolder, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(paramHolder, paramString1, paramMessageForShortVideo, paramInt1, paramInt2);
    boolean bool = FileUtils.fileExistsAndNotEmpty(paramString2);
    int i = 1;
    if ((!bool) && ((!paramMessageForShortVideo.isSend()) || (paramMessageForShortVideo.md5 != null) || (paramMessageForShortVideo.videoFileStatus != 1004)))
    {
      if (paramMessageForShortVideo.videoFileStatus == 2005) {
        c(paramMessageForShortVideo, paramHolder);
      }
      if (paramMessageForShortVideo.videoFileStatus == 5002)
      {
        a(paramMessageForShortVideo, HardCodeUtil.a(2131911451));
        b(paramMessageForShortVideo, paramHolder, 2131915835);
        return;
      }
      if (this.g.getShortVideoPredownloer().a(paramMessageForShortVideo, true))
      {
        a(paramMessageForShortVideo, true);
        return;
      }
      if ((paramMessageForShortVideo.videoFileStatus != 2001) && (paramMessageForShortVideo.videoFileStatus != 2002) && (paramMessageForShortVideo.videoFileStatus != 2000))
      {
        c(paramMessageForShortVideo, paramHolder);
        return;
      }
      a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, false);
      return;
    }
    if ((paramMessageForShortVideo.videoFileStatus != 1005) && (paramMessageForShortVideo.extraflag != 32768) && (paramMessageForShortVideo.videoFileStatus != 1004)) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    paramCropBubbleVideoView = ((ITransFileController)this.g.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
    paramInt2 = paramInt1;
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      paramInt2 = paramInt1;
      if (paramMessageForShortVideo.videoFileProgress < 100)
      {
        paramInt2 = paramInt1;
        if (paramMessageForShortVideo.videoFileStatus != 1003)
        {
          paramInt2 = paramInt1;
          if (paramCropBubbleVideoView == null) {
            paramInt2 = 1;
          }
        }
      }
    }
    if (paramInt2 != 0)
    {
      b(paramMessageForShortVideo, paramHolder, 2131915840);
      return;
    }
    if ((ShortVideoUtils.isVideoSoLibLoaded()) && (paramBoolean))
    {
      if (paramMessageForShortVideo.videoFileStatus != 1003)
      {
        if (ShortVideoUtils.getDisplayProgress(paramMessageForShortVideo.videoFileProgress, 10) <= 60) {
          paramInt1 = i;
        } else {
          paramInt1 = 0;
        }
        if ((paramMessageForShortVideo.busiType == 4601) && (paramMessageForShortVideo.subBusiType == 4602) && (paramInt1 != 0))
        {
          if (paramMessageForShortVideo.progress > 60) {
            paramMessageForShortVideo.progress = 60;
          }
          a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, paramMessageForShortVideo.progress);
          return;
        }
        a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, false);
      }
    }
    else {
      c(paramMessageForShortVideo, paramHolder);
    }
  }
  
  private boolean a(GuildShortVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, CropBubbleVideoView paramCropBubbleVideoView)
  {
    if ((TextUtils.isEmpty(paramMessageForShortVideo.md5)) && (paramMessageForShortVideo.videoFileStatus != 1005) && (paramMessageForShortVideo.extraflag != 32768) && (paramMessageForShortVideo.videoFileStatus != 1004))
    {
      if (paramMessageForShortVideo.isSendFromLocal())
      {
        String str2 = paramMessageForShortVideo.mThumbFilePath;
        String str1 = str2;
        if (!FileUtils.fileExistsAndNotEmpty(str2))
        {
          if (TextUtils.isEmpty(paramMessageForShortVideo.thumbMD5))
          {
            paramCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
            paramCropBubbleVideoView.showCover(URLDrawableHelper.getFailedDrawable());
            a(paramHolder);
            a(paramMessageForShortVideo, "getBubbleView():You must get thumb before send video.");
            return true;
          }
          str1 = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
        }
        if (a(paramCropBubbleVideoView, str1))
        {
          a(paramHolder, str1, paramMessageForShortVideo, paramInt1, paramInt2);
          b(paramHolder, paramMessageForShortVideo);
          paramHolder = this.C;
          if ((paramHolder != null) && ((paramHolder.uniseq == paramMessageForShortVideo.uniseq) || (y.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq))))) {
            paramInt1 = 0;
          } else {
            paramInt1 = 1;
          }
          if ((!paramMessageForShortVideo.mPreUpload) && (TextUtils.isEmpty(paramMessageForShortVideo.md5)) && (paramInt1 != 0) && (paramMessageForShortVideo.busiType == 4601) && (paramMessageForShortVideo.subBusiType == 4602))
          {
            if (!x)
            {
              a(paramMessageForShortVideo, null, false, true);
              return true;
            }
            if (!y.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq)))
            {
              y.put(Long.valueOf(paramMessageForShortVideo.uniseq), paramMessageForShortVideo);
              if (QLog.isColorLevel())
              {
                paramHolder = new StringBuilder();
                paramHolder.append("messageMap size:");
                paramHolder.append(y.size());
                paramHolder.append(", [");
                paramHolder.append(paramMessageForShortVideo.uniseq);
                paramHolder.append("] added, mEncoding:");
                paramHolder.append(x);
                QLog.i("GuildShortVideoRealItemBuilder", 2, paramHolder.toString());
              }
            }
          }
        }
      }
      return true;
    }
    return false;
  }
  
  private void b(long paramLong)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doEncodeNext, curMsg:");
      localObject = this.C;
      if (localObject != null) {
        localObject = Long.valueOf(((MessageForShortVideo)localObject).uniseq);
      } else {
        localObject = "";
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append(", seq:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", contains:");
      localStringBuilder.append(EncodeVideoTask.a.containsKey(Long.valueOf(paramLong)));
      QLog.i("GuildShortVideoRealItemBuilder", 2, localStringBuilder.toString());
    }
    EncodeVideoTask.a.remove(Long.valueOf(paramLong));
    Object localObject = this.C;
    if (localObject != null) {
      y.remove(Long.valueOf(((MessageForShortVideo)localObject).uniseq));
    }
    localObject = this.C;
    if ((localObject != null) && (((MessageForShortVideo)localObject).progressTask != null)) {
      this.C.progressTask = null;
    }
    x = false;
    this.C = null;
    if (y.size() != 0)
    {
      localObject = y.entrySet().iterator();
      if (((Iterator)localObject).hasNext()) {
        localObject = (MessageForShortVideo)((Map.Entry)((Iterator)localObject).next()).getValue();
      } else {
        localObject = null;
      }
      if (localObject != null)
      {
        ThreadManager.postImmediately(new GuildShortVideoItemBuilder.8(this, (MessageForShortVideo)localObject), null, true);
        y.remove(Long.valueOf(((MessageForShortVideo)localObject).uniseq));
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("messageMap size:");
          localStringBuilder.append(y.size());
          localStringBuilder.append(", [");
          localStringBuilder.append(((MessageForShortVideo)localObject).uniseq);
          localStringBuilder.append("] start upload!");
          QLog.i("GuildShortVideoRealItemBuilder", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  private void b(GuildShortVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    paramHolder = new WeakReference(paramHolder);
    if ((paramMessageForShortVideo.busiType == 1) && (paramMessageForShortVideo.subBusiType == 4602))
    {
      if (paramMessageForShortVideo.progressTask == null)
      {
        paramMessageForShortVideo.progressTask = new GuildShortVideoItemBuilder.1(this, paramMessageForShortVideo, paramHolder);
        this.A.removeCallbacks(paramMessageForShortVideo.progressTask);
        this.A.post(paramMessageForShortVideo.progressTask);
      }
    }
    else
    {
      if (paramMessageForShortVideo.mShowProgressTask == null) {
        paramMessageForShortVideo.mShowProgressTask = new GuildShortVideoItemBuilder.2(this, paramHolder, paramMessageForShortVideo);
      }
      this.A.removeCallbacks(paramMessageForShortVideo.mShowProgressTask);
      this.A.post(paramMessageForShortVideo.mShowProgressTask);
    }
  }
  
  private void b(GuildShortVideoItemBuilder.Holder paramHolder, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((paramHolder != null) && (paramHolder.k != null))
    {
      if (paramBoolean) {
        a(paramHolder, false, null);
      }
      paramHolder.k.setFailedIconVisable(paramBoolean, paramOnClickListener);
    }
  }
  
  private void c(MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.progressTask != null))
    {
      this.A.removeCallbacks(paramMessageForShortVideo.progressTask);
      paramMessageForShortVideo.progressTask = null;
    }
  }
  
  private boolean c(GuildShortVideoItemBuilder.Holder paramHolder)
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
    if ((!localMessageForShortVideo.isMultiMsg) && (localMessageForShortVideo.uiOperatorFlag != 2) && (localMessageForShortVideo.busiType == 4601) && (localMessageForShortVideo.subBusiType == 4602) && (localMessageForShortVideo.isSendFromLocal()) && (!paramHolder.k.f())) {
      j = 1;
    } else {
      j = 0;
    }
    if (QLog.isColorLevel())
    {
      paramHolder = new StringBuilder();
      paramHolder.append("shortVideoCancel needShowPauseIcon seq:");
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
      QLog.i("GuildShortVideoRealItemBuilder", 2, paramHolder.toString());
    }
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (j != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean d(MessageForShortVideo paramMessageForShortVideo)
  {
    MultiRichMediaSaveManager localMultiRichMediaSaveManager = (MultiRichMediaSaveManager)this.g.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localMultiRichMediaSaveManager != null)
    {
      paramMessageForShortVideo = localMultiRichMediaSaveManager.a(localMultiRichMediaSaveManager.a(paramMessageForShortVideo));
      if ((paramMessageForShortVideo != null) && (QLog.isColorLevel())) {
        QLog.d("GuildShortVideoRealItemBuilder", 2, "isVideoInMultiSaving = true");
      }
      bool1 = bool2;
      if (paramMessageForShortVideo != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean e(MessageForShortVideo paramMessageForShortVideo)
  {
    return AIOVideoPlayController.a().a(this.b, 2, paramMessageForShortVideo.istroop);
  }
  
  private void i()
  {
    if (!w)
    {
      localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.ShortVideoHDConfig.name(), null);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initVideoHDConfig(), shortVideoHDConfig=");
        localStringBuilder.append((String)localObject);
        QLog.d("GuildShortVideoRealItemBuilder", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length >= 3))
        {
          if (!TextUtils.isEmpty(localObject[0])) {
            a = localObject[0].equals("1");
          }
          bool = TextUtils.isEmpty(localObject[1]);
          j = 720;
          i = j;
          if (bool) {}
        }
      }
    }
    try
    {
      i = Integer.parseInt(localObject[1]);
    }
    catch (Exception localException2)
    {
      try
      {
        j = Integer.parseInt(localObject[2]);
        l = Math.max(i, j);
        m = Math.min(i, j);
        w = true;
        if (!QLog.isColorLevel()) {
          break label302;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initVideoHDConfig(), sReadHDConfig=");
        ((StringBuilder)localObject).append(w);
        ((StringBuilder)localObject).append(", sHDEnable:");
        ((StringBuilder)localObject).append(a);
        ((StringBuilder)localObject).append(", sHDMaxLength:");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(", sHDMinLength:");
        ((StringBuilder)localObject).append(m);
        QLog.d("GuildShortVideoRealItemBuilder", 2, ((StringBuilder)localObject).toString());
        return;
        localException2 = localException2;
        i = j;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          int k;
          j = k;
        }
      }
    }
    boolean bool = TextUtils.isEmpty(localObject[2]);
    k = 540;
    j = k;
    if (bool) {}
  }
  
  private boolean j()
  {
    if ((this.h != null) && ((this.h instanceof ChatXListView))) {
      return ((ChatXListView)this.h).a();
    }
    return true;
  }
  
  private void k()
  {
    try
    {
      if ((this.b != null) && ((this.b instanceof BaseActivity)))
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
    a(paramChatMessage, paramView, this);
    a((GuildShortVideoItemBuilder.Holder)paramView.getTag(), paramView);
    return paramView;
  }
  
  @NonNull
  protected View a(ChatMessage paramChatMessage, BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, GuildMsgItemLayout paramGuildMsgItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (GuildShortVideoItemBuilder.Holder)paramViewHolder;
    Object localObject2 = this.b;
    Object localObject1 = ((Context)localObject2).getResources();
    paramGuildMsgItemLayout = (MessageForShortVideo)paramChatMessage;
    paramChatMessage = ShortVideoUtils.adjustSizeforGuild(paramGuildMsgItemLayout.thumbWidth, paramGuildMsgItemLayout.thumbHeight);
    int i = paramChatMessage[0];
    int j = paramChatMessage[1];
    boolean bool = paramGuildMsgItemLayout.isSend();
    if (paramView == null)
    {
      paramChatMessage = new RelativeLayout((Context)localObject2);
      paramView = (CropBubbleVideoView)QQVideoViewFactory.createCropBubbleView(this.b, paramGuildMsgItemLayout.uniseq, null, bool);
      paramView.setId(2131427939);
      paramView.setVisibility(0);
      paramView.setRadius(6.0F);
      paramView.setContentDescription(HardCodeUtil.a(2131911484));
      paramView.setDrawTri(false);
      paramChatMessage.addView(paramView);
      MessageProgressView localMessageProgressView = new MessageProgressView((Context)localObject2);
      localMessageProgressView.setRadius(6.0F, true);
      localMessageProgressView.setShowCorner(false);
      paramChatMessage.addView(localMessageProgressView);
      ImageView localImageView = new ImageView((Context)localObject2);
      localImageView.setImageResource(2130838044);
      localImageView.setVisibility(8);
      Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131427939);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131427939);
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = AIOUtils.b(10.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject3).rightMargin = AIOUtils.b(10.0F, (Resources)localObject1);
      paramChatMessage.addView(localImageView, (ViewGroup.LayoutParams)localObject3);
      n.add(paramView);
      localObject3 = new LinearLayout((Context)localObject2);
      ((LinearLayout)localObject3).setOrientation(1);
      ((LinearLayout)localObject3).setGravity(17);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(13);
      paramChatMessage.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject2 = new TextView((Context)localObject2);
      localObject4 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject4).topMargin = AIOUtils.b(70.0F, (Resources)localObject1);
      ((TextView)localObject2).setTextColor(-1);
      ((TextView)localObject2).setTextSize(2, 12.0F);
      ((TextView)localObject2).setId(2131430624);
      ((LinearLayout)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
      paramChatMessage.setOnClickListener(this);
      super.a(paramChatMessage, paramOnLongClickAndTouchListener);
      paramViewHolder.a = paramView;
      paramViewHolder.b = localMessageProgressView;
      paramViewHolder.c = ((TextView)localObject2);
      paramViewHolder.d = localImageView;
    }
    else
    {
      paramChatMessage = paramView;
    }
    paramView = paramViewHolder.a;
    if (v) {
      paramView.setContentDescription(HardCodeUtil.a(2131911446));
    }
    paramView.mIsSend = paramGuildMsgItemLayout.isSend();
    paramView.setTag(Long.valueOf(paramGuildMsgItemLayout.uniseq));
    AIOSingleReporter.a().a(Long.valueOf(paramGuildMsgItemLayout.uniseq), paramGuildMsgItemLayout);
    paramViewHolder.c.setVisibility(8);
    a(paramViewHolder, paramGuildMsgItemLayout);
    paramOnLongClickAndTouchListener = paramViewHolder.a.getLayoutParams();
    if (paramOnLongClickAndTouchListener == null)
    {
      paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(i, j);
      paramViewHolder.a.setLayoutParams(paramOnLongClickAndTouchListener);
    }
    else if ((paramOnLongClickAndTouchListener.width != i) || (paramOnLongClickAndTouchListener.height != j))
    {
      paramOnLongClickAndTouchListener.width = i;
      paramOnLongClickAndTouchListener.height = j;
      paramViewHolder.a.setLayoutParams(paramOnLongClickAndTouchListener);
    }
    paramOnLongClickAndTouchListener = paramViewHolder.b.getLayoutParams();
    if (paramOnLongClickAndTouchListener == null)
    {
      paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(i, j);
      paramViewHolder.b.setLayoutParams(paramOnLongClickAndTouchListener);
    }
    else if ((paramOnLongClickAndTouchListener.width != i) || (paramOnLongClickAndTouchListener.height != j))
    {
      paramOnLongClickAndTouchListener.width = i;
      paramOnLongClickAndTouchListener.height = j;
      paramViewHolder.b.setLayoutParams(paramOnLongClickAndTouchListener);
    }
    a(paramGuildMsgItemLayout, paramViewHolder, (Resources)localObject1, bool);
    if (a(paramViewHolder, paramGuildMsgItemLayout, i, j, paramView)) {
      return paramChatMessage;
    }
    paramOnLongClickAndTouchListener = SVUtils.a(paramGuildMsgItemLayout.thumbMD5, "jpg");
    localObject1 = SVUtils.a(paramGuildMsgItemLayout, "mp4");
    bool = e(paramGuildMsgItemLayout);
    if ((bool) && (FileUtils.fileExistsAndNotEmpty((String)localObject1)) && ((!paramGuildMsgItemLayout.isSendFromLocal()) || (paramGuildMsgItemLayout.videoFileStatus == 1003) || (paramGuildMsgItemLayout.videoFileStatus == 2003) || (paramGuildMsgItemLayout.isMultiMsg == true)))
    {
      a(paramGuildMsgItemLayout, paramViewHolder, paramOnLongClickAndTouchListener, (String)localObject1, i, j);
      return paramChatMessage;
    }
    if (FileUtils.fileExistsAndNotEmpty(paramOnLongClickAndTouchListener))
    {
      a(bool, paramView, paramGuildMsgItemLayout, paramViewHolder, paramOnLongClickAndTouchListener, (String)localObject1, i, j);
      return paramChatMessage;
    }
    if (paramGuildMsgItemLayout.videoFileStatus == 5002)
    {
      a(paramGuildMsgItemLayout, HardCodeUtil.a(2131911477));
      paramView.setID(paramGuildMsgItemLayout.uniseq);
      paramView.showCover(o);
      b(paramGuildMsgItemLayout, paramViewHolder, 2131915835);
      return paramChatMessage;
    }
    a(paramGuildMsgItemLayout, HardCodeUtil.a(2131911498));
    paramView.setID(paramGuildMsgItemLayout.uniseq);
    paramView.showCover(o);
    a(paramGuildMsgItemLayout);
    return paramChatMessage;
  }
  
  protected BaseGuildMsgViewBuild.ViewHolder a()
  {
    return new GuildShortVideoItemBuilder.Holder(this);
  }
  
  public GuildShortVideoItemBuilder.Holder a(long paramLong)
  {
    Object localObject = this.B;
    if ((localObject != null) && (paramLong > 0L))
    {
      int i = AIOUtils.a(paramLong, ((ListView)localObject).getAdapter());
      int j = this.B.getHeaderViewsCount();
      int k = this.B.getFirstVisiblePosition();
      int i1 = this.B.getLastVisiblePosition();
      if (i > -1)
      {
        localObject = AIOUtils.a(this.B, i);
        if (localObject != null)
        {
          localObject = AIOUtils.b((View)localObject);
          if ((localObject != null) && ((localObject instanceof GuildShortVideoItemBuilder.Holder))) {
            return (GuildShortVideoItemBuilder.Holder)localObject;
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
          QLog.w("GuildShortVideoRealItemBuilder", 2, ((StringBuilder)localObject).toString());
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
          QLog.d("GuildShortVideoRealItemBuilder", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getHolderByMsg() uniseq=");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(", posi<= -1");
        QLog.w("GuildShortVideoRealItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (d(paramMessageForShortVideo)) {
      return;
    }
    ShortVideoReq localShortVideoReq = SVBusiUtil.a(2, 2);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.b);
    localShortVideoDownloadInfo.p = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 1);
    localShortVideoDownloadInfo.r = 2;
    localShortVideoDownloadInfo.s = 2;
    localShortVideoReq.a(localShortVideoDownloadInfo);
    localShortVideoReq.a(paramMessageForShortVideo);
    ShortVideoBusiManager.a(localShortVideoReq, this.g);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, long paramLong)
  {
    if ((paramMessageForShortVideo != null) && (!AIOSingleReporter.a().a(paramMessageForShortVideo, "0X8009AA6")))
    {
      AIOSingleReporter.a().b(paramMessageForShortVideo, "0X8009AA6");
      ShortVideoUtils.reportVideoPlayEvent(this.g, this.c.a, paramMessageForShortVideo.frienduin, 1, 2, paramMessageForShortVideo.videoFileTime * 1000, paramLong);
    }
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, GuildShortVideoItemBuilder.Holder paramHolder)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startUploadVideo：");
    ((StringBuilder)localObject).append(paramMessageForShortVideo.toString());
    a(paramMessageForShortVideo, ((StringBuilder)localObject).toString());
    localObject = SVUtils.a(paramMessageForShortVideo, "mp4");
    String str = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!FileUtils.fileExistsAndNotEmpty((String)localObject))
    {
      QQToast.makeText(this.b, 1, 2131916646, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
      paramHolder.k.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!FileUtils.fileExistsAndNotEmpty(str))
    {
      QQToast.makeText(this.b, 1, 2131916647, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
      paramHolder.k.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    ((IOrderMediaMsgService)this.g.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsgStatus(this.c.b, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
    localObject = SVBusiUtil.a(1, 2);
    ((ShortVideoReq)localObject).a(ShortVideoBusiManager.a(2, paramMessageForShortVideo, (ShortVideoReq)localObject));
    ShortVideoBusiManager.a((ShortVideoReq)localObject, this.g);
    a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, true);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, GuildShortVideoItemBuilder.Holder paramHolder, int paramInt)
  {
    int i = ShortVideoUtils.getDisplayProgress(paramInt, 10);
    if ((paramMessageForShortVideo.busiType == 4601) && (paramMessageForShortVideo.subBusiType == 4602))
    {
      if (i < 60) {
        return;
      }
      if (paramMessageForShortVideo.progressTask != null)
      {
        this.A.removeCallbacks(paramMessageForShortVideo.progressTask);
        paramMessageForShortVideo.progressTask = null;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("VIDEO STATUS_SEND_PROCESS CLOSE_TASK PROCESS:");
        localStringBuilder.append(i);
        a(paramMessageForShortVideo, localStringBuilder.toString());
      }
    }
    a(paramMessageForShortVideo, paramHolder, paramInt, true);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, GuildShortVideoItemBuilder.Holder paramHolder, int paramInt1, int paramInt2)
  {
    if (ShortVideoUtils.getDisplayProgress(paramMessageForShortVideo.videoFileProgress, 10) <= 60)
    {
      if (paramInt2 > 60) {
        return;
      }
      paramInt2 = ShortVideoUtils.getDisplayProgress(paramInt2, 0);
      paramHolder.b.setDrawStatus(1);
      MessageProgressView localMessageProgressView = paramHolder.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMessageForShortVideo.frienduin);
      localStringBuilder.append(paramMessageForShortVideo.uniseq);
      localMessageProgressView.setAnimProgress(paramInt2, localStringBuilder.toString());
      paramHolder.b.setVisibility(0);
      paramHolder.c.setVisibility(8);
      if ((paramMessageForShortVideo.progressTask != null) && (NetworkUtil.isNetSupport(this.b)))
      {
        paramMessageForShortVideo.progress += 3;
        this.A.postDelayed(paramMessageForShortVideo.progressTask, 1000L);
      }
      if (QLog.isColorLevel())
      {
        paramHolder = new StringBuilder();
        paramHolder.append("[setProgress] uinseq:");
        paramHolder.append(paramMessageForShortVideo.uniseq);
        paramHolder.append(", p:");
        paramHolder.append(paramInt1);
        paramHolder.append(", progress:");
        paramHolder.append(paramInt2);
        QLog.w("GuildShortVideoRealItemBuilder", 2, paramHolder.toString());
      }
    }
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, GuildShortVideoItemBuilder.Holder paramHolder, int paramInt, boolean paramBoolean)
  {
    paramHolder.b.setDrawStatus(1);
    MessageProgressView localMessageProgressView = paramHolder.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForShortVideo.frienduin);
    localStringBuilder.append(paramMessageForShortVideo.uniseq);
    localMessageProgressView.setAnimProgress(paramInt, localStringBuilder.toString());
    paramHolder.b.setVisibility(0);
    paramHolder.c.setVisibility(8);
    if (QLog.isColorLevel())
    {
      paramHolder = new StringBuilder();
      paramHolder.append("[setProgress] uinseq:");
      paramHolder.append(paramMessageForShortVideo.uniseq);
      paramHolder.append(", p:");
      paramHolder.append(paramInt);
      QLog.w("GuildShortVideoRealItemBuilder", 2, paramHolder.toString());
    }
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, GuildShortVideoItemBuilder.Holder paramHolder, Resources paramResources, boolean paramBoolean)
  {
    int i = Math.max(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
    int j = Math.min(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
    if ((a) && (i >= l) && (j >= m))
    {
      paramMessageForShortVideo = (RelativeLayout.LayoutParams)paramHolder.d.getLayoutParams();
      if (paramBoolean) {
        paramMessageForShortVideo.rightMargin = AIOUtils.b(paramHolder.a.getTriaWidth() + 8.0F, paramResources);
      } else {
        paramMessageForShortVideo.rightMargin = AIOUtils.b(8.0F, paramResources);
      }
      paramHolder.d.setVisibility(0);
      return;
    }
    paramHolder.d.setVisibility(8);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      a(paramMessageForShortVideo, HardCodeUtil.a(2131911458));
      return;
    }
    ShortVideoReq localShortVideoReq = SVBusiUtil.a(2, 2);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.b);
    localShortVideoDownloadInfo.o = SVUtils.a(paramMessageForShortVideo, "mp4");
    localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 0);
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    localShortVideoDownloadInfo.r = i;
    localShortVideoDownloadInfo.s = 2;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" startDownloadVideo downloadvideo fileType==");
      localStringBuilder.append(localShortVideoDownloadInfo.q);
      localStringBuilder.append(", uniseq:");
      localStringBuilder.append(paramMessageForShortVideo.uniseq);
      QLog.d("GuildShortVideoRealItemBuilder", 2, localStringBuilder.toString());
    }
    localShortVideoReq.a(localShortVideoDownloadInfo);
    localShortVideoReq.a(paramMessageForShortVideo);
    ShortVideoBusiManager.a(localShortVideoReq, this.g);
  }
  
  protected void a(GuildShortVideoItemBuilder.Holder paramHolder)
  {
    MessageProgressView localMessageProgressView = paramHolder.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramHolder.q.frienduin);
    localStringBuilder.append(paramHolder.q.uniseq);
    if (!localMessageProgressView.c(localStringBuilder.toString())) {
      paramHolder.b.setVisibility(8);
    } else {
      paramHolder.b.setAnimRunnableListener(new GuildShortVideoItemBuilder.5(this, paramHolder));
    }
    paramHolder.c.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("GuildShortVideoRealItemBuilder", 2, "[hideProgress] set mProgressView gone");
    }
  }
  
  protected void a(GuildShortVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo)
  {
    paramHolder.b.setSharpCornerCor(BubbleImageView.d);
    MessageProgressView localMessageProgressView = paramHolder.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForShortVideo.frienduin);
    localStringBuilder.append(paramMessageForShortVideo.uniseq);
    localMessageProgressView.a(localStringBuilder.toString());
    if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9) || (paramMessageForShortVideo.fileType == 20) || (paramMessageForShortVideo.fileType == 67))
    {
      if ((paramMessageForShortVideo.videoFileStatus != 1003) && (paramMessageForShortVideo.videoFileStatus != 2003))
      {
        paramHolder.b.setVisibility(0);
        return;
      }
      b(paramHolder);
    }
  }
  
  public void a(GuildShortVideoItemBuilder.Holder paramHolder, String paramString, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2)
  {
    if ((FileUtils.fileExistsAndNotEmpty(paramString)) && (a(paramHolder.a, paramString)))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramInt1;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      ColorDrawable localColorDrawable = o;
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      paramString = URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions);
      paramHolder.a.setID(paramMessageForShortVideo.uniseq);
      paramHolder.a.showCover(paramString);
    }
  }
  
  public void a(FileMsg paramFileMsg, GuildShortVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramFileMsg.status;
    if (i != 1007)
    {
      if (i != 5001)
      {
        if (i != 5002)
        {
          Object localObject;
          switch (i)
          {
          default: 
            switch (i)
            {
            default: 
              return;
            case 2005: 
              a(paramMessageForShortVideo, "VIDEO STATUS_RECV_ERROR");
              a(paramHolder);
              c(paramMessageForShortVideo, paramHolder);
              if (paramFileMsg.errorCode == -5100528) {
                break;
              }
              QQToast.makeText(this.b, 2131916641, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
              return;
            case 2004: 
              a(paramMessageForShortVideo, "VIDEO STATUS_RECV_CANCEL");
              return;
            case 2003: 
              paramFileMsg = new StringBuilder();
              paramFileMsg.append("VIDEO STATUS_RECV_FINISHED , getAIOState() = ");
              paramFileMsg.append(f());
              a(paramMessageForShortVideo, paramFileMsg.toString());
              if ((e(paramMessageForShortVideo)) && (f() == 4))
              {
                paramFileMsg = SVUtils.a(paramMessageForShortVideo, "mp4");
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(HardCodeUtil.a(2131911481));
                ((StringBuilder)localObject).append(paramFileMsg);
                a(paramMessageForShortVideo, ((StringBuilder)localObject).toString());
                if ((ShortVideoUtils.isVideoSoLibLoaded()) && (FileUtils.fileExistsAndNotEmpty(paramFileMsg)))
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append(HardCodeUtil.a(2131911493));
                  ((StringBuilder)localObject).append(paramFileMsg);
                  a(paramMessageForShortVideo, ((StringBuilder)localObject).toString());
                  localObject = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
                  a(paramHolder.a, paramFileMsg, (String)localObject, paramMessageForShortVideo, paramInt1, paramInt2);
                  if (!paramMessageForShortVideo.isSend()) {
                    new DCShortVideo(BaseApplication.getContext()).a(this.g, 2001, this.c.a, this.c.b, 1002);
                  }
                }
                a(paramMessageForShortVideo, paramHolder, 100, true);
                if (!paramMessageForShortVideo.isMultiMsg) {
                  break;
                }
                a(paramHolder);
                return;
              }
              a(paramHolder, SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg"), paramMessageForShortVideo, paramInt3, paramInt4);
              c(paramMessageForShortVideo, paramHolder);
              return;
            case 2002: 
              paramInt1 = paramMessageForShortVideo.videoFileProgress;
              paramFileMsg = new StringBuilder();
              paramFileMsg.append("VIDEO STATUS_RECV_PROCESS ");
              paramFileMsg.append(paramInt1);
              a(paramMessageForShortVideo, paramFileMsg.toString());
              a(paramMessageForShortVideo, paramHolder, paramInt1, true);
              return;
            case 2001: 
              a(paramMessageForShortVideo, "VIDEO STATUS_RECV_START");
              a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, true);
              return;
            }
            break;
          case 1005: 
            a(paramMessageForShortVideo, "VIDEO STATUS_SEND_ERROR");
            c(paramMessageForShortVideo);
            b(paramMessageForShortVideo, paramHolder, 2131915840);
            paramHolder.k.setFailedIconVisable(true, this);
            EncodeVideoTask.a.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
            return;
          case 1004: 
            a(paramMessageForShortVideo, "VIDEO STATUS_SEND_CANCEL");
            paramFileMsg = paramHolder.b;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramHolder.q.frienduin);
            ((StringBuilder)localObject).append(paramHolder.q.uniseq);
            paramFileMsg.b(((StringBuilder)localObject).toString());
            c(paramMessageForShortVideo);
            a(paramHolder);
            b(paramMessageForShortVideo, paramHolder, 2131915840);
            b(paramHolder, true, this);
            EncodeVideoTask.a.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
            return;
          case 1003: 
            a(paramMessageForShortVideo, "VIDEO STATUS_SEND_FINISHED");
            c(paramMessageForShortVideo);
            a(paramMessageForShortVideo.mVideoFileSourceDir);
            a(paramMessageForShortVideo, paramHolder, 100, true);
            a(paramHolder, false, null);
            EncodeVideoTask.a.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
            return;
          case 1002: 
            paramInt1 = paramMessageForShortVideo.videoFileProgress;
            paramFileMsg = new StringBuilder();
            paramFileMsg.append("VIDEO STATUS_SEND_PROCESS ");
            paramFileMsg.append(paramInt1);
            a(paramMessageForShortVideo, paramFileMsg.toString());
            a(paramMessageForShortVideo, paramHolder, paramInt1);
            return;
          case 1001: 
            paramFileMsg = new StringBuilder();
            paramFileMsg.append("VIDEO STATUS_SEND_START progress ");
            paramFileMsg.append(paramMessageForShortVideo.videoFileProgress);
            a(paramMessageForShortVideo, paramFileMsg.toString());
            if (paramMessageForShortVideo.busiType != 4601) {
              a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, true);
            }
            paramHolder.k.setFailedIconVisable(false, this);
            EncodeVideoTask.a.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
            return;
          }
        }
        else
        {
          a(paramMessageForShortVideo, "VIDEO STATUS_FILE_EXPIRED");
          a(paramHolder, SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg"), paramMessageForShortVideo, paramInt3, paramInt4);
          b(paramMessageForShortVideo, paramHolder, 2131915835);
        }
      }
      else
      {
        a(paramMessageForShortVideo, "VIDEO STATUS_FILE_UNSAFE");
        b(paramMessageForShortVideo, paramHolder, 2131915834);
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
      a(paramHolder, false, null);
      EncodeVideoTask.a.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
      paramFileMsg = new StringBuilder();
      paramFileMsg.append("VIDEO STATUS_UPLOAD_FINISHED progress ");
      paramFileMsg.append(paramMessageForShortVideo.videoFileProgress);
      a(paramMessageForShortVideo, paramFileMsg.toString());
    }
  }
  
  protected void a(CropBubbleVideoView paramCropBubbleVideoView, String paramString1, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playShortVideoByPath uniseq=");
      localStringBuilder.append(paramMessageForShortVideo.uniseq);
      localStringBuilder.append(", videoPath = ");
      String str = "null";
      if (paramString1 != null) {
        localObject = paramString1;
      } else {
        localObject = "null";
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", thumbPath = ");
      localObject = str;
      if (paramString2 != null) {
        localObject = paramString2;
      }
      localStringBuilder.append((String)localObject);
      QLog.d("GuildShortVideoRealItemBuilder", 2, localStringBuilder.toString());
    }
    paramCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
    Object localObject = new VideoPlayParam();
    ((VideoPlayParam)localObject).mSceneId = 100;
    ((VideoPlayParam)localObject).mSceneName = SceneID.getSceneStr(100);
    ((VideoPlayParam)localObject).mIsMute = true;
    ((VideoPlayParam)localObject).mCallback = new GuildShortVideoItemBuilder.3(this);
    ((VideoPlayParam)localObject).mIsLocal = true;
    ((VideoPlayParam)localObject).mIsLoop = true;
    ((VideoPlayParam)localObject).mVideoPath = paramString1;
    ((VideoPlayParam)localObject).mFileSize = paramMessageForShortVideo.videoFileSize;
    paramCropBubbleVideoView.setVideoParam((VideoPlayParam)localObject);
    paramString1 = new EmptyDrawable(-10065297, 100, 100);
    if (TextUtils.isEmpty(paramString2)) {
      paramCropBubbleVideoView.setCoverDrawable(paramString1);
    } else {
      paramCropBubbleVideoView.setCoverDrawable(URLDrawable.getDrawable(ShortVideoUtils.getThumbUrl(paramString2).toString(), paramInt1, paramInt2, paramString1, paramString1));
    }
    if (j()) {
      paramCropBubbleVideoView.play();
    }
    n.add(paramCropBubbleVideoView);
  }
  
  void a(String paramString)
  {
    ThreadManager.post(new GuildShortVideoItemBuilder.4(this, paramString), 5, null, false);
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    boolean bool2 = paramChatMessage.isMultiMsg;
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (!paramChatMessage.isSendFromLocal()) {
      return false;
    }
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    if ((paramChatMessage.md5 == null) && (paramChatMessage.videoFileStatus == 1004)) {
      return true;
    }
    if (paramChatMessage.md5 == null) {
      return false;
    }
    if (paramChatMessage.videoFileStatus == 5002) {
      return false;
    }
    if ((paramChatMessage.busiType == 4601) && (paramChatMessage.uiOperatorFlag == 1) && (paramChatMessage.videoFileStatus == 1004)) {
      return true;
    }
    IHttpCommunicatorListener localIHttpCommunicatorListener = ((ITransFileController)this.g.getRuntimeService(ITransFileController.class)).findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
    if ((localIHttpCommunicatorListener instanceof BaseTransProcessor))
    {
      if (((BaseTransProcessor)localIHttpCommunicatorListener).getFileStatus() == 1005L) {
        bool1 = true;
      }
      return bool1;
    }
    if (paramChatMessage.videoFileStatus == 1005) {
      return true;
    }
    return (paramChatMessage.videoFileProgress != 100) && (paramChatMessage.videoFileStatus != 1003) && (paramChatMessage.videoFileStatus != 2003) && (paramChatMessage.isAllowAutoDown == true);
  }
  
  protected boolean a(CropBubbleVideoView paramCropBubbleVideoView, String paramString)
  {
    paramCropBubbleVideoView = paramCropBubbleVideoView.getCoverDrawable();
    if (paramCropBubbleVideoView == null) {
      return true;
    }
    return (!(paramCropBubbleVideoView instanceof URLDrawable)) || (!((URLDrawable)paramCropBubbleVideoView).getURL().getPath().equals(paramString));
  }
  
  protected String b(MessageForShortVideo paramMessageForShortVideo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForShortVideo.mVideoFileSourceDir);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("configure.txt");
    paramMessageForShortVideo = localStringBuilder.toString();
    if (!FileUtils.fileExistsAndNotEmpty(paramMessageForShortVideo))
    {
      if (QLog.isColorLevel()) {
        QLog.i("GuildShortVideoRealItemBuilder", 2, "configure file empty!");
      }
      return null;
    }
    try
    {
      paramMessageForShortVideo = FileUtils.readFileToString(new File(paramMessageForShortVideo));
      if (paramMessageForShortVideo != null)
      {
        paramMessageForShortVideo = paramMessageForShortVideo.replaceAll("[\\t\\n\\r]", "");
        boolean bool = TextUtils.isEmpty(paramMessageForShortVideo);
        if (!bool) {
          return paramMessageForShortVideo;
        }
      }
    }
    catch (Exception paramMessageForShortVideo)
    {
      paramMessageForShortVideo.printStackTrace();
    }
    return null;
  }
  
  public void b()
  {
    super.b();
    Object localObject1 = y.values().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageForShortVideo)((Iterator)localObject1).next();
      if (((MessageForShortVideo)localObject2).progressTask != null) {
        ((MessageForShortVideo)localObject2).progressTask = null;
      }
    }
    localObject1 = n;
    if (localObject1 != null)
    {
      localObject1 = ((CopyOnWriteArraySet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CropBubbleVideoView)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          long l1 = ((CropBubbleVideoView)localObject2).getCurPlayingPos();
          if (l1 > 0L)
          {
            MessageForShortVideo localMessageForShortVideo = AIOSingleReporter.a().b(Integer.valueOf(((CropBubbleVideoView)localObject2).getId()));
            if (localMessageForShortVideo != null) {
              a(localMessageForShortVideo, l1);
            }
          }
          ((CropBubbleVideoView)localObject2).releasePlayer(false);
          n.remove(localObject2);
        }
      }
    }
    y.clear();
    this.A.removeCallbacksAndMessages(null);
    this.b = null;
    localObject1 = this.C;
    if ((localObject1 != null) && (((MessageForShortVideo)localObject1).progressTask != null)) {
      ((MessageForShortVideo)localObject1).progressTask = null;
    }
    this.B = null;
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, GuildShortVideoItemBuilder.Holder paramHolder)
  {
    if (paramMessageForShortVideo == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reForwardVideo：");
    localStringBuilder.append(paramMessageForShortVideo.toString());
    a(paramMessageForShortVideo, localStringBuilder.toString());
    if (!FileUtils.fileExistsAndNotEmpty(SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
    {
      QQToast.makeText(this.b, 1, 2131916647, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
      paramHolder.k.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
    {
      ((IOrderMediaMsgService)this.g.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsgStatus(this.c.b, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
      paramHolder = SVBusiUtil.a(4, 2);
      paramHolder.a(ShortVideoBusiManager.b(2, paramMessageForShortVideo, paramHolder));
      ShortVideoBusiManager.a(paramHolder, this.g);
      return;
    }
    a(paramMessageForShortVideo, "GuildShortVideoRealItemBuilder:reForwardVideo() path is empty");
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo, GuildShortVideoItemBuilder.Holder paramHolder, int paramInt)
  {
    MessageProgressView localMessageProgressView = paramHolder.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForShortVideo.frienduin);
    localStringBuilder.append(paramMessageForShortVideo.uniseq);
    localMessageProgressView.b(localStringBuilder.toString());
    paramHolder.b.setVisibility(0);
    paramHolder.b.setImageResource(2130851866);
    paramHolder.b.setDrawStatus(3);
    if (QLog.isColorLevel()) {
      QLog.w("GuildShortVideoRealItemBuilder", 2, "[showWarnProgress] set mProgressView visible");
    }
    paramHolder.c.setVisibility(0);
    paramHolder.c.setText(paramInt);
  }
  
  protected void b(GuildShortVideoItemBuilder.Holder paramHolder)
  {
    MessageProgressView localMessageProgressView = paramHolder.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramHolder.q.frienduin);
    localStringBuilder.append(paramHolder.q.uniseq);
    if (!localMessageProgressView.c(localStringBuilder.toString())) {
      paramHolder.b.setVisibility(8);
    } else {
      paramHolder.b.setAnimRunnableListener(new GuildShortVideoItemBuilder.6(this, paramHolder));
    }
    if (QLog.isColorLevel()) {
      QLog.w("GuildShortVideoRealItemBuilder", 2, "[disProgress] set mProgressView gone");
    }
  }
  
  public void b(FileMsg paramFileMsg, GuildShortVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramFileMsg.status;
    if (i != 2001)
    {
      if (i != 2003)
      {
        if (i != 2005)
        {
          if (i != 5002) {
            return;
          }
          a(paramMessageForShortVideo, "THUMB STATUS_FILE_EXPIRED");
        }
        a(paramMessageForShortVideo, "THUMB STATUS_RECV_ERROR");
        paramFileMsg = SVUtils.a(paramMessageForShortVideo, "mp4");
        if (FileUtils.fileExistsAndNotEmpty(paramFileMsg))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131911438));
          ((StringBuilder)localObject).append(paramFileMsg);
          a(paramMessageForShortVideo, ((StringBuilder)localObject).toString());
          if (ShortVideoUtils.isVideoSoLibLoaded())
          {
            localObject = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
            a(paramHolder.a, paramFileMsg, (String)localObject, paramMessageForShortVideo, paramInt1, paramInt2);
          }
        }
        else
        {
          paramHolder.a.setID(paramMessageForShortVideo.uniseq);
          paramHolder.a.showCover(o);
        }
        a(paramHolder);
        return;
      }
      a(paramMessageForShortVideo, "THUMB STATUS_RECV_FINISHED");
      paramFileMsg = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      Object localObject = SVUtils.a(paramMessageForShortVideo, "mp4");
      StringBuilder localStringBuilder;
      if ((FileUtils.fileExistsAndNotEmpty((String)localObject)) && (e(paramMessageForShortVideo)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131911453));
        localStringBuilder.append(paramFileMsg);
        a(paramMessageForShortVideo, localStringBuilder.toString());
        if (ShortVideoUtils.isVideoSoLibLoaded()) {
          a(paramHolder.a, (String)localObject, paramFileMsg, paramMessageForShortVideo, paramInt1, paramInt2);
        }
      }
      else
      {
        a(paramHolder, paramFileMsg, paramMessageForShortVideo, paramInt3, paramInt4);
        if (FileUtils.fileExistsAndNotEmpty(paramFileMsg))
        {
          if (a(paramHolder.a, paramFileMsg))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(HardCodeUtil.a(2131911441));
            localStringBuilder.append(paramFileMsg);
            a(paramMessageForShortVideo, localStringBuilder.toString());
            if (!FileUtils.fileExistsAndNotEmpty((String)localObject))
            {
              if (this.g.getShortVideoPredownloer().a(paramMessageForShortVideo, true))
              {
                a(paramMessageForShortVideo, true);
                return;
              }
              c(paramMessageForShortVideo, paramHolder);
              return;
            }
            if (ShortVideoUtils.isVideoSoLibLoaded())
            {
              a(paramHolder);
              return;
            }
            c(paramMessageForShortVideo, paramHolder);
          }
        }
        else
        {
          paramHolder.a.setID(paramMessageForShortVideo.uniseq);
          paramHolder.a.showCover(URLDrawableHelper.getFailedDrawable());
        }
      }
    }
    else
    {
      a(paramMessageForShortVideo, "THUMB STATUS_RECV_START");
    }
  }
  
  protected boolean b(View paramView)
  {
    g(paramView);
    return true;
  }
  
  protected String b_(ChatMessage paramChatMessage)
  {
    return HardCodeUtil.a(2131911499);
  }
  
  void c(MessageForShortVideo paramMessageForShortVideo, GuildShortVideoItemBuilder.Holder paramHolder)
  {
    MessageProgressView localMessageProgressView = paramHolder.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForShortVideo.frienduin);
    localStringBuilder.append(paramMessageForShortVideo.uniseq);
    localMessageProgressView.b(localStringBuilder.toString());
    paramHolder.b.setDrawStatus(2);
    paramHolder.b.setVisibility(0);
    paramHolder.c.setVisibility(8);
  }
  
  protected void g(View paramView)
  {
    paramView = (GuildShortVideoItemBuilder.Holder)AIOUtils.b(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.q;
    if (!localMessageForShortVideo.isSendFromLocal()) {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.b, null);
    localActionSheet.addButton(2131886574, 5);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new -..Lambda.GuildShortVideoItemBuilder.RIgcBg2EtpCfQG85x5zPgd1Wvjc(this, localMessageForShortVideo, paramView, localActionSheet));
    localActionSheet.show();
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = AIOUtils.b(paramView);
    if (!(paramView instanceof GuildShortVideoItemBuilder.Holder)) {
      return;
    }
    paramView = (GuildShortVideoItemBuilder.Holder)paramView;
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.q;
    if (localMessageForShortVideo.uniseq != paramFileMsg.uniseq) {
      return;
    }
    this.A.removeCallbacks(localMessageForShortVideo.mShowProgressTask);
    if (localMessageForShortVideo.mShowProgressTask != null) {
      localMessageForShortVideo.mShowProgressTask = null;
    }
    if (this.b == null) {
      return;
    }
    Resources localResources = this.b.getResources();
    if (localMessageForShortVideo.thumbWidth > 0) {
      paramInt1 = localMessageForShortVideo.thumbWidth;
    } else {
      paramInt1 = 100;
    }
    if (localMessageForShortVideo.thumbHeight > 0) {
      paramInt2 = localMessageForShortVideo.thumbHeight;
    } else {
      paramInt2 = 100;
    }
    int i = AIOUtils.b(paramInt1, localResources);
    int j = AIOUtils.b(paramInt2, localResources);
    if ((paramFileMsg.fileType != 6) && (paramFileMsg.fileType != 17) && (paramFileMsg.fileType != 9) && (paramFileMsg.fileType != 20) && (paramFileMsg.fileType != 67))
    {
      if ((paramFileMsg.fileType == 7) || (paramFileMsg.fileType == 18) || (paramFileMsg.fileType == 16) || (paramFileMsg.fileType == 68)) {
        b(paramFileMsg, paramView, localMessageForShortVideo, paramInt1, paramInt2, i, j);
      }
    }
    else {
      a(paramFileMsg, paramView, localMessageForShortVideo, paramInt1, paramInt2, i, j);
    }
  }
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    long l2 = D;
    if ((l1 - l2 < 1000L) && (l1 > l2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("GuildShortVideoRealItemBuilder", 2, "click too offen, please try again later!");
      }
      return;
    }
    D = l1;
    if (paramView.getId() == 2131430607)
    {
      localObject = (MessageRecord)paramView.getTag();
      if (localObject != null) {
        ((FlashChatManager)this.g.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a(paramView.getContext(), (MessageRecord)localObject);
      }
      return;
    }
    Object localObject = (GuildShortVideoItemBuilder.Holder)AIOUtils.b(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((GuildShortVideoItemBuilder.Holder)localObject).q;
    if (paramView.getId() == 2131430626) {
      return;
    }
    boolean bool2 = this.g.isVideoChatting();
    boolean bool1 = true;
    if (bool2)
    {
      QQToast.makeText(this.b, 2131893650, 1).show(this.b.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    if (paramView.getId() == 2131430578) {
      a((GuildShortVideoItemBuilder.Holder)localObject, localMessageForShortVideo, false);
    }
    if (paramView.getId() == 2131430598)
    {
      if (((GuildShortVideoItemBuilder.Holder)localObject).q.isMultiMsg) {
        return;
      }
      paramView = ((ITransFileController)this.g.getRuntimeService(ITransFileController.class)).findProcessor(((GuildShortVideoItemBuilder.Holder)localObject).q.frienduin, ((GuildShortVideoItemBuilder.Holder)localObject).q.uniseq);
      if (((paramView instanceof IShortVideoUploadProcessor)) && (((IShortVideoUploadProcessor)paramView).isBDHSuccess()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuildShortVideoRealItemBuilder", 2, "shortVideoCancel pauseOperator BDHSuccess!");
        }
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      paramView = ((ITransFileController)this.g.getRuntimeService(ITransFileController.class)).findProcessor(((GuildShortVideoItemBuilder.Holder)localObject).q.frienduin, ((GuildShortVideoItemBuilder.Holder)localObject).q.uniseq);
      if ((paramView instanceof IShortVideoUploadProcessor))
      {
        ((BaseTransProcessor)paramView).pause();
        localStringBuilder.append("\n shortVideoCancel uploadProcess pause!");
      }
      else
      {
        EncodeVideoTask localEncodeVideoTask = (EncodeVideoTask)EncodeVideoTask.a.remove(Long.valueOf(((GuildShortVideoItemBuilder.Holder)localObject).q.uniseq));
        localStringBuilder.append("\n shortVideoCancel uniseq:");
        if (localEncodeVideoTask != null) {
          paramView = Long.valueOf(localEncodeVideoTask.c.uniseq);
        } else {
          paramView = "-1";
        }
        localStringBuilder.append(paramView);
        localStringBuilder.append(", msgUniseq:");
        localStringBuilder.append(((GuildShortVideoItemBuilder.Holder)localObject).q.uniseq);
        localStringBuilder.append(", encodeFinish:");
        if ((localEncodeVideoTask == null) || (!localEncodeVideoTask.d)) {
          bool1 = false;
        }
        localStringBuilder.append(bool1);
        if ((localEncodeVideoTask != null) && (localEncodeVideoTask.c.uniseq == ((GuildShortVideoItemBuilder.Holder)localObject).q.uniseq) && (localEncodeVideoTask.b()))
        {
          this.A.removeCallbacks(localMessageForShortVideo.progressTask);
          localMessageForShortVideo.progressTask = null;
          localMessageForShortVideo.videoFileStatus = 1004;
          localMessageForShortVideo.md5 = null;
          localMessageForShortVideo.serial();
          this.g.getMessageFacade().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.istroop, localMessageForShortVideo.uniseq, localMessageForShortVideo.msgData);
          ((IOrderMediaMsgService)this.g.getRuntimeService(IOrderMediaMsgService.class)).removeMediaMsgByUniseq(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
          k();
          this.C = null;
          x = false;
        }
      }
      ShortVideoUtils.reportCancelSendVideo("0X800A7EE", this.c.a);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("shortVideoCancel pauseOperator info:");
        paramView.append(localStringBuilder.toString());
        QLog.d("GuildShortVideoRealItemBuilder", 2, paramView.toString());
      }
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildShortVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */