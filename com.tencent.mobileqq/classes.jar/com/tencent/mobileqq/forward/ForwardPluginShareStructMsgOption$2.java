package com.tencent.mobileqq.forward;

import askd;
import asks;
import asos;
import bhmi;
import bihu;
import bihw;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.io.File;
import java.util.ArrayList;

class ForwardPluginShareStructMsgOption$2
  implements Runnable
{
  ForwardPluginShareStructMsgOption$2(ForwardPluginShareStructMsgOption paramForwardPluginShareStructMsgOption, String paramString) {}
  
  public void run()
  {
    Object localObject1 = asos.r.replace("[epId]", this.a);
    boolean bool = bhmi.a((String)localObject1);
    Object localObject2 = asos.c.replace("[epId]", this.a);
    localObject1 = new File((String)localObject1);
    if (!bool)
    {
      localObject2 = new bihu((String)localObject2, (File)localObject1);
      ((bihu)localObject2).j = true;
      if (bihw.a((bihu)localObject2, this.this$0.a) != 0) {
        return;
      }
    }
    localObject2 = new EmoticonPackage();
    ((EmoticonPackage)localObject2).epId = this.a;
    ((EmoticonPackage)localObject2).jobType = 4;
    localObject1 = bhmi.a((File)localObject1);
    ArrayList localArrayList = new ArrayList();
    asks.a(this.this$0.a, (EmoticonPackage)localObject2, askd.c, (byte[])localObject1, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption.2
 * JD-Core Version:    0.7.0.1
 */