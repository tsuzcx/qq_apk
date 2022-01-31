package com.tencent.mobileqq.forward;

import anvx;
import anwm;
import anzr;
import aqds;
import bbdx;
import bbwu;
import bbww;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.io.File;
import java.util.ArrayList;

public class ForwardPluginShareStructMsgOption$2
  implements Runnable
{
  public ForwardPluginShareStructMsgOption$2(aqds paramaqds, String paramString) {}
  
  public void run()
  {
    Object localObject1 = anzr.r.replace("[epId]", this.a);
    boolean bool = bbdx.a((String)localObject1);
    Object localObject2 = anzr.c.replace("[epId]", this.a);
    localObject1 = new File((String)localObject1);
    if (!bool)
    {
      localObject2 = new bbwu((String)localObject2, (File)localObject1);
      ((bbwu)localObject2).j = true;
      if (bbww.a((bbwu)localObject2, this.this$0.a) != 0) {
        return;
      }
    }
    localObject2 = new EmoticonPackage();
    ((EmoticonPackage)localObject2).epId = this.a;
    ((EmoticonPackage)localObject2).jobType = 4;
    localObject1 = bbdx.a((File)localObject1);
    ArrayList localArrayList = new ArrayList();
    anwm.a(this.this$0.a, (EmoticonPackage)localObject2, anvx.c, (byte[])localObject1, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption.2
 * JD-Core Version:    0.7.0.1
 */