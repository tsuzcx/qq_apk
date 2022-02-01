package com.tencent.mobileqq.kandian.glue.viola.wormhole;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView;
import com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.OnBaseViewListener;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.vinstance.Precondition;
import com.tencent.viola.vinstance.PreconditionAdapter;

public class PreconditionAdapterImpl
  implements ViolaBaseView.OnBaseViewListener, PreconditionAdapter
{
  private ViolaBaseView jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
  private Precondition jdField_a_of_type_ComTencentViolaVinstancePrecondition;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private Precondition b;
  
  public PreconditionAdapterImpl(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    ViolaLogUtils.d("Wormhole", "success");
    Precondition localPrecondition = this.jdField_a_of_type_ComTencentViolaVinstancePrecondition;
    if (localPrecondition != null) {
      localPrecondition.setResult(true);
    }
  }
  
  public void a(String paramString)
  {
    ViolaLogUtils.d("Wormhole", paramString);
    Precondition localPrecondition = this.b;
    if ((localPrecondition != null) && (!this.jdField_a_of_type_Boolean))
    {
      localPrecondition.setResult(true, paramString);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void b()
  {
    ViolaLogUtils.d("Wormhole", "error");
    Precondition localPrecondition = this.jdField_a_of_type_ComTencentViolaVinstancePrecondition;
    if (localPrecondition != null) {
      localPrecondition.setResult(false);
    }
  }
  
  public void c()
  {
    ViolaLogUtils.d("Wormhole", "error");
    Precondition localPrecondition = this.b;
    if ((localPrecondition != null) && (!this.jdField_a_of_type_Boolean))
    {
      localPrecondition.setResult(false, null);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public String getPageData()
  {
    return null;
  }
  
  public void init(Precondition paramPrecondition)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView = new ViolaBaseView(BaseApplicationImpl.getApplication());
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.a(this.jdField_a_of_type_JavaLangString, null, null);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.setBaseViewListener(this);
    this.jdField_a_of_type_ComTencentViolaVinstancePrecondition = paramPrecondition;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void loadWormhole(Precondition paramPrecondition)
  {
    this.b = paramPrecondition;
  }
  
  public void onInitError() {}
  
  public void onInitSuccess() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.wormhole.PreconditionAdapterImpl
 * JD-Core Version:    0.7.0.1
 */