package mqq_qstar;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class QStarInfoRsp
  extends JceStruct
{
  static ArrayList<QStarInfoItem> cache_followlist;
  public int cmd = 0;
  public int follow_xylm = 0;
  public ArrayList<QStarInfoItem> followlist = null;
  public String jumpurl = "";
  public String logourl = "";
  public int ret = 0;
  public int seq = 0;
  public int ver = 0;
  
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
    Object localObject = this.jumpurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.logourl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.followlist;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq_qstar.QStarInfoRsp
 * JD-Core Version:    0.7.0.1
 */