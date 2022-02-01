package com.tencent.mobileqq.qqexpand.utils;

import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/ExpandFileUtils;", "", "()V", "TAG", "", "getFileMD5String", "filePath", "validateFile", "", "filepath", "expectedMd5", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public final class ExpandFileUtils
{
  public static final ExpandFileUtils a = new ExpandFileUtils();
  
  private final String a(String paramString)
  {
    String str3 = (String)null;
    String str2;
    try
    {
      localObject = MD5.getPartfileMd5(paramString, 0L);
      String str1 = str3;
      if (localObject != null) {
        str1 = MD5FileUtil.b((byte[])localObject);
      }
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("error ........ error getFileMD5String filePath: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", error=");
      ((StringBuilder)localObject).append(localException.getMessage());
      QLog.e("Expand.FileUtils", 2, ((StringBuilder)localObject).toString());
      str2 = str3;
    }
    if (QLog.isDebugVersion())
    {
      paramString = new StringBuilder();
      paramString.append("getFileMD5String md5: ");
      paramString.append(str2);
      QLog.e("Expand.FileUtils", 2, paramString.toString());
    }
    return str2;
  }
  
  @JvmStatic
  public static final boolean a(@NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "filepath");
    if (!new File(paramString1).exists())
    {
      paramString2 = LogUtils.a;
      if (QLog.isColorLevel())
      {
        paramString2 = paramString2.a();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("validateFile() ");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(" not exists!");
        paramString2.a("Expand.FileUtils", 2, ((StringBuilder)localObject1).toString());
      }
      return false;
    }
    Object localObject1 = a.a(paramString1);
    if (localObject1 == null) {
      localObject1 = "(null)";
    }
    if (!StringsKt.equals((String)localObject1, paramString2, true))
    {
      Object localObject2 = LogUtils.a;
      if (QLog.isColorLevel())
      {
        localObject2 = ((LogUtils)localObject2).a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("validateFile() ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" md5 not match expect ");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(", actually ");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append('!');
        ((ILog)localObject2).a("Expand.FileUtils", 2, localStringBuilder.toString());
      }
      return false;
    }
    paramString2 = LogUtils.a;
    if (QLog.isColorLevel())
    {
      paramString2 = paramString2.a();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("validateFile() ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" success!");
      paramString2.a("Expand.FileUtils", 2, ((StringBuilder)localObject1).toString());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.ExpandFileUtils
 * JD-Core Version:    0.7.0.1
 */