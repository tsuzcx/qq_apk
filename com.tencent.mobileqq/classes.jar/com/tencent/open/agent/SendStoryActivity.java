package com.tencent.open.agent;

import alkf;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.StringAddition;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.open.base.http.HttpImageDownloadAsyncTask;
import com.tencent.open.base.http.HttpImageDownloadAsyncTask.TaskCompleteCallback;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.settings.ServerSetting;
import com.tencent.open.widget.CursorEditText;
import com.tencent.qphone.base.util.QLog;
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
  implements TextWatcher, View.OnClickListener, HttpCgiAsyncTask.Callback, HttpImageDownloadAsyncTask.TaskCompleteCallback
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
  protected String h;
  
  protected String a(Friend paramFriend)
  {
    if (TextUtils.isEmpty(paramFriend.jdField_c_of_type_JavaLangString)) {}
    for (paramFriend = paramFriend.jdField_b_of_type_JavaLangString;; paramFriend = paramFriend.jdField_c_of_type_JavaLangString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("@").append(StringAddition.a(paramFriend, 12, false, false));
      localStringBuilder.append(" ");
      return localStringBuilder.toString();
    }
  }
  
  @TargetApi(14)
  protected void a()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131365818));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131362599);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363400));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363262));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363492));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363447));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText = ((CursorEditText)super.findViewById(2131365823));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131365821));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131365824));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131365819));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365825));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365826));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365827));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ArrayOfAndroidTextInputFilter = new InputFilter[] { new SendStoryActivity.CustomLengthInputFilter(this, this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText, 80) };
    this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.setFilters(this.jdField_a_of_type_ArrayOfAndroidTextInputFilter);
    this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.setSpannedClassToSkip(Friend.class);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(StringAddition.a(this.jdField_c_of_type_JavaLangString, 28, true, false));
    if ((this.jdField_e_of_type_JavaLangString != null) && (this.jdField_e_of_type_JavaLangString.length() > 0))
    {
      this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.setText(this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.setTextColor(-16777216);
    }
    if ((this.jdField_d_of_type_JavaLangString != null) && (this.jdField_d_of_type_JavaLangString.length() > 0)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(StringAddition.a(this.jdField_d_of_type_JavaLangString, 80, true, false));
    }
    new HttpImageDownloadAsyncTask(null, MsfSdkUtils.insertMtype("yingyongbao", this.jdField_f_of_type_JavaLangString), null, "GET", this).execute(new Void[0]);
    this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.setSelection(this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.getText().toString().length());
  }
  
  protected void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("key_error_code", -6);
    if (i != 0)
    {
      Toast.makeText(getApplicationContext(), paramIntent.getStringExtra("key_error_msg"), 0).show();
      LogUtility.e("SendStoryActivity", "onSendStoryComplete error:{KEY_ERROR_CODE:" + i + "; KEY_ERROR_MSG:" + paramIntent.getStringExtra("key_error_msg") + "}");
    }
    super.setResult(-1, paramIntent);
    super.finish();
  }
  
  public void a(Exception paramException)
  {
    c();
    LogUtility.c("SendStoryActivity", "SendStory exception. " + paramException.getMessage(), paramException);
    Intent localIntent = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      localIntent.putExtra("key_error_code", -7);
      localIntent.putExtra("key_error_msg", "网络连接超时!");
    }
    for (;;)
    {
      a(localIntent);
      return;
      if ((paramException instanceof SocketTimeoutException))
      {
        localIntent.putExtra("key_error_code", -8);
        localIntent.putExtra("key_error_msg", "网络连接超时!");
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
        localIntent.putExtra("key_error_msg", "网络连接异常，请检查后重试!");
      }
      else if ((paramException instanceof IOException))
      {
        localIntent.putExtra("key_error_code", -2);
        localIntent.putExtra("key_error_msg", "网络连接异常，请检查后重试!");
      }
      else
      {
        localIntent.putExtra("key_error_code", -6);
        localIntent.putExtra("key_error_msg", "未知错误!");
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
      StaticAnalyz.a("400", "ANDROIDQQ.SENDSTORY.FEED1", this.jdField_a_of_type_JavaLangString);
      c();
      int i = paramJSONObject.getInt("ret");
      String str = paramJSONObject.getString("msg");
      if (i == 0) {
        Toast.makeText(getApplicationContext(), 2131428660, 0).show();
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
      LogUtility.c("SendStoryActivity", "SendStory exception. " + paramJSONObject.getMessage(), paramJSONObject);
      paramJSONObject = new Intent();
      paramJSONObject.putExtra("key_error_code", -4);
      paramJSONObject.putExtra("key_error_msg", "服务器返回数据格式有误!");
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
        this.jdField_c_of_type_JavaLangString = StringAddition.a(this.jdField_a_of_type_AndroidOsBundle.getString("title"), 72, true, false);
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
        this.jdField_e_of_type_JavaLangString = StringAddition.a(this.jdField_a_of_type_AndroidOsBundle.getString("description"), 80, false, false);
      }
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("summary")) {
        this.jdField_d_of_type_JavaLangString = StringAddition.a(this.jdField_a_of_type_AndroidOsBundle.getString("summary"), 160, true, false);
      }
      this.g = ServerSetting.a().a("http://fusion.qq.com/cgi-bin/qzapps/mapp_getuserinfo.cgi");
      this.h = ServerSetting.a().a("http://fusion.qq.com/cgi-bin/appstage/mapp_sendstory.cgi");
      return true;
    }
    catch (Exception localException)
    {
      LogUtility.c("SendStoryActivity", "initParams exception. " + localException.getMessage(), localException);
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
    localIntent.putExtra("key_error_msg", "传入参数有误!");
    LogUtility.e("SendStoryActivity", "initParams:error code:-5; error msg:传入参数有误!");
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_AndroidOsBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append(str + ": " + this.jdField_a_of_type_AndroidOsBundle.get(str).toString() + " ");
      }
      LogUtility.e("SendStoryActivity", "params=" + localStringBuilder.toString());
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
        LogUtility.c("SendStoryActivity", "onActivityResult error:" + paramIntent.getMessage(), paramIntent);
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
  
  protected boolean onBackEvent()
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
    do
    {
      do
      {
        return;
        if (paramView != this.jdField_a_of_type_AndroidWidgetButton) {
          break;
        }
        paramView = new Intent();
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("appid", this.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject1).putString("hopenid", this.jdField_a_of_type_AndroidOsBundle.getString("hopenid"));
        ((Bundle)localObject1).putString("keystr", this.jdField_b_of_type_JavaLangString);
        ((Bundle)localObject1).putString("keytype", this.jdField_a_of_type_AndroidOsBundle.getString("keytype"));
        ((Bundle)localObject1).putString("encrytoken", this.jdField_a_of_type_AndroidOsBundle.getString("encrytoken"));
        ((Bundle)localObject1).putString("platform", this.jdField_a_of_type_AndroidOsBundle.getString("platform"));
        if (this.jdField_a_of_type_AndroidOsBundle.containsKey("sdkv")) {
          ((Bundle)localObject1).putString("sdkv", this.jdField_a_of_type_AndroidOsBundle.getString("sdkv"));
        }
        if (this.jdField_a_of_type_AndroidOsBundle.containsKey("sdkp")) {
          ((Bundle)localObject1).putString("sdkp", this.jdField_a_of_type_AndroidOsBundle.getString("sdkp"));
        }
        ((Bundle)localObject1).putString("key_action", "action_story");
        localObject2 = (Friend[])this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.getEditableText().getSpans(0, this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.length(), Friend.class);
        localObject3 = new String[localObject2.length];
        i = 0;
        while (i < localObject2.length)
        {
          localObject3[i] = localObject2[i].jdField_a_of_type_JavaLangString;
          i += 1;
        }
        ((Bundle)localObject1).putStringArray("BuddiesSelected", (String[])localObject3);
        paramView.setClass(this, SocialFriendChooser.class);
        paramView.putExtra("key_action", "action_story");
        paramView.putExtra("key_params", (Bundle)localObject1);
        super.startActivityForResult(paramView, 0);
      } while (!QLog.isColorLevel());
      QLog.d("SDKQQAgentPref", 2, "GetShareFriendSwitchStart:" + SystemClock.elapsedRealtime());
      return;
      if (paramView == this.jdField_e_of_type_AndroidWidgetTextView)
      {
        onBackEvent();
        return;
      }
    } while (paramView != this.jdField_f_of_type_AndroidWidgetTextView);
    Object localObject1 = new StringBuilder();
    Object localObject2 = this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.getEditableText();
    Object localObject3 = (Friend[])((Editable)localObject2).getSpans(0, ((Editable)localObject2).length(), Friend.class);
    Arrays.sort((Object[])localObject3, new alkf(this, (Editable)localObject2));
    HashSet localHashSet = new HashSet();
    int m = localObject3.length;
    int i = 0;
    int j = 0;
    if (j < m)
    {
      Object localObject4 = localObject3[j];
      int n = ((Editable)localObject2).getSpanStart(localObject4);
      int k = ((Editable)localObject2).getSpanEnd(localObject4);
      ((StringBuilder)localObject1).append(((Editable)localObject2).subSequence(i, n));
      if (localObject4.jdField_b_of_type_JavaLangString == null) {}
      for (paramView = localObject4.jdField_c_of_type_JavaLangString;; paramView = localObject4.jdField_b_of_type_JavaLangString)
      {
        paramView = StringAddition.b(paramView);
        ((StringBuilder)localObject1).append(String.format("@{openid:%s,nick:%s}", new Object[] { localObject4.jdField_a_of_type_JavaLangString, paramView }));
        localHashSet.add(localObject4.jdField_a_of_type_JavaLangString);
        j += 1;
        i = k;
        break;
      }
    }
    if (i != ((Editable)localObject2).length()) {
      ((StringBuilder)localObject1).append(((Editable)localObject2).subSequence(i, ((Editable)localObject2).length()));
    }
    if (localHashSet.size() > 10)
    {
      Toast.makeText(getApplicationContext(), super.getString(2131428661, new Object[] { Integer.valueOf(10) }), 0).show();
      return;
    }
    paramView = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
    paramView.putString("summary", this.jdField_d_of_type_JavaLangString);
    paramView.putString("title", this.jdField_c_of_type_JavaLangString);
    paramView.putString("description", ((StringBuilder)localObject1).toString());
    paramView.putString("appid_for_getting_config", this.jdField_a_of_type_JavaLangString);
    paramView.putString("agentversion", CommonDataAdapter.a().e());
    this.jdField_a_of_type_AndroidAppProgressDialog = ProgressDialog.show(this, "", super.getString(2131428657), true);
    this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
    new HttpCgiAsyncTask(this.h, "POST", this).a(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.requestWindowFeature(1);
    super.onCreate(paramBundle);
    super.setTheme(2131624739);
    super.setContentView(2130969261);
    a();
    a();
    StaticAnalyz.a("100", "ANDROIDQQ.SENDSTORY.FS", this.jdField_a_of_type_JavaLangString);
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131433029);
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_f_of_type_AndroidWidgetTextView.setText(2131428654);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131428652);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.agent.SendStoryActivity
 * JD-Core Version:    0.7.0.1
 */