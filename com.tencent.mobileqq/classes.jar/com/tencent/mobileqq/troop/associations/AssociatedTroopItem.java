package com.tencent.mobileqq.troop.associations;

import NearbyGroup.Color;
import NearbyGroup.GroupLabel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb.Color;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb.Label;
import tencent.im.oidb.cmd0xede.oidb_0xede.Color;
import tencent.im.oidb.cmd0xede.oidb_0xede.Label;

public class AssociatedTroopItem
  extends Entity
  implements Serializable
{
  public int groupFace;
  public String intro;
  public int isConfGroup;
  public String joinAuth;
  public ArrayList<GroupLabel> labelList;
  public int maxMemberNum = -1;
  public int memberNum = -1;
  public String name;
  public int privilege = -1;
  public int relateStatus = 0;
  public int relateType = 0;
  public String richIntro;
  public int seq = -1;
  @unique
  public String uin;
  
  private static oidb_0x9fb.Color transColor(oidb_0xede.Color paramColor)
  {
    if (paramColor == null) {
      return new oidb_0x9fb.Color();
    }
    oidb_0x9fb.Color localColor = new oidb_0x9fb.Color();
    localColor.uint32_b.set(paramColor.uint32_b.get());
    localColor.uint32_g.set(paramColor.uint32_g.get());
    localColor.uint32_r.set(paramColor.uint32_r.get());
    return localColor;
  }
  
  @Nullable
  public static ArrayList<GroupLabel> transLabel(List<oidb_0xede.Label> paramList)
  {
    if (paramList != null)
    {
      Object localObject = transTo9fbList(paramList);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramList = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          oidb_0x9fb.Label localLabel = (oidb_0x9fb.Label)((Iterator)localObject).next();
          GroupLabel localGroupLabel = new GroupLabel();
          Color localColor = new Color();
          localColor.R = localLabel.edging_color.uint32_r.get();
          localColor.G = localLabel.edging_color.uint32_g.get();
          localColor.B = localLabel.edging_color.uint32_b.get();
          localGroupLabel.edging_color = localColor;
          localColor = new Color();
          localColor.R = localLabel.text_color.uint32_r.get();
          localColor.G = localLabel.text_color.uint32_g.get();
          localColor.B = localLabel.text_color.uint32_b.get();
          localGroupLabel.text_color = localColor;
          localGroupLabel.strWording = localLabel.bytes_name.get().toStringUtf8();
          localGroupLabel.type = localLabel.uint32_label_attr.get();
          paramList.add(localGroupLabel);
        }
        return paramList;
      }
    }
    return null;
  }
  
  @Nullable
  private static List<oidb_0x9fb.Label> transTo9fbList(List<oidb_0xede.Label> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_0xede.Label localLabel = (oidb_0xede.Label)paramList.next();
      oidb_0x9fb.Label localLabel1 = new oidb_0x9fb.Label();
      localLabel1.bytes_name.set(localLabel.bytes_name.get());
      localLabel1.edging_color.set(transColor((oidb_0xede.Color)localLabel.edging_color.get()));
      localLabel1.text_color.set(transColor((oidb_0xede.Color)localLabel.text_color.get()));
      localLabel1.enum_type.set(localLabel.enum_type.get());
      localLabel1.uint32_label_attr.set(localLabel.uint32_label_attr.get());
      localLabel1.uint32_label_type.set(localLabel.uint32_label_type.get());
      localArrayList.add(localLabel1);
    }
    return localArrayList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AllianceItem{uin='" + this.uin + '\'' + ", maxMemberNum='" + this.maxMemberNum + '\'' + ", memberNum='" + this.memberNum + '\'' + ", relateStatus='" + this.relateStatus + '\'' + ", relateType='" + this.relateType + '\'' + ", privilege='" + this.privilege + '\'' + ", seq='" + this.seq + '\'' + ", intro='" + this.intro + '\'' + ", groupFace='" + this.groupFace + '\'' + ", isConfGroup='" + this.isConfGroup + '\'');
    if (this.labelList != null)
    {
      localStringBuilder.append(", associatedTroopList='");
      int j = this.labelList.size();
      int i = 0;
      if (i < j)
      {
        if (i == j - 1) {
          localStringBuilder.append(((GroupLabel)this.labelList.get(i)).strWording + "'");
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuilder.append(((GroupLabel)this.labelList.get(i)).strWording + "、");
        }
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.associations.AssociatedTroopItem
 * JD-Core Version:    0.7.0.1
 */