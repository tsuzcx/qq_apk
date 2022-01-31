package com.tencent.mobileqq.teamworkforgroup;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import bahd;
import bdjc;
import com.tencent.qphone.base.util.QLog;

public class TroopTeamWorkFileSearchDialog$10
  implements Runnable
{
  public TroopTeamWorkFileSearchDialog$10(bahd parambahd, Bitmap paramBitmap, View paramView, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      this.this$0.b(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_AndroidGraphicsBitmap);
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopTeamWorkFileSearchDialog", 2, "createScaledBitmap");
      }
      bahd.a(this.this$0, Bitmap.createScaledBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / bahd.d, this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / bahd.d, true));
      Canvas localCanvas = new Canvas();
      localCanvas.setBitmap(bahd.a(this.this$0));
      localCanvas.drawColor(Color.parseColor("#50ffffff"), PorterDuff.Mode.LIGHTEN);
      if (QLog.isColorLevel()) {
        QLog.d("TroopTeamWorkFileSearchDialog", 2, "start blur");
      }
      bdjc.a(bahd.a(this.this$0), bahd.e);
      if (QLog.isColorLevel()) {
        QLog.d("TroopTeamWorkFileSearchDialog", 2, "blur end");
      }
      return;
    }
    catch (Exception localException)
    {
      bahd.a(this.this$0, null);
      if (QLog.isColorLevel()) {
        QLog.d("TroopTeamWorkFileSearchDialog", 2, "blur error", localException);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      bahd.a(this.this$0, null);
      if (QLog.isColorLevel()) {
        QLog.d("TroopTeamWorkFileSearchDialog", 2, "blur error", localOutOfMemoryError);
      }
      return;
    }
    finally
    {
      this.this$0.b(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.10
 * JD-Core Version:    0.7.0.1
 */