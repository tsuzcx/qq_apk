import com.qq.jce.wup.UniAttribute;
import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class tgw
  extends UniAttribute
{
  static HashMap<String, byte[]> a;
  static HashMap<String, HashMap<String, byte[]>> b;
  protected RequestPacket a;
  
  public tgw()
  {
    this.jdField_a_of_type_ComQqTafRequestPacket = new RequestPacket();
    this.jdField_a_of_type_ComQqTafRequestPacket.iVersion = 2;
  }
  
  private void a()
  {
    JceInputStream localJceInputStream = new JceInputStream(this.jdField_a_of_type_ComQqTafRequestPacket.sBuffer);
    localJceInputStream.setServerEncoding(this.encodeName);
    if (jdField_a_of_type_JavaUtilHashMap == null)
    {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
      jdField_a_of_type_JavaUtilHashMap.put("", new byte[0]);
    }
    this._newData = localJceInputStream.readMap(jdField_a_of_type_JavaUtilHashMap, 0, false);
  }
  
  private void b()
  {
    JceInputStream localJceInputStream = new JceInputStream(this.jdField_a_of_type_ComQqTafRequestPacket.sBuffer);
    localJceInputStream.setServerEncoding(this.encodeName);
    if (b == null)
    {
      b = new HashMap();
      HashMap localHashMap = new HashMap();
      localHashMap.put("", new byte[0]);
      b.put("", localHashMap);
    }
    this._data = localJceInputStream.readMap(b, 0, false);
    this.cachedClassName = new HashMap();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComQqTafRequestPacket.iTimeout = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComQqTafRequestPacket.sServantName = paramString;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComQqTafRequestPacket.iRequestId = paramInt;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComQqTafRequestPacket.sFuncName = paramString;
  }
  
  public void decode(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 4) {
      throw new IllegalArgumentException("decode package must include size head");
    }
    try
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte, 4);
      paramArrayOfByte.setServerEncoding(this.encodeName);
      this.jdField_a_of_type_ComQqTafRequestPacket.readFrom(paramArrayOfByte);
      if (this.jdField_a_of_type_ComQqTafRequestPacket.iVersion == 3)
      {
        a();
        return;
      }
      this._newData = null;
      b();
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public void decodeVersion2(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 4) {
      throw new IllegalArgumentException("decode package must include size head");
    }
    try
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte, 4);
      paramArrayOfByte.setServerEncoding(this.encodeName);
      this.jdField_a_of_type_ComQqTafRequestPacket.readFrom(paramArrayOfByte);
      b();
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public void decodeVersion3(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 4) {
      throw new IllegalArgumentException("decode package must include size head");
    }
    try
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte, 4);
      paramArrayOfByte.setServerEncoding(this.encodeName);
      this.jdField_a_of_type_ComQqTafRequestPacket.readFrom(paramArrayOfByte);
      a();
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public byte[] encode()
  {
    if (this.jdField_a_of_type_ComQqTafRequestPacket.iVersion == 2)
    {
      if ((this.jdField_a_of_type_ComQqTafRequestPacket.sServantName == null) || (this.jdField_a_of_type_ComQqTafRequestPacket.sServantName.equals(""))) {
        throw new IllegalArgumentException("servantName can not is null");
      }
      if ((this.jdField_a_of_type_ComQqTafRequestPacket.sFuncName == null) || (this.jdField_a_of_type_ComQqTafRequestPacket.sFuncName.equals(""))) {
        throw new IllegalArgumentException("funcName can not is null");
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComQqTafRequestPacket.sServantName == null) {
        this.jdField_a_of_type_ComQqTafRequestPacket.sServantName = "";
      }
      if (this.jdField_a_of_type_ComQqTafRequestPacket.sFuncName == null) {
        this.jdField_a_of_type_ComQqTafRequestPacket.sFuncName = "";
      }
    }
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.encodeName);
    if ((this.jdField_a_of_type_ComQqTafRequestPacket.iVersion != 2) && (this.jdField_a_of_type_ComQqTafRequestPacket.iVersion != 1)) {
      ((JceOutputStream)localObject).write(this._newData, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComQqTafRequestPacket.sBuffer = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
      localObject = new JceOutputStream(0);
      ((JceOutputStream)localObject).setServerEncoding(this.encodeName);
      this.jdField_a_of_type_ComQqTafRequestPacket.writeTo((JceOutputStream)localObject);
      localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
      int i = localObject.length;
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 4);
      localByteBuffer.putInt(i + 4).put((byte[])localObject).flip();
      return localByteBuffer.array();
      ((JceOutputStream)localObject).write(this._data, 0);
    }
  }
  
  public <T> void put(String paramString, T paramT)
  {
    if (paramString.startsWith(".")) {
      throw new IllegalArgumentException("put name can not startwith . , now is " + paramString);
    }
    super.put(paramString, paramT);
  }
  
  public void useVersion3()
  {
    super.useVersion3();
    this.jdField_a_of_type_ComQqTafRequestPacket.iVersion = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tgw
 * JD-Core Version:    0.7.0.1
 */