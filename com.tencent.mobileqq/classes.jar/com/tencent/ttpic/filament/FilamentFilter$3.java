package com.tencent.ttpic.filament;

import android.util.Log;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.model.GLBItemJava;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class FilamentFilter$3
  implements Runnable
{
  FilamentFilter$3(FilamentFilter paramFilamentFilter) {}
  
  public void run()
  {
    FilaBenchUtil.benchStart(FilamentUtil.BenchTag.IO.tag);
    if (FilamentFilter.access$900(this.this$0).size() == 0)
    {
      Iterator localIterator = FilamentFilter.access$1000(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        GLBItemJava localGLBItemJava = (GLBItemJava)localIterator.next();
        String str = FileUtils.getPostfix(localGLBItemJava.path);
        Object localObject = "";
        if ((str.equals(".glb")) || (str.equals(".dat")))
        {
          str = ".glb";
          localObject = ".dat";
        }
        for (;;)
        {
          Log.v(FilamentFilter.access$800(), "start loading file" + localGLBItemJava.path + str);
          localObject = FilamentUtil.loadAndTryDecryptGlb(localGLBItemJava.path, str, (String)localObject);
          if ((localObject == null) || (localObject.length <= 0)) {
            break label222;
          }
          FilamentFilter.access$900(this.this$0).put(localGLBItemJava, localObject);
          break;
          if ((str.equals(".gltf")) || (str.equals(".datf")))
          {
            str = ".gltf";
            localObject = ".datf";
          }
          else
          {
            Log.e(FilamentFilter.access$800(), "run: Undefined RES_POSTFIX: " + str);
          }
        }
        label222:
        Log.e(FilamentFilter.access$800(), "Fail to load glb file. May crash later");
      }
    }
    FilamentFilter.access$1102(this.this$0, true);
    FilaBenchUtil.benchEnd(FilamentUtil.BenchTag.IO.tag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentFilter.3
 * JD-Core Version:    0.7.0.1
 */