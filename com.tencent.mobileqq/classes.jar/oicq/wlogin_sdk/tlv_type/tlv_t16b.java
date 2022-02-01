package oicq.wlogin_sdk.tlv_type;

import java.util.List;
import oicq.wlogin_sdk.tools.util;

public class tlv_t16b
  extends tlv_t
{
  public tlv_t16b()
  {
    this._cmd = 363;
  }
  
  public byte[] get_tlv_16b(List<String> paramList)
  {
    int k;
    int i;
    if (paramList != null)
    {
      int n = paramList.size();
      k = 0;
      i = 0;
      for (;;)
      {
        j = n;
        m = i;
        if (k >= n) {
          break;
        }
        j = i + 2;
        i = j;
        if (paramList.get(k) != null) {
          i = j + ((String)paramList.get(k)).length();
        }
        k += 1;
      }
    }
    int j = 0;
    int m = 0;
    byte[] arrayOfByte1 = new byte[m + 2];
    util.int16_to_buf(arrayOfByte1, 0, j);
    if (paramList != null)
    {
      k = 0;
      i = 2;
      while (k < j)
      {
        if (paramList.get(k) != null)
        {
          byte[] arrayOfByte2 = ((String)paramList.get(k)).getBytes();
          util.int16_to_buf(arrayOfByte1, i, arrayOfByte2.length);
          i += 2;
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, arrayOfByte2.length);
          i += arrayOfByte2.length;
        }
        else
        {
          util.int16_to_buf(arrayOfByte1, i, 0);
          i += 2;
        }
        k += 1;
      }
    }
    fill_head(this._cmd);
    fill_body(arrayOfByte1, arrayOfByte1.length);
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t16b
 * JD-Core Version:    0.7.0.1
 */