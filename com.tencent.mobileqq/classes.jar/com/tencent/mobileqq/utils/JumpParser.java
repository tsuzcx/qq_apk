package com.tencent.mobileqq.utils;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.tencent.av.share.ShareChat;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JumpParser
{
  public static JumpAction a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    Object localObject3 = paramString;
    try
    {
      if (!QLog.isColorLevel()) {
        break label580;
      }
      localObject3 = paramString;
      QLog.d("JumpAction", 2, "Jump input=" + paramString);
    }
    catch (Exception paramString)
    {
      Object localObject4;
      Object localObject5;
      localObject1 = new HashMap(1);
      ((HashMap)localObject1).put("keyJumpParserUtilUrlErrorKey", localObject3);
      ((HashMap)localObject1).put("keyJumpParserUtilSceneErrorKey", "2");
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance("", "keyJumpParserUtil", true, 0L, 0L, (HashMap)localObject1, "", false);
      QLog.e("JumpAction", 1, "JumpParser parser Exception =" + paramString.getMessage());
      paramQQAppInterface = new JumpAction(paramQQAppInterface, paramContext);
      paramQQAppInterface.b = "";
      paramQQAppInterface.c = "";
      paramQQAppInterface.a = "";
      return paramQQAppInterface;
    }
    localObject3 = paramString;
    Object localObject1 = JumpParserUtil.a(paramQQAppInterface, paramContext, paramString);
    Object localObject2 = localObject1;
    label139:
    int i;
    if (localObject1 == null)
    {
      localObject1 = paramString;
      localObject3 = paramString;
      if (paramString.contains("videochat"))
      {
        localObject1 = paramString;
        localObject3 = paramString;
        if (paramString.contains("uinType=21"))
        {
          localObject3 = paramString;
          localObject1 = URLDecoder.decode(paramString);
        }
      }
      localObject3 = localObject1;
      if (AudioHelper.d())
      {
        localObject3 = localObject1;
        if (AudioHelper.a(8) == 1)
        {
          localObject3 = localObject1;
          if (((String)localObject1).startsWith("mqqconferenceflyticket://"))
          {
            paramString = "mqqavshare://avshare/forward?url=https%3a%2f%2fwww.baidu.com%2fs%3fwd%3dabc%26rsv_spt%3d1&exp=1566906601";
            localObject3 = localObject1;
            if (paramString.startsWith("mqqavshare://"))
            {
              localObject3 = localObject1;
              return ShareChat.a(paramQQAppInterface, paramContext, paramString);
            }
            localObject3 = localObject1;
            if (paramString.startsWith("mqqapi://qzone/groupalbum"))
            {
              localObject3 = localObject1;
              localObject4 = paramString.split("\\?");
              localObject3 = localObject1;
              if (localObject4.length != 2) {
                return null;
              }
              localObject2 = localObject4[0];
              localObject5 = localObject4[1];
              localObject3 = localObject1;
              localObject4 = new JumpAction(paramQQAppInterface, paramContext);
              localObject3 = localObject1;
              localObject2 = ((String)localObject2).substring("mqqapi://".length()).split("/");
              localObject3 = localObject1;
              if (localObject2.length != 2) {
                return null;
              }
              localObject3 = localObject1;
              ((JumpAction)localObject4).a = paramString;
              localObject3 = localObject1;
              ((JumpAction)localObject4).b = localObject2[0];
              localObject3 = localObject1;
              ((JumpAction)localObject4).c = localObject2[1];
              localObject3 = localObject1;
              paramString = localObject5.split("&");
              i = 0;
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject3 = localObject1;
      localObject2 = localObject4;
      if (i < paramString.length)
      {
        localObject3 = localObject1;
        localObject2 = paramString[i].split("=");
        localObject3 = localObject1;
        int j = localObject2.length;
        if (j != 2) {
          break label590;
        }
        try
        {
          localObject2[1] = URLDecoder.decode(localObject2[1], "UTF-8");
          localObject3 = localObject1;
          ((JumpAction)localObject4).a(localObject2[0], localObject2[1]);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localObject3 = localObject1;
            if (QLog.isColorLevel())
            {
              localObject3 = localObject1;
              QLog.d("JumpAction", 2, "failed to decode param value,tmps[1] is:" + localObject2[0] + ",tmps[1] is:" + localObject2[1], localException);
            }
          }
        }
        localObject3 = localObject1;
        paramString = a(paramQQAppInterface, paramContext, (String)localObject1, paramString);
        return paramString;
        paramString = (String)localObject1;
        break label139;
        label580:
        if (paramString != null) {
          break;
        }
        localObject2 = null;
      }
      return localObject2;
      label590:
      i += 1;
    }
  }
  
  private static JumpAction a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    boolean bool3 = paramString2.startsWith("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity");
    boolean bool4 = paramString2.startsWith("mqqapi://readingcenter");
    boolean bool7 = paramString2.startsWith(" mqqapi://qqreader");
    boolean bool5 = paramString2.startsWith("wtloginmqq://");
    boolean bool6 = paramString2.startsWith("mqqwpa://");
    boolean bool8 = paramString2.startsWith("mqqtribe://");
    boolean bool9 = paramString2.startsWith("mqqverifycode://");
    boolean bool10 = paramString2.startsWith("mqqdevlock://");
    int i;
    int j;
    label115:
    int k;
    label136:
    boolean bool11;
    boolean bool12;
    label202:
    boolean bool2;
    label210:
    int i1;
    label218:
    int i2;
    label226:
    int i3;
    label234:
    label242:
    int i4;
    label250:
    int i5;
    label258:
    int i6;
    label266:
    int i7;
    label274:
    int i8;
    if ((paramString2.startsWith("mqqapi://im/chat")) && (paramString2.contains("chat_type=crm")) && (paramString2.contains("kfnick=")))
    {
      i = 1;
      if ((!paramString2.startsWith("mqqapi://card/show_pslcard")) || (!paramString2.contains("card_type=troopmember"))) {
        break label396;
      }
      j = 1;
      if ((!paramString2.startsWith("mqqapi://qstory")) || (!paramString2.contains("topicid="))) {
        break label402;
      }
      k = 1;
      bool11 = paramString2.startsWith("mqqapi://qqcomic/");
      bool12 = a(paramString2);
      boolean bool13 = paramString2.startsWith("mqqconferenceflyticket://");
      int n = 0;
      int m = n;
      if (paramString2.startsWith("mqqapi://readinjoy"))
      {
        m = n;
        if (paramString2.contains("readinjoyNotDecodeUrl=1")) {
          m = 1;
        }
      }
      if (paramString1.startsWith("mqqopensdkapi://bizAgent/")) {
        break label408;
      }
      bool1 = true;
      if (bool4) {
        break label414;
      }
      bool2 = true;
      if (bool5) {
        break label420;
      }
      i1 = 1;
      if (bool6) {
        break label426;
      }
      i2 = 1;
      if (bool8) {
        break label432;
      }
      i3 = 1;
      if (bool3) {
        break label438;
      }
      bool3 = true;
      if (j != 0) {
        break label444;
      }
      i4 = 1;
      if (bool12) {
        break label450;
      }
      i5 = 1;
      if (bool11) {
        break label456;
      }
      i6 = 1;
      if (k != 0) {
        break label462;
      }
      i7 = 1;
      if (m != 0) {
        break label468;
      }
      i8 = 1;
      label282:
      bool2 = a(new boolean[] { bool1, bool2, i1, i2, i3, bool3, i4, i5, i6, i7, i8 });
      if (!bool2) {
        break label480;
      }
      if ((bool4) || (i != 0) || (bool13)) {
        break label474;
      }
    }
    label396:
    label402:
    label408:
    label414:
    label420:
    label426:
    label432:
    label438:
    label444:
    label450:
    label456:
    label462:
    label468:
    label474:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramString2 = a(paramString1, bool1);
      str1 = paramString2;
      if (paramString2 != null) {
        break label483;
      }
      return null;
      i = 0;
      break;
      j = 0;
      break label115;
      k = 0;
      break label136;
      bool1 = false;
      break label202;
      bool2 = false;
      break label210;
      i1 = 0;
      break label218;
      i2 = 0;
      break label226;
      i3 = 0;
      break label234;
      bool3 = false;
      break label242;
      i4 = 0;
      break label250;
      i5 = 0;
      break label258;
      i6 = 0;
      break label266;
      i7 = 0;
      break label274;
      i8 = 0;
      break label282;
    }
    label480:
    String str1 = paramString2;
    label483:
    String[] arrayOfString = a(str1, new boolean[] { bool7, bool4, bool5, bool6, bool8, bool9, bool10, bool12, bool11 });
    String str3 = arrayOfString[0];
    paramString2 = null;
    if (arrayOfString.length > 1) {
      paramString2 = arrayOfString[1];
    }
    String str2 = paramString2;
    if (paramString2 != null)
    {
      str2 = paramString2;
      if (bool2)
      {
        str2 = paramString2;
        if (!str3.startsWith("mqqconferenceflyticket://")) {
          if ((bool4) || (i != 0)) {
            break label632;
          }
        }
      }
    }
    label632:
    for (bool1 = true;; bool1 = false)
    {
      str2 = a(paramString2, bool1);
      return a(paramQQAppInterface, paramContext, paramString1, str1, str3, str2, arrayOfString, bool5, bool4, bool6);
    }
  }
  
  private static JumpAction a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    String str = "";
    JumpAction localJumpAction = new JumpAction(paramQQAppInterface, paramContext);
    if (paramString2.startsWith("mqqapi://now/openroom"))
    {
      localJumpAction.a = paramString2;
      paramArrayOfString = paramString3;
      paramContext = paramString2;
      if (!paramArrayOfString.startsWith("mqqopensdkapi://bizAgent/")) {
        break label144;
      }
      paramQQAppInterface = paramArrayOfString.substring("mqqopensdkapi://bizAgent/".length());
      localJumpAction.a("attr_original_url", paramString1);
    }
    label144:
    int i;
    for (;;)
    {
      paramQQAppInterface = paramQQAppInterface.split("/");
      if (paramQQAppInterface.length == 2) {
        break label399;
      }
      return null;
      paramContext = paramString2;
      paramArrayOfString = paramString3;
      if (!paramString2.startsWith("nowmqqapi://now/openroom")) {
        break;
      }
      paramContext = Uri.parse(paramString2).buildUpon().scheme("mqqapi").build().toString();
      paramArrayOfString = Uri.parse(paramString3).buildUpon().scheme("mqqapi").build().toString();
      localJumpAction.a = paramContext;
      break;
      if (paramArrayOfString.startsWith("http://qm.qq.com/cgi-bin/"))
      {
        paramQQAppInterface = paramArrayOfString.substring("http://qm.qq.com/cgi-bin/".length());
        localJumpAction.a("attr_original_url", paramString1);
      }
      else if (paramArrayOfString.startsWith("http://clientui.3g.qq.com/mqqapi/"))
      {
        paramQQAppInterface = paramArrayOfString.substring("http://clientui.3g.qq.com/mqqapi/".length());
      }
      else if (paramArrayOfString.startsWith("http://clientui.3g.qq.com/mqq/"))
      {
        paramQQAppInterface = paramArrayOfString.substring("http://clientui.3g.qq.com/mqq/".length());
      }
      else
      {
        try
        {
          paramString1 = new ArrayList(Arrays.asList(new String[] { "mqqapi://", "qqstory://", "mqq://", "mqqflyticket://", "mqqwpa://", "wtloginmqq://", "mqqtribe://", "mqqverifycode://", "mqqconnect://", "mqqdevlock://", "mqqconferenceflyticket://" }));
          i = paramArrayOfString.indexOf("://");
          paramQQAppInterface = str;
          if (i > 0)
          {
            i += 3;
            paramQQAppInterface = str;
            if (paramString1.contains(paramArrayOfString.substring(0, i))) {
              paramQQAppInterface = paramArrayOfString.substring(i);
            }
          }
        }
        catch (Exception paramQQAppInterface)
        {
          QLog.e("JumpAction", 1, "jumpParser error: " + paramQQAppInterface.getMessage());
          paramQQAppInterface = str;
        }
      }
    }
    label399:
    localJumpAction.a = paramContext;
    localJumpAction.b = paramQQAppInterface[0];
    localJumpAction.c = paramQQAppInterface[1];
    if (paramString4 == null) {
      return localJumpAction;
    }
    if (paramBoolean1)
    {
      paramQQAppInterface = paramString4.split("&");
      i = 0;
      if (i < paramQQAppInterface.length)
      {
        paramContext = paramQQAppInterface[i];
        if (!paramBoolean2) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          paramContext = a(paramContext, paramBoolean1);
          int j = paramContext.indexOf('=');
          if (j > 0) {
            localJumpAction.a(paramContext.substring(0, j), paramContext.substring(j + 1, paramContext.length()));
          }
          i += 1;
          break;
        }
      }
    }
    else
    {
      paramQQAppInterface = paramString4.split("&");
      i = 0;
      if (i < paramQQAppInterface.length)
      {
        paramContext = a(paramQQAppInterface[i], "=");
        if (paramContext.length == 2)
        {
          if (!paramBoolean3) {
            break label587;
          }
          localJumpAction.a(paramContext[0], a(paramContext[1], false));
        }
        for (;;)
        {
          i += 1;
          break;
          label587:
          localJumpAction.a(paramContext[0], paramContext[1]);
        }
      }
    }
    return localJumpAction;
  }
  
  public static String a(String paramString, boolean paramBoolean)
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
  
  private static boolean a(boolean... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      QLog.e("JumpAction", 1, "judgeNeedDecodeUrlByParam error: params are null");
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramVarArgs.length) {
        break label41;
      }
      if (paramVarArgs[i] == 0) {
        break;
      }
      i += 1;
    }
    label41:
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
  
  private static String[] a(String paramString, boolean... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      QLog.e("JumpAction", 1, "parseDefaultBodyArray: params are empty");
      return paramString.split("\\?");
    }
    int i = 0;
    while (i < paramVarArgs.length)
    {
      if (paramVarArgs[i] != 0) {
        return a(paramString, "?");
      }
      i += 1;
    }
    return paramString.split("\\?");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpParser
 * JD-Core Version:    0.7.0.1
 */