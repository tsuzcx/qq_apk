import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotQuestion;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.widget.AbsListView.LayoutParams;

public class rda
  extends rbp
{
  public rda(Context paramContext, FaceDecoder paramFaceDecoder, szd paramszd)
  {
    super(paramContext, paramFaceDecoder, paramszd);
  }
  
  public rbp a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g();
  }
  
  public rbp d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(AIOUtils.dp2px(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -2));
    if ((this.jdField_a_of_type_Rbo != null) && ((this.jdField_a_of_type_Rbo instanceof ComponentContentHotQuestion))) {
      localLinearLayout.addView((ComponentContentHotQuestion)this.jdField_a_of_type_Rbo);
    }
    a(localLinearLayout);
    return this;
  }
  
  public rbp e()
  {
    return null;
  }
  
  public rbp g()
  {
    this.jdField_a_of_type_Rbo = new ComponentContentHotQuestion(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rda
 * JD-Core Version:    0.7.0.1
 */