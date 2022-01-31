package oicq.wlogin_sdk.request;

import android.os.Build.VERSION;
import java.net.Socket;
import oicq.wlogin_sdk.report.Reporter;
import oicq.wlogin_sdk.report.report_t;
import oicq.wlogin_sdk.tlv_type.tlv_t172;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

public class aa
  extends oicq_request
{
  public int K = 0;
  public int L = 5;
  
  public aa(t paramt)
  {
    this.t = 2066;
    this.u = 1;
    this.v = "wtlogin.trans_emp";
    this.x = paramt;
    if (this.x.m != 0) {
      this.x.m = 1;
    }
  }
  
  public int a(long paramLong1, TransReqContext paramTransReqContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong2, long paramLong3, WUserSigInfo paramWUserSigInfo)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        int i = t.w;
        int k = 0;
        int j = 0;
        Object localObject = paramTransReqContext._body;
        long l1 = System.currentTimeMillis() / 1000L;
        long l2 = t.ae;
        if (localObject == null)
        {
          localObject = new byte[0];
          byte[] arrayOfByte = new byte[localObject.length + 4];
          util.int64_to_buf32(arrayOfByte, 0, l2 + l1);
          System.arraycopy(localObject, 0, arrayOfByte, 4, localObject.length);
          localObject = arrayOfByte;
          if (paramArrayOfByte1 != null) {
            localObject = cryptor.encrypt(arrayOfByte, 0, arrayOfByte.length, paramArrayOfByte2);
          }
          i = j;
          if (localObject != null)
          {
            i = j;
            if (localObject.length > 0)
            {
              if ((oicq_request.EncryptionMethod.EM_ST != paramTransReqContext.requestEm) || ((paramTransReqContext.wtSessionTicketKey != null) && (paramTransReqContext.wtSessionTicketKey.length != 0) && (paramTransReqContext.wtSessionTicket != null) && (paramTransReqContext.wtSessionTicket.length != 0))) {
                break label355;
              }
              paramTransReqContext.requestEm = oicq_request.EncryptionMethod.EM_ECDH;
              t.as.attr_api(2413503);
              util.LOGI("using wt st encrypt body but no st key", "" + paramLong1);
              break label355;
              a(paramLong1, a((byte[])localObject, bool, paramArrayOfByte1, paramLong2, paramLong3, paramTransReqContext), paramTransReqContext.requestEm);
              j = a(String.valueOf(paramLong1), false, paramWUserSigInfo);
              if (j != 0)
              {
                util.LOGI("request_transport rsp: ret=" + j);
                return j;
                bool = false;
                continue;
              }
              i = a(paramTransReqContext);
              if ((i == 0) && (paramArrayOfByte1 != null))
              {
                localObject = paramTransReqContext.get_body();
                paramTransReqContext.set_body(cryptor.decrypt((byte[])localObject, 0, localObject.length, paramArrayOfByte2));
              }
              j = i;
              if (i != 180) {
                continue;
              }
            }
          }
          j = i;
          if (k >= 1) {
            continue;
          }
          k += 1;
          j = i;
        }
        else
        {
          continue;
        }
      }
      finally {}
      label355:
      if (paramArrayOfByte1 != null) {
        bool = true;
      }
    }
  }
  
  public int a(long paramLong1, TransReqContext paramTransReqContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong2, long paramLong3, WUserSigInfo paramWUserSigInfo)
  {
    for (;;)
    {
      long l;
      byte[] arrayOfByte1;
      byte[] arrayOfByte2;
      try
      {
        i = t.w;
        l = paramTransReqContext._body.length;
        j = this.G;
        this.G = (j + 1);
        arrayOfByte1 = a(l, j, String.valueOf(paramLong1).getBytes(), paramLong2, paramLong2, paramArrayOfByte3, new String("wtlogin_conn_trans").getBytes(), new byte[8], 0, 0L, t.A);
        arrayOfByte2 = paramTransReqContext._body;
        l = System.currentTimeMillis() / 1000L;
        l = t.ae + l;
        if (arrayOfByte2 == null)
        {
          paramArrayOfByte3 = new byte[0];
          if ((paramArrayOfByte3 == null) || (paramArrayOfByte3.length <= 0)) {
            break label369;
          }
          paramArrayOfByte3 = a(paramArrayOfByte3, paramArrayOfByte1, paramLong2, paramLong3, 1);
          a(this.i, this.t, this.j, paramLong1, this.m, this.n, i, this.p, paramArrayOfByte3);
          i = a(String.valueOf(paramLong1), true, paramWUserSigInfo);
          if (i == 0) {
            break label316;
          }
          return i;
        }
        if (paramArrayOfByte1 == null)
        {
          paramArrayOfByte3 = new byte[arrayOfByte1.length + 4 + arrayOfByte2.length];
          util.int64_to_buf32(paramArrayOfByte3, 0, l);
          System.arraycopy(arrayOfByte1, 0, paramArrayOfByte3, 4, arrayOfByte1.length);
          System.arraycopy(arrayOfByte2, 0, paramArrayOfByte3, arrayOfByte1.length + 4, arrayOfByte2.length);
          continue;
        }
        paramArrayOfByte3 = new byte[arrayOfByte1.length + 4 + arrayOfByte2.length];
      }
      finally {}
      util.int64_to_buf32(paramArrayOfByte3, 0, l);
      System.arraycopy(arrayOfByte1, 0, paramArrayOfByte3, 4, arrayOfByte1.length);
      System.arraycopy(arrayOfByte2, 0, paramArrayOfByte3, arrayOfByte1.length + 4, arrayOfByte2.length);
      paramArrayOfByte3 = cryptor.encrypt(paramArrayOfByte3, 0, paramArrayOfByte3.length, paramArrayOfByte2);
      continue;
      label316:
      int j = a(paramTransReqContext);
      int i = j;
      if (j == 0)
      {
        i = j;
        if (paramArrayOfByte1 != null)
        {
          paramArrayOfByte1 = paramTransReqContext.get_body();
          paramTransReqContext.set_body(cryptor.decrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2));
          i = j;
          continue;
          label369:
          i = 0;
        }
      }
    }
  }
  
  public int a(long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong2, WUserSigInfo paramWUserSigInfo)
  {
    for (;;)
    {
      try
      {
        i = t.w;
        long l1 = System.currentTimeMillis() / 1000L;
        long l2 = t.ae;
        t.as.commit(Build.VERSION.RELEASE, new String(t.G), "", util.buf_to_string(util.get_ksid(t.t)), new String(t.E), new String(t.Q), new String(t.I), new String(t.H), util.get_release_time(), "6.0.0.2424");
        try
        {
          paramArrayOfByte1 = t.as.toJasonObj().toString().getBytes();
          if (paramArrayOfByte1 != null)
          {
            int j = paramArrayOfByte1.length;
            if (j != 0) {}
          }
          else
          {
            i = 0;
            return i;
          }
        }
        catch (Throwable paramArrayOfByte1)
        {
          paramArrayOfByte1 = new byte[0];
          continue;
          paramArrayOfByte1 = util.compress(paramArrayOfByte1);
          if (paramArrayOfByte1 == null) {
            break label344;
          }
        }
        if (paramArrayOfByte1.length == 0) {
          break label344;
        }
        byte[] arrayOfByte = new byte[paramArrayOfByte1.length + 8];
        util.int64_to_buf32(arrayOfByte, 0, l1 + l2);
        util.int8_to_buf(arrayOfByte, 4, 0);
        util.int8_to_buf(arrayOfByte, 5, 1);
        util.int16_to_buf(arrayOfByte, 6, paramArrayOfByte1.length);
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 8, paramArrayOfByte1.length);
        paramArrayOfByte1 = cryptor.encrypt(arrayOfByte, 0, arrayOfByte.length, paramArrayOfByte3);
        if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0)) {
          break label350;
        }
        report_t.delete_file(t.t);
        paramArrayOfByte1 = a(paramArrayOfByte1, paramArrayOfByte2, paramLong2, 85L, 0);
        a(this.i, this.t, this.j, paramLong1, this.m, this.n, i, this.p, paramArrayOfByte1);
        i = a(String.valueOf(paramLong1), true, paramWUserSigInfo);
        if (i != 0)
        {
          if (i == 0) {
            break label335;
          }
          report_t.write_tofile(t.as, t.t);
          continue;
        }
        i = b();
      }
      finally {}
      continue;
      label335:
      t.as.clear_t2();
      continue;
      label344:
      int i = 0;
      continue;
      label350:
      i = 0;
    }
  }
  
  public int a(TransReqContext paramTransReqContext)
  {
    int i = this.c;
    int j;
    if (i <= this.f + 2)
    {
      j = -1009;
      return j;
    }
    this.g = (i - this.f - 2);
    if (paramTransReqContext.requestEm == oicq_request.EncryptionMethod.EM_ECDH) {
      if (this.x.m == 0)
      {
        j = a(this.h, this.f + 1, this.g, this.x.p);
        i = j;
        if (j < 0)
        {
          util.LOGI("use ecdh decrypt_body failed");
          j = a(this.h, this.f + 1, this.g, this.x.c);
          i = j;
          if (j < 0)
          {
            util.LOGI("use kc decrypt_body failed");
            i = j;
          }
        }
      }
    }
    for (;;)
    {
      j = i;
      if (i < 0) {
        break;
      }
      return a(this.h, this.f + 1, this.g, paramTransReqContext);
      j = a(this.h, this.f + 1, this.g, this.x.c);
      i = j;
      if (j < 0)
      {
        util.LOGI("use kc decrypt_body failed");
        i = j;
        continue;
        if (paramTransReqContext.requestEm == oicq_request.EncryptionMethod.EM_ST)
        {
          j = a(this.h, this.f + 1, this.g, paramTransReqContext.wtSessionTicketKey);
          i = j;
          if (j < 0)
          {
            t.as.attr_api(2494911);
            util.LOGI("use session key decrypt_body failed", "");
            i = -1025;
          }
        }
        else
        {
          util.LOGI("unknown encryption method " + paramTransReqContext.requestEm, "");
          i = -1024;
        }
      }
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, TransReqContext paramTransReqContext)
  {
    if (paramInt2 < this.L) {
      return -1009;
    }
    int i = c(paramArrayOfByte, paramInt1);
    a((ErrMsg)null);
    util.LOGD(getClass().getName(), "type=" + i);
    switch (i)
    {
    default: 
      return i;
    case 0: 
      int j = this.L;
      byte[] arrayOfByte = new byte[paramInt2 - this.L];
      System.arraycopy(paramArrayOfByte, j + paramInt1, arrayOfByte, 0, arrayOfByte.length);
      paramTransReqContext.set_body(arrayOfByte);
      return i;
    }
    paramInt1 = this.L + 2 + paramInt1;
    paramTransReqContext = new tlv_t172();
    paramInt2 = paramTransReqContext.get_tlv(paramArrayOfByte, paramInt1, this.c - paramInt1 - 1);
    paramInt1 = paramInt2;
    if (paramInt2 > 0)
    {
      this.x.m = 2;
      this.x.r = paramTransReqContext.get_data();
      util.LOGI("request_transport get rollback sig");
      paramInt1 = i;
    }
    return paramInt1;
  }
  
  public void a(Socket paramSocket)
  {
    this.x.ap = paramSocket;
  }
  
  byte[] a(long paramLong1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt, long paramLong5, byte[] paramArrayOfByte5)
  {
    byte[] arrayOfByte = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte2 = new byte[paramArrayOfByte1.length + 16 + 4 + 16 + 4 + arrayOfByte.length + 4 + paramArrayOfByte3.length + 4 + paramArrayOfByte4.length + 1 + 4 + 4 + paramArrayOfByte5.length + 4];
    util.int64_to_buf32(paramArrayOfByte2, 0, paramArrayOfByte2.length + paramLong1);
    util.int64_to_buf32(paramArrayOfByte2, 4, paramArrayOfByte2.length - 4 - 4);
    util.int64_to_buf32(paramArrayOfByte2, 8, paramLong2);
    util.int32_to_buf(paramArrayOfByte2, 12, paramArrayOfByte1.length + 4);
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 16, paramArrayOfByte1.length);
    int i = paramArrayOfByte1.length + 16;
    util.int64_to_buf32(paramArrayOfByte2, i, paramLong3);
    i += 4;
    util.int64_to_buf32(paramArrayOfByte2, i, paramLong4);
    i += 16;
    util.int32_to_buf(paramArrayOfByte2, i, arrayOfByte.length + 4);
    i += 4;
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte2, i, arrayOfByte.length);
    i += arrayOfByte.length;
    util.int32_to_buf(paramArrayOfByte2, i, paramArrayOfByte3.length + 4);
    i += 4;
    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte2, i, paramArrayOfByte3.length);
    i += paramArrayOfByte3.length;
    util.int32_to_buf(paramArrayOfByte2, i, paramArrayOfByte4.length + 4);
    i += 4;
    System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte2, i, paramArrayOfByte4.length);
    i += paramArrayOfByte4.length;
    util.int8_to_buf(paramArrayOfByte2, i, paramInt);
    paramInt = i + 1;
    util.int64_to_buf32(paramArrayOfByte2, paramInt, paramLong5);
    paramInt += 4;
    util.int32_to_buf(paramArrayOfByte2, paramInt, paramArrayOfByte5.length + 4);
    paramInt += 4;
    System.arraycopy(paramArrayOfByte5, 0, paramArrayOfByte2, paramInt, paramArrayOfByte5.length);
    paramInt += paramArrayOfByte5.length;
    util.int64_to_buf32(paramArrayOfByte2, paramInt, 4L + paramLong1);
    return paramArrayOfByte2;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, boolean paramBoolean, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, TransReqContext paramTransReqContext)
  {
    byte[] arrayOfByte1 = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      arrayOfByte1 = new byte[0];
    }
    if (true == paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      byte[] arrayOfByte2 = new byte[0];
      paramArrayOfByte2 = arrayOfByte2;
      if (this.x.r != null)
      {
        paramArrayOfByte2 = arrayOfByte2;
        if (this.x.r.length > 0)
        {
          arrayOfByte2 = new tlv_t172().get_tlv_172(this.x.r);
          paramArrayOfByte2 = new byte[arrayOfByte2.length + 2];
          util.int16_to_buf(paramArrayOfByte2, 0, 1);
          System.arraycopy(arrayOfByte2, 0, paramArrayOfByte2, 2, arrayOfByte2.length);
        }
      }
      this.K = (arrayOfByte1.length + 13 + 1 + paramArrayOfByte2.length);
      arrayOfByte2 = new byte[paramArrayOfByte1.length + this.K];
      util.int8_to_buf(arrayOfByte2, 0, i);
      util.int16_to_buf(arrayOfByte2, 1, paramArrayOfByte1.length);
      util.int64_to_buf32(arrayOfByte2, 3, paramLong1);
      util.int64_to_buf32(arrayOfByte2, 7, paramLong2);
      util.int16_to_buf(arrayOfByte2, 11, arrayOfByte1.length);
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 13, arrayOfByte1.length);
      i = arrayOfByte1.length + 13;
      util.int8_to_buf(arrayOfByte2, i, paramArrayOfByte2.length);
      i += 1;
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte2, i, paramArrayOfByte2.length);
      i += paramArrayOfByte2.length;
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte2, i, paramArrayOfByte1.length);
      i = paramArrayOfByte1.length;
      return a(arrayOfByte2, paramTransReqContext.requestEm, paramTransReqContext.wtSessionTicket, paramTransReqContext.wtSessionTicketKey);
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramArrayOfByte2 == null)
    {
      paramArrayOfByte2 = new byte[0];
      if (paramInt == 0) {
        paramInt = 0;
      }
    }
    for (;;)
    {
      byte[] arrayOfByte2 = new byte[0];
      byte[] arrayOfByte1 = arrayOfByte2;
      if (this.x.r != null)
      {
        arrayOfByte1 = arrayOfByte2;
        if (this.x.r.length > 0)
        {
          arrayOfByte2 = new tlv_t172().get_tlv_172(this.x.r);
          arrayOfByte1 = new byte[arrayOfByte2.length + 2];
          util.int16_to_buf(arrayOfByte1, 0, 1);
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 2, arrayOfByte2.length);
        }
      }
      this.K = (paramArrayOfByte2.length + 13 + 1 + arrayOfByte1.length);
      arrayOfByte2 = new byte[paramArrayOfByte1.length + this.K];
      util.int8_to_buf(arrayOfByte2, 0, paramInt);
      util.int16_to_buf(arrayOfByte2, 1, paramArrayOfByte1.length);
      util.int64_to_buf32(arrayOfByte2, 3, paramLong1);
      util.int64_to_buf32(arrayOfByte2, 7, paramLong2);
      util.int16_to_buf(arrayOfByte2, 11, paramArrayOfByte2.length);
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte2, 13, paramArrayOfByte2.length);
      paramInt = paramArrayOfByte2.length + 13;
      util.int8_to_buf(arrayOfByte2, paramInt, arrayOfByte1.length);
      paramInt += 1;
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, paramInt, arrayOfByte1.length);
      paramInt += arrayOfByte1.length;
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte2, paramInt, paramArrayOfByte1.length);
      paramInt = paramArrayOfByte1.length;
      return a(arrayOfByte2);
      paramInt = 3;
      continue;
      if (paramInt == 0) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
    }
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 < this.L) {
      return -1009;
    }
    paramInt1 = c(paramArrayOfByte, paramInt1);
    a((ErrMsg)null);
    util.LOGD(getClass().getName(), "type=" + paramInt1);
    return paramInt1;
  }
  
  public Socket d()
  {
    if (this.x.ap != null) {
      util.LOGD("_transport_sk", "_transport_sk" + this.x.ap.toString());
    }
    for (;;)
    {
      return this.x.ap;
      util.LOGD("_transport_sk", "_transport_sk null");
    }
  }
  
  public int e(boolean paramBoolean)
  {
    if (paramBoolean) {}
    return 8080;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.aa
 * JD-Core Version:    0.7.0.1
 */