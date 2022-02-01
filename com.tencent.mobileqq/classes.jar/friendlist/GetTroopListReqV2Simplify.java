package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class GetTroopListReqV2Simplify
  extends JceStruct
{
  static byte[] cache_vecCookies = (byte[])new byte[1];
  static ArrayList<stTroopNumSimplify> cache_vecGroupInfo;
  public byte bGetLongGroupName = 0;
  public byte bGetMSFMsgFlag = 0;
  public byte bGroupFlagExt = 0;
  public long dwCompanyId = 0L;
  public int shVersion = 0;
  public long uin = 0L;
  public byte[] vecCookies = null;
  public ArrayList<stTroopNumSimplify> vecGroupInfo = null;
  public long versionNum = 0L;
  
  static
  {
    ((byte[])cache_vecCookies)[0] = 0;
    cache_vecGroupInfo = new ArrayList();
    stTroopNumSimplify localstTroopNumSimplify = new stTroopNumSimplify();
    cache_vecGroupInfo.add(localstTroopNumSimplify);
  }
  
  public GetTroopListReqV2Simplify() {}
  
  public GetTroopListReqV2Simplify(long paramLong1, byte paramByte1, byte[] paramArrayOfByte, ArrayList<stTroopNumSimplify> paramArrayList, byte paramByte2, int paramInt, long paramLong2, long paramLong3, byte paramByte3)
  {
    this.uin = paramLong1;
    this.bGetMSFMsgFlag = paramByte1;
    this.vecCookies = paramArrayOfByte;
    this.vecGroupInfo = paramArrayList;
    this.bGroupFlagExt = paramByte2;
    this.shVersion = paramInt;
    this.dwCompanyId = paramLong2;
    this.versionNum = paramLong3;
    this.bGetLongGroupName = paramByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.bGetMSFMsgFlag = paramJceInputStream.read(this.bGetMSFMsgFlag, 1, false);
    this.vecCookies = ((byte[])paramJceInputStream.read(cache_vecCookies, 2, false));
    this.vecGroupInfo = ((ArrayList)paramJceInputStream.read(cache_vecGroupInfo, 3, false));
    this.bGroupFlagExt = paramJceInputStream.read(this.bGroupFlagExt, 4, false);
    this.shVersion = paramJceInputStream.read(this.shVersion, 5, false);
    this.dwCompanyId = paramJceInputStream.read(this.dwCompanyId, 6, false);
    this.versionNum = paramJceInputStream.read(this.versionNum, 7, false);
    this.bGetLongGroupName = paramJceInputStream.read(this.bGetLongGroupName, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.bGetMSFMsgFlag, 1);
    Object localObject = this.vecCookies;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 2);
    }
    localObject = this.vecGroupInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    paramJceOutputStream.write(this.bGroupFlagExt, 4);
    paramJceOutputStream.write(this.shVersion, 5);
    paramJceOutputStream.write(this.dwCompanyId, 6);
    paramJceOutputStream.write(this.versionNum, 7);
    paramJceOutputStream.write(this.bGetLongGroupName, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     friendlist.GetTroopListReqV2Simplify
 * JD-Core Version:    0.7.0.1
 */