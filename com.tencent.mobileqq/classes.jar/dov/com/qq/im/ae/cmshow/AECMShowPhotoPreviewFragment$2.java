package dov.com.qq.im.ae.cmshow;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.TextView;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.text.DynamicTextItem.Pair;
import java.util.List;

class AECMShowPhotoPreviewFragment$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int = 0;
  
  AECMShowPhotoPreviewFragment$2(AECMShowPhotoPreviewFragment paramAECMShowPhotoPreviewFragment) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_Int += 1;
    AEQLog.a("AECMShowPhotoPreviewFragment", "[onGlobalLayout] called, invokeCount=" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int >= 2)
    {
      localObject = AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment).getViewTreeObserver();
      if (((ViewTreeObserver)localObject).isAlive())
      {
        if (Build.VERSION.SDK_INT < 16) {
          break label87;
        }
        ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener(this);
      }
    }
    while (AECMShowPhotoPreviewFragment.b(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment))
    {
      return;
      label87:
      ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this);
    }
    AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment, true);
    Object localObject = AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment, AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment), AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment));
    if ((localObject != null) && (((DynamicTextItem.Pair)localObject).a != null) && (((Boolean)((DynamicTextItem.Pair)localObject).a).booleanValue()))
    {
      AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment, (List)((DynamicTextItem.Pair)localObject).b);
      return;
    }
    AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment).setEnabled(true);
    AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment).setText(2131689686);
    AECMShowPhotoPreviewFragment.b(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment).setVisibility(0);
    AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowPhotoPreviewFragment).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.AECMShowPhotoPreviewFragment.2
 * JD-Core Version:    0.7.0.1
 */