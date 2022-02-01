package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class stGroupRankInfo
  extends JceStruct
{
  static ArrayList<stLevelRankPair> cache_vecRankMap = new ArrayList();
  static ArrayList<stLevelRankPair> cache_vecRankMapNew;
  public byte cGroupRankSysFlag = 0;
  public byte cGroupRankUserFlag = 0;
  public byte cGroupRankUserFlagNew = 0;
  public long dwGroupCode = 0L;
  public long dwGroupRankSeq = 0L;
  public long dwOfficeMode = 0L;
  public String strAdminName = "";
  public String strOwnerName = "";
  public ArrayList<stLevelRankPair> vecRankMap = null;
  public ArrayList<stLevelRankPair> vecRankMapNew = null;
  
  static
  {
    stLevelRankPair localstLevelRankPair = new stLevelRankPair();
    cache_vecRankMap.add(localstLevelRankPair);
    cache_vecRankMapNew = new ArrayList();
    localstLevelRankPair = new stLevelRankPair();
    cache_vecRankMapNew.add(localstLevelRankPair);
  }
  
  public stGroupRankInfo() {}
  
  public stGroupRankInfo(long paramLong1, byte paramByte1, byte paramByte2, ArrayList<stLevelRankPair> paramArrayList1, long paramLong2, String paramString1, String paramString2, long paramLong3, byte paramByte3, ArrayList<stLevelRankPair> paramArrayList2)
  {
    this.dwGroupCode = paramLong1;
    this.cGroupRankSysFlag = paramByte1;
    this.cGroupRankUserFlag = paramByte2;
    this.vecRankMap = paramArrayList1;
    this.dwGroupRankSeq = paramLong2;
    this.strOwnerName = paramString1;
    this.strAdminName = paramString2;
    this.dwOfficeMode = paramLong3;
    this.cGroupRankUserFlagNew = paramByte3;
    this.vecRankMapNew = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwGroupCode = paramJceInputStream.read(this.dwGroupCode, 0, true);
    this.cGroupRankSysFlag = paramJceInputStream.read(this.cGroupRankSysFlag, 1, false);
    this.cGroupRankUserFlag = paramJceInputStream.read(this.cGroupRankUserFlag, 2, false);
    this.vecRankMap = ((ArrayList)paramJceInputStream.read(cache_vecRankMap, 3, false));
    this.dwGroupRankSeq = paramJceInputStream.read(this.dwGroupRankSeq, 4, false);
    this.strOwnerName = paramJceInputStream.readString(5, false);
    this.strAdminName = paramJceInputStream.readString(6, false);
    this.dwOfficeMode = paramJceInputStream.read(this.dwOfficeMode, 7, false);
    this.cGroupRankUserFlagNew = paramJceInputStream.read(this.cGroupRankUserFlagNew, 8, false);
    this.vecRankMapNew = ((ArrayList)paramJceInputStream.read(cache_vecRankMapNew, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwGroupCode, 0);
    paramJceOutputStream.write(this.cGroupRankSysFlag, 1);
    paramJceOutputStream.write(this.cGroupRankUserFlag, 2);
    Object localObject = this.vecRankMap;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    paramJceOutputStream.write(this.dwGroupRankSeq, 4);
    localObject = this.strOwnerName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.strAdminName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    paramJceOutputStream.write(this.dwOfficeMode, 7);
    paramJceOutputStream.write(this.cGroupRankUserFlagNew, 8);
    localObject = this.vecRankMapNew;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     friendlist.stGroupRankInfo
 * JD-Core Version:    0.7.0.1
 */