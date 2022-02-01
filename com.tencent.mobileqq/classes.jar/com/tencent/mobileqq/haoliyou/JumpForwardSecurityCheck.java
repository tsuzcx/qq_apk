package com.tencent.mobileqq.haoliyou;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardFileBaseOption;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardManager;
import com.tencent.mobileqq.haoliyou.sso.OnCheckShareListener;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.JumpForwardPkgManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78.AppFileMsgInfo;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78.CheckShareExtensionReq;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78.ImgInfo;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78.TextInfo;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78.VideoInfo;

public class JumpForwardSecurityCheck
{
  public QBaseActivity a;
  public HashSet<String> b;
  public WeakReference<OnCheckShareListener> c;
  UriParserPathHelper d;
  
  public JumpForwardSecurityCheck(QBaseActivity paramQBaseActivity, OnCheckShareListener paramOnCheckShareListener)
  {
    this.a = paramQBaseActivity;
    this.b = JumpForwardPkgManager.c(paramQBaseActivity);
    this.c = new WeakReference(paramOnCheckShareListener);
  }
  
  private boolean a(Uri paramUri, int paramInt, String paramString)
  {
    if (this.d == null) {
      this.d = new UriParserPathHelper(this.a, false, new JumpForwardSecurityCheck.1(this, paramInt, paramString));
    }
    String str = this.d.a(paramUri, true, false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("system share.prepareFileInfoAndReq : uri= ");
    localStringBuilder.append(paramUri);
    localStringBuilder.append(", path= ");
    localStringBuilder.append(str);
    QLog.d("CheckForward.Security", 1, localStringBuilder.toString());
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    if (!this.d.c)
    {
      if (this.d.a()) {
        return true;
      }
      paramUri = new File(str);
      long l = paramUri.length();
      if ((!this.d.c) && (!this.d.a()) && (l == 0L)) {
        return false;
      }
      if ((!ForwardFileBaseOption.g(str)) && (paramUri.canRead()))
      {
        if (paramInt == 2)
        {
          paramUri = new ArrayList();
          paramUri.add(str);
          a(paramUri, paramString);
          return true;
        }
        if (paramInt == 4)
        {
          paramUri = new ArrayList();
          paramUri.add(str);
          b(paramUri, paramString);
          return true;
        }
        if (paramInt == 3) {
          a(str, paramString);
        }
        return true;
      }
      QLog.d("CheckForward.Security", 1, "system share.prepareFileInfoAndReq : can not Read");
      return false;
    }
    return true;
  }
  
  public Uri a(Bundle paramBundle)
  {
    paramBundle = paramBundle.get("android.intent.extra.STREAM");
    if (paramBundle != null)
    {
      if ((paramBundle instanceof Uri)) {
        return (Uri)paramBundle;
      }
      if ((paramBundle instanceof String)) {
        return Uri.parse((String)paramBundle);
      }
    }
    return null;
  }
  
  public oidb_cmd0xc78.CheckShareExtensionReq a()
  {
    oidb_cmd0xc78.CheckShareExtensionReq localCheckShareExtensionReq = new oidb_cmd0xc78.CheckShareExtensionReq();
    localCheckShareExtensionReq.uin.set(Long.valueOf(this.a.getAppRuntime().getCurrentAccountUin()).longValue());
    Object localObject = this.b;
    if ((localObject != null) && (!((HashSet)localObject).isEmpty()))
    {
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localCheckShareExtensionReq.android_package_names.add(str);
      }
    }
    int i = 0;
    if (JumpShareUtils.b())
    {
      localCheckShareExtensionReq.user_flag1.set(1L);
      i = JumpShareUtils.a();
      localCheckShareExtensionReq.user_flag2.set(i);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setRequestCommonFiled flag =");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" ,pkg: ");
      QLog.d("CheckForward.Security", 2, ((StringBuilder)localObject).toString());
    }
    return localCheckShareExtensionReq;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendCheckTextShareReq text ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("CheckForward.Security", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (CheckForwardManager)this.a.getAppRuntime().getManager(QQManagerFactory.CHECK_FORWARD_MANAGER);
    oidb_cmd0xc78.CheckShareExtensionReq localCheckShareExtensionReq = a();
    localCheckShareExtensionReq.content_type.set(1);
    oidb_cmd0xc78.TextInfo localTextInfo = new oidb_cmd0xc78.TextInfo();
    localTextInfo.text_content.set(paramString);
    localCheckShareExtensionReq.texts.add(localTextInfo);
    paramString = (OnCheckShareListener)this.c.get();
    if (paramString != null) {
      ((CheckForwardManager)localObject).a((QQAppInterface)this.a.getAppRuntime(), localCheckShareExtensionReq, "android.intent.action.SEND", paramString);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendCheckVideoShareReq path = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",action= ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("CheckForward.Security", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (CheckForwardManager)this.a.getAppRuntime().getManager(QQManagerFactory.CHECK_FORWARD_MANAGER);
    oidb_cmd0xc78.CheckShareExtensionReq localCheckShareExtensionReq = a();
    localCheckShareExtensionReq.content_type.set(3);
    if ((!TextUtils.isEmpty(paramString1)) && (new File(paramString1).exists()))
    {
      oidb_cmd0xc78.VideoInfo localVideoInfo = new oidb_cmd0xc78.VideoInfo();
      String str = HexUtil.bytes2HexStr(FileManagerUtil.g(paramString1));
      localVideoInfo.md5.set(str);
      long l = ShortVideoUtils.getDurationOfVideo(paramString1);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sendCheckVideoShareReq md5= ");
        localStringBuilder.append(str);
        localStringBuilder.append(",du=");
        localStringBuilder.append(l);
        QLog.d("CheckForward.Security", 2, localStringBuilder.toString());
      }
      localVideoInfo.sha1.set(JumpShareUtils.a(paramString1));
      localVideoInfo.play_duration.set((int)l);
      localCheckShareExtensionReq.videos.add(localVideoInfo);
    }
    paramString1 = (OnCheckShareListener)this.c.get();
    if (paramString1 != null) {
      ((CheckForwardManager)localObject).a((QQAppInterface)this.a.getAppRuntime(), localCheckShareExtensionReq, paramString2, paramString1);
    }
  }
  
  public void a(ArrayList<String> paramArrayList, String paramString)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sendCheckImgShareReq path len= ");
        ((StringBuilder)localObject1).append(paramArrayList.size());
        ((StringBuilder)localObject1).append(", action=");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("CheckForward.Security", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = (CheckForwardManager)this.a.getAppRuntime().getManager(QQManagerFactory.CHECK_FORWARD_MANAGER);
      oidb_cmd0xc78.CheckShareExtensionReq localCheckShareExtensionReq = a();
      localCheckShareExtensionReq.content_type.set(2);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject4 = (String)paramArrayList.next();
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          Object localObject2 = new File((String)localObject4);
          if (((File)localObject2).exists())
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("sendCheckImgShareReq path ");
              ((StringBuilder)localObject3).append((String)localObject4);
              QLog.d("CheckForward.Security", 2, ((StringBuilder)localObject3).toString());
            }
            Object localObject3 = new oidb_cmd0xc78.ImgInfo();
            String str = HexUtil.bytes2HexStr(FileManagerUtil.g((String)localObject4));
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("sendCheckImgShareReq md5= ");
              localStringBuilder.append(str);
              QLog.d("CheckForward.Security", 2, localStringBuilder.toString());
            }
            ((oidb_cmd0xc78.ImgInfo)localObject3).md5.set(str);
            ((oidb_cmd0xc78.ImgInfo)localObject3).sha1.set(JumpShareUtils.a((String)localObject4));
            localObject4 = JumpShareUtils.b((String)localObject4);
            if (localObject4 != null)
            {
              ((oidb_cmd0xc78.ImgInfo)localObject3).width.set(((Integer)((Pair)localObject4).first).intValue());
              ((oidb_cmd0xc78.ImgInfo)localObject3).height.set(((Integer)((Pair)localObject4).second).intValue());
            }
            localObject2 = JumpShareUtils.a(this.a, (File)localObject2);
            if (localObject2 != null)
            {
              if (!TextUtils.isEmpty((CharSequence)((Pair)localObject2).first)) {
                ((oidb_cmd0xc78.ImgInfo)localObject3).qr_code_result.set(((StringBuilder)((Pair)localObject2).first).toString());
              }
              if (!TextUtils.isEmpty((CharSequence)((Pair)localObject2).second)) {
                ((oidb_cmd0xc78.ImgInfo)localObject3).qr_decode_type.set(((StringBuilder)((Pair)localObject2).second).toString());
              }
            }
            localCheckShareExtensionReq.imgs.add((MessageMicro)localObject3);
          }
        }
      }
      paramArrayList = (OnCheckShareListener)this.c.get();
      if (paramArrayList != null) {
        ((CheckForwardManager)localObject1).a((QQAppInterface)this.a.getAppRuntime(), localCheckShareExtensionReq, paramString, paramArrayList);
      }
    }
  }
  
  public boolean a(Intent paramIntent, String paramString)
  {
    for (;;)
    {
      try
      {
        if (!ZhuoXusManager.a().e()) {
          return false;
        }
        Bundle localBundle = paramIntent.getExtras();
        String str = paramIntent.getType();
        if (!TextUtils.isEmpty(str))
        {
          if (TextUtils.isEmpty(paramString)) {
            return false;
          }
          boolean bool = paramString.equals("android.intent.action.SEND");
          i = 3;
          if ((!bool) && (!paramString.equals("android.intent.action.SEND_MULTIPLE")))
          {
            if (paramString.equals("android.intent.action.VIEW"))
            {
              paramIntent = paramIntent.getData();
              if (paramIntent == null) {
                return false;
              }
              if ((str != null) && (str.startsWith("image/")))
              {
                if (a(paramIntent, 2, paramString)) {
                  return true;
                }
              }
              else
              {
                if (!str.startsWith("video/")) {
                  break label412;
                }
                if (a(paramIntent, i, paramString)) {
                  return true;
                }
              }
            }
          }
          else
          {
            bool = str.startsWith("text/");
            if ((bool) && (!localBundle.containsKey("android.intent.extra.STREAM")))
            {
              a(localBundle.getString("android.intent.extra.TEXT"));
              return true;
            }
            if (str.startsWith("message/"))
            {
              paramIntent = (SpannableString)localBundle.get("android.intent.extra.TEXT");
              if (paramIntent != null)
              {
                a(paramIntent.toString());
                return true;
              }
            }
            else if (str.startsWith("image/"))
            {
              if (paramString.equals("android.intent.action.SEND"))
              {
                paramIntent = a(localBundle);
                if ((paramIntent != null) && (a(paramIntent, 2, paramString))) {
                  return true;
                }
              }
              else
              {
                paramIntent = b(localBundle);
                if ((paramIntent != null) && (paramIntent.size() > 0))
                {
                  a(paramIntent, paramString);
                  return true;
                }
              }
            }
            else if (paramString.equals("android.intent.action.SEND"))
            {
              localBundle.get("android.intent.extra.STREAM");
              paramIntent = a(localBundle);
              if (paramIntent != null)
              {
                if (("text/x-vcard".equals(str)) && ("content".equals(paramIntent.getScheme()))) {
                  return false;
                }
                if (!str.startsWith("video/")) {
                  break label417;
                }
                if (a(paramIntent, i, paramString)) {
                  return true;
                }
              }
            }
            else
            {
              paramIntent = b(localBundle);
              if ((paramIntent != null) && (paramIntent.size() > 0))
              {
                b(paramIntent, paramString);
                return true;
              }
            }
          }
        }
        else
        {
          return false;
        }
      }
      catch (Throwable paramIntent)
      {
        QLog.e("CheckForward.Security", 1, "system share.prepareSecurityCheck exception=", paramIntent);
      }
      return false;
      label412:
      int i = 4;
      continue;
      label417:
      i = 4;
    }
  }
  
  public ArrayList<String> b(Bundle paramBundle)
  {
    ArrayList localArrayList = new ArrayList();
    paramBundle = paramBundle.get("android.intent.extra.STREAM");
    if ((paramBundle != null) && ((paramBundle instanceof ArrayList)))
    {
      paramBundle = (ArrayList)paramBundle;
      Object localObject = this.a;
      int i = 0;
      localObject = new UriParserPathHelper((Activity)localObject, false, null);
      while (i < paramBundle.size())
      {
        String str = ((UriParserPathHelper)localObject).a((Uri)paramBundle.get(i));
        if (!TextUtils.isEmpty(str)) {
          localArrayList.add(str);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public void b(ArrayList<String> paramArrayList, String paramString)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sendCheckFileShareReq path len= ");
        ((StringBuilder)localObject1).append(paramArrayList.size());
        ((StringBuilder)localObject1).append(", action=");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("CheckForward.Security", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = (CheckForwardManager)this.a.getAppRuntime().getManager(QQManagerFactory.CHECK_FORWARD_MANAGER);
      oidb_cmd0xc78.CheckShareExtensionReq localCheckShareExtensionReq = a();
      localCheckShareExtensionReq.content_type.set(4);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str1 = (String)paramArrayList.next();
        if (!TextUtils.isEmpty(str1))
        {
          File localFile = new File(str1);
          if (localFile.exists())
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("sendCheckFileShareReq path ");
              ((StringBuilder)localObject2).append(str1);
              QLog.d("CheckForward.Security", 2, ((StringBuilder)localObject2).toString());
            }
            Object localObject2 = new oidb_cmd0xc78.AppFileMsgInfo();
            String str2 = HexUtil.bytes2HexStr(FileManagerUtil.g(str1));
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("sendCheckFileShareReq md5= ");
              localStringBuilder.append(str2);
              QLog.d("CheckForward.Security", 2, localStringBuilder.toString());
            }
            ((oidb_cmd0xc78.AppFileMsgInfo)localObject2).md5.set(str2);
            ((oidb_cmd0xc78.AppFileMsgInfo)localObject2).sha1.set(JumpShareUtils.a(str1));
            ((oidb_cmd0xc78.AppFileMsgInfo)localObject2).file_size.set((int)localFile.length());
            localCheckShareExtensionReq.files.add((MessageMicro)localObject2);
          }
        }
      }
      paramArrayList = (OnCheckShareListener)this.c.get();
      if (paramArrayList != null) {
        ((CheckForwardManager)localObject1).a((QQAppInterface)this.a.getAppRuntime(), localCheckShareExtensionReq, paramString, paramArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JumpForwardSecurityCheck
 * JD-Core Version:    0.7.0.1
 */