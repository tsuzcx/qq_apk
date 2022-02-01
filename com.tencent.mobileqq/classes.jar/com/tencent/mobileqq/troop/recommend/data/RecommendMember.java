package com.tencent.mobileqq.troop.recommend.data;

import android.graphics.Color;
import com.tencent.mobileqq.data.RecommendLabel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xe3b.oidb_0xe3b.Color;
import tencent.im.oidb.cmd0xe3b.oidb_0xe3b.Label;
import tencent.im.oidb.cmd0xe3b.oidb_0xe3b.RecommendPerson;

public class RecommendMember
{
  public int a;
  public String a;
  public ArrayList<RecommendLabel> a;
  public int b;
  public String b;
  public String c;
  
  public static RecommendMember a(oidb_0xe3b.RecommendPerson paramRecommendPerson)
  {
    RecommendMember localRecommendMember = new RecommendMember();
    localRecommendMember.jdField_a_of_type_JavaLangString = String.valueOf(paramRecommendPerson.uint64_uin.get());
    Object localObject;
    if (paramRecommendPerson.bytes_title.has()) {
      localObject = paramRecommendPerson.bytes_title.get().toStringUtf8();
    } else {
      localObject = "";
    }
    localRecommendMember.jdField_b_of_type_JavaLangString = ((String)localObject);
    if (paramRecommendPerson.bytes_reason.has()) {
      localObject = paramRecommendPerson.bytes_reason.get().toStringUtf8();
    } else {
      localObject = "";
    }
    localRecommendMember.c = ((String)localObject);
    boolean bool = paramRecommendPerson.uint32_age.has();
    int j = -1;
    if (bool) {
      i = paramRecommendPerson.uint32_age.get();
    } else {
      i = -1;
    }
    localRecommendMember.jdField_a_of_type_Int = i;
    int i = j;
    if (paramRecommendPerson.uint32_gender.has()) {
      i = paramRecommendPerson.uint32_gender.get();
    }
    localRecommendMember.jdField_b_of_type_Int = i;
    if (paramRecommendPerson.rpt_msg_label.has())
    {
      paramRecommendPerson = paramRecommendPerson.rpt_msg_label.get();
      localRecommendMember.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramRecommendPerson.size());
      localObject = paramRecommendPerson.iterator();
      while (((Iterator)localObject).hasNext())
      {
        oidb_0xe3b.Label localLabel = (oidb_0xe3b.Label)((Iterator)localObject).next();
        RecommendLabel localRecommendLabel = new RecommendLabel();
        if (localLabel.bytes_name.has()) {
          paramRecommendPerson = localLabel.bytes_name.get().toStringUtf8();
        } else {
          paramRecommendPerson = "";
        }
        localRecommendLabel.bytes_name = paramRecommendPerson;
        localRecommendLabel.uint32_label_type = localLabel.uint32_label_type.get();
        if (localLabel.text_color.has()) {
          localRecommendLabel.text_color = Color.rgb(((oidb_0xe3b.Color)localLabel.text_color.get()).uint32_r.get(), ((oidb_0xe3b.Color)localLabel.text_color.get()).uint32_g.get(), ((oidb_0xe3b.Color)localLabel.text_color.get()).uint32_b.get());
        }
        if (localLabel.edging_color.has()) {
          localRecommendLabel.edging_color = Color.rgb(((oidb_0xe3b.Color)localLabel.edging_color.get()).uint32_r.get(), ((oidb_0xe3b.Color)localLabel.edging_color.get()).uint32_g.get(), ((oidb_0xe3b.Color)localLabel.edging_color.get()).uint32_b.get());
        }
        localRecommendMember.jdField_a_of_type_JavaUtilArrayList.add(localRecommendLabel);
      }
    }
    return localRecommendMember;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.recommend.data.RecommendMember
 * JD-Core Version:    0.7.0.1
 */