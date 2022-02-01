package org.light.gles;

import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;
import org.light.device.DeviceInstance;
import org.light.device.GpuScopeAttrs;
import org.light.device.GpuScopeAttrs.GpuBean.DeviceModel;
import org.light.device.GpuScopeAttrs.GpuBean.GpuModel;
import org.light.utils.LightLogUtil;
import org.light.utils.MustRunOnGLThread;

public class GLCapabilities
{
  public static final String FLIAMENT_TEST_FRAG_SHADER = "#version 300 es\nprecision highp float;\nlayout(location = 0) out vec4 fragColor;\n\n void main(void) {\n     const vec3 _347[2] = vec3[](vec3(1, 1, 1), vec3(1, 1, 1));\n\n     float _1025 = 0.0;\n     for (uint _1149 = 0u; _1149 < 2u; _1149++){\n         _1025 += _347[_1149].z;\n     }\n     fragColor = vec4(_1025 / 2.0);\n }";
  private static final String[] GPU_GL_ONE_THREAD = { "PowerVR SGX 544MP", "Adreno (TM) 306" };
  private static final String TAG = "GLCapabilities";
  private static boolean es_GL_EXT_shader_framebuffer_fetch = false;
  private static boolean es_GL_OES_texture_float = false;
  private static boolean es_GL_OES_texture_float_linear = false;
  private static boolean filamentShaderCompileSucceed;
  private static SimpleGLThread glThread;
  private static String glesVersion;
  private static String gpuInfo;
  private static volatile boolean mIsInit = false;
  private static int[] maxCombinedTextureImageUnits;
  private static int[] maxFragmentUniformComponents;
  private static int[] maxFragmentUniformVectors;
  private static int[] maxVertexTextureImageUnits = new int[1];
  private static int[] maxVertexUniformComponents;
  private static int[] maxVertexUniformVectors;
  
  static
  {
    maxCombinedTextureImageUnits = new int[1];
    maxVertexUniformVectors = new int[1];
    maxFragmentUniformVectors = new int[1];
    maxVertexUniformComponents = new int[1];
    maxFragmentUniformComponents = new int[1];
  }
  
  public static String getGPUInfo()
  {
    waitInitFinish();
    return gpuInfo;
  }
  
  public static String getGlesVersion()
  {
    
    if (glesVersion == null) {
      return "2.0";
    }
    try
    {
      String str = glesVersion.substring(10, 13);
      return str;
    }
    catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
    {
      localStringIndexOutOfBoundsException.printStackTrace();
    }
    return "2.0";
  }
  
