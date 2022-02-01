package com.tencent.qqmini.sdk.core.tissue;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.manager.EngineVersion;
import java.io.File;

public class TissueGlobal
{
  public static final String BUNDLE_KEY_TISSUE_NATIVE_LIB_DIR = "tissuenativelibdir";
  public static final String LOG_TAG = "Tissue";
  public static String sTissueRequiredVersion = "1.7.1";
  public static TissueEnv tissueEnv;
  
  public static boolean checkEngineAvailable(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        localObject = new File(paramString1);
      } while ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()));
      localObject = EngineVersion.fromFolderName(((File)localObject).getName());
    } while ((localObject == null) || (EngineVersion.compareVersion(((EngineVersion)localObject).mMinor, paramString2) < 0));
    return checkFileExists(paramString1, paramArrayOfString);
  }
  
  private static boolean checkFileExists(String paramString, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      File localFile = new File(paramString, paramArrayOfString[i]);
      if (!localFile.exists()) {}
      while ((!localFile.isFile()) || (!localFile.canRead())) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean verifyTissueEngine(String paramString)
  {
    String str = sTissueRequiredVersion;
    return checkEngineAvailable(paramString, new String[] { "libtv8rt.so", "libflutter.so", "libapp.so" }, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.tissue.TissueGlobal
 * JD-Core Version:    0.7.0.1
 */