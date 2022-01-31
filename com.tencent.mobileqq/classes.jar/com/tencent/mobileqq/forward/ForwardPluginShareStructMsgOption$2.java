package com.tencent.mobileqq.forward;

import anfj;
import anfy;
import anjd;
import apkd;
import bace;
import batm;
import bato;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.io.File;
import java.util.ArrayList;

public class ForwardPluginShareStructMsgOption$2
  implements Runnable
{
  public ForwardPluginShareStructMsgOption$2(apkd paramapkd, String paramString) {}
  
  public void run()
  {
    Object localObject1 = anjd.r.replace("[epId]", this.a);
    boolean bool = bace.a((String)localObject1);
    Object localObject2 = anjd.c.replace("[epId]", this.a);
    localObject1 = new File((String)localObject1);
    if (!bool)
    {
      localObject2 = new batm((String)localObject2, (File)localObject1);
      ((batm)localObject2).j = true;
      if (bato.a((batm)localObject2, this.this$0.a) != 0) {
        return;
      }
    }
    localObject2 = new EmoticonPackage();
    ((EmoticonPackage)localObject2).epId = this.a;
    ((EmoticonPackage)localObject2).jobType = 4;
    localObject1 = bace.a((File)localObject1);
    ArrayList localArrayList = new ArrayList();
    anfy.a(this.this$0.a, (EmoticonPackage)localObject2, anfj.c, (byte[])localObject1, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption.2
 * JD-Core Version:    0.7.0.1
 */