import com.qq.jce.wup.UniPacket;
import com.tencent.av.video.jce.QQService.strupbuff;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class lfc
{
  private static lfc jdField_a_of_type_Lfc;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "UNKNOWN", "WIFI", "CMWAP", "CMNET", "UNIWAP", "UNINET", "CTWAP", "CTNET", "3GWAP", "3GNET" };
  private int jdField_a_of_type_Int;
  private UniPacket jdField_a_of_type_ComQqJceWupUniPacket = new UniPacket(true);
  private strupbuff jdField_a_of_type_ComTencentAvVideoJceQQServiceStrupbuff = new strupbuff(this.jdField_a_of_type_JavaUtilMap);
  private Map<String, ArrayList<byte[]>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private lfd jdField_a_of_type_Lfd = new lfd(this);
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[256];
  
  private int a()
  {
    int i = 0;
    String str = bdin.a(BaseApplication.getContext());
    if ("wifi".equals(str)) {
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SharpReport_OffLine", 2, "getApn: " + i);
      }
      return i;
      if ("cmnet".equals(str)) {
        i = 3;
      } else if ("cmwap".equals(str)) {
        i = 2;
      } else if ("ctnet".equals(str)) {
        i = 7;
      } else if ("ctwap".equals(str)) {
        i = 6;
      } else if ("uninet".equals(str)) {
        i = 5;
      } else if ("uniwap".equals(str)) {
        i = 4;
      } else if ("3gnet".equals(str)) {
        i = 9;
      } else if ("3gwap".equals(str)) {
        i = 8;
      }
    }
  }
  
  private int a(int paramInt)
  {
    int i;
    if (this.jdField_a_of_type_ArrayOfByte == null) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return i;
                b(this.jdField_a_of_type_Lfd.jdField_a_of_type_JavaLangString.length());
                j = a(this.jdField_a_of_type_Lfd.jdField_a_of_type_JavaLangString);
                i = j;
              } while (j < 0);
              b(this.jdField_a_of_type_Lfd.jdField_b_of_type_JavaLangString.length());
              j = a(this.jdField_a_of_type_Lfd.jdField_b_of_type_JavaLangString);
              i = j;
            } while (j < 0);
            b(this.jdField_a_of_type_Lfd.jdField_c_of_type_JavaLangString.length());
            j = a(this.jdField_a_of_type_Lfd.jdField_c_of_type_JavaLangString);
            i = j;
          } while (j < 0);
          b(this.jdField_a_of_type_Lfd.f.length());
          j = a(this.jdField_a_of_type_Lfd.f);
          i = j;
        } while (j < 0);
        b(this.jdField_a_of_type_Lfd.d.length());
        j = a(this.jdField_a_of_type_Lfd.d);
        i = j;
      } while (j < 0);
      b(this.jdField_a_of_type_Lfd.e.length());
      j = a(this.jdField_a_of_type_Lfd.e);
      i = j;
    } while (j < 0);
    a(this.jdField_a_of_type_Lfd.jdField_c_of_type_Long);
    a(this.jdField_a_of_type_Lfd.jdField_a_of_type_Long);
    a(this.jdField_a_of_type_Lfd.jdField_a_of_type_Int);
    a(this.jdField_a_of_type_Lfd.jdField_b_of_type_Long);
    a(this.jdField_a_of_type_Lfd.jdField_b_of_type_Int);
    a(paramInt);
    return 0;
  }
  
  private int a(long paramLong, byte[] paramArrayOfByte)
  {
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_ComQqJceWupUniPacket == null) || (this.jdField_a_of_type_ComTencentAvVideoJceQQServiceStrupbuff == null)) {
      return 0;
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap.put("617", new ArrayList());
    ((ArrayList)this.jdField_a_of_type_JavaUtilMap.get("617")).add(paramArrayOfByte);
    this.jdField_a_of_type_ComQqJceWupUniPacket.put("Data", this.jdField_a_of_type_ComTencentAvVideoJceQQServiceStrupbuff);
    paramArrayOfByte = this.jdField_a_of_type_ComQqJceWupUniPacket.encode();
    ToServiceMsg localToServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), String.valueOf(paramLong), "CliLogSvc.UploadReq");
    localToServiceMsg.setNeedCallback(false);
    localToServiceMsg.putWupBuffer(paramArrayOfByte);
    localToServiceMsg.setNeedRemindSlowNetwork(false);
    try
    {
      int i = MsfServiceSdk.get().sendMsg(localToServiceMsg);
      if (i >= 0) {
        return 1;
      }
      return 0;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return 0;
  }
  
  private int a(String paramString)
  {
    int k = 0;
    try
    {
      paramString = paramString.getBytes("utf-8");
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= paramString.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfByte[this.jdField_a_of_type_Int] = paramString[i];
        this.jdField_a_of_type_Int += 1;
        i += 1;
      }
      return j;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
      j = -1;
    }
  }
  
  private String a()
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
  }
  
  public static lfc a()
  {
    if (jdField_a_of_type_Lfc == null) {
      jdField_a_of_type_Lfc = new lfc();
    }
    return jdField_a_of_type_Lfc;
  }
  
  private void a(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    this.jdField_a_of_type_ArrayOfByte[this.jdField_a_of_type_Int] = i;
    this.jdField_a_of_type_Int += 1;
  }
  
  private void a(long paramLong)
  {
    int i = (byte)(int)(paramLong >> 56 & 0xFF);
    int j = (byte)(int)(paramLong >> 48 & 0xFF);
    int k = (byte)(int)(paramLong >> 40 & 0xFF);
    int m = (byte)(int)(paramLong >> 32 & 0xFF);
    int n = (byte)(int)(paramLong >> 24 & 0xFF);
    int i1 = (byte)(int)(paramLong >> 16 & 0xFF);
    int i2 = (byte)(int)(paramLong >> 8 & 0xFF);
    int i3 = (byte)(int)(0xFF & paramLong);
    this.jdField_a_of_type_ArrayOfByte[this.jdField_a_of_type_Int] = i;
    this.jdField_a_of_type_ArrayOfByte[(this.jdField_a_of_type_Int + 1)] = j;
    this.jdField_a_of_type_ArrayOfByte[(this.jdField_a_of_type_Int + 2)] = k;
    this.jdField_a_of_type_ArrayOfByte[(this.jdField_a_of_type_Int + 3)] = m;
    this.jdField_a_of_type_ArrayOfByte[(this.jdField_a_of_type_Int + 4)] = n;
    this.jdField_a_of_type_ArrayOfByte[(this.jdField_a_of_type_Int + 5)] = i1;
    this.jdField_a_of_type_ArrayOfByte[(this.jdField_a_of_type_Int + 6)] = i2;
    this.jdField_a_of_type_ArrayOfByte[(this.jdField_a_of_type_Int + 7)] = i3;
    this.jdField_a_of_type_Int += 8;
  }
  
  private void b(int paramInt)
  {
    int i = (byte)(paramInt >> 8 & 0xFF);
    int j = (byte)(paramInt & 0xFF);
    this.jdField_a_of_type_ArrayOfByte[this.jdField_a_of_type_Int] = i;
    this.jdField_a_of_type_ArrayOfByte[(this.jdField_a_of_type_Int + 1)] = j;
    this.jdField_a_of_type_Int += 2;
  }
  
  public int a(int paramInt1, int paramInt2, long paramLong)
  {
    int i = 0;
    if (this.jdField_a_of_type_Lfd == null) {
      paramInt2 = -1;
    }
    do
    {
      return paramInt2;
      int j = a();
      this.jdField_a_of_type_Lfd.e = jdField_a_of_type_ArrayOfJavaLangString[j];
      this.jdField_a_of_type_Lfd.d = a();
      this.jdField_a_of_type_Lfd.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Lfd.jdField_b_of_type_Int = paramInt2;
      if (paramLong != 0L) {
        this.jdField_a_of_type_Lfd.jdField_b_of_type_Long = paramLong;
      }
      this.jdField_a_of_type_Int = 0;
      if (a(paramInt1) < 0) {
        return -1;
      }
      if (this.jdField_a_of_type_Int <= 0) {
        break;
      }
      byte[] arrayOfByte = new byte[this.jdField_a_of_type_Int];
      paramInt2 = 0;
      while (paramInt2 < this.jdField_a_of_type_Int)
      {
        arrayOfByte[paramInt2] = this.jdField_a_of_type_ArrayOfByte[paramInt2];
        paramInt2 += 1;
      }
      a(this.jdField_a_of_type_Lfd.jdField_a_of_type_Long, arrayOfByte);
      this.jdField_a_of_type_Int = 0;
      paramInt2 = i;
    } while (!QLog.isColorLevel());
    QLog.d("SharpReport_Node", 2, "report_node is" + paramInt1);
    return 0;
    return -1;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_Lfd == null) {
      return;
    }
    this.jdField_a_of_type_Lfd.jdField_b_of_type_Long = paramLong3;
    this.jdField_a_of_type_Lfd.jdField_a_of_type_Long = paramLong2;
    this.jdField_a_of_type_Lfd.jdField_c_of_type_Long = paramLong1;
    this.jdField_a_of_type_Lfd.jdField_c_of_type_JavaLangString = String.valueOf(AppSetting.a());
    this.jdField_a_of_type_Lfd.f = AppSetting.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lfc
 * JD-Core Version:    0.7.0.1
 */