package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpay.ui.R.anim;
import com.tencent.mobileqq.qqpay.ui.R.dimen;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.FrameAnimHelper;
import com.tencent.mobileqq.qwallet.hb.IHbThemeConfigApi;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.IRedPacketManager;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.SendHbLogic;
import com.tencent.mobileqq.qwallet.hb.send.view.impl.RollNumberView;
import com.tencent.mobileqq.qwallet.hb.send.view.impl.RollNumberView.OnRollListener;
import com.tencent.mobileqq.qwallet.hb.theme.ThemeRedPkgConfig;
import com.tencent.mobileqq.qwallet.preload.IPreloadImgApi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import java.io.File;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeHbFragment
  extends BaseHbFragment
  implements View.OnClickListener, Animation.AnimationListener, FragmentInterface, RollNumberView.OnRollListener
{
  private long jdField_a_of_type_Long = 0L;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FrameAnimHelper jdField_a_of_type_ComTencentMobileqqQwalletHbFrameAnimHelper;
  private ThemeHbFragment.SendHbHandler jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplThemeHbFragment$SendHbHandler = new ThemeHbFragment.SendHbHandler(this);
  private RollNumberView jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplRollNumberView;
  private ThemeRedPkgConfig jdField_a_of_type_ComTencentMobileqqQwalletHbThemeThemeRedPkgConfig = null;
  public String a;
  public JSONArray a;
  private int[] jdField_a_of_type_ArrayOfInt = null;
  private int jdField_b_of_type_Int = 0;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private JSONArray jdField_b_of_type_OrgJsonJSONArray;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString = "";
  private JSONArray jdField_c_of_type_OrgJsonJSONArray;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 0;
  private View jdField_d_of_type_AndroidViewView;
  private String jdField_d_of_type_JavaLangString;
  private JSONArray jdField_d_of_type_OrgJsonJSONArray;
  private String e = "1";
  private String f;
  
  public ThemeHbFragment()
  {
    this.jdField_a_of_type_JavaLangString = "1";
  }
  
  private int a(double paramDouble)
  {
    if (paramDouble >= 0.0D) {
      try
      {
        if ((64 == this.jdField_a_of_type_Int) && (!TextUtils.isEmpty(this.f)))
        {
          this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplRollNumberView.b(paramDouble);
          String str = QwUtils.a(this.jdField_d_of_type_JavaLangString, this.f);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(getString(R.string.E), new Object[] { this.f, str }));
          this.jdField_d_of_type_JavaLangString = str;
          return 0;
        }
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplRollNumberView.b(paramDouble);
        return 0;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return -1;
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.f = paramBundle.getString("group_count");
    this.jdField_c_of_type_Boolean = paramBundle.getBoolean("isGroupThemeHb");
    try
    {
      a(Integer.valueOf(paramBundle.getString("theme_type")).intValue());
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    if (this.jdField_c_of_type_Boolean)
    {
      paramBundle = this.jdField_c_of_type_AndroidWidgetTextView;
      if (paramBundle != null)
      {
        paramBundle.setText(String.format(getString(R.string.D), new Object[] { this.jdField_a_of_type_JavaLangString }));
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplThemeHbFragment$SendHbHandler.postDelayed(new ThemeHbFragment.1(this), 10L);
  }
  
  private void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    Object localObject = ((IHbThemeConfigApi)QRoute.api(IHbThemeConfigApi.class)).getFaceConfig(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity);
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      try
      {
        paramBundle = new JSONObject("{\"hb_face_desc\":\" 让对方做表情领红包\",\"hb_face_imgurl\":\"\",\"hb_face_money_array\":[\"0.18\",\"1.18\",\"2.18\",\"6.18\",\"8.18\",\"18.00\"]}");
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        paramBundle = (Bundle)localObject;
      }
    }
    if (paramBundle == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.showThemeHbToast(HardCodeUtil.a(R.string.cV));
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.finish();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramBundle.optString("hb_face_desc"));
    localObject = paramBundle.optString("hb_face_imgurl");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((IPreloadImgApi)QRoute.api(IPreloadImgApi.class)).getBitmap(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, (String)localObject);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
    }
    this.jdField_d_of_type_OrgJsonJSONArray = paramBundle.optJSONArray("hb_face_money_array");
    d();
  }
  
  private void b(String paramString)
  {
    c(paramString);
    if ((64 == this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Int == 64) || (this.jdField_a_of_type_Int == 16384))
    {
      paramString = a(-11001, "", "");
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.setResult(-1, paramString);
    }
    if (isAdded())
    {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.cancelCallBack();
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.finish();
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.overridePendingTransition(0, 0);
    }
  }
  
  private boolean b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      int i = (int)this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getResources().getDimension(R.dimen.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbFrameAnimHelper = new FrameAnimHelper(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity, this.jdField_a_of_type_AndroidWidgetLinearLayout, i, true, new ThemeHbFragment.4(this));
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbFrameAnimHelper.a(paramString, true);
      return true;
    }
    return false;
  }
  
  private void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addHbUploadData(paramString);
    }
  }
  
  private void d()
  {
    int j = new Random(System.currentTimeMillis()).nextInt(this.jdField_d_of_type_OrgJsonJSONArray.length());
    int i = j;
    if (j == this.jdField_d_of_type_Int) {
      i = j + 1;
    }
    this.jdField_d_of_type_Int = i;
    if (this.jdField_d_of_type_Int >= this.jdField_d_of_type_OrgJsonJSONArray.length()) {
      i = 0;
    } else {
      i = this.jdField_d_of_type_Int;
    }
    this.jdField_d_of_type_Int = i;
    try
    {
      String str = this.jdField_d_of_type_OrgJsonJSONArray.optString(this.jdField_d_of_type_Int);
      this.jdField_d_of_type_JavaLangString = str;
      float f1 = Float.parseFloat(str);
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplRollNumberView.b(f1);
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplRollNumberView.a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (!isAdded()) {
        return;
      }
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.t);
      int j = 8;
      int i;
      if (localImageView != null)
      {
        if (((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).isCanShowNewCloseBtn(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity)) {
          i = 8;
        } else {
          i = 0;
        }
        localImageView.setVisibility(i);
        localImageView.setOnClickListener(this);
      }
      localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.r);
      if (localImageView != null)
      {
        i = j;
        if (((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).isCanShowNewCloseBtn(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity)) {
          i = 0;
        }
        localImageView.setVisibility(i);
        localImageView.setOnClickListener(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplRollNumberView = ((RollNumberView)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.ck));
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity, R.anim.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.Q));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.Y));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.bU));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.cm));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.jdField_c_of_type_Int));
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(R.id.Z);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(R.id.bn);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(R.id.cl);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.K));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.M));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(R.id.H));
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplRollNumberView.setLisener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    if (64 == this.jdField_a_of_type_Int) {
      this.e = "1";
    }
    if (isAdded()) {
      ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWindowToken(), 0);
    }
  }
  
  private void g()
  {
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (isAdded()))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((IPreloadImgApi)QRoute.api(IPreloadImgApi.class)).getDrawableByTheme(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setImageBgProcess mHbDrawable = ");
        localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        QLog.i("ThemeHbFragment", 2, localStringBuilder.toString());
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ThemeHbFragment", 2, "setImageBgProcess not exist, start download...");
      }
      ((IPreloadImgApi)QRoute.api(IPreloadImgApi.class)).download(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this.jdField_b_of_type_JavaLangString, new ThemeHbFragment.2(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ThemeHbFragment", 2, "theme config bak img error...");
    }
  }
  
  private void h()
  {
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (isAdded()))
    {
      String str = ((IPreloadImgApi)QRoute.api(IPreloadImgApi.class)).getZipFolderPath(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setAnimFrameBgProcess zipName = ");
        localStringBuilder.append(str);
        QLog.i("ThemeHbFragment", 2, localStringBuilder.toString());
      }
      if (b(str)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ThemeHbFragment", 2, "setAnimFrameBgProcess not exist, start download...");
      }
      ((IPreloadImgApi)QRoute.api(IPreloadImgApi.class)).downloadWithSuffix(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this.jdField_b_of_type_JavaLangString, ".zip", new ThemeHbFragment.3(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ThemeHbFragment", 2, "setAnimFrameBgProcess theme config bak img error...");
    }
  }
  
  private void i()
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 2000L) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    for (;;)
    {
      try
      {
        Object localObject1 = this.jdField_c_of_type_OrgJsonJSONArray;
        if ((localObject1 != null) && (this.jdField_b_of_type_Int < this.jdField_c_of_type_OrgJsonJSONArray.length()) && (this.jdField_b_of_type_Int >= 0))
        {
          localObject1 = this.jdField_c_of_type_OrgJsonJSONArray.optString(this.jdField_b_of_type_Int);
          Object localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = getResources().getString(R.string.L);
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getMapPacketExtra();
          ((Map)localObject1).put("total_num", this.jdField_a_of_type_JavaLangString);
          ((Map)localObject1).put("total_amount", QwUtils.a(this.jdField_d_of_type_JavaLangString));
          ((Map)localObject1).put("wishing", localObject2);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbThemeThemeRedPkgConfig.jdField_b_of_type_Int);
          ((StringBuilder)localObject2).append("");
          ((Map)localObject1).put("resource_type", ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject2).append("");
          ((Map)localObject1).put("channel", ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbThemeThemeRedPkgConfig.jdField_a_of_type_Int);
          ((StringBuilder)localObject2).append("");
          ((Map)localObject1).put("type", ((StringBuilder)localObject2).toString());
          ((Map)localObject1).put("bus_type", this.e);
          if (this.jdField_c_of_type_Boolean)
          {
            ((Map)localObject1).put("groupid", this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.mGroupId);
            ((Map)localObject1).put("theme_type", this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.mThemeType);
          }
          this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplSendHbLogic.a((Map)localObject1);
          if (this.jdField_a_of_type_Int != 16384) {
            break label370;
          }
          localObject1 = "bqredpacket.order.send";
          c((String)localObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      String str = "";
      continue;
      label370:
      str = "theme.pack.go";
    }
  }
  
  private void j()
  {
    QLog.i("ThemeHbFragment", 2, "clickFaceAction...");
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.onFaceHbPacket(this.jdField_d_of_type_JavaLangString);
  }
  
  private void k()
  {
    int i;
    int j;
    label282:
    Object localObject2;
    if (this.jdField_c_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_OrgJsonJSONArray != null) && (this.jdField_b_of_type_OrgJsonJSONArray != null))
      {
        Object localObject1 = new Random();
        try
        {
          if (this.jdField_c_of_type_Int > 0) {
            i = a(((Random)localObject1).nextInt(this.jdField_c_of_type_Int));
          } else {
            i = 0;
          }
          try
          {
            this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_OrgJsonJSONArray.optString(i, "1");
            localObject1 = this.jdField_b_of_type_OrgJsonJSONArray.optString(i, "0.1");
            this.jdField_d_of_type_JavaLangString = QwUtils.a(this.jdField_a_of_type_JavaLangString, (String)localObject1);
            this.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_OrgJsonJSONArray.optString(i, getString(R.string.v));
            j = i;
            if (a(new BigDecimal((String)localObject1).doubleValue()) != 0) {
              break label282;
            }
            this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplRollNumberView.a();
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
            if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
              this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(getString(R.string.D), new Object[] { this.jdField_a_of_type_JavaLangString }));
            }
            localObject1 = this.jdField_a_of_type_AndroidWidgetButton;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(getString(R.string.I));
            localStringBuilder.append(" ");
            localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
            localStringBuilder.append(HardCodeUtil.a(R.string.cW));
            ((Button)localObject1).setText(localStringBuilder.toString());
            j = i;
          }
          catch (Exception localException1) {}
          localException2.printStackTrace();
        }
        catch (Exception localException2)
        {
          i = 0;
        }
        j = i;
        localObject2 = this.jdField_a_of_type_ArrayOfInt;
        if ((localObject2 != null) && (localObject2.length > j)) {
          localObject2[j] = 1;
        }
        this.jdField_b_of_type_Int = j;
      }
    }
    else
    {
      localObject2 = this.jdField_c_of_type_OrgJsonJSONArray;
      if ((localObject2 != null) && (this.jdField_b_of_type_OrgJsonJSONArray != null))
      {
        i = ((JSONArray)localObject2).length();
        if (i > 0)
        {
          j = this.jdField_b_of_type_OrgJsonJSONArray.length();
          if ((j > 0) && (j == i))
          {
            i = a(new Random().nextInt(j));
            try
            {
              this.jdField_d_of_type_JavaLangString = this.jdField_b_of_type_OrgJsonJSONArray.optString(i);
              double d1 = new BigDecimal(this.jdField_d_of_type_JavaLangString).doubleValue();
              this.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_OrgJsonJSONArray.optString(i);
              if (a(d1) == 0) {
                this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplRollNumberView.a();
              }
            }
            catch (Exception localException3)
            {
              localException3.printStackTrace();
            }
            int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
            if ((arrayOfInt != null) && (arrayOfInt.length > i)) {
              arrayOfInt[i] = 1;
            }
            this.jdField_b_of_type_Int = i;
          }
        }
      }
    }
  }
  
  public int a(int paramInt)
  {
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    if ((arrayOfInt != null) && (arrayOfInt.length > paramInt))
    {
      if (paramInt < 0) {
        return 0;
      }
      int k = arrayOfInt.length;
      int j = 0;
      while (j < k)
      {
        i = (paramInt + j) % k;
        if (this.jdField_a_of_type_ArrayOfInt[i] == 0) {
          break label65;
        }
        j += 1;
      }
      int i = 0;
      label65:
      if (j == k)
      {
        i = 0;
        for (;;)
        {
          j = paramInt;
          if (i >= k) {
            break;
          }
          this.jdField_a_of_type_ArrayOfInt[i] = 0;
          i += 1;
        }
      }
      j = i;
      return j;
    }
    return 0;
  }
  
  public Intent a(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    if (paramInt == 0) {
      localIntent.putExtra("data", paramString2);
    } else {
      localIntent.putExtra("retmsg", paramString1);
    }
    localIntent.putExtra("result", paramInt);
    return localIntent;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseThemeConfig themeId = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("ThemeHbFragment", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbThemeThemeRedPkgConfig = ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).getThemeRedPkgConfById(paramInt);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbThemeThemeRedPkgConfig;
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.showThemeHbToast(getString(R.string.P));
      return;
    }
    this.jdField_c_of_type_OrgJsonJSONArray = ((ThemeRedPkgConfig)localObject).jdField_a_of_type_OrgJsonJSONArray;
    this.jdField_b_of_type_OrgJsonJSONArray = this.jdField_a_of_type_ComTencentMobileqqQwalletHbThemeThemeRedPkgConfig.jdField_b_of_type_OrgJsonJSONArray;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqQwalletHbThemeThemeRedPkgConfig.jdField_b_of_type_JavaLangString;
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_OrgJsonJSONArray = this.jdField_a_of_type_ComTencentMobileqqQwalletHbThemeThemeRedPkgConfig.jdField_c_of_type_OrgJsonJSONArray;
      this.jdField_b_of_type_OrgJsonJSONArray = this.jdField_a_of_type_ComTencentMobileqqQwalletHbThemeThemeRedPkgConfig.jdField_d_of_type_OrgJsonJSONArray;
      this.jdField_a_of_type_OrgJsonJSONArray = this.jdField_a_of_type_ComTencentMobileqqQwalletHbThemeThemeRedPkgConfig.e;
      if (this.jdField_a_of_type_OrgJsonJSONArray == null) {
        this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray();
      }
    }
    if (this.jdField_b_of_type_OrgJsonJSONArray == null) {
      this.jdField_b_of_type_OrgJsonJSONArray = new JSONArray();
    }
    if (this.jdField_c_of_type_OrgJsonJSONArray == null) {
      this.jdField_c_of_type_OrgJsonJSONArray = new JSONArray();
    }
    if (1 == this.jdField_a_of_type_ComTencentMobileqqQwalletHbThemeThemeRedPkgConfig.jdField_b_of_type_Int)
    {
      h();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append(".png");
      this.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      g();
    }
    int i;
    if (this.jdField_c_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_OrgJsonJSONArray;
      if ((localObject != null) && (this.jdField_b_of_type_OrgJsonJSONArray != null))
      {
        i = ((JSONArray)localObject).length();
        int j = this.jdField_b_of_type_OrgJsonJSONArray.length();
        int k = this.jdField_c_of_type_OrgJsonJSONArray.length();
        paramInt = j;
        if (k > j) {
          paramInt = k;
        }
        this.jdField_c_of_type_Int = paramInt;
        j = this.jdField_c_of_type_Int;
        paramInt = i;
        if (j > i) {
          paramInt = j;
        }
        this.jdField_c_of_type_Int = paramInt;
        this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_c_of_type_Int];
      }
    }
    else
    {
      localObject = this.jdField_b_of_type_OrgJsonJSONArray;
      if (localObject == null)
      {
        QLog.i("ThemeHbFragment", 2, "mArrMoney error, null checked...");
        return;
      }
      i = ((JSONArray)localObject).length();
      paramInt = this.jdField_c_of_type_OrgJsonJSONArray.length();
      localObject = getString(R.string.v);
      if (i > paramInt) {
        while (paramInt < i)
        {
          this.jdField_c_of_type_OrgJsonJSONArray.put(localObject);
          paramInt += 1;
        }
      }
      if (i < paramInt)
      {
        localObject = new JSONArray();
        paramInt = 0;
        while (paramInt < i)
        {
          ((JSONArray)localObject).put(this.jdField_c_of_type_OrgJsonJSONArray.get(paramInt));
          paramInt += 1;
        }
        this.jdField_c_of_type_OrgJsonJSONArray = ((JSONArray)localObject);
      }
      if (i > 0) {
        this.jdField_a_of_type_ArrayOfInt = new int[i];
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Int >= 0)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplThemeHbFragment$SendHbHandler;
      if (localObject != null)
      {
        localObject = ((ThemeHbFragment.SendHbHandler)localObject).obtainMessage();
        ((Message)localObject).what = 100;
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplThemeHbFragment$SendHbHandler.sendMessage((Message)localObject);
      }
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    k();
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    QLog.i("ThemeHbFragment", 2, "onAnimationStart...");
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.Z)
    {
      if (this.jdField_a_of_type_Int == 16384)
      {
        c("bqredpacket.order.randomamount");
        d();
        return;
      }
      c("theme.pack.change");
      k();
      return;
    }
    if (i == R.id.bU)
    {
      if (this.jdField_a_of_type_Int == 16384)
      {
        j();
        return;
      }
      i();
      return;
    }
    if ((i == R.id.cl) || (i == R.id.r) || (i == R.id.t))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqQwalletHbFrameAnimHelper;
      if (paramView != null) {
        paramView.a();
      }
      if (this.jdField_a_of_type_Int == 16384) {
        paramView = "bqredpacket.order.close";
      } else {
        paramView = "theme.pack.back";
      }
      b(paramView);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = getArguments();
    if (this.jdField_a_of_type_Int == 16384) {
      c("bqredpacket.order.expose");
    }
    int i;
    if (this.jdField_a_of_type_Int == 16384) {
      i = R.layout.j;
    } else {
      i = R.layout.q;
    }
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(i, null);
    e();
    if (this.jdField_a_of_type_Int == 16384) {
      b(paramViewGroup);
    } else {
      a(paramViewGroup);
    }
    b();
    f();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroyView()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.ThemeHbFragment
 * JD-Core Version:    0.7.0.1
 */