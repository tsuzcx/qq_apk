package dov.com.qq.im.ae.data;

import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observable;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs.GpuBean.DeviceModel;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.openapi.initializer.Ace3DEngineInitializer;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.GsonUtils;
import dov.com.qq.im.ae.AEPath.CAMERA.FILES;
import dov.com.qq.im.ae.config.CameraOperationHelper;
import dov.com.qq.im.ae.download.AEMaterialDownloader;
import dov.com.qq.im.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.control.CaptureAsyncControl;
import dov.com.qq.im.capture.control.QIMAsyncManager;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class AEMaterialManager
  extends QIMAsyncManager
{
  private static AEMaterialMetaData jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData;
  public static volatile boolean a;
  private static AEMaterialMetaData jdField_b_of_type_DovComQqImAeDataAEMaterialMetaData;
  public static volatile boolean b;
  private Observable jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable;
  private AEMaterialCategory jdField_a_of_type_DovComQqImAeDataAEMaterialCategory = new AEMaterialCategory(d());
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = "";
  private final List<AEMaterialCategory> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AEMaterialCategory jdField_b_of_type_DovComQqImAeDataAEMaterialCategory;
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  private final List<AEMaterialCategory> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private final Object jdField_c_of_type_JavaLangObject = new Object();
  private final List<AEMaterialCategory> jdField_c_of_type_JavaUtilList = new ArrayList();
  private volatile boolean jdField_c_of_type_Boolean = false;
  private final Object jdField_d_of_type_JavaLangObject = new Object();
  private final List<AEMaterialMetaData> jdField_d_of_type_JavaUtilList = new ArrayList();
  private final List<AEMaterialMetaData> e = new ArrayList();
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
  }
  
  public AEMaterialManager()
  {
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList = new ArrayList(100);
    this.jdField_b_of_type_DovComQqImAeDataAEMaterialCategory = new AEMaterialCategory(d());
    this.jdField_b_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList = new ArrayList(100);
  }
  
  private int a(List<AEMaterialMetaData> paramList, String paramString)
  {
    int j;
    if ((paramList == null) || (paramList.size() <= 0))
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList.size()) {
        break label61;
      }
      j = i;
      if (((AEMaterialMetaData)paramList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {
        break;
      }
      i += 1;
    }
    label61:
    return -1;
  }
  
  public static AEMaterialMetaData a()
  {
    return jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData;
  }
  
  private AEMaterialMetaData a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    Object localObject1 = null;
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator1.hasNext())
    {
      Object localObject2 = (AEMaterialCategory)localIterator1.next();
      int i;
      if (((AEMaterialCategory)localObject2).jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator2 = ((AEMaterialCategory)localObject2).jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          localObject2 = (AEMaterialMetaData)localIterator2.next();
          if (((AEMaterialMetaData)localObject2).equals(paramAEMaterialMetaData))
          {
            i = 1;
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (i != 0)
        {
          return localObject1;
          localObject2 = localObject1;
        }
        localObject1 = localObject2;
        break;
        i = 0;
      }
    }
    return localObject1;
  }
  
  private AEMaterialMetaData a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      AEMaterialMetaData localAEMaterialMetaData;
      do
      {
        Iterator localIterator1 = this.jdField_b_of_type_JavaUtilList.iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localIterator2 = ((AEMaterialCategory)localIterator1.next()).jdField_a_of_type_JavaUtilList.iterator();
        }
        localAEMaterialMetaData = (AEMaterialMetaData)localIterator2.next();
      } while (!localAEMaterialMetaData.jdField_a_of_type_JavaLangString.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "getNormalStickerMaterial---found id=" + paramString);
      }
      return localAEMaterialMetaData;
      return null;
    }
  }
  
  @Nullable
  public static String a(@Nullable ArrayList<AEMaterialOnShow> paramArrayList)
  {
    if (paramArrayList != null) {
      return GsonUtils.obj2Json(paramArrayList);
    }
    return null;
  }
  
  @Nullable
  public static ArrayList<AEMaterialOnShow> a(@Nullable String paramString)
  {
    return (ArrayList)GsonUtils.json2Obj(paramString, new AEMaterialManager.2().getType());
  }
  
  private HashMap<String, AEMaterialCategory> a(@Nullable AEMaterialCategory paramAEMaterialCategory)
  {
    Object localObject2 = new StringBuilder().append("getSpecificCategory: item.name = ");
    if (paramAEMaterialCategory == null) {}
    AEMaterialCategory localAEMaterialCategory;
    for (Object localObject1 = "null";; localObject1 = paramAEMaterialCategory.jdField_b_of_type_JavaLangString)
    {
      AEQLog.a("AEMaterialManager", (String)localObject1);
      localObject1 = new HashMap();
      localObject2 = new AEMaterialCategory();
      localAEMaterialCategory = new AEMaterialCategory();
      if ((paramAEMaterialCategory != null) && (paramAEMaterialCategory.jdField_a_of_type_JavaUtilList != null)) {
        break;
      }
      AEQLog.d("AEMaterialManager", "getSpecificCategory: item.materialList == null!");
      ((HashMap)localObject1).put("normal_material", localObject2);
      ((HashMap)localObject1).put("circle_material", localAEMaterialCategory);
      return localObject1;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramAEMaterialCategory.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)localIterator.next();
      if ("circleCamera".equals(localAEMaterialMetaData.m)) {
        localArrayList2.add(localAEMaterialMetaData);
      } else {
        localArrayList1.add(localAEMaterialMetaData);
      }
    }
    ((AEMaterialCategory)localObject2).jdField_a_of_type_JavaUtilList = localArrayList1;
    ((AEMaterialCategory)localObject2).jdField_a_of_type_Int = paramAEMaterialCategory.jdField_a_of_type_Int;
    ((AEMaterialCategory)localObject2).jdField_b_of_type_JavaLangString = paramAEMaterialCategory.jdField_b_of_type_JavaLangString;
    ((AEMaterialCategory)localObject2).jdField_a_of_type_JavaLangString = paramAEMaterialCategory.jdField_a_of_type_JavaLangString;
    ((AEMaterialCategory)localObject2).jdField_a_of_type_Boolean = paramAEMaterialCategory.jdField_a_of_type_Boolean;
    ((AEMaterialCategory)localObject2).jdField_b_of_type_Int = paramAEMaterialCategory.jdField_b_of_type_Int;
    localAEMaterialCategory.jdField_a_of_type_JavaUtilList = localArrayList2;
    localAEMaterialCategory.jdField_a_of_type_Int = paramAEMaterialCategory.jdField_a_of_type_Int;
    localAEMaterialCategory.jdField_b_of_type_JavaLangString = paramAEMaterialCategory.jdField_b_of_type_JavaLangString;
    localAEMaterialCategory.jdField_a_of_type_JavaLangString = paramAEMaterialCategory.jdField_a_of_type_JavaLangString;
    localAEMaterialCategory.jdField_a_of_type_Boolean = paramAEMaterialCategory.jdField_a_of_type_Boolean;
    localAEMaterialCategory.jdField_b_of_type_Int = paramAEMaterialCategory.jdField_b_of_type_Int;
    ((HashMap)localObject1).put("normal_material", localObject2);
    ((HashMap)localObject1).put("circle_material", localAEMaterialCategory);
    return localObject1;
  }
  
  private List<AEMaterialCategory> a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = QIMPtvTemplateManager.a(paramFile);
    if (TextUtils.isEmpty(paramFile)) {}
    do
    {
      return localArrayList;
      paramFile = AEMaterialConfigParser.a(paramFile);
    } while ((paramFile == null) || (paramFile.isEmpty()));
    return paramFile;
  }
  
  private List<AEMaterialCategory> a(File paramFile1, File paramFile2)
  {
    paramFile1 = a(paramFile1);
    List localList = a(paramFile2);
    if ((localList == null) || (localList.isEmpty())) {
      return paramFile1;
    }
    Iterator localIterator1 = paramFile1.iterator();
    Iterator localIterator2;
    if (localIterator1.hasNext())
    {
      paramFile2 = (AEMaterialCategory)localIterator1.next();
      localIterator2 = localList.iterator();
      do
      {
        if (!localIterator2.hasNext()) {
          break;
        }
        paramFile1 = (AEMaterialCategory)localIterator2.next();
      } while (!paramFile1.jdField_b_of_type_JavaLangString.equals(paramFile2.jdField_b_of_type_JavaLangString));
    }
    for (;;)
    {
      if (paramFile1 == null)
      {
        paramFile1 = paramFile2.jdField_a_of_type_JavaUtilList.iterator();
        while (paramFile1.hasNext()) {
          c((AEMaterialMetaData)paramFile1.next());
        }
        break;
      }
      localIterator2 = paramFile2.jdField_a_of_type_JavaUtilList.iterator();
      label149:
      AEMaterialMetaData localAEMaterialMetaData;
      if (localIterator2.hasNext())
      {
        localAEMaterialMetaData = (AEMaterialMetaData)localIterator2.next();
        Iterator localIterator3 = paramFile1.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!localIterator3.hasNext()) {
            break;
          }
          paramFile2 = (AEMaterialMetaData)localIterator3.next();
        } while (!localAEMaterialMetaData.jdField_a_of_type_JavaLangString.equals(paramFile2.jdField_a_of_type_JavaLangString));
      }
      for (;;)
      {
        if (paramFile2 == null)
        {
          c(localAEMaterialMetaData);
          break label149;
        }
        if (localAEMaterialMetaData.jdField_e_of_type_JavaLangString.equals(paramFile2.jdField_e_of_type_JavaLangString)) {
          break label149;
        }
        c(localAEMaterialMetaData);
        break label149;
        break;
        return localList;
        paramFile2 = null;
      }
      paramFile1 = null;
    }
  }
  
  private List<AEMaterialMetaData> a(List<AEMaterialMetaData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)paramList.next();
      if (((!localAEMaterialMetaData.jdField_a_of_type_JavaLangString.contains("_3DFaceFila")) || (Ace3DEngineInitializer.supportAceEngine())) && ((!localAEMaterialMetaData.jdField_a_of_type_JavaLangString.contains("_haircolor")) || ((DeviceUtils.hasDeviceNormal(BaseApplicationImpl.getContext())) && ((GpuScopeAttrs.getInstance().getDeviceModel() == null) || (GpuScopeAttrs.getInstance().getDeviceModel().hairColor)))))
      {
        if (i >= 10) {
          break;
        }
        localArrayList.add(localAEMaterialMetaData);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private List<AEMaterialMetaData> a(List<AEMaterialCategory> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_b_of_type_JavaLangObject;
    if (paramList != null) {}
    try
    {
      if (paramList.size() > paramInt)
      {
        paramList = (AEMaterialCategory)paramList.get(paramInt);
        if (paramList != null)
        {
          localArrayList.addAll(paramList.jdField_a_of_type_JavaUtilList);
          if ((localArrayList.size() > 0) && (((AEMaterialMetaData)localArrayList.get(0)).equals(AEMaterialMetaData.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData))) {
            localArrayList.remove(0);
          }
        }
      }
      return new ArrayList(localArrayList);
    }
    finally {}
  }
  
  private List<AEMaterialMetaData> a(List<AEMaterialCategory> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AEMaterialCategory localAEMaterialCategory = (AEMaterialCategory)paramList.next();
        if (localAEMaterialCategory.jdField_b_of_type_JavaLangString.equals(paramString))
        {
          localArrayList.addAll(localAEMaterialCategory.jdField_a_of_type_JavaUtilList);
          if ((localArrayList.size() > 0) && (((AEMaterialMetaData)localArrayList.get(0)).equals(AEMaterialMetaData.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData))) {
            localArrayList.remove(0);
          }
        }
      }
      return new ArrayList(localArrayList);
    }
  }
  
  public static boolean a()
  {
    AEMaterialMetaData localAEMaterialMetaData = a();
    return (localAEMaterialMetaData != null) && (!localAEMaterialMetaData.equals(AEMaterialMetaData.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData)) && (localAEMaterialMetaData.jdField_f_of_type_Int != 0);
  }
  
  public static boolean a(VideoMaterial paramVideoMaterial)
  {
    if ((paramVideoMaterial == null) || (paramVideoMaterial.getLightAsset() == null)) {}
    while ((!paramVideoMaterial.needHandDetect()) && (!paramVideoMaterial.needDetectGender()) && (!paramVideoMaterial.needDetectCat()) && (!paramVideoMaterial.needRGBDepth()) && (!paramVideoMaterial.needHairSegment()) && (!paramVideoMaterial.needSkySegment()) && (!paramVideoMaterial.needAce3D()) && (!paramVideoMaterial.need3DMM()) && (!paramVideoMaterial.needHeadSegment())) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public static boolean a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +15 -> 19
    //   7: aload_0
    //   8: getfield 354	dov/com/qq/im/ae/data/AEMaterialMetaData:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   11: invokestatic 232	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: istore_1
    //   15: iload_1
    //   16: ifeq +10 -> 26
    //   19: iconst_0
    //   20: istore_1
    //   21: ldc 2
    //   23: monitorexit
    //   24: iload_1
    //   25: ireturn
    //   26: aload_0
    //   27: invokestatic 356	dov/com/qq/im/ae/data/AEMaterialManager:b	(Ldov/com/qq/im/ae/data/AEMaterialMetaData;)Z
    //   30: istore_1
    //   31: goto -10 -> 21
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	paramAEMaterialMetaData	AEMaterialMetaData
    //   14	17	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   7	15	34	finally
    //   26	31	34	finally
  }
  
  public static AEMaterialMetaData b()
  {
    return jdField_b_of_type_DovComQqImAeDataAEMaterialMetaData;
  }
  
  private AEMaterialMetaData b(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      AEMaterialMetaData localAEMaterialMetaData;
      do
      {
        Iterator localIterator1 = this.jdField_c_of_type_JavaUtilList.iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localIterator2 = ((AEMaterialCategory)localIterator1.next()).jdField_a_of_type_JavaUtilList.iterator();
        }
        localAEMaterialMetaData = (AEMaterialMetaData)localIterator2.next();
      } while (!localAEMaterialMetaData.jdField_a_of_type_JavaLangString.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "getCircleStickerMaterial---found id=" + paramString);
      }
      return localAEMaterialMetaData;
      return null;
    }
  }
  
  public static String b()
  {
    File localFile = new File(AEPath.CAMERA.FILES.j);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile.getPath(), "camera_story_update_template.json").getPath();
  }
  
  private void b(AppInterface paramAppInterface, String paramString, AEMaterialMetaData paramAEMaterialMetaData, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener)
  {
    AEMaterialDownloader.a(paramAppInterface, paramAEMaterialMetaData, paramString, new AEMaterialManager.4(this, paramMaterialDownloadListener));
    paramString = new StringBuilder().append("【START】startDownloadMaterial :");
    if (paramAEMaterialMetaData == null) {}
    for (paramAppInterface = "null";; paramAppInterface = paramAEMaterialMetaData.jdField_a_of_type_JavaLangString)
    {
      AEQLog.b("AEMaterialManager", paramAppInterface);
      return;
    }
  }
  
  public static boolean b()
  {
    try
    {
      boolean bool = FeatureManager.Features.LIGHT_SDK.supportAceEngine();
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private static boolean b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    boolean bool = false;
    Object localObject = paramAEMaterialMetaData.a();
    File localFile1 = new File((String)localObject, "params.json");
    localObject = new File((String)localObject, "params.dat");
    if ((!localFile1.exists()) && (!((File)localObject).exists()))
    {
      try
      {
        File localFile2 = new File(paramAEMaterialMetaData.c());
        if (!localFile2.exists()) {
          return false;
        }
        ZipUtils.unZipFile(localFile2, paramAEMaterialMetaData.b());
        return true;
      }
      catch (Exception paramAEMaterialMetaData)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AEMaterialManager", 2, "judgeTemplateUsable unZipFile exp:", paramAEMaterialMetaData);
        }
        if (localFile1.exists()) {
          break label110;
        }
      }
      if (((File)localObject).exists()) {
        label110:
        return true;
      }
    }
    else
    {
      bool = true;
    }
    return bool;
  }
  
  public static String c()
  {
    File localFile = new File(AEPath.CAMERA.FILES.h);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getPath();
  }
  
  private List<AEMaterialCategory> c()
  {
    Object localObject2 = new File(AEPath.CAMERA.FILES.j, "camera_story_update_template.json");
    Object localObject1 = new File(AEPath.CAMERA.FILES.j, "camera_story_default_template.json");
    if (!((File)localObject2).exists())
    {
      if (!((File)localObject1).exists())
      {
        localObject1 = f();
        AEQLog.a("AEMaterialManager", "readAndParseConfigFile -> oldJson not exist, newJson not exist, use Json from assets ");
        h();
        return localObject1;
      }
      try
      {
        localObject2 = a((File)localObject1);
        AEQLog.a("AEMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, use oldJson");
        return localObject2;
      }
      catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException3)
      {
        FileUtils.e(((File)localObject1).getPath());
        localObject1 = f();
        AEQLog.d("AEMaterialManager", "readAndParseConfigFile -> oldJson exists, newJson not exist, exception:" + localAEMaterialConfigParseException3.toString());
        h();
        return localObject1;
      }
    }
    List localList2;
    List localList1;
    if (!((File)localObject1).exists()) {
      try
      {
        localList2 = a(localAEMaterialConfigParseException3);
        FileUtils.b(localAEMaterialConfigParseException3.getPath(), ((File)localObject1).getPath());
        AEQLog.a("AEMaterialManager", "readAndParseConfigFile -> oldJson not exist, use newJson ");
        return localList2;
      }
      catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException1)
      {
        FileUtils.e(localAEMaterialConfigParseException3.getPath());
        localList1 = f();
        AEQLog.d("AEMaterialManager", "readAndParseConfigFile -> oldJson not exists: exception:" + localAEMaterialConfigParseException1.toString());
        h();
        return localList1;
      }
    }
    try
    {
      localList2 = a(localAEMaterialConfigParseException1, localList1);
      FileUtils.e(localAEMaterialConfigParseException1.getPath());
      FileUtils.b(localList1.getPath(), localAEMaterialConfigParseException1.getPath());
      AEQLog.a("AEMaterialManager", "readAndParseConfigFile -> try check update ");
      return localList2;
    }
    catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException2)
    {
      localList1 = f();
      AEQLog.d("AEMaterialManager", "loadMaterialListFromAssets  -> oldJson exists: exception:" + localAEMaterialConfigParseException2.toString());
      h();
    }
    return localList1;
  }
  
  private void c(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "deleteMaterialFolder: " + paramAEMaterialMetaData.jdField_a_of_type_JavaLangString);
    }
    File localFile = new File(AEPath.CAMERA.FILES.i, paramAEMaterialMetaData.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      FileUtils.a(localFile.getPath());
    }
    paramAEMaterialMetaData = new File(AEPath.CAMERA.FILES.h, paramAEMaterialMetaData.jdField_a_of_type_JavaLangString);
    if (paramAEMaterialMetaData.exists()) {
      FileUtils.a(paramAEMaterialMetaData.getPath());
    }
  }
  
  /* Error */
  @WorkerThread
  private void c(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 479	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +29 -> 36
    //   10: ldc 137
    //   12: iconst_2
    //   13: new 139	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 481
    //   23: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: iload_1
    //   27: invokevirtual 484	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   30: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_0
    //   37: monitorenter
    //   38: aload_0
    //   39: getfield 31	dov/com/qq/im/ae/data/AEMaterialManager:jdField_c_of_type_Boolean	Z
    //   42: ifeq +18 -> 60
    //   45: iload_1
    //   46: ifne +14 -> 60
    //   49: ldc 137
    //   51: ldc_w 486
    //   54: invokestatic 395	dov/com/qq/im/ae/util/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 31	dov/com/qq/im/ae/data/AEMaterialManager:jdField_c_of_type_Boolean	Z
    //   65: aload_0
    //   66: monitorexit
    //   67: ldc 137
    //   69: new 139	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   76: ldc_w 488
    //   79: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokestatic 490	dov/com/qq/im/ae/data/AEMaterialManager:b	()Z
    //   85: invokevirtual 484	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   88: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 395	dov/com/qq/im/ae/util/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_0
    //   95: getfield 58	dov/com/qq/im/ae/data/AEMaterialManager:jdField_d_of_type_JavaLangObject	Ljava/lang/Object;
    //   98: astore 6
    //   100: aload 6
    //   102: monitorenter
    //   103: aload_0
    //   104: invokespecial 492	dov/com/qq/im/ae/data/AEMaterialManager:c	()Ljava/util/List;
    //   107: astore 7
    //   109: aload 6
    //   111: monitorexit
    //   112: aload 7
    //   114: ifnull +13 -> 127
    //   117: aload 7
    //   119: invokeinterface 243 1 0
    //   124: ifeq +27 -> 151
    //   127: ldc 137
    //   129: ldc_w 494
    //   132: invokestatic 194	dov/com/qq/im/ae/util/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: return
    //   136: astore 6
    //   138: aload_0
    //   139: monitorexit
    //   140: aload 6
    //   142: athrow
    //   143: astore 7
    //   145: aload 6
    //   147: monitorexit
    //   148: aload 7
    //   150: athrow
    //   151: aload_0
    //   152: getfield 56	dov/com/qq/im/ae/data/AEMaterialManager:jdField_c_of_type_JavaLangObject	Ljava/lang/Object;
    //   155: astore 6
    //   157: aload 6
    //   159: monitorenter
    //   160: aload_0
    //   161: getfield 36	dov/com/qq/im/ae/data/AEMaterialManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   164: invokeinterface 497 1 0
    //   169: aload_0
    //   170: getfield 38	dov/com/qq/im/ae/data/AEMaterialManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   173: invokeinterface 497 1 0
    //   178: aload_0
    //   179: getfield 43	dov/com/qq/im/ae/data/AEMaterialManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   182: invokeinterface 497 1 0
    //   187: aload_0
    //   188: getfield 36	dov/com/qq/im/ae/data/AEMaterialManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   191: aload 7
    //   193: invokeinterface 295 2 0
    //   198: pop
    //   199: aload 7
    //   201: invokeinterface 118 1 0
    //   206: astore 7
    //   208: aload 7
    //   210: invokeinterface 124 1 0
    //   215: ifeq +217 -> 432
    //   218: aload 7
    //   220: invokeinterface 128 1 0
    //   225: checkcast 71	dov/com/qq/im/ae/data/AEMaterialCategory
    //   228: astore 8
    //   230: aload 8
    //   232: ifnull -24 -> 208
    //   235: aload_0
    //   236: aload 8
    //   238: invokespecial 499	dov/com/qq/im/ae/data/AEMaterialManager:a	(Ldov/com/qq/im/ae/data/AEMaterialCategory;)Ljava/util/HashMap;
    //   241: astore 10
    //   243: aload 10
    //   245: ldc 196
    //   247: invokevirtual 502	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   250: checkcast 71	dov/com/qq/im/ae/data/AEMaterialCategory
    //   253: astore 9
    //   255: aload 10
    //   257: ldc 202
    //   259: invokevirtual 502	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   262: checkcast 71	dov/com/qq/im/ae/data/AEMaterialCategory
    //   265: astore 10
    //   267: aload 10
    //   269: ifnull +65 -> 334
    //   272: aload 10
    //   274: getfield 83	dov/com/qq/im/ae/data/AEMaterialCategory:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   277: ifnull +57 -> 334
    //   280: aload 10
    //   282: getfield 83	dov/com/qq/im/ae/data/AEMaterialCategory:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   285: invokeinterface 92 1 0
    //   290: ifle +44 -> 334
    //   293: ldc 137
    //   295: new 139	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   302: ldc_w 504
    //   305: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload 10
    //   310: invokevirtual 505	java/lang/Object:toString	()Ljava/lang/String;
    //   313: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokestatic 186	dov/com/qq/im/ae/util/AEQLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: aload_0
    //   323: getfield 43	dov/com/qq/im/ae/data/AEMaterialManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   326: aload 10
    //   328: invokeinterface 212 2 0
    //   333: pop
    //   334: aload 9
    //   336: ifnull +36 -> 372
    //   339: aload 9
    //   341: getfield 83	dov/com/qq/im/ae/data/AEMaterialCategory:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   344: ifnull +28 -> 372
    //   347: aload 9
    //   349: getfield 83	dov/com/qq/im/ae/data/AEMaterialCategory:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   352: invokeinterface 92 1 0
    //   357: ifle +15 -> 372
    //   360: aload_0
    //   361: getfield 38	dov/com/qq/im/ae/data/AEMaterialManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   364: aload 9
    //   366: invokeinterface 212 2 0
    //   371: pop
    //   372: aload 8
    //   374: getfield 83	dov/com/qq/im/ae/data/AEMaterialCategory:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   377: invokeinterface 118 1 0
    //   382: astore 8
    //   384: aload 8
    //   386: invokeinterface 124 1 0
    //   391: ifeq -183 -> 208
    //   394: aload 8
    //   396: invokeinterface 128 1 0
    //   401: checkcast 98	dov/com/qq/im/ae/data/AEMaterialMetaData
    //   404: astore 9
    //   406: aload 9
    //   408: ifnull -24 -> 384
    //   411: aload 9
    //   413: aload 9
    //   415: invokestatic 507	dov/com/qq/im/ae/data/AEMaterialManager:a	(Ldov/com/qq/im/ae/data/AEMaterialMetaData;)Z
    //   418: putfield 509	dov/com/qq/im/ae/data/AEMaterialMetaData:jdField_e_of_type_Boolean	Z
    //   421: goto -37 -> 384
    //   424: astore 7
    //   426: aload 6
    //   428: monitorexit
    //   429: aload 7
    //   431: athrow
    //   432: aload 6
    //   434: monitorexit
    //   435: aload_0
    //   436: invokespecial 511	dov/com/qq/im/ae/data/AEMaterialManager:j	()V
    //   439: aload_0
    //   440: invokespecial 514	dov/com/qq/im/ae/data/AEMaterialManager:k	()V
    //   443: aload_0
    //   444: getfield 56	dov/com/qq/im/ae/data/AEMaterialManager:jdField_c_of_type_JavaLangObject	Ljava/lang/Object;
    //   447: astore 6
    //   449: aload 6
    //   451: monitorenter
    //   452: aload_0
    //   453: getfield 38	dov/com/qq/im/ae/data/AEMaterialManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   456: invokeinterface 92 1 0
    //   461: ifle +43 -> 504
    //   464: aload_0
    //   465: invokespecial 74	dov/com/qq/im/ae/data/AEMaterialManager:d	()Ljava/lang/String;
    //   468: aload_0
    //   469: getfield 38	dov/com/qq/im/ae/data/AEMaterialManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   472: iconst_0
    //   473: invokeinterface 96 2 0
    //   478: checkcast 71	dov/com/qq/im/ae/data/AEMaterialCategory
    //   481: getfield 204	dov/com/qq/im/ae/data/AEMaterialCategory:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   484: invokevirtual 105	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   487: ifne +17 -> 504
    //   490: aload_0
    //   491: getfield 38	dov/com/qq/im/ae/data/AEMaterialManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   494: iconst_0
    //   495: aload_0
    //   496: getfield 79	dov/com/qq/im/ae/data/AEMaterialManager:jdField_a_of_type_DovComQqImAeDataAEMaterialCategory	Ldov/com/qq/im/ae/data/AEMaterialCategory;
    //   499: invokeinterface 517 3 0
    //   504: aload_0
    //   505: getfield 43	dov/com/qq/im/ae/data/AEMaterialManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   508: invokeinterface 92 1 0
    //   513: ifle +43 -> 556
    //   516: aload_0
    //   517: invokespecial 74	dov/com/qq/im/ae/data/AEMaterialManager:d	()Ljava/lang/String;
    //   520: aload_0
    //   521: getfield 43	dov/com/qq/im/ae/data/AEMaterialManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   524: iconst_0
    //   525: invokeinterface 96 2 0
    //   530: checkcast 71	dov/com/qq/im/ae/data/AEMaterialCategory
    //   533: getfield 204	dov/com/qq/im/ae/data/AEMaterialCategory:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   536: invokevirtual 105	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   539: ifne +17 -> 556
    //   542: aload_0
    //   543: getfield 43	dov/com/qq/im/ae/data/AEMaterialManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   546: iconst_0
    //   547: aload_0
    //   548: getfield 85	dov/com/qq/im/ae/data/AEMaterialManager:jdField_b_of_type_DovComQqImAeDataAEMaterialCategory	Ldov/com/qq/im/ae/data/AEMaterialCategory;
    //   551: invokeinterface 517 3 0
    //   556: aload_0
    //   557: invokespecial 519	dov/com/qq/im/ae/data/AEMaterialManager:i	()V
    //   560: aload 6
    //   562: monitorexit
    //   563: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   566: ifeq +43 -> 609
    //   569: invokestatic 479	java/lang/System:currentTimeMillis	()J
    //   572: lstore 4
    //   574: ldc 137
    //   576: iconst_2
    //   577: new 139	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   584: ldc_w 521
    //   587: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: lload 4
    //   592: lload_2
    //   593: lsub
    //   594: invokevirtual 524	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   597: ldc_w 526
    //   600: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 152	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   609: aload_0
    //   610: invokespecial 529	dov/com/qq/im/ae/data/AEMaterialManager:l	()V
    //   613: return
    //   614: astore 7
    //   616: aload 6
    //   618: monitorexit
    //   619: aload 7
    //   621: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	622	0	this	AEMaterialManager
    //   0	622	1	paramBoolean	boolean
    //   3	590	2	l1	long
    //   572	19	4	l2	long
    //   136	10	6	localObject2	Object
    //   107	11	7	localList	List
    //   143	57	7	localCollection	Collection
    //   206	13	7	localIterator	Iterator
    //   424	6	7	localObject4	Object
    //   614	6	7	localObject5	Object
    //   228	167	8	localObject6	Object
    //   253	161	9	localObject7	Object
    //   241	86	10	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   38	45	136	finally
    //   49	59	136	finally
    //   60	67	136	finally
    //   138	140	136	finally
    //   103	112	143	finally
    //   145	148	143	finally
    //   160	208	424	finally
    //   208	230	424	finally
    //   235	267	424	finally
    //   272	334	424	finally
    //   339	372	424	finally
    //   372	384	424	finally
    //   384	406	424	finally
    //   411	421	424	finally
    //   426	429	424	finally
    //   432	435	424	finally
    //   452	504	614	finally
    //   504	556	614	finally
    //   556	563	614	finally
    //   616	619	614	finally
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_DovComQqImAeDataAEMaterialCategory != null) && (this.jdField_a_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.size() >= 100);
  }
  
  private String d()
  {
    return HardCodeUtil.a(2131709794);
  }
  
  private List<AEMaterialMetaData> d()
  {
    return a(this.jdField_b_of_type_JavaUtilList, HardCodeUtil.a(2131700091));
  }
  
  private boolean d()
  {
    return (this.jdField_b_of_type_DovComQqImAeDataAEMaterialCategory != null) && (this.jdField_b_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList != null) && (this.jdField_b_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.size() >= 100);
  }
  
  private List<AEMaterialMetaData> e()
  {
    return a(this.jdField_c_of_type_JavaUtilList, 1);
  }
  
  private List<AEMaterialCategory> f()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = CameraOperationHelper.b(getApp().getApp());
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return localArrayList;
      try
      {
        localObject = AEMaterialConfigParser.a((String)localObject);
        if ((localObject != null) && (!((List)localObject).isEmpty())) {
          return localObject;
        }
      }
      catch (AEMaterialConfigParser.AEMaterialConfigParseException localAEMaterialConfigParseException)
      {
        QLog.d("AEMaterialManager", 4, "loadMaterialListFromAssets err=" + localAEMaterialConfigParseException.getMessage());
      }
    }
    return localArrayList;
  }
  
  private void h()
  {
    AECameraPrefsUtil.a().a("CameraModuleSvc.GetCompressedCategoryMaterialV2MqStoryCamera", 4);
    try
    {
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    finally {}
  }
  
  private void i()
  {
    List localList1 = d();
    List localList2 = e();
    this.jdField_d_of_type_JavaUtilList.clear();
    this.jdField_d_of_type_JavaUtilList.addAll(a(localList1));
    this.e.clear();
    this.e.addAll(a(localList2));
  }
  
  private void j()
  {
    int i = 0;
    if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialCategory == null) {}
    do
    {
      return;
      ??? = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      ??? = AECameraPrefsUtil.a().a("recent_template_list_new" + (String)???, null, 0);
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "loadRecentMaterial list=" + (String)???);
      }
    } while (??? == null);
    String[] arrayOfString = ((String)???).split("\\$");
    for (;;)
    {
      Object localObject3;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.clear();
        if (i >= arrayOfString.length) {
          break label233;
        }
        localObject3 = arrayOfString[i].split("\\|");
        if ((localObject3 == null) || (localObject3.length != 2)) {
          break label236;
        }
        localObject3 = a(localObject3[0]);
        if (localObject3 == null) {
          break label236;
        }
        if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.size() >= 100) {
          return;
        }
      }
      if ((!this.jdField_a_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.contains(localObject3)) && (!((AEMaterialMetaData)localObject3).jdField_a_of_type_JavaLangString.equals("0")))
      {
        this.jdField_a_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.add(localObject3);
        break label236;
        label233:
        return;
      }
      label236:
      i += 1;
    }
  }
  
  private void k()
  {
    int i = 0;
    if (this.jdField_b_of_type_DovComQqImAeDataAEMaterialCategory == null) {}
    do
    {
      return;
      ??? = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      ??? = AECameraPrefsUtil.a().a("recent_circle_template_list_new" + (String)???, null, 0);
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "loadCircleRecentMaterial list=" + (String)???);
      }
    } while (??? == null);
    String[] arrayOfString = ((String)???).split("\\$");
    for (;;)
    {
      Object localObject3;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.clear();
        if (i >= arrayOfString.length) {
          break label233;
        }
        localObject3 = arrayOfString[i].split("\\|");
        if ((localObject3 == null) || (localObject3.length != 2)) {
          break label236;
        }
        localObject3 = b(localObject3[0]);
        if (localObject3 == null) {
          break label236;
        }
        if (this.jdField_b_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.size() >= 100) {
          return;
        }
      }
      if ((!this.jdField_b_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.contains(localObject3)) && (!((AEMaterialMetaData)localObject3).jdField_a_of_type_JavaLangString.equals("0")))
      {
        this.jdField_b_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.add(localObject3);
        break label236;
        label233:
        return;
      }
      label236:
      i += 1;
    }
  }
  
  private void l()
  {
    if (getApp() != null) {
      getApp().notifyObservers(CaptureConfigUpdateObserver.class, 3, true, null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(116, null);
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(111, new Object[] { this.jdField_a_of_type_DovComQqImAeDataAEMaterialCategory });
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(111, new Object[] { this.jdField_b_of_type_DovComQqImAeDataAEMaterialCategory });
    }
  }
  
  public AEMaterialMetaData a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    int i;
    for (Object localObject1 = this.jdField_c_of_type_JavaUtilList;; localObject1 = this.jdField_b_of_type_JavaUtilList)
    {
      Object localObject2 = "";
      Iterator localIterator1 = ((List)localObject1).iterator();
      i = 0;
      localObject1 = localObject2;
      do
      {
        if (!localIterator1.hasNext()) {
          break label206;
        }
        localObject2 = (AEMaterialCategory)localIterator1.next();
        if ((localObject2 == null) || (((AEMaterialCategory)localObject2).jdField_a_of_type_JavaUtilList == null)) {
          break;
        }
      } while (((AEMaterialCategory)localObject2).jdField_a_of_type_Int != paramInt);
      localObject1 = ((AEMaterialCategory)localObject2).jdField_b_of_type_JavaLangString;
      Iterator localIterator2 = ((AEMaterialCategory)localObject2).jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      AEMaterialMetaData localAEMaterialMetaData;
      int j;
      do
      {
        if (!localIterator2.hasNext()) {
          break;
        }
        localAEMaterialMetaData = (AEMaterialMetaData)localIterator2.next();
        j = i + 1;
        i = j;
      } while (!localAEMaterialMetaData.jdField_a_of_type_JavaLangString.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("QIMRedDotConfig_PTV", 2, "selectPtvTemplateInfo= " + localAEMaterialMetaData);
      }
      localAEMaterialMetaData.jdField_b_of_type_JavaLangString = ((AEMaterialCategory)localObject2).jdField_b_of_type_JavaLangString;
      localAEMaterialMetaData.jdField_b_of_type_Int = j;
      return localAEMaterialMetaData;
    }
    for (;;)
    {
      break;
      label206:
      if (i != 0)
      {
        paramString = new AEMaterialMetaData();
        paramString.jdField_b_of_type_JavaLangString = ((String)localObject1);
        paramString.jdField_a_of_type_Int = paramInt;
        paramString.jdField_a_of_type_JavaLangString = "";
        return paramString;
      }
      return null;
      i = 1;
    }
  }
  
  public AEMaterialMetaData a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = this.jdField_c_of_type_JavaUtilList;; localObject = this.jdField_b_of_type_JavaUtilList)
    {
      localObject = ((List)localObject).iterator();
      AEMaterialCategory localAEMaterialCategory;
      AEMaterialMetaData localAEMaterialMetaData;
      int j;
      do
      {
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localAEMaterialCategory = (AEMaterialCategory)((Iterator)localObject).next();
          } while ((localAEMaterialCategory == null) || (localAEMaterialCategory.jdField_a_of_type_JavaUtilList == null));
          localIterator = localAEMaterialCategory.jdField_a_of_type_JavaUtilList.iterator();
          i = 0;
        }
        localAEMaterialMetaData = (AEMaterialMetaData)localIterator.next();
        j = i + 1;
        int i = j;
      } while (!localAEMaterialMetaData.jdField_a_of_type_JavaLangString.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("QIMRedDotConfig_PTV", 2, "selectPtvTemplateInfo= " + localAEMaterialMetaData);
      }
      localAEMaterialMetaData.jdField_b_of_type_JavaLangString = localAEMaterialCategory.jdField_b_of_type_JavaLangString;
      localAEMaterialMetaData.jdField_b_of_type_Int = j;
      return localAEMaterialMetaData;
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<AEMaterialCategory> a()
  {
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public List<AEMaterialCategory> a(boolean paramBoolean)
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  @WorkerThread
  @NotNull
  public List<AEMaterialMetaData> a(boolean paramBoolean1, boolean paramBoolean2)
  {
    AEQLog.b("AEMaterialManager", "loadDisplayHotList---requireServerData=" + paramBoolean1);
    if (paramBoolean1) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if (NetworkUtil.a()) {
            PeakAppInterface.a.a(1010);
          }
        }
        else {
          try
          {
            AEQLog.b("AEMaterialManager", "loadDisplayHotList---issue the request and wait");
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.wait(90000L);
            AEQLog.b("AEMaterialManager", "loadDisplayHotList---awake from waiting");
            c(false);
            if (!paramBoolean2) {
              break label140;
            }
            ??? = this.e;
            return new ArrayList((Collection)???);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
            continue;
          }
        }
      }
      AEQLog.b("AEMaterialManager", "loadDisplayHotList---no network, skip request");
      continue;
      label140:
      ??? = this.jdField_d_of_type_JavaUtilList;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(paramInt);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(paramInt, new Object[] { paramObject });
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "notifyEventId eventId=" + paramInt);
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, AEMaterialMetaData paramAEMaterialMetaData, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener)
  {
    a(paramAppInterface, AEPath.CAMERA.FILES.h, paramAEMaterialMetaData, paramMaterialDownloadListener);
  }
  
  public void a(AppInterface paramAppInterface, String paramString, AEMaterialMetaData paramAEMaterialMetaData, AEMaterialDownloader.MaterialDownloadListener paramMaterialDownloadListener)
  {
    ThreadManager.excute(new AEMaterialManager.3(this, paramAppInterface, paramString, paramAEMaterialMetaData, paramMaterialDownloadListener), 128, null, true);
  }
  
  public void a(Observer paramObserver)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(paramObserver);
      }
      return;
    }
    finally
    {
      paramObserver = finally;
      throw paramObserver;
    }
  }
  
  public void a(Observer paramObserver, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable == null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable = new Observable();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCommonObservable.a(paramObserver, new int[] { paramInt });
      return;
    }
    finally {}
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData == null) {}
    while (paramAEMaterialMetaData.c()) {
      return;
    }
    if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialCategory == null)
    {
      j();
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        i = a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList, paramAEMaterialMetaData.jdField_a_of_type_JavaLangString);
        if (i != -1) {
          break label183;
        }
        if (!c())
        {
          this.jdField_a_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.add(0, paramAEMaterialMetaData);
          m();
          if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent not full");
          }
          if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent index=" + i);
          }
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent full");
      }
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.remove(99);
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.add(0, paramAEMaterialMetaData);
      m();
      continue;
      label183:
      if (i != 0)
      {
        this.jdField_a_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.remove(i);
        this.jdField_a_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.add(0, paramAEMaterialMetaData);
        m();
      }
    }
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("setSelectedMaterialAndNotify---info=");
    String str;
    if (paramAEMaterialMetaData == null)
    {
      str = "null";
      AEQLog.b("AEMaterialManager", str + ", addToRecent=" + paramBoolean);
      jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData = paramAEMaterialMetaData;
      jdField_b_of_type_DovComQqImAeDataAEMaterialMetaData = null;
      if (paramBoolean)
      {
        if ((paramAEMaterialMetaData == null) || (!"circleCamera".equals(paramAEMaterialMetaData.m))) {
          break label95;
        }
        b(paramAEMaterialMetaData);
      }
    }
    for (;;)
    {
      a(113, null);
      return;
      str = paramAEMaterialMetaData.jdField_a_of_type_JavaLangString;
      break;
      label95:
      a(paramAEMaterialMetaData);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    c(paramBoolean);
  }
  
  public List<AEMaterialCategory> b()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public List<AEMaterialMetaData> b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (List localList = this.e;; localList = this.jdField_d_of_type_JavaUtilList) {
      return new ArrayList(localList);
    }
  }
  
  public void b()
  {
    AEQLog.b("AEMaterialManager", "onConfigRequestDone---notify all wait thread");
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
      return;
    }
  }
  
  public void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData == null) {}
    while (paramAEMaterialMetaData.c()) {
      return;
    }
    if (this.jdField_b_of_type_DovComQqImAeDataAEMaterialCategory == null)
    {
      k();
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        i = a(this.jdField_b_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList, paramAEMaterialMetaData.jdField_a_of_type_JavaLangString);
        if (i != -1) {
          break label183;
        }
        if (!d())
        {
          this.jdField_b_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.add(0, paramAEMaterialMetaData);
          n();
          if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent not full");
          }
          if (QLog.isColorLevel()) {
            QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent index=" + i);
          }
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AEMaterialManager", 2, "setCurrentTemplateInfoToRecent full");
      }
      this.jdField_b_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.remove(99);
      this.jdField_b_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.add(0, paramAEMaterialMetaData);
      n();
      continue;
      label183:
      if (i != 0)
      {
        this.jdField_b_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.remove(i);
        this.jdField_b_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.add(0, paramAEMaterialMetaData);
        n();
      }
    }
  }
  
  public void b(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("setSelectedWatermarkAndNotify---info=");
    String str;
    if (paramAEMaterialMetaData == null)
    {
      str = "null";
      AEQLog.b("AEMaterialManager", str);
      jdField_b_of_type_DovComQqImAeDataAEMaterialMetaData = paramAEMaterialMetaData;
      jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData = null;
      if (!paramBoolean) {
        break label70;
      }
    }
    label70:
    for (int i = 1024;; i = 1025)
    {
      a(i, null);
      return;
      str = paramAEMaterialMetaData.jdField_a_of_type_JavaLangString;
      break;
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      paramString = a(new File(paramString));
      if ((paramString != null) && (paramString.size() != 0)) {
        break label131;
      }
      paramString = a(f(), HardCodeUtil.a(2131689781));
    }
    catch (AEMaterialConfigParser.AEMaterialConfigParseException paramString)
    {
      ArrayList localArrayList;
      for (;;)
      {
        paramString.printStackTrace();
        return;
        paramString = a(paramString, HardCodeUtil.a(2131689782));
      }
      AECameraPrefsUtil.a().a("PhotoConst.ae_latest_material", a(localArrayList), 4);
      return;
    }
    catch (NullPointerException paramString)
    {
      label131:
      paramString.printStackTrace();
    }
    localArrayList = new ArrayList();
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)paramString.next();
      if ((localArrayList.size() < 10) && (localAEMaterialMetaData != null) && (localAEMaterialMetaData.jdField_a_of_type_JavaLangString != null) && (localAEMaterialMetaData.c != null)) {
        localArrayList.add(new AEMaterialOnShow(localAEMaterialMetaData.jdField_a_of_type_JavaLangString, localAEMaterialMetaData.c));
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    ThreadManager.excute(new AEMaterialManager.1(this, paramBoolean), 64, null, false);
  }
  
  public void c()
  {
    AEQLog.b("AEMaterialManager", "onConfigRequestCancel---notify all wait thread");
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
      return;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialCategory == null) {}
    while ((this.jdField_a_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject3 = this.jdField_a_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)((Iterator)localObject3).next();
        if ((!TextUtils.isEmpty(localAEMaterialMetaData.jdField_a_of_type_JavaLangString)) && (!localAEMaterialMetaData.equals(AEMaterialMetaData.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData)))
        {
          localStringBuilder.append(localAEMaterialMetaData.jdField_a_of_type_JavaLangString).append("|");
          localStringBuilder.append(localAEMaterialMetaData.jdField_a_of_type_Int).append("$");
        }
      }
    }
    if (TextUtils.isEmpty(localObject2.toString())) {
      return;
    }
    Object localObject3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    AECameraPrefsUtil.a().a("recent_template_list_new" + (String)localObject3, localObject2.toString(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "saveRecentTemplate list=" + localObject2.toString());
    }
  }
  
  public void e()
  {
    if ((this.jdField_b_of_type_DovComQqImAeDataAEMaterialCategory == null) || (this.jdField_b_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList == null) || (this.jdField_b_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject3 = this.jdField_b_of_type_DovComQqImAeDataAEMaterialCategory.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)((Iterator)localObject3).next();
        if ((!TextUtils.isEmpty(localAEMaterialMetaData.jdField_a_of_type_JavaLangString)) && (!localAEMaterialMetaData.equals(AEMaterialMetaData.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData)))
        {
          localStringBuilder.append(localAEMaterialMetaData.jdField_a_of_type_JavaLangString).append("|");
          localStringBuilder.append(localAEMaterialMetaData.jdField_a_of_type_Int).append("$");
        }
      }
    }
    if (TextUtils.isEmpty(localObject2.toString())) {
      return;
    }
    Object localObject3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    AECameraPrefsUtil.a().a("recent_circle_template_list_new" + (String)localObject3, localObject2.toString(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialManager", 2, "saveRecentTemplate list=" + localObject2.toString());
    }
  }
  
  public void f()
  {
    jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData = null;
  }
  
  @Deprecated
  public void forceInit() {}
  
  public void g()
  {
    jdField_b_of_type_DovComQqImAeDataAEMaterialMetaData = null;
  }
  
  @Deprecated
  public void initIndeed() {}
  
  @Deprecated
  public void onInit() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.data.AEMaterialManager
 * JD-Core Version:    0.7.0.1
 */