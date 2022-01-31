package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetTroopAppointRemarkReq
  extends JceStruct
{
  static ArrayList<Long> cache_vecUinList = new ArrayList();
  public long GroupCode;
  public long GroupUin;
  public byte cRichCardNameVer;
  public byte cRichInfo;
  public long uin;
  public ArrayList<Long> vecUinList;
  
  static
  {
    cache_vecUinList.add(Long.valueOf(0L));
  }
  
  public GetTroopAppointRemarkReq() {}
  
  public GetTroopAppointRemarkReq(long paramLong1, long paramLong2, long paramLong3, ArrayList<Long> paramArrayList, byte paramByte1, byte paramByte2)
  {
    this.uin = paramLong1;
    this.GroupCode = paramLong2;
    this.GroupUin = paramLong3;
    this.vecUinList = paramArrayList;
    this.cRichInfo = paramByte1;
    this.cRichCardNameVer = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.GroupCode = paramJceInputStream.read(this.GroupCode, 1, true);
    this.GroupUin = paramJceInputStream.read(this.GroupUin, 3, true);
    this.vecUinList = ((ArrayList)paramJceInputStream.read(cache_vecUinList, 4, true));
    this.cRichInfo = paramJceInputStream.read(this.cRichInfo, 5, false);
    this.cRichCardNameVer = paramJceInputStream.read(this.cRichCardNameVer, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.GroupCode, 1);
    paramJceOutputStream.write(this.GroupUin, 3);
    paramJceOutputStream.write(this.vecUinList, 4);
    paramJceOutputStream.write(this.cRichInfo, 5);
    paramJceOutputStream.write(this.cRichCardNameVer, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     friendlist.GetTroopAppointRemarkReq
 * JD-Core Version:    0.7.0.1
 */