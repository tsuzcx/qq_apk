package com.tencent.mobileqq.troop.activity;

import aikl;
import aikm;
import aikn;
import aikq;
import aikr;
import aiks;
import aikt;
import aiku;
import aikv;
import aikw;
import aikx;
import aiky;
import aikz;
import aila;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.aio.PlusPanel.PluginData;
import com.tencent.mobileqq.activity.aio.PlusPanelAdapter;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicPageView.OnHotPicItemClickListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.data.MediaInfo;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopBarUtils.PublishDataCacheEntity;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.troop.widget.TribeHotPicPanel;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.onSizeChangedListenner;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarReplyActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener, EmoticonCallback, HotPicPageView.OnHotPicItemClickListener, HttpWebCgiAsyncTask.Callback, InputMethodRelativeLayout.onSizeChangedListenner
{
  public static final String a;
  private static int[] jdField_a_of_type_ArrayOfInt;
  private static final int[] jdField_b_of_type_ArrayOfInt;
  private static final int[] c;
  private static final int[] d;
  private static final int[] e;
  protected int a;
  protected long a;
  protected BroadcastReceiver a;
  protected Drawable a;
  protected Uri a;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aikq(this);
  protected View a;
  public Button a;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  public EditText a;
  protected FrameLayout a;
  protected GridView a;
  public ImageButton a;
  protected ImageView a;
  protected LinearLayout a;
  private PlusPanelAdapter jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanelAdapter;
  public CommonRecordSoundPanel a;
  protected SystemEmoticonPanel a;
  public TroopBarPublishUtils.AudioUploadTask a;
  protected TroopBarPublishUtils.PicUploadThread a;
  public AudioInfo a;
  public TroopBarPOI a;
  public PublishItemContainer a;
  protected TribeHotPicPanel a;
  protected InputMethodRelativeLayout a;
  public QQProgressDialog a;
  protected Boolean a;
  protected CharSequence a;
  public ArrayList a;
  public boolean a;
  private final int[][] jdField_a_of_type_Array2dOfInt = new int[5][];
  protected int b;
  Handler jdField_b_of_type_AndroidOsHandler = new aikm(this);
  protected FrameLayout b;
  protected ImageButton b;
  private AudioInfo jdField_b_of_type_ComTencentMobileqqTroopDataAudioInfo;
  protected String b;
  protected ArrayList b;
  public boolean b;
  protected int c;
  public ImageButton c;
  protected String c;
  protected boolean c;
  protected int d;
  protected String d;
  protected boolean d;
  protected int e;
  protected String e;
  protected boolean e;
  protected int f;
  protected String f;
  protected boolean f;
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
  private boolean jdField_l_of_type_Boolean;
  private int m;
  public String m;
  public String n;
  public String o;
  protected String p = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = TroopBarReplyActivity.class.getName();
    jdField_a_of_type_ArrayOfInt = new int[] { 2131427505, 2130838397, 2131430454 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2131433806, 2130838380, 2131430456 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2131430461, 2130838398, 2131430457 };
    jdField_d_of_type_ArrayOfInt = new int[] { 2131434892, 2130838391, 2131430458 };
    jdField_e_of_type_ArrayOfInt = new int[] { 2131430464, 2130838375, 2131430459 };
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
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aikz(this);
    this.jdField_a_of_type_AndroidOsHandler = new aila(this);
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
              PlusPanel.PluginData localPluginData = new PlusPanel.PluginData();
              localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(arrayOfInt[1]);
              localPluginData.jdField_a_of_type_Int = arrayOfInt[1];
              localPluginData.jdField_a_of_type_JavaLangString = paramContext.getString(arrayOfInt[0]);
              localPluginData.jdField_b_of_type_JavaLangString = paramContext.getString(arrayOfInt[2]);
              localPluginData.jdField_a_of_type_Boolean = false;
              localArrayList.add(localPluginData);
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanelAdapter.a(localArrayList);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanelAdapter.notifyDataSetChanged();
      }
      return;
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
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(paramBoolean);
    findViewById(2131366584).setEnabled(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation2);
      if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
        this.jdField_b_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation2);
      }
      this.jdField_c_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation2);
      this.jdField_a_of_type_AndroidWidgetButton.startAnimation(localAlphaAnimation2);
      this.jdField_a_of_type_AndroidWidgetEditText.startAnimation(localAlphaAnimation2);
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation2);
      findViewById(2131366584).setBackgroundColor(0);
      findViewById(2131366584).setBackgroundResource(2130846313);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation1);
    if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
      this.jdField_b_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation1);
    }
    this.jdField_c_of_type_AndroidWidgetImageButton.startAnimation(localAlphaAnimation1);
    this.jdField_a_of_type_AndroidWidgetEditText.startAnimation(localAlphaAnimation1);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation1);
    findViewById(2131366584).setBackgroundColor(1291845632);
    this.jdField_a_of_type_AndroidWidgetButton.startAnimation(localAlphaAnimation1);
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837571);
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      k();
      return;
    case 2: 
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      k();
      return;
    case 3: 
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      k();
      return;
    case 4: 
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      k();
      return;
    }
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    j();
  }
  
  public void a()
  {
    Object localObject2;
    if ((this.jdField_m_of_type_Int == 101000) || (this.jdField_i_of_type_Boolean) || (this.jdField_j_of_type_Boolean))
    {
      localObject1 = TroopBarUtils.a(this.jdField_a_of_type_AndroidWidgetEditText).replace("\n", " ");
      this.jdField_b_of_type_Boolean = true;
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("result", "\"" + (String)localObject1 + "\"");
      setResult(-1, (Intent)localObject2);
      finish();
    }
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((this.jdField_i_of_type_Int == 2) && (this.jdField_k_of_type_Boolean)) {
      TroopBarUtils.a("Grp_talk", "pub_reco", "Clk_reco", this.jdField_l_of_type_JavaLangString, "", "", "");
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
    Object localObject1 = TroopBarUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = ((String)localObject1).trim();
    }
    for (int i1 = ((String)localObject1).length();; i1 = 0)
    {
      if ((!this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        if (i1 == 0)
        {
          QQToast.a(this, 2131430311, 0).b(getTitleBarHeight());
          if (this.jdField_k_of_type_Boolean) {
            TroopBarUtils.a("reply_page", "fail", this.o, "2", "", "");
          }
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        if (i1 < this.jdField_b_of_type_Int)
        {
          QQToast.a(this, getString(2131430312, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }), 0).b(getTitleBarHeight());
          if (this.jdField_k_of_type_Boolean) {
            TroopBarUtils.a("reply_page", "fail", this.o, "2", "", "");
          }
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        if (i1 > this.jdField_c_of_type_Int)
        {
          QQToast.a(this, getString(2131430313, new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) }), 0).b(getTitleBarHeight());
          if (this.jdField_k_of_type_Boolean) {
            TroopBarUtils.a("reply_page", "fail", this.o, "4", "", "");
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
      if (!HttpUtil.a(this))
      {
        QQToast.a(this, 2131433086, 0).b(getTitleBarHeight());
        if (this.jdField_k_of_type_Boolean) {
          TroopBarUtils.a("reply_page", "fail", this.o, "7", "", "");
        }
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      a(true);
      i1 = 0;
      for (;;)
      {
        if (i1 >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label611;
        }
        localObject2 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if ((TroopBarPublishActivity.Pic_list)TroopBarUtils.a.get(localObject2) == null)
        {
          this.jdField_a_of_type_Boolean = false;
          a(this, 1, this.jdField_a_of_type_AndroidOsHandler);
          if (!this.jdField_k_of_type_Boolean) {
            break;
          }
          TroopBarUtils.a("reply_page", "fail", this.o, "10", "", "");
          return;
        }
        i1 += 1;
      }
      label611:
      boolean bool;
      if (this.jdField_a_of_type_AndroidWidgetCheckBox != null)
      {
        bool = this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked();
        localObject1 = TroopBarPublishUtils.a((String)localObject1, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
        localObject2 = new JSONObject();
      }
      for (;;)
      {
        try
        {
          ((JSONObject)localObject2).put("pid", this.jdField_b_of_type_JavaLangString);
          ((JSONObject)localObject2).put("bid", Long.parseLong(this.o));
          ((JSONObject)localObject2).put("comment", localObject1);
          if (bool) {
            ((JSONObject)localObject2).put("is_forward", 1);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
          {
            ((JSONObject)localObject2).put("uid", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_a_of_type_JavaLangString);
            ((JSONObject)localObject2).put("lat", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_b_of_type_Int));
            ((JSONObject)localObject2).put("lon", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_a_of_type_Int));
          }
          ((JSONObject)localObject2).put("extparam", this.jdField_d_of_type_JavaLangString);
          ((JSONObject)localObject2).put("version", "7.6.0.3525");
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), ProtoServlet.class);
          if (bool) {
            TroopBarUtils.a(this.jdField_m_of_type_JavaLangString, "reply_page_new", "share_interest", this.o, "", "", "");
          }
          if (this.jdField_i_of_type_Int != 1) {
            break label958;
          }
          localObject1 = "MQUpdateSvc_com_qq_xiaoqu.web.comment";
          localNewIntent.putExtra("cmd", (String)localObject1);
          localObject1 = new WebSsoBody.WebSsoRequestBody();
          ((WebSsoBody.WebSsoRequestBody)localObject1).type.set(0);
          ((WebSsoBody.WebSsoRequestBody)localObject1).data.set(((JSONObject)localObject2).toString());
          localNewIntent.putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject1).toByteArray());
          localNewIntent.setObserver(new aikl(this));
          this.app.startServlet(localNewIntent);
          return;
        }
        catch (Exception localException)
        {
          QQToast.a(this, 1, 2131430291, 0).b(getTitleBarHeight());
          a(false);
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        bool = false;
        break;
        label958:
        String str = "MQUpdateSvc_com_qq_buluo.web.sbar_comment";
      }
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool = true;
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(2131430466);
    Object localObject = new aikn(this, paramInt);
    localQQCustomDialog.setNegativeButton(getString(2131430468), (DialogInterface.OnClickListener)localObject);
    String str;
    switch (paramInt)
    {
    case 6: 
    default: 
      return;
    case 2: 
      str = getString(2131430460, new Object[] { getString(2131430461) });
      localQQCustomDialog.setMessage(str);
      localQQCustomDialog.setPositiveButton(getString(2131430470), (DialogInterface.OnClickListener)localObject);
    }
    for (;;)
    {
      localQQCustomDialog.setMessage(str);
      localQQCustomDialog.show();
      return;
      str = getString(2131430460, new Object[] { getString(2131430462) });
      localQQCustomDialog.setPositiveButton(getString(2131430469), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131430460, new Object[] { getString(2131430463) });
      localQQCustomDialog.setPositiveButton(getString(2131430471), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131430460, new Object[] { getString(2131430463) });
      localQQCustomDialog.setPositiveButton(getString(2131430471), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131430333, new Object[] { Integer.valueOf(9) });
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() < 9) {}
      for (;;)
      {
        ((PublishItemContainer)localObject).a(bool);
        break;
        bool = false;
      }
      str = getString(2131430465);
      localQQCustomDialog.setPositiveButton(getString(2131430467), (DialogInterface.OnClickListener)localObject);
      continue;
      str = getString(2131430460, new Object[] { getString(2131430464) });
      localQQCustomDialog.setPositiveButton(getString(2131430472), (DialogInterface.OnClickListener)localObject);
    }
  }
  
  public void a(int paramInt, MediaInfo paramMediaInfo)
  {
    if (paramMediaInfo == null) {
      return;
    }
    if ((paramMediaInfo instanceof AudioInfo)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = ((AudioInfo)paramMediaInfo);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a(paramInt, paramMediaInfo);
    c(0);
    InputMethodUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
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
      paramVarArgs = getString(2131432491);
      break label39;
      String str = getString(2131432490);
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
      paramVarArgs = getString(2131432489);
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
      paramVarArgs = getString(2131430323);
    }
  }
  
  protected void a(BaseActivity paramBaseActivity, int paramInt, Handler paramHandler)
  {
    paramBaseActivity.runOnUiThread(new aikr(this));
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
  
  protected void a(BaseActivity paramBaseActivity, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    SosoInterface.a(new aiks(this, 0, true, true, this.jdField_l_of_type_Int, false, false, "AbsPublish", paramBaseActivity, paramCallback));
    a(2, new String[0]);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    if (((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) && (this.jdField_a_of_type_AndroidWidgetEditText != null)) {
      ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).a(this.app, this, this.jdField_a_of_type_AndroidWidgetEditText, null);
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130844380);
    this.jdField_a_of_type_JavaLangCharSequence = BaseApplication.getContext().getResources().getText(2131432657);
    com.tencent.biz.common.util.ImageUtil.a((String)null, 0);
    if (this.jdField_g_of_type_Int != 0) {
      i();
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("key_photo_delete_action");
    localIntentFilter.addAction("key_audio_delete_action");
    localIntentFilter.addAction("key_photo_add_action");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.o = paramJSONObject.optString("bid", "");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("pid", "");
    this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("cid", "");
    if (android.text.TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
    for (this.jdField_j_of_type_JavaLangString = (this.app.getCurrentAccountUin() + "-" + this.o + "-" + this.jdField_b_of_type_JavaLangString);; this.jdField_j_of_type_JavaLangString = (this.app.getCurrentAccountUin() + "-" + this.o + "-" + this.jdField_b_of_type_JavaLangString + "-" + this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_d_of_type_JavaLangString = paramJSONObject.optString("extparam");
      this.jdField_m_of_type_JavaLangString = "Grp_tribe";
      this.n = "reply_page";
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
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131430334);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      c(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
      if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
        this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(false);
      }
      this.jdField_c_of_type_AndroidWidgetImageButton.setSelected(false);
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
    TroopBarUtils.PublishDataCacheEntity localPublishDataCacheEntity = (TroopBarUtils.PublishDataCacheEntity)TroopBarUtils.b.get(this.jdField_j_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "reply restore key = " + this.jdField_j_of_type_JavaLangString + ", replyData = " + localPublishDataCacheEntity);
    }
    TroopBarUtils.b.clear();
    if (localPublishDataCacheEntity == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
      this.jdField_a_of_type_JavaUtilArrayList = localPublishDataCacheEntity.jdField_a_of_type_JavaUtilArrayList;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI;
    this.jdField_b_of_type_JavaUtilArrayList = localPublishDataCacheEntity.jdField_b_of_type_JavaUtilArrayList;
    this.jdField_b_of_type_Int = localPublishDataCacheEntity.jdField_c_of_type_Int;
    this.jdField_c_of_type_Int = localPublishDataCacheEntity.jdField_d_of_type_Int;
    this.jdField_h_of_type_JavaLangString = localPublishDataCacheEntity.jdField_b_of_type_JavaLangString;
    this.jdField_i_of_type_JavaLangString = localPublishDataCacheEntity.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo;
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
        localObject = getString(2131430475, new Object[] { this.jdField_k_of_type_JavaLangString });
        continue;
        localObject = getString(2131430474, new Object[] { this.jdField_k_of_type_JavaLangString });
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
        localObject1 = getString(2131430478, new Object[] { getString(2131430463) });
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
            localObject1 = getString(2131430478, new Object[] { getString(2131430461) });
          }
        }
      }
    }
  }
  
  protected boolean a(Handler paramHandler, String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      QQToast.a(this, getString(2131430476), 1).b(getTitleBarHeight());
    }
    while (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 9)
    {
      QQToast.a(this, getString(2131432384, new Object[] { Integer.valueOf(9) }), 1).b(getTitleBarHeight());
      return false;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    Message localMessage = paramHandler.obtainMessage(1005);
    localMessage.obj = paramString;
    paramHandler.sendMessage(localMessage);
    return true;
  }
  
  protected boolean a(Handler paramHandler, ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 9))
    {
      QQToast.a(this, getString(2131432384, new Object[] { Integer.valueOf(9) }), 1).b(getTitleBarHeight());
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
      com.tencent.mobileqq.utils.ImageUtil.a(this, paramString);
      a(this.jdField_a_of_type_AndroidOsHandler, paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.jdField_a_of_type_Boolean = true;
      }
    } while (!this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = new TroopBarPublishUtils.PicUploadThread(this, null, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_e_of_type_JavaLangString);
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread, 8, null, true);
    return true;
  }
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return true;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i2 = 0;
    this.jdField_j_of_type_Int = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
    this.jdField_k_of_type_Int = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
    String str = TroopBarUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
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
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(i1 + this.jdField_j_of_type_Int);
      return;
      i1 = str.length();
      break;
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      i1 = i2;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
    }
  }
  
  public void b(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("bid", this.o);
    localBundle.putString("pid", this.jdField_b_of_type_JavaLangString);
    localBundle.putString("from", "qqbuluo");
    localBundle.putString("uin", this.app.getCurrentAccountUin());
    localBundle.putString("content", TroopBarUtils.a(this.jdField_a_of_type_AndroidWidgetEditText).trim());
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
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c() {}
  
  protected void d()
  {
    int i2 = 0;
    for (;;)
    {
      try
      {
        if (this.jdField_l_of_type_Boolean)
        {
          setContentView(2130969477);
          this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131366627));
          Object localObject = findViewById(2131363226);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)findViewById(2131365609));
          this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131366614));
          this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131366628));
          this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131365573));
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366624));
          this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366594));
          this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365505));
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer = ((PublishItemContainer)findViewById(2131366625));
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setMaxPicNum(9);
          this.jdField_a_of_type_AndroidViewView = findViewById(2131366626);
          this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131366583));
          this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131366590));
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = TroopBarPublishUtils.a(this, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidWidgetEditText, this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
          findViewById(2131366584).setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131366622));
          this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanelAdapter = new PlusPanelAdapter();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanelAdapter.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanelAdapter);
          a(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131366581));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)LayoutInflater.from(this).inflate(2130969421, null));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.app, this, this.jdField_b_of_type_AndroidOsHandler, 1);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setTimeOutTime(this.jdField_e_of_type_Int);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel);
          this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
          if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
            this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
          this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
          this.jdField_a_of_type_AndroidWidgetButton.setPressed(false);
          this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
          if ((android.text.TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) || (this.jdField_b_of_type_Int <= 0) || (this.jdField_c_of_type_Int <= 0))
          {
            this.jdField_b_of_type_Int = 3;
            this.jdField_c_of_type_Int = 700;
            this.jdField_h_of_type_JavaLangString = getString(2131430299, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) });
          }
          this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_h_of_type_JavaLangString);
          if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() <= 0)
          {
            EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
            if (!android.text.TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))
            {
              localObject = this.jdField_i_of_type_JavaLangString;
              localEditText.setText((CharSequence)localObject);
            }
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
              break label860;
            }
            if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString)) {
              break label849;
            }
            localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_d_of_type_JavaLangString;
            a(1, new String[] { localObject });
            a(this, this);
            localObject = this.jdField_a_of_type_AndroidWidgetImageView;
            if (!this.jdField_d_of_type_Boolean) {
              break label872;
            }
            i1 = 0;
            ((ImageView)localObject).setVisibility(i1);
            localObject = this.jdField_a_of_type_AndroidWidgetImageButton;
            if (!this.jdField_e_of_type_Boolean) {
              break label878;
            }
            i1 = 0;
            ((ImageButton)localObject).setVisibility(i1);
            if (this.jdField_b_of_type_AndroidWidgetImageButton != null)
            {
              localObject = this.jdField_b_of_type_AndroidWidgetImageButton;
              if (!this.jdField_e_of_type_Boolean) {
                break label884;
              }
              i1 = i2;
              ((ImageButton)localObject).setVisibility(i1);
            }
            if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
              break label890;
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
              TroopBarUtils.a("reply_page", "choose_place", this.o, "0", ((StringBuffer)localObject).toString(), "");
              TroopBarUtils.a("reply_page", "exp", String.valueOf(this.o), "", "", "");
            }
          }
        }
        else
        {
          setContentView(2130969476);
          continue;
        }
        str = null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        finish();
        return;
      }
      continue;
      label849:
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString;
      continue;
      label860:
      a(0, new String[0]);
      continue;
      label872:
      int i1 = 8;
      continue;
      label878:
      i1 = 8;
      continue;
      label884:
      i1 = 8;
      continue;
      label890:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {
        a(2, this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
    this.jdField_c_of_type_AndroidWidgetImageButton.setSelected(false);
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
        paramIntent = com.tencent.mobileqq.utils.ImageUtil.b(this, this.jdField_a_of_type_AndroidNetUri);
        com.tencent.mobileqq.utils.ImageUtil.a(this, paramIntent);
        a(this.jdField_a_of_type_AndroidOsHandler, paramIntent);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread = new TroopBarPublishUtils.PicUploadThread(this, null, this.jdField_a_of_type_JavaUtilArrayList, "https://upload.buluo.qq.com/cgi-bin/bar/upload/image");
        ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$PicUploadThread, 8, null, true);
      } while (!this.jdField_k_of_type_Boolean);
      TroopBarUtils.a("reply_page", "choose_place", this.o, "2", "", "");
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    if (paramBundle == null)
    {
      QQToast.a(this, 1, getString(2131430292, new Object[] { Integer.valueOf(990) }), 0).b(getTitleBarHeight());
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
        this.jdField_f_of_type_JavaLangString = paramBundle.optString("selectContent");
        this.jdField_g_of_type_JavaLangString = paramBundle.optString("selectUrl");
        this.jdField_b_of_type_Int = paramBundle.optInt("minContentLength", 3);
        this.jdField_c_of_type_Int = paramBundle.optInt("maxContentLength", 700);
        this.jdField_h_of_type_JavaLangString = paramBundle.optString("contentPlaceholder", this.jdField_h_of_type_JavaLangString);
        this.jdField_f_of_type_Boolean = paramBundle.optBoolean("photoOrContent");
        this.jdField_d_of_type_Boolean = paramBundle.optBoolean("needLocation", true);
        this.jdField_e_of_type_Boolean = paramBundle.optBoolean("needFace", true);
        this.jdField_l_of_type_Boolean = paramBundle.optBoolean("needForward", false);
        this.jdField_c_of_type_Boolean = paramBundle.optBoolean("isPreUpload", true);
        this.jdField_d_of_type_Int = paramBundle.optInt("flag");
        if (paramBundle.optInt("recordTimeLimit") == 0)
        {
          i1 = 60000;
          this.jdField_e_of_type_Int = i1;
          if (paramBundle.optInt("requireType", 0) == 0) {
            break label567;
          }
          bool = true;
          this.jdField_g_of_type_Boolean = bool;
          this.jdField_f_of_type_Int = paramBundle.optInt("optionType", 1);
          this.jdField_j_of_type_JavaLangString = paramBundle.optString("cacheKey");
          this.jdField_g_of_type_Int = paramBundle.optInt("defaultCategory", 0);
          this.jdField_a_of_type_Int = paramBundle.optInt("maxPhotoCount", 9);
          this.jdField_h_of_type_Int = paramBundle.optInt("forbiddenType", 0);
          this.jdField_k_of_type_JavaLangString = paramBundle.optString("forbiddenMsg", getString(2131430473));
          this.p = getString(2131430309, new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
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
          d();
          return true;
        }
      }
      catch (Exception paramBundle)
      {
        QQToast.a(this, 1, getString(2131430292, new Object[] { Integer.valueOf(999) }), 0).b(getTitleBarHeight());
        finish();
        return false;
      }
      int i1 = paramBundle.optInt("recordTimeLimit") * 1000;
      continue;
      label567:
      boolean bool = false;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
    }
    if (!this.jdField_b_of_type_Boolean) {
      f();
    }
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this);
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
  
  protected void doOnNewIntent(Intent paramIntent)
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
  
  protected void doOnStop()
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
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aikt(this), 200L);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aiku(this), 500L);
  }
  
  protected void f()
  {
    int i2 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "reply save key = " + this.jdField_j_of_type_JavaLangString);
    }
    if (android.text.TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {}
    for (;;)
    {
      return;
      TroopBarUtils.PublishDataCacheEntity localPublishDataCacheEntity = new TroopBarUtils.PublishDataCacheEntity();
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
        localPublishDataCacheEntity.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
      {
        localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = new TroopBarPOI(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        if (this.jdField_b_of_type_JavaUtilArrayList != null)
        {
          localArrayList = new ArrayList();
          i1 = i2;
          while (i1 < this.jdField_b_of_type_JavaUtilArrayList.size())
          {
            localArrayList.add(new TroopBarPOI((TroopBarPOI)this.jdField_b_of_type_JavaUtilArrayList.get(i1)));
            i1 += 1;
          }
          localPublishDataCacheEntity.jdField_b_of_type_JavaUtilArrayList = localArrayList;
        }
      }
      localPublishDataCacheEntity.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      localPublishDataCacheEntity.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
      localPublishDataCacheEntity.jdField_b_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
      localPublishDataCacheEntity.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {}
      try
      {
        localPublishDataCacheEntity.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = ((AudioInfo)this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.clone());
        TroopBarUtils.b.put(this.jdField_j_of_type_JavaLangString, localPublishDataCacheEntity);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopBar", 2, "reply save key = " + this.jdField_j_of_type_JavaLangString + ", data = " + localPublishDataCacheEntity);
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
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    }
    overridePendingTransition(0, 2131034122);
    if (((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_AndroidWidgetEditText.length() > 0)) || ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))) {}
    for (String str = "0";; str = "1")
    {
      if (this.jdField_k_of_type_Boolean) {
        TroopBarUtils.a("reply_page", "un", this.o, str, "", "");
      }
      return;
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 9)
    {
      QQToast.a(this, getString(2131430333, new Object[] { Integer.valueOf(9) }), 0).a();
      return;
    }
    TroopBarPublishUtils.a(this, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 9)
    {
      QQToast.a(this, getString(2131430333, new Object[] { Integer.valueOf(9) }), 0).a();
      return;
    }
    this.jdField_a_of_type_AndroidNetUri = TroopBarPublishUtils.a(this);
  }
  
  protected void i()
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
        e();
        return;
      } while ((this.jdField_f_of_type_Int & 0x1) != 1);
      h();
      return;
    } while ((this.jdField_f_of_type_Int & 0x1) != 1);
    g();
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel = ((TribeHotPicPanel)LayoutInflater.from(this).inflate(2130971596, null));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.a(this.app, this, this);
      this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel, -1, DisplayUtil.a(this, 250.0F));
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.f();
  }
  
  protected void k()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
      this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(false);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.isShown())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTribeHotPicPanel.a(false);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
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
            String str = this.o;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {}
            for (paramView = "0";; paramView = "1")
            {
              TroopBarUtils.a("reply_page", "Clk_place", str, paramView, "", "");
              return;
            }
            if (this.jdField_b_of_type_AndroidWidgetImageButton.isSelected())
            {
              k();
              InputMethodUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
              return;
            }
            this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
            this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(true);
            this.jdField_c_of_type_AndroidWidgetImageButton.setSelected(false);
            InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aikv(this), 200L);
            return;
          } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L);
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
            InputMethodUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
            this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
            this.jdField_c_of_type_AndroidWidgetImageButton.setSelected(false);
            return;
          }
          InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aikw(this), 200L);
          return;
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.c();
          a();
          return;
        } while (!this.jdField_k_of_type_Boolean);
        TroopBarUtils.a("reply_page", "del_photo", this.o, "", "", "");
        return;
      } while (!this.jdField_k_of_type_Boolean);
      TroopBarUtils.a("pub_page", "choose_photo", this.o, "", "", "");
      return;
      if (this.jdField_a_of_type_AndroidWidgetGridView.getVisibility() == 0)
      {
        c(0);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aikx(this), 200L);
        return;
      }
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new aiky(this), 200L);
    } while (!this.jdField_k_of_type_Boolean);
    TroopBarUtils.a(this.jdField_m_of_type_JavaLangString, this.n, "Clk_add", this.o, "", "", "");
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarReplyActivity
 * JD-Core Version:    0.7.0.1
 */