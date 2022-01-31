package com.tencent.mobileqq.filemanager.fileviewer;

import adbg;
import adbi;
import adbj;
import adbl;
import adbn;
import adbo;
import adbp;
import adbq;
import adbr;
import android.app.Activity;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class FileOperaterUtils
{
  public static View.OnClickListener a(Activity paramActivity, String paramString)
  {
    return new adbo(paramActivity, paramString);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return new adbr(paramFileManagerEntity, paramActivity);
  }
  
  public static View.OnClickListener a(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity)
  {
    return new adbi(paramFileManagerEntity, paramIFileBrowser);
  }
  
  public static View.OnClickListener a(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return new adbj(paramFileManagerEntity, paramActivity, paramIFileBrowser);
  }
  
  public static View.OnClickListener a(IFileBrowser paramIFileBrowser, String paramString)
  {
    return new adbg(paramString, paramIFileBrowser);
  }
  
  public static View.OnClickListener b(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity)
  {
    return new adbl(paramFileManagerEntity, paramIFileBrowser);
  }
  
  public static View.OnClickListener b(IFileBrowser paramIFileBrowser, String paramString)
  {
    return new adbn(paramString, paramIFileBrowser);
  }
  
  public static View.OnClickListener c(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity)
  {
    return new adbp(paramIFileBrowser, paramFileManagerEntity);
  }
  
  public static View.OnClickListener d(IFileBrowser paramIFileBrowser, FileManagerEntity paramFileManagerEntity)
  {
    return new adbq(paramIFileBrowser, paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils
 * JD-Core Version:    0.7.0.1
 */