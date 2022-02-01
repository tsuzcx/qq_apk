package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.List;

class FaceListPage$2
  implements Runnable
{
  FaceListPage$2(FaceListPage paramFaceListPage, NormalFacePackage paramNormalFacePackage, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.a(this.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Boolean)
    {
      SLog.b("FaceListPage", "FacePkg is already download.show face list.");
      FaceListPage.a(this.this$0).setMax(1);
      FaceListPage.a(this.this$0).setProgress(1);
      this.this$0.postDelayed(new FaceListPage.2.1(this), 30L);
    }
    do
    {
      return;
      FaceListPage.a(this.this$0).setVisibility(4);
      FaceListPage.b(this.this$0).setVisibility(4);
      FaceListPage.a(this.this$0).setVisibility(0);
      Object localObject = (String)FaceListPage.a(this.this$0).getTag(2131378926);
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equals(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.jdField_d_of_type_JavaLangString)))
      {
        FaceListPage.a(this.this$0).setTag(2131378926, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.jdField_d_of_type_JavaLangString);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = FaceListPage.a(this.this$0);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = FaceListPage.a(this.this$0);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.getStickerFailedDrawable();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
        localObject = URLDrawable.getDrawable(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.jdField_d_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
        FaceListPage.a(this.this$0).setImageDrawable((Drawable)localObject);
      }
      TextView localTextView = FaceListPage.a(this.this$0);
      if (TextUtils.isEmpty(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.jdField_b_of_type_JavaLangString)) {}
      for (localObject = "";; localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.jdField_b_of_type_JavaLangString)
      {
        localTextView.setText((CharSequence)localObject);
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.jdField_b_of_type_Boolean) {
          break;
        }
        FaceListPage.a(this.this$0).setMax(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.c);
        FaceListPage.a(this.this$0).setProgress(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.jdField_d_of_type_Int);
        FaceListPage.b(this.this$0).setText(HardCodeUtil.a(2131704322));
        FaceListPage.a(this.this$0).setVisibility(0);
        return;
      }
      FaceListPage.a(this.this$0).setMax(1);
      FaceListPage.a(this.this$0).setProgress(0);
      FaceListPage.b(this.this$0).setBackgroundResource(2130846841);
      FaceListPage.a(this.this$0).setVisibility(4);
    } while (StringUtil.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.e));
    FaceListPage.b(this.this$0).setText(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage.2
 * JD-Core Version:    0.7.0.1
 */