package com.tencent.mobileqq.fts.v1;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.utils.FTSV2FieldUtils;

public abstract class FTSEntity
{
  public static final int EXT1_INDEX = 1;
  public static final int EXT2_INDEX = 2;
  public static final int EXT3_INDEX = 3;
  public static final int EXT_NON_INDEX = 0;
  public static final int FTS_OPT_DELETE = 16;
  public static final int FTS_OPT_INSERT = 1;
  public static final int FTS_OPT_NON = 0;
  public static final int FTS_OPT_UPDATE = 17;
  public static final int FTS_TYPE_MSG = 1;
  public static final int FTS_TYPE_NULL = 0;
  public static final int FTS_TYPE_TROOP = 2;
  public static final int MAX_LIMIT = 2000;
  public static final int MAX_PROXIMITY = 65535;
  public static final int MIN_PROXIMITY = 0;
  public String mContent = null;
  protected String mContentIndex = null;
  public String mExt1 = null;
  public String mExt2 = null;
  public String mExt3 = null;
  public String mExt4 = null;
  public String mExt5 = null;
  public String mExt6 = null;
  public String mExt7 = null;
  public String mExt8 = null;
  public String mExt9 = null;
  public byte[] mExts = null;
  public long mOId = -1L;
  public int mOpt = 0;
  public int mProximity = 65535;
  public int mProximityEnd = -1;
  public int mProximityStart = -1;
  public int mSearchScene;
  public int mSegmentCount = 0;
  public int mType = -1;
  
  public FTSEntity() {}
  
  public FTSEntity(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, byte[] paramArrayOfByte)
  {
    this.mType = paramInt1;
    this.mContent = paramString1;
    this.mOId = paramLong;
    this.mExt1 = paramString2;
    this.mExt2 = paramString3;
    this.mExt3 = paramString4;
    this.mExt4 = paramString5;
    this.mExt5 = paramString6;
    this.mExt6 = paramString7;
    this.mExt7 = paramString8;
    this.mExt8 = paramString9;
    this.mExt9 = paramString10;
    this.mExts = paramArrayOfByte;
    this.mProximity = paramInt2;
    this.mProximityStart = paramInt3;
    this.mProximityEnd = paramInt4;
  }
  
  public FTSEntity(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte)
  {
    this.mType = paramInt1;
    this.mContent = paramString1;
    this.mOId = paramLong;
    this.mExt1 = paramString2;
    this.mExt2 = paramString3;
    this.mExt3 = paramString4;
    this.mExts = paramArrayOfByte;
    this.mProximity = paramInt2;
    this.mProximityStart = paramInt3;
    this.mProximityEnd = paramInt4;
  }
  
  public FTSEntity(int paramInt, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte)
  {
    this.mType = paramInt;
    this.mContent = paramString1;
    this.mOId = paramLong;
    this.mExt1 = paramString2;
    this.mExt2 = paramString3;
    this.mExt3 = paramString4;
    this.mExts = paramArrayOfByte;
  }
  
  public abstract String createDeleteSQL();
  
  public abstract String createInsertSQL();
  
  public abstract String createUpdateSQL();
  
  public void deleteOpt()
  {
    this.mOpt = 16;
  }
  
  protected abstract void doDeserialize();
  
  protected abstract void doSerialize();
  
  public abstract String getTableName();
  
  public void insertOpt()
  {
    this.mOpt = 1;
  }
  
  public void postRead()
  {
    doDeserialize();
  }
  
  public void postWrite() {}
  
  public void preRead() {}
  
  public void preWrite()
  {
    String str = this.mContent;
    if ((str != null) && (!TextUtils.isEmpty(str)))
    {
      this.mContentIndex = FTSV2FieldUtils.c(this.mContent);
      this.mSegmentCount += FTSV2FieldUtils.a(this.mContentIndex);
    }
    else
    {
      this.mContentIndex = null;
    }
    doSerialize();
  }
  
  public void preWriteOne()
  {
    String str = this.mContent;
    if ((str != null) && (!TextUtils.isEmpty(str)))
    {
      this.mContentIndex = FTSV2FieldUtils.c(this.mContent);
      this.mSegmentCount += FTSV2FieldUtils.a(this.mContentIndex);
      return;
    }
    this.mContentIndex = null;
  }
  
  public void preWriteTwo()
  {
    doSerialize();
  }
  
  public abstract int type();
  
  public void upgradeOpt()
  {
    this.mOpt = 17;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v1.FTSEntity
 * JD-Core Version:    0.7.0.1
 */