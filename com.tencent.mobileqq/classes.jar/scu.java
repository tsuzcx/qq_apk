import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.StoryAlbumEntry;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class scu
  extends spc
  implements spp
{
  private volatile int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private scm jdField_a_of_type_Scm;
  private spz jdField_a_of_type_Spz;
  wis jdField_a_of_type_Wis = null;
  
  public static String a(@NonNull List<sdf> paramList)
  {
    if (paramList.isEmpty()) {
      return "";
    }
    paramList = paramList.iterator();
    int n = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    if (paramList.hasNext())
    {
      int i1;
      int i2;
      switch (((sdf)paramList.next()).jdField_a_of_type_Int)
      {
      case 5: 
      default: 
        i1 = n;
        i2 = m;
        n = i;
        m = j;
        j = i2;
        i = i1;
      }
      for (;;)
      {
        i1 = n;
        i2 = m;
        n = i;
        m = j;
        j = i2;
        i = i1;
        break;
        i1 = j;
        i2 = i + 1;
        i = n;
        j = m;
        m = i1;
        n = i2;
        continue;
        i2 = j + 1;
        i1 = i;
        i = n;
        j = m;
        m = i2;
        n = i1;
        continue;
        k += 1;
        i1 = j;
        i2 = i;
        i = n;
        j = m;
        m = i1;
        n = i2;
        continue;
        i2 = m + 1;
        m = j;
        i1 = i;
        i = n;
        j = i2;
        n = i1;
        continue;
        i2 = n + 1;
        n = j;
        i1 = i;
        i = i2;
        j = m;
        m = n;
        n = i1;
      }
    }
    paramList = new StringBuilder("{");
    paramList.append("\"festival\":").append(i).append(",");
    paramList.append("\"birthday\":").append(j).append(",");
    paramList.append("\"frequent\":").append(k).append(",");
    paramList.append("\"unfrequent\":").append(m).append(",");
    paramList.append("\"aboard\":").append(n).append(",");
    paramList.append("}");
    return paramList.toString();
  }
  
  public static List<sek> a(@NonNull HashMap<String, sde> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList(paramHashMap.size());
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      sde localsde = (sde)((Map.Entry)paramHashMap.next()).getValue();
      if (localsde.a != null) {
        localArrayList.add(localsde.a);
      }
    }
    return localArrayList;
  }
  
  public static List<sdg> a(sdf paramsdf, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramsdf.a();
    if (localList.size() < paramInt)
    {
      localArrayList.addAll(localList);
      localObject1 = localList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((sdg)((Iterator)localObject1).next()).a(true);
      }
      paramsdf.a(localList);
      return localArrayList;
    }
    Object localObject1 = localList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (sdg)((Iterator)localObject1).next();
      if (((sdg)localObject2).a()) {
        ((sdg)localObject2).a(false);
      }
    }
    localObject1 = new sep();
    ((sep)localObject1).a(localList);
    localObject1 = ((sep)localObject1).a(paramInt, null, 0).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (List)((Iterator)localObject1).next();
      ((sdg)((List)localObject2).get(0)).a(true);
      localArrayList.add(((List)localObject2).get(0));
    }
    paramsdf.a(localList);
    return localArrayList;
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "saveScanTime lastDateAlbumTime=" + paramLong1 + " ,lastScanPictureTime=" + paramLong2);
    spz localspz = (spz)sqg.a(10);
    localspz.b("key_last_pic_scan_time", Long.valueOf(paramLong2));
    localspz.b("key_last_date_album_time", Long.valueOf(paramLong1));
    localspz.b("key_story_home_scan_time", Long.valueOf(paramLong2));
  }
  
  public static void a(List<sdf> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    Collections.sort(paramList, new scw());
  }
  
  private void a(sdt paramsdt)
  {
    Object localObject1 = (spz)sqg.a(10);
    if ((TextUtils.isEmpty(paramsdt.a)) || (TextUtils.isEmpty(paramsdt.b)))
    {
      localObject2 = (String)((spz)localObject1).b("key_album_debug_k", "");
      localObject1 = (String)((spz)localObject1).b("key_album_debug_sse", "");
      urk.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "保存K means 的调试信息失败:" + paramsdt.a + " 和 " + paramsdt.b);
      urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + (String)localObject1 + " time info:" + (String)localObject2);
      return;
    }
    if (paramsdt.a())
    {
      ((spz)localObject1).b("key_album_debug_k", paramsdt.a);
      ((spz)localObject1).b("key_album_debug_sse", paramsdt.b);
      urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + paramsdt.b + " time info:" + paramsdt.a);
      return;
    }
    Object localObject2 = paramsdt.a.split(";");
    paramsdt = paramsdt.b.split(";");
    ((spz)localObject1).b("key_album_debug_k", localObject2[0]);
    ((spz)localObject1).b("key_album_debug_sse", paramsdt[0]);
    urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + paramsdt[0] + " time info:" + localObject2[0]);
  }
  
  public static void b(@NonNull List<sdg> paramList)
  {
    Collections.sort(paramList, new scx());
  }
  
  public List<sdf> a()
  {
    ArrayList localArrayList = new ArrayList();
    spz localspz = (spz)sqg.a(10);
    long l = ((Long)localspz.b("key_last_home_time", Long.valueOf(-1L))).longValue();
    atmp localatmp = QQStoryContext.a().a().createEntityManager();
    Object localObject = sqd.a(localatmp, StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), "state=0 ", null, "startTime desc");
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return localArrayList;
    }
    urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum : new album time=%s,last time=%d", new Object[] { Long.valueOf(((StoryAlbumEntry)((List)localObject).get(0)).startTime), Long.valueOf(l) });
    if (((StoryAlbumEntry)((List)localObject).get(0)).startTime <= l) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbumEntry localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
      sdf localsdf;
      try
      {
        localsdf = sdf.a(localStoryAlbumEntry);
        if (!localsdf.c()) {
          break label241;
        }
        localArrayList.add(localsdf);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        vkw.a("getNewStoryAlbum DB info have error:" + localInvalidProtocolBufferMicroException, new Object[0]);
      }
      continue;
      label241:
      urk.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum we find the illegal album and deleted it : " + localsdf);
      localInvalidProtocolBufferMicroException.setStatus(1001);
      localatmp.b(localInvalidProtocolBufferMicroException);
    }
    urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum reslut=%s", new Object[] { localArrayList });
    if (localArrayList.isEmpty()) {
      return localArrayList;
    }
    if (((sdf)localArrayList.get(0)).f() <= l)
    {
      localArrayList.clear();
      return localArrayList;
    }
    localspz.b("key_last_home_time", Long.valueOf(((sdf)localArrayList.get(0)).f()));
    return localArrayList;
  }
  
  public List<scz> a(long paramLong1, long paramLong2)
  {
    return this.jdField_a_of_type_Scm.a(paramLong1, paramLong2);
  }
  
  @NonNull
  public List<sdg> a(Context paramContext)
  {
    spz localspz = (spz)sqg.a(10);
    long l = ((Long)localspz.b("key_story_home_scan_time", Long.valueOf(-1L))).longValue();
    paramContext = a(paramContext, Math.max(System.currentTimeMillis() / 1000L - 259200L, l));
    urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewScanPicList  result=" + paramContext);
    if (paramContext.size() >= 10)
    {
      localspz.b("key_story_home_scan_time", Long.valueOf(((sdg)paramContext.get(0)).b));
      return paramContext;
    }
    return null;
  }
  
  @NonNull
  public List<sdg> a(Context paramContext, long paramLong)
  {
    urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewPicList scan time = " + paramLong);
    new ArrayList();
    return new scl().a(paramContext, 1L + paramLong, false, 500);
  }
  
  public scm a()
  {
    return this.jdField_a_of_type_Scm;
  }
  
  public void a()
  {
    ((sqm)sqg.a(26)).a(this);
    this.jdField_a_of_type_Spz = ((spz)sqg.a(10));
    this.jdField_a_of_type_Wis = wis.a();
    this.jdField_a_of_type_Wis.a();
    this.jdField_a_of_type_Scm = new scm();
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
    case 1: 
      do
      {
        return;
        urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "trimMemory to be 5");
      } while (Build.VERSION.SDK_INT < 17);
      return;
    }
    urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "clearAllMemory");
  }
  
  public void a(boolean paramBoolean)
  {
    int j = 2;
    Object localObject = this.jdField_a_of_type_Wis;
    if (paramBoolean)
    {
      i = 2;
      ((wis)localObject).b(i);
      localObject = (spz)sqg.a(10);
      if (!paramBoolean) {
        break label54;
      }
    }
    label54:
    for (int i = j;; i = 1)
    {
      ((spz)localObject).b("sp_key_user_enable_album_scan", Integer.valueOf(i));
      return;
      i = 1;
      break;
    }
  }
  
  public boolean a()
  {
    int i = ((Integer)this.jdField_a_of_type_Spz.b("sp_key_user_enable_album_scan", Integer.valueOf(0))).intValue();
    if ((i == 0) || (i == -1)) {
      return this.jdField_a_of_type_Scm.b();
    }
    return i != 1;
  }
  
  public boolean a(long paramLong)
  {
    urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "deletedAlbumById=" + paramLong);
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      vkw.a(bool, "It is not allowed to deleted the id<0");
      atmp localatmp = QQStoryContext.a().a().createEntityManager();
      StoryAlbumEntry localStoryAlbumEntry = new StoryAlbumEntry();
      localStoryAlbumEntry.setId(paramLong);
      localStoryAlbumEntry.setStatus(1001);
      return localatmp.b(localStoryAlbumEntry);
    }
  }
  
  public boolean a(Context paramContext)
  {
    boolean bool2;
    if ((this.jdField_a_of_type_Scm != null) && (this.jdField_a_of_type_Scm.a()))
    {
      bool2 = true;
      if (Build.VERSION.SDK_INT < 18) {
        break label132;
      }
    }
    label132:
    for (boolean bool3 = true;; bool3 = false)
    {
      boolean bool1;
      if (Build.VERSION.SDK_INT >= 23) {
        if (paramContext.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
          bool1 = true;
        }
      }
      for (;;)
      {
        label50:
        if ((bool3) && (bool1) && (bool2)) {}
        for (boolean bool4 = true;; bool4 = false)
        {
          urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "isAlbumModuleEnable :%s , isVersionOk :%s , isStoragePermitOk :%s , isConfigOk :%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          return bool4;
          bool2 = false;
          break;
          bool1 = false;
          break label50;
        }
        bool1 = true;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_Scm.b(paramString);
  }
  
  public boolean a(@NonNull List<sdf> paramList, boolean paramBoolean)
  {
    urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "insertAlbumToDb albums=" + paramList.size() + " append=" + paramBoolean);
    boolean bool;
    if (!paramList.isEmpty()) {
      bool = true;
    }
    atmp localatmp;
    for (;;)
    {
      vkw.a(bool, "It is not allow save the empty albums to DB ");
      localatmp = QQStoryContext.a().a().createEntityManager();
      localatmp.a().a();
      if (!paramBoolean) {
        localatmp.a(StoryAlbumEntry.class);
      }
      try
      {
        paramList = paramList.iterator();
        for (;;)
        {
          if (!paramList.hasNext()) {
            break label226;
          }
          sdf localsdf = (sdf)paramList.next();
          localStoryAlbumEntry = localsdf.a();
          if (localStoryAlbumEntry.getId() <= 0L) {
            break;
          }
          localStoryAlbumEntry.setStatus(1001);
          if (!localatmp.a(localStoryAlbumEntry))
          {
            localStoryAlbumEntry.setStatus(1000);
            localatmp.b(localStoryAlbumEntry);
          }
          localsdf.a(localStoryAlbumEntry.getId());
        }
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          StoryAlbumEntry localStoryAlbumEntry;
          urk.c("Q.qqstory.recommendAlbum.logic.StoryScanManager", "insertAlbumToDb exception=%s", paramList);
          return false;
          bool = false;
          break;
          localatmp.b(localStoryAlbumEntry);
        }
      }
      finally
      {
        localatmp.a().b();
      }
    }
    label226:
    localatmp.a().c();
    localatmp.a().b();
    return true;
  }
  
  public boolean a(sdf paramsdf)
  {
    urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "deletedAlbumById=" + paramsdf);
    atmp localatmp = QQStoryContext.a().a().createEntityManager();
    paramsdf = paramsdf.a();
    paramsdf.setStatus(1001);
    return localatmp.a(paramsdf);
  }
  
  public List<sdf> b()
  {
    ArrayList localArrayList = new ArrayList();
    atmp localatmp = QQStoryContext.a().a().createEntityManager();
    Object localObject = sqd.a(localatmp, StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbumEntry localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
      sdf localsdf;
      try
      {
        localsdf = sdf.a(localStoryAlbumEntry);
        if (!localsdf.c()) {
          break label144;
        }
        if (localsdf.c() < 2) {
          a(localsdf, 10);
        }
        localArrayList.add(localsdf);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        vkw.a("DB info have error:" + localInvalidProtocolBufferMicroException, new Object[0]);
      }
      continue;
      label144:
      urk.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getAlbumListFromDB we find the illegal album and deleted it : " + localsdf);
      localInvalidProtocolBufferMicroException.setStatus(1001);
      localatmp.b(localInvalidProtocolBufferMicroException);
    }
    a(localArrayList);
    urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getAlbumListFromDB reslut=" + localArrayList);
    return localArrayList;
  }
  
  public void b()
  {
    ((sqm)sqg.a(26)).b(this);
    this.jdField_a_of_type_Wis.b();
  }
  
  public boolean b(Context paramContext)
  {
    if (a(paramContext)) {
      return this.jdField_a_of_type_Scm.c();
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_Scm.a(paramString);
  }
  
  public List<see> c()
  {
    return this.jdField_a_of_type_Scm.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Scm.a();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan task is running so ignore this request.");
      return;
    }
    urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "start scan");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Int = 1;
    sdt localsdt = new sdt();
    Context localContext = QQStoryContext.a().a().getBaseContext();
    Stream.of(Integer.valueOf(0)).map(new ThreadOffFunction("Q.qqstory.recommendAlbum.logic.StoryScanManager", 2)).map(new sdr(localContext, localsdt)).map(new sds(localsdt)).map(new sdq(localsdt)).map(new sdp(localsdt)).subscribe(new scv(this, localsdt));
  }
  
  public void e()
  {
    this.jdField_a_of_type_Scm.c();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Scm.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     scu
 * JD-Core Version:    0.7.0.1
 */