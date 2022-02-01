package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import beyq;
import bqjf;
import bqjh;
import bqji;
import bqjl;
import bqjp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.PasterParcelData;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import yuk;

public class DynamicFaceLayer$1
  implements Runnable
{
  public DynamicFaceLayer$1(bqjf parambqjf, ArrayList paramArrayList) {}
  
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
        if ((bqjf.a(this.this$0).a == null) || (!bqjf.b(this.this$0).a.b())) {
          break label457;
        }
        localObject1 = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), ((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString, "-Dynamic-", beyq.a, new int[] { 13 }, "-Dynamic-", null);
        if (localObject1 == null) {
          break label437;
        }
        if (((URLDrawable)localObject1).getStatus() != 1) {
          ((URLDrawable)localObject1).restartDownload();
        }
        ((Drawable)localObject1).setCallback(bqjf.c(this.this$0));
        j = (int)((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsRectF.left;
        k = (int)((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsRectF.right;
        m = (int)((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsRectF.top;
        n = (int)((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsRectF.bottom;
      } while (localObject1 == null);
      ((Drawable)localObject1).setBounds(j, m, k, n);
      Object localObject3;
      if (TextUtils.isEmpty(((PasterParcelData)localObject2).jdField_f_of_type_JavaLangString))
      {
        yuk.b("DynamicFaceLayer", "Create Normal FaceItem.");
        localObject3 = new bqjp(((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsPointF.x, ((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsPointF.y, ((PasterParcelData)localObject2).jdField_a_of_type_Float, ((PasterParcelData)localObject2).jdField_b_of_type_Float, ((PasterParcelData)localObject2).jdField_c_of_type_Float, ((PasterParcelData)localObject2).jdField_d_of_type_Float, (int)((PasterParcelData)localObject2).e, (int)((PasterParcelData)localObject2).jdField_f_of_type_Float);
        localObject1 = new bqjl(this.this$0, (Drawable)localObject1, (bqjp)localObject3, ((PasterParcelData)localObject2).jdField_a_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_b_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_d_of_type_Int);
        ((bqjl)localObject1).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.set(((PasterParcelData)localObject2).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
        ((bqjl)localObject1).e = 0;
        if (((bqjl)localObject1).h == 1) {
          break label674;
        }
        localObject2 = (bqjh)bqjf.d(this.this$0).a(bqjh.jdField_a_of_type_JavaLangString);
        if (localObject2 == null) {}
      }
      for (;;)
      {
        try
        {
          localObject3 = bqjl.class.getDeclaredField("b");
          ((Field)localObject3).setAccessible(true);
          ((Field)localObject3).set(localObject1, localObject2);
          ((bqjh)localObject2).jdField_a_of_type_JavaUtilList.add(localObject1);
          ((bqjh)localObject2).k();
          if ((bqjf.e(this.this$0).a == null) || (!bqjf.f(this.this$0).a.b())) {
            break;
          }
          ((bqjl)localObject1).c(true);
          break;
          label437:
          if (QLog.isColorLevel()) {
            QLog.d("DynamicFaceLayer", 2, "apng error");
          }
          localObject1 = null;
          break label136;
          label457:
          localObject1 = bqjf.a(((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString);
          ((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1);
          ((PasterParcelData)localObject2).jdField_d_of_type_Int = 0;
          localObject1 = bqjf.a((String)localObject1);
          break label136;
          yuk.b("DynamicFaceLayer", "Create FaceAndTextItem with text:" + ((PasterParcelData)localObject2).jdField_f_of_type_JavaLangString);
          localObject3 = new bqjp(((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsPointF.x, ((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsPointF.y, ((PasterParcelData)localObject2).jdField_a_of_type_Float, ((PasterParcelData)localObject2).jdField_b_of_type_Float, ((PasterParcelData)localObject2).jdField_c_of_type_Float, ((PasterParcelData)localObject2).jdField_d_of_type_Float, (int)((PasterParcelData)localObject2).e, (int)((PasterParcelData)localObject2).jdField_f_of_type_Float, ((PasterParcelData)localObject2).jdField_f_of_type_JavaLangString, ((PasterParcelData)localObject2).g, ((PasterParcelData)localObject2).jdField_f_of_type_Int);
          localObject1 = new bqji(this.this$0, (Drawable)localObject1, (bqjp)localObject3, ((PasterParcelData)localObject2).jdField_a_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_b_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_d_of_type_Int);
          ((bqji)localObject1).a();
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("DynamicFaceLayer", 2, new Object[] { "reflect faceLayer Item error : ", localException.getMessage() });
          continue;
        }
        label674:
        this.this$0.jdField_a_of_type_JavaUtilList.add(localObject1);
        this.this$0.k();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer.1
 * JD-Core Version:    0.7.0.1
 */