package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleOpController;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleOperator;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleTextureView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.MosaicOperator;

public class LineLayer
  extends BaseLayer
{
  public static String a;
  public int a;
  public DoodleOpController a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "LineLayer";
  }
  
  public LineLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController = new DoodleOpController();
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    MosaicOperator localMosaicOperator;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Int = 1;
        return;
        this.jdField_a_of_type_Int = 2;
        return;
        this.jdField_a_of_type_Int = 3;
        return;
        this.jdField_a_of_type_Int = 4;
        localMosaicOperator = (MosaicOperator)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(103);
      } while (localMosaicOperator == null);
      localMosaicOperator.a(104);
      localMosaicOperator.b();
      return;
      this.jdField_a_of_type_Int = 6;
      localMosaicOperator = (MosaicOperator)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(103);
    } while (localMosaicOperator == null);
    localMosaicOperator.a(105);
    localMosaicOperator.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.c, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.d);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.d(101);
    }
    while ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int != 4)) {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.d(104);
  }
  
  public Bitmap a()
  {
    return ((MosaicOperator)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(103)).b;
  }
  
  public DoodleOperator a(int paramInt)
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(paramInt);
  }
  
  public String a()
  {
    return "LineLayer";
  }
  
  public void a()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.i();
    SLog.b("LineLayer", "clear over.");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    MosaicOperator localMosaicOperator = (MosaicOperator)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(103);
    if (localMosaicOperator != null) {
      localMosaicOperator.c(paramInt1, paramInt2);
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(paramCanvas, this.jdField_a_of_type_Float);
    h();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.b(paramCanvas, paramFloat);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a())
    {
      Bitmap localBitmap = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a;
      if (localBitmap == null) {
        break label94;
      }
      PorterDuffXfermode localPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
      Paint localPaint = new Paint(1);
      localPaint.setXfermode(localPorterDuffXfermode);
      paramCanvas.save();
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
      paramCanvas.restore();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.j();
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.c();
      return;
      label94:
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "imgDoodle is null");
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    SLog.b("LineLayer", "switchImageMode.");
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(paramAppInterface, paramInt2);
  }
  
  public void a(LineLayer.LayerEventListener paramLayerEventListener)
  {
    Bitmap localBitmap = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b();
    MosaicOperator localMosaicOperator = (MosaicOperator)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(103);
    if (localMosaicOperator != null) {
      localMosaicOperator.a(paramLayerEventListener, this.jdField_a_of_type_Float, localBitmap, this.jdField_a_of_type_AndroidGraphicsRect);
    }
  }
  
  public void a(DoodleTextureView paramDoodleTextureView)
  {
    if (paramDoodleTextureView.getVisibility() == 0) {
      paramDoodleTextureView.setOpController(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.c();
  }
  
  public boolean a(long paramLong)
  {
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    while (this.jdField_a_of_type_Int == 5)
    {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(102, paramMotionEvent);
      VideoEditReport.a("0X80076BE");
      VideoEditReport.b("0X80075CB");
    }
    if (this.jdField_a_of_type_Int == 1) {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(101, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 3) {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(103, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 4) {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(104, paramMotionEvent);
    }
    if (this.jdField_a_of_type_Int == 6) {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(105, paramMotionEvent);
    }
    return false;
  }
  
  public byte[] a()
  {
    return ((MosaicOperator)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(103)).a;
  }
  
  public int b()
  {
    int[] arrayOfInt = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a();
    int i = arrayOfInt[0];
    return arrayOfInt[1] + i;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.b();
    }
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_a_of_type_Float);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void c()
  {
    ((MosaicOperator)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(103)).c();
  }
  
  public void c(Canvas paramCanvas)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.c(paramCanvas, this.jdField_a_of_type_Float);
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 6);
  }
  
  public void d()
  {
    MosaicOperator localMosaicOperator = (MosaicOperator)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(103);
    if (localMosaicOperator != null) {
      localMosaicOperator.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.b()) {
      super.k();
    }
  }
  
  public void f()
  {
    SLog.b("LineLayer", "switchMosaicMode.");
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a())
    {
      a(4);
      return;
    }
    a(6);
  }
  
  public void g()
  {
    SLog.b("LineLayer", "switchNormalMode.");
    a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer
 * JD-Core Version:    0.7.0.1
 */