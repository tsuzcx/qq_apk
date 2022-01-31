package com.tencent.mobileqq.forward;

import apro;
import apsd;
import apvx;
import asbj;
import bdhb;
import beae;
import beag;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.io.File;
import java.util.ArrayList;

public class ForwardPluginShareStructMsgOption$2
  implements Runnable
{
  public ForwardPluginShareStructMsgOption$2(asbj paramasbj, String paramString) {}
  
  public void run()
  {
    Object localObject1 = apvx.r.replace("[epId]", this.a);
    boolean bool = bdhb.a((String)localObject1);
    Object localObject2 = apvx.c.replace("[epId]", this.a);
    localObject1 = new File((String)localObject1);
    if (!bool)
    {
      localObject2 = new beae((String)localObject2, (File)localObject1);
      ((beae)localObject2).j = true;
      if (beag.a((beae)localObject2, this.this$0.a) != 0) {
        return;
      }
    }
    localObject2 = new EmoticonPackage();
    ((EmoticonPackage)localObject2).epId = this.a;
    ((EmoticonPackage)localObject2).jobType = 4;
    localObject1 = bdhb.a((File)localObject1);
    ArrayList localArrayList = new ArrayList();
    apsd.a(this.this$0.a, (EmoticonPackage)localObject2, apro.c, (byte[])localObject1, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption.2
 * JD-Core Version:    0.7.0.1
 */