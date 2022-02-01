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
        Object localObject1 = FileUtils.getPostfix(localGLBItemJava.path);
        boolean bool = ((String)localObject1).equals(".glb");
        String str = ".datf";
        if ((!bool) && (!((String)localObject1).equals(".dat")))
        {
          if ((!((String)localObject1).equals(".gltf")) && (!((String)localObject1).equals(".datf")))
          {
            str = FilamentFilter.access$800();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("run: Undefined RES_POSTFIX: ");
            ((StringBuilder)localObject2).append((String)localObject1);
            Log.e(str, ((StringBuilder)localObject2).toString());
            str = "";
          }
          else
          {
            localObject1 = ".gltf";
          }
        }
        else
        {
          localObject1 = ".glb";
          str = ".dat";
        }
        Object localObject2 = FilamentFilter.access$800();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("start loading file");
        localStringBuilder.append(localGLBItemJava.path);
        localStringBuilder.append((String)localObject1);
        Log.v((String)localObject2, localStringBuilder.toString());
        localObject1 = FilamentUtil.loadAndTryDecryptGlb(localGLBItemJava.path, (String)localObject1, str);
        if ((localObject1 != null) && (localObject1.length > 0)) {
          FilamentFilter.access$900(this.this$0).put(localGLBItemJava, localObject1);
        } else {
          Log.e(FilamentFilter.access$800(), "Fail to load glb file. May crash later");
        }
      }
    }
    FilamentFilter.access$1102(this.this$0, true);
    FilaBenchUtil.benchEnd(FilamentUtil.BenchTag.IO.tag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentFilter.3
 * JD-Core Version:    0.7.0.1
 */