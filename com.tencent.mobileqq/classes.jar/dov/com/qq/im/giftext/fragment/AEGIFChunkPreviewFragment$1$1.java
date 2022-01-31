package dov.com.qq.im.giftext.fragment;

import android.view.ViewGroup;
import bhsp;
import bhtg;
import bhth;

public class AEGIFChunkPreviewFragment$1$1
  implements Runnable
{
  public AEGIFChunkPreviewFragment$1$1(bhth parambhth, int paramInt) {}
  
  public void run()
  {
    if (bhtg.a(this.jdField_a_of_type_Bhth.a) != null) {
      bhtg.a(this.jdField_a_of_type_Bhth.a).notifyItemChanged(this.jdField_a_of_type_Int);
    }
    if (bhtg.a(this.jdField_a_of_type_Bhth.a) != null)
    {
      if (bhtg.a(this.jdField_a_of_type_Bhth.a) != null) {
        bhtg.a(this.jdField_a_of_type_Bhth.a).removeCallbacks(bhtg.a(this.jdField_a_of_type_Bhth.a));
      }
      bhtg.a(this.jdField_a_of_type_Bhth.a).postDelayed(bhtg.a(this.jdField_a_of_type_Bhth.a, new AEGIFChunkPreviewFragment.1.1.1(this)), bhtg.a(this.jdField_a_of_type_Bhth.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.giftext.fragment.AEGIFChunkPreviewFragment.1.1
 * JD-Core Version:    0.7.0.1
 */