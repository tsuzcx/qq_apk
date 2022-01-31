package com.tencent.mobileqq.troop.activity;

import aijc;
import aijd;
import aije;
import aijf;
import aijg;
import aijh;
import aijj;
import aijm;
import aijn;
import aijo;
import aijp;
import aijq;
import aijr;
import aijs;
import aijt;
import aiju;
import aijv;
import aijw;
import aijy;
import aijz;
import aika;
import aikb;
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
import android.os.Bundle;
import android.os.Handler;
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
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.view.widget.VerticalImageSpan;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tribe.TribePostTitlePrefixPanelController;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams.ChangeFace;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams.Filter;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams.Music;
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
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.TroopBarShareUtils;
import com.tencent.mobileqq.widget.InputMethodLinearLayout;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.immersive.SystemBarCompact;
import java.lang.reflect.Field;
import java.util.ArrayList;
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
  public static final String D = TroopBarPublishActivity.class.getName();
  public static String G = "";
  public String E = "";
  protected String F;
  public String H = "";
  public String I;
  protected String J;
  public String K = "    ";
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new aiju(this);
  public PublishVideoEntry a;
  public TribePostTitlePrefixPanelController a;
  public VideoInfo a;
  private TribeVideoUploadTask jdField_a_of_type_ComTencentMobileqqTribeVideouploadTribeVideoUploadTask;
  public TribeTitlePrefixPanelView.TitlePrefixItem a;
  private TribeTitlePrefixPanelView jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView;
  public TroopBarMyBar a;
  protected CharSequence a;
  public List a;
  private JSONArray jdField_a_of_type_OrgJsonJSONArray;
  private Handler jdField_b_of_type_AndroidOsHandler = new aijc(this);
  public ImageView b;
  protected RelativeLayout b;
  private TroopBarPublishUtils.PicUploadThread jdField_b_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread;
  private List jdField_b_of_type_JavaUtilList;
  private JSONObject jdField_b_of_type_OrgJsonJSONObject;
  private Handler c;
  private TextView d;
  public TextView g;
  protected int o;
  private boolean o;
  public final int p;
  protected boolean p;
  public int q;
  public boolean q;
  public int r;
  boolean r;
  public int s;
  public boolean s;
  public int t;
  protected boolean t;
  private int jdField_u_of_type_Int = 0;
  private String jdField_u_of_type_JavaLangString;
  private String v;
  
  public TroopBarPublishActivity()
  {
    this.jdField_p_of_type_Int = 5;
    this.jdField_r_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = true;
    this.jdField_t_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangCharSequence = "";
    this.jdField_c_of_type_AndroidOsHandler = new aijp(this);
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
    this.H = paramIntent.getStringExtra("theme_name");
    if (this.jdField_t_of_type_Boolean)
    {
      if (!TextUtils.isEmpty(this.H))
      {
        this.H = ("#" + this.H);
        return;
      }
      this.H = "#添加话题";
      return;
    }
    this.H = "";
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing());
  }
  
  private void u()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText == null) || (this.jdField_b_of_type_AndroidWidgetEditText == null)) {
      return;
    }
    int j = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getText().length();
    if (TextUtils.isEmpty(this.H))
    {
      i = 0;
      if (j > i) {
        break label175;
      }
      this.jdField_b_of_type_AndroidWidgetEditText.setVisibility(0);
      if (this.jdField_t_of_type_Int != -1) {
        break label168;
      }
    }
    label168:
    for (int i = 2130840600;; i = 2130840601)
    {
      Object localObject = new SpannableStringBuilder(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getText());
      ((SpannableStringBuilder)localObject).append(this.jdField_k_of_type_JavaLangString);
      localObject = new SpannableString((CharSequence)localObject);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(0), 0, this.H.length(), 33);
      if (!TextUtils.isEmpty(this.H)) {
        ((SpannableString)localObject).setSpan(new VerticalImageSpan(this, i), 0, 1, 33);
      }
      this.jdField_b_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
      return;
      i = this.H.length() + 1;
      break;
    }
    label175:
    this.jdField_b_of_type_AndroidWidgetEditText.setVisibility(8);
  }
  
  private void v()
  {
    this.jdField_b_of_type_AndroidWidgetEditText.setEnabled(false);
    if (!TextUtils.isEmpty(this.H)) {
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setMovementMethod(LinkMovementMethod.getInstance());
    }
    this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.addTextChangedListener(new aika(this));
    this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setOnSelectionChangedListener(new aijd(this));
    if (this.jdField_u_of_type_Int == 700) {
      this.H = "";
    }
    d(false);
    if ((this.jdField_t_of_type_Boolean) && (!TextUtils.isEmpty(this.H)) && (!SharedPreUtils.a(this, this.app.getCurrentAccountUin(), "tribe_video_post_has_show_tips", false))) {
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.post(new aije(this));
    }
  }
  
  private void w()
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() <= 0) || (!this.jdField_h_of_type_Boolean)) {
      return;
    }
    if (this.jdField_b_of_type_JavaUtilList.size() == 1) {
      this.K = "  ";
    }
    ReportController.b(null, "dc00899", "Grp_tribe", "", "pub_page", "exp_prefix", 0, 0, this.jdField_r_of_type_JavaLangString, "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem = ((TribeTitlePrefixPanelView.TitlePrefixItem)this.jdField_b_of_type_JavaUtilList.get(0));
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView = new TribeTitlePrefixPanelView(this, this.jdField_a_of_type_AndroidWidgetListView);
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView.a(new aikb(this, null));
    this.jdField_a_of_type_ComTencentMobileqqTribeTribePostTitlePrefixPanelController = new TribePostTitlePrefixPanelController(this.jdField_a_of_type_AndroidWidgetListView, this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView, this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(false);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setMovementMethod(LinkMovementMethod.getInstance());
    }
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.addTextChangedListener(new aijf(this));
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setOnSelectionChangedListener(new aijg(this));
    e(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.setFocusableInTouchMode(true);
    int i = this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText().length();
    this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(i);
  }
  
  private void x()
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
          break label330;
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
        localSpannableString = new SpannableString(new SpannableStringBuilder(this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText()).append(this.jdField_d_of_type_JavaLangString));
        if (i > localSpannableString.length()) {
          break label282;
        }
        localSpannableString.setSpan(new ForegroundColorSpan(0), 0, this.K.length() + i - 1, 33);
        label176:
        if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 1)) {
          if ((this.jdField_a_of_type_ComTencentMobileqqTribeTribePostTitlePrefixPanelController == null) || (!this.jdField_a_of_type_ComTencentMobileqqTribeTribePostTitlePrefixPanelController.b())) {
            break label323;
          }
        }
      }
      label282:
      label323:
      for (int j = 2130840598;; j = 2130840599)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_b_of_type_JavaLangString))) {
          localSpannableString.setSpan(new VerticalImageSpan(this, j), i + 1, i + 2, 33);
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setText(localSpannableString);
        return;
        j = this.K.length() + i;
        break;
        QLog.e("TroopBarPublishActivity", 2, "updateTitlePrefix spannableString = " + localSpannableString + " prefixNum = " + i);
        break label176;
      }
      label330:
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(4);
      return;
    }
  }
  
  private void y()
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
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366589));
    this.jdField_o_of_type_Boolean = b();
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(2131368548, this.jdField_b_of_type_AndroidWidgetTextView);
    }
    q();
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
        TroopBarUtils.b(this, (Bundle)localObject, "https://buluo.qq.com/cgi-bin/bar/bar_publish_info", 8, null, this);
      }
      if (this.jdField_d_of_type_Boolean) {
        c(2131430143);
      }
      p();
      if (this.mSystemBarComp != null) {
        break label523;
      }
      setImmersiveStatus(-16777216);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131366586));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366587));
      this.g = ((TextView)findViewById(2131366588));
      a(getIntent());
      if (this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo != null)
      {
        b(getIntent());
        this.jdField_m_of_type_JavaLangString = null;
      }
      v();
      w();
      StringBuffer localStringBuffer = new StringBuffer();
      if ((this.jdField_i_of_type_Int & 0x1) == 1) {
        localStringBuffer.append("0");
      }
      if ((this.jdField_i_of_type_Int & 0x2) == 2) {
        localStringBuffer.append("1");
      }
      if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
        break label554;
      }
      i = 2;
      label409:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label559;
      }
      localObject = "0";
      label420:
      ReportController.b(null, "P_CliOper", "Grp_tribe", "", "pub_page", "exp", i, 0, (String)localObject, this.jdField_c_of_type_JavaLangString, localStringBuffer.toString(), "");
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label570;
      }
    }
    label523:
    label554:
    label559:
    label570:
    for (Object localObject = "0";; localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
    {
      TroopBarUtils.a("pub_page", "choose_place", (String)localObject, "0", "", "");
      if (this.jdField_d_of_type_Int == 2) {
        TroopBarUtils.a("Grp_talk", "pub_talk", "exp", this.jdField_s_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "", "");
      }
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
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
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aijw(this, paramInt1, paramInt3, paramBoolean), paramInt2);
  }
  
  protected void a(Intent paramIntent)
  {
    this.jdField_u_of_type_JavaLangString = paramIntent.getStringExtra("thumbPath");
    this.J = paramIntent.getStringExtra("fakeVid");
    String str = paramIntent.getStringExtra("videoPath");
    paramIntent = paramIntent.getStringExtra("videoDoodleDescription");
    if ((this.jdField_u_of_type_JavaLangString == null) || (this.J == null) || (str == null)) {
      return;
    }
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams;
      try
      {
        Bitmap localBitmap = ImageUtil.a(this.jdField_u_of_type_JavaLangString, null);
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
          this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new aijo(this));
          this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo = new VideoInfo();
          this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.e = paramIntent;
          a(str, this.J);
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
    paramView.putExtra("back_btn_text", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131430479));
    paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_JavaUtilArrayList);
    paramView.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    paramView.putExtra("PhotoConst.MAXUM_SELECTED_NUM", this.jdField_a_of_type_JavaUtilArrayList.size());
    paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramInt);
    paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    paramView.putExtra("PhotoConst.IS_OVERLOAD", false);
    paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    paramView.putExtra("from_tribe_class_name", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClass().getSimpleName());
    paramView.setClass(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, PhotoPreviewActivity.class);
    paramView.addFlags(603979776);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
    AlbumUtil.a(this, true, true);
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      paramInt = 2;
      if (!TextUtils.isEmpty(this.jdField_r_of_type_JavaLangString)) {
        break label281;
      }
    }
    label281:
    for (paramView = "0";; paramView = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
    {
      ReportController.b(null, "P_CliOper", "Grp_tribe", "", "pub_page", "choose_photo", paramInt, 0, paramView, "", "", "");
      return;
      paramInt = 1;
      break;
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    this.jdField_s_of_type_Boolean = true;
    VideoCompositeHelper localVideoCompositeHelper = new VideoCompositeHelper();
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = VideoCompositeHelper.a(paramString2);
    if (!this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isLocalPublish) {
      this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isLocalPublish;
    paramString2 = new aijh(this);
    localVideoCompositeHelper.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, paramString1 + ".tmp.mp4", false, paramString2);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    QLog.d("tribe_publish_TroopBarPublishActivity", 2, "start uploadVideoThumb " + paramBoolean);
    if (!paramBoolean) {
      c(true);
    }
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramString);
    if (this.jdField_b_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = new TroopBarPublishUtils.PicUploadThread(this, this.jdField_c_of_type_AndroidOsHandler, localArrayList, this.jdField_f_of_type_JavaLangString);
      ThreadManager.post(this.jdField_b_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread, 8, null, true);
    }
  }
  
  /* Error */
  void a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: aload_1
    //   5: invokespecial 931	com/tencent/mobileqq/troop/activity/AbsPublishActivity:a	(Lorg/json/JSONObject;)V
    //   8: invokestatic 934	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +30 -> 41
    //   14: ldc_w 414
    //   17: iconst_2
    //   18: new 180	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 936
    //   28: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_1
    //   32: invokevirtual 419	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 905	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_1
    //   42: ldc_w 538
    //   45: invokevirtual 939	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   48: invokestatic 945	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   51: lstore_2
    //   52: lload_2
    //   53: lconst_0
    //   54: lcmp
    //   55: ifne +470 -> 525
    //   58: aload_1
    //   59: ldc_w 451
    //   62: invokevirtual 949	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   65: ifeq +460 -> 525
    //   68: aload_0
    //   69: aload_1
    //   70: ldc_w 451
    //   73: invokevirtual 953	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   76: putfield 449	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   79: aload_0
    //   80: getfield 449	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   83: ifnull +442 -> 525
    //   86: aload_0
    //   87: getfield 449	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   90: ldc_w 538
    //   93: invokevirtual 956	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   96: lstore_2
    //   97: aload_0
    //   98: getfield 449	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   101: ldc_w 958
    //   104: invokevirtual 939	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   107: astore 4
    //   109: aload_0
    //   110: iconst_1
    //   111: putfield 70	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_r_of_type_Boolean	Z
    //   114: aload_0
    //   115: aload_1
    //   116: ldc_w 960
    //   119: iconst_0
    //   120: invokevirtual 964	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   123: putfield 178	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_t_of_type_Boolean	Z
    //   126: aload_0
    //   127: aload_1
    //   128: ldc_w 966
    //   131: invokevirtual 939	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   134: putfield 968	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:F	Ljava/lang/String;
    //   137: new 446	org/json/JSONObject
    //   140: dup
    //   141: aload_0
    //   142: getfield 968	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:F	Ljava/lang/String;
    //   145: invokespecial 971	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   148: astore 6
    //   150: aload_0
    //   151: aload 6
    //   153: ldc_w 973
    //   156: iconst_0
    //   157: invokevirtual 976	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   160: putfield 80	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_u_of_type_Int	I
    //   163: aload_0
    //   164: aload_1
    //   165: ldc_w 978
    //   168: invokevirtual 982	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   171: putfield 984	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   174: aload_0
    //   175: getfield 326	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_h_of_type_Boolean	Z
    //   178: ifeq +35 -> 213
    //   181: aload_0
    //   182: getfield 134	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   185: ifnull +12 -> 197
    //   188: aload_0
    //   189: getfield 134	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   192: invokeinterface 987 1 0
    //   197: aload_0
    //   198: aload_0
    //   199: getfield 984	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   202: invokestatic 990	com/tencent/mobileqq/tribe/TribePostTitlePrefixPanelController:a	(Lorg/json/JSONArray;)Ljava/util/List;
    //   205: putfield 134	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   208: aload_0
    //   209: aconst_null
    //   210: putfield 984	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   213: aload_0
    //   214: aload_1
    //   215: ldc_w 992
    //   218: invokevirtual 994	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   221: putfield 996	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_o_of_type_Int	I
    //   224: lload_2
    //   225: lconst_0
    //   226: lcmp
    //   227: ifle +280 -> 507
    //   230: aload_0
    //   231: getfield 70	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_r_of_type_Boolean	Z
    //   234: ifne +256 -> 490
    //   237: aload_0
    //   238: new 508	com/tencent/mobileqq/troop/data/TroopBarMyBar
    //   241: dup
    //   242: lload_2
    //   243: aload_1
    //   244: ldc_w 998
    //   247: invokevirtual 939	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   250: invokespecial 1001	com/tencent/mobileqq/troop/data/TroopBarMyBar:<init>	(JLjava/lang/String;)V
    //   253: putfield 503	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   256: aload_0
    //   257: new 180	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   264: aload_0
    //   265: getfield 298	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   268: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   271: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc_w 1003
    //   277: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_0
    //   281: getfield 503	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   284: getfield 539	com/tencent/mobileqq/troop/data/TroopBarMyBar:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   287: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: ldc_w 1003
    //   293: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_0
    //   297: getfield 80	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_u_of_type_Int	I
    //   300: invokevirtual 424	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   303: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: putfield 590	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   309: aload_0
    //   310: aload_0
    //   311: getfield 503	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   314: getfield 539	com/tencent/mobileqq/troop/data/TroopBarMyBar:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   317: putfield 338	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_r_of_type_JavaLangString	Ljava/lang/String;
    //   320: aload_0
    //   321: getfield 80	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_u_of_type_Int	I
    //   324: sipush 700
    //   327: if_icmpne +8 -> 335
    //   330: aload_0
    //   331: iconst_3
    //   332: putfield 599	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_i_of_type_Int	I
    //   335: aload_0
    //   336: ldc_w 332
    //   339: putfield 1005	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_p_of_type_JavaLangString	Ljava/lang/String;
    //   342: aload_0
    //   343: ldc_w 334
    //   346: putfield 1007	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_q_of_type_JavaLangString	Ljava/lang/String;
    //   349: aload_0
    //   350: aload_1
    //   351: invokevirtual 1009	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:b	(Lorg/json/JSONObject;)V
    //   354: return
    //   355: astore 4
    //   357: invokestatic 934	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   360: ifeq +15 -> 375
    //   363: ldc_w 414
    //   366: iconst_2
    //   367: aload 4
    //   369: invokevirtual 1012	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   372: invokestatic 905	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: lconst_0
    //   376: lstore_2
    //   377: goto -325 -> 52
    //   380: astore 6
    //   382: invokestatic 934	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   385: ifeq -222 -> 163
    //   388: ldc_w 414
    //   391: iconst_2
    //   392: new 180	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   399: ldc_w 1014
    //   402: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload 5
    //   407: invokevirtual 419	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   410: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 429	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: goto -253 -> 163
    //   419: astore 5
    //   421: invokestatic 934	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq -250 -> 174
    //   427: ldc_w 414
    //   430: iconst_2
    //   431: new 180	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 1016
    //   441: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: aload_1
    //   445: invokevirtual 419	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 429	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   454: goto -280 -> 174
    //   457: astore 5
    //   459: ldc_w 414
    //   462: iconst_2
    //   463: new 180	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   470: ldc_w 1018
    //   473: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload 5
    //   478: invokevirtual 419	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   481: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 429	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   487: goto -274 -> 213
    //   490: aload_0
    //   491: new 508	com/tencent/mobileqq/troop/data/TroopBarMyBar
    //   494: dup
    //   495: lload_2
    //   496: aload 4
    //   498: invokespecial 1001	com/tencent/mobileqq/troop/data/TroopBarMyBar:<init>	(JLjava/lang/String;)V
    //   501: putfield 503	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar	Lcom/tencent/mobileqq/troop/data/TroopBarMyBar;
    //   504: goto -248 -> 256
    //   507: aload_0
    //   508: bipush 15
    //   510: putfield 599	com/tencent/mobileqq/troop/activity/TroopBarPublishActivity:jdField_i_of_type_Int	I
    //   513: goto -193 -> 320
    //   516: astore 5
    //   518: aload 6
    //   520: astore 5
    //   522: goto -140 -> 382
    //   525: aconst_null
    //   526: astore 4
    //   528: goto -414 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	531	0	this	TroopBarPublishActivity
    //   0	531	1	paramJSONObject	JSONObject
    //   51	445	2	l	long
    //   107	1	4	str	String
    //   355	142	4	localNumberFormatException	NumberFormatException
    //   526	1	4	localObject1	Object
    //   1	405	5	localObject2	Object
    //   419	1	5	localException1	Exception
    //   457	20	5	localException2	Exception
    //   516	1	5	localJSONException1	JSONException
    //   520	1	5	localObject3	Object
    //   148	4	6	localJSONObject	JSONObject
    //   380	139	6	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   41	52	355	java/lang/NumberFormatException
    //   137	150	380	org/json/JSONException
    //   163	174	419	java/lang/Exception
    //   181	197	457	java/lang/Exception
    //   197	213	457	java/lang/Exception
    //   150	163	516	org/json/JSONException
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    int i = 1;
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
          this.jdField_r_of_type_JavaLangString = null;
        }
      }
      if (this.jdField_d_of_type_Boolean) {
        m();
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
    this.jdField_i_of_type_Boolean = paramJSONObject.optBoolean("needLocation", true);
    this.j = paramJSONObject.optBoolean("needFace", true);
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
        if (!this.jdField_d_of_type_Boolean) {
          continue;
        }
        if (!this.jdField_p_of_type_Boolean) {
          continue;
        }
        this.jdField_i_of_type_Int |= paramBundle.optInt("optionType");
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_e_of_type_Int == 1)) {
          this.jdField_i_of_type_Int |= 0x1;
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
        this.jdField_n_of_type_JavaLangString = paramBundle.optString("forbiddenMsg", getString(2131430473));
      }
      catch (JSONException paramBundle)
      {
        boolean bool;
        continue;
        paramInt = 0;
        continue;
      }
      a();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aijt(this), 200L);
      c(paramJSONObject);
      break;
      bool = false;
      continue;
      this.jdField_i_of_type_Int = paramBundle.optInt("optionType");
      continue;
      if (!"barindex".equals(this.jdField_a_of_type_JavaLangString)) {
        continue;
      }
      paramInt = i;
      this.jdField_i_of_type_Int = paramBundle.optInt("optionType", paramInt);
      continue;
      paramInt = paramBundle.optInt("recordTimeLimit");
      paramInt *= 1000;
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    this.l = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getSelectionStart();
    this.jdField_m_of_type_Int = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.getSelectionEnd();
    String str = TroopBarUtils.a(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
    int j;
    if (str == null)
    {
      i = 0;
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishActivity", 2, "onTextChanged: " + i + "--" + this.l + "--" + this.jdField_m_of_type_Int);
      }
      if ((this.jdField_f_of_type_Int <= 0) || (i <= this.jdField_f_of_type_Int)) {
        break label265;
      }
      j = i - this.jdField_f_of_type_Int;
      paramEditable.delete(this.l - j, this.jdField_m_of_type_Int);
      this.l -= j;
      this.jdField_m_of_type_Int -= j;
      i = j;
      if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue())
      {
        QQToast.a(this, this.jdField_t_of_type_JavaLangString, 0).b(getTitleBarHeight());
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      }
    }
    for (int i = j;; i = 0)
    {
      if (this.l + i >= 0) {
        break label278;
      }
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(0);
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishActivity", 2, "onTextChanged: editStart + diff < 0 -> " + (i + this.l));
      }
      return;
      i = str.length();
      break;
      label265:
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    }
    label278:
    this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(i + this.l);
  }
  
  public Animation b(float paramFloat1, float paramFloat2)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, paramFloat1, 1, 0.0F, 1, paramFloat2);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setDuration(200L);
    return localTranslateAnimation;
  }
  
  public void b(String paramString)
  {
    if (isFinishing())
    {
      VideoCompositeHelper.a(VideoCompositeHelper.a(this.J));
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new aijj(this, paramString));
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
    this.j = true;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 4;
    this.jdField_b_of_type_Int = 25;
    this.jdField_d_of_type_JavaLangString = getString(2131430298, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int) });
    this.jdField_e_of_type_Int = 10;
    this.jdField_f_of_type_Int = 700;
    this.jdField_k_of_type_JavaLangString = getString(2131430299, new Object[] { Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(this.jdField_f_of_type_Int) });
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
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a());
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
        if (TextUtils.isEmpty(this.H))
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
        break label357;
      }
      j = 2130840600;
      label174:
      localObject3 = new StringBuilder().append(this.H);
      if (!TextUtils.isEmpty(this.H)) {
        break label364;
      }
      localObject1 = "";
      label204:
      localObject1 = new SpannableString((String)localObject1 + localObject2);
      ((SpannableString)localObject1).setSpan(new TribeThemeSpan(i, 0, this.H.length()), 0, this.H.length(), 33);
      if (!TextUtils.isEmpty(this.H)) {
        ((SpannableString)localObject1).setSpan(new VerticalImageSpan(this, j), 0, 1, 33);
      }
      ((SpannableString)localObject1).setSpan(new aijy(this, i), 0, this.H.length(), 33);
      this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setText((CharSequence)localObject1);
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText;
      if (!TextUtils.isEmpty(this.H)) {
        break label372;
      }
    }
    label357:
    label364:
    label372:
    for (int i = k;; i = this.H.length() + 1)
    {
      ((TEditText)localObject1).setSelection(i);
      u();
      return;
      i = -18432;
      break;
      j = 2130840601;
      break label174;
      localObject1 = " ";
      break label204;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
            paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_d_of_type_JavaLangString;
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
            break label723;
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
                break label646;
              }
              localObject1 = (TroopBarMyBar)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
              if (paramInt1 == 0)
              {
                this.jdField_r_of_type_JavaLangString = ((TroopBarMyBar)localObject1).jdField_c_of_type_JavaLangString;
                this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = ((TroopBarMyBar)localObject1);
              }
              Object localObject2 = new TextView(this);
              Object localObject3 = new LinearLayout.LayoutParams(-2, paramInt2);
              ((LinearLayout.LayoutParams)localObject3).rightMargin = i;
              ((TextView)localObject2).setPadding(j, 0, j, 0);
              ((LinearLayout.LayoutParams)localObject3).gravity = 16;
              ((TextView)localObject2).setTextColor(Color.parseColor("#FFB800"));
              ((TextView)localObject2).setBackgroundResource(2130841176);
              ((TextView)localObject2).setText(((TroopBarMyBar)localObject1).jdField_a_of_type_JavaLangString);
              ((TextView)localObject2).setTextSize(1, 14.0F);
              ((TextView)localObject2).setContentDescription(((TroopBarMyBar)localObject1).jdField_a_of_type_JavaLangString);
              ((TextView)localObject2).setOnClickListener(this);
              ((TextView)localObject2).setTag(2131368548, localObject1);
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
                    this.E = (this.E + (String)localObject3 + "|");
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
            break label761;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.a(1);
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.isShown())) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemBar.a(5, 1);
          return;
          this.jdField_r_of_type_JavaLangString = "";
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = null;
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
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
  
  protected void doOnDestroy()
  {
    y();
    if ((!this.jdField_s_of_type_Boolean) && (!TextUtils.isEmpty(this.J))) {
      VideoCompositeHelper.a(VideoCompositeHelper.a(this.J));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTribeTribePostTitlePrefixPanelController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTribeTribePostTitlePrefixPanelController.c();
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_d_of_type_AndroidViewView != null) && (!this.jdField_n_of_type_Boolean) && (this.jdField_c_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aijq(this), 200L);
    }
  }
  
  public void e(boolean paramBoolean)
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
          i = this.K.length();
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
      ((SpannableStringBuilder)localObject1).append(this.K);
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
    for (i = 2130840598;; i = 2130840599)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_b_of_type_JavaLangString)) {
        ((SpannableString)localObject1).setSpan(new VerticalImageSpan(this, i), j + 1, j + 2, 33);
      }
      ((SpannableString)localObject1).setSpan(new aijz(this), 0, j + this.K.length() - 1, 33);
      this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setText((CharSequence)localObject1);
      x();
      return;
    }
  }
  
  public void finish()
  {
    super.finish();
    if ((!this.jdField_e_of_type_Boolean) && (this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_OrgJsonJSONObject != null)) {
      TroopBarShareUtils.a(this, this.jdField_a_of_type_OrgJsonJSONObject.optLong("share_app_id"));
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
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo == null) {
      super.j();
    }
    this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText.setHint("");
    u();
    x();
  }
  
  public void k()
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
        if (!this.g.getText().toString().equals("视频合成失败")) {
          break label112;
        }
        s();
      }
      label112:
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
          QQToast.a(this, 2131430302, 1).b(getTitleBarHeight());
          if (this.jdField_b_of_type_AndroidWidgetTextView != null)
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF725A"));
            localObject1 = getResources().getDrawable(2130841179);
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
            break label2220;
          }
          localObject3 = ((String)localObject1).trim();
          int k = ((String)localObject3).length();
          i = k;
          localObject1 = localObject3;
          if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem != null)
          {
            i = k;
            localObject1 = localObject3;
            if (k > this.K.length() + this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_c_of_type_JavaLangString.length() + this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_b_of_type_JavaLangString.length() + this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_a_of_type_JavaLangString.length())
            {
              i = k - this.K.length();
              localObject1 = localObject3;
            }
          }
          if (i < this.jdField_a_of_type_Int)
          {
            QQToast.a(this, getString(2131430304, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }), 0).b(getTitleBarHeight());
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
            {
              TroopBarUtils.a("pub_page", "fail", (String)localObject1, "0", b(), "");
              return;
            }
          }
          if (i > this.jdField_b_of_type_Int)
          {
            QQToast.a(this, getString(2131430305, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }), 0).b(getTitleBarHeight());
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
            QQToast.a(this, 2131430308, 0).b(getTitleBarHeight());
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
            {
              TroopBarUtils.a("pub_page", "fail", (String)localObject1, "35", b(), "");
              return;
            }
          }
          localObject1 = null;
        }
        localObject4 = TroopBarUtils.a(this.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText);
        localObject3 = localObject4;
        if (!TextUtils.isEmpty(this.H))
        {
          localObject3 = localObject4;
          if (((String)localObject4).startsWith(this.H)) {
            localObject3 = ((String)localObject4).substring(this.H.length());
          }
        }
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label2215;
        }
        localObject3 = ((String)localObject3).trim();
        i = ((String)localObject3).length();
        if ((!this.jdField_k_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
        {
          if (i < this.jdField_e_of_type_Int)
          {
            QQToast.a(this, getString(2131430306, new Object[] { Integer.valueOf(this.jdField_e_of_type_Int) }), 0).b(getTitleBarHeight());
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
            {
              TroopBarUtils.a("pub_page", "fail", (String)localObject1, "2", b(), "");
              return;
            }
          }
          if (i > this.jdField_f_of_type_Int)
          {
            QQToast.a(this, getString(2131430307, new Object[] { Integer.valueOf(this.jdField_f_of_type_Int) }), 0).b(getTitleBarHeight());
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
            {
              TroopBarUtils.a("pub_page", "fail", (String)localObject1, "4", b(), "");
              if (this.jdField_d_of_type_Int != 2) {
                break;
              }
              ReportController.b(null, "dc00899", "Grp_talk", "", "pub_talk", "pub_fail", 0, 0, "1", b(), "", "");
              return;
            }
          }
        }
      } while (!a(this.jdField_i_of_type_Int, false));
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_e_of_type_Int == 1) && ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())))
      {
        QQToast.a(this, 2131430328, 0).b(getTitleBarHeight());
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
        for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
        {
          TroopBarUtils.a("pub_page", "fail", (String)localObject1, "9", b(), "");
          return;
        }
      }
      if (!HttpUtil.a(this))
      {
        QQToast.a(this, 2131433086, 0).b(getTitleBarHeight());
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
        for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
        {
          TroopBarUtils.a("pub_page", "fail", (String)localObject1, "7", b(), "");
          if (this.jdField_d_of_type_Int != 2) {
            break;
          }
          ReportController.b(null, "dc00899", "Grp_talk", "", "pub_talk", "pub_fail", 0, 0, "2", b(), "", "");
          return;
        }
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString))) && ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)))
      {
        o();
        TribeUtils.a("pub_page_new", "auto_choose_tribe", 0, 0, new String[] { "" });
        return;
      }
      if (this.jdField_s_of_type_Boolean)
      {
        QQToast.a(this, "视频处理中，请稍候", 0).a();
        ReportController.b(null, "dc00899", "Grp_talk", "", "pub_talk", "pub_fail", 0, 0, "50", b(), "", "");
        return;
      }
      c(true);
      this.rightViewText.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(false);
      i = 0;
      for (;;)
      {
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label1476;
        }
        localObject4 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((TroopBarPublishActivity.Pic_list)TroopBarUtils.a.get(localObject4) == null)
        {
          a(1, this.jdField_a_of_type_AndroidOsHandler);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null) {}
          for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString)
          {
            TroopBarUtils.a("pub_page", "fail", (String)localObject1, "10", b(), "");
            if (this.jdField_d_of_type_Int != 2) {
              break;
            }
            ReportController.b(null, "dc00899", "Grp_talk", "", "pub_talk", "pub_fail", 0, 0, "3", "", b(), "");
            return;
          }
        }
        i += 1;
      }
      label1476:
      if ((this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo != null) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.jdField_d_of_type_JavaLangString)))
      {
        a(this.jdField_u_of_type_JavaLangString, false);
        return;
      }
      if ((!TextUtils.isEmpty(this.I)) && (this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo != null) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.jdField_a_of_type_JavaLangString)))
      {
        b(this.I, false);
        return;
      }
      Object localObject4 = TroopBarPublishUtils.a((String)localObject3, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo, this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo);
      Object localObject3 = new JSONObject();
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(this.jdField_r_of_type_JavaLangString)) {
            break label2031;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
            break label2016;
          }
          l = 0L;
          ((JSONObject)localObject3).put("bid", l);
          ((JSONObject)localObject3).put("post", localObject4);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label2212;
          }
          if (this.jdField_h_of_type_Boolean) {
            break label2225;
          }
          if (TextUtils.equals(this.jdField_b_of_type_JavaLangString, "3")) {
            break label2212;
          }
        }
        catch (Exception localException1)
        {
          QQToast.a(this, 1, 2131430291, 0).b(getTitleBarHeight());
          localException1.printStackTrace();
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem != null)
        {
          if (a(this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem, this.K) == null) {
            break label2233;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.jdField_c_of_type_JavaLangString + a(this.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem, this.K);
        }
        this.v = ((String)localObject1);
        ((JSONObject)localObject3).put("title", localObject1);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
        {
          ((JSONObject)localObject3).put("uid", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_a_of_type_JavaLangString);
          ((JSONObject)localObject3).put("lat", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_b_of_type_Int));
          ((JSONObject)localObject3).put("lon", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_a_of_type_Int));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo == null) {
          break label2241;
        }
        i = 210;
        ((JSONObject)localObject3).put("type", i);
        ((JSONObject)localObject3).put("extparam", this.F);
        ((JSONObject)localObject3).put("version", "7.6.0.3525");
        ((JSONObject)localObject3).put("pfrom", this.jdField_b_of_type_JavaLangString);
        if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
          break label2246;
        }
        i = j;
        ((JSONObject)localObject3).put("pubsource", i);
        if (this.jdField_o_of_type_Int != 1) {
          break label2064;
        }
        ((JSONObject)localObject3).put("pversion", 1);
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          break label2064;
        }
        localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
        localObject4 = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        ((List)localObject1).add(((TroopBarMyBar)((Iterator)localObject4).next()).jdField_c_of_type_JavaLangString);
        continue;
        label2016:
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString);
        continue;
        label2031:
        l = Long.parseLong(this.jdField_r_of_type_JavaLangString);
      }
      ((JSONObject)localObject3).put("bid_list", new JSONArray(localException1).toString());
      label2064:
      if (this.jdField_t_of_type_Int == -1)
      {
        i = 0;
        ((JSONObject)localObject3).put("theme_id", i);
        localObject4 = new NewIntent(super.getApplicationContext(), ProtoServlet.class);
        if (this.jdField_d_of_type_Int != 1) {
          break label2199;
        }
      }
      label2199:
      for (Object localObject2 = "MQUpdateSvc_com_qq_xiaoqu.web.publish_post";; localObject2 = "MQUpdateSvc_com_qq_buluo.web.sbar_publish_post")
      {
        ((NewIntent)localObject4).putExtra("cmd", (String)localObject2);
        localObject2 = new WebSsoBody.WebSsoRequestBody();
        ((WebSsoBody.WebSsoRequestBody)localObject2).type.set(0);
        ((WebSsoBody.WebSsoRequestBody)localObject2).data.set(((JSONObject)localObject3).toString());
        ((NewIntent)localObject4).putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject2).toByteArray());
        ((NewIntent)localObject4).setObserver(new aijv(this));
        this.app.startServlet((NewIntent)localObject4);
        return;
        i = this.jdField_t_of_type_Int;
        break;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        continue;
        label2212:
        continue;
        label2215:
        int i = 0;
        continue;
        label2220:
        i = 0;
        continue;
        label2225:
        String str = "###...^_^###";
        continue;
        label2233:
        str = "###...^_^###";
        continue;
        label2241:
        i = 0;
        continue;
        label2246:
        i = 1;
      }
    }
  }
  
  protected void n()
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
  
  public void o()
  {
    G = a();
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
  
  protected boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo != null)
    {
      DialogUtil.a(this, 230, "编辑未完成", "退出后编辑的内容将不被保存", "退出", "继续编辑", new aijr(this), new aijs(this)).show();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getTag(2131368548) != null)
    {
      o();
      return;
    }
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131366603: 
      n();
      return;
    }
    int i;
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      i = 2;
      if (!TextUtils.isEmpty(this.jdField_r_of_type_JavaLangString)) {
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
      ReportController.b(null, "P_CliOper", "Grp_tribe", "", "pub_page", "Clk_place", i, 0, paramView, str, "", "");
      return;
      i = 1;
      break;
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.jdField_c_of_type_JavaLangString;
      break label91;
    }
  }
  
  protected void p()
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
        this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setHint(this.jdField_d_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.jdField_b_of_type_Int) });
      }
      x();
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
        u();
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
  
  public void q()
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
  
  public void r()
  {
    a(this, "is_first_enter", "true");
  }
  
  public void s()
  {
    DialogUtil.a(this, 230, null, "视频合成失败，是否重新拍摄？", "取消", "确定", new aijm(this), new aijn(this)).show();
  }
  
  public void t()
  {
    TribeVideoPublishParams localTribeVideoPublishParams = (TribeVideoPublishParams)getIntent().getSerializableExtra(TribeVideoPublishParams.BUNDLE_EXTRA_KEY);
    if ("barindex".equals(this.jdField_a_of_type_JavaLangString)) {}
    for (int i = 1;; i = 2)
    {
      if ((localTribeVideoPublishParams.changeFace != null) && (!TextUtils.isEmpty(localTribeVideoPublishParams.changeFace.id))) {
        ReportController.b(this.app, "dc00899", "Grp_tribe", "", "video_shoot", "pub_changeface", i, 0, localTribeVideoPublishParams.changeFace.id, localTribeVideoPublishParams.changeFace.type, "", "");
      }
      if (localTribeVideoPublishParams.filter != null) {
        ReportController.b(this.app, "dc00899", "Grp_tribe", "", "video_shoot", "pub_filter", i, 0, localTribeVideoPublishParams.filter.id, localTribeVideoPublishParams.filter.typeId, "", "");
      }
      if (localTribeVideoPublishParams.beauty > 0) {
        ReportController.b(this.app, "dc00899", "Grp_tribe", "", "video_shoot", "pub_beauty", i, 0, "" + localTribeVideoPublishParams.beauty, "", "", "");
      }
      if (localTribeVideoPublishParams.hasGraffiti) {
        ReportController.b(this.app, "dc00899", "Grp_tribe", "", "video_edit", "pub_graffiti", i, 0, "", "", "", "");
      }
      if (localTribeVideoPublishParams.hasText) {
        ReportController.b(this.app, "dc00899", "Grp_tribe", "", "video_edit", "pub_text", i, 0, "", "", "", "");
      }
      if (localTribeVideoPublishParams.hasFace) {
        ReportController.b(this.app, "dc00899", "Grp_tribe", "", "video_edit", "pub_face", i, 0, "", "", "", "");
      }
      if (localTribeVideoPublishParams.hasPoi) {
        ReportController.b(this.app, "dc00899", "Grp_tribe", "", "video_edit", "pub_poi", i, 0, "", "", "", "");
      }
      if (localTribeVideoPublishParams.music == null) {
        break;
      }
      ReportController.b(this.app, "dc00899", "Grp_tribe", "", "video_edit", "pub_music", i, 0, localTribeVideoPublishParams.music.name, localTribeVideoPublishParams.music.type, "", "");
      return;
    }
    if (localTribeVideoPublishParams.isSoundOn)
    {
      ReportController.b(this.app, "dc00899", "Grp_tribe", "", "video_edit", "sound_on", i, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.app, "dc00899", "Grp_tribe", "", "video_edit", "sound_off", i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity
 * JD-Core Version:    0.7.0.1
 */