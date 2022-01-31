package com.tencent.mobileqq.troop.activity;

import alud;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import azib;
import azqs;
import bbco;
import bbct;
import bbes;
import bbev;
import bbfa;
import bbiu;
import bbiw;
import bbix;
import bbiy;
import bbiz;
import bbjb;
import bbje;
import bbjf;
import bbjg;
import bbjh;
import bbji;
import bbjj;
import bbjk;
import bbjl;
import bbjn;
import bbjo;
import bbjp;
import bbjq;
import bclq;
import bcmc;
import bdaq;
import bdfa;
import bdgm;
import bdhj;
import bdne;
import bdnx;
import bety;
import bhsj;
import bnnq;
import bnns;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams.ChangeFace;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams.ComboInfo;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams.Filter;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams.Music;
import com.tencent.mobileqq.tribe.videoupload.TribeVideoUploadTask;
import com.tencent.mobileqq.tribe.view.TEditText;
import com.tencent.mobileqq.tribe.view.TribeThemeSpan;
import com.tencent.mobileqq.troop.data.TroopBarMyBar;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.troop.widget.PublishItemBar;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.troop.widget.TribeHotPicPanel;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.InputMethodLinearLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarCompact;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mzx;
import ndd;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import upd;
import upl;
import xrg;
import xuf;
import xww;

