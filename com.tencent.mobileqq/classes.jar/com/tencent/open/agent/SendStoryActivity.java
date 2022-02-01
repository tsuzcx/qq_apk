package com.tencent.open.agent;

import Override;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import biip;
import bioe;
import biof;
import bisy;
import bite;
import bitt;
import bitu;
import bitv;
import bitw;
import biuc;
import biuh;
import biyo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.open.widget.CursorEditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class SendStoryActivity
  extends BaseActivity
  implements TextWatcher, View.OnClickListener, bitu, bitw
{
  protected ProgressDialog a;
  protected Bundle a;
  protected View a;
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected CursorEditText a;
  protected String a;
  protected InputFilter[] a;
  protected LinearLayout b;
  protected TextView b;
  protected String b;
  protected TextView c;
  protected String c;
  protected TextView d;
  protected String d;
  protected TextView e;
  protected String e;
  protected TextView f;
  protected String f;
  protected String g;
  
  protected String a(Friend paramFriend)
  {
    if (TextUtils.isEmpty(paramFriend.jdField_c_of_type_JavaLangString)) {}
    for (paramFriend = paramFriend.jdField_b_of_type_JavaLangString;; paramFriend = paramFriend.jdField_c_of_type_JavaLangString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("@").append(bite.a(paramFriend, 12, false, false));
      localStringBuilder.append(" ");
      return localStringBuilder.toString();
    }
  }
  
  @TargetApi(14)
  protected void a()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131370144));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131378796);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368994));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368947));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368949));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368979));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText = ((CursorEditText)super.findViewById(2131366105));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131363694));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131370156));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131376679));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379918));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379917));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131369307));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ArrayOfAndroidTextInputFilter = new InputFilter[] { new biof(this, this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText, 80) };
    this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.setFilters(this.jdField_a_of_type_ArrayOfAndroidTextInputFilter);
    this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.setSpannedClassToSkip(Friend.class);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(bite.a(this.jdField_c_of_type_JavaLangString, 28, true, false));
    if ((this.jdField_e_of_type_JavaLangString != null) && (this.jdField_e_of_type_JavaLangString.length() > 0))
    {
      this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.setText(this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.setTextColor(-16777216);
    }
    if ((this.jdField_d_of_type_JavaLangString != null) && (this.jdField_d_of_type_JavaLangString.length() > 0)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bite.a(this.jdField_d_of_type_JavaLangString, 80, true, false));
    }
    new bitv(null, MsfSdkUtils.insertMtype("yingyongbao", this.jdField_f_of_type_JavaLangString), null, "GET", this).execute(new Void[0]);
    this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.setSelection(this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.getText().toString().length());
  }
  
  protected void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("key_error_code", -6);
    if (i != 0)
    {
      Toast.makeText(getApplicationContext(), paramIntent.getStringExtra("key_error_msg"), 0).show();
      bisy.e("SendStoryActivity", "onSendStoryComplete error:{KEY_ERROR_CODE:" + i + "; KEY_ERROR_MSG:" + paramIntent.getStringExtra("key_error_msg") + "}");
    }
    super.setResult(-1, paramIntent);
    super.finish();
  }
  
  public void a(Exception paramException)
  {
    c();
    bisy.c("SendStoryActivity", "SendStory exception. " + paramException.getMessage(), paramException);
    Intent localIntent = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      localIntent.putExtra("key_error_code", -7);
      localIntent.putExtra("key_error_msg", biuc.jdField_e_of_type_JavaLangString);
    }
    for (;;)
    {
      a(localIntent);
      return;
      if ((paramException instanceof SocketTimeoutException))
      {
        localIntent.putExtra("key_error_code", -8);
        localIntent.putExtra("key_error_msg", biuc.jdField_f_of_type_JavaLangString);
      }
      else if ((paramException instanceof MalformedURLException))
      {
        localIntent.putExtra("key_error_code", -3);
        localIntent.putExtra("key_error_msg", "访问url有误!");
      }
      else if ((paramException instanceof HttpBaseUtil.HttpStatusException))
      {
        localIntent.putExtra("key_error_code", -10);
        localIntent.putExtra("key_error_msg", "Http返回码异常!");
      }
      else if ((paramException instanceof HttpBaseUtil.NetworkUnavailableException))
      {
        localIntent.putExtra("key_error_code", -9);
        localIntent.putExtra("key_error_msg", biuc.g);
      }
      else if ((paramException instanceof IOException))
      {
        localIntent.putExtra("key_error_code", -2);
        localIntent.putExtra("key_error_msg", biuc.jdField_a_of_type_JavaLangString);
      }
      else
      {
        localIntent.putExtra("key_error_code", -6);
        localIntent.putExtra("key_error_msg", biuc.jdField_d_of_type_JavaLangString);
      }
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      biuh.a("400", "ANDROIDQQ.SENDSTORY.FEED1", this.jdField_a_of_type_JavaLangString);
      c();
      int i = paramJSONObject.getInt("ret");
      String str = paramJSONObject.getString("msg");
      if (i == 0) {
        Toast.makeText(getApplicationContext(), 2131690837, 0).show();
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("key_error_code", i);
      localIntent.putExtra("key_error_msg", str);
      localIntent.putExtra("key_response", paramJSONObject.toString());
      a(localIntent);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      bisy.c("SendStoryActivity", "SendStory exception. " + paramJSONObject.getMessage(), paramJSONObject);
      paramJSONObject = new Intent();
      paramJSONObject.putExtra("key_error_code", -4);
      paramJSONObject.putExtra("key_error_msg", biuc.jdField_b_of_type_JavaLangString);
      a(paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      a(paramJSONObject);
    }
  }
  
  protected boolean a()
  {
    try
    {
      this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("appid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("hopenid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("keystr")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("keytype")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("platform")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("title")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("pics")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("encrytoken")))
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("appid");
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("keystr");
        this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("pics");
        this.jdField_c_of_type_JavaLangString = bite.a(this.jdField_a_of_type_AndroidOsBundle.getString("title"), 72, true, false);
        String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("hopenid");
        String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("keytype");
        String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("platform");
        String str4 = this.jdField_a_of_type_AndroidOsBundle.getString("encrytoken");
        if (("".equals(this.jdField_a_of_type_JavaLangString.trim())) || ("".equals(str1.trim())) || ("".equals(this.jdField_b_of_type_JavaLangString.trim())) || ("".equals(str2.trim())) || ("".equals(str3.trim())) || ("".equals(this.jdField_c_of_type_JavaLangString.trim())) || ("".equals(this.jdField_f_of_type_JavaLangString.trim())) || ("".equals(str4.trim())))
        {
          b();
          return false;
        }
      }
      else
      {
        b();
        return false;
      }
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("description")) {
        this.jdField_e_of_type_JavaLangString = bite.a(this.jdField_a_of_type_AndroidOsBundle.getString("description"), 80, false, false);
      }
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("summary")) {
        this.jdField_d_of_type_JavaLangString = bite.a(this.jdField_a_of_type_AndroidOsBundle.getString("summary"), 160, true, false);
      }
      this.g = biyo.a().a("https://fusion.qq.com/cgi-bin/appstage/mapp_sendstory.cgi");
      return true;
    }
    catch (Exception localException)
    {
      bisy.c("SendStoryActivity", "initParams exception. " + localException.getMessage(), localException);
      b();
    }
    return false;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = 0;
    Friend[] arrayOfFriend = (Friend[])paramEditable.getSpans(0, paramEditable.length(), Friend.class);
    int j = arrayOfFriend.length;
    while (i < j)
    {
      Friend localFriend = arrayOfFriend[i];
      int k = paramEditable.getSpanStart(localFriend);
      int m = paramEditable.getSpanEnd(localFriend);
      String str = a(localFriend);
      if (!paramEditable.subSequence(k, m).toString().equals(str))
      {
        paramEditable.removeSpan(localFriend);
        paramEditable.delete(k, m);
      }
      i += 1;
    }
  }
  
  protected void b()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", -5);
    localIntent.putExtra("key_error_msg", biuc.jdField_c_of_type_JavaLangString);
    bisy.e("SendStoryActivity", "initParams:error code:-5; error msg:" + biuc.jdField_c_of_type_JavaLangString);
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_AndroidOsBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append(str + ": " + this.jdField_a_of_type_AndroidOsBundle.get(str).toString() + " ");
      }
      bisy.e("SendStoryActivity", "params=" + localStringBuilder.toString());
    }
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void c()
  {
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {}
    for (;;)
    {
      try
      {
        Object localObject1 = paramIntent.getExtras();
        if (localObject1 == null) {
          break label417;
        }
        if (((Bundle)localObject1).getInt("key_error_code", -6) != 0) {
          return;
        }
        this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.setFilters(new InputFilter[0]);
        paramIntent = this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.getEditableText();
        localObject1 = ((Bundle)localObject1).getParcelableArray("RESULT_BUDDIES_SELECTED");
        if (localObject1 == null) {
          break label417;
        }
        paramInt1 = this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.getSelectionStart();
        paramIntent.delete(paramInt1, this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.getSelectionEnd());
        Friend[] arrayOfFriend = (Friend[])paramIntent.getSpans(0, paramIntent.length(), Friend.class);
        int j = localObject1.length;
        paramInt2 = 0;
        Object localObject2;
        Object localObject3;
        if (paramInt2 < j)
        {
          localObject2 = localObject1[paramInt2];
          localObject3 = new Friend((Friend)localObject2);
          int k = arrayOfFriend.length;
          i = 0;
          if (i >= k) {
            break label411;
          }
          if (!arrayOfFriend[i].jdField_a_of_type_JavaLangString.equals(((Friend)localObject3).jdField_a_of_type_JavaLangString)) {
            break label425;
          }
          i = 0;
          if (i == 0) {
            break label408;
          }
          localObject3 = a((Friend)localObject3);
          paramIntent.insert(paramInt1, (CharSequence)localObject3);
          paramIntent.setSpan(localObject2, paramInt1, ((String)localObject3).length() + paramInt1, 33);
          paramInt1 = ((String)localObject3).length() + paramInt1;
          break label418;
        }
        arrayOfFriend = (Friend[])paramIntent.getSpans(0, paramIntent.length(), Friend.class);
        i = arrayOfFriend.length;
        paramInt1 = 0;
        if (paramInt1 < i)
        {
          localObject2 = arrayOfFriend[paramInt1];
          j = localObject1.length;
          paramInt2 = 0;
          if (paramInt2 < j)
          {
            localObject3 = localObject1[paramInt2];
            if (!((Friend)localObject2).jdField_a_of_type_JavaLangString.equals(((Friend)localObject3).jdField_a_of_type_JavaLangString)) {
              break label441;
            }
            paramInt2 = 0;
            if (paramInt2 == 0) {
              break label434;
            }
            paramInt2 = paramIntent.getSpanStart(localObject2);
            j = paramIntent.getSpanEnd(localObject2);
            paramIntent.removeSpan(localObject2);
            paramIntent.delete(paramInt2, j);
            break label434;
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.setFilters(this.jdField_a_of_type_ArrayOfAndroidTextInputFilter);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        bisy.c("SendStoryActivity", "onActivityResult error:" + paramIntent.getMessage(), paramIntent);
        super.setResult(0);
        super.finish();
        return;
      }
      paramInt2 = 1;
      continue;
      label408:
      break label418;
      label411:
      int i = 1;
      continue;
      label417:
      return;
      label418:
      paramInt2 += 1;
      continue;
      label425:
      i += 1;
      continue;
      label434:
      paramInt1 += 1;
      continue;
      label441:
      paramInt2 += 1;
    }
  }
  
  public boolean onBackEvent()
  {
    super.setResult(0);
    super.finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_d_of_type_AndroidWidgetTextView)
    {
      super.setResult(0);
      super.finish();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      int i;
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
      {
        localObject1 = new Intent();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("appid", this.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject2).putString("hopenid", this.jdField_a_of_type_AndroidOsBundle.getString("hopenid"));
        ((Bundle)localObject2).putString("keystr", this.jdField_b_of_type_JavaLangString);
        ((Bundle)localObject2).putString("keytype", this.jdField_a_of_type_AndroidOsBundle.getString("keytype"));
        ((Bundle)localObject2).putString("encrytoken", this.jdField_a_of_type_AndroidOsBundle.getString("encrytoken"));
        ((Bundle)localObject2).putString("platform", this.jdField_a_of_type_AndroidOsBundle.getString("platform"));
        if (this.jdField_a_of_type_AndroidOsBundle.containsKey("sdkv")) {
          ((Bundle)localObject2).putString("sdkv", this.jdField_a_of_type_AndroidOsBundle.getString("sdkv"));
        }
        if (this.jdField_a_of_type_AndroidOsBundle.containsKey("sdkp")) {
          ((Bundle)localObject2).putString("sdkp", this.jdField_a_of_type_AndroidOsBundle.getString("sdkp"));
        }
        ((Bundle)localObject2).putString("key_action", "action_story");
        localObject3 = (Friend[])this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.getEditableText().getSpans(0, this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.length(), Friend.class);
        localObject4 = new String[localObject3.length];
        i = 0;
        while (i < localObject3.length)
        {
          localObject4[i] = localObject3[i].jdField_a_of_type_JavaLangString;
          i += 1;
        }
        ((Bundle)localObject2).putStringArray("BuddiesSelected", (String[])localObject4);
        ((Intent)localObject1).setClass(this, SocialFriendChooser.class);
        ((Intent)localObject1).putExtra("key_action", "action_story");
        ((Intent)localObject1).putExtra("key_params", (Bundle)localObject2);
        super.startActivityForResult((Intent)localObject1, 0);
        if (QLog.isColorLevel()) {
          QLog.d("SDKQQAgentPref", 2, "GetShareFriendSwitchStart:" + SystemClock.elapsedRealtime());
        }
      }
      else if (paramView == this.jdField_e_of_type_AndroidWidgetTextView)
      {
        onBackEvent();
      }
      else if (paramView == this.jdField_f_of_type_AndroidWidgetTextView)
      {
        localObject2 = new StringBuilder();
        localObject3 = this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.getEditableText();
        localObject4 = (Friend[])((Editable)localObject3).getSpans(0, ((Editable)localObject3).length(), Friend.class);
        Arrays.sort((Object[])localObject4, new bioe(this, (Editable)localObject3));
        HashSet localHashSet = new HashSet();
        int m = localObject4.length;
        i = 0;
        int j = 0;
        if (j < m)
        {
          Object localObject5 = localObject4[j];
          int n = ((Editable)localObject3).getSpanStart(localObject5);
          int k = ((Editable)localObject3).getSpanEnd(localObject5);
          ((StringBuilder)localObject2).append(((Editable)localObject3).subSequence(i, n));
          if (localObject5.jdField_b_of_type_JavaLangString == null) {}
          for (localObject1 = localObject5.jdField_c_of_type_JavaLangString;; localObject1 = localObject5.jdField_b_of_type_JavaLangString)
          {
            localObject1 = bite.b((String)localObject1);
            ((StringBuilder)localObject2).append(String.format("@{openid:%s,nick:%s}", new Object[] { localObject5.jdField_a_of_type_JavaLangString, localObject1 }));
            localHashSet.add(localObject5.jdField_a_of_type_JavaLangString);
            j += 1;
            i = k;
            break;
          }
        }
        if (i != ((Editable)localObject3).length()) {
          ((StringBuilder)localObject2).append(((Editable)localObject3).subSequence(i, ((Editable)localObject3).length()));
        }
        if (localHashSet.size() > 10)
        {
          Toast.makeText(getApplicationContext(), super.getString(2131690836, new Object[] { Integer.valueOf(10) }), 0).show();
        }
        else
        {
          localObject1 = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
          ((Bundle)localObject1).putString("summary", this.jdField_d_of_type_JavaLangString);
          ((Bundle)localObject1).putString("title", this.jdField_c_of_type_JavaLangString);
          ((Bundle)localObject1).putString("description", ((StringBuilder)localObject2).toString());
          ((Bundle)localObject1).putString("appid_for_getting_config", this.jdField_a_of_type_JavaLangString);
          ((Bundle)localObject1).putString("agentversion", biip.a().e());
          this.jdField_a_of_type_AndroidAppProgressDialog = ProgressDialog.show(this, "", super.getString(2131690842), true);
          this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
          new bitt(this.g, "POST", this).a((Bundle)localObject1);
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.requestWindowFeature(1);
    super.onCreate(paramBundle);
    super.setTheme(2131755152);
    super.setContentView(2131559680);
    a();
    a();
    biuh.a("100", "ANDROIDQQ.SENDSTORY.FS", this.jdField_a_of_type_JavaLangString);
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690582);
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_f_of_type_AndroidWidgetTextView.setText(2131690844);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690838);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.SendStoryActivity
 * JD-Core Version:    0.7.0.1
 */