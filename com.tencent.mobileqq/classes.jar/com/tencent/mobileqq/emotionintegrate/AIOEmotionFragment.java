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
import android.support.v4.app.FragmentActivity;
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
import com.tencent.av.audio.AudioSettingManager;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.GalleryProgressView;
import com.tencent.component.network.utils.Base64;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioDeviceManager;
import com.tencent.mobileqq.activity.aio.CommonAudioPlayer;
import com.tencent.mobileqq.activity.aio.CommonAudioPlayer.UIAudioDeivceChangedListern;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr.MsgRevokeListener;
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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.EmotionUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.magicface.drawable.PngFrameDrawable;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.AudioPlayerListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.RoundedColorDrawable;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.RichMediaShareActionSheetUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
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
  implements Handler.Callback, View.OnClickListener, CommonAudioPlayer.UIAudioDeivceChangedListern, AIOGalleryMsgRevokeMgr.MsgRevokeListener, EmotionDataSource.DataLoadListener, EmotionDownGIFCallback.UiCallback, EmotionGallery.OnScaleChangeListener, AudioPlayerBase.AudioPlayerListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener, DragView.OnDragChangeListener, DragView.OnGestureChangeListener, Gallery.OnScollListener
{
  public static PicEmoticonInfo a;
  public static EmoticonPreviewData a;
  private static int jdField_c_of_type_Int = 0;
  private float jdField_a_of_type_Float = 1.0F;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  GalleryProgressView jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView;
  private CommonAudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer;
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
  PicEmoticonInfo jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
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
    RoundedColorDrawable localRoundedColorDrawable = new RoundedColorDrawable(paramInt1, 1, 1, AIOUtils.a(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localRoundedColorDrawable);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setThemeColor(paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.postInvalidate();
  }
  
  private void a(int paramInt, EmoticonPreviewData paramEmoticonPreviewData)
  {
    paramEmoticonPreviewData = paramEmoticonPreviewData.a();
    float f2;
    if (paramEmoticonPreviewData != null)
    {
      f2 = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
      if (QLog.isColorLevel()) {
        QLog.d("AIOEmotionFragment", 2, "updateEmotionOcr scale=" + f2 + "originalScale=" + f2);
      }
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.a(paramInt))) {
        break label560;
      }
    }
    label529:
    label560:
    for (float f1 = ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.a(paramInt))).floatValue();; f1 = f2)
    {
      if ((f1 > 0.0F) && (f2 <= f1))
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
      if (!TextUtils.isEmpty(paramEmoticonPreviewData.modifyWord))
      {
        paramEmoticonPreviewData = paramEmoticonPreviewData.modifyWord;
        if (!TextUtils.isEmpty(paramEmoticonPreviewData)) {
          break label529;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167127));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692010));
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bringToFront();
        if ((b()) && (SharedPreUtils.E(this.jdField_a_of_type_AndroidContentContext, a().getCurrentUin())))
        {
          SharedPreUtils.x(this.jdField_a_of_type_AndroidContentContext, a().getCurrentUin(), false);
          paramEmoticonPreviewData = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
          paramEmoticonPreviewData.setOrientation(1);
          paramEmoticonPreviewData.setGravity(1);
          Object localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839040));
          paramEmoticonPreviewData.addView((View)localObject);
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
          localLayoutParams.bottomMargin = (-AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.topMargin = AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
          ((TextView)localObject).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167374));
          ((TextView)localObject).setTextSize(14.0F);
          ((TextView)localObject).setGravity(17);
          ((TextView)localObject).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692022));
          ((TextView)localObject).setBackgroundResource(2130839044);
          paramEmoticonPreviewData.addView((View)localObject);
          paramInt = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((TextView)localObject).setPadding(paramInt, 0, paramInt, 0);
          paramEmoticonPreviewData = new PopupWindow(paramEmoticonPreviewData, -2, -2);
          paramEmoticonPreviewData.setBackgroundDrawable(new ColorDrawable(0));
          paramEmoticonPreviewData.setOutsideTouchable(true);
          paramEmoticonPreviewData.setFocusable(true);
          ((TextView)localObject).measure(0, 0);
          this.jdField_a_of_type_AndroidWidgetTextView.post(new AIOEmotionFragment.4(this, paramEmoticonPreviewData, (TextView)localObject));
        }
        return;
        paramEmoticonPreviewData = paramEmoticonPreviewData.ocrWord;
        break;
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165357));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramEmoticonPreviewData);
      }
    }
  }
  
  public static void a(Context paramContext, MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, Rect paramRect)
  {
    a(paramContext, paramMessageRecord, paramSessionInfo, paramRect, true, true);
  }
  
  public static void a(Context paramContext, MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
  {
    jdField_c_of_type_Int = 0;
    boolean bool;
    if (((paramContext instanceof ChatHistoryActivity)) || ((paramContext instanceof ChatHistory))) {
      bool = true;
    }
    for (;;)
    {
      e();
      if (paramRect != null)
      {
        paramRect.top -= ImmersiveUtils.getStatusBarHeight(paramContext);
        paramRect.bottom -= ImmersiveUtils.getStatusBarHeight(paramContext);
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("enterEmotionPreview, type:");
        if (MessageForMarketFace.class.isInstance(paramMessageRecord))
        {
          localObject = "Emotion";
          label90:
          QLog.i("AIOEmotionFragment", 2, (String)localObject);
        }
      }
      else
      {
        jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData = new MsgEmoticonPreviewData(paramMessageRecord);
        localObject = new Intent();
        ((Intent)localObject).putExtra("session_info", paramSessionInfo);
        ((Intent)localObject).putExtra("from_chat_history", bool);
        ((Intent)localObject).putExtra("hide_emo_position", paramBoolean1);
        ((Intent)localObject).putExtra("need_reload_data", paramBoolean2);
        ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
        if (paramRect != null) {
          ((Intent)localObject).putExtra("KEY_THUMBNAL_BOUND", paramRect);
        }
        if (!(paramContext instanceof ChatHistory)) {
          break label304;
        }
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatHistory.class.getName());
      }
      for (;;)
      {
        if ((paramContext instanceof ChatHistoryActivity)) {
          ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatHistoryActivity.class.getName());
        }
        if ((!ChatHistoryActivity.a(paramContext, (Intent)localObject)) || (!(paramContext instanceof Activity))) {
          break label364;
        }
        PublicFragmentActivity.Launcher.a((Activity)paramContext, (Intent)localObject, PublicTransFragmentActivity.class, AIOEmotionFragment.class, 38);
        return;
        if ((!(paramContext instanceof PublicFragmentActivity)) || (!(((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment))) {
          break label375;
        }
        bool = true;
        break;
        localObject = "GIF";
        break label90;
        label304:
        if (((paramContext instanceof MultiForwardActivity)) && (paramMessageRecord.isMultiMsg) && (((MultiForwardActivity)paramContext).getIntent() != null))
        {
          ((Intent)localObject).putExtra("key_multi_forward_seq", ((MultiForwardActivity)paramContext).getIntent().getLongExtra("origin_merge_structing_msg_uniseq", 0L));
          ((Intent)localObject).putExtra("key_is_multi_forward_msg", true);
        }
      }
      label364:
      PublicFragmentActivity.Launcher.a((Intent)localObject, PublicTransFragmentActivity.class, AIOEmotionFragment.class);
      return;
      label375:
      bool = false;
    }
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
    PublicFragmentActivity.Launcher.a(localIntent, PublicTransFragmentActivity.class, AIOEmotionFragment.class);
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$EmoticonDetailJsonDownloader == null) {
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$EmoticonDetailJsonDownloader = new AIOEmotionFragment.EmoticonDetailJsonDownloader(this);
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null))
    {
      QLog.d("AIOEmotionFragment", 1, "error in json downloading");
      if (paramInt == 32) {}
      a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$EmoticonDetailJsonDownloader.a(paramInt, paramQQAppInterface, getActivity(), this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null);
    EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$EmoticonDetailJsonDownloader);
    ((EmojiManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, EmojiManager.jdField_c_of_type_Int);
  }
  
  private void a(EmoticonInfo paramEmoticonInfo)
  {
    label60:
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 2))
    {
      i = 1;
      if ((i == 0) || (paramEmoticonInfo == null)) {
        break label315;
      }
      a("0X800997E");
      if ((!(paramEmoticonInfo instanceof PicEmoticonInfo)) || (!((PicEmoticonInfo)paramEmoticonInfo).isNewSoundType())) {
        break label259;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setClickable(true);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new AIOEmotionFragment.7(this));
      paramEmoticonInfo = paramEmoticonInfo.getDrawable(getActivity(), this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramEmoticonInfo);
      paramEmoticonInfo = null;
      localObject = EmotionDataManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      if (localObject != null) {
        paramEmoticonInfo = ((EmoticonPackage)localObject).name;
      }
      localObject = a();
      if (localObject == null) {
        break label324;
      }
      if (TextUtils.isEmpty(paramEmoticonInfo)) {
        break label282;
      }
      if (paramEmoticonInfo.length() <= 11) {
        break label271;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramEmoticonInfo.substring(0, 10) + "...");
      label201:
      if (!((EmoticonManager)((QQAppInterface)localObject).getManager(QQManagerFactory.EMOTICON_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId)) {
        break label324;
      }
    }
    label259:
    label271:
    label282:
    label315:
    label324:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700106));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        return;
        i = 0;
        break;
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label60;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramEmoticonInfo);
        break label201;
        a((QQAppInterface)localObject, 4);
        break label201;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700105));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      return;
    }
  }
  
  private void a(MsgEmoticonPreviewData paramMsgEmoticonPreviewData)
  {
    a("0X800A7E6");
    paramMsgEmoticonPreviewData = (MessageForPic)paramMsgEmoticonPreviewData.a;
    int i = paramMsgEmoticonPreviewData.picExtraData.from;
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bringToFront();
    if (!TextUtils.isEmpty(paramMsgEmoticonPreviewData.picExtraData.source))
    {
      if (paramMsgEmoticonPreviewData.picExtraData.source.length() > 11) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramMsgEmoticonPreviewData.picExtraData.source.substring(0, 10) + "...");
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setClickable(true);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new AIOEmotionFragment.5(this, i, paramMsgEmoticonPreviewData));
      if (i != 1) {
        break label295;
      }
      if (!((EmoticonManager)a().getManager(QQManagerFactory.EMOTICON_MANAGER)).b(paramMsgEmoticonPreviewData.picExtraData.emojiPkgId)) {
        break label328;
      }
    }
    label295:
    label328:
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689935));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-7829368);
      }
      for (;;)
      {
        paramMsgEmoticonPreviewData = PicItemBuilder.a(paramMsgEmoticonPreviewData);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
        localURLDrawableOptions.mGifRoundCorner = this.jdField_d_of_type_Int;
        localURLDrawableOptions.mPlayGifImage = true;
        paramMsgEmoticonPreviewData = URLDrawable.getDrawable(paramMsgEmoticonPreviewData, localURLDrawableOptions);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMsgEmoticonPreviewData);
        return;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramMsgEmoticonPreviewData.picExtraData.source);
        break;
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689936));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        continue;
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689937));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      }
    }
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
  
  private boolean a(PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramPicEmoticonInfo == null) || (!paramPicEmoticonInfo.isNewSoundType())) {}
    while (paramPicEmoticonInfo.getWaveformArray() == null) {
      return false;
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
    QLog.d("AIOEmotionFragment", 2, "tryUpdateNewAudioEmoAudioInfo");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setMaxTopBottomPadding(4);
    localLayoutParams.width = AIOUtils.a(39.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramPicEmoticonInfo.getWaveformArray(), AIOUtils.a(39.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), paramPicEmoticonInfo.getVoiceLength());
    a(paramPicEmoticonInfo.getWaveBackgroundColor(), paramPicEmoticonInfo.getWaveForegroundColor());
    return true;
  }
  
  private void b(MsgEmoticonPreviewData paramMsgEmoticonPreviewData)
  {
    Object localObject = (MessageForPic)paramMsgEmoticonPreviewData.a;
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bringToFront();
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691960));
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setClickable(true);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new AIOEmotionFragment.6(this, paramMsgEmoticonPreviewData));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692804));
    paramMsgEmoticonPreviewData = PicItemBuilder.a((MessageForPic)localObject);
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
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
        if ((localObject instanceof PngFrameDrawable))
        {
          i = AIOUtils.a(100.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          this.jdField_a_of_type_Float = f;
          localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(i * f / 2.0F) + AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("AIOEmotionFragment", 2, new Object[] { "updateEmotionNameLayout scale:", Float.valueOf(f), " topMargin:", Integer.valueOf(((RelativeLayout.LayoutParams)localObject).topMargin) });
          }
          if (i <= 0) {
            break label229;
          }
        }
        label229:
        for (boolean bool = true;; bool = false)
        {
          return bool;
          i = ((Drawable)localObject).getIntrinsicHeight();
          break;
        }
      }
    }
    return false;
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a();
  }
  
  private static void e()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = MediaPlayerManager.a((QQAppInterface)localObject);
        if (((((MediaPlayerManager)localObject).a() instanceof MessageForMarketFace)) && (((MediaPlayerManager)localObject).a())) {
          ((MediaPlayerManager)localObject).a(true);
        }
      }
      return;
    }
  }
  
  private void f()
  {
    Object localObject = (EmoticonPreviewData)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
    if (!(localObject instanceof MsgEmoticonPreviewData)) {
      return;
    }
    localObject = ((MsgEmoticonPreviewData)localObject).a;
    ChatHistoryActivity.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, ((MessageRecord)localObject).uniseq);
  }
  
  private void g()
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer = new CommonAudioPlayer(this.jdField_a_of_type_AndroidContentContext, this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a(this);
      localObject1 = a();
      if (localObject1 != null) {
        AudioDeviceManager.a((QQAppInterface)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.d();
    Object localObject2;
    if (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null)
    {
      localObject2 = EmoticonUtils.emoticonSoundPath.replace("[epId]", this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId).replace("[eId]", this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.eId);
      this.jdField_b_of_type_Boolean = false;
      localObject1 = a();
      if (localObject1 != null)
      {
        this.jdField_a_of_type_Boolean = ((QQAppInterface)localObject1).getLoudSpeakerState();
        MediaPlayerManager localMediaPlayerManager = MediaPlayerManager.a((QQAppInterface)localObject1);
        if (localMediaPlayerManager.a()) {
          localMediaPlayerManager.a(true);
        }
      }
      boolean bool3 = AudioSettingManager.a(BaseApplicationImpl.getContext());
      boolean bool2 = AudioHelper.a(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.b(1);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a((String)localObject2)) {
        break label417;
      }
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (bool3) {
          bool1 = AudioHelper.b(BaseApplicationImpl.getContext());
        }
      }
      BaseChatPie.b(getActivity(), this.jdField_a_of_type_Boolean, bool3, bool1);
      if ((bool3) || (bool1)) {
        break label404;
      }
      bool1 = true;
      b(bool1, this.jdField_a_of_type_Boolean);
      localObject2 = getActivity();
      if (localObject2 != null) {
        ((Activity)localObject2).getWindow().addFlags(128);
      }
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject2 = (URLDrawable)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject2 != null) {
          EmotionUtils.startSoundDrawablePlay((URLDrawable)localObject2);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(true);
    }
    label404:
    label417:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1) {
        EmoticonManager.a((QQAppInterface)localObject1, "0X800A935", -1, this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
      }
      localObject2 = new HashMap();
      if (bool1) {}
      for (localObject1 = "0";; localObject1 = "1")
      {
        ((HashMap)localObject2).put("playResult", localObject1);
        ((HashMap)localObject2).put("playType", "2");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "NewAudioEmoticonVoicePlay", bool1, 0L, 0L, (HashMap)localObject2, null);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer != null)
    {
      i();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.d();
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPlayState(false);
    b(false, false);
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.getWindow().clearFlags(128);
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2131558639, paramViewGroup, false);
  }
  
  protected void a()
  {
    boolean bool = false;
    Object localObject1 = (EmoticonPreviewData)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
    Object localObject2;
    int i;
    if ((localObject1 instanceof MsgEmoticonPreviewData))
    {
      localObject2 = ((MsgEmoticonPreviewData)localObject1).a;
      if (((localObject2 instanceof MessageForPic)) && (((MessageForPic)localObject2).picExtraData != null)) {
        if ((((MessageForPic)localObject2).picExtraData.isZhitu()) && (!((MessageRecord)localObject2).isSend())) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null)
      {
        localObject2 = new ShareActionSheetV2.Param();
        ((ShareActionSheetV2.Param)localObject2).context = this.jdField_a_of_type_AndroidContentContext;
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131692825));
      }
      localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      RichMediaShareActionSheetUtil.a(2, (ArrayList)localObject2);
      RichMediaShareActionSheetUtil.a(48, localArrayList);
      if (!getActivity().getIntent().getBooleanExtra("from_chat_history", false)) {
        RichMediaShareActionSheetUtil.a(65, localArrayList);
      }
      if ((localObject1 != null) && (!((EmoticonPreviewData)localObject1).a())) {
        RichMediaShareActionSheetUtil.a(39, localArrayList);
      }
      if (getActivity().getIntent().getBooleanExtra("hide_emo_position", true)) {
        RichMediaShareActionSheetUtil.a(54, localArrayList);
      }
      if (i != 0) {
        RichMediaShareActionSheetUtil.a(66, localArrayList);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new AIOEmotionFragment.2(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems((List)localObject2, localArrayList);
      if (getActivity() != null) {
        getActivity().getIntent().putExtra("big_brother_source_key", "biz_src_jc_gif");
      }
      localObject2 = a();
      if (((localObject1 instanceof MsgEmoticonPreviewData)) && (localObject2 != null))
      {
        localObject1 = ((MsgEmoticonPreviewData)localObject1).a;
        if ((localObject1 instanceof MessageForMarketFace)) {
          i = 0;
        }
        for (;;)
        {
          if (i == 0)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null))
            {
              jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
              ((EmoticonManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.EMOTICON_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, new AIOEmotionFragment.3(this, (QQAppInterface)localObject2));
              return;
              i = 0;
              break;
              i = 1;
              continue;
            }
            localObject1 = new StringBuilder().append("error mEmoticon, ");
            if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {
              bool = true;
            }
            QLog.d("AIOEmotionFragment", 1, bool);
          }
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
        return;
        localObject1 = PicItemBuilder.b((MessageForPic)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (QQAppInterface)localObject2, this.jdField_a_of_type_AndroidContentContext);
        ((Intent)localObject1).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getActivity().getClass().getName());
        ((Intent)localObject1).putExtra("key_new_img_shareactionsheet", 1);
        ((Intent)localObject1).putExtra("k_dataline", true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity((Intent)localObject1);
      }
      i = 0;
    }
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOEmotionFragment", 2, "onScaleEnd scale:" + paramFloat);
    }
    Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1002);
    Long localLong = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition());
    float f;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localLong))
    {
      f = ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(localLong)).floatValue();
      if (paramFloat <= f) {
        break label124;
      }
    }
    label124:
    for (int i = 4;; i = 0)
    {
      localMessage.arg1 = i;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
      return;
      f = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
      break;
    }
  }
  
  public void a(int paramInt)
  {
    QLog.d("AIOEmotionFragment", 1, "getView onScrollStart:" + paramInt + " currentPosition:" + this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition() + " hasScrolled: " + this.jdField_c_of_type_Boolean);
    this.jdField_d_of_type_Boolean = true;
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1001);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1001, -1, 0).sendToTarget();
    }
  }
  
  public void a(int paramInt, MessageForPic paramMessageForPic)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView.a(paramInt / 100);
  }
  
  protected void a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    Object localObject1 = a();
    if (localObject1 == null) {
      QLog.d("AIOEmotionFragment", 1, "error runtime");
    }
    Object localObject2;
    Object localObject3;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("AIOEmotionFragment", 1, "handleClickMenuItem, action:" + paramInt);
            }
            localObject2 = (EmoticonPreviewData)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
          } while (!(localObject2 instanceof MsgEmoticonPreviewData));
          localObject2 = ((MsgEmoticonPreviewData)localObject2).a;
          int i;
          if ((localObject2 instanceof MessageForMarketFace)) {
            i = 0;
          }
          boolean bool;
          switch (paramInt)
          {
          default: 
            return;
          case 2: 
          case 73: 
            a("0X8009981");
            if ((localObject2 instanceof MessageForPic)) {
              PicItemBuilder.a((QQAppInterface)localObject1, ((MessageForPic)localObject2).senderuin, ((MessageForPic)localObject2).md5, "0X8009F3D", "");
            }
            if (i == 0)
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) || (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null))
              {
                paramActionSheetItem = new StringBuilder().append("error mEmoticon, ");
                if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {}
                for (bool = true;; bool = false)
                {
                  QLog.d("AIOEmotionFragment", 1, bool);
                  return;
                  i = 1;
                  break;
                }
              }
              jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
              ((EmoticonManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.EMOTICON_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, new AIOEmotionFragment.8(this, (QQAppInterface)localObject1));
              return;
            }
            paramActionSheetItem = PicItemBuilder.b((MessageForPic)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (QQAppInterface)localObject1, this.jdField_a_of_type_AndroidContentContext);
            paramActionSheetItem.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getActivity().getClass().getName());
            ForwardBaseOption.a(super.getActivity(), paramActionSheetItem, 1, 100500, "biz_src_jc_gif");
            return;
          case 72: 
            localObject3 = new Bundle();
            ((Bundle)localObject3).putInt("key_req", ForwardRecentActivity.f);
            ((Bundle)localObject3).putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
            ((Bundle)localObject3).putString("key_direct_show_uin", paramActionSheetItem.uin);
            if (i == 0)
            {
              if (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null)
              {
                QLog.e("AIOEmotionFragment", 2, "ACTION_SEND_TO_SPECIFIED_FRIEND mPicEmotionInfo is null");
                return;
              }
              jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
              paramActionSheetItem = new Intent();
              localObject1 = new Bundle();
              ((Bundle)localObject1).putInt("forward_type", 9);
              ((Bundle)localObject1).putBoolean("forward_emotion_from_preview", true);
              paramActionSheetItem.putExtras((Bundle)localObject1);
              paramActionSheetItem.putExtras((Bundle)localObject3);
              ForwardBaseOption.a(super.getActivity(), paramActionSheetItem, ForwardRecentTranslucentActivity.class, 21, 100500, "biz_src_jc_gif");
              return;
            }
            ((Bundle)localObject3).putBoolean("key_help_forward_pic", true);
            paramActionSheetItem = PicItemBuilder.b((MessageForPic)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (QQAppInterface)localObject1, this.jdField_a_of_type_AndroidContentContext);
            paramActionSheetItem.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getActivity().getClass().getName());
            paramActionSheetItem.putExtras((Bundle)localObject3);
            ForwardBaseOption.a(super.getActivity(), paramActionSheetItem, ForwardRecentTranslucentActivity.class, 1, 100500, "biz_src_jc_gif");
            return;
          case 48: 
            a("0X8009982");
            if ((localObject2 instanceof MessageForPic)) {
              PicItemBuilder.a((QQAppInterface)localObject1, ((MessageForPic)localObject2).senderuin, ((MessageForPic)localObject2).md5, "0X8009F3E", "");
            }
            if (i == 0)
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) || (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null))
              {
                paramActionSheetItem = new StringBuilder().append("error mEmoticon, ");
                if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {}
                for (bool = true;; bool = false)
                {
                  QLog.d("AIOEmotionFragment", 1, bool);
                  return;
                }
              }
              ((EmoticonManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.EMOTICON_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, new AIOEmotionFragment.9(this, (QQAppInterface)localObject1));
              EmoticonUtils.reportFavAddEmotionEvent((QQAppInterface)localObject1, 2, null, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
              return;
            }
            paramActionSheetItem = URLDrawableHelper.getDrawable(URLDrawableHelper.getURL((MessageForPic)localObject2, 1), -1, -1, null, null, false);
            paramActionSheetItem.setTag(localObject2);
            this.jdField_a_of_type_JavaUtilList.add(paramActionSheetItem);
            AIOGalleryUtils.a(this.jdField_a_of_type_AndroidContentContext, (QQAppInterface)localObject1, paramActionSheetItem, ((MessageRecord)localObject2).frienduin, getActivity().getResources().getDimensionPixelSize(2131299166), null, ((MessageForPic)localObject2).picExtraData);
            EmoticonUtils.reportFavAddEmotionEvent((QQAppInterface)localObject1, 2, ((MessageForPic)localObject2).md5, null);
            new AdEmoReportUtil().c((QQAppInterface)localObject1, null, (MessageForPic)localObject2);
            return;
          case 39: 
            a("0X8009983");
            paramActionSheetItem = AbsDownloader.getFile(URLDrawableHelper.getURL((MessageForPic)localObject2, 1).toString());
          }
        } while (paramActionSheetItem == null);
        AIOGalleryUtils.a(getActivity(), paramActionSheetItem, Utils.Crc64String(paramActionSheetItem.getAbsolutePath() + NetConnInfoCenter.getServerTime()));
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) {}
        for (paramInt = 2;; paramInt = 1)
        {
          ReportController.b(null, "dc00898", "", "", "0X8009EA7", "0X8009EA7", paramInt, 0, "", "", "", "");
          f();
          return;
        }
        if (getActivity().getIntent().getBooleanExtra("from_chat_history", false)) {}
        for (paramInt = 2;; paramInt = 1)
        {
          ReportController.b(null, "dc00898", "", "", "0X8009EA8", "0X8009EA8", paramInt, 0, "", "", "", "");
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b;
          paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramActionSheetItem = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          }
          AIOGalleryScene.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramActionSheetItem, ((MessageRecord)localObject2).time, ((MessageRecord)localObject2).shmsgseq, ((MessageRecord)localObject2).istroop, true);
          return;
        }
        if (!AnonymousChatHelper.a((MessageRecord)localObject2)) {
          break label1216;
        }
        paramActionSheetItem = AnonymousChatHelper.a((MessageRecord)localObject2);
        if ((paramActionSheetItem.jdField_a_of_type_JavaLangString != null) || (paramActionSheetItem.jdField_a_of_type_Int == 2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("AIOEmotionFragment", 2, "Anonymous report : an_id is null");
      return;
      localObject3 = paramActionSheetItem.a();
    } while ((localObject3 == null) || (paramActionSheetItem.jdField_a_of_type_Int == 2));
    paramActionSheetItem = URLEncoder.encode(Base64.encodeToString((byte[])localObject3, 2));
    AnonymousChatHelper.a().a(((MessageRecord)localObject2).frienduin, paramActionSheetItem, (MessageRecord)localObject2);
    NewReportPlugin.a((QQAppInterface)localObject1, ((MessageRecord)localObject2).frienduin, paramActionSheetItem, ((QQAppInterface)localObject1).getCurrentAccountUin(), AnonymousChatHelper.a().a(((MessageRecord)localObject2).frienduin, paramActionSheetItem));
    return;
    label1216:
    paramActionSheetItem = ((MessageRecord)localObject2).senderuin;
    NewReportPlugin.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, paramActionSheetItem, ((MessageRecord)localObject2).frienduin, ((QQAppInterface)localObject1).getCurrentAccountUin(), NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), null);
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource instanceof MsgEmotionDataSource)) {
      ((MsgEmotionDataSource)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource).a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery, this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter, paramLong, this);
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (a())
    {
      Object localObject = (ImageView)paramView.findViewById(2131369501);
      ((ImageView)localObject).setPadding(0, ((ImageView)localObject).getPaddingTop(), ((ImageView)localObject).getPaddingRight(), ((ImageView)localObject).getPaddingBottom());
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      localLayoutParams.height = AIOUtils.a(36, getResources());
      localLayoutParams.width = AIOUtils.a(36, getResources());
      ((ImageView)localObject).setLayoutParams(localLayoutParams);
      paramView = (ImageView)paramView.findViewById(2131369502);
      paramView.setImageResource(2130841560);
      paramView.setVisibility(0);
      localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.a(36, getResources());
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.a(36, getResources());
      ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramView.setContentDescription(getString(2131719269));
      paramView.setOnClickListener(new AIOEmotionFragment.1(this));
    }
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase)
  {
    i();
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    QLog.e("AIOEmotionFragment", 2, "AudioPlayer on onError, errorCode = " + paramInt);
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131689950, 0).a();
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
    for (;;)
    {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView.b();
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.b(true);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a(true);
      return;
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131695008), 0).a();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = AudioSettingManager.a(BaseApplicationImpl.getContext());
    boolean bool = AudioHelper.a(BaseApplicationImpl.getContext());
    BaseChatPie.b(getActivity(), paramBoolean2, paramBoolean1, bool);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a()) && (!paramBoolean1) && (!bool)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      b(paramBoolean1, paramBoolean2);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    paramBoolean4 = paramBoolean2;
    if (paramBoolean2)
    {
      paramBoolean4 = paramBoolean2;
      if (paramBoolean1) {
        paramBoolean4 = AudioHelper.b(BaseApplicationImpl.getContext());
      }
    }
    BaseChatPie.b(getActivity(), paramBoolean3, paramBoolean1, paramBoolean4);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a()) && (!paramBoolean1) && (!paramBoolean4)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      b(paramBoolean1, paramBoolean3);
      return;
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("AIOEmotionFragment", 2, "onDoubleTap currScale:" + paramFloat);
    }
    Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1002);
    Long localLong = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition());
    float f;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localLong))
    {
      f = ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(localLong)).floatValue();
      if (paramFloat <= f) {
        break label138;
      }
    }
    label138:
    for (int i = 0;; i = 4)
    {
      localMessage.arg1 = i;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
      return;
      f = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
      this.jdField_a_of_type_JavaUtilHashMap.put(localLong, Float.valueOf(f));
      break;
    }
  }
  
  public void b(int paramInt)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition();
    QLog.d("AIOEmotionFragment", 1, "getView onScrollEnd:" + paramInt + " currentPosition:" + this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition() + " selectPos: " + i + " hasScrolled: " + this.jdField_c_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a() == this.jdField_a_of_type_Float) {}
    for (paramInt = 0;; paramInt = 1)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1001);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1001, i, paramInt).sendToTarget();
      return;
    }
  }
  
  protected void b(View paramView)
  {
    Intent localIntent = getActivity().getIntent();
    this.jdField_a_of_type_AndroidGraphicsRect = ((Rect)localIntent.getParcelableExtra("KEY_THUMBNAL_BOUND"));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)localIntent.getParcelableExtra("session_info"));
    d();
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery = ((EmotionGallery)paramView.findViewById(2131367677));
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnScaleChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnScollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setSpacing(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297168));
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnItemLongClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnItemSelectedListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131379451));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131363419);
    this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)paramView.findViewById(2131366062));
    this.jdField_a_of_type_ComTencentWidgetDragView.init();
    this.jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetDragView.setDragChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362403));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131362404));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365716));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365714));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131366295);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365715));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365717));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369501));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362394));
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView = new GalleryProgressView();
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView.a(super.getActivity(), this.jdField_c_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362401));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363101));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView = ((TriangleView)paramView.findViewById(2131373284));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363102));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView = ((PttAudioPlayView)paramView.findViewById(2131363103));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)paramView.findViewById(2131363106));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setShowProgressLine(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setPttPauseOrStopDrawable(2130838330);
    a(PicEmoticonInfo.DEFAULT_AUDIO_WAVE_BACKGROUND_COLOR, PicEmoticonInfo.DEFAULT_AUDIO_WAVE_FOREGROUND_COLOR);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372704));
    AIOGalleryMsgRevokeMgr.a().a(this);
    this.jdField_b_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_d_of_type_Int = ((int)(this.jdField_b_of_type_Float * 6.0F));
    if ((getActivity().getIntent().getBooleanExtra("need_reload_data", true)) && (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOEmotionFragment", 2, " initData dataSource=" + this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource);
      }
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource.a(this, jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData, false);
    }
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!DeviceInfoUtil.h())) {
      if (this.jdField_d_of_type_AndroidViewView == null)
      {
        localFragmentActivity = getActivity();
        if (localFragmentActivity != null) {}
      }
    }
    while (this.jdField_d_of_type_AndroidViewView == null)
    {
      FragmentActivity localFragmentActivity;
      return;
      ((LayoutInflater)localFragmentActivity.getSystemService("layout_inflater")).inflate(2131558681, this.jdField_e_of_type_AndroidWidgetRelativeLayout);
      this.jdField_d_of_type_AndroidViewView = this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131362533);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131362534));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131362532));
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      ((RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131366295);
      this.jdField_d_of_type_AndroidViewView.bringToFront();
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      if (ThemeUtil.isNowThemeIsNight(a(), false, null)) {
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF737373"));
      }
      if (paramBoolean2)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131690031);
        this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130850377);
        return;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131690030);
      this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130850376);
      return;
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new AIOEmotionFragment.13(this));
  }
  
  public void c(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void d()
  {
    if (jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData == null)
    {
      QLog.d("AIOEmotionFragment", 1, "initDataResource fail");
      return;
    }
    if ((jdField_c_of_type_Int == 0) && ((jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData instanceof MsgEmoticonPreviewData))) {}
    for (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource = new MsgEmotionDataSource(getActivity().getIntent(), (MsgEmoticonPreviewData)jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo); this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource == null; this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource = new FavEmotionDataSource(a(), (FavEmoticonPreviewData)jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData))
    {
      label59:
      QLog.d("AIOEmotionFragment", 1, "initDataResource fail dataSource is null.");
      return;
      if ((jdField_c_of_type_Int != 1) || (!(jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData instanceof FavEmoticonPreviewData))) {
        break label59;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter = new EmotionAdapter(getActivity(), this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData);
  }
  
  public void d(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isNewSoundType()))
    {
      String str1 = EmoticonUtils.emoticonSoundPath.replace("[epId]", this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId).replace("[eId]", this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.eId);
      String str2 = paramAudioPlayerBase.a();
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new AIOEmotionFragment.12(this, str2, str1, paramInt, paramAudioPlayerBase));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 0;
    int j;
    label139:
    Object localObject;
    label278:
    label290:
    float f2;
    EmoticonInfo localEmoticonInfo;
    PicEmoticonInfo localPicEmoticonInfo;
    switch (paramMessage.what)
    {
    default: 
    case 1000: 
    case 1001: 
      do
      {
        do
        {
          return true;
        } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof String)));
        paramMessage = (String)paramMessage.obj;
        if (QLog.isColorLevel()) {
          QLog.d("AIOEmotionFragment", 2, "update album name:" + paramMessage);
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessage);
        return true;
        j = paramMessage.arg1;
        i = paramMessage.arg2;
      } while ((j == this.jdField_b_of_type_Int) && (i == 0));
      if (j != this.jdField_b_of_type_Int)
      {
        i = 1;
        this.jdField_b_of_type_Int = j;
        this.jdField_a_of_type_JavaLangRefWeakReference = null;
        this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = null;
        if (j == -1) {
          break label278;
        }
      }
      for (localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.a(j);; localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem())
      {
        localObject = (EmoticonPreviewData)localObject;
        if ((localObject == null) || ((!this.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.a(j)))) {
          break;
        }
        if (!this.jdField_c_of_type_Boolean) {
          break label290;
        }
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
        i = 0;
        break label139;
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if ((((EmoticonPreviewData)localObject).a()) && (j != -1))
      {
        f2 = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a();
        localEmoticonInfo = ((EmoticonPreviewData)localObject).a();
        if (localEmoticonInfo != null) {
          if ((localEmoticonInfo instanceof PicEmoticonInfo))
          {
            localPicEmoticonInfo = (PicEmoticonInfo)localEmoticonInfo;
            if (localPicEmoticonInfo.emoticon != null) {
              if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.a(j))) {
                break label892;
              }
            }
          }
        }
      }
      break;
    }
    label892:
    for (float f1 = ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionAdapter.a(j))).floatValue();; f1 = f2)
    {
      if ((f1 > 0.0F) && (f2 <= f1))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = localPicEmoticonInfo;
      this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = localPicEmoticonInfo.emoticon;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localPicEmoticonInfo.emoticon.name);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bringToFront();
      QLog.d("AIOEmotionFragment", 1, "getView emotion name:" + localPicEmoticonInfo.emoticon.name);
      if (a(localPicEmoticonInfo))
      {
        paramMessage = (Drawable)paramMessage.obj;
        if ((paramMessage != null) && ((paramMessage instanceof URLDrawable))) {
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((URLDrawable)paramMessage);
        }
      }
      b();
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      a(localEmoticonInfo);
      while (((localObject instanceof MsgEmoticonPreviewData)) && (!((EmoticonPreviewData)localObject).a()) && (!((MsgEmotionDataSource)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource).a((EmoticonPreviewData)localObject)))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView.a();
        this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView.a(0);
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.b(false);
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a(false);
        ((MsgEmotionDataSource)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource).a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery, this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, (EmoticonPreviewData)localObject, this);
        return true;
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
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryProgressView.b();
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.b(true);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.a(true);
      return true;
      j = paramMessage.arg1;
      if (j == 0)
      {
        paramMessage = (EmoticonPreviewData)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
        if (paramMessage == null) {
          break;
        }
        if (paramMessage.a())
        {
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          return true;
        }
        if (paramMessage.a() != null) {}
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(i);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(i);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(i);
          return true;
          i = 4;
        }
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(j);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(j);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(j);
      return true;
    }
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
      paramIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_AndroidContentContext.getString(2131719718));
      paramIntent = new Bundle(paramIntent.getExtras());
      localIntent = new Intent();
      localIntent.putExtras(paramIntent);
      if (super.a() != null) {
        ForwardUtils.a(super.a(), super.getActivity(), this.jdField_a_of_type_AndroidContentContext, localIntent, ThreadManager.getUIHandler());
      }
    }
    while ((paramInt2 != -1) || (paramInt1 != 2))
    {
      Intent localIntent;
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1001);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1001, -1, 1).sendToTarget();
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    if ((paramView.getId() == 2131362404) || (paramView.getId() == 2131362403)) {
      if (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0) {}
    }
    Object localObject;
    do
    {
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          localObject = (EmoticonPreviewData)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
          if (localObject != null)
          {
            CustomEmotionData localCustomEmotionData = ((EmoticonPreviewData)localObject).a();
            if (localCustomEmotionData != null)
            {
              if (!TextUtils.isEmpty(localCustomEmotionData.modifyWord)) {}
              for (localObject = localCustomEmotionData.modifyWord;; localObject = localCustomEmotionData.ocrWord)
              {
                Intent localIntent = new Intent(getActivity(), EditActivity.class);
                localIntent.putExtra("title", 2131692014);
                localIntent.putExtra("limit", 30);
                localIntent.putExtra("action", 105);
                localIntent.putExtra("key_emo_id", localCustomEmotionData.emoId);
                localIntent.putExtra("key_input_tip", getResources().getString(2131692015));
                localIntent.putExtra("current", (String)localObject);
                localIntent.putExtra("canPostNull", false);
                localIntent.putExtra("multiLine", false);
                ReportController.b(null, "dc00898", "", "", "0X800A7C1", "0X800A7C1", this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource.a(), 0, "", "", "", "");
                startActivityForResult(localIntent, 2);
                break;
              }
              if ((paramView.getId() != 2131363103) && (paramView.getId() != 2131363106)) {
                break;
              }
              if (c())
              {
                h();
                if ((this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null)) {
                  EmoticonManager.a(a(), "0X800A9E1", -1, this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
                }
              }
              else
              {
                g();
                if ((this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon != null)) {
                  EmoticonManager.a(a(), "0X800A9E0", -1, this.jdField_b_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
                }
              }
            }
          }
        }
      } while (paramView.getId() != 2131362533);
      localObject = a();
    } while (localObject == null);
    boolean bool3 = AudioSettingManager.a(BaseApplicationImpl.getContext());
    boolean bool4 = AudioHelper.a(BaseApplicationImpl.getContext());
    if (!this.jdField_a_of_type_Boolean)
    {
      bool1 = true;
      label423:
      this.jdField_a_of_type_Boolean = bool1;
      ((QQAppInterface)localObject).setLoudSpeakerState(bool1);
      bool1 = c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a(1, this.jdField_a_of_type_Boolean);
      BaseChatPie.b(getActivity(), this.jdField_a_of_type_Boolean, bool3, bool4);
      if ((bool3) || (bool4) || (!bool1)) {
        break label499;
      }
    }
    label499:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      b(bool1, this.jdField_a_of_type_Boolean);
      break;
      bool1 = false;
      break label423;
    }
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
    boolean bool = false;
    super.onCreate(paramBundle);
    if (jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData == null) {
      bool = true;
    }
    QLog.d("AIOEmotionFragment", 1, new Object[] { "onCreate, mCurDataIsNull:", Boolean.valueOf(bool) });
    if (jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData == null) {}
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
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOEmotionFragment", 1, "onCreateView");
    }
    if ((jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData != null) && (jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmoticonPreviewData.a())) {}
    for (;;)
    {
      this.jdField_a_of_type_Int = i;
      paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      i = 2;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$EmoticonDetailJsonDownloader != null)
    {
      EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$EmoticonDetailJsonDownloader);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$EmoticonDetailJsonDownloader = null;
    }
    a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataSource.a();
    }
    Object localObject;
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((URLDrawable)((Iterator)localObject).next()).setTag(null);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.d();
      }
      localObject = a();
      if (localObject != null) {
        AudioDeviceManager.a((QQAppInterface)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.h();
    }
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(4);
      this.jdField_d_of_type_AndroidViewView = null;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.b();
    }
    AIOGalleryMsgRevokeMgr.a().b(this);
  }
  
  public void onGestureFinish()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
    {
      localFragmentActivity.finish();
      localFragmentActivity.overridePendingTransition(0, 0);
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (localEmoticonPreviewData.a())
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    if (localEmoticonPreviewData.c())
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (localEmoticonPreviewData.a() == null) {
        break label124;
      }
    }
    label124:
    for (int i = 0;; i = 4)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(i);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(i);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(i);
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      break;
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment
 * JD-Core Version:    0.7.0.1
 */