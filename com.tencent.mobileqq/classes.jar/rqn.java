import android.content.Context;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;
import com.tencent.qphone.base.util.QLog;

public abstract class rqn
  implements rfm
{
  private static final String a;
  protected int a;
  protected Context a;
  protected SlideActiveAnimController a;
  protected rqo a;
  protected rqp a;
  public xea a;
  
  static
  {
    jdField_a_of_type_JavaLangString = rqn.class.getSimpleName();
  }
  
  public rqn(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    if (this.jdField_a_of_type_Rqo != null) {
      this.jdField_a_of_type_Rqo.a(paramInt1, paramInt2);
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
  
  public void a(rqo paramrqo)
  {
    this.jdField_a_of_type_Rqo = paramrqo;
  }
  
  public void a(rqp paramrqp)
  {
    this.jdField_a_of_type_Rqp = paramrqp;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Rqp != null) {
      this.jdField_a_of_type_Rqp.a(paramBoolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rqn
 * JD-Core Version:    0.7.0.1
 */