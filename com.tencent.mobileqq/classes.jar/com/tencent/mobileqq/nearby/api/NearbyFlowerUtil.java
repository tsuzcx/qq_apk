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
  private static String jdField_a_of_type_JavaLangString;
  private static int[] jdField_a_of_type_ArrayOfInt;
  
  public static int a(Context paramContext)
  {
    int i = jdField_a_of_type_Int;
    if (i > 0) {
      return i;
    }
    jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131299168);
    return jdField_a_of_type_Int;
  }
  
  public static int a(MessageForStructing paramMessageForStructing)
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
        if (paramMessageForStructing.a.size() > 0)
        {
          paramMessageForStructing = paramMessageForStructing.a.getString("fCount");
          i = j;
          if (!TextUtils.isEmpty(paramMessageForStructing)) {
            i = Integer.valueOf(paramMessageForStructing).intValue();
          }
        }
      }
    }
    return i;
  }
  
  public static ActionGlobalData a(String paramString)
  {
    paramString = new MagicfaceResLoader(a(paramString), 2).a("receive.xml");
    if (paramString == null) {
      return null;
    }
    return new MagicfaceActionDecoder().a(paramString);
  }
  
  public static DownloaderInterface a(QQAppInterface paramQQAppInterface)
  {
    return ((DownloaderFactory)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
  }
  
  public static String a(Context paramContext)
  {
    String str = jdField_a_of_type_JavaLangString;
    if (str != null) {
      return str;
    }
    a(SharedPreUtils.l(paramContext));
    return jdField_a_of_type_JavaLangString;
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
        if (((StructMsgItemLayout12)localObject).a.size() > 0)
        {
          paramMessageForStructing = ((StructMsgItemLayout12)localObject).a.getString("sNick");
          String str = ((StructMsgItemLayout12)localObject).a.getString("rNick");
          localObject = ((StructMsgItemLayout12)localObject).a.getString("cMean");
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
  
  public static String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(AppConstants.SDCARD_NEARBY_FLOWER);
    localStringBuffer.append(paramString);
    localStringBuffer.append(File.separator);
    return localStringBuffer.toString();
  }
  
  public static List<String> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = new File(a(paramString));
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
  
  public static void a(String paramString)
  {
    try
    {
      jdField_a_of_type_JavaLangString = new JSONObject(paramString).optString("icon");
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
          if (a(localObject[i].getName()))
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
  
  public static boolean a(String paramString)
  {
    return !TroopGiftUtil.a(a(paramString));
  }
  
  public static int[] a(Context paramContext)
  {
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    if (arrayOfInt != null) {
      return arrayOfInt;
    }
    paramContext = SharedPreUtils.l(paramContext);
    if (paramContext != null) {
      b(paramContext);
    }
    return jdField_a_of_type_ArrayOfInt;
  }
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramString));
    localStringBuilder.append(paramString);
    localStringBuilder.append(".zip");
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static void b(String paramString)
  {
    // Byte code:
    //   0: new 204	org/json/JSONObject
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 205	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: ldc_w 284
    //   11: invokevirtual 288	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   14: astore_0
    //   15: aload_0
    //   16: ifnull +46 -> 62
    //   19: aload_0
    //   20: invokevirtual 293	org/json/JSONArray:length	()I
    //   23: newarray int
    //   25: putstatic 275	com/tencent/mobileqq/nearby/api/NearbyFlowerUtil:jdField_a_of_type_ArrayOfInt	[I
    //   28: iconst_0
    //   29: istore_1
    //   30: iload_1
    //   31: aload_0
    //   32: invokevirtual 293	org/json/JSONArray:length	()I
    //   35: if_icmpge +27 -> 62
    //   38: aload_0
    //   39: iload_1
    //   40: invokevirtual 296	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   43: astore_3
    //   44: aload_3
    //   45: invokestatic 302	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   48: istore_2
    //   49: getstatic 275	com/tencent/mobileqq/nearby/api/NearbyFlowerUtil:jdField_a_of_type_ArrayOfInt	[I
    //   52: iload_1
    //   53: iload_2
    //   54: iastore
    //   55: iload_1
    //   56: iconst_1
    //   57: iadd
    //   58: istore_1
    //   59: goto -29 -> 30
    //   62: return
    //   63: astore_0
    //   64: return
    //   65: astore_3
    //   66: goto -11 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	paramString	String
    //   29	30	1	i	int
    //   48	6	2	j	int
    //   43	2	3	str	String
    //   65	1	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	15	63	org/json/JSONException
    //   19	28	63	org/json/JSONException
    //   30	44	63	org/json/JSONException
    //   44	55	63	org/json/JSONException
    //   44	55	65	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.NearbyFlowerUtil
 * JD-Core Version:    0.7.0.1
 */