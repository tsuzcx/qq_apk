import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentNoteCard;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyLifeCycleLinearLayout;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.widget.AbsListView.LayoutParams;

public class rdk
  extends rbp
{
  public rdk(Context paramContext, FaceDecoder paramFaceDecoder, szd paramszd)
  {
    super(paramContext, paramFaceDecoder, paramszd);
  }
  
  public rbp a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g().l().n();
  }
  
  public void b()
  {
    super.b();
    ((ComponentContentNoteCard)this.jdField_a_of_type_Rbo).c();
  }
  
  public rbp d()
  {
    ReadInJoyLifeCycleLinearLayout localReadInJoyLifeCycleLinearLayout = new ReadInJoyLifeCycleLinearLayout(this.jdField_a_of_type_AndroidContentContext, null);
    localReadInJoyLifeCycleLinearLayout.setOrientation(1);
    localReadInJoyLifeCycleLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if ((this.jdField_a_of_type_Rbo != null) && ((this.jdField_a_of_type_Rbo instanceof ComponentContentNoteCard))) {
      localReadInJoyLifeCycleLinearLayout.addView((ComponentContentNoteCard)this.jdField_a_of_type_Rbo);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
      localReadInJoyLifeCycleLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead);
    }
    a(localReadInJoyLifeCycleLinearLayout);
    return this;
  }
  
  public rbp e()
  {
    return this;
  }
  
  public rbp g()
  {
    this.jdField_a_of_type_Rbo = new ComponentContentNoteCard(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Szd);
    return this;
  }
  
  public rbp o()
  {
    super.o();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rdk
 * JD-Core Version:    0.7.0.1
 */