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

public class spq
  extends tby
  implements tcl
{
  private volatile int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private spi jdField_a_of_type_Spi;
  private tcv jdField_a_of_type_Tcv;
  wxu jdField_a_of_type_Wxu = null;
  
  public static String a(@NonNull List<sqb> paramList)
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
      switch (((sqb)paramList.next()).jdField_a_of_type_Int)
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
  
  public static List<srg> a(@NonNull HashMap<String, sqa> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList(paramHashMap.size());
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      sqa localsqa = (sqa)((Map.Entry)paramHashMap.next()).getValue();
      if (localsqa.a != null) {
        localArrayList.add(localsqa.a);
      }
    }
    return localArrayList;
  }
  
  public static List<sqc> a(sqb paramsqb, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramsqb.a();
    if (localList.size() < paramInt)
    {
      localArrayList.addAll(localList);
      localObject1 = localList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((sqc)((Iterator)localObject1).next()).a(true);
      }
      paramsqb.a(localList);
      return localArrayList;
    }
    Object localObject1 = localList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (sqc)((Iterator)localObject1).next();
      if (((sqc)localObject2).a()) {
        ((sqc)localObject2).a(false);
      }
    }
    localObject1 = new srl();
    ((srl)localObject1).a(localList);
    localObject1 = ((srl)localObject1).a(paramInt, null, 0).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (List)((Iterator)localObject1).next();
      ((sqc)((List)localObject2).get(0)).a(true);
      localArrayList.add(((List)localObject2).get(0));
    }
    paramsqb.a(localList);
    return localArrayList;
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "saveScanTime lastDateAlbumTime=" + paramLong1 + " ,lastScanPictureTime=" + paramLong2);
    tcv localtcv = (tcv)tdc.a(10);
    localtcv.b("key_last_pic_scan_time", Long.valueOf(paramLong2));
    localtcv.b("key_last_date_album_time", Long.valueOf(paramLong1));
    localtcv.b("key_story_home_scan_time", Long.valueOf(paramLong2));
  }
  
  public static void a(List<sqb> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    Collections.sort(paramList, new sps());
  }
  
  private void a(sqp paramsqp)
  {
    Object localObject1 = (tcv)tdc.a(10);
    if ((TextUtils.isEmpty(paramsqp.a)) || (TextUtils.isEmpty(paramsqp.b)))
    {
      localObject2 = (String)((tcv)localObject1).b("key_album_debug_k", "");
      localObject1 = (String)((tcv)localObject1).b("key_album_debug_sse", "");
      veg.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "保存K means 的调试信息失败:" + paramsqp.a + " 和 " + paramsqp.b);
      veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + (String)localObject1 + " time info:" + (String)localObject2);
      return;
    }
    if (paramsqp.a())
    {
      ((tcv)localObject1).b("key_album_debug_k", paramsqp.a);
      ((tcv)localObject1).b("key_album_debug_sse", paramsqp.b);
      veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + paramsqp.b + " time info:" + paramsqp.a);
      return;
    }
    Object localObject2 = paramsqp.a.split(";");
    paramsqp = paramsqp.b.split(";");
    ((tcv)localObject1).b("key_album_debug_k", localObject2[0]);
    ((tcv)localObject1).b("key_album_debug_sse", paramsqp[0]);
    veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "sp K means debug sse info:" + paramsqp[0] + " time info:" + localObject2[0]);
  }
  
  public static void b(@NonNull List<sqc> paramList)
  {
    Collections.sort(paramList, new spt());
  }
  
  public List<sqb> a()
  {
    ArrayList localArrayList = new ArrayList();
    tcv localtcv = (tcv)tdc.a(10);
    long l = ((Long)localtcv.b("key_last_home_time", Long.valueOf(-1L))).longValue();
    aukn localaukn = QQStoryContext.a().a().createEntityManager();
    Object localObject = tcz.a(localaukn, StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), "state=0 ", null, "startTime desc");
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return localArrayList;
    }
    veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum : new album time=%s,last time=%d", new Object[] { Long.valueOf(((StoryAlbumEntry)((List)localObject).get(0)).startTime), Long.valueOf(l) });
    if (((StoryAlbumEntry)((List)localObject).get(0)).startTime <= l) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbumEntry localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
      sqb localsqb;
      try
      {
        localsqb = sqb.a(localStoryAlbumEntry);
        if (!localsqb.c()) {
          break label241;
        }
        localArrayList.add(localsqb);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        vxs.a("getNewStoryAlbum DB info have error:" + localInvalidProtocolBufferMicroException, new Object[0]);
      }
      continue;
      label241:
      veg.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum we find the illegal album and deleted it : " + localsqb);
      localInvalidProtocolBufferMicroException.setStatus(1001);
      localaukn.b(localInvalidProtocolBufferMicroException);
    }
    veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewStoryAlbum reslut=%s", new Object[] { localArrayList });
    if (localArrayList.isEmpty()) {
      return localArrayList;
    }
    if (((sqb)localArrayList.get(0)).f() <= l)
    {
      localArrayList.clear();
      return localArrayList;
    }
    localtcv.b("key_last_home_time", Long.valueOf(((sqb)localArrayList.get(0)).f()));
    return localArrayList;
  }
  
  public List<spv> a(long paramLong1, long paramLong2)
  {
    return this.jdField_a_of_type_Spi.a(paramLong1, paramLong2);
  }
  
  @NonNull
  public List<sqc> a(Context paramContext)
  {
    tcv localtcv = (tcv)tdc.a(10);
    long l = ((Long)localtcv.b("key_story_home_scan_time", Long.valueOf(-1L))).longValue();
    paramContext = a(paramContext, Math.max(System.currentTimeMillis() / 1000L - 259200L, l));
    veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewScanPicList  result=" + paramContext);
    if (paramContext.size() >= 10)
    {
      localtcv.b("key_story_home_scan_time", Long.valueOf(((sqc)paramContext.get(0)).b));
      return paramContext;
    }
    return null;
  }
  
  @NonNull
  public List<sqc> a(Context paramContext, long paramLong)
  {
    veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getNewPicList scan time = " + paramLong);
    new ArrayList();
    return new sph().a(paramContext, 1L + paramLong, false, 500);
  }
  
  public spi a()
  {
    return this.jdField_a_of_type_Spi;
  }
  
  public void a()
  {
    ((tdi)tdc.a(26)).a(this);
    this.jdField_a_of_type_Tcv = ((tcv)tdc.a(10));
    this.jdField_a_of_type_Wxu = wxu.a();
    this.jdField_a_of_type_Wxu.a();
    this.jdField_a_of_type_Spi = new spi();
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
        veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "trimMemory to be 5");
      } while (Build.VERSION.SDK_INT < 17);
      return;
    }
    veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "clearAllMemory");
  }
  
  public void a(boolean paramBoolean)
  {
    int j = 2;
    Object localObject = this.jdField_a_of_type_Wxu;
    if (paramBoolean)
    {
      i = 2;
      ((wxu)localObject).b(i);
      localObject = (tcv)tdc.a(10);
      if (!paramBoolean) {
        break label54;
      }
    }
    label54:
    for (int i = j;; i = 1)
    {
      ((tcv)localObject).b("sp_key_user_enable_album_scan", Integer.valueOf(i));
      return;
      i = 1;
      break;
    }
  }
  
  public boolean a()
  {
    int i = ((Integer)this.jdField_a_of_type_Tcv.b("sp_key_user_enable_album_scan", Integer.valueOf(0))).intValue();
    if ((i == 0) || (i == -1)) {
      return this.jdField_a_of_type_Spi.b();
    }
    return i != 1;
  }
  
  public boolean a(long paramLong)
  {
    veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "deletedAlbumById=" + paramLong);
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      vxs.a(bool, "It is not allowed to deleted the id<0");
      aukn localaukn = QQStoryContext.a().a().createEntityManager();
      StoryAlbumEntry localStoryAlbumEntry = new StoryAlbumEntry();
      localStoryAlbumEntry.setId(paramLong);
      localStoryAlbumEntry.setStatus(1001);
      return localaukn.b(localStoryAlbumEntry);
    }
  }
  
  public boolean a(Context paramContext)
  {
    boolean bool2;
    if ((this.jdField_a_of_type_Spi != null) && (this.jdField_a_of_type_Spi.a()))
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
          veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "isAlbumModuleEnable :%s , isVersionOk :%s , isStoragePermitOk :%s , isConfigOk :%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
    return this.jdField_a_of_type_Spi.b(paramString);
  }
  
  public boolean a(@NonNull List<sqb> paramList, boolean paramBoolean)
  {
    veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "insertAlbumToDb albums=" + paramList.size() + " append=" + paramBoolean);
    boolean bool;
    if (!paramList.isEmpty()) {
      bool = true;
    }
    aukn localaukn;
    for (;;)
    {
      vxs.a(bool, "It is not allow save the empty albums to DB ");
      localaukn = QQStoryContext.a().a().createEntityManager();
      localaukn.a().a();
      if (!paramBoolean) {
        localaukn.a(StoryAlbumEntry.class);
      }
      try
      {
        paramList = paramList.iterator();
        for (;;)
        {
          if (!paramList.hasNext()) {
            break label226;
          }
          sqb localsqb = (sqb)paramList.next();
          localStoryAlbumEntry = localsqb.a();
          if (localStoryAlbumEntry.getId() <= 0L) {
            break;
          }
          localStoryAlbumEntry.setStatus(1001);
          if (!localaukn.a(localStoryAlbumEntry))
          {
            localStoryAlbumEntry.setStatus(1000);
            localaukn.b(localStoryAlbumEntry);
          }
          localsqb.a(localStoryAlbumEntry.getId());
        }
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          StoryAlbumEntry localStoryAlbumEntry;
          veg.c("Q.qqstory.recommendAlbum.logic.StoryScanManager", "insertAlbumToDb exception=%s", paramList);
          return false;
          bool = false;
          break;
          localaukn.b(localStoryAlbumEntry);
        }
      }
      finally
      {
        localaukn.a().b();
      }
    }
    label226:
    localaukn.a().c();
    localaukn.a().b();
    return true;
  }
  
  public boolean a(sqb paramsqb)
  {
    veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "deletedAlbumById=" + paramsqb);
    aukn localaukn = QQStoryContext.a().a().createEntityManager();
    paramsqb = paramsqb.a();
    paramsqb.setStatus(1001);
    return localaukn.a(paramsqb);
  }
  
  public List<sqb> b()
  {
    ArrayList localArrayList = new ArrayList();
    aukn localaukn = QQStoryContext.a().a().createEntityManager();
    Object localObject = tcz.a(localaukn, StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbumEntry localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
      sqb localsqb;
      try
      {
        localsqb = sqb.a(localStoryAlbumEntry);
        if (!localsqb.c()) {
          break label144;
        }
        if (localsqb.c() < 2) {
          a(localsqb, 10);
        }
        localArrayList.add(localsqb);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        vxs.a("DB info have error:" + localInvalidProtocolBufferMicroException, new Object[0]);
      }
      continue;
      label144:
      veg.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getAlbumListFromDB we find the illegal album and deleted it : " + localsqb);
      localInvalidProtocolBufferMicroException.setStatus(1001);
      localaukn.b(localInvalidProtocolBufferMicroException);
    }
    a(localArrayList);
    veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "getAlbumListFromDB reslut=" + localArrayList);
    return localArrayList;
  }
  
  public void b()
  {
    ((tdi)tdc.a(26)).b(this);
    this.jdField_a_of_type_Wxu.b();
  }
  
  public boolean b(Context paramContext)
  {
    if (a(paramContext)) {
      return this.jdField_a_of_type_Spi.c();
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_Spi.a(paramString);
  }
  
  public List<sra> c()
  {
    return this.jdField_a_of_type_Spi.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Spi.a();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan task is running so ignore this request.");
      return;
    }
    veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "start scan");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Int = 1;
    sqp localsqp = new sqp();
    Context localContext = QQStoryContext.a().a().getBaseContext();
    Stream.of(Integer.valueOf(0)).map(new ThreadOffFunction("Q.qqstory.recommendAlbum.logic.StoryScanManager", 2)).map(new sqn(localContext, localsqp)).map(new sqo(localsqp)).map(new sqm(localsqp)).map(new sql(localsqp)).subscribe(new spr(this, localsqp));
  }
  
  public void e()
  {
    this.jdField_a_of_type_Spi.c();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Spi.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     spq
 * JD-Core Version:    0.7.0.1
 */