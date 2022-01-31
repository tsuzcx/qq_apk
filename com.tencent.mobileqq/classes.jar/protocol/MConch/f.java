package Protocol.MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class f
  extends JceStruct
{
  static ArrayList<String> bz = new ArrayList();
  public ArrayList<String> by = null;
  
  static
  {
    bz.add("");
  }
  
  public JceStruct newInit()
  {
    return new f();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.by = ((ArrayList)paramJceInputStream.read(bz, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.by != null) {
      paramJceOutputStream.write(this.by, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     Protocol.MConch.f
 * JD-Core Version:    0.7.0.1
 */