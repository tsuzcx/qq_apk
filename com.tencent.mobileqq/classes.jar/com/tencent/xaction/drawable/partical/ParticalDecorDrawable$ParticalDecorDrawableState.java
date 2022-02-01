package com.tencent.xaction.drawable.partical;

import android.graphics.Bitmap;
import androidx.annotation.Keep;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.base.DecorDrawableState;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/drawable/partical/ParticalDecorDrawable$ParticalDecorDrawableState;", "Lcom/tencent/xaction/api/base/DecorDrawableState;", "()V", "camY", "", "getCamY", "()F", "setCamY", "(F)V", "camZ", "getCamZ", "count", "", "getCount", "()I", "radius", "getRadius", "scale", "getScale", "speed", "getSpeed", "texture", "Landroid/graphics/Bitmap;", "getTexture", "()Landroid/graphics/Bitmap;", "buildDrawable", "Lcom/tencent/xaction/api/IDrawable;", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class ParticalDecorDrawable$ParticalDecorDrawableState
  extends DecorDrawableState
{
  private float camY = -1.0F;
  private final float camZ = -1.0F;
  private final int count = -1;
  private final float radius = -1.0F;
  private final float scale = -1.0F;
  private final float speed = -1.0F;
  @Nullable
  private final Bitmap texture;
  
  @NotNull
  public IDrawable buildDrawable()
  {
    return buildDrawable(ParticalDecorDrawable.class);
  }
  
  public final float getCamY()
  {
    return this.camY;
  }
  
  public final float getCamZ()
  {
    return this.camZ;
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  public final float getRadius()
  {
    return this.radius;
  }
  
  public final float getScale()
  {
    return this.scale;
  }
  
  public final float getSpeed()
  {
    return this.speed;
  }
  
  @Nullable
  public final Bitmap getTexture()
  {
    return this.texture;
  }
  
  public final void setCamY(float paramFloat)
  {
    this.camY = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.drawable.partical.ParticalDecorDrawable.ParticalDecorDrawableState
 * JD-Core Version:    0.7.0.1
 */