package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class GetTroopListRespV2
  extends JceStruct
{
  static int cache_result;
  static byte[] cache_vecCookies = (byte[])new byte[1];
  static ArrayList<stFavoriteGroup> cache_vecFavGroup;
  static ArrayList<Long> cache_vecGroupInfoExt;
  static ArrayList<stTroopNum> cache_vecTroopList;
  static ArrayList<stTroopNum> cache_vecTroopListDel;
  static ArrayList<stTroopNum> cache_vecTroopListExt;
  static ArrayList<stGroupRankInfo> cache_vecTroopRank;
  public short errorCode = 0;
  public int result = 0;
  public short troopcount = 0;
  public long uin = 0L;
  public byte[] vecCookies = null;
  public ArrayList<stFavoriteGroup> vecFavGroup = null;
  public ArrayList<Long> vecGroupInfoExt = null;
  public ArrayList<stTroopNum> vecTroopList = null;
  public ArrayList<stTroopNum> vecTroopListDel = null;
  public ArrayList<stTroopNum> vecTroopListExt = null;
  public ArrayList<stGroupRankInfo> vecTroopRank = null;
  
  static
  {
    ((byte[])cache_vecCookies)[0] = 0;
    cache_vecTroopList = new ArrayList();
    Object localObject = new stTroopNum();
    cache_vecTroopList.add(localObject);
    cache_vecTroopListDel = new ArrayList();
    localObject = new stTroopNum();
    cache_vecTroopListDel.add(localObject);
    cache_vecTroopRank = new ArrayList();
    localObject = new stGroupRankInfo();
    cache_vecTroopRank.add(localObject);
    cache_vecFavGroup = new ArrayList();
    localObject = new stFavoriteGroup();
    cache_vecFavGroup.add(localObject);
    cache_vecTroopListExt = new ArrayList();
    localObject = new stTroopNum();
    cache_vecTroopListExt.add(localObject);
    cache_vecGroupInfoExt = new ArrayList();
    cache_vecGroupInfoExt.add(Long.valueOf(0L));
  }
  
  public GetTroopListRespV2() {}
  
  public GetTroopListRespV2(long paramLong, short paramShort1, int paramInt, short paramShort2, byte[] paramArrayOfByte, ArrayList<stTroopNum> paramArrayList1, ArrayList<stTroopNum> paramArrayList2, ArrayList<stGroupRankInfo> paramArrayList, ArrayList<stFavoriteGroup> paramArrayList3, ArrayList<stTroopNum> paramArrayList4, ArrayList<Long> paramArrayList5)
  {
    this.uin = paramLong;
    this.troopcount = paramShort1;
    this.result = paramInt;
    this.errorCode = paramShort2;
    this.vecCookies = paramArrayOfByte;
    this.vecTroopList = paramArrayList1;
    this.vecTroopListDel = paramArrayList2;
    this.vecTroopRank = paramArrayList;
    this.vecFavGroup = paramArrayList3;
    this.vecTroopListExt = paramArrayList4;
    this.vecGroupInfoExt = paramArrayList5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.troopcount = paramJceInputStream.read(this.troopcount, 1, true);
    this.result = paramJceInputStream.read(this.result, 2, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 3, false);
    this.vecCookies = ((byte[])paramJceInputStream.read(cache_vecCookies, 4, false));
    this.vecTroopList = ((ArrayList)paramJceInputStream.read(cache_vecTroopList, 5, false));
    this.vecTroopListDel = ((ArrayList)paramJceInputStream.read(cache_vecTroopListDel, 6, false));
    this.vecTroopRank = ((ArrayList)paramJceInputStream.read(cache_vecTroopRank, 7, false));
    this.vecFavGroup = ((ArrayList)paramJceInputStream.read(cache_vecFavGroup, 8, false));
    this.vecTroopListExt = ((ArrayList)paramJceInputStream.read(cache_vecTroopListExt, 9, false));
    this.vecGroupInfoExt = ((ArrayList)paramJceInputStream.read(cache_vecGroupInfoExt, 10, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.troopcount, 1);
    paramJceOutputStream.write(this.result, 2);
    paramJceOutputStream.write(this.errorCode, 3);
    Object localObject = this.vecCookies;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 4);
    }
    localObject = this.vecTroopList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 5);
    }
    localObject = this.vecTroopListDel;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 6);
    }
    localObject = this.vecTroopRank;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 7);
    }
    localObject = this.vecFavGroup;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 8);
    }
    localObject = this.vecTroopListExt;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 9);
    }
    localObject = this.vecGroupInfoExt;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     friendlist.GetTroopListRespV2
 * JD-Core Version:    0.7.0.1
 */