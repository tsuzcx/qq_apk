package com.tencent.mobileqq.filemanager.fileviewer;

import acrj;
import acrl;
import acrm;
import acro;
import acrq;
import acrr;
import acrs;
import acrt;
import acru;
import android.app.Activity;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class FileOperaterUtils
{
  public static View.OnClickListener a(Activity paramActivity, String paramString)
  {
    return new acrr(paramActivity, paramString);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return new acru(paramFileManagerEntity, paramActivity);
  }
  
  public static View.OnClickListener a(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity)
  {
    return new acrl(paramFileManagerEntity, paramIFileBrowser);
  }
  
  public static View.OnClickListener a(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return new acrm(paramFileManagerEntity, paramActivity, paramIFileBrowser);
  }
  
  public static View.OnClickListener a(IFileBrowser paramIFileBrowser, String paramString)
  {
    return new acrj(paramString, paramIFileBrowser);
  }
  
  public static View.OnClickListener b(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity)
  {
    return new acro(paramFileManagerEntity, paramIFileBrowser);
  }
  
  public static View.OnClickListener b(IFileBrowser paramIFileBrowser, String paramString)
  {
    return new acrq(paramString, paramIFileBrowser);
  }
  
  public static View.OnClickListener c(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity)
  {
    return new acrs(paramIFileBrowser, paramFileManagerEntity);
  }
  
  public static View.OnClickListener d(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity)
  {
    return new acrt(paramIFileBrowser, paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils
 * JD-Core Version:    0.7.0.1
 */