package dov.com.qq.im.capture.music;

import amvq;
import amvr;
import amvs;
import amvt;
import amvv;
import amvw;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.IQIMManager;
import dov.com.qq.im.capture.data.DoodleMusicCategoryItem;
import dov.com.qq.im.capture.music.humrecognition.recognize.RecognitionManager;
import dov.com.qq.im.capture.util.QIMFileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QIMMusicConfigManager
  extends IQIMManager
{
  public static final File a;
  public static AtomicBoolean b;
  private int jdField_a_of_type_Int = 3;
  protected BroadcastReceiver a;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  private DoodleMusicCategoryItem jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  public AtomicBoolean a;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString = "我的";
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private int c = 0;
  private int d = 0;
  private int e;
  
  static
  {
    jdField_a_of_type_JavaIoFile = new File(QIMFileUtils.a(), "dov_doodle_music");
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public QIMMusicConfigManager()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_e_of_type_Int = 2;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new amvs(this);
  }
  
  private int a(MusicItemInfo paramMusicItemInfo)
  {
    int j;
    if (this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory is null");
      }
      j = -1;
      return j;
    }
    if (this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory.templateGroups is null");
      }
      return -1;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.size()) {
        break label156;
      }
      MusicItemInfo localMusicItemInfo = (MusicItemInfo)this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.get(i);
      j = i;
      if (localMusicItemInfo.jdField_a_of_type_Int == paramMusicItemInfo.jdField_a_of_type_Int) {
        break;
      }
      if ((paramMusicItemInfo.jdField_a_of_type_Float != -1.0F) && (!TextUtils.isEmpty(paramMusicItemInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localMusicItemInfo.jdField_a_of_type_JavaLangString)))
      {
        j = i;
        if (paramMusicItemInfo.jdField_a_of_type_JavaLangString.equals(localMusicItemInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
      }
      i += 1;
    }
    label156:
    return -1;
  }
  
  private FlowMusic a(int paramInt)
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findFlowMusicFromUserList mUserMusicList is null");
      }
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label74;
      }
      FlowMusic localFlowMusic = (FlowMusic)this.jdField_a_of_type_JavaUtilList.get(i);
      localObject = localFlowMusic;
      if (localFlowMusic.songId == paramInt) {
        break;
      }
      i += 1;
    }
    label74:
    return null;
  }
  
  private DoodleMusicCategoryItem a(MusicItemInfo paramMusicItemInfo1, MusicItemInfo paramMusicItemInfo2, MusicItemInfo paramMusicItemInfo3)
  {
    this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem = new DoodleMusicCategoryItem();
    this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_Int = 999;
    this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    MusicItemInfo localMusicItemInfo = new MusicItemInfo();
    localMusicItemInfo.d = 4;
    localMusicItemInfo.jdField_a_of_type_Int = -3;
    this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.add(paramMusicItemInfo1);
    this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.add(paramMusicItemInfo2);
    if (RecognitionManager.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = 4;
      paramMusicItemInfo1 = new MusicItemInfo();
      paramMusicItemInfo1.d = 6;
      paramMusicItemInfo1.jdField_a_of_type_Int = -4;
      this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.add(paramMusicItemInfo1);
      if (this.jdField_a_of_type_Boolean)
      {
        paramMusicItemInfo1 = new MusicItemInfo();
        paramMusicItemInfo1.d = 8;
        paramMusicItemInfo1.jdField_a_of_type_Int = -6;
        this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.add(paramMusicItemInfo1);
      }
    }
    this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.add(localMusicItemInfo);
    if (this.d == 1) {
      this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.add(paramMusicItemInfo3);
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramMusicItemInfo1 = (FlowMusic)this.jdField_a_of_type_JavaUtilList.get(i);
      paramMusicItemInfo2 = new MusicItemInfo();
      paramMusicItemInfo2.d = 5;
      paramMusicItemInfo2.jdField_a_of_type_JavaLangString = paramMusicItemInfo1.songName;
      paramMusicItemInfo2.a(paramMusicItemInfo1.path);
      paramMusicItemInfo2.c = paramMusicItemInfo1.url;
      paramMusicItemInfo2.jdField_b_of_type_JavaLangString = paramMusicItemInfo1.singerName;
      paramMusicItemInfo2.jdField_a_of_type_Int = paramMusicItemInfo1.songId;
      paramMusicItemInfo2.jdField_e_of_type_JavaLangString = paramMusicItemInfo1.songMid;
      paramMusicItemInfo2.jdField_e_of_type_Int = paramMusicItemInfo1.tryBegin;
      paramMusicItemInfo2.f = paramMusicItemInfo1.tryEnd;
      paramMusicItemInfo2.g = paramMusicItemInfo1.duration;
      this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.add(paramMusicItemInfo2);
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigManager", 2, "buildMyTab size:" + this.jdField_a_of_type_JavaUtilList.size());
    }
    return this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem;
  }
  
  private void a(FlowMusic paramFlowMusic, long paramLong)
  {
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    for (;;)
    {
      try
      {
        localEntityTransaction.a();
        paramFlowMusic.storeTimeStamp = paramLong;
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label298;
        }
        FlowMusic localFlowMusic = (FlowMusic)((Iterator)localObject).next();
        if (localFlowMusic.songId != paramFlowMusic.songId) {
          continue;
        }
        localObject = localFlowMusic;
        if (localFlowMusic != paramFlowMusic)
        {
          localFlowMusic.copyFrom(paramFlowMusic);
          localObject = localFlowMusic;
        }
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject);
          return;
        }
        if (this.jdField_a_of_type_JavaUtilList.size() < 40)
        {
          this.jdField_a_of_type_JavaUtilList.add(0, paramFlowMusic);
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramFlowMusic);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QIMMusicConfigManager", 2, "insert music=" + paramFlowMusic);
          continue;
        }
        i = this.jdField_a_of_type_JavaUtilList.size();
      }
      finally
      {
        Collections.sort(this.jdField_a_of_type_JavaUtilList);
        localEntityTransaction.c();
        localEntityTransaction.b();
      }
      int i;
      Object localObject = (FlowMusic)this.jdField_a_of_type_JavaUtilList.remove(i - 1);
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(FlowMusic.class.getSimpleName(), "songName=? and tryBegin=? and tryEnd=?", new String[] { ((FlowMusic)localObject).songName, String.valueOf(((FlowMusic)localObject).tryBegin), String.valueOf(((FlowMusic)localObject).tryEnd) });
      this.jdField_a_of_type_JavaUtilList.add(0, paramFlowMusic);
      continue;
      label298:
      localObject = null;
    }
  }
  
  public static boolean a()
  {
    boolean bool1 = new File(jdField_a_of_type_JavaIoFile + File.separator + "doodle_music_config.cfg").exists();
    boolean bool2 = new File(jdField_a_of_type_JavaIoFile, "temp_music_zip").exists();
    if (QLog.isColorLevel()) {
      QLog.i("QIMMusicConfigManager", 2, "isStickerConfigFileExist" + bool1 + " " + bool2);
    }
    return bool1;
  }
  
  static boolean a(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.sApplication).getBoolean("fecth_from_qq_music_" + paramString, false);
  }
  
  public static void b(String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.sApplication).edit();
    localEditor.putBoolean("fecth_from_qq_music_" + paramString, true);
    localEditor.apply();
  }
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public MusicItemInfo a(int paramInt)
  {
    Object localObject;
    if (this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory is null");
      }
      localObject = null;
      return localObject;
    }
    if (this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory.templateGroups is null");
      }
      return null;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.size()) {
        break label106;
      }
      MusicItemInfo localMusicItemInfo = (MusicItemInfo)this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.get(i);
      localObject = localMusicItemInfo;
      if (localMusicItemInfo.jdField_a_of_type_Int == paramInt) {
        break;
      }
      i += 1;
    }
    label106:
    return null;
  }
  
  /* Error */
  public MusicItemInfo a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 353	dov/com/qq/im/capture/music/QIMMusicConfigManager:a	()Ljava/util/ArrayList;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +63 -> 71
    //   11: aload_3
    //   12: invokevirtual 354	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   15: astore_3
    //   16: aload_3
    //   17: invokeinterface 243 1 0
    //   22: ifeq +49 -> 71
    //   25: aload_3
    //   26: invokeinterface 247 1 0
    //   31: checkcast 105	dov/com/qq/im/capture/data/DoodleMusicCategoryItem
    //   34: astore 4
    //   36: iload_1
    //   37: iconst_m1
    //   38: if_icmpne +14 -> 52
    //   41: aload 4
    //   43: iload_2
    //   44: invokevirtual 356	dov/com/qq/im/capture/data/DoodleMusicCategoryItem:a	(I)Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;
    //   47: astore_3
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_3
    //   51: areturn
    //   52: aload 4
    //   54: getfield 155	dov/com/qq/im/capture/data/DoodleMusicCategoryItem:jdField_a_of_type_Int	I
    //   57: iload_1
    //   58: if_icmpne -42 -> 16
    //   61: aload 4
    //   63: iload_2
    //   64: invokevirtual 356	dov/com/qq/im/capture/data/DoodleMusicCategoryItem:a	(I)Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;
    //   67: astore_3
    //   68: goto -20 -> 48
    //   71: aconst_null
    //   72: astore_3
    //   73: goto -25 -> 48
    //   76: astore_3
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_3
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	QIMMusicConfigManager
    //   0	81	1	paramInt1	int
    //   0	81	2	paramInt2	int
    //   6	67	3	localObject1	Object
    //   76	4	3	localObject2	Object
    //   34	28	4	localDoodleMusicCategoryItem	DoodleMusicCategoryItem
    // Exception table:
    //   from	to	target	type
    //   2	7	76	finally
    //   11	16	76	finally
    //   16	36	76	finally
    //   41	48	76	finally
    //   52	68	76	finally
  }
  
  /* Error */
  public ArrayList a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 76	dov/com/qq/im/capture/music/QIMMusicConfigManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: iconst_1
    //   7: iconst_1
    //   8: invokevirtual 360	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   11: istore_1
    //   12: iload_1
    //   13: ifeq +9 -> 22
    //   16: aconst_null
    //   17: astore_2
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_2
    //   21: areturn
    //   22: aload_0
    //   23: iconst_0
    //   24: invokevirtual 363	dov/com/qq/im/capture/music/QIMMusicConfigManager:a	(Z)Ljava/util/ArrayList;
    //   27: astore_2
    //   28: goto -10 -> 18
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	QIMMusicConfigManager
    //   11	2	1	bool	boolean
    //   17	11	2	localArrayList	ArrayList
    //   31	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	31	finally
    //   22	28	31	finally
  }
  
  public ArrayList a(String paramString)
  {
    ArrayList localArrayList = new ArrayList(4);
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("showMine")) {
        this.jdField_b_of_type_Int = paramString.getInt("showMine");
      }
      if (paramString.has("showWsTab")) {
        this.c = paramString.getInt("showWsTab");
      }
      if (paramString.has("showMusicWs")) {
        this.d = paramString.getInt("showMusicWs");
      }
      if (paramString.has("mineIndex")) {
        this.jdField_e_of_type_Int = paramString.getInt("mineIndex");
      }
      if (paramString.has("mineCategoryName")) {
        this.jdField_b_of_type_JavaLangString = paramString.getString("mineCategoryName");
      }
      JSONArray localJSONArray = paramString.getJSONArray("category");
      localArrayList.ensureCapacity(localJSONArray.length());
      int i = 0;
      for (;;)
      {
        paramString = localArrayList;
        if (i >= localJSONArray.length()) {
          break;
        }
        localArrayList.add(new DoodleMusicCategoryItem(localJSONArray.getJSONObject(i)));
        i += 1;
      }
      return paramString;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QIMMusicConfigManager", 2, QLog.getStackTraceString(paramString));
      }
      paramString = null;
    }
  }
  
  public ArrayList a(boolean paramBoolean)
  {
    int j = 0;
    for (;;)
    {
      MusicItemInfo localMusicItemInfo2;
      MusicItemInfo localMusicItemInfo3;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMMusicConfigManager", 2, "random tab getDoodleMusicList " + paramBoolean);
        }
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          if (this.jdField_a_of_type_JavaUtilArrayList == null)
          {
            localObject3 = QIMFileUtils.a(jdField_a_of_type_JavaIoFile, "doodle_music_config.cfg");
            if (localObject3 != null)
            {
              this.jdField_a_of_type_JavaUtilArrayList = a((String)localObject3);
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder().append("initStickerConfigFromCache").append((String)localObject3).append(" result:");
                if (this.jdField_a_of_type_JavaUtilArrayList == null) {
                  break label634;
                }
                bool = true;
                QLog.i("QIMMusicConfigManager", 2, bool);
              }
            }
            if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
            {
              localObject3 = QIMFileUtils.a("doodle_music.cfg");
              this.jdField_a_of_type_JavaUtilArrayList = a((String)localObject3);
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder().append("initStickerConfigFromAssets").append((String)localObject3).append(" result:");
                if (this.jdField_a_of_type_JavaUtilArrayList == null) {
                  break label640;
                }
                bool = true;
                QLog.i("QIMMusicConfigManager", 2, bool);
              }
            }
          }
          if ((this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem == null) || (this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList.size() == this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_Int)) {
            break label736;
          }
          i = 1;
          if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (!paramBoolean) && (i == 0)) {
            break label714;
          }
          if (this.jdField_a_of_type_JavaUtilArrayList != null) {
            break label646;
          }
          i = j;
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(i);
          Object localObject3 = new MusicItemInfo();
          ((MusicItemInfo)localObject3).d = 2;
          ((MusicItemInfo)localObject3).jdField_a_of_type_Int = -1;
          localMusicItemInfo2 = new MusicItemInfo();
          localMusicItemInfo2.d = 3;
          localMusicItemInfo2.jdField_a_of_type_Int = -2;
          localMusicItemInfo3 = new MusicItemInfo();
          localMusicItemInfo3.d = 10;
          localMusicItemInfo3.jdField_a_of_type_Int = -7;
          MusicItemInfo localMusicItemInfo4 = new MusicItemInfo();
          localMusicItemInfo4.d = 6;
          localMusicItemInfo4.jdField_a_of_type_Int = -4;
          MusicItemInfo localMusicItemInfo5 = new MusicItemInfo();
          localMusicItemInfo5.d = 8;
          localMusicItemInfo5.jdField_a_of_type_Int = -6;
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            break label657;
          }
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!localIterator.hasNext()) {
            break label657;
          }
          DoodleMusicCategoryItem localDoodleMusicCategoryItem1 = (DoodleMusicCategoryItem)localIterator.next();
          if ((localDoodleMusicCategoryItem1.jdField_a_of_type_JavaUtilList == null) || (localDoodleMusicCategoryItem1.jdField_a_of_type_JavaUtilList.size() <= 0)) {
            continue;
          }
          DoodleMusicCategoryItem localDoodleMusicCategoryItem2 = localDoodleMusicCategoryItem1.a();
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(localObject3);
          localArrayList.add(localMusicItemInfo2);
          this.jdField_a_of_type_Int = 3;
          if (RecognitionManager.jdField_a_of_type_Boolean)
          {
            localArrayList.add(localMusicItemInfo4);
            this.jdField_a_of_type_Int = 4;
            if (this.jdField_a_of_type_Boolean)
            {
              localArrayList.add(localMusicItemInfo5);
              this.jdField_a_of_type_Int = 5;
            }
          }
          if ((paramBoolean) && (localDoodleMusicCategoryItem1.jdField_a_of_type_Boolean)) {
            Collections.shuffle(localDoodleMusicCategoryItem1.jdField_a_of_type_JavaUtilList);
          }
          localArrayList.addAll(localDoodleMusicCategoryItem1.jdField_a_of_type_JavaUtilList);
          localDoodleMusicCategoryItem2.jdField_a_of_type_JavaUtilList = localArrayList;
          this.jdField_b_of_type_JavaUtilArrayList.add(localDoodleMusicCategoryItem2);
        }
        bool = false;
      }
      finally {}
      label634:
      continue;
      label640:
      boolean bool = false;
      continue;
      label646:
      int i = this.jdField_a_of_type_JavaUtilArrayList.size();
      continue;
      label657:
      if ((this.jdField_b_of_type_Int == 1) && (this.jdField_e_of_type_Int >= 1) && (this.jdField_e_of_type_Int <= this.jdField_b_of_type_JavaUtilArrayList.size()))
      {
        localObject4 = a(localMusicItemInfo1, localMusicItemInfo2, localMusicItemInfo3);
        this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_e_of_type_Int - 1, localObject4);
      }
      label714:
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      Object localObject4 = this.jdField_b_of_type_JavaUtilArrayList;
      return localObject4;
      label736:
      i = 0;
    }
  }
  
  public void a()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null)
    {
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      localQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
    ThreadManager.post(new amvq(this), 8, null, true);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = a().getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = a().getNetEngine(0);
    e();
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      if (paramInt == 4) {
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)paramObject);
      }
      if (((paramObject instanceof String)) && (QLog.isColorLevel())) {
        QLog.d("QIMMusicConfigManager", 2, "onStepCall successed, step=" + paramInt + ", msg=" + paramObject);
      }
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new amvr(this, paramInt, paramBoolean, paramObject));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "onStepCall failed, step=" + paramInt + ", msg=" + paramObject);
      }
    }
  }
  
  public void a(MusicItemInfo paramMusicItemInfo, boolean paramBoolean)
  {
    label475:
    for (;;)
    {
      Object localObject1;
      int i;
      long l;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMMusicConfigManager", 2, "addOrUpdateMytabMusic, lock updateTimeStamp=" + paramBoolean);
        }
        if ((this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem == null) || (this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList == null)) {
          return;
        }
        localObject1 = this.jdField_a_of_type_DovComQqImCaptureDataDoodleMusicCategoryItem.jdField_a_of_type_JavaUtilList;
        i = a(paramMusicItemInfo);
        l = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("QIMMusicConfigManager", 2, "addOrUpdateMytabMusic, index=" + i);
        }
        if (i != -1) {
          break label369;
        }
        if (((List)localObject1).size() < this.jdField_a_of_type_Int + 40)
        {
          ((List)localObject1).add(this.jdField_a_of_type_Int, paramMusicItemInfo);
          localObject1 = new FlowMusic(paramMusicItemInfo);
          if (localObject1 != null)
          {
            ((FlowMusic)localObject1).tryBegin = paramMusicItemInfo.jdField_e_of_type_Int;
            ((FlowMusic)localObject1).tryEnd = paramMusicItemInfo.f;
            ((FlowMusic)localObject1).url = paramMusicItemInfo.c;
            ((FlowMusic)localObject1).path = paramMusicItemInfo.a();
            ((FlowMusic)localObject1).duration = paramMusicItemInfo.g;
            a((FlowMusic)localObject1, l);
          }
          if (this.jdField_b_of_type_JavaUtilList == null) {
            break label475;
          }
          localObject1 = this.jdField_b_of_type_JavaUtilList.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label475;
          }
          ((QIMMusicConfigManager.LoadMusicStepListener)((Iterator)localObject1).next()).a(5, true, paramMusicItemInfo);
        }
      }
      MusicItemInfo localMusicItemInfo = (MusicItemInfo)((List)localObject1).remove(((List)localObject1).size() - 1);
      if (!TextUtils.isEmpty(localMusicItemInfo.a()))
      {
        FileUtils.a(new File(localMusicItemInfo.a()));
        if (QLog.isColorLevel()) {
          QLog.d("QIMMusicConfigManager", 2, "delete file=" + localMusicItemInfo.jdField_a_of_type_JavaLangString);
        }
      }
      ((List)localObject1).add(this.jdField_a_of_type_Int, paramMusicItemInfo);
      continue;
      label369:
      if ((i != this.jdField_a_of_type_Int) && (paramBoolean))
      {
        ((List)localObject1).remove(i);
        ((List)localObject1).add(this.jdField_a_of_type_Int, paramMusicItemInfo);
        localObject1 = a(paramMusicItemInfo.jdField_a_of_type_Int);
        if (localObject1 != null) {
          ((FlowMusic)localObject1).sourceType = 0;
        }
      }
      else
      {
        ((List)localObject1).remove(i);
        ((List)localObject1).add(i, paramMusicItemInfo);
        localObject1 = a(paramMusicItemInfo.jdField_a_of_type_Int);
        if (localObject1 != null)
        {
          ((FlowMusic)localObject1).sourceType = 0;
          l = ((FlowMusic)localObject1).storeTimeStamp;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("QIMMusicConfigManager", 2, "addOrUpdateMytabMusic, unlock");
          }
        }
        else {}
      }
    }
  }
  
  public void a(QIMMusicConfigManager.LoadMusicStepListener paramLoadMusicStepListener)
  {
    if ((paramLoadMusicStepListener == null) || (this.jdField_b_of_type_JavaUtilList == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "addLoadMusicListener listener = null");
      }
    }
    do
    {
      return;
      if (!this.jdField_b_of_type_JavaUtilList.contains(paramLoadMusicStepListener)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QIMMusicConfigManager", 2, "addLoadMusicListener mListeners has listener");
    return;
    this.jdField_b_of_type_JavaUtilList.add(paramLoadMusicStepListener);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilArrayList = a(paramString);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleStickerConfig").append(paramString).append(" result:");
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break label86;
      }
    }
    label86:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("QIMMusicConfigManager", 2, bool);
      a().notifyObservers(CaptureConfigUpdateObserver.class, 1, true, null);
      QIMFileUtils.a(jdField_a_of_type_JavaIoFile, "doodle_music_config.cfg", paramString);
      return;
    }
  }
  
  public void a(String paramString, QIMMusicConfigManager.GetSingleMusicInfoCallback paramGetSingleMusicInfoCallback)
  {
    ThreadManager.executeOnSubThread(new QIMMusicConfigManager.GetSingleFullMusicInfoTask(this, paramString, paramGetSingleMusicInfoCallback));
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      d();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public MusicItemInfo b(int paramInt)
  {
    Object localObject1 = null;
    MusicItemInfo localMusicItemInfo = null;
    try
    {
      Object localObject3 = a();
      if (localObject3 != null)
      {
        localObject3 = ((ArrayList)localObject3).iterator();
        localObject1 = localMusicItemInfo;
        while (((Iterator)localObject3).hasNext())
        {
          localMusicItemInfo = ((DoodleMusicCategoryItem)((Iterator)localObject3).next()).a(paramInt);
          localObject1 = localMusicItemInfo;
          if (localMusicItemInfo != null) {
            localObject1 = localMusicItemInfo;
          }
        }
      }
      return localObject1;
    }
    finally {}
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      localQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
  }
  
  public void b(QIMMusicConfigManager.LoadMusicStepListener paramLoadMusicStepListener)
  {
    if (this.jdField_b_of_type_JavaUtilList.contains(paramLoadMusicStepListener)) {
      this.jdField_b_of_type_JavaUtilList.remove(paramLoadMusicStepListener);
    }
  }
  
  public boolean b()
  {
    return this.c == 1;
  }
  
  public void c()
  {
    a(true);
  }
  
  public void d()
  {
    try
    {
      this.jdField_b_of_type_JavaUtilArrayList = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void e()
  {
    boolean bool = a(a().getCurrentAccountUin());
    this.jdField_a_of_type_JavaUtilList.clear();
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigManager", 2, "checkMyFavoriteUpgradeInQQMusic, hasFetch=" + bool);
    }
    if (!bool)
    {
      localObject = a().c();
      if (localObject != null)
      {
        this.jdField_a_of_type_JavaLangString = ((String)localObject);
        new amvt(this).a();
      }
      return;
    }
    Object localObject = new amvv(this);
    ((amvv)localObject).jdField_a_of_type_Boolean = true;
    ((amvw)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QIMMusicConfigManager
 * JD-Core Version:    0.7.0.1
 */