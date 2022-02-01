package com.tencent.mobileqq.troop.troopMemberLevel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;

public class TroopMemberLevelEffectView
  extends ImageView
{
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  
  public TroopMemberLevelEffectView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TroopMemberLevelEffectView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, null, 0);
  }
  
  public TroopMemberLevelEffectView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_AndroidGraphicsRect != null))
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
      this.jdField_a_of_type_ComTencentImageURLDrawable.draw(paramCanvas);
    }
  }
  
  public void setCurrentDrawable(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentImageURLDrawable = paramURLDrawable;
    this.jdField_a_of_type_ComTencentImageURLDrawable.setCallback(this);
  }
  
  public void setLeftCropRect(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
  }
  
  public boolean verifyDrawable(@NonNull Drawable paramDrawable)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelEffectView
 * JD-Core Version:    0.7.0.1
 */