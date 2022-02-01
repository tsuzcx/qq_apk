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
  private static final String TAG = "ProtocolUtils";
  
  public static JceStruct decode(byte[] paramArrayOfByte, String paramString)
  {
    return decode(paramArrayOfByte, paramString, null);
  }
  
  public static JceStruct decode(byte[] paramArrayOfByte, String paramString, int[] paramArrayOfInt)
  {
    return decode(paramArrayOfByte, paramString, paramArrayOfInt, null);
  }
  
  public static JceStruct decode(byte[] paramArrayOfByte, String paramString, int[] paramArrayOfInt, String[] paramArrayOfString)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      paramArrayOfInt[0] = -1000000;
    }
    Object localObject1 = new WNSStream();
    try
    {
      paramArrayOfByte = ((WNSStream)localObject1).unpack(WupUtil.b(paramArrayOfByte));
      if ((paramArrayOfByte != null) && (paramArrayOfByte.WnsCode == 0))
      {
        localObject1 = new UniAttribute();
        ((UniAttribute)localObject1).setEncodeName("utf-8");
        ((UniAttribute)localObject1).decode(paramArrayOfByte.Extra);
        Object localObject2 = (QmfBusiControl)((UniAttribute)localObject1).get("busiCompCtl");
        if ((localObject2 != null) && (1 == ((QmfBusiControl)localObject2).compFlag))
        {
          localObject2 = WNSStream.decompress(paramArrayOfByte.BusiBuff);
          if (localObject2 != null)
          {
            paramArrayOfByte.BusiBuff = ((byte[])localObject2);
          }
          else
          {
            if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
              paramArrayOfInt[0] = 1000002;
            }
            getServerMsg((UniAttribute)localObject1, paramArrayOfString);
            return null;
          }
        }
        localObject1 = new UniAttribute();
        ((UniAttribute)localObject1).setEncodeName("utf-8");
        ((UniAttribute)localObject1).decode(paramArrayOfByte.BusiBuff);
        int i = paramArrayOfByte.BizCode;
        paramArrayOfByte = ((UniAttribute)localObject1).get("ret", Short.valueOf(paramArrayOfByte.BizCode));
        if ((paramArrayOfByte instanceof Short)) {
          i = ((Short)paramArrayOfByte).intValue();
        } else if ((paramArrayOfByte instanceof Integer)) {
          i = ((Integer)paramArrayOfByte).intValue();
        }
        if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
          paramArrayOfInt[0] = i;
        }
        getServerMsg((UniAttribute)localObject1, paramArrayOfString);
        return (JceStruct)((UniAttribute)localObject1).get(paramString);
      }
      if ((paramArrayOfByte != null) && (paramArrayOfByte.WnsCode != 0))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("decode ");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append(" error:");
          ((StringBuilder)localObject1).append(WnsError.getErrorMessage(paramArrayOfByte.WnsCode));
          QLog.e("ProtocolUtils", 2, ((StringBuilder)localObject1).toString());
        }
        if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
          paramArrayOfInt[0] = paramArrayOfByte.WnsCode;
        }
        if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0)) {
          break label407;
        }
        paramArrayOfString[0] = WnsError.getErrorMessage(paramArrayOfByte.WnsCode);
        return null;
      }
      if ((paramArrayOfByte == null) && (paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
        paramArrayOfInt[0] = 1000003;
      }
      return null;
    }
    catch (Throwable paramArrayOfByte)
    {
      label387:
      break label387;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      paramArrayOfInt[0] = 1000001;
    }
    return null;
    label407:
    return null;
  }
  
  /* Error */
  private static void getServerMsg(UniAttribute paramUniAttribute, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +68 -> 69
    //   4: aload_1
    //   5: ifnull +64 -> 69
    //   8: aload_1
    //   9: arraylength
    //   10: iconst_1
    //   11: if_icmpge +4 -> 15
    //   14: return
    //   15: aload_1
    //   16: iconst_0
    //   17: aload_0
    //   18: ldc 140
    //   20: ldc 142
    //   22: invokevirtual 96	com/qq/jce/wup/UniAttribute:get	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 144	java/lang/String
    //   28: checkcast 144	java/lang/String
    //   31: aastore
    //   32: aload_1
    //   33: iconst_0
    //   34: aaload
    //   35: ifnonnull +34 -> 69
    //   38: aload_1
    //   39: iconst_0
    //   40: ldc 146
    //   42: aastore
    //   43: return
    //   44: astore_0
    //   45: aload_1
    //   46: iconst_0
    //   47: aaload
    //   48: ifnonnull +8 -> 56
    //   51: aload_1
    //   52: iconst_0
    //   53: ldc 146
    //   55: aastore
    //   56: aload_0
    //   57: athrow
    //   58: aload_1
    //   59: iconst_0
    //   60: aaload
    //   61: ifnonnull +8 -> 69
    //   64: aload_1
    //   65: iconst_0
    //   66: ldc 146
    //   68: aastore
    //   69: return
    //   70: astore_0
    //   71: goto -13 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	paramUniAttribute	UniAttribute
    //   0	74	1	paramArrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   15	32	44	finally
    //   15	32	70	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.ProtocolUtils
 * JD-Core Version:    0.7.0.1
 */