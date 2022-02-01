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
  protected Bundle a;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  protected String h = null;
  protected CursorEditText i = null;
  protected Button j = null;
  protected LinearLayout k = null;
  protected TextView l = null;
  protected TextView m = null;
  protected ImageView n = null;
  protected LinearLayout o = null;
  protected RelativeLayout p = null;
  protected View q;
  protected TextView r;
  protected TextView s;
  protected TextView t;
  protected TextView u;
  protected ProgressDialog v = null;
  protected InputFilter[] w;
  
  protected String a(Friend paramFriend)
  {
    if (TextUtils.isEmpty(paramFriend.c)) {
      paramFriend = paramFriend.b;
    } else {
      paramFriend = paramFriend.c;
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
    this.o = ((LinearLayout)super.findViewById(2131437555));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.o.setFitsSystemWindows(true);
      this.o.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.q = super.findViewById(2131447484);
    this.r = ((TextView)super.findViewById(2131436227));
    this.s = ((TextView)super.findViewById(2131436180));
    this.t = ((TextView)super.findViewById(2131436182));
    this.u = ((TextView)super.findViewById(2131436211));
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.i = ((CursorEditText)super.findViewById(2131432637));
    this.j = ((Button)super.findViewById(2131429790));
    this.k = ((LinearLayout)super.findViewById(2131437569));
    this.p = ((RelativeLayout)super.findViewById(2131444984));
    this.l = ((TextView)super.findViewById(2131448765));
    this.m = ((TextView)super.findViewById(2131448764));
    this.n = ((ImageView)super.findViewById(2131436599));
    this.j.setOnClickListener(this);
    this.w = new InputFilter[] { new SendStoryActivity.CustomLengthInputFilter(this, this.i, 80) };
    this.i.setFilters(this.w);
    this.i.addTextChangedListener(this);
    this.i.setSpannedClassToSkip(Friend.class);
    this.l.setText(StringAddition.a(this.d, 28, true, false));
    Object localObject = this.f;
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      this.i.setText(this.f);
      this.i.setTextColor(-16777216);
    }
    localObject = this.e;
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      this.m.setText(StringAddition.a(this.e, 80, true, false));
    }
    new HttpImageDownloadAsyncTask(null, MsfSdkUtils.insertMtype("yingyongbao", this.g), null, "GET", this).execute(new Void[0]);
    localObject = this.i;
    ((CursorEditText)localObject).setSelection(((CursorEditText)localObject).getText().toString().length());
  }
  
  protected void a(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("key_error_code", -6);
    if (i1 != 0)
    {
      Toast.makeText(getApplicationContext(), paramIntent.getStringExtra("key_error_msg"), 0).show();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSendStoryComplete error:{KEY_ERROR_CODE:");
      localStringBuilder.append(i1);
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
    d();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SendStory exception. ");
    ((StringBuilder)localObject).append(paramException.getMessage());
    LogUtility.c("SendStoryActivity", ((StringBuilder)localObject).toString(), paramException);
    localObject = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      ((Intent)localObject).putExtra("key_error_code", -7);
      ((Intent)localObject).putExtra("key_error_msg", Constants.e);
    }
    else if ((paramException instanceof SocketTimeoutException))
    {
      ((Intent)localObject).putExtra("key_error_code", -8);
      ((Intent)localObject).putExtra("key_error_msg", Constants.f);
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
      ((Intent)localObject).putExtra("key_error_msg", Constants.a);
    }
    else
    {
      ((Intent)localObject).putExtra("key_error_code", -6);
      ((Intent)localObject).putExtra("key_error_msg", Constants.d);
    }
    a((Intent)localObject);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.n.setImageBitmap(paramBitmap);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      StaticAnalyz.a("400", "ANDROIDQQ.SENDSTORY.FEED1", this.b, true);
      d();
      int i1 = paramJSONObject.getInt("ret");
      localObject = paramJSONObject.getString("msg");
      if (i1 == 0) {
        Toast.makeText(getApplicationContext(), 2131887922, 0).show();
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("key_error_code", i1);
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
      paramJSONObject.putExtra("key_error_msg", Constants.b);
      a(paramJSONObject);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i2 = paramEditable.length();
    int i1 = 0;
    Friend[] arrayOfFriend = (Friend[])paramEditable.getSpans(0, i2, Friend.class);
    i2 = arrayOfFriend.length;
    while (i1 < i2)
    {
      Friend localFriend = arrayOfFriend[i1];
      int i3 = paramEditable.getSpanStart(localFriend);
      int i4 = paramEditable.getSpanEnd(localFriend);
      String str = a(localFriend);
      if (!paramEditable.subSequence(i3, i4).toString().equals(str))
      {
        paramEditable.removeSpan(localFriend);
        paramEditable.delete(i3, i4);
      }
      i1 += 1;
    }
  }
  
  protected boolean b()
  {
    try
    {
      this.a = super.getIntent().getBundleExtra("key_params");
      if ((this.a != null) && (this.a.containsKey("appid")) && (this.a.containsKey("hopenid")) && (this.a.containsKey("keystr")) && (this.a.containsKey("keytype")) && (this.a.containsKey("platform")) && (this.a.containsKey("title")) && (this.a.containsKey("pics")) && (this.a.containsKey("encrytoken")))
      {
        this.b = this.a.getString("appid");
        this.c = this.a.getString("keystr");
        this.g = this.a.getString("pics");
        this.d = StringAddition.a(this.a.getString("title"), 72, true, false);
        String str1 = this.a.getString("hopenid");
        localObject = this.a.getString("keytype");
        String str2 = this.a.getString("platform");
        String str3 = this.a.getString("encrytoken");
        if ((!"".equals(this.b.trim())) && (!"".equals(str1.trim())) && (!"".equals(this.c.trim())) && (!"".equals(((String)localObject).trim())) && (!"".equals(str2.trim())) && (!"".equals(this.d.trim())) && (!"".equals(this.g.trim())) && (!"".equals(str3.trim())))
        {
          if (this.a.containsKey("description")) {
            this.f = StringAddition.a(this.a.getString("description"), 80, false, false);
          }
          if (this.a.containsKey("summary")) {
            this.e = StringAddition.a(this.a.getString("summary"), 160, true, false);
          }
          this.h = ServerSetting.a().a("https://fusion.qq.com/cgi-bin/appstage/mapp_sendstory.cgi");
          return true;
        }
        c();
        return false;
      }
      c();
      return false;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initParams exception. ");
      ((StringBuilder)localObject).append(localException.getMessage());
      LogUtility.c("SendStoryActivity", ((StringBuilder)localObject).toString(), localException);
      c();
    }
    return false;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void c()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", -5);
    localIntent.putExtra("key_error_msg", Constants.c);
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("initParams:error code:-5; error msg:");
    localStringBuilder1.append(Constants.c);
    LogUtility.e("SendStoryActivity", localStringBuilder1.toString());
    if (this.a != null)
    {
      localStringBuilder1 = new StringBuilder();
      Object localObject = this.a.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(str);
        localStringBuilder2.append(": ");
        localStringBuilder2.append(this.a.get(str).toString());
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
  
  protected void d()
  {
    ProgressDialog localProgressDialog = this.v;
    if ((localProgressDialog != null) && (localProgressDialog.isShowing())) {
      this.v.dismiss();
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
      int i2;
      try
      {
        localObject1 = paramIntent.getExtras();
        if (localObject1 != null)
        {
          if (((Bundle)localObject1).getInt("key_error_code", -6) != 0) {
            return;
          }
          this.i.setFilters(new InputFilter[0]);
          paramIntent = this.i.getEditableText();
          localObject1 = ((Bundle)localObject1).getParcelableArray("RESULT_BUDDIES_SELECTED");
          if (localObject1 == null) {
            return;
          }
          paramInt2 = this.i.getSelectionStart();
          paramIntent.delete(paramInt2, this.i.getSelectionEnd());
          Friend[] arrayOfFriend = (Friend[])paramIntent.getSpans(0, paramIntent.length(), Friend.class);
          int i4 = localObject1.length;
          paramInt1 = 0;
          int i3 = 1;
          Object localObject2;
          Object localObject3;
          if (paramInt1 < i4)
          {
            localObject2 = localObject1[paramInt1];
            localObject3 = new Friend((Friend)localObject2);
            int i5 = arrayOfFriend.length;
            i2 = 0;
            i1 = i3;
            if (i2 < i5)
            {
              if (!arrayOfFriend[i2].a.equals(((Friend)localObject3).a)) {
                break label433;
              }
              i1 = 0;
            }
            i2 = paramInt2;
            if (i1 == 0) {
              break label442;
            }
            localObject3 = a((Friend)localObject3);
            paramIntent.insert(paramInt2, (CharSequence)localObject3);
            paramIntent.setSpan(localObject2, paramInt2, ((String)localObject3).length() + paramInt2, 33);
            i2 = paramInt2 + ((String)localObject3).length();
            break label442;
          }
          arrayOfFriend = (Friend[])paramIntent.getSpans(0, paramIntent.length(), Friend.class);
          int i1 = arrayOfFriend.length;
          paramInt1 = 0;
          if (paramInt1 < i1)
          {
            localObject2 = arrayOfFriend[paramInt1];
            i2 = localObject1.length;
            paramInt2 = 0;
            if (paramInt2 >= i2) {
              break label459;
            }
            localObject3 = localObject1[paramInt2];
            if (!((Friend)localObject2).a.equals(((Friend)localObject3).a)) {
              break label452;
            }
            paramInt2 = 0;
            if (paramInt2 == 0) {
              break label464;
            }
            paramInt2 = paramIntent.getSpanStart(localObject2);
            i2 = paramIntent.getSpanEnd(localObject2);
            paramIntent.removeSpan(localObject2);
            paramIntent.delete(paramInt2, i2);
            break label464;
          }
          this.i.setFilters(this.w);
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
      i2 += 1;
      continue;
      label442:
      paramInt1 += 1;
      paramInt2 = i2;
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
    if (paramView == this.s)
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
      int i1;
      if (paramView == this.j)
      {
        localObject1 = new Intent();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("appid", this.b);
        ((Bundle)localObject2).putString("hopenid", this.a.getString("hopenid"));
        ((Bundle)localObject2).putString("keystr", this.c);
        ((Bundle)localObject2).putString("keytype", this.a.getString("keytype"));
        ((Bundle)localObject2).putString("encrytoken", this.a.getString("encrytoken"));
        ((Bundle)localObject2).putString("platform", this.a.getString("platform"));
        if (this.a.containsKey("sdkv")) {
          ((Bundle)localObject2).putString("sdkv", this.a.getString("sdkv"));
        }
        if (this.a.containsKey("sdkp")) {
          ((Bundle)localObject2).putString("sdkp", this.a.getString("sdkp"));
        }
        ((Bundle)localObject2).putString("key_action", "action_story");
        localObject3 = (Friend[])this.i.getEditableText().getSpans(0, this.i.length(), Friend.class);
        localObject4 = new String[localObject3.length];
        i1 = 0;
        while (i1 < localObject3.length)
        {
          localObject4[i1] = localObject3[i1].a;
          i1 += 1;
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
      else if (paramView == this.t)
      {
        onBackEvent();
      }
      else if (paramView == this.u)
      {
        localObject2 = new StringBuilder();
        localObject3 = this.i.getEditableText();
        localObject4 = (Friend[])((Editable)localObject3).getSpans(0, ((Editable)localObject3).length(), Friend.class);
        Arrays.sort((Object[])localObject4, new SendStoryActivity.1(this, (Editable)localObject3));
        HashSet localHashSet = new HashSet();
        int i4 = localObject4.length;
        i1 = 0;
        int i3;
        for (int i2 = 0; i1 < i4; i2 = i3)
        {
          Object localObject5 = localObject4[i1];
          int i5 = ((Editable)localObject3).getSpanStart(localObject5);
          i3 = ((Editable)localObject3).getSpanEnd(localObject5);
          ((StringBuilder)localObject2).append(((Editable)localObject3).subSequence(i2, i5));
          if (localObject5.b == null) {
            localObject1 = localObject5.c;
          } else {
            localObject1 = localObject5.b;
          }
          localObject1 = StringAddition.b((String)localObject1);
          ((StringBuilder)localObject2).append(String.format("@{openid:%s,nick:%s}", new Object[] { localObject5.a, localObject1 }));
          localHashSet.add(localObject5.a);
          i1 += 1;
        }
        if (i2 != ((Editable)localObject3).length()) {
          ((StringBuilder)localObject2).append(((Editable)localObject3).subSequence(i2, ((Editable)localObject3).length()));
        }
        if (localHashSet.size() > 10)
        {
          Toast.makeText(getApplicationContext(), super.getString(2131887921, new Object[] { Integer.valueOf(10) }), 0).show();
        }
        else
        {
          localObject1 = new Bundle(this.a);
          ((Bundle)localObject1).putString("summary", this.e);
          ((Bundle)localObject1).putString("title", this.d);
          ((Bundle)localObject1).putString("description", ((StringBuilder)localObject2).toString());
          ((Bundle)localObject1).putString("appid_for_getting_config", this.b);
          ((Bundle)localObject1).putString("agentversion", CommonDataAdapter.a().k());
          this.v = ProgressDialog.show(this, "", super.getString(2131887927), true);
          this.v.setCancelable(true);
          new HttpCgiAsyncTask(this.h, "POST", this, true).a((Bundle)localObject1);
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
    super.setTheme(2131952010);
    super.setContentView(2131625708);
    b();
    a();
    StaticAnalyz.a("100", "ANDROIDQQ.SENDSTORY.FS", this.b, true);
  }
  
  protected void onStart()
  {
    super.onStart();
    this.s.setVisibility(4);
    this.t.setVisibility(0);
    this.t.setText(2131887648);
    this.u.setVisibility(0);
    this.u.setText(2131887929);
    this.r.setText(2131887923);
    this.t.setOnClickListener(this);
    this.u.setOnClickListener(this);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.SendStoryActivity
 * JD-Core Version:    0.7.0.1
 */