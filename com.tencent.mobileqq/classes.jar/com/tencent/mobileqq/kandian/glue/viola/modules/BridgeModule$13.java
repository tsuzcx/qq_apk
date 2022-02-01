package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout;
import com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo.ViolaCommentManager.CommentEventListener;
import com.tencent.viola.core.ViolaInstance;

class BridgeModule$13
  implements ViolaCommentManager.CommentEventListener
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  BridgeModule$13(BridgeModule paramBridgeModule) {}
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.getViolaInstance() != null) && ((this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.getViolaInstance().getFragment() instanceof ViolaFragment)))
    {
      ViolaFragment localViolaFragment = (ViolaFragment)this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.getViolaInstance().getFragment();
      if (paramBoolean)
      {
        this.jdField_a_of_type_JavaLangString = localViolaFragment.getStatusBarColor();
        this.jdField_a_of_type_Boolean = localViolaFragment.getStatusBarFontColorWhite().booleanValue();
        localViolaFragment.setStatusBarColor("#FF000000");
        localViolaFragment.initStatusBarColor("#FF000000");
        localViolaFragment.setStatusBarFontColor(Boolean.valueOf(true), true);
        return;
      }
      localViolaFragment.setStatusBarColor(this.jdField_a_of_type_JavaLangString);
      localViolaFragment.initStatusBarColor(this.jdField_a_of_type_JavaLangString);
      localViolaFragment.setStatusBarFontColor(Boolean.valueOf(this.jdField_a_of_type_Boolean), true);
      if ((localViolaFragment.isSuspension()) && (localViolaFragment.getCommonSuspensionGestureLayout() != null) && ((localViolaFragment.getCommonSuspensionGestureLayout() instanceof CommonSuspensionGestureLayout))) {
        ((CommonSuspensionGestureLayout)localViolaFragment.getCommonSuspensionGestureLayout()).g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule.13
 * JD-Core Version:    0.7.0.1
 */