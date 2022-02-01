import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

public class lbx
{
  private static int a(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("task_id");
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static String a(ConfigurationService.Config paramConfig, int paramInt1, int paramInt2)
  {
    String str2 = "QAVConfig_" + paramInt2;
    if (paramConfig.msg_content_list != null) {}
    int i;
    for (paramInt2 = paramConfig.msg_content_list.size();; paramInt2 = -1)
    {
      i = paramConfig.version.get();
      QLog.w(str2, 1, "handleCompressConfig, serverVersion[" + i + "], localVersion[" + paramInt1 + "], size[" + paramInt2 + "]");
      if (i != paramInt1) {
        break;
      }
      return null;
    }
    if (paramInt2 <= 0) {
      return "";
    }
    paramInt1 = 0;
    Object localObject1 = null;
    String str1;
    while (paramInt1 < paramInt2)
    {
      ConfigurationService.Content localContent = (ConfigurationService.Content)paramConfig.msg_content_list.get(paramInt1);
      Object localObject2;
      if (localContent == null)
      {
        localObject2 = localObject1;
        paramInt1 += 1;
        localObject1 = localObject2;
      }
      else
      {
        int j = localContent.task_id.get();
        localObject2 = localContent.content.get().toByteArray();
        localObject1 = localObject2;
        if (localContent.compress.get() == 1)
        {
          localObject1 = apfw.a((byte[])localObject2);
          if ((localObject1 == null) && (QLog.isDevelopLevel())) {
            QLog.w(str2, 1, "handleCompressConfig, 解压失败");
          }
        }
        if (localObject1 != null) {}
        for (;;)
        {
          try
          {
            localObject1 = new String((byte[])localObject1, "utf-8");
            if ((paramInt2 <= 1) || (TextUtils.isEmpty((CharSequence)localObject1))) {
              break label361;
            }
            i = a((String)localObject1);
            localObject2 = new StringBuilder().append("handleCompressConfig, task_id[").append(j).append("|").append(i).append("], jsonContent[");
            if (localObject1 == null) {
              break label355;
            }
            bool = true;
            QLog.w(str2, 1, bool + "]");
            localObject2 = localObject1;
            if (i != j) {
              break;
            }
            return localObject1;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            if (QLog.isDevelopLevel()) {
              QLog.w(str2, 1, "handleCompressConfig, 编码失败", localUnsupportedEncodingException);
            }
          }
          str1 = null;
          continue;
          label355:
          boolean bool = false;
          continue;
          label361:
          i = 0;
        }
      }
    }
    return str1;
  }
  
  public static void a(int paramInt, String paramString, ConfigurationService.Config paramConfig)
  {
    String str = "QAVConfig_" + paramInt;
    try
    {
      b(paramInt, paramString, paramConfig);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.w(str, 1, "receiveAllConfigs, Exception");
    }
  }
  
  public static void a(int paramInt, String paramString, ConfigurationService.ConfigSeq paramConfigSeq)
  {
    paramString = "QAVConfig_" + paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(paramString, 1, "addAllConfigs, version[" + paramConfigSeq.version.get() + "]");
      }
      return;
      paramInt = EffectConfigBase.c(paramInt, EffectConfigBase.c);
      paramConfigSeq.version.set(paramInt);
      paramConfigSeq.compress.set(1);
      continue;
      paramInt = bhhr.a(BaseApplicationImpl.getContext());
      paramConfigSeq.version.set(paramInt);
      paramConfigSeq.compress.set(1);
    }
  }
  
  public static void a(int paramInt, boolean paramBoolean, ConfigurationService.RespGetConfig paramRespGetConfig)
  {
    String str = "QAVConfig_" + paramInt;
    if (!paramBoolean) {
      QLog.d(str, 2, "receiveConfigFail, timeout");
    }
    do
    {
      return;
      if (paramRespGetConfig.result.get() != 0)
      {
        paramInt = paramRespGetConfig.result.get();
        QLog.d(str, 2, "receiveConfigFail, result[" + paramInt + "]");
        return;
      }
    } while ((paramRespGetConfig.config_list != null) && (paramRespGetConfig.config_list.size() != 0));
    QLog.d(str, 2, "receiveConfigFail, config_list is null");
  }
  
  public static void b(int paramInt, String paramString, ConfigurationService.Config paramConfig)
  {
    String str = "QAVConfig_" + paramInt;
    int k = paramConfig.version.get();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int i;
    switch (paramInt)
    {
    default: 
      i = -1;
      paramString = anvx.a(2131708359);
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(str, 1, "receiveAllConfigs, ver[" + i + "->" + k + "], content[\n" + paramString + "\n]");
      }
      return;
      int j = EffectConfigBase.c(paramInt, EffectConfigBase.c);
      paramConfig = a(paramConfig, j, paramInt);
      paramString = paramConfig;
      i = j;
      if (paramConfig != null)
      {
        EffectConfigBase.a(paramInt, EffectConfigBase.c, k, paramConfig);
        paramString = paramConfig;
        i = j;
        continue;
        i = EffectConfigBase.c(paramInt, EffectConfigBase.c);
        paramConfig = a(paramConfig, i, paramInt);
        paramString = paramConfig;
        paramInt = i;
        if (paramConfig != null)
        {
          lpb.a(localQQAppInterface.getApplication(), paramConfig, k, true);
          paramString = paramConfig;
          continue;
          i = bhhr.a(localQQAppInterface.getApplication());
          paramConfig = a(paramConfig, i, paramInt);
          paramString = paramConfig;
          paramInt = i;
          if (paramConfig != null)
          {
            bhhr.a(localQQAppInterface.getApplication(), k);
            paramString = bhhr.c(localQQAppInterface.getCurrentAccountUin());
            if (paramString != null) {
              paramString.edit().putString("AvWeakNet_video_ConfigContent", paramConfig).commit();
            }
            paramString = paramConfig;
            continue;
          }
        }
        i = paramInt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lbx
 * JD-Core Version:    0.7.0.1
 */