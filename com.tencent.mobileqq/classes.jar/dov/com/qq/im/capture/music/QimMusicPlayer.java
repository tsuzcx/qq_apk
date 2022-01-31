package dov.com.qq.im.capture.music;

import android.text.TextUtils;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.dancegame.DanceGameVideoManager;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter.MusicWaveformSupporter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QQFilterRenderManagerHolder;
import dov.com.qq.im.capture.IQIMManager;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.view.QIMCommonLoadingProgress;
import dov.com.tencent.mobileqq.shortvideo.musicwavesupport.MusicWaveformManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class QimMusicPlayer
  extends IQIMManager
  implements QQSpecialAVFilter.MusicWaveformSupporter
{
  private int jdField_a_of_type_Int = QQFilterRenderManagerHolder.jdField_a_of_type_Int;
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private MusicMuteListener jdField_a_of_type_DovComQqImCaptureMusicMusicMuteListener;
  private MusicPlayerScene jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerScene;
  private MusicWaveformManager jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicWaveformManager = new MusicWaveformManager();
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  public ConcurrentHashMap a;
  private volatile int jdField_b_of_type_Int = 0;
  private MusicItemInfo jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public QimMusicPlayer()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  /* Error */
  private MusicPlayerScene a(MusicItemInfo paramMusicItemInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_1
    //   5: getfield 56	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:d	I
    //   8: iconst_1
    //   9: if_icmpne +62 -> 71
    //   12: aload_0
    //   13: getfield 39	dov/com/qq/im/capture/music/QimMusicPlayer:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   16: iconst_1
    //   17: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   20: invokevirtual 66	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 68	dov/com/qq/im/capture/music/MusicPlayerScene
    //   26: astore_3
    //   27: aload_3
    //   28: astore_2
    //   29: aload_3
    //   30: ifnonnull +32 -> 62
    //   33: new 68	dov/com/qq/im/capture/music/MusicPlayerScene
    //   36: dup
    //   37: invokespecial 69	dov/com/qq/im/capture/music/MusicPlayerScene:<init>	()V
    //   40: astore_2
    //   41: aload_2
    //   42: aload_0
    //   43: getfield 44	dov/com/qq/im/capture/music/QimMusicPlayer:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   46: invokevirtual 72	dov/com/qq/im/capture/music/MusicPlayerScene:a	(Ljava/util/List;)V
    //   49: aload_0
    //   50: getfield 39	dov/com/qq/im/capture/music/QimMusicPlayer:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   53: iconst_1
    //   54: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aload_2
    //   58: invokevirtual 76	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: pop
    //   62: aload_2
    //   63: aload_1
    //   64: invokevirtual 79	dov/com/qq/im/capture/music/MusicPlayerScene:a	(Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;)V
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: areturn
    //   71: aload_1
    //   72: getfield 56	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:d	I
    //   75: iconst_5
    //   76: if_icmpne -9 -> 67
    //   79: aload_0
    //   80: getfield 39	dov/com/qq/im/capture/music/QimMusicPlayer:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   83: iconst_2
    //   84: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: invokevirtual 66	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: checkcast 68	dov/com/qq/im/capture/music/MusicPlayerScene
    //   93: astore_3
    //   94: aload_3
    //   95: astore_2
    //   96: aload_3
    //   97: ifnonnull +32 -> 129
    //   100: new 81	dov/com/qq/im/capture/music/QQMusicPlayerScene
    //   103: dup
    //   104: invokespecial 82	dov/com/qq/im/capture/music/QQMusicPlayerScene:<init>	()V
    //   107: astore_2
    //   108: aload_2
    //   109: aload_0
    //   110: getfield 44	dov/com/qq/im/capture/music/QimMusicPlayer:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   113: invokevirtual 72	dov/com/qq/im/capture/music/MusicPlayerScene:a	(Ljava/util/List;)V
    //   116: aload_0
    //   117: getfield 39	dov/com/qq/im/capture/music/QimMusicPlayer:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   120: iconst_2
    //   121: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aload_2
    //   125: invokevirtual 76	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   128: pop
    //   129: aload_2
    //   130: aload_1
    //   131: invokevirtual 79	dov/com/qq/im/capture/music/MusicPlayerScene:a	(Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;)V
    //   134: goto -67 -> 67
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	QimMusicPlayer
    //   0	142	1	paramMusicItemInfo	MusicItemInfo
    //   3	127	2	localObject	Object
    //   26	71	3	localMusicPlayerScene	MusicPlayerScene
    // Exception table:
    //   from	to	target	type
    //   4	27	137	finally
    //   33	62	137	finally
    //   62	67	137	finally
    //   71	94	137	finally
    //   100	129	137	finally
    //   129	134	137	finally
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerScene != null)
    {
      f();
      this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerScene.a();
    }
  }
  
  public float a()
  {
    MusicItemInfo localMusicItemInfo = b();
    if (localMusicItemInfo == null) {}
    do
    {
      for (;;)
      {
        return -1.0F;
        try
        {
          if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicWaveformManager != null) && (localMusicItemInfo.b()) && (a()))
          {
            float f = this.jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicWaveformManager.a(a() - localMusicItemInfo.e);
            return f;
          }
        }
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("QimMusicPlayer", 2, "getCurrentMusicGain() error: " + localException.toString());
    return -1.0F;
  }
  
  public int a()
  {
    int i = -1;
    if (a()) {
      i = this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerScene.a();
    }
    return i;
  }
  
  public MusicItemInfo a()
  {
    MusicItemInfo localMusicItemInfo = b();
    if ((localMusicItemInfo != null) && (localMusicItemInfo.b())) {
      return localMusicItemInfo.a();
    }
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureMusicMusicMuteListener != null) {
      this.jdField_a_of_type_DovComQqImCaptureMusicMusicMuteListener.a(true);
    }
    a(-1, -1, paramInt);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerScene != null) {
      this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerScene.a(paramLong);
    }
  }
  
  public void a(MusicItemInfo paramMusicItemInfo)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      localObject = (DownloadTask)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramMusicItemInfo.a());
      if (localObject != null) {
        QQMusicDownloader.a((DownloadTask)localObject);
      }
    }
    Object localObject = paramMusicItemInfo.a();
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(localObject))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject);
    }
    paramMusicItemInfo.jdField_c_of_type_Int = -1;
    QIMCommonLoadingProgress.a(paramMusicItemInfo).c();
  }
  
  public void a(MusicMuteListener paramMusicMuteListener)
  {
    this.jdField_a_of_type_DovComQqImCaptureMusicMusicMuteListener = paramMusicMuteListener;
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (this.jdField_a_of_type_DovComQqImCaptureMusicMusicMuteListener != null)) {
      this.jdField_a_of_type_DovComQqImCaptureMusicMusicMuteListener.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.c());
    }
  }
  
  public void a(MusicPlayerSceneListener paramMusicPlayerSceneListener)
  {
    if ((paramMusicPlayerSceneListener == null) || (this.jdField_a_of_type_JavaUtilList == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("QimMusicPlayer", 2, "addMusicPlayerSceneListener listener = null");
      }
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramMusicPlayerSceneListener)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QimMusicPlayer", 2, "addMusicPlayerSceneListener mListeners has listener");
    return;
    this.jdField_a_of_type_JavaUtilList.add(paramMusicPlayerSceneListener);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerScene != null) && (this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerScene.a());
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    MusicItemInfo localMusicItemInfo = ((QIMMusicConfigManager)QIMManager.a(2)).a(paramInt1, paramInt2);
    if (localMusicItemInfo != null) {
      return a(localMusicItemInfo, false, paramInt3);
    }
    return false;
  }
  
  public boolean a(MusicItemInfo paramMusicItemInfo)
  {
    if (!b(paramMusicItemInfo)) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == paramMusicItemInfo) && (a()))
    {
      QLog.i("QimMusicPlayer", 1, "have playing" + paramMusicItemInfo);
      return false;
    }
    if ((this.jdField_a_of_type_DovComQqImCaptureMusicMusicMuteListener != null) && ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.c() != paramMusicItemInfo.c()))) {
      this.jdField_a_of_type_DovComQqImCaptureMusicMusicMuteListener.a(paramMusicItemInfo.c());
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((MusicPlayerSceneListener)localIterator.next()).a(paramMusicItemInfo);
      }
    }
    e();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerScene = a(paramMusicItemInfo);
    return true;
  }
  
  public boolean a(MusicItemInfo paramMusicItemInfo, int paramInt)
  {
    return a(paramMusicItemInfo, false, paramInt);
  }
  
  public boolean a(MusicItemInfo paramMusicItemInfo, MusicDownloadListener paramMusicDownloadListener)
  {
    String str;
    if ((!b(paramMusicItemInfo)) && (paramMusicItemInfo != null))
    {
      str = paramMusicItemInfo.a();
      if (!TextUtils.isEmpty(str)) {}
    }
    else
    {
      return false;
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(str))
    {
      paramMusicItemInfo.jdField_c_of_type_Int = 0;
      paramMusicDownloadListener = new QQMusicDownloadListener(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap, this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap, paramMusicDownloadListener);
      DownloadTask localDownloadTask = QQMusicDownloader.a(paramMusicItemInfo.jdField_c_of_type_JavaLangString, str, paramMusicDownloadListener);
      if (localDownloadTask != null)
      {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localDownloadTask);
        QQMusicDownloader.a(localDownloadTask, paramMusicDownloadListener);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramMusicItemInfo);
      }
    }
    return true;
  }
  
  public boolean a(MusicItemInfo paramMusicItemInfo, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QimMusicPlayer", 2, "requestPlay " + paramInt + " " + this.jdField_b_of_type_Int);
    }
    this.jdField_b_of_type_Int = paramInt;
    if (!b(paramMusicItemInfo)) {}
    while (DanceGameVideoManager.a().c()) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == paramMusicItemInfo) && (a()) && (!paramBoolean))
    {
      QLog.i("QimMusicPlayer", 1, "have playing" + paramMusicItemInfo);
      return false;
    }
    if ((this.jdField_a_of_type_DovComQqImCaptureMusicMusicMuteListener != null) && ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.c() != paramMusicItemInfo.c()))) {
      this.jdField_a_of_type_DovComQqImCaptureMusicMusicMuteListener.a(paramMusicItemInfo.c());
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((MusicPlayerSceneListener)localIterator.next()).a(paramMusicItemInfo);
      }
    }
    e();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = paramMusicItemInfo;
    this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerScene = a(paramMusicItemInfo);
    g();
    return true;
  }
  
  public MusicItemInfo b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.d != 5) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.d != 1)) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    this.jdField_a_of_type_DovComQqImCaptureMusicMusicMuteListener = null;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerScene = null;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((MusicPlayerScene)localIterator.next()).f();
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicWaveformManager.a();
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicWaveformManager = null;
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QimMusicPlayer", 2, "pauseMusicCheckScene " + paramInt + " " + this.jdField_b_of_type_Int);
    }
    if (paramInt != this.jdField_b_of_type_Int) {}
    while (this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerScene == null) {
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerScene.c();
  }
  
  public void b(MusicPlayerSceneListener paramMusicPlayerSceneListener)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(paramMusicPlayerSceneListener))) {
      this.jdField_a_of_type_JavaUtilList.remove(paramMusicPlayerSceneListener);
    }
  }
  
  public boolean b()
  {
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if (j == QQFilterRenderManagerHolder.jdField_a_of_type_Int) {
      i = QQFilterRenderManagerHolder.a();
    }
    QQFilterRenderManager localQQFilterRenderManager = QQFilterRenderManagerHolder.a(i);
    FilterDesc localFilterDesc = null;
    if (localQQFilterRenderManager != null) {
      localFilterDesc = localQQFilterRenderManager.a(2);
    }
    return (localFilterDesc != null) && (QQAVImageFilterConstants.a(localFilterDesc.jdField_b_of_type_Int));
  }
  
  public boolean b(MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo == null) {}
    while (((paramMusicItemInfo.d == 5) || (paramMusicItemInfo.d == 1)) && (!FileUtils.b(paramMusicItemInfo.a()))) {
      return false;
    }
    return true;
  }
  
  public MusicItemInfo c()
  {
    return this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerScene != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((MusicPlayerSceneListener)localIterator.next()).a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
        }
      }
      this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerScene.b();
      f();
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerScene != null) {
      this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerScene.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerScene != null) {
      this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerScene.c();
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void e()
  {
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = null;
    if (this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerScene != null) {
      this.jdField_a_of_type_DovComQqImCaptureMusicMusicPlayerScene.e();
    }
  }
  
  public void f()
  {
    MusicItemInfo localMusicItemInfo = b();
    if (localMusicItemInfo == null) {}
    label9:
    QQFilterRenderManager localQQFilterRenderManager;
    do
    {
      do
      {
        break label9;
        do
        {
          return;
        } while (this.jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicWaveformManager == null);
        int j = this.jdField_a_of_type_Int;
        int i = j;
        if (j == QQFilterRenderManagerHolder.jdField_a_of_type_Int) {
          i = QQFilterRenderManagerHolder.a();
        }
        localQQFilterRenderManager = QQFilterRenderManagerHolder.a(i);
        if ((localMusicItemInfo.b()) && (b()))
        {
          if (a()) {}
          for (i = a() - localMusicItemInfo.e;; i = 0)
          {
            this.jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicWaveformManager.a(localMusicItemInfo, i);
            if (localQQFilterRenderManager == null) {
              break;
            }
            localQQFilterRenderManager.a(this);
            return;
          }
        }
      } while ((!localMusicItemInfo.b()) && (!b()));
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicWaveformManager.a();
    } while (localQQFilterRenderManager == null);
    localQQFilterRenderManager.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QimMusicPlayer
 * JD-Core Version:    0.7.0.1
 */