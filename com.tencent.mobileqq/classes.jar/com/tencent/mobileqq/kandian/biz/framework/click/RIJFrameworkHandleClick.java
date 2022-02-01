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
  private RIJDataManager a;
  private HashMap<Integer, ClickHandler> b = new HashMap();
  private ClickHandler c = new RIJFrameworkHandleClick.1(this);
  private ClickHandler d = new RIJFrameworkHandleClick.2(this);
  private ClickHandler e = new RIJFrameworkHandleClick.3(this);
  
  public RIJFrameworkHandleClick(RIJDataManager paramRIJDataManager)
  {
    this.a = paramRIJDataManager;
    a();
  }
  
  private void a()
  {
    this.b.put(Integer.valueOf(2131444659), this.c);
    this.b.put(Integer.valueOf(2131444254), this.d);
    this.b.put(Integer.valueOf(2131435219), this.d);
    this.b.put(Integer.valueOf(2131427438), this.d);
    this.b.put(Integer.valueOf(2131437111), this.d);
    this.b.put(Integer.valueOf(2131444830), this.d);
    this.b.put(Integer.valueOf(2131427660), this.e);
    this.b.put(Integer.valueOf(2131449096), this.e);
  }
  
  private void a(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ReadInJoyConstants.l);
    localStringBuilder.append(Base64Util.encodeToString(String.valueOf(paramString).getBytes(), 2));
    ReadInJoyUtils.a(paramContext, localStringBuilder.toString());
  }
  
  public void a(View paramView)
  {
    Object localObject = (ClickHandler)this.b.get(Integer.valueOf(paramView.getId()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.click.RIJFrameworkHandleClick
 * JD-Core Version:    0.7.0.1
 */