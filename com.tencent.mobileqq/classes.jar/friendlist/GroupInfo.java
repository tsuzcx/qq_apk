package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GroupInfo
  extends JceStruct
{
  public int friend_count;
  public byte groupId;
  public String groupname = "";
  public int online_friend_count;
  public byte seqid;
  public int sqqOnLine_count;
  
  public GroupInfo() {}
  
  public GroupInfo(byte paramByte1, String paramString, int paramInt1, int paramInt2, byte paramByte2, int paramInt3)
  {
    this.groupId = paramByte1;
    this.groupname = paramString;
    this.friend_count = paramInt1;
    this.online_friend_count = paramInt2;
    this.seqid = paramByte2;
    this.sqqOnLine_count = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.groupId = paramJceInputStream.read(this.groupId, 0, true);
    this.groupname = paramJceInputStream.readString(1, true);
    this.friend_count = paramJceInputStream.read(this.friend_count, 2, true);
    this.online_friend_count = paramJceInputStream.read(this.online_friend_count, 3, true);
    this.seqid = paramJceInputStream.read(this.seqid, 4, false);
    this.sqqOnLine_count = paramJceInputStream.read(this.sqqOnLine_count, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.groupId, 0);
    paramJceOutputStream.write(this.groupname, 1);
    paramJceOutputStream.write(this.friend_count, 2);
    paramJceOutputStream.write(this.online_friend_count, 3);
    paramJceOutputStream.write(this.seqid, 4);
    paramJceOutputStream.write(this.sqqOnLine_count, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     friendlist.GroupInfo
 * JD-Core Version:    0.7.0.1
 */