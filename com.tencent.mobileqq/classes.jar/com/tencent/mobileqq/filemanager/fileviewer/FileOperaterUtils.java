package com.tencent.mobileqq.filemanager.fileviewer;

import adjn;
import adjp;
import adjq;
import adjs;
import adju;
import adjv;
import adjw;
import adjx;
import adjy;
import android.app.Activity;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class FileOperaterUtils
{
  public static View.OnClickListener a(Activity paramActivity, String paramString)
  {
    return new adjv(paramActivity, paramString);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return new adjy(paramFileManagerEntity, paramActivity);
  }
  
  public static View.OnClickListener a(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity)
  {
    return new adjp(paramFileManagerEntity, paramIFileBrowser);
  }
  
  public static View.OnClickListener a(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return new adjq(paramFileManagerEntity, paramActivity, paramIFileBrowser);
  }
  
  public static View.OnClickListener a(IFileBrowser paramIFileBrowser, String paramString)
  {
    return new adjn(paramString, paramIFileBrowser);
  }
  
  public static View.OnClickListener b(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity)
  {
    return new adjs(paramFileManagerEntity, paramIFileBrowser);
  }
  
  public static View.OnClickListener b(IFileBrowser paramIFileBrowser, String paramString)
  {
    return new adju(paramString, paramIFileBrowser);
  }
  
  public static View.OnClickListener c(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity)
  {
    return new adjw(paramIFileBrowser, paramFileManagerEntity);
  }
  
  public static View.OnClickListener d(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity)
  {
    return new adjx(paramIFileBrowser, paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils
 * JD-Core Version:    0.7.0.1
 */