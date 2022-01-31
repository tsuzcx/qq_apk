package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stAlbumAbiInfo
  extends JceStruct
{
  public long dwFriendUin;
  
  public stAlbumAbiInfo() {}
  
  public stAlbumAbiInfo(long paramLong)
  {
    this.dwFriendUin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwFriendUin = paramJceInputStream.read(this.dwFriendUin, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwFriendUin, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     friendlist.stAlbumAbiInfo
 * JD-Core Version:    0.7.0.1
 */