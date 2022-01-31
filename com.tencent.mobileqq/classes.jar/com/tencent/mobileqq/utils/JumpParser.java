package com.tencent.mobileqq.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JumpParser
{
  public static JumpAction a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "Jump input=" + paramString);
    }
    if (paramString == null) {
      paramQQAppInterface = null;
    }
    do
    {
      do
      {
        return paramQQAppInterface;
        if (!paramString.startsWith("mqqapi://groupopenapp/openapp")) {
          break;
        }
        paramContext = new JumpAction(paramQQAppInterface, paramContext);
        paramContext.a = paramString;
        paramContext.b = "groupopenapp";
        paramContext.c = "openapp";
        paramString = paramString.split("\\?");
        paramQQAppInterface = paramContext;
      } while (paramString.length != 2);
      paramString = paramString[1].split("&");
      j = paramString.length;
      i = 0;
      for (;;)
      {
        paramQQAppInterface = paramContext;
        if (i >= j) {
          break;
        }
        paramQQAppInterface = paramString[i].split("=");
        if (paramQQAppInterface.length == 2) {
          paramContext.a(paramQQAppInterface[0], paramQQAppInterface[1]);
        }
        i += 1;
      }
      if (paramString.startsWith("mqqapi://now/playmedia"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = paramString;
        paramQQAppInterface.b = "now";
        paramQQAppInterface.c = "playmedia";
        return paramQQAppInterface;
      }
      if (paramString.startsWith("mqqapi://now/openSmallVideoRecord"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = paramString;
        paramQQAppInterface.b = "now";
        paramQQAppInterface.c = "openSmallVideoRecord";
        return paramQQAppInterface;
      }
      if ((paramString.startsWith("mqqzone")) || (paramString.startsWith("mqqapi://qzoneschema")))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = paramString;
        paramQQAppInterface.b = "qzone";
        paramQQAppInterface.c = "qzone_schema";
        return paramQQAppInterface;
      }
      if (paramString.startsWith("qqfav://operation/"))
      {
        str1 = Uri.parse(paramString).getLastPathSegment();
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = paramString;
        paramQQAppInterface.b = "com.qqfav";
        paramQQAppInterface.c = str1;
        return paramQQAppInterface;
      }
      if (paramString.startsWith("mqq://shop/apollo_store"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = paramString;
        paramQQAppInterface.b = "shop";
        paramQQAppInterface.c = "apollo_store";
        return paramQQAppInterface;
      }
      if (paramString.startsWith("mqqapi://cmshow/game_invite"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = paramString;
        paramQQAppInterface.b = "cmshow";
        paramQQAppInterface.c = "game_invite";
        return paramQQAppInterface;
      }
      if (paramString.startsWith("mqqapi://assistant_setting/ASSISTANT_SETTING"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = paramString;
        paramQQAppInterface.b = "assistant_setting";
        paramQQAppInterface.c = "ASSISTANT_SETTING";
        return paramQQAppInterface;
      }
      String str1 = paramString;
      if (paramString.contains("videochat"))
      {
        str1 = paramString;
        if (paramString.contains("uinType=21")) {
          str1 = URLDecoder.decode(paramString);
        }
      }
      if (str1.startsWith("mqqapi://qzone/to_publish_queue"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "qzone";
        paramQQAppInterface.c = "to_publish_queue";
        return paramQQAppInterface;
      }
      if ((str1.startsWith("mqqapi://qzone/to_friend_feeds")) || (str1.startsWith("mqqapi://qzone/activefeed")))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "qzone";
        paramQQAppInterface.c = "to_friend_feeds";
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://qzone/open_homepage"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "qzone";
        paramQQAppInterface.c = "open_homepage";
        paramContext = str1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://ftssearch/tab"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "ftssearch";
        paramQQAppInterface.c = "tab";
        paramContext = str1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://qzone/to_qzone_dialog"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "qzone";
        paramQQAppInterface.c = "to_qzone_dialog";
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://qzone/to_redpocket_share"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "qzone";
        paramQQAppInterface.c = "to_redpocket_share";
        return paramQQAppInterface;
      }
      if (str1.startsWith("qapp://"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "qapp";
        paramQQAppInterface.c = Uri.parse(str1).getHost();
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://qqreg"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.b = "qqreg";
        paramContext = str1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://wallet/open"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "wallet";
        paramQQAppInterface.c = "open";
        paramContext = str1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqmdpass://wallet/modify_pass"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "wallet";
        paramQQAppInterface.c = "modify_pass";
        paramContext = str1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://asyncmsg/showdetail?"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "asyncmsg";
        paramQQAppInterface.c = "open_async_detail";
        paramContext = str1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://schedule/showDetail?"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "schedule";
        paramQQAppInterface.c = "showDetail";
        paramContext = str1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (str1.startsWith("qqwifi://"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "qqwifi";
        paramQQAppInterface.c = "outweb_start";
        paramContext = str1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://huayang"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "huayang";
        paramQQAppInterface.c = "open";
        paramContext = str1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        i = 0;
        for (;;)
        {
          if (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if (paramString.length == 2) {}
            try
            {
              paramString[1] = URLDecoder.decode(paramString[1], "UTF-8");
              paramQQAppInterface.a(paramString[0], paramString[1]);
              i += 1;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("JumpAction", 2, "failed to decode param value,tmps[1] is:" + paramString[0] + ",tmps[1] is:" + paramString[1], localException1);
                }
              }
            }
          }
        }
        return paramQQAppInterface;
      }
      if (localException1.startsWith("mqqapi://od"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = localException1;
        paramQQAppInterface.b = "od";
        paramQQAppInterface.c = "openroom";
        paramContext = localException1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (localException1.startsWith("mqqapi://0odAddFriend"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = localException1;
        paramQQAppInterface.b = "odAddFriend";
        paramQQAppInterface.c = "addFriend";
        paramContext = localException1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (localException1.startsWith("mqqapi://teamwork/opendoclist"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = localException1;
        paramQQAppInterface.b = "teamwork";
        paramQQAppInterface.c = "opendoclist";
        return paramQQAppInterface;
      }
      if ((localException1.startsWith("mqqapi://qstory/opencontent")) || (localException1.startsWith("qqstory://qstory/opencontent")))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = localException1;
        paramQQAppInterface.b = "qstory";
        paramQQAppInterface.c = "opencontent";
        paramContext = localException1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (localException1.startsWith("mqqapi://contact/add"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = localException1;
        paramQQAppInterface.b = "contact";
        paramQQAppInterface.c = "add";
        paramContext = localException1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (localException1.startsWith("mqqapi://groupvideo"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = localException1;
        paramQQAppInterface.b = "groupvideo";
        paramQQAppInterface.c = "openroom";
        paramContext = localException1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (localException1.startsWith("mqqapi://qwerewolf/enterHomePage"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = localException1;
        paramQQAppInterface.b = "qwerewolf";
        paramQQAppInterface.c = "enterHomePage";
        paramContext = localException1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (localException1.startsWith("mqqapi://lightapp/open"))
      {
        paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
        paramContext = URLDecoder.decode(localException1);
        paramQQAppInterface.a = paramContext;
        paramQQAppInterface.b = "lightapp";
        paramQQAppInterface.c = "open";
        paramContext = paramContext.split("\\?")[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i];
            if ((paramString != null) && (paramString.length() > 0))
            {
              j = paramString.indexOf("=");
              if ((j > 0) && (j < paramString.length() - 1)) {
                paramQQAppInterface.a(paramString.substring(0, j), paramString.substring(j + 1, paramString.length()));
              }
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (!localException1.startsWith("mqqapi://troop_homework/publish")) {
        break;
      }
      paramContext = new JumpAction(paramQQAppInterface, paramContext);
      paramContext.a = localException1;
      paramContext.b = "troop_homework";
      paramContext.c = "publish";
      paramString = localException1.split("\\?");
      paramQQAppInterface = paramContext;
    } while (paramString.length != 2);
    paramString = paramString[1].split("&");
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      paramQQAppInterface = paramContext;
      if (i >= j) {
        break;
      }
      paramQQAppInterface = paramString[i].split("=");
      if (paramQQAppInterface.length == 2) {
        paramContext.a(paramQQAppInterface[0], paramQQAppInterface[1]);
      }
      i += 1;
    }
    String str2;
    if (localException1.startsWith("mqqapi://qzone/groupalbum"))
    {
      paramString = localException1.split("\\?");
      if (paramString.length != 2) {
        return null;
      }
      localObject2 = paramString[0];
      str2 = paramString[1];
      paramString = "";
      paramContext = new JumpAction(paramQQAppInterface, paramContext);
      if (localObject2.startsWith("mqqopensdkapi://bizAgent/")) {
        paramQQAppInterface = localObject2.substring("mqqopensdkapi://bizAgent/".length());
      }
      for (;;)
      {
        paramQQAppInterface = paramQQAppInterface.split("/");
        if (paramQQAppInterface.length == 2) {
          break;
        }
        return null;
        if (localObject2.startsWith("http://qm.qq.com/cgi-bin/"))
        {
          paramQQAppInterface = localObject2.substring("http://qm.qq.com/cgi-bin/".length());
        }
        else if (localObject2.startsWith("http://clientui.3g.qq.com/mqqapi/"))
        {
          paramQQAppInterface = localObject2.substring("http://clientui.3g.qq.com/mqqapi/".length());
        }
        else if (localObject2.startsWith("mqqapi://"))
        {
          paramQQAppInterface = localObject2.substring("mqqapi://".length());
        }
        else if (localObject2.startsWith("qqstory://"))
        {
          paramQQAppInterface = localObject2.substring("qqstory://".length());
        }
        else if (localObject2.startsWith("mqq://"))
        {
          paramQQAppInterface = localObject2.substring("mqq://".length());
        }
        else if (localObject2.startsWith("http://clientui.3g.qq.com/mqq/"))
        {
          paramQQAppInterface = localObject2.substring("http://clientui.3g.qq.com/mqq/".length());
        }
        else if (localObject2.startsWith("mqqflyticket://"))
        {
          paramQQAppInterface = localObject2.substring("mqqflyticket://".length());
        }
        else if (localObject2.startsWith("mqqwpa://"))
        {
          paramQQAppInterface = localObject2.substring("mqqwpa://".length());
        }
        else if (localObject2.startsWith("wtloginmqq://"))
        {
          paramQQAppInterface = localObject2.substring("wtloginmqq://".length());
        }
        else if (localObject2.startsWith("mqqtribe://"))
        {
          paramQQAppInterface = localObject2.substring("mqqtribe://".length());
        }
        else if (localObject2.startsWith("qapp://"))
        {
          paramQQAppInterface = localObject2.substring("qapp://".length());
        }
        else
        {
          paramQQAppInterface = paramString;
          if (localObject2.startsWith("mqqconferenceflyticket://")) {
            paramQQAppInterface = localObject2.substring("mqqconferenceflyticket://".length());
          }
        }
      }
      paramContext.a = localException1;
      paramContext.b = paramQQAppInterface[0];
      paramContext.c = paramQQAppInterface[1];
      paramQQAppInterface = str2.split("&");
      i = 0;
      for (;;)
      {
        if (i < paramQQAppInterface.length)
        {
          paramString = paramQQAppInterface[i].split("=");
          if (paramString.length == 2) {}
          try
          {
            paramString[1] = URLDecoder.decode(paramString[1], "UTF-8");
            paramContext.a(paramString[0], paramString[1]);
            i += 1;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "failed to decode param value,tmps[1] is:" + paramString[0] + ",tmps[1] is:" + paramString[1], localException2);
              }
            }
          }
        }
      }
      return paramContext;
    }
    boolean bool1 = localException2.startsWith("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity");
    boolean bool2 = localException2.startsWith("mqqapi://readingcenter");
    boolean bool5 = localException2.startsWith(" mqqapi://qqreader");
    boolean bool3 = localException2.startsWith("wtloginmqq://");
    boolean bool4 = localException2.startsWith("mqqwpa://");
    boolean bool6 = localException2.startsWith("mqqtribe://");
    boolean bool7 = localException2.startsWith("mqqverifycode://");
    boolean bool8 = localException2.startsWith("mqqdevlock://");
    label3395:
    int k;
    label3420:
    boolean bool9;
    boolean bool10;
    if ((localException2.startsWith("mqqapi://im/chat")) && (localException2.contains("chat_type=crm")) && (localException2.contains("kfnick=")))
    {
      i = 1;
      if ((!localException2.startsWith("mqqapi://card/show_pslcard")) || (!localException2.contains("card_type=troopmember"))) {
        break label3555;
      }
      j = 1;
      if ((!localException2.startsWith("mqqapi://qstory")) || (!localException2.contains("topicid="))) {
        break label3561;
      }
      k = 1;
      bool9 = localException2.startsWith("mqqapi://qqcomic/");
      bool10 = a(localException2);
      boolean bool11 = localException2.startsWith("mqqconferenceflyticket://");
      if ((localException2.startsWith("mqqopensdkapi://bizAgent/")) || (bool2) || (bool3) || (bool4) || (bool6) || (bool1) || (j != 0) || (bool10) || (bool9) || (k != 0)) {
        break label3567;
      }
      j = 1;
      label3506:
      paramString = localException2;
      if (j == 0) {
        break label3579;
      }
      if ((bool2) || (i != 0) || (bool11)) {
        break label3573;
      }
    }
    label3555:
    label3561:
    label3567:
    label3573:
    for (bool1 = true;; bool1 = false)
    {
      localObject1 = a(localException2, bool1);
      paramString = (String)localObject1;
      if (localObject1 != null) {
        break label3579;
      }
      return null;
      i = 0;
      break;
      j = 0;
      break label3395;
      k = 0;
      break label3420;
      j = 0;
      break label3506;
    }
    label3579:
    if ((bool5) || (bool2) || (bool3) || (bool4) || (bool6) || (bool7) || (bool8) || (bool10) || (bool9)) {}
    for (Object localObject1 = a(paramString, "?"); localObject1.length != 2; localObject1 = paramString.split("\\?")) {
      return null;
    }
    Object localObject2 = localObject1[0];
    localObject1 = localObject1[1];
    if ((j != 0) && (!localObject2.startsWith("mqqconferenceflyticket://"))) {
      if ((!bool2) && (i == 0))
      {
        bool1 = true;
        localObject1 = a((String)localObject1, bool1);
      }
    }
    for (;;)
    {
      str2 = "";
      paramContext = new JumpAction(paramQQAppInterface, paramContext);
      if (localObject2.startsWith("mqqopensdkapi://bizAgent/")) {
        paramQQAppInterface = localObject2.substring("mqqopensdkapi://bizAgent/".length());
      }
      for (;;)
      {
        paramQQAppInterface = paramQQAppInterface.split("/");
        if (paramQQAppInterface.length == 2) {
          break label4129;
        }
        return null;
        bool1 = false;
        break;
        if (localObject2.startsWith("http://qm.qq.com/cgi-bin/"))
        {
          paramQQAppInterface = localObject2.substring("http://qm.qq.com/cgi-bin/".length());
        }
        else if (localObject2.startsWith("http://clientui.3g.qq.com/mqqapi/"))
        {
          paramQQAppInterface = localObject2.substring("http://clientui.3g.qq.com/mqqapi/".length());
        }
        else if (localObject2.startsWith("mqqapi://"))
        {
          paramQQAppInterface = localObject2.substring("mqqapi://".length());
        }
        else if (localObject2.startsWith("qqstory://"))
        {
          paramQQAppInterface = localObject2.substring("qqstory://".length());
        }
        else if (localObject2.startsWith("mqq://"))
        {
          paramQQAppInterface = localObject2.substring("mqq://".length());
        }
        else if (localObject2.startsWith("http://clientui.3g.qq.com/mqq/"))
        {
          paramQQAppInterface = localObject2.substring("http://clientui.3g.qq.com/mqq/".length());
        }
        else if (localObject2.startsWith("mqqflyticket://"))
        {
          paramQQAppInterface = localObject2.substring("mqqflyticket://".length());
        }
        else if (localObject2.startsWith("mqqwpa://"))
        {
          paramQQAppInterface = localObject2.substring("mqqwpa://".length());
        }
        else if (localObject2.startsWith("wtloginmqq://"))
        {
          paramQQAppInterface = localObject2.substring("wtloginmqq://".length());
        }
        else if (localObject2.startsWith("mqqtribe://"))
        {
          paramQQAppInterface = localObject2.substring("mqqtribe://".length());
        }
        else if (localObject2.startsWith("mqqverifycode://"))
        {
          paramQQAppInterface = localObject2.substring("mqqverifycode://".length());
        }
        else if (localObject2.startsWith("mqqconnect://"))
        {
          paramQQAppInterface = localObject2.substring("mqqconnect://".length());
        }
        else if (localObject2.startsWith("mqqdevlock://"))
        {
          paramQQAppInterface = localObject2.substring("mqqdevlock://".length());
        }
        else
        {
          paramQQAppInterface = str2;
          if (localObject2.startsWith("mqqconferenceflyticket://")) {
            paramQQAppInterface = localObject2.substring("mqqconferenceflyticket://".length());
          }
        }
      }
      label4129:
      paramContext.a = paramString;
      paramContext.b = paramQQAppInterface[0];
      paramContext.c = paramQQAppInterface[1];
      if (bool3)
      {
        paramQQAppInterface = ((String)localObject1).split("&");
        i = 0;
        if (i < paramQQAppInterface.length)
        {
          paramString = paramQQAppInterface[i];
          if (!bool2) {}
          for (bool1 = true;; bool1 = false)
          {
            paramString = a(paramString, bool1);
            j = paramString.indexOf('=');
            if (j > 0) {
              paramContext.a(paramString.substring(0, j), paramString.substring(j + 1, paramString.length()));
            }
            i += 1;
            break;
          }
        }
        return paramContext;
      }
      paramQQAppInterface = ((String)localObject1).split("&");
      i = 0;
      if (i < paramQQAppInterface.length)
      {
        paramString = a(paramQQAppInterface[i], "=");
        if (paramString.length == 2)
        {
          if (!bool4) {
            break label4296;
          }
          paramContext.a(paramString[0], a(paramString[1], false));
        }
        for (;;)
        {
          i += 1;
          break;
          label4296:
          paramContext.a(paramString[0], paramString[1]);
        }
      }
      return paramContext;
    }
  }
  
  private static String a(String paramString, boolean paramBoolean)
  {
    Object localObject1 = null;
    try
    {
      String str2 = URLDecoder.decode(paramString);
      str1 = str2;
      if (paramBoolean)
      {
        localObject1 = str2;
        str1 = str2.replaceAll(" ", "+");
      }
    }
    catch (Exception localException)
    {
      do
      {
        String str1;
        Object localObject2 = localObject1;
      } while (!QLog.isColorLevel());
      QLog.d("JumpAction", 2, "JumpParser parser Exception =" + paramString);
    }
    return str1;
    return localObject1;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = a(paramString, false);
    } while ((TextUtils.isEmpty(paramString)) || (!Pattern.compile("gamecenter\\s*=\\s*1").matcher(paramString).find()));
    return true;
  }
  
  public static String[] a(String paramString1, String paramString2)
  {
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new String[] { paramString1 };
    }
    return new String[] { paramString1.substring(0, i), paramString1.substring(i + paramString2.length(), paramString1.length()) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpParser
 * JD-Core Version:    0.7.0.1
 */