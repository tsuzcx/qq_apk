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
  private int jdField_a_of_type_Int;
  private WebViewFragment jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  
  public WebViewAioShareMusicHelper(WebViewFragment paramWebViewFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = paramWebViewFragment;
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
      QQToast.a(BaseApplicationImpl.getApplication(), paramString, 1).a();
    }
  }
  
  private boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getAppRuntime().getAccount().equals(this.jdField_d_of_type_JavaLangString));
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getAppRuntime().getEntityManagerFactory(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getAppRuntime().getAccount()).createEntityManager();
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
      if ((paramString.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getAppRuntime().getAccount())) || (paramString.isAdmin())) {
        return true;
      }
    }
    return false;
  }
  
  private void b(String paramString)
  {
    WebViewFragment localWebViewFragment = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
    if ((localWebViewFragment != null) && (localWebViewFragment.getQBaseActivity() != null)) {
      DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getQBaseActivity(), 230).setMessage(paramString).setPositiveButton(2131693825, new WebViewAioShareMusicHelper.3(this)).show();
    }
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
        if (this.jdField_a_of_type_Int != 0) {
          break label344;
        }
        paramIntent = "friend_uin";
        Object localObject2 = ((Bundle)localObject3).getString(paramIntent, "");
        if (this.jdField_a_of_type_Int != 0) {
          break label351;
        }
        paramIntent = "h5_ark_url_web_sender_uin";
        paramIntent = ((Bundle)localObject3).getString(paramIntent);
        int j = ((JSONObject)localObject1).getInt("appid");
        Object localObject4 = ((JSONObject)localObject1).getString("title");
        localObject3 = ((JSONObject)localObject1).getString("musicUrl");
        String str = ((JSONObject)localObject1).getString("desc");
        localObject1 = new JSONObject();
        if (this.jdField_a_of_type_Int != 0) {
          break label358;
        }
        i = 2;
        ((JSONObject)localObject1).put("enum_aio_type", i);
        ((JSONObject)localObject1).put("uint64_id", localObject2);
        ((JSONObject)localObject1).put("uint32_share_appid", j);
        ((JSONObject)localObject1).put("bytes_song_name", localObject4);
        localObject2 = new JSONArray();
        localObject4 = new JSONObject();
        ((JSONObject)localObject4).put("singer", str);
        ((JSONArray)localObject2).put(localObject4);
        ((JSONObject)localObject1).put("rpt_bytes_singer", localObject2);
        ((JSONObject)localObject1).put("bytes_song_url", localObject3);
        ((JSONObject)localObject1).put("bool_cut_song", this.jdField_a_of_type_Boolean);
        ((JSONObject)localObject1).put("str_song_id", this.jdField_c_of_type_JavaLangString);
        ((JSONObject)localObject1).put("uint32_duration", this.jdField_b_of_type_Int);
        ((JSONObject)localObject1).put("uint64_sharer_uin", paramIntent);
        ((JSONObject)localObject1).put("bytes_cover", this.jdField_b_of_type_JavaLangString);
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
      label351:
      paramIntent = "friendUin";
      continue;
      label358:
      int i = 1;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = null;
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
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("uinType", 0);
    int j;
    int i;
    if ("music".equalsIgnoreCase(str))
    {
      j = this.jdField_a_of_type_Int;
      i = 1;
      if ((j == 0) || (j == 1))
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
        if (this.jdField_a_of_type_Int != 0) {
          break label405;
        }
        str = "friend_uin";
        Object localObject1 = paramIntent.getStringExtra(str);
        j = localJSONObject.getInt("appid");
        Object localObject2 = localJSONObject.getString("title");
        paramIntent = localJSONObject.getString("musicUrl");
        str = localJSONObject.getString("desc");
        this.jdField_b_of_type_JavaLangString = localJSONObject.getString("preview");
        localJSONObject = new JSONObject();
        if (this.jdField_a_of_type_Int == 0) {
          i = 2;
        }
        localJSONObject.put("enum_aio_type", i);
        localJSONObject.put("uint64_id", localObject1);
        localJSONObject.put("uint32_share_appid", j);
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
        paramIntent.append(this.jdField_a_of_type_Int);
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
        this.jdField_c_of_type_Int = paramJSONObject.getInt("enum_aio_state");
        this.jdField_d_of_type_Int = paramJSONObject.getInt("enum_media_type");
        this.jdField_c_of_type_JavaLangString = paramJSONObject.getString("str_song_id");
        this.jdField_b_of_type_Int = paramJSONObject.getInt("uint32_duration");
        this.jdField_d_of_type_JavaLangString = String.valueOf(paramJSONObject.getLong("uint64_create_uin"));
        this.jdField_b_of_type_Boolean = paramJSONObject.getBoolean("bool_song_existed");
        this.jdField_c_of_type_Boolean = paramJSONObject.getBoolean("bool_allow_member_start");
        this.jdField_d_of_type_Boolean = paramJSONObject.getBoolean("bool_allow_member_add");
        this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("current_song_id");
        if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getQBaseActivity() != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getQBaseActivity().runOnUiThread(new WebViewAioShareMusicHelper.1(this, bool));
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
    if ((paramIntent != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null))
    {
      this.jdField_a_of_type_Boolean = true;
      String str4 = paramIntent.getStringExtra("groupUin");
      String str1;
      if (this.jdField_a_of_type_Int == 0) {
        str1 = "c2c_AIO";
      } else {
        str1 = "Grp_AIO";
      }
      String str2;
      if (this.jdField_a_of_type_Int == 0) {
        str2 = "clk_share_c2c";
      } else {
        str2 = "clk_share_grp";
      }
      String str3;
      if (this.jdField_a_of_type_Int == 0) {
        str3 = "";
      } else {
        str3 = str4;
      }
      ReportController.b(null, "dc00899", str1, "", "music_tab", str2, 0, 0, str3, "", "", "");
      int i = this.jdField_d_of_type_Int;
      if ((i != 1) && (this.jdField_c_of_type_Int != 3))
      {
        if (i == 2)
        {
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
          i = 2131698622;
        }
        else
        {
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
          i = 2131698597;
        }
        paramIntent = paramIntent.getString(i);
        a(String.format(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131693677), new Object[] { paramIntent }));
        return;
      }
      if ((this.jdField_c_of_type_Int != 3) && (this.jdField_a_of_type_JavaLangString.equals(this.jdField_c_of_type_JavaLangString)))
      {
        a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131693675));
        return;
      }
      if (this.jdField_a_of_type_Int == 1)
      {
        boolean bool = a(str4);
        if ((this.jdField_c_of_type_Int == 3) && (!bool) && (!this.jdField_c_of_type_Boolean))
        {
          b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131693673));
          return;
        }
        if ((this.jdField_c_of_type_Int == 3) && (!bool) && (this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
        {
          b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131693674));
          return;
        }
        if ((this.jdField_c_of_type_Int != 3) && (!bool) && (!this.jdField_d_of_type_Boolean))
        {
          b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131693672));
          return;
        }
        if ((this.jdField_c_of_type_Int != 3) && (!a()) && (!bool) && (this.jdField_d_of_type_Boolean))
        {
          if (this.jdField_b_of_type_Boolean)
          {
            a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131693676));
            return;
          }
          this.jdField_a_of_type_Boolean = false;
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
      int i;
      try
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
        boolean bool;
        if ((localObject != null) && (paramJSONObject != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getQBaseActivity() != null))
        {
          bool = paramJSONObject.getBoolean("isSuccess");
          if (!bool)
          {
            i = paramJSONObject.getInt("uint32_result");
            localObject = paramJSONObject.getString("bytes_errmsg");
            if ((TextUtils.isEmpty((CharSequence)localObject)) || (i == 0)) {
              continue;
            }
          }
        }
        switch (i)
        {
        case 10001: 
          b((String)localObject);
          continue;
          a((String)localObject);
          continue;
          a(String.format(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131693677), new Object[] { localObject }));
          break;
        case 10002: 
        case 10003: 
        case 10004: 
          a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131694667));
          continue;
          a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131693676));
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getQBaseActivity().runOnUiThread(new WebViewAioShareMusicHelper.2(this));
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
              ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment);
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
      switch (i)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebViewAioShareMusicHelper
 * JD-Core Version:    0.7.0.1
 */