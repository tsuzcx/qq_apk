package oicq.wlogin_sdk.tools;

import java.util.Map;
import oicq.wlogin_sdk.tlv_type.tlv_t;

public class e
{
  public static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, Map<Integer, tlv_t> paramMap)
  {
    if (paramArrayOfByte.length != paramInt2 + paramInt3) {
      return -1;
    }
    int i = paramInt2;
    paramInt2 = 0;
    while ((paramInt2 < paramInt1) && (paramInt3 > 0))
    {
      int j = util.buf_to_int16(paramArrayOfByte, i);
      i += 2;
      int k = util.buf_to_int16(paramArrayOfByte, i);
      i += 2;
      paramInt3 = paramInt3 - 2 - 2;
      if (paramInt3 < k) {
        return -2;
      }
      tlv_t localtlv_t = new tlv_t(j);
      localtlv_t.set_data(paramArrayOfByte, i, k);
      paramMap.put(new Integer(j), localtlv_t);
      i += k;
      paramInt3 -= k;
      paramInt2 += 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.e
 * JD-Core Version:    0.7.0.1
 */