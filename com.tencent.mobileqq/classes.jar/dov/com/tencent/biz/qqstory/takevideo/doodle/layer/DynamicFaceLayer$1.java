package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import bayu;
import bduc;
import bmqe;
import bmqg;
import bmqh;
import bmqk;
import bmqo;
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
import wxe;

public class DynamicFaceLayer$1
  implements Runnable
{
  public DynamicFaceLayer$1(bmqe parambmqe, ArrayList paramArrayList) {}
  
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
        if ((bmqe.a(this.this$0).a == null) || (!bmqe.b(this.this$0).a.b())) {
          break label457;
        }
        localObject1 = bduc.a(BaseApplicationImpl.sApplication.getRuntime(), ((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString, "-Dynamic-", bayu.a, new int[] { 13 }, "-Dynamic-", null);
        if (localObject1 == null) {
          break label437;
        }
        if (((URLDrawable)localObject1).getStatus() != 1) {
          ((URLDrawable)localObject1).restartDownload();
        }
        ((Drawable)localObject1).setCallback(bmqe.c(this.this$0));
        j = (int)((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsRectF.left;
        k = (int)((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsRectF.right;
        m = (int)((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsRectF.top;
        n = (int)((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsRectF.bottom;
      } while (localObject1 == null);
      ((Drawable)localObject1).setBounds(j, m, k, n);
      Object localObject3;
      if (TextUtils.isEmpty(((PasterParcelData)localObject2).jdField_f_of_type_JavaLangString))
      {
        wxe.b("DynamicFaceLayer", "Create Normal FaceItem.");
        localObject3 = new bmqo(((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsPointF.x, ((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsPointF.y, ((PasterParcelData)localObject2).jdField_a_of_type_Float, ((PasterParcelData)localObject2).jdField_b_of_type_Float, ((PasterParcelData)localObject2).jdField_c_of_type_Float, ((PasterParcelData)localObject2).jdField_d_of_type_Float, (int)((PasterParcelData)localObject2).e, (int)((PasterParcelData)localObject2).jdField_f_of_type_Float);
        localObject1 = new bmqk(this.this$0, (Drawable)localObject1, (bmqo)localObject3, ((PasterParcelData)localObject2).jdField_a_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_b_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_d_of_type_Int);
        ((bmqk)localObject1).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.set(((PasterParcelData)localObject2).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
        ((bmqk)localObject1).e = 0;
        if (((bmqk)localObject1).h == 1) {
          break label673;
        }
        localObject2 = (bmqg)bmqe.d(this.this$0).a(bmqg.jdField_a_of_type_JavaLangString);
        if (localObject2 == null) {}
      }
      for (;;)
      {
        try
        {
          localObject3 = bmqk.class.getDeclaredField("b");
          ((Field)localObject3).setAccessible(true);
          ((Field)localObject3).set(localObject1, localObject2);
          ((bmqg)localObject2).jdField_a_of_type_JavaUtilList.add(localObject1);
          ((bmqg)localObject2).k();
          if ((bmqe.e(this.this$0).a == null) || (!bmqe.f(this.this$0).a.b())) {
            break;
          }
          ((bmqk)localObject1).c(true);
          break;
          label437:
          if (QLog.isColorLevel()) {
            QLog.d("DynamicFaceLayer", 2, "apng error");
          }
          localObject1 = null;
          break label136;
          label457:
          localObject1 = bmqe.a(((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString);
          ((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1);
          ((PasterParcelData)localObject2).jdField_d_of_type_Int = 0;
          localObject1 = bmqe.a((String)localObject1);
          break label136;
          wxe.b("DynamicFaceLayer", "Create FaceAndTextItem with text:" + ((PasterParcelData)localObject2).jdField_f_of_type_JavaLangString);
          localObject3 = new bmqo(((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsPointF.x, ((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsPointF.y, ((PasterParcelData)localObject2).jdField_a_of_type_Float, ((PasterParcelData)localObject2).jdField_b_of_type_Float, ((PasterParcelData)localObject2).jdField_c_of_type_Float, ((PasterParcelData)localObject2).jdField_d_of_type_Float, (int)((PasterParcelData)localObject2).e, (int)((PasterParcelData)localObject2).jdField_f_of_type_Float, ((PasterParcelData)localObject2).jdField_f_of_type_JavaLangString, ((PasterParcelData)localObject2).g, ((PasterParcelData)localObject2).jdField_f_of_type_Int);
          localObject1 = new bmqh(this.this$0, (Drawable)localObject1, (bmqo)localObject3, ((PasterParcelData)localObject2).jdField_a_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_b_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_d_of_type_Int);
          ((bmqh)localObject1).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer.1
 * JD-Core Version:    0.7.0.1
 */