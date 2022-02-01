package me.weishu.epic.art;

import android.os.Build.VERSION;
import com.qq.android.dexposed.utility.Logger;
import com.qq.android.dexposed.utility.Runtime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.weishu.epic.art.arch.Arm64_2;
import me.weishu.epic.art.arch.ShellCode;
import me.weishu.epic.art.arch.Thumb2;
import me.weishu.epic.art.method.ArtMethod;

public final class Epic
{
  private static final Map<String, ArtMethod> a = new ConcurrentHashMap();
  private static final Map<Long, Epic.MethodInfo> b = new ConcurrentHashMap();
  private static final Map<Long, Trampoline> c = new HashMap();
  private static ShellCode d;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (Runtime.a()) {
      switch (i)
      {
      default: 
        break;
      case 24: 
      case 25: 
      case 26: 
      case 27: 
        d = new Arm64_2();
        break;
      case 23: 
        d = new Arm64_2();
        break;
      }
    } else if (Runtime.b()) {
      d = new Thumb2();
    } else {
      Logger.c("Epic", "ARM32, not support now.");
    }
    if (d != null)
    {
      localStringBuilder = new StringBuilder("Using: ");
      localStringBuilder.append(d.a());
      Logger.a("Epic", localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("Do not support this ARCH now!! API LEVEL:");
    localStringBuilder.append(i);
    throw new RuntimeException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     me.weishu.epic.art.Epic
 * JD-Core Version:    0.7.0.1
 */