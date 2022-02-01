package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

class ReadinjoySPEventReport$CommonAttrBuilder
{
  private List<oidb_cmd0x80a.AttributeList> b = new ArrayList();
  
  public ReadinjoySPEventReport$CommonAttrBuilder(List<oidb_cmd0x80a.AttributeList> paramList)
  {
    Object localObject;
    if (localObject != null) {
      this.b = localObject;
    }
  }
  
  public CommonAttrBuilder a(int paramInt, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("attr value is Empty ! id : ");
      paramString2.append(paramInt);
      paramString2.append(", name : ");
      paramString2.append(paramString1);
      QLog.d("CommonAttrBulder", 1, paramString2.toString());
      return this;
    }
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(paramInt);
    localAttributeList.att_name.set(paramString1);
    localAttributeList.att_value.set(paramString2);
    this.b.add(localAttributeList);
    return this;
  }
  
  public CommonAttrBuilder a(int paramInt, String paramString, boolean paramBoolean)
  {
    return a(paramInt, paramString, ReadinjoySPEventReport.Utils.a(paramBoolean, "1", "0"));
  }
  
  public CommonAttrBuilder a(oidb_cmd0x80a.AttributeList paramAttributeList)
  {
    if (paramAttributeList != null) {
      this.b.add(paramAttributeList);
    }
    return this;
  }
  
  public List<oidb_cmd0x80a.AttributeList> a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.CommonAttrBuilder
 * JD-Core Version:    0.7.0.1
 */