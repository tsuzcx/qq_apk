package oicq.wlogin_sdk.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;[B>;
import java.util.Set;
import oicq.wlogin_sdk.report.event.a;
import oicq.wlogin_sdk.report.event.b;
import oicq.wlogin_sdk.tools.util;

public class Ticket
  implements Parcelable
{
  public static final Parcelable.Creator<Ticket> CREATOR = new Ticket.2();
  private static final int EXPIRE_FIELD = 65535;
  private static final int MAX_PSKEY_SIZE = 100;
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
    if (paramArrayOfByte1 == null) {
      paramArrayOfByte1 = new byte[0];
    } else {
      paramArrayOfByte1 = (byte[])paramArrayOfByte1.clone();
    }
    this._sig = paramArrayOfByte1;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    } else {
      paramArrayOfByte1 = (byte[])paramArrayOfByte2.clone();
    }
    this._sig_key = paramArrayOfByte1;
    this._create_time = paramLong1;
    this._expire_time = paramLong2;
  }
  
  public Ticket(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3)
  {
    this._type = paramInt;
    if (paramArrayOfByte1 == null) {
      paramArrayOfByte1 = new byte[0];
    } else {
      paramArrayOfByte1 = (byte[])paramArrayOfByte1.clone();
    }
    this._sig = paramArrayOfByte1;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    } else {
      paramArrayOfByte1 = (byte[])paramArrayOfByte2.clone();
    }
    this._sig_key = paramArrayOfByte1;
    this._create_time = paramLong;
    this._expire_time = (paramLong + 86400L);
    parsePsBuf(paramArrayOfByte3, this._create_time, this._pskey_map, this._pskey_expire, true);
  }
  
  public Ticket(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    this._type = paramInt;
    if (paramArrayOfByte1 == null) {
      paramArrayOfByte1 = new byte[0];
    } else {
      paramArrayOfByte1 = (byte[])paramArrayOfByte1.clone();
    }
    this._sig = paramArrayOfByte1;
    if (paramArrayOfByte2 == null) {
      paramArrayOfByte1 = new byte[0];
    } else {
      paramArrayOfByte1 = (byte[])paramArrayOfByte2.clone();
    }
    this._sig_key = paramArrayOfByte1;
    this._create_time = paramLong;
    this._expire_time = (paramLong + 86400L);
    parsePsBuf(paramArrayOfByte3, this._create_time, this._pskey_map, this._pskey_expire, true);
    parsePsBuf(paramArrayOfByte4, this._create_time, this._pt4token_map, this._pt4token_expire, false);
  }
  
  private Ticket(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  private String __getPskey(String paramString, Map<String, byte[]> paramMap, Map<String, Long> paramMap1)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("__getPskey get domain ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" pskey or pt4token");
    util.LOGI(((StringBuilder)localObject1).toString(), "");
    if (paramMap == null) {
      return null;
    }
    Object localObject2 = (byte[])paramMap.get(paramString);
    if (localObject2 == null)
    {
      paramMap = new StringBuilder();
      paramMap.append("__getPskey get domain ");
      paramMap.append(paramString);
      paramMap.append(" pskey or pt4token null");
      util.LOGI(paramMap.toString(), "");
      return null;
    }
    if (paramMap1 != null)
    {
      localObject1 = (Long)paramMap1.get(paramString);
      if ((localObject1 != null) && (((Long)localObject1).longValue() <= t.f()))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("__getPskey delete domain ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" expired pskey or pt4token expire time ");
        ((StringBuilder)localObject2).append(localObject1);
        util.LOGI(((StringBuilder)localObject2).toString(), "");
        paramMap1.remove(paramString);
        paramMap.remove(paramString);
        return null;
      }
    }
    paramMap = new String((byte[])localObject2);
    paramMap1 = new StringBuilder();
    paramMap1.append("__getPskey get domain ");
    paramMap1.append(paramString);
    paramMap1.append(" pskey or pt4token len ");
    paramMap1.append(paramMap.length());
    paramMap1.append(" ");
    paramMap1.append(paramMap.substring(0, 5));
    paramMap1.append("***");
    paramMap1.append(paramMap.substring(paramMap.length() - 5, paramMap.length()));
    util.LOGI(paramMap1.toString(), "");
    return paramMap;
  }
  
  protected static int calPsBufLength(Map<String, byte[]> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    Map.Entry localEntry;
    for (int i = 2; paramMap.hasNext(); i = i + 2 + ((String)localEntry.getKey()).length() + 2 + ((byte[])localEntry.getValue()).length + 2 + 8) {
      localEntry = (Map.Entry)paramMap.next();
    }
    return i;
  }
  
  private String getPskeyOrPt4tokenContent()
  {
    Iterator localIterator = this._pskey_map.keySet().iterator();
    StringBuilder localStringBuilder;
    for (String str1 = ""; localIterator.hasNext(); str1 = localStringBuilder.toString())
    {
      String str2 = (String)localIterator.next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append(str2);
      localStringBuilder.append(":");
      localStringBuilder.append(util.getMaskBytes((byte[])this._pskey_map.get(str2), 3, 3));
      localStringBuilder.append("|");
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isPskeyStorageExpired expireTime:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("|current: ");
    localStringBuilder.append(l);
    util.LOGI(localStringBuilder.toString(), "");
    return l > paramLong + 86400L;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("time for system may be  modified manually expireTime ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" current ");
      localStringBuilder.append(l);
      util.LOGI(localStringBuilder.toString(), "");
      return true;
    }
    return false;
  }
  
  public static void limitMapSize(int paramInt1, Map<String, byte[]> paramMap, Map<String, Long> paramMap1, int paramInt2)
  {
    Object localObject;
    if (paramInt1 > paramInt2)
    {
      paramMap1 = new a("wtlogin_alarm", "pskey_net_to_much", String.valueOf(paramInt1));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("limitMapSize net domainCnt=");
      ((StringBuilder)localObject).append(paramInt1);
      util.LOGI(((StringBuilder)localObject).toString(), "");
      paramMap.clear();
      paramMap = paramMap1;
    }
    else if (paramMap.size() + paramInt1 > paramInt2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramMap.size());
      localObject = new a("wtlogin_alarm", "pskey_mix_to_much", ((StringBuilder)localObject).toString());
      StringBuilder localStringBuilder = new StringBuilder("limitMapSize mix  domainCnt=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",localKeyMap=");
      localStringBuilder.append(paramMap.size());
      paramMap1 = new ArrayList(paramMap1.entrySet());
      Collections.sort(paramMap1, new Ticket.1());
      paramMap1 = paramMap1.iterator();
      do
      {
        if (!paramMap1.hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)paramMap1.next();
        localStringBuilder.append(",rm key=");
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append(",expire=");
        localStringBuilder.append(localEntry.getValue());
        paramMap.remove(localEntry.getKey());
      } while (paramMap.size() > paramInt2 - paramInt1);
      util.LOGI(localStringBuilder.toString(), "");
      paramMap = (Map<String, byte[]>)localObject;
    }
    else
    {
      paramMap = null;
    }
    if (paramMap != null)
    {
      paramMap.a(true).b(true);
      b.a(paramMap);
    }
  }
  
  public static byte[] packPsBuf(Map<String, byte[]> paramMap, long paramLong, Map<String, Long> paramMap1)
  {
    int i = Math.max(calPsBufLength(paramMap), 4096);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("packPsBuf mapSize=");
    ((StringBuilder)localObject1).append(paramMap.size());
    ((StringBuilder)localObject1).append(",bufLen=");
    ((StringBuilder)localObject1).append(i);
    util.LOGI(((StringBuilder)localObject1).toString(), "");
    localObject1 = ByteBuffer.allocate(i);
    ((ByteBuffer)localObject1).putShort((short)paramMap.size());
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      ((ByteBuffer)localObject1).putShort((short)((String)localObject2).length());
      ((ByteBuffer)localObject1).put(((String)localObject2).getBytes());
      byte[] arrayOfByte = (byte[])paramMap.get(localObject2);
      ((ByteBuffer)localObject1).putShort((short)arrayOfByte.length);
      ((ByteBuffer)localObject1).put(arrayOfByte);
      ((ByteBuffer)localObject1).putShort((short)-1);
      localObject2 = (Long)paramMap1.get(localObject2);
      if (localObject2 != null) {
        ((ByteBuffer)localObject1).putLong(((Long)localObject2).longValue());
      } else {
        ((ByteBuffer)localObject1).putLong(86400L + paramLong);
      }
    }
    ((ByteBuffer)localObject1).flip();
    paramMap = new byte[((ByteBuffer)localObject1).limit()];
    ((ByteBuffer)localObject1).get(paramMap);
    return paramMap;
  }
  
  public static void parsePsBuf(byte[] paramArrayOfByte, long paramLong, Map<String, byte[]> paramMap, Map<String, Long> paramMap1, boolean paramBoolean)
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("ps_buf ");
    Object localObject1;
    if (paramArrayOfByte == null) {
      localObject1 = "null";
    } else {
      localObject1 = Integer.valueOf(paramArrayOfByte.length);
    }
    ((StringBuilder)localObject2).append(localObject1);
    util.LOGI(((StringBuilder)localObject2).toString(), "");
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 2) {
        return;
      }
      long l2 = t.f();
      int k = util.buf_to_int16(paramArrayOfByte, 0);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("domainCnt ");
      ((StringBuilder)localObject1).append(k);
      util.LOGI(((StringBuilder)localObject1).toString(), "");
      int j = 0;
      int i = 2;
      while (j < k)
      {
        int n = paramArrayOfByte.length;
        int m = i + 2;
        if (n < m) {
          return;
        }
        n = util.buf_to_int16(paramArrayOfByte, i);
        int i1 = paramArrayOfByte.length;
        i = m + n;
        if (i1 < i) {
          return;
        }
        localObject1 = new String(paramArrayOfByte, m, n);
        m = paramArrayOfByte.length;
        n = i + 2;
        if (m < n) {
          return;
        }
        m = util.buf_to_int16(paramArrayOfByte, i);
        i1 = paramArrayOfByte.length;
        i = n + m;
        if (i1 < i) {
          return;
        }
        localObject2 = new byte[m];
        System.arraycopy(paramArrayOfByte, n, localObject2, 0, m);
        n = paramArrayOfByte.length;
        i1 = i + 2;
        long l1;
        if ((n > i1) && (util.buf_to_int16(paramArrayOfByte, i) == 65535))
        {
          l1 = util.buf_to_int64(paramArrayOfByte, i1);
          i = i1 + 8;
        }
        else
        {
          l1 = paramLong + 86400L;
        }
        if (l1 > l2)
        {
          paramMap.put(localObject1, localObject2);
          paramMap1.put(localObject1, Long.valueOf(l1));
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        if (paramBoolean) {
          ((StringBuilder)localObject2).append(" pskey:");
        } else {
          ((StringBuilder)localObject2).append(" pt4Token:");
        }
        ((StringBuilder)localObject2).append(m);
        ((StringBuilder)localObject2).append(",expire: ");
        ((StringBuilder)localObject2).append(l1);
        util.LOGI(((StringBuilder)localObject2).toString(), "");
        j += 1;
      }
    }
  }
  
  protected static void parseSvrPs(byte[] paramArrayOfByte, long paramLong, Map<String, byte[]> paramMap1, Map<String, Long> paramMap2, Map<String, byte[]> paramMap3, Map<String, Long> paramMap4)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("pskeyMap ");
    localStringBuilder1.append(paramMap1.size());
    localStringBuilder1.append(", tokenMap ");
    localStringBuilder1.append(paramMap3.size());
    localStringBuilder1.append(" create time:");
    localStringBuilder1.append(paramLong);
    util.LOGI(localStringBuilder1.toString(), "");
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 2) {
        return;
      }
      paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
      int j = paramArrayOfByte.getShort();
      try
      {
        limitMapSize(j, paramMap1, paramMap2, 100);
        limitMapSize(j, paramMap3, paramMap4, 100);
      }
      catch (Exception localException)
      {
        util.printException(localException, "");
      }
      int i = 0;
      while (i < j)
      {
        Object localObject1 = new byte[paramArrayOfByte.getShort()];
        paramArrayOfByte.get((byte[])localObject1);
        localObject1 = new String((byte[])localObject1);
        byte[] arrayOfByte1 = new byte[paramArrayOfByte.getShort()];
        paramArrayOfByte.get(arrayOfByte1);
        byte[] arrayOfByte2 = new byte[paramArrayOfByte.getShort()];
        paramArrayOfByte.get(arrayOfByte2);
        long l = 86400L + paramLong;
        if (arrayOfByte1.length > 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("parseSvrPs add domain ");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(" pskey len ");
          ((StringBuilder)localObject2).append(arrayOfByte1.length);
          ((StringBuilder)localObject2).append(" ");
          ((StringBuilder)localObject2).append(l);
          util.LOGI(((StringBuilder)localObject2).toString(), "");
          paramMap1.put(localObject1, arrayOfByte1);
          paramMap2.put(localObject1, Long.valueOf(l));
        }
        if (arrayOfByte2.length > 0)
        {
          localObject2 = new String(arrayOfByte2);
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("parseSvrPs add domain ");
          localStringBuilder2.append((String)localObject1);
          localStringBuilder2.append(" pt4token len ");
          localStringBuilder2.append(arrayOfByte2.length);
          localStringBuilder2.append(" ");
          localStringBuilder2.append(l);
          localStringBuilder2.append(" ");
          localStringBuilder2.append(((String)localObject2).substring(0, 5));
          localStringBuilder2.append("***");
          localStringBuilder2.append(((String)localObject2).substring(((String)localObject2).length() - 5));
          util.LOGI(localStringBuilder2.toString(), "");
          paramMap3.put(localObject1, arrayOfByte2);
          paramMap4.put(localObject1, Long.valueOf(l));
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" pskey:");
        ((StringBuilder)localObject2).append(arrayOfByte1.length);
        ((StringBuilder)localObject2).append(" pt4token ");
        ((StringBuilder)localObject2).append(arrayOfByte2.length);
        ((StringBuilder)localObject2).append(" expire: ");
        ((StringBuilder)localObject2).append(l);
        util.LOGI(((StringBuilder)localObject2).toString(), "");
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
    if (4096 == this._type)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("skey:");
      localStringBuilder.append(util.getMaskBytes(this._sig, 2, 2));
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public String getPSkey(String paramString)
  {
    return __getPskey(paramString, this._pskey_map, this._pskey_expire);
  }
  
  public String getPt4Token(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getPt4Token get domain ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" pt4token");
    util.LOGI(localStringBuilder.toString(), "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.Ticket
 * JD-Core Version:    0.7.0.1
 */