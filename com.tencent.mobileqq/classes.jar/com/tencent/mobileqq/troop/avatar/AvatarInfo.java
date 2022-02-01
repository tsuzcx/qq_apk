package com.tencent.mobileqq.troop.avatar;

import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.util.Utils;
import java.util.List;
import java.util.Set;

public class AvatarInfo
{
  public static int a = -5;
  public static String a = "-5";
  public long a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  
  public AvatarInfo()
  {
    this.jdField_d_of_type_Int = 0;
  }
  
  public static final AvatarInfo a(TroopClipPic paramTroopClipPic, Set<String> paramSet)
  {
    AvatarInfo localAvatarInfo = new AvatarInfo();
    localAvatarInfo.jdField_c_of_type_JavaLangString = paramTroopClipPic.id;
    localAvatarInfo.jdField_d_of_type_JavaLangString = paramTroopClipPic.clipInfo;
    localAvatarInfo.jdField_d_of_type_Int = paramTroopClipPic.type;
    localAvatarInfo.jdField_b_of_type_Int = 1;
    if (paramSet != null) {
      localAvatarInfo.jdField_c_of_type_Boolean = paramSet.contains(paramTroopClipPic.id);
    }
    return localAvatarInfo;
  }
  
  public static final boolean a(List<AvatarInfo> paramList1, List<AvatarInfo> paramList2)
  {
    if (paramList1 == paramList2) {
      return true;
    }
    if (paramList1 != null)
    {
      if (paramList2 == null) {
        return false;
      }
      if (paramList1.size() != paramList2.size()) {
        return false;
      }
      int i = 0;
      while (i < paramList1.size())
      {
        if (!((AvatarInfo)paramList1.get(i)).equals(paramList2.get(i))) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if (!(paramObject instanceof AvatarInfo)) {
        return false;
      }
      paramObject = (AvatarInfo)paramObject;
      bool1 = bool2;
      if (Utils.a(this.jdField_c_of_type_JavaLangString, paramObject.jdField_c_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (Utils.a(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString))
        {
          bool1 = bool2;
          if (this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int)
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_Boolean == paramObject.jdField_a_of_type_Boolean)
            {
              bool1 = bool2;
              if (this.jdField_c_of_type_Boolean == paramObject.jdField_c_of_type_Boolean)
              {
                bool1 = bool2;
                if (this.jdField_d_of_type_Boolean == paramObject.jdField_d_of_type_Boolean)
                {
                  bool1 = bool2;
                  if (Utils.a(this.jdField_d_of_type_JavaLangString, paramObject.jdField_d_of_type_JavaLangString))
                  {
                    bool1 = bool2;
                    if (this.jdField_d_of_type_Int == paramObject.jdField_d_of_type_Int)
                    {
                      bool1 = bool2;
                      if (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long) {
                        bool1 = true;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AvatarInfo=[");
    localStringBuilder.append("seq");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(" ");
    localStringBuilder.append("fromType");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" ");
    localStringBuilder.append("type");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(" ");
    localStringBuilder.append("isUploading");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" ");
    localStringBuilder.append("isVerifying");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append(" ");
    localStringBuilder.append("clipInfo");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(" ");
    localStringBuilder.append("ts");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" ");
    localStringBuilder.append("localFile");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.AvatarInfo
 * JD-Core Version:    0.7.0.1
 */