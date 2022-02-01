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
    HashMap localHashMap = fW;
    b localb = fF;
    localHashMap.put(localb.fX, localb);
    localHashMap = fW;
    localb = fG;
    localHashMap.put(localb.fX, localb);
    localHashMap = fW;
    localb = fH;
    localHashMap.put(localb.fX, localb);
    localHashMap = fW;
    localb = fI;
    localHashMap.put(localb.fX, localb);
    localHashMap = fW;
    localb = fJ;
    localHashMap.put(localb.fX, localb);
    localHashMap = fW;
    localb = fK;
    localHashMap.put(localb.fX, localb);
    localHashMap = fW;
    localb = fL;
    localHashMap.put(localb.fX, localb);
    localHashMap = fW;
    localb = fM;
    localHashMap.put(localb.fX, localb);
    localHashMap = fW;
    localb = fN;
    localHashMap.put(localb.fX, localb);
    localHashMap = fW;
    localb = fO;
    localHashMap.put(localb.fX, localb);
    localHashMap = fW;
    localb = fP;
    localHashMap.put(localb.fX, localb);
    localHashMap = fW;
    localb = fQ;
    localHashMap.put(localb.fX, localb);
    localHashMap = fW;
    localb = fR;
    localHashMap.put(localb.fX, localb);
    localHashMap = fW;
    localb = fS;
    localHashMap.put(localb.fX, localb);
    localHashMap = fW;
    localb = fT;
    localHashMap.put(localb.fX, localb);
    localHashMap = fW;
    localb = fU;
    localHashMap.put(localb.fX, localb);
    localHashMap = fW;
    localb = fV;
    localHashMap.put(localb.fX, localb);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqpimsecure.wificore.api.recognize.monitor.b
 * JD-Core Version:    0.7.0.1
 */