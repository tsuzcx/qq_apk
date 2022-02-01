package com.tencent.mobileqq.hiboom;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class HiBoomItem
{
  public int a;
  public long a;
  public Bitmap a;
  public String a;
  public AtomicBoolean a;
  public boolean a;
  public int b;
  public Bitmap b;
  public String b;
  public boolean b;
  public int c;
  
  public HiBoomItem()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public int a()
  {
    boolean bool = TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString);
    int i = 1;
    Object localObject;
    if (!bool)
    {
      if (this.jdField_b_of_type_JavaLangString.startsWith("act")) {
        break label143;
      }
      if (this.jdField_b_of_type_JavaLangString.startsWith("free"))
      {
        localObject = this.jdField_b_of_type_JavaLangString.split("-");
        if ((localObject.length >= 3) && (!TextUtils.isEmpty(localObject[1])) && (TextUtils.isDigitsOnly(localObject[1])) && (!TextUtils.isEmpty(localObject[2])) && (TextUtils.isDigitsOnly(localObject[2])))
        {
          long l1 = Long.parseLong(localObject[1]);
          long l2 = Long.parseLong(localObject[2]);
          long l3 = NetConnInfoCenter.getServerTime();
          if ((l3 > l1) && (l3 < l2))
          {
            i = 2;
            break label143;
          }
        }
      }
    }
    i = 0;
    label143:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTagType id = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(" type = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("HiBoomFont.Item", 2, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HiBoomItem: id = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" name = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" engine = ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomItem
 * JD-Core Version:    0.7.0.1
 */