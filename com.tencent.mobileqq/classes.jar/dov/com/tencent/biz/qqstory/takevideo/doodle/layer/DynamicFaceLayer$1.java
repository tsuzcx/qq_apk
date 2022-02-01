package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import bovp;
import bovr;
import bovs;
import bovv;
import bovz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.PasterParcelData;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import ykq;

public class DynamicFaceLayer$1
  implements Runnable
{
  public DynamicFaceLayer$1(bovp parambovp, ArrayList paramArrayList) {}
  
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
        if ((bovp.a(this.this$0).a == null) || (!bovp.b(this.this$0).a.b())) {
          break label444;
        }
        localObject1 = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), ((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString, "-Dynamic-", URLDrawableHelper.TRANSPARENT, new int[] { 13 }, "-Dynamic-", null);
        if (localObject1 == null) {
          break label424;
        }
        if (((URLDrawable)localObject1).getStatus() != 1) {
          ((URLDrawable)localObject1).restartDownload();
        }
        ((Drawable)localObject1).setCallback(bovp.c(this.this$0));
        j = (int)((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsRectF.left;
        k = (int)((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsRectF.right;
        m = (int)((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsRectF.top;
        n = (int)((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsRectF.bottom;
      } while (localObject1 == null);
      ((Drawable)localObject1).setBounds(j, m, k, n);
      Object localObject3;
      if (TextUtils.isEmpty(((PasterParcelData)localObject2).jdField_f_of_type_JavaLangString))
      {
        ykq.b("DynamicFaceLayer", "Create Normal FaceItem.");
        localObject3 = new bovz(((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsPointF.x, ((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsPointF.y, ((PasterParcelData)localObject2).jdField_a_of_type_Float, ((PasterParcelData)localObject2).jdField_b_of_type_Float, ((PasterParcelData)localObject2).jdField_c_of_type_Float, ((PasterParcelData)localObject2).jdField_d_of_type_Float, (int)((PasterParcelData)localObject2).e, (int)((PasterParcelData)localObject2).jdField_f_of_type_Float);
        localObject1 = new bovv(this.this$0, (Drawable)localObject1, (bovz)localObject3, ((PasterParcelData)localObject2).jdField_a_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_b_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_d_of_type_Int);
        ((bovv)localObject1).e = 0;
        if (((bovv)localObject1).h == 1) {
          break label660;
        }
        localObject2 = (bovr)bovp.d(this.this$0).a(bovr.jdField_a_of_type_JavaLangString);
        if (localObject2 == null) {}
      }
      for (;;)
      {
        try
        {
          localObject3 = bovv.class.getDeclaredField("b");
          ((Field)localObject3).setAccessible(true);
          ((Field)localObject3).set(localObject1, localObject2);
          ((bovr)localObject2).jdField_a_of_type_JavaUtilList.add(localObject1);
          ((bovr)localObject2).k();
          if ((bovp.e(this.this$0).a == null) || (!bovp.f(this.this$0).a.b())) {
            break;
          }
          ((bovv)localObject1).c(true);
          break;
          label424:
          if (QLog.isColorLevel()) {
            QLog.d("DynamicFaceLayer", 2, "apng error");
          }
          localObject1 = null;
          break label136;
          label444:
          localObject1 = bovp.a(((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString);
          ((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1);
          ((PasterParcelData)localObject2).jdField_d_of_type_Int = 0;
          localObject1 = bovp.a((String)localObject1);
          break label136;
          ykq.b("DynamicFaceLayer", "Create FaceAndTextItem with text:" + ((PasterParcelData)localObject2).jdField_f_of_type_JavaLangString);
          localObject3 = new bovz(((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsPointF.x, ((PasterParcelData)localObject2).jdField_a_of_type_AndroidGraphicsPointF.y, ((PasterParcelData)localObject2).jdField_a_of_type_Float, ((PasterParcelData)localObject2).jdField_b_of_type_Float, ((PasterParcelData)localObject2).jdField_c_of_type_Float, ((PasterParcelData)localObject2).jdField_d_of_type_Float, (int)((PasterParcelData)localObject2).e, (int)((PasterParcelData)localObject2).jdField_f_of_type_Float, ((PasterParcelData)localObject2).jdField_f_of_type_JavaLangString, ((PasterParcelData)localObject2).g, ((PasterParcelData)localObject2).jdField_f_of_type_Int);
          localObject1 = new bovs(this.this$0, (Drawable)localObject1, (bovz)localObject3, ((PasterParcelData)localObject2).jdField_a_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_b_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_c_of_type_JavaLangString, ((PasterParcelData)localObject2).jdField_d_of_type_Int);
          ((bovs)localObject1).a();
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("DynamicFaceLayer", 2, new Object[] { "reflect faceLayer Item error : ", localException.getMessage() });
          continue;
        }
        label660:
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