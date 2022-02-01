package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

class UiApiPlugin$1
  extends OnRemoteRespObserver
{
  UiApiPlugin$1(UiApiPlugin paramUiApiPlugin) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.a.a.key))
    {
      String str1 = paramBundle.getString("cmd");
      String str2 = paramBundle.getString("callbackid");
      Object localObject2 = paramBundle.getBundle("response");
      Object localObject1 = paramBundle.getBundle("request");
      if (localObject1 == null)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("reqBundle is null, cmd is : ");
        paramBundle.append(str1);
        QLog.e("UiApiPlugin", 1, paramBundle.toString());
        return;
      }
      paramBundle = ((Bundle)localObject1).getString("uin");
      Object localObject4 = ((Bundle)localObject1).getString("action");
      Object localObject3 = new int[5];
      Object tmp118_116 = localObject3;
      tmp118_116[0] = 1;
      Object tmp122_118 = tmp118_116;
      tmp122_118[1] = 41;
      Object tmp127_122 = tmp122_118;
      tmp127_122[2] = 75;
      Object tmp132_127 = tmp127_122;
      tmp132_127[3] = 21;
      Object tmp137_132 = tmp132_127;
      tmp137_132[4] = 58;
      tmp137_132;
      if (this.a.mRuntime == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "mRuntime == null");
        }
        return;
      }
      Activity localActivity = this.a.mRuntime.a();
      if (("checkRelation".equals(str1)) && (localActivity != null) && (paramBundle != null))
      {
        boolean bool = "openSocialCard".equals(localObject4);
        str1 = "{\"result\": 0}";
        int i;
        if (bool)
        {
          int k = ((Bundle)localObject1).getInt("source");
          localObject4 = ((Bundle)localObject1).getString("sign");
          int j = ((Bundle)localObject1).getInt("nProfileEntryType");
          i = j;
          if (j == 0) {
            i = 999;
          }
          localObject1 = this.a.mRuntime.a();
          if ((((Bundle)localObject2).getBoolean("result", false)) && (localObject1 != null) && (!((AppInterface)localObject1).getCurrentAccountUin().equals(paramBundle)))
          {
            paramBundle = new AllInOne(paramBundle, localObject3[k]);
            paramBundle.profileEntryType = i;
            paramBundle = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(localActivity, paramBundle);
            i = 0;
          }
          else
          {
            localObject1 = new AllInOne(paramBundle, localObject3[k]);
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              ((AllInOne)localObject1).chatCookie = ChatActivityUtils.a((String)localObject4);
            }
            ((AllInOne)localObject1).profileEntryType = i;
            paramBundle = new Intent();
            paramBundle.putExtra("param_mode", 3);
            paramBundle.putExtra("AllInOne", (Parcelable)localObject1);
            i = 1;
          }
          if (i != 0)
          {
            RouteUtils.a(BaseApplicationImpl.getContext(), paramBundle, "/nearby/people/profile");
            paramBundle = str1;
          }
          else
          {
            localActivity.startActivity(paramBundle);
            paramBundle = str1;
          }
        }
        else if ("openStrangerAIO".equals(localObject4))
        {
          if (((Bundle)localObject2).getBoolean("result", false))
          {
            localObject1 = new Intent(localActivity, ChatActivity.class);
            ((Intent)localObject1).putExtra("uin", paramBundle);
            ((Intent)localObject1).putExtra("uintype", 0);
            localActivity.startActivity((Intent)localObject1);
            paramBundle = str1;
          }
          else
          {
            i = ((Bundle)localObject1).getInt("sourceType");
            localObject2 = ((Bundle)localObject1).getString("sign");
            bool = ((Bundle)localObject1).getBoolean("isGroup");
            localObject3 = ((Bundle)localObject1).getString("strangerchat_ext");
            localObject4 = new Intent();
            ((Intent)localObject4).putExtra("uin", paramBundle);
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              ((Intent)localObject4).putExtra("strangerchat_ext", (String)localObject3);
            }
            if ((!bool) && (TextUtils.isEmpty((CharSequence)localObject2)) && (i != 6))
            {
              paramBundle = "{\"result\": -2, \"message\":\"Can't send message to a stranger without sign!\"}";
            }
            else
            {
              if (bool)
              {
                ((Intent)localObject4).putExtra("open_chatfragment", true);
                ((Intent)localObject4).setClass(localActivity, SplashActivity.class);
              }
              do
              {
                i = 1;
                break label707;
                ((Intent)localObject4).setClass(localActivity, ChatActivity.class);
                if (i == 0) {
                  break label705;
                }
                if (i == 1) {
                  break;
                }
                if (i == 2) {
                  break label698;
                }
              } while (i == 3);
              if (i != 4)
              {
                if (i != 6)
                {
                  if (i != 8) {
                    i = 1001;
                  } else {
                    i = 10004;
                  }
                }
                else {
                  i = 10002;
                }
              }
              else
              {
                i = 1020;
                break label707;
                label698:
                i = 1010;
                break label707;
                label705:
                i = 0;
              }
              label707:
              if (((Bundle)localObject1).getInt("fromAIO") >= 1) {
                ((Intent)localObject4).addFlags(67108864);
              }
              ((Intent)localObject4).putExtra("uintype", i);
              if (i == 1001) {
                ((Intent)localObject4).putExtra("rich_accost_sig", ChatActivityUtils.a((String)localObject2));
              } else if (i == 1010) {
                ((Intent)localObject4).putExtra("rich_date_sig", ChatActivityUtils.a((String)localObject2));
              } else if (i == 10004) {
                ((Intent)localObject4).putExtra("rich_movie_sig", ChatActivityUtils.a((String)localObject2));
              }
              localActivity.startActivity((Intent)localObject4);
              paramBundle = str1;
            }
          }
        }
        else
        {
          paramBundle = null;
        }
        if ((!TextUtils.isEmpty(str2)) && (paramBundle != null)) {
          this.a.callJs(str2, new String[] { paramBundle });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */