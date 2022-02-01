package com.tencent.mobileqq.qwallet.hb.send.busylogic.impl;

import android.content.SharedPreferences;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.impl.GdtAdServlet;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import tencent.im.qqwallet.GetRecommendWords.GetClassifyReq;
import tencent.im.qqwallet.GetRecommendWords.GetDefaultCopywriterReq;

public class GetRecommendWordUtils
{
  private static final Set<Integer> a = new HashSet();
  
  public static int a(String paramString)
  {
    if (HbInfo.c.contains(paramString))
    {
      if ("2".equals(paramString)) {
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qwallet_hongbao_shengpizi_");
    localStringBuilder.append(QWalletHelperImpl.getAppRuntime().getCurrentUin());
    return MD5.toMD5(localStringBuilder.toString());
  }
  
  public static List<GetRecommendWordUtils.RspGroupWordsListInfo> a()
  {
    Object localObject2 = new ArrayList();
    Object localObject1;
    try
    {
      Object localObject3 = FileUtils.readObject(a());
      localObject1 = localObject2;
      if ((localObject3 instanceof ArrayList)) {
        localObject1 = (List)localObject3;
      }
    }
    catch (Throwable localThrowable)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.e("GetRandomRecommendWordUtils", 2, "", localThrowable);
        localObject1 = localObject2;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readFromFile, ");
      if (localObject1 != null) {
        localObject2 = localObject1.toString();
      } else {
        localObject2 = "null";
      }
      localStringBuilder.append((String)localObject2);
      QLog.d("GetRandomRecommendWordUtils", 2, localStringBuilder.toString());
    }
    return localObject1;
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, GetRecommendWordUtils.GetGroupWordsListener paramGetGroupWordsListener)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("GetRandomRecommendWordUtils", 2, "is getGroupWordListFromSSO...");
      }
      SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("red_packet", 0);
      long l = NetConnInfoCenter.getServerTimeMillis();
      NewIntent localNewIntent = new NewIntent(MobileQQ.sMobileQQ, GdtAdServlet.class);
      localNewIntent.putExtra("cmd", "trpc.qqhb.sendhbdetail.sendhbdetail.GetClassify");
      GetRecommendWords.GetClassifyReq localGetClassifyReq = new GetRecommendWords.GetClassifyReq();
      localGetClassifyReq.subchannel.set(paramInt);
      PBInt32Field localPBInt32Field = localGetClassifyReq.ver;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_key_group_words_list");
      localStringBuilder.append(QWalletHelperImpl.getAppRuntime().getCurrentUin());
      localPBInt32Field.set(localSharedPreferences.getInt(localStringBuilder.toString(), 0));
      localNewIntent.putExtra("data", WupUtil.a(localGetClassifyReq.toByteArray()));
      localNewIntent.setObserver(new GetRecommendWordUtils.2(l, localSharedPreferences, paramGetGroupWordsListener, paramInt));
      paramBaseQQAppInterface.startServlet(localNewIntent);
      return;
    }
    catch (Throwable paramBaseQQAppInterface)
    {
      QLog.e("GetRandomRecommendWordUtils", 1, paramBaseQQAppInterface, new Object[0]);
    }
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, String paramString, GetRecommendWordUtils.GetRandomWordsListener paramGetRandomWordsListener)
  {
    try
    {
      if (a.contains(Integer.valueOf(paramInt))) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GetRandomRecommendWordUtils", 2, "is getIdiomListFromSSO...");
      }
      a.add(Integer.valueOf(paramInt));
      long l = NetConnInfoCenter.getServerTimeMillis();
      NewIntent localNewIntent = new NewIntent(MobileQQ.sMobileQQ, GdtAdServlet.class);
      localNewIntent.putExtra("cmd", "trpc.qqhb.sendhbdetail.sendhbdetail.GetDefaultCopywriter");
      GetRecommendWords.GetDefaultCopywriterReq localGetDefaultCopywriterReq = new GetRecommendWords.GetDefaultCopywriterReq();
      localGetDefaultCopywriterReq.subchannel.set(paramInt);
      localGetDefaultCopywriterReq.fromtype.set(a(paramString));
      localNewIntent.putExtra("data", WupUtil.a(localGetDefaultCopywriterReq.toByteArray()));
      localNewIntent.setObserver(new GetRecommendWordUtils.1(paramInt, l, paramGetRandomWordsListener));
      paramBaseQQAppInterface.startServlet(localNewIntent);
      return;
    }
    catch (Throwable paramBaseQQAppInterface)
    {
      QLog.e("GetRandomRecommendWordUtils", 1, paramBaseQQAppInterface, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.GetRecommendWordUtils
 * JD-Core Version:    0.7.0.1
 */