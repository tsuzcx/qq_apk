package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ItemCfgList
  extends JceStruct
{
  static ArrayList<ItemCfgInfo> cache_itemCfgInfo = new ArrayList();
  public long iItemCfgVer = 0L;
  public ArrayList<ItemCfgInfo> itemCfgInfo = null;
  
  static
  {
    ItemCfgInfo localItemCfgInfo = new ItemCfgInfo();
    cache_itemCfgInfo.add(localItemCfgInfo);
  }
  
  public ItemCfgList() {}
  
  public ItemCfgList(long paramLong, ArrayList<ItemCfgInfo> paramArrayList)
  {
    this.iItemCfgVer = paramLong;
    this.itemCfgInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemCfgVer = paramJceInputStream.read(this.iItemCfgVer, 0, false);
    this.itemCfgInfo = ((ArrayList)paramJceInputStream.read(cache_itemCfgInfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemCfgVer, 0);
    if (this.itemCfgInfo != null) {
      paramJceOutputStream.write(this.itemCfgInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MQQ.ItemCfgList
 * JD-Core Version:    0.7.0.1
 */