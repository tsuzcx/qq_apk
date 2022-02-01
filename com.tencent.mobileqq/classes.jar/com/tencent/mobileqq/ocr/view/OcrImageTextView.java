package com.tencent.mobileqq.ocr.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import atvv;
import atvw;
import axlj;
import axlk;
import axmx;
import axos;
import bgcf;
import bgch;
import bgcj;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class OcrImageTextView
  extends ImageView
{
  private static String jdField_a_of_type_JavaLangString = "OcrImageTextView";
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private axlk jdField_a_of_type_Axlk;
  public Runnable a;
  private List<axos> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  
  public OcrImageTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OcrImageTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OcrImageTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangRunnable = new OcrImageTextView.2(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
  }
  
  private void a(int paramInt1, axos paramaxos, int paramInt2)
  {
    if (paramInt1 <= 0) {
      return;
    }
    if (paramaxos.jdField_a_of_type_Float > 0.0F)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramaxos.jdField_a_of_type_Float);
      return;
    }
    paramaxos.jdField_a_of_type_Float = axmx.a(paramInt1, paramaxos.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt2);
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsPaint.getTextBounds(paramaxos.jdField_a_of_type_JavaLangString, 0, paramaxos.jdField_a_of_type_JavaLangString.length(), localRect);
    paramaxos.j = ((paramInt1 - localRect.width()) / 2);
    paramaxos.k = ((paramInt2 - localRect.height()) / 2);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramaxos.jdField_a_of_type_Float);
  }
  
  private void a(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    i = (int)(ScreenUtil.getRealWidth(getContext()) / i * j);
    super.setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(ScreenUtil.getRealWidth(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
  }
  
  private void a(Canvas paramCanvas, axos paramaxos, Rect paramRect, int paramInt)
  {
    paramCanvas.drawBitmap(paramaxos.jdField_a_of_type_AndroidGraphicsBitmap, paramRect, paramRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (paramaxos.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-15550475);
      paramCanvas.drawRect(paramRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (paramaxos.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    }
    for (;;)
    {
      paramCanvas.drawText(paramaxos.jdField_a_of_type_JavaLangString, paramaxos.j, paramInt, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16777216);
    }
  }
  
  private void a(atvv paramatvv, axos paramaxos)
  {
    paramatvv = paramatvv.a.iterator();
    while (paramatvv.hasNext())
    {
      Object localObject = (atvw)paramatvv.next();
      localObject = new Point((int)(((atvw)localObject).jdField_a_of_type_Int * this.jdField_a_of_type_Float), (int)(((atvw)localObject).jdField_b_of_type_Int * this.jdField_b_of_type_Float));
      paramaxos.jdField_a_of_type_JavaUtilList.add(localObject);
      paramaxos.jdField_d_of_type_Int = Math.max(paramaxos.jdField_d_of_type_Int, ((Point)localObject).x);
      paramaxos.e = Math.max(paramaxos.e, ((Point)localObject).y);
      paramaxos.f = Math.min(paramaxos.f, ((Point)localObject).x);
      paramaxos.g = Math.min(paramaxos.g, ((Point)localObject).y);
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.add(paramaxos);
    }
  }
  
  private void a(axos paramaxos)
  {
    Object localObject = bgcf.a(paramaxos.jdField_a_of_type_AndroidGraphicsBitmap).a();
    if ((localObject != null) && (((bgcf)localObject).a() != null))
    {
      localObject = ((bgcf)localObject).a();
      paramaxos.m = (((bgcj)localObject).a() | 0xFF000000);
      paramaxos.n = (((bgcj)localObject).d() | 0xFF000000);
      paramaxos.jdField_d_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "ocrText.backRGB=" + paramaxos.m + " ocrText.textColor =" + paramaxos.n + " text=" + paramaxos.jdField_a_of_type_JavaLangString);
      }
      axlj.a(1, "ocr_palette_suc");
      return;
    }
    paramaxos.jdField_a_of_type_Boolean = axlj.a(paramaxos.jdField_a_of_type_AndroidGraphicsBitmap);
    axlj.a(0, "ocr_palette_suc");
  }
  
  private void a(List<atvv> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      atvv localatvv = (atvv)paramList.next();
      int i = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      if (i != paramInt1)
      {
        float f = i / paramInt1;
        if ((paramInt3 == 90) || (paramInt3 == 270)) {
          f = i / paramInt2;
        }
        localatvv.a(f);
      }
    }
  }
  
  private void a(List<atvv> paramList, int paramInt1, int paramInt2, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new OcrImageTextView.1(this, paramList, paramString, paramInt2, paramInt1));
  }
  
  private boolean a(atvv paramatvv, axos paramaxos, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
  {
    if (paramaxos.jdField_c_of_type_Boolean) {}
    for (paramatvv = axlj.a(this.jdField_a_of_type_AndroidGraphicsBitmap, paramatvv.e(), paramatvv.g(), paramInt1, paramInt2, paramaxos.jdField_a_of_type_Int, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float); paramatvv == null; paramatvv = axlj.a(this.jdField_a_of_type_AndroidGraphicsBitmap, paramatvv.d(), paramatvv.f(), paramInt1, paramInt2, paramaxos.jdField_a_of_type_Int, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float))
    {
      axlj.a(0, paramString, paramaxos.jdField_a_of_type_JavaLangString, "ocr_crop_back_img");
      return false;
    }
    axlj.a(1, paramString, paramaxos.jdField_a_of_type_JavaLangString, "ocr_crop_back_img");
    axlj.a(paramaxos, 64, paramatvv);
    if ((paramatvv.getHeight() != paramInt3) || (paramatvv.getWidth() != paramInt4)) {
      paramatvv.recycle();
    }
    return true;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-38294);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(30.0F);
  }
  
  private void b(Canvas paramCanvas, axos paramaxos, Rect paramRect, int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramaxos.m);
    paramCanvas.drawRect(paramRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (paramaxos.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-15550475);
      paramCanvas.drawRect(paramRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramaxos.n);
    paramCanvas.drawText(paramaxos.jdField_a_of_type_JavaLangString, paramaxos.j, paramInt, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public CharSequence a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = -2;
    axos localaxos;
    if (localIterator.hasNext())
    {
      localaxos = (axos)localIterator.next();
      if (!localaxos.jdField_b_of_type_Boolean) {
        break label156;
      }
      if (i < 0)
      {
        localStringBuilder.append(localaxos.jdField_a_of_type_JavaLangString.trim());
        i = localaxos.h;
      }
    }
    label156:
    for (;;)
    {
      break;
      if (localaxos.h == i)
      {
        localStringBuilder.append(localaxos.jdField_a_of_type_JavaLangString.trim());
      }
      else
      {
        localStringBuilder.append("\n\n").append(localaxos.jdField_a_of_type_JavaLangString.trim());
        i = localaxos.h;
        continue;
        return localStringBuilder.toString();
      }
    }
  }
  
  public List<axos> a(List<atvv> paramList, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    a();
    if ((paramList == null) || (paramList.isEmpty()) || (getDrawable() == null) || (!(getDrawable() instanceof BitmapDrawable))) {
      return null;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)getDrawable()).getBitmap();
      this.jdField_a_of_type_Float = (ScreenUtil.getRealWidth(getContext()) / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
      this.jdField_b_of_type_Float = this.jdField_a_of_type_Float;
    }
    a(paramList, paramInt1, paramInt2, paramInt3);
    a(paramList, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), paramString);
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      axos localaxos = (axos)localIterator.next();
      if ((localaxos != null) && (localaxos.jdField_a_of_type_AndroidGraphicsBitmap != null))
      {
        localaxos.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        localaxos.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    requestLayout();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)getDrawable()).getBitmap();
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.jdField_b_of_type_Float <= paramInt;
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((axos)localIterator.next()).jdField_b_of_type_Boolean) {
        return true;
      }
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.jdField_a_of_type_Boolean) {}
    while ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    label49:
    axos localaxos;
    Rect localRect;
    int i;
    while (localIterator.hasNext())
    {
      localaxos = (axos)localIterator.next();
      if (localaxos.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        a(localaxos.jdField_b_of_type_Int, localaxos, localaxos.jdField_c_of_type_Int);
        if (localaxos.jdField_a_of_type_AndroidGraphicsRect == null)
        {
          localRect = new Rect();
          this.jdField_a_of_type_AndroidGraphicsPaint.getTextBounds(localaxos.jdField_a_of_type_JavaLangString, 0, localaxos.jdField_a_of_type_JavaLangString.length(), localRect);
          localaxos.jdField_a_of_type_AndroidGraphicsRect = localRect;
        }
        paramCanvas.save();
        paramCanvas.translate(localaxos.a(), localaxos.b());
        paramCanvas.rotate(localaxos.jdField_a_of_type_Int);
        localRect = new Rect();
        localRect.set(0, 0, localaxos.jdField_b_of_type_Int, localaxos.jdField_c_of_type_Int);
        i = localaxos.jdField_a_of_type_AndroidGraphicsRect.height();
        if (!localaxos.jdField_d_of_type_Boolean) {
          break label231;
        }
        b(paramCanvas, localaxos, localRect, i);
      }
    }
    for (;;)
    {
      paramCanvas.restore();
      break label49;
      break;
      label231:
      a(paramCanvas, localaxos, localRect, i);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onMeasure isRequestOcr=" + this.jdField_b_of_type_Boolean);
    }
    if ((getDrawable() == null) || (((BitmapDrawable)getDrawable()).getBitmap() == null))
    {
      super.setMeasuredDimension(paramInt1, paramInt2);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      super.setMeasuredDimension(paramInt1, paramInt2);
      return;
    }
    Bitmap localBitmap = ((BitmapDrawable)getDrawable()).getBitmap();
    if (localBitmap == null)
    {
      super.setMeasuredDimension(paramInt1, paramInt2);
      return;
    }
    a(localBitmap);
  }
  
  public void setHideAnimLisnter(axlk paramaxlk)
  {
    this.jdField_a_of_type_Axlk = paramaxlk;
  }
  
  public void setShowTextMask(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.OcrImageTextView
 * JD-Core Version:    0.7.0.1
 */