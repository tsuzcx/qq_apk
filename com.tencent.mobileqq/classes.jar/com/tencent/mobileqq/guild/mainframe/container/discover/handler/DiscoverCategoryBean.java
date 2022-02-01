package com.tencent.mobileqq.guild.mainframe.container.discover.handler;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.group_pro_proto.oidb0xf9c.common.Category;

public class DiscoverCategoryBean
{
  public int a;
  public String b;
  
  public static DiscoverCategoryBean a(common.Category paramCategory)
  {
    DiscoverCategoryBean localDiscoverCategoryBean = new DiscoverCategoryBean();
    localDiscoverCategoryBean.a = paramCategory.id.get();
    if ((paramCategory.name.has()) && (!TextUtils.isEmpty(paramCategory.name.get()))) {
      localDiscoverCategoryBean.b = paramCategory.name.get();
    }
    return localDiscoverCategoryBean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DiscoverCategoryBean{id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.handler.DiscoverCategoryBean
 * JD-Core Version:    0.7.0.1
 */