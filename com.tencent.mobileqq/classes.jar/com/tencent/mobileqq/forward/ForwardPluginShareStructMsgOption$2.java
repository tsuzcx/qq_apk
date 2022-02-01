package com.tencent.mobileqq.forward;

import arup;
import arve;
import arze;
import bgmg;
import bhhf;
import bhhh;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.io.File;
import java.util.ArrayList;

class ForwardPluginShareStructMsgOption$2
  implements Runnable
{
  ForwardPluginShareStructMsgOption$2(ForwardPluginShareStructMsgOption paramForwardPluginShareStructMsgOption, String paramString) {}
  
  public void run()
  {
    Object localObject1 = arze.r.replace("[epId]", this.a);
    boolean bool = bgmg.a((String)localObject1);
    Object localObject2 = arze.c.replace("[epId]", this.a);
    localObject1 = new File((String)localObject1);
    if (!bool)
    {
      localObject2 = new bhhf((String)localObject2, (File)localObject1);
      ((bhhf)localObject2).j = true;
      if (bhhh.a((bhhf)localObject2, this.this$0.a) != 0) {
        return;
      }
    }
    localObject2 = new EmoticonPackage();
    ((EmoticonPackage)localObject2).epId = this.a;
    ((EmoticonPackage)localObject2).jobType = 4;
    localObject1 = bgmg.a((File)localObject1);
    ArrayList localArrayList = new ArrayList();
    arve.a(this.this$0.a, (EmoticonPackage)localObject2, arup.c, (byte[])localObject1, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption.2
 * JD-Core Version:    0.7.0.1
 */