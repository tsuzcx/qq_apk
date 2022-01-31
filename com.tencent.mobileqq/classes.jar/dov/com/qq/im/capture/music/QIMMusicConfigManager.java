package dov.com.qq.im.capture.music;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import atmo;
import atmp;
import atmq;
import atmr;
import axrr;
import badq;
import bhgj;
import bhgl;
import bhgm;
import bhhi;
import bhik;
import bhiq;
import bhir;
import bhis;
import bhjl;
import bhok;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.BatchGetMusicInfoRequest;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.control.GetSingleFullMusicInfoTask;
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
import vlm;

public class QIMMusicConfigManager
  extends bhgm
{
  public static final File a;
  private int jdField_a_of_type_Int = 3;
  protected BroadcastReceiver a;
  public atmp a;
  public axrr a;
  public bhhi a;
  public MusicItemInfo a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private ArrayList<bhhi> jdField_a_of_type_JavaUtilArrayList;
  private List<FlowMusic> jdField_a_of_type_JavaUtilList = new ArrayList();
  public AtomicBoolean a;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private bhhi jdField_b_of_type_Bhhi;
  public String b;
  private ArrayList<bhhi> jdField_b_of_type_JavaUtilArrayList;
  private List<bhis> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString = "我的";
  private int e = 2;
  
  static
  {
    jdField_a_of_type_JavaIoFile = new File(bhok.a(), "dov_doodle_music");
  }
  
  public QIMMusicConfigManager()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bhir(this);
    this.jdField_a_of_type_Atmp = a().getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_Axrr = a().getNetEngine(0);
  }
  
  private int a(MusicItemInfo paramMusicItemInfo)
  {
    int j;
    if (this.jdField_b_of_type_Bhhi == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory is null");
      }
      j = -1;
      return j;
    }
    if (this.jdField_b_of_type_Bhhi.jdField_a_of_type_JavaUtilList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory.templateGroups is null");
      }
      return -1;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_b_of_type_Bhhi.jdField_a_of_type_JavaUtilList.size()) {
        break label156;
      }
      MusicItemInfo localMusicItemInfo = (MusicItemInfo)this.jdField_b_of_type_Bhhi.jdField_a_of_type_JavaUtilList.get(i);
      j = i;
      if (localMusicItemInfo.mItemId == paramMusicItemInfo.mItemId) {
        break;
      }
      if ((paramMusicItemInfo.mRecognitionOffset != -1.0F) && (!TextUtils.isEmpty(paramMusicItemInfo.mMusicName)) && (!TextUtils.isEmpty(localMusicItemInfo.mMusicName)))
      {
        j = i;
        if (paramMusicItemInfo.mMusicName.equals(localMusicItemInfo.mMusicName)) {
          break;
        }
      }
      i += 1;
    }
    label156:
    return -1;
  }
  
  private bhhi a(MusicItemInfo paramMusicItemInfo1, MusicItemInfo paramMusicItemInfo2, MusicItemInfo paramMusicItemInfo3)
  {
    this.jdField_b_of_type_Bhhi = new bhhi();
    this.jdField_b_of_type_Bhhi.jdField_a_of_type_Int = 999;
    this.jdField_b_of_type_Bhhi.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    MusicItemInfo localMusicItemInfo = new MusicItemInfo();
    localMusicItemInfo.mType = 4;
    localMusicItemInfo.mItemId = -3;
    this.jdField_b_of_type_Bhhi.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Bhhi.jdField_a_of_type_JavaUtilList.add(paramMusicItemInfo1);
    this.jdField_b_of_type_Bhhi.jdField_a_of_type_JavaUtilList.add(paramMusicItemInfo2);
    if (bhjl.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = 4;
      paramMusicItemInfo1 = new MusicItemInfo();
      paramMusicItemInfo1.mType = 6;
      paramMusicItemInfo1.mItemId = -4;
      this.jdField_b_of_type_Bhhi.jdField_a_of_type_JavaUtilList.add(paramMusicItemInfo1);
      if (this.jdField_b_of_type_Boolean)
      {
        paramMusicItemInfo1 = new MusicItemInfo();
        paramMusicItemInfo1.mType = 8;
        paramMusicItemInfo1.mItemId = -6;
        this.jdField_b_of_type_Bhhi.jdField_a_of_type_JavaUtilList.add(paramMusicItemInfo1);
      }
    }
    this.jdField_b_of_type_Bhhi.jdField_a_of_type_JavaUtilList.add(localMusicItemInfo);
    if (this.jdField_d_of_type_Int == 1)
    {
      this.jdField_b_of_type_Bhhi.jdField_a_of_type_JavaUtilList.add(paramMusicItemInfo3);
      paramMusicItemInfo3.jumpWs = this.jdField_c_of_type_JavaLangString;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramMusicItemInfo1 = (FlowMusic)this.jdField_a_of_type_JavaUtilList.get(i);
      paramMusicItemInfo2 = new MusicItemInfo();
      paramMusicItemInfo2.mType = 5;
      paramMusicItemInfo2.mMusicName = paramMusicItemInfo1.songName;
      paramMusicItemInfo2.setPath(paramMusicItemInfo1.path);
      paramMusicItemInfo2.mUrl = paramMusicItemInfo1.url;
      paramMusicItemInfo2.mSingername = paramMusicItemInfo1.singerName;
      paramMusicItemInfo2.mItemId = paramMusicItemInfo1.songId;
      paramMusicItemInfo2.mSongMid = paramMusicItemInfo1.songMid;
      paramMusicItemInfo2.musicStart = paramMusicItemInfo1.tryBegin;
      paramMusicItemInfo2.musicEnd = paramMusicItemInfo1.tryEnd;
      paramMusicItemInfo2.musicDuration = paramMusicItemInfo1.duration;
      paramMusicItemInfo2.mAlbumUrl = paramMusicItemInfo1.albumUrl;
      this.jdField_b_of_type_Bhhi.jdField_a_of_type_JavaUtilList.add(paramMusicItemInfo2);
      i += 1;
    }
    return this.jdField_b_of_type_Bhhi;
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
  
  private MusicItemInfo a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new VsMusicItemInfo(paramJSONObject);
    }
    MusicItemInfo localMusicItemInfo = new MusicItemInfo();
    localMusicItemInfo.mType = 5;
    localMusicItemInfo.mMusicName = paramJSONObject.optString("title");
    localMusicItemInfo.mSingername = paramJSONObject.optString("desc");
    localMusicItemInfo.mItemId = paramJSONObject.optInt("id");
    localMusicItemInfo.mSongMid = paramJSONObject.optString("mid");
    return localMusicItemInfo;
  }
  
  private void a(bhhi parambhhi, MusicItemInfo paramMusicItemInfo)
  {
    if ((parambhhi.jdField_a_of_type_Int == 999) || (paramMusicItemInfo.mType != 5)) {}
    MusicItemInfo localMusicItemInfo;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = parambhhi.jdField_a_of_type_JavaUtilList.iterator();
      }
      localMusicItemInfo = (MusicItemInfo)localIterator.next();
      if (localMusicItemInfo.mType == 5)
      {
        i = parambhhi.jdField_a_of_type_JavaUtilList.indexOf(localMusicItemInfo);
        parambhhi.jdField_a_of_type_JavaUtilList.remove(i);
        parambhhi.jdField_a_of_type_JavaUtilList.add(i, paramMusicItemInfo);
        return;
      }
    } while (localMusicItemInfo.mType != 1);
    int i = parambhhi.jdField_a_of_type_JavaUtilList.indexOf(localMusicItemInfo);
    parambhhi.jdField_a_of_type_JavaUtilList.add(i, paramMusicItemInfo);
  }
  
  private void a(FlowMusic paramFlowMusic, long paramLong)
  {
    atmr localatmr = this.jdField_a_of_type_Atmp.a();
    for (;;)
    {
      try
      {
        localatmr.a();
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
          this.jdField_a_of_type_Atmp.a((atmo)localObject);
          return;
        }
        if (this.jdField_a_of_type_JavaUtilList.size() < 40)
        {
          this.jdField_a_of_type_JavaUtilList.add(0, paramFlowMusic);
          this.jdField_a_of_type_Atmp.b(paramFlowMusic);
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
        localatmr.c();
        localatmr.b();
      }
      int i;
      Object localObject = (FlowMusic)this.jdField_a_of_type_JavaUtilList.remove(i - 1);
      this.jdField_a_of_type_Atmp.a(FlowMusic.class.getSimpleName(), "songName=? and tryBegin=? and tryEnd=?", new String[] { ((FlowMusic)localObject).songName, String.valueOf(((FlowMusic)localObject).tryBegin), String.valueOf(((FlowMusic)localObject).tryEnd) });
      this.jdField_a_of_type_JavaUtilList.add(0, paramFlowMusic);
      continue;
      label298:
      localObject = null;
    }
  }
  
  public static boolean a()
  {
    boolean bool = new File(jdField_a_of_type_JavaIoFile + File.separator + "doodle_music_config.cfg").exists();
    if (QLog.isColorLevel()) {
      QLog.i("QIMMusicConfigManager", 2, "QIMMusicConfigManager isStickerConfigFileExist=" + bool);
    }
    return bool;
  }
  
  public static void b(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("fecth_qq_music", 4).edit();
    localEditor.putLong("fecth_from_qq_music_time_" + paramString, System.currentTimeMillis());
    localEditor.commit();
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      b(a().getCurrentAccountUin());
    }
  }
  
  public int a()
  {
    return this.e;
  }
  
  public MusicItemInfo a(int paramInt)
  {
    Object localObject;
    if (this.jdField_b_of_type_Bhhi == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory is null");
      }
      localObject = null;
      return localObject;
    }
    if (this.jdField_b_of_type_Bhhi.jdField_a_of_type_JavaUtilList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory.templateGroups is null");
      }
      return null;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_b_of_type_Bhhi.jdField_a_of_type_JavaUtilList.size()) {
        break label106;
      }
      MusicItemInfo localMusicItemInfo = (MusicItemInfo)this.jdField_b_of_type_Bhhi.jdField_a_of_type_JavaUtilList.get(i);
      localObject = localMusicItemInfo;
      if (localMusicItemInfo.mItemId == paramInt) {
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
    //   3: invokevirtual 433	dov/com/qq/im/capture/music/QIMMusicConfigManager:a	()Ljava/util/ArrayList;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +63 -> 71
    //   11: aload_3
    //   12: invokevirtual 434	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   15: astore_3
    //   16: aload_3
    //   17: invokeinterface 287 1 0
    //   22: ifeq +49 -> 71
    //   25: aload_3
    //   26: invokeinterface 291 1 0
    //   31: checkcast 132	bhhi
    //   34: astore 4
    //   36: iload_1
    //   37: iconst_m1
    //   38: if_icmpne +14 -> 52
    //   41: aload 4
    //   43: iload_2
    //   44: invokevirtual 436	bhhi:a	(I)Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;
    //   47: astore_3
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_3
    //   51: areturn
    //   52: aload 4
    //   54: getfield 173	bhhi:jdField_a_of_type_Int	I
    //   57: iload_1
    //   58: if_icmpne -42 -> 16
    //   61: aload 4
    //   63: iload_2
    //   64: invokevirtual 436	bhhi:a	(I)Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;
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
    //   34	28	4	localbhhi	bhhi
    // Exception table:
    //   from	to	target	type
    //   2	7	76	finally
    //   11	16	76	finally
    //   16	36	76	finally
    //   41	48	76	finally
    //   52	68	76	finally
  }
  
  /* Error */
  public ArrayList<bhhi> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	dov/com/qq/im/capture/music/QIMMusicConfigManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: iconst_1
    //   7: iconst_1
    //   8: invokevirtual 440	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
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
    //   24: invokevirtual 443	dov/com/qq/im/capture/music/QIMMusicConfigManager:a	(Z)Ljava/util/ArrayList;
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
    //   17	11	2	localObject1	Object
    //   31	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	31	finally
    //   22	28	31	finally
  }
  
  public ArrayList<bhhi> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList(4);
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("showMine")) {
        this.jdField_b_of_type_Int = paramString.getInt("showMine");
      }
      if (paramString.has("showWsTab")) {
        this.jdField_c_of_type_Int = paramString.getInt("showWsTab");
      }
      if (paramString.has("showMusicWs")) {
        this.jdField_d_of_type_Int = paramString.getInt("showMusicWs");
      }
      if (paramString.has("jumpWsTab")) {
        this.jdField_b_of_type_JavaLangString = paramString.getString("jumpWsTab");
      }
      if (paramString.has("jumpWsMusic")) {
        this.jdField_c_of_type_JavaLangString = paramString.getString("jumpWsMusic");
      }
      if (paramString.has("mineIndex")) {
        this.e = paramString.getInt("mineIndex");
      }
      if (paramString.has("mineCategoryName")) {
        this.jdField_d_of_type_JavaLangString = paramString.getString("mineCategoryName");
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
        localArrayList.add(new bhhi(localJSONArray.getJSONObject(i)));
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
  
  public ArrayList<bhhi> a(boolean paramBoolean)
  {
    int j = 0;
    for (;;)
    {
      MusicItemInfo localMusicItemInfo2;
      MusicItemInfo localMusicItemInfo3;
      try
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          if (this.jdField_a_of_type_JavaUtilArrayList == null)
          {
            localObject3 = bhok.a(jdField_a_of_type_JavaIoFile, "doodle_music_config.cfg");
            if (localObject3 != null)
            {
              this.jdField_a_of_type_JavaUtilArrayList = a((String)localObject3);
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder().append("initStickerConfigFromCache, result:");
                if (this.jdField_a_of_type_JavaUtilArrayList == null) {
                  break label625;
                }
                bool = true;
                QLog.i("QIMMusicConfigManager", 2, bool);
              }
            }
            if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
            {
              this.jdField_a_of_type_JavaUtilArrayList = a(bhok.a("doodle_music.cfg"));
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder().append("initStickerConfigFromAssets, result:");
                if (this.jdField_a_of_type_JavaUtilArrayList == null) {
                  break label631;
                }
                bool = true;
                QLog.i("QIMMusicConfigManager", 2, bool);
              }
            }
          }
          if ((this.jdField_b_of_type_Bhhi == null) || (this.jdField_b_of_type_Bhhi.jdField_a_of_type_JavaUtilList.size() == this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_Int)) {
            break label727;
          }
          i = 1;
          if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (!paramBoolean) && (i == 0)) {
            break label705;
          }
          if (this.jdField_a_of_type_JavaUtilArrayList != null) {
            break label637;
          }
          i = j;
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(i);
          Object localObject3 = new MusicItemInfo();
          ((MusicItemInfo)localObject3).mType = 2;
          ((MusicItemInfo)localObject3).mItemId = -1;
          localMusicItemInfo2 = new MusicItemInfo();
          localMusicItemInfo2.mType = 3;
          localMusicItemInfo2.mItemId = -2;
          localMusicItemInfo3 = new MusicItemInfo();
          localMusicItemInfo3.mType = 10;
          localMusicItemInfo3.mItemId = -7;
          MusicItemInfo localMusicItemInfo4 = new MusicItemInfo();
          localMusicItemInfo4.mType = 6;
          localMusicItemInfo4.mItemId = -4;
          MusicItemInfo localMusicItemInfo5 = new MusicItemInfo();
          localMusicItemInfo5.mType = 8;
          localMusicItemInfo5.mItemId = -6;
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            break label648;
          }
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!localIterator.hasNext()) {
            break label648;
          }
          bhhi localbhhi1 = (bhhi)localIterator.next();
          if ((localbhhi1.jdField_a_of_type_JavaUtilList == null) || (localbhhi1.jdField_a_of_type_JavaUtilList.size() <= 0)) {
            continue;
          }
          bhhi localbhhi2 = localbhhi1.a();
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(localObject3);
          localArrayList.add(localMusicItemInfo2);
          this.jdField_a_of_type_Int = 3;
          if (bhjl.jdField_a_of_type_Boolean)
          {
            localArrayList.add(localMusicItemInfo4);
            this.jdField_a_of_type_Int = 4;
            if (this.jdField_b_of_type_Boolean)
            {
              localArrayList.add(localMusicItemInfo5);
              this.jdField_a_of_type_Int = 5;
            }
          }
          if ((this.jdField_a_of_type_Bhhi != null) && (this.jdField_a_of_type_Bhhi.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Bhhi.jdField_a_of_type_Int == localbhhi1.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null)) {
            a(localbhhi1, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
          }
          if ((paramBoolean) && (localbhhi1.jdField_a_of_type_Boolean)) {
            Collections.shuffle(localbhhi1.jdField_a_of_type_JavaUtilList);
          }
          localArrayList.addAll(localbhhi1.jdField_a_of_type_JavaUtilList);
          localbhhi2.jdField_a_of_type_JavaUtilList = localArrayList;
          this.jdField_b_of_type_JavaUtilArrayList.add(localbhhi2);
        }
        bool = false;
      }
      finally {}
      label625:
      continue;
      label631:
      boolean bool = false;
      continue;
      label637:
      int i = this.jdField_a_of_type_JavaUtilArrayList.size();
      continue;
      label648:
      if ((this.jdField_b_of_type_Int == 1) && (this.e >= 1) && (this.e <= this.jdField_b_of_type_JavaUtilArrayList.size()))
      {
        localObject4 = a(localMusicItemInfo1, localMusicItemInfo2, localMusicItemInfo3);
        this.jdField_b_of_type_JavaUtilArrayList.add(this.e - 1, localObject4);
      }
      label705:
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      Object localObject4 = this.jdField_b_of_type_JavaUtilArrayList;
      return localObject4;
      label727:
      i = 0;
    }
  }
  
  public void a()
  {
    AppInterface localAppInterface = a();
    if (localAppInterface != null)
    {
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      localAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      a();
      a().notifyObservers(bhik.class, 1, true, null);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QIMMusicConfigManager", 4, "initMusicConfig");
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      if (paramInt == 4)
      {
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)paramObject);
        Collections.sort(this.jdField_a_of_type_JavaUtilList);
      }
      if (((paramObject instanceof String)) && (QLog.isColorLevel())) {
        QLog.d("QIMMusicConfigManager", 2, "onStepCall successed, step=" + paramInt + ", msg=" + paramObject);
      }
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new QIMMusicConfigManager.1(this, paramInt, paramBoolean, paramObject));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "onStepCall failed, step=" + paramInt + ", msg=" + paramObject);
      }
    }
  }
  
  public void a(bhis parambhis)
  {
    if ((parambhis == null) || (this.jdField_b_of_type_JavaUtilList == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "addLoadMusicListener listener = null");
      }
    }
    do
    {
      return;
      if (!this.jdField_b_of_type_JavaUtilList.contains(parambhis)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QIMMusicConfigManager", 2, "addLoadMusicListener mListeners has listener");
    return;
    this.jdField_b_of_type_JavaUtilList.add(parambhis);
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
        if ((this.jdField_b_of_type_Bhhi == null) || (this.jdField_b_of_type_Bhhi.jdField_a_of_type_JavaUtilList == null)) {
          return;
        }
        localObject1 = this.jdField_b_of_type_Bhhi.jdField_a_of_type_JavaUtilList;
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
            ((FlowMusic)localObject1).tryBegin = paramMusicItemInfo.musicStart;
            ((FlowMusic)localObject1).tryEnd = paramMusicItemInfo.musicEnd;
            ((FlowMusic)localObject1).url = paramMusicItemInfo.mUrl;
            ((FlowMusic)localObject1).path = paramMusicItemInfo.getLocalPath();
            ((FlowMusic)localObject1).duration = paramMusicItemInfo.musicDuration;
            a((FlowMusic)localObject1, l);
          }
          if (this.jdField_b_of_type_JavaUtilList == null) {
            break label475;
          }
          localObject1 = this.jdField_b_of_type_JavaUtilList.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label475;
          }
          ((bhis)((Iterator)localObject1).next()).a(5, true, paramMusicItemInfo);
        }
      }
      MusicItemInfo localMusicItemInfo = (MusicItemInfo)((List)localObject1).remove(((List)localObject1).size() - 1);
      if (!TextUtils.isEmpty(localMusicItemInfo.getLocalPath()))
      {
        vlm.a(new File(localMusicItemInfo.getLocalPath()));
        if (QLog.isColorLevel()) {
          QLog.d("QIMMusicConfigManager", 2, "delete file=" + localMusicItemInfo.mMusicName);
        }
      }
      ((List)localObject1).add(this.jdField_a_of_type_Int, paramMusicItemInfo);
      continue;
      label369:
      if ((i != this.jdField_a_of_type_Int) && (paramBoolean))
      {
        ((List)localObject1).remove(i);
        ((List)localObject1).add(this.jdField_a_of_type_Int, paramMusicItemInfo);
        localObject1 = a(paramMusicItemInfo.mItemId);
        if (localObject1 != null) {
          ((FlowMusic)localObject1).sourceType = 0;
        }
      }
      else
      {
        ((List)localObject1).remove(i);
        ((List)localObject1).add(i, paramMusicItemInfo);
        localObject1 = a(paramMusicItemInfo.mItemId);
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
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilArrayList = a(paramString);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleDoodleMusicConfig").append(paramString).append(" result:");
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break label102;
      }
    }
    label102:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("QIMMusicConfigManager", 2, bool);
      bhok.a(jdField_a_of_type_JavaIoFile, "doodle_music_config.cfg", paramString);
      PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.sApplication).edit().putInt("show_wstab", this.jdField_c_of_type_Int).commit();
      return;
    }
  }
  
  public void a(String paramString, bhgl parambhgl)
  {
    a(paramString, false, parambhgl);
  }
  
  public void a(String paramString, boolean paramBoolean, bhgl parambhgl)
  {
    if (paramBoolean)
    {
      QLog.i("QIMMusicConfigManager", 1, "getSingleFullMusicInfo instance is VsMusicItemInfo though videoStory cmd");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      VSNetworkHelper.a().a(new BatchGetMusicInfoRequest(localArrayList), new bhiq(this, parambhgl));
      return;
    }
    ThreadManager.executeOnSubThread(new GetSingleFullMusicInfoTask(paramString, parambhgl));
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void aZ_()
  {
    AppInterface localAppInterface = a();
    if (localAppInterface != null) {
      localAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
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
          localMusicItemInfo = ((bhhi)((Iterator)localObject3).next()).a(paramInt);
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
  
  public void b(bhis parambhis)
  {
    if (this.jdField_b_of_type_JavaUtilList.contains(parambhis)) {
      this.jdField_b_of_type_JavaUtilList.remove(parambhis);
    }
  }
  
  public boolean b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.sApplication);
      if (!localSharedPreferences.contains("show_wstab")) {
        break label55;
      }
      this.jdField_c_of_type_Int = localSharedPreferences.getInt("show_wstab", 0);
    }
    while (this.jdField_c_of_type_Int == 1)
    {
      return true;
      label55:
      a();
    }
    return false;
  }
  
  public void c()
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
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    PeakAppInterface.a.a(1009);
    String str = a().getCurrentAccountUin();
    long l = BaseApplicationImpl.getContext().getSharedPreferences("fecth_qq_music", 4).getLong("fecth_from_qq_music_time_" + str, 0L);
    if ((System.currentTimeMillis() - l > 86400000L) && (badq.a(BaseApplicationImpl.sApplication))) {}
    for (int i = 1;; i = 0)
    {
      if ((l == 0L) || (i != 0))
      {
        str = a().getCurrentAccountUin();
        if (str != null)
        {
          this.jdField_a_of_type_JavaLangString = str;
          new QIMMusicConfigManager.GetQQMusicSongListTask(this, this).a();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "checkMyFavoriteUpgradeInQQMusic, lastFetchTime = " + l);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QIMMusicConfigManager
 * JD-Core Version:    0.7.0.1
 */