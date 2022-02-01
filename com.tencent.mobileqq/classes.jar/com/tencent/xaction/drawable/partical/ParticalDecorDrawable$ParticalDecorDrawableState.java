package com.tencent.xaction.drawable.partical;

import android.graphics.Bitmap;
import androidx.annotation.Keep;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.base.DecorDrawableState;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/drawable/partical/ParticalDecorDrawable$ParticalDecorDrawableState;", "Lcom/tencent/xaction/api/base/DecorDrawableState;", "()V", "count", "", "getCount", "()I", "distance", "getDistance", "height", "", "getHeight", "()F", "radius", "getRadius", "roundPI", "getRoundPI", "scale", "getScale", "speed", "getSpeed", "texture", "Landroid/graphics/Bitmap;", "getTexture", "()Landroid/graphics/Bitmap;", "width", "getWidth", "buildDrawable", "Lcom/tencent/xaction/api/IDrawable;", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class ParticalDecorDrawable$ParticalDecorDrawableState
  extends DecorDrawableState
{
  private final int count = 1;
  private final int distance = 300;
  private final float height = ScreenUnit.a.a();
  private final int radius = 4;
  private final int roundPI = 790;
  private final float scale = 1.0F;
  private final float speed = 0.4F;
  @Nullable
  private final Bitmap texture;
  private final float width = 750.0F;
  
  @NotNull
  public IDrawable buildDrawable()
  {
    return buildDrawable(ParticalDecorDrawable.class);
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  public final int getDistance()
  {
    return this.distance;
  }
  
  public final float getHeight()
  {
    return this.height;
  }
  
  public final int getRadius()
  {
    return this.radius;
  }
  
  public final int getRoundPI()
  {
    return this.roundPI;
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
  
  public final float getWidth()
  {
    return this.width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.drawable.partical.ParticalDecorDrawable.ParticalDecorDrawableState
 * JD-Core Version:    0.7.0.1
 */