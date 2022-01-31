package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import ajjy;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import axwd;
import baip;
import biox;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.List;
import urk;

class FaceListPage$2
  implements Runnable
{
  FaceListPage$2(FaceListPage paramFaceListPage, biox parambiox, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_Biox.a(this.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Boolean)
    {
      urk.b("FaceListPage", "FacePkg is already download.show face list.");
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
      Object localObject = (String)FaceListPage.a(this.this$0).getTag(2131311070);
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equals(this.jdField_a_of_type_Biox.jdField_d_of_type_JavaLangString)))
      {
        FaceListPage.a(this.this$0).setTag(2131311070, this.jdField_a_of_type_Biox.jdField_d_of_type_JavaLangString);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = FaceListPage.a(this.this$0);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = FaceListPage.a(this.this$0);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = axwd.c();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = axwd.a;
        ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
        localObject = URLDrawable.getDrawable(this.jdField_a_of_type_Biox.jdField_d_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
        FaceListPage.a(this.this$0).setImageDrawable((Drawable)localObject);
      }
      TextView localTextView = FaceListPage.a(this.this$0);
      if (TextUtils.isEmpty(this.jdField_a_of_type_Biox.jdField_b_of_type_JavaLangString)) {}
      for (localObject = "";; localObject = this.jdField_a_of_type_Biox.jdField_b_of_type_JavaLangString)
      {
        localTextView.setText((CharSequence)localObject);
        if (!this.jdField_a_of_type_Biox.jdField_b_of_type_Boolean) {
          break;
        }
        FaceListPage.a(this.this$0).setMax(this.jdField_a_of_type_Biox.c);
        FaceListPage.a(this.this$0).setProgress(this.jdField_a_of_type_Biox.jdField_d_of_type_Int);
        FaceListPage.b(this.this$0).setText(ajjy.a(2131638509));
        FaceListPage.a(this.this$0).setVisibility(0);
        return;
      }
      FaceListPage.a(this.this$0).setMax(1);
      FaceListPage.a(this.this$0).setProgress(0);
      FaceListPage.b(this.this$0).setBackgroundResource(2130845396);
      FaceListPage.a(this.this$0).setVisibility(4);
    } while (baip.a(this.jdField_a_of_type_Biox.e));
    FaceListPage.b(this.this$0).setText(this.jdField_a_of_type_Biox.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage.2
 * JD-Core Version:    0.7.0.1
 */