package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.opengl.GLES20;
import aydb;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import java.io.File;

class TroopSignVideoView$SignVideoSprite
  extends VideoSprite
{
  private int p = GLES20.glGetUniformLocation(this.m, "v_isShowCover");
  
  public TroopSignVideoView$SignVideoSprite(TroopSignVideoView paramTroopSignVideoView, SpriteGLView paramSpriteGLView, Context paramContext, boolean paramBoolean)
  {
    super(paramSpriteGLView, paramContext, paramBoolean);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (TroopSignVideoView.a(this.this$0) == 0) {
      TroopSignVideoView.a(this.this$0, paramInt2);
    }
    super.a(paramInt1, TroopSignVideoView.a(this.this$0));
  }
  
  public String b()
  {
    return aydb.a(this.this$0.getContext(), "troop" + File.separator + "shaders" + File.separator + "FragmentShaderVideoForTroopSign.glsl");
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.e == null) {
      return;
    }
    a(paramInt1, paramInt2);
    GLES20.glEnableVertexAttribArray(this.j);
    GLES20.glVertexAttribPointer(this.j, 2, 5126, false, 0, this.e);
    GLES20.glBindTexture(3553, this.a[0]);
    GLES20.glUniform1i(this.g, 0);
    GLES20.glEnableVertexAttribArray(this.h);
    GLES20.glVertexAttribPointer(this.h, 4, 5126, false, 0, this.c);
    if (this.jdField_f_of_type_Boolean)
    {
      GLES20.glUniform1i(this.l, 1);
      GLES20.glEnableVertexAttribArray(this.i);
      GLES20.glVertexAttribPointer(this.i, 4, 5126, false, 0, this.d);
      paramInt2 = this.p;
      if (!TroopSignVideoView.a(this.this$0)) {
        break label205;
      }
    }
    label205:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      GLES20.glUniform1i(paramInt2, paramInt1);
      GLES20.glUniformMatrix4fv(this.k, 1, false, this.jdField_f_of_type_ArrayOfFloat, 0);
      GLES20.glDrawElements(4, jdField_b_of_type_ArrayOfShort.length, 5123, this.jdField_b_of_type_JavaNioShortBuffer);
      GLES20.glDisableVertexAttribArray(this.j);
      GLES20.glDisableVertexAttribArray(this.h);
      GLES20.glDisableVertexAttribArray(this.i);
      return;
      GLES20.glUniform1i(this.l, 0);
      break;
    }
  }
  
  public void i()
  {
    super.i();
    this.p = GLES20.glGetUniformLocation(this.m, "v_isShowCover");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopSignVideoView.SignVideoSprite
 * JD-Core Version:    0.7.0.1
 */