package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetTroopMemberListResp
  extends JceStruct
{
  static int cache_result = 0;
  static ArrayList cache_vecTroopMember = new ArrayList();
  public long GroupCode;
  public long GroupUin;
  public long NextGetTime;
  public long NextUin;
  public short errorCode;
  public long office_mode;
  public int result;
  public long uin;
  public ArrayList vecTroopMember;
  
  static
  {
    stTroopMemberInfo localstTroopMemberInfo = new stTroopMemberInfo();
    cache_vecTroopMember.add(localstTroopMemberInfo);
  }
  
  public GetTroopMemberListResp() {}
  
  public GetTroopMemberListResp(long paramLong1, long paramLong2, long paramLong3, ArrayList paramArrayList, long paramLong4, int paramInt, short paramShort, long paramLong5, long paramLong6)
  {
    this.uin = paramLong1;
    this.GroupCode = paramLong2;
    this.GroupUin = paramLong3;
    this.vecTroopMember = paramArrayList;
    this.NextUin = paramLong4;
    this.result = paramInt;
    this.errorCode = paramShort;
    this.office_mode = paramLong5;
    this.NextGetTime = paramLong6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.GroupCode = paramJceInputStream.read(this.GroupCode, 1, true);
    this.GroupUin = paramJceInputStream.read(this.GroupUin, 2, true);
    this.vecTroopMember = ((ArrayList)paramJceInputStream.read(cache_vecTroopMember, 3, true));
    this.NextUin = paramJceInputStream.read(this.NextUin, 4, true);
    this.result = paramJceInputStream.read(this.result, 5, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 6, false);
    this.office_mode = paramJceInputStream.read(this.office_mode, 7, false);
    this.NextGetTime = paramJceInputStream.read(this.NextGetTime, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.GroupCode, 1);
    paramJceOutputStream.write(this.GroupUin, 2);
    paramJceOutputStream.write(this.vecTroopMember, 3);
    paramJceOutputStream.write(this.NextUin, 4);
    paramJceOutputStream.write(this.result, 5);
    paramJceOutputStream.write(this.errorCode, 6);
    paramJceOutputStream.write(this.office_mode, 7);
    paramJceOutputStream.write(this.NextGetTime, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     friendlist.GetTroopMemberListResp
 * JD-Core Version:    0.7.0.1
 */