import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBig;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBigImageVideo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.widget.AbsListView.LayoutParams;

public class reb
  extends rbp
{
  public reb(Context paramContext, FaceDecoder paramFaceDecoder, szd paramszd)
  {
    super(paramContext, paramFaceDecoder, paramszd);
  }
  
  public rbp a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g().h();
  }
  
  public rbp d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof qhk)) && (pqw.g(((qhk)this.jdField_a_of_type_JavaLangObject).a()))) {
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(AIOUtils.dp2px(250.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -2));
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Rbo != null) && ((this.jdField_a_of_type_Rbo instanceof ComponentContentBig))) {
        localLinearLayout.addView((ComponentContentBig)this.jdField_a_of_type_Rbo);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle);
      }
      a(localLinearLayout);
      return this;
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(AIOUtils.dp2px(220.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -2));
    }
  }
  
  public rbp e()
  {
    return null;
  }
  
  public rbp g()
  {
    this.jdField_a_of_type_Rbo = new ComponentContentBigImageVideo(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     reb
 * JD-Core Version:    0.7.0.1
 */