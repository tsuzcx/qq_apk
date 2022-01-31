import android.content.Context;
import com.tencent.biz.pubaccount.VideoInfo;
import java.lang.ref.WeakReference;

class qgt
  implements run
{
  private int jdField_a_of_type_Int;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private int b;
  private int c;
  private int d;
  
  public qgt(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      qfy.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.c, this.d, false, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qgt
 * JD-Core Version:    0.7.0.1
 */