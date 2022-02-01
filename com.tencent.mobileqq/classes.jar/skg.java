import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderFriendRecommend;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.widget.FixSizeImageView;

public class skg
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
  
  public skg(View paramView)
  {
    this.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView = new FixSizeImageView[4];
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[4];
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[2];
    this.n = paramView;
    e();
  }
  
  private void e()
  {
    this.jdField_e_of_type_AndroidViewView = this.n.findViewById(2131380413);
    this.jdField_f_of_type_AndroidViewView = this.n.findViewById(2131378230);
    this.g = this.n.findViewById(2131371647);
    this.l = this.n.findViewById(2131376116);
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
    this.jdField_b_of_type_AndroidViewView = ((ViewStub)this.n.findViewById(2131376121)).inflate();
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131362986);
    this.jdField_c_of_type_AndroidViewView = this.n.findViewById(2131376128);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.n.findViewById(2131376142));
    this.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[0] = ((FixSizeImageView)this.n.findViewById(2131376117));
    this.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[1] = ((FixSizeImageView)this.n.findViewById(2131376118));
    this.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[2] = ((FixSizeImageView)this.n.findViewById(2131376119));
    this.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[3] = ((FixSizeImageView)this.n.findViewById(2131376120));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131376133));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131376124));
    this.jdField_d_of_type_AndroidViewView = this.n.findViewById(2131380433);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend = ((ComponentHeaderFriendRecommend)this.n.findViewById(2131367971));
  }
  
  public boolean a()
  {
    if (this.m != null) {
      return true;
    }
    ViewStub localViewStub = (ViewStub)this.n.findViewById(2131376139);
    if (localViewStub == null) {
      return false;
    }
    this.m = localViewStub.inflate();
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131376138));
    return true;
  }
  
  public void b()
  {
    if (this.h != null) {
      return;
    }
    this.h = ((ViewStub)this.n.findViewById(2131369482)).inflate();
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)this.n.findViewById(2131369483));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)this.n.findViewById(2131369485));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)this.n.findViewById(2131369487));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3] = ((TextView)this.n.findViewById(2131369488));
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = this.n.findViewById(2131369484);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = this.n.findViewById(2131369486);
  }
  
  public void c()
  {
    if (this.i != null) {
      return;
    }
    this.i = ((ViewStub)this.n.findViewById(2131367240)).inflate();
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131367241));
  }
  
  public void d()
  {
    if (this.j != null) {
      return;
    }
    this.j = ((ViewStub)this.n.findViewById(2131364859)).inflate();
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131364856));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131364854));
    this.k = this.n.findViewById(2131364814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     skg
 * JD-Core Version:    0.7.0.1
 */