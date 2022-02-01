package com.tencent.mobileqq.emotionintegrate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.GalleryProgressView;
import com.tencent.component.network.utils.Base64;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.mobileqq.MsgRevokeListener;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAioHelper;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.ad.AdEmoReportUtil;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.contact.connections.TriangleView;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.IEmojiListenerManager;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.EmotionUtils;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.magicface.drawable.PngFrameDrawable;
import com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioDeviceHelper;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.AudioPlayerListener;
import com.tencent.mobileqq.qqaudio.audioplayer.CommonAudioPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.CommonAudioPlayer.UIAudioDeivceChangedListern;
import com.tencent.mobileqq.qqaudio.audioplayer.IAudioDeviceService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.RoundedColorDrawable;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.RichMediaShareActionSheetUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.DragView;
import com.tencent.widget.DragView.OnDragChangeListener;
import com.tencent.widget.DragView.OnGestureChangeListener;
import com.tencent.widget.Gallery.OnScollListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class AIOEmotionFragment
  extends AIOEmotionBaseFragment
  implements Handler.Callback, View.OnClickListener, MsgRevokeListener, EmotionDataSource.DataLoadListener, EmotionDownGIFCallback.UiCallback, EmotionGallery.OnScaleChangeListener, AudioPlayerBase.AudioPlayerListener, CommonAudioPlayer.UIAudioDeivceChangedListern, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener, DragView.OnDragChangeListener, DragView.OnGestureChangeListener, Gallery.OnScollListener
{
  private static int W;
  public static IPicEmoticonInfo d;
  public static EmoticonPreviewData e;
  PttAudioWaveView A;
  protected View B;
  SessionInfo C;
  Emoticon D;
  IPicEmoticonInfo E;
  ShareActionSheet F;
  private Rect G;
  private CommonAudioPlayer H;
  private WeakReference<URLDrawable> I = null;
  private boolean J = true;
  private boolean K = false;
  private TextView L;
  private ImageView M;
  private RelativeLayout N;
  private AIOEmotionFragment.EmoticonDetailJsonDownloader O = null;
  private List<URLDrawable> P = new ArrayList();
  private HashMap<Long, Float> Q = new HashMap();
  private float R = 1.0F;
  private int S = -1;
  private boolean T = false;
  private boolean U = false;
  private EmotionDataSource V;
  private float X;
  private int Y;
  private EmoticonObserver Z = new AIOEmotionFragment.10(this);
  final WeakReferenceHandler f = new WeakReferenceHandler(Looper.getMainLooper(), this);
  EmotionGallery g;
  EmotionAdapter h;
  TextView i;
  Button j;
  TextView k;
  TextView l;
  View m;
  ImageView n;
  ImageView o;
  ImageView p;
  GalleryProgressView q;
  ImageView r;
  DragView s;
  RelativeLayout t;
  View u;
  RelativeLayout v;
  RelativeLayout w;
  TriangleView x;
  RelativeLayout y;
  PttAudioPlayView z;
  
  private void a(int paramInt1, int paramInt2)
  {
    this.x.setDrawColor(paramInt1);
    RoundedColorDrawable localRoundedColorDrawable = new RoundedColorDrawable(paramInt1, 1, 1, AIOUtils.b(22.0F, this.b.getResources()));
    this.y.setBackgroundDrawable(localRoundedColorDrawable);
    this.z.setThemeColor(paramInt2);
    this.A.setProgressColor(paramInt2);
    this.A.postInvalidate();
  }
  
  private void a(int paramInt, EmoticonPreviewData paramEmoticonPreviewData)
  {
    paramEmoticonPreviewData = paramEmoticonPreviewData.d();
    if (paramEmoticonPreviewData != null)
    {
      float f2 = this.g.getSelectChildScale();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateEmotionOcr scale=");
        ((StringBuilder)localObject).append(f2);
        ((StringBuilder)localObject).append("originalScale=");
        ((StringBuilder)localObject).append(f2);
        QLog.d("AIOEmotionFragment", 2, ((StringBuilder)localObject).toString());
      }
      float f1;
      if (this.Q.containsKey(this.h.c(paramInt))) {
        f1 = ((Float)this.Q.get(this.h.c(paramInt))).floatValue();
      } else {
        f1 = f2;
      }
      if ((f1 > 0.0F) && (f2 <= f1))
      {
        this.v.setVisibility(0);
        this.i.setVisibility(0);
        this.j.setVisibility(0);
      }
      if (!TextUtils.isEmpty(paramEmoticonPreviewData.modifyWord)) {
        paramEmoticonPreviewData = paramEmoticonPreviewData.modifyWord;
      } else {
        paramEmoticonPreviewData = paramEmoticonPreviewData.ocrWord;
      }
      if (TextUtils.isEmpty(paramEmoticonPreviewData))
      {
        this.i.setTextColor(this.b.getResources().getColor(2131168133));
        this.i.setText(this.b.getResources().getString(2131888898));
      }
      else
      {
        this.i.setTextColor(this.b.getResources().getColor(2131165564));
        this.i.setText(paramEmoticonPreviewData);
      }
      this.g.bringToFront();
      if ((h()) && (SharedPreUtils.cf(this.b, c().getCurrentUin())))
      {
        SharedPreUtils.p(this.b, c().getCurrentUin(), false);
        paramEmoticonPreviewData = new LinearLayout(this.b);
        paramEmoticonPreviewData.setOrientation(1);
        paramEmoticonPreviewData.setGravity(1);
        localObject = new ImageView(this.b);
        ((ImageView)localObject).setImageDrawable(this.b.getResources().getDrawable(2130839047));
        paramEmoticonPreviewData.addView((View)localObject);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
        localLayoutParams.bottomMargin = (-AIOUtils.b(7.0F, this.b.getResources()));
        localLayoutParams.topMargin = AIOUtils.b(3.0F, this.b.getResources());
        ((ImageView)localObject).setLayoutParams(localLayoutParams);
        localObject = new TextView(this.b);
        ((TextView)localObject).setTextColor(this.b.getResources().getColor(2131168464));
        ((TextView)localObject).setTextSize(14.0F);
        ((TextView)localObject).setGravity(17);
        ((TextView)localObject).setText(this.b.getResources().getString(2131888909));
        ((TextView)localObject).setBackgroundResource(2130839051);
        paramEmoticonPreviewData.addView((View)localObject);
        paramInt = AIOUtils.b(7.0F, this.b.getResources());
        ((TextView)localObject).setPadding(paramInt, 0, paramInt, 0);
        paramEmoticonPreviewData = new PopupWindow(paramEmoticonPreviewData, -2, -2);
        paramEmoticonPreviewData.setBackgroundDrawable(new ColorDrawable(0));
        paramEmoticonPreviewData.setOutsideTouchable(true);
        paramEmoticonPreviewData.setFocusable(true);
        ((TextView)localObject).measure(0, 0);
        this.i.post(new AIOEmotionFragment.4(this, paramEmoticonPreviewData, (TextView)localObject));
      }
    }
  }
  
  public static void a(Context paramContext, MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, Rect paramRect)
  {
    a(paramContext, paramMessageRecord, paramSessionInfo, paramRect, true, true);
  }
  
  public static void a(Context paramContext, MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    W = 0;
    boolean bool3 = paramContext instanceof ChatHistoryActivity;
    boolean bool1;
    if ((!bool3) && (!(paramContext instanceof ChatHistory)))
    {
      bool1 = bool2;
      if ((paramContext instanceof PublicFragmentActivity))
      {
        bool1 = bool2;
        if (!(((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    g();
    if (paramRect != null)
    {
      paramRect.top -= ImmersiveUtils.getStatusBarHeight(paramContext);
      paramRect.bottom -= ImmersiveUtils.getStatusBarHeight(paramContext);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enterEmotionPreview, type:");
      if (MessageForMarketFace.class.isInstance(paramMessageRecord)) {
        localObject = "Emotion";
      } else {
        localObject = "GIF";
      }
      localStringBuilder.append((String)localObject);
      QLog.i("AIOEmotionFragment", 2, localStringBuilder.toString());
    }
    e = new MsgEmoticonPreviewData(paramMessageRecord);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("session_info", paramSessionInfo);
    ((Intent)localObject).putExtra("from_chat_history", bool1);
    ((Intent)localObject).putExtra("hide_emo_position", paramBoolean1);
    ((Intent)localObject).putExtra("need_reload_data", paramBoolean2);
    ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
    if (paramRect != null) {
      ((Intent)localObject).putExtra("KEY_THUMBNAL_BOUND", paramRect);
    }
    if ((paramContext instanceof ChatHistory))
    {
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatHistory.class.getName());
    }
    else if (((paramContext instanceof MultiForwardActivity)) && (paramMessageRecord.isMultiMsg))
    {
      paramMessageRecord = (MultiForwardActivity)paramContext;
      if (paramMessageRecord.getIntent() != null)
      {
        ((Intent)localObject).putExtra("key_multi_forward_seq", paramMessageRecord.getIntent().getLongExtra("origin_merge_structing_msg_uniseq", 0L));
        ((Intent)localObject).putExtra("key_is_multi_forward_msg", true);
      }
    }
    if (bool3) {
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatHistoryActivity.class.getName());
    }
    if ((ChatHistoryActivity.a(paramContext, (Intent)localObject)) && ((paramContext instanceof Activity)))
    {
      PublicFragmentActivity.Launcher.a((Activity)paramContext, (Intent)localObject, PublicTransFragmentActivity.class, AIOEmotionFragment.class, 38);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      PublicFragmentActivity.Launcher.a(paramContext, (Intent)localObject, PublicTransFragmentActivity.class, AIOEmotionFragment.class);
      return;
    }
    PublicFragmentActivity.Launcher.a((Intent)localObject, PublicTransFragmentActivity.class, AIOEmotionFragment.class);
  }
  
  public static void a(Context paramContext, EmoticonInfo paramEmoticonInfo, Rect paramRect)
  {
    Intent localIntent = new Intent();
    if (paramRect != null)
    {
      paramRect.top -= ImmersiveUtils.getStatusBarHeight(paramContext);
      paramRect.bottom -= ImmersiveUtils.getStatusBarHeight(paramContext);
      localIntent.putExtra("KEY_THUMBNAL_BOUND", paramRect);
    }
    g();
    if (QLog.isColorLevel()) {
      QLog.i("AIOEmotionFragment", 2, "enterEmotionPreview, type: FAV");
    }
    W = 1;
    e = new FavEmoticonPreviewData(paramEmoticonInfo);
    localIntent.putExtra("from_chat_history", false);
    localIntent.putExtra("public_fragment_window_feature", 1);
    if ((paramContext instanceof Activity))
    {
      PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicTransFragmentActivity.class, AIOEmotionFragment.class);
      return;
    }
    PublicFragmentActivity.Launcher.a(localIntent, PublicTransFragmentActivity.class, AIOEmotionFragment.class);
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (this.O == null) {
      this.O = new AIOEmotionFragment.EmoticonDetailJsonDownloader(this);
    }
    if ((this.E != null) && (this.D != null))
    {
      this.O.a(paramInt, paramQQAppInterface, getBaseActivity(), this.E, this.C, null);
      paramQQAppInterface = (IEmojiManagerService)paramQQAppInterface.getRuntimeService(IEmojiManagerService.class);
      paramQQAppInterface.getEmojiListenerManager().addEmotionJsonDownloadListener(this.O);
      paramQQAppInterface.startDownloadEmosmJson(this.D.epId, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
      return;
    }
    QLog.d("AIOEmotionFragment", 1, "error in json downloading");
    a(false);
  }
  
  private void a(EmoticonInfo paramEmoticonInfo)
  {
    Object localObject = this.D;
    int i2 = 1;
    int i1;
    if ((localObject != null) && (((Emoticon)localObject).jobType != 2)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((i1 != 0) && (paramEmoticonInfo != null))
    {
      a("0X800997E");
      if (((paramEmoticonInfo instanceof IPicEmoticonInfo)) && (((IPicEmoticonInfo)paramEmoticonInfo).isNewSoundType())) {
        this.o.setVisibility(0);
      } else {
        this.o.setVisibility(8);
      }
      this.m.setVisibility(0);
      this.m.setClickable(true);
      this.m.setOnTouchListener(new AIOEmotionFragment.7(this));
      paramEmoticonInfo = paramEmoticonInfo.getDrawable(getBaseActivity(), this.b.getResources().getDisplayMetrics().density);
      this.n.setImageDrawable(paramEmoticonInfo);
      paramEmoticonInfo = null;
      localObject = EmotionDataManager.a(this.D.epId);
      if (localObject != null) {
        paramEmoticonInfo = ((EmoticonPackage)localObject).name;
      }
      localObject = c();
      if (localObject != null)
      {
        if (!TextUtils.isEmpty(paramEmoticonInfo))
        {
          if (paramEmoticonInfo.length() > 11)
          {
            TextView localTextView = this.k;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramEmoticonInfo.substring(0, 10));
            localStringBuilder.append("...");
            localTextView.setText(localStringBuilder.toString());
          }
          else
          {
            this.k.setText(paramEmoticonInfo);
          }
        }
        else {
          a((QQAppInterface)localObject, 4);
        }
        if (((IEmoticonManagerService)((QQAppInterface)localObject).getRuntimeService(IEmoticonManagerService.class)).isEpidInTabcache(this.D.epId))
        {
          i1 = i2;
          break label297;
        }
      }
      i1 = 0;
      label297:
      if (i1 != 0)
      {
        this.l.setText(HardCodeUtil.a(2131898289));
        this.l.setTextColor(-7829368);
        return;
      }
      this.l.setText(HardCodeUtil.a(2131898288));
      this.l.setTextColor(-16777216);
      return;
    }
    this.m.setVisibility(4);
  }
  
  private void a(MsgEmoticonPreviewData paramMsgEmoticonPreviewData)
  {
    a("0X800A7E6");
    paramMsgEmoticonPreviewData = (MessageForPic)paramMsgEmoticonPreviewData.a;
    int i1 = paramMsgEmoticonPreviewData.picExtraData.from;
    this.g.bringToFront();
    if (!TextUtils.isEmpty(paramMsgEmoticonPreviewData.picExtraData.source)) {
      if (paramMsgEmoticonPreviewData.picExtraData.source.length() > 11)
      {
        localObject = this.k;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMsgEmoticonPreviewData.picExtraData.source.substring(0, 10));
        localStringBuilder.append("...");
        ((TextView)localObject).setText(localStringBuilder.toString());
      }
      else
      {
        this.k.setText(paramMsgEmoticonPreviewData.picExtraData.source);
      }
    }
    this.m.setVisibility(0);
    this.m.setClickable(true);
    this.m.setOnTouchListener(new AIOEmotionFragment.5(this, i1, paramMsgEmoticonPreviewData));
    if (i1 == 1)
    {
      if (((IEmoticonManagerService)c().getRuntimeService(IEmoticonManagerService.class)).isEpidInTabcache(paramMsgEmoticonPreviewData.picExtraData.emojiPkgId))
      {
        this.l.setText(this.b.getResources().getString(2131886491));
        this.l.setTextColor(-7829368);
      }
      else
      {
        this.l.setText(this.b.getResources().getString(2131886492));
        this.l.setTextColor(-16777216);
      }
    }
    else
    {
      this.l.setText(this.b.getResources().getString(2131886493));
      this.l.setTextColor(-16777216);
    }
    paramMsgEmoticonPreviewData = PicItemBuilder.f(paramMsgEmoticonPreviewData);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = this.Y;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    paramMsgEmoticonPreviewData = URLDrawable.getDrawable(paramMsgEmoticonPreviewData, (URLDrawable.URLDrawableOptions)localObject);
    this.n.setImageDrawable(paramMsgEmoticonPreviewData);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 9);
      localBundle.putBoolean("forward_emotion_from_preview", true);
      Intent localIntent = new Intent();
      localIntent.putExtras(localBundle);
      this.F.setIntentForStartForwardRecentActivity(localIntent);
    }
    this.F.show();
  }
  
  private boolean a(IPicEmoticonInfo paramIPicEmoticonInfo)
  {
    if (paramIPicEmoticonInfo != null)
    {
      if (!paramIPicEmoticonInfo.isNewSoundType()) {
        return false;
      }
      if (paramIPicEmoticonInfo.getWaveformArray() == null) {
        return false;
      }
      this.w.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.A.getLayoutParams();
      QLog.d("AIOEmotionFragment", 2, "tryUpdateNewAudioEmoAudioInfo");
      this.A.setProgress(0.0F);
      this.A.setMaxTopBottomPadding(4);
      localLayoutParams.width = AIOUtils.b(39.0F, this.b.getResources());
      this.A.setAudioData(paramIPicEmoticonInfo.getWaveformArray(), AIOUtils.b(39.0F, this.b.getResources()), paramIPicEmoticonInfo.getVoiceLength());
      a(paramIPicEmoticonInfo.getWaveBackgroundColor(), paramIPicEmoticonInfo.getWaveForegroundColor());
      return true;
    }
    return false;
  }
  
  private void b(MsgEmoticonPreviewData paramMsgEmoticonPreviewData)
  {
    Object localObject = (MessageForPic)paramMsgEmoticonPreviewData.a;
    this.g.bringToFront();
    this.k.setText(this.b.getResources().getString(2131888852));
    this.m.setVisibility(0);
    this.m.setClickable(true);
    this.m.setOnTouchListener(new AIOEmotionFragment.6(this, paramMsgEmoticonPreviewData));
    this.l.setText(this.b.getResources().getString(2131889832));
    paramMsgEmoticonPreviewData = PicItemBuilder.f((MessageForPic)localObject);
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = this.Y;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    paramMsgEmoticonPreviewData = URLDrawable.getDrawable(paramMsgEmoticonPreviewData, (URLDrawable.URLDrawableOptions)localObject);
    this.n.setImageDrawable(paramMsgEmoticonPreviewData);
  }
  
  private static void g()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      localObject = (QQAppInterface)localObject;
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = MediaPlayerManager.a((AppRuntime)localObject);
      if (((((MediaPlayerManager)localObject).f() instanceof MessageForMarketFace)) && (((MediaPlayerManager)localObject).g())) {
        ((MediaPlayerManager)localObject).a(true);
      }
    }
  }
  
  private boolean h()
  {
    float f1 = this.g.getSelectChildScale();
    if ((this.Q.containsKey(this.h.c(this.S))) && (f1 != ((Float)this.Q.get(this.h.c(this.S))).floatValue())) {
      return true;
    }
    Object localObject = this.g.getSelectedView();
    if ((localObject instanceof ImageView))
    {
      localObject = ((ImageView)localObject).getDrawable();
      if (localObject != null)
      {
        int i1;
        if ((localObject instanceof PngFrameDrawable)) {
          i1 = AIOUtils.b(100.0F, this.b.getResources());
        } else {
          i1 = ((Drawable)localObject).getIntrinsicHeight();
        }
        this.R = f1;
        localObject = (RelativeLayout.LayoutParams)this.v.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(i1 * f1 / 2.0F) + AIOUtils.b(5.0F, this.b.getResources()));
        this.v.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("AIOEmotionFragment", 2, new Object[] { "updateEmotionNameLayout scale:", Float.valueOf(f1), " topMargin:", Integer.valueOf(((RelativeLayout.LayoutParams)localObject).topMargin) });
        }
        return i1 > 0;
      }
    }
    return false;
  }
  
  private void i()
  {
    Object localObject = (EmoticonPreviewData)this.g.getSelectedItem();
    if (!(localObject instanceof MsgEmoticonPreviewData)) {
      return;
    }
    localObject = ((MsgEmoticonPreviewData)localObject).a;
    ChatHistoryActivity.a(getBaseActivity(), this.C.b, this.C.a, this.C.e, ((MessageRecord)localObject).uniseq);
  }
  
  private void j()
  {
    Object localObject1;
    if (this.H == null)
    {
      this.H = new CommonAudioPlayer(this.b, this);
      this.H.s();
      this.H.a(this);
      localObject1 = c();
      if (localObject1 != null) {
        ((IAudioDeviceService)((QQAppInterface)localObject1).getRuntimeService(IAudioDeviceService.class)).registerAudioDeviceListener(this.H);
      }
    }
    this.H.d();
    if (this.E != null)
    {
      Object localObject2 = EmotionPanelConstans.emoticonSoundPath.replace("[epId]", this.E.getEmoticon().epId).replace("[eId]", this.E.getEmoticon().eId);
      boolean bool3 = false;
      this.K = false;
      localObject1 = c();
      if (localObject1 != null)
      {
        this.J = AudioDeviceHelper.a((AppRuntime)localObject1);
        MediaPlayerManager localMediaPlayerManager = MediaPlayerManager.a((AppRuntime)localObject1);
        if (localMediaPlayerManager.g()) {
          localMediaPlayerManager.a(true);
        }
      }
      boolean bool4 = AudioDeviceHelper.a(BaseApplicationImpl.getContext());
      boolean bool2 = AudioDeviceHelper.b(BaseApplicationImpl.getContext());
      this.H.a(1);
      boolean bool1;
      if (this.H.a((String)localObject2))
      {
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (bool4) {
            bool1 = AudioDeviceHelper.c(BaseApplicationImpl.getContext());
          }
        }
        AudioPanelAioHelper.a(getBaseActivity(), this.J, bool4, bool1);
        bool2 = bool3;
        if (!bool4)
        {
          bool2 = bool3;
          if (!bool1) {
            bool2 = true;
          }
        }
        b(bool2, this.J);
        localObject2 = getBaseActivity();
        if (localObject2 != null) {
          ((Activity)localObject2).getWindow().addFlags(128);
        }
        localObject2 = this.I;
        if (localObject2 != null)
        {
          localObject2 = (URLDrawable)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            EmotionUtils.startSoundDrawablePlay((URLDrawable)localObject2);
          }
        }
        this.A.setProgress(0.0F);
        this.z.setPlayState(true);
        bool1 = true;
      }
      else
      {
        bool1 = false;
      }
      if (!bool1) {
        EmoticonOperateReport.reportNewSoundEvent((AppInterface)localObject1, "0X800A935", -1, this.E.getEmoticon().epId);
      }
      localObject2 = new HashMap();
      if (bool1) {
        localObject1 = "0";
      } else {
        localObject1 = "1";
      }
      ((HashMap)localObject2).put("playResult", localObject1);
      ((HashMap)localObject2).put("playType", "2");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "NewAudioEmoticonVoicePlay", bool1, 0L, 0L, (HashMap)localObject2, null);
    }
  }
  
  private boolean k()
  {
    CommonAudioPlayer localCommonAudioPlayer = this.H;
    if (localCommonAudioPlayer == null) {
      return false;
    }
    return localCommonAudioPlayer.m();
  }
  
  private void l()
  {
    if (this.H != null)
    {
      m();
      this.H.d();
    }
  }
  
  private void m()
  {
    this.A.setProgress(0.0F);
    this.z.setPlayState(false);
    b(false, false);
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity != null) {
      localBaseActivity.getWindow().clearFlags(128);
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2131624093, paramViewGroup, false);
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onScaleEnd scale:");
      ((StringBuilder)localObject).append(paramFloat);
      QLog.d("AIOEmotionFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.f.obtainMessage(1002);
    Long localLong = this.h.c(this.g.getSelectedItemPosition());
    float f1;
    if (this.Q.containsKey(localLong)) {
      f1 = ((Float)this.Q.get(localLong)).floatValue();
    } else {
      f1 = this.g.getSelectChildScale();
    }
    int i1;
    if (paramFloat > f1) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    ((Message)localObject).arg1 = i1;
    this.f.sendMessage((Message)localObject);
  }
  
  public void a(int paramInt, MessageForPic paramMessageForPic)
  {
    this.q.a(paramInt / 100);
  }
  
  protected void a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    Object localObject2 = c();
    if (localObject2 == null)
    {
      QLog.d("AIOEmotionFragment", 1, "error runtime");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleClickMenuItem, action:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("AIOEmotionFragment", 1, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (EmoticonPreviewData)this.g.getSelectedItem();
    if (!(localObject1 instanceof MsgEmoticonPreviewData)) {
      return;
    }
    MessageRecord localMessageRecord = ((MsgEmoticonPreviewData)localObject1).a;
    boolean bool3 = localMessageRecord instanceof MessageForMarketFace;
    boolean bool2 = false;
    boolean bool1 = false;
    int i1;
    if (bool3) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (paramInt != 2) {
      if (paramInt != 39)
      {
        localObject1 = null;
        if (paramInt != 48)
        {
          if (paramInt != 54)
          {
            if (paramInt != 166)
            {
              if (paramInt != 65)
              {
                if (paramInt != 66)
                {
                  if (paramInt != 72)
                  {
                    if (paramInt == 73) {}
                  }
                  else
                  {
                    localObject1 = new Bundle();
                    ((Bundle)localObject1).putInt("key_req", 1);
                    ((Bundle)localObject1).putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
                    ((Bundle)localObject1).putString("key_direct_show_uin", paramActionSheetItem.uin);
                    if (i1 == 0)
                    {
                      paramActionSheetItem = this.E;
                      if (paramActionSheetItem == null)
                      {
                        QLog.e("AIOEmotionFragment", 2, "ACTION_SEND_TO_SPECIFIED_FRIEND mPicEmotionInfo is null");
                        return;
                      }
                      d = paramActionSheetItem;
                      paramActionSheetItem = new Intent();
                      localObject2 = new Bundle();
                      ((Bundle)localObject2).putInt("forward_type", 9);
                      ((Bundle)localObject2).putBoolean("forward_emotion_from_preview", true);
                      paramActionSheetItem.putExtras((Bundle)localObject2);
                      paramActionSheetItem.putExtras((Bundle)localObject1);
                      ForwardBaseOption.a(super.getBaseActivity(), paramActionSheetItem, ForwardRecentTranslucentActivity.class, 21, 100500, "biz_src_jc_gif");
                      return;
                    }
                    ((Bundle)localObject1).putBoolean("key_help_forward_pic", true);
                    paramActionSheetItem = PicItemBuilder.b((MessageForPic)localMessageRecord, this.C, (QQAppInterface)localObject2, this.b);
                    paramActionSheetItem.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getBaseActivity().getClass().getName());
                    paramActionSheetItem.putExtras((Bundle)localObject1);
                    ForwardBaseOption.a(super.getBaseActivity(), paramActionSheetItem, ForwardRecentTranslucentActivity.class, 1, 100500, "biz_src_jc_gif");
                  }
                }
                else
                {
                  if (AnonymousChatHelper.c(localMessageRecord))
                  {
                    paramActionSheetItem = AnonymousChatHelper.g(localMessageRecord);
                    if ((paramActionSheetItem.b == null) && (paramActionSheetItem.a != 2))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.i("AIOEmotionFragment", 2, "Anonymous report : an_id is null");
                      }
                      return;
                    }
                    localObject1 = paramActionSheetItem.a();
                    if ((localObject1 == null) || (paramActionSheetItem.a == 2)) {
                      return;
                    }
                    paramActionSheetItem = URLEncoder.encode(Base64.encodeToString((byte[])localObject1, 2));
                    AnonymousChatHelper.a().a(localMessageRecord.frienduin, paramActionSheetItem, localMessageRecord);
                    NewReportPlugin.a((QQAppInterface)localObject2, localMessageRecord.frienduin, paramActionSheetItem, ((QQAppInterface)localObject2).getCurrentAccountUin(), AnonymousChatHelper.a().a(localMessageRecord.frienduin, paramActionSheetItem));
                    return;
                  }
                  paramActionSheetItem = localMessageRecord.senderuin;
                  NewReportPlugin.a((BaseActivity)this.b, paramActionSheetItem, localMessageRecord.frienduin, ((QQAppInterface)localObject2).getCurrentAccountUin(), NewReportPlugin.b(this.C.a), null);
                }
              }
              else
              {
                if ((this.C.a != 1) && (this.C.a != 3000)) {
                  paramInt = 1;
                } else {
                  paramInt = 2;
                }
                ReportController.b(null, "dc00898", "", "", "0X8009EA7", "0X8009EA7", paramInt, 0, "", "", "", "");
                i();
              }
            }
            else
            {
              if ((localMessageRecord instanceof MessageForPic)) {
                paramActionSheetItem = URLDrawableHelper.getURL((MessageForPic)localMessageRecord, 1);
              } else {
                paramActionSheetItem = null;
              }
              if (paramActionSheetItem != null) {
                localObject1 = paramActionSheetItem.toString();
              }
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                return;
              }
              paramActionSheetItem = AbsDownloader.getFile((String)localObject1);
              if (paramActionSheetItem == null) {
                return;
              }
              ((IMiniAppFileMaterialService)QRoute.api(IMiniAppFileMaterialService.class)).showSupportedAppList((Activity)this.b, paramActionSheetItem.getAbsolutePath(), "image/*");
            }
          }
          else
          {
            if (getBaseActivity().getIntent().getBooleanExtra("from_chat_history", false)) {
              paramInt = 2;
            } else {
              paramInt = 1;
            }
            ReportController.b(null, "dc00898", "", "", "0X8009EA8", "0X8009EA8", paramInt, 0, "", "", "", "");
            localObject1 = this.C.c;
            paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramActionSheetItem = this.C.b;
            }
            AIOGalleryScene.a(getBaseActivity(), this.C.a, this.C.b, paramActionSheetItem, localMessageRecord.time, localMessageRecord.shmsgseq, localMessageRecord.istroop, true);
          }
        }
        else
        {
          a("0X8009982");
          if ((localMessageRecord instanceof MessageForPic))
          {
            paramActionSheetItem = (MessageForPic)localMessageRecord;
            PicItemBuilder.a((QQAppInterface)localObject2, paramActionSheetItem.senderuin, paramActionSheetItem.md5, "0X8009F3E", "");
          }
          if (i1 == 0)
          {
            if ((this.D != null) && (this.E != null))
            {
              ((IEmoticonManagerService)((QQAppInterface)localObject2).getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(this.D.epId, new AIOEmotionFragment.9(this, (QQAppInterface)localObject2));
              EmoticonOperateReport.reportFavAddEmotionEvent((AppInterface)localObject2, 2, null, this.D.eId);
              return;
            }
            paramActionSheetItem = new StringBuilder();
            paramActionSheetItem.append("error mEmoticon, ");
            if (this.D == null) {
              bool1 = true;
            }
            paramActionSheetItem.append(bool1);
            QLog.d("AIOEmotionFragment", 1, paramActionSheetItem.toString());
            return;
          }
          paramActionSheetItem = (MessageForPic)localMessageRecord;
          localObject1 = URLDrawableHelper.getDrawable(URLDrawableHelper.getURL(paramActionSheetItem, 1), -1, -1, null, null, false);
          ((URLDrawable)localObject1).setTag(localMessageRecord);
          this.P.add(localObject1);
          AIOGalleryUtils.a(this.b, (QQAppInterface)localObject2, (URLDrawable)localObject1, localMessageRecord.frienduin, getBaseActivity().getResources().getDimensionPixelSize(2131299920), null, paramActionSheetItem.picExtraData);
          EmoticonOperateReport.reportFavAddEmotionEvent((AppInterface)localObject2, 2, paramActionSheetItem.md5, null);
          new AdEmoReportUtil().c((AppInterface)localObject2, null, paramActionSheetItem);
        }
      }
      else
      {
        a("0X8009983");
        paramActionSheetItem = AbsDownloader.getFile(URLDrawableHelper.getURL((MessageForPic)localMessageRecord, 1).toString());
        if (paramActionSheetItem == null) {
          return;
        }
        localObject1 = getBaseActivity();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramActionSheetItem.getAbsolutePath());
        ((StringBuilder)localObject2).append(NetConnInfoCenter.getServerTime());
        AIOGalleryUtils.a((Activity)localObject1, paramActionSheetItem, Utils.Crc64String(((StringBuilder)localObject2).toString()));
        return;
      }
    }
    a("0X8009981");
    if ((localMessageRecord instanceof MessageForPic))
    {
      paramActionSheetItem = (MessageForPic)localMessageRecord;
      PicItemBuilder.a((QQAppInterface)localObject2, paramActionSheetItem.senderuin, paramActionSheetItem.md5, "0X8009F3D", "");
    }
    if (i1 == 0)
    {
      if (this.D != null)
      {
        paramActionSheetItem = this.E;
        if (paramActionSheetItem != null)
        {
          d = paramActionSheetItem;
          ((IEmoticonManagerService)((QQAppInterface)localObject2).getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(this.D.epId, new AIOEmotionFragment.8(this, (QQAppInterface)localObject2));
          return;
        }
      }
      paramActionSheetItem = new StringBuilder();
      paramActionSheetItem.append("error mEmoticon, ");
      bool1 = bool2;
      if (this.D == null) {
        bool1 = true;
      }
      paramActionSheetItem.append(bool1);
      QLog.d("AIOEmotionFragment", 1, paramActionSheetItem.toString());
      return;
    }
    paramActionSheetItem = PicItemBuilder.b((MessageForPic)localMessageRecord, this.C, (QQAppInterface)localObject2, this.b);
    paramActionSheetItem.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getBaseActivity().getClass().getName());
    ForwardBaseOption.a(super.getBaseActivity(), paramActionSheetItem, 1, 100500, "biz_src_jc_gif");
  }
  
  public void a(long paramLong)
  {
    EmotionDataSource localEmotionDataSource = this.V;
    if ((localEmotionDataSource instanceof MsgEmotionDataSource)) {
      ((MsgEmotionDataSource)localEmotionDataSource).a(this.g, this.h, paramLong, this);
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (a())
    {
      Object localObject = (ImageView)paramView.findViewById(2131436194);
      ((ImageView)localObject).setPadding(0, ((ImageView)localObject).getPaddingTop(), ((ImageView)localObject).getPaddingRight(), ((ImageView)localObject).getPaddingBottom());
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      float f1 = 36;
      localLayoutParams.height = AIOUtils.b(f1, getResources());
      localLayoutParams.width = AIOUtils.b(f1, getResources());
      ((ImageView)localObject).setLayoutParams(localLayoutParams);
      paramView = (ImageView)paramView.findViewById(2131436195);
      paramView.setImageResource(2130842285);
      paramView.setVisibility(0);
      localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.b(f1, getResources());
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.b(f1, getResources());
      ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramView.setContentDescription(getString(2131916522));
      paramView.setOnClickListener(new AIOEmotionFragment.1(this));
    }
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase)
  {
    m();
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    paramAudioPlayerBase = new StringBuilder();
    paramAudioPlayerBase.append("AudioPlayer on onError, errorCode = ");
    paramAudioPlayerBase.append(paramInt);
    QLog.e("AIOEmotionFragment", 2, paramAudioPlayerBase.toString());
    QQToast.makeText(this.b, 1, 2131886506, 0).show();
    m();
  }
  
  public void a(List<EmoticonPreviewData> paramList, EmoticonPreviewData paramEmoticonPreviewData)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.f.post(new AIOEmotionFragment.11(this, paramList, paramEmoticonPreviewData));
    }
  }
  
  public void a(boolean paramBoolean, MessageForPic paramMessageForPic)
  {
    if (paramBoolean)
    {
      this.h.notifyDataSetChanged();
      this.r.setVisibility(0);
    }
    else
    {
      QQToast.makeText(this.b, this.b.getString(2131892726), 0).show();
    }
    this.q.b();
    this.g.enableDoubleTap(true);
    this.g.enableScaleGesture(true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = AudioDeviceHelper.a(BaseApplicationImpl.getContext());
    boolean bool = AudioDeviceHelper.b(BaseApplicationImpl.getContext());
    AudioPanelAioHelper.a(getBaseActivity(), paramBoolean2, paramBoolean1, bool);
    if ((this.H.m()) && (!paramBoolean1) && (!bool)) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    b(paramBoolean1, paramBoolean2);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    paramBoolean4 = paramBoolean2;
    if (paramBoolean2)
    {
      paramBoolean4 = paramBoolean2;
      if (paramBoolean1) {
        paramBoolean4 = AudioDeviceHelper.c(BaseApplicationImpl.getContext());
      }
    }
    AudioPanelAioHelper.a(getBaseActivity(), paramBoolean3, paramBoolean1, paramBoolean4);
    if ((this.H.m()) && (!paramBoolean1) && (!paramBoolean4)) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    b(paramBoolean1, paramBoolean3);
  }
  
  public boolean a()
  {
    return W == 0;
  }
  
  protected void b()
  {
    Object localObject1 = (EmoticonPreviewData)this.g.getSelectedItem();
    boolean bool2 = localObject1 instanceof MsgEmoticonPreviewData;
    boolean bool1 = false;
    if (bool2)
    {
      localObject2 = ((MsgEmoticonPreviewData)localObject1).a;
      if ((localObject2 instanceof MessageForPic))
      {
        localObject3 = (MessageForPic)localObject2;
        if ((((MessageForPic)localObject3).picExtraData != null) && (((MessageForPic)localObject3).picExtraData.isZhitu()) && (!((MessageRecord)localObject2).isSend()))
        {
          i1 = 1;
          break label83;
        }
      }
    }
    int i1 = 0;
    label83:
    if (this.F == null)
    {
      localObject2 = new ShareActionSheetV2.Param();
      ((ShareActionSheetV2.Param)localObject2).context = this.b;
      ((ShareActionSheetV2.Param)localObject2).isNotShowMyPc = false;
      this.F = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject2);
      this.F.setActionSheetTitle(this.b.getString(2131889851));
    }
    Object localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    RichMediaShareActionSheetUtil.a(2, (ArrayList)localObject2);
    if ((localObject1 != null) && (!((EmoticonPreviewData)localObject1).a()) && (((IMiniAppFileMaterialService)QRoute.api(IMiniAppFileMaterialService.class)).isMimeTypeSupported("image/*"))) {
      RichMediaShareActionSheetUtil.a(166, (ArrayList)localObject2);
    }
    RichMediaShareActionSheetUtil.a(48, (ArrayList)localObject3);
    if (!getBaseActivity().getIntent().getBooleanExtra("from_chat_history", false)) {
      RichMediaShareActionSheetUtil.a(65, (ArrayList)localObject3);
    }
    if ((localObject1 != null) && (!((EmoticonPreviewData)localObject1).a())) {
      RichMediaShareActionSheetUtil.a(39, (ArrayList)localObject3);
    }
    if (getBaseActivity().getIntent().getBooleanExtra("hide_emo_position", true)) {
      RichMediaShareActionSheetUtil.a(54, (ArrayList)localObject3);
    }
    if (i1 != 0) {
      RichMediaShareActionSheetUtil.a(66, (ArrayList)localObject3);
    }
    this.F.setItemClickListenerV2(new AIOEmotionFragment.2(this));
    this.F.setActionSheetItems((List)localObject2, (List)localObject3);
    if (getBaseActivity() != null) {
      getBaseActivity().getIntent().putExtra("big_brother_source_key", "biz_src_jc_gif");
    }
    localObject2 = c();
    if ((bool2) && (localObject2 != null))
    {
      localObject1 = ((MsgEmoticonPreviewData)localObject1).a;
      if ((localObject1 instanceof MessageForMarketFace)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      if (i1 == 0)
      {
        if (this.D != null)
        {
          localObject1 = this.E;
          if (localObject1 != null)
          {
            d = (IPicEmoticonInfo)localObject1;
            ((IEmoticonManagerService)((QQAppInterface)localObject2).getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(this.D.epId, new AIOEmotionFragment.3(this, (QQAppInterface)localObject2));
            return;
          }
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("error mEmoticon, ");
        if (this.D == null) {
          bool1 = true;
        }
        ((StringBuilder)localObject1).append(bool1);
        QLog.d("AIOEmotionFragment", 1, ((StringBuilder)localObject1).toString());
      }
      else
      {
        localObject1 = PicItemBuilder.b((MessageForPic)localObject1, this.C, (QQAppInterface)localObject2, this.b);
        ((Intent)localObject1).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getBaseActivity().getClass().getName());
        ((Intent)localObject1).putExtra("key_new_img_shareactionsheet", 1);
        ((Intent)localObject1).putExtra("k_dataline", true);
        this.F.setIntentForStartForwardRecentActivity((Intent)localObject1);
      }
    }
    this.F.show();
  }
  
  public void b(float paramFloat)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDoubleTap currScale:");
      ((StringBuilder)localObject).append(paramFloat);
      QLog.d("AIOEmotionFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.f.obtainMessage(1002);
    Long localLong = this.h.c(this.g.getSelectedItemPosition());
    float f1;
    if (this.Q.containsKey(localLong))
    {
      f1 = ((Float)this.Q.get(localLong)).floatValue();
    }
    else
    {
      f1 = this.g.getSelectChildScale();
      this.Q.put(localLong, Float.valueOf(f1));
    }
    int i1;
    if (paramFloat > f1) {
      i1 = 0;
    } else {
      i1 = 4;
    }
    ((Message)localObject).arg1 = i1;
    this.f.sendMessage((Message)localObject);
  }
  
  protected void b(View paramView)
  {
    Intent localIntent = getBaseActivity().getIntent();
    this.G = ((Rect)localIntent.getParcelableExtra("KEY_THUMBNAL_BOUND"));
    this.C = ((SessionInfo)localIntent.getParcelableExtra("session_info"));
    f();
    this.g = ((EmotionGallery)paramView.findViewById(2131433934));
    this.g.setAdapter(this.h);
    this.g.setOnScaleChangeListener(this);
    this.g.setOnScollListener(this);
    this.g.setSpacing(this.b.getResources().getDimensionPixelSize(2131297535));
    this.g.setOnItemLongClickListener(this);
    this.g.setOnItemSelectedListener(this);
    this.t = ((RelativeLayout)paramView.findViewById(2131447484));
    this.u = paramView.findViewById(2131429234);
    this.s = ((DragView)paramView.findViewById(2131432158));
    this.s.init();
    this.s.setGestureChangeListener(this);
    this.s.setDragChangeListener(this);
    this.s.setRatioModify(false);
    this.i = ((TextView)paramView.findViewById(2131427959));
    this.j = ((Button)paramView.findViewById(2131427960));
    this.k = ((TextView)paramView.findViewById(2131431780));
    this.l = ((TextView)paramView.findViewById(2131431778));
    this.m = paramView.findViewById(2131432471);
    this.n = ((ImageView)paramView.findViewById(2131431779));
    this.o = ((ImageView)paramView.findViewById(2131431781));
    this.j.setOnClickListener(this);
    this.i.setOnClickListener(this);
    c().addObserver(this.Z);
    this.r = ((ImageView)this.a.findViewById(2131436194));
    this.p = ((ImageView)paramView.findViewById(2131427950));
    this.q = new GalleryProgressView();
    this.q.a(super.getBaseActivity(), this.p);
    this.v = ((RelativeLayout)paramView.findViewById(2131427957));
    this.w = ((RelativeLayout)paramView.findViewById(2131428864));
    this.x = ((TriangleView)paramView.findViewById(2131440422));
    this.y = ((RelativeLayout)paramView.findViewById(2131428865));
    this.z = ((PttAudioPlayView)paramView.findViewById(2131428866));
    this.A = ((PttAudioWaveView)paramView.findViewById(2131428874));
    this.A.setCanSupportSlide(false);
    this.A.setShowProgressLine(false);
    this.z.setPttPauseOrStopDrawable(2130838205);
    a(IPicEmoticonInfo.DEFAULT_AUDIO_WAVE_BACKGROUND_COLOR, IPicEmoticonInfo.DEFAULT_AUDIO_WAVE_FOREGROUND_COLOR);
    this.z.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.w.setVisibility(8);
    this.N = ((RelativeLayout)paramView.findViewById(2131439792));
    AIOGalleryMsgRevokeMgr.a().a(this);
    this.X = getResources().getDisplayMetrics().density;
    this.Y = ((int)(this.X * 6.0F));
    if ((getBaseActivity().getIntent().getBooleanExtra("need_reload_data", true)) && (this.V != null))
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append(" initData dataSource=");
        paramView.append(this.V);
        QLog.d("AIOEmotionFragment", 2, paramView.toString());
      }
      this.V.a(this, e, false);
    }
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!DeviceInfoUtil.W()))
    {
      if (this.B == null)
      {
        localObject = getBaseActivity();
        if (localObject == null) {
          return;
        }
        ((LayoutInflater)((Activity)localObject).getSystemService("layout_inflater")).inflate(2131624137, this.N);
        this.B = this.N.findViewById(2131428098);
        this.L = ((TextView)this.N.findViewById(2131428099));
        this.M = ((ImageView)this.N.findViewById(2131428097));
        this.B.setOnClickListener(this);
        ((RelativeLayout.LayoutParams)this.B.getLayoutParams()).addRule(2, 2131432471);
      }
      this.B.bringToFront();
      this.B.setVisibility(0);
      if (ThemeUtil.isNowThemeIsNight(c(), false, null)) {
        this.L.setTextColor(Color.parseColor("#FF737373"));
      }
      if (paramBoolean2)
      {
        this.L.setText(2131886587);
        this.M.setBackgroundResource(2130852095);
        return;
      }
      this.L.setText(2131886586);
      this.M.setBackgroundResource(2130852094);
      return;
    }
    Object localObject = this.B;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
  }
  
  public void c(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void d()
  {
    Object localObject = this.h.c(this.g.getSelectedItemPosition());
    if (!this.Q.containsKey(localObject)) {
      this.Q.put(localObject, Float.valueOf(this.g.getSelectChildScale()));
    }
    localObject = this.f.obtainMessage(1002);
    ((Message)localObject).arg1 = 4;
    this.f.sendMessage((Message)localObject);
  }
  
  public void d(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    Object localObject = this.E;
    if ((localObject != null) && (((IPicEmoticonInfo)localObject).isNewSoundType()))
    {
      localObject = EmotionPanelConstans.emoticonSoundPath.replace("[epId]", this.E.getEmoticon().epId).replace("[eId]", this.E.getEmoticon().eId);
      String str = paramAudioPlayerBase.k();
      this.f.post(new AIOEmotionFragment.12(this, str, (String)localObject, paramInt, paramAudioPlayerBase));
    }
  }
  
  public void e()
  {
    this.f.post(new AIOEmotionFragment.13(this));
  }
  
  public void f()
  {
    EmoticonPreviewData localEmoticonPreviewData = e;
    if (localEmoticonPreviewData == null)
    {
      QLog.d("AIOEmotionFragment", 1, "initDataResource fail");
      return;
    }
    if ((W == 0) && ((localEmoticonPreviewData instanceof MsgEmoticonPreviewData))) {
      this.V = new MsgEmotionDataSource(getBaseActivity().getIntent(), (MsgEmoticonPreviewData)e, this.C);
    } else if ((W == 1) && ((e instanceof FavEmoticonPreviewData))) {
      this.V = new FavEmotionDataSource(c(), (FavEmoticonPreviewData)e);
    }
    if (this.V == null)
    {
      QLog.d("AIOEmotionFragment", 1, "initDataResource fail dataSource is null.");
      return;
    }
    this.h = new EmotionAdapter(getBaseActivity(), this.f, e);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i2 = paramMessage.what;
    int i1 = 0;
    Object localObject;
    switch (i2)
    {
    default: 
      return true;
    case 1002: 
      i2 = paramMessage.arg1;
      if (i2 == 0)
      {
        paramMessage = (EmoticonPreviewData)this.g.getSelectedItem();
        if (paramMessage != null)
        {
          if (paramMessage.a())
          {
            this.j.setVisibility(4);
            this.i.setVisibility(0);
            this.v.setVisibility(0);
            return true;
          }
          if (paramMessage.d() == null) {
            i1 = 4;
          }
          this.j.setVisibility(i1);
          this.i.setVisibility(i1);
          this.v.setVisibility(i1);
          return true;
        }
      }
      else
      {
        this.i.setVisibility(i2);
        this.j.setVisibility(i2);
        this.v.setVisibility(i2);
        return true;
      }
      break;
    case 1001: 
      i2 = paramMessage.arg1;
      i1 = paramMessage.arg2;
      if ((i2 == this.S) && (i1 == 0)) {
        return true;
      }
      if (i2 != this.S) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      this.S = i2;
      this.I = null;
      this.E = null;
      if (i2 != -1) {
        localObject = this.h.a(i2);
      } else {
        localObject = this.g.getSelectedItem();
      }
      localObject = (EmoticonPreviewData)localObject;
      if (localObject == null) {
        return true;
      }
      if ((!this.U) && (!this.h.b(i2))) {
        return true;
      }
      if (this.T)
      {
        if ((i1 != 0) && (k()))
        {
          QLog.d("AIOEmotionFragment", 2, "MSG_UPDATE_EMOTION_UI stopAudio");
          l();
        }
        this.v.setVisibility(4);
        this.i.setVisibility(4);
        this.j.setVisibility(4);
        this.m.setVisibility(4);
        return true;
      }
      this.w.setVisibility(8);
      if ((((EmoticonPreviewData)localObject).a()) && (i2 != -1))
      {
        float f2 = this.g.getSelectChildScale();
        EmoticonInfo localEmoticonInfo = ((EmoticonPreviewData)localObject).c();
        if (localEmoticonInfo != null)
        {
          if ((localEmoticonInfo instanceof IPicEmoticonInfo))
          {
            IPicEmoticonInfo localIPicEmoticonInfo = (IPicEmoticonInfo)localEmoticonInfo;
            if (localIPicEmoticonInfo.getEmoticon() != null)
            {
              float f1;
              if (this.Q.containsKey(this.h.c(i2))) {
                f1 = ((Float)this.Q.get(this.h.c(i2))).floatValue();
              } else {
                f1 = f2;
              }
              if ((f1 > 0.0F) && (f2 <= f1))
              {
                this.i.setVisibility(0);
                this.v.setVisibility(0);
              }
              this.E = localIPicEmoticonInfo;
              this.D = localIPicEmoticonInfo.getEmoticon();
              this.i.setText(localIPicEmoticonInfo.getEmoticon().name);
              this.g.bringToFront();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("getView emotion name:");
              localStringBuilder.append(localIPicEmoticonInfo.getEmoticon().name);
              QLog.d("AIOEmotionFragment", 1, localStringBuilder.toString());
              if (a(localIPicEmoticonInfo))
              {
                paramMessage = (Drawable)paramMessage.obj;
                if ((paramMessage != null) && ((paramMessage instanceof URLDrawable))) {
                  this.I = new WeakReference((URLDrawable)paramMessage);
                }
              }
            }
          }
          h();
        }
        this.j.setVisibility(4);
        a(localEmoticonInfo);
      }
      else
      {
        this.v.setVisibility(4);
        this.j.setVisibility(4);
        this.i.setVisibility(4);
        this.m.setVisibility(4);
        if (((EmoticonPreviewData)localObject).f()) {
          a((MsgEmoticonPreviewData)localObject);
        }
        if (((EmoticonPreviewData)localObject).g()) {
          b((MsgEmoticonPreviewData)localObject);
        }
        a(i2, (EmoticonPreviewData)localObject);
      }
      if (((localObject instanceof MsgEmoticonPreviewData)) && (!((EmoticonPreviewData)localObject).a()) && (!((MsgEmotionDataSource)this.V).a((EmoticonPreviewData)localObject)))
      {
        this.r.setVisibility(8);
        this.q.a();
        this.q.a(0);
        this.g.enableDoubleTap(false);
        this.g.enableScaleGesture(false);
        ((MsgEmotionDataSource)this.V).a(this.g, this.f, (EmoticonPreviewData)localObject, this);
        return true;
      }
      this.r.setVisibility(0);
      this.q.b();
      this.g.enableDoubleTap(true);
      this.g.enableScaleGesture(true);
      return true;
    case 1000: 
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof String)))
      {
        paramMessage = (String)paramMessage.obj;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("update album name:");
          ((StringBuilder)localObject).append(paramMessage);
          QLog.d("AIOEmotionFragment", 2, ((StringBuilder)localObject).toString());
        }
        this.k.setText(paramMessage);
      }
      break;
    }
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      paramIntent.putExtra("selfSet_leftViewText", this.b.getString(2131917002));
      paramIntent = new Bundle(paramIntent.getExtras());
      Intent localIntent = new Intent();
      localIntent.putExtras(paramIntent);
      if (super.c() != null) {
        ForwardUtils.a(super.c(), super.getBaseActivity(), this.b, localIntent, ThreadManager.getUIHandler());
      }
    }
    else if ((paramInt2 == -1) && (paramInt1 == 2))
    {
      this.f.removeMessages(1001);
      this.f.obtainMessage(1001, -1, 1).sendToTarget();
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    boolean bool2 = false;
    Object localObject;
    if ((i1 != 2131427960) && (paramView.getId() != 2131427959))
    {
      if ((paramView.getId() != 2131428866) && (paramView.getId() != 2131428874))
      {
        if (paramView.getId() == 2131428098)
        {
          localObject = c();
          if (localObject != null)
          {
            boolean bool3 = AudioDeviceHelper.a(BaseApplicationImpl.getContext());
            boolean bool4 = AudioDeviceHelper.b(BaseApplicationImpl.getContext());
            boolean bool1 = this.J ^ true;
            this.J = bool1;
            AudioDeviceHelper.a(bool1, (AppRuntime)localObject);
            boolean bool5 = k();
            this.H.a(1, this.J);
            AudioPanelAioHelper.a(getBaseActivity(), this.J, bool3, bool4);
            bool1 = bool2;
            if (!bool3)
            {
              bool1 = bool2;
              if (!bool4)
              {
                bool1 = bool2;
                if (bool5) {
                  bool1 = true;
                }
              }
            }
            b(bool1, this.J);
          }
        }
      }
      else if (k())
      {
        l();
        localObject = this.E;
        if ((localObject != null) && (((IPicEmoticonInfo)localObject).getEmoticon() != null)) {
          EmoticonOperateReport.reportNewSoundEvent(c(), "0X800A9E1", -1, this.E.getEmoticon().epId);
        }
      }
      else
      {
        j();
        localObject = this.E;
        if ((localObject != null) && (((IPicEmoticonInfo)localObject).getEmoticon() != null)) {
          EmoticonOperateReport.reportNewSoundEvent(c(), "0X800A9E0", -1, this.E.getEmoticon().epId);
        }
      }
    }
    else if (this.j.getVisibility() == 0)
    {
      localObject = (EmoticonPreviewData)this.g.getSelectedItem();
      if (localObject != null)
      {
        CustomEmotionData localCustomEmotionData = ((EmoticonPreviewData)localObject).d();
        if (localCustomEmotionData != null)
        {
          if (!TextUtils.isEmpty(localCustomEmotionData.modifyWord)) {
            localObject = localCustomEmotionData.modifyWord;
          } else {
            localObject = localCustomEmotionData.ocrWord;
          }
          Intent localIntent = new Intent(getBaseActivity(), EditActivity.class);
          localIntent.putExtra("title", 2131888902);
          localIntent.putExtra("limit", 30);
          localIntent.putExtra("action", 105);
          localIntent.putExtra("key_emo_id", localCustomEmotionData.emoId);
          localIntent.putExtra("key_input_tip", getResources().getString(2131888903));
          localIntent.putExtra("current", (String)localObject);
          localIntent.putExtra("canPostNull", false);
          localIntent.putExtra("multiLine", false);
          ReportController.b(null, "dc00898", "", "", "0X800A7C1", "0X800A7C1", this.V.b(), 0, "", "", "", "");
          startActivityForResult(localIntent, 2);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onClickDragView() {}
  
  public void onContentMove(float paramFloat)
  {
    this.u.setAlpha(paramFloat);
    if (paramFloat < 0.9F)
    {
      this.t.setVisibility(4);
      this.m.setVisibility(4);
      this.i.setVisibility(4);
      this.j.setVisibility(4);
      this.p.setVisibility(4);
      this.v.setVisibility(4);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    boolean bool = false;
    if (e == null) {
      bool = true;
    }
    QLog.d("AIOEmotionFragment", 1, new Object[] { "onCreate, mCurDataIsNull:", Boolean.valueOf(bool) });
    if (e == null) {
      try
      {
        e = EmoticonPreviewData.a(paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.d("AIOEmotionFragment", 1, "onCreate exception:", paramBundle);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool = QLog.isColorLevel();
    int i1 = 1;
    if (bool) {
      QLog.d("AIOEmotionFragment", 1, "onCreateView");
    }
    EmoticonPreviewData localEmoticonPreviewData = e;
    if ((localEmoticonPreviewData == null) || (!localEmoticonPreviewData.a())) {
      i1 = 2;
    }
    this.c = i1;
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.f.removeCallbacksAndMessages(null);
    if (this.O != null)
    {
      ((IEmojiManagerService)c().getRuntimeService(IEmojiManagerService.class)).getEmojiListenerManager().removeEmotionJsonDownloadListener(this.O);
      this.O = null;
    }
    c().removeObserver(this.Z);
    Object localObject = this.V;
    if (localObject != null) {
      ((EmotionDataSource)localObject).c();
    }
    if (!this.P.isEmpty())
    {
      localObject = this.P.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((URLDrawable)((Iterator)localObject).next()).setTag(null);
      }
    }
    localObject = this.H;
    if (localObject != null)
    {
      if (((CommonAudioPlayer)localObject).m()) {
        this.H.d();
      }
      localObject = c();
      if (localObject != null) {
        ((IAudioDeviceService)((QQAppInterface)localObject).getRuntimeService(IAudioDeviceService.class)).unRegisterAudioDeviceListener(this.H);
      }
      this.H.q();
    }
    localObject = this.B;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(4);
      this.B = null;
    }
    this.I = null;
    localObject = this.z;
    if (localObject != null) {
      ((PttAudioPlayView)localObject).b();
    }
    localObject = this.A;
    if (localObject != null) {
      ((PttAudioWaveView)localObject).b();
    }
    AIOGalleryMsgRevokeMgr.a().b(this);
  }
  
  public void onGestureFinish()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing()))
    {
      localBaseActivity.finish();
      localBaseActivity.overridePendingTransition(0, 0);
    }
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a("0X8009980");
    if (this.V.a()) {
      b();
    }
    return false;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.h.b(paramInt))
    {
      this.s.setOriginRect(this.G);
      return;
    }
    this.s.setOriginRect(null);
  }
  
  public int[] onModifyCurViewSize()
  {
    Object localObject = (ImageView)this.g.getSelectedView();
    if (localObject == null) {
      return null;
    }
    localObject = ((ImageView)localObject).getDrawable();
    if (localObject == null) {
      return null;
    }
    return new int[] { (int)(((Drawable)localObject).getIntrinsicWidth() * this.g.getSelectChildScale()), (int)(((Drawable)localObject).getIntrinsicHeight() * this.g.getSelectChildScale()) };
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void onPause()
  {
    super.onPause();
    if (k()) {
      l();
    }
  }
  
  public void onResetPosition()
  {
    EmoticonPreviewData localEmoticonPreviewData = (EmoticonPreviewData)this.g.getSelectedItem();
    if (localEmoticonPreviewData == null) {
      return;
    }
    RelativeLayout localRelativeLayout = this.t;
    int i1 = 0;
    localRelativeLayout.setVisibility(0);
    if (localEmoticonPreviewData.a())
    {
      this.m.setVisibility(0);
      this.j.setVisibility(4);
      this.i.setVisibility(0);
      this.v.setVisibility(0);
      return;
    }
    if (localEmoticonPreviewData.f()) {
      this.m.setVisibility(0);
    } else {
      this.m.setVisibility(4);
    }
    if (localEmoticonPreviewData.d() == null) {
      i1 = 4;
    }
    this.j.setVisibility(i1);
    this.i.setVisibility(i1);
    this.v.setVisibility(i1);
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (e != null)
    {
      QLog.d("AIOEmotionFragment", 1, "onSaveInstanceState");
      e.a(paramBundle, W);
    }
  }
  
  public void onScrollEnd(int paramInt)
  {
    if (!this.T) {
      return;
    }
    int i1 = this.g.getSelectedItemPosition();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getView onScrollEnd:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" currentPosition:");
    localStringBuilder.append(this.g.getSelectedItemPosition());
    localStringBuilder.append(" selectPos: ");
    localStringBuilder.append(i1);
    localStringBuilder.append(" hasScrolled: ");
    localStringBuilder.append(this.T);
    QLog.d("AIOEmotionFragment", 1, localStringBuilder.toString());
    if (this.g.getSelectChildScale() == this.R) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    this.T = false;
    this.U = true;
    this.f.removeMessages(1001);
    this.f.obtainMessage(1001, i1, paramInt).sendToTarget();
  }
  
  public void onScrollStart(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getView onScrollStart:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" currentPosition:");
    localStringBuilder.append(this.g.getSelectedItemPosition());
    localStringBuilder.append(" hasScrolled: ");
    localStringBuilder.append(this.T);
    QLog.d("AIOEmotionFragment", 1, localStringBuilder.toString());
    this.U = true;
    if (!this.T)
    {
      this.T = true;
      this.f.removeMessages(1001);
      this.f.obtainMessage(1001, -1, 0).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment
 * JD-Core Version:    0.7.0.1
 */