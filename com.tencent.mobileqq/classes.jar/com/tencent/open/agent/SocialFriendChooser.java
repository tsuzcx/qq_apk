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
  protected ProgressDialog a;
  protected Bundle a;
  protected HttpCgiAsyncTask a;
  protected String[] a;
  protected Handler b;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  protected String h;
  protected String i;
  protected String j;
  protected String k;
  protected String l;
  protected String m;
  protected String n;
  protected String o;
  protected String p;
  protected String q;
  protected String r;
  protected String s;
  protected String t;
  
  public SocialFriendChooser()
  {
    this.jdField_a_of_type_AndroidAppProgressDialog = null;
    this.jdField_b_of_type_AndroidOsHandler = new SocialFriendChooser.1(this);
  }
  
  protected int a()
  {
    return 2131559673;
  }
  
  public String a()
  {
    return this.d;
  }
  
  public void a(Intent paramIntent)
  {
    l();
    if (paramIntent.hasExtra("key_error_msg")) {
      Toast.makeText(CommonDataAdapter.a().a(), paramIntent.getStringExtra("key_error_msg"), 0).show();
    }
    int i1 = paramIntent.getIntExtra("key_error_code", -6);
    if (i1 != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetBuddyListError{KEY_ERROR_CODE:");
      localStringBuilder.append(i1);
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
      l();
      if (("action_gift".equals(this.f)) || ("action_ask".equals(this.f)) || ("action_invite".equals(this.f)) || ("action_reactive".equals(this.f)) || ("action_story".equals(this.f)))
      {
        this.jdField_a_of_type_Int = paramFriendResponseInfo.d;
        int i2 = paramFriendResponseInfo.jdField_b_of_type_Int;
        int i1 = 0;
        if (i2 != -1)
        {
          if (paramFriendResponseInfo.jdField_b_of_type_Int - paramFriendResponseInfo.c == 0) {
            this.jdField_a_of_type_Int = 0;
          } else if (paramFriendResponseInfo.jdField_b_of_type_Int - paramFriendResponseInfo.c < this.jdField_a_of_type_Int) {
            this.jdField_a_of_type_Int = (paramFriendResponseInfo.jdField_b_of_type_Int - paramFriendResponseInfo.c);
          }
          this.jdField_b_of_type_Int = paramFriendResponseInfo.jdField_b_of_type_Int;
        }
        if (this.jdField_a_of_type_Int == 0) {
          Toast.makeText(this, super.getString(2131689814, new Object[] { Integer.valueOf(paramFriendResponseInfo.jdField_b_of_type_Int) }), 0).show();
        }
        localObject = FriendDataManager.a();
        ((FriendDataManager)localObject).a(paramFriendResponseInfo.a, paramFriendResponseInfo.e, paramFriendResponseInfo.f);
        if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
        {
          paramFriendResponseInfo = this.jdField_a_of_type_ArrayOfJavaLangString;
          i2 = paramFriendResponseInfo.length;
          while (i1 < i2)
          {
            String str = paramFriendResponseInfo[i1];
            ((FriendDataManager)localObject).a(str);
            this.jdField_b_of_type_JavaUtilArrayList.add(((FriendDataManager)localObject).a(str));
            i1 += 1;
          }
        }
        b(true);
        ((OpenFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).g();
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10001, 5000L);
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
      if ("action_story".equals(this.f))
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
    l();
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
      l();
      int i2 = paramJSONObject.getInt("ret");
      localObject = paramJSONObject.getString("msg");
      if (i2 == 0)
      {
        boolean bool = "action_invite".equals(this.f);
        int i1 = 2131690977;
        if (bool)
        {
          StaticAnalyz.a("400", "ANDROIDQQ.INVITE.ASSISTANT", this.d, true);
        }
        else if ("action_ask".equals(this.f))
        {
          StaticAnalyz.a("400", "ANDROIDQQ.REQUEST.ASSISTANT", this.d, true);
          i1 = 2131689822;
        }
        else if ("action_gift".equals(this.f))
        {
          StaticAnalyz.a("400", "ANDROIDQQ.FREEGIFT.ASSISTANT", this.d, true);
          i1 = 2131689820;
        }
        else if ("action_reactive".equals(this.f))
        {
          StaticAnalyz.a("400", "ANDROIDQQ.REACTIVE.ASSISTANT", this.d, true);
          i1 = 2131689821;
        }
        Toast.makeText(this, i1, 0).show();
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("key_error_code", i2);
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
  
  protected boolean a()
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
        this.f = super.getIntent().getStringExtra("key_action");
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("-->action = ");
        ((StringBuilder)localObject).append(this.f);
        ((StringBuilder)localObject).append(" -- mParms = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidOsBundle);
        LogUtility.c("SocialFriendChooser", ((StringBuilder)localObject).toString());
        if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("appid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("hopenid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("keystr")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("keytype")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("platform")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("encrytoken")))
        {
          this.d = this.jdField_a_of_type_AndroidOsBundle.getString("appid");
          this.e = this.jdField_a_of_type_AndroidOsBundle.getString("keystr");
          this.g = this.jdField_a_of_type_AndroidOsBundle.getString("hopenid");
          this.h = this.jdField_a_of_type_AndroidOsBundle.getString("keytype");
          this.i = this.jdField_a_of_type_AndroidOsBundle.getString("platform");
          this.j = this.jdField_a_of_type_AndroidOsBundle.getString("encrytoken");
          if ((!"".equals(this.d.trim())) && (!"".equals(this.g.trim())) && (!"".equals(this.e.trim())) && (!"".equals(this.i.trim())) && (!"".equals(this.h.trim())) && (!"".equals(this.j.trim())))
          {
            boolean bool = "action_gift".equals(this.f);
            if ((bool) || ("action_ask".equals(this.f)) || ("action_reactive".equals(this.f)))
            {
              this.l = this.jdField_a_of_type_AndroidOsBundle.getString("type");
              this.o = StringAddition.a(this.jdField_a_of_type_AndroidOsBundle.getString("title"), 12, true, false);
              this.n = StringAddition.a(this.jdField_a_of_type_AndroidOsBundle.getString("msg"), 70, true, false);
              if (!"action_ask".equals(this.f)) {
                break label882;
              }
              localObject = "50";
              this.m = ((String)localObject);
              if ((!"".equals(this.l.trim())) && (!"".equals(this.o.trim())) && (!"".equals(this.n.trim())))
              {
                if ("action_reactive".equals(this.f))
                {
                  this.m = "51";
                  if ((this.jdField_a_of_type_AndroidOsBundle.containsKey("recImg")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("recImgDec")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("sendImg")))
                  {
                    this.r = this.jdField_a_of_type_AndroidOsBundle.getString("recImg");
                    this.s = StringAddition.a(this.jdField_a_of_type_AndroidOsBundle.getString("recImgDec"), 20, true, false);
                    this.t = this.jdField_a_of_type_AndroidOsBundle.getString("sendImg");
                    if (("".equals(this.r)) || ("".equals(this.s)) || ("".equals(this.t)))
                    {
                      j();
                      return false;
                    }
                  }
                  else
                  {
                    j();
                    return false;
                  }
                }
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("-->typeid = ");
                ((StringBuilder)localObject).append(this.m);
                LogUtility.c("SocialFriendChooser", ((StringBuilder)localObject).toString());
              }
            }
            else
            {
              if (this.jdField_a_of_type_AndroidOsBundle.containsKey("pf")) {
                this.k = this.jdField_a_of_type_AndroidOsBundle.getString("pf");
              }
              if (this.jdField_a_of_type_AndroidOsBundle.containsKey("img")) {
                this.p = this.jdField_a_of_type_AndroidOsBundle.getString("img");
              }
              if (this.jdField_a_of_type_AndroidOsBundle.containsKey("source")) {
                this.q = this.jdField_a_of_type_AndroidOsBundle.getString("source");
              }
              OpenSdkFriendService.a().a(this.d, this.g);
              this.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_AndroidOsBundle.getStringArray("BuddiesSelected");
              return true;
            }
            j();
            return false;
          }
          else
          {
            j();
            return false;
          }
        }
        else
        {
          j();
          return false;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initParams exception.");
        localStringBuilder.append(localException.getMessage());
        LogUtility.c("SocialFriendChooser", localStringBuilder.toString(), localException);
        j();
        return false;
      }
      label882:
      String str = "1";
    }
  }
  
  protected void b(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("key_error_code", -6);
    if (i1 != 0)
    {
      Toast.makeText(this, paramIntent.getStringExtra("key_error_msg"), 0).show();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSendAppInvitationComplete{KEY_ERROR_CODE:");
      localStringBuilder.append(i1);
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
  
  protected void g()
  {
    if ((!"action_invite".equals(this.f)) && (!"action_gift".equals(this.f)) && (!"action_ask".equals(this.f)) && (!"action_reactive".equals(this.f)))
    {
      if ("action_story".equals(this.f))
      {
        Intent localIntent = new Intent();
        Bundle localBundle = new Bundle();
        Friend[] arrayOfFriend = (Friend[])this.jdField_b_of_type_JavaUtilArrayList.toArray(new Friend[this.jdField_b_of_type_JavaUtilArrayList.size()]);
        localBundle.putInt("key_error_code", 0);
        localBundle.putParcelableArray("RESULT_BUDDIES_SELECTED", arrayOfFriend);
        localIntent.putExtras(localBundle);
        super.setResult(-1, localIntent);
        super.finish();
      }
    }
    else {
      i();
    }
  }
  
  public void h()
  {
    String str;
    if (this.jdField_a_of_type_Int == 0)
    {
      if ("action_invite".equals(this.f)) {
        str = super.getString(2131689814, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) });
      } else if ("action_ask".equals(this.f)) {
        str = super.getString(2131689819, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) });
      } else if ("action_gift".equals(this.f)) {
        str = super.getString(2131689813, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) });
      } else if ("action_reactive".equals(this.f)) {
        str = super.getString(2131689814, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) });
      } else {
        str = null;
      }
    }
    else {
      str = super.getString(2131690954, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    ToastUtil.a().a(str, 0);
  }
  
  protected void i()
  {
    this.jdField_a_of_type_AndroidAppProgressDialog = ProgressDialog.show(this, "", super.getString(2131690985), true);
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.d);
    localBundle.putString("hopenid", this.g);
    localBundle.putString("keystr", this.e);
    localBundle.putString("keytype", this.h);
    localBundle.putString("platform", this.i);
    localBundle.putString("encrytoken", this.j);
    localBundle.putString("agentversion", CommonDataAdapter.a().e());
    localBundle.putString("appid_for_getting_config", this.d);
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("desc")) {
      localBundle.putString("desc", StringAddition.a(this.jdField_a_of_type_AndroidOsBundle.getString("desc"), 70, true, false));
    }
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("picurl")) {
      localBundle.putString("picurl", this.jdField_a_of_type_AndroidOsBundle.getString("picurl"));
    }
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("source")) {
      localBundle.putString("source", this.jdField_a_of_type_AndroidOsBundle.getString("source"));
    }
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("pf")) {
      localBundle.putString("pf", this.jdField_a_of_type_AndroidOsBundle.getString("pf"));
    }
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("sdkv")) {
      localBundle.putString("sdkv", this.jdField_a_of_type_AndroidOsBundle.getString("pf"));
    }
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("sdkp")) {
      localBundle.putString("sdkp", this.jdField_a_of_type_AndroidOsBundle.getString("sdkp"));
    }
    Object localObject1 = new StringBuilder();
    Object localObject2 = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.b().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Friend localFriend = this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(str);
      if (localFriend != null) {
        if (localFriend.jdField_b_of_type_Int == -1)
        {
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(",");
        }
        else
        {
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append("_");
          ((StringBuilder)localObject2).append(localFriend.jdField_b_of_type_Int);
          ((StringBuilder)localObject2).append(",");
        }
      }
    }
    int i1 = ((StringBuilder)localObject1).lastIndexOf(",");
    if (i1 != -1) {
      ((StringBuilder)localObject1).deleteCharAt(i1);
    }
    i1 = ((StringBuilder)localObject2).lastIndexOf(",");
    if (i1 != -1) {
      ((StringBuilder)localObject2).deleteCharAt(i1);
    }
    localBundle.putString("app_rid", String.valueOf(this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.jdField_a_of_type_Int));
    localBundle.putString("app_tid", String.valueOf(this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.jdField_b_of_type_Int));
    localBundle.putString("recom_openids", ((StringBuilder)localObject2).toString());
    boolean bool = "action_invite".equals(this.f);
    localObject2 = null;
    if (bool)
    {
      localBundle.putString("invitedopenids", ((StringBuilder)localObject1).toString());
      localObject2 = ServerSetting.a().a("https://fusion.qq.com/cgi-bin/qzapps/mappinvite_invite.cgi");
      localObject1 = "GET";
    }
    else if ((!"action_gift".equals(this.f)) && (!"action_ask".equals(this.f)) && (!"action_reactive".equals(this.f)))
    {
      localObject1 = null;
    }
    else
    {
      if ("action_reactive".equals(this.f)) {
        localBundle.putString("imgurl", this.t);
      } else if (!TextUtils.isEmpty(this.p)) {
        localBundle.putString("imgurl", this.p);
      }
      if (!TextUtils.isEmpty(this.o)) {
        localBundle.putString("title", this.o);
      }
      if (!TextUtils.isEmpty(this.n)) {
        localBundle.putString("sendmsg", this.n);
      }
      localBundle.putString("receiver", ((StringBuilder)localObject1).toString());
      localBundle.putString("typeid", this.m);
      localObject2 = ServerSetting.a().a("https://appic.qq.com/cgi-bin/appstage/mapp_sendrequest.cgi");
      localObject1 = "POST";
    }
    if (localObject2 != null)
    {
      this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask = new HttpCgiAsyncTask((String)localObject2, (String)localObject1, this, true);
      this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask.a(localBundle);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10002, 45000L);
    }
  }
  
  protected void j()
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
  
  protected void k()
  {
    this.jdField_a_of_type_AndroidAppProgressDialog = ProgressDialog.show(this, "", getResources().getString(2131690951), true);
    this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.d);
    localBundle.putString("hopenid", this.g);
    localBundle.putString("keystr", this.e);
    localBundle.putString("keytype", this.h);
    localBundle.putString("platform", this.i);
    localBundle.putString("encrytoken", this.j);
    String str = this.k;
    if (str != null) {
      localBundle.putString("pf", str);
    }
    localBundle.putString("appid_for_getting_config", this.d);
    if (("action_gift".equals(this.f)) || ("action_ask".equals(this.f)) || ("action_reactive".equals(this.f))) {
      localBundle.putString("typeid", this.m);
    }
    localBundle.putString("agentversion", CommonDataAdapter.a().e());
    localBundle.putString("appid_for_getting_config", this.d);
    OpenSdkFriendService.a().a(localBundle, this, this.f);
  }
  
  protected void l()
  {
    ProgressDialog localProgressDialog = this.jdField_a_of_type_AndroidAppProgressDialog;
    if ((localProgressDialog != null) && (localProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
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
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
    paramBundle = findViewById(2131372135);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.setFitsSystemWindows(paramBundle, true);
    }
    a();
    k();
    if (this.f.equals("action_invite"))
    {
      paramBundle = super.getString(2131689815);
      ((GroupListOpenFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).a(paramBundle);
    }
    else if ((this.f.equals("action_reactive")) || (this.f.equals("action_gift")) || (this.f.equals("action_ask")))
    {
      paramBundle = super.getString(2131689817);
      ((GroupListOpenFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).a(paramBundle);
    }
    if ("action_invite".equals(this.f))
    {
      StaticAnalyz.a("100", "ANDROIDQQ.INVITE.FS", this.d, true);
      return;
    }
    if ("action_ask".equals(this.f))
    {
      StaticAnalyz.a("100", "ANDROIDQQ.REQUEST.FS", this.d, true);
      return;
    }
    if ("action_gift".equals(this.f))
    {
      StaticAnalyz.a("100", "ANDROIDQQ.FREEGIFT.FS", this.d, true);
      return;
    }
    if ("action_reactive".equals(this.f)) {
      StaticAnalyz.a("100", "ANDROIDQQ.REACTIVE.FS", this.d, true);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(10001);
    OpenSdkFriendService.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.SocialFriendChooser
 * JD-Core Version:    0.7.0.1
 */