import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.widget.AbsListView.LayoutParams;
import java.lang.reflect.Constructor;

public class reg<T extends View>
  extends rbp
{
  private Class<T> a;
  
  public reg(Context paramContext, FaceDecoder paramFaceDecoder, szd paramszd, Class<T> paramClass)
  {
    super(paramContext, paramFaceDecoder, paramszd);
    this.jdField_a_of_type_JavaLangClass = paramClass;
  }
  
  public rbp a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g().l().n();
  }
  
  public rbp d()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if ((this.jdField_a_of_type_Rbo != null) && (this.jdField_a_of_type_Rbo.getClass().equals(this.jdField_a_of_type_JavaLangClass))) {
      localLinearLayout.addView((View)this.jdField_a_of_type_Rbo);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead);
    }
    a(localLinearLayout);
    return this;
  }
  
  public rbp e()
  {
    return this;
  }
  
  public rbp g()
  {
    try
    {
      this.jdField_a_of_type_Rbo = ((rbo)this.jdField_a_of_type_JavaLangClass.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { this.jdField_a_of_type_AndroidContentContext }));
      return this;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this;
  }
  
  public rbp o()
  {
    super.o();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     reg
 * JD-Core Version:    0.7.0.1
 */