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
  
  public byte[] get_tlv_544(Context paramContext, long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString, int paramInt3)
  {
    try
    {
      byte[] arrayOfByte2 = new byte[paramInt1 + 6 + 2 + paramInt2 + 4];
      String str = util.buf_to_string(paramArrayOfByte, paramInt1);
      if (paramString == null) {}
      for (byte[] arrayOfByte1 = "".getBytes();; arrayOfByte1 = paramString.getBytes())
      {
        util.int32_to_buf(arrayOfByte2, 0, (int)paramLong);
        util.int16_to_buf(arrayOfByte2, 4, paramInt1);
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, 6, paramInt1);
        paramInt1 += 6;
        util.int16_to_buf(arrayOfByte2, paramInt1, paramInt2);
        paramInt1 += 2;
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, paramInt1, paramInt2);
        util.int32_to_buf(arrayOfByte2, paramInt1 + paramInt2, paramInt3);
        ByteData.getInstance().init(paramContext);
        paramContext = ByteData.getInstance().getCode(0L, paramLong, paramInt3, 0L, "", paramString, str, arrayOfByte2);
        fill_head(this._cmd);
        fill_body(paramContext, paramContext.length);
        set_length();
        return get_buf();
      }
      return null;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t544
 * JD-Core Version:    0.7.0.1
 */