package com.tencent.open.agent;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Toast;
import bbtm;
import bbyj;
import bbym;
import bbzg;
import bbzv;
import bbzy;
import bcds;
import bcdy;
import bcec;
import bcen;
import bceo;
import bcew;
import bcfb;
import bcjm;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.qphone.base.util.QLog;
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
  implements bbym, bceo
{
  protected ProgressDialog a;
  public Bundle a;
  public bcen a;
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
    this.jdField_b_of_type_AndroidOsHandler = new bbzg(this);
  }
  
  protected int a()
  {
    return 2131493921;
  }
  
  public String a()
  {
    return this.d;
  }
  
  public void a(Intent paramIntent)
  {
    l();
    if (paramIntent.hasExtra("key_error_msg")) {
      Toast.makeText(bbtm.a().a(), paramIntent.getStringExtra("key_error_msg"), 0).show();
    }
    int i1 = paramIntent.getIntExtra("key_error_code", -6);
    if (i1 != 0) {
      bcds.e("SocialFriendChooser", "onGetBuddyListError{KEY_ERROR_CODE:" + i1 + "; KEY_ERROR_MSG:" + paramIntent.getStringExtra("key_error_msg") + "}");
    }
    super.setResult(-1, paramIntent);
    super.finish();
  }
  
  public void a(bbzy parambbzy)
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        l();
        if (("action_gift".equals(this.f)) || ("action_ask".equals(this.f)) || ("action_invite".equals(this.f)) || ("action_reactive".equals(this.f)) || ("action_story".equals(this.f)))
        {
          this.jdField_a_of_type_Int = parambbzy.d;
          if (parambbzy.jdField_b_of_type_Int != -1)
          {
            if (parambbzy.jdField_b_of_type_Int - parambbzy.c == 0)
            {
              this.jdField_a_of_type_Int = 0;
              this.jdField_b_of_type_Int = parambbzy.jdField_b_of_type_Int;
            }
          }
          else
          {
            if (this.jdField_a_of_type_Int == 0) {
              Toast.makeText(this, super.getString(2131624318, new Object[] { Integer.valueOf(parambbzy.jdField_b_of_type_Int) }), 0).show();
            }
            bbzv localbbzv = bbzv.a();
            localbbzv.a(parambbzy.a, parambbzy.e, parambbzy.f);
            if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
              break label357;
            }
            parambbzy = this.jdField_a_of_type_ArrayOfJavaLangString;
            int i2 = parambbzy.length;
            if (i1 >= i2) {
              break label357;
            }
            String str = parambbzy[i1];
            localbbzv.a(str);
            this.jdField_b_of_type_JavaUtilArrayList.add(localbbzv.a(str));
            i1 += 1;
            continue;
          }
          if (parambbzy.jdField_b_of_type_Int - parambbzy.c >= this.jdField_a_of_type_Int) {
            continue;
          }
          this.jdField_a_of_type_Int = (parambbzy.jdField_b_of_type_Int - parambbzy.c);
          continue;
        }
        b(true);
      }
      catch (Exception parambbzy)
      {
        bcds.c("SocialFriendChooser", "GetBuddyList exception." + parambbzy.getMessage(), parambbzy);
        parambbzy = new Intent();
        parambbzy.putExtra("key_error_code", -6);
        parambbzy.putExtra("key_error_msg", bcew.d);
        a(parambbzy);
        if (QLog.isColorLevel())
        {
          if (!"action_story".equals(this.f)) {
            break;
          }
          QLog.d("SDKQQAgentPref", 2, "GetShareFriendSwitchEnd:" + SystemClock.elapsedRealtime());
        }
        return;
      }
      label357:
      ((OpenFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).g();
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10001, 5000L);
    }
    QLog.d("SDKQQAgentPref", 2, "GetInviteFriendSwitch_AGENT:" + SystemClock.elapsedRealtime());
  }
  
  public void a(Exception paramException)
  {
    l();
    bcds.c("SocialFriendChooser", "SendAppInvitation exception." + paramException.getMessage(), paramException);
    Intent localIntent = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      localIntent.putExtra("key_error_code", -7);
      localIntent.putExtra("key_error_msg", bcew.e);
    }
    for (;;)
    {
      b(localIntent);
      return;
      if ((paramException instanceof SocketTimeoutException))
      {
        localIntent.putExtra("key_error_code", -8);
        localIntent.putExtra("key_error_msg", bcew.f);
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
        localIntent.putExtra("key_error_msg", bcew.g);
      }
      else if ((paramException instanceof IOException))
      {
        localIntent.putExtra("key_error_code", -2);
        localIntent.putExtra("key_error_msg", bcew.a);
      }
      else
      {
        localIntent.putExtra("key_error_code", -6);
        localIntent.putExtra("key_error_msg", bcew.d);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    int i1 = 2131625363;
    try
    {
      l();
      int i2 = paramJSONObject.getInt("ret");
      String str = paramJSONObject.getString("msg");
      if (i2 == 0)
      {
        if (!"action_invite".equals(this.f)) {
          break label111;
        }
        bcfb.a("400", "ANDROIDQQ.INVITE.ASSISTANT", this.d);
      }
      for (;;)
      {
        Toast.makeText(this, i1, 0).show();
        Intent localIntent = new Intent();
        localIntent.putExtra("key_error_code", i2);
        localIntent.putExtra("key_error_msg", str);
        localIntent.putExtra("key_response", paramJSONObject.toString());
        b(localIntent);
        return;
        label111:
        if ("action_ask".equals(this.f))
        {
          bcfb.a("400", "ANDROIDQQ.REQUEST.ASSISTANT", this.d);
          i1 = 2131624326;
        }
        else if ("action_gift".equals(this.f))
        {
          bcfb.a("400", "ANDROIDQQ.FREEGIFT.ASSISTANT", this.d);
          i1 = 2131624324;
        }
        else if ("action_reactive".equals(this.f))
        {
          bcfb.a("400", "ANDROIDQQ.REACTIVE.ASSISTANT", this.d);
          i1 = 2131624325;
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      bcds.c("SocialFriendChooser", "SendAppInvitation exception." + paramJSONObject.getMessage(), paramJSONObject);
      paramJSONObject = new Intent();
      paramJSONObject.putExtra("key_error_code", -4);
      paramJSONObject.putExtra("key_error_msg", bcew.b);
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
        bcds.c("SocialFriendChooser", "-->action = " + this.f + " -- mParms = " + this.jdField_a_of_type_AndroidOsBundle);
        if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("appid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("hopenid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("keystr")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("keytype")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("platform")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("encrytoken")))
        {
          this.d = this.jdField_a_of_type_AndroidOsBundle.getString("appid");
          this.e = this.jdField_a_of_type_AndroidOsBundle.getString("keystr");
          this.g = this.jdField_a_of_type_AndroidOsBundle.getString("hopenid");
          this.h = this.jdField_a_of_type_AndroidOsBundle.getString("keytype");
          this.i = this.jdField_a_of_type_AndroidOsBundle.getString("platform");
          this.j = this.jdField_a_of_type_AndroidOsBundle.getString("encrytoken");
          if (("".equals(this.d.trim())) || ("".equals(this.g.trim())) || ("".equals(this.e.trim())) || ("".equals(this.i.trim())) || ("".equals(this.h.trim())) || ("".equals(this.j.trim())))
          {
            j();
            return false;
          }
          if (("action_gift".equals(this.f)) || ("action_ask".equals(this.f)) || ("action_reactive".equals(this.f)))
          {
            this.l = this.jdField_a_of_type_AndroidOsBundle.getString("type");
            this.o = bcdy.a(this.jdField_a_of_type_AndroidOsBundle.getString("title"), 12, true, false);
            this.n = bcdy.a(this.jdField_a_of_type_AndroidOsBundle.getString("msg"), 70, true, false);
            if (!"action_ask".equals(this.f)) {
              break label846;
            }
            String str1 = "50";
            this.m = str1;
            if (("".equals(this.l.trim())) || ("".equals(this.o.trim())) || ("".equals(this.n.trim())))
            {
              j();
              return false;
            }
            if ("action_reactive".equals(this.f))
            {
              this.m = "51";
              if ((!this.jdField_a_of_type_AndroidOsBundle.containsKey("recImg")) || (!this.jdField_a_of_type_AndroidOsBundle.containsKey("recImgDec")) || (!this.jdField_a_of_type_AndroidOsBundle.containsKey("sendImg")))
              {
                j();
                return false;
              }
              this.r = this.jdField_a_of_type_AndroidOsBundle.getString("recImg");
              this.s = bcdy.a(this.jdField_a_of_type_AndroidOsBundle.getString("recImgDec"), 20, true, false);
              this.t = this.jdField_a_of_type_AndroidOsBundle.getString("sendImg");
              if (("".equals(this.r)) || ("".equals(this.s)) || ("".equals(this.t)))
              {
                j();
                return false;
              }
            }
            bcds.c("SocialFriendChooser", "-->typeid = " + this.m);
          }
          if (this.jdField_a_of_type_AndroidOsBundle.containsKey("pf")) {
            this.k = this.jdField_a_of_type_AndroidOsBundle.getString("pf");
          }
          if (this.jdField_a_of_type_AndroidOsBundle.containsKey("img")) {
            this.p = this.jdField_a_of_type_AndroidOsBundle.getString("img");
          }
          if (this.jdField_a_of_type_AndroidOsBundle.containsKey("source")) {
            this.q = this.jdField_a_of_type_AndroidOsBundle.getString("source");
          }
          bbyj.a().a(this.d, this.g);
          this.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_AndroidOsBundle.getStringArray("BuddiesSelected");
          return true;
        }
      }
      catch (Exception localException)
      {
        bcds.c("SocialFriendChooser", "initParams exception." + localException.getMessage(), localException);
        j();
        return false;
      }
      j();
      return false;
      label846:
      String str2 = "1";
    }
  }
  
  protected void b(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("key_error_code", -6);
    if (i1 != 0)
    {
      Toast.makeText(this, paramIntent.getStringExtra("key_error_msg"), 0).show();
      bcds.e("SocialFriendChooser", "onSendAppInvitationComplete{KEY_ERROR_CODE:" + i1 + "; KEY_ERROR_MSG:" + paramIntent.getStringExtra("key_error_msg") + "}");
    }
    super.setResult(-1, paramIntent);
    super.finish();
  }
  
  protected void g()
  {
    if (("action_invite".equals(this.f)) || ("action_gift".equals(this.f)) || ("action_ask".equals(this.f)) || ("action_reactive".equals(this.f))) {
      i();
    }
    while (!"action_story".equals(this.f)) {
      return;
    }
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    Friend[] arrayOfFriend = (Friend[])this.jdField_b_of_type_JavaUtilArrayList.toArray(new Friend[this.jdField_b_of_type_JavaUtilArrayList.size()]);
    localBundle.putInt("key_error_code", 0);
    localBundle.putParcelableArray("RESULT_BUDDIES_SELECTED", arrayOfFriend);
    localIntent.putExtras(localBundle);
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  public void h()
  {
    String str = null;
    if (this.jdField_a_of_type_Int == 0) {
      if ("action_invite".equals(this.f)) {
        str = super.getString(2131624318, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) });
      }
    }
    for (;;)
    {
      bcec.a().a(str, 0);
      return;
      if ("action_ask".equals(this.f))
      {
        str = super.getString(2131624323, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) });
      }
      else if ("action_gift".equals(this.f))
      {
        str = super.getString(2131624317, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) });
      }
      else if ("action_reactive".equals(this.f))
      {
        str = super.getString(2131624318, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) });
        continue;
        str = super.getString(2131625340, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      }
    }
  }
  
  protected void i()
  {
    String str1 = null;
    this.jdField_a_of_type_AndroidAppProgressDialog = ProgressDialog.show(this, "", super.getString(2131625371), true);
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.d);
    localBundle.putString("hopenid", this.g);
    localBundle.putString("keystr", this.e);
    localBundle.putString("keytype", this.h);
    localBundle.putString("platform", this.i);
    localBundle.putString("encrytoken", this.j);
    localBundle.putString("agentversion", bbtm.a().e());
    localBundle.putString("appid_for_getting_config", this.d);
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("desc")) {
      localBundle.putString("desc", bcdy.a(this.jdField_a_of_type_AndroidOsBundle.getString("desc"), 70, true, false));
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
    Object localObject = new StringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_Bbzv.b().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      Friend localFriend = this.jdField_a_of_type_Bbzv.a(str2);
      if (localFriend != null) {
        if (localFriend.jdField_b_of_type_Int == -1) {
          ((StringBuilder)localObject).append(str2).append(",");
        } else {
          localStringBuilder.append(str2).append("_").append(localFriend.jdField_b_of_type_Int).append(",");
        }
      }
    }
    int i1 = ((StringBuilder)localObject).lastIndexOf(",");
    if (i1 != -1) {
      ((StringBuilder)localObject).deleteCharAt(i1);
    }
    i1 = localStringBuilder.lastIndexOf(",");
    if (i1 != -1) {
      localStringBuilder.deleteCharAt(i1);
    }
    localBundle.putString("app_rid", String.valueOf(this.jdField_a_of_type_Bbzv.jdField_a_of_type_Int));
    localBundle.putString("app_tid", String.valueOf(this.jdField_a_of_type_Bbzv.jdField_b_of_type_Int));
    localBundle.putString("recom_openids", localStringBuilder.toString());
    if ("action_invite".equals(this.f))
    {
      localBundle.putString("invitedopenids", ((StringBuilder)localObject).toString());
      str1 = bcjm.a().a("http://fusion.qq.com/cgi-bin/qzapps/mappinvite_invite.cgi");
      localObject = "GET";
    }
    for (;;)
    {
      if (str1 != null)
      {
        this.jdField_a_of_type_Bcen = new bcen(str1, (String)localObject, this);
        this.jdField_a_of_type_Bcen.a(localBundle);
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10002, 45000L);
      }
      return;
      if (("action_gift".equals(this.f)) || ("action_ask".equals(this.f)) || ("action_reactive".equals(this.f)))
      {
        if ("action_reactive".equals(this.f)) {
          localBundle.putString("imgurl", this.t);
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(this.o)) {
            localBundle.putString("title", this.o);
          }
          if (!TextUtils.isEmpty(this.n)) {
            localBundle.putString("sendmsg", this.n);
          }
          localBundle.putString("receiver", ((StringBuilder)localObject).toString());
          localBundle.putString("typeid", this.m);
          str1 = bcjm.a().a("http://appic.qq.com/cgi-bin/appstage/mapp_sendrequest.cgi");
          localObject = "POST";
          break;
          if (!TextUtils.isEmpty(this.p)) {
            localBundle.putString("imgurl", this.p);
          }
        }
      }
      localObject = null;
    }
  }
  
  protected void j()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", -5);
    localIntent.putExtra("key_error_msg", bcew.c);
    bcds.e("SocialFriendChooser", "initParams:error code:-5; error msg:" + bcew.c);
    Bundle localBundle = super.getIntent().getBundleExtra("key_params");
    if (localBundle != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = localBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append(str + ": " + localBundle.get(str).toString() + " ");
      }
      bcds.e("SocialFriendChooser", "params=" + localStringBuilder.toString());
    }
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  protected void k()
  {
    this.jdField_a_of_type_AndroidAppProgressDialog = ProgressDialog.show(this, "", getResources().getString(2131625337), true);
    this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.d);
    localBundle.putString("hopenid", this.g);
    localBundle.putString("keystr", this.e);
    localBundle.putString("keytype", this.h);
    localBundle.putString("platform", this.i);
    localBundle.putString("encrytoken", this.j);
    if (this.k != null) {
      localBundle.putString("pf", this.k);
    }
    localBundle.putString("appid_for_getting_config", this.d);
    if (("action_gift".equals(this.f)) || ("action_ask".equals(this.f)) || ("action_reactive".equals(this.f))) {
      localBundle.putString("typeid", this.m);
    }
    localBundle.putString("agentversion", bbtm.a().e());
    localBundle.putString("appid_for_getting_config", this.d);
    bbyj.a().a(localBundle, this, this.f);
  }
  
  public void l()
  {
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
    paramBundle = findViewById(2131305380);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.a(paramBundle, true);
    }
    a();
    k();
    if (this.f.equals("action_invite"))
    {
      paramBundle = super.getString(2131624319);
      ((GroupListOpenFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).a(paramBundle);
    }
    do
    {
      while ("action_invite".equals(this.f))
      {
        bcfb.a("100", "ANDROIDQQ.INVITE.FS", this.d);
        return;
        if ((this.f.equals("action_reactive")) || (this.f.equals("action_gift")) || (this.f.equals("action_ask")))
        {
          paramBundle = super.getString(2131624321);
          ((GroupListOpenFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).a(paramBundle);
        }
      }
      if ("action_ask".equals(this.f))
      {
        bcfb.a("100", "ANDROIDQQ.REQUEST.FS", this.d);
        return;
      }
      if ("action_gift".equals(this.f))
      {
        bcfb.a("100", "ANDROIDQQ.FREEGIFT.FS", this.d);
        return;
      }
    } while (!"action_reactive".equals(this.f));
    bcfb.a("100", "ANDROIDQQ.REACTIVE.FS", this.d);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(10001);
    bbyj.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.SocialFriendChooser
 * JD-Core Version:    0.7.0.1
 */