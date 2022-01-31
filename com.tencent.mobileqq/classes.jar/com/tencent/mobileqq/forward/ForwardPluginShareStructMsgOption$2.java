package com.tencent.mobileqq.forward;

import anvs;
import anwh;
import anzm;
import aqdq;
import bbdj;
import bbwg;
import bbwi;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.io.File;
import java.util.ArrayList;

public class ForwardPluginShareStructMsgOption$2
  implements Runnable
{
  public ForwardPluginShareStructMsgOption$2(aqdq paramaqdq, String paramString) {}
  
  public void run()
  {
    Object localObject1 = anzm.r.replace("[epId]", this.a);
    boolean bool = bbdj.a((String)localObject1);
    Object localObject2 = anzm.c.replace("[epId]", this.a);
    localObject1 = new File((String)localObject1);
    if (!bool)
    {
      localObject2 = new bbwg((String)localObject2, (File)localObject1);
      ((bbwg)localObject2).j = true;
      if (bbwi.a((bbwg)localObject2, this.this$0.a) != 0) {
        return;
      }
    }
    localObject2 = new EmoticonPackage();
    ((EmoticonPackage)localObject2).epId = this.a;
    ((EmoticonPackage)localObject2).jobType = 4;
    localObject1 = bbdj.a((File)localObject1);
    ArrayList localArrayList = new ArrayList();
    anwh.a(this.this$0.a, (EmoticonPackage)localObject2, anvs.c, (byte[])localObject1, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption.2
 * JD-Core Version:    0.7.0.1
 */