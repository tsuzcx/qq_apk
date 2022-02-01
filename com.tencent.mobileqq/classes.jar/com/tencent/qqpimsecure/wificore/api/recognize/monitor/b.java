package com.tencent.qqpimsecure.wificore.api.recognize.monitor;

import java.util.HashMap;

public class b
{
  public static b fF = new b("C1", "识别场景");
  public static b fG = new b("C2", "用户行为");
  public static b fH = new b("C3", "内存总量");
  public static b fI = new b("C4", "内存可用");
  public static b fJ = new b("C5", "cpu最大频率");
  public static b fK = new b("C6", "cpu工作频率");
  public static b fL = new b("C7", "网络类型");
  public static final b fM = new b("C10", "前台——开始执行onCreate()");
  public static final b fN = new b("C11", "前台——完成onResume()");
  public static final b fO = new b("C12", "前台——startRequest()");
  public static final b fP = new b("C13", "前台——开始处理识别结果");
  public static final b fQ = new b("C14", "前台——完成刷新界面");
  public static final b fR = new b("C21", "后台——收到识别请求");
  public static final b fS = new b("C22", "后台——开始准备识别数据");
  public static final b fT = new b("C23", "后台——发起鲨鱼请求");
  public static final b fU = new b("C24", "后台——收到请求结果");
  public static final b fV = new b("C25", "后台——处理请求结果");
  static HashMap<String, b> fW = new HashMap();
  public String fX;
  private String fY;
  
  static
  {
    fW.put(fF.fX, fF);
    fW.put(fG.fX, fG);
    fW.put(fH.fX, fH);
    fW.put(fI.fX, fI);
    fW.put(fJ.fX, fJ);
    fW.put(fK.fX, fK);
    fW.put(fL.fX, fL);
    fW.put(fM.fX, fM);
    fW.put(fN.fX, fN);
    fW.put(fO.fX, fO);
    fW.put(fP.fX, fP);
    fW.put(fQ.fX, fQ);
    fW.put(fR.fX, fR);
    fW.put(fS.fX, fS);
    fW.put(fT.fX, fT);
    fW.put(fU.fX, fU);
    fW.put(fV.fX, fV);
  }
  
  b(String paramString1, String paramString2)
  {
    this.fX = paramString1;
    this.fY = paramString2;
  }
  
  public static String e(String paramString)
  {
    return ((b)fW.get(paramString)).fY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqpimsecure.wificore.api.recognize.monitor.b
 * JD-Core Version:    0.7.0.1
 */