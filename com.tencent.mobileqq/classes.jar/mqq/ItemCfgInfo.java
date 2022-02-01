package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class ItemCfgInfo
  extends JceStruct
{
  static Map<Long, String> cache_itemJumUrl = new HashMap();
  public Map<Long, String> itemJumUrl = null;
  public int vipType = 0;
  
  static
  {
    cache_itemJumUrl.put(Long.valueOf(0L), "");
  }
  
  public ItemCfgInfo() {}
  
  public ItemCfgInfo(int paramInt, Map<Long, String> paramMap)
  {
    this.vipType = paramInt;
    this.itemJumUrl = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vipType = paramJceInputStream.read(this.vipType, 0, false);
    this.itemJumUrl = ((Map)paramJceInputStream.read(cache_itemJumUrl, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vipType, 0);
    if (this.itemJumUrl != null) {
      paramJceOutputStream.write(this.itemJumUrl, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MQQ.ItemCfgInfo
 * JD-Core Version:    0.7.0.1
 */