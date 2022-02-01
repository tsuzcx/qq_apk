package com.tencent.open.agent;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.Toast;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.open.agent.datamodel.FriendResponseInfo;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.StringAddition;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.open.business.base.Constants;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.settings.ServerSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class SocialFriendChooser
  extends FriendChooser
  implements OpenSdkFriendService.GetFriendInfoListener, HttpCgiAsyncTask.Callback
{
  protected Bundle N;
  protected String O;
  protected String P;
  protected String Q;
  protected String R;
  protected String S;
  protected String T;
  protected String U;
  protected String V;
  protected String W;
  protected String X;
  protected String Y;
  protected String Z;
  protected String aa;
  protected String ab;
  protected String ac;
  protected String ad;
  protected String ae;
  protected ProgressDialog af = null;
  protected String[] ag;
  protected HttpCgiAsyncTask ah;
  protected Handler ai = new SocialFriendChooser.1(this);
  
  protected int a()
  {
    return 2131625703;
  }
  
  public void a(Intent paramIntent)
  {
    o();
    if (paramIntent.hasExtra("key_error_msg")) {
      Toast.makeText(CommonDataAdapter.a().b(), paramIntent.getStringExtra("key_error_msg"), 0).show();
    }
    int i = paramIntent.getIntExtra("key_error_code", -6);
    if (i != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetBuddyListError{KEY_ERROR_CODE:");
      localStringBuilder.append(i);
      localStringBuilder.append("; KEY_ERROR_MSG:");
      localStringBuilder.append(paramIntent.getStringExtra("key_error_msg"));
      localStringBuilder.append("}");
      LogUtility.e("SocialFriendChooser", localStringBuilder.toString());
    }
    super.setResult(-1, paramIntent);
    super.finish();
  }
  
  public void a(FriendResponseInfo paramFriendResponseInfo)
  {
    try
    {
      o();
      if (("action_gift".equals(this.Q)) || ("action_ask".equals(this.Q)) || ("action_invite".equals(this.Q)) || ("action_reactive".equals(this.Q)) || ("action_story".equals(this.Q)))
      {
        this.K = paramFriendResponseInfo.e;
        int j = paramFriendResponseInfo.c;
        int i = 0;
        if (j != -1)
        {
          if (paramFriendResponseInfo.c - paramFriendResponseInfo.d == 0) {
            this.K = 0;
          } else if (paramFriendResponseInfo.c - paramFriendResponseInfo.d < this.K) {
            this.K = (paramFriendResponseInfo.c - paramFriendResponseInfo.d);
          }
          this.L = paramFriendResponseInfo.c;
        }
        if (this.K == 0) {
          Toast.makeText(this, super.getString(2131886455, new Object[] { Integer.valueOf(paramFriendResponseInfo.c) }), 0).show();
        }
        localObject = FriendDataManager.a();
        ((FriendDataManager)localObject).a(paramFriendResponseInfo.f, paramFriendResponseInfo.h, paramFriendResponseInfo.i);
        if (this.ag != null)
        {
          paramFriendResponseInfo = this.ag;
          j = paramFriendResponseInfo.length;
          while (i < j)
          {
            String str = paramFriendResponseInfo[i];
            ((FriendDataManager)localObject).c(str);
            this.B.add(((FriendDataManager)localObject).a(str));
            i += 1;
          }
        }
        b(true);
        ((OpenFrame)this.h.getCurrentView()).g();
        this.ai.sendEmptyMessageDelayed(10001, 5000L);
      }
    }
    catch (Exception paramFriendResponseInfo)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GetBuddyList exception.");
      ((StringBuilder)localObject).append(paramFriendResponseInfo.getMessage());
      LogUtility.c("SocialFriendChooser", ((StringBuilder)localObject).toString(), paramFriendResponseInfo);
      paramFriendResponseInfo = new Intent();
      paramFriendResponseInfo.putExtra("key_error_code", -6);
      paramFriendResponseInfo.putExtra("key_error_msg", Constants.d);
      a(paramFriendResponseInfo);
    }
    if (QLog.isColorLevel())
    {
      if ("action_story".equals(this.Q))
      {
        paramFriendResponseInfo = new StringBuilder();
        paramFriendResponseInfo.append("GetShareFriendSwitchEnd:");
        paramFriendResponseInfo.append(SystemClock.elapsedRealtime());
        QLog.d("SDKQQAgentPref", 2, paramFriendResponseInfo.toString());
        return;
      }
      paramFriendResponseInfo = new StringBuilder();
      paramFriendResponseInfo.append("GetInviteFriendSwitch_AGENT:");
      paramFriendResponseInfo.append(SystemClock.elapsedRealtime());
      QLog.d("SDKQQAgentPref", 2, paramFriendResponseInfo.toString());
    }
  }
  
  public void a(Exception paramException)
  {
    o();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SendAppInvitation exception.");
    ((StringBuilder)localObject).append(paramException.getMessage());
    LogUtility.c("SocialFriendChooser", ((StringBuilder)localObject).toString(), paramException);
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
    b((Intent)localObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      o();
      int j = paramJSONObject.getInt("ret");
      localObject = paramJSONObject.getString("msg");
      if (j == 0)
      {
        boolean bool = "action_invite".equals(this.Q);
        int i = 2131887916;
        if (bool)
        {
          StaticAnalyz.a("400", "ANDROIDQQ.INVITE.ASSISTANT", this.O, true);
        }
        else if ("action_ask".equals(this.Q))
        {
          StaticAnalyz.a("400", "ANDROIDQQ.REQUEST.ASSISTANT", this.O, true);
          i = 2131886463;
        }
        else if ("action_gift".equals(this.Q))
        {
          StaticAnalyz.a("400", "ANDROIDQQ.FREEGIFT.ASSISTANT", this.O, true);
          i = 2131886461;
        }
        else if ("action_reactive".equals(this.Q))
        {
          StaticAnalyz.a("400", "ANDROIDQQ.REACTIVE.ASSISTANT", this.O, true);
          i = 2131886462;
        }
        Toast.makeText(this, i, 0).show();
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("key_error_code", j);
      localIntent.putExtra("key_error_msg", (String)localObject);
      localIntent.putExtra("key_response", paramJSONObject.toString());
      b(localIntent);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SendAppInvitation exception.");
      ((StringBuilder)localObject).append(paramJSONObject.getMessage());
      LogUtility.c("SocialFriendChooser", ((StringBuilder)localObject).toString(), paramJSONObject);
      paramJSONObject = new Intent();
      paramJSONObject.putExtra("key_error_code", -4);
      paramJSONObject.putExtra("key_error_msg", Constants.b);
      b(paramJSONObject);
    }
  }
  
  protected void b(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("key_error_code", -6);
    if (i != 0)
    {
      Toast.makeText(this, paramIntent.getStringExtra("key_error_msg"), 0).show();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSendAppInvitationComplete{KEY_ERROR_CODE:");
      localStringBuilder.append(i);
      localStringBuilder.append("; KEY_ERROR_MSG:");
      localStringBuilder.append(paramIntent.getStringExtra("key_error_msg"));
      localStringBuilder.append("}");
      LogUtility.e("SocialFriendChooser", localStringBuilder.toString());
    }
    super.setResult(-1, paramIntent);
    super.finish();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void h()
  {
    if ((!"action_invite".equals(this.Q)) && (!"action_gift".equals(this.Q)) && (!"action_ask".equals(this.Q)) && (!"action_reactive".equals(this.Q)))
    {
      if ("action_story".equals(this.Q))
      {
        Intent localIntent = new Intent();
        Bundle localBundle = new Bundle();
        Friend[] arrayOfFriend = (Friend[])this.B.toArray(new Friend[this.B.size()]);
        localBundle.putInt("key_error_code", 0);
        localBundle.putParcelableArray("RESULT_BUDDIES_SELECTED", arrayOfFriend);
        localIntent.putExtras(localBundle);
        super.setResult(-1, localIntent);
        super.finish();
      }
    }
    else {
      k();
    }
  }
  
  public String i()
  {
    return this.O;
  }
  
  public void j()
  {
    String str;
    if (this.K == 0)
    {
      if ("action_invite".equals(this.Q)) {
        str = super.getString(2131886455, new Object[] { Integer.valueOf(this.L) });
      } else if ("action_ask".equals(this.Q)) {
        str = super.getString(2131886460, new Object[] { Integer.valueOf(this.L) });
      } else if ("action_gift".equals(this.Q)) {
        str = super.getString(2131886454, new Object[] { Integer.valueOf(this.L) });
      } else if ("action_reactive".equals(this.Q)) {
        str = super.getString(2131886455, new Object[] { Integer.valueOf(this.L) });
      } else {
        str = null;
      }
    }
    else {
      str = super.getString(2131887893, new Object[] { Integer.valueOf(this.K) });
    }
    ToastUtil.a().a(str, 0);
  }
  
  protected void k()
  {
    this.af = ProgressDialog.show(this, "", super.getString(2131887924), true);
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.O);
    localBundle.putString("hopenid", this.R);
    localBundle.putString("keystr", this.P);
    localBundle.putString("keytype", this.S);
    localBundle.putString("platform", this.T);
    localBundle.putString("encrytoken", this.U);
    localBundle.putString("agentversion", CommonDataAdapter.a().k());
    localBundle.putString("appid_for_getting_config", this.O);
    if (this.N.containsKey("desc")) {
      localBundle.putString("desc", StringAddition.a(this.N.getString("desc"), 70, true, false));
    }
    if (this.N.containsKey("picurl")) {
      localBundle.putString("picurl", this.N.getString("picurl"));
    }
    if (this.N.containsKey("source")) {
      localBundle.putString("source", this.N.getString("source"));
    }
    if (this.N.containsKey("pf")) {
      localBundle.putString("pf", this.N.getString("pf"));
    }
    if (this.N.containsKey("sdkv")) {
      localBundle.putString("sdkv", this.N.getString("pf"));
    }
    if (this.N.containsKey("sdkp")) {
      localBundle.putString("sdkp", this.N.getString("sdkp"));
    }
    Object localObject1 = new StringBuilder();
    Object localObject2 = new StringBuilder();
    Iterator localIterator = this.C.f().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Friend localFriend = this.C.a(str);
      if (localFriend != null) {
        if (localFriend.g == -1)
        {
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(",");
        }
        else
        {
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append("_");
          ((StringBuilder)localObject2).append(localFriend.g);
          ((StringBuilder)localObject2).append(",");
        }
      }
    }
    int i = ((StringBuilder)localObject1).lastIndexOf(",");
    if (i != -1) {
      ((StringBuilder)localObject1).deleteCharAt(i);
    }
    i = ((StringBuilder)localObject2).lastIndexOf(",");
    if (i != -1) {
      ((StringBuilder)localObject2).deleteCharAt(i);
    }
    localBundle.putString("app_rid", String.valueOf(this.C.f));
    localBundle.putString("app_tid", String.valueOf(this.C.g));
    localBundle.putString("recom_openids", ((StringBuilder)localObject2).toString());
    boolean bool = "action_invite".equals(this.Q);
    localObject2 = null;
    if (bool)
    {
      localBundle.putString("invitedopenids", ((StringBuilder)localObject1).toString());
      localObject2 = ServerSetting.a().a("https://fusion.qq.com/cgi-bin/qzapps/mappinvite_invite.cgi");
      localObject1 = "GET";
    }
    else if ((!"action_gift".equals(this.Q)) && (!"action_ask".equals(this.Q)) && (!"action_reactive".equals(this.Q)))
    {
      localObject1 = null;
    }
    else
    {
      if ("action_reactive".equals(this.Q)) {
        localBundle.putString("imgurl", this.ae);
      } else if (!TextUtils.isEmpty(this.aa)) {
        localBundle.putString("imgurl", this.aa);
      }
      if (!TextUtils.isEmpty(this.Z)) {
        localBundle.putString("title", this.Z);
      }
      if (!TextUtils.isEmpty(this.Y)) {
        localBundle.putString("sendmsg", this.Y);
      }
      localBundle.putString("receiver", ((StringBuilder)localObject1).toString());
      localBundle.putString("typeid", this.X);
      localObject2 = ServerSetting.a().a("https://appic.qq.com/cgi-bin/appstage/mapp_sendrequest.cgi");
      localObject1 = "POST";
    }
    if (localObject2 != null)
    {
      this.ah = new HttpCgiAsyncTask((String)localObject2, (String)localObject1, this, true);
      this.ah.a(localBundle);
      this.ai.sendEmptyMessageDelayed(10002, 45000L);
    }
  }
  
  protected boolean l()
  {
    for (;;)
    {
      try
      {
        this.N = super.getIntent().getBundleExtra("key_params");
        this.Q = super.getIntent().getStringExtra("key_action");
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("-->action = ");
        ((StringBuilder)localObject).append(this.Q);
        ((StringBuilder)localObject).append(" -- mParms = ");
        ((StringBuilder)localObject).append(this.N);
        LogUtility.c("SocialFriendChooser", ((StringBuilder)localObject).toString());
        if ((this.N != null) && (this.N.containsKey("appid")) && (this.N.containsKey("hopenid")) && (this.N.containsKey("keystr")) && (this.N.containsKey("keytype")) && (this.N.containsKey("platform")) && (this.N.containsKey("encrytoken")))
        {
          this.O = this.N.getString("appid");
          this.P = this.N.getString("keystr");
          this.R = this.N.getString("hopenid");
          this.S = this.N.getString("keytype");
          this.T = this.N.getString("platform");
          this.U = this.N.getString("encrytoken");
          if ((!"".equals(this.O.trim())) && (!"".equals(this.R.trim())) && (!"".equals(this.P.trim())) && (!"".equals(this.T.trim())) && (!"".equals(this.S.trim())) && (!"".equals(this.U.trim())))
          {
            boolean bool = "action_gift".equals(this.Q);
            if ((bool) || ("action_ask".equals(this.Q)) || ("action_reactive".equals(this.Q)))
            {
              this.W = this.N.getString("type");
              this.Z = StringAddition.a(this.N.getString("title"), 12, true, false);
              this.Y = StringAddition.a(this.N.getString("msg"), 70, true, false);
              if (!"action_ask".equals(this.Q)) {
                break label882;
              }
              localObject = "50";
              this.X = ((String)localObject);
              if ((!"".equals(this.W.trim())) && (!"".equals(this.Z.trim())) && (!"".equals(this.Y.trim())))
              {
                if ("action_reactive".equals(this.Q))
                {
                  this.X = "51";
                  if ((this.N.containsKey("recImg")) && (this.N.containsKey("recImgDec")) && (this.N.containsKey("sendImg")))
                  {
                    this.ac = this.N.getString("recImg");
                    this.ad = StringAddition.a(this.N.getString("recImgDec"), 20, true, false);
                    this.ae = this.N.getString("sendImg");
                    if (("".equals(this.ac)) || ("".equals(this.ad)) || ("".equals(this.ae)))
                    {
                      m();
                      return false;
                    }
                  }
                  else
                  {
                    m();
                    return false;
                  }
                }
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("-->typeid = ");
                ((StringBuilder)localObject).append(this.X);
                LogUtility.c("SocialFriendChooser", ((StringBuilder)localObject).toString());
              }
            }
            else
            {
              if (this.N.containsKey("pf")) {
                this.V = this.N.getString("pf");
              }
              if (this.N.containsKey("img")) {
                this.aa = this.N.getString("img");
              }
              if (this.N.containsKey("source")) {
                this.ab = this.N.getString("source");
              }
              OpenSdkFriendService.a().a(this.O, this.R);
              this.ag = this.N.getStringArray("BuddiesSelected");
              return true;
            }
            m();
            return false;
          }
          else
          {
            m();
            return false;
          }
        }
        else
        {
          m();
          return false;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initParams exception.");
        localStringBuilder.append(localException.getMessage());
        LogUtility.c("SocialFriendChooser", localStringBuilder.toString(), localException);
        m();
        return false;
      }
      label882:
      String str = "1";
    }
  }
  
  protected void m()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", -5);
    localIntent.putExtra("key_error_msg", Constants.c);
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("initParams:error code:-5; error msg:");
    localStringBuilder1.append(Constants.c);
    LogUtility.e("SocialFriendChooser", localStringBuilder1.toString());
    Object localObject = super.getIntent().getBundleExtra("key_params");
    if (localObject != null)
    {
      localStringBuilder1 = new StringBuilder();
      Iterator localIterator = ((Bundle)localObject).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(str);
        localStringBuilder2.append(": ");
        localStringBuilder2.append(((Bundle)localObject).get(str).toString());
        localStringBuilder2.append(" ");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("params=");
      ((StringBuilder)localObject).append(localStringBuilder1.toString());
      LogUtility.e("SocialFriendChooser", ((StringBuilder)localObject).toString());
    }
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  protected void n()
  {
    this.af = ProgressDialog.show(this, "", getResources().getString(2131887890), true);
    this.af.setCancelable(true);
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.O);
    localBundle.putString("hopenid", this.R);
    localBundle.putString("keystr", this.P);
    localBundle.putString("keytype", this.S);
    localBundle.putString("platform", this.T);
    localBundle.putString("encrytoken", this.U);
    String str = this.V;
    if (str != null) {
      localBundle.putString("pf", str);
    }
    localBundle.putString("appid_for_getting_config", this.O);
    if (("action_gift".equals(this.Q)) || ("action_ask".equals(this.Q)) || ("action_reactive".equals(this.Q))) {
      localBundle.putString("typeid", this.X);
    }
    localBundle.putString("agentversion", CommonDataAdapter.a().k());
    localBundle.putString("appid_for_getting_config", this.O);
    OpenSdkFriendService.a().a(localBundle, this, this.Q);
  }
  
  protected void o()
  {
    ProgressDialog localProgressDialog = this.af;
    if ((localProgressDialog != null) && (localProgressDialog.isShowing())) {
      this.af.dismiss();
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
    super.onCreate(paramBundle);
    this.h.a(0);
    paramBundle = findViewById(2131439607);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.setFitsSystemWindows(paramBundle, true);
    }
    l();
    n();
    if (this.Q.equals("action_invite"))
    {
      paramBundle = super.getString(2131886456);
      ((GroupListOpenFrame)this.h.getCurrentView()).a(paramBundle);
    }
    else if ((this.Q.equals("action_reactive")) || (this.Q.equals("action_gift")) || (this.Q.equals("action_ask")))
    {
      paramBundle = super.getString(2131886458);
      ((GroupListOpenFrame)this.h.getCurrentView()).a(paramBundle);
    }
    if ("action_invite".equals(this.Q))
    {
      StaticAnalyz.a("100", "ANDROIDQQ.INVITE.FS", this.O, true);
      return;
    }
    if ("action_ask".equals(this.Q))
    {
      StaticAnalyz.a("100", "ANDROIDQQ.REQUEST.FS", this.O, true);
      return;
    }
    if ("action_gift".equals(this.Q))
    {
      StaticAnalyz.a("100", "ANDROIDQQ.FREEGIFT.FS", this.O, true);
      return;
    }
    if ("action_reactive".equals(this.Q)) {
      StaticAnalyz.a("100", "ANDROIDQQ.REACTIVE.FS", this.O, true);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.ai.removeMessages(10001);
    OpenSdkFriendService.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.SocialFriendChooser
 * JD-Core Version:    0.7.0.1
 */