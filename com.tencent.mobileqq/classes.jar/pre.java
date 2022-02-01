import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;

public class pre
{
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    if (!bmhv.b(pnn.a())) {
      if (QLog.isColorLevel()) {
        QLog.d("RIJSmartCropUtils", 2, "smart crop switch is false ! url : " + paramString);
      }
    }
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return paramString;
        } while ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("http://qqpublic.qpic.cn")));
        localObject2 = paramString.split("/");
      } while (localObject2.length < 2);
      localObject1 = localObject2[(localObject2.length - 2)].split("_");
    } while (localObject1.length < 1);
    Object localObject3 = localObject1[(localObject1.length - 1)];
    if ("open".equals(localObject3)) {}
    for (Object localObject1 = pjj.a;; localObject1 = pjj.b)
    {
      localObject1 = pqa.a((Pair[])localObject1, paramInt1, paramInt2);
      if (localObject1 == null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RIJSmartCropUtils", 2, "the picture size : w : " + paramInt1 + " h : " + paramInt2 + ", select scale : " + ((Pair)localObject1).first + ":" + ((Pair)localObject1).second);
      }
      localObject2 = localObject2[(localObject2.length - 1)];
      return paramString.replace(String.format("_%s/%s", new Object[] { localObject3, localObject2 }), String.format("_%s_%d_%d/%s", new Object[] { localObject3, ((Pair)localObject1).first, ((Pair)localObject1).second, localObject2 }));
      if (!"vsmcut".equals(localObject3)) {
        break;
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (paramString.startsWith("http://qqpublic.qpic.cn"))
      {
        paramString = paramString.split("/");
        bool1 = bool2;
        if (paramString.length >= 2)
        {
          paramString = paramString[(paramString.length - 2)].split("_");
          bool1 = bool2;
          if (paramString.length >= 1)
          {
            paramString = paramString[(paramString.length - 1)];
            if (!TextUtils.equals("open", paramString))
            {
              bool1 = bool2;
              if (!TextUtils.equals("vsmcut", paramString)) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pre
 * JD-Core Version:    0.7.0.1
 */