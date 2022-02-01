package oicq.wlogin_sdk.request;

import android.os.Build.VERSION;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import oicq.wlogin_sdk.report.Reporter;
import oicq.wlogin_sdk.report.report_t;
import oicq.wlogin_sdk.tlv_type.tlv_t150;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

public class w
  extends j
{
  public final int b = 1737040709;
  public final int c = 33;
  public final String d = "x'Z8mSi,V(Wu~.v:";
  
  public w(t paramt)
  {
    this.a = paramt;
  }
  
  public int a(long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong2, int paramInt)
  {
    if (paramInt == 0) {
      return b(paramLong1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramLong2);
    }
    if (paramInt == 1) {
      return c(paramLong1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramLong2);
    }
    return 0;
  }
  
  public byte[] a(long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong2)
  {
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0))
    {
      paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte3);
      paramArrayOfByte3 = new byte[paramArrayOfByte2.length + 10 + paramArrayOfByte1.length];
      util.int32_to_buf(paramArrayOfByte3, 0, (int)paramLong1);
      util.int32_to_buf(paramArrayOfByte3, 4, (int)paramLong2);
      util.int16_to_buf(paramArrayOfByte3, 8, paramArrayOfByte2.length);
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, 10, paramArrayOfByte2.length);
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, 10 + paramArrayOfByte2.length, paramArrayOfByte1.length);
      i = paramArrayOfByte1.length;
      return paramArrayOfByte3;
    }
    paramArrayOfByte1 = cryptor.encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, "x'Z8mSi,V(Wu~.v:".getBytes());
    paramArrayOfByte2 = new byte[paramArrayOfByte1.length + 10];
    util.int32_to_buf(paramArrayOfByte2, 0, (int)paramLong1);
    util.int32_to_buf(paramArrayOfByte2, 4, (int)paramLong2);
    util.int16_to_buf(paramArrayOfByte2, 8, 0);
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 10, paramArrayOfByte1.length);
    int i = paramArrayOfByte1.length;
    return paramArrayOfByte2;
  }
  
  public byte[] a(byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 33];
    util.int32_to_buf(arrayOfByte, 0, 1737040709);
    util.int32_to_buf(arrayOfByte, 4, 0);
    util.int32_to_buf(arrayOfByte, 8, arrayOfByte.length);
    util.int64_to_buf32(arrayOfByte, 12, paramLong1);
    util.int64_to_buf32(arrayOfByte, 16, paramLong2);
    util.int64_to_buf32(arrayOfByte, 20, paramLong3 / 1000L);
    util.int8_to_buf(arrayOfByte, 24, paramInt);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 33, paramArrayOfByte.length);
    paramInt = paramArrayOfByte.length;
    return arrayOfByte;
  }
  
  public int b(long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong2)
  {
    long l = System.currentTimeMillis();
    t.at.commit(Build.VERSION.RELEASE, new String(t.H), "", util.buf_to_string(util.get_ksid(t.u)), new String(t.F), new String(t.R), new String(t.J), new String(t.I), util.get_release_time(), "6.0.0.2477");
    int j = 0;
    try
    {
      paramArrayOfByte1 = t.at.toJasonObj().toString().getBytes();
    }
    catch (Throwable paramArrayOfByte1)
    {
      label99:
      int i;
      byte[] arrayOfByte;
      break label99;
    }
    paramArrayOfByte1 = new byte[0];
    i = j;
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte1.length == 0) {
        return 0;
      }
      paramArrayOfByte1 = util.compress(paramArrayOfByte1);
      i = j;
      if (paramArrayOfByte1 != null)
      {
        if (paramArrayOfByte1.length == 0) {
          return 0;
        }
        arrayOfByte = new byte[paramArrayOfByte1.length + 4];
        util.int8_to_buf(arrayOfByte, 0, 0);
        util.int8_to_buf(arrayOfByte, 1, 1);
        util.int16_to_buf(arrayOfByte, 2, paramArrayOfByte1.length);
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 4, paramArrayOfByte1.length);
        paramArrayOfByte1 = a(arrayOfByte, paramLong1, paramLong2, l, 0);
        report_t.delete_file(t.u);
        i = b(a(a(paramLong1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramLong2)));
        paramArrayOfByte1 = new StringBuilder();
        paramArrayOfByte1.append("request_report_error(0) rsp: ret=");
        paramArrayOfByte1.append(i);
        util.LOGI(paramArrayOfByte1.toString());
        if (i != 0)
        {
          report_t.write_tofile(t.at, t.u);
          return i;
        }
        t.at.clear_t2();
      }
    }
    return i;
  }
  
  public int c(long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong2)
  {
    if ((this.a.d != null) && (!t.e.booleanValue()))
    {
      t.e = Boolean.valueOf(true);
      long l3 = System.currentTimeMillis();
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
      Calendar localCalendar = Calendar.getInstance();
      int i = this.a.d.get_bitmap();
      int j = this.a.d.get_network();
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("bitmap:");
      paramArrayOfByte1.append(i);
      paramArrayOfByte1.append(" network:");
      paramArrayOfByte1.append(j);
      paramArrayOfByte1.append(" local network:");
      paramArrayOfByte1.append(util.get_network_type(t.u));
      util.LOGI(paramArrayOfByte1.toString());
      int k = 0;
      while (k < 32)
      {
        if ((1 << k & i) != 0)
        {
          while ((j != 0) && ((j != 1) || (util.get_network_type(t.u) != 2))) {}
          long l1 = l3 - 86400000 * k;
          localCalendar.setTimeInMillis(l1);
          String str = localSimpleDateFormat.format(localCalendar.getTime());
          long l2 = util.getLogModifyTime(t.u, str);
          if (l2 != 0L) {
            l1 = l2;
          }
          paramArrayOfByte1 = util.readLog(t.u, str);
          if (paramArrayOfByte1 == null) {
            paramArrayOfByte1 = new byte[0];
          } else {
            paramArrayOfByte1 = a(paramArrayOfByte1, paramLong1, paramLong2, l1, 1);
          }
          if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0))
          {
            int m = b(a(a(paramLong1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramLong2)));
            paramArrayOfByte1 = new StringBuilder();
            paramArrayOfByte1.append("request_report_error(1) rsp: ret=");
            paramArrayOfByte1.append(m);
            paramArrayOfByte1.append("(");
            paramArrayOfByte1.append(str);
            paramArrayOfByte1.append(")");
            util.LOGI(paramArrayOfByte1.toString());
          }
        }
        k += 1;
      }
    }
    this.a.d = null;
    t.e = Boolean.valueOf(false);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.request.w
 * JD-Core Version:    0.7.0.1
 */