package cooperation.qzone.util;

import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfDownstream;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.WNSStream;

public class ProtocolUtils
{
  public static JceStruct a(byte[] paramArrayOfByte, String paramString)
  {
    return a(paramArrayOfByte, paramString, null);
  }
  
  public static JceStruct a(byte[] paramArrayOfByte, String paramString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      paramArrayOfInt[0] = -1000000;
    }
    Object localObject = new WNSStream();
    label339:
    for (;;)
    {
      try
      {
        paramArrayOfByte = ((WNSStream)localObject).unpack(WupUtil.b(paramArrayOfByte));
        localObject = new UniAttribute();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.WnsCode == 0))
        {
          ((UniAttribute)localObject).setEncodeName("utf-8");
          ((UniAttribute)localObject).decode(paramArrayOfByte.Extra);
          localObject = (QmfBusiControl)((UniAttribute)localObject).get("busiCompCtl");
          if ((localObject != null) && (1 == ((QmfBusiControl)localObject).compFlag))
          {
            localObject = WNSStream.decompress(paramArrayOfByte.BusiBuff);
            if (localObject != null) {
              paramArrayOfByte.BusiBuff = ((byte[])localObject);
            }
          }
          else
          {
            localObject = new UniAttribute();
            ((UniAttribute)localObject).setEncodeName("utf-8");
            ((UniAttribute)localObject).decode(paramArrayOfByte.BusiBuff);
            i = paramArrayOfByte.BizCode;
            paramArrayOfByte = ((UniAttribute)localObject).get("ret", Short.valueOf(paramArrayOfByte.BizCode));
            if (!(paramArrayOfByte instanceof Short)) {
              continue;
            }
            i = ((Short)paramArrayOfByte).intValue();
            if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
              paramArrayOfInt[0] = i;
            }
            return (JceStruct)((UniAttribute)localObject).get(paramString);
          }
          if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
            break;
          }
          paramArrayOfInt[0] = 1000002;
          break;
          if (!(paramArrayOfByte instanceof Integer)) {
            break label339;
          }
          int i = ((Integer)paramArrayOfByte).intValue();
          continue;
        }
        if ((paramArrayOfByte != null) && (paramArrayOfByte.WnsCode != 0))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ProtocolUtils", 2, new Object[] { "decode error:", Short.valueOf(paramArrayOfByte.WnsCode) });
          }
          if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
            break label344;
          }
          paramArrayOfInt[0] = paramArrayOfByte.WnsCode;
          break label344;
        }
        if (paramArrayOfByte == null)
        {
          if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
            paramArrayOfInt[0] = 1000003;
          }
          return null;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
          paramArrayOfInt[0] = 1000001;
        }
        return null;
      }
      return null;
    }
    return null;
    label344:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.ProtocolUtils
 * JD-Core Version:    0.7.0.1
 */