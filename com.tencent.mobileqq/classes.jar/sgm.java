import android.content.Context;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;
import com.tencent.qphone.base.util.QLog;

public abstract class sgm
  implements rvi
{
  private static final String a;
  protected int a;
  protected Context a;
  protected SlideActiveAnimController a;
  protected sgn a;
  protected sgo a;
  public yst a;
  
  static
  {
    jdField_a_of_type_JavaLangString = sgm.class.getSimpleName();
  }
  
  public sgm(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    if (this.jdField_a_of_type_Sgn != null) {
      this.jdField_a_of_type_Sgn.a(paramInt1, paramInt2);
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
  
  public void a(sgn paramsgn)
  {
    this.jdField_a_of_type_Sgn = paramsgn;
  }
  
  public void a(sgo paramsgo)
  {
    this.jdField_a_of_type_Sgo = paramsgo;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Sgo != null) {
      this.jdField_a_of_type_Sgo.a(paramBoolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sgm
 * JD-Core Version:    0.7.0.1
 */