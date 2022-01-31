package com.tencent.mobileqq.jsp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FaceDetectForThirdPartyManager$AppConf
  implements Serializable
{
  public final List<FaceDetectForThirdPartyManager.AppWordings> al;
  public final String appName;
  public String colorSequence;
  public String debug;
  public String errMsg;
  public final int mode;
  public int ret;
  public String session;
  
  public FaceDetectForThirdPartyManager$AppConf(String paramString, List<FaceDetectForThirdPartyManager.AppWordings> paramList, int paramInt)
  {
    this.appName = paramString;
    this.al = new ArrayList(3);
    this.al.addAll(paramList);
    this.mode = paramInt;
  }
  
  public String toString()
  {
    return "appName=" + this.appName + " mode=" + this.mode + " colorSe=" + this.colorSequence + " session=" + this.session + " ret=" + this.ret + " errMsg=" + this.errMsg + " debug=" + this.debug;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf
 * JD-Core Version:    0.7.0.1
 */