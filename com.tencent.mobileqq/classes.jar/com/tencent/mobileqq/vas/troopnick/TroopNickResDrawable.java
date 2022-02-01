package com.tencent.mobileqq.vas.troopnick;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.text.TextUtils;
import com.qflutter.resource_loader.NinePatchChunk;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.VasResEngine.AbsVasRes;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.ui.VasNinePathBitmap;
import kotlin.Triple;

public class TroopNickResDrawable
  extends VasResDrawable
  implements Handler.Callback, AbsVasRes
{
  private PointF F;
  private boolean G = false;
  private TroopNickResDrawable.UpdateDrawablePadding H;
  private VasNinePathBitmap I = new VasNinePathBitmap();
  private int J = 0;
  private Rect K = new Rect();
  int l = 0;
  
  public TroopNickResDrawable(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.p = new VasNinePathBitmap();
    this.J = paramInt;
  }
  
  protected Drawable a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    if (this.I.c()) {
      ThreadManagerV2.executeOnSubThread(new TroopNickResDrawable.1(this, paramString2));
    }
    return null;
  }
  
  protected void a(@android.support.annotation.NonNull Canvas paramCanvas)
  {
    if (this.C) {
      this.I.a(paramCanvas, null, getBounds(), this.o);
    }
  }
  
  public void a(PointF paramPointF)
  {
    this.F = paramPointF;
    this.G = true;
  }
  
  public void a(Rect paramRect)
  {
    if ((this.F != null) && (this.G))
    {
      Object localObject2 = (VasNinePathBitmap)this.p;
      if (localObject2 == null) {
        return;
      }
      Object localObject1 = ((VasNinePathBitmap)localObject2).d();
      if (localObject1 == null) {
        return;
      }
      localObject1 = NinePatchChunk.deserialize((byte[])localObject1).mPaddings;
      localObject2 = VasNinePathBitmap.a(((VasNinePathBitmap)localObject2).e(), ((VasNinePathBitmap)localObject2).f(), this.K);
      if ((((Boolean)((Triple)localObject2).getFirst()).booleanValue()) || (((Boolean)((Triple)localObject2).getSecond()).booleanValue()))
      {
        float f = ((Float)((Triple)localObject2).getThird()).floatValue();
        ((Rect)localObject1).set((int)(((Rect)localObject1).left / f), (int)(((Rect)localObject1).top / f), (int)(((Rect)localObject1).right / f), (int)(((Rect)localObject1).bottom / f));
      }
      int i = ((Rect)localObject1).left;
      int j = ((Rect)localObject1).right;
      localObject2 = this.F;
      if ((localObject2 != null) && (((PointF)localObject2).x > 0.0F)) {
        paramRect.right = ((int)this.F.x + (i + j));
      }
      this.G = false;
      this.l = paramRect.right;
      paramRect = this.H;
      if (paramRect != null) {
        paramRect.a((Rect)localObject1);
      }
    }
  }
  
  public void a(TroopNickResDrawable.UpdateDrawablePadding paramUpdateDrawablePadding)
  {
    this.H = paramUpdateDrawablePadding;
  }
  
  public void draw(@android.support.annotation.NonNull Canvas paramCanvas)
  {
    a(getBounds());
    super.draw(paramCanvas);
  }
  
  public int e()
  {
    return this.J;
  }
  
  public boolean getPadding(@androidx.annotation.NonNull Rect paramRect)
  {
    return super.getPadding(paramRect);
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.K.set(getBounds());
  }
  
  public void setBounds(Rect paramRect)
  {
    super.setBounds(paramRect);
    this.K.set(getBounds());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.TroopNickResDrawable
 * JD-Core Version:    0.7.0.1
 */