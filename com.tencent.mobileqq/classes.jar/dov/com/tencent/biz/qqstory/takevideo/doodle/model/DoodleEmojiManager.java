package dov.com.tencent.biz.qqstory.takevideo.doodle.model;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import anhg;
import anhh;
import anhi;
import anhj;
import anhk;
import anhl;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.IManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.LbsUpdateListener;
import com.tencent.biz.qqstory.network.request.GetPoiFacesRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.paster.QIMPasterConfigManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(9)
public class DoodleEmojiManager
  implements IManager
{
  public static final String a;
  private float jdField_a_of_type_Float;
  public final int a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  LbsManager.LbsUpdateListener jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$LbsUpdateListener = new anhj(this);
  public DoodleEmojiItem a;
  public DoodleEmojiManager.POIPostersRequestCallback a;
  public final Object a;
  public final List a;
  public final Queue a;
  public final ConcurrentHashMap a;
  public volatile AtomicInteger a;
  public String b;
  protected List b;
  
  static
  {
    jdField_a_of_type_JavaLangString = QQStoryConstant.h + "emoji";
    a(jdField_a_of_type_JavaLangString);
  }
  
  public DoodleEmojiManager()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaLangObject = new Object[0];
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 50;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiManager$POIPostersRequestCallback = null;
    BaseApplicationImpl localBaseApplicationImpl = QQStoryContext.a().a();
    if (localBaseApplicationImpl == null) {
      throw new IllegalArgumentException("Context should not be null");
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences = localBaseApplicationImpl.getSharedPreferences("qqstory_emoji", 0);
  }
  
  public static String a(DoodleEmojiManager paramDoodleEmojiManager, String paramString)
  {
    return paramDoodleEmojiManager.a("emoji_pack_url_" + paramString, "");
  }
  
  private static String a(@NonNull File paramFile)
  {
    return paramFile.getName().substring("emoji_folder_".length());
  }
  
  public static String a(@NonNull String paramString)
  {
    return jdField_a_of_type_JavaLangString + File.separator + "emoji_zip_" + paramString;
  }
  
  public static void a(DoodleEmojiManager paramDoodleEmojiManager, String paramString1, String paramString2)
  {
    paramDoodleEmojiManager.a("emoji_pack_md5_" + paramString1, paramString2);
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString);
    boolean bool;
    if (paramString.isFile())
    {
      bool = paramString.delete();
      SLog.d("DoodleEmojiManager", "delete file : " + bool);
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      SLog.d("DoodleEmojiManager", "create folder : " + bool);
    }
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2;
  }
  
  private static boolean a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {}
    do
    {
      return false;
      paramFile = paramFile.listFiles(new anhl());
    } while ((paramFile == null) || (paramFile.length <= 0));
    return true;
  }
  
  public static String b(DoodleEmojiManager paramDoodleEmojiManager, String paramString)
  {
    return paramDoodleEmojiManager.a("emoji_pack_name_" + paramString, "");
  }
  
  public static String b(@NonNull String paramString)
  {
    return jdField_a_of_type_JavaLangString + File.separator + "emoji_folder_" + paramString;
  }
  
  private static void b(DoodleEmojiManager paramDoodleEmojiManager, String paramString1, String paramString2)
  {
    paramDoodleEmojiManager.a("emoji_pack_url_" + paramString1, paramString2);
  }
  
  public static String c(DoodleEmojiManager paramDoodleEmojiManager, String paramString)
  {
    return paramDoodleEmojiManager.a("emoji_pack_config_" + paramString, "");
  }
  
  private static void c(DoodleEmojiManager paramDoodleEmojiManager, String paramString1, String paramString2)
  {
    paramDoodleEmojiManager.a("emoji_pack_name_" + paramString1, paramString2);
  }
  
  public static String d(DoodleEmojiManager paramDoodleEmojiManager, String paramString)
  {
    return paramDoodleEmojiManager.a("emoji_pack_md5_" + paramString, "");
  }
  
  private static void d(DoodleEmojiManager paramDoodleEmojiManager, String paramString1, String paramString2)
  {
    paramDoodleEmojiManager.a("emoji_pack_config_" + paramString1, paramString2);
  }
  
  public float a()
  {
    Object localObject1 = new ArrayList(this.jdField_b_of_type_JavaUtilList);
    Object localObject2 = ((List)localObject1).iterator();
    long l = System.currentTimeMillis();
    while (((Iterator)localObject2).hasNext()) {
      if (l - ((Location)((Iterator)localObject2).next()).getTime() > 60000L) {
        ((Iterator)localObject2).remove();
      }
    }
    if (((List)localObject1).size() > 1)
    {
      localObject2 = new Location((Location)((List)localObject1).get(0));
      localObject1 = new Location((Location)((List)localObject1).get(((List)localObject1).size() - 1));
      this.jdField_a_of_type_Float = Math.abs(((Location)localObject1).distanceTo((Location)localObject2) / (float)((((Location)localObject1).getTime() - ((Location)localObject2).getTime()) / 1000L));
      SLog.a("DoodleEmojiManager", "meter speed:%s .", Float.valueOf(this.jdField_a_of_type_Float));
    }
    for (;;)
    {
      return this.jdField_a_of_type_Float;
      SLog.d("DoodleEmojiManager", "location list size < 2, size:%s .", new Object[] { Integer.valueOf(((List)localObject1).size()) });
    }
  }
  
  public String a(@NonNull String paramString1, @NonNull String paramString2)
  {
    paramString2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString1, paramString2);
    SLog.b("DoodleEmojiManager", "getStringValue, key : %s, value : %s", paramString1, paramString2);
    return paramString2;
  }
  
  public List a()
  {
    if (!a())
    {
      SLog.b("DoodleEmojiManager", "getCurrentEmojiPackList but not init yet");
      return Collections.EMPTY_LIST;
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, DoodleEmojiManager.POIPostersRequestCallback paramPOIPostersRequestCallback)
  {
    paramPOIPostersRequestCallback = new WeakReference(paramPOIPostersRequestCallback);
    CmdTaskManger.a().a(new GetPoiFacesRequest(paramInt1, paramInt2), new anhk(this, paramPOIPostersRequestCallback));
  }
  
  public void a(Context paramContext)
  {
    SLog.b("DoodleEmojiManager", "initLocalPackages, doodle emoji path : " + jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1))
    {
      paramContext = (DoodleEmojiManager)SuperManager.a(36);
      Object localObject1 = new File(jdField_a_of_type_JavaLangString);
      if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
      {
        localObject1 = ((File)localObject1).listFiles(new anhg(this));
        if (localObject1 != null)
        {
          int j = localObject1.length;
          int i = 0;
          if (i < j)
          {
            File localFile = localObject1[i];
            Object localObject2 = localFile.listFiles(new anhh(this));
            if ((localObject2 != null) && (localObject2.length > 0))
            {
              localObject2 = a(localFile);
              Object localObject3 = b(paramContext, (String)localObject2);
              localObject3 = new DoodleEmojiItem((String)localObject2, a(paramContext, (String)localObject2), (String)localObject3, null, c(paramContext, (String)localObject2), d(paramContext, (String)localObject2));
              ((DoodleEmojiItem)localObject3).setLocalEmojiFolderPath(localFile.getPath());
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject2, localObject3);
              SLog.b("DoodleEmojiManager", "load local emoji pack : " + localObject3);
            }
            for (;;)
            {
              i += 1;
              break;
              try
              {
                FileUtils.d(localFile.getPath());
                SLog.d("DoodleEmojiManager", "find empty local emoji folder : " + localFile.getName() + ", delete it");
              }
              catch (Exception localException)
              {
                SLog.d("DoodleEmojiManager", "find empty local emoji folder : " + localFile.getName() + ", delete failed : " + localException);
              }
            }
          }
        }
      }
      else
      {
        SLog.d("DoodleEmojiManager", "local emoji folder is empty");
      }
      a(((QIMPasterConfigManager)QIMManager.a(1)).a());
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    }
  }
  
  public void a(BasicLocation paramBasicLocation, DoodleEmojiManager.POIPostersRequestCallback paramPOIPostersRequestCallback)
  {
    SLog.b("DoodleEmojiManager", "requestPoiFaces " + paramPOIPostersRequestCallback);
    LbsManager localLbsManager = (LbsManager)SuperManager.a(9);
    BasicLocation localBasicLocation = paramBasicLocation;
    if (paramBasicLocation == null) {
      localBasicLocation = localLbsManager.b();
    }
    if (localBasicLocation != null)
    {
      a(localBasicLocation.b, localBasicLocation.jdField_a_of_type_Int, paramPOIPostersRequestCallback);
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiManager$POIPostersRequestCallback = paramPOIPostersRequestCallback;
    localLbsManager.a(this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$LbsUpdateListener);
    localLbsManager.c();
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    SLog.b("DoodleEmojiManager", "saveStringValue, key : %s, value : %s", paramString1, paramString2);
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(paramString1, paramString2).apply();
  }
  
  public void a(List arg1)
  {
    if (??? == null) {
      return;
    }
    DoodleEmojiManager localDoodleEmojiManager = (DoodleEmojiManager)SuperManager.a(36);
    ArrayList localArrayList = new ArrayList(???.size());
    Iterator localIterator = ???.iterator();
    DoodleEmojiItem localDoodleEmojiItem1;
    if (localIterator.hasNext())
    {
      localDoodleEmojiItem1 = (DoodleEmojiItem)localIterator.next();
      if (localDoodleEmojiItem1.type != 1) {
        break label428;
      }
      DoodleEmojiItem localDoodleEmojiItem2 = (DoodleEmojiItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localDoodleEmojiItem1.pack_id);
      if (localDoodleEmojiItem2 == null) {
        break label428;
      }
      ??? = localDoodleEmojiItem2.getLocalEmojiFolderPath();
      if (TextUtils.equals(localDoodleEmojiItem2.md5, localDoodleEmojiItem1.md5)) {
        break label425;
      }
      SLog.a("DoodleEmojiManager", "EmojiPack md5 has changed. old : %s, new : %s", localDoodleEmojiItem2.md5, localDoodleEmojiItem1.md5);
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          FileUtils.d(???);
          ??? = null;
          localDoodleEmojiItem1.setLocalEmojiFolderPath(???);
          b(localDoodleEmojiManager, localDoodleEmojiItem1.pack_id, localDoodleEmojiItem1.icon);
          c(localDoodleEmojiManager, localDoodleEmojiItem1.pack_id, localDoodleEmojiItem1.name);
          d(localDoodleEmojiManager, localDoodleEmojiItem1.pack_id, localDoodleEmojiItem1.config);
          a(localDoodleEmojiManager, localDoodleEmojiItem1.pack_id, localDoodleEmojiItem1.md5);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localDoodleEmojiItem1.pack_id, localDoodleEmojiItem1);
          SLog.a("DoodleEmojiManager", "from network get doodle item : %s", localDoodleEmojiItem1);
          localArrayList.remove(localDoodleEmojiItem1);
          localArrayList.add(localDoodleEmojiItem1);
        }
        catch (Exception localException)
        {
          SLog.d("DoodleEmojiManager", "remove folder : %s failed. error: %s .", new Object[] { ???, localException });
          continue;
        }
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
          if (QLog.isColorLevel()) {
            QLog.i("DoodleEmojiManager", 2, "paster config processResponse " + this.jdField_a_of_type_JavaUtilList.size());
          }
          Dispatchers.get().dispatch(new DoodleEmojiManager.DoodleEmojiUpdateEvent());
          if (localArrayList.size() <= 0) {
            break;
          }
          SLog.b("DoodleEmojiManager", "start download the first emoji pack if needed : " + ((DoodleEmojiItem)localArrayList.get(0)).pack_id);
          a(((DoodleEmojiItem)localArrayList.get(0)).pack_id, false);
          return;
        }
      }
      label425:
      continue;
      label428:
      ??? = null;
    }
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (!a()) {
      SLog.d("DoodleEmojiManager", "downloadEmojiPack init state = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) });
    }
    if (paramString == null) {
      throw new IllegalArgumentException("pack id should not be null");
    }
    DoodleEmojiItem localDoodleEmojiItem = (DoodleEmojiItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localDoodleEmojiItem == null)
    {
      SLog.d("DoodleEmojiManager", "can not find pack item by id " + paramString);
      return false;
    }
    ??? = new File(b(localDoodleEmojiItem.pack_id));
    if ((a((File)???)) && (!paramBoolean))
    {
      SLog.d("DoodleEmojiManager", "already has local emoji folder, notify download success directly");
      localDoodleEmojiItem.setLocalEmojiFolderPath(((File)???).getPath());
      Dispatchers.get().dispatch(new DoodleEmojiManager.DoodleEmojiDownloadEvent(localDoodleEmojiItem, 0, true, 0L, 0L));
      return true;
    }
    if (!TextUtils.isEmpty(localDoodleEmojiItem.getLocalEmojiFolderPath()))
    {
      SLog.d("DoodleEmojiManager", "local emoji folder is missing");
      localDoodleEmojiItem.setLocalEmojiFolderPath(null);
    }
    if (TextUtils.isEmpty(localDoodleEmojiItem.download_url))
    {
      SLog.d("DoodleEmojiManager", "can not start download because of empty download-url is found");
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilQueue.contains(localDoodleEmojiItem))
      {
        this.jdField_a_of_type_JavaUtilQueue.offer(localDoodleEmojiItem);
        SLog.b("DoodleEmojiManager", "downloadEmojiPack pack " + paramString + " enqueue");
        c();
        return true;
      }
      SLog.b("DoodleEmojiManager", "downloadEmojiPack pack " + paramString + " is already in pending list");
    }
  }
  
  public void b()
  {
    LbsManager localLbsManager = (LbsManager)SuperManager.a(9);
    if ((localLbsManager != null) && (this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$LbsUpdateListener != null)) {
      localLbsManager.b(this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$LbsUpdateListener);
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiManager$POIPostersRequestCallback = null;
  }
  
  public void c()
  {
    SLog.b("DoodleEmojiManager", "startDownload");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem == null)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem = ((DoodleEmojiItem)this.jdField_a_of_type_JavaUtilQueue.poll());
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem != null)
        {
          SLog.b("DoodleEmojiManager", "downloader startDownload : " + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem);
          Bosses.get().postJob(new anhi(this, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem));
        }
        return;
      }
      SLog.b("DoodleEmojiManager", "can not start download because find one is still downloading : " + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager
 * JD-Core Version:    0.7.0.1
 */