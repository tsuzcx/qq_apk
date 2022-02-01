package dov.com.qq.im.ae.cmshow;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AECMShowRequestController$CmShowDataWrapper
  implements Serializable
{
  public String cmJsonString;
  public Map<String, Integer> dressidMaps;
  public int errorCode;
  public String errorMessage;
  public HashMap<String, String> namePathMap;
  public String rolePath;
  public int sceneMode;
  
  public String toString()
  {
    return "{sceneMode=" + this.sceneMode + ", namePathMap=" + this.namePathMap + ", rolePath=" + this.rolePath + ", dressidMaps=" + this.dressidMaps + ", cmJsonString=" + this.cmJsonString + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.AECMShowRequestController.CmShowDataWrapper
 * JD-Core Version:    0.7.0.1
 */