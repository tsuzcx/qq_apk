package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DataReturnFlag
  extends JceStruct
{
  public int has_priv_base;
  public String trace_info = "";
  
  public DataReturnFlag() {}
  
  public DataReturnFlag(String paramString, int paramInt)
  {
    this.trace_info = paramString;
    this.has_priv_base = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.trace_info = paramJceInputStream.readString(0, false);
    this.has_priv_base = paramJceInputStream.read(this.has_priv_base, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.trace_info != null) {
      paramJceOutputStream.write(this.trace_info, 0);
    }
    paramJceOutputStream.write(this.has_priv_base, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MQQ.DataReturnFlag
 * JD-Core Version:    0.7.0.1
 */