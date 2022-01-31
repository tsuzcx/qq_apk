package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ModifyGroupCardResp
  extends JceStruct
{
  static int cache_result = 0;
  static ArrayList<Long> cache_vecUin = new ArrayList();
  public String ErrorString = "";
  public long dwGroupCode;
  public long dwGroupUin;
  public int result;
  public ArrayList<Long> vecUin;
  
  static
  {
    cache_vecUin.add(Long.valueOf(0L));
  }
  
  public ModifyGroupCardResp() {}
  
  public ModifyGroupCardResp(int paramInt, long paramLong1, long paramLong2, ArrayList<Long> paramArrayList, String paramString)
  {
    this.result = paramInt;
    this.dwGroupUin = paramLong1;
    this.dwGroupCode = paramLong2;
    this.vecUin = paramArrayList;
    this.ErrorString = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 0, true);
    this.dwGroupUin = paramJceInputStream.read(this.dwGroupUin, 1, true);
    this.dwGroupCode = paramJceInputStream.read(this.dwGroupCode, 2, true);
    this.vecUin = ((ArrayList)paramJceInputStream.read(cache_vecUin, 3, true));
    this.ErrorString = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 0);
    paramJceOutputStream.write(this.dwGroupUin, 1);
    paramJceOutputStream.write(this.dwGroupCode, 2);
    paramJceOutputStream.write(this.vecUin, 3);
    if (this.ErrorString != null) {
      paramJceOutputStream.write(this.ErrorString, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     friendlist.ModifyGroupCardResp
 * JD-Core Version:    0.7.0.1
 */