import com.tencent.qphone.base.util.QLog;

public class lmk
{
  private static volatile lmk jdField_a_of_type_Lmk;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private lml[] jdField_a_of_type_ArrayOfLml = new lml[4];
  
  public static lmk a()
  {
    if (jdField_a_of_type_Lmk == null) {}
    try
    {
      if (jdField_a_of_type_Lmk == null) {
        jdField_a_of_type_Lmk = new lmk();
      }
      return jdField_a_of_type_Lmk;
    }
    finally {}
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ArrayOfLml.length;
  }
  
  public void a()
  {
    int i = 0;
    QLog.i("FrameBufMgr", 1, "clear.");
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (i < this.jdField_a_of_type_ArrayOfLml.length)
        {
          if (this.jdField_a_of_type_ArrayOfLml[i] != null)
          {
            this.jdField_a_of_type_ArrayOfLml[i].jdField_a_of_type_ArrayOfByte = null;
            this.jdField_a_of_type_ArrayOfLml[i].jdField_a_of_type_Int = 0;
          }
        }
        else {
          return;
        }
      }
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int j = 0;
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_ArrayOfLml.length)
        {
          if (this.jdField_a_of_type_ArrayOfLml[i].jdField_a_of_type_Int == paramInt1)
          {
            this.jdField_a_of_type_ArrayOfLml[i].jdField_a_of_type_Int = paramInt2;
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            QLog.i("FrameBufMgr", 1, "setFrameBufState failed. oldState = " + paramInt1 + ", newState = " + paramInt2);
          }
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_ArrayOfLml.length)
        {
          if (this.jdField_a_of_type_ArrayOfLml[i].jdField_a_of_type_ArrayOfByte == paramArrayOfByte) {
            this.jdField_a_of_type_ArrayOfLml[i].jdField_a_of_type_Int = paramInt;
          }
        }
        else
        {
          QLog.i("FrameBufMgr", 1, "setFrameBufState failed. dataBuf = " + paramArrayOfByte + ", state = " + paramInt);
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public boolean a(int paramInt)
  {
    int i = 0;
    QLog.i("FrameBufMgr", 1, "init. bufSize = " + paramInt);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      while (i < this.jdField_a_of_type_ArrayOfLml.length)
      {
        if (this.jdField_a_of_type_ArrayOfLml[i] == null) {
          this.jdField_a_of_type_ArrayOfLml[i] = new lml(this);
        }
        if ((this.jdField_a_of_type_ArrayOfLml[i].jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfLml[i].jdField_a_of_type_ArrayOfByte.length != paramInt)) {
          this.jdField_a_of_type_ArrayOfLml[i].jdField_a_of_type_ArrayOfByte = new byte[paramInt];
        }
        this.jdField_a_of_type_ArrayOfLml[i].jdField_a_of_type_Int = 0;
        i += 1;
      }
      return true;
    }
  }
  
  public byte[] a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_ArrayOfLml.length)
        {
          if (this.jdField_a_of_type_ArrayOfLml[i].jdField_a_of_type_Int == paramInt)
          {
            byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfLml[i].jdField_a_of_type_ArrayOfByte;
            return arrayOfByte;
          }
        }
        else
        {
          QLog.i("FrameBufMgr", 1, "getFrameBufByState failed. state = " + paramInt);
          return null;
        }
      }
      finally {}
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lmk
 * JD-Core Version:    0.7.0.1
 */