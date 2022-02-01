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
    paramDCShortVideoSendData.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      if (paramInt == 0)
      {
        paramDCShortVideoSendData.jdField_a_of_type_Int = 0;
        return;
      }
      if (paramInt == 3000)
      {
        paramDCShortVideoSendData.jdField_a_of_type_Int = 3000;
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
                paramDCShortVideoSendData.jdField_a_of_type_Int = 1;
              } else {
                paramDCShortVideoSendData.jdField_a_of_type_Int = 2;
              }
            }
            else {
              paramDCShortVideoSendData.jdField_a_of_type_Int = 4;
            }
          }
          else {
            paramDCShortVideoSendData.jdField_a_of_type_Int = 3;
          }
        }
        else {
          paramDCShortVideoSendData.jdField_a_of_type_Int = 1;
        }
        paramDCShortVideoSendData.i = 0;
        paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.c(paramString);
          if (paramQQAppInterface != null) {
            paramDCShortVideoSendData.i = paramQQAppInterface.wMemberNum;
          }
        }
      }
      else
      {
        paramDCShortVideoSendData.jdField_a_of_type_Int = 9999;
      }
    }
  }
  
  private boolean a(DCShortVideo.DCShortVideoSendData paramDCShortVideoSendData, String paramString)
  {
    Object localObject2 = new File(paramString);
    Object localObject1 = FileUtil.b(paramString);
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
          paramDCShortVideoSendData.j = 1002;
        } else if (paramString.contains("/qq_collection/")) {
          paramDCShortVideoSendData.j = 1001;
        } else if (paramString.contains("/qqfile_recv/")) {
          paramDCShortVideoSendData.j = 1003;
        } else if ((!paramString.contains("/weixin/")) && (!paramString.contains("/wechat/")) && (!paramString.contains("/micromsg/")))
        {
          if (PhotoReportUtils.a(paramString)) {
            paramDCShortVideoSendData.j = 1005;
          } else {
            paramDCShortVideoSendData.j = 1006;
          }
        }
        else {
          paramDCShortVideoSendData.j = 1004;
        }
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath());
        ((StringBuilder)localObject2).append(File.separator);
        if (paramString.equalsIgnoreCase(((StringBuilder)localObject2).toString())) {
          paramDCShortVideoSendData.j = 1002;
        } else if ((!((String)localObject1).contains("camera")) && (!((String)localObject1).equals("dcim")) && (!((String)localObject1).equals("100MEDIA")) && (!((String)localObject1).equals("100ANDRO")) && (!((String)localObject1).contains(HardCodeUtil.a(2131703046))) && (!((String)localObject1).contains(HardCodeUtil.a(2131703045))) && (!((String)localObject1).contains(HardCodeUtil.a(2131703047))))
        {
          if (PhotoReportUtils.a(paramString)) {
            paramDCShortVideoSendData.j = 1005;
          } else {
            paramDCShortVideoSendData.j = 1006;
          }
        }
        else {
          paramDCShortVideoSendData.j = 1007;
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
    paramDCShortVideoReportData.f = paramInt1;
    if (paramInt2 == 0)
    {
      paramDCShortVideoReportData.b = 0;
    }
    else if (paramInt2 == 3000)
    {
      paramDCShortVideoReportData.b = 3000;
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
                paramDCShortVideoReportData.b = 1;
              } else {
                paramDCShortVideoReportData.b = 2;
              }
            }
            else {
              paramDCShortVideoReportData.b = 4;
            }
          }
          else {
            paramDCShortVideoReportData.b = 3;
          }
        }
        else {
          paramDCShortVideoReportData.b = 1;
        }
      }
      else
      {
        paramDCShortVideoReportData.b = 1;
      }
      paramDCShortVideoReportData.c = 0;
      TroopManager localTroopManager = (TroopManager)paramAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localTroopManager != null)
      {
        paramString = localTroopManager.c(paramString);
        if (paramString != null) {
          paramDCShortVideoReportData.c = paramString.wMemberNum;
        }
      }
    }
    else
    {
      paramDCShortVideoReportData.b = 9999;
    }
    paramAppInterface = (INearbyCardManager)paramAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
    if (paramAppInterface != null)
    {
      paramDCShortVideoReportData.d = paramAppInterface.a();
      paramDCShortVideoReportData.e = paramAppInterface.b();
    }
    paramDCShortVideoReportData.g = Calendar.getInstance().get(11);
    paramDCShortVideoReportData.h = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo
 * JD-Core Version:    0.7.0.1
 */