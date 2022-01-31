import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderFriendRecommend;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.widget.FixSizeImageView;

public class rfk
{
  public View a;
  public TextView a;
  public ComponentHeaderFriendRecommend a;
  public KandianUrlImageView a;
  public View[] a;
  public TextView[] a;
  public FixSizeImageView[] a;
  public View b;
  public TextView b;
  public View c;
  public TextView c;
  public View d;
  public TextView d;
  public View e;
  public TextView e;
  public View f;
  public TextView f;
  public View g;
  public View h;
  public View i;
  public View j;
  public View k;
  public View l;
  public View m;
  private View n;
  
  public rfk(View paramView)
  {
    this.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView = new FixSizeImageView[4];
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[4];
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[2];
    this.n = paramView;
    e();
  }
  
  private void e()
  {
    this.jdField_e_of_type_AndroidViewView = this.n.findViewById(2131378625);
    this.jdField_f_of_type_AndroidViewView = this.n.findViewById(2131376698);
    this.g = this.n.findViewById(2131370647);
    this.l = this.n.findViewById(2131374732);
  }
  
  public View a()
  {
    return this.n;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView = ((ViewStub)this.n.findViewById(2131374737)).inflate();
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131362822);
    this.jdField_c_of_type_AndroidViewView = this.n.findViewById(2131374744);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.n.findViewById(2131374758));
    this.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[0] = ((FixSizeImageView)this.n.findViewById(2131374733));
    this.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[1] = ((FixSizeImageView)this.n.findViewById(2131374734));
    this.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[2] = ((FixSizeImageView)this.n.findViewById(2131374735));
    this.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[3] = ((FixSizeImageView)this.n.findViewById(2131374736));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131374749));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131374740));
    this.jdField_d_of_type_AndroidViewView = this.n.findViewById(2131378645);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend = ((ComponentHeaderFriendRecommend)this.n.findViewById(2131367455));
  }
  
  public boolean a()
  {
    if (this.m != null) {
      return true;
    }
    ViewStub localViewStub = (ViewStub)this.n.findViewById(2131374755);
    if (localViewStub == null) {
      return false;
    }
    this.m = localViewStub.inflate();
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131374754));
    return true;
  }
  
  public void b()
  {
    if (this.h != null) {
      return;
    }
    this.h = ((ViewStub)this.n.findViewById(2131368769)).inflate();
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)this.n.findViewById(2131368770));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)this.n.findViewById(2131368772));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)this.n.findViewById(2131368774));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3] = ((TextView)this.n.findViewById(2131368775));
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = this.n.findViewById(2131368771);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = this.n.findViewById(2131368773);
  }
  
  public void c()
  {
    if (this.i != null) {
      return;
    }
    this.i = ((ViewStub)this.n.findViewById(2131366792)).inflate();
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131366793));
  }
  
  public void d()
  {
    if (this.j != null) {
      return;
    }
    this.j = ((ViewStub)this.n.findViewById(2131364518)).inflate();
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131364516));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131364514));
    this.k = this.n.findViewById(2131364477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rfk
 * JD-Core Version:    0.7.0.1
 */