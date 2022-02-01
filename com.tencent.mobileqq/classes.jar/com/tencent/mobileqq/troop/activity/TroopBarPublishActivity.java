package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeManager;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.mediaCodec.VideoMergeHelper;
import com.tencent.biz.qqstory.view.widget.VerticalImageSpan;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tribe.TribePostTitlePrefixPanelController;
import com.tencent.mobileqq.tribe.VideoInfo;
import com.tencent.mobileqq.tribe.videoupload.TribeVideoTaskInfo;
import com.tencent.mobileqq.tribe.videoupload.TribeVideoUploadTask;
import com.tencent.mobileqq.tribe.view.TEditText;
import com.tencent.mobileqq.tribe.view.TribeThemeSpan;
import com.tencent.mobileqq.tribe.view.TribeTitlePrefixPanelView;
import com.tencent.mobileqq.tribe.view.TribeTitlePrefixPanelView.TitlePrefixItem;
import com.tencent.mobileqq.troop.data.TroopBarMyBar;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.troop.utils.TribeUtils;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.widget.PublishItemBar;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.troop.widget.TribeHotPicPanel;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.TroopBarShareUtils;
import com.tencent.mobileqq.widget.InputMethodLinearLayout;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.immersive.SystemBarCompact;
import dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo;
import dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.EditParam;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarPublishActivity
  extends AbsPublishActivity
  implements TextWatcher
{
  public static final String t;
  public static String w = "";
  public String A = "    ";
  protected String B = null;
  private String C;
  private String D = null;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new TroopBarPublishActivity.4(this);
  protected PublishVideoEntry a;
  public TribePostTitlePrefixPanelController a;
  protected VideoInfo a;
  private TribeVideoUploadTask jdField_a_of_type_ComTencentMobileqqTribeVideouploadTribeVideoUploadTask;
  public TribeTitlePrefixPanelView.TitlePrefixItem a;
  private TribeTitlePrefixPanelView jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView;
  protected TroopBarMyBar a;
  protected CharSequence a;
  protected List<TroopBarMyBar> a;
  private JSONArray jdField_a_of_type_OrgJsonJSONArray = null;
  private Handler jdField_b_of_type_AndroidOsHandler = new TroopBarPublishActivity.1(this);
  protected ImageView b;
  protected RelativeLayout b;
  private TroopBarPublishUtils.PicUploadThread jdField_b_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread;
  private List<TribeTitlePrefixPanelView.TitlePrefixItem> jdField_b_of_type_JavaUtilList = null;
  private JSONObject jdField_b_of_type_OrgJsonJSONObject;
  private Handler c;
  protected TextView d;
  private TextView e;
  protected int o;
  protected boolean o;
  public final int p;
  public boolean p;
  public int q;
  boolean q;
  public int r;
  protected boolean r;
  public int s;
  protected boolean s;
  protected int t;
  private boolean t;
  private int u;
  protected String u;
  protected String v;
  protected String x = "";
  protected String y;
  protected String z;
  
  static
  {
    jdField_t_of_type_JavaLangString = TroopBarPublishActivity.class.getName();
  }
  
  public TroopBarPublishActivity()
  {
    this.jdField_o_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = null;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_u_of_type_JavaLangString = "";
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Int = 5;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_t_of_type_Boolean = true;
    this.jdField_t_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangCharSequence = "";
    this.jdField_s_of_type_Boolean = false;
    this.jdField_u_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem = null;
    this.jdField_c_of_type_AndroidOsHandler = new TroopBarPublishActivity.20(this);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (paramContext != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramString)) {
        str1 = paramContext.getSharedPreferences("bitapp_config", 0).getString(paramString, "");
      }
    }
    return str1;
  }
  
  public static void a(Activity paramActivity, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopBarPublishActivity", 2, "notifySDKCanceled:" + paramLong);
    }
    ForwardSdkShareOption.a(paramActivity, false, "shareToTroopBar", paramLong);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramContext = paramContext.getSharedPreferences("bitapp_config", 0).edit();
        paramContext.putString(paramString1, paramString2);
        bool1 = paramContext.commit();
      }
    }
    return bool1;
  }
  
  private String b()
  {
    switch (this.jdField_u_of_type_Int)
    {
    default: 
      return "1";
    case 150: 
      return "4";
    case 700: 
      return "3";
    }
    return "2";
  }
  
  private void b(Intent paramIntent)
  {
    this.jdField_t_of_type_Int = paramIntent.getIntExtra("theme_id", -1);
    this.x = paramIntent.getStringExtra("theme_name");
    if (this.jdField_s_of_type_Boolean)
    {
      if (!TextUtils.isEmpty(this.x))
      {
        this.x = ("#" + this.x);
        return;
      }
      this.x = HardCodeUtil.a(2131715083);
      return;
    }
    this.x = "";
  }
  
  private void b(String paramString, long paramLong)
  {
    CodecParam.mMaxrate = 2000000;
    String str1 = paramString + ".doodle.mp4";
    String str2 = paramString + ".tmp.mp4";
    Object localObject = new MergeEditVideo.EditParam(CodecParam.mMaxrate, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
    ((MergeEditVideo.EditParam)localObject).b(2);
    int i = new MergeEditVideo().a(paramString, str1, (MergeEditVideo.EditParam)localObject, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
    if (i != 0)
    {
      if (i == -1) {
        FileUtils.c(paramString, str1);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("tribe_publish_TroopBarPublishActivity", 1, "onCompositeFinish step 1 timeCost:" + (SystemClock.uptimeMillis() - paramLong) + "ms bitrate:" + CodecParam.mMaxrate);
      }
      paramString = new MediaMetadataRetriever();
      paramString.setDataSource(str1);
      localObject = paramString.getFrameAtTime();
      this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.jdField_b_of_type_Int = ((Bitmap)localObject).getWidth();
      this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.c = ((Bitmap)localObject).getHeight();
      paramString.release();
      if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd == 0) {
        break label315;
      }
    }
    label315:
    for (this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.jdField_a_of_type_Int = (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd - this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart); (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isMuteRecordVoice) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath)); this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDuration))
    {
      a(str1, paramLong);
      return;
      QLog.i("tribe_publish_TroopBarPublishActivity", 1, "getVideoMeta failed. merge file path:" + paramString + " merge result:" + i);
      a(null, paramLong);
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath))
    {
      paramString = this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mLocalRawVideoDir;
      try
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd == 0) {}
        for (i = VideoMergeHelper.a(str1, paramString, str2, 0);; i = VideoMergeHelper.a(str1, paramString, str2, 0, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd))
        {
          FileUtils.f(str1);
          if ((i != 0) && (i != -8)) {
            break;
          }
          c(str2, paramLong);
          return;
        }
        QLog.i("tribe_publish_TroopBarPublishActivity", 1, "merge voice failed. merge file path:" + str1 + " merge result:" + i);
      }
      catch (Exception paramString)
      {
        QLog.d("TroopBarPublishActivity", 1, "e = " + paramString);
        a(null, paramLong);
        return;
      }
      a(null, paramLong);
      return;
    }
    new VideoCompositeHelper().a(this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, str1, str2, true, new TroopBarPublishActivity.15(this, str1, paramLong, str2));
  }
  
  private void c(String paramString, long paramLong)
  {
    if (AudioHelper.a())
    {
      int i = VideoCompositeManager.a(paramString);
      if (i == 0)
      {
        QLog.i("tribe_publish_TroopBarPublishActivity", 1, "isHuaweiGreen: reEncodeVideoWithFFMpeg succeed. output path = " + paramString);
        a(paramString, paramLong);
        return;
      }
      QLog.i("tribe_publish_TroopBarPublishActivity", 1, "isHuaweiGreen: reEncodeVideoWithFFMpeg failed. errorCode = " + i);
      a(null, paramLong);
      return;
    }
    a(paramString, paramLong);
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing());
  }
  
  private void r()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText == null) || (this.jdField_b_of_type_AndroidWidgetEditText == null)) {
      return;
    }
    int j = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getText().length();
    if (TextUtils.isEmpty(this.x))
    {
      i = 0;
      if (j > i) {
        break label176;
      }
      this.jdField_b_of_type_AndroidWidgetEditText.setVisibility(0);
      if (this.jdField_t_of_type_Int != -1) {
        break label169;
      }
    }
    label169:
    for (int i = 2130842779;; i = 2130842780)
    {
      Object localObject = new SpannableStringBuilder(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getText());
      ((SpannableStringBuilder)localObject).append(this.jdField_j_of_type_JavaLangString);
      localObject = new SpannableString((CharSequence)localObject);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(0), 0, this.x.length(), 33);
      if (!TextUtils.isEmpty(this.x)) {
        ((SpannableString)localObject).setSpan(new VerticalImageSpan(this, i), 0, 1, 33);
      }
      this.jdField_b_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
      return;
      i = this.x.length() + 1;
      break;
    }
    label176:
    this.jdField_b_of_type_AndroidWidgetEditText.setVisibility(8);
  }
  
  private void s()
  {
    this.jdField_b_of_type_AndroidWidgetEditText.setEnabled(false);
    if (!TextUtils.isEmpty(this.x)) {
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setMovementMethod(LinkMovementMethod.getInstance());
    }
    this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.addTextChangedListener(new TroopBarPublishActivity.9(this));
    this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setOnSelectionChangedListener(new TroopBarPublishActivity.10(this));
    if (this.jdField_u_of_type_Int == 700) {
      this.x = "";
    }
    d(false);
    if ((this.jdField_s_of_type_Boolean) && (!TextUtils.isEmpty(this.x)) && (!SharedPreUtils.b(this, this.app.getCurrentAccountUin(), "tribe_video_post_has_show_tips", false))) {
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.post(new TroopBarPublishActivity.11(this));
    }
  }
  
  private void t()
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() <= 0) || (!this.jdField_h_of_type_Boolean)) {
      return;
    }
    if (this.jdField_b_of_type_JavaUtilList.size() == 1) {
      this.A = "  ";
    }
    ReportController.b(null, "dc00899", "Grp_tribe", "", "pub_page", "exp_prefix", 0, 0, this.jdField_q_of_type_JavaLangString, "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem = ((TribeTitlePrefixPanelView.TitlePrefixItem)this.jdField_b_of_type_JavaUtilList.get(0));
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView = new TribeTitlePrefixPanelView(this, this.jdField_a_of_type_AndroidWidgetListView);
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView.a(new TroopBarPublishActivity.PrefixSelectedListenerImp(this, null));
    this.jdField_a_of_type_ComTencentMobileqqTribeTribePostTitlePrefixPanelController = new TribePostTitlePrefixPanelController(this.jdField_a_of_type_AndroidWidgetListView, this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView, this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(false);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setMovementMethod(LinkMovementMethod.getInstance());
    }
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.addTextChangedListener(new TroopBarPublishActivity.12(this));
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setOnSelectionChangedListener(new TroopBarPublishActivity.13(this));
    e(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.setFocusableInTouchMode(true);
    int i = this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText().length();
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(i);
  }
  
  private void u()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText == null) || (this.jdField_a_of_type_AndroidWidgetEditText == null) || (this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem != null) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_b_of_type_JavaLangString.length() + this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_c_of_type_JavaLangString.length() + this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_a_of_type_JavaLangString.length();; i = 0)
    {
      int k = this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText().length();
      SpannableString localSpannableString;
      if ((this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_b_of_type_JavaLangString)))
      {
        j = 0;
        if (k > j) {
          break label329;
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
        localSpannableString = new SpannableString(new SpannableStringBuilder(this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText()).append(this.jdField_c_of_type_JavaLangString));
        if (i > localSpannableString.length()) {
          break label282;
        }
        localSpannableString.setSpan(new ForegroundColorSpan(0), 0, this.A.length() + i - 1, 33);
        label176:
        if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 1)) {
          if ((this.jdField_a_of_type_ComTencentMobileqqTribeTribePostTitlePrefixPanelController == null) || (!this.jdField_a_of_type_ComTencentMobileqqTribeTribePostTitlePrefixPanelController.b())) {
            break label322;
          }
        }
      }
      label282:
      label322:
      for (int j = 2130842777;; j = 2130842778)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_b_of_type_JavaLangString))) {
          localSpannableString.setSpan(new VerticalImageSpan(this, j), i + 1, i + 2, 33);
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setText(localSpannableString);
        return;
        j = this.A.length() + i;
        break;
        QLog.e("TroopBarPublishActivity", 2, "updateTitlePrefix spannableString = " + localSpannableString + " prefixNum = " + i);
        break label176;
      }
      label329:
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(4);
      return;
    }
  }
  
  private void v()
  {
    QLog.i("tribe_publish_TroopBarPublishActivity", 1, "cancelUploadVideoTask");
    if (this.jdField_a_of_type_ComTencentMobileqqTribeVideouploadTribeVideoUploadTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTribeVideouploadTribeVideoUploadTask.a();
      this.jdField_a_of_type_ComTencentMobileqqTribeVideouploadTribeVideoUploadTask = null;
    }
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.jdField_b_of_type_OrgJsonJSONObject != null) {
        localJSONObject.put("suggestDestination", this.jdField_b_of_type_OrgJsonJSONObject);
      }
      String str1 = this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText().toString();
      String str2 = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getText().toString();
      localJSONObject.put("inputTitle", str1);
      localJSONObject.put("inputContent", str2);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    return localJSONObject.toString();
  }
  
  protected void a()
  {
    super.a();
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374139));
    this.jdField_t_of_type_Boolean = b();
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(2131374282, this.jdField_b_of_type_AndroidWidgetTextView);
    }
    o();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVideoCallback(this.jdField_b_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setMusicCallback(this.jdField_b_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setAudioCallback(this.jdField_b_of_type_AndroidOsHandler);
    label269:
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null)
    {
      if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_q_of_type_Boolean)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if ((this.jdField_q_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_a_of_type_JavaLangString);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#638EC3"));
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_a_of_type_JavaLangString);
      }
      if ((!"barindex".equals(this.jdField_a_of_type_JavaLangString)) && (this.jdField_d_of_type_Int == 1))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("bid", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString);
        this.jdField_o_of_type_Boolean = true;
        TroopBarUtils.b(this, (Bundle)localObject, "https://buluo.qq.com/cgi-bin/bar/bar_publish_info", 8, null, this);
      }
      if (this.jdField_d_of_type_Boolean) {
        c(2131719321);
      }
      n();
      if (this.mSystemBarComp != null) {
        break label491;
      }
      setImmersiveStatus(-16777216);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131374338));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374337));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374336));
      a(getIntent());
      if (this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo != null)
      {
        b(getIntent());
        this.jdField_l_of_type_JavaLangString = null;
      }
      s();
      t();
      StringBuffer localStringBuffer = new StringBuffer();
      if ((this.jdField_i_of_type_Int & 0x1) == 1) {
        localStringBuffer.append("0");
      }
      if ((this.jdField_i_of_type_Int & 0x2) == 2) {
        localStringBuffer.append("1");
      }
      if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
        break label522;
      }
      i = 2;
      label409:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label527;
      }
      localObject = "0";
      label420:
      ReportController.b(null, "P_CliOper", "Grp_tribe", "", "pub_page", "exp", i, 0, (String)localObject, this.jdField_b_of_type_JavaLangString, localStringBuffer.toString(), "");
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label538;
      }
    }
    label522:
    label527:
    label538:
    for (Object localObject = "0";; localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
    {
      TroopBarUtils.a("pub_page", "choose_place", (String)localObject, "0", "", "");
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      label491:
      this.mSystemBarComp.setStatusBarDrawable(null);
      this.mSystemBarComp.setStatusBarColor(-16777216);
      this.mSystemBarComp.setStatusColor(-16777216);
      break label269;
      i = 1;
      break label409;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString;
      break label420;
    }
  }
  
  protected void a(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0)
    {
      i = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo != null) {
        i = 4;
      }
    }
    super.a(i);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 1)
      {
        a(0);
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt1);
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() < paramInt2) {
          bool = true;
        }
        ((TroopBarImagePreviewAdapter)localObject).a(bool, true);
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    else {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label134;
      }
    }
    label134:
    for (Object localObject = "0";; localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
    {
      TroopBarUtils.a("pub_page", "del_photo", (String)localObject, "", "", "");
      return;
      if (this.jdField_p_of_type_Boolean) {
        break;
      }
      this.jdField_r_of_type_Int = paramInt1;
      this.jdField_s_of_type_Int = paramInt2;
      d(paramInt1);
      break;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopBarPublishActivity.6(this, paramInt1, paramInt3, paramBoolean), paramInt2);
  }
  
  protected void a(Intent paramIntent)
  {
    this.C = paramIntent.getStringExtra("thumbPath");
    this.z = paramIntent.getStringExtra("fakeVid");
    String str1 = paramIntent.getStringExtra("videoPath");
    String str2 = paramIntent.getStringExtra("videoDoodleDescription");
    if ((this.C == null) || (this.z == null) || (str1 == null)) {
      return;
    }
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams;
      try
      {
        Bitmap localBitmap = ImageUtil.a(this.C, null);
        int i = localBitmap.getWidth();
        int j = localBitmap.getHeight();
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        if (i > j)
        {
          localLayoutParams.width = DisplayUtil.a(this, 216.0F);
          localLayoutParams.height = DisplayUtil.a(this, 130.0F);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
          this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setPadding(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingLeft(), this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingTop(), this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingRight(), 0);
          this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setMinLines(1);
          this.jdField_b_of_type_AndroidWidgetEditText.setPadding(this.jdField_b_of_type_AndroidWidgetEditText.getPaddingLeft(), this.jdField_b_of_type_AndroidWidgetEditText.getPaddingTop(), this.jdField_b_of_type_AndroidWidgetEditText.getPaddingRight(), 0);
          this.jdField_b_of_type_AndroidWidgetEditText.setMinLines(1);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new TroopBarPublishActivity.19(this));
          this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo = new VideoInfo();
          this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.jdField_e_of_type_JavaLangString = str2;
          this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.a(paramIntent.getIntExtra("captureMode", 0));
          a(str1, this.z);
          return;
        }
      }
      catch (OutOfMemoryError paramIntent)
      {
        QLog.e("TroopBarPublishActivity", 2, QLog.getStackTraceString(paramIntent));
        return;
      }
      localLayoutParams.width = DisplayUtil.a(this, 130.0F);
      localLayoutParams.height = DisplayUtil.a(this, 216.0F);
    }
  }
  
  public void a(View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a(paramInt))
    {
      a(this, TroopBarPublishActivity.class.getName());
      return;
    }
    AlbumUtil.a();
    paramView = new Intent();
    paramView.putExtra("ALBUM_ID", "$RecentAlbumId");
    paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClass().getName());
    paramView.putExtra("back_btn_text", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697235));
    paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_JavaUtilArrayList);
    paramView.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    paramView.putExtra("PhotoConst.MAXUM_SELECTED_NUM", this.jdField_a_of_type_JavaUtilArrayList.size());
    paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramInt);
    paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    paramView.putExtra("PhotoConst.IS_OVERLOAD", false);
    paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    paramView.putExtra("from_tribe_class_name", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClass().getSimpleName());
    paramView.putExtra("enter_from", 24);
    paramView.setClass(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, NewPhotoPreviewActivity.class);
    paramView.addFlags(603979776);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
    AlbumUtil.anim(this, true, true);
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      paramInt = 2;
      if (!TextUtils.isEmpty(this.jdField_q_of_type_JavaLangString)) {
        break label291;
      }
    }
    label291:
    for (paramView = "0";; paramView = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
    {
      ReportController.b(null, "P_CliOper", "Grp_tribe", "", "pub_page", "choose_photo", paramInt, 0, paramView, "", "", "");
      return;
      paramInt = 1;
      break;
    }
  }
  
  protected void a(String paramString, long paramLong)
  {
    if (isFinishing())
    {
      VideoCompositeHelper.a(VideoCompositeHelper.a(this.z));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("tribe_publish_TroopBarPublishActivity", 1, "onCompositeFinish total timeCost:" + (SystemClock.uptimeMillis() - paramLong) + "ms");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new TroopBarPublishActivity.16(this, paramString));
  }
  
  protected void a(String paramString1, String paramString2)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_r_of_type_Boolean = true;
    ThreadManager.post(new TroopBarPublishActivity.14(this, paramString2, paramString1, l), 8, null, true);
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    QLog.d("tribe_publish_TroopBarPublishActivity", 2, "start uploadVideoThumb " + paramBoolean);
    if (!paramBoolean) {
      c(true);
    }
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramString);
    if (this.jdField_b_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = new TroopBarPublishUtils.PicUploadThread(this, this.jdField_c_of_type_AndroidOsHandler, localArrayList, this.jdField_e_of_type_JavaLangString);
      ThreadManager.post(this.jdField_b_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread, 8, null, true);
    }
  }
  
  /* Error */
  void a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: aload_1
    //   5: invokespecial 1081	com/tencent/mobileqq/troop/activity/AbsPublishActivity:a	(Lorg/json/JSONObject;)V
    //   8: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +29 -> 40
    //   14: ldc 164
    //   16: iconst_2
    //   17: new 166	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 1083
    //   27: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload_1
    //   41: ldc_w 716
    //   44: invokevirtual 1086	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   47: invokestatic 1092	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   50: lstore_3
    //   51: lload_3
    //   52: lconst_0
    //   53: lcmp
    //   54: ifne +522 -> 576
    //   57: aload_1
    //   58: ldc_w 632
    //   61: invokevirtual 1095	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   64: ifeq +512 -> 576
    //   67: aload_0
    //   68: aload_1
    //   69: ldc_w 632
    //   72: invokevirtual 1099	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   75: putfield 630	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   78: aload_0
    //   79: getfield 630	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   82: ifnull +494 -> 576
    //   85: aload_0
    //   86: getfield 630	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   89: ldc_w 716
    //   92: invokevirtual 1102	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   95: lstore_3
    //   96: aload_0
    //   97: getfield 630	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   100: ldc_w 1104
    //   103: invokevirtual 1086	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   106: astore 6
    //   108: aload_0
    //   109: iconst_1
    //   110: putfield 83	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_q_of_type_Boolean	Z
    //   113: aload_0
    //   114: aload_1
    //   115: ldc_w 1106
    //   118: iconst_0
    //   119: invokevirtual 1110	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   122: putfield 93	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_s_of_type_Boolean	Z
    //   125: aload_0
    //   126: aload_1
    //   127: ldc_w 1112
    //   130: invokevirtual 1086	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   133: putfield 1114	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:v	Ljava/lang/String;
    //   136: new 627	org/json/JSONObject
    //   139: dup
    //   140: aload_0
    //   141: getfield 1114	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:v	Ljava/lang/String;
    //   144: invokespecial 1116	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   147: astore 8
    //   149: aload_0
    //   150: aload 8
    //   152: ldc_w 1118
    //   155: iconst_0
    //   156: invokevirtual 1121	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   159: putfield 95	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_u_of_type_Int	I
    //   162: aload_0
    //   163: aload_1
    //   164: ldc_w 1123
    //   167: invokevirtual 1127	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   170: putfield 103	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   173: aload_0
    //   174: getfield 528	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_h_of_type_Boolean	Z
    //   177: ifeq +35 -> 212
    //   180: aload_0
    //   181: getfield 105	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   184: ifnull +12 -> 196
    //   187: aload_0
    //   188: getfield 105	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   191: invokeinterface 1130 1 0
    //   196: aload_0
    //   197: aload_0
    //   198: getfield 103	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   201: invokestatic 1133	com/tencent/mobileqq/tribe/TribePostTitlePrefixPanelController:a	(Lorg/json/JSONArray;)Ljava/util/List;
    //   204: putfield 105	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   207: aload_0
    //   208: aconst_null
    //   209: putfield 103	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   212: aload_0
    //   213: aload_1
    //   214: ldc_w 1135
    //   217: invokevirtual 1137	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   220: putfield 69	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_o_of_type_Int	I
    //   223: lload_3
    //   224: lconst_0
    //   225: lcmp
    //   226: ifle +326 -> 552
    //   229: aload_0
    //   230: getfield 83	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_q_of_type_Boolean	Z
    //   233: ifne +302 -> 535
    //   236: aload_0
    //   237: new 687	com/tencent/mobileqq/troop/data/TroopBarMyBar
    //   240: dup
    //   241: lload_3
    //   242: aload_1
    //   243: ldc_w 1139
    //   246: invokevirtual 1086	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   249: invokespecial 1142	com/tencent/mobileqq/troop/data/TroopBarMyBar:<init>	(JLjava/lang/String;)V
    //   252: putfield 71	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   255: aload_0
    //   256: new 166	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   263: aload_0
    //   264: getfield 501	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   267: invokevirtual 506	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   270: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc_w 1144
    //   276: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload_0
    //   280: getfield 71	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   283: getfield 717	com/tencent/mobileqq/troop/data/TroopBarMyBar:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   286: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: ldc_w 1144
    //   292: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload_0
    //   296: getfield 95	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_u_of_type_Int	I
    //   299: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   302: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: putfield 765	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   308: aload_0
    //   309: aload_0
    //   310: getfield 71	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   313: getfield 717	com/tencent/mobileqq/troop/data/TroopBarMyBar:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   316: putfield 540	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_q_of_type_JavaLangString	Ljava/lang/String;
    //   319: aload_0
    //   320: getfield 95	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_u_of_type_Int	I
    //   323: sipush 700
    //   326: if_icmpne +13 -> 339
    //   329: aload_0
    //   330: aload_0
    //   331: getfield 774	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_i_of_type_Int	I
    //   334: iconst_3
    //   335: iand
    //   336: putfield 774	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_i_of_type_Int	I
    //   339: aload_0
    //   340: ldc_w 534
    //   343: putfield 1146	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_o_of_type_JavaLangString	Ljava/lang/String;
    //   346: aload_0
    //   347: ldc_w 536
    //   350: putfield 1148	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_p_of_type_JavaLangString	Ljava/lang/String;
    //   353: aload_0
    //   354: aload_1
    //   355: ldc_w 1150
    //   358: invokevirtual 1086	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   361: putfield 109	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:B	Ljava/lang/String;
    //   364: aload_0
    //   365: getfield 109	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:B	Ljava/lang/String;
    //   368: putstatic 1153	com/tencent/mobileqq/troop/activity/TroopBarPublishUtils:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   371: aload_0
    //   372: aload_1
    //   373: invokevirtual 1155	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:b	(Lorg/json/JSONObject;)V
    //   376: aload_1
    //   377: ldc_w 1157
    //   380: invokevirtual 1137	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   383: istore_2
    //   384: iload_2
    //   385: iconst_1
    //   386: if_icmplt +175 -> 561
    //   389: iload_2
    //   390: bipush 6
    //   392: if_icmpgt +169 -> 561
    //   395: iconst_1
    //   396: istore 5
    //   398: iload 5
    //   400: putstatic 1159	com/tencent/mobileqq/troop/activity/TroopBarPublishUtils:jdField_a_of_type_Boolean	Z
    //   403: return
    //   404: astore 6
    //   406: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   409: ifeq +14 -> 423
    //   412: ldc 164
    //   414: iconst_2
    //   415: aload 6
    //   417: invokevirtual 1162	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   420: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   423: lconst_0
    //   424: lstore_3
    //   425: goto -374 -> 51
    //   428: astore 8
    //   430: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   433: ifeq -271 -> 162
    //   436: ldc 164
    //   438: iconst_2
    //   439: new 166	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   446: ldc_w 1164
    //   449: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: aload 7
    //   454: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   457: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: invokestatic 616	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   463: goto -301 -> 162
    //   466: astore 7
    //   468: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   471: ifeq -298 -> 173
    //   474: ldc 164
    //   476: iconst_2
    //   477: new 166	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   484: ldc_w 1166
    //   487: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload_1
    //   491: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   494: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 616	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   500: goto -327 -> 173
    //   503: astore 7
    //   505: ldc 164
    //   507: iconst_2
    //   508: new 166	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   515: ldc_w 1168
    //   518: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: aload 7
    //   523: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   526: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokestatic 616	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   532: goto -320 -> 212
    //   535: aload_0
    //   536: new 687	com/tencent/mobileqq/troop/data/TroopBarMyBar
    //   539: dup
    //   540: lload_3
    //   541: aload 6
    //   543: invokespecial 1142	com/tencent/mobileqq/troop/data/TroopBarMyBar:<init>	(JLjava/lang/String;)V
    //   546: putfield 71	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   549: goto -294 -> 255
    //   552: aload_0
    //   553: bipush 15
    //   555: putfield 774	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_i_of_type_Int	I
    //   558: goto -239 -> 319
    //   561: iconst_0
    //   562: istore 5
    //   564: goto -166 -> 398
    //   567: astore 7
    //   569: aload 8
    //   571: astore 7
    //   573: goto -143 -> 430
    //   576: aconst_null
    //   577: astore 6
    //   579: goto -466 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	582	0	this	TroopBarPublishActivity
    //   0	582	1	paramJSONObject	JSONObject
    //   383	10	2	i	int
    //   50	491	3	l	long
    //   396	167	5	bool	boolean
    //   106	1	6	str	String
    //   404	138	6	localNumberFormatException	NumberFormatException
    //   577	1	6	localObject1	Object
    //   1	452	7	localObject2	Object
    //   466	1	7	localException1	Exception
    //   503	19	7	localException2	Exception
    //   567	1	7	localJSONException1	JSONException
    //   571	1	7	localObject3	Object
    //   147	4	8	localJSONObject	JSONObject
    //   428	142	8	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   40	51	404	java/lang/NumberFormatException
    //   136	149	428	org/json/JSONException
    //   162	173	466	java/lang/Exception
    //   180	196	503	java/lang/Exception
    //   196	212	503	java/lang/Exception
    //   149	162	567	org/json/JSONException
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    super.a(paramJSONObject, paramInt, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("TroopBarPublishActivity", 2, "onResult requestCode = " + paramInt + " result = " + paramJSONObject);
    }
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (paramJSONObject != null)
      {
        if (paramJSONObject.optInt("retcode", -1) == -1) {
          break;
        }
        if ((this.jdField_d_of_type_Boolean) && (this.jdField_o_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = null;
          this.jdField_q_of_type_JavaLangString = null;
        }
      }
      if (this.jdField_d_of_type_Boolean) {
        k();
      }
    } while (!this.jdField_o_of_type_Boolean);
    this.jdField_o_of_type_Boolean = false;
    return;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_e_of_type_Int = paramJSONObject.optInt("flag");
    }
    this.jdField_k_of_type_Boolean = paramJSONObject.optBoolean("photoOrContent");
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("from");
    this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("needCategory", true);
    this.jdField_j_of_type_Boolean = paramJSONObject.optBoolean("needFace", true);
    for (;;)
    {
      try
      {
        paramBundle = paramJSONObject.getJSONObject("publish_condition");
        if (paramBundle.optInt("requireType", 0) == 0) {
          continue;
        }
        bool = true;
        this.jdField_m_of_type_Boolean = bool;
        if (this.jdField_d_of_type_Boolean)
        {
          if (!this.jdField_o_of_type_Boolean) {
            continue;
          }
          this.jdField_i_of_type_Int |= paramBundle.optInt("optionType");
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_e_of_type_Int == 1)) {
            this.jdField_i_of_type_Int |= 0x1;
          }
        }
        if (this.jdField_u_of_type_Int == 700)
        {
          this.jdField_i_of_type_Int &= 0xB;
          this.jdField_i_of_type_Int &= 0x7;
        }
        if (paramBundle.optInt("recordTimeLimit") != 0) {
          continue;
        }
        paramInt = 60000;
        this.jdField_h_of_type_Int = paramInt;
        this.jdField_k_of_type_Int = paramBundle.optInt("forbiddenType", 0);
        this.jdField_m_of_type_JavaLangString = paramBundle.optString("forbiddenMsg", getString(2131697234));
      }
      catch (JSONException paramBundle)
      {
        boolean bool;
        continue;
      }
      a();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopBarPublishActivity.3(this), 200L);
      c(paramJSONObject);
      break;
      bool = false;
      continue;
      this.jdField_i_of_type_Int = paramBundle.optInt("optionType");
      continue;
      paramInt = paramBundle.optInt("recordTimeLimit");
      paramInt *= 1000;
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    this.jdField_l_of_type_Int = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getSelectionStart();
    this.jdField_m_of_type_Int = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getSelectionEnd();
    String str = TroopBarUtils.a(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
    int j;
    if (str == null)
    {
      i = 0;
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishActivity", 2, "onTextChanged: " + i + "--" + this.jdField_l_of_type_Int + "--" + this.jdField_m_of_type_Int);
      }
      if ((this.f <= 0) || (i <= this.f)) {
        break label263;
      }
      j = i - this.f;
      paramEditable.delete(this.jdField_l_of_type_Int - j, this.jdField_m_of_type_Int);
      this.jdField_l_of_type_Int -= j;
      this.jdField_m_of_type_Int -= j;
      i = j;
      if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue())
      {
        QQToast.a(this, this.jdField_s_of_type_JavaLangString, 0).b(getTitleBarHeight());
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      }
    }
    for (int i = j;; i = 0)
    {
      if (this.jdField_l_of_type_Int + i >= 0) {
        break label276;
      }
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(0);
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishActivity", 2, "onTextChanged: editStart + diff < 0 -> " + (i + this.jdField_l_of_type_Int));
      }
      return;
      i = str.length();
      break;
      label263:
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    }
    label276:
    this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(i + this.jdField_l_of_type_Int);
  }
  
  public Animation b(float paramFloat1, float paramFloat2)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, paramFloat1, 1, 0.0F, 1, paramFloat2);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setDuration(200L);
    return localTranslateAnimation;
  }
  
  protected void b(String paramString, boolean paramBoolean)
  {
    Object localObject = new StringBuilder().append("start uploadVideo. mTribeVideoUploadTask is running?");
    if (this.jdField_a_of_type_ComTencentMobileqqTribeVideouploadTribeVideoUploadTask == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("tribe_publish_TroopBarPublishActivity", 1, bool);
      if (!paramBoolean) {
        c(true);
      }
      localObject = new TribeVideoTaskInfo();
      ((TribeVideoTaskInfo)localObject).jdField_a_of_type_JavaLangString = paramString;
      if (this.jdField_a_of_type_ComTencentMobileqqTribeVideouploadTribeVideoUploadTask == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTribeVideouploadTribeVideoUploadTask = new TribeVideoUploadTask(this, this.jdField_c_of_type_AndroidOsHandler, (TribeVideoTaskInfo)localObject);
        ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTribeVideouploadTribeVideoUploadTask, 8, null, true);
      }
      return;
    }
  }
  
  protected void b(JSONObject paramJSONObject)
  {
    this.jdField_d_of_type_Boolean = paramJSONObject.optBoolean("share_from_app");
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject.optJSONObject("share_info");
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
    TroopBarShareUtils.a(this.app, "share_ask", paramJSONObject.optString("bid"));
    this.jdField_i_of_type_Boolean = true;
    this.jdField_j_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 4;
    this.jdField_b_of_type_Int = 25;
    this.jdField_c_of_type_JavaLangString = getString(2131696240, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int) });
    this.jdField_e_of_type_Int = 10;
    this.f = 700;
    this.jdField_j_of_type_JavaLangString = getString(2131696224, new Object[] { Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(this.f) });
    this.jdField_i_of_type_Int |= 0x1;
  }
  
  public boolean b()
  {
    return TextUtils.isEmpty(a(this, "is_first_enter"));
  }
  
  protected void c(JSONObject paramJSONObject)
  {
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_o_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_a_of_type_JavaLangString = paramJSONObject.optString("barName");
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#638EC3"));
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void d(int paramInt)
  {
    boolean bool = false;
    if (paramInt == 8)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_s_of_type_Int) {
        bool = true;
      }
      ((TroopBarImagePreviewAdapter)localObject1).a(bool, true);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    }
    label126:
    do
    {
      return;
      this.jdField_q_of_type_Int = 0;
      this.jdField_p_of_type_Boolean = true;
      localObject1 = a(1.0F, 0.0F);
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getChildAt(paramInt);
      if (localObject2 != null) {
        ((View)localObject2).startAnimation((Animation)localObject1);
      }
      paramInt += 1;
      if (paramInt < this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getCount())
      {
        int i;
        int j;
        if (paramInt % 5 == 0)
        {
          i = -1;
          j = 4;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getChildAt(paramInt);
          localObject2 = b(j, i);
          ((Animation)localObject2).setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
          if (localObject1 != null) {
            break label174;
          }
        }
        for (;;)
        {
          paramInt += 1;
          break;
          i = 0;
          j = -1;
          break label126;
          ((View)localObject1).startAnimation((Animation)localObject2);
          this.jdField_q_of_type_Int += 1;
        }
      }
      paramInt = this.jdField_a_of_type_JavaUtilArrayList.size();
    } while ((paramInt != 4) && (paramInt != 8));
    label174:
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a());
    ((TranslateAnimation)localObject1).setDuration(200L);
    ((TranslateAnimation)localObject1).setFillAfter(true);
    this.jdField_c_of_type_AndroidViewView.startAnimation((Animation)localObject1);
  }
  
  protected void d(boolean paramBoolean)
  {
    int k = 0;
    Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getText();
    Object localObject3;
    int j;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject3 = (TribeThemeSpan[])((Spanned)localObject1).getSpans(0, ((CharSequence)localObject1).length(), TribeThemeSpan.class);
      j = 0;
      localObject2 = localObject1;
      if (j < localObject3.length)
      {
        int m = localObject3[j].jdField_b_of_type_Int;
        if (TextUtils.isEmpty(this.x))
        {
          i = 0;
          label77:
          m = i + m;
          if (m <= ((CharSequence)localObject1).length()) {
            break label132;
          }
          i = ((CharSequence)localObject1).length();
        }
        for (;;)
        {
          localObject1 = ((CharSequence)localObject1).subSequence(i, ((CharSequence)localObject1).length());
          j += 1;
          break;
          i = 1;
          break label77;
          label132:
          i = m;
          if (!paramBoolean) {
            i = m - 1;
          }
        }
      }
    }
    else
    {
      localObject2 = localObject1;
    }
    if (this.jdField_t_of_type_Int == -1)
    {
      i = -8947849;
      if (this.jdField_t_of_type_Int != -1) {
        break label358;
      }
      j = 2130842779;
      label175:
      localObject3 = new StringBuilder().append(this.x);
      if (!TextUtils.isEmpty(this.x)) {
        break label365;
      }
      localObject1 = "";
      label205:
      localObject1 = new SpannableString((String)localObject1 + localObject2);
      ((SpannableString)localObject1).setSpan(new TribeThemeSpan(i, 0, this.x.length()), 0, this.x.length(), 33);
      if (!TextUtils.isEmpty(this.x)) {
        ((SpannableString)localObject1).setSpan(new VerticalImageSpan(this, j), 0, 1, 33);
      }
      ((SpannableString)localObject1).setSpan(new TroopBarPublishActivity.7(this, i), 0, this.x.length(), 33);
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setText((CharSequence)localObject1);
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText;
      if (!TextUtils.isEmpty(this.x)) {
        break label373;
      }
    }
    label358:
    label365:
    label373:
    for (int i = k;; i = this.x.length() + 1)
    {
      ((TEditText)localObject1).setSelection(i);
      r();
      return;
      i = -18432;
      break;
      j = 2130842780;
      break label175;
      localObject1 = " ";
      break label205;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {}
    label120:
    do
    {
      return;
      switch (paramInt1)
      {
      default: 
        return;
      case 1002: 
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramIntent.getParcelableExtra("key_selected_poi"));
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString))
          {
            paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.d;
            a(1, new String[] { paramIntent });
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
              break label171;
            }
          }
        }
        for (paramIntent = "0";; paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
        {
          TroopBarUtils.a("pub_page", "choose_place", paramIntent, "2", "", "");
          return;
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString;
          break;
          a(0, new String[0]);
          break label120;
        }
      case 1004: 
        Object localObject1 = paramIntent.getStringExtra("tribeList");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          this.jdField_a_of_type_JavaUtilList = null;
        }
        while ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
        {
          if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
            break label721;
          }
          this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
          paramInt2 = DisplayUtil.a(this, 20.0F);
          int i = DisplayUtil.a(this, 10.0F);
          int j = DisplayUtil.a(this, 6.0F);
          paramInt1 = 0;
          for (;;)
          {
            for (;;)
            {
              if (paramInt1 >= this.jdField_a_of_type_JavaUtilList.size()) {
                break label644;
              }
              localObject1 = (TroopBarMyBar)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
              if (paramInt1 == 0)
              {
                this.jdField_q_of_type_JavaLangString = ((TroopBarMyBar)localObject1).jdField_c_of_type_JavaLangString;
                this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = ((TroopBarMyBar)localObject1);
              }
              Object localObject2 = new TextView(this);
              Object localObject3 = new LinearLayout.LayoutParams(-2, paramInt2);
              ((LinearLayout.LayoutParams)localObject3).rightMargin = i;
              ((TextView)localObject2).setPadding(j, 0, j, 0);
              ((LinearLayout.LayoutParams)localObject3).gravity = 16;
              ((TextView)localObject2).setTextColor(Color.parseColor("#FFB800"));
              ((TextView)localObject2).setBackgroundResource(2130843809);
              ((TextView)localObject2).setText(((TroopBarMyBar)localObject1).jdField_a_of_type_JavaLangString);
              ((TextView)localObject2).setTextSize(1, 14.0F);
              ((TextView)localObject2).setContentDescription(((TroopBarMyBar)localObject1).jdField_a_of_type_JavaLangString);
              ((TextView)localObject2).setOnClickListener(this);
              ((TextView)localObject2).setTag(2131374282, localObject1);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
              paramInt1 += 1;
              continue;
              this.jdField_a_of_type_JavaUtilList = new ArrayList(((String)localObject1).length());
              try
              {
                localObject1 = new JSONArray((String)localObject1);
                paramInt1 = 0;
                while (paramInt1 < ((JSONArray)localObject1).length())
                {
                  localObject3 = ((JSONArray)localObject1).getJSONObject(paramInt1);
                  localObject2 = ((JSONObject)localObject3).optString("tribeName");
                  localObject3 = ((JSONObject)localObject3).optString("bid");
                  try
                  {
                    this.jdField_a_of_type_JavaUtilList.add(new TroopBarMyBar(Long.parseLong((String)localObject3), (String)localObject2));
                    this.jdField_u_of_type_JavaLangString = (this.jdField_u_of_type_JavaLangString + (String)localObject3 + "|");
                    paramInt1 += 1;
                  }
                  catch (NumberFormatException localNumberFormatException)
                  {
                    for (;;)
                    {
                      QLog.e("TroopBarPublishActivity", 1, "TroopBarPublishActivity.doOnActivityResult(). name=" + (String)localObject2 + " bid=" + (String)localObject3, localNumberFormatException);
                    }
                  }
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
              }
              catch (JSONException localJSONException) {}
            }
            QLog.e("TroopBarPublishActivity", 2, "TroopBarPublishActivity.doOnActivityResult(). ", localJSONException);
            break;
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        while (this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo == null)
        {
          if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
            break label759;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.a(1);
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.isShown())) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.a(5, 1);
          return;
          this.jdField_q_of_type_JavaLangString = "";
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = null;
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
        }
        if (this.jdField_u_of_type_Int == 700) {
          this.jdField_i_of_type_Int &= 0x3;
        }
        b(paramIntent.getIntExtra("optionType", this.jdField_i_of_type_Int));
        return;
      }
    } while (!QLog.isColorLevel());
    label171:
    label721:
    label759:
    QLog.d("TroopBarPublishActivity", 2, "doOnActivityResult, REQUEST_CODE_SELECT_MYBAR");
    label644:
    return;
    a(paramIntent);
    return;
    b(paramIntent);
    d(true);
  }
  
  public void doOnDestroy()
  {
    v();
    if ((!this.jdField_r_of_type_Boolean) && (!TextUtils.isEmpty(this.z))) {
      VideoCompositeHelper.a(VideoCompositeHelper.a(this.z));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTribeTribePostTitlePrefixPanelController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTribeTribePostTitlePrefixPanelController.c();
    }
    TroopBarPublishUtils.jdField_a_of_type_Boolean = false;
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_d_of_type_AndroidViewView != null) && (!this.n) && (this.jdField_c_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopBarPublishActivity.2(this), 200L);
    }
  }
  
  protected void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText();
    Object localObject2;
    if (localObject1 != null)
    {
      TribeThemeSpan[] arrayOfTribeThemeSpan = (TribeThemeSpan[])((Spanned)localObject1).getSpans(0, ((CharSequence)localObject1).length(), TribeThemeSpan.class);
      j = 0;
      localObject2 = localObject1;
      if (j < arrayOfTribeThemeSpan.length)
      {
        int k = arrayOfTribeThemeSpan[j].jdField_b_of_type_Int;
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_b_of_type_JavaLangString))
        {
          i = 0;
          label85:
          k = i + k;
          if (k <= ((CharSequence)localObject1).length()) {
            break label146;
          }
          i = ((CharSequence)localObject1).length();
        }
        for (;;)
        {
          localObject1 = ((CharSequence)localObject1).subSequence(i, ((CharSequence)localObject1).length());
          j += 1;
          break;
          i = this.A.length();
          break label85;
          label146:
          i = k;
          if (!paramBoolean) {
            i = k - 1;
          }
        }
      }
    }
    else
    {
      localObject2 = localObject1;
    }
    localObject1 = new SpannableStringBuilder(this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_a_of_type_JavaLangString).append(this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_b_of_type_JavaLangString).append(this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_c_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_b_of_type_JavaLangString)) {
      ((SpannableStringBuilder)localObject1).append(this.A);
    }
    ((SpannableStringBuilder)localObject1).append(localObject2);
    localObject1 = new SpannableString((CharSequence)localObject1);
    int i = this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_a_of_type_JavaLangString.length();
    int j = this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_b_of_type_JavaLangString.length();
    j = this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_c_of_type_JavaLangString.length() + (i + j);
    ((SpannableString)localObject1).setSpan(new TribeThemeSpan(-16777216, 0, j), 0, j, 33);
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 1)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqTribeTribePostTitlePrefixPanelController == null) || (!this.jdField_a_of_type_ComTencentMobileqqTribeTribePostTitlePrefixPanelController.b())) {
        break label418;
      }
    }
    label418:
    for (i = 2130842777;; i = 2130842778)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_b_of_type_JavaLangString)) {
        ((SpannableString)localObject1).setSpan(new VerticalImageSpan(this, i), j + 1, j + 2, 33);
      }
      ((SpannableString)localObject1).setSpan(new TroopBarPublishActivity.8(this), 0, j + this.A.length() - 1, 33);
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setText((CharSequence)localObject1);
      u();
      return;
    }
  }
  
  public void finish()
  {
    super.finish();
    if ((!this.jdField_e_of_type_Boolean) && (this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_OrgJsonJSONObject != null)) {
      a(this, this.jdField_a_of_type_OrgJsonJSONObject.optLong("share_app_id"));
    }
    String str1;
    if (!this.jdField_e_of_type_Boolean)
    {
      if (((this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText == null) || (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.length() <= 0)) && ((this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText == null) || (this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.length() <= 0)) && ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0))) {
        break label128;
      }
      str1 = "0";
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label134;
      }
    }
    label128:
    label134:
    for (String str2 = "0";; str2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
    {
      TroopBarUtils.a("pub_page", "un", str2, str1, "", "");
      return;
      str1 = "1";
      break;
    }
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo == null) {
      super.h();
    }
    this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setHint("");
    r();
    u();
  }
  
  public void i()
  {
    int j = 2;
    try
    {
      InputMethodUtil.b(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
      if (!c())
      {
        if ("barindex".equals(this.jdField_a_of_type_JavaLangString))
        {
          i = 1;
          ReportController.b(null, "dc00899", "Grp_tribe", "", "post", "Clk_post ", i, 0, b(), "", "", "");
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = null;
        }
        if (!this.jdField_d_of_type_AndroidWidgetTextView.getText().toString().equals(HardCodeUtil.a(2131715105))) {
          break label115;
        }
        q();
      }
      label115:
      Object localObject1;
      do
      {
        return;
        i = 2;
        break;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$AudioUploadTask != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$AudioUploadTask.a() != 0))
        {
          c(true);
          this.rightViewText.setEnabled(false);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(false);
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(false);
          return;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) && (this.jdField_o_of_type_Int == 0))
        {
          QQToast.a(this, 2131696231, 1).b(getTitleBarHeight());
          if (this.jdField_b_of_type_AndroidWidgetTextView != null)
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF725A"));
            localObject1 = getResources().getDrawable(2130843826);
            ((Drawable)localObject1).setColorFilter(new LightingColorFilter(0, -36262));
            this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject1, null, null, null);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
          for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
          {
            TroopBarUtils.a("pub_page", "fail", (String)localObject1, "8", b(), "");
            return;
          }
        }
        if (this.jdField_h_of_type_Boolean)
        {
          localObject1 = TroopBarUtils.a(this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label2031;
          }
          localObject2 = ((String)localObject1).trim();
          int k = ((String)localObject2).length();
          i = k;
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem != null)
          {
            i = k;
            localObject1 = localObject2;
            if (k > this.A.length() + this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_c_of_type_JavaLangString.length() + this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_b_of_type_JavaLangString.length() + this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_a_of_type_JavaLangString.length())
            {
              i = k - this.A.length();
              localObject1 = localObject2;
            }
          }
          if (i < this.jdField_a_of_type_Int)
          {
            QQToast.a(this, getString(2131696237, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }), 0).b(getTitleBarHeight());
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
            {
              TroopBarUtils.a("pub_page", "fail", (String)localObject1, "0", b(), "");
              return;
            }
          }
          if (i > this.jdField_b_of_type_Int)
          {
            QQToast.a(this, getString(2131696238, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }), 0).b(getTitleBarHeight());
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
            {
              TroopBarUtils.a("pub_page", "fail", (String)localObject1, "1", b(), "");
              return;
            }
          }
        }
        else
        {
          if ((TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getText().toString())) && ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())))
          {
            QQToast.a(this, 2131696222, 0).b(getTitleBarHeight());
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
            {
              TroopBarUtils.a("pub_page", "fail", (String)localObject1, "35", b(), "");
              return;
            }
          }
          localObject1 = null;
        }
        localObject3 = TroopBarUtils.a(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
        localObject2 = localObject3;
        if (!TextUtils.isEmpty(this.x))
        {
          localObject2 = localObject3;
          if (((String)localObject3).startsWith(this.x)) {
            localObject2 = ((String)localObject3).substring(this.x.length());
          }
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label2026;
        }
        localObject2 = ((String)localObject2).trim();
        i = ((String)localObject2).length();
        if ((!this.jdField_k_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
        {
          if (i < this.jdField_e_of_type_Int)
          {
            QQToast.a(this, getString(2131696220, new Object[] { Integer.valueOf(this.jdField_e_of_type_Int) }), 0).b(getTitleBarHeight());
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
            {
              TroopBarUtils.a("pub_page", "fail", (String)localObject1, "2", b(), "");
              return;
            }
          }
          if (i > this.f)
          {
            QQToast.a(this, getString(2131696221, new Object[] { Integer.valueOf(this.f) }), 0).b(getTitleBarHeight());
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
            {
              TroopBarUtils.a("pub_page", "fail", (String)localObject1, "4", b(), "");
              return;
            }
          }
        }
      } while (!a(this.jdField_i_of_type_Int, false));
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_e_of_type_Int == 1) && ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())))
      {
        QQToast.a(this, 2131696233, 0).b(getTitleBarHeight());
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
        for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
        {
          TroopBarUtils.a("pub_page", "fail", (String)localObject1, "9", b(), "");
          return;
        }
      }
      if (!HttpUtil.isConnect(this))
      {
        QQToast.a(this, 2131694430, 0).b(getTitleBarHeight());
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
        for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
        {
          TroopBarUtils.a("pub_page", "fail", (String)localObject1, "7", b(), "");
          return;
        }
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString))) && ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)))
      {
        l();
        TribeUtils.a("pub_page_new", "auto_choose_tribe", 0, 0, new String[] { "" });
        return;
      }
      if (this.jdField_r_of_type_Boolean)
      {
        QQToast.a(this, HardCodeUtil.a(2131715100), 0).a();
        return;
      }
      c(true);
      this.rightViewText.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(false);
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject3 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((TroopBarPublishActivity.Pic_list)TroopBarUtils.a.get(localObject3) == null)
        {
          a(1, this.jdField_a_of_type_AndroidOsHandler);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
          for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
          {
            TroopBarUtils.a("pub_page", "fail", (String)localObject1, "10", b(), "");
            return;
          }
        }
        i += 1;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo != null) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.d)))
      {
        a(this.C, false);
        return;
      }
      if ((!TextUtils.isEmpty(this.y)) && (this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo != null) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.jdField_a_of_type_JavaLangString)))
      {
        b(this.y, false);
        return;
      }
      Object localObject3 = TroopBarPublishUtils.a((String)localObject2, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo, this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo);
      Object localObject2 = new JSONObject();
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(this.jdField_q_of_type_JavaLangString)) {
            break label1862;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null)
          {
            l = 0L;
            ((JSONObject)localObject2).put("bid", l);
            ((JSONObject)localObject2).put("post", localObject3);
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              break label2023;
            }
            localObject1 = "###...^_^###";
            if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem != null)
            {
              if (a(this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem, this.A) == null) {
                break label2036;
              }
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_c_of_type_JavaLangString + a(this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem, this.A);
            }
            this.D = ((String)localObject1);
            ((JSONObject)localObject2).put("title", localObject1);
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
            {
              ((JSONObject)localObject2).put("uid", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_a_of_type_JavaLangString);
              ((JSONObject)localObject2).put("lat", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_b_of_type_Int));
              ((JSONObject)localObject2).put("lon", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_a_of_type_Int));
            }
            if (this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo == null) {
              break label2044;
            }
            i = 210;
            ((JSONObject)localObject2).put("type", i);
            ((JSONObject)localObject2).put("extparam", this.v);
            ((JSONObject)localObject2).put("version", "8.5.5.5105");
            if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
              break label2049;
            }
            i = j;
            ((JSONObject)localObject2).put("pubsource", i);
            if (this.jdField_o_of_type_Int != 1) {
              break label1895;
            }
            ((JSONObject)localObject2).put("pversion", 1);
            if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
              break label1895;
            }
            localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
            localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            ((List)localObject1).add(((TroopBarMyBar)((Iterator)localObject3).next()).jdField_c_of_type_JavaLangString);
            continue;
          }
          l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString);
        }
        catch (Exception localException1)
        {
          QQToast.a(this, 1, 2131696253, 0).b(getTitleBarHeight());
          localException1.printStackTrace();
          return;
        }
        continue;
        label1862:
        long l = Long.parseLong(this.jdField_q_of_type_JavaLangString);
      }
      ((JSONObject)localObject2).put("bid_list", new JSONArray(localException1).toString());
      label1895:
      if (this.jdField_t_of_type_Int == -1) {}
      for (i = 0;; i = this.jdField_t_of_type_Int)
      {
        ((JSONObject)localObject2).put("theme_id", i);
        NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), ProtoServlet.class);
        localNewIntent.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.publish_post");
        localObject3 = new WebSsoBody.WebSsoRequestBody();
        ((WebSsoBody.WebSsoRequestBody)localObject3).type.set(0);
        ((WebSsoBody.WebSsoRequestBody)localObject3).data.set(((JSONObject)localObject2).toString());
        localNewIntent.putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject3).toByteArray());
        localNewIntent.setObserver(new TroopBarPublishActivity.5(this));
        this.app.startServlet(localNewIntent);
        return;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        continue;
        label2023:
        continue;
        label2026:
        int i = 0;
        continue;
        label2031:
        i = 0;
        continue;
        label2036:
        String str = "###...^_^###";
        continue;
        label2044:
        i = 0;
        continue;
        label2049:
        i = 1;
      }
    }
  }
  
  public void l()
  {
    w = a();
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    StringBuilder localStringBuilder1 = new StringBuilder("https://buluo.qq.com/mobile/publish_tribe.html?_wv=1027");
    localStringBuilder1.append("&timestamp=" + this.jdField_b_of_type_Long);
    StringBuilder localStringBuilder2 = new StringBuilder().append("&optionType=");
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a())
    {
      localStringBuilder1.append(i);
      localStringBuilder1.append("&supportMultiSelect=" + this.jdField_o_of_type_Int);
      localIntent.putExtra("url", localStringBuilder1.toString());
      startActivityForResult(localIntent, 1004);
      return;
    }
  }
  
  protected void m()
  {
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null)
    {
      str1 = "0";
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {
        break label49;
      }
    }
    label49:
    for (String str2 = "0";; str2 = "1")
    {
      TroopBarUtils.a("pub_page", "choose_tribe", str1, str2, "", "");
      return;
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString;
      break;
    }
  }
  
  protected void n()
  {
    Object localObject2;
    String str1;
    String str2;
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_OrgJsonJSONObject != null))
    {
      localObject2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("share_title");
      str1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("share_content");
      str2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("share_img_list");
      if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText != null)
      {
        TEditText localTEditText = this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localTEditText.setText((CharSequence)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setHint(this.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.jdField_b_of_type_Int) });
      }
      u();
      if (this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText != null)
      {
        localObject2 = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText;
        if (str1 != null) {
          break label235;
        }
      }
    }
    label235:
    for (Object localObject1 = "";; localObject1 = str1)
    {
      ((TEditText)localObject2).setText((CharSequence)localObject1);
      r();
      if (!TextUtils.isEmpty(str2))
      {
        localObject1 = str2.split(";");
        if (localObject1.length > 0)
        {
          localObject1 = new ArrayList(Arrays.asList((Object[])localObject1));
          a(this.jdField_a_of_type_AndroidOsHandler, (ArrayList)localObject1);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null) {
            this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.jdField_a_of_type_Boolean = true;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = new TroopBarPublishUtils.PicUploadThread(this, null, this.jdField_a_of_type_JavaUtilArrayList, "https://upload.buluo.qq.com/cgi-bin/bar/upload/image");
          ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread, 8, null, true);
        }
      }
      return;
    }
  }
  
  public void o()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText != null)
    {
      if (this.jdField_e_of_type_AndroidWidgetTextView != null)
      {
        localObject = this.jdField_e_of_type_AndroidWidgetTextView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().heightPixels;
        this.jdField_e_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_e_of_type_AndroidWidgetTextView.requestLayout();
      }
      if ((this.jdField_u_of_type_Int != 700) && ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() <= 0))) {
        break label98;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText != null) {
        this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.requestFocus();
      }
    }
    return;
    label98:
    int i = DisplayUtil.a(this, 40.0F);
    if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getMeasuredHeight() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.measure(200, -2147483648);
      int j = this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getMeasuredHeight();
      if (j != 0) {
        i = j;
      }
    }
    for (;;)
    {
      if (!this.jdField_t_of_type_Boolean)
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText().toString())) {
          break;
        }
        try
        {
          localObject = View.class.getDeclaredField("mScrollY");
          ((Field)localObject).setAccessible(true);
          ((Field)localObject).set(this.jdField_a_of_type_ComTencentWidgetScrollView, Integer.valueOf(i));
          this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.requestFocus();
          return;
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          localNoSuchFieldException.printStackTrace();
          return;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
          return;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getVisibility() != 0) {
        break;
      }
      a(i, 800, 600, true);
      return;
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo != null)
    {
      DialogUtil.a(this, 230, HardCodeUtil.a(2131715095), HardCodeUtil.a(2131715108), HardCodeUtil.a(2131715091), HardCodeUtil.a(2131715079), new TroopBarPublishActivity.21(this), new TroopBarPublishActivity.22(this)).show();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getTag(2131374282) != null) {
      l();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131370171: 
        m();
      }
    }
    int i;
    label85:
    String str1;
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      i = 2;
      if (!TextUtils.isEmpty(this.jdField_q_of_type_JavaLangString)) {
        break label146;
      }
      str1 = "0";
      label99:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
        break label157;
      }
    }
    label146:
    label157:
    for (String str2 = "0";; str2 = "1")
    {
      ReportController.b(null, "P_CliOper", "Grp_tribe", "", "pub_page", "Clk_place", i, 0, str1, str2, "", "");
      break;
      i = 1;
      break label85;
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString;
      break label99;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void p()
  {
    a(this, "is_first_enter", "true");
  }
  
  protected void q()
  {
    DialogUtil.a(this, 230, null, HardCodeUtil.a(2131715092), HardCodeUtil.a(2131715087), HardCodeUtil.a(2131715076), new TroopBarPublishActivity.17(this), new TroopBarPublishActivity.18(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity
 * JD-Core Version:    0.7.0.1
 */