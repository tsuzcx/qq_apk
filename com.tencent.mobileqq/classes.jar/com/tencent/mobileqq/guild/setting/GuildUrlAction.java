package com.tencent.mobileqq.guild.setting;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.avatar.BaseUrlAction;
import com.tencent.mobileqq.troop.avatar.HeaderSetting;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread.UploadState;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class GuildUrlAction
  extends BaseUrlAction
{
  private final String c;
  
  private GuildUrlAction(int paramInt)
  {
    if (paramInt != 1)
    {
      this.c = "https://qun.qq.com/cgi-bin/group_pro/manage/avatar_upload";
      return;
    }
    this.c = "https://qun.qq.com/cgi-bin/group_pro/manage/cover_upload";
  }
  
  private int a(boolean paramBoolean, String paramString, TroopUploadingThread.UploadState paramUploadState)
  {
    int k = -1;
    int j = k;
    if (paramBoolean)
    {
      int i = k;
      try
      {
        paramBoolean = QLog.isColorLevel();
        if (paramBoolean)
        {
          i = k;
          StringBuilder localStringBuilder = new StringBuilder();
          i = k;
          localStringBuilder.append("result: ");
          i = k;
          localStringBuilder.append(paramString);
          i = k;
          QLog.d("GuildUrlAction", 2, localStringBuilder.toString());
        }
        i = k;
        paramString = new JSONObject(paramString);
        i = k;
        k = paramString.optInt("retcode", -1);
        if (k != 0)
        {
          i = k;
          if (!paramString.optString("msg", "").toLowerCase().equals("success"))
          {
            j = k;
            if (k != 1001) {
              break label232;
            }
            i = k;
            paramString = paramString.optString("msg", "");
            i = k;
            paramUploadState.f = 1001;
            i = k;
            j = k;
            if (paramString.isEmpty()) {
              break label232;
            }
            i = k;
            paramUploadState.g = paramString;
            return k;
          }
        }
        i = k;
        j = k;
        if (QLog.isColorLevel())
        {
          i = k;
          QLog.d("GuildUrlAction", 2, "upload success");
          return k;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        j = i;
      }
    }
    label232:
    return j;
  }
  
  public static GuildUrlAction a(int paramInt)
  {
    return new GuildUrlAction(paramInt);
  }
  
  /* Error */
  public int a(java.net.HttpURLConnection paramHttpURLConnection, TroopUploadingThread.UploadState paramUploadState, com.tencent.mobileqq.troop.avatar.UploadItem paramUploadItem)
  {
    // Byte code:
    //   0: new 30	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   7: astore 7
    //   9: aconst_null
    //   10: astore_3
    //   11: aload_3
    //   12: astore 6
    //   14: aload_1
    //   15: invokevirtual 106	java/net/HttpURLConnection:getResponseCode	()I
    //   18: sipush 200
    //   21: if_icmpne +31 -> 52
    //   24: aload_3
    //   25: astore 6
    //   27: new 108	java/io/BufferedReader
    //   30: dup
    //   31: new 110	java/io/InputStreamReader
    //   34: dup
    //   35: aload_1
    //   36: invokevirtual 114	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   39: invokespecial 117	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   42: invokespecial 120	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore_3
    //   46: iconst_1
    //   47: istore 5
    //   49: goto +28 -> 77
    //   52: aload_3
    //   53: astore 6
    //   55: new 108	java/io/BufferedReader
    //   58: dup
    //   59: new 110	java/io/InputStreamReader
    //   62: dup
    //   63: aload_1
    //   64: invokevirtual 123	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   67: invokespecial 117	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   70: invokespecial 120	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   73: astore_3
    //   74: iconst_0
    //   75: istore 5
    //   77: aload_3
    //   78: astore 6
    //   80: aload_3
    //   81: invokevirtual 126	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   84: astore 8
    //   86: aload 8
    //   88: ifnull +17 -> 105
    //   91: aload_3
    //   92: astore 6
    //   94: aload 7
    //   96: aload 8
    //   98: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: goto -25 -> 77
    //   105: aload_3
    //   106: astore 6
    //   108: aload_3
    //   109: invokevirtual 129	java/io/BufferedReader:close	()V
    //   112: aload_3
    //   113: astore 6
    //   115: aload_0
    //   116: iload 5
    //   118: aload 7
    //   120: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: aload_2
    //   124: invokespecial 131	com/tencent/mobileqq/guild/setting/GuildUrlAction:a	(ZLjava/lang/String;Lcom/tencent/mobileqq/troop/avatar/TroopUploadingThread$UploadState;)I
    //   127: istore 4
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   137: iload 4
    //   139: ireturn
    //   140: astore_2
    //   141: goto +50 -> 191
    //   144: astore_2
    //   145: aload 6
    //   147: ifnull +21 -> 168
    //   150: aload 6
    //   152: invokevirtual 129	java/io/BufferedReader:close	()V
    //   155: goto +13 -> 168
    //   158: astore_3
    //   159: ldc 39
    //   161: iconst_1
    //   162: ldc 136
    //   164: aload_3
    //   165: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   168: aload_1
    //   169: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   172: ldc 39
    //   174: iconst_1
    //   175: ldc 136
    //   177: aload_2
    //   178: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   181: aload_1
    //   182: ifnull +7 -> 189
    //   185: aload_1
    //   186: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   189: iconst_m1
    //   190: ireturn
    //   191: aload_1
    //   192: ifnull +7 -> 199
    //   195: aload_1
    //   196: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   199: goto +5 -> 204
    //   202: aload_2
    //   203: athrow
    //   204: goto -2 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	GuildUrlAction
    //   0	207	1	paramHttpURLConnection	java.net.HttpURLConnection
    //   0	207	2	paramUploadState	TroopUploadingThread.UploadState
    //   0	207	3	paramUploadItem	com.tencent.mobileqq.troop.avatar.UploadItem
    //   127	11	4	i	int
    //   47	70	5	bool	boolean
    //   12	139	6	localUploadItem	com.tencent.mobileqq.troop.avatar.UploadItem
    //   7	112	7	localStringBuilder	StringBuilder
    //   84	13	8	str	String
    // Exception table:
    //   from	to	target	type
    //   14	24	140	finally
    //   27	46	140	finally
    //   55	74	140	finally
    //   80	86	140	finally
    //   94	102	140	finally
    //   108	112	140	finally
    //   115	129	140	finally
    //   150	155	140	finally
    //   159	168	140	finally
    //   168	181	140	finally
    //   14	24	144	java/io/IOException
    //   27	46	144	java/io/IOException
    //   55	74	144	java/io/IOException
    //   80	86	144	java/io/IOException
    //   94	102	144	java/io/IOException
    //   108	112	144	java/io/IOException
    //   115	129	144	java/io/IOException
    //   150	155	158	java/io/IOException
  }
  
  public List<String> a(AppInterface paramAppInterface)
  {
    paramAppInterface = new ArrayList();
    if (this.a != null)
    {
      int i = this.a.getInt("bkn", 0);
      String str = this.a.getString("groupID");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append("?bkn=");
      localStringBuilder.append(i);
      localStringBuilder.append("&groupProId=");
      localStringBuilder.append(str);
      paramAppInterface.add(localStringBuilder.toString());
    }
    return paramAppInterface;
  }
  
  public void b(AppInterface paramAppInterface)
  {
    HeaderSetting localHeaderSetting = new HeaderSetting();
    localHeaderSetting.a("qun.qq.com");
    if (this.a != null)
    {
      String str1 = this.a.getString("uin");
      String str2 = this.a.getString("ukey");
      String str3 = this.a.getString("pUin");
      paramAppInterface = (TicketManager)paramAppInterface.getManager(2);
      if (paramAppInterface != null) {
        paramAppInterface = paramAppInterface.getPskey(str1, "qun.qq.com");
      } else {
        paramAppInterface = "";
      }
      StringBuilder localStringBuilder = new StringBuilder(" uin=");
      localStringBuilder.append(str1);
      localStringBuilder.append(";");
      localStringBuilder.append(" skey=");
      localStringBuilder.append(str2);
      localStringBuilder.append(";");
      localStringBuilder.append(" p_skey=");
      localStringBuilder.append(paramAppInterface);
      localStringBuilder.append(";");
      localStringBuilder.append(" p_uin=");
      localStringBuilder.append(str3);
      localStringBuilder.append(";");
      localHeaderSetting.b(localStringBuilder.toString());
    }
    this.b = localHeaderSetting;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.GuildUrlAction
 * JD-Core Version:    0.7.0.1
 */