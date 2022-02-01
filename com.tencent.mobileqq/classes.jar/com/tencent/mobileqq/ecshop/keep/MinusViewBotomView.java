package com.tencent.mobileqq.ecshop.keep;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class MinusViewBotomView
  extends FrameLayout
{
  private Button a;
  
  public MinusViewBotomView(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MinusViewBotomView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setBackgroundColor(paramContext.getResources().getColor(2131168464));
    this.a = new Button(paramContext);
    addView(this.a);
    this.a.getLayoutParams().width = -1;
    this.a.getLayoutParams().height = DisplayUtil.a(paramContext, 45.0F);
    this.a.setBackgroundResource(2130843721);
    this.a.setTextColor(paramContext.getResources().getColor(2131168464));
    this.a.setTextSize(1, 17.0F);
    int i = DisplayUtil.a(getContext(), 16.0F);
    setPadding(i, i, i, i);
  }
  
  public void setBtnText(EcshopConfBean paramEcshopConfBean)
  {
    if ((this.a != null) && (paramEcshopConfBean != null) && (getContext() != null))
    {
      ((IMessageFacade)AppUtils.a().getRuntimeService(IMessageFacade.class, "")).getLastMsgForMsgTab("3046055438", 1008);
      if (StringUtil.isEmpty(paramEcshopConfBean.b)) {
        paramEcshopConfBean = getContext().getString(2131888822);
      } else {
        paramEcshopConfBean = paramEcshopConfBean.b;
      }
      this.a.setText(paramEcshopConfBean);
      this.a.setOnClickListener(new MinusViewBotomView.1(this));
      return;
    }
    QLog.i("MinusViewBotomView", 2, "params error!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.keep.MinusViewBotomView
 * JD-Core Version:    0.7.0.1
 */