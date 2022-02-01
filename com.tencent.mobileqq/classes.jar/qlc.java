import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentNoteCard;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyLifeCycleLinearLayout;
import com.tencent.widget.AbsListView.LayoutParams;

public class qlc
  extends qjh
{
  public qlc(Context paramContext, aoof paramaoof, sel paramsel)
  {
    super(paramContext, paramaoof, paramsel);
  }
  
  public qjh a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g().l().n();
  }
  
  public void b()
  {
    super.b();
    ((ComponentContentNoteCard)this.jdField_a_of_type_Qjg).c();
  }
  
  public qjh d()
  {
    ReadInJoyLifeCycleLinearLayout localReadInJoyLifeCycleLinearLayout = new ReadInJoyLifeCycleLinearLayout(this.jdField_a_of_type_AndroidContentContext, null);
    localReadInJoyLifeCycleLinearLayout.setOrientation(1);
    localReadInJoyLifeCycleLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if ((this.jdField_a_of_type_Qjg != null) && ((this.jdField_a_of_type_Qjg instanceof ComponentContentNoteCard))) {
      localReadInJoyLifeCycleLinearLayout.addView((ComponentContentNoteCard)this.jdField_a_of_type_Qjg);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
      localReadInJoyLifeCycleLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead);
    }
    a(localReadInJoyLifeCycleLinearLayout);
    return this;
  }
  
  public qjh e()
  {
    return this;
  }
  
  public qjh g()
  {
    this.jdField_a_of_type_Qjg = new ComponentContentNoteCard(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Sel);
    return this;
  }
  
  public qjh o()
  {
    super.o();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qlc
 * JD-Core Version:    0.7.0.1
 */