package com.tencent.mobileqq.pic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.transfile.HttpDownloaderParams;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StructMsgPicPreDelegate
{
  public static int a = 0;
  public static boolean b = false;
  public static String c = "struct_msg_pic_pre";
  
  public static int a()
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append(c);
      return localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).getInt("mStructMsgPicSwitch", 0);
    }
    return 0;
  }
  
  public static void a(int paramInt)
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      a = paramInt;
      b = true;
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((QQAppInterface)localObject).getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append(c);
      localObject = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).edit();
      ((SharedPreferences.Editor)localObject).putInt("mStructMsgPicSwitch", paramInt);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public static void a(MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface)
  {
    int i = BasePicPreDownloadUtils.a();
    if (!b)
    {
      a = a();
      b = true;
    }
    if ((i != 0) && (a == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("StructMsgPicPreDelegate", 2, "not wifi not pre download");
      }
      return;
    }
    if (paramMessageForStructing != null)
    {
      paramQQAppInterface = paramMessageForStructing.structingMsg;
      ArrayList localArrayList = new ArrayList();
      Object localObject;
      if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof AbsShareMsg)))
      {
        localObject = ((AbsShareMsg)paramQQAppInterface).getStructMsgItemLists();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            a((AbsStructMsgElement)((Iterator)localObject).next(), localArrayList);
          }
        }
      }
      if (localArrayList.size() > 0)
      {
        localObject = new HttpDownloaderParams();
        ((HttpDownloaderParams)localObject).param1 = paramQQAppInterface.mMsgServiceID;
        ((HttpDownloaderParams)localObject).param2 = paramQQAppInterface.mMsgTemplateID;
        ((HttpDownloaderParams)localObject).param3 = String.valueOf(paramMessageForStructing.istroop);
        ((HttpDownloaderParams)localObject).isPreDownload = true;
        paramMessageForStructing = localArrayList.iterator();
        while (paramMessageForStructing.hasNext()) {
          a((String)paramMessageForStructing.next(), (HttpDownloaderParams)localObject);
        }
      }
    }
  }
  
  public static void a(AbsStructMsgElement paramAbsStructMsgElement, List<String> paramList)
  {
    if ((paramAbsStructMsgElement != null) && ((paramAbsStructMsgElement instanceof AbsStructMsgItem)))
    {
      paramAbsStructMsgElement = ((AbsStructMsgItem)paramAbsStructMsgElement).ax;
      if ((paramAbsStructMsgElement != null) && (paramAbsStructMsgElement.size() > 0)) {
        paramAbsStructMsgElement = paramAbsStructMsgElement.iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (paramAbsStructMsgElement.hasNext())
        {
          a((AbsStructMsgElement)paramAbsStructMsgElement.next(), paramList);
          continue;
          if ((paramAbsStructMsgElement != null) && ((paramAbsStructMsgElement instanceof StructMsgItemCover)))
          {
            paramAbsStructMsgElement = ((StructMsgItemCover)paramAbsStructMsgElement).av;
            if ((!TextUtils.isEmpty(paramAbsStructMsgElement)) && (paramAbsStructMsgElement.startsWith("http"))) {
              try
              {
                if (a(new URL(paramAbsStructMsgElement).getHost()))
                {
                  paramList.add(paramAbsStructMsgElement);
                  return;
                }
              }
              catch (MalformedURLException paramAbsStructMsgElement)
              {
                paramAbsStructMsgElement.printStackTrace();
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(String paramString, HttpDownloaderParams paramHttpDownloaderParams)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http"))) {
      HttpDownloader.downloadImageByHttpEngine(paramString, paramHttpDownloaderParams, null, 1);
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = Pattern.compile("((\\.|^)(qq\\.com|soso\\.com|gtimg\\.cn|url\\.cn|qpic\\.cn|qlogo\\.cn|idqqimg\\.com)$)").matcher(paramString).find();
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" host = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ,isTencentDomain = ");
      localStringBuilder.append(bool);
      QLog.d("StructMsgPicPreDelegate", 4, localStringBuilder.toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.StructMsgPicPreDelegate
 * JD-Core Version:    0.7.0.1
 */