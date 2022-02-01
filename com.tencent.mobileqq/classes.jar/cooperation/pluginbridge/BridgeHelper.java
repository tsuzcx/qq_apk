package cooperation.pluginbridge;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Xml;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class BridgeHelper
  implements Runnable
{
  private static BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private static BridgeHelper jdField_a_of_type_CooperationPluginbridgeBridgeHelper;
  private static PluginLoadDialog jdField_a_of_type_CooperationPluginbridgePluginLoadDialog;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  private final HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean = false;
  
  private BridgeHelper(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public static BridgeHelper a(Context paramContext, String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get GeneralEntryConfigManager instancegInstance:");
        localStringBuilder.append(jdField_a_of_type_CooperationPluginbridgeBridgeHelper);
        localStringBuilder.append("uin:");
        localStringBuilder.append(paramString);
        QLog.i("BridgeHelper", 2, localStringBuilder.toString());
      }
      if (jdField_a_of_type_CooperationPluginbridgeBridgeHelper == null)
      {
        try
        {
          if (jdField_a_of_type_CooperationPluginbridgeBridgeHelper == null) {
            jdField_a_of_type_CooperationPluginbridgeBridgeHelper = new BridgeHelper(paramContext, paramString);
          }
        }
        finally {}
      }
      else if ((TextUtils.isEmpty(paramString)) || ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(jdField_a_of_type_CooperationPluginbridgeBridgeHelper.jdField_a_of_type_JavaLangString))))
      {
        jdField_a_of_type_CooperationPluginbridgeBridgeHelper.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        jdField_a_of_type_CooperationPluginbridgeBridgeHelper.jdField_a_of_type_Boolean = false;
        jdField_a_of_type_CooperationPluginbridgeBridgeHelper.jdField_a_of_type_JavaLangString = paramString;
        jdField_a_of_type_CooperationPluginbridgeBridgeHelper.jdField_a_of_type_JavaUtilHashMap.clear();
      }
      paramContext = jdField_a_of_type_CooperationPluginbridgeBridgeHelper;
      return paramContext;
    }
    finally {}
  }
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if (paramBaseApplicationImpl != null) {
      if (paramString == null) {
        return null;
      }
    }
    try
    {
      try
      {
        paramString = Class.forName("com.tencent.bridge.BridgeInterface");
        paramBaseApplicationImpl = paramString;
      }
      catch (Exception paramBaseApplicationImpl)
      {
        break label98;
      }
    }
    catch (ClassNotFoundException paramString)
    {
      label25:
      break label25;
    }
    paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "BridgePlugin.apk");
    paramBaseApplicationImpl = paramString.loadClass("com.tencent.bridge.BridgeInterface");
    BasicClassTypeUtil.setClassLoader(true, paramString);
    if (paramBaseApplicationImpl == null)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("BridgeHelper", 2, "*createBridgeAppInterface load class fail");
        return null;
      }
    }
    else
    {
      paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      if ((paramBaseApplicationImpl != null) && ((paramBaseApplicationImpl instanceof AppRuntime)))
      {
        paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
        return paramBaseApplicationImpl;
        label98:
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("*createBridgeAppInterface exception:");
          paramString.append(paramBaseApplicationImpl.toString());
          QLog.e("BridgeHelper", 2, paramString.toString());
        }
      }
      return null;
    }
    return null;
  }
  
  static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, Intent paramIntent, String paramString1, String paramString2, String paramString3)
  {
    if (paramIntent == null) {
      paramIntent = new Intent();
    }
    paramIntent.putExtra("param_plugin_gesturelock", true);
    paramIntent.putExtra("userQqResources", -1);
    paramIntent.putExtra("useSkinEngine", true);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    localPluginParams.jdField_b_of_type_JavaLangString = "BridgePlugin.apk";
    localPluginParams.e = "BridgePlugin";
    if (jdField_a_of_type_CooperationPluginbridgePluginLoadDialog == null) {
      jdField_a_of_type_CooperationPluginbridgePluginLoadDialog = new PluginLoadDialog(paramActivity, paramString3);
    }
    localPluginParams.jdField_a_of_type_AndroidAppDialog = jdField_a_of_type_CooperationPluginbridgePluginLoadDialog;
    localPluginParams.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    paramIntent.putExtra("distParamsString", paramString1);
    paramIntent.putExtra("distPluginId", paramString2);
    paramIntent.putExtra("distPluginName", paramString3);
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localPluginParams.f = "com.tencent.bridge.activity.BridgeMainActivity";
    localPluginParams.jdField_a_of_type_JavaLangClass = MainBridgeProxyActivity.class;
    localPluginParams.c = 19;
    localPluginParams.d = 15000;
    localPluginParams.jdField_b_of_type_Boolean = false;
    localPluginParams.g = null;
    a(paramActivity);
    IPluginManager.a(paramActivity, localPluginParams);
    ReportController.b(paramQQAppInterface, "P_CliOper", "BridgePlatform", "", "start_bridge_plugin", "BridgePlugin.apk", 0, 1, "", "", "", "");
  }
  
  static void a(Context paramContext)
  {
    if (jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      jdField_a_of_type_AndroidContentBroadcastReceiver = new BridgeHelper.MyReceiver(null);
    }
    IntentFilter localIntentFilter = new IntentFilter("bridge.onresume.broadcast");
    localIntentFilter.addAction("bridge.plugin.onresume.broadcast");
    paramContext.registerReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public String a(String paramString)
  {
    a();
    return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public HashMap<String, String> a()
  {
    a();
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 2;
      ThreadManager.getFileThreadHandler().post(jdField_a_of_type_CooperationPluginbridgeBridgeHelper);
    }
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    if (paramConfig.version != null)
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("receiveAllConfigs|type: 13,version: ");
        ((StringBuilder)???).append(paramConfig.version.get());
        QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)???).toString());
      }
      SharedPreUtils.a(this.jdField_a_of_type_AndroidContentContext, paramConfig.version.get(), this.jdField_a_of_type_JavaLangString);
    }
    if (paramConfig.content_list != null) {}
    for (;;)
    {
      int i;
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        paramConfig = paramConfig.content_list.get();
        if ((paramConfig != null) && (paramConfig.size() != 0))
        {
          Iterator localIterator = paramConfig.iterator();
          if (localIterator.hasNext())
          {
            paramConfig = (String)localIterator.next();
            if (QLog.isColorLevel())
            {
              ??? = new StringBuilder();
              ((StringBuilder)???).append("receiveAllConfigs|type: 13,content: ");
              ((StringBuilder)???).append(paramConfig);
              QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)???).toString());
            }
            if (TextUtils.isEmpty(paramConfig)) {
              continue;
            }
            XmlPullParser localXmlPullParser = Xml.newPullParser();
            try
            {
              localXmlPullParser.setInput(new ByteArrayInputStream(paramConfig.getBytes()), "UTF-8");
              i = localXmlPullParser.getEventType();
              paramConfig = "";
              break label558;
              if (localXmlPullParser.getDepth() == 2)
              {
                ??? = localXmlPullParser.getName();
              }
              else
              {
                ??? = paramConfig;
                if (localXmlPullParser.getDepth() == 3)
                {
                  ??? = localXmlPullParser.getName();
                  localXmlPullParser.next();
                  Object localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append(paramConfig);
                  ((StringBuilder)localObject2).append("_");
                  ((StringBuilder)localObject2).append((String)???);
                  localObject2 = ((StringBuilder)localObject2).toString();
                  String str = localXmlPullParser.getText();
                  synchronized (jdField_a_of_type_ArrayOfByte)
                  {
                    this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, str);
                    ??? = paramConfig;
                    if (QLog.isColorLevel())
                    {
                      ??? = new StringBuilder();
                      ((StringBuilder)???).append("config put. ");
                      ((StringBuilder)???).append((String)localObject2);
                      ((StringBuilder)???).append(" : ");
                      ((StringBuilder)???).append(str);
                      QLog.i("BridgeHelper", 2, ((StringBuilder)???).toString());
                      ??? = paramConfig;
                    }
                  }
                }
              }
              i = localXmlPullParser.next();
              paramConfig = (ConfigurationService.Config)???;
            }
            catch (IOException paramConfig)
            {
              paramConfig.printStackTrace();
              continue;
            }
            catch (XmlPullParserException paramConfig)
            {
              paramConfig.printStackTrace();
            }
            continue;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 13,content_list is empty ");
          }
          paramConfig = this.jdField_a_of_type_AndroidContentContext.getFilesDir();
          ??? = new StringBuilder();
          ((StringBuilder)???).append("entry_config_file_");
          ((StringBuilder)???).append(this.jdField_a_of_type_JavaLangString);
          paramConfig = new File(paramConfig, ((StringBuilder)???).toString());
          if (paramConfig.exists()) {
            paramConfig.delete();
          }
        }
        ThreadManager.getFileThreadHandler().removeCallbacks(jdField_a_of_type_CooperationPluginbridgeBridgeHelper);
        this.jdField_a_of_type_Int = 1;
        ThreadManager.getFileThreadHandler().post(jdField_a_of_type_CooperationPluginbridgeBridgeHelper);
        return;
      }
      return;
      label558:
      if (i != 1) {
        if (i != 2) {
          ??? = paramConfig;
        }
      }
    }
  }
  
  public void run()
  {
    int i = this.jdField_a_of_type_Int;
    Object localObject2;
    if (i == 1)
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("Write configContent to file: ");
        ((StringBuilder)???).append(this.jdField_a_of_type_JavaUtilHashMap);
        QLog.w("BridgeHelper", 2, ((StringBuilder)???).toString());
      }
      ??? = new ByteArrayOutputStream();
      try
      {
        ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)???);
        localObjectOutputStream.writeObject(this.jdField_a_of_type_JavaUtilHashMap);
        localObjectOutputStream.close();
        ((ByteArrayOutputStream)???).close();
      }
      catch (IOException localIOException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BridgeHelper", 2, "Exception happened while construct ObjectOutputStream. ", localIOException);
        }
      }
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getFilesDir();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("entry_config_file_");
      localStringBuilder2.append(this.jdField_a_of_type_JavaLangString);
      FileUtils.pushData2File(new File((File)localObject2, localStringBuilder2.toString()).getAbsolutePath(), ((ByteArrayOutputStream)???).toByteArray(), false);
      return;
    }
    if (i == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.w("BridgeHelper", 2, "Read configContent from file.");
      }
      ??? = this.jdField_a_of_type_AndroidContentContext.getFilesDir();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("entry_config_file_");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
      ??? = new File((File)???, ((StringBuilder)localObject2).toString());
      if (((File)???).exists())
      {
        ??? = FileUtils.fileToBytes((File)???);
        if (??? != null)
        {
          ??? = new ByteArrayInputStream((byte[])???);
          try
          {
            localObject2 = new ObjectInputStream((InputStream)???).readObject();
            if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && ((localObject2 instanceof HashMap))) {
              synchronized (jdField_a_of_type_ArrayOfByte)
              {
                this.jdField_a_of_type_JavaUtilHashMap.clear();
                this.jdField_a_of_type_JavaUtilHashMap.putAll((HashMap)localObject2);
              }
            }
            if (!QLog.isColorLevel()) {
              return;
            }
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.e("BridgeHelper", 2, "Exception happened while construct ObjectInputStream. ", localException);
            }
          }
        }
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("configContent: ");
      localStringBuilder1.append(this.jdField_a_of_type_JavaUtilHashMap.toString());
      QLog.i("BridgeHelper", 2, localStringBuilder1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.pluginbridge.BridgeHelper
 * JD-Core Version:    0.7.0.1
 */