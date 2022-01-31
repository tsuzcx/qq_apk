package com.tencent.ttpic;

import android.content.Context;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoPrefsUtil;

public class VideoModule
{
  public static boolean es_GL_EXT_shader_framebuffer_fetch;
  
  public static int getVersionCode()
  {
    return 480;
  }
  
  public static void init(Context paramContext)
  {
    VideoGlobalContext.setContext(paramContext);
    VideoPrefsUtil.init(paramContext);
    com.tencent.view.FilterDefault.ENABLE_GLFLUSH = true;
  }
  
  public static void initExtensionValues()
  {
    Object localObject = GLES20.glGetString(7939);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\s");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = localObject[i];
        if ((!TextUtils.isEmpty(localCharSequence)) && (localCharSequence.equals("GL_EXT_shader_framebuffer_fetch"))) {
          es_GL_EXT_shader_framebuffer_fetch = true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.VideoModule
 * JD-Core Version:    0.7.0.1
 */