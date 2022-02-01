package com.tencent.open.agent;

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
import com.tencent.mobileqq.app.QBaseActivity;
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
import com.tencent.open.business.base.Constants;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.settings.ServerSetting;
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
  extends QBaseActivity
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
  protected String g = null;
  
  public SendStoryActivity()
  {
    this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_b_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_AndroidAppProgressDialog = null;
  }
  
  protected String a(Friend paramFriend)
  {
    if (TextUtils.isEmpty(paramFriend.jdField_c_of_type_JavaLangString)) {
      paramFriend = paramFriend.jdField_b_of_type_JavaLangString;
    } else {
      paramFriend = paramFriend.jdField_c_of_type_JavaLangString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("@");
    localStringBuilder.append(StringAddition.a(paramFriend, 12, false, false));
    localStringBuilder.append(" ");
    return localStringBuilder.toString();
  }
  
  @TargetApi(14)
  protected void a()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131370307));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131378803);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369249));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369202));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369204));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369233));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText = ((CursorEditText)super.findViewById(2131366336));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131363844));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131370319));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131376703));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379892));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379891));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131369512));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ArrayOfAndroidTextInputFilter = new InputFilter[] { new SendStoryActivity.CustomLengthInputFilter(this, this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText, 80) };
    this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.setFilters(this.jdField_a_of_type_ArrayOfAndroidTextInputFilter);
    this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.setSpannedClassToSkip(Friend.class);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(StringAddition.a(this.jdField_c_of_type_JavaLangString, 28, true, false));
    Object localObject = this.jdField_e_of_type_JavaLangString;
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.setText(this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.setTextColor(-16777216);
    }
    localObject = this.jdField_d_of_type_JavaLangString;
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(StringAddition.a(this.jdField_d_of_type_JavaLangString, 80, true, false));
    }
    new HttpImageDownloadAsyncTask(null, MsfSdkUtils.insertMtype("yingyongbao", this.jdField_f_of_type_JavaLangString), null, "GET", this).execute(new Void[0]);
    localObject = this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText;
    ((CursorEditText)localObject).setSelection(((CursorEditText)localObject).getText().toString().length());
  }
  
  protected void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("key_error_code", -6);
    if (i != 0)
    {
      Toast.makeText(getApplicationContext(), paramIntent.getStringExtra("key_error_msg"), 0).show();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSendStoryComplete error:{KEY_ERROR_CODE:");
      localStringBuilder.append(i);
      localStringBuilder.append("; KEY_ERROR_MSG:");
      localStringBuilder.append(paramIntent.getStringExtra("key_error_msg"));
      localStringBuilder.append("}");
      LogUtility.e("SendStoryActivity", localStringBuilder.toString());
    }
    super.setResult(-1, paramIntent);
    super.finish();
  }
  
  public void a(Exception paramException)
  {
    c();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SendStory exception. ");
    ((StringBuilder)localObject).append(paramException.getMessage());
    LogUtility.c("SendStoryActivity", ((StringBuilder)localObject).toString(), paramException);
    localObject = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      ((Intent)localObject).putExtra("key_error_code", -7);
      ((Intent)localObject).putExtra("key_error_msg", Constants.jdField_e_of_type_JavaLangString);
    }
    else if ((paramException instanceof SocketTimeoutException))
    {
      ((Intent)localObject).putExtra("key_error_code", -8);
      ((Intent)localObject).putExtra("key_error_msg", Constants.jdField_f_of_type_JavaLangString);
    }
    else if ((paramException instanceof MalformedURLException))
    {
      ((Intent)localObject).putExtra("key_error_code", -3);
      ((Intent)localObject).putExtra("key_error_msg", "访问url有误!");
    }
    else if ((paramException instanceof HttpBaseUtil.HttpStatusException))
    {
      ((Intent)localObject).putExtra("key_error_code", -10);
      ((Intent)localObject).putExtra("key_error_msg", "Http返回码异常!");
    }
    else if ((paramException instanceof HttpBaseUtil.NetworkUnavailableException))
    {
      ((Intent)localObject).putExtra("key_error_code", -9);
      ((Intent)localObject).putExtra("key_error_msg", Constants.g);
    }
    else if ((paramException instanceof IOException))
    {
      ((Intent)localObject).putExtra("key_error_code", -2);
      ((Intent)localObject).putExtra("key_error_msg", Constants.jdField_a_of_type_JavaLangString);
    }
    else
    {
      ((Intent)localObject).putExtra("key_error_code", -6);
      ((Intent)localObject).putExtra("key_error_msg", Constants.jdField_d_of_type_JavaLangString);
    }
    a((Intent)localObject);
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
      StaticAnalyz.a("400", "ANDROIDQQ.SENDSTORY.FEED1", this.jdField_a_of_type_JavaLangString, true);
      c();
      int i = paramJSONObject.getInt("ret");
      localObject = paramJSONObject.getString("msg");
      if (i == 0) {
        Toast.makeText(getApplicationContext(), 2131690983, 0).show();
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("key_error_code", i);
      localIntent.putExtra("key_error_msg", (String)localObject);
      localIntent.putExtra("key_response", paramJSONObject.toString());
      a(localIntent);
      return;
    }
    catch (Exception paramJSONObject)
    {
      a(paramJSONObject);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SendStory exception. ");
      ((StringBuilder)localObject).append(paramJSONObject.getMessage());
      LogUtility.c("SendStoryActivity", ((StringBuilder)localObject).toString(), paramJSONObject);
      paramJSONObject = new Intent();
      paramJSONObject.putExtra("key_error_code", -4);
      paramJSONObject.putExtra("key_error_msg", Constants.jdField_b_of_type_JavaLangString);
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
        localObject = this.jdField_a_of_type_AndroidOsBundle.getString("keytype");
        String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("platform");
        String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("encrytoken");
        if ((!"".equals(this.jdField_a_of_type_JavaLangString.trim())) && (!"".equals(str1.trim())) && (!"".equals(this.jdField_b_of_type_JavaLangString.trim())) && (!"".equals(((String)localObject).trim())) && (!"".equals(str2.trim())) && (!"".equals(this.jdField_c_of_type_JavaLangString.trim())) && (!"".equals(this.jdField_f_of_type_JavaLangString.trim())) && (!"".equals(str3.trim())))
        {
          if (this.jdField_a_of_type_AndroidOsBundle.containsKey("description")) {
            this.jdField_e_of_type_JavaLangString = StringAddition.a(this.jdField_a_of_type_AndroidOsBundle.getString("description"), 80, false, false);
          }
          if (this.jdField_a_of_type_AndroidOsBundle.containsKey("summary")) {
            this.jdField_d_of_type_JavaLangString = StringAddition.a(this.jdField_a_of_type_AndroidOsBundle.getString("summary"), 160, true, false);
          }
          this.g = ServerSetting.a().a("https://fusion.qq.com/cgi-bin/appstage/mapp_sendstory.cgi");
          return true;
        }
        b();
        return false;
      }
      b();
      return false;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initParams exception. ");
      ((StringBuilder)localObject).append(localException.getMessage());
      LogUtility.c("SendStoryActivity", ((StringBuilder)localObject).toString(), localException);
      b();
    }
    return false;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int j = paramEditable.length();
    int i = 0;
    Friend[] arrayOfFriend = (Friend[])paramEditable.getSpans(0, j, Friend.class);
    j = arrayOfFriend.length;
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
    localIntent.putExtra("key_error_msg", Constants.jdField_c_of_type_JavaLangString);
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("initParams:error code:-5; error msg:");
    localStringBuilder1.append(Constants.jdField_c_of_type_JavaLangString);
    LogUtility.e("SendStoryActivity", localStringBuilder1.toString());
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      localStringBuilder1 = new StringBuilder();
      Object localObject = this.jdField_a_of_type_AndroidOsBundle.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(str);
        localStringBuilder2.append(": ");
        localStringBuilder2.append(this.jdField_a_of_type_AndroidOsBundle.get(str).toString());
        localStringBuilder2.append(" ");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("params=");
      ((StringBuilder)localObject).append(localStringBuilder1.toString());
      LogUtility.e("SendStoryActivity", ((StringBuilder)localObject).toString());
    }
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void c()
  {
    ProgressDialog localProgressDialog = this.jdField_a_of_type_AndroidAppProgressDialog;
    if ((localProgressDialog != null) && (localProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
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
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {}
    for (;;)
    {
      int j;
      try
      {
        localObject1 = paramIntent.getExtras();
        if (localObject1 != null)
        {
          if (((Bundle)localObject1).getInt("key_error_code", -6) != 0) {
            return;
          }
          this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.setFilters(new InputFilter[0]);
          paramIntent = this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.getEditableText();
          localObject1 = ((Bundle)localObject1).getParcelableArray("RESULT_BUDDIES_SELECTED");
          if (localObject1 == null) {
            return;
          }
          paramInt2 = this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.getSelectionStart();
          paramIntent.delete(paramInt2, this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.getSelectionEnd());
          Friend[] arrayOfFriend = (Friend[])paramIntent.getSpans(0, paramIntent.length(), Friend.class);
          int m = localObject1.length;
          paramInt1 = 0;
          int k = 1;
          Object localObject2;
          Object localObject3;
          if (paramInt1 < m)
          {
            localObject2 = localObject1[paramInt1];
            localObject3 = new Friend((Friend)localObject2);
            int n = arrayOfFriend.length;
            j = 0;
            i = k;
            if (j < n)
            {
              if (!arrayOfFriend[j].jdField_a_of_type_JavaLangString.equals(((Friend)localObject3).jdField_a_of_type_JavaLangString)) {
                break label433;
              }
              i = 0;
            }
            j = paramInt2;
            if (i == 0) {
              break label442;
            }
            localObject3 = a((Friend)localObject3);
            paramIntent.insert(paramInt2, (CharSequence)localObject3);
            paramIntent.setSpan(localObject2, paramInt2, ((String)localObject3).length() + paramInt2, 33);
            j = paramInt2 + ((String)localObject3).length();
            break label442;
          }
          arrayOfFriend = (Friend[])paramIntent.getSpans(0, paramIntent.length(), Friend.class);
          int i = arrayOfFriend.length;
          paramInt1 = 0;
          if (paramInt1 < i)
          {
            localObject2 = arrayOfFriend[paramInt1];
            j = localObject1.length;
            paramInt2 = 0;
            if (paramInt2 >= j) {
              break label459;
            }
            localObject3 = localObject1[paramInt2];
            if (!((Friend)localObject2).jdField_a_of_type_JavaLangString.equals(((Friend)localObject3).jdField_a_of_type_JavaLangString)) {
              break label452;
            }
            paramInt2 = 0;
            if (paramInt2 == 0) {
              break label464;
            }
            paramInt2 = paramIntent.getSpanStart(localObject2);
            j = paramIntent.getSpanEnd(localObject2);
            paramIntent.removeSpan(localObject2);
            paramIntent.delete(paramInt2, j);
            break label464;
          }
          this.jdField_a_of_type_ComTencentOpenWidgetCursorEditText.setFilters(this.jdField_a_of_type_ArrayOfAndroidTextInputFilter);
          return;
        }
        return;
      }
      catch (Exception paramIntent)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onActivityResult error:");
        ((StringBuilder)localObject1).append(paramIntent.getMessage());
        LogUtility.c("SendStoryActivity", ((StringBuilder)localObject1).toString(), paramIntent);
        super.setResult(0);
        super.finish();
      }
      return;
      label433:
      j += 1;
      continue;
      label442:
      paramInt1 += 1;
      paramInt2 = j;
      continue;
      label452:
      paramInt2 += 1;
      continue;
      label459:
      paramInt2 = 1;
      continue;
      label464:
      paramInt1 += 1;
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
    else
    {
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
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("GetShareFriendSwitchStart:");
          ((StringBuilder)localObject1).append(SystemClock.elapsedRealtime());
          QLog.d("SDKQQAgentPref", 2, ((StringBuilder)localObject1).toString());
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
        Arrays.sort((Object[])localObject4, new SendStoryActivity.1(this, (Editable)localObject3));
        HashSet localHashSet = new HashSet();
        int m = localObject4.length;
        i = 0;
        int k;
        for (int j = 0; i < m; j = k)
        {
          Object localObject5 = localObject4[i];
          int n = ((Editable)localObject3).getSpanStart(localObject5);
          k = ((Editable)localObject3).getSpanEnd(localObject5);
          ((StringBuilder)localObject2).append(((Editable)localObject3).subSequence(j, n));
          if (localObject5.jdField_b_of_type_JavaLangString == null) {
            localObject1 = localObject5.jdField_c_of_type_JavaLangString;
          } else {
            localObject1 = localObject5.jdField_b_of_type_JavaLangString;
          }
          localObject1 = StringAddition.b((String)localObject1);
          ((StringBuilder)localObject2).append(String.format("@{openid:%s,nick:%s}", new Object[] { localObject5.jdField_a_of_type_JavaLangString, localObject1 }));
          localHashSet.add(localObject5.jdField_a_of_type_JavaLangString);
          i += 1;
        }
        if (j != ((Editable)localObject3).length()) {
          ((StringBuilder)localObject2).append(((Editable)localObject3).subSequence(j, ((Editable)localObject3).length()));
        }
        if (localHashSet.size() > 10)
        {
          Toast.makeText(getApplicationContext(), super.getString(2131690982, new Object[] { Integer.valueOf(10) }), 0).show();
        }
        else
        {
          localObject1 = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
          ((Bundle)localObject1).putString("summary", this.jdField_d_of_type_JavaLangString);
          ((Bundle)localObject1).putString("title", this.jdField_c_of_type_JavaLangString);
          ((Bundle)localObject1).putString("description", ((StringBuilder)localObject2).toString());
          ((Bundle)localObject1).putString("appid_for_getting_config", this.jdField_a_of_type_JavaLangString);
          ((Bundle)localObject1).putString("agentversion", CommonDataAdapter.a().e());
          this.jdField_a_of_type_AndroidAppProgressDialog = ProgressDialog.show(this, "", super.getString(2131690988), true);
          this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
          new HttpCgiAsyncTask(this.g, "POST", this, true).a((Bundle)localObject1);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
    super.setTheme(2131755317);
    super.setContentView(2131559677);
    a();
    a();
    StaticAnalyz.a("100", "ANDROIDQQ.SENDSTORY.FS", this.jdField_a_of_type_JavaLangString, true);
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690728);
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_f_of_type_AndroidWidgetTextView.setText(2131690990);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690984);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.SendStoryActivity
 * JD-Core Version:    0.7.0.1
 */