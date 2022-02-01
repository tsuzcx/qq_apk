package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t108;
import oicq.wlogin_sdk.tlv_type.tlv_t109;
import oicq.wlogin_sdk.tlv_type.tlv_t112;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t142;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t154;
import oicq.wlogin_sdk.tlv_type.tlv_t52c;
import oicq.wlogin_sdk.tlv_type.tlv_t52d;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.util;

public class x
  extends oicq_request
{
  public x(t paramt)
  {
    this.t = 2064;
    this.u = 17;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte, String paramString, int paramInt2, int paramInt3, long[] paramArrayOfLong, int paramInt4, long paramLong3, WUserSigInfo paramWUserSigInfo)
  {
    int m = t.x;
    byte[] arrayOfByte1;
    int i;
    if ((paramString == null) && (paramInt4 == 1))
    {
      arrayOfByte1 = t.am;
      i = 0;
    }
    for (;;)
    {
      byte[] arrayOfByte2;
      label32:
      int j;
      if (paramString == null)
      {
        arrayOfByte2 = null;
        arrayOfByte2 = a(paramLong1, paramLong2, paramInt1, m, paramArrayOfByte, arrayOfByte2, paramInt4, paramLong3, arrayOfByte1, paramInt2, paramInt3, paramArrayOfLong, paramWUserSigInfo);
        a(this.i, this.t, this.j, this.x.f, this.m, this.n, m, this.p, arrayOfByte2);
        j = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
        if (j == 0) {
          break label144;
        }
      }
      label144:
      do
      {
        int k;
        do
        {
          return j;
          arrayOfByte1 = null;
          break;
          arrayOfByte2 = paramString.getBytes();
          break label32;
          k = b();
          util.LOGI("retry num:" + i + " extra:" + paramLong3 + " ret:" + k, "" + this.x.f);
          j = k;
        } while (k != 180);
        j = k;
      } while (i >= 1);
      i += 1;
    }
  }
  
  public byte[] a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3, long paramLong3, byte[] paramArrayOfByte3, int paramInt4, int paramInt5, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int i = 0;
    int[] arrayOfInt;
    ArrayList localArrayList;
    int j;
    int k;
    label120:
    byte[] arrayOfByte;
    Object localObject;
    if (paramArrayOfByte2 == null) {
      if (paramInt3 == 1)
      {
        arrayOfInt = new int[12];
        int[] tmp22_20 = arrayOfInt;
        tmp22_20[0] = 256;
        int[] tmp28_22 = tmp22_20;
        tmp28_22[1] = 260;
        int[] tmp34_28 = tmp28_22;
        tmp34_28[2] = 264;
        int[] tmp40_34 = tmp34_28;
        tmp40_34[3] = 265;
        int[] tmp46_40 = tmp40_34;
        tmp46_40[4] = 1325;
        int[] tmp52_46 = tmp46_40;
        tmp52_46[5] = 8;
        int[] tmp57_52 = tmp52_46;
        tmp57_52[6] = 322;
        int[] tmp64_57 = tmp57_52;
        tmp64_57[7] = 325;
        int[] tmp71_64 = tmp64_57;
        tmp71_64[8] = 340;
        int[] tmp78_71 = tmp71_64;
        tmp78_71[9] = 1324;
        int[] tmp85_78 = tmp78_71;
        tmp85_78[10] = 278;
        int[] tmp92_85 = tmp85_78;
        tmp92_85[11] = 1313;
        tmp92_85;
        localArrayList = new ArrayList();
        int m = tmp22_20.length;
        j = 0;
        k = 0;
        if (k >= m) {
          break label782;
        }
        arrayOfByte = new byte[0];
        switch (tmp22_20[k])
        {
        default: 
          localObject = arrayOfByte;
          label256:
          if (localObject.length > 4)
          {
            int n = localObject.length;
            localArrayList.add(localObject);
            j = n + j;
            i += 1;
          }
          break;
        }
      }
    }
    for (;;)
    {
      k += 1;
      break label120;
      tmp22_20 = new int[11];
      int[] tmp306_304 = tmp22_20;
      tmp306_304[0] = 256;
      int[] tmp312_306 = tmp306_304;
      tmp312_306[1] = 264;
      int[] tmp318_312 = tmp312_306;
      tmp318_312[2] = 265;
      int[] tmp324_318 = tmp318_312;
      tmp324_318[3] = 1325;
      int[] tmp330_324 = tmp324_318;
      tmp330_324[4] = 8;
      int[] tmp335_330 = tmp330_324;
      tmp335_330[5] = 322;
      int[] tmp341_335 = tmp335_330;
      tmp341_335[6] = 325;
      int[] tmp348_341 = tmp341_335;
      tmp348_341[7] = 340;
      int[] tmp355_348 = tmp348_341;
      tmp355_348[8] = 1324;
      int[] tmp362_355 = tmp355_348;
      tmp362_355[9] = 278;
      int[] tmp369_362 = tmp362_355;
      tmp369_362[10] = 1313;
      tmp369_362;
      break;
      tmp22_20 = new int[11];
      int[] tmp388_386 = tmp22_20;
      tmp388_386[0] = 256;
      int[] tmp394_388 = tmp388_386;
      tmp394_388[1] = 264;
      int[] tmp400_394 = tmp394_388;
      tmp400_394[2] = 265;
      int[] tmp406_400 = tmp400_394;
      tmp406_400[3] = 1325;
      int[] tmp412_406 = tmp406_400;
      tmp412_406[4] = 8;
      int[] tmp417_412 = tmp412_406;
      tmp417_412[5] = 322;
      int[] tmp423_417 = tmp417_412;
      tmp423_417[6] = 325;
      int[] tmp430_423 = tmp423_417;
      tmp430_423[7] = 340;
      int[] tmp437_430 = tmp430_423;
      tmp437_430[8] = 274;
      int[] tmp444_437 = tmp437_430;
      tmp444_437[9] = 278;
      int[] tmp451_444 = tmp444_437;
      tmp451_444[10] = 1313;
      tmp451_444;
      break;
      localObject = new tlv_t100().get_tlv_100(paramLong1, paramLong2, paramInt2, paramInt1);
      break label256;
      localObject = new tlv_t104().get_tlv_104(paramArrayOfByte3);
      break label256;
      localObject = arrayOfByte;
      if (paramArrayOfByte1 == null) {
        break label256;
      }
      localObject = arrayOfByte;
      if (paramArrayOfByte1.length <= 0) {
        break label256;
      }
      localObject = new tlv_t108().get_tlv_108(paramArrayOfByte1);
      break label256;
      localObject = arrayOfByte;
      if (t.P == null) {
        break label256;
      }
      localObject = arrayOfByte;
      if (t.P.length <= 0) {
        break label256;
      }
      localObject = new tlv_t109().get_tlv_109(t.P);
      break label256;
      localObject = new tlv_t52d().get_tlv_52d(this.a);
      break label256;
      localObject = new tlv_t8().get_tlv_8(0, t.v, 0);
      break label256;
      localObject = new tlv_t142().get_tlv_142(t.F);
      break label256;
      localObject = new tlv_t145().get_tlv_145(t.B);
      break label256;
      localObject = new tlv_t154().get_tlv_154(this.x.i);
      break label256;
      localObject = new tlv_t112().get_tlv_112(paramArrayOfByte2);
      break label256;
      localObject = new tlv_t116().get_tlv_116(paramInt4, paramInt5, paramArrayOfLong);
      break label256;
      localObject = new tlv_t(1313);
      arrayOfByte = new byte[6];
      util.int32_to_buf(arrayOfByte, 0, t.aA);
      util.int16_to_buf(arrayOfByte, 4, 0);
      ((tlv_t)localObject).set_data(arrayOfByte, 6);
      localObject = ((tlv_t)localObject).get_buf();
      break label256;
      localObject = new tlv_t52c().get_tlv_52c(paramInt3, paramLong3);
      break label256;
      label782:
      paramArrayOfByte1 = (tlv_t)paramWUserSigInfo._loginExtraProductTLVMap.get(Integer.valueOf(1322));
      paramInt1 = j;
      paramInt2 = i;
      if (paramArrayOfByte1 != null)
      {
        paramArrayOfByte1 = paramArrayOfByte1.get_buf();
        paramInt2 = i + 1;
        paramInt1 = j + paramArrayOfByte1.length;
        localArrayList.add(paramArrayOfByte1);
      }
      paramArrayOfByte1 = paramWUserSigInfo.extraLoginTLVMap.keySet().iterator();
      while (paramArrayOfByte1.hasNext())
      {
        paramArrayOfByte2 = (Integer)paramArrayOfByte1.next();
        paramArrayOfByte3 = ((tlv_t)paramWUserSigInfo.extraLoginTLVMap.get(paramArrayOfByte2)).get_buf();
        paramInt1 += paramArrayOfByte3.length;
        localArrayList.add(paramArrayOfByte3);
        paramInt2 += 1;
        util.LOGI("Extra Tlv from user：0x" + paramArrayOfByte2);
      }
      paramArrayOfByte1 = new byte[paramInt1];
      paramInt3 = 0;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramArrayOfByte2 = (byte[])localArrayList.get(paramInt1);
        System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt3, paramArrayOfByte2.length);
        paramInt3 += paramArrayOfByte2.length;
        paramInt1 += 1;
      }
      return b(paramArrayOfByte1, this.u, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.x
 * JD-Core Version:    0.7.0.1
 */