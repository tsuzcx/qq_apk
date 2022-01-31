package com.tencent.mobileqq.troop.activity;

import acxs;
import acxt;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
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
import anyb;
import anyc;
import aocp;
import aqzv;
import ayla;
import azhl;
import azhm;
import azho;
import azhp;
import azhq;
import azhr;
import azhs;
import azht;
import azhu;
import azhv;
import azhw;
import azhx;
import azmi;
import baho;
import bair;
import bait;
import bawz;
import bbcv;
import bbdr;
import bbgg;
import bcmu;
import bcpq;
import bcpw;
import bfmr;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.troop.widget.TribeHotPicPanel;
import com.tencent.mobileqq.troop.widget.XEditTextExWithListener;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mxh;
import nam;
import nap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarReplyActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener, anyb, aqzv, baho, bcmu
{
  public static final String a;
  private static int[] jdField_a_of_type_ArrayOfInt;
  private static final int[] jdField_b_of_type_ArrayOfInt;
  private static final int[] c;
  private static final int[] d;
  private static final int[] e;
  protected int a;
  protected long a;
  private acxt jdField_a_of_type_Acxt;
  protected BroadcastReceiver a;
  public Uri a;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new azhs(this);
  protected View a;
  protected ViewGroup a;
  public Button a;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  protected FrameLayout a;
  protected GridView a;
  protected ImageButton a;
  protected ImageView a;
  protected LinearLayout a;
  public bcpq a;
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
  Handler jdField_b_of_type_AndroidOsHandler = new azho(this);
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
    jdField_a_of_type_ArrayOfInt = new int[] { 2131693941, 2130838911, 2131697527 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2131720355, 2130838878, 2131697514 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2131697512, 2130838912, 2131697513 };
    jdField_d_of_type_ArrayOfInt = new int[] { 2131694474, 2130838905, 2131697524 };
    jdField_e_of_type_ArrayOfInt = new int[] { 2131697530, 2130838857, 2131697529 };
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
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new azhx(this);
    this.jdField_a_of_type_AndroidOsHandler = new azhm(this);
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
              acxs localacxs = new acxs();
              localacxs.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(arrayOfInt[1]);
              localacxs.jdField_a_of_type_Int = arrayOfInt[1];
              localacxs.jdField_a_of_type_JavaLangString = paramContext.getString(arrayOfInt[0]);
              localacxs.jdField_b_of_type_JavaLangString = paramContext.getString(arrayOfInt[2]);
              localacxs.jdField_a_of_type_Boolean = false;
              localArrayList.add(localacxs);
            }
          }
        }
        this.jdField_a_of_type_Acxt.a(localArrayList);
        this.jdField_a_of_type_Acxt.notifyDataSetChanged();
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
      paramImageButton.setImageResource(2130846983);
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
      if (TextUtils.isEmpty(null)) {
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
      localJSONObject.put("version", "8.2.8.4440");
      localJSONObject.put("pubsource", 1);
      localJSONObject.put("theme_id", 0);
      paramString = new NewIntent(super.getApplicationContext(), mxh.class);
      paramString.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.publish_post");
      localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
      localWebSsoRequestBody.type.set(0);
      localWebSsoRequestBody.data.set(localJSONObject.toString());
      paramString.putExtra("data", localWebSsoRequestBody.toByteArray());
      paramString.setObserver(new azhl(this));
      this.app.startServlet(paramString);
      return;
    }
    catch (Exception paramString)
    {
      bcpw.a(this, 1, 2131696568, 0).b(getTitleBarHeight());
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
        localJSONObject.put("version", "8.2.8.4440");
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), mxh.class);
        if (bool) {
          bair.a(this.jdField_m_of_type_JavaLangString, "reply_page_new", "share_interest", this.jdField_o_of_type_JavaLangString, "", "", "");
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
        localNewIntent.setObserver(new azhu(this));
        this.app.startServlet(localNewIntent);
        return;
      }
      catch (Exception paramString)
      {
        bcpw.a(this, 1, 2131696568, 0).b(getTitleBarHeight());
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
    findViewById(2131377676).setEnabled(paramBoolean);
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
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837709);
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      l();
      m();
    }
    for (;;)
    {
      c(true);
      return;
      bfmr.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      l();
      a(this.jdField_a_of_type_AndroidWidgetImageButton, true);
      continue;
      bfmr.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      l();
      a(this.jdField_c_of_type_AndroidWidgetImageButton, true);
      continue;
      bfmr.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      l();
      a(this.jdField_d_of_type_AndroidWidgetImageButton, true);
      continue;
      bfmr.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      k();
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
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130849552);
  }
  
  private void m()
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
  
  private void n()
  {
    a(this.jdField_d_of_type_AndroidWidgetImageButton, this.jdField_f_of_type_ArrayOfInt[2]);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  private void o()
  {
    if (this.jdField_k_of_type_Boolean) {
      bair.a(this.jdField_m_of_type_JavaLangString, this.jdField_n_of_type_JavaLangString, "Clk_photo", this.jdField_o_of_type_JavaLangString, "", "", "");
    }
    if (a(1)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a() != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a() != 1))
    {
      a(1);
      return;
    }
    h();
  }
  
  private void p()
  {
    if (this.jdField_k_of_type_Boolean) {
      bair.a(this.jdField_m_of_type_JavaLangString, this.jdField_n_of_type_JavaLangString, "Clk_shoot", this.jdField_o_of_type_JavaLangString, "", "", "");
    }
    if (a(1)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a() != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a() != 1))
    {
      a(0);
      return;
    }
    i();
  }
  
  private void q()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a() != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a() != 1))
    {
      a(6);
      return;
    }
    if (this.jdField_b_of_type_AndroidWidgetImageButton.isSelected())
    {
      l();
      bfmr.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
      return;
    }
    a(this.jdField_b_of_type_AndroidWidgetImageButton, true);
    bfmr.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopBarReplyActivity.14(this), 200L);
  }
  
  private void r()
  {
    if (this.jdField_k_of_type_Boolean)
    {
      bair.a(this.jdField_m_of_type_JavaLangString, this.jdField_n_of_type_JavaLangString, "Clk_record", this.jdField_o_of_type_JavaLangString, "", "", "");
      bair.b("reply_page_new", "Clk_record", this.jdField_o_of_type_JavaLangString, "", "", "");
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
      requestPermissions(new azhr(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
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
      str = bair.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener).replace("\n", " ");
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
      bair.a("Grp_talk", "pub_reco", "Clk_reco", this.jdField_l_of_type_JavaLangString, "", "", "");
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
    String str = bair.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
    if (!TextUtils.isEmpty(str)) {
      str = str.trim();
    }
    for (int i1 = str.length();; i1 = 0)
    {
      if ((!this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        if (i1 == 0)
        {
          bcpw.a(this, 2131696565, 0).b(getTitleBarHeight());
          if (this.jdField_k_of_type_Boolean) {
            bair.a("reply_page", "fail", this.jdField_o_of_type_JavaLangString, "2", "", "");
          }
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        if (i1 < this.jdField_b_of_type_Int)
        {
          bcpw.a(this, getString(2131696563, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }), 0).b(getTitleBarHeight());
          if (this.jdField_k_of_type_Boolean) {
            bair.a("reply_page", "fail", this.jdField_o_of_type_JavaLangString, "2", "", "");
          }
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        if (i1 > this.jdField_c_of_type_Int)
        {
          bcpw.a(this, getString(2131696564, new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) }), 0).b(getTitleBarHeight());
          if (this.jdField_k_of_type_Boolean) {
            bair.a("reply_page", "fail", this.jdField_o_of_type_JavaLangString, "4", "", "");
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
      if (!nam.a(this))
      {
        bcpw.a(this, 2131694543, 0).b(getTitleBarHeight());
        if (this.jdField_k_of_type_Boolean) {
          bair.a("reply_page", "fail", this.jdField_o_of_type_JavaLangString, "7", "", "");
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
        if ((TroopBarPublishActivity.Pic_list)bair.a.get(localObject) == null)
        {
          this.jdField_a_of_type_Boolean = false;
          a(this, 1, this.jdField_a_of_type_AndroidOsHandler);
          if (!this.jdField_k_of_type_Boolean) {
            break;
          }
          bair.a("reply_page", "fail", this.jdField_o_of_type_JavaLangString, "10", "", "");
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
    bbgg localbbgg = bbcv.a(this, 230);
    localbbgg.setTitle(2131697521);
    Object localObject = new azhp(this, paramInt);
    localbbgg.setNegativeButton(getString(2131697519), (DialogInterface.OnClickListener)localObject);
    String str;
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      str = getString(2131697525, new Object[] { getString(2131697512) });
      localbbgg.setMessage(str);
      localbbgg.setPositiveButton(getString(2131697515), (DialogInterface.OnClickListener)localObject);
    }
    for (;;)
    {
      localbbgg.setMessage(str);
      localbbgg.show();
      return;
      str = getString(2131697525, new Object[] { getString(2131697523) });
      localbbgg.setPositiveButton(getString(2131697516), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131697525, new Object[] { getString(2131697526) });
      localbbgg.setPositiveButton(getString(2131697517), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131697525, new Object[] { getString(2131697526) });
      localbbgg.setPositiveButton(getString(2131697517), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131697525, new Object[] { getString(2131697526) });
      localbbgg.setPositiveButton(getString(2131697517), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131696567, new Object[] { Integer.valueOf(9) });
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() < 9) {}
      for (;;)
      {
        ((PublishItemContainer)localObject).a(bool);
        break;
        bool = false;
      }
      str = getString(2131697528);
      localbbgg.setPositiveButton(getString(2131697520), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131697525, new Object[] { getString(2131697530) });
      localbbgg.setPositiveButton(getString(2131697518), (DialogInterface.OnClickListener)localObject);
    }
  }
  
  public void a(int paramInt, azmi paramazmi)
  {
    if (paramazmi == null) {
      return;
    }
    if ((paramazmi instanceof AudioInfo)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = ((AudioInfo)paramazmi);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a(paramInt, paramazmi);
    c(0);
    bfmr.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
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
      paramVarArgs = getString(2131717912);
      break label39;
      String str = getString(2131717913);
      localObject = str;
      if (paramVarArgs == null) {
        break;
      }
      localObject = str;
      if (paramVarArgs.length <= 0) {
        break;
      }
      bcpw.a(this, paramVarArgs[0], 1).b(getTitleBarHeight());
      paramVarArgs = str;
      break label39;
      paramVarArgs = getString(2131717914);
      break label39;
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!TextUtils.isEmpty(paramVarArgs[0])))
      {
        if (TextUtils.isEmpty(paramVarArgs[0]))
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
      paramVarArgs = getString(2131696547);
    }
  }
  
  public void a(anyc paramanyc)
  {
    if (((paramanyc instanceof aocp)) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener != null)) {
      ((aocp)paramanyc).a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener, null);
    }
  }
  
  public void a(anyc paramanyc1, anyc paramanyc2, Drawable paramDrawable) {}
  
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
  
  protected void a(BaseActivity paramBaseActivity, baho parambaho)
  {
    SosoInterface.a(new azht(this, 0, true, true, this.jdField_l_of_type_Int, false, false, "AbsPublish", paramBaseActivity, parambaho));
    a(2, new String[0]);
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaLangCharSequence = BaseApplication.getContext().getResources().getText(2131718297);
    nap.a((String)null, 0);
    if (this.jdField_g_of_type_Int != 0) {
      j();
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("key_photo_delete_action");
    localIntentFilter.addAction("key_audio_delete_action");
    localIntentFilter.addAction("key_photo_add_action");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_o_of_type_JavaLangString = paramJSONObject.optString("bid", "");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("pid", "");
    this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("cid", "");
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
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
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString))
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
      if (this.jdField_a_of_type_Bcpq == null) {
        this.jdField_a_of_type_Bcpq = new bcpq(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_Bcpq.c(2131696561);
      this.jdField_a_of_type_Bcpq.show();
    }
    while ((this.jdField_a_of_type_Bcpq == null) || (!this.jdField_a_of_type_Bcpq.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Bcpq.dismiss();
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      c(0);
      m();
    }
  }
  
  protected boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "repky restore key = " + this.jdField_j_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {
      return false;
    }
    bait localbait = (bait)bair.b.get(this.jdField_j_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "reply restore key = " + this.jdField_j_of_type_JavaLangString + ", replyData = " + localbait);
    }
    bair.b.clear();
    if (localbait == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
      this.jdField_a_of_type_JavaUtilArrayList = localbait.jdField_a_of_type_JavaUtilArrayList;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = localbait.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI;
    this.jdField_b_of_type_JavaUtilArrayList = localbait.jdField_b_of_type_JavaUtilArrayList;
    this.jdField_b_of_type_Int = localbait.jdField_c_of_type_Int;
    this.jdField_c_of_type_Int = localbait.jdField_d_of_type_Int;
    this.jdField_h_of_type_JavaLangString = localbait.jdField_b_of_type_JavaLangString;
    this.jdField_i_of_type_JavaLangString = localbait.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = localbait.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo;
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
        bcpw.a(this, (CharSequence)localObject, 0).b(getTitleBarHeight());
        return true;
        localObject = getString(2131697532, new Object[] { this.jdField_k_of_type_JavaLangString });
        continue;
        localObject = getString(2131697531, new Object[] { this.jdField_k_of_type_JavaLangString });
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
        localObject1 = getString(2131697511, new Object[] { getString(2131697526) });
      }
      while (localObject1 != null)
      {
        bcpw.a(this, (CharSequence)localObject1, 0).b(getTitleBarHeight());
        return false;
        localObject1 = localObject2;
        if ((paramInt & 0x2) == 2)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo == null) {
            localObject1 = getString(2131697511, new Object[] { getString(2131697512) });
          }
        }
      }
    }
  }
  
  protected boolean a(Handler paramHandler, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      bcpw.a(this, getString(2131697508), 1).b(getTitleBarHeight());
    }
    while (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 9)
    {
      bcpw.a(this, getString(2131694305, new Object[] { Integer.valueOf(9) }), 1).b(getTitleBarHeight());
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
      bcpw.a(this, getString(2131694305, new Object[] { Integer.valueOf(9) }), 1).b(getTitleBarHeight());
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
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("IphoneTitleBarActivity", 2, "filePath is null");
    }
    do
    {
      return true;
      bbdr.a(this, paramString);
      a(this.jdField_a_of_type_AndroidOsHandler, paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.jdField_a_of_type_Boolean = true;
      }
    } while (!this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = new TroopBarPublishUtils.PicUploadThread(this, null, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_e_of_type_JavaLangString);
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread, 8, null, true);
    return true;
  }
  
  public boolean a(anyc paramanyc)
  {
    return true;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i2 = 0;
    this.jdField_j_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.getSelectionStart();
    this.jdField_k_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.getSelectionEnd();
    String str = bair.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
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
      bcpw.a(this, this.p, 0).b(getTitleBarHeight());
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
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener != null) {
      ayla.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
    }
  }
  
  public void b(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("bid", this.jdField_o_of_type_JavaLangString);
    localBundle.putString("pid", this.jdField_b_of_type_JavaLangString);
    localBundle.putString("from", "qqbuluo");
    localBundle.putString("uin", this.app.getCurrentAccountUin());
    localBundle.putString("content", bair.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener).trim());
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
  
  public void b(anyc paramanyc) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c() {}
  
  public void d() {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    m();
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
        paramIntent = bbdr.b(this, this.jdField_a_of_type_AndroidNetUri);
        bbdr.a(this, paramIntent);
        a(this.jdField_a_of_type_AndroidOsHandler, paramIntent);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = new TroopBarPublishUtils.PicUploadThread(this, null, this.jdField_a_of_type_JavaUtilArrayList, "https://upload.buluo.qq.com/cgi-bin/bar/upload/image");
        ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread, 8, null, true);
      } while (!this.jdField_k_of_type_Boolean);
      bair.a("reply_page", "choose_place", this.jdField_o_of_type_JavaLangString, "2", "", "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramIntent.getParcelableExtra("key_selected_poi"));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString)) {}
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    if (paramBundle == null)
    {
      bcpw.a(this, 1, getString(2131696569, new Object[] { Integer.valueOf(990) }), 0).b(getTitleBarHeight());
      finish();
      return false;
    }
    this.jdField_m_of_type_Int = paramBundle.getInt("requestCode", 0);
    paramBundle = paramBundle.getString("options");
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "publish option: " + paramBundle);
    }
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(paramBundle);
        this.jdField_l_of_type_Boolean = paramBundle.optString("platform").equals("FTS");
        this.jdField_m_of_type_Boolean = paramBundle.optBoolean("isReply");
        this.jdField_n_of_type_Boolean = paramBundle.optBoolean("needRecord", true);
        this.jdField_f_of_type_JavaLangString = paramBundle.optString("selectContent");
        this.jdField_g_of_type_JavaLangString = paramBundle.optString("selectUrl");
        this.jdField_b_of_type_Int = paramBundle.optInt("minContentLength", 3);
        this.jdField_c_of_type_Int = paramBundle.optInt("maxContentLength", 700);
        this.jdField_h_of_type_JavaLangString = paramBundle.optString("contentPlaceholder", this.jdField_h_of_type_JavaLangString);
        this.jdField_f_of_type_Boolean = paramBundle.optBoolean("photoOrContent");
        this.jdField_d_of_type_Boolean = paramBundle.optBoolean("needLocation", true);
        this.jdField_e_of_type_Boolean = paramBundle.optBoolean("needFace", true);
        this.jdField_o_of_type_Boolean = paramBundle.optBoolean("needForward", false);
        this.jdField_c_of_type_Boolean = paramBundle.optBoolean("isPreUpload", true);
        this.jdField_d_of_type_Int = paramBundle.optInt("flag");
        if (paramBundle.optInt("recordTimeLimit") == 0)
        {
          i1 = 60000;
          this.jdField_e_of_type_Int = i1;
          if (paramBundle.optInt("requireType", 0) == 0) {
            break label607;
          }
          bool = true;
          this.jdField_g_of_type_Boolean = bool;
          this.jdField_f_of_type_Int = paramBundle.optInt("optionType", 1);
          this.jdField_j_of_type_JavaLangString = paramBundle.optString("cacheKey");
          this.jdField_g_of_type_Int = paramBundle.optInt("defaultCategory", 0);
          this.jdField_a_of_type_Int = paramBundle.optInt("maxPhotoCount", 9);
          this.jdField_h_of_type_Int = paramBundle.optInt("forbiddenType", 0);
          this.jdField_k_of_type_JavaLangString = paramBundle.optString("forbiddenMsg", getString(2131697509));
          this.p = getString(2131696538, new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
          this.jdField_i_of_type_Int = paramBundle.optInt("groupType", 1);
          this.jdField_l_of_type_JavaLangString = paramBundle.optString("groupUin", "");
          this.jdField_h_of_type_Boolean = paramBundle.optBoolean("need_plus_btn", true);
          this.jdField_i_of_type_Boolean = paramBundle.optBoolean("content_to_web", false);
          this.jdField_j_of_type_Boolean = paramBundle.optBoolean("sendToWeb", false);
          this.jdField_k_of_type_Boolean = paramBundle.optBoolean("needTribeReport", true);
          if (this.jdField_j_of_type_Boolean) {
            this.jdField_k_of_type_Boolean = false;
          }
          a(paramBundle);
          if (this.jdField_g_of_type_Int == 0) {
            a();
          }
          e();
          return true;
        }
      }
      catch (Exception paramBundle)
      {
        bcpw.a(this, 1, getString(2131696569, new Object[] { Integer.valueOf(999) }), 0).b(getTitleBarHeight());
        finish();
        return false;
      }
      int i1 = paramBundle.optInt("recordTimeLimit") * 1000;
      continue;
      label607:
      boolean bool = false;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
    }
    if (!this.jdField_b_of_type_Boolean) {
      g();
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.e();
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.d();
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
  
  protected void e()
  {
    int i2 = 0;
    for (;;)
    {
      try
      {
        if (b())
        {
          setContentView(2131559722);
          this.jdField_f_of_type_Int = 0;
          Object localObject = findViewById(2131375327);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131375501));
          this.jdField_b_of_type_AndroidViewView = findViewById(2131377676);
          this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131367911));
          this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131367912));
          this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131371783));
          this.jdField_d_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131363471));
          this.jdField_e_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131363478));
          this.jdField_f_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131367913));
          if ((!this.jdField_n_of_type_Boolean) && (this.jdField_d_of_type_AndroidWidgetImageButton != null)) {
            this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
          }
          this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton[0] = this.jdField_a_of_type_AndroidWidgetImageButton;
          this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton[1] = this.jdField_b_of_type_AndroidWidgetImageButton;
          this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton[2] = this.jdField_d_of_type_AndroidWidgetImageButton;
          this.jdField_a_of_type_ArrayOfAndroidWidgetImageButton[3] = this.jdField_c_of_type_AndroidWidgetImageButton;
          this.jdField_f_of_type_ArrayOfInt[0] = 2130843071;
          this.jdField_f_of_type_ArrayOfInt[1] = 2130841998;
          this.jdField_f_of_type_ArrayOfInt[2] = 2130841990;
          this.jdField_f_of_type_ArrayOfInt[3] = 2130843074;
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367984));
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener = ((XEditTextExWithListener)findViewById(2131365751));
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.setOnKeyPreImeListener(new azhw(this));
          this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131375840));
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer = ((PublishItemContainer)findViewById(2131375130));
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setMaxPicNum(9);
          this.jdField_a_of_type_AndroidViewView = findViewById(2131367887);
          this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131368945));
          this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131368970));
          this.jdField_a_of_type_AndroidViewViewGroup = TroopBarPublishUtils.a(this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener, this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
          findViewById(2131377676).setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131371784));
          this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
          this.jdField_a_of_type_Acxt = new acxt();
          this.jdField_a_of_type_Acxt.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Acxt);
          a(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362850));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)LayoutInflater.from(this).inflate(2131559661, null));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.app, this, this.jdField_b_of_type_AndroidOsHandler, 1);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setPadding(0, bawz.a(this, 20.0F), 0, bawz.a(this, 25.0F));
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
          if ((TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) || (this.jdField_b_of_type_Int <= 0) || (this.jdField_c_of_type_Int <= 0))
          {
            this.jdField_b_of_type_Int = 3;
            this.jdField_c_of_type_Int = 700;
            this.jdField_h_of_type_JavaLangString = getString(2131696539, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) });
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.setHint(this.jdField_h_of_type_JavaLangString);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.getText().length() <= 0)
          {
            XEditTextExWithListener localXEditTextExWithListener = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener;
            if (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
              break label1087;
            }
            localObject = this.jdField_i_of_type_JavaLangString;
            localXEditTextExWithListener.setText((CharSequence)localObject);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
            break label1103;
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString)) {
            break label1092;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_d_of_type_JavaLangString;
          a(1, new String[] { localObject });
          a(this, this);
          localObject = this.jdField_a_of_type_AndroidWidgetImageView;
          if (!this.jdField_d_of_type_Boolean) {
            break label1115;
          }
          i1 = 0;
          ((ImageView)localObject).setVisibility(i1);
          localObject = this.jdField_a_of_type_AndroidWidgetImageButton;
          if (!this.jdField_e_of_type_Boolean) {
            break label1121;
          }
          i1 = 0;
          ((ImageButton)localObject).setVisibility(i1);
          if (this.jdField_b_of_type_AndroidWidgetImageButton != null)
          {
            localObject = this.jdField_b_of_type_AndroidWidgetImageButton;
            if (!this.jdField_e_of_type_Boolean) {
              break label1127;
            }
            i1 = i2;
            ((ImageButton)localObject).setVisibility(i1);
          }
          if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
            break label1133;
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
            bair.a("reply_page", "choose_place", this.jdField_o_of_type_JavaLangString, "0", ((StringBuffer)localObject).toString(), "");
            bair.a("reply_page", "exp", String.valueOf(this.jdField_o_of_type_JavaLangString), "", "", "");
          }
          return;
        }
        if (this.jdField_o_of_type_Boolean)
        {
          setContentView(2131559721);
          this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131375125));
          continue;
        }
        setContentView(2131559720);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        finish();
        return;
      }
      continue;
      label1087:
      String str = null;
      continue;
      label1092:
      str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString;
      continue;
      label1103:
      a(0, new String[0]);
      continue;
      label1115:
      int i1 = 8;
      continue;
      label1121:
      i1 = 8;
      continue;
      label1127:
      i1 = 8;
      continue;
      label1133:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {
        a(2, this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
      }
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopBarReplyActivity.4(this), 200L);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopBarReplyActivity.5(this), 500L);
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener != null) {
      bfmr.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
    }
    overridePendingTransition(0, 2130771978);
    if (((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.length() > 0)) || ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))) {}
    for (String str = "0";; str = "1")
    {
      if (this.jdField_k_of_type_Boolean) {
        bair.a("reply_page", "un", this.jdField_o_of_type_JavaLangString, str, "", "");
      }
      return;
    }
  }
  
  protected void g()
  {
    int i2 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "reply save key = " + this.jdField_j_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {}
    for (;;)
    {
      return;
      bait localbait = new bait();
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
        localbait.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
      {
        localbait.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = new TroopBarPOI(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        if (this.jdField_b_of_type_JavaUtilArrayList != null)
        {
          localArrayList = new ArrayList();
          i1 = i2;
          while (i1 < this.jdField_b_of_type_JavaUtilArrayList.size())
          {
            localArrayList.add(new TroopBarPOI((TroopBarPOI)this.jdField_b_of_type_JavaUtilArrayList.get(i1)));
            i1 += 1;
          }
          localbait.jdField_b_of_type_JavaUtilArrayList = localArrayList;
        }
      }
      localbait.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      localbait.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
      localbait.jdField_b_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
      localbait.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener.getEditableText().toString();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {}
      try
      {
        localbait.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = ((AudioInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.clone());
        bair.b.put(this.jdField_j_of_type_JavaLangString, localbait);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopBar", 2, "reply save key = " + this.jdField_j_of_type_JavaLangString + ", data = " + localbait);
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
  
  public void h()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 9)
    {
      bcpw.a(this, getString(2131696567, new Object[] { Integer.valueOf(9) }), 0).a();
      return;
    }
    TroopBarPublishUtils.a(this, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 9)
    {
      bcpw.a(this, getString(2131696567, new Object[] { Integer.valueOf(9) }), 0).a();
      return;
    }
    this.jdField_a_of_type_AndroidNetUri = TroopBarPublishUtils.a(this, new azhq(this));
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected void j()
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
          requestPermissions(new azhv(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
          return;
        }
        f();
        return;
      } while ((this.jdField_f_of_type_Int & 0x1) != 1);
      i();
      return;
    } while ((this.jdField_f_of_type_Int & 0x1) != 1);
    h();
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel = ((TribeHotPicPanel)LayoutInflater.from(this).inflate(2131562513, null));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.a(this.app, this, this);
      this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel, -1, bawz.a(this, 250.0F));
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.f();
  }
  
  protected void l()
  {
    a(this.jdField_b_of_type_AndroidWidgetImageButton, this.jdField_f_of_type_ArrayOfInt[1]);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.isShown())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.a(false);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131377676: 
    case 2131367984: 
    case 2131367912: 
    case 2131367911: 
    case 2131375840: 
    case 2131367975: 
    case 2131378713: 
    case 2131371783: 
    case 2131363478: 
    case 2131363471: 
      do
      {
        do
        {
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
                    QLog.w("IphoneTitleBarActivity", 2, "transparent_space click!!!!!!!!!!!!!!!");
                  }
                  this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
                  finish();
                  return;
                  paramView = new Intent(this, TroopBarPublishLocationSelectActivity.class);
                  paramView.putParcelableArrayListExtra("current_location_list", this.jdField_b_of_type_JavaUtilArrayList);
                  paramView.putExtra("key_selected_poi", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
                  startActivityForResult(paramView, 1002);
                } while (!this.jdField_k_of_type_Boolean);
                String str = this.jdField_o_of_type_JavaLangString;
                if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {}
                for (paramView = "0";; paramView = "1")
                {
                  bair.a("reply_page", "Clk_place", str, paramView, "", "");
                  return;
                }
                q();
                return;
              } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L);
              this.jdField_a_of_type_Long = System.currentTimeMillis();
              if (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0)
              {
                this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
                bfmr.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
                m();
                return;
              }
              bfmr.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
              this.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopBarReplyActivity.6(this), 200L);
              return;
              this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
              a();
              return;
            } while (!this.jdField_k_of_type_Boolean);
            bair.a("reply_page", "del_photo", this.jdField_o_of_type_JavaLangString, "", "", "");
            return;
          } while (!this.jdField_k_of_type_Boolean);
          bair.a("pub_page", "choose_photo", this.jdField_o_of_type_JavaLangString, "", "", "");
          return;
          if (this.jdField_a_of_type_AndroidWidgetGridView.getVisibility() == 0)
          {
            c(0);
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopBarReplyActivity.7(this), 200L);
            return;
          }
          bfmr.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopBarReplyActivity.8(this), 200L);
        } while (!this.jdField_k_of_type_Boolean);
        bair.a(this.jdField_m_of_type_JavaLangString, this.jdField_n_of_type_JavaLangString, "Clk_add", this.jdField_o_of_type_JavaLangString, "", "", "");
        return;
        p();
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b());
      if (this.jdField_d_of_type_AndroidWidgetImageButton.isSelected())
      {
        n();
        bfmr.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetXEditTextExWithListener);
        return;
      }
      r();
      return;
    }
    o();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarReplyActivity
 * JD-Core Version:    0.7.0.1
 */