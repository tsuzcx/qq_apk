import android.opengl.GLES20;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.program.YUVTextureAliasingProgram;
import com.tencent.av.opengl.program.YUVTextureProgram;
import java.util.HashMap;
import java.util.Map;

public class ltu
{
  static Map<String, TextureProgram> a = new HashMap();
  
  public static TextureProgram a(int paramInt)
  {
    int j = 1;
    for (;;)
    {
      int i;
      try
      {
        String str = paramInt + "_" + Thread.currentThread().getId();
        localObject1 = (TextureProgram)a.get(str);
        if (localObject1 == null)
        {
          i = 1;
          if (i != 0) {
            break label173;
          }
          GLES20.glUseProgram(((TextureProgram)localObject1).a());
          if (lux.a() != 0)
          {
            i = j;
            break label173;
            localObject1 = new TextureProgram();
            a.put(str, localObject1);
            return localObject1;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        i = 0;
      }
      finally {}
      Object localObject1 = new YUVTextureProgram();
      continue;
      Object localObject3 = new YUVTextureAliasingProgram();
      continue;
      localObject3 = new ltt();
      continue;
      localObject3 = new lts();
      continue;
      localObject3 = new ltr();
      continue;
      label173:
      if (i != 0) {
        switch (paramInt)
        {
        }
      }
    }
  }
  
  public static void a()
  {
    try
    {
      a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ltu
 * JD-Core Version:    0.7.0.1
 */