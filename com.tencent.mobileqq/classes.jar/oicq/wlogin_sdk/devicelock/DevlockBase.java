package oicq.wlogin_sdk.devicelock;

import oicq.wlogin_sdk.request.t;
import oicq.wlogin_sdk.tools.util;

public class DevlockBase
{
  private static int _seq;
  public static DevlockRst rst = new DevlockRst();
  public int Role = 505;
  private int _head_len = 110;
  protected int _msgType = 0;
  private int _version = 32;
  
  public byte[] _get_request(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[this._head_len + 1 + paramArrayOfByte.length + 1];
    util.int8_to_buf(arrayOfByte, 0, 2);
    util.int16_to_buf(arrayOfByte, 1, arrayOfByte.length);
    util.int64_to_buf32(arrayOfByte, 3, paramLong1);
    util.int16_to_buf(arrayOfByte, 9, this._msgType);
    util.int64_to_buf32(arrayOfByte, 11, paramLong2);
    int i = _seq;
    _seq = i + 1;
    util.int32_to_buf(arrayOfByte, 27, i);
    util.int16_to_buf(arrayOfByte, 39, t.v);
    util.int16_to_buf(arrayOfByte, 43, this._version);
    util.int8_to_buf(arrayOfByte, 45, 0);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 111, paramArrayOfByte.length);
    util.int8_to_buf(arrayOfByte, 111 + paramArrayOfByte.length, 3);
    return arrayOfByte;
  }
  
  public int get_msgType()
  {
    return this._msgType;
  }
  
  public int parse_rsp(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      int i = paramArrayOfByte.length;
      int j = this._head_len;
      if (i < j + 2) {
        return -1009;
      }
      byte[] arrayOfByte = new byte[paramArrayOfByte.length - j - 2];
      System.arraycopy(paramArrayOfByte, j + 1, arrayOfByte, 0, arrayOfByte.length);
      if (2 > arrayOfByte.length) {
        return -1009;
      }
      int m = util.buf_to_int16(arrayOfByte, 0);
      j = 0;
      i = 0;
      int k = 2;
      while (j < m)
      {
        paramArrayOfByte = pickup_TLV(arrayOfByte, k);
        if (paramArrayOfByte == null) {
          return -1009;
        }
        k += paramArrayOfByte.length;
        i = util.buf_to_int16(paramArrayOfByte, 0);
        if (i != 1)
        {
          if (i != 6)
          {
            if (i != 8)
            {
              if (i != 11)
              {
                if (i != 14)
                {
                  if (i != 3)
                  {
                    if (i != 4)
                    {
                      if (i != 18)
                      {
                        if (i != 19) {
                          i = 0;
                        } else {
                          i = rst.transferInfo.set_buf(paramArrayOfByte, paramArrayOfByte.length);
                        }
                      }
                      else {
                        i = rst.devGuideInfo.set_buf(paramArrayOfByte, paramArrayOfByte.length);
                      }
                    }
                    else {
                      i = rst.mbMobileInfo.set_buf(paramArrayOfByte, paramArrayOfByte.length);
                    }
                  }
                  else {
                    i = rst.devSetupInfo.set_buf(paramArrayOfByte, paramArrayOfByte.length);
                  }
                }
                else {
                  i = rst.mbGuideInfo.set_buf(paramArrayOfByte, paramArrayOfByte.length);
                }
              }
              else {
                i = rst.sppKey.set_buf(paramArrayOfByte, paramArrayOfByte.length);
              }
            }
            else {
              i = rst.querySig.set_buf(paramArrayOfByte, paramArrayOfByte.length);
            }
          }
          else {
            i = rst.smsInfo.set_buf(paramArrayOfByte, paramArrayOfByte.length);
          }
        }
        else {
          i = rst.commRsp.set_buf(paramArrayOfByte, paramArrayOfByte.length);
        }
        if (i != 0) {
          return i;
        }
        j += 1;
      }
      j = i;
      if (i == 0) {
        j = rst.commRsp.RetCode;
      }
      return j;
    }
    return -1009;
  }
  
  public byte[] pickup_TLV(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = null;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length < paramInt + 4) {
        return null;
      }
      int i = util.buf_to_int16(paramArrayOfByte, paramInt + 2) + 4;
      if (paramArrayOfByte.length < paramInt + i) {
        return null;
      }
      arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, paramInt, arrayOfByte, 0, i);
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.devicelock.DevlockBase
 * JD-Core Version:    0.7.0.1
 */