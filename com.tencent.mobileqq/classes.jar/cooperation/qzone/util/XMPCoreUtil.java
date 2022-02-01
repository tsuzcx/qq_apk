package cooperation.qzone.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class XMPCoreUtil
{
  private static final String KEY = "xmp_core_file_md5";
  public static final String PROPERTY_NAME_CROP_WIDTH = "GPano:CroppedAreaImageWidthPixels";
  public static final String PROPERTY_NAME_FULL_WIDTH = "GPano:FullPanoWidthPixels";
  public static final String PROPERTY_NAME_IS_PANORAMA = "GPano:UsePanoramaViewer";
  public static final String SCHEMA_PANORAMA = "http://ns.google.com/photos/1.0/panorama/";
  private static final String TAG = "XMPCoreUtil";
  private static XMPCoreUtil instance = null;
  private static String mXMPCoreJarMD5;
  private static String mXMPCoreJarUrl = QzoneConfig.getInstance().getConfig("QZoneSetting", "xmpcoreUrl", "https://d3g.qq.com/sngapp/app/update/20171220130606_8640/xmpcore.jar");
  private boolean isModuleLoadSuccess = false;
  private ConcurrentHashMap<String, Boolean> panoramaHashMap = new ConcurrentHashMap();
  
  static
  {
    mXMPCoreJarMD5 = QzoneConfig.getInstance().getConfig("QZoneSetting", "XMPcoreJarMD5", "a0c5ac44fc2d0e35187f0c1479db48b2");
  }
  
  public static XMPCoreUtil getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new XMPCoreUtil();
        }
      }
      finally {}
    }
    return instance;
  }
  
  private boolean isNeedUpdate()
  {
    String str = LocalMultiProcConfig.getString("xmp_core_file_md5", null);
    if (TextUtils.isEmpty(str)) {
      return true;
    }
    return str.equalsIgnoreCase(mXMPCoreJarMD5) ^ true;
  }
  
  private boolean isXMPCoreJarExit()
  {
    String str = ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).getModuleFilePath("xmpcore.jar");
    QZLog.i("XMPCoreUtil", 4, new Object[] { "isXMPCoreJarExit path = ", str });
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return new File(str).exists();
  }
  
  private void loadXMPCoreModule()
  {
    QZLog.i("XMPCoreUtil", "loadXMPCoreModule");
    if (isXMPCoreJarExit())
    {
      QZLog.i("XMPCoreUtil", 4, new Object[] { "xmpCoreModulePath =", ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).getModuleFilePath("xmpcore.jar") });
      this.isModuleLoadSuccess = ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).loadModule("xmpcore.jar", getClass().getClassLoader(), false, false);
      if (this.isModuleLoadSuccess)
      {
        QZLog.i("XMPCoreUtil", "loadXMPCoreModule success");
        return;
      }
      QZLog.i("XMPCoreUtil", "loadXMPCoreModule fail");
    }
  }
  
  private HashMap<String, Object> readXMPData(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramArrayOfString != null) && (paramArrayOfString.length != 0) && (this.isModuleLoadSuccess))
    {
      paramString1 = JarReflectUtil.callSpecifiedStaticMethod("com.adobe.xmp.XmpUtil", "extractXMPMeta", false, getParamsClass(new Class[] { String.class }), new Object[] { paramString1 });
      HashMap localHashMap = new HashMap();
      if (paramString1 != null)
      {
        int j = paramArrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = paramArrayOfString[i];
          if (!TextUtils.isEmpty(str))
          {
            Object localObject = JarReflectUtil.callSpecifiedMethod(paramString1, "getProperty", false, getParamsClass(new Class[] { String.class, String.class }), new Object[] { paramString2, str });
            if (localObject != null)
            {
              localObject = JarReflectUtil.callSpecifiedMethod(localObject, "getValue", false, new Class[0], new Object[0]);
              if (localObject != null) {
                localHashMap.put(str, localObject);
              }
            }
          }
          i += 1;
        }
      }
      return localHashMap;
    }
    return null;
  }
  
  public void downloadXMPModule()
  {
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new XMPCoreUtil.2(this));
  }
  
  public Class[] getParamsClass(Class... paramVarArgs)
  {
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfClass[i] = paramVarArgs[i];
      i += 1;
    }
    return arrayOfClass;
  }
  
  public boolean isModuleLoadSuccess()
  {
    return this.isModuleLoadSuccess;
  }
  
  public boolean isPanorama(String paramString)
  {
    if (this.panoramaHashMap.get(paramString) != null) {
      return ((Boolean)this.panoramaHashMap.get(paramString)).booleanValue();
    }
    Object localObject = readXMPData(paramString, "http://ns.google.com/photos/1.0/panorama/", new String[] { "GPano:UsePanoramaViewer" });
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).get("GPano:UsePanoramaViewer");
      if ((localObject != null) && ((localObject instanceof String)))
      {
        boolean bool = ((String)localObject).equalsIgnoreCase("true");
        QZLog.i("XMPCoreUtil", 4, new Object[] { "isPanorama: ", Boolean.valueOf(bool) });
        this.panoramaHashMap.put(paramString, Boolean.valueOf(bool));
        return bool;
      }
    }
    return false;
  }
  
  public void loadXMPCoreJarModule(XMPCoreUtil.XMPCoreJarLoadListener paramXMPCoreJarLoadListener)
  {
    if (paramXMPCoreJarLoadListener == null) {
      return;
    }
    boolean bool = this.isModuleLoadSuccess;
    if (bool)
    {
      paramXMPCoreJarLoadListener.loadState(bool);
      return;
    }
    int i;
    if ((!isNeedUpdate()) && (isXMPCoreJarExit())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      loadXMPCoreModule();
      paramXMPCoreJarLoadListener.loadState(this.isModuleLoadSuccess);
      return;
    }
    ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).downloadModule("xmpcore.jar", new XMPCoreUtil.1(this, paramXMPCoreJarLoadListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.XMPCoreUtil
 * JD-Core Version:    0.7.0.1
 */