package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import aywk;
import bbql;
import bkgf;
import bkgg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import java.lang.ref.WeakReference;

public class InformationFaceAdapter$InformationItemLayout$1$1
  implements Runnable
{
  public InformationFaceAdapter$InformationItemLayout$1$1(bkgf parambkgf, boolean paramBoolean) {}
  
  public void run()
  {
    ((QIMCommonLoadingView)this.jdField_a_of_type_Bkgf.jdField_a_of_type_JavaLangRefWeakReference.get()).setVisibility(8);
    ((ImageView)this.jdField_a_of_type_Bkgf.b.get()).setVisibility(0);
    if (this.jdField_a_of_type_Boolean)
    {
      URLDrawable localURLDrawable = bbql.a(BaseApplicationImpl.sApplication.getRuntime(), this.jdField_a_of_type_Bkgf.jdField_a_of_type_JavaLangString, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
      Object localObject;
      if (localURLDrawable != null)
      {
        ImageView localImageView = (ImageView)this.jdField_a_of_type_Bkgf.b.get();
        if (!this.jdField_a_of_type_Bkgf.jdField_a_of_type_Boolean) {
          break label204;
        }
        localObject = localURLDrawable;
        localImageView.setImageDrawable((Drawable)localObject);
        ((ImageView)this.jdField_a_of_type_Bkgf.b.get()).setTag(2131376849, Boolean.valueOf(true));
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.restartDownload();
        }
        if (localURLDrawable.getStatus() == 1) {
          this.jdField_a_of_type_Bkgf.jdField_a_of_type_Bkgg.onLoadSuccessed((View)this.jdField_a_of_type_Bkgf.b.get(), localURLDrawable);
        }
        localObject = (ImageView)this.jdField_a_of_type_Bkgf.b.get();
        if (!this.jdField_a_of_type_Bkgf.jdField_a_of_type_Boolean) {
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
    ((ImageView)this.jdField_a_of_type_Bkgf.b.get()).setImageDrawable(aywk.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.InformationItemLayout.1.1
 * JD-Core Version:    0.7.0.1
 */