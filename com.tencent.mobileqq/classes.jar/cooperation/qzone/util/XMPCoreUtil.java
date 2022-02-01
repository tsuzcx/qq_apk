package cooperation.qzone.util;

import android.text.TextUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
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
  private static XMPCoreUtil instance;
  private static String mXMPCoreJarMD5 = QzoneConfig.getInstance().getConfig("QZoneSetting", "XMPcoreJarMD5", "a0c5ac44fc2d0e35187f0c1479db48b2");
  private static String mXMPCoreJarUrl = QzoneConfig.getInstance().getConfig("QZoneSetting", "xmpcoreUrl", "https://d3g.qq.com/sngapp/app/update/20171220130606_8640/xmpcore.jar");
  private boolean isModuleLoadSuccess;
  private ConcurrentHashMap<String, Boolean> panoramaHashMap = new ConcurrentHashMap();
  
  public static XMPCoreUtil getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new XMPCoreUtil();
      }
      return instance;
    }
    finally {}
  }
  
  private boolean isNeedUpdate()
  {
    String str = LocalMultiProcConfig.getString("xmp_core_file_md5", null);
    if (TextUtils.isEmpty(str)) {}
    while (!str.equalsIgnoreCase(mXMPCoreJarMD5)) {
      return true;
    }
    return false;
  }
  
  private boolean isXMPCoreJarExit()
  {
    String str = QzoneModuleManager.getInstance().getModuleFilePath("xmpcore.jar");
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
      QZLog.i("XMPCoreUtil", 4, new Object[] { "xmpCoreModulePath =", QzoneModuleManager.getInstance().getModuleFilePath("xmpcore.jar") });
      this.isModuleLoadSuccess = QzoneModuleManager.getInstance().loadModule("xmpcore.jar", getClass().getClassLoader(), false, false);
      if (this.isModuleLoadSuccess) {
        QZLog.i("XMPCoreUtil", "loadXMPCoreModule success");
      }
    }
    else
    {
      return;
    }
    QZLog.i("XMPCoreUtil", "loadXMPCoreModule fail");
  }
  
  private HashMap<String, Object> readXMPData(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramArrayOfString == null) || (paramArrayOfString.length == 0) || (!this.isModuleLoadSuccess)) {
      paramString1 = null;
    }
    Object localObject1;
    HashMap localHashMap;
    int j;
    int i;
    do
    {
      do
      {
        return paramString1;
        localObject1 = JarReflectUtil.callSpecifiedStaticMethod("com.adobe.xmp.XmpUtil", "extractXMPMeta", false, getParamsClass(new Class[] { String.class }), new Object[] { paramString1 });
        localHashMap = new HashMap();
        paramString1 = localHashMap;
      } while (localObject1 == null);
      j = paramArrayOfString.length;
      i = 0;
      paramString1 = localHashMap;
    } while (i >= j);
    paramString1 = paramArrayOfString[i];
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      i += 1;
      break;
      Object localObject2 = JarReflectUtil.callSpecifiedMethod(localObject1, "getProperty", false, getParamsClass(new Class[] { String.class, String.class }), new Object[] { paramString2, paramString1 });
      if (localObject2 != null)
      {
        localObject2 = JarReflectUtil.callSpecifiedMethod(localObject2, "getValue", false, new Class[0], new Object[0]);
        if (localObject2 != null) {
          localHashMap.put(paramString1, localObject2);
        }
      }
    }
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
    if (this.isModuleLoadSuccess)
    {
      paramXMPCoreJarLoadListener.loadState(this.isModuleLoadSuccess);
      return;
    }
    if ((isNeedUpdate()) || (!isXMPCoreJarExit())) {}
    for (int i = 1; i == 0; i = 0)
    {
      loadXMPCoreModule();
      paramXMPCoreJarLoadListener.loadState(this.isModuleLoadSuccess);
      return;
    }
    QzoneModuleManager.getInstance().downloadModule("xmpcore.jar", new XMPCoreUtil.1(this, paramXMPCoreJarLoadListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.XMPCoreUtil
 * JD-Core Version:    0.7.0.1
 */