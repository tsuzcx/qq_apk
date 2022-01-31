package com.tencent.mobileqq.extendfriend.bean;

import android.graphics.Color;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.io.Serializable;
import tencent.im.oidb.cmd0x5e3.oidb_0xb4a.Color;
import tencent.im.oidb.cmd0x5e3.oidb_0xb4a.Label;

public class GroupInfo$Label
  implements Serializable
{
  public int bgColor;
  public int labelAttr;
  public String labelName;
  public int labelType;
  public int textColor;
  
  public GroupInfo$Label(GroupInfo paramGroupInfo) {}
  
  private int a(oidb_0xb4a.Color paramColor)
  {
    return Color.rgb(paramColor.uint32_r.get(), paramColor.uint32_g.get(), paramColor.uint32_b.get());
  }
  
  public void parseFromPb(oidb_0xb4a.Label paramLabel)
  {
    int j = 0;
    Object localObject;
    if (paramLabel.bytes_name.has())
    {
      localObject = paramLabel.bytes_name.get().toStringUtf8();
      this.labelName = ((String)localObject);
      if (!paramLabel.text_color.has()) {
        break label160;
      }
      localObject = (oidb_0xb4a.Color)paramLabel.text_color.get();
      label52:
      if (localObject != null) {
        this.textColor = a((oidb_0xb4a.Color)localObject);
      }
      if (!paramLabel.edging_color.has()) {
        break label166;
      }
      localObject = (oidb_0xb4a.Color)paramLabel.edging_color.get();
      label89:
      if (localObject != null) {
        this.bgColor = a((oidb_0xb4a.Color)localObject);
      }
      if (!paramLabel.uint32_label_attr.has()) {
        break label172;
      }
    }
    label160:
    label166:
    label172:
    for (int i = paramLabel.uint32_label_attr.get();; i = 0)
    {
      this.labelAttr = i;
      i = j;
      if (paramLabel.uint32_label_type.has()) {
        i = paramLabel.uint32_label_type.get();
      }
      this.labelType = i;
      return;
      localObject = "";
      break;
      localObject = null;
      break label52;
      localObject = null;
      break label89;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("labelName").append("=").append(this.labelName);
    localStringBuilder.append(" ").append("textColor").append("=").append(this.textColor);
    localStringBuilder.append(" ").append("bgColor").append("=").append(this.bgColor);
    localStringBuilder.append(" ").append("labelAttr").append("=").append(this.labelAttr);
    localStringBuilder.append(" ").append("labelType").append("=").append(this.labelType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.bean.GroupInfo.Label
 * JD-Core Version:    0.7.0.1
 */