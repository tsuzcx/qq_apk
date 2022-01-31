package cooperation.qzone.share;

import amit;
import amiu;
import amiv;
import amix;
import amiy;
import amiz;
import amja;
import amjb;
import amjc;
import amjd;
import amje;
import amjg;
import amjh;
import amji;
import amjj;
import amjm;
import amjn;
import amjo;
import amjp;
import amjq;
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
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.AgentActivity;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class QZoneShareActivity
  extends IphoneTitleBarActivity
{
  public static final Object a;
  public static final String a;
  public int a;
  public long a;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new amje(this);
  public View a;
  protected InputMethodManager a;
  public EditText a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public ImageView a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  public SystemEmoticonPanel a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public GetAppInfoProto.GetAppinfoResponse a;
  private QZoneShareData jdField_a_of_type_CooperationQzoneQZoneShareData;
  public List a;
  protected mqq.observer.BusinessObserver a;
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
  public boolean e;
  private int jdField_f_of_type_Int = -1;
  private String jdField_f_of_type_JavaLangString;
  protected boolean f;
  private int g;
  public boolean g;
  public boolean h;
  private boolean i = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = QZoneShareActivity.class.getSimpleName();
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public QZoneShareActivity()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_MqqObserverBusinessObserver = new amjb(this);
  }
  
  private int a(CharSequence paramCharSequence, int paramInt)
  {
    return InputViewPanelControl.a(paramCharSequence, paramInt, this.jdField_g_of_type_Int, this.jdField_a_of_type_JavaUtilList, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.jdField_b_of_type_JavaLangString);
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
    if ((paramEditText instanceof QQTextBuilder)) {
      return ((QQTextBuilder)paramEditText).a();
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
    long l = System.currentTimeMillis() / 1000L;
    paramString = AgentActivity.a(this, paramString, l + "");
    if (QLog.isColorLevel()) {
      QLog.d("QZoneShare", 2, "-->sdk_share, getting appinfo in construct. sign: " + paramString);
    }
    Share.a(paramAppInterface, this, paramAppInterface.getCurrentAccountUin(), paramLong, paramString, l, this.jdField_a_of_type_MqqObserverBusinessObserver);
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
    return InputViewPanelControl.a(paramString, paramBoolean, this.jdField_a_of_type_JavaUtilList, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.jdField_b_of_type_JavaLangString);
  }
  
  private void b(QZoneShareData paramQZoneShareData)
  {
    if (paramQZoneShareData.jdField_b_of_type_Long > 0L)
    {
      localHashMap = new HashMap();
      localHashMap.put("url", paramQZoneShareData.jdField_d_of_type_JavaLangString);
      localHashMap.put("time_cost", String.valueOf(System.currentTimeMillis() - paramQZoneShareData.jdField_b_of_type_Long));
      localHashMap.put("time_interval", String.valueOf((System.currentTimeMillis() - paramQZoneShareData.jdField_b_of_type_Long) / 100L));
      if (QLog.isColorLevel()) {
        QLog.d("QZoneShare", 2, "timecost:" + (System.currentTimeMillis() - paramQZoneShareData.jdField_b_of_type_Long));
      }
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_c_of_type_JavaLangString, "qzonesharetimecost", true, 0L, 0L, localHashMap, null, true);
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
        break label340;
      }
      localObject = null;
      this.jdField_e_of_type_JavaLangString = ((String)localObject);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_c_of_type_JavaLangString)) {
        break label354;
      }
      localObject = null;
      label126:
      this.jdField_f_of_type_JavaLangString = ((String)localObject);
      if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)))
      {
        if (!this.jdField_e_of_type_JavaLangString.equals(this.jdField_f_of_type_JavaLangString)) {
          break label368;
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
      this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("qzone_uin");
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        this.jdField_c_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      }
      a(this.jdField_a_of_type_CooperationQzoneQZoneShareData);
      b(this.jdField_a_of_type_CooperationQzoneQZoneShareData);
      if ((this.app != null) && (this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_Long > 0L) && (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationQzoneQZoneShareData.i))) {
        a(this.app, this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_Long, this.jdField_a_of_type_CooperationQzoneQZoneShareData.i);
      }
      return;
      label340:
      localObject = this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_b_of_type_JavaLangString.trim();
      break;
      label354:
      localObject = this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_c_of_type_JavaLangString.trim();
      break label126;
      label368:
      if (this.jdField_e_of_type_JavaLangString.length() > 20)
      {
        localObject = this.jdField_e_of_type_JavaLangString.substring(0, 20);
        if (this.jdField_f_of_type_JavaLangString.startsWith((String)localObject)) {
          this.jdField_f_of_type_JavaLangString = null;
        }
      }
    }
  }
  
  private void m()
  {
    setContentView(2130971037);
    setLeftButton(2131432891, new amjg(this));
    setRightButton(2131432892, new amji(this));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131372846));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131372847));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131373496));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131373497));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373499));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373500));
    a();
    this.jdField_b_of_type_AndroidViewView = findViewById(2131373503);
    c();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373502));
    e();
    d();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373504));
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void n()
  {
    Object localObject1 = getResources().getColorStateList(2131493893);
    Object localObject2 = getResources().getColorStateList(2131493896);
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (this.jdField_a_of_type_CooperationQzoneQZoneShareData != null))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_d_of_type_JavaLangString);
        if (localObject1 != null) {
          this.jdField_c_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(2);
        label104:
        localObject1 = getResources().getDrawable(2130844381);
        if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
          break label470;
        }
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
        if (!a(this.jdField_d_of_type_JavaLangString)) {
          break label449;
        }
      }
    }
    label449:
    for (localObject1 = URLDrawable.getDrawable(this.jdField_d_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);; localObject1 = URLDrawable.getDrawable(new File(this.jdField_d_of_type_JavaLangString), (URLDrawable.URLDrawableOptions)localObject2))
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
      break;
      if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_e_of_type_JavaLangString);
        if (localObject1 != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
        break label104;
      }
      int j = ViewUtils.a();
      int k = ViewUtils.b(24.0F);
      int m = ViewUtils.b(24.0F);
      int n = ViewUtils.b(80.0F);
      if (a(this.jdField_e_of_type_JavaLangString, 14, j - k - m - n) > 1)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_e_of_type_JavaLangString);
        if (localObject1 != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
        break label104;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (localObject1 != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      if (localObject1 != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject2);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_e_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
      this.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(1);
      break label104;
    }
    label470:
    this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable((Drawable)localObject1);
  }
  
  private void o()
  {
    if (!NetworkUtil.d(this))
    {
      QRUtils.a(1, 2131434794);
      return;
    }
    ThreadManager.postImmediately(new amjj(this), null, true);
  }
  
  private void p()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = -1;
    this.jdField_f_of_type_Int = -1;
  }
  
  private void q()
  {
    int k = 0;
    int m = 1;
    Object localObject2 = null;
    for (;;)
    {
      int j;
      String str3;
      String str4;
      try
      {
        if (this.jdField_a_of_type_CooperationQzoneQZoneShareData == null) {
          this.jdField_a_of_type_CooperationQzoneQZoneShareData = new QZoneShareData();
        }
        j = this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_b_of_type_Int;
        if (j != 2) {
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
        int n = LocalMultiProcConfig.getInt("msharefrom", -1);
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
          j = k;
          if (!TextUtils.isEmpty(str3))
          {
            j = k;
            if (!str3.equals(this.jdField_e_of_type_JavaLangString))
            {
              this.jdField_e_of_type_JavaLangString = str3;
              this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_b_of_type_JavaLangString = str3;
              j = 1;
            }
          }
          k = j;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            k = j;
            if (!((String)localObject2).equals(this.jdField_f_of_type_JavaLangString))
            {
              this.jdField_f_of_type_JavaLangString = ((String)localObject2);
              this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_c_of_type_JavaLangString = ((String)localObject2);
              k = 1;
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
          j = m;
          if ((!TextUtils.isEmpty(str5)) && (!str5.equals(this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_d_of_type_JavaLangString))) {
            this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_d_of_type_JavaLangString = str5;
          }
          if (j == 0) {
            continue;
          }
          this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_a_of_type_Int = n;
          ThreadManager.getUIHandler().post(new amjh(this));
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
        j = m;
        continue;
        label453:
        j = k;
        continue;
      }
      label458:
      localObject2 = str2;
    }
  }
  
  public int a()
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
  
  public final String a()
  {
    return InputViewPanelControl.a(this.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_JavaUtilList);
  }
  
  protected final void a()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QzoneTextBuilder.b);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = InputViewPanelControl.a(this, this.jdField_a_of_type_AndroidWidgetEditText);
      b();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new amjc(this, paramInt));
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    a(paramIntent.getParcelableArrayListExtra("result_set"));
  }
  
  public final void a(Activity paramActivity, QZoneShareData paramQZoneShareData)
  {
    paramQZoneShareData = new amiz(this, paramActivity, paramQZoneShareData);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(paramActivity, 230);
    localQQCustomDialog.setMessage(2131430008);
    localQQCustomDialog.setTitle(2131430142);
    localQQCustomDialog.setNegativeButton(2131432998, paramQZoneShareData);
    localQQCustomDialog.setPositiveButton(2131430010, paramQZoneShareData);
    localQQCustomDialog.setCancelable(false);
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {}
    try
    {
      localQQCustomDialog.show();
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
      localObject = new amiy(this, str, paramQZoneShareData);
      localObject = QZoneShareManager.a(BaseApplicationImpl.getApplication().getRuntime(), String.valueOf(paramQZoneShareData.jdField_a_of_type_Long), (com.tencent.mobileqq.app.BusinessObserver)localObject);
    } while ((localObject == null) || (((OpenID)localObject).openID == null) || (((OpenID)localObject).openID.equals(str)));
    a(this, paramQZoneShareData);
  }
  
  protected void a(ArrayList paramArrayList)
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return;
    }
    if (this.jdField_g_of_type_Boolean)
    {
      int j = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      Editable localEditable = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText();
      if ((localEditable != null) && (!TextUtils.isEmpty(localEditable.toString())) && (localEditable.toString().substring(j - 1, j).equals("@"))) {
        localEditable.delete(j - 1, j);
      }
      this.jdField_g_of_type_Boolean = false;
    }
    this.jdField_g_of_type_Int = InputViewPanelControl.a(this.jdField_a_of_type_AndroidWidgetEditText, paramArrayList, this.jdField_a_of_type_JavaUtilList, this.jdField_g_of_type_Int);
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
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845143);
    return true;
  }
  
  public boolean a(AppInterface paramAppInterface, long paramLong, String paramString)
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
            a(2131430139);
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
        long l = System.currentTimeMillis() / 1000L;
        paramString = AgentActivity.a(this, paramString, l + "");
        if (QLog.isColorLevel()) {
          QLog.d("QZoneShare", 2, "-->sdk_share, checkAppinfoLocked, sign: " + paramString + ", appinfo is null.");
        }
        a(2131430139);
        Share.a(paramAppInterface, this, paramAppInterface.getCurrentAccountUin(), paramLong, paramString, l, this.jdField_a_of_type_MqqObserverBusinessObserver);
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
    int j = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.ret.get();
    if ((j == 110507) || (j == 110401))
    {
      ThreadManager.getUIHandler().post(new amja(this));
      if (QLog.isColorLevel()) {
        QLog.d("QZoneShare", 2, "-->sdk_share, response ret: " + j + " and show result dialog.");
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
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130971159, null);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams2.addRule(10);
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView, localLayoutParams2);
      localLayoutParams2 = new RelativeLayout.LayoutParams(-1, 2);
      localLayoutParams2.addRule(3, this.jdField_c_of_type_AndroidViewView.getId());
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130971099, null);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams2);
      localLayoutParams2 = new RelativeLayout.LayoutParams(-1, (int)(150.0F * ViewUtils.a()));
      localLayoutParams2.addRule(3, this.jdField_a_of_type_AndroidViewView.getId());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel, localLayoutParams2);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setBackgroundColor(getResources().getColor(2131493861));
      ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams1);
      this.jdField_b_of_type_Int = ((RelativeLayout)localObject).getHeight();
      ((RelativeLayout)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new amjm(this, (RelativeLayout)localObject));
    }
  }
  
  protected boolean b()
  {
    return a(false);
  }
  
  protected void c()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new amjn(this));
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new amjo(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new amjp(this));
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
  
  protected boolean doOnCreate(Bundle paramBundle)
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
    m();
    l();
    n();
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
  
  protected void doOnPause()
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
  
  protected void doOnResume()
  {
    super.doOnResume();
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.qq.shareupdate");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    if (!this.jdField_a_of_type_Boolean)
    {
      ThreadManager.postImmediately(new amit(this), null, true);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidWidgetEditText != null))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      ThreadManager.getUIHandler().postDelayed(new amix(this), 300L);
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new amjq(this));
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
    ThreadManager.getUIHandler().postDelayed(new amiu(this), 100L);
  }
  
  public void g()
  {
    a(true);
  }
  
  public void h()
  {
    if (!this.i) {}
    while ((this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) || (this.jdField_a_of_type_AndroidWidgetEditText == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 2);
    this.jdField_f_of_type_Boolean = false;
  }
  
  public void i()
  {
    ThreadManager.postImmediately(new amiv(this), null, true);
  }
  
  public void j()
  {
    g();
    if (this.jdField_a_of_type_CooperationQzoneQZoneShareData.jdField_b_of_type_Int == 1) {
      a(this, this.jdField_a_of_type_CooperationQzoneQZoneShareData, false);
    }
    setResult(0, new Intent());
    finish();
  }
  
  public void k()
  {
    ThreadManager.getUIHandler().post(new amjd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity
 * JD-Core Version:    0.7.0.1
 */