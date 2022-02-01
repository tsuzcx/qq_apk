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
  int b = 0;
  private boolean e = false;
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
  
  protected Drawable a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasUiVasNinePathBitmap.a()) {
      ThreadManagerV2.executeOnSubThread(new TroopNickResDrawable.1(this, paramString2));
    }
    return null;
  }
  
  protected void a(@android.support.annotation.NonNull Canvas paramCanvas)
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
    if ((this.jdField_a_of_type_AndroidGraphicsPointF != null) && (this.e))
    {
      Object localObject2 = (VasNinePathBitmap)this.jdField_a_of_type_ComTencentMobileqqVasUiINinePathBitmap;
      if (localObject2 == null) {
        return;
      }
      Object localObject1 = ((VasNinePathBitmap)localObject2).a();
      if (localObject1 == null) {
        return;
      }
      localObject1 = NinePatchChunk.deserialize((byte[])localObject1).mPaddings;
      localObject2 = VasNinePathBitmap.a(((VasNinePathBitmap)localObject2).a(), ((VasNinePathBitmap)localObject2).b(), this.jdField_a_of_type_AndroidGraphicsRect);
      if ((((Boolean)((Triple)localObject2).getFirst()).booleanValue()) || (((Boolean)((Triple)localObject2).getSecond()).booleanValue()))
      {
        float f = ((Float)((Triple)localObject2).getThird()).floatValue();
        ((Rect)localObject1).set((int)(((Rect)localObject1).left / f), (int)(((Rect)localObject1).top / f), (int)(((Rect)localObject1).right / f), (int)(((Rect)localObject1).bottom / f));
      }
      int i = ((Rect)localObject1).left;
      int j = ((Rect)localObject1).right;
      localObject2 = this.jdField_a_of_type_AndroidGraphicsPointF;
      if ((localObject2 != null) && (((PointF)localObject2).x > 0.0F)) {
        paramRect.right = ((int)this.jdField_a_of_type_AndroidGraphicsPointF.x + (i + j));
      }
      this.e = false;
      this.b = paramRect.right;
      paramRect = this.jdField_a_of_type_ComTencentMobileqqVasTroopnickTroopNickResDrawable$UpdateDrawablePadding;
      if (paramRect != null) {
        paramRect.a((Rect)localObject1);
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.TroopNickResDrawable
 * JD-Core Version:    0.7.0.1
 */