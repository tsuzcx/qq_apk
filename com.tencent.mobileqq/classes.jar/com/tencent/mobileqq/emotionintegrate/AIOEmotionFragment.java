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
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioDeviceHelper;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.AudioPlayerListener;
import com.tencent.mobileqq.qqaudio.audioplayer.CommonAudioPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.CommonAudioPlayer.UIAudioDeivceChangedListern;
import com.tencent.mobileqq.qqaudio.audioplayer.IAudioDeviceService;
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
  public static IPicEmoticonInfo a;
  public static EmoticonPreviewData a;
  private static int jdField_c_of_type_Int;
  private float jdField_a_of_type_Float = 1.0F;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  GalleryProgressView jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  PttAudioPlayView jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView;
  PttAudioWaveView jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView;
  TriangleView jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView;
  private EmoticonObserver jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver = new AIOEmotionFragment.10(this);
  Emoticon jdField_a_of_type_ComTencentMobileqqDataEmoticon;
  private AIOEmotionFragment.EmoticonDetailJsonDownloader jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$EmoticonDetailJsonDownloader = null;
  EmotionAdapter jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter;
  private EmotionDataSource jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource;
  EmotionGallery jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery;
  private CommonAudioPlayer jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer;
  ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  final WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  DragView jdField_a_of_type_ComTencentWidgetDragView;
  private WeakReference<URLDrawable> jdField_a_of_type_JavaLangRefWeakReference = null;
  private HashMap<Long, Float> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<URLDrawable> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = -1;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  IPicEmoticonInfo jdField_b_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo;
  private boolean jdField_b_of_type_Boolean = false;
  View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  protected View d;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = false;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.setDrawColor(paramInt1);
    RoundedColorDrawable localRoundedColorDrawable = new RoundedColorDrawable(paramInt1, 1, 1, AIOUtils.b(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localRoundedColorDrawable);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.postInvalidate();
  }
  
  private void a(int paramInt, EmoticonPreviewData paramEmoticonPreviewData)
  {
    paramEmoticonPreviewData = paramEmoticonPreviewData.a();
    if (paramEmoticonPreviewData != null)
    {
      float f2 = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
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
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.a(paramInt))) {
        f1 = ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.a(paramInt))).floatValue();
      } else {
        f1 = f2;
      }
      if ((f1 > 0.0F) && (f2 <= f1))
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
      if (!TextUtils.isEmpty(paramEmoticonPreviewData.modifyWord)) {
        paramEmoticonPreviewData = paramEmoticonPreviewData.modifyWord;
      } else {
        paramEmoticonPreviewData = paramEmoticonPreviewData.ocrWord;
      }
      if (TextUtils.isEmpty(paramEmoticonPreviewData))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167152));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691931));
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165327));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramEmoticonPreviewData);
      }
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bringToFront();
      if ((b()) && (SharedPreUtils.x(this.jdField_a_of_type_AndroidContentContext, a().getCurrentUin())))
      {
        SharedPreUtils.q(this.jdField_a_of_type_AndroidContentContext, a().getCurrentUin(), false);
        paramEmoticonPreviewData = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramEmoticonPreviewData.setOrientation(1);
        paramEmoticonPreviewData.setGravity(1);
        localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838893));
        paramEmoticonPreviewData.addView((View)localObject);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
        localLayoutParams.bottomMargin = (-AIOUtils.b(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localLayoutParams.topMargin = AIOUtils.b(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((ImageView)localObject).setLayoutParams(localLayoutParams);
        localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167394));
        ((TextView)localObject).setTextSize(14.0F);
        ((TextView)localObject).setGravity(17);
        ((TextView)localObject).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691942));
        ((TextView)localObject).setBackgroundResource(2130838897);
        paramEmoticonPreviewData.addView((View)localObject);
        paramInt = AIOUtils.b(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((TextView)localObject).setPadding(paramInt, 0, paramInt, 0);
        paramEmoticonPreviewData = new PopupWindow(paramEmoticonPreviewData, -2, -2);
        paramEmoticonPreviewData.setBackgroundDrawable(new ColorDrawable(0));
        paramEmoticonPreviewData.setOutsideTouchable(true);
        paramEmoticonPreviewData.setFocusable(true);
        ((TextView)localObject).measure(0, 0);
        this.jdField_a_of_type_AndroidWidgetTextView.post(new AIOEmotionFragment.4(this, paramEmoticonPreviewData, (TextView)localObject));
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
    jdField_c_of_type_Int = 0;
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
    e();
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
    jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData = new MsgEmoticonPreviewData(paramMessageRecord);
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
    e();
    if (QLog.isColorLevel()) {
      QLog.i("AIOEmotionFragment", 2, "enterEmotionPreview, type: FAV");
    }
    jdField_c_of_type_Int = 1;
    jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData = new FavEmoticonPreviewData(paramEmoticonInfo);
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
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$EmoticonDetailJsonDownloader == null) {
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$EmoticonDetailJsonDownloader = new AIOEmotionFragment.EmoticonDetailJsonDownloader(this);
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$EmoticonDetailJsonDownloader.a(paramInt, paramQQAppInterface, getBaseActivity(), this.jdField_b_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null);
      paramQQAppInterface = (IEmojiManagerService)paramQQAppInterface.getRuntimeService(IEmojiManagerService.class);
      paramQQAppInterface.getEmojiListenerManager().addEmotionJsonDownloadListener(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$EmoticonDetailJsonDownloader);
      paramQQAppInterface.startDownloadEmosmJson(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
      return;
    }
    QLog.d("AIOEmotionFragment", 1, "error in json downloading");
    a(false);
  }
  
  private void a(EmoticonInfo paramEmoticonInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon;
    int j = 1;
    int i;
    if ((localObject != null) && (((Emoticon)localObject).jobType != 2)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (paramEmoticonInfo != null))
    {
      a("0X800997E");
      if (((paramEmoticonInfo instanceof IPicEmoticonInfo)) && (((IPicEmoticonInfo)paramEmoticonInfo).isNewSoundType())) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setClickable(true);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new AIOEmotionFragment.7(this));
      paramEmoticonInfo = paramEmoticonInfo.getDrawable(getBaseActivity(), this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramEmoticonInfo);
      paramEmoticonInfo = null;
      localObject = EmotionDataManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      if (localObject != null) {
        paramEmoticonInfo = ((EmoticonPackage)localObject).name;
      }
      localObject = a();
      if (localObject != null)
      {
        if (!TextUtils.isEmpty(paramEmoticonInfo))
        {
          if (paramEmoticonInfo.length() > 11)
          {
            TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramEmoticonInfo.substring(0, 10));
            localStringBuilder.append("...");
            localTextView.setText(localStringBuilder.toString());
          }
          else
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(paramEmoticonInfo);
          }
        }
        else {
          a((QQAppInterface)localObject, 4);
        }
        if (((IEmoticonManagerService)((QQAppInterface)localObject).getRuntimeService(IEmoticonManagerService.class)).isEpidInTabcache(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId))
        {
          i = j;
          break label297;
        }
      }
      i = 0;
      label297:
      if (i != 0)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700247));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        return;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700246));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
  }
  
  private void a(MsgEmoticonPreviewData paramMsgEmoticonPreviewData)
  {
    a("0X800A7E6");
    paramMsgEmoticonPreviewData = (MessageForPic)paramMsgEmoticonPreviewData.a;
    int i = paramMsgEmoticonPreviewData.picExtraData.from;
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bringToFront();
    if (!TextUtils.isEmpty(paramMsgEmoticonPreviewData.picExtraData.source)) {
      if (paramMsgEmoticonPreviewData.picExtraData.source.length() > 11)
      {
        localObject = this.jdField_b_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMsgEmoticonPreviewData.picExtraData.source.substring(0, 10));
        localStringBuilder.append("...");
        ((TextView)localObject).setText(localStringBuilder.toString());
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramMsgEmoticonPreviewData.picExtraData.source);
      }
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setClickable(true);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new AIOEmotionFragment.5(this, i, paramMsgEmoticonPreviewData));
    if (i == 1)
    {
      if (((IEmoticonManagerService)a().getRuntimeService(IEmoticonManagerService.class)).isEpidInTabcache(paramMsgEmoticonPreviewData.picExtraData.emojiPkgId))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689850));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-7829368);
      }
      else
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689851));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      }
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689852));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    paramMsgEmoticonPreviewData = PicItemBuilder.a(paramMsgEmoticonPreviewData);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = this.jdField_d_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    paramMsgEmoticonPreviewData = URLDrawable.getDrawable(paramMsgEmoticonPreviewData, (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMsgEmoticonPreviewData);
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(localIntent);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
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
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
      QLog.d("AIOEmotionFragment", 2, "tryUpdateNewAudioEmoAudioInfo");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setMaxTopBottomPadding(4);
      localLayoutParams.width = AIOUtils.b(39.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramIPicEmoticonInfo.getWaveformArray(), AIOUtils.b(39.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), paramIPicEmoticonInfo.getVoiceLength());
      a(paramIPicEmoticonInfo.getWaveBackgroundColor(), paramIPicEmoticonInfo.getWaveForegroundColor());
      return true;
    }
    return false;
  }
  
  private void b(MsgEmoticonPreviewData paramMsgEmoticonPreviewData)
  {
    Object localObject = (MessageForPic)paramMsgEmoticonPreviewData.a;
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bringToFront();
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691885));
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setClickable(true);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new AIOEmotionFragment.6(this, paramMsgEmoticonPreviewData));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692761));
    paramMsgEmoticonPreviewData = PicItemBuilder.a((MessageForPic)localObject);
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = this.jdField_d_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    paramMsgEmoticonPreviewData = URLDrawable.getDrawable(paramMsgEmoticonPreviewData, (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMsgEmoticonPreviewData);
  }
  
  private boolean b()
  {
    float f = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.a(this.jdField_b_of_type_Int))) && (f != ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.a(this.jdField_b_of_type_Int))).floatValue())) {
      return true;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedView();
    if ((localObject instanceof ImageView))
    {
      localObject = ((ImageView)localObject).getDrawable();
      if (localObject != null)
      {
        int i;
        if ((localObject instanceof PngFrameDrawable)) {
          i = AIOUtils.b(100.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        } else {
          i = ((Drawable)localObject).getIntrinsicHeight();
        }
        this.jdField_a_of_type_Float = f;
        localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(i * f / 2.0F) + AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("AIOEmotionFragment", 2, new Object[] { "updateEmotionNameLayout scale:", Float.valueOf(f), " topMargin:", Integer.valueOf(((RelativeLayout.LayoutParams)localObject).topMargin) });
        }
        return i > 0;
      }
    }
    return false;
  }
  
  private boolean c()
  {
    CommonAudioPlayer localCommonAudioPlayer = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer;
    if (localCommonAudioPlayer == null) {
      return false;
    }
    return localCommonAudioPlayer.a();
  }
  
  private static void e()
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
      if (((((MediaPlayerManager)localObject).a() instanceof MessageForMarketFace)) && (((MediaPlayerManager)localObject).a())) {
        ((MediaPlayerManager)localObject).a(true);
      }
    }
  }
  
  private void f()
  {
    Object localObject = (EmoticonPreviewData)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
    if (!(localObject instanceof MsgEmoticonPreviewData)) {
      return;
    }
    localObject = ((MsgEmoticonPreviewData)localObject).a;
    ChatHistoryActivity.a(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, ((MessageRecord)localObject).uniseq);
  }
  
  private void g()
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer = new CommonAudioPlayer(this.jdField_a_of_type_AndroidContentContext, this);
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer.l();
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer.a(this);
      localObject1 = a();
      if (localObject1 != null) {
        ((IAudioDeviceService)((QQAppInterface)localObject1).getRuntimeService(IAudioDeviceService.class)).registerAudioDeviceListener(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer.c();
    if (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo != null)
    {
      Object localObject2 = EmotionPanelConstans.emoticonSoundPath.replace("[epId]", this.jdField_b_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId).replace("[eId]", this.jdField_b_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().eId);
      boolean bool3 = false;
      this.jdField_b_of_type_Boolean = false;
      localObject1 = a();
      if (localObject1 != null)
      {
        this.jdField_a_of_type_Boolean = AudioDeviceHelper.a((AppRuntime)localObject1);
        MediaPlayerManager localMediaPlayerManager = MediaPlayerManager.a((AppRuntime)localObject1);
        if (localMediaPlayerManager.a()) {
          localMediaPlayerManager.a(true);
        }
      }
      boolean bool4 = AudioDeviceHelper.a(BaseApplicationImpl.getContext());
      boolean bool2 = AudioDeviceHelper.b(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer.a(1);
      boolean bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer.a((String)localObject2))
      {
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (bool4) {
            bool1 = AudioDeviceHelper.c(BaseApplicationImpl.getContext());
          }
        }
        AudioPanelAioHelper.a(getBaseActivity(), this.jdField_a_of_type_Boolean, bool4, bool1);
        bool2 = bool3;
        if (!bool4)
        {
          bool2 = bool3;
          if (!bool1) {
            bool2 = true;
          }
        }
        b(bool2, this.jdField_a_of_type_Boolean);
        localObject2 = getBaseActivity();
        if (localObject2 != null) {
          ((Activity)localObject2).getWindow().addFlags(128);
        }
        localObject2 = this.jdField_a_of_type_JavaLangRefWeakReference;
        if (localObject2 != null)
        {
          localObject2 = (URLDrawable)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            EmotionUtils.startSoundDrawablePlay((URLDrawable)localObject2);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
        bool1 = true;
      }
      else
      {
        bool1 = false;
      }
      if (!bool1) {
        EmoticonOperateReport.reportNewSoundEvent((AppInterface)localObject1, "0X800A935", -1, this.jdField_b_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId);
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
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer != null)
    {
      i();
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer.c();
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
    b(false, false);
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity != null) {
      localBaseActivity.getWindow().clearFlags(128);
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2131558540, paramViewGroup, false);
  }
  
  protected void a()
  {
    Object localObject1 = (EmoticonPreviewData)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
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
          i = 1;
          break label83;
        }
      }
    }
    int i = 0;
    label83:
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null)
    {
      localObject2 = new ShareActionSheetV2.Param();
      ((ShareActionSheetV2.Param)localObject2).context = this.jdField_a_of_type_AndroidContentContext;
      ((ShareActionSheetV2.Param)localObject2).isNotShowMyPc = false;
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131692780));
    }
    Object localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    RichMediaShareActionSheetUtil.a(2, (ArrayList)localObject2);
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
    if (i != 0) {
      RichMediaShareActionSheetUtil.a(66, (ArrayList)localObject3);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new AIOEmotionFragment.2(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems((List)localObject2, (List)localObject3);
    if (getBaseActivity() != null) {
      getBaseActivity().getIntent().putExtra("big_brother_source_key", "biz_src_jc_gif");
    }
    localObject2 = a();
    if ((bool2) && (localObject2 != null))
    {
      localObject1 = ((MsgEmoticonPreviewData)localObject1).a;
      if ((localObject1 instanceof MessageForMarketFace)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null)
        {
          localObject1 = this.jdField_b_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo;
          if (localObject1 != null)
          {
            jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo = (IPicEmoticonInfo)localObject1;
            ((IEmoticonManagerService)((QQAppInterface)localObject2).getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, new AIOEmotionFragment.3(this, (QQAppInterface)localObject2));
            return;
          }
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("error mEmoticon, ");
        if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {
          bool1 = true;
        }
        ((StringBuilder)localObject1).append(bool1);
        QLog.d("AIOEmotionFragment", 1, ((StringBuilder)localObject1).toString());
      }
      else
      {
        localObject1 = PicItemBuilder.b((MessageForPic)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (QQAppInterface)localObject2, this.jdField_a_of_type_AndroidContentContext);
        ((Intent)localObject1).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getBaseActivity().getClass().getName());
        ((Intent)localObject1).putExtra("key_new_img_shareactionsheet", 1);
        ((Intent)localObject1).putExtra("k_dataline", true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity((Intent)localObject1);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
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
    Object localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1002);
    Long localLong = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition());
    float f;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localLong)) {
      f = ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(localLong)).floatValue();
    } else {
      f = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
    }
    int i;
    if (paramFloat > f) {
      i = 4;
    } else {
      i = 0;
    }
    ((Message)localObject).arg1 = i;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject);
  }
  
  public void a(int paramInt, MessageForPic paramMessageForPic)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView.a(paramInt / 100);
  }
  
  protected void a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    Object localObject1 = a();
    if (localObject1 == null)
    {
      QLog.d("AIOEmotionFragment", 1, "error runtime");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleClickMenuItem, action:");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.d("AIOEmotionFragment", 1, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = (EmoticonPreviewData)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
    if (!(localObject2 instanceof MsgEmoticonPreviewData)) {
      return;
    }
    localObject2 = ((MsgEmoticonPreviewData)localObject2).a;
    boolean bool3 = localObject2 instanceof MessageForMarketFace;
    boolean bool2 = false;
    boolean bool1 = false;
    int i;
    if (bool3) {
      i = 0;
    } else {
      i = 1;
    }
    if (paramInt != 2) {
      if (paramInt != 39)
      {
        Object localObject3;
        if (paramInt != 48)
        {
          if (paramInt != 54)
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
                  localObject3 = new Bundle();
                  ((Bundle)localObject3).putInt("key_req", 1);
                  ((Bundle)localObject3).putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
                  ((Bundle)localObject3).putString("key_direct_show_uin", paramActionSheetItem.uin);
                  if (i == 0)
                  {
                    paramActionSheetItem = this.jdField_b_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo;
                    if (paramActionSheetItem == null)
                    {
                      QLog.e("AIOEmotionFragment", 2, "ACTION_SEND_TO_SPECIFIED_FRIEND mPicEmotionInfo is null");
                      return;
                    }
                    jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo = paramActionSheetItem;
                    paramActionSheetItem = new Intent();
                    localObject1 = new Bundle();
                    ((Bundle)localObject1).putInt("forward_type", 9);
                    ((Bundle)localObject1).putBoolean("forward_emotion_from_preview", true);
                    paramActionSheetItem.putExtras((Bundle)localObject1);
                    paramActionSheetItem.putExtras((Bundle)localObject3);
                    ForwardBaseOption.a(super.getBaseActivity(), paramActionSheetItem, ForwardRecentTranslucentActivity.class, 21, 100500, "biz_src_jc_gif");
                    return;
                  }
                  ((Bundle)localObject3).putBoolean("key_help_forward_pic", true);
                  paramActionSheetItem = PicItemBuilder.b((MessageForPic)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (QQAppInterface)localObject1, this.jdField_a_of_type_AndroidContentContext);
                  paramActionSheetItem.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getBaseActivity().getClass().getName());
                  paramActionSheetItem.putExtras((Bundle)localObject3);
                  ForwardBaseOption.a(super.getBaseActivity(), paramActionSheetItem, ForwardRecentTranslucentActivity.class, 1, 100500, "biz_src_jc_gif");
                }
              }
              else
              {
                if (AnonymousChatHelper.a((MessageRecord)localObject2))
                {
                  paramActionSheetItem = AnonymousChatHelper.a((MessageRecord)localObject2);
                  if ((paramActionSheetItem.jdField_a_of_type_JavaLangString == null) && (paramActionSheetItem.jdField_a_of_type_Int != 2))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.i("AIOEmotionFragment", 2, "Anonymous report : an_id is null");
                    }
                    return;
                  }
                  localObject3 = paramActionSheetItem.a();
                  if ((localObject3 == null) || (paramActionSheetItem.jdField_a_of_type_Int == 2)) {
                    return;
                  }
                  paramActionSheetItem = URLEncoder.encode(Base64.encodeToString((byte[])localObject3, 2));
                  AnonymousChatHelper.a().a(((MessageRecord)localObject2).frienduin, paramActionSheetItem, (MessageRecord)localObject2);
                  NewReportPlugin.a((QQAppInterface)localObject1, ((MessageRecord)localObject2).frienduin, paramActionSheetItem, ((QQAppInterface)localObject1).getCurrentAccountUin(), AnonymousChatHelper.a().a(((MessageRecord)localObject2).frienduin, paramActionSheetItem));
                  return;
                }
                paramActionSheetItem = ((MessageRecord)localObject2).senderuin;
                NewReportPlugin.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, paramActionSheetItem, ((MessageRecord)localObject2).frienduin, ((QQAppInterface)localObject1).getCurrentAccountUin(), NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), null);
              }
            }
            else
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {
                paramInt = 1;
              } else {
                paramInt = 2;
              }
              ReportController.b(null, "dc00898", "", "", "0X8009EA7", "0X8009EA7", paramInt, 0, "", "", "", "");
              f();
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
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b;
            paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramActionSheetItem = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
            }
            AIOGalleryScene.a(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramActionSheetItem, ((MessageRecord)localObject2).time, ((MessageRecord)localObject2).shmsgseq, ((MessageRecord)localObject2).istroop, true);
          }
        }
        else
        {
          a("0X8009982");
          if ((localObject2 instanceof MessageForPic))
          {
            paramActionSheetItem = (MessageForPic)localObject2;
            PicItemBuilder.a((QQAppInterface)localObject1, paramActionSheetItem.senderuin, paramActionSheetItem.md5, "0X8009F3E", "");
          }
          if (i == 0)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo != null))
            {
              ((IEmoticonManagerService)((QQAppInterface)localObject1).getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, new AIOEmotionFragment.9(this, (QQAppInterface)localObject1));
              EmoticonOperateReport.reportFavAddEmotionEvent((AppInterface)localObject1, 2, null, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
              return;
            }
            paramActionSheetItem = new StringBuilder();
            paramActionSheetItem.append("error mEmoticon, ");
            if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {
              bool1 = true;
            }
            paramActionSheetItem.append(bool1);
            QLog.d("AIOEmotionFragment", 1, paramActionSheetItem.toString());
            return;
          }
          paramActionSheetItem = (MessageForPic)localObject2;
          localObject3 = URLDrawableHelper.getDrawable(URLDrawableHelper.getURL(paramActionSheetItem, 1), -1, -1, null, null, false);
          ((URLDrawable)localObject3).setTag(localObject2);
          this.jdField_a_of_type_JavaUtilList.add(localObject3);
          AIOGalleryUtils.a(this.jdField_a_of_type_AndroidContentContext, (QQAppInterface)localObject1, (URLDrawable)localObject3, ((MessageRecord)localObject2).frienduin, getBaseActivity().getResources().getDimensionPixelSize(2131299168), null, paramActionSheetItem.picExtraData);
          EmoticonOperateReport.reportFavAddEmotionEvent((AppInterface)localObject1, 2, paramActionSheetItem.md5, null);
          new AdEmoReportUtil().c((AppInterface)localObject1, null, paramActionSheetItem);
        }
      }
      else
      {
        a("0X8009983");
        paramActionSheetItem = AbsDownloader.getFile(URLDrawableHelper.getURL((MessageForPic)localObject2, 1).toString());
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
    if ((localObject2 instanceof MessageForPic))
    {
      paramActionSheetItem = (MessageForPic)localObject2;
      PicItemBuilder.a((QQAppInterface)localObject1, paramActionSheetItem.senderuin, paramActionSheetItem.md5, "0X8009F3D", "");
    }
    if (i == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null)
      {
        paramActionSheetItem = this.jdField_b_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo;
        if (paramActionSheetItem != null)
        {
          jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo = paramActionSheetItem;
          ((IEmoticonManagerService)((QQAppInterface)localObject1).getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, new AIOEmotionFragment.8(this, (QQAppInterface)localObject1));
          return;
        }
      }
      paramActionSheetItem = new StringBuilder();
      paramActionSheetItem.append("error mEmoticon, ");
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {
        bool1 = true;
      }
      paramActionSheetItem.append(bool1);
      QLog.d("AIOEmotionFragment", 1, paramActionSheetItem.toString());
      return;
    }
    paramActionSheetItem = PicItemBuilder.b((MessageForPic)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (QQAppInterface)localObject1, this.jdField_a_of_type_AndroidContentContext);
    paramActionSheetItem.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getBaseActivity().getClass().getName());
    ForwardBaseOption.a(super.getBaseActivity(), paramActionSheetItem, 1, 100500, "biz_src_jc_gif");
  }
  
  public void a(long paramLong)
  {
    EmotionDataSource localEmotionDataSource = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource;
    if ((localEmotionDataSource instanceof MsgEmotionDataSource)) {
      ((MsgEmotionDataSource)localEmotionDataSource).a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery, this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter, paramLong, this);
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (a())
    {
      Object localObject = (ImageView)paramView.findViewById(2131369216);
      ((ImageView)localObject).setPadding(0, ((ImageView)localObject).getPaddingTop(), ((ImageView)localObject).getPaddingRight(), ((ImageView)localObject).getPaddingBottom());
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      float f = 36;
      localLayoutParams.height = AIOUtils.b(f, getResources());
      localLayoutParams.width = AIOUtils.b(f, getResources());
      ((ImageView)localObject).setLayoutParams(localLayoutParams);
      paramView = (ImageView)paramView.findViewById(2131369217);
      paramView.setImageResource(2130841443);
      paramView.setVisibility(0);
      localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.b(f, getResources());
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.b(f, getResources());
      ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramView.setContentDescription(getString(2131718987));
      paramView.setOnClickListener(new AIOEmotionFragment.1(this));
    }
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase)
  {
    i();
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    paramAudioPlayerBase = new StringBuilder();
    paramAudioPlayerBase.append("AudioPlayer on onError, errorCode = ");
    paramAudioPlayerBase.append(paramInt);
    QLog.e("AIOEmotionFragment", 2, paramAudioPlayerBase.toString());
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131689865, 0).a();
    i();
  }
  
  public void a(List<EmoticonPreviewData> paramList, EmoticonPreviewData paramEmoticonPreviewData)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new AIOEmotionFragment.11(this, paramList, paramEmoticonPreviewData));
    }
  }
  
  public void a(boolean paramBoolean, MessageForPic paramMessageForPic)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.notifyDataSetChanged();
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    else
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131694998), 0).a();
    }
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView.b();
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.enableDoubleTap(true);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.enableScaleGesture(true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = AudioDeviceHelper.a(BaseApplicationImpl.getContext());
    boolean bool = AudioDeviceHelper.b(BaseApplicationImpl.getContext());
    AudioPanelAioHelper.a(getBaseActivity(), paramBoolean2, paramBoolean1, bool);
    if ((this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer.a()) && (!paramBoolean1) && (!bool)) {
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
    if ((this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer.a()) && (!paramBoolean1) && (!paramBoolean4)) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    b(paramBoolean1, paramBoolean3);
  }
  
  public boolean a()
  {
    return jdField_c_of_type_Int == 0;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition());
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject, Float.valueOf(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a()));
    }
    localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1002);
    ((Message)localObject).arg1 = 4;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject);
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
    Object localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1002);
    Long localLong = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition());
    float f;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localLong))
    {
      f = ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(localLong)).floatValue();
    }
    else
    {
      f = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
      this.jdField_a_of_type_JavaUtilHashMap.put(localLong, Float.valueOf(f));
    }
    int i;
    if (paramFloat > f) {
      i = 0;
    } else {
      i = 4;
    }
    ((Message)localObject).arg1 = i;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject);
  }
  
  protected void b(View paramView)
  {
    Intent localIntent = getBaseActivity().getIntent();
    this.jdField_a_of_type_AndroidGraphicsRect = ((Rect)localIntent.getParcelableExtra("KEY_THUMBNAL_BOUND"));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)localIntent.getParcelableExtra("session_info"));
    d();
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery = ((EmotionGallery)paramView.findViewById(2131367431));
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnScaleChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnScollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setSpacing(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297150));
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnItemLongClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnItemSelectedListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131378803));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131363349);
    this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)paramView.findViewById(2131365892));
    this.jdField_a_of_type_ComTencentWidgetDragView.init();
    this.jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetDragView.setDragChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362359));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131362360));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365553));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365551));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131366183);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365552));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365554));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369216));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362350));
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView = new GalleryProgressView();
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView.a(super.getBaseActivity(), this.jdField_c_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362357));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363041));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView = ((TriangleView)paramView.findViewById(2131372860));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363042));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = ((PttAudioPlayView)paramView.findViewById(2131363043));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)paramView.findViewById(2131363046));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setShowProgressLine(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPttPauseOrStopDrawable(2130838159);
    a(IPicEmoticonInfo.DEFAULT_AUDIO_WAVE_BACKGROUND_COLOR, IPicEmoticonInfo.DEFAULT_AUDIO_WAVE_FOREGROUND_COLOR);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372282));
    AIOGalleryMsgRevokeMgr.a().a(this);
    this.jdField_b_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_d_of_type_Int = ((int)(this.jdField_b_of_type_Float * 6.0F));
    if ((getBaseActivity().getIntent().getBooleanExtra("need_reload_data", true)) && (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource != null))
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append(" initData dataSource=");
        paramView.append(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource);
        QLog.d("AIOEmotionFragment", 2, paramView.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource.a(this, jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData, false);
    }
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!DeviceInfoUtil.j()))
    {
      if (this.jdField_d_of_type_AndroidViewView == null)
      {
        localObject = getBaseActivity();
        if (localObject == null) {
          return;
        }
        ((LayoutInflater)((Activity)localObject).getSystemService("layout_inflater")).inflate(2131558579, this.jdField_e_of_type_AndroidWidgetRelativeLayout);
        this.jdField_d_of_type_AndroidViewView = this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131362489);
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131362490));
        this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131362488));
        this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
        ((RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131366183);
      }
      this.jdField_d_of_type_AndroidViewView.bringToFront();
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      if (ThemeUtil.isNowThemeIsNight(a(), false, null)) {
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF737373"));
      }
      if (paramBoolean2)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131689946);
        this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130850304);
        return;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131689945);
      this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130850303);
      return;
    }
    Object localObject = this.jdField_d_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new AIOEmotionFragment.13(this));
  }
  
  public void c(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void d()
  {
    EmoticonPreviewData localEmoticonPreviewData = jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData;
    if (localEmoticonPreviewData == null)
    {
      QLog.d("AIOEmotionFragment", 1, "initDataResource fail");
      return;
    }
    if ((jdField_c_of_type_Int == 0) && ((localEmoticonPreviewData instanceof MsgEmoticonPreviewData))) {
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource = new MsgEmotionDataSource(getBaseActivity().getIntent(), (MsgEmoticonPreviewData)jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    } else if ((jdField_c_of_type_Int == 1) && ((jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData instanceof FavEmoticonPreviewData))) {
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource = new FavEmotionDataSource(a(), (FavEmoticonPreviewData)jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource == null)
    {
      QLog.d("AIOEmotionFragment", 1, "initDataResource fail dataSource is null.");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter = new EmotionAdapter(getBaseActivity(), this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData);
  }
  
  public void d(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo;
    if ((localObject != null) && (((IPicEmoticonInfo)localObject).isNewSoundType()))
    {
      localObject = EmotionPanelConstans.emoticonSoundPath.replace("[epId]", this.jdField_b_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId).replace("[eId]", this.jdField_b_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().eId);
      String str = paramAudioPlayerBase.a();
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new AIOEmotionFragment.12(this, str, (String)localObject, paramInt, paramAudioPlayerBase));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    int i = 0;
    Object localObject;
    switch (j)
    {
    default: 
      return true;
    case 1002: 
      j = paramMessage.arg1;
      if (j == 0)
      {
        paramMessage = (EmoticonPreviewData)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
        if (paramMessage != null)
        {
          if (paramMessage.a())
          {
            this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            return true;
          }
          if (paramMessage.a() == null) {
            i = 4;
          }
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(i);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(i);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(i);
          return true;
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(j);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(j);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(j);
        return true;
      }
      break;
    case 1001: 
      j = paramMessage.arg1;
      i = paramMessage.arg2;
      if ((j == this.jdField_b_of_type_Int) && (i == 0)) {
        return true;
      }
      if (j != this.jdField_b_of_type_Int) {
        i = 1;
      } else {
        i = 0;
      }
      this.jdField_b_of_type_Int = j;
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo = null;
      if (j != -1) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.a(j);
      } else {
        localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
      }
      localObject = (EmoticonPreviewData)localObject;
      if (localObject == null) {
        return true;
      }
      if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.a(j))) {
        return true;
      }
      if (this.jdField_c_of_type_Boolean)
      {
        if ((i != 0) && (c()))
        {
          QLog.d("AIOEmotionFragment", 2, "MSG_UPDATE_EMOTION_UI stopAudio");
          h();
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
        this.jdField_b_of_type_AndroidViewView.setVisibility(4);
        return true;
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if ((((EmoticonPreviewData)localObject).a()) && (j != -1))
      {
        float f2 = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
        EmoticonInfo localEmoticonInfo = ((EmoticonPreviewData)localObject).a();
        if (localEmoticonInfo != null)
        {
          if ((localEmoticonInfo instanceof IPicEmoticonInfo))
          {
            IPicEmoticonInfo localIPicEmoticonInfo = (IPicEmoticonInfo)localEmoticonInfo;
            if (localIPicEmoticonInfo.getEmoticon() != null)
            {
              float f1;
              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.a(j))) {
                f1 = ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.a(j))).floatValue();
              } else {
                f1 = f2;
              }
              if ((f1 > 0.0F) && (f2 <= f1))
              {
                this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
                this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
              }
              this.jdField_b_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo = localIPicEmoticonInfo;
              this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = localIPicEmoticonInfo.getEmoticon();
              this.jdField_a_of_type_AndroidWidgetTextView.setText(localIPicEmoticonInfo.getEmoticon().name);
              this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bringToFront();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("getView emotion name:");
              localStringBuilder.append(localIPicEmoticonInfo.getEmoticon().name);
              QLog.d("AIOEmotionFragment", 1, localStringBuilder.toString());
              if (a(localIPicEmoticonInfo))
              {
                paramMessage = (Drawable)paramMessage.obj;
                if ((paramMessage != null) && ((paramMessage instanceof URLDrawable))) {
                  this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((URLDrawable)paramMessage);
                }
              }
            }
          }
          b();
        }
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
        a(localEmoticonInfo);
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_b_of_type_AndroidViewView.setVisibility(4);
        if (((EmoticonPreviewData)localObject).c()) {
          a((MsgEmoticonPreviewData)localObject);
        }
        if (((EmoticonPreviewData)localObject).d()) {
          b((MsgEmoticonPreviewData)localObject);
        }
        a(j, (EmoticonPreviewData)localObject);
      }
      if (((localObject instanceof MsgEmoticonPreviewData)) && (!((EmoticonPreviewData)localObject).a()) && (!((MsgEmotionDataSource)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource).a((EmoticonPreviewData)localObject)))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView.a();
        this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView.a(0);
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.enableDoubleTap(false);
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.enableScaleGesture(false);
        ((MsgEmotionDataSource)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource).a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery, this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, (EmoticonPreviewData)localObject, this);
        return true;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView.b();
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.enableDoubleTap(true);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.enableScaleGesture(true);
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
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessage);
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
      paramIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_AndroidContentContext.getString(2131719442));
      paramIntent = new Bundle(paramIntent.getExtras());
      Intent localIntent = new Intent();
      localIntent.putExtras(paramIntent);
      if (super.a() != null) {
        ForwardUtils.a(super.a(), super.getBaseActivity(), this.jdField_a_of_type_AndroidContentContext, localIntent, ThreadManager.getUIHandler());
      }
    }
    else if ((paramInt2 == -1) && (paramInt1 == 2))
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1001);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1001, -1, 1).sendToTarget();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    boolean bool2 = false;
    Object localObject;
    if ((i != 2131362360) && (paramView.getId() != 2131362359))
    {
      if ((paramView.getId() != 2131363043) && (paramView.getId() != 2131363046))
      {
        if (paramView.getId() == 2131362489)
        {
          localObject = a();
          if (localObject != null)
          {
            boolean bool3 = AudioDeviceHelper.a(BaseApplicationImpl.getContext());
            boolean bool4 = AudioDeviceHelper.b(BaseApplicationImpl.getContext());
            boolean bool1 = this.jdField_a_of_type_Boolean ^ true;
            this.jdField_a_of_type_Boolean = bool1;
            AudioDeviceHelper.a(bool1, (AppRuntime)localObject);
            boolean bool5 = c();
            this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer.a(1, this.jdField_a_of_type_Boolean);
            AudioPanelAioHelper.a(getBaseActivity(), this.jdField_a_of_type_Boolean, bool3, bool4);
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
            b(bool1, this.jdField_a_of_type_Boolean);
          }
        }
      }
      else if (c())
      {
        h();
        localObject = this.jdField_b_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo;
        if ((localObject != null) && (((IPicEmoticonInfo)localObject).getEmoticon() != null)) {
          EmoticonOperateReport.reportNewSoundEvent(a(), "0X800A9E1", -1, this.jdField_b_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId);
        }
      }
      else
      {
        g();
        localObject = this.jdField_b_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo;
        if ((localObject != null) && (((IPicEmoticonInfo)localObject).getEmoticon() != null)) {
          EmoticonOperateReport.reportNewSoundEvent(a(), "0X800A9E0", -1, this.jdField_b_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId);
        }
      }
    }
    else if (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0)
    {
      localObject = (EmoticonPreviewData)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
      if (localObject != null)
      {
        CustomEmotionData localCustomEmotionData = ((EmoticonPreviewData)localObject).a();
        if (localCustomEmotionData != null)
        {
          if (!TextUtils.isEmpty(localCustomEmotionData.modifyWord)) {
            localObject = localCustomEmotionData.modifyWord;
          } else {
            localObject = localCustomEmotionData.ocrWord;
          }
          Intent localIntent = new Intent(getBaseActivity(), EditActivity.class);
          localIntent.putExtra("title", 2131691935);
          localIntent.putExtra("limit", 30);
          localIntent.putExtra("action", 105);
          localIntent.putExtra("key_emo_id", localCustomEmotionData.emoId);
          localIntent.putExtra("key_input_tip", getResources().getString(2131691936));
          localIntent.putExtra("current", (String)localObject);
          localIntent.putExtra("canPostNull", false);
          localIntent.putExtra("multiLine", false);
          ReportController.b(null, "dc00898", "", "", "0X800A7C1", "0X800A7C1", this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource.a(), 0, "", "", "", "");
          startActivityForResult(localIntent, 2);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onClickDragView() {}
  
  public void onContentMove(float paramFloat)
  {
    this.jdField_c_of_type_AndroidViewView.setAlpha(paramFloat);
    if (paramFloat < 0.9F)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    boolean bool = false;
    if (jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData == null) {
      bool = true;
    }
    QLog.d("AIOEmotionFragment", 1, new Object[] { "onCreate, mCurDataIsNull:", Boolean.valueOf(bool) });
    if (jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData == null) {
      try
      {
        jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData = EmoticonPreviewData.a(paramBundle);
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
    int i = 1;
    if (bool) {
      QLog.d("AIOEmotionFragment", 1, "onCreateView");
    }
    EmoticonPreviewData localEmoticonPreviewData = jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData;
    if ((localEmoticonPreviewData == null) || (!localEmoticonPreviewData.a())) {
      i = 2;
    }
    this.jdField_a_of_type_Int = i;
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$EmoticonDetailJsonDownloader != null)
    {
      ((IEmojiManagerService)a().getRuntimeService(IEmojiManagerService.class)).getEmojiListenerManager().removeEmotionJsonDownloadListener(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$EmoticonDetailJsonDownloader);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$EmoticonDetailJsonDownloader = null;
    }
    a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource;
    if (localObject != null) {
      ((EmotionDataSource)localObject).a();
    }
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((URLDrawable)((Iterator)localObject).next()).setTag(null);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer;
    if (localObject != null)
    {
      if (((CommonAudioPlayer)localObject).a()) {
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer.c();
      }
      localObject = a();
      if (localObject != null) {
        ((IAudioDeviceService)((QQAppInterface)localObject).getRuntimeService(IAudioDeviceService.class)).unRegisterAudioDeviceListener(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer);
      }
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerCommonAudioPlayer.k();
    }
    localObject = this.jdField_d_of_type_AndroidViewView;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(4);
      this.jdField_d_of_type_AndroidViewView = null;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView;
    if (localObject != null) {
      ((PttAudioPlayView)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView;
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
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource.a()) {
      a();
    }
    return false;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.a(paramInt))
    {
      this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(this.jdField_a_of_type_AndroidGraphicsRect);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(null);
  }
  
  public int[] onModifyCurViewSize()
  {
    Object localObject = (ImageView)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedView();
    if (localObject == null) {
      return null;
    }
    localObject = ((ImageView)localObject).getDrawable();
    if (localObject == null) {
      return null;
    }
    return new int[] { (int)(((Drawable)localObject).getIntrinsicWidth() * this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a()), (int)(((Drawable)localObject).getIntrinsicHeight() * this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a()) };
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void onPause()
  {
    super.onPause();
    if (c()) {
      h();
    }
  }
  
  public void onResetPosition()
  {
    EmoticonPreviewData localEmoticonPreviewData = (EmoticonPreviewData)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
    if (localEmoticonPreviewData == null) {
      return;
    }
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    int i = 0;
    localRelativeLayout.setVisibility(0);
    if (localEmoticonPreviewData.a())
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    if (localEmoticonPreviewData.c()) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    } else {
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    }
    if (localEmoticonPreviewData.a() == null) {
      i = 4;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(i);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(i);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(i);
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData != null)
    {
      QLog.d("AIOEmotionFragment", 1, "onSaveInstanceState");
      jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData.a(paramBundle, jdField_c_of_type_Int);
    }
  }
  
  public void onScrollEnd(int paramInt)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getView onScrollEnd:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" currentPosition:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition());
    localStringBuilder.append(" selectPos: ");
    localStringBuilder.append(i);
    localStringBuilder.append(" hasScrolled: ");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    QLog.d("AIOEmotionFragment", 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a() == this.jdField_a_of_type_Float) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1001);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1001, i, paramInt).sendToTarget();
  }
  
  public void onScrollStart(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getView onScrollStart:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" currentPosition:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition());
    localStringBuilder.append(" hasScrolled: ");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    QLog.d("AIOEmotionFragment", 1, localStringBuilder.toString());
    this.jdField_d_of_type_Boolean = true;
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1001);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1001, -1, 0).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment
 * JD-Core Version:    0.7.0.1
 */