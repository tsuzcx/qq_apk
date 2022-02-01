package com.tencent.mobileqq.search.model;

import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.search.view.NetSearchTemplateIndividuateOneView;
import com.tencent.mobileqq.transfile.URLDrawableHelper.Adapter;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;

class NetSearchTemplateIndividuateOneItem$1
  extends URLDrawableHelper.Adapter
{
  NetSearchTemplateIndividuateOneItem$1(NetSearchTemplateIndividuateOneItem paramNetSearchTemplateIndividuateOneItem, NetSearchTemplateIndividuateOneView paramNetSearchTemplateIndividuateOneView) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      paramURLDrawable = VipUtils.a(AIOUtils.b(12.0F, BaseApplicationImpl.getContext().getResources()), paramURLDrawable);
      this.a.o.setCompoundDrawables(null, null, paramURLDrawable, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateIndividuateOneItem.1
 * JD-Core Version:    0.7.0.1
 */