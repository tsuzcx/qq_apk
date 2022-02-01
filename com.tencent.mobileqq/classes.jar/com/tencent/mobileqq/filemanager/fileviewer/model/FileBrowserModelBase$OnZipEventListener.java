package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.FileData;
import java.util.List;

public abstract interface FileBrowserModelBase$OnZipEventListener
{
  public abstract void a(long paramLong);
  
  public abstract void a(List<ZipFilePresenter.FileData> paramList, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, short paramShort);
  
  public abstract void b(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnZipEventListener
 * JD-Core Version:    0.7.0.1
 */