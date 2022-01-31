package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetResourceReqV2
  extends JceStruct
{
  static ArrayList cache_vecResReqInfo;
  public int iAppid;
  public int iPluginType = 64;
  public String strModel = "";
  public ArrayList vecResReqInfo;
  
  public GetResourceReqV2() {}
  
  public GetResourceReqV2(ArrayList paramArrayList, int paramInt1, String paramString, int paramInt2)
  {
    this.vecResReqInfo = paramArrayList;
    this.iPluginType = paramInt1;
    this.strModel = paramString;
    this.iAppid = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecResReqInfo == null)
    {
      cache_vecResReqInfo = new ArrayList();
      GetResourceReqInfoV2 localGetResourceReqInfoV2 = new GetResourceReqInfoV2();
      cache_vecResReqInfo.add(localGetResourceReqInfoV2);
    }
    this.vecResReqInfo = ((ArrayList)paramJceInputStream.read(cache_vecResReqInfo, 1, true));
    this.iPluginType = paramJceInputStream.read(this.iPluginType, 2, false);
    this.strModel = paramJceInputStream.readString(3, false);
    this.iAppid = paramJceInputStream.read(this.iAppid, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecResReqInfo, 1);
    paramJceOutputStream.write(this.iPluginType, 2);
    if (this.strModel != null) {
      paramJceOutputStream.write(this.strModel, 3);
    }
    paramJceOutputStream.write(this.iAppid, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     protocol.KQQConfig.GetResourceReqV2
 * JD-Core Version:    0.7.0.1
 */