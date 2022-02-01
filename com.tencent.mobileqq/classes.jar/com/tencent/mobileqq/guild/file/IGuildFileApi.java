package com.tencent.mobileqq.guild.file;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IGuildFileApi
  extends QRouteApi
{
  public abstract FileManagerEntity createGuildFileEntity(String paramString1, String paramString2);
  
  public abstract void downloadGuildFile(String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity);
  
  public abstract void downloadGuildThumb(String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.file.IGuildFileApi
 * JD-Core Version:    0.7.0.1
 */