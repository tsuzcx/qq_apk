package com.tencent.mobileqq.troop.association.data;

import NearbyGroup.Color;
import NearbyGroup.GroupLabel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb.Color;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb.Label;
import tencent.im.oidb.cmd0xede.oidb_0xede.Color;
import tencent.im.oidb.cmd0xede.oidb_0xede.Label;

public class AssociatedTroopItem
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
  
  private static List<oidb_0x9fb.Label> a(List<oidb_0xede.Label> paramList)
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
      localLabel1.edging_color.set(a((oidb_0xede.Color)localLabel.edging_color.get()));
      localLabel1.text_color.set(a((oidb_0xede.Color)localLabel.text_color.get()));
      localLabel1.enum_type.set(localLabel.enum_type.get());
      localLabel1.uint32_label_attr.set(localLabel.uint32_label_attr.get());
      localLabel1.uint32_label_type.set(localLabel.uint32_label_type.get());
      localArrayList.add(localLabel1);
    }
    return localArrayList;
  }
  
  private static oidb_0x9fb.Color a(oidb_0xede.Color paramColor)
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
  
  public static ArrayList<GroupLabel> transLabel(List<oidb_0xede.Label> paramList)
  {
    if (paramList != null)
    {
      Object localObject = a(paramList);
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
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("AllianceItem{uin='");
    localStringBuilder2.append(this.uin);
    localStringBuilder2.append('\'');
    localStringBuilder2.append(", maxMemberNum='");
    localStringBuilder2.append(this.maxMemberNum);
    localStringBuilder2.append('\'');
    localStringBuilder2.append(", memberNum='");
    localStringBuilder2.append(this.memberNum);
    localStringBuilder2.append('\'');
    localStringBuilder2.append(", relateStatus='");
    localStringBuilder2.append(this.relateStatus);
    localStringBuilder2.append('\'');
    localStringBuilder2.append(", relateType='");
    localStringBuilder2.append(this.relateType);
    localStringBuilder2.append('\'');
    localStringBuilder2.append(", privilege='");
    localStringBuilder2.append(this.privilege);
    localStringBuilder2.append('\'');
    localStringBuilder2.append(", seq='");
    localStringBuilder2.append(this.seq);
    localStringBuilder2.append('\'');
    localStringBuilder2.append(", intro='");
    localStringBuilder2.append(this.intro);
    localStringBuilder2.append('\'');
    localStringBuilder2.append(", groupFace='");
    localStringBuilder2.append(this.groupFace);
    localStringBuilder2.append('\'');
    localStringBuilder2.append(", isConfGroup='");
    localStringBuilder2.append(this.isConfGroup);
    localStringBuilder2.append('\'');
    localStringBuilder1.append(localStringBuilder2.toString());
    if (this.labelList != null)
    {
      localStringBuilder1.append(", associatedTroopList='");
      int j = this.labelList.size();
      int i = 0;
      while (i < j)
      {
        if (i == j - 1)
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(((GroupLabel)this.labelList.get(i)).strWording);
          localStringBuilder2.append("'");
          localStringBuilder1.append(localStringBuilder2.toString());
        }
        else
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(((GroupLabel)this.labelList.get(i)).strWording);
          localStringBuilder2.append("、");
          localStringBuilder1.append(localStringBuilder2.toString());
        }
        i += 1;
      }
    }
    localStringBuilder1.append("}");
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.association.data.AssociatedTroopItem
 * JD-Core Version:    0.7.0.1
 */