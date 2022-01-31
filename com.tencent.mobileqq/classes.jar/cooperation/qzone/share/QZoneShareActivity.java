package cooperation.qzone.share;

import alpg;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import azri;
import bamz;
import bane;
import bdgm;
import bdin;
import bdjz;
import bdnn;
import bdoo;
import bety;
import bjdt;
import bjev;
import bjrh;
import bjri;
import bjrk;
import bjrl;
import bjrm;
import bjrn;
import bjro;
import bjrp;
import bjrq;
import bjrr;
import bjrs;
import bjru;
import bjrv;
import bjrw;
import bjrx;
import bjvb;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.open.agent.AgentActivity;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneShareData;
import eipc.EIPCClient;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import ybk;
import zfy;

public class QZoneShareActivity
  extends IphoneTitleBarActivity
{
  public static final Object a;
  public static final String a;
  public int a;
  public long a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bjrr(this);
  protected View a;
  protected InputMethodManager a;
  public EditText a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  protected ImageView a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  protected TextView a;
  private bety jdField_a_of_type_Bety;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  protected SystemEmoticonPanel a;
  public GetAppInfoProto.GetAppinfoResponse a;
  private QZoneShareData jdField_a_of_type_CooperationQzoneQZoneShareData;
  public List<bjrh> a;
  protected BusinessObserver a;
  public boolean a;
  private int jdField_b_of_type_Int;
  protected View b;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "";
  public boolean b;
  private int jdField_c_of_type_Int = 1;
  public View c;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  public boolean c;
  private int jdField_d_of_type_Int = 1;
  private String jdField_d_of_type_JavaLangString;
  public boolean d;
  private int jdField_e_of_type_Int = -1;
  private String jdField_e_of_type_JavaLangString;
  protected boolean e;
  private int jdField_f_of_type_Int = -1;
  private String jdField_f_of_type_JavaLangString;
  protected boolean f;
  private int g;
  public boolean g;
  public boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = QZoneShareActivity.class.getSimpleName();
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public QZoneShareActivity()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_MqqObserverBusinessObserver = new bjrp(this);
  }
  
  private int a(CharSequence paramCharSequence, int paramInt)
  {
    return bjri.a(paramCharSequence, paramInt, this.jdField_g_of_type_Int, this.jdField_a_of_type_JavaUtilList, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.jdField_b_of_type_JavaLangString);
  }
  
  private int a(String paramString, int paramInt1, int paramInt2)
  {
    TextView localTextView = new TextView(BaseApplication.getContext());
    localTextView.setText(paramString);
    localTextView.setTextSize(2, paramInt1);
    localTextView.setMaxLines(2);
    localTextView.measure(View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
    return localTextView.getLineCount();
  }
  
  public static String a(EditText paramEditText)
  {
    if (paramEditText == null) {
      return "";
    }
    paramEditText = paramEditText.getText();
    if ((paramEditText instanceof bamz)) {
      return ((bamz)paramEditText).a();
    }
    return paramEditText.toString();
  }
  
  public static String a(String paramString)
  {
    paramString = new StringTokenizer(paramString.toString().replace("\r\n", " ").replace("\n", " "), " ");
    StringBuffer localStringBuffer = new StringBuffer();
    while (paramString.hasMoreTokens()) {
      localStringBuffer.append(paramString.nextToken() + ' ');
    }
    return localStringBuffer.toString().trim();
  }
  
  private void a(Activity paramActivity, QZoneShareData paramQZoneShareData, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramQZoneShareData == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramQZoneShareData.h)) {
      paramQZoneShareData.h = "shareToQzone";
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "sdk_share:sdk callback=" + paramBoolean + " appid=" + paramQZoneShareData.jdField_a_of_type_Long + " action=" + paramQZoneShareData.h);
    }
    Intent localIntent = new Intent();
    if (paramBoolean) {
      localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(paramQZoneShareData.jdField_a_of_type_Long), paramQZoneShareData.h })));
    }
    for (;;)
    {
      localIntent.setPackage(paramQZoneShareData.i);
      bjdt.c(localIntent);
      try
      {
        paramActivity.startActivity(localIntent);
        return;
      }
      catch (ActivityNotFoundException paramActivity)
      {
        QLog.e("QZoneShare", 1, paramActivity.getStackTrace());
        return;
      }
      localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(paramQZoneShareData.jdField_a_of_type_Long), paramQZoneShareData.h })));
    }
  }
  
  private void a(AppInterface paramAppInterface, long paramLong, String paramString)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.h = true;
    long l1 = System.currentTimeMillis() / 1000L;
    String str = AgentActivity.a(this, paramString, l1 + "");
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "-->sdk_share, getting appinfo in construct. sign: " + str);
    }
    zfy.a(paramAppInterface, this, paramAppInterface.getCurrentAccountUin(), paramLong, str, l1, this.jdField_a_of_type_MqqObserverBusinessObserver, paramString);
  }
  
  public static final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
      return false;
    }
    return true;
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    return bjri.a(paramString, paramBoolean, this.jdField_a_of_type_JavaUtilList, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.jdField_b_of_type_JavaLangString);
  }
  
  private void b(QZoneShareData paramQZoneShareData)
  {
    if ((paramQZoneShareData != null) && (paramQZoneShareData.jdField_b_of_type_Long > 0L))
    {
      localHashMap = new HashMap();
      localHashMap.put("url", paramQZoneShareData.jdField_d_of_type_JavaLangString);
      localHashMap.put("time_cost", String.valueOf(System.currentTimeMillis() - paramQZoneShareData.jdField_b_of_type_Long));
      localHashMap.put("time_interval", String.valueOf((System.currentTimeMillis() - paramQZoneShareData.jdField_b_of_type_Long) / 100L));
      if (QLog.isColorLevel()) {
        QLog.d("QZoneShare", 2, "timecost:" + (System.currentTimeMillis() - paramQZoneShareData.jdField_b_of_type_Long));
      }
      azri.a(BaseApplication.getContext()).a(this.jdField_c_of_type_JavaLangString, "qzonesharetimecost", true, 0L, 0L, localHashMap, null, true);
    }
    while (!QLog.isColorLevel())
    {
      HashMap localHashMap;
      return;
    }
    QLog.d("QZoneShare", 2, "timecost: -1");
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_f_of_type_Boolean) && (!paramBoolean))
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void l()
  {
    Intent localIntent = getIntent();
    this.jdField_a_of_type_CooperationQzoneQZoneShareData = ((QZoneShareData)localIntent.getParcelableExtra("extraIntentKeyParcelable"));
    this.i = localIntent.getBooleanExtra("isSharedFromMiniProgram", false);
    this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("qzone_uin");
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_c_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    }
    if (this.i)
    {
      a(2131720065);
      boolean bool = localIntent.getBooleanExtra("isSharedFromThirdParty", false);
      String str1 = localIntent.getStringExtra("miniShareParamAppId");
      String str2 = localIntent.getStringExtra("miniShareParamTitle");
      String str3 = localIntent.getStringExtra("miniShareParamDescription");
      int m = localIntent.getIntExtra("miniShareParamShareScene", 1);
      int n = localIntent.getIntExtra("miniShareParamTemplateType", 1);
      int i1 = localIntent.getIntExtra("miniShareParamBusinessType", 0);
      String str4 = localIntent.getStringExtra("miniShareParamPicUrl");
      String str5 = localIntent.getStringExtra("miniShareParamJumpUrl");
      String str6 = localIntent.getStringExtra("miniShareParamIconUrl");
      int i2 = localIntent.getIntExtra("miniShareParamVersionType", -1);
      String str7 = localIntent.getStringExtra("miniShareParamVersionId");
      String str8 = localIntent.getStringExtra("miniShareAppRichId");
      Object localObject = localIntent.getStringExtra("miniSharePkgName");
      String str9 = localIntent.getStringExtra("miniShareOpenId");
      this.k = localIntent.getBooleanExtra("miniShareIsFromInnerButton", false);
      this.jdField_a_of_type_CooperationQzoneQZoneShareData = new QZoneShareData();
      this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_b_of_type_JavaLangString = str2;
      if (str8 != null) {}
      try
      {
        this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_Long = Long.parseLong(str8);
        this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_JavaLangString = str9;
        this.jdField_a_of_type_CooperationQzoneQZoneShareData.i = ((String)localObject);
        this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_c_of_type_JavaLangString = str3;
        this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        if (!bdnn.a(str4))
        {
          this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_JavaUtilArrayList.add(str4);
          if (bool) {
            this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_b_of_type_Int = 1;
          }
          this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_JavaUtilMap = new HashMap();
          this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_JavaUtilMap.put("xcxPath", str5);
          this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_JavaUtilMap.put("xcxAppId", str1);
          this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_JavaUtilMap.put("xcxSourceType", String.valueOf(i1));
          localObject = new bjrs(this);
          if (!TextUtils.isEmpty(str6)) {
            break label532;
          }
          MiniAppCmdUtil.getInstance().getAppInfoById(null, str1, str5, String.valueOf(i2), new bjru(this, str2, str3, str1, m, n, i1, str4, str5, i2, str8, (MiniAppCmdInterface)localObject));
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("QZoneShare", 1, "Long.parseLong(appRichId) get an Exception", localNumberFormatException);
          continue;
          if (!bdnn.a(str6)) {
            this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_JavaUtilArrayList.add(str6);
          }
        }
        label532:
        MiniProgramShareUtils.shareAsQzoneFeeds(str1, str2, str3, m, n, i1, str4, null, str5, str6, i2, str7, str8, (MiniAppCmdInterface)localObject);
        return;
      }
    }
    o();
  }
  
  private void m()
  {
    Bundle localBundle;
    if (this.i)
    {
      localBundle = new Bundle();
      localBundle.putString("key_mini_report_event_action_type", "user_click");
      if (!this.k) {
        break label104;
      }
      localBundle.putString("key_mini_report_event_sub_action_type", "custom_button");
    }
    for (;;)
    {
      localBundle.putString("key_mini_report_event_reserves", "share_QZ");
      localBundle.putString("key_mini_report_event_reserves2", "success");
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_report_event", localBundle, null);
      if (this.j) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
      }
      return;
      label104:
      localBundle.putString("key_mini_report_event_sub_action_type", "more_button");
    }
  }
  
  private void n()
  {
    Bundle localBundle;
    if (this.i)
    {
      localBundle = new Bundle();
      localBundle.putString("key_mini_report_event_action_type", "user_click");
      if (!this.k) {
        break label104;
      }
      localBundle.putString("key_mini_report_event_sub_action_type", "custom_button");
    }
    for (;;)
    {
      localBundle.putString("key_mini_report_event_reserves", "share_QZ");
      localBundle.putString("key_mini_report_event_reserves2", "fail");
      QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_report_event", localBundle, null);
      if (this.j) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_fail", null, null);
      }
      return;
      label104:
      localBundle.putString("key_mini_report_event_sub_action_type", "more_button");
    }
  }
  
  private void o()
  {
    Object localObject;
    if (this.jdField_a_of_type_CooperationQzoneQZoneShareData != null)
    {
      if ((this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localObject = this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (!TextUtils.isEmpty(str)) {
            this.jdField_d_of_type_JavaLangString = str;
          }
        }
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_b_of_type_JavaLangString)) {
        break label294;
      }
      localObject = null;
      this.jdField_e_of_type_JavaLangString = ((String)localObject);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_c_of_type_JavaLangString)) {
        break label308;
      }
      localObject = null;
      label107:
      this.jdField_f_of_type_JavaLangString = ((String)localObject);
      if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)))
      {
        if (!this.jdField_e_of_type_JavaLangString.equals(this.jdField_f_of_type_JavaLangString)) {
          break label322;
        }
        this.jdField_f_of_type_JavaLangString = null;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneShare", 2, "params: " + this.jdField_a_of_type_CooperationQzoneQZoneShareData.toString());
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationQzoneQZoneShareData.l)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_CooperationQzoneQZoneShareData.l);
      }
      a(this.jdField_a_of_type_CooperationQzoneQZoneShareData);
      b(this.jdField_a_of_type_CooperationQzoneQZoneShareData);
      if ((this.app != null) && (this.jdField_a_of_type_CooperationQzoneQZoneShareData != null) && (this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_Long > 0L) && (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationQzoneQZoneShareData.i))) {
        a(this.app, this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_Long, this.jdField_a_of_type_CooperationQzoneQZoneShareData.i);
      }
      return;
      label294:
      localObject = this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_b_of_type_JavaLangString.trim();
      break;
      label308:
      localObject = this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_c_of_type_JavaLangString.trim();
      break label107;
      label322:
      if (this.jdField_e_of_type_JavaLangString.length() > 20)
      {
        localObject = this.jdField_e_of_type_JavaLangString.substring(0, 20);
        if (this.jdField_f_of_type_JavaLangString.startsWith((String)localObject)) {
          this.jdField_f_of_type_JavaLangString = null;
        }
      }
    }
  }
  
  private void p()
  {
    setContentView(2131561932);
    setRightButton(2131718600, new bjrv(this));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131374695));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366772));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131366774));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131366777));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366786));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366782));
    a();
    this.jdField_b_of_type_AndroidViewView = findViewById(2131374221);
    c();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374254));
    e();
    d();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366784));
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void q()
  {
    Object localObject = getResources().getColorStateList(2131165193);
    ColorStateList localColorStateList = getResources().getColorStateList(2131165195);
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (this.jdField_a_of_type_CooperationQzoneQZoneShareData != null))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_d_of_type_JavaLangString);
        if (localObject != null) {
          this.jdField_c_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject);
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(2);
      }
    }
    for (;;)
    {
      localObject = getResources().getDrawable(2130847368);
      this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable((Drawable)localObject);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
      break;
      if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        r();
        if (localObject != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject);
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
      }
      else
      {
        int m = bdoo.a();
        int n = bdoo.b(24.0F);
        int i1 = bdoo.b(24.0F);
        int i2 = bdoo.b(80.0F);
        if (a(this.jdField_e_of_type_JavaLangString, 14, m - n - i1 - i2) > 1)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          r();
          if (localObject != null) {
            this.jdField_b_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject);
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          if (localObject != null) {
            this.jdField_b_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject);
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          if (localObject != null) {
            this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(localColorStateList);
          }
          r();
          this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
          this.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(1);
        }
      }
    }
  }
  
  private void r()
  {
    String str2 = this.jdField_e_of_type_JavaLangString;
    String str1 = str2;
    if (str2 != null) {
      str1 = this.jdField_e_of_type_JavaLangString.replace("[em]e10086[/em]", "");
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(str1);
  }
  
  private void s()
  {
    Object localObject = getResources().getDrawable(2130847368);
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mRequestHeight = bdoo.b(70.0F);
      localURLDrawableOptions.mRequestWidth = bdoo.b(70.0F);
      if (a(this.jdField_d_of_type_JavaLangString)) {}
      for (localObject = URLDrawable.getDrawable(this.jdField_d_of_type_JavaLangString, localURLDrawableOptions);; localObject = URLDrawable.getDrawable(new File(this.jdField_d_of_type_JavaLangString), localURLDrawableOptions))
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable((Drawable)localObject);
  }
  
  private void t()
  {
    m();
    if (!bdin.d(this))
    {
      ybk.a(1, 2131694768);
      return;
    }
    ThreadManager.postImmediately(new QZoneShareActivity.7(this), null, true);
  }
  
  private void u()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = -1;
    this.jdField_f_of_type_Int = -1;
  }
  
  private void v()
  {
    int n = 0;
    int i1 = 1;
    Object localObject2 = null;
    for (;;)
    {
      int m;
      String str3;
      String str4;
      try
      {
        if (this.jdField_a_of_type_CooperationQzoneQZoneShareData == null) {
          this.jdField_a_of_type_CooperationQzoneQZoneShareData = new QZoneShareData();
        }
        m = this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_b_of_type_Int;
        if (m != 2) {
          return;
        }
        String str1 = LocalMultiProcConfig.getString("msharecururl", "");
        if ((TextUtils.isEmpty(str1)) || (!str1.equals(this.jdField_a_of_type_CooperationQzoneQZoneShareData.m))) {
          continue;
        }
        str3 = LocalMultiProcConfig.getString("msharetitle", "");
        str1 = LocalMultiProcConfig.getString("msharedesc", "");
        str4 = LocalMultiProcConfig.getString("msharethumb", "");
        String str5 = LocalMultiProcConfig.getString("mshareurl", "");
        int i2 = LocalMultiProcConfig.getInt("msharefrom", -1);
        if (TextUtils.isEmpty(str3))
        {
          str3 = null;
          if (!TextUtils.isEmpty(str1)) {
            break label396;
          }
          str1 = null;
          if ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str1))) {
            break label458;
          }
          if (!str3.equals(str1)) {
            break label406;
          }
          m = n;
          if (!TextUtils.isEmpty(str3))
          {
            m = n;
            if (!str3.equals(this.jdField_e_of_type_JavaLangString))
            {
              this.jdField_e_of_type_JavaLangString = str3;
              this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_b_of_type_JavaLangString = str3;
              m = 1;
            }
          }
          n = m;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            n = m;
            if (!((String)localObject2).equals(this.jdField_f_of_type_JavaLangString))
            {
              this.jdField_f_of_type_JavaLangString = ((String)localObject2);
              this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_c_of_type_JavaLangString = ((String)localObject2);
              n = 1;
            }
          }
          if ((TextUtils.isEmpty(str4)) || (str4.equals(this.jdField_d_of_type_JavaLangString))) {
            break label453;
          }
          this.jdField_d_of_type_JavaLangString = str4;
          if (this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_JavaUtilArrayList == null) {
            break label435;
          }
          this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_JavaUtilArrayList.add(str4);
          m = i1;
          if ((!TextUtils.isEmpty(str5)) && (!str5.equals(this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_d_of_type_JavaLangString))) {
            this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_d_of_type_JavaLangString = str5;
          }
          if (m == 0) {
            continue;
          }
          this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_Int = i2;
          ThreadManager.getUIHandler().post(new QZoneShareActivity.23(this));
          continue;
        }
        str3 = str3.trim();
      }
      finally {}
      continue;
      label396:
      String str2 = localObject1.trim();
      continue;
      label406:
      if (str3.length() > 20)
      {
        if (str2.startsWith(str3.substring(0, 20))) {
          continue;
        }
        break label458;
        label435:
        new ArrayList().add(str4);
        m = i1;
        continue;
        label453:
        m = n;
        continue;
      }
      label458:
      localObject2 = str2;
    }
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_Int > 0) {
      return this.jdField_a_of_type_Int;
    }
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "maxUgcTextCount", 2000);
  }
  
  protected View a()
  {
    return this.jdField_b_of_type_AndroidWidgetRelativeLayout;
  }
  
  protected final String a()
  {
    return bjri.a(this.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_JavaUtilList);
  }
  
  protected final void a()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(bane.c);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = bjri.a(this, this.jdField_a_of_type_AndroidWidgetEditText);
      b();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new QZoneShareActivity.20(this, paramInt));
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    a(paramIntent.getParcelableArrayListExtra("result_set"));
  }
  
  public final void a(Activity paramActivity, QZoneShareData paramQZoneShareData)
  {
    paramQZoneShareData = new bjro(this, paramActivity, paramQZoneShareData);
    bdjz localbdjz = bdgm.a(paramActivity, 230);
    localbdjz.setMessage(2131695722);
    localbdjz.setTitle(2131692311);
    localbdjz.setNegativeButton(2131690648, paramQZoneShareData);
    localbdjz.setPositiveButton(2131719931, paramQZoneShareData);
    localbdjz.setCancelable(false);
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {}
    try
    {
      localbdjz.show();
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("QZoneShare", 1, paramActivity.toString());
    }
  }
  
  public void a(QZoneShareData paramQZoneShareData)
  {
    if (paramQZoneShareData == null) {}
    label4:
    Object localObject;
    String str;
    do
    {
      do
      {
        do
        {
          break label4;
          do
          {
            return;
          } while ((paramQZoneShareData.jdField_b_of_type_Int != 1) || ("login".equals(paramQZoneShareData.j)));
          localObject = paramQZoneShareData.jdField_f_of_type_JavaLangString;
          str = paramQZoneShareData.jdField_a_of_type_JavaLangString;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
        } while (((String)localObject).equals(this.jdField_c_of_type_JavaLangString));
        a(this, paramQZoneShareData);
        return;
      } while (TextUtils.isEmpty(str));
      localObject = new bjrn(this, str, paramQZoneShareData);
      localObject = bjev.a(BaseApplicationImpl.getApplication().getRuntime(), String.valueOf(paramQZoneShareData.jdField_a_of_type_Long), (alpg)localObject);
    } while ((localObject == null) || (((OpenID)localObject).openID == null) || (((OpenID)localObject).openID.equals(str)));
    a(this, paramQZoneShareData);
  }
  
  protected void a(ArrayList<ResultRecord> paramArrayList)
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return;
    }
    if (this.jdField_g_of_type_Boolean)
    {
      int m = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      Editable localEditable = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText();
      if ((localEditable != null) && (!TextUtils.isEmpty(localEditable.toString())) && (localEditable.toString().substring(m - 1, m).equals("@"))) {
        localEditable.delete(m - 1, m);
      }
      this.jdField_g_of_type_Boolean = false;
    }
    this.jdField_g_of_type_Int = bjri.a(this.jdField_a_of_type_AndroidWidgetEditText, paramArrayList, this.jdField_a_of_type_JavaUtilList, this.jdField_g_of_type_Int);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return;
    }
    a(paramBoolean);
    a();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel == null) || (this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {}
    while (!this.jdField_d_of_type_Boolean) {
      return false;
    }
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    b(this.jdField_d_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848571);
    return true;
  }
  
  protected boolean a(AppInterface paramAppInterface, long paramLong, String paramString)
  {
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.h)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QZoneShare", 2, "-->sdk_share, checkAppinfoLocked, getappinfo already executing...");
          }
          try
          {
            a(2131692315);
            jdField_a_of_type_JavaLangObject.wait(5000L);
            if (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QZoneShare", 2, "-->sdk_share, response is null and show result dialog.");
            }
            k();
            return true;
          }
          catch (InterruptedException paramAppInterface)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("QZoneShare", 2, "check app info locked ex", paramAppInterface);
            continue;
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse == null)
      {
        this.h = true;
        long l1 = System.currentTimeMillis() / 1000L;
        String str = AgentActivity.a(this, paramString, l1 + "");
        if (QLog.isColorLevel()) {
          QLog.d("QZoneShare", 2, "-->sdk_share, checkAppinfoLocked, sign: " + str + ", appinfo is null.");
        }
        a(2131692315);
        zfy.a(paramAppInterface, this, paramAppInterface.getCurrentAccountUin(), paramLong, str, l1, this.jdField_a_of_type_MqqObserverBusinessObserver, paramString);
        try
        {
          jdField_a_of_type_JavaLangObject.wait(5000L);
        }
        catch (InterruptedException paramAppInterface) {}
        if (QLog.isColorLevel()) {
          QLog.e("QZoneShare", 2, "check app info locked ex", paramAppInterface);
        }
      }
    }
    int m = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.ret.get();
    if ((m == 110507) || (m == 110401))
    {
      ThreadManager.getUIHandler().post(new QZoneShareActivity.18(this));
      if (QLog.isColorLevel()) {
        QLog.d("QZoneShare", 2, "-->sdk_share, response ret: " + m + " and show result dialog.");
      }
      k();
      return false;
    }
    k();
    return true;
  }
  
  protected boolean a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) || (this.jdField_a_of_type_AndroidWidgetEditText == null)) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      }
      this.jdField_f_of_type_Boolean = true;
      return true;
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      return a(a(this.jdField_a_of_type_AndroidWidgetEditText)).length();
    }
    return 0;
  }
  
  protected void b()
  {
    Object localObject = a();
    if ((localObject instanceof RelativeLayout))
    {
      localObject = (RelativeLayout)localObject;
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams1.addRule(12);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this);
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131562125, null);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams2.addRule(10);
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView, localLayoutParams2);
      localLayoutParams2 = new RelativeLayout.LayoutParams(-1, 2);
      localLayoutParams2.addRule(3, this.jdField_c_of_type_AndroidViewView.getId());
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131562019, null);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams2);
      localLayoutParams2 = new RelativeLayout.LayoutParams(-1, (int)(150.0F * bdoo.a()));
      localLayoutParams2.addRule(3, this.jdField_a_of_type_AndroidViewView.getId());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel, localLayoutParams2);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setBackgroundColor(getResources().getColor(2131166568));
      ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams1);
      this.jdField_b_of_type_Int = ((RelativeLayout)localObject).getHeight();
      ((RelativeLayout)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new bjrw(this, (RelativeLayout)localObject));
    }
  }
  
  protected boolean b()
  {
    return a(true);
  }
  
  protected void c()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new bjrx(this));
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new bjrk(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new bjrl(this));
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0)
    {
      this.jdField_g_of_type_Boolean = false;
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    }
    a(paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "doOnCreate()");
    }
    if (getIntent() == null)
    {
      QLog.e("QZoneShare", 1, "onCreate getIntent is null");
      finish();
    }
    getWindow().setSoftInputMode(3);
    p();
    l();
    q();
    if ((!ImmersiveUtils.c) && (!isInMultiWindow())) {
      getWindow().getDecorView().post(new QZoneShareActivity.1(this));
    }
    if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (!a(this.jdField_d_of_type_JavaLangString)) && (getIntent().getBooleanExtra("key_require_storage_permission", false)))
    {
      if (bjvb.a(this, new bjrq(this), 1)) {
        s();
      }
      return false;
    }
    s();
    return false;
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
      {
        a();
        return true;
      }
      j();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      b();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QZoneShare", 1, localException, new Object[0]);
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.qq.shareupdate");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    if (!this.jdField_a_of_type_Boolean)
    {
      ThreadManager.postImmediately(new QZoneShareActivity.3(this), null, true);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    s();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidWidgetEditText != null))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      ThreadManager.getUIHandler().postDelayed(new QZoneShareActivity.15(this), 300L);
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bjrm(this));
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel == null) || (this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {}
    while (this.jdField_e_of_type_Boolean) {
      return;
    }
    b();
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_e_of_type_Boolean = true;
    ThreadManager.getUIHandler().postDelayed(new QZoneShareActivity.13(this), 100L);
  }
  
  public void finish()
  {
    ForwardRecentActivity.a(getIntent(), this);
    super.finish();
  }
  
  protected void g()
  {
    a(true);
  }
  
  public void h()
  {
    if (!this.l) {}
    while ((this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) || (this.jdField_a_of_type_AndroidWidgetEditText == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 2);
    this.jdField_f_of_type_Boolean = false;
  }
  
  public void i()
  {
    ThreadManager.postImmediately(new QZoneShareActivity.14(this), null, true);
  }
  
  protected void j()
  {
    g();
    if (this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_b_of_type_Int == 1) {
      a(this, this.jdField_a_of_type_CooperationQzoneQZoneShareData, false);
    }
    setResult(0, getIntent());
    onBackEvent();
  }
  
  public void k()
  {
    ThreadManager.getUIHandler().post(new QZoneShareActivity.21(this));
  }
  
  public boolean onBackEvent()
  {
    n();
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity
 * JD-Core Version:    0.7.0.1
 */