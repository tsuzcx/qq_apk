package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import java.io.File;
import java.util.HashSet;

public class Taurus
  extends Thread
{
  public Taurus(UrsaMajor paramUrsaMajor) {}
  
  public void run()
  {
    Context localContext = this.get();
    Bilberry.d(localContext, UrsaMajor.a(this.this$0));
    try
    {
      Thread.sleep(5000L);
      UrsaMajor.J();
      UrsaMajor.a(this.this$0, localContext, 1, true);
      if (Avocado.zg.g(Auriga.ti.value))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        try
        {
          localObject1 = new String(extends.h("/proc/self/maps"));
          String[] arrayOfString = ((String)localObject1).split("\n");
          localHashSet = new HashSet();
          int j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            localObject1 = arrayOfString[i];
            localObject1 = ((String)localObject1).split(" +");
            if (localObject1.length < 2) {
              break label421;
            }
            str = localObject1[(localObject1.length - 1)].trim();
            localObject1 = null;
          }
        }
        catch (Throwable localThrowable1)
        {
          Object localObject1;
          HashSet localHashSet;
          String str;
          Object localObject3;
          label177:
          boolean bool;
          int k;
          localStringBuilder.append(",");
          localObject2 = Resources.getSystem().getClass().getName();
          if (!TextUtils.equals("android.content.res.Resources", (CharSequence)localObject2)) {
            localStringBuilder.append((String)localObject2);
          }
          localObject2 = localStringBuilder.toString().replace("(\\|)|\\s*|\t|\r|\n", "");
          UrsaMajor.a(this.this$0).a(localContext, "405", (String)localObject2, true);
        }
      }
      else
      {
        try
        {
          localObject3 = new File(str);
          if (!((File)localObject3).exists()) {
            break label421;
          }
          localObject3 = ((File)localObject3).getName();
          localObject1 = localObject3;
        }
        catch (Throwable localThrowable2)
        {
          break label177;
        }
        if (localObject1 != null)
        {
          bool = ((String)localObject1).contains("res");
          if (bool)
          {
            bool = ((String)localObject1).endsWith(".apk");
            if (bool)
            {
              bool = ((String)localObject1).contains("mediatek");
              if ((!bool) && (!TextUtils.equals("/system/framework/framework-res.apk", str)) && (!localHashSet.contains(str)))
              {
                localHashSet.add(str);
                localObject1 = this.a(localContext, str);
                if (localObject1 != null)
                {
                  bool = TextUtils.equals((CharSequence)localObject1, "android.auto_generated_rro__");
                  if ((!bool) && (!TextUtils.equals((CharSequence)localObject1, "android.overlay")))
                  {
                    k = localStringBuilder.length();
                    if (k > 0) {
                      localStringBuilder.append(":");
                    }
                    localStringBuilder.append((String)localObject1);
                    break label421;
                    Object localObject2 = this.this$0;
                    UrsaMajor.a((UrsaMajor)localObject2, UrsaMajor.b((UrsaMajor)localObject2).getContext(), false);
                    return;
                  }
                }
              }
            }
          }
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        int i;
        continue;
        label421:
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Taurus
 * JD-Core Version:    0.7.0.1
 */