package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import aywk;
import bbql;
import bjzr;
import bjzt;
import bjzu;
import bjzx;
import bkab;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.PasterParcelData;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import veg;

public class DynamicFaceLayer$1
  implements Runnable
{
  public DynamicFaceLayer$1(bjzr parambjzr, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.a.size())
    {
      Object localObject2 = (PasterParcelData)this.a.get(i);
      if (TextUtils.isEmpty(((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString)) {}
      Object localObject1;
      label136:
      int j;
      int k;
      int m;
      int n;
      do
      {
        i += 1;
        break;
        if ((bjzr.a(this.this$0).a == null) || (!bjzr.b(this.this$0).a.b())) {
          break label457;
        }
        localObject1 = bbql.a(BaseApplicationImpl.sApplication.getRuntime(), ((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString, "-Dynamic-", aywk.a, new int[] { 13 }, "-Dynamic-", null);
        if (localObject1 == null) {
          break label437;
        }
        if (((URLDrawable)localObject1).getStatus() != 1) {
          ((URLDrawable)localObject1).restartDownload();
        }
        ((Drawable)localObject1).setCallback(bjzr.c(this.this$0));
        j = (int)((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsRectF.left;
        k = (int)((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsRectF.right;
        m = (int)((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsRectF.top;
        n = (int)((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsRectF.bottom;
      } while (localObject1 == null);
      ((Drawable)localObject1).setBounds(j, m, k, n);
      Object localObject3;
      if (TextUtils.isEmpty(((PasterParcelData)localObject2).jdField_f_of_type_JavaLangString))
      {
        veg.b("DynamicFaceLayer", "Create Normal FaceItem.");
        localObject3 = new bkab(((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsPointF.x, ((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsPointF.y, ((PasterParcelData)localObject2).jdField_a_of_type_Float, ((PasterParcelData)localObject2).jdField_b_of_type_Float, ((PasterParcelData)localObject2).jdField_c_of_type_Float, ((PasterParcelData)localObject2).jdField_d_of_type_Float, (int)((PasterParcelData)localObject2).e, (int)((PasterParcelData)localObject2).jdField_f_of_type_Float);
        localObject1 = new bjzx(this.this$0, (Drawable)localObject1, (bkab)localObject3, ((PasterParcelData)localObject2).jdField_a_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_b_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_d_of_type_Int);
        ((bjzx)localObject1).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.set(((PasterParcelData)localObject2).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
        ((bjzx)localObject1).e = 0;
        if (((bjzx)localObject1).h == 1) {
          break label673;
        }
        localObject2 = (bjzt)bjzr.d(this.this$0).a(bjzt.jdField_a_of_type_JavaLangString);
        if (localObject2 == null) {}
      }
      for (;;)
      {
        try
        {
          localObject3 = bjzx.class.getDeclaredField("b");
          ((Field)localObject3).setAccessible(true);
          ((Field)localObject3).set(localObject1, localObject2);
          ((bjzt)localObject2).jdField_a_of_type_JavaUtilList.add(localObject1);
          ((bjzt)localObject2).k();
          if ((bjzr.e(this.this$0).a == null) || (!bjzr.f(this.this$0).a.b())) {
            break;
          }
          ((bjzx)localObject1).c(true);
          break;
          label437:
          if (QLog.isColorLevel()) {
            QLog.d("DynamicFaceLayer", 2, "apng error");
          }
          localObject1 = null;
          break label136;
          label457:
          localObject1 = bjzr.a(((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString);
          ((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1);
          ((PasterParcelData)localObject2).jdField_d_of_type_Int = 0;
          localObject1 = bjzr.a((String)localObject1);
          break label136;
          veg.b("DynamicFaceLayer", "Create FaceAndTextItem with text:" + ((PasterParcelData)localObject2).jdField_f_of_type_JavaLangString);
          localObject3 = new bkab(((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsPointF.x, ((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsPointF.y, ((PasterParcelData)localObject2).jdField_a_of_type_Float, ((PasterParcelData)localObject2).jdField_b_of_type_Float, ((PasterParcelData)localObject2).jdField_c_of_type_Float, ((PasterParcelData)localObject2).jdField_d_of_type_Float, (int)((PasterParcelData)localObject2).e, (int)((PasterParcelData)localObject2).jdField_f_of_type_Float, ((PasterParcelData)localObject2).jdField_f_of_type_JavaLangString, ((PasterParcelData)localObject2).g, ((PasterParcelData)localObject2).jdField_f_of_type_Int);
          localObject1 = new bjzu(this.this$0, (Drawable)localObject1, (bkab)localObject3, ((PasterParcelData)localObject2).jdField_a_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_b_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_d_of_type_Int);
          ((bjzu)localObject1).a();
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("DynamicFaceLayer", 2, new Object[] { "reflect faceLayer Item error : ", localException.getMessage() });
          continue;
        }
        label673:
        this.this$0.jdField_a_of_type_JavaUtilList.add(localObject1);
        this.this$0.k();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer.1
 * JD-Core Version:    0.7.0.1
 */