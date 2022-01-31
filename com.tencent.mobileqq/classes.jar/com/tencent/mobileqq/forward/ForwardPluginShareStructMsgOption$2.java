package com.tencent.mobileqq.forward;

import apnf;
import apnu;
import apro;
import arxa;
import bdcs;
import bdvv;
import bdvx;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.io.File;
import java.util.ArrayList;

public class ForwardPluginShareStructMsgOption$2
  implements Runnable
{
  public ForwardPluginShareStructMsgOption$2(arxa paramarxa, String paramString) {}
  
  public void run()
  {
    Object localObject1 = apro.r.replace("[epId]", this.a);
    boolean bool = bdcs.a((String)localObject1);
    Object localObject2 = apro.c.replace("[epId]", this.a);
    localObject1 = new File((String)localObject1);
    if (!bool)
    {
      localObject2 = new bdvv((String)localObject2, (File)localObject1);
      ((bdvv)localObject2).j = true;
      if (bdvx.a((bdvv)localObject2, this.this$0.a) != 0) {
        return;
      }
    }
    localObject2 = new EmoticonPackage();
    ((EmoticonPackage)localObject2).epId = this.a;
    ((EmoticonPackage)localObject2).jobType = 4;
    localObject1 = bdcs.a((File)localObject1);
    ArrayList localArrayList = new ArrayList();
    apnu.a(this.this$0.a, (EmoticonPackage)localObject2, apnf.c, (byte[])localObject1, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption.2
 * JD-Core Version:    0.7.0.1
 */