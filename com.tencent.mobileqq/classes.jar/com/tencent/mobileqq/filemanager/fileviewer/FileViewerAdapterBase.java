package com.tencent.mobileqq.filemanager.fileviewer;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.EntityFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.LocalFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.TroopFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.WeiyunFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.BaseApplication;

public abstract class FileViewerAdapterBase
  implements IFileViewerAdapter
{
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  
  public static IFileViewerAdapter a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    return new EntityFileViewerAdapter(paramQQAppInterface, paramFileManagerEntity);
  }
  
  public static IFileViewerAdapter a(QQAppInterface paramQQAppInterface, WeiYunFileInfo paramWeiYunFileInfo)
  {
    return new WeiyunFileViewerAdapter(paramQQAppInterface, paramWeiYunFileInfo);
  }
  
  public static IFileViewerAdapter a(FileInfo paramFileInfo)
  {
    return new LocalFileViewerAdapter(paramFileInfo);
  }
  
  public static IFileViewerAdapter b(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    return new TroopFileViewerAdapter(paramQQAppInterface, paramFileManagerEntity);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public String f()
  {
    return "";
  }
  
  public String i()
  {
    String str2 = "";
    String str1 = str2;
    if (c() > 0L)
    {
      str1 = str2;
      if (c() != 3) {
        if ((e() == null) || (e().length() <= 0)) {
          break label92;
        }
      }
    }
    label92:
    for (int i = 1;; i = 0)
    {
      str1 = str2;
      if (i == 0) {
        str1 = "" + BaseApplicationImpl.getContext().getString(2131692414) + FileManagerUtil.a(c(), b());
      }
      return str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewerAdapterBase
 * JD-Core Version:    0.7.0.1
 */