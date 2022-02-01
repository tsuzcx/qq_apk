package com.tencent.mobileqq.colornote.api.impl;

import android.content.ContentValues;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.colornote.ColorNoteConstants;
import com.tencent.mobileqq.colornote.api.IColorNoteDataService;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteConfBean;
import com.tencent.mobileqq.colornote.data.ColorNoteConfigProcessor;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.colornote.data.IColorNoteListener;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@KeepClassConstructor
public class ColorNoteDataServiceImpl
  implements IColorNoteDataService
{
  private static final Object CACHE_LOCK = new Object();
  public static final int COLOR_NOTE_OP_ADD = 1;
  public static final int COLOR_NOTE_OP_DEL = 2;
  private static final String TAG = "ColorNoteProxy";
  private AppRuntime mAppRuntime;
  protected List<ColorNote> mCache = new ArrayList();
  ArrayList<IColorNoteListener> mColorNoteListener;
  private Comparator<ColorNote> mComparator = new ColorNoteDataServiceImpl.1(this);
  private EntityManager mEntityManager;
  
  private int judgeColorNotePosition(ColorNote paramColorNote1, ColorNote paramColorNote2)
  {
    long l = paramColorNote1.mTime - paramColorNote2.mTime;
    if (l == 0L) {
      return 0;
    }
    if (l < 0L) {
      return 1;
    }
    return -1;
  }
  
  private void notifyColorNoteOp(int paramInt, ColorNote paramColorNote)
  {
    ArrayList localArrayList = this.mColorNoteListener;
    if (localArrayList == null) {
      return;
    }
    localArrayList = (ArrayList)localArrayList.clone();
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (paramInt == 1) {
        ((IColorNoteListener)localArrayList.get(i)).a(paramColorNote);
      } else if (paramInt == 2) {
        ((IColorNoteListener)localArrayList.get(i)).b(paramColorNote);
      }
      i += 1;
    }
  }
  
  protected void add(ColorNote paramColorNote)
  {
    EntityManager localEntityManager = this.mEntityManager;
    if (localEntityManager != null) {
      localEntityManager.persist(paramColorNote);
    }
    notifyColorNoteOp(1, paramColorNote);
  }
  
  public boolean addColorNote(String paramString, ColorNote paramColorNote, ProxyListener paramProxyListener, boolean paramBoolean)
  {
    if ((!filterColorNote(paramColorNote)) && (ColorNoteSmallScreenUtil.b()))
    {
      if (paramColorNote.getServiceType() == 16973824) {
        ReportController.b(null, "dc00898", "", "", "0X800A746", "0X800A746", 0, 0, "", "", "", "");
      }
      synchronized (CACHE_LOCK)
      {
        if (ColorNoteUtils.b(paramColorNote)) {
          this.mCache.add(0, paramColorNote);
        } else {
          this.mCache.add(paramColorNote);
        }
        if (paramColorNote.getServiceType() != 16973824) {
          saveToDB(paramString, paramColorNote, paramProxyListener, paramBoolean);
        }
        return true;
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("addColorNote error! isAfterSyncMsg = ");
      paramString.append(ColorNoteSmallScreenUtil.b());
      QLog.e("ColorNoteProxy", 2, paramString.toString());
    }
    return false;
  }
  
  protected void addSync(ColorNote paramColorNote)
  {
    add(paramColorNote);
  }
  
  protected void batchDelete(List<ColorNote> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      ThreadManagerV2.excute(new ColorNoteDataServiceImpl.3(this, paramList), 32, null, false);
    }
  }
  
  public boolean canAddColorNote()
  {
    boolean bool = false;
    Object localObject2 = getColorNotes(false);
    int i = ((List)localObject2).size();
    synchronized (CACHE_LOCK)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ColorNote localColorNote = (ColorNote)((Iterator)localObject2).next();
        int j = i;
        if (ColorNoteUtils.b(localColorNote)) {
          j = i - 1;
        }
        i = j;
        if (localColorNote.getServiceType() == 16973824) {
          i = j - 1;
        }
      }
      if (i < ColorNoteConstants.a) {
        bool = true;
      }
      return bool;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public void clearAllUpcomingMindFlag()
  {
    Object localObject2 = this.mCache;
    synchronized (CACHE_LOCK)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ColorNote localColorNote = (ColorNote)((Iterator)localObject2).next();
        if (ColorNoteUtils.c(localColorNote))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("clearAllUpcomingMindFlag ~~ ");
            localStringBuilder.append(localColorNote);
            QLog.d("ColorNoteProxy", 2, localStringBuilder.toString());
          }
          localColorNote.mExtLong &= 0L;
          updateColorNoteFieldByKey(this.mAppRuntime.getCurrentUin(), localColorNote.getUniKey(), "mExtLong", Long.valueOf(localColorNote.mExtLong));
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public ArrayList<ColorNote> deleteAllColorNote(String paramString, ProxyListener paramProxyListener)
  {
    return deleteAllColorNote(paramString, paramProxyListener, 0);
  }
  
  public ArrayList<ColorNote> deleteAllColorNote(String arg1, ProxyListener paramProxyListener, int paramInt)
  {
    paramProxyListener = new ArrayList();
    synchronized (CACHE_LOCK)
    {
      Iterator localIterator = this.mCache.iterator();
      while (localIterator.hasNext())
      {
        ColorNote localColorNote = (ColorNote)localIterator.next();
        if (localColorNote.mExtra == paramInt) {
          paramProxyListener.add(localColorNote);
        }
      }
      this.mCache.removeAll(paramProxyListener);
      batchDelete(paramProxyListener);
      return paramProxyListener;
    }
    for (;;)
    {
      throw paramProxyListener;
    }
  }
  
  public void deleteColorNote(String arg1, ColorNote paramColorNote, ProxyListener paramProxyListener)
  {
    if (paramColorNote != null) {
      synchronized (CACHE_LOCK)
      {
        this.mCache.remove(paramColorNote);
        ThreadManagerV2.excute(new ColorNoteDataServiceImpl.2(this, paramColorNote), 32, null, false);
        return;
      }
    }
  }
  
  public List<ColorNote> extraTypeFilter(List<ColorNote> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (CACHE_LOCK)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ColorNote localColorNote = (ColorNote)paramList.next();
        if (localColorNote.mExtra == paramInt) {
          localArrayList.add(localColorNote);
        }
      }
      return localArrayList;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  boolean filterColorNote(ColorNote paramColorNote)
  {
    return (!this.mCache.isEmpty()) && (findColorNoteByKey(paramColorNote.getUniKey(), paramColorNote.mExtra) != null);
  }
  
  public ColorNote findColorNoteByKey(String paramString)
  {
    try
    {
      paramString = findColorNoteByKey(paramString, 0);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public ColorNote findColorNoteByKey(String paramString, int paramInt)
  {
    Object localObject3 = null;
    if (paramInt == 0) {}
    try
    {
      Object localObject2 = getColorNotes(false);
      break label27;
      localObject2 = getColorNotes(false, paramInt);
      label27:
      Object localObject1 = localObject3;
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        boolean bool;
        do
        {
          localObject1 = localObject3;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = (ColorNote)((Iterator)localObject2).next();
          bool = ((ColorNote)localObject1).getUniKey().equals(paramString);
        } while (!bool);
      }
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public final List<ColorNote> getColorNotes(boolean paramBoolean)
  {
    try
    {
      List localList = getColorNotes(paramBoolean, 0);
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public List<ColorNote> getColorNotes(boolean paramBoolean, int paramInt)
  {
    try
    {
      if ((this.mCache.isEmpty()) && (paramBoolean))
      {
        localList = this.mEntityManager.query(ColorNote.class);
        if ((localList != null) && (!localList.isEmpty())) {
          this.mCache = localList;
        }
      }
      List localList = extraTypeFilter(this.mCache, paramInt);
      return localList;
    }
    finally {}
  }
  
  public final int getCurrentColorNoteCount()
  {
    try
    {
      int i = getColorNotes(false).size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public List<ColorNote> getVisiableColorNotes()
  {
    try
    {
      List localList = getVisiableColorNotes(this.mCache);
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public List<ColorNote> getVisiableColorNotes(List<ColorNote> paramList)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      if (!paramList.isEmpty())
      {
        i = paramList.size() - 1;
        if (i >= 0)
        {
          ColorNote localColorNote = (ColorNote)paramList.get(i);
          if ((localColorNote.isOpen()) && (!ColorNoteUtils.d(localColorNote))) {
            break label102;
          }
          localArrayList.add(localColorNote);
          break label102;
        }
      }
      Collections.sort(localArrayList, this.mComparator);
      paramList = extraTypeFilter(localArrayList, 0);
      return paramList;
    }
    finally
    {
      for (;;)
      {
        int i;
        for (;;)
        {
          throw paramList;
        }
        label102:
        i -= 1;
      }
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mAppRuntime = paramAppRuntime;
    if (QLog.isColorLevel()) {
      QLog.e("ColorNoteProxy", 2, "init ~~ ");
    }
    this.mEntityManager = paramAppRuntime.getEntityManagerFactory().createEntityManager();
    List localList = this.mEntityManager.query(ColorNote.class, true, null, null, null, null, null, null);
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.mCache = localList;
      ColorNoteSmallScreenUtil.a(paramAppRuntime, false, false);
    }
    paramAppRuntime = ColorNoteConfigProcessor.a();
    if ((paramAppRuntime != null) && (paramAppRuntime.a() != -1))
    {
      ColorNoteConstants.a = paramAppRuntime.a();
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("init MAX_COUNT ");
        paramAppRuntime.append(ColorNoteConstants.a);
        QLog.e("ColorNoteConfigProcessor", 2, paramAppRuntime.toString());
      }
    }
    ColorNoteSmallScreenUtil.a(MobileQQ.getContext(), 3, true);
  }
  
  public void onDestroy()
  {
    EntityManager localEntityManager = this.mEntityManager;
    if (localEntityManager != null) {
      localEntityManager.close();
    }
  }
  
  public void registerColorNoteListener(IColorNoteListener paramIColorNoteListener)
  {
    if (this.mColorNoteListener == null) {
      this.mColorNoteListener = new ArrayList();
    }
    if (!this.mColorNoteListener.contains(paramIColorNoteListener)) {
      this.mColorNoteListener.add(paramIColorNoteListener);
    }
  }
  
  protected void saveToDB(String paramString, ColorNote paramColorNote, ProxyListener paramProxyListener, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      addSync(paramColorNote);
      return;
    }
    add(paramColorNote);
  }
  
  @Deprecated
  public void setCache(List<ColorNote> paramList)
  {
    this.mCache = paramList;
  }
  
  public void setEntityManager(EntityManager paramEntityManager)
  {
    this.mEntityManager = paramEntityManager;
  }
  
  public void setUpcomingColorNoteExtLong(ColorNote paramColorNote)
  {
    Object localObject2 = this.mCache;
    synchronized (CACHE_LOCK)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ColorNote localColorNote = (ColorNote)((Iterator)localObject2).next();
        if (localColorNote.equals(paramColorNote))
        {
          localColorNote.mExtLong |= 1L;
          updateColorNoteFieldByKey(this.mAppRuntime.getCurrentUin(), localColorNote.getUniKey(), "mExtLong", Long.valueOf(localColorNote.mExtLong));
        }
      }
      return;
    }
    for (;;)
    {
      throw paramColorNote;
    }
  }
  
  public void unregisterColorNoteListener(IColorNoteListener paramIColorNoteListener)
  {
    ArrayList localArrayList = this.mColorNoteListener;
    if (localArrayList != null) {
      localArrayList.remove(paramIColorNoteListener);
    }
  }
  
  public ColorNote updateColorNoteFieldByKey(String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    paramString1 = findColorNoteByKey(paramString2);
    try
    {
      Object localObject = ColorNote.class.getDeclaredField(paramString3);
      paramString2 = ((Field)localObject).getType();
      ((Field)localObject).setAccessible(true);
      if (paramString1 != null) {
        ((Field)localObject).set(paramString1, paramObject);
      }
      if (!Modifier.isStatic(((Field)localObject).getModifiers()))
      {
        if (((Field)localObject).isAnnotationPresent(notColumn.class)) {
          return null;
        }
        localObject = new ContentValues();
        if (paramString2 == Long.TYPE)
        {
          ((ContentValues)localObject).put(paramString3, (Long)paramObject);
        }
        else if (paramString2 == Integer.TYPE)
        {
          ((ContentValues)localObject).put(paramString3, (Integer)paramObject);
        }
        else if (paramString2 == String.class)
        {
          ((ContentValues)localObject).put(paramString3, (String)paramObject);
        }
        else if (paramString2 == Byte.TYPE)
        {
          ((ContentValues)localObject).put(paramString3, (Byte)paramObject);
        }
        else if (paramString2 == [B.class)
        {
          ((ContentValues)localObject).put(paramString3, (byte[])paramObject);
        }
        else if (paramString2 == Short.TYPE)
        {
          ((ContentValues)localObject).put(paramString3, (Short)paramObject);
        }
        else if (paramString2 == Boolean.TYPE)
        {
          ((ContentValues)localObject).put(paramString3, (Boolean)paramObject);
        }
        else if (paramString2 == Float.TYPE)
        {
          ((ContentValues)localObject).put(paramString3, (Float)paramObject);
        }
        else if (paramString2 == Double.TYPE)
        {
          ((ContentValues)localObject).put(paramString3, (Double)paramObject);
        }
        else if (QLog.isColorLevel())
        {
          paramString3 = new StringBuilder();
          paramString3.append("updateMsgFieldByUniseq fieldType error! ");
          paramString3.append(paramString2.getClass().getSimpleName());
          QLog.e("ColorNoteProxy", 2, paramString3.toString());
        }
        if (paramString1 != null)
        {
          this.mEntityManager.update(paramString1);
          return paramString1;
        }
      }
      else
      {
        return null;
      }
    }
    catch (IllegalAccessException paramString1)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("ColorNoteProxy", 2, "updateColorNoteFieldByKey error IllegalAccessException! ", paramString1);
        return null;
      }
    }
    catch (NoSuchFieldException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ColorNoteProxy", 2, "updateColorNoteFieldByKey error NoSuchFieldException! ", paramString1);
      }
    }
    return null;
  }
  
  public boolean updateRecentNote(String paramString, ColorNote paramColorNote)
  {
    List localList = this.mCache;
    ArrayList localArrayList = new ArrayList();
    synchronized (CACHE_LOCK)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ColorNote localColorNote = (ColorNote)localIterator.next();
        if (ColorNoteUtils.b(localColorNote)) {
          localArrayList.add(localColorNote);
        }
      }
      localList.removeAll(localArrayList);
      ??? = localArrayList.iterator();
      while (((Iterator)???).hasNext()) {
        deleteColorNote(paramString, (ColorNote)((Iterator)???).next(), null);
      }
      if (paramColorNote != null) {
        addColorNote(paramString, paramColorNote, null, false);
      }
      return true;
    }
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.api.impl.ColorNoteDataServiceImpl
 * JD-Core Version:    0.7.0.1
 */