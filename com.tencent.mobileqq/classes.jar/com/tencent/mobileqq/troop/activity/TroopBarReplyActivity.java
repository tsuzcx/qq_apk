package com.tencent.mobileqq.troop.activity;

import Override;
import aftp;
import ahvd;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import avmz;
import bezl;
import bezm;
import bezo;
import bezp;
import bezq;
import bezr;
import bezs;
import bezt;
import bezu;
import bezv;
import bezw;
import bezx;
import bffk;
import bghi;
import bgip;
import bgir;
import bhdj;
import bheg;
import bipu;
import bisl;
import bkxz;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.troop.widget.TribeHotPicPanel;
import com.tencent.mobileqq.troop.widget.XEditTextExWithListener;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import nta;
import nwh;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarReplyActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener, avmz, bghi, bipu, EmoticonCallback
{
  public static final String a;
  private static int[] jdField_a_of_type_ArrayOfInt;
  private static final int[] jdField_b_of_type_ArrayOfInt;
  private static final int[] c;
  private static final int[] d;
  private static final int[] e;
  protected int a;
  protected long a;
  private aftp jdField_a_of_type_Aftp;
  protected BroadcastReceiver a;
  public Uri a;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bezs(this);
  protected View a;
  protected ViewGroup a;
  public Button a;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  protected FrameLayout a;
  protected GridView a;
  protected ImageButton a;
  protected ImageView a;
  protected LinearLayout a;
  public bisl a;
  public CommonRecordSoundPanel a;
  public TroopBarPublishUtils.AudioUploadTask a;
  protected TroopBarPublishUtils.PicUploadThread a;
  public AudioInfo a;
  public TroopBarPOI a;
  public PublishItemContainer a;
  protected TribeHotPicPanel a;
  public XEditTextExWithListener a;
  protected InputMethodRelativeLayout a;
  protected Boolean a;
  protected CharSequence a;
  public ArrayList<String> a;
  public boolean a;
  private ImageButton[] jdField_a_of_type_ArrayOfAndroidWidgetImageButton = new ImageButton[4];
  private final int[][] jdField_a_of_type_Array2dOfInt = new int[5][];
  protected int b;
  Handler jdField_b_of_type_AndroidOsHandler = new bezo(this);
  protected View b;
  protected FrameLayout b;
  public ImageButton b;
  private AudioInfo jdField_b_of_type_ComTencentMobileqqTroopDataAudioInfo;
  protected String b;
  protected ArrayList<TroopBarPOI> b;
  public boolean b;
  protected int c;
  protected ImageButton c;
  protected String c;
  protected boolean c;
  protected int d;
  protected ImageButton d;
  protected String d;
  protected boolean d;
  protected int e;
  protected ImageButton e;
  protected String e;
  protected boolean e;
  protected int f;
  protected ImageButton f;
  protected String f;
  protected boolean f;
  private int[] f;
  protected int g;
  protected String g;
  protected boolean g;
  protected int h;
  protected String h;
  protected boolean h;
  protected int i;
  protected String i;
  protected boolean i;
  protected int j;
  protected String j;
  protected boolean j;
  protected int k;
  protected String k;
  public boolean k;
  int jdField_l_of_type_Int = 0;
  protected String l;
  boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int;
  public String m;
  boolean jdField_m_of_type_Boolean;
  public String n;
  boolean n;
  public String o;
  private boolean o;
  protected String p = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = TroopBarReplyActivity.class.getName();
    jdField_a_of_type_ArrayOfInt = new int[] { 2131693644, 2130839218, 2131696998 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2131719438, 2130839197, 2131696985 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2131696983, 2130839219, 2131696984 };
    jdField_d_of_type_ArrayOfInt = new int[] { 2131694193, 2130839212, 2131696995 };
    jdField_e_of_type_ArrayOfInt = new int[] { 2131697001, 2130839191, 2131697000 };
  }
  
  public TroopBarReplyActivity()
  {
    this.jdField_e_of_type_JavaLangString = "https://upload.buluo.qq.com/cgi-bin/bar/upload/image";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 9;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_h_of_type_Boolean = true;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_f_of_type_ArrayOfInt = new int[4];
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bezx(this);
    this.jdField_a_of_type_AndroidOsHandler = new bezm(this);
  }
  
  private void a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getResources();
    this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(8);
    if ((this.jdField_f_of_type_Int & 0x1) == 1)
    {
      this.jdField_a_of_type_Array2dOfInt[0] = jdField_a_of_type_ArrayOfInt;
      this.jdField_a_of_type_Array2dOfInt[1] = jdField_b_of_type_ArrayOfInt;
    }
    for (int i2 = 2;; i2 = 0)
    {
      int i1 = i2;
      if ((this.jdField_f_of_type_Int & 0x2) == 2)
      {
        this.jdField_a_of_type_Array2dOfInt[i2] = jdField_c_of_type_ArrayOfInt;
        i1 = i2 + 1;
      }
      i2 = i1;
      if ((this.jdField_f_of_type_Int & 0x8) == 8)
      {
        this.jdField_a_of_type_Array2dOfInt[i1] = jdField_e_of_type_ArrayOfInt;
        i2 = i1 + 1;
      }
      i1 = i2;
      if ((this.jdField_f_of_type_Int & 0x4) == 4)
      {
        this.jdField_a_of_type_Array2dOfInt[i2] = jdField_d_of_type_ArrayOfInt;
        i1 = i2 + 1;
      }
      if (i1 > 0)
      {
        this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(0);
        i1 = 0;
        if (i1 < this.jdField_a_of_type_Array2dOfInt.length)
        {
          int[] arrayOfInt = this.jdField_a_of_type_Array2dOfInt[i1];
          if (arrayOfInt == null) {}
          for (;;)
          {
            i1 += 1;
            break;
            if (arrayOfInt.length == jdField_a_of_type_ArrayOfInt.length)
            {
              ahvd localahvd = new ahvd();
              localahvd.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(arrayOfInt[1]);
              localahvd.jdField_a_of_type_Int = arrayOfInt[1];
              localahvd.jdField_a_of_type_JavaLangString = paramContext.getString(arrayOfInt[0]);
              localahvd.jdField_b_of_type_JavaLangString = paramContext.getString(arrayOfInt[2]);
              localahvd.jdField_a_of_type_Boolean = false;
              localArrayList.add(localahvd);
            }
          }
        }
        this.jdField_a_of_type_Aftp.a(localArrayList);
        this.jdField_a_of_type_Aftp.notifyDataSetChanged();
      }
      return;
    }
  }
  
  private void a(ImageButton paramImageButton, int paramInt)
  {
    if (paramImageButton != null)
    {
      paramImageButton.setSelected(false);
      paramImageButton.setImageResource(paramInt);
    }
  }
  
  private void a(ImageButton paramImageButton, boolean paramBoolean)
  {
    if (paramImageButton != null)
    {
      paramImageButton.setSelected(true);
      paramImageButton.setImageResource(2130847908);
    }
    if (paramBoolean)
    {
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton.length)
      {
        if ((this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton[i1] != null) && (this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton[i1] != paramImageButton)) {
          a(this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton[i1], this.jdField_f_of_type_ArrayOfInt[i1]);
        }
        i1 += 1;
      }
    }
  }
  
  private void a(String paramString)
  {
    WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = null;
    paramString = TroopBarPublishUtils.a(paramString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo, null);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("bid", Long.parseLong(this.jdField_o_of_type_JavaLangString));
      localJSONObject.put("post", paramString);
      paramString = localWebSsoRequestBody;
      if (android.text.TextUtils.isEmpty(null)) {
        paramString = "###...^_^###";
      }
      localJSONObject.put("title", paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
      {
        localJSONObject.put("uid", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_a_of_type_JavaLangString);
        localJSONObject.put("lat", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_b_of_type_Int));
        localJSONObject.put("lon", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_a_of_type_Int));
      }
      localJSONObject.put("type", 0);
      localJSONObject.put("extparam", this.jdField_d_of_type_JavaLangString);
      localJSONObject.put("version", "8.4.10.4875");
      localJSONObject.put("pubsource", 1);
      localJSONObject.put("theme_id", 0);
      paramString = new NewIntent(super.getApplicationContext(), nta.class);
      paramString.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.publish_post");
      localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
      localWebSsoRequestBody.type.set(0);
      localWebSsoRequestBody.data.set(localJSONObject.toString());
      paramString.putExtra("data", localWebSsoRequestBody.toByteArray());
      paramString.setObserver(new bezl(this));
      this.app.startServlet(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QQToast.a(this, 1, 2131696005, 0).b(getTitleBarHeight());
      paramString.printStackTrace();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void b(String paramString)
  {
    boolean bool;
    JSONObject localJSONObject;
    if (this.jdField_a_of_type_AndroidWidgetCheckBox != null)
    {
      bool = this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked();
      paramString = TroopBarPublishUtils.a(paramString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("pid", this.jdField_b_of_type_JavaLangString);
        localJSONObject.put("bid", Long.parseLong(this.jdField_o_of_type_JavaLangString));
        localJSONObject.put("comment", paramString);
        if (bool) {
          localJSONObject.put("is_forward", 1);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
        {
          localJSONObject.put("uid", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_a_of_type_JavaLangString);
          localJSONObject.put("lat", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_b_of_type_Int));
          localJSONObject.put("lon", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_a_of_type_Int));
        }
        localJSONObject.put("extparam", this.jdField_d_of_type_JavaLangString);
        localJSONObject.put("version", "8.4.10.4875");
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), nta.class);
        if (bool) {
          bgip.a(this.jdField_m_of_type_JavaLangString, "reply_page_new", "share_interest", this.jdField_o_of_type_JavaLangString, "", "", "");
        }
        if (this.jdField_i_of_type_Int != 1) {
          break label336;
        }
        paramString = "MQUpdateSvc_com_qq_xiaoqu.web.comment";
        localNewIntent.putExtra("cmd", paramString);
        paramString = new WebSsoBody.WebSsoRequestBody();
        paramString.type.set(0);
        paramString.data.set(localJSONObject.toString());
        localNewIntent.putExtra("data", paramString.toByteArray());
        localNewIntent.setObserver(new bezu(this));
        this.app.startServlet(localNewIntent);
        return;
      }
      catch (Exception paramString)
      {
        QQToast.a(this, 1, 2131696005, 0).b(getTitleBarHeight());
        a(false);
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      bool = false;
      break;
      label336:
      paramString = "MQUpdateSvc_com_qq_buluo.web.sbar_comment";
    }
  }
  
  private void b(boolean paramBoolean)
  {
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.4F);
    localAlphaAnimation1.setDuration(0L);
    localAlphaAnimation1.setFillAfter(true);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.4F, 1.0F);
    localAlphaAnimation2.setDuration(0L);
    localAlphaAnimation2.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(paramBoolean);
    if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
      this.jdField_b_of_type_AndroidWidgetImageButton.setEnabled(paramBoolean);
    }
    this.jdField_c_of_type_AndroidWidgetImageButton.setEnabled(paramBoolean);
    if (this.jdField_d_of_type_AndroidWidgetImageButton != null) {
      this.jdField_d_of_type_AndroidWidgetImageButton.setEnabled(paramBoolean);
    }
    if (this.jdField_f_of_type_AndroidWidgetImageButton != null) {
      this.jdField_f_of_type_AndroidWidgetImageButton.setEnabled(paramBoolean);
    }
    if (this.jdField_e_of_type_AndroidWidgetImageButton != null) {
      this.jdField_e_of_type_AndroidWidgetImageButton.setEnabled(paramBoolean);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(paramBoolean);
    findViewById(2131379357).setEnabled(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation2);
      if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
        this.jdField_b_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation2);
      }
      this.jdField_c_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation2);
      this.jdField_a_of_type_AndroidWidgetButton.startAnimation(localAlphaAnimation2);
      if (this.jdField_d_of_type_AndroidWidgetImageButton != null) {
        this.jdField_d_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation2);
      }
      if (this.jdField_f_of_type_AndroidWidgetImageButton != null) {
        this.jdField_f_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation2);
      }
      if (this.jdField_e_of_type_AndroidWidgetImageButton != null) {
        this.jdField_e_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation2);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.startAnimation(localAlphaAnimation2);
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation2);
      c(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation1);
    if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
      this.jdField_b_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation1);
    }
    this.jdField_c_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation1);
    if (this.jdField_d_of_type_AndroidWidgetImageButton != null) {
      this.jdField_d_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation1);
    }
    if (this.jdField_f_of_type_AndroidWidgetImageButton != null) {
      this.jdField_f_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation1);
    }
    if (this.jdField_e_of_type_AndroidWidgetImageButton != null) {
      this.jdField_e_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation1);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.startAnimation(localAlphaAnimation1);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation1);
    c(true);
    this.jdField_a_of_type_AndroidWidgetButton.startAnimation(localAlphaAnimation1);
  }
  
  private boolean b()
  {
    return this.jdField_l_of_type_Boolean;
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130838048);
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      i();
      j();
    }
    for (;;)
    {
      c(true);
      return;
      bkxz.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      i();
      a(this.jdField_a_of_type_AndroidWidgetImageButton, true);
      continue;
      bkxz.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      i();
      a(this.jdField_c_of_type_AndroidWidgetImageButton, true);
      continue;
      bkxz.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      i();
      a(this.jdField_d_of_type_AndroidWidgetImageButton, true);
      continue;
      bkxz.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      h();
      a(this.jdField_b_of_type_AndroidWidgetImageButton, true);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(2130706432);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130850739);
  }
  
  private void j()
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton.length)
    {
      if (this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton[i1] != null) {
        a(this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton[i1], this.jdField_f_of_type_ArrayOfInt[i1]);
      }
      i1 += 1;
    }
  }
  
  private void k()
  {
    a(this.jdField_d_of_type_AndroidWidgetImageButton, this.jdField_f_of_type_ArrayOfInt[2]);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  private void l()
  {
    if (this.jdField_k_of_type_Boolean) {
      bgip.a(this.jdField_m_of_type_JavaLangString, this.jdField_n_of_type_JavaLangString, "Clk_photo", this.jdField_o_of_type_JavaLangString, "", "", "");
    }
    if (a(1)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a() != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a() != 1))
    {
      a(1);
      return;
    }
    e();
  }
  
  private void m()
  {
    if (this.jdField_k_of_type_Boolean) {
      bgip.a(this.jdField_m_of_type_JavaLangString, this.jdField_n_of_type_JavaLangString, "Clk_shoot", this.jdField_o_of_type_JavaLangString, "", "", "");
    }
    if (a(1)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a() != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a() != 1))
    {
      a(0);
      return;
    }
    f();
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a() != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a() != 1))
    {
      a(6);
      return;
    }
    if (this.jdField_b_of_type_AndroidWidgetImageButton.isSelected())
    {
      i();
      bkxz.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
      return;
    }
    a(this.jdField_b_of_type_AndroidWidgetImageButton, true);
    bkxz.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopBarReplyActivity.14(this), 200L);
  }
  
  private void o()
  {
    if (this.jdField_k_of_type_Boolean)
    {
      bgip.a(this.jdField_m_of_type_JavaLangString, this.jdField_n_of_type_JavaLangString, "Clk_record", this.jdField_o_of_type_JavaLangString, "", "", "");
      bgip.b("reply_page_new", "Clk_record", this.jdField_o_of_type_JavaLangString, "", "", "");
    }
    if (a(2)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a() != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a() != 2))
    {
      a(2);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a() == 2)
    {
      a(5);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission("android.permission.RECORD_AUDIO") != 0))
    {
      requestPermissions(new bezr(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
      return;
    }
    a(this.jdField_d_of_type_AndroidWidgetImageButton, true);
    c(4);
  }
  
  public void a()
  {
    Object localObject;
    if ((this.jdField_m_of_type_Int == 101000) || (this.jdField_i_of_type_Boolean) || (this.jdField_j_of_type_Boolean))
    {
      str = bgip.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener).replace("\n", " ");
      this.jdField_b_of_type_Boolean = true;
      localObject = new Intent();
      ((Intent)localObject).putExtra("result", "\"" + str + "\"");
      setResult(-1, (Intent)localObject);
      finish();
    }
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((this.jdField_i_of_type_Int == 2) && (this.jdField_k_of_type_Boolean)) {
      bgip.a("Grp_talk", "pub_reco", "Clk_reco", this.jdField_l_of_type_JavaLangString, "", "", "");
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$AudioUploadTask != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$AudioUploadTask.a() != 0))
    {
      a(true);
      return;
    }
    String str = bgip.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
    if (!android.text.TextUtils.isEmpty(str)) {
      str = str.trim();
    }
    for (int i1 = str.length();; i1 = 0)
    {
      if ((!this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        if (i1 == 0)
        {
          QQToast.a(this, 2131696002, 0).b(getTitleBarHeight());
          if (this.jdField_k_of_type_Boolean) {
            bgip.a("reply_page", "fail", this.jdField_o_of_type_JavaLangString, "2", "", "");
          }
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        if (i1 < this.jdField_b_of_type_Int)
        {
          QQToast.a(this, getString(2131696000, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }), 0).b(getTitleBarHeight());
          if (this.jdField_k_of_type_Boolean) {
            bgip.a("reply_page", "fail", this.jdField_o_of_type_JavaLangString, "2", "", "");
          }
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        if (i1 > this.jdField_c_of_type_Int)
        {
          QQToast.a(this, getString(2131696001, new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) }), 0).b(getTitleBarHeight());
          if (this.jdField_k_of_type_Boolean) {
            bgip.a("reply_page", "fail", this.jdField_o_of_type_JavaLangString, "4", "", "");
          }
          this.jdField_a_of_type_Boolean = false;
          return;
        }
      }
      if (!a(this.jdField_f_of_type_Int, this.jdField_g_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      if (!HttpUtil.isConnect(this))
      {
        QQToast.a(this, 2131694226, 0).b(getTitleBarHeight());
        if (this.jdField_k_of_type_Boolean) {
          bgip.a("reply_page", "fail", this.jdField_o_of_type_JavaLangString, "7", "", "");
        }
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      a(true);
      i1 = 0;
      for (;;)
      {
        if (i1 >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label606;
        }
        localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if ((TroopBarPublishActivity.Pic_list)bgip.a.get(localObject) == null)
        {
          this.jdField_a_of_type_Boolean = false;
          a(this, 1, this.jdField_a_of_type_AndroidOsHandler);
          if (!this.jdField_k_of_type_Boolean) {
            break;
          }
          bgip.a("reply_page", "fail", this.jdField_o_of_type_JavaLangString, "10", "", "");
          return;
        }
        i1 += 1;
      }
      label606:
      if ((b()) && (!this.jdField_m_of_type_Boolean))
      {
        a(str);
        return;
      }
      b(str);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool = true;
    QQCustomDialog localQQCustomDialog = bhdj.a(this, 230);
    localQQCustomDialog.setTitle(2131696992);
    Object localObject = new bezp(this, paramInt);
    localQQCustomDialog.setNegativeButton(getString(2131696990), (DialogInterface.OnClickListener)localObject);
    String str;
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      str = getString(2131696996, new Object[] { getString(2131696983) });
      localQQCustomDialog.setMessage(str);
      localQQCustomDialog.setPositiveButton(getString(2131696986), (DialogInterface.OnClickListener)localObject);
    }
    for (;;)
    {
      localQQCustomDialog.setMessage(str);
      localQQCustomDialog.show();
      return;
      str = getString(2131696996, new Object[] { getString(2131696994) });
      localQQCustomDialog.setPositiveButton(getString(2131696987), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131696996, new Object[] { getString(2131696997) });
      localQQCustomDialog.setPositiveButton(getString(2131696988), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131696996, new Object[] { getString(2131696997) });
      localQQCustomDialog.setPositiveButton(getString(2131696988), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131696996, new Object[] { getString(2131696997) });
      localQQCustomDialog.setPositiveButton(getString(2131696988), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131696004, new Object[] { Integer.valueOf(9) });
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() < 9) {}
      for (;;)
      {
        ((PublishItemContainer)localObject).a(bool);
        break;
        bool = false;
      }
      str = getString(2131696999);
      localQQCustomDialog.setPositiveButton(getString(2131696991), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131696996, new Object[] { getString(2131697001) });
      localQQCustomDialog.setPositiveButton(getString(2131696989), (DialogInterface.OnClickListener)localObject);
    }
  }
  
  public void a(int paramInt, bffk parambffk)
  {
    if (parambffk == null) {
      return;
    }
    if ((parambffk instanceof AudioInfo)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = ((AudioInfo)parambffk);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a(paramInt, parambffk);
    c(0);
    bkxz.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
  }
  
  protected void a(int paramInt, String... paramVarArgs)
  {
    boolean bool = false;
    Object localObject = "";
    switch (paramInt)
    {
    default: 
      paramVarArgs = (String[])localObject;
      label39:
      this.jdField_a_of_type_AndroidWidgetImageView.setSelected(bool);
      if (!bool) {
        break;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramVarArgs);
      return;
      paramVarArgs = getString(2131717182);
      break label39;
      String str = getString(2131717183);
      localObject = str;
      if (paramVarArgs == null) {
        break;
      }
      localObject = str;
      if (paramVarArgs.length <= 0) {
        break;
      }
      QQToast.a(this, paramVarArgs[0], 1).b(getTitleBarHeight());
      paramVarArgs = str;
      break label39;
      paramVarArgs = getString(2131717184);
      break label39;
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!android.text.TextUtils.isEmpty(paramVarArgs[0])))
      {
        if (android.text.TextUtils.isEmpty(paramVarArgs[0]))
        {
          a(3, new String[0]);
          return;
        }
        paramVarArgs = paramVarArgs[0];
        bool = true;
        break label39;
      }
      a(0, new String[0]);
      return;
      paramVarArgs = getString(2131695984);
    }
  }
  
  protected void a(BaseActivity paramBaseActivity, int paramInt, Handler paramHandler)
  {
    paramBaseActivity.runOnUiThread(new TroopBarReplyActivity.17(this));
    if (((TicketManager)paramBaseActivity.app.getManager(2)).getSkey(paramBaseActivity.app.getCurrentAccountUin()) != null) {
      switch (paramInt)
      {
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      ThreadManager.post(new TroopBarPublishUtils.PicUploadThread(paramBaseActivity, paramHandler, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_e_of_type_JavaLangString), 8, null, true);
      return;
    }
    QLog.w("IphoneTitleBarActivity", 2, "startUploadImage skey is null!!!!!!!!!!!!!!!");
  }
  
  protected void a(BaseActivity paramBaseActivity, bghi parambghi)
  {
    SosoInterface.startLocation(new bezt(this, 0, true, true, this.jdField_l_of_type_Int, false, false, "AbsPublish", paramBaseActivity, parambghi));
    a(2, new String[0]);
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaLangCharSequence = BaseApplication.getContext().getResources().getText(2131717561);
    nwh.a((String)null, 0);
    if (this.jdField_g_of_type_Int != 0) {
      g();
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("key_photo_delete_action");
    localIntentFilter.addAction("key_audio_delete_action");
    localIntentFilter.addAction("key_photo_add_action");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_o_of_type_JavaLangString = paramJSONObject.optString("bid", "");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("pid", "");
    this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("cid", "");
    if (android.text.TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
    for (this.jdField_j_of_type_JavaLangString = (this.app.getCurrentAccountUin() + "-" + this.jdField_o_of_type_JavaLangString + "-" + this.jdField_b_of_type_JavaLangString);; this.jdField_j_of_type_JavaLangString = (this.app.getCurrentAccountUin() + "-" + this.jdField_o_of_type_JavaLangString + "-" + this.jdField_b_of_type_JavaLangString + "-" + this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_d_of_type_JavaLangString = paramJSONObject.optString("extparam");
      this.jdField_m_of_type_JavaLangString = "Grp_tribe";
      this.jdField_n_of_type_JavaLangString = "reply_page";
      return;
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (isFinishing()) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("poilist");
        if (this.jdField_b_of_type_JavaUtilArrayList == null)
        {
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
          break label226;
          if (paramInt < paramJSONObject.length())
          {
            this.jdField_b_of_type_JavaUtilArrayList.add(new TroopBarPOI(paramJSONObject.getJSONObject(paramInt)));
            paramInt += 1;
            continue;
          }
        }
        else
        {
          this.jdField_b_of_type_JavaUtilArrayList.clear();
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopBar", 2, paramJSONObject.toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
        {
          if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString))
          {
            paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_d_of_type_JavaLangString;
            a(1, new String[] { paramJSONObject });
            return;
            if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)this.jdField_b_of_type_JavaUtilArrayList.get(0));
            continue;
          }
          paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString;
          continue;
        }
        a(0, new String[0]);
        return;
      }
      a(3, new String[0]);
      return;
      label226:
      paramInt = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Bisl == null) {
        this.jdField_a_of_type_Bisl = new bisl(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_Bisl.c(2131695998);
      this.jdField_a_of_type_Bisl.show();
    }
    while ((this.jdField_a_of_type_Bisl == null) || (!this.jdField_a_of_type_Bisl.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Bisl.dismiss();
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      c(0);
      j();
    }
  }
  
  protected boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "repky restore key = " + this.jdField_j_of_type_JavaLangString);
    }
    if (android.text.TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {
      return false;
    }
    bgir localbgir = (bgir)bgip.b.get(this.jdField_j_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "reply restore key = " + this.jdField_j_of_type_JavaLangString + ", replyData = " + localbgir);
    }
    bgip.b.clear();
    if (localbgir == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
      this.jdField_a_of_type_JavaUtilArrayList = localbgir.jdField_a_of_type_JavaUtilArrayList;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = localbgir.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI;
    this.jdField_b_of_type_JavaUtilArrayList = localbgir.jdField_b_of_type_JavaUtilArrayList;
    this.jdField_b_of_type_Int = localbgir.jdField_c_of_type_Int;
    this.jdField_c_of_type_Int = localbgir.jdField_d_of_type_Int;
    this.jdField_h_of_type_JavaLangString = localbgir.jdField_b_of_type_JavaLangString;
    this.jdField_i_of_type_JavaLangString = localbgir.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = localbgir.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo;
    return true;
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = null;
    if ((this.jdField_h_of_type_Int & paramInt) == paramInt)
    {
      switch (paramInt)
      {
      }
      while (localObject != null)
      {
        QQToast.a(this, (CharSequence)localObject, 0).b(getTitleBarHeight());
        return true;
        localObject = getString(2131697003, new Object[] { this.jdField_k_of_type_JavaLangString });
        continue;
        localObject = getString(2131697002, new Object[] { this.jdField_k_of_type_JavaLangString });
      }
    }
    return false;
  }
  
  protected boolean a(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      return true;
      Object localObject2 = null;
      Object localObject1;
      if (((paramInt & 0x1) == 1) && (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
        localObject1 = getString(2131696982, new Object[] { getString(2131696997) });
      }
      while (localObject1 != null)
      {
        QQToast.a(this, (CharSequence)localObject1, 0).b(getTitleBarHeight());
        return false;
        localObject1 = localObject2;
        if ((paramInt & 0x2) == 2)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo == null) {
            localObject1 = getString(2131696982, new Object[] { getString(2131696983) });
          }
        }
      }
    }
  }
  
  protected boolean a(Handler paramHandler, String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      QQToast.a(this, getString(2131696979), 1).b(getTitleBarHeight());
    }
    while (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 9)
    {
      QQToast.a(this, getString(2131694038, new Object[] { Integer.valueOf(9) }), 1).b(getTitleBarHeight());
      return false;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    Message localMessage = paramHandler.obtainMessage(1005);
    localMessage.obj = paramString;
    paramHandler.sendMessage(localMessage);
    return true;
  }
  
  protected boolean a(Handler paramHandler, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 9))
    {
      QQToast.a(this, getString(2131694038, new Object[] { Integer.valueOf(9) }), 1).b(getTitleBarHeight());
      return false;
    }
    if (paramArrayList != this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if (paramArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      }
    }
    for (;;)
    {
      paramHandler.sendMessage(paramHandler.obtainMessage(1005));
      return true;
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    }
  }
  
  public boolean a(View paramView, String paramString, HotPicData paramHotPicData)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      QLog.e("IphoneTitleBarActivity", 2, "filePath is null");
    }
    do
    {
      return true;
      bheg.a(this, paramString);
      a(this.jdField_a_of_type_AndroidOsHandler, paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.jdField_a_of_type_Boolean = true;
      }
    } while (!this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = new TroopBarPublishUtils.PicUploadThread(this, null, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_e_of_type_JavaLangString);
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread, 8, null, true);
    return true;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i2 = 0;
    this.jdField_j_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.getSelectionStart();
    this.jdField_k_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.getSelectionEnd();
    String str = bgip.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
    int i1;
    if (str == null)
    {
      i1 = 0;
      if ((this.jdField_c_of_type_Int <= 0) || (i1 <= this.jdField_c_of_type_Int)) {
        break label157;
      }
      i1 -= this.jdField_c_of_type_Int;
      paramEditable.delete(this.jdField_j_of_type_Int - i1, this.jdField_k_of_type_Int);
      this.jdField_j_of_type_Int -= i1;
      this.jdField_k_of_type_Int -= i1;
      if (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
        break label170;
      }
      QQToast.a(this, this.p, 0).b(getTitleBarHeight());
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    }
    label157:
    label170:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.setSelection(i1 + this.jdField_j_of_type_Int);
      return;
      i1 = str.length();
      break;
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      i1 = i2;
    }
  }
  
  protected void b()
  {
    int i2 = 0;
    for (;;)
    {
      try
      {
        if (b())
        {
          setContentView(2131559971);
          this.jdField_f_of_type_Int = 0;
          Object localObject = findViewById(2131376760);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131376957));
          this.jdField_b_of_type_AndroidViewView = findViewById(2131379357);
          this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131368638));
          this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131368639));
          this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131372972));
          this.jdField_d_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131363835));
          this.jdField_e_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131363843));
          this.jdField_f_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131368640));
          if ((!this.jdField_n_of_type_Boolean) && (this.jdField_d_of_type_AndroidWidgetImageButton != null)) {
            this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
          }
          this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton[0] = this.jdField_a_of_type_AndroidWidgetImageButton;
          this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton[1] = this.jdField_b_of_type_AndroidWidgetImageButton;
          this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton[2] = this.jdField_d_of_type_AndroidWidgetImageButton;
          this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton[3] = this.jdField_c_of_type_AndroidWidgetImageButton;
          this.jdField_f_of_type_ArrayOfInt[0] = 2130843748;
          this.jdField_f_of_type_ArrayOfInt[1] = 2130842563;
          this.jdField_f_of_type_ArrayOfInt[2] = 2130842555;
          this.jdField_f_of_type_ArrayOfInt[3] = 2130843751;
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368714));
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener = ((XEditTextExWithListener)findViewById(2131366265));
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.setOnKeyPreImeListener(new bezw(this));
          this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131377349));
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer = ((PublishItemContainer)findViewById(2131376541));
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setMaxPicNum(9);
          this.jdField_a_of_type_AndroidViewView = findViewById(2131368613);
          this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131369836));
          this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131369861));
          this.jdField_a_of_type_AndroidViewViewGroup = TroopBarPublishUtils.a(this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener, this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
          findViewById(2131379357).setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131372973));
          this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
          this.jdField_a_of_type_Aftp = new aftp();
          this.jdField_a_of_type_Aftp.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Aftp);
          a(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363050));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)LayoutInflater.from(this).inflate(2131559902, null));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.app, this, this.jdField_b_of_type_AndroidOsHandler, 1);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setPadding(0, DisplayUtil.dip2px(this, 20.0F), 0, DisplayUtil.dip2px(this, 25.0F));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setTimeOutTime(this.jdField_e_of_type_Int);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel);
          this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
          if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
            this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
          this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
          if (b())
          {
            this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
            this.jdField_f_of_type_AndroidWidgetImageButton.setOnClickListener(this);
            this.jdField_e_of_type_AndroidWidgetImageButton.setOnClickListener(this);
          }
          this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
          this.jdField_a_of_type_AndroidWidgetButton.setPressed(false);
          this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.addTextChangedListener(this);
          if ((android.text.TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) || (this.jdField_b_of_type_Int <= 0) || (this.jdField_c_of_type_Int <= 0))
          {
            this.jdField_b_of_type_Int = 3;
            this.jdField_c_of_type_Int = 700;
            this.jdField_h_of_type_JavaLangString = getString(2131695976, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) });
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.setHint(this.jdField_h_of_type_JavaLangString);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.getText().length() <= 0)
          {
            XEditTextExWithListener localXEditTextExWithListener = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener;
            if (android.text.TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
              break label1101;
            }
            localObject = this.jdField_i_of_type_JavaLangString;
            localXEditTextExWithListener.setText((CharSequence)localObject);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
            break label1117;
          }
          if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString)) {
            break label1106;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_d_of_type_JavaLangString;
          a(1, new String[] { localObject });
          a(this, this);
          localObject = this.jdField_a_of_type_AndroidWidgetImageView;
          if (!this.jdField_d_of_type_Boolean) {
            break label1129;
          }
          i1 = 0;
          ((ImageView)localObject).setVisibility(i1);
          localObject = this.jdField_a_of_type_AndroidWidgetImageButton;
          if (!this.jdField_e_of_type_Boolean) {
            break label1135;
          }
          i1 = 0;
          ((ImageButton)localObject).setVisibility(i1);
          if (this.jdField_b_of_type_AndroidWidgetImageButton != null)
          {
            localObject = this.jdField_b_of_type_AndroidWidgetImageButton;
            if (!this.jdField_e_of_type_Boolean) {
              break label1141;
            }
            i1 = i2;
            ((ImageButton)localObject).setVisibility(i1);
          }
          if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
            break label1147;
          }
          a(this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_JavaUtilArrayList);
          if (!this.jdField_h_of_type_Boolean) {
            this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(8);
          }
          localObject = new StringBuffer();
          if ((this.jdField_f_of_type_Int & 0x1) == 1) {
            ((StringBuffer)localObject).append("0");
          }
          if ((this.jdField_f_of_type_Int & 0x2) == 2) {
            ((StringBuffer)localObject).append("1");
          }
          if (this.jdField_k_of_type_Boolean)
          {
            bgip.a("reply_page", "choose_place", this.jdField_o_of_type_JavaLangString, "0", ((StringBuffer)localObject).toString(), "");
            bgip.a("reply_page", "exp", String.valueOf(this.jdField_o_of_type_JavaLangString), "", "", "");
          }
          return;
        }
        if (this.jdField_o_of_type_Boolean)
        {
          setContentView(2131559970);
          this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131376536));
          ViewUtils.fixCheckBoxLeftPaddingBelow17(this.jdField_a_of_type_AndroidWidgetCheckBox, DisplayUtil.dip2px(this, 18.0F));
          continue;
        }
        setContentView(2131559969);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        finish();
        return;
      }
      continue;
      label1101:
      String str = null;
      continue;
      label1106:
      str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString;
      continue;
      label1117:
      a(0, new String[0]);
      continue;
      label1129:
      int i1 = 8;
      continue;
      label1135:
      i1 = 8;
      continue;
      label1141:
      i1 = 8;
      continue;
      label1147:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {
        a(2, this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
      }
    }
  }
  
  public void b(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("bid", this.jdField_o_of_type_JavaLangString);
    localBundle.putString("pid", this.jdField_b_of_type_JavaLangString);
    localBundle.putString("from", "qqbuluo");
    localBundle.putString("uin", this.app.getCurrentAccountUin());
    localBundle.putString("content", bgip.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener).trim());
    String str;
    if (paramInt == 3) {
      str = "video";
    }
    for (;;)
    {
      localBundle.putString("clicktype", str);
      try
      {
        localBundle.putString("floor", new JSONObject(this.jdField_d_of_type_JavaLangString).getString("floor"));
        label112:
        TroopBarPublishUtils.a(this, 2, paramInt, localBundle);
        return;
        str = "music";
      }
      catch (Exception localException)
      {
        break label112;
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopBarReplyActivity.4(this), 200L);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopBarReplyActivity.5(this), 500L);
  }
  
  protected void d()
  {
    int i2 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "reply save key = " + this.jdField_j_of_type_JavaLangString);
    }
    if (android.text.TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {}
    for (;;)
    {
      return;
      bgir localbgir = new bgir();
      ArrayList localArrayList;
      int i1;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localArrayList = new ArrayList();
        i1 = 0;
        while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i1));
          i1 += 1;
        }
        localbgir.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
      {
        localbgir.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = new TroopBarPOI(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        if (this.jdField_b_of_type_JavaUtilArrayList != null)
        {
          localArrayList = new ArrayList();
          i1 = i2;
          while (i1 < this.jdField_b_of_type_JavaUtilArrayList.size())
          {
            localArrayList.add(new TroopBarPOI((TroopBarPOI)this.jdField_b_of_type_JavaUtilArrayList.get(i1)));
            i1 += 1;
          }
          localbgir.jdField_b_of_type_JavaUtilArrayList = localArrayList;
        }
      }
      localbgir.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      localbgir.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
      localbgir.jdField_b_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
      localbgir.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.getEditableText().toString();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {}
      try
      {
        localbgir.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = ((AudioInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.clone());
        bgip.b.put(this.jdField_j_of_type_JavaLangString, localbgir);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopBar", 2, "reply save key = " + this.jdField_j_of_type_JavaLangString + ", data = " + localbgir);
        return;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("IphoneTitleBarActivity", 2, QLog.getStackTraceString(localCloneNotSupportedException));
          }
        }
      }
    }
  }
  
  public void delete()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener != null) {
      com.tencent.mobileqq.text.TextUtils.backspace(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
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
    j();
    if (paramInt2 == 0) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramInt1)
          {
          default: 
            return;
          }
        } while (this.jdField_a_of_type_AndroidNetUri == null);
        paramIntent = bheg.b(this, this.jdField_a_of_type_AndroidNetUri);
        bheg.a(this, paramIntent);
        a(this.jdField_a_of_type_AndroidOsHandler, paramIntent);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = new TroopBarPublishUtils.PicUploadThread(this, null, this.jdField_a_of_type_JavaUtilArrayList, "https://upload.buluo.qq.com/cgi-bin/bar/upload/image");
        ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread, 8, null, true);
      } while (!this.jdField_k_of_type_Boolean);
      bgip.a("reply_page", "choose_place", this.jdField_o_of_type_JavaLangString, "2", "", "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramIntent.getParcelableExtra("key_selected_poi"));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
      {
        if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString)) {}
        for (paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_d_of_type_JavaLangString;; paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString)
        {
          a(1, new String[] { paramIntent });
          return;
        }
      }
      a(0, new String[0]);
      return;
      a(2, (AudioInfo)paramIntent.getSerializableExtra("audio_info"));
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$AudioUploadTask = new TroopBarPublishUtils.AudioUploadTask(this, this.jdField_a_of_type_AndroidOsHandler, "https://upload.buluo.qq.com/cgi-bin/bar/upload/meida", this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$AudioUploadTask, 5, null, true);
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBackEvent() is called,isRecording is:" + bool);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
  }
  
  /* Error */
  public boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield 1391	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:mNeedStatusTrans	Z
    //   5: aload_0
    //   6: iconst_0
    //   7: putfield 1394	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:mActNeedImmersive	Z
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 1396	com/tencent/mobileqq/app/IphoneTitleBarActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   15: pop
    //   16: aload_0
    //   17: invokevirtual 1400	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:getIntent	()Landroid/content/Intent;
    //   20: invokevirtual 1404	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnonnull +43 -> 68
    //   28: aload_0
    //   29: iconst_1
    //   30: aload_0
    //   31: ldc_w 1405
    //   34: iconst_1
    //   35: anewarray 715	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: sipush 990
    //   43: invokestatic 720	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: aastore
    //   47: invokevirtual 723	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   50: iconst_0
    //   51: invokestatic 1408	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   54: aload_0
    //   55: invokevirtual 406	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:getTitleBarHeight	()I
    //   58: invokevirtual 409	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   61: pop
    //   62: aload_0
    //   63: invokevirtual 671	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:finish	()V
    //   66: iconst_0
    //   67: ireturn
    //   68: aload_0
    //   69: aload_1
    //   70: ldc_w 1410
    //   73: iconst_0
    //   74: invokevirtual 1414	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   77: putfield 630	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_m_of_type_Int	I
    //   80: aload_1
    //   81: ldc_w 1416
    //   84: invokevirtual 1417	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   87: astore_1
    //   88: invokestatic 874	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +30 -> 121
    //   94: ldc_w 876
    //   97: iconst_2
    //   98: new 655	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 656	java/lang/StringBuilder:<init>	()V
    //   105: ldc_w 1419
    //   108: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_1
    //   112: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 663	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 978	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: new 265	org/json/JSONObject
    //   124: dup
    //   125: aload_1
    //   126: invokespecial 1278	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   129: astore_1
    //   130: aload_0
    //   131: aload_1
    //   132: ldc_w 1421
    //   135: invokevirtual 948	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   138: ldc_w 1423
    //   141: invokevirtual 1426	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   144: putfield 515	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_l_of_type_Boolean	Z
    //   147: aload_0
    //   148: aload_1
    //   149: ldc_w 1428
    //   152: invokevirtual 1432	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   155: putfield 771	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_m_of_type_Boolean	Z
    //   158: aload_0
    //   159: aload_1
    //   160: ldc_w 1434
    //   163: iconst_1
    //   164: invokevirtual 1437	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   167: putfield 1115	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_n_of_type_Boolean	Z
    //   170: aload_0
    //   171: aload_1
    //   172: ldc_w 1439
    //   175: invokevirtual 948	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   178: putfield 1441	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   181: aload_0
    //   182: aload_1
    //   183: ldc_w 1443
    //   186: invokevirtual 948	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   189: putfield 1445	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   192: aload_0
    //   193: aload_1
    //   194: ldc_w 1447
    //   197: iconst_3
    //   198: invokevirtual 1450	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   201: putfield 712	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_b_of_type_Int	I
    //   204: aload_0
    //   205: aload_1
    //   206: ldc_w 1452
    //   209: sipush 700
    //   212: invokevirtual 1450	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   215: putfield 728	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_c_of_type_Int	I
    //   218: aload_0
    //   219: aload_1
    //   220: ldc_w 1454
    //   223: aload_0
    //   224: getfield 1024	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   227: invokevirtual 938	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   230: putfield 1024	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   233: aload_0
    //   234: aload_1
    //   235: ldc_w 1456
    //   238: invokevirtual 1432	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   241: putfield 697	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_f_of_type_Boolean	Z
    //   244: aload_0
    //   245: aload_1
    //   246: ldc_w 1458
    //   249: iconst_1
    //   250: invokevirtual 1437	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   253: putfield 125	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_d_of_type_Boolean	Z
    //   256: aload_0
    //   257: aload_1
    //   258: ldc_w 1460
    //   261: iconst_1
    //   262: invokevirtual 1437	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   265: putfield 127	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_e_of_type_Boolean	Z
    //   268: aload_0
    //   269: aload_1
    //   270: ldc_w 1462
    //   273: iconst_0
    //   274: invokevirtual 1437	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   277: putfield 1243	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_o_of_type_Boolean	Z
    //   280: aload_0
    //   281: aload_1
    //   282: ldc_w 1464
    //   285: iconst_1
    //   286: invokevirtual 1437	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   289: putfield 121	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_c_of_type_Boolean	Z
    //   292: aload_0
    //   293: aload_1
    //   294: ldc_w 1466
    //   297: invokevirtual 1468	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   300: putfield 1469	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_d_of_type_Int	I
    //   303: aload_1
    //   304: ldc_w 1471
    //   307: invokevirtual 1468	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   310: ifne +282 -> 592
    //   313: ldc_w 1472
    //   316: istore_2
    //   317: aload_0
    //   318: iload_2
    //   319: putfield 1190	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_e_of_type_Int	I
    //   322: aload_1
    //   323: ldc_w 1474
    //   326: iconst_0
    //   327: invokevirtual 1450	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   330: ifeq +277 -> 607
    //   333: iconst_1
    //   334: istore_3
    //   335: aload_0
    //   336: iload_3
    //   337: putfield 733	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_g_of_type_Boolean	Z
    //   340: aload_0
    //   341: aload_1
    //   342: ldc_w 1476
    //   345: iconst_1
    //   346: invokevirtual 1450	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   349: putfield 194	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_f_of_type_Int	I
    //   352: aload_0
    //   353: aload_1
    //   354: ldc_w 1478
    //   357: invokevirtual 948	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   360: putfield 946	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   363: aload_0
    //   364: aload_1
    //   365: ldc_w 1480
    //   368: iconst_0
    //   369: invokevirtual 1450	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   372: putfield 129	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_g_of_type_Int	I
    //   375: aload_0
    //   376: aload_1
    //   377: ldc_w 1482
    //   380: bipush 9
    //   382: invokevirtual 1450	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   385: putfield 123	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_a_of_type_Int	I
    //   388: aload_0
    //   389: aload_1
    //   390: ldc_w 1484
    //   393: iconst_0
    //   394: invokevirtual 1450	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   397: putfield 1030	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_h_of_type_Int	I
    //   400: aload_0
    //   401: aload_1
    //   402: ldc_w 1486
    //   405: aload_0
    //   406: ldc_w 1487
    //   409: invokevirtual 792	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:getString	(I)Ljava/lang/String;
    //   412: invokevirtual 938	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   415: putfield 1033	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   418: aload_0
    //   419: aload_0
    //   420: ldc_w 1488
    //   423: iconst_1
    //   424: anewarray 715	java/lang/Object
    //   427: dup
    //   428: iconst_0
    //   429: aload_0
    //   430: getfield 728	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_c_of_type_Int	I
    //   433: invokestatic 720	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   436: aastore
    //   437: invokevirtual 723	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   440: putfield 133	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:p	Ljava/lang/String;
    //   443: aload_0
    //   444: aload_1
    //   445: ldc_w 1490
    //   448: iconst_1
    //   449: invokevirtual 1450	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   452: putfield 455	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_i_of_type_Int	I
    //   455: aload_0
    //   456: aload_1
    //   457: ldc_w 1492
    //   460: ldc 131
    //   462: invokevirtual 938	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   465: putfield 679	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   468: aload_0
    //   469: aload_1
    //   470: ldc_w 1494
    //   473: iconst_1
    //   474: invokevirtual 1437	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   477: putfield 143	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_h_of_type_Boolean	Z
    //   480: aload_0
    //   481: aload_1
    //   482: ldc_w 1496
    //   485: iconst_0
    //   486: invokevirtual 1437	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   489: putfield 633	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_i_of_type_Boolean	Z
    //   492: aload_0
    //   493: aload_1
    //   494: ldc_w 1498
    //   497: iconst_0
    //   498: invokevirtual 1437	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   501: putfield 635	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_j_of_type_Boolean	Z
    //   504: aload_0
    //   505: aload_1
    //   506: ldc_w 1500
    //   509: iconst_1
    //   510: invokevirtual 1437	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   513: putfield 145	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_k_of_type_Boolean	Z
    //   516: aload_0
    //   517: getfield 635	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_j_of_type_Boolean	Z
    //   520: ifeq +8 -> 528
    //   523: aload_0
    //   524: iconst_0
    //   525: putfield 145	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_k_of_type_Boolean	Z
    //   528: aload_0
    //   529: aload_1
    //   530: invokevirtual 1502	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:a	(Lorg/json/JSONObject;)V
    //   533: aload_0
    //   534: getfield 129	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:jdField_g_of_type_Int	I
    //   537: ifne +8 -> 545
    //   540: aload_0
    //   541: invokevirtual 1503	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:a	()Z
    //   544: pop
    //   545: aload_0
    //   546: invokevirtual 1505	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:b	()V
    //   549: iconst_1
    //   550: ireturn
    //   551: astore_1
    //   552: aload_0
    //   553: iconst_1
    //   554: aload_0
    //   555: ldc_w 1405
    //   558: iconst_1
    //   559: anewarray 715	java/lang/Object
    //   562: dup
    //   563: iconst_0
    //   564: sipush 999
    //   567: invokestatic 720	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   570: aastore
    //   571: invokevirtual 723	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   574: iconst_0
    //   575: invokestatic 1408	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   578: aload_0
    //   579: invokevirtual 406	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:getTitleBarHeight	()I
    //   582: invokevirtual 409	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   585: pop
    //   586: aload_0
    //   587: invokevirtual 671	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:finish	()V
    //   590: iconst_0
    //   591: ireturn
    //   592: aload_1
    //   593: ldc_w 1471
    //   596: invokevirtual 1468	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   599: sipush 1000
    //   602: imul
    //   603: istore_2
    //   604: goto -287 -> 317
    //   607: iconst_0
    //   608: istore_3
    //   609: goto -274 -> 335
    //   612: astore_1
    //   613: aload_1
    //   614: invokevirtual 412	java/lang/Exception:printStackTrace	()V
    //   617: aload_0
    //   618: invokevirtual 671	com/tencent/mobileqq/troop/activity/TroopBarReplyActivity:finish	()V
    //   621: ldc_w 876
    //   624: iconst_1
    //   625: new 655	java/lang/StringBuilder
    //   628: dup
    //   629: invokespecial 656	java/lang/StringBuilder:<init>	()V
    //   632: ldc_w 1507
    //   635: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: aload_1
    //   639: invokevirtual 1511	java/lang/Object:getClass	()Ljava/lang/Class;
    //   642: invokevirtual 1514	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   645: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: ldc_w 1516
    //   651: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: aload_1
    //   655: invokevirtual 1519	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   658: invokevirtual 662	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: invokevirtual 663	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   664: invokestatic 1064	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   667: goto -118 -> 549
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	670	0	this	TroopBarReplyActivity
    //   0	670	1	paramBundle	Bundle
    //   316	288	2	i1	int
    //   334	275	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   121	130	551	java/lang/Exception
    //   545	549	612	java/lang/Exception
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
    }
    if (!this.jdField_b_of_type_Boolean) {
      d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.removeTextChangedListener(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onDestroy() is called,isRecording is:" + bool);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.c();
    }
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    try
    {
      Field localField = Class.forName("android.widget.BubblePopupHelper").getDeclaredField("sHelper");
      localField.setAccessible(true);
      localField.set(null, null);
      if (QLog.isColorLevel()) {
        QLog.e("IphoneTitleBarActivity", 2, "doOnDestroy: cut sHelper ref true");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("IphoneTitleBarActivity", 2, "doOnDestroy: " + QLog.getStackTraceString(localException));
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if (paramIntent != null)
      {
        a(this.jdField_a_of_type_AndroidOsHandler, paramIntent);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = new TroopBarPublishUtils.PicUploadThread(this, null, this.jdField_a_of_type_JavaUtilArrayList, "https://upload.buluo.qq.com/cgi-bin/bar/upload/image");
        ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread, 8, null, true);
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onPause() is called,isRecording is:" + bool);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1003);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 9)
    {
      QQToast.a(this, getString(2131696004, new Object[] { Integer.valueOf(9) }), 0).a();
      return;
    }
    TroopBarPublishUtils.a(this, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int);
  }
  
  public void emoticonMall() {}
  
  public void f()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 9)
    {
      QQToast.a(this, getString(2131696004, new Object[] { Integer.valueOf(9) }), 0).a();
      return;
    }
    this.jdField_a_of_type_AndroidNetUri = TroopBarPublishUtils.a(this, new bezq(this));
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener != null) {
      bkxz.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
    }
    overridePendingTransition(0, 2130771978);
    if (((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.length() > 0)) || ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))) {}
    for (String str = "0";; str = "1")
    {
      if (this.jdField_k_of_type_Boolean) {
        bgip.a("reply_page", "un", this.jdField_o_of_type_JavaLangString, str, "", "");
      }
      return;
    }
  }
  
  protected void g()
  {
    switch (this.jdField_g_of_type_Int)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_f_of_type_Int & 0x2) != 2);
        if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission("android.permission.RECORD_AUDIO") != 0))
        {
          requestPermissions(new bezv(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
          return;
        }
        c();
        return;
      } while ((this.jdField_f_of_type_Int & 0x1) != 1);
      f();
      return;
    } while ((this.jdField_f_of_type_Int & 0x1) != 1);
    e();
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel = ((TribeHotPicPanel)LayoutInflater.from(this).inflate(2131562960, null));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.a(this.app, this, this);
      this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel, -1, DisplayUtil.dip2px(this, 250.0F));
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.f();
  }
  
  protected void i()
  {
    a(this.jdField_b_of_type_AndroidWidgetImageButton, this.jdField_f_of_type_ArrayOfInt[1]);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.isShown())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.a(false);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.w("IphoneTitleBarActivity", 2, "transparent_space click!!!!!!!!!!!!!!!");
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
      finish();
      continue;
      Object localObject = new Intent(this, TroopBarPublishLocationSelectActivity.class);
      ((Intent)localObject).putParcelableArrayListExtra("current_location_list", this.jdField_b_of_type_JavaUtilArrayList);
      ((Intent)localObject).putExtra("key_selected_poi", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      startActivityForResult((Intent)localObject, 1002);
      if (this.jdField_k_of_type_Boolean)
      {
        String str = this.jdField_o_of_type_JavaLangString;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {}
        for (localObject = "0";; localObject = "1")
        {
          bgip.a("reply_page", "Clk_place", str, (String)localObject, "", "");
          break;
        }
        n();
        continue;
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 500L)
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          if (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0)
          {
            this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
            bkxz.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
            j();
          }
          else
          {
            bkxz.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopBarReplyActivity.6(this), 200L);
            continue;
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
            a();
            continue;
            if (this.jdField_k_of_type_Boolean)
            {
              bgip.a("reply_page", "del_photo", this.jdField_o_of_type_JavaLangString, "", "", "");
              continue;
              if (this.jdField_k_of_type_Boolean)
              {
                bgip.a("pub_page", "choose_photo", this.jdField_o_of_type_JavaLangString, "", "", "");
                continue;
                if (this.jdField_a_of_type_AndroidWidgetGridView.getVisibility() == 0)
                {
                  c(0);
                  this.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopBarReplyActivity.7(this), 200L);
                }
                else
                {
                  bkxz.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
                  this.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopBarReplyActivity.8(this), 200L);
                  if (this.jdField_k_of_type_Boolean)
                  {
                    bgip.a(this.jdField_m_of_type_JavaLangString, this.jdField_n_of_type_JavaLangString, "Clk_add", this.jdField_o_of_type_JavaLangString, "", "", "");
                    continue;
                    m();
                    continue;
                    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b()) {
                      if (this.jdField_d_of_type_AndroidWidgetImageButton.isSelected())
                      {
                        k();
                        bkxz.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
                      }
                      else
                      {
                        o();
                        continue;
                        l();
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return true;
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void send() {}
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    if (((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener != null)) {
      ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).send(this.app, this, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener, null);
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarReplyActivity
 * JD-Core Version:    0.7.0.1
 */