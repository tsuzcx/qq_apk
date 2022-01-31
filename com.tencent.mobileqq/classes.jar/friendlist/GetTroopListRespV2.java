package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetTroopListRespV2
  extends JceStruct
{
  static int cache_result;
  static byte[] cache_vecCookies;
  static ArrayList cache_vecFavGroup;
  static ArrayList cache_vecTroopList;
  static ArrayList cache_vecTroopListDel;
  static ArrayList cache_vecTroopRank;
  public short errorCode;
  public int result;
  public short troopcount;
  public long uin;
  public byte[] vecCookies;
  public ArrayList vecFavGroup;
  public ArrayList vecTroopList;
  public ArrayList vecTroopListDel;
  public ArrayList vecTroopRank;
  
  public GetTroopListRespV2() {}
  
  public GetTroopListRespV2(long paramLong, short paramShort1, int paramInt, short paramShort2, byte[] paramArrayOfByte, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4)
  {
    this.uin = paramLong;
    this.troopcount = paramShort1;
    this.result = paramInt;
    this.errorCode = paramShort2;
    this.vecCookies = paramArrayOfByte;
    this.vecTroopList = paramArrayList1;
    this.vecTroopListDel = paramArrayList2;
    this.vecTroopRank = paramArrayList3;
    this.vecFavGroup = paramArrayList4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.troopcount = paramJceInputStream.read(this.troopcount, 1, true);
    this.result = paramJceInputStream.read(this.result, 2, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 3, false);
    if (cache_vecCookies == null)
    {
      cache_vecCookies = (byte[])new byte[1];
      ((byte[])cache_vecCookies)[0] = 0;
    }
    this.vecCookies = ((byte[])paramJceInputStream.read(cache_vecCookies, 4, false));
    Object localObject;
    if (cache_vecTroopList == null)
    {
      cache_vecTroopList = new ArrayList();
      localObject = new stTroopNum();
      cache_vecTroopList.add(localObject);
    }
    this.vecTroopList = ((ArrayList)paramJceInputStream.read(cache_vecTroopList, 5, false));
    if (cache_vecTroopListDel == null)
    {
      cache_vecTroopListDel = new ArrayList();
      localObject = new stTroopNum();
      cache_vecTroopListDel.add(localObject);
    }
    this.vecTroopListDel = ((ArrayList)paramJceInputStream.read(cache_vecTroopListDel, 6, false));
    if (cache_vecTroopRank == null)
    {
      cache_vecTroopRank = new ArrayList();
      localObject = new stGroupRankInfo();
      cache_vecTroopRank.add(localObject);
    }
    this.vecTroopRank = ((ArrayList)paramJceInputStream.read(cache_vecTroopRank, 7, false));
    if (cache_vecFavGroup == null)
    {
      cache_vecFavGroup = new ArrayList();
      localObject = new stFavoriteGroup();
      cache_vecFavGroup.add(localObject);
    }
    this.vecFavGroup = ((ArrayList)paramJceInputStream.read(cache_vecFavGroup, 8, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.troopcount, 1);
    paramJceOutputStream.write(this.result, 2);
    paramJceOutputStream.write(this.errorCode, 3);
    if (this.vecCookies != null) {
      paramJceOutputStream.write(this.vecCookies, 4);
    }
    if (this.vecTroopList != null) {
      paramJceOutputStream.write(this.vecTroopList, 5);
    }
    if (this.vecTroopListDel != null) {
      paramJceOutputStream.write(this.vecTroopListDel, 6);
    }
    if (this.vecTroopRank != null) {
      paramJceOutputStream.write(this.vecTroopRank, 7);
    }
    if (this.vecFavGroup != null) {
      paramJceOutputStream.write(this.vecFavGroup, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     friendlist.GetTroopListRespV2
 * JD-Core Version:    0.7.0.1
 */