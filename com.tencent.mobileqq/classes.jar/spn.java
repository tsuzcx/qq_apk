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

public class spn
  extends tbv
  implements tci
{
  private volatile int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private spf jdField_a_of_type_Spf;
  private tcs jdField_a_of_type_Tcs;
  wxr jdField_a_of_type_Wxr = null;
  
  public static String a(@NonNull List<spy> paramList)
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
      switch (((spy)paramList.next()).jdField_a_of_type_Int)
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
  
  public static List<srd> a(@NonNull HashMap<String, spx> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList(paramHashMap.size());
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      spx localspx = (spx)((Map.Entry)paramHashMap.next()).getValue();
      if (localspx.a != null) {
        localArrayList.add(localspx.a);
      }
    }
    return localArrayList;
  }
  
  public static List<spz> a(spy paramspy, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramspy.a();
    if (localList.size() < paramInt)
    {
      localArrayList.addAll(localList);
      localObject1 = localList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((spz)((Iterator)localObject1).next()).a(true);
      }
      paramspy.a(localList);
      return localArrayList;
    }
    Object localObject1 = localList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (spz)((Iterator)localObject1).next();
      if (((spz)localObject2).a()) {
        ((spz)localObject2).a(false);
      }
    }
    localObject1 = new sri();
    ((sri)localObject1).a(localList);
    localObject1 = ((sri)localObject1).a(paramInt, null, 0).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (List)((Iterator)localObject1).next();
      ((spz)((List)localObject2).get(0)).a(true);
      localArrayList.add(((List)localObject2).get(0));
    }
    paramspy.a(localList);
    return localArrayList;
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "saveScanTime lastDateAlbumTime=" + paramLong1 + " ,lastScanPictureTime=" + paramLong2);
    tcs localtcs = (tcs)tcz.a(10);
    localtcs.b("key_last_pic_scan_time", Long.valueOf(paramLong2));
    localtcs.b("key_last_date_album_time", Long.valueOf(paramLong1));
    localtcs.b("key_story_home_scan_time", Long.valueOf(paramLong2));
  }
  
  public static void a(List<spy> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    Collections.sort(paramList, new spp());
  }
  
  private void a(sqm paramsqm)
  {
    Object localObject1 = (tcs)tcz.a(10);
    if ((TextUtils.isEmpty(paramsqm.a)) || (TextUtils.isEmpty(paramsqm.b)))
    {
      localObject2 = (String)((tcs)localObject1).b("key_album_debug_k", "");
      localObject1 = (String)((tcs)localObject1).b("key_album_debug_sse", "");
      ved.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "保存K means 的调试信息失败:" + paramsqm.a + " 和 " + paramsqm.b);
      ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + (String)localObject1 + " time info:" + (String)localObject2);
      return;
    }
    if (paramsqm.a())
    {
      ((tcs)localObject1).b("key_album_debug_k", paramsqm.a);
      ((tcs)localObject1).b("key_album_debug_sse", paramsqm.b);
      ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + paramsqm.b + " time info:" + paramsqm.a);
      return;
    }
    Object localObject2 = paramsqm.a.split(";");
    paramsqm = paramsqm.b.split(";");
    ((tcs)localObject1).b("key_album_debug_k", localObject2[0]);
    ((tcs)localObject1).b("key_album_debug_sse", paramsqm[0]);
    ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + paramsqm[0] + " time info:" + localObject2[0]);
  }
  
  public static void b(@NonNull List<spz> paramList)
  {
    Collections.sort(paramList, new spq());
  }
  
  public List<spy> a()
  {
    ArrayList localArrayList = new ArrayList();
    tcs localtcs = (tcs)tcz.a(10);
    long l = ((Long)localtcs.b("key_last_home_time", Long.valueOf(-1L))).longValue();
    aukp localaukp = QQStoryContext.a().a().createEntityManager();
    Object localObject = tcw.a(localaukp, StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), "state=0 ", null, "startTime desc");
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return localArrayList;
    }
    ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum : new album time=%s,last time=%d", new Object[] { Long.valueOf(((StoryAlbumEntry)((List)localObject).get(0)).startTime), Long.valueOf(l) });
    if (((StoryAlbumEntry)((List)localObject).get(0)).startTime <= l) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbumEntry localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
      spy localspy;
      try
      {
        localspy = spy.a(localStoryAlbumEntry);
        if (!localspy.c()) {
          break label241;
        }
        localArrayList.add(localspy);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        vxp.a("getNewStoryAlbum DB info have error:" + localInvalidProtocolBufferMicroException, new Object[0]);
      }
      continue;
      label241:
      ved.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum we find the illegal album and deleted it : " + localspy);
      localInvalidProtocolBufferMicroException.setStatus(1001);
      localaukp.b(localInvalidProtocolBufferMicroException);
    }
    ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum reslut=%s", new Object[] { localArrayList });
    if (localArrayList.isEmpty()) {
      return localArrayList;
    }
    if (((spy)localArrayList.get(0)).f() <= l)
    {
      localArrayList.clear();
      return localArrayList;
    }
    localtcs.b("key_last_home_time", Long.valueOf(((spy)localArrayList.get(0)).f()));
    return localArrayList;
  }
  
  public List<sps> a(long paramLong1, long paramLong2)
  {
    return this.jdField_a_of_type_Spf.a(paramLong1, paramLong2);
  }
  
  @NonNull
  public List<spz> a(Context paramContext)
  {
    tcs localtcs = (tcs)tcz.a(10);
    long l = ((Long)localtcs.b("key_story_home_scan_time", Long.valueOf(-1L))).longValue();
    paramContext = a(paramContext, Math.max(System.currentTimeMillis() / 1000L - 259200L, l));
    ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewScanPicList  result=" + paramContext);
    if (paramContext.size() >= 10)
    {
      localtcs.b("key_story_home_scan_time", Long.valueOf(((spz)paramContext.get(0)).b));
      return paramContext;
    }
    return null;
  }
  
  @NonNull
  public List<spz> a(Context paramContext, long paramLong)
  {
    ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewPicList scan time = " + paramLong);
    new ArrayList();
    return new spe().a(paramContext, 1L + paramLong, false, 500);
  }
  
  public spf a()
  {
    return this.jdField_a_of_type_Spf;
  }
  
  public void a()
  {
    ((tdf)tcz.a(26)).a(this);
    this.jdField_a_of_type_Tcs = ((tcs)tcz.a(10));
    this.jdField_a_of_type_Wxr = wxr.a();
    this.jdField_a_of_type_Wxr.a();
    this.jdField_a_of_type_Spf = new spf();
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
        ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "trimMemory to be 5");
      } while (Build.VERSION.SDK_INT < 17);
      return;
    }
    ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "clearAllMemory");
  }
  
  public void a(boolean paramBoolean)
  {
    int j = 2;
    Object localObject = this.jdField_a_of_type_Wxr;
    if (paramBoolean)
    {
      i = 2;
      ((wxr)localObject).b(i);
      localObject = (tcs)tcz.a(10);
      if (!paramBoolean) {
        break label54;
      }
    }
    label54:
    for (int i = j;; i = 1)
    {
      ((tcs)localObject).b("sp_key_user_enable_album_scan", Integer.valueOf(i));
      return;
      i = 1;
      break;
    }
  }
  
  public boolean a()
  {
    int i = ((Integer)this.jdField_a_of_type_Tcs.b("sp_key_user_enable_album_scan", Integer.valueOf(0))).intValue();
    if ((i == 0) || (i == -1)) {
      return this.jdField_a_of_type_Spf.b();
    }
    return i != 1;
  }
  
  public boolean a(long paramLong)
  {
    ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "deletedAlbumById=" + paramLong);
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      vxp.a(bool, "It is not allowed to deleted the id<0");
      aukp localaukp = QQStoryContext.a().a().createEntityManager();
      StoryAlbumEntry localStoryAlbumEntry = new StoryAlbumEntry();
      localStoryAlbumEntry.setId(paramLong);
      localStoryAlbumEntry.setStatus(1001);
      return localaukp.b(localStoryAlbumEntry);
    }
  }
  
  public boolean a(Context paramContext)
  {
    boolean bool2;
    if ((this.jdField_a_of_type_Spf != null) && (this.jdField_a_of_type_Spf.a()))
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
          ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "isAlbumModuleEnable :%s , isVersionOk :%s , isStoragePermitOk :%s , isConfigOk :%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
    return this.jdField_a_of_type_Spf.b(paramString);
  }
  
  public boolean a(@NonNull List<spy> paramList, boolean paramBoolean)
  {
    ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "insertAlbumToDb albums=" + paramList.size() + " append=" + paramBoolean);
    boolean bool;
    if (!paramList.isEmpty()) {
      bool = true;
    }
    aukp localaukp;
    for (;;)
    {
      vxp.a(bool, "It is not allow save the empty albums to DB ");
      localaukp = QQStoryContext.a().a().createEntityManager();
      localaukp.a().a();
      if (!paramBoolean) {
        localaukp.a(StoryAlbumEntry.class);
      }
      try
      {
        paramList = paramList.iterator();
        for (;;)
        {
          if (!paramList.hasNext()) {
            break label226;
          }
          spy localspy = (spy)paramList.next();
          localStoryAlbumEntry = localspy.a();
          if (localStoryAlbumEntry.getId() <= 0L) {
            break;
          }
          localStoryAlbumEntry.setStatus(1001);
          if (!localaukp.a(localStoryAlbumEntry))
          {
            localStoryAlbumEntry.setStatus(1000);
            localaukp.b(localStoryAlbumEntry);
          }
          localspy.a(localStoryAlbumEntry.getId());
        }
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          StoryAlbumEntry localStoryAlbumEntry;
          ved.c("Q.qqstory.recommendAlbum.logic.StoryScanManager", "insertAlbumToDb exception=%s", paramList);
          return false;
          bool = false;
          break;
          localaukp.b(localStoryAlbumEntry);
        }
      }
      finally
      {
        localaukp.a().b();
      }
    }
    label226:
    localaukp.a().c();
    localaukp.a().b();
    return true;
  }
  
  public boolean a(spy paramspy)
  {
    ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "deletedAlbumById=" + paramspy);
    aukp localaukp = QQStoryContext.a().a().createEntityManager();
    paramspy = paramspy.a();
    paramspy.setStatus(1001);
    return localaukp.a(paramspy);
  }
  
  public List<spy> b()
  {
    ArrayList localArrayList = new ArrayList();
    aukp localaukp = QQStoryContext.a().a().createEntityManager();
    Object localObject = tcw.a(localaukp, StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbumEntry localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
      spy localspy;
      try
      {
        localspy = spy.a(localStoryAlbumEntry);
        if (!localspy.c()) {
          break label144;
        }
        if (localspy.c() < 2) {
          a(localspy, 10);
        }
        localArrayList.add(localspy);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        vxp.a("DB info have error:" + localInvalidProtocolBufferMicroException, new Object[0]);
      }
      continue;
      label144:
      ved.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getAlbumListFromDB we find the illegal album and deleted it : " + localspy);
      localInvalidProtocolBufferMicroException.setStatus(1001);
      localaukp.b(localInvalidProtocolBufferMicroException);
    }
    a(localArrayList);
    ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getAlbumListFromDB reslut=" + localArrayList);
    return localArrayList;
  }
  
  public void b()
  {
    ((tdf)tcz.a(26)).b(this);
    this.jdField_a_of_type_Wxr.b();
  }
  
  public boolean b(Context paramContext)
  {
    if (a(paramContext)) {
      return this.jdField_a_of_type_Spf.c();
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_Spf.a(paramString);
  }
  
  public List<sqx> c()
  {
    return this.jdField_a_of_type_Spf.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Spf.a();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan task is running so ignore this request.");
      return;
    }
    ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "start scan");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Int = 1;
    sqm localsqm = new sqm();
    Context localContext = QQStoryContext.a().a().getBaseContext();
    Stream.of(Integer.valueOf(0)).map(new ThreadOffFunction("Q.qqstory.recommendAlbum.logic.StoryScanManager", 2)).map(new sqk(localContext, localsqm)).map(new sql(localsqm)).map(new sqj(localsqm)).map(new sqi(localsqm)).subscribe(new spo(this, localsqm));
  }
  
  public void e()
  {
    this.jdField_a_of_type_Spf.c();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Spf.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     spn
 * JD-Core Version:    0.7.0.1
 */