package com.tencent.qcircle.shadow.core.runtime;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources.Theme;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.view.ContextThemeWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

abstract class SubDirContextThemeWrapper
  extends ContextThemeWrapper
{
  private File mCacheDir;
  private File mCodeCacheDir;
  private File mDataDir;
  private File mExternalCacheDir;
  private File mFilesDir;
  private File mNoBackupFilesDir;
  private File mObbDir;
  private final Object mSync = new Object();
  
  public SubDirContextThemeWrapper() {}
  
  public SubDirContextThemeWrapper(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  @TargetApi(23)
  public SubDirContextThemeWrapper(Context paramContext, Resources.Theme paramTheme)
  {
    super(paramContext, paramTheme);
  }
  
  private static File ensurePrivateDirExists(File paramFile)
  {
    paramFile.mkdirs();
    return paramFile;
  }
  
  private static File makeFilename(File paramFile, String paramString)
  {
    if (paramString.indexOf(File.separatorChar) < 0) {
      return new File(paramFile, paramString);
    }
    paramFile = new StringBuilder();
    paramFile.append("File ");
    paramFile.append(paramString);
    paramFile.append(" contains a path separator");
    throw new IllegalArgumentException(paramFile.toString());
  }
  
  private String makeSubName(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getSubDirName());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public String[] databaseList()
  {
    if (getSubDirName() == null) {
      return super.databaseList();
    }
    String[] arrayOfString1 = super.databaseList();
    boolean[] arrayOfBoolean = new boolean[arrayOfString1.length];
    int k = 0;
    int i = 0;
    int j = 0;
    while (i < arrayOfString1.length)
    {
      if (arrayOfString1[i].startsWith(getSubDirName()))
      {
        arrayOfBoolean[i] = true;
        j += 1;
      }
      else
      {
        arrayOfBoolean[i] = false;
      }
      i += 1;
    }
    String[] arrayOfString2 = new String[j];
    j = 0;
    i = k;
    while (i < arrayOfBoolean.length)
    {
      k = j;
      if (arrayOfBoolean[i] != 0)
      {
        arrayOfString2[j] = arrayOfString1[i];
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return arrayOfString2;
  }
  
  public boolean deleteDatabase(String paramString)
  {
    if (getSubDirName() == null) {
      return super.deleteDatabase(paramString);
    }
    return super.deleteDatabase(makeSubName(paramString));
  }
  
  public boolean deleteFile(String paramString)
  {
    return makeFilename(getFilesDir(), paramString).delete();
  }
  
  public boolean deleteSharedPreferences(String paramString)
  {
    if (getSubDirName() == null) {
      return super.deleteSharedPreferences(paramString);
    }
    return super.deleteSharedPreferences(makeSubName(paramString));
  }
  
  public File getCacheDir()
  {
    if (getSubDirName() == null) {
      return super.getCacheDir();
    }
    synchronized (this.mSync)
    {
      if (this.mCacheDir == null) {
        this.mCacheDir = new File(super.getCacheDir(), getSubDirName());
      }
      File localFile = ensurePrivateDirExists(this.mCacheDir);
      return localFile;
    }
  }
  
  public File getCodeCacheDir()
  {
    if (getSubDirName() == null) {
      return super.getCodeCacheDir();
    }
    synchronized (this.mSync)
    {
      if (this.mCodeCacheDir == null) {
        this.mCodeCacheDir = new File(super.getCodeCacheDir(), getSubDirName());
      }
      File localFile = ensurePrivateDirExists(this.mCodeCacheDir);
      return localFile;
    }
  }
  
  public File getDataDir()
  {
    if (getSubDirName() == null) {
      return super.getDataDir();
    }
    synchronized (this.mSync)
    {
      if (this.mDataDir == null) {
        this.mDataDir = new File(super.getDataDir(), getSubDirName());
      }
      File localFile = ensurePrivateDirExists(this.mDataDir);
      return localFile;
    }
  }
  
  public File getDatabasePath(String paramString)
  {
    if (getSubDirName() == null) {
      return super.getDatabasePath(paramString);
    }
    return super.getDatabasePath(makeSubName(paramString));
  }
  
  public File getDir(String paramString, int paramInt)
  {
    if ((paramInt == 0) && (getSubDirName() != null)) {
      return ensurePrivateDirExists(new File(super.getDir(paramString, paramInt), getSubDirName()));
    }
    return super.getDir(paramString, paramInt);
  }
  
  public File getExternalCacheDir()
  {
    if (getSubDirName() == null) {
      return super.getExternalCacheDir();
    }
    synchronized (this.mSync)
    {
      if (this.mExternalCacheDir == null) {
        this.mExternalCacheDir = new File(super.getExternalCacheDir(), getSubDirName());
      }
      File localFile = ensurePrivateDirExists(this.mExternalCacheDir);
      return localFile;
    }
  }
  
  public File[] getExternalCacheDirs()
  {
    if (getSubDirName() == null) {
      return super.getExternalCacheDirs();
    }
    File[] arrayOfFile1 = super.getExternalCacheDirs();
    File[] arrayOfFile2 = new File[arrayOfFile1.length];
    int i = 0;
    while (i < arrayOfFile1.length)
    {
      arrayOfFile2[i] = ensurePrivateDirExists(new File(arrayOfFile1[i], getSubDirName()));
      i += 1;
    }
    return arrayOfFile2;
  }
  
  public File getExternalFilesDir(String paramString)
  {
    if (getSubDirName() == null) {
      return super.getExternalFilesDir(paramString);
    }
    return ensurePrivateDirExists(new File(super.getExternalFilesDir(paramString), getSubDirName()));
  }
  
  public File[] getExternalFilesDirs(String paramString)
  {
    if (getSubDirName() == null) {
      return super.getExternalFilesDirs(paramString);
    }
    paramString = super.getExternalFilesDirs(paramString);
    File[] arrayOfFile = new File[paramString.length];
    int i = 0;
    while (i < paramString.length)
    {
      arrayOfFile[i] = ensurePrivateDirExists(new File(paramString[i], getSubDirName()));
      i += 1;
    }
    return arrayOfFile;
  }
  
  public File[] getExternalMediaDirs()
  {
    if (getSubDirName() == null) {
      return super.getExternalMediaDirs();
    }
    File[] arrayOfFile1 = super.getExternalMediaDirs();
    File[] arrayOfFile2 = new File[arrayOfFile1.length];
    int i = 0;
    while (i < arrayOfFile1.length)
    {
      arrayOfFile2[i] = ensurePrivateDirExists(new File(arrayOfFile1[i], getSubDirName()));
      i += 1;
    }
    return arrayOfFile2;
  }
  
  public File getFilesDir()
  {
    if (getSubDirName() == null) {
      return super.getFilesDir();
    }
    synchronized (this.mSync)
    {
      if (this.mFilesDir == null) {
        this.mFilesDir = new File(super.getFilesDir(), getSubDirName());
      }
      File localFile = ensurePrivateDirExists(this.mFilesDir);
      return localFile;
    }
  }
  
  public File getNoBackupFilesDir()
  {
    if (getSubDirName() == null) {
      return super.getNoBackupFilesDir();
    }
    synchronized (this.mSync)
    {
      if (this.mNoBackupFilesDir == null) {
        this.mNoBackupFilesDir = new File(super.getNoBackupFilesDir(), getSubDirName());
      }
      File localFile = ensurePrivateDirExists(this.mNoBackupFilesDir);
      return localFile;
    }
  }
  
  public File getObbDir()
  {
    if (getSubDirName() == null) {
      return super.getObbDir();
    }
    synchronized (this.mSync)
    {
      if (this.mObbDir == null) {
        this.mObbDir = new File(super.getObbDir(), getSubDirName());
      }
      File localFile = ensurePrivateDirExists(this.mObbDir);
      return localFile;
    }
  }
  
  public File[] getObbDirs()
  {
    if (getSubDirName() == null) {
      return super.getObbDirs();
    }
    File[] arrayOfFile1 = super.getObbDirs();
    File[] arrayOfFile2 = new File[arrayOfFile1.length];
    int i = 0;
    while (i < arrayOfFile1.length)
    {
      arrayOfFile2[i] = ensurePrivateDirExists(new File(arrayOfFile1[i], getSubDirName()));
      i += 1;
    }
    return arrayOfFile2;
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    if ((paramInt == 0) && (getSubDirName() != null)) {
      return super.getSharedPreferences(makeSubName(paramString), paramInt);
    }
    return super.getSharedPreferences(paramString, paramInt);
  }
  
  abstract String getSubDirName();
  
  public boolean moveDatabaseFrom(Context paramContext, String paramString)
  {
    if (getSubDirName() == null) {
      return super.moveDatabaseFrom(paramContext, paramString);
    }
    throw new UnsupportedOperationException("暂不支持");
  }
  
  public FileInputStream openFileInput(String paramString)
  {
    if (getSubDirName() == null) {
      return super.openFileInput(paramString);
    }
    return new FileInputStream(makeFilename(getFilesDir(), paramString));
  }
  
  public FileOutputStream openFileOutput(String paramString, int paramInt)
  {
    if ((paramInt == 0) && (getSubDirName() != null))
    {
      boolean bool;
      if ((paramInt & 0x8000) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return new FileOutputStream(makeFilename(getFilesDir(), paramString), bool);
    }
    return super.openFileOutput(paramString, paramInt);
  }
  
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    if ((paramInt == 0) && (getSubDirName() != null)) {
      return super.openOrCreateDatabase(makeSubName(paramString), paramInt, paramCursorFactory);
    }
    return super.openOrCreateDatabase(paramString, paramInt, paramCursorFactory);
  }
  
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    if ((paramInt == 0) && (getSubDirName() != null)) {
      return super.openOrCreateDatabase(makeSubName(paramString), paramInt, paramCursorFactory, paramDatabaseErrorHandler);
    }
    return super.openOrCreateDatabase(paramString, paramInt, paramCursorFactory, paramDatabaseErrorHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper
 * JD-Core Version:    0.7.0.1
 */