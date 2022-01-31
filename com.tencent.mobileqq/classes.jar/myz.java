import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class myz
{
  public int a;
  public Context a;
  public String a;
  
  public myz(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = a(paramContext, paramString);
    a(c());
  }
  
  public int a(Context paramContext, String paramString)
  {
    return a(paramContext).getInt(paramString + "_" + b(), 0);
  }
  
  protected SharedPreferences a(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext);
  }
  
  public abstract String a();
  
  public String a(AppInterface paramAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonConfigBase", 2, "handleConfig type = " + paramConfig.type.get());
    }
    if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() < 1) || (paramConfig.msg_content_list.get(0) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CommonConfigBase", 2, "handleQuickShotShareToStoryConfig data is null!!!");
      }
      a(this.jdField_a_of_type_AndroidContentContext, paramAppInterface.getCurrentAccountUin());
      return null;
    }
    return a(paramConfig);
  }
  
  protected String a(ConfigurationService.Config paramConfig)
  {
    paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = augt.a(paramConfig.content.get().toByteArray());
      if (paramConfig != null) {
        try
        {
          String str = new String(paramConfig, "UTF-8");
          return str;
        }
        catch (Exception paramConfig)
        {
          if (QLog.isColorLevel()) {
            QLog.w("CommonConfigBase", 2, QLog.getStackTraceString(paramConfig));
          }
          return null;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (QLog.isColorLevel()) {
            QLog.w("CommonConfigBase", 2, QLog.getStackTraceString(localOutOfMemoryError));
          }
          System.gc();
          try
          {
            paramConfig = new String(paramConfig, "UTF-8");
            return paramConfig;
          }
          catch (Throwable paramConfig)
          {
            if (QLog.isColorLevel()) {
              QLog.w("CommonConfigBase", 2, QLog.getStackTraceString(paramConfig));
            }
          }
        }
      }
      return null;
    }
    return paramConfig.content.get().toStringUtf8();
  }
  
  public void a(Context paramContext, String paramString)
  {
    a(paramContext).edit().remove(paramString + "_" + b()).commit();
  }
  
  public void a(Context paramContext, String paramString, int paramInt)
  {
    a(paramContext).edit().putInt(paramString + "_" + b(), paramInt).commit();
  }
  
  public void a(AppInterface paramAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonConfigBase", 2, "handleConfig type = " + paramConfig.type.get());
    }
    this.jdField_a_of_type_Int = a(this.jdField_a_of_type_AndroidContentContext, paramAppInterface.getCurrentAccountUin());
    int i = paramConfig.version.get();
    if (this.jdField_a_of_type_Int == i) {
      if (QLog.isColorLevel()) {
        QLog.d("CommonConfigBase", 2, "handleConfig version code not changed .");
      }
    }
    do
    {
      return;
      a(this.jdField_a_of_type_AndroidContentContext, paramAppInterface.getCurrentAccountUin(), i);
      this.jdField_a_of_type_Int = i;
      paramConfig = a(paramAppInterface, paramConfig);
      if (TextUtils.isEmpty(paramConfig)) {
        break;
      }
    } while (a(paramAppInterface, paramConfig));
    b(paramConfig);
    a(paramConfig);
    return;
    b(paramConfig);
    a(paramConfig);
  }
  
  public abstract void a(String paramString);
  
  public boolean a(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString).optString(d(), "");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return false;
      }
      if (!(paramAppInterface instanceof QQAppInterface)) {
        return false;
      }
      paramAppInterface = ((bbwi)((QQAppInterface)paramAppInterface).getManager(47)).a(1);
      paramString = ajsf.aW + a() + ".tmp";
      localObject = new bbwg((String)localObject, new File(paramString));
      ((bbwg)localObject).b = 3;
      Bundle localBundle = new Bundle();
      localBundle.putString("file_path", paramString);
      paramAppInterface.a((bbwg)localObject, new mza(this), localBundle);
      return true;
    }
    catch (JSONException paramAppInterface) {}
    return false;
  }
  
  public abstract String b();
  
  public void b(String paramString)
  {
    SharedPreferences localSharedPreferences = a(this.jdField_a_of_type_AndroidContentContext);
    if (TextUtils.isEmpty(paramString))
    {
      localSharedPreferences.edit().remove(this.jdField_a_of_type_JavaLangString + "_" + a());
      return;
    }
    localSharedPreferences.edit().putString(this.jdField_a_of_type_JavaLangString + "_" + a(), paramString).commit();
  }
  
  public String c()
  {
    return a(this.jdField_a_of_type_AndroidContentContext).getString(this.jdField_a_of_type_JavaLangString + "_" + a(), null);
  }
  
  public String d()
  {
    return "more_config_url";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     myz
 * JD-Core Version:    0.7.0.1
 */