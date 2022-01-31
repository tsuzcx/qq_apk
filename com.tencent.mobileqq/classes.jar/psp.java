import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentNoteCard;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyLifeCycleLinearLayout;
import com.tencent.widget.AbsListView.LayoutParams;

public class psp
  extends pqt
{
  public psp(Context paramContext, baxk parambaxk, rap paramrap)
  {
    super(paramContext, parambaxk, paramrap);
  }
  
  public pqt a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g().l().n();
  }
  
  public void b()
  {
    super.b();
    ((ComponentContentNoteCard)this.jdField_a_of_type_Pqs).c();
  }
  
  public pqt d()
  {
    ReadInJoyLifeCycleLinearLayout localReadInJoyLifeCycleLinearLayout = new ReadInJoyLifeCycleLinearLayout(this.jdField_a_of_type_AndroidContentContext, null);
    localReadInJoyLifeCycleLinearLayout.setOrientation(1);
    localReadInJoyLifeCycleLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if ((this.jdField_a_of_type_Pqs != null) && ((this.jdField_a_of_type_Pqs instanceof ComponentContentNoteCard))) {
      localReadInJoyLifeCycleLinearLayout.addView((ComponentContentNoteCard)this.jdField_a_of_type_Pqs);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
      localReadInJoyLifeCycleLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead);
    }
    a(localReadInJoyLifeCycleLinearLayout);
    return this;
  }
  
  public pqt e()
  {
    return this;
  }
  
  public pqt g()
  {
    this.jdField_a_of_type_Pqs = new ComponentContentNoteCard(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Rap);
    return this;
  }
  
  public pqt o()
  {
    super.o();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     psp
 * JD-Core Version:    0.7.0.1
 */