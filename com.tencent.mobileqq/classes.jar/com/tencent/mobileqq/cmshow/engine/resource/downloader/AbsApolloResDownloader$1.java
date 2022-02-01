package com.tencent.mobileqq.cmshow.engine.resource.downloader;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.apollo.res.api.IApolloResHelper;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ProcessUtil;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.util.LogUtil;

class AbsApolloResDownloader$1
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  AbsApolloResDownloader$1(AbsApolloResDownloader paramAbsApolloResDownloader, IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, int paramInt, int[] paramArrayOfInt, AppRuntime paramAppRuntime, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    Object localObject1;
    if (!paramBoolean)
    {
      paramArrayOfInt = this.a;
      if (paramArrayOfInt != null) {
        paramArrayOfInt.a(false, paramString, this.b, this.c, paramInt2);
      }
      paramArrayOfInt = this.f.b();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("downloadApolloResOrder down load role fail id: ");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append(", uin:");
      ((StringBuilder)localObject1).append(LogUtil.wrapLogUin(paramString));
      QLog.e(paramArrayOfInt, 1, ((StringBuilder)localObject1).toString());
      return;
    }
    if (ProcessUtil.a())
    {
      paramArrayOfInt = new File(this.f.a().d(1, paramInt1), "dress.zip");
      localObject1 = this.f.a().d(1, paramInt1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append("dress.zip");
      localObject1 = new File((String)localObject1, localStringBuilder.toString());
      FileUtils.copyFile(paramArrayOfInt, (File)localObject1);
      if (CMResUtil.b((File)localObject1))
      {
        if (paramInt1 != 0) {
          paramArrayOfInt = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/";
        }
        try
        {
          paramArrayOfInt = new StringBuilder();
          paramArrayOfInt.append(ApolloConstant.a);
          paramArrayOfInt.append("/def/dress/");
          paramArrayOfInt = paramArrayOfInt.toString();
          localStringBuilder = new StringBuilder();
          try
          {
            new File(paramArrayOfInt).mkdirs();
            Object localObject2 = ((IApolloResHelper)QRoute.api(IApolloResHelper.class)).readRoleDefaultDressIds(paramInt1);
            int j = ZipUtils.unZipFiles((File)localObject1, paramArrayOfInt, new AbsApolloResDownloader.1.1(this, localStringBuilder, paramArrayOfInt));
            if ((localObject2 != null) && (localObject2.length > 0))
            {
              paramArrayOfInt = this.f.a();
              int k = localObject2.length;
              int i = 0;
              while (i < k)
              {
                int m = localObject2[i];
                paramArrayOfInt.a(this.d, 2, m);
                i += 1;
              }
            }
            FileUtils.deleteFile((File)localObject1);
            localStringBuilder.append(", unzipRet: ");
            localStringBuilder.append(j);
            paramArrayOfInt = this.f.b();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("downloadApolloResOrder succ roleId: ");
            ((StringBuilder)localObject2).append(this.b);
            ((StringBuilder)localObject2).append(", unzipRoleDress: ");
            ((StringBuilder)localObject2).append(localStringBuilder.toString());
            ((StringBuilder)localObject2).append(", uin: ");
            ((StringBuilder)localObject2).append(LogUtil.wrapLogUin(paramString));
            QLog.d(paramArrayOfInt, 1, ((StringBuilder)localObject2).toString());
          }
          finally {}
          paramArrayOfInt = this.f.b();
        }
        catch (OutOfMemoryError paramArrayOfInt)
        {
          FileUtils.deleteFile((File)localObject1);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("downloadApolloResOrder unZipFile file error resType->");
          ((StringBuilder)localObject1).append(paramInt1);
          ((StringBuilder)localObject1).append(" error->");
          ((StringBuilder)localObject1).append(paramArrayOfInt.getMessage());
          QLog.e("[cmshow][ApolloResDownloader]", 1, ((StringBuilder)localObject1).toString());
        }
        catch (Exception paramArrayOfInt)
        {
          FileUtils.deleteFile((File)localObject1);
          localObject1 = this.f.b();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("downloadApolloResOrder unZipFile file error resType->");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append(" error->");
          localStringBuilder.append(paramArrayOfInt.getMessage());
          QLog.e((String)localObject1, 1, localStringBuilder.toString(), paramArrayOfInt);
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("downloadApolloResOrder unZipFile file warning, empty file!Check if it is double download. resType->");
        ((StringBuilder)localObject1).append(paramInt1);
        QLog.w(paramArrayOfInt, 1, ((StringBuilder)localObject1).toString());
      }
    }
    paramArrayOfInt = this.c;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      this.f.b(this.d, paramString, this.a, -1, paramArrayOfInt, -1, -1, this.e);
      return;
    }
    paramArrayOfInt = this.a;
    if (paramArrayOfInt != null) {
      paramArrayOfInt.a(true, paramString, this.b, this.c, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.downloader.AbsApolloResDownloader.1
 * JD-Core Version:    0.7.0.1
 */