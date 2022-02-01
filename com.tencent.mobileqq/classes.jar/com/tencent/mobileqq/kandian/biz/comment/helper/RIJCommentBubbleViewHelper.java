package com.tencent.mobileqq.kandian.biz.comment.helper;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/helper/RIJCommentBubbleViewHelper;", "", "()V", "PATROL_ARBITRATION_SWITCH", "", "PATROL_ARBITRATION_TEXT", "TAG", "commentBubbleConfigs", "Lcom/tencent/aladdin/config/AladdinConfig;", "clearCommentBubbleConfigs", "", "enablePatrolArbitration", "", "getPatrolArbitrationTxt", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentBubbleViewHelper
{
  private static AladdinConfig jdField_a_of_type_ComTencentAladdinConfigAladdinConfig;
  public static final RIJCommentBubbleViewHelper a;
  private static final String jdField_a_of_type_JavaLangString = "RIJCommentBubbleViewHelper";
  private static final String b = "is_switch_on";
  private static final String c = "text";
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizCommentHelperRIJCommentBubbleViewHelper = new RIJCommentBubbleViewHelper();
  }
  
  @NotNull
  public final String a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentAladdinConfigAladdinConfig == null) {
        jdField_a_of_type_ComTencentAladdinConfigAladdinConfig = Aladdin.getConfig(468);
      }
      Object localObject1 = jdField_a_of_type_ComTencentAladdinConfigAladdinConfig;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((AladdinConfig)localObject1).getString(c, "");
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("patrolShowText=");
      localStringBuilder.append((String)localObject1);
      QLog.d(str, 1, localStringBuilder.toString());
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "patrolShowText");
      return localObject1;
    }
    finally {}
  }
  
  public final void a()
  {
    try
    {
      jdField_a_of_type_ComTencentAladdinConfigAladdinConfig = (AladdinConfig)null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentAladdinConfigAladdinConfig == null) {
        jdField_a_of_type_ComTencentAladdinConfigAladdinConfig = Aladdin.getConfig(468);
      }
      Object localObject1 = jdField_a_of_type_ComTencentAladdinConfigAladdinConfig;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      Object localObject3 = b;
      boolean bool = false;
      int i = ((AladdinConfig)localObject1).getIntegerFromString((String)localObject3, 0);
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("arbitrationSwitch=");
      ((StringBuilder)localObject3).append(i);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject3).toString());
      if (i == 1) {
        bool = true;
      }
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentBubbleViewHelper
 * JD-Core Version:    0.7.0.1
 */