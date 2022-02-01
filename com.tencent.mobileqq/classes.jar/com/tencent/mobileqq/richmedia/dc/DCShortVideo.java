package com.tencent.mobileqq.richmedia.dc;

import android.content.Context;
import android.os.Environment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.statistics.PhotoReportUtils;
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
    paramDCShortVideoSendData.b = paramBoolean;
    if (paramBoolean)
    {
      if (paramInt == 0)
      {
        paramDCShortVideoSendData.k = 0;
        return;
      }
      if (paramInt == 3000)
      {
        paramDCShortVideoSendData.k = 3000;
        return;
      }
      if (paramInt == 1)
      {
        paramInt = paramQQAppInterface.getTroopMask(paramString);
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt != 4) {
                paramDCShortVideoSendData.k = 1;
              } else {
                paramDCShortVideoSendData.k = 2;
              }
            }
            else {
              paramDCShortVideoSendData.k = 4;
            }
          }
          else {
            paramDCShortVideoSendData.k = 3;
          }
        }
        else {
          paramDCShortVideoSendData.k = 1;
        }
        paramDCShortVideoSendData.l = 0;
        paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.g(paramString);
          if (paramQQAppInterface != null) {
            paramDCShortVideoSendData.l = paramQQAppInterface.wMemberNum;
          }
        }
      }
      else
      {
        paramDCShortVideoSendData.k = 9999;
      }
    }
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
    if ((paramString != null) && (localObject1 != null))
    {
      if (paramString.contains("/tencent/"))
      {
        if (paramString.contains("/mobileqq/shortvideo/")) {
          paramDCShortVideoSendData.m = 1002;
        } else if (paramString.contains("/qq_collection/")) {
          paramDCShortVideoSendData.m = 1001;
        } else if (paramString.contains("/qqfile_recv/")) {
          paramDCShortVideoSendData.m = 1003;
        } else if ((!paramString.contains("/weixin/")) && (!paramString.contains("/wechat/")) && (!paramString.contains("/micromsg/")))
        {
          if (PhotoReportUtils.a(paramString)) {
            paramDCShortVideoSendData.m = 1005;
          } else {
            paramDCShortVideoSendData.m = 1006;
          }
        }
        else {
          paramDCShortVideoSendData.m = 1004;
        }
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath());
        ((StringBuilder)localObject2).append(File.separator);
        if (paramString.equalsIgnoreCase(((StringBuilder)localObject2).toString())) {
          paramDCShortVideoSendData.m = 1002;
        } else if ((!((String)localObject1).contains("camera")) && (!((String)localObject1).equals("dcim")) && (!((String)localObject1).equals("100MEDIA")) && (!((String)localObject1).equals("100ANDRO")) && (!((String)localObject1).contains(HardCodeUtil.a(2131901020))) && (!((String)localObject1).contains(HardCodeUtil.a(2131901019))) && (!((String)localObject1).contains(HardCodeUtil.a(2131901021))))
        {
          if (PhotoReportUtils.a(paramString)) {
            paramDCShortVideoSendData.m = 1005;
          } else {
            paramDCShortVideoSendData.m = 1006;
          }
        }
        else {
          paramDCShortVideoSendData.m = 1007;
        }
      }
      return true;
    }
    return false;
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
    paramDCShortVideoReportData.g = paramInt1;
    if (paramInt2 == 0)
    {
      paramDCShortVideoReportData.c = 0;
    }
    else if (paramInt2 == 3000)
    {
      paramDCShortVideoReportData.c = 3000;
    }
    else if (paramInt2 == 1)
    {
      if ((paramAppInterface instanceof QQAppInterface))
      {
        paramInt1 = ((QQAppInterface)paramAppInterface).getTroopMask(paramString);
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            if (paramInt1 != 3)
            {
              if (paramInt1 != 4) {
                paramDCShortVideoReportData.c = 1;
              } else {
                paramDCShortVideoReportData.c = 2;
              }
            }
            else {
              paramDCShortVideoReportData.c = 4;
            }
          }
          else {
            paramDCShortVideoReportData.c = 3;
          }
        }
        else {
          paramDCShortVideoReportData.c = 1;
        }
      }
      else
      {
        paramDCShortVideoReportData.c = 1;
      }
      paramDCShortVideoReportData.d = 0;
      TroopManager localTroopManager = (TroopManager)paramAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localTroopManager != null)
      {
        paramString = localTroopManager.g(paramString);
        if (paramString != null) {
          paramDCShortVideoReportData.d = paramString.wMemberNum;
        }
      }
    }
    else
    {
      paramDCShortVideoReportData.c = 9999;
    }
    paramAppInterface = (INearbyCardManager)paramAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
    if (paramAppInterface != null)
    {
      paramDCShortVideoReportData.e = paramAppInterface.b();
      paramDCShortVideoReportData.f = paramAppInterface.c();
    }
    paramDCShortVideoReportData.h = Calendar.getInstance().get(11);
    paramDCShortVideoReportData.i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if ((paramQQAppInterface != null) && ((paramInt1 == 2001) || (paramInt1 == 2002) || (paramInt1 == 2003))) {
      ThreadManager.getSubThreadHandler().post(new DCShortVideo.2(this, paramQQAppInterface, paramInt1, paramInt2, paramString, paramInt3));
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong)
  {
    ThreadManager.getSubThreadHandler().post(new DCShortVideo.6(this, paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt7, paramInt8, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo
 * JD-Core Version:    0.7.0.1
 */