  public static void init(boolean paramBoolean)
  {
    try
    {
      LightLogUtil.i("GLCapabilities", "init: enableFramebufferFetch=" + paramBoolean);
      if ((!mIsInit) && (glThread == null))
      {
        LightLogUtil.i("GLCapabilities", "init: async start");
        glThread = new SimpleGLThread(null, "GLCapabilities-Init");
        glThread.postJob(new GLCapabilities.1(paramBoolean));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @MustRunOnGLThread
  private static void initExtensionValues(boolean paramBoolean)
  {
    int i = 0;
    if (!paramBoolean)
    {
      es_GL_EXT_shader_framebuffer_fetch = false;
      return;
    }
    Object localObject = GLES20.glGetString(7939);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\s");
      int j = localObject.length;
      while (i < j)
      {
        CharSequence localCharSequence = localObject[i];
        if ((!TextUtils.isEmpty(localCharSequence)) && (localCharSequence.equals("GL_EXT_shader_framebuffer_fetch"))) {
          es_GL_EXT_shader_framebuffer_fetch = true;
        }
        if ((!TextUtils.isEmpty(localCharSequence)) && (localCharSequence.equals("GL_OES_texture_float"))) {
          es_GL_OES_texture_float = true;
        }
        if ((!TextUtils.isEmpty(localCharSequence)) && (localCharSequence.equals("GL_OES_texture_float_linear"))) {
          es_GL_OES_texture_float_linear = true;
        }
        i += 1;
      }
    }
    initGLExtensionRelatedShaders();
  }
  
  @MustRunOnGLThread
  private static void initFilamentValues()
  {
    try
    {
      filamentShaderCompileSucceed = testCompileShader(35632, "#version 300 es\nprecision highp float;\nlayout(location = 0) out vec4 fragColor;\n\n void main(void) {\n     const vec3 _347[2] = vec3[](vec3(1, 1, 1), vec3(1, 1, 1));\n\n     float _1025 = 0.0;\n     for (uint _1149 = 0u; _1149 < 2u; _1149++){\n         _1025 += _347[_1149].z;\n     }\n     fragColor = vec4(_1025 / 2.0);\n }");
      return;
    }
    catch (Exception localException)
    {
      LightLogUtil.e("GLCapabilities", localException.toString());
    }
  }
  
  private static void initGLExtensionRelatedShaders() {}
  
  private static void initGpuInfo()
  {
    String str1 = GLES20.glGetString(7937);
    String str2 = GLES20.glGetString(7936);
    glesVersion = GLES20.glGetString(7938);
    gpuInfo = str1 + "; " + str2 + "; " + glesVersion;
    LightLogUtil.d("GLCapabilities", "GPU = " + gpuInfo);
  }
  
  private static void initImpl(boolean paramBoolean)
  {
    initGpuInfo();
    initExtensionValues(paramBoolean);
    initReshapeValues();
    initFilamentValues();
  }
  
  @MustRunOnGLThread
  private static void initReshapeValues()
  {
    GLES20.glGetIntegerv(35660, maxVertexTextureImageUnits, 0);
    GLES20.glGetIntegerv(35661, maxCombinedTextureImageUnits, 0);
    LightLogUtil.d("GLCapabilities", String.format("[vtf] vtf = %d, all = %d", new Object[] { Integer.valueOf(maxVertexTextureImageUnits[0]), Integer.valueOf(maxCombinedTextureImageUnits[0]) }));
  }
  
  @MustRunOnGLThread
  private static void initUniformValues()
  {
    GLES20.glGetIntegerv(36347, maxVertexUniformVectors, 0);
    GLES20.glGetIntegerv(36349, maxFragmentUniformVectors, 0);
    GLES20.glGetIntegerv(35658, maxVertexUniformComponents, 0);
    GLES20.glGetIntegerv(35657, maxFragmentUniformComponents, 0);
    LightLogUtil.d("GLCapabilities", String.format("[uniform] GL_MAX_VERTEX_UNIFORM_VECTORS = %d, GL_MAX_FRAGMENT_UNIFORM_VECTORS = %d", new Object[] { Integer.valueOf(maxVertexUniformVectors[0]), Integer.valueOf(maxFragmentUniformVectors[0]) }));
    LightLogUtil.d("GLCapabilities", String.format("[uniform] GL_MAX_VERTEX_UNIFORM_COMPONENTS = %d, GL_MAX_FRAGMENT_UNIFORM_COMPONENTS = %d", new Object[] { Integer.valueOf(maxVertexUniformComponents[0]), Integer.valueOf(maxFragmentUniformComponents[0]) }));
  }
  
  public static boolean isDeviceSupportAceEngine()
  {
    Object localObject = GpuScopeAttrs.getInstance().getGPuModel();
    if (localObject == null)
    {
      localObject = GpuScopeAttrs.getInstance().getDeviceModel();
      if (localObject != null) {}
    }
    while ((((GpuScopeAttrs.GpuBean.GpuModel)localObject).filamentSupport) || ((((GpuScopeAttrs.GpuBean.GpuModel)localObject).filamentWhiteList != null) && (((GpuScopeAttrs.GpuBean.GpuModel)localObject).filamentWhiteList.contains(DeviceInstance.getInstance().getDeviceName()))))
    {
      return true;
      return ((GpuScopeAttrs.GpuBean.DeviceModel)localObject).filamentSupport;
    }
    return false;
  }
  
  public static boolean isDeviceSupportAiAbility()
  {
    Object localObject = GpuScopeAttrs.getInstance().getDeviceModel();
    if (localObject == null)
    {
      localObject = GpuScopeAttrs.getInstance().getGPuModel();
      if (localObject == null) {
        return true;
      }
      return ((GpuScopeAttrs.GpuBean.GpuModel)localObject).aiSupport;
    }
    return ((GpuScopeAttrs.GpuBean.DeviceModel)localObject).aiSupport;
  }
  
  public static boolean isDeviceSupportGPUSegment()
  {
    Object localObject = GpuScopeAttrs.getInstance().getDeviceModel();
    if (localObject == null)
    {
      localObject = GpuScopeAttrs.getInstance().getGPuModel();
      if (localObject == null) {
        return true;
      }
      return ((GpuScopeAttrs.GpuBean.GpuModel)localObject).gpuSegment;
    }
    return ((GpuScopeAttrs.GpuBean.DeviceModel)localObject).gpuSegment;
  }
  
  public static boolean isDeviceSupportKapu()
  {
    Object localObject = GpuScopeAttrs.getInstance().getDeviceModel();
    if (localObject == null)
    {
      localObject = GpuScopeAttrs.getInstance().getGPuModel();
      if (localObject == null) {
        return true;
      }
      return ((GpuScopeAttrs.GpuBean.GpuModel)localObject).kapuSupport;
    }
    return ((GpuScopeAttrs.GpuBean.DeviceModel)localObject).kapuSupport;
  }
  
  public static boolean isFilamentShaderCompileSucceed()
  {
    waitInitFinish();
    return filamentShaderCompileSucceed;
  }
  
  public static boolean isInOneGLThreadBlackList()
  {
    boolean bool2 = false;
    Object localObject = getGPUInfo().split(";");
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (localObject.length > 0)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(localObject[0]))
      {
        localObject = localObject[0].trim().toLowerCase();
        arrayOfString = GPU_GL_ONE_THREAD;
        j = arrayOfString.length;
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (((String)localObject).equals(arrayOfString[i].toLowerCase())) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean isShareGLContextError()
  {
    Object localObject = GpuScopeAttrs.getInstance().getDeviceModel();
    if (localObject == null)
    {
      localObject = GpuScopeAttrs.getInstance().getGPuModel();
      if (localObject == null) {
        return false;
      }
      return ((GpuScopeAttrs.GpuBean.GpuModel)localObject).shareGLContextError;
    }
    return ((GpuScopeAttrs.GpuBean.DeviceModel)localObject).shareGLContextError;
  }
  
  public static boolean isSupportFloatTexture()
  {
    waitInitFinish();
    return (es_GL_OES_texture_float) && (es_GL_OES_texture_float_linear);
  }
  
  public static boolean isSupportFramebufferFetch()
  {
    waitInitFinish();
    return es_GL_EXT_shader_framebuffer_fetch;
  }
  
  @MustRunOnGLThread
  public static boolean supportVTF()
  {
    boolean bool = false;
    initReshapeValues();
    if (maxVertexTextureImageUnits[0] > 0) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean testCompileShader(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    Object localObject = new int[1];
    GLES20.glCompileShader(paramInt);
    GLES20.glGetShaderiv(paramInt, 35713, (int[])localObject, 0);
    if (localObject[0] == 0)
    {
      localObject = GLES20.glGetShaderInfoLog(paramInt);
      GLES20.glDeleteShader(paramInt);
      Log.e("GLCapabilities", "vertex shader test compile failed, shader : [" + paramString + "]");
      Log.e("GLCapabilities", (String)localObject);
      GLES20.glDeleteShader(paramInt);
      return false;
    }
    GLES20.glDeleteShader(paramInt);
    return true;
  }
  
  private static void useInWrongTime()
  {
    new IllegalStateException("must call init method first");
  }
  
  private static void waitInitFinish()
  {
    if (!mIsInit)
    {
      if (glThread == null) {
        break label31;
      }
      glThread.waitDone(200);
      if (!mIsInit) {
        useInWrongTime();
      }
    }
    return;
    label31:
    useInWrongTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.gles.GLCapabilities
 * JD-Core Version:    0.7.0.1
 */