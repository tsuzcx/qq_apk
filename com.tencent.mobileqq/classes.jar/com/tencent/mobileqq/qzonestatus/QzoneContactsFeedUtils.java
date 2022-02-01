package com.tencent.mobileqq.qzonestatus;

import NS_MOBILE_NEWEST_FEEDS.newest_feeds_req;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import cooperation.qzone.QUA;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QzoneContactsFeedUtils
{
  private static final Pattern a = Pattern.compile("@?\\{uin:\\d+,nick(name)?:.*?\\}");
  
  public static newest_feeds_req a(int paramInt, long paramLong1, ArrayList<Long> paramArrayList, long paramLong2, String paramString)
  {
    return new newest_feeds_req(paramInt, paramLong1, paramArrayList, paramLong2, paramString, QUA.getQUA3(), null);
  }
  
  public static newest_feeds_req a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return new newest_feeds_req();
    }
    paramIntent = paramIntent.getSerializableExtra("req");
    if ((paramIntent != null) && ((paramIntent instanceof newest_feeds_req))) {
      return (newest_feeds_req)paramIntent;
    }
    return new newest_feeds_req();
  }
  
  public static Intent a(Intent paramIntent, newest_feeds_req paramnewest_feeds_req)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("req", paramnewest_feeds_req);
    return localIntent;
  }
  
  public static String a(String paramString)
  {
    if ("".equals(paramString)) {
      return null;
    }
    int k = paramString.indexOf("uin:");
    int j = paramString.indexOf(",");
    int i = 0;
    if (k != -1) {
      i = k + 4;
    }
    if ((i != 0) && (j != -1)) {
      return paramString.substring(i, j);
    }
    return null;
  }
  
  public static String a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramQQAppInterface != null))
    {
      Matcher localMatcher = a.matcher(paramString);
      String str1 = paramString;
      while (localMatcher.find())
      {
        String str2 = localMatcher.group();
        String str3 = a(str2);
        Object localObject = "";
        paramString = (String)localObject;
        if (!TextUtils.isEmpty(str3))
        {
          FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
          paramString = (String)localObject;
          if (localFriendsManager != null)
          {
            paramString = localFriendsManager.e(str3);
            if (paramString != null) {
              localObject = paramString.getFriendNickWithAlias();
            }
            paramString = (String)localObject;
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              paramString = b(str2);
            }
          }
        }
        if (!TextUtils.isEmpty(paramString))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("@");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(" ");
          str1 = str1.replace(str2, ((StringBuilder)localObject).toString());
        }
      }
      return str1;
    }
    return null;
  }
  
  public static ArrayList<Long> a(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    paramQQAppInterface = null;
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ((FriendsManager)localObject1).c();
    if (localObject2 != null)
    {
      localObject1 = new ArrayList(((List)localObject2).size());
      localObject2 = ((List)localObject2).iterator();
      for (;;)
      {
        paramQQAppInterface = (QQAppInterface)localObject1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        paramQQAppInterface = (Friends)((Iterator)localObject2).next();
        if ((paramQQAppInterface != null) && (Friends.isValidUin(paramQQAppInterface.uin))) {
          ((ArrayList)localObject1).add(Long.valueOf(Long.parseLong(paramQQAppInterface.uin)));
        }
      }
    }
    return paramQQAppInterface;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int k = paramString.indexOf(",nick:");
    int j = paramString.indexOf("}");
    int i = 0;
    if (k != -1) {
      i = k + 6;
    }
    if ((j != -1) && (i != 0)) {
      return paramString.substring(i, j);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qzonestatus.QzoneContactsFeedUtils
 * JD-Core Version:    0.7.0.1
 */