public class TroopBarPublishActivity
  extends AbsPublishActivity
  implements TextWatcher
{
  public static final String C = TroopBarPublishActivity.class.getName();
  public static String F = "";
  public String D = "";
  protected String E;
  public String G = "";
  public String H;
  protected String I;
  public String J = "    ";
  protected String K;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new bbjk(this);
  public bbco a;
  public bbct a;
  private bbev jdField_a_of_type_Bbev;
  public bbfa a;
  public PublishVideoEntry a;
  private TribeVideoUploadTask jdField_a_of_type_ComTencentMobileqqTribeVideouploadTribeVideoUploadTask;
  public TroopBarMyBar a;
  protected CharSequence a;
  public List<TroopBarMyBar> a;
  private JSONArray jdField_a_of_type_OrgJsonJSONArray;
  private Handler jdField_b_of_type_AndroidOsHandler = new bbiw(this);
  protected ImageView b;
  protected RelativeLayout b;
  private TroopBarPublishUtils.PicUploadThread jdField_b_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread;
  private List<bbfa> jdField_b_of_type_JavaUtilList;
  private JSONObject jdField_b_of_type_OrgJsonJSONObject;
  private Handler c;
  private TextView d;
  protected TextView g;
  protected int o;
  private boolean o;
  public final int p;
  protected boolean p;
  public int q;
  public boolean q;
  public int r;
  boolean r;
  public int s;
  protected boolean s;
  public int t;
  private String t;
  protected boolean t;
  private int jdField_u_of_type_Int = 0;
  private String jdField_u_of_type_JavaLangString;
  
  public TroopBarPublishActivity()
  {
    this.jdField_p_of_type_Int = 5;
    this.jdField_r_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = true;
    this.jdField_t_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangCharSequence = "";
    this.jdField_c_of_type_AndroidOsHandler = new bbjh(this);
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
    this.G = paramIntent.getStringExtra("theme_name");
    if (this.jdField_t_of_type_Boolean)
    {
      if (!TextUtils.isEmpty(this.G))
      {
        this.G = ("#" + this.G);
        return;
      }
      this.G = alud.a(2131715619);
      return;
    }
    this.G = "";
  }
  
  private void b(String paramString, long paramLong)
  {
    azib.jdField_r_of_type_Int = 2000000;
    String str1 = paramString + ".doodle.mp4";
    String str2 = paramString + ".tmp.mp4";
    Object localObject = new bnns(azib.jdField_r_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
    ((bnns)localObject).b(2);
    int i = new bnnq().a(paramString, str1, (bnns)localObject, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
    if (i != 0)
    {
      if (i == -1) {
        xrg.c(paramString, str1);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("tribe_publish_TroopBarPublishActivity", 1, "onCompositeFinish step 1 timeCost:" + (SystemClock.uptimeMillis() - paramLong) + "ms bitrate:" + azib.jdField_r_of_type_Int);
      }
      paramString = new MediaMetadataRetriever();
      paramString.setDataSource(str1);
      localObject = paramString.getFrameAtTime();
      this.jdField_a_of_type_Bbct.jdField_b_of_type_Int = ((Bitmap)localObject).getWidth();
      this.jdField_a_of_type_Bbct.c = ((Bitmap)localObject).getHeight();
      paramString.release();
      if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd == 0) {
        break label310;
      }
    }
    label310:
    for (this.jdField_a_of_type_Bbct.jdField_a_of_type_Int = (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd - this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart); (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isMuteRecordVoice) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath)); this.jdField_a_of_type_Bbct.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDuration))
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
        for (i = xuf.a(str1, paramString, str2, 0);; i = xuf.a(str1, paramString, str2, 0, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd))
        {
          xrg.f(str1);
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
    new upd().a(this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, str1, str2, true, new bbjb(this, str1, paramLong, str2));
  }
  
  private void c(String paramString, long paramLong)
  {
    if (AudioHelper.a())
    {
      int i = upl.a(paramString);
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
    return (this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing());
  }
  
  private void v()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText == null) || (this.jdField_b_of_type_AndroidWidgetEditText == null)) {
      return;
    }
    int j = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getText().length();
    if (TextUtils.isEmpty(this.G))
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
    for (int i = 2130842235;; i = 2130842236)
    {
      Object localObject = new SpannableStringBuilder(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getText());
      ((SpannableStringBuilder)localObject).append(this.jdField_j_of_type_JavaLangString);
      localObject = new SpannableString((CharSequence)localObject);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(0), 0, this.G.length(), 33);
      if (!TextUtils.isEmpty(this.G)) {
        ((SpannableString)localObject).setSpan(new xww(this, i), 0, 1, 33);
      }
      this.jdField_b_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
      return;
      i = this.G.length() + 1;
      break;
    }
    label176:
    this.jdField_b_of_type_AndroidWidgetEditText.setVisibility(8);
  }
  
  private void w()
  {
    this.jdField_b_of_type_AndroidWidgetEditText.setEnabled(false);
    if (!TextUtils.isEmpty(this.G)) {
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setMovementMethod(LinkMovementMethod.getInstance());
    }
    this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.addTextChangedListener(new bbjp(this));
    this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setOnSelectionChangedListener(new bbix(this));
    if (this.jdField_u_of_type_Int == 700) {
      this.G = "";
    }
    d(false);
    if ((this.jdField_t_of_type_Boolean) && (!TextUtils.isEmpty(this.G)) && (!bdne.b(this, this.app.getCurrentAccountUin(), "tribe_video_post_has_show_tips", false))) {
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.post(new TroopBarPublishActivity.11(this));
    }
  }
  
  private void x()
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() <= 0) || (!this.jdField_h_of_type_Boolean)) {
      return;
    }
    if (this.jdField_b_of_type_JavaUtilList.size() == 1) {
      this.J = "  ";
    }
    azqs.b(null, "dc00899", "Grp_tribe", "", "pub_page", "exp_prefix", 0, 0, this.jdField_q_of_type_JavaLangString, "", "", "");
    this.jdField_a_of_type_Bbfa = ((bbfa)this.jdField_b_of_type_JavaUtilList.get(0));
    this.jdField_a_of_type_Bbev = new bbev(this, this.jdField_a_of_type_AndroidWidgetListView);
    this.jdField_a_of_type_Bbev.a(new bbjq(this, null));
    this.jdField_a_of_type_Bbco = new bbco(this.jdField_a_of_type_AndroidWidgetListView, this.jdField_a_of_type_Bbev, this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(false);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bbfa.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setMovementMethod(LinkMovementMethod.getInstance());
    }
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.addTextChangedListener(new bbiy(this));
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setOnSelectionChangedListener(new bbiz(this));
    e(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.setFocusableInTouchMode(true);
    int i = this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText().length();
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(i);
  }
  
  private void y()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText == null) || (this.jdField_a_of_type_AndroidWidgetEditText == null) || (this.jdField_a_of_type_Bbfa == null)) {
      return;
    }
    if (this.jdField_a_of_type_Bbfa != null) {}
    for (int i = this.jdField_a_of_type_Bbfa.jdField_b_of_type_JavaLangString.length() + this.jdField_a_of_type_Bbfa.jdField_c_of_type_JavaLangString.length() + this.jdField_a_of_type_Bbfa.jdField_a_of_type_JavaLangString.length();; i = 0)
    {
      int k = this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText().length();
      SpannableString localSpannableString;
      if ((this.jdField_a_of_type_Bbfa == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Bbfa.jdField_b_of_type_JavaLangString)))
      {
        j = 0;
        if (k > j) {
          break label330;
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
        localSpannableString = new SpannableString(new SpannableStringBuilder(this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText()).append(this.jdField_c_of_type_JavaLangString));
        if (i > localSpannableString.length()) {
          break label282;
        }
        localSpannableString.setSpan(new ForegroundColorSpan(0), 0, this.J.length() + i - 1, 33);
        label176:
        if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 1)) {
          if ((this.jdField_a_of_type_Bbco == null) || (!this.jdField_a_of_type_Bbco.b())) {
            break label323;
          }
        }
      }
      label282:
      label323:
      for (int j = 2130842233;; j = 2130842234)
      {
        if ((this.jdField_a_of_type_Bbfa != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bbfa.jdField_b_of_type_JavaLangString))) {
          localSpannableString.setSpan(new xww(this, j), i + 1, i + 2, 33);
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setText(localSpannableString);
        return;
        j = this.J.length() + i;
        break;
        QLog.e("TroopBarPublishActivity", 2, "updateTitlePrefix spannableString = " + localSpannableString + " prefixNum = " + i);
        break label176;
      }
      label330:
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(4);
      return;
    }
  }
  
  private void z()
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
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372941));
    this.jdField_o_of_type_Boolean = b();
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(2131373084, this.jdField_b_of_type_AndroidWidgetTextView);
    }
    r();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVideoCallback(this.jdField_b_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setMusicCallback(this.jdField_b_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setAudioCallback(this.jdField_b_of_type_AndroidOsHandler);
    label269:
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null)
    {
      if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_r_of_type_Boolean)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if ((this.jdField_r_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null))
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
        this.jdField_p_of_type_Boolean = true;
        bcmc.b(this, (Bundle)localObject, "https://buluo.qq.com/cgi-bin/bar/bar_publish_info", 8, null, this);
      }
      if (this.jdField_d_of_type_Boolean) {
        c(2131720065);
      }
      q();
      if (this.mSystemBarComp != null) {
        break label491;
      }
      setImmersiveStatus(-16777216);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131373139));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373138));
      this.g = ((TextView)findViewById(2131373137));
      a(getIntent());
      if (this.jdField_a_of_type_Bbct != null)
      {
        b(getIntent());
        this.jdField_l_of_type_JavaLangString = null;
      }
      w();
      x();
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
      azqs.b(null, "P_CliOper", "Grp_tribe", "", "pub_page", "exp", i, 0, (String)localObject, this.jdField_b_of_type_JavaLangString, localStringBuffer.toString(), "");
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label538;
      }
    }
    label522:
    label527:
    label538:
    for (Object localObject = "0";; localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
    {
      bcmc.a("pub_page", "choose_place", (String)localObject, "0", "", "");
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
      if (this.jdField_a_of_type_Bbct != null) {
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
        localObject = this.jdField_a_of_type_Bbiu;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() < paramInt2) {
          bool = true;
        }
        ((bbiu)localObject).a(bool, true);
        this.jdField_a_of_type_Bbiu.a(this.jdField_a_of_type_JavaUtilArrayList);
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
      bcmc.a("pub_page", "del_photo", (String)localObject, "", "", "");
      return;
      if (this.jdField_q_of_type_Boolean) {
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
    this.jdField_t_of_type_JavaLangString = paramIntent.getStringExtra("thumbPath");
    this.I = paramIntent.getStringExtra("fakeVid");
    String str1 = paramIntent.getStringExtra("videoPath");
    String str2 = paramIntent.getStringExtra("videoDoodleDescription");
    if ((this.jdField_t_of_type_JavaLangString == null) || (this.I == null) || (str1 == null)) {
      return;
    }
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams;
      try
      {
        Bitmap localBitmap = bdhj.a(this.jdField_t_of_type_JavaLangString, null);
        int i = localBitmap.getWidth();
        int j = localBitmap.getHeight();
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        if (i > j)
        {
          localLayoutParams.width = bdaq.a(this, 216.0F);
          localLayoutParams.height = bdaq.a(this, 130.0F);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
          this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setPadding(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingLeft(), this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingTop(), this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getPaddingRight(), 0);
          this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setMinLines(1);
          this.jdField_b_of_type_AndroidWidgetEditText.setPadding(this.jdField_b_of_type_AndroidWidgetEditText.getPaddingLeft(), this.jdField_b_of_type_AndroidWidgetEditText.getPaddingTop(), this.jdField_b_of_type_AndroidWidgetEditText.getPaddingRight(), 0);
          this.jdField_b_of_type_AndroidWidgetEditText.setMinLines(1);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new bbjg(this));
          this.jdField_a_of_type_Bbct = new bbct();
          this.jdField_a_of_type_Bbct.jdField_e_of_type_JavaLangString = str2;
          this.jdField_a_of_type_Bbct.a(paramIntent.getIntExtra("captureMode", 0));
          a(str1, this.I);
          return;
        }
      }
      catch (OutOfMemoryError paramIntent)
      {
        QLog.e("TroopBarPublishActivity", 2, QLog.getStackTraceString(paramIntent));
        return;
      }
      localLayoutParams.width = bdaq.a(this, 130.0F);
      localLayoutParams.height = bdaq.a(this, 216.0F);
    }
  }
  
  public void a(View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Bbiu.a(paramInt))
    {
      a(this, TroopBarPublishActivity.class.getName());
      return;
    }
    bdfa.a();
    paramView = new Intent();
    paramView.putExtra("ALBUM_ID", "$RecentAlbumId");
    paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClass().getName());
    paramView.putExtra("back_btn_text", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697688));
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
    bdfa.anim(this, true, true);
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
      azqs.b(null, "P_CliOper", "Grp_tribe", "", "pub_page", "choose_photo", paramInt, 0, paramView, "", "", "");
      return;
      paramInt = 1;
      break;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (isFinishing())
    {
      upd.a(upd.a(this.I));
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
    this.jdField_s_of_type_Boolean = true;
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
    //   5: invokespecial 1064	com/tencent/mobileqq/troop/activity/AbsPublishActivity:a	(Lorg/json/JSONObject;)V
    //   8: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +30 -> 41
    //   14: ldc_w 340
    //   17: iconst_2
    //   18: new 187	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 1066
    //   28: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_1
    //   32: invokevirtual 345	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 347	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_1
    //   42: ldc_w 697
    //   45: invokevirtual 1069	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   48: invokestatic 1075	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   51: lstore_3
    //   52: lload_3
    //   53: lconst_0
    //   54: lcmp
    //   55: ifne +526 -> 581
    //   58: aload_1
    //   59: ldc_w 611
    //   62: invokevirtual 1078	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   65: ifeq +516 -> 581
    //   68: aload_0
    //   69: aload_1
    //   70: ldc_w 611
    //   73: invokevirtual 1082	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   76: putfield 609	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   79: aload_0
    //   80: getfield 609	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   83: ifnull +498 -> 581
    //   86: aload_0
    //   87: getfield 609	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   90: ldc_w 697
    //   93: invokevirtual 1085	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   96: lstore_3
    //   97: aload_0
    //   98: getfield 609	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   101: ldc_w 1087
    //   104: invokevirtual 1069	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   107: astore 6
    //   109: aload_0
    //   110: iconst_1
    //   111: putfield 72	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_r_of_type_Boolean	Z
    //   114: aload_0
    //   115: aload_1
    //   116: ldc_w 1089
    //   119: iconst_0
    //   120: invokevirtual 1093	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   123: putfield 185	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_t_of_type_Boolean	Z
    //   126: aload_0
    //   127: aload_1
    //   128: ldc_w 1095
    //   131: invokevirtual 1069	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   134: putfield 1097	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:E	Ljava/lang/String;
    //   137: new 606	org/json/JSONObject
    //   140: dup
    //   141: aload_0
    //   142: getfield 1097	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:E	Ljava/lang/String;
    //   145: invokespecial 1099	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   148: astore 8
    //   150: aload_0
    //   151: aload 8
    //   153: ldc_w 1101
    //   156: iconst_0
    //   157: invokevirtual 1104	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   160: putfield 82	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_u_of_type_Int	I
    //   163: aload_0
    //   164: aload_1
    //   165: ldc_w 1106
    //   168: invokevirtual 1110	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   171: putfield 1112	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   174: aload_0
    //   175: getfield 503	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_h_of_type_Boolean	Z
    //   178: ifeq +35 -> 213
    //   181: aload_0
    //   182: getfield 136	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   185: ifnull +12 -> 197
    //   188: aload_0
    //   189: getfield 136	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   192: invokeinterface 1115 1 0
    //   197: aload_0
    //   198: aload_0
    //   199: getfield 1112	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   202: invokestatic 1118	bbco:a	(Lorg/json/JSONArray;)Ljava/util/List;
    //   205: putfield 136	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   208: aload_0
    //   209: aconst_null
    //   210: putfield 1112	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   213: aload_0
    //   214: aload_1
    //   215: ldc_w 1120
    //   218: invokevirtual 1122	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   221: putfield 1124	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_o_of_type_Int	I
    //   224: lload_3
    //   225: lconst_0
    //   226: lcmp
    //   227: ifle +330 -> 557
    //   230: aload_0
    //   231: getfield 72	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_r_of_type_Boolean	Z
    //   234: ifne +306 -> 540
    //   237: aload_0
    //   238: new 668	com/tencent/mobileqq/troop/data/TroopBarMyBar
    //   241: dup
    //   242: lload_3
    //   243: aload_1
    //   244: ldc_w 1126
    //   247: invokevirtual 1069	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   250: invokespecial 1129	com/tencent/mobileqq/troop/data/TroopBarMyBar:<init>	(JLjava/lang/String;)V
    //   253: putfield 663	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   256: aload_0
    //   257: new 187	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   264: aload_0
    //   265: getfield 475	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   268: invokevirtual 480	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   271: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc_w 1131
    //   277: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_0
    //   281: getfield 663	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   284: getfield 698	com/tencent/mobileqq/troop/data/TroopBarMyBar:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   287: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: ldc_w 1131
    //   293: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_0
    //   297: getfield 82	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_u_of_type_Int	I
    //   300: invokevirtual 263	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   303: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: putfield 747	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   309: aload_0
    //   310: aload_0
    //   311: getfield 663	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   314: getfield 698	com/tencent/mobileqq/troop/data/TroopBarMyBar:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   317: putfield 515	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_q_of_type_JavaLangString	Ljava/lang/String;
    //   320: aload_0
    //   321: getfield 82	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_u_of_type_Int	I
    //   324: sipush 700
    //   327: if_icmpne +13 -> 340
    //   330: aload_0
    //   331: aload_0
    //   332: getfield 756	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_i_of_type_Int	I
    //   335: iconst_3
    //   336: iand
    //   337: putfield 756	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_i_of_type_Int	I
    //   340: aload_0
    //   341: ldc_w 509
    //   344: putfield 1133	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_o_of_type_JavaLangString	Ljava/lang/String;
    //   347: aload_0
    //   348: ldc_w 511
    //   351: putfield 1135	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_p_of_type_JavaLangString	Ljava/lang/String;
    //   354: aload_0
    //   355: aload_1
    //   356: ldc_w 1137
    //   359: invokevirtual 1069	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   362: putfield 1139	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:K	Ljava/lang/String;
    //   365: aload_0
    //   366: getfield 1139	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:K	Ljava/lang/String;
    //   369: putstatic 1142	com/tencent/mobileqq/troop/activity/TroopBarPublishUtils:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   372: aload_0
    //   373: aload_1
    //   374: invokevirtual 1144	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:b	(Lorg/json/JSONObject;)V
    //   377: aload_1
    //   378: ldc_w 1146
    //   381: invokevirtual 1122	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   384: istore_2
    //   385: iload_2
    //   386: iconst_1
    //   387: if_icmplt +179 -> 566
    //   390: iload_2
    //   391: bipush 6
    //   393: if_icmpgt +173 -> 566
    //   396: iconst_1
    //   397: istore 5
    //   399: iload 5
    //   401: putstatic 1148	com/tencent/mobileqq/troop/activity/TroopBarPublishUtils:jdField_a_of_type_Boolean	Z
    //   404: return
    //   405: astore 6
    //   407: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   410: ifeq +15 -> 425
    //   413: ldc_w 340
    //   416: iconst_2
    //   417: aload 6
    //   419: invokevirtual 1151	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   422: invokestatic 347	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: lconst_0
    //   426: lstore_3
    //   427: goto -375 -> 52
    //   430: astore 8
    //   432: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   435: ifeq -272 -> 163
    //   438: ldc_w 340
    //   441: iconst_2
    //   442: new 187	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   449: ldc_w 1153
    //   452: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload 7
    //   457: invokevirtual 345	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   460: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 594	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   466: goto -303 -> 163
    //   469: astore 7
    //   471: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   474: ifeq -300 -> 174
    //   477: ldc_w 340
    //   480: iconst_2
    //   481: new 187	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   488: ldc_w 1155
    //   491: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload_1
    //   495: invokevirtual 345	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   498: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokestatic 594	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   504: goto -330 -> 174
    //   507: astore 7
    //   509: ldc_w 340
    //   512: iconst_2
    //   513: new 187	java/lang/StringBuilder
    //   516: dup
    //   517: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   520: ldc_w 1157
    //   523: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: aload 7
    //   528: invokevirtual 345	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   531: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   534: invokestatic 594	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   537: goto -324 -> 213
    //   540: aload_0
    //   541: new 668	com/tencent/mobileqq/troop/data/TroopBarMyBar
    //   544: dup
    //   545: lload_3
    //   546: aload 6
    //   548: invokespecial 1129	com/tencent/mobileqq/troop/data/TroopBarMyBar:<init>	(JLjava/lang/String;)V
    //   551: putfield 663	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   554: goto -298 -> 256
    //   557: aload_0
    //   558: bipush 15
    //   560: putfield 756	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_i_of_type_Int	I
    //   563: goto -243 -> 320
    //   566: iconst_0
    //   567: istore 5
    //   569: goto -170 -> 399
    //   572: astore 7
    //   574: aload 8
    //   576: astore 7
    //   578: goto -146 -> 432
    //   581: aconst_null
    //   582: astore 6
    //   584: goto -470 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	587	0	this	TroopBarPublishActivity
    //   0	587	1	paramJSONObject	JSONObject
    //   384	10	2	i	int
    //   51	495	3	l	long
    //   397	171	5	bool	boolean
    //   107	1	6	str	String
    //   405	142	6	localNumberFormatException	NumberFormatException
    //   582	1	6	localObject1	Object
    //   1	455	7	localObject2	Object
    //   469	1	7	localException1	Exception
    //   507	20	7	localException2	Exception
    //   572	1	7	localJSONException1	JSONException
    //   576	1	7	localObject3	Object
    //   148	4	8	localJSONObject	JSONObject
    //   430	145	8	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   41	52	405	java/lang/NumberFormatException
    //   137	150	430	org/json/JSONException
    //   163	174	469	java/lang/Exception
    //   181	197	507	java/lang/Exception
    //   197	213	507	java/lang/Exception
    //   150	163	572	org/json/JSONException
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
        if ((this.jdField_d_of_type_Boolean) && (this.jdField_p_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = null;
          this.jdField_q_of_type_JavaLangString = null;
        }
      }
      if (this.jdField_d_of_type_Boolean) {
        n();
      }
    } while (!this.jdField_p_of_type_Boolean);
    this.jdField_p_of_type_Boolean = false;
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
          if (!this.jdField_p_of_type_Boolean) {
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
        this.jdField_m_of_type_JavaLangString = paramBundle.optString("forbiddenMsg", getString(2131697687));
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
    String str = bcmc.a(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
    int j;
    if (str == null)
    {
      i = 0;
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishActivity", 2, "onTextChanged: " + i + "--" + this.jdField_l_of_type_Int + "--" + this.jdField_m_of_type_Int);
      }
      if ((this.f <= 0) || (i <= this.f)) {
        break label265;
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
        break label278;
      }
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(0);
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishActivity", 2, "onTextChanged: editStart + diff < 0 -> " + (i + this.jdField_l_of_type_Int));
      }
      return;
      i = str.length();
      break;
      label265:
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    }
    label278:
    this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(i + this.jdField_l_of_type_Int);
  }
  
  public Animation b(float paramFloat1, float paramFloat2)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, paramFloat1, 1, 0.0F, 1, paramFloat2);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setDuration(200L);
    return localTranslateAnimation;
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    Object localObject = new StringBuilder().append("start uploadVideo. mTribeVideoUploadTask is running?");
    if (this.jdField_a_of_type_ComTencentMobileqqTribeVideouploadTribeVideoUploadTask == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("tribe_publish_TroopBarPublishActivity", 1, bool);
      if (!paramBoolean) {
        c(true);
      }
      localObject = new bbes();
      ((bbes)localObject).jdField_a_of_type_JavaLangString = paramString;
      if (this.jdField_a_of_type_ComTencentMobileqqTribeVideouploadTribeVideoUploadTask == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTribeVideouploadTribeVideoUploadTask = new TribeVideoUploadTask(this, this.jdField_c_of_type_AndroidOsHandler, (bbes)localObject);
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
    bdnx.a(this.app, "share_ask", paramJSONObject.optString("bid"));
    this.jdField_i_of_type_Boolean = true;
    this.jdField_j_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 4;
    this.jdField_b_of_type_Int = 25;
    this.jdField_c_of_type_JavaLangString = getString(2131696733, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int) });
    this.jdField_e_of_type_Int = 10;
    this.f = 700;
    this.jdField_j_of_type_JavaLangString = getString(2131696717, new Object[] { Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(this.f) });
    this.jdField_i_of_type_Int |= 0x1;
  }
  
  public boolean b()
  {
    return TextUtils.isEmpty(a(this, "is_first_enter"));
  }
  
  protected void c(JSONObject paramJSONObject)
  {
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_p_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null))
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
      localObject1 = this.jdField_a_of_type_Bbiu;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_s_of_type_Int) {
        bool = true;
      }
      ((bbiu)localObject1).a(bool, true);
      this.jdField_a_of_type_Bbiu.a(this.jdField_a_of_type_JavaUtilArrayList);
    }
    label126:
    do
    {
      return;
      this.jdField_q_of_type_Int = 0;
      this.jdField_q_of_type_Boolean = true;
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
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_a_of_type_Bbiu.a());
    ((TranslateAnimation)localObject1).setDuration(200L);
    ((TranslateAnimation)localObject1).setFillAfter(true);
    this.jdField_c_of_type_AndroidViewView.startAnimation((Animation)localObject1);
  }
  
  public void d(boolean paramBoolean)
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
        if (TextUtils.isEmpty(this.G))
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
      j = 2130842235;
      label175:
      localObject3 = new StringBuilder().append(this.G);
      if (!TextUtils.isEmpty(this.G)) {
        break label365;
      }
      localObject1 = "";
      label205:
      localObject1 = new SpannableString((String)localObject1 + localObject2);
      ((SpannableString)localObject1).setSpan(new TribeThemeSpan(i, 0, this.G.length()), 0, this.G.length(), 33);
      if (!TextUtils.isEmpty(this.G)) {
        ((SpannableString)localObject1).setSpan(new xww(this, j), 0, 1, 33);
      }
      ((SpannableString)localObject1).setSpan(new bbjn(this, i), 0, this.G.length(), 33);
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setText((CharSequence)localObject1);
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText;
      if (!TextUtils.isEmpty(this.G)) {
        break label373;
      }
    }
    label358:
    label365:
    label373:
    for (int i = k;; i = this.G.length() + 1)
    {
      ((TEditText)localObject1).setSelection(i);
      v();
      return;
      i = -18432;
      break;
      j = 2130842236;
      break label175;
      localObject1 = " ";
      break label205;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {}
    label120:
    label761:
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
          bcmc.a("pub_page", "choose_place", paramIntent, "2", "", "");
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
            break label723;
          }
          this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
          paramInt2 = bdaq.a(this, 20.0F);
          int i = bdaq.a(this, 10.0F);
          int j = bdaq.a(this, 6.0F);
          paramInt1 = 0;
          for (;;)
          {
            for (;;)
            {
              if (paramInt1 >= this.jdField_a_of_type_JavaUtilList.size()) {
                break label646;
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
              ((TextView)localObject2).setBackgroundResource(2130843174);
              ((TextView)localObject2).setText(((TroopBarMyBar)localObject1).jdField_a_of_type_JavaLangString);
              ((TextView)localObject2).setTextSize(1, 14.0F);
              ((TextView)localObject2).setContentDescription(((TroopBarMyBar)localObject1).jdField_a_of_type_JavaLangString);
              ((TextView)localObject2).setOnClickListener(this);
              ((TextView)localObject2).setTag(2131373084, localObject1);
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
                    this.D = (this.D + (String)localObject3 + "|");
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
        while (this.jdField_a_of_type_Bbct == null)
        {
          if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
            break label761;
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
    label723:
    QLog.d("TroopBarPublishActivity", 2, "doOnActivityResult, REQUEST_CODE_SELECT_MYBAR");
    label646:
    return;
    a(paramIntent);
    return;
    b(paramIntent);
    d(true);
  }
  
  public void doOnDestroy()
  {
    z();
    if ((!this.jdField_s_of_type_Boolean) && (!TextUtils.isEmpty(this.I))) {
      upd.a(upd.a(this.I));
    }
    if (this.jdField_a_of_type_Bbco != null) {
      this.jdField_a_of_type_Bbco.c();
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
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bbfa == null) {
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
        if (TextUtils.isEmpty(this.jdField_a_of_type_Bbfa.jdField_b_of_type_JavaLangString))
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
          i = this.J.length();
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
    localObject1 = new SpannableStringBuilder(this.jdField_a_of_type_Bbfa.jdField_a_of_type_JavaLangString).append(this.jdField_a_of_type_Bbfa.jdField_b_of_type_JavaLangString).append(this.jdField_a_of_type_Bbfa.jdField_c_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bbfa.jdField_b_of_type_JavaLangString)) {
      ((SpannableStringBuilder)localObject1).append(this.J);
    }
    ((SpannableStringBuilder)localObject1).append(localObject2);
    localObject1 = new SpannableString((CharSequence)localObject1);
    int i = this.jdField_a_of_type_Bbfa.jdField_a_of_type_JavaLangString.length();
    int j = this.jdField_a_of_type_Bbfa.jdField_b_of_type_JavaLangString.length();
    j = this.jdField_a_of_type_Bbfa.jdField_c_of_type_JavaLangString.length() + (i + j);
    ((SpannableString)localObject1).setSpan(new TribeThemeSpan(-16777216, 0, j), 0, j, 33);
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 1)) {
      if ((this.jdField_a_of_type_Bbco == null) || (!this.jdField_a_of_type_Bbco.b())) {
        break label418;
      }
    }
    label418:
    for (i = 2130842233;; i = 2130842234)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Bbfa.jdField_b_of_type_JavaLangString)) {
        ((SpannableString)localObject1).setSpan(new xww(this, i), j + 1, j + 2, 33);
      }
      ((SpannableString)localObject1).setSpan(new bbjo(this), 0, j + this.J.length() - 1, 33);
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setText((CharSequence)localObject1);
      y();
      return;
    }
  }
  
  public void finish()
  {
    super.finish();
    if ((!this.jdField_e_of_type_Boolean) && (this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_OrgJsonJSONObject != null)) {
      bdnx.a(this, this.jdField_a_of_type_OrgJsonJSONObject.optLong("share_app_id"));
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
      bcmc.a("pub_page", "un", str2, str1, "", "");
      return;
      str1 = "1";
      break;
    }
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_Bbct == null) {
      super.k();
    }
    this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setHint("");
    v();
    y();
  }
  
  public void l()
  {
    int j = 2;
    try
    {
      bhsj.b(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
      if (!c())
      {
        if ("barindex".equals(this.jdField_a_of_type_JavaLangString))
        {
          i = 1;
          azqs.b(null, "dc00899", "Grp_tribe", "", "post", "Clk_post ", i, 0, b(), "", "", "");
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = null;
        }
        if (!this.g.getText().toString().equals(alud.a(2131715641))) {
          break label115;
        }
        t();
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
          QQToast.a(this, 2131696724, 1).b(getTitleBarHeight());
          if (this.jdField_b_of_type_AndroidWidgetTextView != null)
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF725A"));
            localObject1 = getResources().getDrawable(2130843177);
            ((Drawable)localObject1).setColorFilter(new LightingColorFilter(0, -36262));
            this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject1, null, null, null);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
          for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
          {
            bcmc.a("pub_page", "fail", (String)localObject1, "8", b(), "");
            return;
          }
        }
        if (this.jdField_h_of_type_Boolean)
        {
          localObject1 = bcmc.a(this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label2031;
          }
          localObject2 = ((String)localObject1).trim();
          int k = ((String)localObject2).length();
          i = k;
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Bbfa != null)
          {
            i = k;
            localObject1 = localObject2;
            if (k > this.J.length() + this.jdField_a_of_type_Bbfa.jdField_c_of_type_JavaLangString.length() + this.jdField_a_of_type_Bbfa.jdField_b_of_type_JavaLangString.length() + this.jdField_a_of_type_Bbfa.jdField_a_of_type_JavaLangString.length())
            {
              i = k - this.J.length();
              localObject1 = localObject2;
            }
          }
          if (i < this.jdField_a_of_type_Int)
          {
            QQToast.a(this, getString(2131696730, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }), 0).b(getTitleBarHeight());
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
            {
              bcmc.a("pub_page", "fail", (String)localObject1, "0", b(), "");
              return;
            }
          }
          if (i > this.jdField_b_of_type_Int)
          {
            QQToast.a(this, getString(2131696731, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }), 0).b(getTitleBarHeight());
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
            {
              bcmc.a("pub_page", "fail", (String)localObject1, "1", b(), "");
              return;
            }
          }
        }
        else
        {
          if ((TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getText().toString())) && ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())))
          {
            QQToast.a(this, 2131696715, 0).b(getTitleBarHeight());
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
            {
              bcmc.a("pub_page", "fail", (String)localObject1, "35", b(), "");
              return;
            }
          }
          localObject1 = null;
        }
        localObject3 = bcmc.a(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
        localObject2 = localObject3;
        if (!TextUtils.isEmpty(this.G))
        {
          localObject2 = localObject3;
          if (((String)localObject3).startsWith(this.G)) {
            localObject2 = ((String)localObject3).substring(this.G.length());
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
            QQToast.a(this, getString(2131696713, new Object[] { Integer.valueOf(this.jdField_e_of_type_Int) }), 0).b(getTitleBarHeight());
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
            {
              bcmc.a("pub_page", "fail", (String)localObject1, "2", b(), "");
              return;
            }
          }
          if (i > this.f)
          {
            QQToast.a(this, getString(2131696714, new Object[] { Integer.valueOf(this.f) }), 0).b(getTitleBarHeight());
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
            {
              bcmc.a("pub_page", "fail", (String)localObject1, "4", b(), "");
              return;
            }
          }
        }
      } while (!a(this.jdField_i_of_type_Int, false));
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_e_of_type_Int == 1) && ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())))
      {
        QQToast.a(this, 2131696726, 0).b(getTitleBarHeight());
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
        for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
        {
          bcmc.a("pub_page", "fail", (String)localObject1, "9", b(), "");
          return;
        }
      }
      if (!ndd.a(this))
      {
        QQToast.a(this, 2131694702, 0).b(getTitleBarHeight());
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
        for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
        {
          bcmc.a("pub_page", "fail", (String)localObject1, "7", b(), "");
          return;
        }
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString))) && ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)))
      {
        p();
        bclq.a("pub_page_new", "auto_choose_tribe", 0, 0, new String[] { "" });
        return;
      }
      if (this.jdField_s_of_type_Boolean)
      {
        QQToast.a(this, alud.a(2131715636), 0).a();
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
        if ((TroopBarPublishActivity.Pic_list)bcmc.a.get(localObject3) == null)
        {
          a(1, this.jdField_a_of_type_AndroidOsHandler);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
          for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
          {
            bcmc.a("pub_page", "fail", (String)localObject1, "10", b(), "");
            return;
          }
        }
        i += 1;
      }
      if ((this.jdField_a_of_type_Bbct != null) && (TextUtils.isEmpty(this.jdField_a_of_type_Bbct.d)))
      {
        a(this.jdField_t_of_type_JavaLangString, false);
        return;
      }
      if ((!TextUtils.isEmpty(this.H)) && (this.jdField_a_of_type_Bbct != null) && (TextUtils.isEmpty(this.jdField_a_of_type_Bbct.jdField_a_of_type_JavaLangString)))
      {
        b(this.H, false);
        return;
      }
      Object localObject3 = TroopBarPublishUtils.a((String)localObject2, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo, this.jdField_a_of_type_Bbct);
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
            if (this.jdField_a_of_type_Bbfa != null)
            {
              if (a(this.jdField_a_of_type_Bbfa, this.J) == null) {
                break label2036;
              }
              localObject1 = this.jdField_a_of_type_Bbfa.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Bbfa.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Bbfa.jdField_c_of_type_JavaLangString + a(this.jdField_a_of_type_Bbfa, this.J);
            }
            this.jdField_u_of_type_JavaLangString = ((String)localObject1);
            ((JSONObject)localObject2).put("title", localObject1);
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
            {
              ((JSONObject)localObject2).put("uid", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_a_of_type_JavaLangString);
              ((JSONObject)localObject2).put("lat", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_b_of_type_Int));
              ((JSONObject)localObject2).put("lon", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_a_of_type_Int));
            }
            if (this.jdField_a_of_type_Bbct == null) {
              break label2044;
            }
            i = 210;
            ((JSONObject)localObject2).put("type", i);
            ((JSONObject)localObject2).put("extparam", this.E);
            ((JSONObject)localObject2).put("version", "8.3.5.4555");
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
          QQToast.a(this, 1, 2131696746, 0).b(getTitleBarHeight());
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
        NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), mzx.class);
        localNewIntent.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.publish_post");
        localObject3 = new WebSsoBody.WebSsoRequestBody();
        ((WebSsoBody.WebSsoRequestBody)localObject3).type.set(0);
        ((WebSsoBody.WebSsoRequestBody)localObject3).data.set(((JSONObject)localObject2).toString());
        localNewIntent.putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject3).toByteArray());
        localNewIntent.setObserver(new bbjl(this));
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
  
  protected void o()
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
      bcmc.a("pub_page", "choose_tribe", str1, str2, "", "");
      return;
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString;
      break;
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Bbct != null)
    {
      bdgm.a(this, 230, alud.a(2131715631), alud.a(2131715644), alud.a(2131715627), alud.a(2131715615), new bbji(this), new bbjj(this)).show();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getTag(2131373084) != null)
    {
      p();
      return;
    }
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131369259: 
      o();
      return;
    }
    int i;
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      i = 2;
      if (!TextUtils.isEmpty(this.jdField_q_of_type_JavaLangString)) {
        break label134;
      }
      paramView = "0";
      label91:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
        break label145;
      }
    }
    label134:
    label145:
    for (String str = "0";; str = "1")
    {
      azqs.b(null, "P_CliOper", "Grp_tribe", "", "pub_page", "Clk_place", i, 0, paramView, str, "", "");
      return;
      i = 1;
      break;
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString;
      break label91;
    }
  }
  
  public void p()
  {
    F = a();
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
  
  protected void q()
  {
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_OrgJsonJSONObject != null))
    {
      Object localObject3 = this.jdField_a_of_type_OrgJsonJSONObject.optString("share_title");
      Object localObject2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("share_content");
      String str = this.jdField_a_of_type_OrgJsonJSONObject.optString("share_img_list");
      if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText != null)
      {
        TEditText localTEditText = this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localTEditText.setText((CharSequence)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setHint(this.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.jdField_b_of_type_Int) });
      }
      y();
      if (this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText != null)
      {
        localObject3 = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText;
        if (localObject2 != null) {
          break label206;
        }
      }
      label206:
      for (Object localObject1 = "";; localObject1 = localObject2)
      {
        ((TEditText)localObject3).setText((CharSequence)localObject1);
        v();
        if (TextUtils.isEmpty(str)) {
          return;
        }
        localObject1 = str.split(";");
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          return;
        }
        localObject2 = new ArrayList();
        int i = 0;
        while (i < localObject1.length)
        {
          ((ArrayList)localObject2).add(localObject1[i]);
          i += 1;
        }
      }
      a(this.jdField_a_of_type_AndroidOsHandler, (ArrayList)localObject2);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = new TroopBarPublishUtils.PicUploadThread(this, null, this.jdField_a_of_type_JavaUtilArrayList, "https://upload.buluo.qq.com/cgi-bin/bar/upload/image");
      ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread, 8, null, true);
    }
  }
  
  public void r()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText != null)
    {
      if (this.jdField_d_of_type_AndroidWidgetTextView != null)
      {
        localObject = this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().heightPixels;
        this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_d_of_type_AndroidWidgetTextView.requestLayout();
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
    int i = bdaq.a(this, 40.0F);
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
      if (!this.jdField_o_of_type_Boolean)
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
  
  public void s()
  {
    a(this, "is_first_enter", "true");
  }
  
  public void t()
  {
    bdgm.a(this, 230, null, alud.a(2131715628), alud.a(2131715623), alud.a(2131715612), new bbje(this), new bbjf(this)).show();
  }
  
  public void u()
  {
    TribeVideoPublishParams localTribeVideoPublishParams = (TribeVideoPublishParams)getIntent().getSerializableExtra(TribeVideoPublishParams.BUNDLE_EXTRA_KEY);
    if ("barindex".equals(this.jdField_a_of_type_JavaLangString)) {}
    for (int i = 1;; i = 2)
    {
      if (localTribeVideoPublishParams.combo0Info != null) {
        azqs.b(this.app, "dc00899", "Grp_tribe", "", "video_shoot", "pub_packages", i, 0, localTribeVideoPublishParams.combo0Info.id, localTribeVideoPublishParams.combo0Info.type, "", "");
      }
      if ((localTribeVideoPublishParams.changeFace != null) && (!TextUtils.isEmpty(localTribeVideoPublishParams.changeFace.id))) {
        azqs.b(this.app, "dc00899", "Grp_tribe", "", "video_shoot", "pub_changeface", i, 0, localTribeVideoPublishParams.changeFace.id, localTribeVideoPublishParams.changeFace.type, "", "");
      }
      if (localTribeVideoPublishParams.filter != null) {
        azqs.b(this.app, "dc00899", "Grp_tribe", "", "video_shoot", "pub_filter", i, 0, localTribeVideoPublishParams.filter.id, localTribeVideoPublishParams.filter.typeId, "", "");
      }
      if (localTribeVideoPublishParams.beauty > 0) {
        azqs.b(this.app, "dc00899", "Grp_tribe", "", "video_shoot", "pub_beauty", i, 0, "" + localTribeVideoPublishParams.beauty, "", "", "");
      }
      if (localTribeVideoPublishParams.hasGraffiti) {
        azqs.b(this.app, "dc00899", "Grp_tribe", "", "video_edit", "pub_graffiti", i, 0, "", "", "", "");
      }
      if (localTribeVideoPublishParams.hasText) {
        azqs.b(this.app, "dc00899", "Grp_tribe", "", "video_edit", "pub_text", i, 0, "", "", "", "");
      }
      if (localTribeVideoPublishParams.hasFace) {
        azqs.b(this.app, "dc00899", "Grp_tribe", "", "video_edit", "pub_face", i, 0, "", "", "", "");
      }
      if (localTribeVideoPublishParams.music == null) {
        break;
      }
      azqs.b(this.app, "dc00899", "Grp_tribe", "", "video_edit", "pub_music", i, 0, localTribeVideoPublishParams.music.name, localTribeVideoPublishParams.music.type, "", "");
      return;
    }
    if (localTribeVideoPublishParams.isSoundOn)
    {
      azqs.b(this.app, "dc00899", "Grp_tribe", "", "video_edit", "sound_on", i, 0, "", "", "", "");
      return;
    }
    azqs.b(this.app, "dc00899", "Grp_tribe", "", "video_edit", "sound_off", i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity
 * JD-Core Version:    0.7.0.1
 */