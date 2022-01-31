package com.tencent.mobileqq.intervideo.groupvideo;

import android.os.Handler;
import aszn;
import atam;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.Map;

public class IVPluginLoader$1
  implements Runnable
{
  public IVPluginLoader$1(atam paramatam, String paramString1, String paramString2, String paramString3, String paramString4, Map paramMap) {}
  
  public void run()
  {
    aszn.a().a(this.jdField_a_of_type_JavaLangString, atam.a(this.this$0));
    ThreadManagerV2.getUIHandlerV2().post(new IVPluginLoader.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.IVPluginLoader.1
 * JD-Core Version:    0.7.0.1
 */