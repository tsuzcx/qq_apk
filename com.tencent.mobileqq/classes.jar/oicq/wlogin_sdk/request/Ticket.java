package oicq.wlogin_sdk.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import oicq.wlogin_sdk.tools.util;

public class Ticket
  implements Parcelable
{
  public static final Parcelable.Creator<Ticket> CREATOR = new Ticket.1();
  private static final int EXPIRE_FIELD = 65535;
  public long _create_time;
  public long _expire_time;
  public Map<String, Long> _pskey_expire = new HashMap();
  public Map<String, byte[]> _pskey_map = new HashMap();
  public Map<String, Long> _pt4token_expire = new HashMap();
  public Map<String, byte[]> _pt4token_map = new HashMap();
  public byte[] _sig;
  public byte[] _sig_key;
  public int _type;
  
  public Ticket() {}
  
  public Ticket(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2)
  {
    this._type = paramInt;
    if (paramArrayOfByte1 == null)
    {
      paramArrayOfByte1 = new byte[0];
      this._sig = paramArrayOfByte1;
      if (paramArrayOfByte2 != null) {
        break label103;
      }
    }
    label103:
    for (paramArrayOfByte1 = new byte[0];; paramArrayOfByte1 = (byte[])paramArrayOfByte2.clone())
    {
      this._sig_key = paramArrayOfByte1;
      this._create_time = paramLong1;
      this._expire_time = paramLong2;
      return;
      paramArrayOfByte1 = (byte[])paramArrayOfByte1.clone();
      break;
    }
  }
  
  public Ticket(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3)
  {
    this._type = paramInt;
    if (paramArrayOfByte1 == null)
    {
      paramArrayOfByte1 = new byte[0];
      this._sig = paramArrayOfByte1;
      if (paramArrayOfByte2 != null) {
        break label125;
      }
    }
    label125:
    for (paramArrayOfByte1 = new byte[0];; paramArrayOfByte1 = (byte[])paramArrayOfByte2.clone())
    {
      this._sig_key = paramArrayOfByte1;
      this._create_time = paramLong;
      this._expire_time = (86400L + paramLong);
      parsePsBuf(paramArrayOfByte3, this._create_time, this._pskey_map, this._pskey_expire, true);
      return;
      paramArrayOfByte1 = (byte[])paramArrayOfByte1.clone();
      break;
    }
  }
  
  public Ticket(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    this._type = paramInt;
    if (paramArrayOfByte1 == null)
    {
      paramArrayOfByte1 = new byte[0];
      this._sig = paramArrayOfByte1;
      if (paramArrayOfByte2 != null) {
        break label143;
      }
    }
    label143:
    for (paramArrayOfByte1 = new byte[0];; paramArrayOfByte1 = (byte[])paramArrayOfByte2.clone())
    {
      this._sig_key = paramArrayOfByte1;
      this._create_time = paramLong;
      this._expire_time = (86400L + paramLong);
      parsePsBuf(paramArrayOfByte3, this._create_time, this._pskey_map, this._pskey_expire, true);
      parsePsBuf(paramArrayOfByte4, this._create_time, this._pt4token_map, this._pt4token_expire, false);
      return;
      paramArrayOfByte1 = (byte[])paramArrayOfByte1.clone();
      break;
    }
  }
  
  private Ticket(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  private String __getPskey(String paramString, Map<String, byte[]> paramMap, Map<String, Long> paramMap1)
  {
    util.LOGI("__getPskey get domain " + paramString + " pskey or pt4token", "");
    if (paramMap == null) {
      return null;
    }
    byte[] arrayOfByte = (byte[])paramMap.get(paramString);
    if (arrayOfByte == null)
    {
      util.LOGI("__getPskey get domain " + paramString + " pskey or pt4token null", "");
      return null;
    }
    if (paramMap1 != null)
    {
      Long localLong = (Long)paramMap1.get(paramString);
      if ((localLong != null) && (localLong.longValue() <= t.f()))
      {
        util.LOGI("__getPskey delete domain " + paramString + " expired pskey or pt4token expire time " + localLong, "");
        paramMap1.remove(paramString);
        paramMap.remove(paramString);
        return null;
      }
    }
    paramMap = new String(arrayOfByte);
    util.LOGI("__getPskey get domain " + paramString + " pskey or pt4token len " + paramMap.length() + " " + paramMap.substring(0, 5) + "***" + paramMap.substring(paramMap.length() - 5, paramMap.length()), "");
    return paramMap;
  }
  
  private String getPskeyOrPt4tokenContent()
  {
    Iterator localIterator = this._pskey_map.keySet().iterator();
    String str2;
    for (String str1 = ""; localIterator.hasNext(); str1 = str1 + str2 + ":" + util.getMaskBytes((byte[])this._pskey_map.get(str2), 3, 3) + "|") {
      str2 = (String)localIterator.next();
    }
    return str1;
  }
  
  public static boolean isPskeyExpired(long paramLong)
  {
    return isTicketExpired(paramLong);
  }
  
  public static boolean isPskeyStorageExpired(long paramLong)
  {
    long l = t.f();
    util.LOGI("isPskeyStorageExpired expireTime:" + paramLong + "|current: " + l, "");
    return l > 86400L + paramLong;
  }
  
  public static boolean isPt4TokenExpired(long paramLong)
  {
    return isTicketExpired(paramLong);
  }
  
  public static boolean isSkeyExpired(long paramLong)
  {
    return isTicketExpired(paramLong);
  }
  
  public static boolean isTicketExpired(long paramLong)
  {
    long l = t.f();
    if (l > paramLong) {
      return true;
    }
    if (paramLong > 86400L + l)
    {
      util.LOGI("time for system may be  modified manually expireTime " + paramLong + " current " + l, "");
      return true;
    }
    return false;
  }
  
  protected static byte[] packPsBuf(Map<String, byte[]> paramMap, long paramLong, Map<String, Long> paramMap1)
  {
    util.LOGI("pskeyMap " + paramMap.size(), "");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4096);
    localByteBuffer.putShort((short)paramMap.size());
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localByteBuffer.putShort((short)((String)localObject).length());
      localByteBuffer.put(((String)localObject).getBytes());
      byte[] arrayOfByte = (byte[])paramMap.get(localObject);
      localByteBuffer.putShort((short)arrayOfByte.length);
      localByteBuffer.put(arrayOfByte);
      localByteBuffer.putShort((short)-1);
      localObject = (Long)paramMap1.get(localObject);
      if (localObject != null) {
        localByteBuffer.putLong(((Long)localObject).longValue());
      } else {
        localByteBuffer.putLong(86400L + paramLong);
      }
    }
    localByteBuffer.flip();
    paramMap = new byte[localByteBuffer.limit()];
    localByteBuffer.get(paramMap);
    return paramMap;
  }
  
  protected static void parsePsBuf(byte[] paramArrayOfByte, long paramLong, Map<String, byte[]> paramMap, Map<String, Long> paramMap1, boolean paramBoolean)
  {
    Object localObject2 = new StringBuilder().append("ps_buf ");
    Object localObject1;
    if (paramArrayOfByte == null)
    {
      localObject1 = "null";
      util.LOGI(localObject1, "");
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 2)) {
        break label58;
      }
    }
    label58:
    long l2;
    int i;
    int j;
    label102:
    int m;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = Integer.valueOf(paramArrayOfByte.length);
          break;
          l2 = t.f();
          int k = util.buf_to_int16(paramArrayOfByte, 0);
          i = 2;
          util.LOGI("domainCnt " + k, "");
          j = 0;
          if ((j >= k) || (paramArrayOfByte.length < i + 2)) {
            break label362;
          }
          m = util.buf_to_int16(paramArrayOfByte, i);
          i += 2;
        } while (paramArrayOfByte.length < i + m);
        localObject1 = new String(paramArrayOfByte, i, m);
        i = m + i;
      } while (paramArrayOfByte.length < i + 2);
      m = util.buf_to_int16(paramArrayOfByte, i);
      i += 2;
    } while (paramArrayOfByte.length < i + m);
    localObject2 = new byte[m];
    System.arraycopy(paramArrayOfByte, i, localObject2, 0, m);
    i += m;
    long l1;
    if ((paramArrayOfByte.length > i + 2) && (util.buf_to_int16(paramArrayOfByte, i) == 65535))
    {
      i += 2;
      l1 = util.buf_to_int64(paramArrayOfByte, i);
      i += 8;
      label261:
      if (l1 > l2)
      {
        paramMap.put(localObject1, localObject2);
        paramMap1.put(localObject1, Long.valueOf(l1));
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      if (!paramBoolean) {
        break label374;
      }
      ((StringBuilder)localObject2).append(" pskey:");
    }
    for (;;)
    {
      ((StringBuilder)localObject2).append(m).append(",expire: ").append(l1);
      util.LOGI(((StringBuilder)localObject2).toString(), "");
      j += 1;
      break label102;
      label362:
      break;
      l1 = 86400L + paramLong;
      break label261;
      label374:
      ((StringBuilder)localObject2).append(" pt4Token:");
    }
  }
  
  protected static void parseSvrPs(byte[] paramArrayOfByte, long paramLong, Map<String, byte[]> paramMap1, Map<String, Long> paramMap2, Map<String, byte[]> paramMap3, Map<String, Long> paramMap4)
  {
    util.LOGI("pskeyMap " + paramMap1.size() + ", tokenMap " + paramMap3.size() + " create time:" + paramLong, "");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 2)) {}
    for (;;)
    {
      return;
      paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
      int j = paramArrayOfByte.getShort();
      int i = 0;
      while (i < j)
      {
        Object localObject = new byte[paramArrayOfByte.getShort()];
        paramArrayOfByte.get((byte[])localObject);
        localObject = new String((byte[])localObject);
        byte[] arrayOfByte1 = new byte[paramArrayOfByte.getShort()];
        paramArrayOfByte.get(arrayOfByte1);
        byte[] arrayOfByte2 = new byte[paramArrayOfByte.getShort()];
        paramArrayOfByte.get(arrayOfByte2);
        long l = 86400L + paramLong;
        if (arrayOfByte1.length > 0)
        {
          util.LOGI("parseSvrPs add domain " + (String)localObject + " pskey len " + arrayOfByte1.length + " " + l, "");
          paramMap1.put(localObject, arrayOfByte1);
          paramMap2.put(localObject, Long.valueOf(l));
        }
        if (arrayOfByte2.length > 0)
        {
          String str = new String(arrayOfByte2);
          util.LOGI("parseSvrPs add domain " + (String)localObject + " pt4token len " + arrayOfByte2.length + " " + l + " " + str.substring(0, 5) + "***" + str.substring(str.length() - 5), "");
          paramMap3.put(localObject, arrayOfByte2);
          paramMap4.put(localObject, Long.valueOf(l));
        }
        util.LOGI((String)localObject + " pskey:" + arrayOfByte1.length + " pt4token " + arrayOfByte2.length + " expire: " + l, "");
        i += 1;
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getContent()
  {
    if (4096 == this._type) {
      return "skey:" + util.getMaskBytes(this._sig, 2, 2);
    }
    return "";
  }
  
  public String getPSkey(String paramString)
  {
    return __getPskey(paramString, this._pskey_map, this._pskey_expire);
  }
  
  public String getPt4Token(String paramString)
  {
    util.LOGI("getPt4Token get domain " + paramString + " pt4token", "");
    return __getPskey(paramString, this._pt4token_map, this._pt4token_expire);
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this._type = paramParcel.readInt();
    this._sig = paramParcel.createByteArray();
    this._sig_key = paramParcel.createByteArray();
    this._create_time = paramParcel.readLong();
    this._expire_time = paramParcel.readLong();
    this._pskey_map = paramParcel.readHashMap(Map.class.getClassLoader());
    this._pt4token_map = paramParcel.readHashMap(Map.class.getClassLoader());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this._type);
    paramParcel.writeByteArray(this._sig);
    paramParcel.writeByteArray(this._sig_key);
    paramParcel.writeLong(this._create_time);
    paramParcel.writeLong(this._expire_time);
    paramParcel.writeMap(this._pskey_map);
    paramParcel.writeMap(this._pt4token_map);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.Ticket
 * JD-Core Version:    0.7.0.1
 */