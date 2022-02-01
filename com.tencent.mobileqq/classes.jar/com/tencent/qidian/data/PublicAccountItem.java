package com.tencent.qidian.data;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qidian.proto.mobileqq_qidian.PubAccItem;

public class PublicAccountItem
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c = "";
  public String d = "";
  
  public PublicAccountItem()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
  }
  
  public PublicAccountItem(mobileqq_qidian.PubAccItem paramPubAccItem)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    a(paramPubAccItem);
  }
  
  public mobileqq_qidian.PubAccItem a()
  {
    mobileqq_qidian.PubAccItem localPubAccItem = new mobileqq_qidian.PubAccItem();
    localPubAccItem.str_uin.set(this.jdField_a_of_type_JavaLangString);
    localPubAccItem.str_name.set(this.jdField_b_of_type_JavaLangString);
    localPubAccItem.uint32_type.set(this.jdField_a_of_type_Int);
    localPubAccItem.uint32_verity.set(this.jdField_b_of_type_Int);
    localPubAccItem.str_face_url.set(this.c);
    localPubAccItem.str_qr_url.set(this.d);
    return localPubAccItem;
  }
  
  public void a(mobileqq_qidian.PubAccItem paramPubAccItem)
  {
    if (paramPubAccItem.str_uin.has()) {
      this.jdField_a_of_type_JavaLangString = paramPubAccItem.str_uin.get();
    }
    if (paramPubAccItem.str_name.has()) {
      this.jdField_b_of_type_JavaLangString = paramPubAccItem.str_name.get();
    }
    if (paramPubAccItem.uint32_type.has()) {
      this.jdField_a_of_type_Int = paramPubAccItem.uint32_type.get();
    }
    if (paramPubAccItem.uint32_verity.has()) {
      this.jdField_b_of_type_Int = paramPubAccItem.uint32_verity.get();
    }
    if (paramPubAccItem.str_face_url.has()) {
      this.c = paramPubAccItem.str_face_url.get();
    }
    if (paramPubAccItem.str_qr_url.has()) {
      this.d = paramPubAccItem.str_qr_url.get();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    if (paramObject.getClass() != getClass()) {
      return false;
    }
    paramObject = (PublicAccountItem)paramObject;
    boolean bool1 = bool2;
    if (paramObject.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))
    {
      bool1 = bool2;
      if (paramObject.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int)
        {
          bool1 = bool2;
          if (paramObject.jdField_b_of_type_Int == this.jdField_b_of_type_Int)
          {
            bool1 = bool2;
            if (paramObject.c.equals(this.c))
            {
              bool1 = bool2;
              if (paramObject.d.equals(this.d)) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return ((((((403 + this.jdField_a_of_type_JavaLangString.hashCode()) * 31 + this.jdField_b_of_type_JavaLangString.hashCode()) * 31 + this.jdField_a_of_type_Int) * 31 + this.jdField_b_of_type_Int) * 31 + (this.jdField_a_of_type_Boolean ^ true)) * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.data.PublicAccountItem
 * JD-Core Version:    0.7.0.1
 */