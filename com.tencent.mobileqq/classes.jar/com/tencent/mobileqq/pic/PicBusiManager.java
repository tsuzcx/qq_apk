package com.tencent.mobileqq.pic;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.api.IMsgMixed;
import com.tencent.mobileqq.pic.operator.AbstractPicOperator;
import com.tencent.mobileqq.pic.operator.AioQuickSendPicOperator;
import com.tencent.mobileqq.pic.operator.AioQzonePicOperator;
import com.tencent.mobileqq.pic.operator.CompressPicOperator;
import com.tencent.mobileqq.pic.operator.DownloadPicOperator;
import com.tencent.mobileqq.pic.operator.EssencePicOperator;
import com.tencent.mobileqq.pic.operator.ForwardPicOperator;
import com.tencent.mobileqq.pic.operator.OperatorMap;
import com.tencent.mobileqq.pic.operator.ReSendPicOperator;
import com.tencent.mobileqq.pic.operator.SendBlessOperator;
import com.tencent.mobileqq.pic.operator.SendFlashPicOperator;
import com.tencent.mobileqq.pic.operator.UploadPicOperator;
import com.tencent.mobileqq.pic.operator.multipic.MultiPicsOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.RichMediaBugReport;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class PicBusiManager
{
  private static OperatorMap<UploadPicOperator> a = new OperatorMap(UploadPicOperator.class);
  private static OperatorMap<UploadPicOperator> b = new OperatorMap(ReSendPicOperator.class);
  private static OperatorMap<ForwardPicOperator> c = new OperatorMap(ForwardPicOperator.class);
  private static OperatorMap<DownloadPicOperator> d = new OperatorMap(DownloadPicOperator.class);
  private static OperatorMap<MultiPicsOperator> e = new OperatorMap(MultiPicsOperator.class);
  private static OperatorMap<CompressPicOperator> f = new OperatorMap(CompressPicOperator.class);
  private static HashMap<Integer, OperatorMap> g = new HashMap();
  
  static
  {
    a.a(1039, SendFlashPicOperator.class);
    a.a(1040, SendFlashPicOperator.class);
    a.a(1045, AioQzonePicOperator.class);
    a.a(1042, AioQuickSendPicOperator.class);
    a.a(1047, AioQuickSendPicOperator.class);
    a.a(1054, AioQuickSendPicOperator.class);
    a.a(1044, AioQuickSendPicOperator.class);
    a.a(1049, AioQuickSendPicOperator.class);
    a.a(1056, SendBlessOperator.class);
    a.a(1057, EssencePicOperator.class);
    g.put(Integer.valueOf(2), a);
    g.put(Integer.valueOf(4), b);
    g.put(Integer.valueOf(3), c);
    g.put(Integer.valueOf(5), d);
    g.put(Integer.valueOf(6), d);
    g.put(Integer.valueOf(7), d);
    g.put(Integer.valueOf(8), e);
    g.put(Integer.valueOf(1), f);
  }
  
  public static AppInterface a()
  {
    return (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
  }
  
  public static CompressInfo a(int paramInt, Intent paramIntent)
  {
    CompressPicOperator localCompressPicOperator = (CompressPicOperator)a(f, paramInt);
    if (localCompressPicOperator != null) {
      return localCompressPicOperator.a(paramIntent);
    }
    return null;
  }
  
  public static PicFowardInfo a(int paramInt1, MessageForPic paramMessageForPic, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    MultiPicsOperator localMultiPicsOperator = (MultiPicsOperator)a(e, paramInt1);
    if (localMultiPicsOperator != null) {
      return localMultiPicsOperator.a(paramMessageForPic, paramInt2, paramString1, paramString2, paramString3);
    }
    return null;
  }
  
  public static PicReq a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, 0, paramInt2);
  }
  
  public static PicReq a(int paramInt1, int paramInt2, int paramInt3)
  {
    PicReq localPicReq = new PicReq();
    localPicReq.a = paramInt1;
    localPicReq.n = paramInt2;
    localPicReq.b = paramInt3;
    return localPicReq;
  }
  
  public static AbstractPicOperator a(PicReq paramPicReq)
  {
    if (paramPicReq == null)
    {
      Logger.b("PicBusiManager", "launch", "error,req == null");
      return null;
    }
    Object localObject = b(paramPicReq.a, paramPicReq.b);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("error,busiInterface == null,req.busiType:");
      ((StringBuilder)localObject).append(paramPicReq.b);
      Logger.b("PicBusiManager", "launch", ((StringBuilder)localObject).toString());
      return null;
    }
    ((AbstractPicOperator)localObject).c = paramPicReq;
    ((AbstractPicOperator)localObject).a = paramPicReq.c;
    ((AbstractPicOperator)localObject).b = paramPicReq.d;
    ((AbstractPicOperator)localObject).a(paramPicReq.k);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cmd:");
    localStringBuilder.append(paramPicReq.a);
    localStringBuilder.append(",busiType:");
    localStringBuilder.append(paramPicReq.b);
    localStringBuilder.append("localUUID:");
    localStringBuilder.append(paramPicReq.c);
    Logger.a("PicBusiManager", "launch", localStringBuilder.toString());
    ((AbstractPicOperator)localObject).a();
    return localObject;
  }
  
  private static <T extends AbstractPicOperator> T a(OperatorMap<T> paramOperatorMap, int paramInt)
  {
    paramOperatorMap = paramOperatorMap.a(paramInt);
    if (paramOperatorMap != null) {
      try
      {
        paramOperatorMap = (AbstractPicOperator)paramOperatorMap.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        return paramOperatorMap;
      }
      catch (Throwable paramOperatorMap)
      {
        QLog.e("PicBusiManager", 1, paramOperatorMap.toString());
        RichMediaBugReport.a("PIC_BUS_GET_OPERATOR", String.valueOf(paramInt));
        paramOperatorMap.printStackTrace();
      }
    }
    return null;
  }
  
  public static ArrayList<PicFowardInfo> a(int paramInt1, MessageRecord paramMessageRecord, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    if (((IMsgMixed)QRoute.api(IMsgMixed.class)).isMessageForMixedMsg(paramMessageRecord))
    {
      MultiPicsOperator localMultiPicsOperator = (MultiPicsOperator)a(e, paramInt1);
      if (localMultiPicsOperator != null) {
        return localMultiPicsOperator.a(paramMessageRecord, paramInt2, paramString1, paramString2, paramString3);
      }
    }
    return null;
  }
  
  public static PicUploadInfo b(int paramInt, Intent paramIntent)
  {
    UploadPicOperator localUploadPicOperator = (UploadPicOperator)a(a, paramInt);
    if (localUploadPicOperator != null) {
      return localUploadPicOperator.a(paramIntent);
    }
    return null;
  }
  
  public static AbstractPicOperator b(int paramInt1, int paramInt2)
  {
    OperatorMap localOperatorMap = (OperatorMap)g.get(Integer.valueOf(paramInt1));
    if (localOperatorMap != null) {
      return a(localOperatorMap, paramInt2);
    }
    return null;
  }
  
  public static PicFowardInfo c(int paramInt, Intent paramIntent)
  {
    ForwardPicOperator localForwardPicOperator = (ForwardPicOperator)a(c, paramInt);
    if (localForwardPicOperator != null) {
      return localForwardPicOperator.a(paramIntent);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicBusiManager
 * JD-Core Version:    0.7.0.1
 */