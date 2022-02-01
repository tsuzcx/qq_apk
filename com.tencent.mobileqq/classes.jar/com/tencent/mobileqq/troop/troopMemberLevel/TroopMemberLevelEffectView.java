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
  private Rect a;
  private URLDrawable b;
  
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
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    URLDrawable localURLDrawable = this.b;
    if (localURLDrawable != null)
    {
      Rect localRect = this.a;
      if (localRect != null)
      {
        localURLDrawable.setBounds(localRect);
        this.b.draw(paramCanvas);
      }
    }
  }
  
  public void setCurrentDrawable(URLDrawable paramURLDrawable)
  {
    this.b = paramURLDrawable;
    this.b.setCallback(this);
  }
  
  public void setLeftCropRect(Rect paramRect)
  {
    this.a = paramRect;
  }
  
  protected boolean verifyDrawable(@NonNull Drawable paramDrawable)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelEffectView
 * JD-Core Version:    0.7.0.1
 */