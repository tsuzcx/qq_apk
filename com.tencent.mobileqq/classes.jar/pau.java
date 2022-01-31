import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

public class pau
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public pau(ReadInJoySelfFragment paramReadInJoySelfFragment, ImageView paramImageView, nxe paramnxe) {}
  
  public void onGlobalLayout()
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 16)
        {
          ReadInJoySelfFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment).getViewTreeObserver().removeOnGlobalLayoutListener(this);
          int j = ReadInJoySelfFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment).getWidth();
          if (ReadInJoySelfFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment))
          {
            i = (int)(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment.jdField_a_of_type_Float + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment.c + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment.jdField_b_of_type_Float);
            if (i <= 0) {
              break;
            }
            double d1 = this.jdField_a_of_type_Nxe.c / this.jdField_a_of_type_Nxe.d;
            double d2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment.d;
            i = (int)(j - i - d1 * d2);
            if (i <= 0) {
              break;
            }
            Drawable localDrawable = DrawableUtil.getDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment.getActivity(), this.jdField_a_of_type_Nxe.b, null, null);
            if (localDrawable == null) {
              break;
            }
            ReadInJoySelfFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment).setMaxWidth(i);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localDrawable);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment.jdField_a_of_type_ComTencentImageURLImageView.setTag(this.jdField_a_of_type_Nxe);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment);
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment.jdField_b_of_type_Boolean) {
              break;
            }
            ors.a(this.jdField_a_of_type_Nxe);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment.jdField_b_of_type_Boolean = true;
          }
        }
        else
        {
          ReadInJoySelfFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment).getViewTreeObserver().removeGlobalOnLayoutListener(this);
          continue;
        }
        f1 = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      }
      catch (Exception localException)
      {
        QLog.d("Q.readinjoy.self.SelfFragment", 1, "showMedal! error, msg=" + localException);
        return;
      }
      float f1;
      float f2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment.jdField_a_of_type_Float;
      float f3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment.jdField_b_of_type_Float;
      float f4 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment.c;
      int i = (int)(f1 + f2 + f3 + f4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pau
 * JD-Core Version:    0.7.0.1
 */