package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetFriendListReq
  extends JceStruct
{
  static int cache_eAppType;
  static int cache_reqtype = 0;
  static ArrayList<Long> cache_uinList = new ArrayList();
  static byte[] cache_vec0xd50Req;
  static byte[] cache_vec0xd6bReq;
  static ArrayList<Long> cache_vecSnsTypelist;
  public int eAppType = 0;
  public short getfriendCount = 0;
  public byte getgroupCount = 0;
  public byte groupid = 0;
  public byte groupstartIndex = 0;
  public byte ifGetBothFlag = 0;
  public byte ifGetDOVId = 0;
  public byte ifGetGroupInfo = 0;
  public byte ifGetMSFGroup = 0;
  public byte ifReflush = 0;
  public byte ifShowTermType = 0;
  public int reqtype = 0;
  public short startIndex = 0;
  public long uin = 0L;
  public ArrayList<Long> uinList = null;
  public byte[] vec0xd50Req = null;
  public byte[] vec0xd6bReq = null;
  public ArrayList<Long> vecSnsTypelist = null;
  public long version = 0L;
  
  static
  {
    cache_uinList.add(Long.valueOf(0L));
    cache_eAppType = 0;
    cache_vec0xd50Req = (byte[])new byte[1];
    ((byte[])cache_vec0xd50Req)[0] = 0;
    cache_vec0xd6bReq = (byte[])new byte[1];
    ((byte[])cache_vec0xd6bReq)[0] = 0;
    cache_vecSnsTypelist = new ArrayList();
    cache_vecSnsTypelist.add(Long.valueOf(0L));
  }
  
  public GetFriendListReq() {}
  
  public GetFriendListReq(int paramInt1, byte paramByte1, long paramLong1, short paramShort1, short paramShort2, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, long paramLong2, ArrayList<Long> paramArrayList1, int paramInt2, byte paramByte8, byte paramByte9, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, ArrayList<Long> paramArrayList2)
  {
    this.reqtype = paramInt1;
    this.ifReflush = paramByte1;
    this.uin = paramLong1;
    this.startIndex = paramShort1;
    this.getfriendCount = paramShort2;
    this.groupid = paramByte2;
    this.ifGetGroupInfo = paramByte3;
    this.groupstartIndex = paramByte4;
    this.getgroupCount = paramByte5;
    this.ifGetMSFGroup = paramByte6;
    this.ifShowTermType = paramByte7;
    this.version = paramLong2;
    this.uinList = paramArrayList1;
    this.eAppType = paramInt2;
    this.ifGetDOVId = paramByte8;
    this.ifGetBothFlag = paramByte9;
    this.vec0xd50Req = paramArrayOfByte1;
    this.vec0xd6bReq = paramArrayOfByte2;
    this.vecSnsTypelist = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reqtype = paramJceInputStream.read(this.reqtype, 0, true);
    this.ifReflush = paramJceInputStream.read(this.ifReflush, 1, true);
    this.uin = paramJceInputStream.read(this.uin, 2, true);
    this.startIndex = paramJceInputStream.read(this.startIndex, 3, true);
    this.getfriendCount = paramJceInputStream.read(this.getfriendCount, 4, true);
    this.groupid = paramJceInputStream.read(this.groupid, 5, false);
    this.ifGetGroupInfo = paramJceInputStream.read(this.ifGetGroupInfo, 6, true);
    this.groupstartIndex = paramJceInputStream.read(this.groupstartIndex, 7, false);
    this.getgroupCount = paramJceInputStream.read(this.getgroupCount, 8, false);
    this.ifGetMSFGroup = paramJceInputStream.read(this.ifGetMSFGroup, 9, false);
    this.ifShowTermType = paramJceInputStream.read(this.ifShowTermType, 10, false);
    this.version = paramJceInputStream.read(this.version, 11, false);
    this.uinList = ((ArrayList)paramJceInputStream.read(cache_uinList, 12, false));
    this.eAppType = paramJceInputStream.read(this.eAppType, 13, false);
    this.ifGetDOVId = paramJceInputStream.read(this.ifGetDOVId, 14, false);
    this.ifGetBothFlag = paramJceInputStream.read(this.ifGetBothFlag, 15, false);
    this.vec0xd50Req = ((byte[])paramJceInputStream.read(cache_vec0xd50Req, 16, false));
    this.vec0xd6bReq = ((byte[])paramJceInputStream.read(cache_vec0xd6bReq, 17, false));
    this.vecSnsTypelist = ((ArrayList)paramJceInputStream.read(cache_vecSnsTypelist, 18, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.reqtype, 0);
    paramJceOutputStream.write(this.ifReflush, 1);
    paramJceOutputStream.write(this.uin, 2);
    paramJceOutputStream.write(this.startIndex, 3);
    paramJceOutputStream.write(this.getfriendCount, 4);
    paramJceOutputStream.write(this.groupid, 5);
    paramJceOutputStream.write(this.ifGetGroupInfo, 6);
    paramJceOutputStream.write(this.groupstartIndex, 7);
    paramJceOutputStream.write(this.getgroupCount, 8);
    paramJceOutputStream.write(this.ifGetMSFGroup, 9);
    paramJceOutputStream.write(this.ifShowTermType, 10);
    paramJceOutputStream.write(this.version, 11);
    if (this.uinList != null) {
      paramJceOutputStream.write(this.uinList, 12);
    }
    paramJceOutputStream.write(this.eAppType, 13);
    paramJceOutputStream.write(this.ifGetDOVId, 14);
    paramJceOutputStream.write(this.ifGetBothFlag, 15);
    if (this.vec0xd50Req != null) {
      paramJceOutputStream.write(this.vec0xd50Req, 16);
    }
    if (this.vec0xd6bReq != null) {
      paramJceOutputStream.write(this.vec0xd6bReq, 17);
    }
    if (this.vecSnsTypelist != null) {
      paramJceOutputStream.write(this.vecSnsTypelist, 18);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     friendlist.GetFriendListReq
 * JD-Core Version:    0.7.0.1
 */