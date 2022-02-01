package com.tencent.mobileqq.nearby.api;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.magicfaceaction.MagicfaceActionDecoder;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class NearbyFlowerUtil
{
  public static int a;
  private static String b;
  private static int[] c;
  
  public static DownloaderInterface a(QQAppInterface paramQQAppInterface)
  {
    return ((DownloaderFactory)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
  }
  
  public static String a(Context paramContext)
  {
    String str = b;
    if (str != null) {
      return str;
    }
    a(SharedPreUtils.O(paramContext));
    return b;
  }
  
  public static String a(MessageForStructing paramMessageForStructing)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramMessageForStructing = (AbsShareMsg)paramMessageForStructing.structingMsg;
    if (paramMessageForStructing.getItemCount() > 0)
    {
      paramMessageForStructing = paramMessageForStructing.getItemByIndex(0);
      if ((paramMessageForStructing instanceof StructMsgItemLayout12))
      {
        Object localObject = (StructMsgItemLayout12)paramMessageForStructing;
        if (((StructMsgItemLayout12)localObject).az.size() > 0)
        {
          paramMessageForStructing = ((StructMsgItemLayout12)localObject).az.getString("sNick");
          String str = ((StructMsgItemLayout12)localObject).az.getString("rNick");
          localObject = ((StructMsgItemLayout12)localObject).az.getString("cMean");
          localStringBuilder.append(paramMessageForStructing);
          localStringBuilder.append("送给");
          localStringBuilder.append(str);
          localStringBuilder.append((String)localObject);
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(INearbyFlowerMessage paramINearbyFlowerMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://sqimg.qq.com/qq_product_operations/flower/animation/android/");
    localStringBuilder.append(paramINearbyFlowerMessage.getpURL());
    return localStringBuilder.toString();
  }
  
  public static void a(String paramString)
  {
    try
    {
      b = new JSONObject(paramString).optString("icon");
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public static void a(HashMap<String, Integer> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    Object localObject = new File(AppConstants.SDCARD_NEARBY_FLOWER);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = ((File)localObject).listFiles();
    if (localObject != null)
    {
      int i = 0;
      while (i < localObject.length)
      {
        if ((localObject[i].exists()) && (localObject[i].isDirectory()))
        {
          StringBuilder localStringBuilder;
          if (c(localObject[i].getName()))
          {
            localHashMap.put(localObject[i].getName(), Integer.valueOf(3));
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("Package Downloaded:");
              localStringBuilder.append(localObject[i].getName());
              QLog.d("NearbyFlowerUtil", 2, localStringBuilder.toString());
            }
          }
          else
          {
            FileUtils.deleteDirectory(localObject[i].getAbsolutePath());
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("Package deleted:");
              localStringBuilder.append(localObject[i].getName());
              QLog.d("NearbyFlowerUtil", 2, localStringBuilder.toString());
            }
          }
        }
        i += 1;
      }
    }
    paramHashMap.putAll(localHashMap);
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool1 = paramMessageRecord instanceof ChatMessage;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramMessageRecord = (ChatMessage)paramMessageRecord;
    bool1 = bool2;
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      bool1 = bool2;
      if (paramMessageRecord.structingMsg != null)
      {
        bool1 = bool2;
        if ((paramMessageRecord.structingMsg instanceof AbsShareMsg))
        {
          bool1 = bool2;
          if (paramMessageRecord.structingMsg.mMsgServiceID == 52)
          {
            paramMessageRecord = (AbsShareMsg)paramMessageRecord.structingMsg;
            bool1 = bool2;
            if (paramMessageRecord.getItemCount() > 0)
            {
              bool1 = bool2;
              if ((paramMessageRecord.getItemByIndex(0) instanceof StructMsgItemLayout12)) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static int b(MessageForStructing paramMessageForStructing)
  {
    paramMessageForStructing = (AbsShareMsg)paramMessageForStructing.structingMsg;
    int k = paramMessageForStructing.getItemCount();
    int j = 0;
    int i = j;
    if (k > 0)
    {
      paramMessageForStructing = paramMessageForStructing.getItemByIndex(0);
      i = j;
      if ((paramMessageForStructing instanceof StructMsgItemLayout12))
      {
        paramMessageForStructing = (StructMsgItemLayout12)paramMessageForStructing;
        i = j;
        if (paramMessageForStructing.az.size() > 0)
        {
          paramMessageForStructing = paramMessageForStructing.az.getString("fCount");
          i = j;
          if (!TextUtils.isEmpty(paramMessageForStructing)) {
            i = Integer.valueOf(paramMessageForStructing).intValue();
          }
        }
      }
    }
    return i;
  }
  
  /* Error */
  public static void b(String paramString)
  {
    // Byte code:
    //   0: new 107	org/json/JSONObject
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 109	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: ldc 212
    //   10: invokevirtual 216	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   13: astore_0
    //   14: aload_0
    //   15: ifnull +46 -> 61
    //   18: aload_0
    //   19: invokevirtual 221	org/json/JSONArray:length	()I
    //   22: newarray int
    //   24: putstatic 223	com/tencent/mobileqq/nearby/api/NearbyFlowerUtil:c	[I
    //   27: iconst_0
    //   28: istore_1
    //   29: iload_1
    //   30: aload_0
    //   31: invokevirtual 221	org/json/JSONArray:length	()I
    //   34: if_icmpge +27 -> 61
    //   37: aload_0
    //   38: iload_1
    //   39: invokevirtual 226	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   42: astore_3
    //   43: aload_3
    //   44: invokestatic 232	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   47: istore_2
    //   48: getstatic 223	com/tencent/mobileqq/nearby/api/NearbyFlowerUtil:c	[I
    //   51: iload_1
    //   52: iload_2
    //   53: iastore
    //   54: iload_1
    //   55: iconst_1
    //   56: iadd
    //   57: istore_1
    //   58: goto -29 -> 29
    //   61: return
    //   62: astore_0
    //   63: return
    //   64: astore_3
    //   65: goto -11 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramString	String
    //   28	30	1	i	int
    //   47	6	2	j	int
    //   42	2	3	str	String
    //   64	1	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	14	62	org/json/JSONException
    //   18	27	62	org/json/JSONException
    //   29	43	62	org/json/JSONException
    //   43	54	62	org/json/JSONException
    //   43	54	64	java/lang/Exception
  }
  
  public static int[] b(Context paramContext)
  {
    int[] arrayOfInt = c;
    if (arrayOfInt != null) {
      return arrayOfInt;
    }
    paramContext = SharedPreUtils.O(paramContext);
    if (paramContext != null) {
      b(paramContext);
    }
    return c;
  }
  
  public static int c(Context paramContext)
  {
    int i = a;
    if (i > 0) {
      return i;
    }
    a = paramContext.getResources().getDimensionPixelSize(2131299920);
    return a;
  }
  
  public static boolean c(String paramString)
  {
    return !TroopGiftUtil.a(d(paramString));
  }
  
  public static List<String> d(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = new File(e(paramString));
    if (paramString.exists())
    {
      paramString = paramString.listFiles();
      if (paramString == null) {
        return localArrayList;
      }
      int i = 0;
      while (i < paramString.length)
      {
        if (paramString[i].getAbsolutePath().endsWith(".png")) {
          localArrayList.add(paramString[i].getAbsolutePath());
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static String e(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(AppConstants.SDCARD_NEARBY_FLOWER);
    localStringBuffer.append(paramString);
    localStringBuffer.append(File.separator);
    return localStringBuffer.toString();
  }
  
  public static String f(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e(paramString));
    localStringBuilder.append(paramString);
    localStringBuilder.append(".zip");
    return localStringBuilder.toString();
  }
  
  public static ActionGlobalData g(String paramString)
  {
    paramString = new MagicfaceResLoader(e(paramString), 2).a("receive.xml");
    if (paramString == null) {
      return null;
    }
    return new MagicfaceActionDecoder().b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.NearbyFlowerUtil
 * JD-Core Version:    0.7.0.1
 */