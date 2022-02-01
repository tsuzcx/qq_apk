package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ModifyGroupInfoReq
  extends JceStruct
{
  public long cGroupOption = 0L;
  public long dwGroupClass = 0L;
  public long dwGroupCode = 0L;
  public long dwValidMask = 0L;
  public String strFingerMemo = "";
  public String strGroupMemo = "";
  public String strGroupName = "";
  public String strRichFingerMemo = "";
  public int wGroupFace = 0;
  public int wVersion = 0;
  
  public ModifyGroupInfoReq() {}
  
  public ModifyGroupInfoReq(long paramLong1, long paramLong2, long paramLong3, String paramString1, int paramInt1, String paramString2, String paramString3, long paramLong4, String paramString4, int paramInt2)
  {
    this.dwGroupCode = paramLong1;
    this.cGroupOption = paramLong2;
    this.dwGroupClass = paramLong3;
    this.strGroupName = paramString1;
    this.wGroupFace = paramInt1;
    this.strGroupMemo = paramString2;
    this.strFingerMemo = paramString3;
    this.dwValidMask = paramLong4;
    this.strRichFingerMemo = paramString4;
    this.wVersion = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwGroupCode = paramJceInputStream.read(this.dwGroupCode, 0, true);
    this.cGroupOption = paramJceInputStream.read(this.cGroupOption, 1, true);
    this.dwGroupClass = paramJceInputStream.read(this.dwGroupClass, 2, true);
    this.strGroupName = paramJceInputStream.readString(3, true);
    this.wGroupFace = paramJceInputStream.read(this.wGroupFace, 4, true);
    this.strGroupMemo = paramJceInputStream.readString(5, true);
    this.strFingerMemo = paramJceInputStream.readString(6, true);
    this.dwValidMask = paramJceInputStream.read(this.dwValidMask, 7, false);
    this.strRichFingerMemo = paramJceInputStream.readString(8, false);
    this.wVersion = paramJceInputStream.read(this.wVersion, 9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwGroupCode, 0);
    paramJceOutputStream.write(this.cGroupOption, 1);
    paramJceOutputStream.write(this.dwGroupClass, 2);
    paramJceOutputStream.write(this.strGroupName, 3);
    paramJceOutputStream.write(this.wGroupFace, 4);
    paramJceOutputStream.write(this.strGroupMemo, 5);
    paramJceOutputStream.write(this.strFingerMemo, 6);
    paramJceOutputStream.write(this.dwValidMask, 7);
    String str = this.strRichFingerMemo;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    paramJceOutputStream.write(this.wVersion, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     friendlist.ModifyGroupInfoReq
 * JD-Core Version:    0.7.0.1
 */