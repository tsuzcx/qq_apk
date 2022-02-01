package com.tencent.mobileqq.qrscan;

import com.tencent.mobileqq.qrscan.utils.QRUtils;
import com.tencent.mobileqq.utils.HexUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class QRActionEntity
{
  public int a;
  public ArrayList<QRActionEntity.QRActionTLV> a;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  
  public QRActionEntity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public QRActionEntity(String paramString)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    a(paramString);
  }
  
  public static QRActionEntity a(int paramInt, String paramString)
  {
    int i = 2;
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      return null;
    }
    long l;
    if (paramString != null) {
      l = Long.parseLong(paramString);
    } else {
      l = 0L;
    }
    paramString = new QRActionEntity();
    paramString.jdField_a_of_type_Int = 1;
    paramString.b = 1;
    paramString.c = paramInt;
    paramString.d = 0;
    paramString.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    byte[] arrayOfByte = QRUtils.a(l);
    Object localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).put(arrayOfByte, 4, 4);
    ((ByteBuffer)localObject).flip();
    arrayOfByte = new byte[((ByteBuffer)localObject).limit()];
    ((ByteBuffer)localObject).get(arrayOfByte);
    if (paramInt == 2) {
      paramInt = i;
    } else if (paramInt == 3) {
      paramInt = 7;
    } else {
      paramInt = 1;
    }
    localObject = new QRActionEntity.QRActionTLV(paramInt, (short)4, arrayOfByte);
    paramString.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    return paramString;
  }
  
  public int a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      return localArrayList.size();
    }
    return 0;
  }
  
  public QRActionEntity.QRActionTLV a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      return (QRActionEntity.QRActionTLV)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    }
    return null;
  }
  
  public String a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    int i = 4;
    int j = i;
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        i += ((QRActionEntity.QRActionTLV)((Iterator)localObject1).next()).a();
      }
    }
    localObject1 = ByteBuffer.allocate(j);
    ((ByteBuffer)localObject1).put((byte)this.jdField_a_of_type_Int);
    ((ByteBuffer)localObject1).put((byte)this.b);
    ((ByteBuffer)localObject1).put((byte)this.c);
    ((ByteBuffer)localObject1).put((byte)this.d);
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
    {
      ((ByteBuffer)localObject1).put((byte)this.jdField_a_of_type_JavaUtilArrayList.size());
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        QRActionEntity.QRActionTLV localQRActionTLV = (QRActionEntity.QRActionTLV)((Iterator)localObject2).next();
        ((ByteBuffer)localObject1).put((byte)localQRActionTLV.jdField_a_of_type_Int);
        ((ByteBuffer)localObject1).putShort(localQRActionTLV.jdField_a_of_type_Short);
        ((ByteBuffer)localObject1).put(localQRActionTLV.jdField_a_of_type_ArrayOfByte);
      }
    }
    ((ByteBuffer)localObject1).flip();
    localObject2 = new byte[((ByteBuffer)localObject1).limit()];
    ((ByteBuffer)localObject1).get((byte[])localObject2);
    return HexUtil.bytes2HexStr((byte[])localObject2);
  }
  
  public void a(String paramString)
  {
    Object localObject = HexUtil.hexStr2Bytes(paramString);
    paramString = ByteBuffer.allocate(localObject.length);
    paramString.put((byte[])localObject);
    paramString.flip();
    this.jdField_a_of_type_Int = paramString.get();
    this.b = paramString.get();
    this.c = paramString.get();
    this.d = paramString.get();
    int j = paramString.get();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localObject = new QRActionEntity.QRActionTLV();
      ((QRActionEntity.QRActionTLV)localObject).jdField_a_of_type_Int = paramString.get();
      byte[] arrayOfByte = new byte[2];
      paramString.get(arrayOfByte);
      ((QRActionEntity.QRActionTLV)localObject).jdField_a_of_type_Short = QRUtils.a(arrayOfByte);
      arrayOfByte = new byte[((QRActionEntity.QRActionTLV)localObject).jdField_a_of_type_Short];
      paramString.get(arrayOfByte);
      ((QRActionEntity.QRActionTLV)localObject).jdField_a_of_type_ArrayOfByte = arrayOfByte;
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.QRActionEntity
 * JD-Core Version:    0.7.0.1
 */