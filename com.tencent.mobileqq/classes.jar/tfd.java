import android.content.Context;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;
import com.tencent.qphone.base.util.QLog;

public abstract class tfd
  implements ste
{
  private static final String a;
  protected int a;
  public aaul a;
  protected Context a;
  protected SlideActiveAnimController a;
  protected tfe a;
  protected tff a;
  
  static
  {
    jdField_a_of_type_JavaLangString = tfd.class.getSimpleName();
  }
  
  public tfd(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    if (this.jdField_a_of_type_Tfe != null) {
      this.jdField_a_of_type_Tfe.a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isDebugVersion()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "onPullRefreshing percent:" + paramInt + " isTopRefreshing:" + paramBoolean);
    }
  }
  
  public void a(SlideActiveAnimController paramSlideActiveAnimController)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = paramSlideActiveAnimController;
  }
  
  public void a(tfe paramtfe)
  {
    this.jdField_a_of_type_Tfe = paramtfe;
  }
  
  public void a(tff paramtff)
  {
    this.jdField_a_of_type_Tff = paramtff;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Tff != null) {
      this.jdField_a_of_type_Tff.a(paramBoolean);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tfd
 * JD-Core Version:    0.7.0.1
 */