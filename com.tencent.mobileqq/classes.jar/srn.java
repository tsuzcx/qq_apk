import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.vinstance.Precondition;
import com.tencent.viola.vinstance.PreconditionAdapter;

public class srn
  implements PreconditionAdapter, sri
{
  private ViolaBaseView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView;
  private Precondition jdField_a_of_type_ComTencentViolaVinstancePrecondition;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private Precondition b;
  
  public srn(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    ViolaLogUtils.d("Wormhole", "success");
    if (this.jdField_a_of_type_ComTencentViolaVinstancePrecondition != null) {
      this.jdField_a_of_type_ComTencentViolaVinstancePrecondition.setResult(true);
    }
  }
  
  public void a(String paramString)
  {
    ViolaLogUtils.d("Wormhole", paramString);
    if ((this.b != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.b.setResult(true, paramString);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void b()
  {
    ViolaLogUtils.d("Wormhole", "error");
    if (this.jdField_a_of_type_ComTencentViolaVinstancePrecondition != null) {
      this.jdField_a_of_type_ComTencentViolaVinstancePrecondition.setResult(false);
    }
  }
  
  public void c()
  {
    ViolaLogUtils.d("Wormhole", "error");
    if ((this.b != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.b.setResult(false, null);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void init(Precondition paramPrecondition)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView = new ViolaBaseView(BaseApplicationImpl.getApplication());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(this.jdField_a_of_type_JavaLangString, null, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.setBaseViewListener(this);
    this.jdField_a_of_type_ComTencentViolaVinstancePrecondition = paramPrecondition;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void loadWormhole(Precondition paramPrecondition)
  {
    this.b = paramPrecondition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     srn
 * JD-Core Version:    0.7.0.1
 */