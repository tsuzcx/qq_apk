package cooperation.qwallet.safestream;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class QwSafeInputStream
{
  private ByteArrayInputStream jdField_a_of_type_JavaIoByteArrayInputStream;
  private ObjectInputStream jdField_a_of_type_JavaIoObjectInputStream;
  private boolean jdField_a_of_type_Boolean;
  
  private QwSafeInputStream() {}
  
  public QwSafeInputStream(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_JavaIoByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    this.jdField_a_of_type_JavaIoObjectInputStream = new ObjectInputStream(this.jdField_a_of_type_JavaIoByteArrayInputStream);
  }
  
  public int a()
  {
    return a(0);
  }
  
  public int a(int paramInt)
  {
    int i = paramInt;
    if (!this.jdField_a_of_type_Boolean) {}
    try
    {
      i = this.jdField_a_of_type_JavaIoObjectInputStream.readInt();
      return i;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_Boolean = true;
    }
    return paramInt;
  }
  
  public Object a(Object paramObject)
  {
    Object localObject = paramObject;
    if (!this.jdField_a_of_type_Boolean) {}
    try
    {
      localObject = this.jdField_a_of_type_JavaIoObjectInputStream.readObject();
      return localObject;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_Boolean = true;
    }
    return paramObject;
  }
  
  public String a()
  {
    return a("");
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (!this.jdField_a_of_type_Boolean) {}
    try
    {
      str = this.jdField_a_of_type_JavaIoObjectInputStream.readUTF();
      return str;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_Boolean = true;
    }
    return paramString;
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaIoObjectInputStream.close();
      try
      {
        label7:
        this.jdField_a_of_type_JavaIoByteArrayInputStream.close();
        return;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      break label7;
    }
  }
  
  public boolean a()
  {
    return a(false);
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (!this.jdField_a_of_type_Boolean) {}
    try
    {
      bool = this.jdField_a_of_type_JavaIoObjectInputStream.readBoolean();
      return bool;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_Boolean = true;
    }
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qwallet.safestream.QwSafeInputStream
 * JD-Core Version:    0.7.0.1
 */