package oicq.wlogin_sdk.tlv_type;

import android.content.Context;
import com.tencent.secprotocol.ByteData;
import oicq.wlogin_sdk.tools.util;

public class tlv_t544
  extends tlv_t
{
  public tlv_t544()
  {
    this._cmd = 1348;
  }
  
  private byte[] errInfo(byte paramByte)
  {
    byte[] arrayOfByte = new byte[4];
    arrayOfByte[2] = paramByte;
    return makeByte(arrayOfByte, arrayOfByte.length);
  }
  
  private byte[] makeByte(byte[] paramArrayOfByte, int paramInt)
  {
    fill_head(this._cmd);
    fill_body(paramArrayOfByte, paramInt);
    set_length();
    return get_buf();
  }
  
  public byte[] get_tlv_544(Context paramContext, long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString, int paramInt3)
  {
    if (paramString == null) {
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramArrayOfByte == null) {
        paramInt2 = 0;
      }
      try
      {
        label16:
        byte[] arrayOfByte = new byte[paramInt2 + 6 + 2 + paramInt1 + 4];
        String str = util.buf_to_string(paramArrayOfByte, paramInt2);
        if (paramString == null) {}
        for (paramContext = "".getBytes();; paramContext = paramString.getBytes())
        {
          util.int32_to_buf(arrayOfByte, 0, (int)paramLong);
          util.int16_to_buf(arrayOfByte, 4, paramInt2);
          System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 6, paramInt2);
          paramInt2 += 6;
          util.int16_to_buf(arrayOfByte, paramInt2, paramInt1);
          paramInt2 += 2;
          System.arraycopy(paramContext, 0, arrayOfByte, paramInt2, paramInt1);
          util.int32_to_buf(arrayOfByte, paramInt2 + paramInt1, paramInt3);
          ByteData.getInstance().setDataEx(paramLong, "0x0A");
          paramContext = ByteData.getInstance().getCode(1L, 0L, paramLong, paramInt3, "", paramString, str, arrayOfByte, "0x0A");
          return makeByte(paramContext, paramContext.length);
          paramInt1 = paramString.length();
          break;
          paramInt2 = paramArrayOfByte.length;
          break label16;
        }
        return paramArrayOfByte;
      }
      catch (Exception paramContext)
      {
        paramArrayOfByte = errInfo((byte)1);
        paramContext.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t544
 * JD-Core Version:    0.7.0.1
 */