package cooperation.qzone.provider;

import java.io.Serializable;
import java.util.ArrayList;

public class LocalPhotoGroupData
  implements Serializable
{
  public String capTime;
  public ArrayList<String> pathList = new ArrayList();
  public String title;
  public String unikey;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("LocalPhotoGroupData{\n");
    localStringBuffer.append("unikey='").append(this.unikey).append('\'').append('\n');
    localStringBuffer.append(", title='").append(this.title).append('\'').append('\n');
    localStringBuffer.append(", capTime='").append(this.capTime).append('\'').append('\n');
    localStringBuffer.append(", pathList=").append(this.pathList).append('\n');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.provider.LocalPhotoGroupData
 * JD-Core Version:    0.7.0.1
 */