package mqq_qstar;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class QStarInfoRsp
  extends JceStruct
{
  static ArrayList<QStarInfoItem> cache_followlist;
  public int cmd;
  public int follow_xylm;
  public ArrayList<QStarInfoItem> followlist;
  public String jumpurl = "";
  public String logourl = "";
  public int ret;
  public int seq;
  public int ver;
  
  public QStarInfoRsp() {}
  
  public QStarInfoRsp(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2, ArrayList<QStarInfoItem> paramArrayList)
  {
    this.ver = paramInt1;
    this.seq = paramInt2;
    this.cmd = paramInt3;
    this.ret = paramInt4;
    this.follow_xylm = paramInt5;
    this.jumpurl = paramString1;
    this.logourl = paramString2;
    this.followlist = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ver = paramJceInputStream.read(this.ver, 0, false);
    this.seq = paramJceInputStream.read(this.seq, 1, false);
    this.cmd = paramJceInputStream.read(this.cmd, 2, false);
    this.ret = paramJceInputStream.read(this.ret, 3, false);
    this.follow_xylm = paramJceInputStream.read(this.follow_xylm, 4, false);
    this.jumpurl = paramJceInputStream.readString(5, false);
    this.logourl = paramJceInputStream.readString(6, false);
    if (cache_followlist == null)
    {
      cache_followlist = new ArrayList();
      QStarInfoItem localQStarInfoItem = new QStarInfoItem();
      cache_followlist.add(localQStarInfoItem);
    }
    this.followlist = ((ArrayList)paramJceInputStream.read(cache_followlist, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ver, 0);
    paramJceOutputStream.write(this.seq, 1);
    paramJceOutputStream.write(this.cmd, 2);
    paramJceOutputStream.write(this.ret, 3);
    paramJceOutputStream.write(this.follow_xylm, 4);
    if (this.jumpurl != null) {
      paramJceOutputStream.write(this.jumpurl, 5);
    }
    if (this.logourl != null) {
      paramJceOutputStream.write(this.logourl, 6);
    }
    if (this.followlist != null) {
      paramJceOutputStream.write(this.followlist, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mqq_qstar.QStarInfoRsp
 * JD-Core Version:    0.7.0.1
 */