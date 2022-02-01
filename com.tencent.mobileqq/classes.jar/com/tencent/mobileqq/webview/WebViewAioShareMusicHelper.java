package com.tencent.mobileqq.webview;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aiosharemusic.AioShareMusicIPCWebClient;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewAioShareMusicHelper
{
  public String a;
  private WebViewFragment b;
  private String c;
  private int d;
  private boolean e;
  private String f;
  private int g;
  private String h;
  private int i;
  private int j;
  private boolean k;
  private boolean l;
  private boolean m;
  
  public WebViewAioShareMusicHelper(WebViewFragment paramWebViewFragment)
  {
    this.b = paramWebViewFragment;
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = this.b.getAppRuntime().getEntityManagerFactory(this.b.getAppRuntime().getAccount()).createEntityManager();
    paramString = (TroopInfo)((EntityManager)localObject).find(TroopInfo.class, paramString);
    ((EntityManager)localObject).close();
    if (paramString != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" isTroopAdminOrOwner() troopInfo = ");
        ((StringBuilder)localObject).append(paramString.isAdmin());
        QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, ((StringBuilder)localObject).toString());
      }
      if ((paramString.isTroopOwner(this.b.getAppRuntime().getAccount())) || (paramString.isAdmin())) {
        return true;
      }
    }
    return false;
  }
  
  private void b(String paramString)
  {
    if (this.b != null) {
      QQToast.makeText(BaseApplicationImpl.getApplication(), paramString, 1).show();
    }
  }
  
  private boolean b()
  {
    return (!TextUtils.isEmpty(this.h)) && (this.b.getAppRuntime().getAccount().equals(this.h));
  }
  
  private void c(Intent paramIntent)
  {
    Object localObject1 = paramIntent.getStringExtra("forward_ark_app_meta");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1).getJSONObject("music");
        Object localObject3 = paramIntent.getExtras();
        if (this.d != 0) {
          break label344;
        }
        paramIntent = "friend_uin";
        Object localObject2 = ((Bundle)localObject3).getString(paramIntent, "");
        if (this.d != 0) {
          break label350;
        }
        paramIntent = "h5_ark_url_web_sender_uin";
        paramIntent = ((Bundle)localObject3).getString(paramIntent);
        int i1 = ((JSONObject)localObject1).getInt("appid");
        Object localObject4 = ((JSONObject)localObject1).getString("title");
        localObject3 = ((JSONObject)localObject1).getString("musicUrl");
        String str = ((JSONObject)localObject1).getString("desc");
        localObject1 = new JSONObject();
        if (this.d != 0) {
          break label356;
        }
        n = 2;
        ((JSONObject)localObject1).put("enum_aio_type", n);
        ((JSONObject)localObject1).put("uint64_id", localObject2);
        ((JSONObject)localObject1).put("uint32_share_appid", i1);
        ((JSONObject)localObject1).put("bytes_song_name", localObject4);
        localObject2 = new JSONArray();
        localObject4 = new JSONObject();
        ((JSONObject)localObject4).put("singer", str);
        ((JSONArray)localObject2).put(localObject4);
        ((JSONObject)localObject1).put("rpt_bytes_singer", localObject2);
        ((JSONObject)localObject1).put("bytes_song_url", localObject3);
        ((JSONObject)localObject1).put("bool_cut_song", this.e);
        ((JSONObject)localObject1).put("str_song_id", this.f);
        ((JSONObject)localObject1).put("uint32_duration", this.g);
        ((JSONObject)localObject1).put("uint64_sharer_uin", paramIntent);
        ((JSONObject)localObject1).put("bytes_cover", this.c);
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("realStartAioShareMusic() jsonObject = ");
          paramIntent.append(((JSONObject)localObject1).toString());
          QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, paramIntent.toString());
        }
        AioShareMusicIPCWebClient.a((JSONObject)localObject1, "startListenAioShareMusic", null);
        return;
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
      }
      return;
      label344:
      paramIntent = "groupUin";
      continue;
      label350:
      paramIntent = "friendUin";
      continue;
      label356:
      int n = 1;
    }
  }
  
  private void c(String paramString)
  {
    WebViewFragment localWebViewFragment = this.b;
    if ((localWebViewFragment != null) && (localWebViewFragment.getQBaseActivity() != null)) {
      DialogUtil.a(this.b.getQBaseActivity(), 230).setMessage(paramString).setPositiveButton(2131891401, new WebViewAioShareMusicHelper.3(this)).show();
    }
  }
  
  public void a()
  {
    this.b = null;
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, " checkAndShowAioShareMusic inten is null ");
      }
      return;
    }
    String str = paramIntent.getStringExtra("forward_ark_app_view");
    this.d = paramIntent.getIntExtra("uinType", 0);
    int i1;
    int n;
    if ("music".equalsIgnoreCase(str))
    {
      i1 = this.d;
      n = 1;
      if ((i1 == 0) || (i1 == 1))
      {
        str = paramIntent.getStringExtra("forward_ark_app_meta");
        if (TextUtils.isEmpty(str)) {}
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(str).getJSONObject("music");
        if (this.d != 0) {
          break label405;
        }
        str = "friend_uin";
        Object localObject1 = paramIntent.getStringExtra(str);
        i1 = localJSONObject.getInt("appid");
        Object localObject2 = localJSONObject.getString("title");
        paramIntent = localJSONObject.getString("musicUrl");
        str = localJSONObject.getString("desc");
        this.c = localJSONObject.getString("preview");
        localJSONObject = new JSONObject();
        if (this.d == 0) {
          n = 2;
        }
        localJSONObject.put("enum_aio_type", n);
        localJSONObject.put("uint64_id", localObject1);
        localJSONObject.put("uint32_share_appid", i1);
        localJSONObject.put("bytes_song_name", localObject2);
        localJSONObject.put("uint32_duration", 0);
        localObject1 = new JSONArray();
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("singer", str);
        ((JSONArray)localObject1).put(localObject2);
        localJSONObject.put("rpt_bytes_singer", localObject1);
        localJSONObject.put("bytes_song_url", paramIntent);
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append(" type is music jsonObject = ");
          paramIntent.append(localJSONObject.toString());
          QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, paramIntent.toString());
        }
        AioShareMusicIPCWebClient.a(localJSONObject, "checkAioShareMusic", null);
        return;
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
      }
      return;
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append(" type is not music just return, ShareType = ");
        paramIntent.append(str);
        paramIntent.append(" mAioType = ");
        paramIntent.append(this.d);
        QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, paramIntent.toString());
      }
      return;
      label405:
      str = "groupUin";
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = paramJSONObject.getBoolean("isSuccess");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleCheckAioShareMusic() isSuccess = ");
        localStringBuilder.append(bool);
        localStringBuilder.append(" data = ");
        localStringBuilder.append(paramJSONObject.toString());
        QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, localStringBuilder.toString());
      }
      if (bool)
      {
        bool = paramJSONObject.getBoolean("bool_show_icon");
        this.i = paramJSONObject.getInt("enum_aio_state");
        this.j = paramJSONObject.getInt("enum_media_type");
        this.f = paramJSONObject.getString("str_song_id");
        this.g = paramJSONObject.getInt("uint32_duration");
        this.h = String.valueOf(paramJSONObject.getLong("uint64_create_uin"));
        this.k = paramJSONObject.getBoolean("bool_song_existed");
        this.l = paramJSONObject.getBoolean("bool_allow_member_start");
        this.m = paramJSONObject.getBoolean("bool_allow_member_add");
        this.a = paramJSONObject.getString("current_song_id");
        if ((this.b != null) && (this.b.getQBaseActivity() != null))
        {
          this.b.getQBaseActivity().runOnUiThread(new WebViewAioShareMusicHelper.1(this, bool));
          return;
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void b(Intent paramIntent)
  {
    if ((paramIntent != null) && (this.b != null))
    {
      this.e = true;
      String str4 = paramIntent.getStringExtra("groupUin");
      String str1;
      if (this.d == 0) {
        str1 = "c2c_AIO";
      } else {
        str1 = "Grp_AIO";
      }
      String str2;
      if (this.d == 0) {
        str2 = "clk_share_c2c";
      } else {
        str2 = "clk_share_grp";
      }
      String str3;
      if (this.d == 0) {
        str3 = "";
      } else {
        str3 = str4;
      }
      ReportController.b(null, "dc00899", str1, "", "music_tab", str2, 0, 0, str3, "", "", "");
      int n = this.j;
      if ((n != 1) && (this.i != 3))
      {
        if (n == 2)
        {
          paramIntent = this.b;
          n = 2131896569;
        }
        else
        {
          paramIntent = this.b;
          n = 2131896544;
        }
        paramIntent = paramIntent.getString(n);
        b(String.format(this.b.getString(2131891252), new Object[] { paramIntent }));
        return;
      }
      if ((this.i != 3) && (this.a.equals(this.f)))
      {
        b(this.b.getString(2131891250));
        return;
      }
      if (this.d == 1)
      {
        boolean bool = a(str4);
        if ((this.i == 3) && (!bool) && (!this.l))
        {
          c(this.b.getString(2131891248));
          return;
        }
        if ((this.i == 3) && (!bool) && (this.l) && (!this.m))
        {
          c(this.b.getString(2131891249));
          return;
        }
        if ((this.i != 3) && (!bool) && (!this.m))
        {
          c(this.b.getString(2131891247));
          return;
        }
        if ((this.i != 3) && (!b()) && (!bool) && (this.m))
        {
          if (this.k)
          {
            b(this.b.getString(2131891251));
            return;
          }
          this.e = false;
        }
      }
      c(paramIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, " checkAndShowAioShareMusic inten is null ");
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    for (;;)
    {
      int n;
      try
      {
        Object localObject = this.b;
        boolean bool;
        if ((localObject != null) && (paramJSONObject != null) && (this.b.getQBaseActivity() != null))
        {
          bool = paramJSONObject.getBoolean("isSuccess");
          if (!bool)
          {
            n = paramJSONObject.getInt("uint32_result");
            localObject = paramJSONObject.getString("bytes_errmsg");
            if ((TextUtils.isEmpty((CharSequence)localObject)) || (n == 0)) {
              continue;
            }
          }
        }
        switch (n)
        {
        case 10001: 
          c((String)localObject);
          continue;
          b((String)localObject);
          continue;
          b(String.format(this.b.getString(2131891252), new Object[] { localObject }));
          break;
        case 10002: 
        case 10003: 
        case 10004: 
          b(this.b.getString(2131892359));
          continue;
          b(this.b.getString(2131891251));
          this.b.getQBaseActivity().runOnUiThread(new WebViewAioShareMusicHelper.2(this));
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("handleCheckAioShareMusic() isSuccess = ");
            ((StringBuilder)localObject).append(bool);
            ((StringBuilder)localObject).append(" data = ");
            ((StringBuilder)localObject).append(paramJSONObject.toString());
            QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, ((StringBuilder)localObject).toString());
            return;
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("handleCheckAioShareMusic()  data  = ");
              ((StringBuilder)localObject).append(paramJSONObject);
              ((StringBuilder)localObject).append(" mWebViewFragment = ");
              ((StringBuilder)localObject).append(this.b);
              QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, ((StringBuilder)localObject).toString());
            }
            return;
          }
          break;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      return;
      switch (n)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebViewAioShareMusicHelper
 * JD-Core Version:    0.7.0.1
 */