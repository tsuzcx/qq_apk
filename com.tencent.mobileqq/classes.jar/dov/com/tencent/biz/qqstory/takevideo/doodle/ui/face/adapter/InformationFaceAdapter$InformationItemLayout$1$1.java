package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import beyq;
import bqpt;
import bqpu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.vas.VasApngUtil;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import java.lang.ref.WeakReference;

public class InformationFaceAdapter$InformationItemLayout$1$1
  implements Runnable
{
  public InformationFaceAdapter$InformationItemLayout$1$1(bqpt parambqpt, boolean paramBoolean) {}
  
  public void run()
  {
    ((QIMCommonLoadingView)this.jdField_a_of_type_Bqpt.jdField_a_of_type_JavaLangRefWeakReference.get()).setVisibility(8);
    ((ImageView)this.jdField_a_of_type_Bqpt.b.get()).setVisibility(0);
    if (this.jdField_a_of_type_Boolean)
    {
      URLDrawable localURLDrawable = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), this.jdField_a_of_type_Bqpt.jdField_a_of_type_JavaLangString, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
      Object localObject;
      if (localURLDrawable != null)
      {
        ImageView localImageView = (ImageView)this.jdField_a_of_type_Bqpt.b.get();
        if (!this.jdField_a_of_type_Bqpt.jdField_a_of_type_Boolean) {
          break label204;
        }
        localObject = localURLDrawable;
        localImageView.setImageDrawable((Drawable)localObject);
        ((ImageView)this.jdField_a_of_type_Bqpt.b.get()).setTag(2131378405, Boolean.valueOf(true));
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.restartDownload();
        }
        if (localURLDrawable.getStatus() == 1) {
          this.jdField_a_of_type_Bqpt.jdField_a_of_type_Bqpu.onLoadSuccessed((View)this.jdField_a_of_type_Bqpt.b.get(), localURLDrawable);
        }
        localObject = (ImageView)this.jdField_a_of_type_Bqpt.b.get();
        if (!this.jdField_a_of_type_Bqpt.jdField_a_of_type_Boolean) {
          break label209;
        }
      }
      for (;;)
      {
        ((ImageView)localObject).setImageDrawable(localURLDrawable);
        return;
        label204:
        localObject = null;
        break;
        label209:
        localURLDrawable = null;
      }
    }
    ((ImageView)this.jdField_a_of_type_Bqpt.b.get()).setImageDrawable(beyq.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.InformationItemLayout.1.1
 * JD-Core Version:    0.7.0.1
 */