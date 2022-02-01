package com.tencent.mobileqq.qmcf.processor;

import com.tencent.mobileqq.qmcf.QMCF;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.QmcfModelItem;
import com.tencent.mobileqq.qmcf.QmcfReporter;
import com.tencent.sveffects.SLog;
import java.util.HashMap;

public class BaseQmcfProcessor
{
  public static final String INIT_ERROR = "InitError";
  public static final String LINK_ERROR = "UnsatisfiedLinkError";
  public static final String RES_ERROR = "ResError";
  public static final String SUCCESS = "success";
  protected static volatile Object mNativeLock = new Object();
  protected static QMCF qmcfLinker = new QMCF();
  protected static QmcfManager qmcfManager = QmcfManager.getInstance();
  protected String TAG = "BaseQmcfProcessor";
  private int inputHeight;
  private int inputWidth;
  private long processCost = 0L;
  private String processResult = "";
  private boolean processorDestroyed = true;
  private long startPorcessTime = 0L;
  
  public String doDestroy()
  {
    this.processorDestroyed = true;
    return modelDestroy();
  }
  
  public void doInit()
  {
    Object localObject1;
    long l1;
    if ((!this.processorDestroyed) && (!qmcfManager.modeChanged))
    {
      if (qmcfManager.modelSwitched)
      {
        localObject1 = qmcfManager;
        ((QmcfManager)localObject1).modelSwitched = false;
        localObject1 = ((QmcfManager)localObject1).getQmcfModelItem();
        if (localObject1 != null)
        {
          l1 = System.currentTimeMillis();
          boolean bool = modelSwitch((QmcfModelItem)localObject1);
          if (SLog.isEnable()) {
            SLog.d(this.TAG, String.format("switchModel result[%s], cost[%s]", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l1) }));
          }
        }
        else
        {
          SLog.i(this.TAG, "error occur while switchModel!");
        }
      }
      return;
    }
    if (SLog.isEnable()) {
      SLog.d(this.TAG, String.format("initProcessor processorDestroyed[%s], modeChanged[%s]", new Object[] { Boolean.valueOf(this.processorDestroyed), Boolean.valueOf(qmcfManager.modeChanged) }));
    }
    int i = qmcfManager.getCurrQmcfMode();
    int j = qmcfManager.getCurrFrameType();
    long l3;
    long l2;
    if (QmcfManager.getInstance().hasQmcfEntrance(i, true))
    {
      l3 = -1L;
      l1 = l3;
      l2 = l3;
    }
    for (;;)
    {
      try
      {
        long l4 = System.currentTimeMillis();
        l1 = l3;
        l2 = l3;
        qmcfManager.checkPathValid();
        l1 = l3;
        l2 = l3;
        qmcfManager.setQmcfRunSupported(false, true, i);
        l1 = l3;
        l2 = l3;
        localObject1 = qmcfManager.getQmcfModelItem();
        if (localObject1 == null) {
          break label585;
        }
        l1 = l3;
        l2 = l3;
        localObject1 = modelInit((QmcfModelItem)localObject1);
        l1 = l3;
        l2 = l3;
        l3 = System.currentTimeMillis() - l4;
        l1 = l3;
        l2 = l3;
        SLog.d(this.TAG, String.format("initProcessor, result[%s], cost[%s], width[%s], heigth[%s], mode[%s], type[%s]", new Object[] { localObject1, Long.valueOf(l3), Integer.valueOf(getInputWidth()), Integer.valueOf(getInputHeight()), Integer.valueOf(i), Integer.valueOf(j) }));
        l1 = l3;
      }
      catch (Error localError)
      {
        SLog.e(this.TAG, "initProcessor error", localError);
      }
      catch (Exception localException)
      {
        SLog.e(this.TAG, "initProcessor excep", localException);
        l1 = l2;
      }
      Object localObject2 = "NotNativeError";
      if ("success".equals(localObject2))
      {
        qmcfManager.setQmcfRunSupported(true, true, i);
        qmcfManager.setQmcfInitSuccess(true);
        if (l1 > 3000L)
        {
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("svaf_cost", String.valueOf(l1));
          ((HashMap)localObject2).put("svaf_qmcf_mode", String.valueOf(i));
          QmcfReporter.report("svaf_init_cost3s", (HashMap)localObject2, true);
        }
      }
      else
      {
        if ("NotNativeError".equals(localObject2)) {
          QmcfManager.getInstance().setQmcfRunSupported(true, true, i);
        } else {
          QmcfManager.getInstance().setQmcfInitSuccess(false);
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("svaf_result", String.valueOf(localObject2));
        localHashMap.put("svaf_cost", String.valueOf(l1));
        localHashMap.put("svaf_qmcf_mode", String.valueOf(i));
        QmcfReporter.report("svaf_init_error", localHashMap, true);
        qmcfManager.setCurrQmcfMode(0);
      }
      this.processorDestroyed = false;
      localObject2 = qmcfManager;
      ((QmcfManager)localObject2).modeChanged = false;
      ((QmcfManager)localObject2).modelSwitched = false;
      return;
      label585:
      localObject2 = "NotNativeError";
    }
  }
  
  public String doProcess(int paramInt1, int paramInt2)
  {
    this.startPorcessTime = System.currentTimeMillis();
    this.processResult = modelProcess(paramInt1, paramInt2);
    this.processCost = (System.currentTimeMillis() - this.startPorcessTime);
    if (this.processResult.startsWith("suc")) {
      QmcfManager.getInstance().setQmcfProcessConsume(this.processCost);
    }
    return this.processResult;
  }
  
  public int getInputHeight()
  {
    return this.inputHeight;
  }
  
  public int getInputWidth()
  {
    return this.inputWidth;
  }
  
  protected String modelDestroy()
  {
    return "success";
  }
  
  protected String modelInit(QmcfModelItem paramQmcfModelItem)
  {
    return "success";
  }
  
  protected String modelProcess(int paramInt1, int paramInt2)
  {
    return "success";
  }
  
  protected boolean modelSwitch(QmcfModelItem paramQmcfModelItem)
  {
    return false;
  }
  
  public String replaceModelSize(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      String str = paramString.replaceFirst("\\d{2,4}\\s\\d{2,4}", String.format("%d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramString;
  }
  
  public void setInputSize(int paramInt1, int paramInt2)
  {
    this.inputWidth = paramInt1;
    this.inputHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qmcf.processor.BaseQmcfProcessor
 * JD-Core Version:    0.7.0.1
 */