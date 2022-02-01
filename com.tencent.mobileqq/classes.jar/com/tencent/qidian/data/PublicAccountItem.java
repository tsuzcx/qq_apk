package com.tencent.qidian.data;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qidian.proto.mobileqq_qidian.PubAccItem;

public class PublicAccountItem
{
  public String a = "";
  public String b = "";
  public int c;
  public int d;
  public boolean e = false;
  public String f = "";
  public String g = "";
  
  public PublicAccountItem() {}
  
  public PublicAccountItem(mobileqq_qidian.PubAccItem paramPubAccItem)
  {
    a(paramPubAccItem);
  }
  
  public mobileqq_qidian.PubAccItem a()
  {
    mobileqq_qidian.PubAccItem localPubAccItem = new mobileqq_qidian.PubAccItem();
    localPubAccItem.str_uin.set(this.a);
    localPubAccItem.str_name.set(this.b);
    localPubAccItem.uint32_type.set(this.c);
    localPubAccItem.uint32_verity.set(this.d);
    localPubAccItem.str_face_url.set(this.f);
    localPubAccItem.str_qr_url.set(this.g);
    return localPubAccItem;
  }
  
  public void a(mobileqq_qidian.PubAccItem paramPubAccItem)
  {
    if (paramPubAccItem.str_uin.has()) {
      this.a = paramPubAccItem.str_uin.get();
    }
    if (paramPubAccItem.str_name.has()) {
      this.b = paramPubAccItem.str_name.get();
    }
    if (paramPubAccItem.uint32_type.has()) {
      this.c = paramPubAccItem.uint32_type.get();
    }
    if (paramPubAccItem.uint32_verity.has()) {
      this.d = paramPubAccItem.uint32_verity.get();
    }
    if (paramPubAccItem.str_face_url.has()) {
      this.f = paramPubAccItem.str_face_url.get();
    }
    if (paramPubAccItem.str_qr_url.has()) {
      this.g = paramPubAccItem.str_qr_url.get();
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
    if (paramObject.a.equals(this.a))
    {
      bool1 = bool2;
      if (paramObject.b.equals(this.b))
      {
        bool1 = bool2;
        if (paramObject.c == this.c)
        {
          bool1 = bool2;
          if (paramObject.d == this.d)
          {
            bool1 = bool2;
            if (paramObject.f.equals(this.f))
            {
              bool1 = bool2;
              if (paramObject.g.equals(this.g)) {
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
    return ((((((403 + this.a.hashCode()) * 31 + this.b.hashCode()) * 31 + this.c) * 31 + this.d) * 31 + (this.e ^ true)) * 31 + this.f.hashCode()) * 31 + this.g.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.data.PublicAccountItem
 * JD-Core Version:    0.7.0.1
 */