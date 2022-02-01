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
  private PointF jdField_a_of_type_AndroidGraphicsPointF;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private TroopNickResDrawable.UpdateDrawablePadding jdField_a_of_type_ComTencentMobileqqVasTroopnickTroopNickResDrawable$UpdateDrawablePadding;
  private VasNinePathBitmap jdField_a_of_type_ComTencentMobileqqVasUiVasNinePathBitmap = new VasNinePathBitmap();
  private boolean e = false;
  int j = 0;
  private int k = 0;
  
  public TroopNickResDrawable(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqVasUiINinePathBitmap = new VasNinePathBitmap();
    this.k = paramInt;
  }
  
  public int a()
  {
    return this.k;
  }
  
  public Drawable a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    while (!this.jdField_a_of_type_ComTencentMobileqqVasUiVasNinePathBitmap.a()) {
      return null;
    }
    ThreadManagerV2.executeOnSubThread(new TroopNickResDrawable.1(this, paramString2));
    return null;
  }
  
  public void a(@android.support.annotation.NonNull Canvas paramCanvas)
  {
    if (this.d) {
      this.jdField_a_of_type_ComTencentMobileqqVasUiVasNinePathBitmap.a(paramCanvas, null, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void a(PointF paramPointF)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF = paramPointF;
    this.e = true;
  }
  
  public void a(Rect paramRect)
  {
    Object localObject1;
    if ((this.jdField_a_of_type_AndroidGraphicsPointF != null) && (this.e))
    {
      localObject1 = (VasNinePathBitmap)this.jdField_a_of_type_ComTencentMobileqqVasUiINinePathBitmap;
      if (localObject1 != null) {
        break label29;
      }
    }
    label29:
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject2 = ((VasNinePathBitmap)localObject1).a();
      } while (localObject2 == null);
      localObject2 = NinePatchChunk.deserialize((byte[])localObject2).mPaddings;
      localObject1 = VasNinePathBitmap.a(((VasNinePathBitmap)localObject1).a(), ((VasNinePathBitmap)localObject1).b(), this.jdField_a_of_type_AndroidGraphicsRect);
      if ((((Boolean)((Triple)localObject1).getFirst()).booleanValue()) || (((Boolean)((Triple)localObject1).getSecond()).booleanValue()))
      {
        float f = ((Float)((Triple)localObject1).getThird()).floatValue();
        ((Rect)localObject2).set((int)(((Rect)localObject2).left / f), (int)(((Rect)localObject2).top / f), (int)(((Rect)localObject2).right / f), (int)(((Rect)localObject2).bottom / f));
      }
      int i = ((Rect)localObject2).left;
      int m = ((Rect)localObject2).right;
      if ((this.jdField_a_of_type_AndroidGraphicsPointF != null) && (this.jdField_a_of_type_AndroidGraphicsPointF.x > 0.0F)) {
        paramRect.right = (i + m + (int)this.jdField_a_of_type_AndroidGraphicsPointF.x);
      }
      this.e = false;
      this.j = paramRect.right;
    } while (this.jdField_a_of_type_ComTencentMobileqqVasTroopnickTroopNickResDrawable$UpdateDrawablePadding == null);
    this.jdField_a_of_type_ComTencentMobileqqVasTroopnickTroopNickResDrawable$UpdateDrawablePadding.a((Rect)localObject2);
  }
  
  public void a(TroopNickResDrawable.UpdateDrawablePadding paramUpdateDrawablePadding)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasTroopnickTroopNickResDrawable$UpdateDrawablePadding = paramUpdateDrawablePadding;
  }
  
  public void draw(@android.support.annotation.NonNull Canvas paramCanvas)
  {
    a(getBounds());
    super.draw(paramCanvas);
  }
  
  public boolean getPadding(@androidx.annotation.NonNull Rect paramRect)
  {
    return super.getPadding(paramRect);
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidGraphicsRect.set(getBounds());
  }
  
  public void setBounds(Rect paramRect)
  {
    super.setBounds(paramRect);
    this.jdField_a_of_type_AndroidGraphicsRect.set(getBounds());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.TroopNickResDrawable
 * JD-Core Version:    0.7.0.1
 */