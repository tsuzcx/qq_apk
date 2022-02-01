package photo_share_struct;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class share_attr
  extends JceStruct
{
  static Map<Long, uin_attr> cache_shares_attr = new HashMap();
  public long owner = 0L;
  public Map<Long, uin_attr> shares_attr = null;
  public String source = "";
  
  static
  {
    uin_attr localuin_attr = new uin_attr();
    cache_shares_attr.put(Long.valueOf(0L), localuin_attr);
  }
  
  public share_attr() {}
  
  public share_attr(Map<Long, uin_attr> paramMap, String paramString, long paramLong)
  {
    this.shares_attr = paramMap;
    this.source = paramString;
    this.owner = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shares_attr = ((Map)paramJceInputStream.read(cache_shares_attr, 0, false));
    this.source = paramJceInputStream.readString(1, false);
    this.owner = paramJceInputStream.read(this.owner, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.shares_attr;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 0);
    }
    localObject = this.source;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.owner, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     photo_share_struct.share_attr
 * JD-Core Version:    0.7.0.1
 */