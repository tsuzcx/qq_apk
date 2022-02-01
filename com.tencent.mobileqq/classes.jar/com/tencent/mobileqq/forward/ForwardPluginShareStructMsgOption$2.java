package com.tencent.mobileqq.forward;

import asih;
import asiw;
import bhyo;
import bhyq;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;

class ForwardPluginShareStructMsgOption$2
  implements Runnable
{
  ForwardPluginShareStructMsgOption$2(ForwardPluginShareStructMsgOption paramForwardPluginShareStructMsgOption, String paramString) {}
  
  public void run()
  {
    Object localObject1 = EmoticonUtils.emoticonJsonFilePath.replace("[epId]", this.a);
    boolean bool = FileUtils.fileExists((String)localObject1);
    Object localObject2 = EmoticonUtils.smallEmoticonJsonUrl.replace("[epId]", this.a);
    localObject1 = new File((String)localObject1);
    if (!bool)
    {
      localObject2 = new bhyo((String)localObject2, (File)localObject1);
      ((bhyo)localObject2).j = true;
      if (bhyq.a((bhyo)localObject2, this.this$0.a) != 0) {
        return;
      }
    }
    localObject2 = new EmoticonPackage();
    ((EmoticonPackage)localObject2).epId = this.a;
    ((EmoticonPackage)localObject2).jobType = 4;
    localObject1 = FileUtils.fileToBytes((File)localObject1);
    ArrayList localArrayList = new ArrayList();
    asiw.a(this.this$0.a, (EmoticonPackage)localObject2, asih.c, (byte[])localObject1, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption.2
 * JD-Core Version:    0.7.0.1
 */