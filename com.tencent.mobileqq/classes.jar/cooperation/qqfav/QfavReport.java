package cooperation.qqfav;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public final class QfavReport
{
  public static void a(AppRuntime paramAppRuntime, int paramInt)
  {
    a(paramAppRuntime, "User_NewFav", paramInt, 0, 0);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2)
  {
    a(paramAppRuntime, "User_AddFav", paramInt2, 0, paramInt1);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("subAction= 0X800AA51, actionName = 0X800AA51, fromType = ");
      paramAppRuntime.append(paramInt1);
      paramAppRuntime.append(", actionResult = ");
      paramAppRuntime.append(paramInt2);
      paramAppRuntime.append(", ext2 = ");
      paramAppRuntime.append(paramInt3);
      QLog.i("qqfavReport", 2, paramAppRuntime.toString());
    }
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("");
    paramAppRuntime.append(paramInt3);
    ReportController.b(null, "dc00898", "", "", "0X800AA51", "0X800AA51", paramInt1, paramInt2, paramAppRuntime.toString(), "", "", "");
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramAppRuntime, paramString, paramInt1, paramInt2, paramInt3, 0, "", "");
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
    } else {
      paramAppRuntime = null;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("actionName = ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", fromType = ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", actionResult = ");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(", ext2 =");
      ((StringBuilder)localObject1).append(paramInt3);
      ((StringBuilder)localObject1).append(", ext3 =");
      ((StringBuilder)localObject1).append(paramInt4);
      ((StringBuilder)localObject1).append(", ext4 =");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(", ext5 =");
      ((StringBuilder)localObject1).append(paramString3);
      QLog.i("qqfavReport", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(paramInt3);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramInt4);
    localObject2 = ((StringBuilder)localObject2).toString();
    if (paramString2 == null) {
      paramString2 = "";
    }
    if (paramString3 == null) {
      paramString3 = "";
    }
    ReportController.b(paramAppRuntime, "CliOper", "", "", "Favorite", paramString1, paramInt1, paramInt2, (String)localObject1, (String)localObject2, paramString2, paramString3);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong)
  {
    Object localObject = new String[3];
    int i = NetworkUtil.getSystemNetwork(paramAppRuntime.getApplication().getApplicationContext());
    if (i == 1)
    {
      if (paramBoolean) {
        localObject[0] = "param_WIFIFavoritesUploadFlow";
      } else {
        localObject[0] = "param_WIFIFavoritesDownloadFlow";
      }
      localObject[1] = "param_WIFIFlow";
    }
    else
    {
      if (paramBoolean) {
        localObject[0] = "param_XGFavoritesUploadFlow";
      } else {
        localObject[0] = "param_XGFavoritesDownloadFlow";
      }
      localObject[1] = "param_XGFlow";
    }
    localObject[2] = "param_Flow";
    paramAppRuntime.sendAppDataIncermentMsg(paramAppRuntime.getAccount(), (String[])localObject, paramLong);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addFlowCount ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" for ");
      if (paramBoolean) {
        paramAppRuntime = "upload";
      } else {
        paramAppRuntime = "download";
      }
      ((StringBuilder)localObject).append(paramAppRuntime);
      ((StringBuilder)localObject).append(", netType is ");
      ((StringBuilder)localObject).append(i);
      QLog.d("qqfav", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void b(AppRuntime paramAppRuntime, int paramInt)
  {
    a(paramAppRuntime, "User_DelFav", 0, 0, paramInt);
  }
  
  public static void b(AppRuntime paramAppRuntime, int paramInt1, int paramInt2)
  {
    a(paramAppRuntime, "User_OpenFavPage", paramInt2, 0, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.QfavReport
 * JD-Core Version:    0.7.0.1
 */