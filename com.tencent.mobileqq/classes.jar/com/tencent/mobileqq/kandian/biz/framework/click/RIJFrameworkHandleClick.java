package com.tencent.mobileqq.kandian.biz.framework.click;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class RIJFrameworkHandleClick
{
  private RIJDataManager jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager;
  private ClickHandler jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickClickHandler = new RIJFrameworkHandleClick.1(this);
  private HashMap<Integer, ClickHandler> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ClickHandler b = new RIJFrameworkHandleClick.2(this);
  private ClickHandler c = new RIJFrameworkHandleClick.3(this);
  
  public RIJFrameworkHandleClick(RIJDataManager paramRIJDataManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager = paramRIJDataManager;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376438), this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickClickHandler);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376054), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131368343), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131361884), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131369961), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376575), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131362082), this.c);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131380181), this.c);
  }
  
  private void a(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ReadInJoyConstants.k);
    localStringBuilder.append(Base64Util.encodeToString(String.valueOf(paramString).getBytes(), 2));
    ReadInJoyUtils.a(paramContext, localStringBuilder.toString());
  }
  
  public void a(View paramView)
  {
    Object localObject = (ClickHandler)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramView.getId()));
    if (localObject != null)
    {
      ((ClickHandler)localObject).onClick(paramView);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onClick, has no click handler for id(");
    ((StringBuilder)localObject).append(paramView.getId());
    ((StringBuilder)localObject).append("}");
    QLog.e("RIJFrameworkHandleClick", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.click.RIJFrameworkHandleClick
 * JD-Core Version:    0.7.0.1
 */