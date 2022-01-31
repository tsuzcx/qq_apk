package com.tencent.tmediacodec.hook;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/hook/THookTextureView;", "Landroid/view/TextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mInnerSetListener", "Landroid/view/TextureView$SurfaceTextureListener;", "mOutSetListener", "setSurfaceTextureListener", "", "listener", "Companion", "SurfaceTextureHookCallback", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public class THookTextureView
  extends TextureView
{
  public static final THookTextureView.Companion Companion = new THookTextureView.Companion(null);
  @Nullable
  private static THookTextureView.SurfaceTextureHookCallback hookCallback;
  private HashMap _$_findViewCache;
  private TextureView.SurfaceTextureListener mInnerSetListener = (TextureView.SurfaceTextureListener)new THookTextureView.mInnerSetListener.1(this);
  private TextureView.SurfaceTextureListener mOutSetListener;
  
  public THookTextureView(@Nullable Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public THookTextureView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public THookTextureView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void setSurfaceTextureListener(@Nullable TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    this.mOutSetListener = paramSurfaceTextureListener;
    super.setSurfaceTextureListener(this.mInnerSetListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.THookTextureView
 * JD-Core Version:    0.7.0.1
 */