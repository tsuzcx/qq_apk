package com.tencent.shadow.core.runtime.skin.loader;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class SkinPkgInfo
{
  private static final String SKIN_DIR;
  private static final String SKIN_NAME = "blackNight2.skin";
  private int mSkinId;
  private String mSkinName;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("blackNight2.skin");
    SKIN_DIR = localStringBuilder.toString();
  }
  
  protected SkinPkgInfo(int paramInt, String paramString)
  {
    this.mSkinId = paramInt;
    this.mSkinName = paramString;
  }
  
  public static String getAssetDir()
  {
    return "skinres";
  }
  
  public static String getInstallDir()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ContextHolder.getContext().getFilesDir());
    localStringBuilder.append("/");
    localStringBuilder.append("skin");
    return localStringBuilder.toString();
  }
  
  public String getAssetPath()
  {
    return this.mSkinName;
  }
  
  public String getInstallPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ContextHolder.getContext().getFilesDir());
    localStringBuilder.append("/");
    localStringBuilder.append("skin");
    localStringBuilder.append("/blackNight2.skin");
    return localStringBuilder.toString();
  }
  
  public int getSkinId()
  {
    return this.mSkinId;
  }
  
  public String getSkinName()
  {
    return this.mSkinName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.skin.loader.SkinPkgInfo
 * JD-Core Version:    0.7.0.1
 */