import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.view.headers.question.ReadInJoyQuestionBannerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.headers.question.ReadInJoyQuestionBannerViewPager;

public class rcm
  extends Handler
{
  public rcm(ReadInJoyQuestionBannerViewPager paramReadInJoyQuestionBannerViewPager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((ReadInJoyQuestionBannerViewPager.a(this.a)) || (!ReadInJoyQuestionBannerViewPager.b(this.a))) {}
    while (ReadInJoyQuestionBannerViewPager.a(this.a).getCount() <= 1) {
      return;
    }
    paramMessage = this.a;
    paramMessage.jdField_a_of_type_Int += 1;
    this.a.jdField_a_of_type_Int %= ReadInJoyQuestionBannerViewPager.a(this.a).getCount();
    this.a.setCurrentItem(this.a.jdField_a_of_type_Int, true);
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(), 4000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rcm
 * JD-Core Version:    0.7.0.1
 */