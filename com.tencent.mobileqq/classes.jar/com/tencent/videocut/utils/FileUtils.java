package com.tencent.videocut.utils;

import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/FileUtils;", "", "()V", "TAG", "", "convertFileToByteArray", "", "filePath", "copyAssetFile", "", "context", "Landroid/content/Context;", "assetFile", "destFile", "copyFile", "inputStream", "Ljava/io/InputStream;", "os", "Ljava/io/OutputStream;", "createNewFile", "Ljava/io/File;", "createParentDir", "delete", "", "file", "path", "doZip", "zos", "Ljava/util/zip/ZipOutputStream;", "parentDirName", "buffer", "exist", "fileToBase64", "find", "", "dir", "fileName", "findFirstFileBySuffix", "suffix", "getCacheDirectory", "type", "getExternalCacheDirectory", "getFileSize", "", "getInternalCacheDirectory", "isDirectory", "directory", "isDirectoryWritable", "isExternalStorageAvailable", "isExternalStorageSpaceEnough", "fileSize", "loadAssetsString", "moveFile", "oldPath", "newPath", "readString", "saveFile", "data", "splitFile", "Lcom/tencent/videocut/utils/FileUtils$FileInfo;", "partLength", "", "partFileDir", "fileSuffix", "unzip", "location", "zip", "srcFiles", "", "([Ljava/io/File;Ljava/io/File;)Z", "FileInfo", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class FileUtils
{
  @NotNull
  public static final FileUtils a = new FileUtils();
  
  public final boolean a(@Nullable String paramString)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    int i;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return false;
    }
    return new File(paramString).exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */