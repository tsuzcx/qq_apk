package org.xwalk.core;

import com.tencent.xweb.ae;
import com.tencent.xweb.util.c;
import com.tencent.xweb.util.d;
import com.tencent.xweb.util.h;
import java.io.File;

public class XWalkUpdater$LibUpdateConfig
  extends XWalkUpdater.EmbededUpdateConfig
{
  public XWalkUpdater$LibUpdateConfig(int paramInt, String paramString1, String paramString2)
  {
    super(paramInt, paramString1, paramString2);
  }
  
  public boolean copyPackageToLocal(String paramString1, String paramString2)
  {
    Object localObject1 = ae.a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append(paramString1);
    paramString1 = ((StringBuilder)localObject2).toString();
    localObject1 = new File(paramString1);
    localObject2 = new File(getDownloadPath());
    if (((File)localObject2).exists())
    {
      if (d.a(((File)localObject2).getAbsolutePath(), paramString2))
      {
        XWalkEnvironment.addXWalkInitializeLog("lib_installer", " already have file and md5 matched");
        return true;
      }
      XWalkEnvironment.addXWalkInitializeLog("lib_installer", " already have file but md5 not matched");
      ((File)localObject2).delete();
    }
    if (!((File)localObject1).exists())
    {
      h.a(903L, 129L, 1L);
      paramString2 = new StringBuilder();
      paramString2.append(" src file not find:");
      paramString2.append(paramString1);
      XWalkEnvironment.addXWalkInitializeLog("lib_installer", paramString2.toString());
      return false;
    }
    if (!d.a(((File)localObject1).getAbsolutePath(), paramString2))
    {
      h.a(903L, 130L, 1L);
      XWalkEnvironment.addXWalkInitializeLog("lib_installer", " src file MD5 not match");
    }
    if (!c.a((File)localObject1, (File)localObject2))
    {
      h.a(903L, 131L, 1L);
      XWalkEnvironment.addXWalkInitializeLog("lib_installer", " copy file failed");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.LibUpdateConfig
 * JD-Core Version:    0.7.0.1
 */