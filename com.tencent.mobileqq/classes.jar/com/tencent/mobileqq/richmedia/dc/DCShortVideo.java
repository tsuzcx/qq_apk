package com.tencent.mobileqq.richmedia.dc;

import android.content.Context;
import android.os.Environment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.Calendar;
import java.util.Locale;
import mqq.os.MqqHandler;

public class DCShortVideo
  extends DataCollector
  implements ReportEvent
{
  public DCShortVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(QQAppInterface paramQQAppInterface, DCShortVideo.DCShortVideoSendData paramDCShortVideoSendData, boolean paramBoolean, int paramInt, String paramString)
  {
    paramDCShortVideoSendData.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      if (paramInt == 0) {
        paramDCShortVideoSendData.jdField_a_of_type_Int = 0;
      }
    }
    else {
      return;
    }
    if (paramInt == 3000)
    {
      paramDCShortVideoSendData.jdField_a_of_type_Int = 3000;
      return;
    }
    if (paramInt == 1)
    {
      switch (paramQQAppInterface.getTroopMask(paramString))
      {
      default: 
        paramDCShortVideoSendData.jdField_a_of_type_Int = 1;
      }
      for (;;)
      {
        paramDCShortVideoSendData.i = 0;
        paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (paramQQAppInterface == null) {
          break;
        }
        paramQQAppInterface = paramQQAppInterface.c(paramString);
        if (paramQQAppInterface == null) {
          break;
        }
        paramDCShortVideoSendData.i = paramQQAppInterface.wMemberNum;
        return;
        paramDCShortVideoSendData.jdField_a_of_type_Int = 1;
        continue;
        paramDCShortVideoSendData.jdField_a_of_type_Int = 3;
        continue;
        paramDCShortVideoSendData.jdField_a_of_type_Int = 4;
        continue;
        paramDCShortVideoSendData.jdField_a_of_type_Int = 2;
      }
    }
    paramDCShortVideoSendData.jdField_a_of_type_Int = 9999;
  }
  
  private boolean a(DCShortVideo.DCShortVideoSendData paramDCShortVideoSendData, String paramString)
  {
    Object localObject2 = new File(paramString);
    Object localObject1 = FileUtil.c(paramString);
    paramString = (String)localObject1;
    if (localObject1 != null) {
      paramString = ((String)localObject1).toLowerCase(Locale.US);
    }
    localObject1 = null;
    try
    {
      localObject2 = ((File)localObject2).getParentFile().getName().toLowerCase(Locale.US);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label50:
      break label50;
    }
    if ((paramString == null) || (localObject1 == null)) {
      return false;
    }
    if (paramString.contains("/tencent/")) {
      if (paramString.contains("/mobileqq/shortvideo/")) {
        paramDCShortVideoSendData.j = 1002;
      }
    }
    for (;;)
    {
      return true;
      if (paramString.contains("/qq_collection/"))
      {
        paramDCShortVideoSendData.j = 1001;
      }
      else if (paramString.contains("/qqfile_recv/"))
      {
        paramDCShortVideoSendData.j = 1003;
      }
      else if ((paramString.contains("/weixin/")) || (paramString.contains("/wechat/")) || (paramString.contains("/micromsg/")))
      {
        paramDCShortVideoSendData.j = 1004;
      }
      else if (StatisticConstants.a(paramString))
      {
        paramDCShortVideoSendData.j = 1005;
      }
      else
      {
        paramDCShortVideoSendData.j = 1006;
        continue;
        if (paramString.equalsIgnoreCase(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath() + File.separator)) {
          paramDCShortVideoSendData.j = 1002;
        } else if ((((String)localObject1).contains("camera")) || (((String)localObject1).equals("dcim")) || (((String)localObject1).equals("100MEDIA")) || (((String)localObject1).equals("100ANDRO")) || (((String)localObject1).contains(HardCodeUtil.a(2131702914))) || (((String)localObject1).contains(HardCodeUtil.a(2131702913))) || (((String)localObject1).contains(HardCodeUtil.a(2131702915)))) {
          paramDCShortVideoSendData.j = 1007;
        } else if (StatisticConstants.a(paramString)) {
          paramDCShortVideoSendData.j = 1005;
        } else {
          paramDCShortVideoSendData.j = 1006;
        }
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new DCShortVideo.5(this, paramInt, paramBoolean));
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, int paramInt3, String paramString, long paramLong)
  {
    if ((paramAppInterface != null) && ((paramInt1 == 2001) || (paramInt1 == 2002) || (paramInt1 == 2003))) {
      ThreadManager.getSubThreadHandler().post(new DCShortVideo.3(this, paramAppInterface, paramInt1, paramInt3, paramString, paramInt2, paramLong));
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramAppInterface != null) && ((paramInt1 == 2001) || (paramInt1 == 2002) || (paramInt1 == 2003))) {
      ThreadManager.getSubThreadHandler().post(new DCShortVideo.4(this, paramAppInterface, paramInt1, paramInt2, paramString));
    }
  }
  
  void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, DCShortVideo.DCShortVideoReportData paramDCShortVideoReportData)
  {
    paramDCShortVideoReportData.f = paramInt1;
    if (paramInt2 == 0) {
      paramDCShortVideoReportData.b = 0;
    }
    for (;;)
    {
      paramAppInterface = (NearbyCardManager)paramAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
      if (paramAppInterface != null)
      {
        paramDCShortVideoReportData.d = paramAppInterface.a();
        paramDCShortVideoReportData.e = paramAppInterface.b();
      }
      paramDCShortVideoReportData.g = Calendar.getInstance().get(11);
      paramDCShortVideoReportData.h = NetworkUtil.a(BaseApplication.getContext());
      return;
      if (paramInt2 == 3000)
      {
        paramDCShortVideoReportData.b = 3000;
      }
      else
      {
        if (paramInt2 == 1)
        {
          if ((paramAppInterface instanceof QQAppInterface)) {
            switch (((QQAppInterface)paramAppInterface).getTroopMask(paramString))
            {
            default: 
              paramDCShortVideoReportData.b = 1;
            }
          }
          for (;;)
          {
            paramDCShortVideoReportData.c = 0;
            TroopManager localTroopManager = (TroopManager)paramAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            if (localTroopManager == null) {
              break;
            }
            paramString = localTroopManager.c(paramString);
            if (paramString == null) {
              break;
            }
            paramDCShortVideoReportData.c = paramString.wMemberNum;
            break;
            paramDCShortVideoReportData.b = 1;
            continue;
            paramDCShortVideoReportData.b = 3;
            continue;
            paramDCShortVideoReportData.b = 4;
            continue;
            paramDCShortVideoReportData.b = 2;
            continue;
            paramDCShortVideoReportData.b = 1;
          }
        }
        paramDCShortVideoReportData.b = 9999;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if ((paramQQAppInterface != null) && ((paramInt1 == 2001) || (paramInt1 == 2002) || (paramInt1 == 2003))) {
      ThreadManager.getSubThreadHandler().post(new DCShortVideo.2(this, paramQQAppInterface, paramInt1, paramInt2, paramString, paramInt3));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString3, long paramLong, String paramString4)
  {
    if ((paramQQAppInterface != null) && (paramString1 != null) && ((paramInt1 == 2001) || (paramInt1 == 2002) || (paramInt1 == 2003))) {
      ThreadManager.getSubThreadHandler().post(new DCShortVideo.1(this, paramString1, paramQQAppInterface, paramInt1, paramInt2, paramString2, paramLong, paramString4, paramBoolean1, paramInt3, paramString3, paramBoolean2));
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong)
  {
    ThreadManager.getSubThreadHandler().post(new DCShortVideo.6(this, paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt7, paramInt8, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo
 * JD-Core Version:    0.7.0.1
 */