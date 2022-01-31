import android.content.Context;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;
import com.tencent.qphone.base.util.QLog;

public abstract class rec
  implements qtd
{
  private static final String a;
  protected int a;
  protected Context a;
  protected SlideActiveAnimController a;
  protected red a;
  protected ree a;
  public wpa a;
  
  static
  {
    jdField_a_of_type_JavaLangString = rec.class.getSimpleName();
  }
  
  public rec(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    if (this.jdField_a_of_type_Red != null) {
      this.jdField_a_of_type_Red.a(paramInt1, paramInt2);
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
  
  public void a(red paramred)
  {
    this.jdField_a_of_type_Red = paramred;
  }
  
  public void a(ree paramree)
  {
    this.jdField_a_of_type_Ree = paramree;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ree != null) {
      this.jdField_a_of_type_Ree.a(paramBoolean);
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
 * Qualified Name:     rec
 * JD-Core Version:    0.7.0.1
 */