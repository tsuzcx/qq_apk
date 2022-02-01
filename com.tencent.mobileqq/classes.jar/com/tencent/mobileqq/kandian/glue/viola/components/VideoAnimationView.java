package com.tencent.mobileqq.kandian.glue.viola.components;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.view.TextureView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vpng.glrenderer.Renderable;
import com.tencent.mobileqq.vpng.glrenderer.VPNGRenderer;
import com.tencent.mobileqq.vpng.glrenderer.VPNGRendererManager;
import com.tencent.mobileqq.vpng.view.VPNGImageView;
import com.tencent.viola.ui.view.IVView;
import cooperation.liveroom.LiveRoomGiftCallback;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/components/VideoAnimationView;", "Lcom/tencent/mobileqq/vpng/view/VPNGImageView;", "Lcom/tencent/viola/ui/view/IVView;", "Lcom/tencent/mobileqq/kandian/glue/viola/components/VideoAnimationComponent;", "Lcooperation/liveroom/LiveRoomGiftCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "componentWeakRef", "Ljava/lang/ref/WeakReference;", "currentState", "", "isAutoPlay", "", "bindComponent", "", "component", "destroy", "fireStateChange", "state", "getComponent", "getFilePath", "", "src", "init", "autoPlay", "loop", "onCall", "type", "args", "onSurfaceTextureAvailable", "surface", "Landroid/graphics/SurfaceTexture;", "width", "height", "pause", "play", "playOnSubThread", "resume", "setVideo", "path", "isLoop", "align", "callback", "setupVideo", "stop", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoAnimationView
  extends VPNGImageView
  implements IVView<VideoAnimationComponent>, LiveRoomGiftCallback
{
  public static final VideoAnimationView.Companion a = new VideoAnimationView.Companion(null);
  @NotNull
  private static final Map<Integer, Integer> e;
  private WeakReference<VideoAnimationComponent> b;
  private boolean c = true;
  private int d;
  
  static
  {
    Integer localInteger1 = Integer.valueOf(3);
    Object localObject = Integer.valueOf(1);
    localObject = TuplesKt.to(localObject, localObject);
    Integer localInteger2 = Integer.valueOf(2);
    e = MapsKt.mutableMapOf(new Pair[] { localObject, TuplesKt.to(localInteger2, localInteger2), TuplesKt.to(localInteger1, localInteger1) });
  }
  
  public VideoAnimationView(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  private final String a(String paramString)
  {
    int i = StringsKt.lastIndexOf$default((CharSequence)paramString, '/', 0, false, 6, null);
    if (i != -1)
    {
      int j = paramString.length();
      if (paramString != null)
      {
        paramString = paramString.substring(i + 1, j);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (!TextUtils.isEmpty((CharSequence)paramString))
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(AppConstants.SDCARD_PATH);
          localStringBuilder2.append(".readInjoy/resource/video_animation/");
          localStringBuilder1.append(VFSAssistantUtils.getSDKPrivatePath(localStringBuilder2.toString()));
          localStringBuilder1.append(paramString);
          return localStringBuilder1.toString();
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    return "";
  }
  
  private final void a(int paramInt)
  {
    VideoAnimationComponent localVideoAnimationComponent = getComponent();
    if (localVideoAnimationComponent != null) {
      localVideoAnimationComponent.fireEvent("stateChange", new JSONObject().put("state", paramInt));
    }
  }
  
  private final void a(String paramString, boolean paramBoolean)
  {
    String str = a(paramString);
    if (!TextUtils.isEmpty((CharSequence)str))
    {
      File localFile = new File(str);
      if (localFile.exists())
      {
        setVideo(str, paramBoolean, 1, (LiveRoomGiftCallback)this);
        return;
      }
      ThreadManagerV2.executeOnSubThread((Runnable)new VideoAnimationView.setupVideo.1(paramString, localFile));
    }
    setVideo(paramString, paramBoolean, 1, (LiveRoomGiftCallback)this);
  }
  
  private final void f()
  {
    if (this.mVPNGRenderer == null) {
      return;
    }
    this.d = 1;
    if (!this.c)
    {
      this.mVPNGRenderer.a(getWidth(), getHeight());
      VPNGRenderer localVPNGRenderer = this.mVPNGRenderer;
      TextureView localTextureView = this.mTextureView;
      Intrinsics.checkExpressionValueIsNotNull(localTextureView, "mTextureView");
      localVPNGRenderer.a(localTextureView.getSurfaceTexture());
    }
    playRender();
    a(1);
  }
  
  public final void a()
  {
    if (this.d == 1) {
      return;
    }
    f();
  }
  
  public void a(@Nullable VideoAnimationComponent paramVideoAnimationComponent)
  {
    this.b = new WeakReference(paramVideoAnimationComponent);
  }
  
  public final void a(boolean paramBoolean1, @NotNull String paramString, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "src");
    this.c = paramBoolean1;
    setPlayOnSubThread(true);
    a(paramString, paramBoolean2);
  }
  
  public final void b()
  {
    if ((this.d == 1) && (this.mVPNGRenderer != null))
    {
      this.mVPNGRenderer.i();
      this.d = 2;
    }
  }
  
  public final void c()
  {
    if ((this.d == 2) && (this.mVPNGRenderer != null))
    {
      this.mVPNGRenderer.j();
      this.d = 1;
      a(1);
    }
  }
  
  public final void d()
  {
    int i = this.d;
    if (((i == 1) || (i == 2)) && (this.mVPNGRenderer != null))
    {
      this.mVPNGRenderer.c();
      this.d = 3;
    }
  }
  
  public final void e()
  {
    d();
  }
  
  @Nullable
  public VideoAnimationComponent getComponent()
  {
    WeakReference localWeakReference = this.b;
    if (localWeakReference != null) {
      return (VideoAnimationComponent)localWeakReference.get();
    }
    return null;
  }
  
  public void onCall(int paramInt, @Nullable String paramString)
  {
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 7) {
          paramInt = 0;
        } else {
          paramInt = 3;
        }
      }
      else {
        paramInt = 1;
      }
    }
    else {
      paramInt = 2;
    }
    if ((!this.c) && (this.d == 3)) {
      return;
    }
    if ((paramInt != 0) && (paramInt != this.d))
    {
      this.d = paramInt;
      paramString = (Integer)e.get(Integer.valueOf(paramInt));
      if (paramString != null) {
        a(((Number)paramString).intValue());
      }
    }
  }
  
  public void onSurfaceTextureAvailable(@Nullable SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (this.mVPNGRenderer == null)
    {
      this.mVPNGRenderer = VPNGRendererManager.a().a((Renderable)this, this.mWidth, this.mHeight);
      if (this.mVPNGRenderer != null)
      {
        this.mVPNGRenderer.a(this.mVideoPath, this.mAlign, this.mCallback);
        this.mVPNGRenderer.b(this.mIsLoop);
      }
    }
    if ((this.c) && (this.mVPNGRenderer != null))
    {
      this.mVPNGRenderer.a(paramInt1, paramInt2);
      this.mVPNGRenderer.a(paramSurfaceTexture);
      f();
    }
    paramSurfaceTexture = this.mTextureView;
    Intrinsics.checkExpressionValueIsNotNull(paramSurfaceTexture, "mTextureView");
    paramSurfaceTexture.setAlpha(0.0F);
  }
  
  public void setVideo(@Nullable String paramString, boolean paramBoolean, int paramInt, @Nullable LiveRoomGiftCallback paramLiveRoomGiftCallback)
  {
    super.setVideo(paramString, paramBoolean, paramInt, paramLiveRoomGiftCallback);
    if (this.mVPNGRenderer != null) {
      this.mVPNGRenderer.a("attribute vec4 vPosition;\nattribute vec4 vTexCoordinate;\nattribute vec4 vTexAlphaCoordinate;\nuniform mat4 textureTransform;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexAlphaCoordinate;\nvoid main () {\n    v_TexCoordinate = (textureTransform * vTexCoordinate).xy;\n    v_TexAlphaCoordinate = (textureTransform * vTexAlphaCoordinate).xy;\n    gl_Position = vPosition;\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES texture;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexAlphaCoordinate;\nvoid main () {\n    vec4 color = texture2D(texture, v_TexCoordinate);\n    float r = texture2D(texture, v_TexAlphaCoordinate).r;\n    float g = texture2D(texture, v_TexAlphaCoordinate).g;\n    float b = texture2D(texture, v_TexAlphaCoordinate).b;\n    float alpha = min(r, min(g, b)) * texture2D(texture, v_TexAlphaCoordinate).a;\n    gl_FragColor = color;\n    gl_FragColor.a = gl_FragColor.a * alpha;\n    gl_FragColor.r = gl_FragColor.r;\n    gl_FragColor.g = gl_FragColor.g;\n    gl_FragColor.b = gl_FragColor.b;\n}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.components.VideoAnimationView
 * JD-Core Version:    0.7.0.1
 */