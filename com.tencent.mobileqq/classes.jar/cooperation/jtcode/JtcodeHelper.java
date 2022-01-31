package cooperation.jtcode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class JtcodeHelper
{
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("JtcodeHelper", 4, "createJtcodeAppInterface processName=" + paramString);
    }
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.tencent.mobileqq.wlx.WlxAppInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        try
        {
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.d("JtcodeHelper", 4, "*createJtcodeAppInterface load class fail");
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          paramBaseApplicationImpl.printStackTrace();
        }
        paramString = paramString;
        if (QLog.isDevelopLevel()) {
          QLog.d("JtcodeHelper", 4, "createJtcodeAppInterface 1");
        }
        paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "wlx_jtcode.apk");
        paramBaseApplicationImpl = paramString.loadClass("com.tencent.mobileqq.wlx.WlxAppInterface");
        BasicClassTypeUtil.setClassLoader(true, paramString);
      }
      do
      {
        return null;
        if (QLog.isDevelopLevel()) {
          QLog.d("JtcodeHelper", 4, "createJtcodeAppInterface 2");
        }
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (QLog.isDevelopLevel()) {
          QLog.d("JtcodeHelper", 4, "createJtcodeAppInterface 3");
        }
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
      paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    if (paramBaseApplicationImpl == null) {}
    return null;
  }
  
  /* Error */
  public static JSONObject a(String paramString)
  {
    // Byte code:
    //   0: new 111	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 117	java/io/File:exists	()Z
    //   13: ifeq +166 -> 179
    //   16: new 119	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 122	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore_2
    //   25: aload_2
    //   26: astore_0
    //   27: sipush 1024
    //   30: newarray byte
    //   32: astore_3
    //   33: aload_2
    //   34: astore_0
    //   35: new 35	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   42: astore 4
    //   44: aload_2
    //   45: astore_0
    //   46: aload_2
    //   47: aload_3
    //   48: invokevirtual 126	java/io/FileInputStream:read	([B)I
    //   51: istore_1
    //   52: iload_1
    //   53: ifle +43 -> 96
    //   56: aload_2
    //   57: astore_0
    //   58: aload 4
    //   60: new 128	java/lang/String
    //   63: dup
    //   64: aload_3
    //   65: iconst_0
    //   66: iload_1
    //   67: invokespecial 131	java/lang/String:<init>	([BII)V
    //   70: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: goto -30 -> 44
    //   77: astore_3
    //   78: aload_2
    //   79: astore_0
    //   80: aload_3
    //   81: invokevirtual 106	java/lang/Exception:printStackTrace	()V
    //   84: aload_2
    //   85: ifnull +94 -> 179
    //   88: aload_2
    //   89: invokevirtual 134	java/io/FileInputStream:close	()V
    //   92: aconst_null
    //   93: astore_0
    //   94: aload_0
    //   95: areturn
    //   96: aload_2
    //   97: astore_0
    //   98: new 136	org/json/JSONObject
    //   101: dup
    //   102: new 128	java/lang/String
    //   105: dup
    //   106: aload 4
    //   108: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: iconst_0
    //   112: invokestatic 142	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   115: invokespecial 145	java/lang/String:<init>	([B)V
    //   118: invokespecial 146	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   121: astore_3
    //   122: aload_3
    //   123: astore_0
    //   124: aload_2
    //   125: ifnull -31 -> 94
    //   128: aload_2
    //   129: invokevirtual 134	java/io/FileInputStream:close	()V
    //   132: aload_3
    //   133: areturn
    //   134: astore_0
    //   135: aload_0
    //   136: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   139: aload_3
    //   140: areturn
    //   141: astore_0
    //   142: aload_0
    //   143: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   146: aconst_null
    //   147: areturn
    //   148: astore_2
    //   149: aconst_null
    //   150: astore_0
    //   151: aload_0
    //   152: ifnull +7 -> 159
    //   155: aload_0
    //   156: invokevirtual 134	java/io/FileInputStream:close	()V
    //   159: aload_2
    //   160: athrow
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   166: goto -7 -> 159
    //   169: astore_2
    //   170: goto -19 -> 151
    //   173: astore_3
    //   174: aconst_null
    //   175: astore_2
    //   176: goto -98 -> 78
    //   179: aconst_null
    //   180: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	paramString	String
    //   51	16	1	i	int
    //   24	105	2	localFileInputStream	java.io.FileInputStream
    //   148	12	2	localObject1	Object
    //   169	1	2	localObject2	Object
    //   175	1	2	localObject3	Object
    //   32	33	3	arrayOfByte	byte[]
    //   77	4	3	localException1	Exception
    //   121	19	3	localJSONObject	JSONObject
    //   173	1	3	localException2	Exception
    //   42	65	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   27	33	77	java/lang/Exception
    //   35	44	77	java/lang/Exception
    //   46	52	77	java/lang/Exception
    //   58	74	77	java/lang/Exception
    //   98	122	77	java/lang/Exception
    //   128	132	134	java/io/IOException
    //   88	92	141	java/io/IOException
    //   16	25	148	finally
    //   155	159	161	java/io/IOException
    //   27	33	169	finally
    //   35	44	169	finally
    //   46	52	169	finally
    //   58	74	169	finally
    //   80	84	169	finally
    //   98	122	169	finally
    //   16	25	173	java/lang/Exception
  }
  
  public static void a(String paramString, Activity paramActivity, Intent paramIntent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("JtcodeHelper", 4, "before jumpJtcodePlugin");
    }
    paramString = "{ \"viewTag\":\"jtCode\", \"comeForm\":4, \"appInfo\":\"appid#0|bargainor_id#0|channel#qwallet_gotonfc\", \"userId\":\"" + paramString + "\" }";
    String str1 = paramIntent.getStringExtra("city_name");
    String str2 = paramIntent.getStringExtra("city_code");
    String str3 = paramIntent.getStringExtra("ykt_id");
    String str4 = paramIntent.getStringExtra("show_name");
    paramIntent = new Bundle();
    paramIntent.putString("json", paramString);
    paramIntent.putString("callbackSn", "0");
    paramIntent.putString("city_name", str1);
    paramIntent.putString("city_code", str2);
    paramIntent.putString("ykt_id", str3);
    paramIntent.putString("show_name", str4);
    paramString = new Intent();
    paramString.setClass(paramActivity, JtcodePluginInstallActivity.class);
    paramString.putExtras(paramIntent);
    paramActivity.startActivity(paramString);
    if (QLog.isDevelopLevel()) {
      QLog.i("JtcodeHelper", 4, "after jumpJtcodePlugin");
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("wlx isJtcodePluginPreInstall; uin=");
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = paramString;
        QLog.d("JtcodeHelper", 2, (String)localObject1);
      }
    }
    else
    {
      if ((paramContext != null) && (!TextUtils.isEmpty(paramString))) {
        break label63;
      }
    }
    label63:
    label233:
    do
    {
      do
      {
        do
        {
          return false;
          localObject1 = "null";
          break;
          localObject1 = SosoInterface.a();
          StringBuilder localStringBuilder;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder().append("wlx isJtcodePluginPreInstall; current get locationCity=");
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label363;
            }
            localObject2 = localObject1;
            QLog.d("JtcodeHelper", 2, (String)localObject2);
          }
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder().append("wlx isJtcodePluginPreInstall; locationCity=");
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label370;
            }
            localObject2 = localObject1;
            QLog.d("JtcodeHelper", 2, (String)localObject2);
          }
        } while (TextUtils.isEmpty((CharSequence)localObject1));
        paramString = a(paramContext.getFilesDir().getPath() + "/QWallet/" + paramString + "/hbThemeConfig.cfg");
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("wlx isJtcodePluginPreInstall; mCityConfig=");
          if (paramString == null) {
            break label377;
          }
          paramContext = paramString.toString();
          QLog.d("JtcodeHelper", 2, paramContext);
        }
      } while (paramString == null);
      paramString = paramString.optJSONObject("paycode_city_config");
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("wlx isJtcodePluginPreInstall; cityGson=");
        if (paramString == null) {
          break label383;
        }
        paramContext = paramString.toString();
        QLog.d("JtcodeHelper", 2, paramContext);
      }
    } while (paramString == null);
    label143:
    label288:
    paramString = paramString.optJSONObject((String)localObject1);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("wlx isJtcodePluginPreInstall; cityConfig=");
      if (paramString != null)
      {
        paramContext = paramString.toString();
        label341:
        QLog.d("JtcodeHelper", 2, paramContext);
      }
    }
    else
    {
      if (paramString == null) {
        break label395;
      }
    }
    label395:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      label363:
      localObject2 = "null";
      break;
      label370:
      localObject2 = "null";
      break label143;
      label377:
      paramContext = "null";
      break label233;
      label383:
      paramContext = "null";
      break label288;
      paramContext = "null";
      break label341;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.jtcode.JtcodeHelper
 * JD-Core Version:    0.7.0.1
 */