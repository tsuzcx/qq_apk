package com.tencent.mobileqq.fts.v2.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.utils.FTSV2FieldUtils;
import com.tencent.mobileqq.fts.v2.FTSQueryArgsV2;
import com.tencent.mobileqq.fts.v2.FTSQueryArgsV2.MatchKey;
import com.tencent.mobileqq.fts.v2.entity.FTSEntityV2;
import java.lang.Class<+Lcom.tencent.mobileqq.fts.v2.entity.FTSEntityV2;>;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SQLUtils
{
  static
  {
    FTSV2FieldUtils.a.put(Byte.TYPE, "INTEGER");
    FTSV2FieldUtils.a.put(Boolean.TYPE, "INTEGER");
    FTSV2FieldUtils.a.put(Short.TYPE, "INTEGER");
    FTSV2FieldUtils.a.put(Integer.TYPE, "INTEGER");
    FTSV2FieldUtils.a.put(Long.TYPE, "INTEGER");
    FTSV2FieldUtils.a.put(String.class, "TEXT");
    FTSV2FieldUtils.a.put([B.class, "BLOB");
    FTSV2FieldUtils.a.put(Float.TYPE, "REAL");
    FTSV2FieldUtils.a.put(Double.TYPE, "REAL");
  }
  
  public static FTSEntityV2 a(Map paramMap, Class<? extends FTSEntityV2> paramClass)
  {
    try
    {
      FTSEntityV2 localFTSEntityV2 = (FTSEntityV2)paramClass.newInstance();
      Iterator localIterator = FTSV2FieldUtils.a(paramClass).values().iterator();
      while (localIterator.hasNext())
      {
        Field localField = (Field)localIterator.next();
        localObject1 = paramMap.get(localField.getName());
        if (localObject1 != null)
        {
          Object localObject2;
          if (((String)FTSV2FieldUtils.a.get(localField.getType())).equals("INTEGER"))
          {
            localObject2 = (Long)localObject1;
            if (localField.getType().equals(Byte.TYPE))
            {
              paramClass = Byte.valueOf(((Long)localObject2).byteValue());
            }
            else if (localField.getType().equals(Boolean.TYPE))
            {
              boolean bool;
              if (((Long)localObject2).longValue() == 1L) {
                bool = true;
              } else {
                bool = false;
              }
              paramClass = Boolean.valueOf(bool);
            }
            else if (localField.getType().equals(Short.TYPE))
            {
              paramClass = Short.valueOf(((Long)localObject2).shortValue());
            }
            else if (localField.getType().equals(Integer.TYPE))
            {
              paramClass = Integer.valueOf(((Long)localObject2).intValue());
            }
            else
            {
              paramClass = (Class<? extends FTSEntityV2>)localObject1;
              if (localField.getType().equals(Long.TYPE)) {
                paramClass = Long.valueOf(((Long)localObject2).longValue());
              }
            }
          }
          else
          {
            paramClass = (Class<? extends FTSEntityV2>)localObject1;
            if (((String)FTSV2FieldUtils.a.get(localField.getType())).equals("REAL"))
            {
              localObject2 = (Double)localObject1;
              if (localField.getType().equals(Float.TYPE))
              {
                paramClass = Float.valueOf(((Double)localObject2).floatValue());
              }
              else
              {
                paramClass = (Class<? extends FTSEntityV2>)localObject1;
                if (localField.getType().equals(Double.TYPE)) {
                  paramClass = Double.valueOf(((Double)localObject2).doubleValue());
                }
              }
            }
          }
          try
          {
            localField.set(localFTSEntityV2, paramClass);
          }
          catch (IllegalAccessException paramClass)
          {
            paramClass.printStackTrace();
          }
        }
      }
      localFTSEntityV2.postRead();
      return localFTSEntityV2;
    }
    catch (Exception paramMap)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramClass.getSimpleName());
      ((StringBuilder)localObject1).append(" must have an empty constructor. ");
      paramMap = new RuntimeException(((StringBuilder)localObject1).toString(), paramMap);
    }
    for (;;)
    {
      throw paramMap;
    }
  }
  
  private static String a(FTSQueryArgsV2 paramFTSQueryArgsV2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramFTSQueryArgsV2.f))
    {
      localStringBuilder.append(" ORDER BY ");
      localStringBuilder.append(paramFTSQueryArgsV2.f);
    }
    if (paramFTSQueryArgsV2.d > 0)
    {
      localStringBuilder.append(" LIMIT ");
      localStringBuilder.append(paramFTSQueryArgsV2.d);
    }
    return localStringBuilder.toString();
  }
  
  private static String a(FTSQueryArgsV2 paramFTSQueryArgsV2, FTSQueryArgsV2.MatchKey paramMatchKey)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramMatchKey = a(paramFTSQueryArgsV2.a, paramMatchKey);
    if ((!TextUtils.isEmpty(paramMatchKey)) || (!TextUtils.isEmpty(paramFTSQueryArgsV2.e)))
    {
      localStringBuilder.append(" WHERE ");
      if (!TextUtils.isEmpty(paramMatchKey)) {
        localStringBuilder.append(paramMatchKey);
      }
      if ((!TextUtils.isEmpty(paramMatchKey)) && (!TextUtils.isEmpty(paramFTSQueryArgsV2.e))) {
        localStringBuilder.append(" AND ");
      }
      if (!TextUtils.isEmpty(paramFTSQueryArgsV2.e)) {
        localStringBuilder.append(paramFTSQueryArgsV2.e);
      }
    }
    return localStringBuilder.toString();
  }
  
  private static String a(FTSQueryArgsV2 paramFTSQueryArgsV2, FTSQueryArgsV2.MatchKey paramMatchKey, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d(paramFTSQueryArgsV2, paramBoolean));
    localStringBuilder.append(a(paramFTSQueryArgsV2, paramMatchKey));
    if (!paramBoolean) {
      localStringBuilder.append(a(paramFTSQueryArgsV2));
    }
    return localStringBuilder.toString();
  }
  
  public static String a(FTSQueryArgsV2 paramFTSQueryArgsV2, List<Integer> paramList)
  {
    String str = a(paramFTSQueryArgsV2, false);
    if ((paramList != null) && (paramList.size() <= 0))
    {
      paramFTSQueryArgsV2 = FTSV2FieldUtils.a(paramFTSQueryArgsV2.a).values().iterator();
      while (paramFTSQueryArgsV2.hasNext())
      {
        Object localObject = (Field)paramFTSQueryArgsV2.next();
        localObject = (String)FTSV2FieldUtils.a.get(((Field)localObject).getType());
        if (((String)localObject).equals("INTEGER")) {
          paramList.add(Integer.valueOf(1));
        } else if (((String)localObject).equals("REAL")) {
          paramList.add(Integer.valueOf(2));
        } else if (((String)localObject).equals("TEXT")) {
          paramList.add(Integer.valueOf(3));
        } else if (((String)localObject).equals("BLOB")) {
          paramList.add(Integer.valueOf(4));
        }
      }
      return str;
    }
    paramFTSQueryArgsV2 = new IllegalArgumentException("columnTyps must be empty and not null.");
    for (;;)
    {
      throw paramFTSQueryArgsV2;
    }
  }
  
  private static String a(FTSQueryArgsV2 paramFTSQueryArgsV2, boolean paramBoolean)
  {
    if (paramFTSQueryArgsV2.b != null)
    {
      if (paramFTSQueryArgsV2.b.length == 1) {
        return a(paramFTSQueryArgsV2, paramFTSQueryArgsV2.b[0], paramBoolean);
      }
      if (paramFTSQueryArgsV2.b.length > 1)
      {
        if (paramFTSQueryArgsV2.c) {
          return b(paramFTSQueryArgsV2, paramBoolean);
        }
        return c(paramFTSQueryArgsV2, paramBoolean);
      }
    }
    return a(paramFTSQueryArgsV2, null, paramBoolean);
  }
  
  public static String a(FTSEntityV2 paramFTSEntityV2, List<Integer> paramList, List<byte[]> paramList1)
  {
    paramFTSEntityV2.preWrite();
    paramList1.clear();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("INSERT INTO ");
    localStringBuilder.append(paramFTSEntityV2.getTableName());
    localStringBuilder.append("(");
    Object localObject1 = FTSV2FieldUtils.a(paramFTSEntityV2.getClass());
    Set localSet = FTSV2FieldUtils.b(paramFTSEntityV2.getClass());
    Object localObject2 = ((Map)localObject1).values().iterator();
    Field localField;
    for (int i = 1; ((Iterator)localObject2).hasNext(); i = 0)
    {
      localField = (Field)((Iterator)localObject2).next();
      if (i == 0) {
        localStringBuilder.append(',');
      }
      localStringBuilder.append(localField.getName());
      if (localSet.contains(localField))
      {
        localStringBuilder.append(',');
        localStringBuilder.append(paramFTSEntityV2.getIndexColumnName(localField.getName()));
      }
    }
    localStringBuilder.append(") VALUES(");
    localObject2 = ((Map)localObject1).entrySet().iterator();
    i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      localField = (Field)((Map.Entry)((Iterator)localObject2).next()).getValue();
      if (localField.getType().equals([B.class)) {
        try
        {
          paramList.add(Integer.valueOf(i));
          paramList1.add((byte[])localField.get(paramFTSEntityV2));
        }
        catch (IllegalAccessException localIllegalAccessException5)
        {
          localIllegalAccessException5.printStackTrace();
        }
      }
      j = i + 1;
      i = j;
      if (localSet.contains(localField)) {
        i = j + 1;
      }
    }
    localObject1 = ((Map)localObject1).values().iterator();
    int j = 1;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Field)((Iterator)localObject1).next();
      if (j == 0) {
        localStringBuilder.append(',');
      }
      if (((Field)localObject2).getType().equals(String.class))
      {
        localStringBuilder.append("'");
        try
        {
          localStringBuilder.append(((Field)localObject2).get(paramFTSEntityV2));
        }
        catch (IllegalAccessException localIllegalAccessException1)
        {
          localIllegalAccessException1.printStackTrace();
        }
        localStringBuilder.append("'");
      }
      else if (!((Field)localObject2).getType().equals(Boolean.TYPE)) {}
    }
    for (;;)
    {
      try
      {
        if (!((Boolean)((Field)localObject2).get(paramFTSEntityV2)).booleanValue()) {
          break label635;
        }
        j = 1;
        localStringBuilder.append(j);
      }
      catch (IllegalAccessException localIllegalAccessException2)
      {
        localIllegalAccessException2.printStackTrace();
      }
      if (((Field)localObject2).getType().equals([B.class))
      {
        localStringBuilder.append("?");
        try
        {
          paramList.add(Integer.valueOf(i));
          paramList1.add((byte[])((Field)localObject2).get(paramFTSEntityV2));
        }
        catch (IllegalAccessException localIllegalAccessException3)
        {
          localIllegalAccessException3.printStackTrace();
        }
      }
      else
      {
        try
        {
          localStringBuilder.append(((Field)localObject2).get(paramFTSEntityV2));
        }
        catch (IllegalAccessException localIllegalAccessException4)
        {
          localIllegalAccessException4.printStackTrace();
        }
      }
      if (localSet.contains(localObject2))
      {
        localStringBuilder.append(',');
        localStringBuilder.append("'");
        localStringBuilder.append((String)paramFTSEntityV2.indexContentMap.get(((Field)localObject2).getName()));
        localStringBuilder.append("'");
      }
      j = 0;
      break;
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      label635:
      j = 0;
    }
  }
  
  private static String a(Class<? extends FTSEntityV2> paramClass, FTSQueryArgsV2.MatchKey paramMatchKey)
  {
    if (paramMatchKey == null) {
      return "";
    }
    Object localObject1 = FTSV2FieldUtils.d(paramClass);
    Object localObject3 = paramMatchKey.a;
    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (paramMatchKey != null))
    {
      if (TextUtils.isEmpty(paramMatchKey.b)) {
        return "";
      }
      Object localObject2 = FTSV2FieldUtils.a(paramClass);
      Object localObject4 = FTSV2FieldUtils.b(paramClass);
      Field localField = (Field)((Map)localObject2).get(localObject3);
      localObject2 = new StringBuilder(128);
      if (((Set)localObject4).contains(localField)) {
        ((StringBuilder)localObject2).append(((FTSEntityV2)localObject1).getIndexColumnName((String)localObject3));
      } else {
        ((StringBuilder)localObject2).append((String)localObject3);
      }
      ((StringBuilder)localObject2).append(" MATCH '");
      paramClass = null;
      boolean bool = ((Set)localObject4).contains(localField);
      int j = 0;
      int i;
      if ((!bool) && (!paramMatchKey.d))
      {
        localObject3 = SegmentUtils.c(paramMatchKey.b);
        if (localObject3 != null)
        {
          localObject1 = new String[((ArrayList)localObject3).size()];
          i = 0;
          for (;;)
          {
            paramClass = (Class<? extends FTSEntityV2>)localObject1;
            if (i >= ((ArrayList)localObject3).size()) {
              break;
            }
            paramClass = (String)((ArrayList)localObject3).get(i);
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("*");
            ((StringBuilder)localObject4).append(paramClass);
            ((StringBuilder)localObject4).append("*");
            localObject1[i] = ((StringBuilder)localObject4).toString();
            i += 1;
          }
        }
      }
      else
      {
        paramClass = SegmentUtils.d(paramMatchKey.b);
      }
      if (paramClass != null)
      {
        i = j;
        if (paramClass.length == 0) {
          return "";
        }
        while (i < paramClass.length)
        {
          if (i > 0) {
            if (paramMatchKey.c) {
              ((StringBuilder)localObject2).append(" OR ");
            } else {
              ((StringBuilder)localObject2).append(" ");
            }
          }
          ((StringBuilder)localObject2).append("\"");
          ((StringBuilder)localObject2).append(paramClass[i]);
          ((StringBuilder)localObject2).append("\"");
          i += 1;
        }
        ((StringBuilder)localObject2).append("'");
        return ((StringBuilder)localObject2).toString();
      }
    }
    return "";
  }
  
  public static String a(Class<? extends FTSEntityV2> paramClass, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    FTSEntityV2 localFTSEntityV2 = FTSV2FieldUtils.d(paramClass);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE VIRTUAL TABLE ");
    if ((paramBoolean1) && (paramBoolean2)) {
      localStringBuilder.append("IF NOT EXISTS ");
    }
    localStringBuilder.append(localFTSEntityV2.getTableName());
    localStringBuilder.append(" USING ");
    if (paramBoolean1) {
      localStringBuilder.append("fts4");
    } else {
      localStringBuilder.append("fts3");
    }
    localStringBuilder.append("(");
    Object localObject2 = FTSV2FieldUtils.a(paramClass);
    Object localObject1 = FTSV2FieldUtils.b(paramClass);
    int i = 1;
    localObject2 = ((Map)localObject2).values().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Field localField = (Field)((Iterator)localObject2).next();
      String str = (String)FTSV2FieldUtils.a.get(localField.getType());
      if (i == 0) {
        localStringBuilder.append(',');
      }
      localStringBuilder.append(localField.getName());
      localStringBuilder.append(" ");
      localStringBuilder.append(str);
      if (((Set)localObject1).contains(localField))
      {
        localStringBuilder.append(',');
        localStringBuilder.append(localFTSEntityV2.getIndexColumnName(localField.getName()));
        localStringBuilder.append(" ");
        localStringBuilder.append("TEXT");
      }
      i = 0;
    }
    if ((paramBoolean1) && (paramBoolean3))
    {
      localObject2 = new HashSet();
      ((Set)localObject2).addAll((Collection)localObject1);
      ((Set)localObject2).addAll(FTSV2FieldUtils.c(paramClass));
      paramClass = ((Set)localObject2).iterator();
      while (paramClass.hasNext())
      {
        localObject1 = (Field)paramClass.next();
        localStringBuilder.append(", notindexed=");
        localStringBuilder.append(((Field)localObject1).getName());
      }
    }
    if ((paramBoolean1) && (localFTSEntityV2.needCompress()) && (paramBoolean4)) {
      localStringBuilder.append(", compress=qqcompress, uncompress=qquncompress");
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  private static String b(FTSQueryArgsV2 paramFTSQueryArgsV2, boolean paramBoolean)
  {
    if ((paramFTSQueryArgsV2 != null) && (paramFTSQueryArgsV2.b != null) && (paramFTSQueryArgsV2.b.length >= 2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = 0;
      int i = j;
      if (!paramBoolean)
      {
        localStringBuilder.append(d(paramFTSQueryArgsV2, false));
        localStringBuilder.append(" WHERE rowid in (");
        i = j;
      }
      while (i < paramFTSQueryArgsV2.b.length)
      {
        if (i > 0) {
          localStringBuilder.append(" UNION ");
        }
        localStringBuilder.append(a(paramFTSQueryArgsV2, paramFTSQueryArgsV2.b[i], true));
        i += 1;
      }
      if (!paramBoolean)
      {
        localStringBuilder.append(")");
        localStringBuilder.append(a(paramFTSQueryArgsV2));
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private static String c(FTSQueryArgsV2 paramFTSQueryArgsV2, boolean paramBoolean)
  {
    if ((paramFTSQueryArgsV2 != null) && (paramFTSQueryArgsV2.b != null) && (paramFTSQueryArgsV2.b.length >= 2))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      if (!paramBoolean)
      {
        localStringBuilder1.append(d(paramFTSQueryArgsV2, false));
        localStringBuilder1.append(" WHERE rowid in (");
      }
      String str = a(paramFTSQueryArgsV2, paramFTSQueryArgsV2.b[0], true);
      int i = 1;
      while (i < paramFTSQueryArgsV2.b.length)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(a(paramFTSQueryArgsV2, paramFTSQueryArgsV2.b[i], true));
        localStringBuilder2.append(" AND rowid in (");
        localStringBuilder2.append(str);
        localStringBuilder2.append(")");
        str = localStringBuilder2.toString();
        i += 1;
      }
      localStringBuilder1.append(str);
      if (!paramBoolean)
      {
        localStringBuilder1.append(")");
        localStringBuilder1.append(a(paramFTSQueryArgsV2));
      }
      return localStringBuilder1.toString();
    }
    return "";
  }
  
  private static String d(FTSQueryArgsV2 paramFTSQueryArgsV2, boolean paramBoolean)
  {
    FTSEntityV2 localFTSEntityV2 = FTSV2FieldUtils.d(paramFTSQueryArgsV2.a);
    Object localObject = FTSV2FieldUtils.a(paramFTSQueryArgsV2.a);
    paramFTSQueryArgsV2 = new StringBuilder();
    paramFTSQueryArgsV2.append("SELECT ");
    if (paramBoolean)
    {
      paramFTSQueryArgsV2.append("rowid");
    }
    else
    {
      int i = 1;
      localObject = ((Map)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (i == 0) {
          paramFTSQueryArgsV2.append(',');
        }
        paramFTSQueryArgsV2.append(str);
        i = 0;
      }
    }
    paramFTSQueryArgsV2.append(" FROM ");
    paramFTSQueryArgsV2.append(localFTSEntityV2.getTableName());
    return paramFTSQueryArgsV2.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v2.utils.SQLUtils
 * JD-Core Version:    0.7.0.1
 */