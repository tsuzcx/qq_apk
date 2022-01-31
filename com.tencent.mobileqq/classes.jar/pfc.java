import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyUninterestComplainFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;

class pfc
  implements bekr
{
  pfc(pez parampez) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FeedItemCell", 2, "onAdComplain");
    }
    if ((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_from_type", 1);
      localIntent.putExtra("key_ad_info", ((opw)this.a.jdField_a_of_type_JavaLangObject).a());
      PublicFragmentActivity.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, localIntent, ReadInJoyUninterestComplainFragment.class, 9999);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pfc
 * JD-Core Version:    0.7.0.1
 */