package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
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
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qqpay.ui.R.anim;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.SendHbLogic;
import com.tencent.mobileqq.qwallet.hb.send.view.impl.RollNumberView;
import com.tencent.mobileqq.qwallet.hb.send.view.impl.RollNumberView.OnRollListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadImgApi.OnSingleDownloadCallback;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.util.Map;
import java.util.Random;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class QzoneHbFragment
  extends BaseHbFragment
  implements View.OnClickListener, FragmentInterface, RollNumberView.OnRollListener
{
  private long jdField_a_of_type_Long = 0L;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  protected TextWatcher a;
  private View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QzoneHbFragment.SendHbHandler jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplQzoneHbFragment$SendHbHandler = new QzoneHbFragment.SendHbHandler(this);
  private RollNumberView jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplRollNumberView;
  IPreloadImgApi.OnSingleDownloadCallback jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadImgApi$OnSingleDownloadCallback = new QzoneHbFragment.4(this);
  private String jdField_a_of_type_JavaLangString;
  private JSONArray jdField_a_of_type_OrgJsonJSONArray = new JSONArray();
  private int jdField_b_of_type_Int = 1;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private String jdField_b_of_type_JavaLangString;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString = "1.00";
  private boolean jdField_c_of_type_Boolean = false;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  private String e;
  private String f;
  private String g;
  private String h;
  
  public QzoneHbFragment()
  {
    this.jdField_a_of_type_AndroidTextTextWatcher = new QzoneHbFragment.1(this);
  }
  
  private String a()
  {
    new JSONArray();
    Object localObject1 = this.jdField_a_of_type_OrgJsonJSONArray;
    if (localObject1 != null)
    {
      int m = ((JSONArray)localObject1).length();
      if (m > 0)
      {
        Random localRandom = new Random();
        int k = 0;
        int i = k;
        Object localObject2;
        try
        {
          Object localObject4 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("hb_key_rand_amount", "");
          Object localObject3 = null;
          localObject1 = localObject3;
          i = k;
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            i = k;
            localObject4 = new JSONArray((String)localObject4);
            localObject1 = localObject3;
            i = k;
            if (((JSONArray)localObject4).length() == this.jdField_a_of_type_OrgJsonJSONArray.length()) {
              localObject1 = localObject4;
            }
          }
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            i = k;
            localObject1 = new JSONArray();
            j = 0;
            for (;;)
            {
              localObject3 = localObject1;
              i = k;
              if (j >= this.jdField_a_of_type_OrgJsonJSONArray.length()) {
                break;
              }
              i = k;
              ((JSONArray)localObject1).put(j, 0);
              j += 1;
            }
          }
          i = k;
          int j = a(localObject3, localRandom.nextInt(m));
          i = j;
          localObject3.put(j, 1);
          i = j;
          localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
          i = j;
          ((SharedPreferences.Editor)localObject1).putString("hb_key_rand_amount", localObject3.toString());
          i = j;
          ((SharedPreferences.Editor)localObject1).commit();
          i = j;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          localObject2 = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
          ((SharedPreferences.Editor)localObject2).remove("hb_key_rand_amount");
          ((SharedPreferences.Editor)localObject2).commit();
        }
        try
        {
          localObject2 = this.jdField_a_of_type_OrgJsonJSONArray.get(i).toString();
          return localObject2;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
    }
    return "";
  }
  
  public static void a(Handler paramHandler, EditText paramEditText)
  {
    if ((paramHandler != null) && (paramEditText != null)) {
      paramHandler.postDelayed(new QzoneHbFragment.8(paramEditText), 100L);
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(R.id.bh);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(R.id.bl));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(R.id.bi));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(R.id.bf));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(R.id.bg));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(R.id.bS));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(R.id.bN);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(R.id.O);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplRollNumberView = ((RollNumberView)paramView.findViewById(R.id.bm));
  }
  
  private boolean a()
  {
    this.jdField_b_of_type_Int = ((IQWalletConfigService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IQWalletConfigService.class, "")).getInt("grap_hb_verify", 1, new String[] { "videoRedMinValue" });
    return Integer.valueOf(QwUtils.a(this.jdField_b_of_type_JavaLangString)).intValue() >= this.jdField_b_of_type_Int;
  }
  
  private boolean b()
  {
    int i = this.jdField_a_of_type_AndroidWidgetEditText.getText().length();
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if ((i != 0) && (!str.startsWith(".")))
    {
      if (str.endsWith(".")) {
        return false;
      }
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      if (str.indexOf('.') == 0) {
        return false;
      }
      if ((str.indexOf('.') > 0) && (str.indexOf('.') < str.length() - 3))
      {
        str = getString(R.string.J);
        if (str != null) {
          this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.showQzoneHbToast(str);
        }
        return false;
      }
    }
    try
    {
      double d1 = Double.valueOf(str).doubleValue();
      return d1 > 0.0D;
    }
    catch (Exception localException) {}
    return false;
    return false;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplRollNumberView.setLisener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = getActivity().getPreferences(0);
    try
    {
      this.jdField_a_of_type_OrgJsonJSONArray.put("1.00");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    Object localObject = getArguments();
    if (localObject != null)
    {
      this.f = ((Bundle)localObject).getString("recv_name");
      this.g = ((Bundle)localObject).getString("feedsid");
      this.jdField_d_of_type_JavaLangString = ((Bundle)localObject).getString("recv_uin");
      this.h = ((Bundle)localObject).getString("recv_type");
      if ((32768 == this.jdField_a_of_type_Int) && (!this.h.equals("1"))) {
        this.jdField_d_of_type_JavaLangString = ((Bundle)localObject).getString("grab_uin_list");
      }
      this.e = ((Bundle)localObject).getString("send_uin");
      if (!TextUtils.isEmpty(this.f))
      {
        if (this.f.length() > 8)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.f.substring(0, 7));
          ((StringBuilder)localObject).append("...");
          this.f = ((StringBuilder)localObject).toString();
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.f);
      }
      this.jdField_b_of_type_JavaLangString = "1.00";
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, 1, this.jdField_d_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplQzoneHbFragment$SendHbHandler.postDelayed(new QzoneHbFragment.2(this), 10L);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplRollNumberView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
  }
  
  private void f()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((isAdded()) && (localFragmentActivity != null)) {
      this.jdField_c_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new QzoneHbFragment.5(this, localFragmentActivity));
    }
  }
  
  protected int a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getResources();
      int i = paramContext.getIdentifier("navigation_bar_height", "dimen", "android");
      if (i > 0)
      {
        i = paramContext.getDimensionPixelSize(i);
        return i;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public int a(JSONArray paramJSONArray, int paramInt)
  {
    int j = 0;
    int k = 0;
    int i = j;
    if (paramJSONArray != null)
    {
      i = j;
      if (paramJSONArray.length() > paramInt)
      {
        if (paramInt < 0) {
          return 0;
        }
        i = k;
        try
        {
          int n = paramJSONArray.length();
          j = 0;
          while (j < n)
          {
            int m = (paramInt + j) % n;
            i = k;
            int i1 = paramJSONArray.optInt(m);
            if (i1 == 0)
            {
              i = m;
              break label91;
            }
            j += 1;
          }
          i = 0;
          label91:
          if (j == n)
          {
            j = 0;
            for (;;)
            {
              if (j < n) {
                try
                {
                  paramJSONArray.put(j, 0);
                  j += 1;
                }
                catch (Exception paramJSONArray)
                {
                  break label146;
                }
              }
            }
          }
          else
          {
            paramInt = i;
          }
          i = paramInt;
          paramJSONArray.put(paramInt, 1);
          return paramInt;
        }
        catch (Exception paramJSONArray)
        {
          label146:
          paramJSONArray.printStackTrace();
        }
      }
    }
    return i;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    if (this.jdField_a_of_type_Int == 32768) {
      paramJSONObject = paramJSONObject.optJSONObject("mk_svideo_hb");
    } else {
      paramJSONObject = paramJSONObject.optJSONObject("mk_qzone_hb");
    }
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("comment");
      this.jdField_a_of_type_OrgJsonJSONArray = paramJSONObject.optJSONArray("money_array");
      this.jdField_b_of_type_JavaLangString = a();
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      }
      paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplQzoneHbFragment$SendHbHandler.obtainMessage();
      paramJSONObject.what = 100;
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplQzoneHbFragment$SendHbHandler.sendMessage(paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void b()
  {
    if (!isAdded()) {
      return;
    }
    getActivity();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getQWalletInternalPath());
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append("/hbThemeConfig.cfg");
    localObject = ((StringBuilder)localObject).toString();
    ThreadManager.getFileThreadHandler().post(new QzoneHbFragment.7(this, (String)localObject));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneHbFragment", 2, "complete---");
    }
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplQzoneHbFragment$SendHbHandler.obtainMessage();
    localMessage.what = 101;
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplQzoneHbFragment$SendHbHandler.sendMessage(localMessage);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.bh)
    {
      if (isAdded())
      {
        try
        {
          ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_b_of_type_AndroidViewView.getWindowToken(), 0);
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
        }
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.cancelCallBack();
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.finish();
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.overridePendingTransition(0, 0);
        if (this.jdField_a_of_type_Int != 32768) {
          this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addQZoneHbUploadData(300, "rewardhongbao.wrap.close", 2);
        }
      }
    }
    else
    {
      if (i == R.id.bg)
      {
        if (!this.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(R.string.bV));
          this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(true);
          this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
          this.jdField_a_of_type_AndroidWidgetEditText.setText("");
          if (this.jdField_a_of_type_Int != 32768) {
            this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addQZoneHbUploadData(300, "rewardhongbao.wrap.custom", 2);
          }
          a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplQzoneHbFragment$SendHbHandler, this.jdField_a_of_type_AndroidWidgetEditText);
          return;
        }
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(R.string.bT));
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
        return;
      }
      if (i == R.id.bS)
      {
        long l = System.currentTimeMillis();
        if ((this.jdField_a_of_type_Long != 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L)) {
          return;
        }
        this.jdField_a_of_type_Long = l;
        paramView = this.jdField_a_of_type_AndroidWidgetEditText;
        if (paramView != null) {
          this.jdField_b_of_type_JavaLangString = paramView.getText().toString();
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getMapPacketExtra();
        paramView.put("total_num", "1");
        paramView.put("total_amount", QwUtils.a(this.jdField_b_of_type_JavaLangString));
        paramView.put("wishing", "");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append("");
        paramView.put("channel", localStringBuilder.toString());
        paramView.put("feeds_name", this.f);
        paramView.put("feeds_sid", this.g);
        if (this.jdField_a_of_type_Int == 32768)
        {
          if (!a())
          {
            paramView = new StringBuilder();
            paramView.append(this.jdField_b_of_type_Int);
            paramView.append("");
            paramView = QwUtils.a(paramView.toString(), 0, true);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(HardCodeUtil.a(R.string.bW));
            localStringBuilder.append(paramView);
            localStringBuilder.append(HardCodeUtil.a(R.string.bU));
            paramView = localStringBuilder.toString();
            DialogUtil.a(getActivity(), 230, null, paramView, null, getString(R.string.w), new QzoneHbFragment.3(this), null).show();
            return;
          }
          if (this.h.equals("1"))
          {
            paramView.put("channel", String.valueOf(1));
            paramView.put("bus_type", "1");
          }
          else
          {
            paramView.put("channel", String.valueOf(1024));
          }
          paramView.put("type", String.valueOf(1));
        }
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplSendHbLogic.a(paramView);
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.overridePendingTransition(0, 0);
        if (this.jdField_a_of_type_Int != 32768) {
          this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addQZoneHbUploadData(300, "rewardhongbao.wrap.send", 2);
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.getWindow().setSoftInputMode(32);
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.o, null);
    a(paramLayoutInflater);
    e();
    d();
    b();
    f();
    if (this.jdField_a_of_type_Int != 32768) {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity.addQZoneHbUploadData(300, "rewardhongbao.wrap.show", 2);
    }
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localEditText != null)
    {
      TextWatcher localTextWatcher = this.jdField_a_of_type_AndroidTextTextWatcher;
      if (localTextWatcher != null)
      {
        localEditText.removeTextChangedListener(localTextWatcher);
        this.jdField_a_of_type_AndroidTextTextWatcher = null;
      }
    }
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.QzoneHbFragment
 * JD-Core Version:    0.7.0.1
 */